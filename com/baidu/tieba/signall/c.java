package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes6.dex */
public class c {
    private String alB;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int iZA;
    private String iZB;
    private int iZC;
    private boolean iZD;
    private int iZE;
    private int iZF;
    private int iZG;
    private int iZH;
    private String iZI;
    private String iZJ;
    private String iZK;
    private String iZL;
    private int iZM;
    private String iZN;
    private int iZO;
    private boolean iZP;
    private int iZQ;
    private int iZR;
    private int iZX;
    private String iZw;
    private String iZx;
    private String iZy;
    private String iZz;
    private int level;
    private String title;
    private String iZv = "0";
    private ArrayList<d> iZS = new ArrayList<>();
    private ArrayList<d> iZT = new ArrayList<>();
    private ArrayList<d> iZU = new ArrayList<>();
    private HashMap<String, d> iZV = new HashMap<>();
    private a iZW = new a();
    private f iZY = new f();
    private k iZZ = new k();

    public boolean cnC() {
        return (this.iZY == null || StringUtils.isNull(this.iZY.jar)) ? false : true;
    }

    public String awn() {
        return this.iZY.bFu;
    }

    public String cnD() {
        return this.iZY.jar;
    }

    public String cnE() {
        return this.iZZ.jbL;
    }

    public String cnF() {
        return this.iZZ.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cnG() {
        return !StringUtils.isNull(this.iZv) && this.iZv.equals("1");
    }

    public String cnH() {
        return this.iZw;
    }

    public String caL() {
        return this.alB;
    }

    public String cnI() {
        return this.iZx;
    }

    public String cnJ() {
        return this.iZy;
    }

    public String cnK() {
        return this.iZz;
    }

    public int cnL() {
        return this.iZA;
    }

    public String cnM() {
        return this.iZB;
    }

    public ArrayList<d> cnN() {
        return this.iZS;
    }

    public a cnO() {
        return this.iZW;
    }

    public ArrayList<d> cnP() {
        return this.iZT;
    }

    public ArrayList<d> cnQ() {
        return this.iZU;
    }

    public boolean cnR() {
        return this.iZD;
    }

    public String cnS() {
        return this.iZN;
    }

    public String getContent() {
        return this.content;
    }

    public int cnT() {
        return this.iZO;
    }

    public boolean cnU() {
        return this.iZP;
    }

    public int cnV() {
        return this.iZQ;
    }

    public int cnW() {
        return this.iZR;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.iZV.get(signData.forumId)) != null) {
            dVar.AP(1);
            dVar.AQ(signData.count_sign_num);
            dVar.AS(signData.sign_bonus_point);
            dVar.qS(true);
            dVar.qT(false);
            dVar.qU(false);
            a(dVar);
            cnX();
            qR(true);
        }
    }

    private void a(d dVar) {
        if (dVar.coa() >= this.level) {
            this.iZG++;
            this.iZH--;
        } else {
            this.iZE++;
            this.iZF--;
        }
        this.iZV.remove(String.valueOf(dVar.getForumId()));
        this.iZU.remove(dVar);
        if (dVar.cob() + dVar.cof() >= dVar.coc()) {
            dVar.AR(dVar.coa() + 1);
            dVar.qV(true);
            if (dVar.coa() == this.level) {
                this.iZG++;
                this.iZE--;
            }
        }
        this.iZT.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cof(), -1);
    }

    private void cnX() {
        if (this.iZD) {
            if (this.iZH + this.iZF <= 0) {
                this.iZP = true;
            } else {
                this.iZP = false;
            }
        } else if (this.iZH <= 0) {
            this.iZP = true;
        } else {
            this.iZP = false;
        }
    }

    public void a(h hVar) {
        this.iZQ = 0;
        this.iZR = 0;
        ArrayList<i> cop = hVar.cop();
        int size = cop.size();
        for (int i = 0; i < size; i++) {
            i iVar = cop.get(i);
            d dVar = this.iZV.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cos() != 0) {
                    this.iZQ++;
                    dVar.AP(1);
                    dVar.AQ(iVar.cot());
                    dVar.AS(iVar.getCurScore());
                    dVar.qS(true);
                    dVar.qT(false);
                    dVar.qU(false);
                    a(dVar);
                } else {
                    this.iZR++;
                    dVar.qS(false);
                    dVar.qT(true);
                    dVar.qU(false);
                    dVar.setErrorMsg(iVar.cnO().getUserMsg());
                }
            }
        }
        cnX();
        qR(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.iZW.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.iZv = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.iZw = jSONObject.optString("text_pre");
            this.alB = jSONObject.optString("text_color");
            this.iZx = jSONObject.optString("text_mid");
            this.iZy = jSONObject.optString("text_suf");
            this.iZz = jSONObject.optString("num_notice");
            this.iZA = jSONObject.optInt("show_dialog");
            this.iZB = jSONObject.optString("sign_notice");
            this.iZC = jSONObject.optInt("valid", 0);
            this.iZX = jSONObject.optInt("sign_max_num", 50);
            this.iZM = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.iZN = jSONObject.optString("button_content");
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
            if (this.iZM == 1) {
                this.iZD = true;
            } else {
                this.iZD = false;
            }
            this.iZJ = this.level + this.title;
            this.iZI = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.jbB = this.iZX;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.jbB);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cnY() == 0) {
                            if (this.iZC == 0) {
                                if (this.iZD) {
                                    dVar.qT(true);
                                } else if (dVar.coa() > this.level) {
                                    dVar.qT(true);
                                }
                            }
                            if (dVar.coa() >= this.level) {
                                this.iZH++;
                            } else {
                                this.iZF++;
                            }
                            this.iZU.add(dVar);
                            this.iZV.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.coa() >= this.level) {
                                this.iZG++;
                            } else {
                                this.iZE++;
                            }
                            this.iZT.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cof(), -1);
                        }
                        this.iZS.add(dVar);
                        Collections.sort(this.iZS, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.coa() - dVar2.coa();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.iZY == null) {
                this.iZY = new f();
            }
            this.iZY.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.iZZ == null) {
                this.iZZ = new k();
            }
            this.iZZ.parserJson(optJSONObject3);
            qR(false);
        }
    }

    private void qR(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.iZS.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.iZS.removeAll(arrayList);
        }
        if (this.iZH + this.iZG > 0) {
            if (this.iZG > 0) {
                this.iZL = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iZG), Integer.valueOf(this.iZH));
            } else {
                this.iZL = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iZH + this.iZG));
            }
            if (this.iZS.size() > 0) {
                this.iZS.add(0, new b(this.iZJ, this.iZL));
            }
        }
        if (this.iZF + this.iZE > 0) {
            if (this.iZE > 0) {
                this.iZK = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iZE), Integer.valueOf(this.iZF));
            } else {
                this.iZK = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iZF + this.iZE));
            }
            if (this.iZH + this.iZG > 0) {
                if (this.iZS.size() > this.iZH + this.iZG + 1) {
                    this.iZS.add(this.iZH + this.iZG + 1, new b(this.iZI, this.iZK));
                }
            } else if (this.iZS.size() > 0) {
                this.iZS.add(0, new b(this.iZI, this.iZK));
            }
        }
        if (this.iZS.size() <= 0) {
            this.iZO = 3;
        } else if (this.iZD) {
            if (this.iZC == 1 && this.iZU.size() > 0) {
                this.iZO = 0;
            } else {
                this.iZO = 2;
            }
        } else if (this.iZC == 1 && this.iZH > 0) {
            this.iZO = 0;
        } else if (this.iZH + this.iZG > 0) {
            this.iZO = 2;
        } else if (this.iZH + this.iZG <= 0) {
            this.iZO = 3;
        }
    }
}
