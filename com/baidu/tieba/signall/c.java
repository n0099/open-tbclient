package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.net.update.UpdateConstants;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
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
/* loaded from: classes9.dex */
public class c {
    private String aaC;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String jWA;
    private String jWB;
    private String jWC;
    private String jWD;
    private int jWE;
    private String jWF;
    private boolean jWG;
    private int jWH;
    private int jWI;
    private int jWJ;
    private int jWK;
    private String jWL;
    private String jWM;
    private String jWN;
    private String jWO;
    private int jWP;
    private String jWQ;
    private int jWR;
    private boolean jWS;
    private int jWT;
    private int jWU;
    private int jXa;
    private int level;
    private String title;
    private int valid;
    private String jWz = "0";
    private ArrayList<d> jWV = new ArrayList<>();
    private ArrayList<d> jWW = new ArrayList<>();
    private ArrayList<d> jWX = new ArrayList<>();
    private HashMap<String, d> jWY = new HashMap<>();
    private a jWZ = new a();
    private f jXb = new f();
    private k jXc = new k();

    public boolean cGG() {
        return (this.jXb == null || StringUtils.isNull(this.jXb.jXv)) ? false : true;
    }

    public String aPw() {
        return this.jXb.cIU;
    }

    public String cGH() {
        return this.jXb.jXv;
    }

    public String cGI() {
        return this.jXc.jYP;
    }

    public String cGJ() {
        return this.jXc.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cGK() {
        return !StringUtils.isNull(this.jWz) && this.jWz.equals("1");
    }

    public String cGL() {
        return this.jWA;
    }

    public String cqR() {
        return this.aaC;
    }

    public String cGM() {
        return this.jWB;
    }

    public String cGN() {
        return this.jWC;
    }

    public String cGO() {
        return this.jWD;
    }

    public int cGP() {
        return this.jWE;
    }

    public String cGQ() {
        return this.jWF;
    }

    public ArrayList<d> cGR() {
        return this.jWV;
    }

    public a cGS() {
        return this.jWZ;
    }

    public ArrayList<d> cGT() {
        return this.jWW;
    }

    public ArrayList<d> cGU() {
        return this.jWX;
    }

    public boolean cGV() {
        return this.jWG;
    }

    public String cGW() {
        return this.jWQ;
    }

    public String getContent() {
        return this.content;
    }

    public int cGX() {
        return this.jWR;
    }

    public boolean cGY() {
        return this.jWS;
    }

    public int cGZ() {
        return this.jWT;
    }

    public int cHa() {
        return this.jWU;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.jWY.get(signData.forumId)) != null) {
            dVar.BX(1);
            dVar.BY(signData.count_sign_num);
            dVar.Ca(signData.sign_bonus_point);
            dVar.sv(true);
            dVar.sw(false);
            dVar.sx(false);
            a(dVar);
            cHb();
            su(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cHe() >= this.level) {
            this.jWJ++;
            this.jWK--;
        } else {
            this.jWH++;
            this.jWI--;
        }
        this.jWY.remove(String.valueOf(dVar.getForumId()));
        this.jWX.remove(dVar);
        if (dVar.cHf() + dVar.cHj() >= dVar.cHg()) {
            dVar.BZ(dVar.cHe() + 1);
            dVar.sy(true);
            if (dVar.cHe() == this.level) {
                this.jWJ++;
                this.jWH--;
            }
        }
        this.jWW.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cHj(), -1);
    }

    private void cHb() {
        if (this.jWG) {
            if (this.jWK + this.jWI <= 0) {
                this.jWS = true;
            } else {
                this.jWS = false;
            }
        } else if (this.jWK <= 0) {
            this.jWS = true;
        } else {
            this.jWS = false;
        }
    }

    public void a(h hVar) {
        this.jWT = 0;
        this.jWU = 0;
        ArrayList<i> cHt = hVar.cHt();
        int size = cHt.size();
        for (int i = 0; i < size; i++) {
            i iVar = cHt.get(i);
            d dVar = this.jWY.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cHw() != 0) {
                    this.jWT++;
                    dVar.BX(1);
                    dVar.BY(iVar.cHx());
                    dVar.Ca(iVar.getCurScore());
                    dVar.sv(true);
                    dVar.sw(false);
                    dVar.sx(false);
                    a(dVar);
                } else {
                    this.jWU++;
                    dVar.sv(false);
                    dVar.sw(true);
                    dVar.sx(false);
                    dVar.setErrorMsg(iVar.cGS().getUserMsg());
                }
            }
        }
        cHb();
        su(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.jWZ.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.jWz = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.jWA = jSONObject.optString("text_pre");
            this.aaC = jSONObject.optString("text_color");
            this.jWB = jSONObject.optString("text_mid");
            this.jWC = jSONObject.optString("text_suf");
            this.jWD = jSONObject.optString("num_notice");
            this.jWE = jSONObject.optInt("show_dialog");
            this.jWF = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(UpdateConstants.VALID_KEY, 0);
            this.jXa = jSONObject.optInt("sign_max_num", 50);
            this.jWP = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.jWQ = jSONObject.optString("button_content");
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
            if (this.jWP == 1) {
                this.jWG = true;
            } else {
                this.jWG = false;
            }
            this.jWM = this.level + this.title;
            this.jWL = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.jYF = this.jXa;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.jYF);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cHc() == 0) {
                            if (this.valid == 0) {
                                if (this.jWG) {
                                    dVar.sw(true);
                                } else if (dVar.cHe() > this.level) {
                                    dVar.sw(true);
                                }
                            }
                            if (dVar.cHe() >= this.level) {
                                this.jWK++;
                            } else {
                                this.jWI++;
                            }
                            this.jWX.add(dVar);
                            this.jWY.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cHe() >= this.level) {
                                this.jWJ++;
                            } else {
                                this.jWH++;
                            }
                            this.jWW.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cHj(), -1);
                        }
                        this.jWV.add(dVar);
                        Collections.sort(this.jWV, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cHe() - dVar2.cHe();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.jXb == null) {
                this.jXb = new f();
            }
            this.jXb.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.jXc == null) {
                this.jXc = new k();
            }
            this.jXc.parserJson(optJSONObject3);
            su(false);
        }
    }

    private void su(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.jWV.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.jWV.removeAll(arrayList);
        }
        if (this.jWK + this.jWJ > 0) {
            if (this.jWJ > 0) {
                this.jWO = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jWJ), Integer.valueOf(this.jWK));
            } else {
                this.jWO = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jWK + this.jWJ));
            }
            if (this.jWV.size() > 0) {
                this.jWV.add(0, new b(this.jWM, this.jWO));
            }
        }
        if (this.jWI + this.jWH > 0) {
            if (this.jWH > 0) {
                this.jWN = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jWH), Integer.valueOf(this.jWI));
            } else {
                this.jWN = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jWI + this.jWH));
            }
            if (this.jWK + this.jWJ > 0) {
                if (this.jWV.size() > this.jWK + this.jWJ + 1) {
                    this.jWV.add(this.jWK + this.jWJ + 1, new b(this.jWL, this.jWN));
                }
            } else if (this.jWV.size() > 0) {
                this.jWV.add(0, new b(this.jWL, this.jWN));
            }
        }
        if (this.jWV.size() <= 0) {
            this.jWR = 3;
        } else if (this.jWG) {
            if (this.valid == 1 && this.jWX.size() > 0) {
                this.jWR = 0;
            } else {
                this.jWR = 2;
            }
        } else if (this.valid == 1 && this.jWK > 0) {
            this.jWR = 0;
        } else if (this.jWK + this.jWJ > 0) {
            this.jWR = 2;
        } else if (this.jWK + this.jWJ <= 0) {
            this.jWR = 3;
        }
    }
}
