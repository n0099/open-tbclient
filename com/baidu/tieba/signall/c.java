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
    private String aOi;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int level;
    private int mHA;
    private String mHa;
    private String mHb;
    private String mHc;
    private String mHd;
    private int mHe;
    private String mHf;
    private boolean mHg;
    private int mHh;
    private int mHi;
    private int mHj;
    private int mHk;
    private String mHl;
    private String mHm;
    private String mHn;
    private String mHo;
    private int mHp;
    private String mHq;
    private int mHr;
    private boolean mHs;
    private int mHt;
    private int mHu;
    private String title;
    private int valid;
    private String mGZ = "0";
    private ArrayList<d> mHv = new ArrayList<>();
    private ArrayList<d> mHw = new ArrayList<>();
    private ArrayList<d> mHx = new ArrayList<>();
    private HashMap<String, d> mHy = new HashMap<>();
    private a mHz = new a();
    private f mHB = new f();
    private k mHC = new k();

    public boolean dEo() {
        return (this.mHB == null || StringUtils.isNull(this.mHB.mHU)) ? false : true;
    }

    public String bAI() {
        return this.mHB.esW;
    }

    public String dEp() {
        return this.mHB.mHU;
    }

    public String dEq() {
        return this.mHC.mJv;
    }

    public String dEr() {
        return this.mHC.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dEs() {
        return !StringUtils.isNull(this.mGZ) && this.mGZ.equals("1");
    }

    public String dEt() {
        return this.mHa;
    }

    public String dnQ() {
        return this.aOi;
    }

    public String dEu() {
        return this.mHb;
    }

    public String dEv() {
        return this.mHc;
    }

    public String dEw() {
        return this.mHd;
    }

    public int dEx() {
        return this.mHe;
    }

    public String dEy() {
        return this.mHf;
    }

    public ArrayList<d> dEz() {
        return this.mHv;
    }

    public a dEA() {
        return this.mHz;
    }

    public ArrayList<d> dEB() {
        return this.mHw;
    }

    public ArrayList<d> dEC() {
        return this.mHx;
    }

    public boolean dED() {
        return this.mHg;
    }

    public String dEE() {
        return this.mHq;
    }

    public String getContent() {
        return this.content;
    }

    public int dEF() {
        return this.mHr;
    }

    public boolean dEG() {
        return this.mHs;
    }

    public int dEH() {
        return this.mHt;
    }

    public int dEI() {
        return this.mHu;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.mHy.get(signData.forumId)) != null) {
            dVar.IV(1);
            dVar.IW(signData.count_sign_num);
            dVar.IY(signData.sign_bonus_point);
            dVar.wU(true);
            dVar.wV(false);
            dVar.wW(false);
            a(dVar);
            dEJ();
            wT(true);
        }
    }

    private void a(d dVar) {
        if (dVar.dEM() >= this.level) {
            this.mHj++;
            this.mHk--;
        } else {
            this.mHh++;
            this.mHi--;
        }
        this.mHy.remove(String.valueOf(dVar.getForumId()));
        this.mHx.remove(dVar);
        if (dVar.dEN() + dVar.dER() >= dVar.dEO()) {
            dVar.IX(dVar.dEM() + 1);
            dVar.wX(true);
            if (dVar.dEM() == this.level) {
                this.mHj++;
                this.mHh--;
            }
        }
        this.mHw.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dER(), -1);
    }

    private void dEJ() {
        if (this.mHg) {
            if (this.mHk + this.mHi <= 0) {
                this.mHs = true;
            } else {
                this.mHs = false;
            }
        } else if (this.mHk <= 0) {
            this.mHs = true;
        } else {
            this.mHs = false;
        }
    }

    public void a(h hVar) {
        this.mHt = 0;
        this.mHu = 0;
        ArrayList<i> dFb = hVar.dFb();
        int size = dFb.size();
        for (int i = 0; i < size; i++) {
            i iVar = dFb.get(i);
            d dVar = this.mHy.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dFe() != 0) {
                    this.mHt++;
                    dVar.IV(1);
                    dVar.IW(iVar.dFf());
                    dVar.IY(iVar.getCurScore());
                    dVar.wU(true);
                    dVar.wV(false);
                    dVar.wW(false);
                    a(dVar);
                } else {
                    this.mHu++;
                    dVar.wU(false);
                    dVar.wV(true);
                    dVar.wW(false);
                    dVar.setErrorMsg(iVar.dEA().getUserMsg());
                }
            }
        }
        dEJ();
        wT(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.mHz.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.mGZ = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.mHa = jSONObject.optString("text_pre");
            this.aOi = jSONObject.optString("text_color");
            this.mHb = jSONObject.optString("text_mid");
            this.mHc = jSONObject.optString("text_suf");
            this.mHd = jSONObject.optString("num_notice");
            this.mHe = jSONObject.optInt("show_dialog");
            this.mHf = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.mHA = jSONObject.optInt("sign_max_num", 50);
            this.mHp = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.mHq = jSONObject.optString("button_content");
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
            if (this.mHp == 1) {
                this.mHg = true;
            } else {
                this.mHg = false;
            }
            this.mHm = this.level + this.title;
            this.mHl = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.mJl = this.mHA;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.mJl);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dEK() == 0) {
                            if (this.valid == 0) {
                                if (this.mHg) {
                                    dVar.wV(true);
                                } else if (dVar.dEM() > this.level) {
                                    dVar.wV(true);
                                }
                            }
                            if (dVar.dEM() >= this.level) {
                                this.mHk++;
                            } else {
                                this.mHi++;
                            }
                            this.mHx.add(dVar);
                            this.mHy.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.dEM() >= this.level) {
                                this.mHj++;
                            } else {
                                this.mHh++;
                            }
                            this.mHw.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dER(), -1);
                        }
                        this.mHv.add(dVar);
                        Collections.sort(this.mHv, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.dEM() - dVar2.dEM();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.mHB == null) {
                this.mHB = new f();
            }
            this.mHB.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.mHC == null) {
                this.mHC = new k();
            }
            this.mHC.parserJson(optJSONObject3);
            wT(false);
        }
    }

    private void wT(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.mHv.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.mHv.removeAll(arrayList);
        }
        if (this.mHk + this.mHj > 0) {
            if (this.mHj > 0) {
                this.mHo = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.mHj), Integer.valueOf(this.mHk));
            } else {
                this.mHo = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.mHk + this.mHj));
            }
            if (this.mHv.size() > 0) {
                this.mHv.add(0, new b(this.mHm, this.mHo));
            }
        }
        if (this.mHi + this.mHh > 0) {
            if (this.mHh > 0) {
                this.mHn = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.mHh), Integer.valueOf(this.mHi));
            } else {
                this.mHn = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.mHi + this.mHh));
            }
            if (this.mHk + this.mHj > 0) {
                if (this.mHv.size() > this.mHk + this.mHj + 1) {
                    this.mHv.add(this.mHk + this.mHj + 1, new b(this.mHl, this.mHn));
                }
            } else if (this.mHv.size() > 0) {
                this.mHv.add(0, new b(this.mHl, this.mHn));
            }
        }
        if (this.mHv.size() <= 0) {
            this.mHr = 3;
        } else if (this.mHg) {
            if (this.valid == 1 && this.mHx.size() > 0) {
                this.mHr = 0;
            } else {
                this.mHr = 2;
            }
        } else if (this.valid == 1 && this.mHk > 0) {
            this.mHr = 0;
        } else if (this.mHk + this.mHj > 0) {
            this.mHr = 2;
        } else if (this.mHk + this.mHj <= 0) {
            this.mHr = 3;
        }
    }
}
