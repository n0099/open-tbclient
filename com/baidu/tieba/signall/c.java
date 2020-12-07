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
/* loaded from: classes24.dex */
public class c {
    private String aUL;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int level;
    private String nbZ;
    private String nca;
    private String ncb;
    private String ncc;
    private int ncd;
    private String nce;
    private boolean ncf;
    private int ncg;
    private int nch;
    private int nci;
    private int ncj;
    private String nck;
    private String ncl;
    private String ncm;
    private String ncn;
    private int nco;
    private String ncp;
    private int ncq;
    private boolean ncr;
    private int ncs;
    private int nct;
    private int ncz;
    private String title;
    private int valid;
    private String nbY = "0";
    private ArrayList<d> ncu = new ArrayList<>();
    private ArrayList<d> ncv = new ArrayList<>();
    private ArrayList<d> ncw = new ArrayList<>();
    private HashMap<String, d> ncx = new HashMap<>();
    private a ncy = new a();
    private f ncA = new f();
    private k ncB = new k();

    public boolean dLY() {
        return (this.ncA == null || StringUtils.isNull(this.ncA.ncS)) ? false : true;
    }

    public String bGb() {
        return this.ncA.eEf;
    }

    public String dLZ() {
        return this.ncA.ncS;
    }

    public String dMa() {
        return this.ncB.nep;
    }

    public String dMb() {
        return this.ncB.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dMc() {
        return !StringUtils.isNull(this.nbY) && this.nbY.equals("1");
    }

    public String dMd() {
        return this.nbZ;
    }

    public String dvl() {
        return this.aUL;
    }

    public String dMe() {
        return this.nca;
    }

    public String dMf() {
        return this.ncb;
    }

    public String dMg() {
        return this.ncc;
    }

    public int dMh() {
        return this.ncd;
    }

    public String dMi() {
        return this.nce;
    }

    public ArrayList<d> dMj() {
        return this.ncu;
    }

    public a dMk() {
        return this.ncy;
    }

    public ArrayList<d> dMl() {
        return this.ncv;
    }

    public ArrayList<d> dMm() {
        return this.ncw;
    }

    public boolean dMn() {
        return this.ncf;
    }

    public String dMo() {
        return this.ncp;
    }

    public String getContent() {
        return this.content;
    }

    public int dMp() {
        return this.ncq;
    }

    public boolean dMq() {
        return this.ncr;
    }

    public int dMr() {
        return this.ncs;
    }

    public int dMs() {
        return this.nct;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.ncx.get(signData.forumId)) != null) {
            dVar.KB(1);
            dVar.KC(signData.count_sign_num);
            dVar.KD(signData.sign_bonus_point);
            dVar.xL(true);
            dVar.xM(false);
            dVar.xN(false);
            a(dVar);
            dMt();
            xK(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bLB() >= this.level) {
            this.nci++;
            this.ncj--;
        } else {
            this.ncg++;
            this.nch--;
        }
        this.ncx.remove(String.valueOf(dVar.getForumId()));
        this.ncw.remove(dVar);
        if (dVar.dMw() + dVar.dMA() >= dVar.dMx()) {
            dVar.setUserLevel(dVar.bLB() + 1);
            dVar.xO(true);
            if (dVar.bLB() == this.level) {
                this.nci++;
                this.ncg--;
            }
        }
        this.ncv.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dMA(), -1);
    }

    private void dMt() {
        if (this.ncf) {
            if (this.ncj + this.nch <= 0) {
                this.ncr = true;
            } else {
                this.ncr = false;
            }
        } else if (this.ncj <= 0) {
            this.ncr = true;
        } else {
            this.ncr = false;
        }
    }

    public void a(h hVar) {
        this.ncs = 0;
        this.nct = 0;
        ArrayList<i> dMK = hVar.dMK();
        int size = dMK.size();
        for (int i = 0; i < size; i++) {
            i iVar = dMK.get(i);
            d dVar = this.ncx.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dMN() != 0) {
                    this.ncs++;
                    dVar.KB(1);
                    dVar.KC(iVar.dMO());
                    dVar.KD(iVar.getCurScore());
                    dVar.xL(true);
                    dVar.xM(false);
                    dVar.xN(false);
                    a(dVar);
                } else {
                    this.nct++;
                    dVar.xL(false);
                    dVar.xM(true);
                    dVar.xN(false);
                    dVar.setErrorMsg(iVar.dMk().getUserMsg());
                }
            }
        }
        dMt();
        xK(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.ncy.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.nbY = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.nbZ = jSONObject.optString("text_pre");
            this.aUL = jSONObject.optString("text_color");
            this.nca = jSONObject.optString("text_mid");
            this.ncb = jSONObject.optString("text_suf");
            this.ncc = jSONObject.optString("num_notice");
            this.ncd = jSONObject.optInt("show_dialog");
            this.nce = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.ncz = jSONObject.optInt("sign_max_num", 50);
            this.nco = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.ncp = jSONObject.optString("button_content");
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
            if (this.nco == 1) {
                this.ncf = true;
            } else {
                this.ncf = false;
            }
            this.ncl = this.level + this.title;
            this.nck = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.nef = this.ncz;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.nef);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dMu() == 0) {
                            if (this.valid == 0) {
                                if (this.ncf) {
                                    dVar.xM(true);
                                } else if (dVar.bLB() > this.level) {
                                    dVar.xM(true);
                                }
                            }
                            if (dVar.bLB() >= this.level) {
                                this.ncj++;
                            } else {
                                this.nch++;
                            }
                            this.ncw.add(dVar);
                            this.ncx.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bLB() >= this.level) {
                                this.nci++;
                            } else {
                                this.ncg++;
                            }
                            this.ncv.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dMA(), -1);
                        }
                        this.ncu.add(dVar);
                        Collections.sort(this.ncu, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bLB() - dVar2.bLB();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.ncA == null) {
                this.ncA = new f();
            }
            this.ncA.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.ncB == null) {
                this.ncB = new k();
            }
            this.ncB.parserJson(optJSONObject3);
            xK(false);
        }
    }

    private void xK(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.ncu.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.ncu.removeAll(arrayList);
        }
        if (this.ncj + this.nci > 0) {
            if (this.nci > 0) {
                this.ncn = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.nci), Integer.valueOf(this.ncj));
            } else {
                this.ncn = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.ncj + this.nci));
            }
            if (this.ncu.size() > 0) {
                this.ncu.add(0, new b(this.ncl, this.ncn));
            }
        }
        if (this.nch + this.ncg > 0) {
            if (this.ncg > 0) {
                this.ncm = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.ncg), Integer.valueOf(this.nch));
            } else {
                this.ncm = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.nch + this.ncg));
            }
            if (this.ncj + this.nci > 0) {
                if (this.ncu.size() > this.ncj + this.nci + 1) {
                    this.ncu.add(this.ncj + this.nci + 1, new b(this.nck, this.ncm));
                }
            } else if (this.ncu.size() > 0) {
                this.ncu.add(0, new b(this.nck, this.ncm));
            }
        }
        if (this.ncu.size() <= 0) {
            this.ncq = 3;
        } else if (this.ncf) {
            if (this.valid == 1 && this.ncw.size() > 0) {
                this.ncq = 0;
            } else {
                this.ncq = 2;
            }
        } else if (this.valid == 1 && this.ncj > 0) {
            this.ncq = 0;
        } else if (this.ncj + this.nci > 0) {
            this.ncq = 2;
        } else if (this.ncj + this.nci <= 0) {
            this.ncq = 3;
        }
    }
}
