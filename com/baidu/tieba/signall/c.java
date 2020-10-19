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
    private String aND;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int level;
    private boolean muA;
    private int muB;
    private int muC;
    private int muD;
    private int muE;
    private String muF;
    private String muG;
    private String muH;
    private String muI;
    private int muJ;
    private String muK;
    private int muL;
    private boolean muM;
    private int muN;
    private int muO;
    private int muU;
    private String muu;
    private String muv;
    private String muw;
    private String mux;
    private int muy;
    private String muz;
    private String title;
    private int valid;
    private String mut = "0";
    private ArrayList<d> muP = new ArrayList<>();
    private ArrayList<d> muQ = new ArrayList<>();
    private ArrayList<d> muR = new ArrayList<>();
    private HashMap<String, d> muS = new HashMap<>();
    private a muT = new a();
    private f muV = new f();
    private k muW = new k();

    public boolean dBg() {
        return (this.muV == null || StringUtils.isNull(this.muV.mvo)) ? false : true;
    }

    public String byP() {
        return this.muV.ekx;
    }

    public String dBh() {
        return this.muV.mvo;
    }

    public String dBi() {
        return this.muW.mwL;
    }

    public String dBj() {
        return this.muW.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dBk() {
        return !StringUtils.isNull(this.mut) && this.mut.equals("1");
    }

    public String dBl() {
        return this.muu;
    }

    public String dkI() {
        return this.aND;
    }

    public String dBm() {
        return this.muv;
    }

    public String dBn() {
        return this.muw;
    }

    public String dBo() {
        return this.mux;
    }

    public int dBp() {
        return this.muy;
    }

    public String dBq() {
        return this.muz;
    }

    public ArrayList<d> dBr() {
        return this.muP;
    }

    public a dBs() {
        return this.muT;
    }

    public ArrayList<d> dBt() {
        return this.muQ;
    }

    public ArrayList<d> dBu() {
        return this.muR;
    }

    public boolean dBv() {
        return this.muA;
    }

    public String dBw() {
        return this.muK;
    }

    public String getContent() {
        return this.content;
    }

    public int dBx() {
        return this.muL;
    }

    public boolean dBy() {
        return this.muM;
    }

    public int dBz() {
        return this.muN;
    }

    public int dBA() {
        return this.muO;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.muS.get(signData.forumId)) != null) {
            dVar.IC(1);
            dVar.ID(signData.count_sign_num);
            dVar.IF(signData.sign_bonus_point);
            dVar.wD(true);
            dVar.wE(false);
            dVar.wF(false);
            a(dVar);
            dBB();
            wC(true);
        }
    }

    private void a(d dVar) {
        if (dVar.dBE() >= this.level) {
            this.muD++;
            this.muE--;
        } else {
            this.muB++;
            this.muC--;
        }
        this.muS.remove(String.valueOf(dVar.getForumId()));
        this.muR.remove(dVar);
        if (dVar.dBF() + dVar.dBJ() >= dVar.dBG()) {
            dVar.IE(dVar.dBE() + 1);
            dVar.wG(true);
            if (dVar.dBE() == this.level) {
                this.muD++;
                this.muB--;
            }
        }
        this.muQ.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dBJ(), -1);
    }

    private void dBB() {
        if (this.muA) {
            if (this.muE + this.muC <= 0) {
                this.muM = true;
            } else {
                this.muM = false;
            }
        } else if (this.muE <= 0) {
            this.muM = true;
        } else {
            this.muM = false;
        }
    }

    public void a(h hVar) {
        this.muN = 0;
        this.muO = 0;
        ArrayList<i> dBT = hVar.dBT();
        int size = dBT.size();
        for (int i = 0; i < size; i++) {
            i iVar = dBT.get(i);
            d dVar = this.muS.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dBW() != 0) {
                    this.muN++;
                    dVar.IC(1);
                    dVar.ID(iVar.dBX());
                    dVar.IF(iVar.getCurScore());
                    dVar.wD(true);
                    dVar.wE(false);
                    dVar.wF(false);
                    a(dVar);
                } else {
                    this.muO++;
                    dVar.wD(false);
                    dVar.wE(true);
                    dVar.wF(false);
                    dVar.setErrorMsg(iVar.dBs().getUserMsg());
                }
            }
        }
        dBB();
        wC(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.muT.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.mut = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.muu = jSONObject.optString("text_pre");
            this.aND = jSONObject.optString("text_color");
            this.muv = jSONObject.optString("text_mid");
            this.muw = jSONObject.optString("text_suf");
            this.mux = jSONObject.optString("num_notice");
            this.muy = jSONObject.optInt("show_dialog");
            this.muz = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.muU = jSONObject.optInt("sign_max_num", 50);
            this.muJ = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.muK = jSONObject.optString("button_content");
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
            if (this.muJ == 1) {
                this.muA = true;
            } else {
                this.muA = false;
            }
            this.muG = this.level + this.title;
            this.muF = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.mwB = this.muU;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.mwB);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dBC() == 0) {
                            if (this.valid == 0) {
                                if (this.muA) {
                                    dVar.wE(true);
                                } else if (dVar.dBE() > this.level) {
                                    dVar.wE(true);
                                }
                            }
                            if (dVar.dBE() >= this.level) {
                                this.muE++;
                            } else {
                                this.muC++;
                            }
                            this.muR.add(dVar);
                            this.muS.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.dBE() >= this.level) {
                                this.muD++;
                            } else {
                                this.muB++;
                            }
                            this.muQ.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dBJ(), -1);
                        }
                        this.muP.add(dVar);
                        Collections.sort(this.muP, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.dBE() - dVar2.dBE();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.muV == null) {
                this.muV = new f();
            }
            this.muV.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.muW == null) {
                this.muW = new k();
            }
            this.muW.parserJson(optJSONObject3);
            wC(false);
        }
    }

    private void wC(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.muP.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.muP.removeAll(arrayList);
        }
        if (this.muE + this.muD > 0) {
            if (this.muD > 0) {
                this.muI = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.muD), Integer.valueOf(this.muE));
            } else {
                this.muI = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.muE + this.muD));
            }
            if (this.muP.size() > 0) {
                this.muP.add(0, new b(this.muG, this.muI));
            }
        }
        if (this.muC + this.muB > 0) {
            if (this.muB > 0) {
                this.muH = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.muB), Integer.valueOf(this.muC));
            } else {
                this.muH = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.muC + this.muB));
            }
            if (this.muE + this.muD > 0) {
                if (this.muP.size() > this.muE + this.muD + 1) {
                    this.muP.add(this.muE + this.muD + 1, new b(this.muF, this.muH));
                }
            } else if (this.muP.size() > 0) {
                this.muP.add(0, new b(this.muF, this.muH));
            }
        }
        if (this.muP.size() <= 0) {
            this.muL = 3;
        } else if (this.muA) {
            if (this.valid == 1 && this.muR.size() > 0) {
                this.muL = 0;
            } else {
                this.muL = 2;
            }
        } else if (this.valid == 1 && this.muE > 0) {
            this.muL = 0;
        } else if (this.muE + this.muD > 0) {
            this.muL = 2;
        } else if (this.muE + this.muD <= 0) {
            this.muL = 3;
        }
    }
}
