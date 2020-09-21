package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class c {
    private String aKy;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int level;
    private String meR;
    private String meS;
    private String meT;
    private String meU;
    private int meV;
    private String meW;
    private boolean meX;
    private int meY;
    private int meZ;
    private int mfa;
    private int mfb;
    private String mfc;
    private String mfd;
    private String mfe;
    private String mff;
    private int mfg;
    private String mfh;
    private int mfi;
    private boolean mfj;
    private int mfk;
    private int mfl;
    private int mfr;
    private String title;
    private int valid;
    private String meQ = "0";
    private ArrayList<d> mfm = new ArrayList<>();
    private ArrayList<d> mfn = new ArrayList<>();
    private ArrayList<d> mfo = new ArrayList<>();
    private HashMap<String, d> mfp = new HashMap<>();
    private a mfq = new a();
    private f mfs = new f();
    private k mft = new k();

    public boolean dxv() {
        return (this.mfs == null || StringUtils.isNull(this.mfs.mfL)) ? false : true;
    }

    public String bwf() {
        return this.mfs.dYv;
    }

    public String dxw() {
        return this.mfs.mfL;
    }

    public String dxx() {
        return this.mft.mhi;
    }

    public String dxy() {
        return this.mft.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dxz() {
        return !StringUtils.isNull(this.meQ) && this.meQ.equals("1");
    }

    public String dxA() {
        return this.meR;
    }

    public String dgZ() {
        return this.aKy;
    }

    public String dxB() {
        return this.meS;
    }

    public String dxC() {
        return this.meT;
    }

    public String dxD() {
        return this.meU;
    }

    public int dxE() {
        return this.meV;
    }

    public String dxF() {
        return this.meW;
    }

    public ArrayList<d> dxG() {
        return this.mfm;
    }

    public a dxH() {
        return this.mfq;
    }

    public ArrayList<d> dxI() {
        return this.mfn;
    }

    public ArrayList<d> dxJ() {
        return this.mfo;
    }

    public boolean dxK() {
        return this.meX;
    }

    public String dxL() {
        return this.mfh;
    }

    public String getContent() {
        return this.content;
    }

    public int dxM() {
        return this.mfi;
    }

    public boolean dxN() {
        return this.mfj;
    }

    public int dxO() {
        return this.mfk;
    }

    public int dxP() {
        return this.mfl;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.mfp.get(signData.forumId)) != null) {
            dVar.HW(1);
            dVar.HX(signData.count_sign_num);
            dVar.HZ(signData.sign_bonus_point);
            dVar.vW(true);
            dVar.vX(false);
            dVar.vY(false);
            a(dVar);
            dxQ();
            vV(true);
        }
    }

    private void a(d dVar) {
        if (dVar.dxT() >= this.level) {
            this.mfa++;
            this.mfb--;
        } else {
            this.meY++;
            this.meZ--;
        }
        this.mfp.remove(String.valueOf(dVar.getForumId()));
        this.mfo.remove(dVar);
        if (dVar.dxU() + dVar.dxY() >= dVar.dxV()) {
            dVar.HY(dVar.dxT() + 1);
            dVar.vZ(true);
            if (dVar.dxT() == this.level) {
                this.mfa++;
                this.meY--;
            }
        }
        this.mfn.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dxY(), -1);
    }

    private void dxQ() {
        if (this.meX) {
            if (this.mfb + this.meZ <= 0) {
                this.mfj = true;
            } else {
                this.mfj = false;
            }
        } else if (this.mfb <= 0) {
            this.mfj = true;
        } else {
            this.mfj = false;
        }
    }

    public void a(h hVar) {
        this.mfk = 0;
        this.mfl = 0;
        ArrayList<i> dyi = hVar.dyi();
        int size = dyi.size();
        for (int i = 0; i < size; i++) {
            i iVar = dyi.get(i);
            d dVar = this.mfp.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dyl() != 0) {
                    this.mfk++;
                    dVar.HW(1);
                    dVar.HX(iVar.dym());
                    dVar.HZ(iVar.getCurScore());
                    dVar.vW(true);
                    dVar.vX(false);
                    dVar.vY(false);
                    a(dVar);
                } else {
                    this.mfl++;
                    dVar.vW(false);
                    dVar.vX(true);
                    dVar.vY(false);
                    dVar.setErrorMsg(iVar.dxH().getUserMsg());
                }
            }
        }
        dxQ();
        vV(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.mfq.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.meQ = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.meR = jSONObject.optString("text_pre");
            this.aKy = jSONObject.optString("text_color");
            this.meS = jSONObject.optString("text_mid");
            this.meT = jSONObject.optString("text_suf");
            this.meU = jSONObject.optString("num_notice");
            this.meV = jSONObject.optInt("show_dialog");
            this.meW = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.mfr = jSONObject.optInt("sign_max_num", 50);
            this.mfg = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.mfh = jSONObject.optString("button_content");
            JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
            if (optJSONObject != null) {
                this.blockPopInfoData = new BlockPopInfoData();
                this.blockPopInfoData.block_info = optJSONObject.optString("block_content");
                this.blockPopInfoData.ahead_info = optJSONObject.optString("block_confirm");
                this.blockPopInfoData.ahead_url = optJSONObject.optString("block_dealurl");
                this.blockPopInfoData.ok_info = optJSONObject.optString("block_cancel");
                this.blockPopInfoData.appeal_status = optJSONObject.optInt("appeal_status");
                this.blockPopInfoData.appeal_msg = optJSONObject.optString("appeal_msg");
            }
            if (this.mfg == 1) {
                this.meX = true;
            } else {
                this.meX = false;
            }
            this.mfd = this.level + this.title;
            this.mfc = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.mgY = this.mfr;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.mgY);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dxR() == 0) {
                            if (this.valid == 0) {
                                if (this.meX) {
                                    dVar.vX(true);
                                } else if (dVar.dxT() > this.level) {
                                    dVar.vX(true);
                                }
                            }
                            if (dVar.dxT() >= this.level) {
                                this.mfb++;
                            } else {
                                this.meZ++;
                            }
                            this.mfo.add(dVar);
                            this.mfp.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.dxT() >= this.level) {
                                this.mfa++;
                            } else {
                                this.meY++;
                            }
                            this.mfn.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dxY(), -1);
                        }
                        this.mfm.add(dVar);
                        Collections.sort(this.mfm, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.dxT() - dVar2.dxT();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.mfs == null) {
                this.mfs = new f();
            }
            this.mfs.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.mft == null) {
                this.mft = new k();
            }
            this.mft.parserJson(optJSONObject3);
            vV(false);
        }
    }

    private void vV(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.mfm.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.mfm.removeAll(arrayList);
        }
        if (this.mfb + this.mfa > 0) {
            if (this.mfa > 0) {
                this.mff = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.mfa), Integer.valueOf(this.mfb));
            } else {
                this.mff = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.mfb + this.mfa));
            }
            if (this.mfm.size() > 0) {
                this.mfm.add(0, new b(this.mfd, this.mff));
            }
        }
        if (this.meZ + this.meY > 0) {
            if (this.meY > 0) {
                this.mfe = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.meY), Integer.valueOf(this.meZ));
            } else {
                this.mfe = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.meZ + this.meY));
            }
            if (this.mfb + this.mfa > 0) {
                if (this.mfm.size() > this.mfb + this.mfa + 1) {
                    this.mfm.add(this.mfb + this.mfa + 1, new b(this.mfc, this.mfe));
                }
            } else if (this.mfm.size() > 0) {
                this.mfm.add(0, new b(this.mfc, this.mfe));
            }
        }
        if (this.mfm.size() <= 0) {
            this.mfi = 3;
        } else if (this.meX) {
            if (this.valid == 1 && this.mfo.size() > 0) {
                this.mfi = 0;
            } else {
                this.mfi = 2;
            }
        } else if (this.valid == 1 && this.mfb > 0) {
            this.mfi = 0;
        } else if (this.mfb + this.mfa > 0) {
            this.mfi = 2;
        } else if (this.mfb + this.mfa <= 0) {
            this.mfi = 3;
        }
    }
}
