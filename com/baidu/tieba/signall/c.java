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
    private String aTu;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int level;
    private int mNA;
    private String mNa;
    private String mNb;
    private String mNc;
    private String mNd;
    private int mNe;
    private String mNf;
    private boolean mNg;
    private int mNh;
    private int mNi;
    private int mNj;
    private int mNk;
    private String mNl;
    private String mNm;
    private String mNn;
    private String mNo;
    private int mNp;
    private String mNq;
    private int mNr;
    private boolean mNs;
    private int mNt;
    private int mNu;
    private String title;
    private int valid;
    private String mMZ = "0";
    private ArrayList<d> mNv = new ArrayList<>();
    private ArrayList<d> mNw = new ArrayList<>();
    private ArrayList<d> mNx = new ArrayList<>();
    private HashMap<String, d> mNy = new HashMap<>();
    private a mNz = new a();
    private f mNB = new f();
    private k mNC = new k();

    public boolean dGQ() {
        return (this.mNB == null || StringUtils.isNull(this.mNB.mNT)) ? false : true;
    }

    public String bDh() {
        return this.mNB.eyQ;
    }

    public String dGR() {
        return this.mNB.mNT;
    }

    public String dGS() {
        return this.mNC.mPs;
    }

    public String dGT() {
        return this.mNC.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dGU() {
        return !StringUtils.isNull(this.mMZ) && this.mMZ.equals("1");
    }

    public String dGV() {
        return this.mNa;
    }

    public String dqs() {
        return this.aTu;
    }

    public String dGW() {
        return this.mNb;
    }

    public String dGX() {
        return this.mNc;
    }

    public String dGY() {
        return this.mNd;
    }

    public int dGZ() {
        return this.mNe;
    }

    public String dHa() {
        return this.mNf;
    }

    public ArrayList<d> dHb() {
        return this.mNv;
    }

    public a dHc() {
        return this.mNz;
    }

    public ArrayList<d> dHd() {
        return this.mNw;
    }

    public ArrayList<d> dHe() {
        return this.mNx;
    }

    public boolean dHf() {
        return this.mNg;
    }

    public String dHg() {
        return this.mNq;
    }

    public String getContent() {
        return this.content;
    }

    public int dHh() {
        return this.mNr;
    }

    public boolean dHi() {
        return this.mNs;
    }

    public int dHj() {
        return this.mNt;
    }

    public int dHk() {
        return this.mNu;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.mNy.get(signData.forumId)) != null) {
            dVar.Ji(1);
            dVar.Jj(signData.count_sign_num);
            dVar.Jl(signData.sign_bonus_point);
            dVar.xd(true);
            dVar.xe(false);
            dVar.xf(false);
            a(dVar);
            dHl();
            xc(true);
        }
    }

    private void a(d dVar) {
        if (dVar.dHo() >= this.level) {
            this.mNj++;
            this.mNk--;
        } else {
            this.mNh++;
            this.mNi--;
        }
        this.mNy.remove(String.valueOf(dVar.getForumId()));
        this.mNx.remove(dVar);
        if (dVar.dHp() + dVar.dHt() >= dVar.dHq()) {
            dVar.Jk(dVar.dHo() + 1);
            dVar.xg(true);
            if (dVar.dHo() == this.level) {
                this.mNj++;
                this.mNh--;
            }
        }
        this.mNw.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dHt(), -1);
    }

    private void dHl() {
        if (this.mNg) {
            if (this.mNk + this.mNi <= 0) {
                this.mNs = true;
            } else {
                this.mNs = false;
            }
        } else if (this.mNk <= 0) {
            this.mNs = true;
        } else {
            this.mNs = false;
        }
    }

    public void a(h hVar) {
        this.mNt = 0;
        this.mNu = 0;
        ArrayList<i> dHD = hVar.dHD();
        int size = dHD.size();
        for (int i = 0; i < size; i++) {
            i iVar = dHD.get(i);
            d dVar = this.mNy.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dHG() != 0) {
                    this.mNt++;
                    dVar.Ji(1);
                    dVar.Jj(iVar.dHH());
                    dVar.Jl(iVar.getCurScore());
                    dVar.xd(true);
                    dVar.xe(false);
                    dVar.xf(false);
                    a(dVar);
                } else {
                    this.mNu++;
                    dVar.xd(false);
                    dVar.xe(true);
                    dVar.xf(false);
                    dVar.setErrorMsg(iVar.dHc().getUserMsg());
                }
            }
        }
        dHl();
        xc(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.mNz.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.mMZ = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.mNa = jSONObject.optString("text_pre");
            this.aTu = jSONObject.optString("text_color");
            this.mNb = jSONObject.optString("text_mid");
            this.mNc = jSONObject.optString("text_suf");
            this.mNd = jSONObject.optString("num_notice");
            this.mNe = jSONObject.optInt("show_dialog");
            this.mNf = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.mNA = jSONObject.optInt("sign_max_num", 50);
            this.mNp = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.mNq = jSONObject.optString("button_content");
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
            if (this.mNp == 1) {
                this.mNg = true;
            } else {
                this.mNg = false;
            }
            this.mNm = this.level + this.title;
            this.mNl = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.mPg = this.mNA;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.mPg);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dHm() == 0) {
                            if (this.valid == 0) {
                                if (this.mNg) {
                                    dVar.xe(true);
                                } else if (dVar.dHo() > this.level) {
                                    dVar.xe(true);
                                }
                            }
                            if (dVar.dHo() >= this.level) {
                                this.mNk++;
                            } else {
                                this.mNi++;
                            }
                            this.mNx.add(dVar);
                            this.mNy.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.dHo() >= this.level) {
                                this.mNj++;
                            } else {
                                this.mNh++;
                            }
                            this.mNw.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dHt(), -1);
                        }
                        this.mNv.add(dVar);
                        Collections.sort(this.mNv, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.dHo() - dVar2.dHo();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.mNB == null) {
                this.mNB = new f();
            }
            this.mNB.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.mNC == null) {
                this.mNC = new k();
            }
            this.mNC.parserJson(optJSONObject3);
            xc(false);
        }
    }

    private void xc(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.mNv.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.mNv.removeAll(arrayList);
        }
        if (this.mNk + this.mNj > 0) {
            if (this.mNj > 0) {
                this.mNo = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.mNj), Integer.valueOf(this.mNk));
            } else {
                this.mNo = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.mNk + this.mNj));
            }
            if (this.mNv.size() > 0) {
                this.mNv.add(0, new b(this.mNm, this.mNo));
            }
        }
        if (this.mNi + this.mNh > 0) {
            if (this.mNh > 0) {
                this.mNn = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.mNh), Integer.valueOf(this.mNi));
            } else {
                this.mNn = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.mNi + this.mNh));
            }
            if (this.mNk + this.mNj > 0) {
                if (this.mNv.size() > this.mNk + this.mNj + 1) {
                    this.mNv.add(this.mNk + this.mNj + 1, new b(this.mNl, this.mNn));
                }
            } else if (this.mNv.size() > 0) {
                this.mNv.add(0, new b(this.mNl, this.mNn));
            }
        }
        if (this.mNv.size() <= 0) {
            this.mNr = 3;
        } else if (this.mNg) {
            if (this.valid == 1 && this.mNx.size() > 0) {
                this.mNr = 0;
            } else {
                this.mNr = 2;
            }
        } else if (this.valid == 1 && this.mNk > 0) {
            this.mNr = 0;
        } else if (this.mNk + this.mNj > 0) {
            this.mNr = 2;
        } else if (this.mNk + this.mNj <= 0) {
            this.mNr = 3;
        }
    }
}
