package com.baidu.tieba.signall;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int cAd;
    private String content;
    private String czB;
    private String czC;
    private String czD;
    private String czE;
    private String czF;
    private int czG;
    private String czH;
    private int czI;
    private boolean czJ;
    private int czK;
    private int czL;
    private int czM;
    private int czN;
    private String czO;
    private String czP;
    private String czQ;
    private String czR;
    private int czS;
    private String czT;
    private int czU;
    private boolean czV;
    private int czW;
    private int czX;
    private int level;
    private String title;
    private ArrayList<e> czY = new ArrayList<>();
    private ArrayList<e> czZ = new ArrayList<>();
    private ArrayList<e> cAa = new ArrayList<>();
    private HashMap<String, e> cAb = new HashMap<>();
    private a cAc = new a();

    public int getLevel() {
        return this.level;
    }

    public String amH() {
        return this.czB;
    }

    public String afD() {
        return this.czC;
    }

    public String amI() {
        return this.czD;
    }

    public String amJ() {
        return this.czE;
    }

    public String amK() {
        return this.czF;
    }

    public int amL() {
        return this.czG;
    }

    public String amM() {
        return this.czH;
    }

    public ArrayList<e> amN() {
        return this.czY;
    }

    public a amO() {
        return this.cAc;
    }

    public ArrayList<e> amP() {
        return this.czZ;
    }

    public ArrayList<e> amQ() {
        return this.cAa;
    }

    public boolean amR() {
        return this.czJ;
    }

    public String amS() {
        return this.czT;
    }

    public String getContent() {
        return this.content;
    }

    public int amT() {
        return this.czU;
    }

    public boolean amU() {
        return this.czV;
    }

    public int amV() {
        return this.czW;
    }

    public int amW() {
        return this.czX;
    }

    public void b(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.cAb.get(signData.getForumId())) != null) {
            eVar.js(1);
            eVar.jt(signData.getCountSignNum());
            eVar.jv(signData.getBonusPoint());
            eVar.fk(true);
            eVar.fl(false);
            eVar.fm(false);
            a(eVar);
            amX();
            fj(true);
        }
    }

    private void a(e eVar) {
        if (eVar.ana() >= this.level) {
            this.czM++;
            this.czN--;
        } else {
            this.czK++;
            this.czL--;
        }
        this.cAb.remove(String.valueOf(eVar.getForumId()));
        this.cAa.remove(eVar);
        if (eVar.anb() + eVar.ang() >= eVar.anc()) {
            eVar.ju(eVar.ana() + 1);
            eVar.fn(true);
            if (eVar.ana() == this.level) {
                this.czM++;
                this.czK--;
            }
        }
        this.czZ.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.ang(), -1);
    }

    private void amX() {
        if (this.czJ) {
            if (this.czN + this.czL <= 0) {
                this.czV = true;
            } else {
                this.czV = false;
            }
        } else if (this.czN <= 0) {
            this.czV = true;
        } else {
            this.czV = false;
        }
    }

    public void a(p pVar) {
        this.czW = 0;
        this.czX = 0;
        ArrayList<q> anm = pVar.anm();
        int size = anm.size();
        for (int i = 0; i < size; i++) {
            q qVar = anm.get(i);
            e eVar = this.cAb.get(new StringBuilder(String.valueOf(qVar.getForumId())).toString());
            if (eVar != null) {
                if (qVar.getSigned() != 0) {
                    this.czW++;
                    eVar.js(1);
                    eVar.jt(qVar.anp());
                    eVar.jv(qVar.getCurScore());
                    eVar.fk(true);
                    eVar.fl(false);
                    eVar.fm(false);
                    a(eVar);
                } else {
                    this.czX++;
                    eVar.fk(false);
                    eVar.fl(true);
                    eVar.fm(false);
                    eVar.setErrorMsg(qVar.amO().getUserMsg());
                }
            }
        }
        amX();
        fj(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cAc.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.czB = jSONObject.optString("text_pre");
            this.czC = jSONObject.optString("text_color");
            this.czD = jSONObject.optString("text_mid");
            this.czE = jSONObject.optString("text_suf");
            this.czF = jSONObject.optString("num_notice");
            this.czG = jSONObject.optInt("show_dialog");
            this.czH = jSONObject.optString("sign_notice");
            this.czI = jSONObject.optInt("valid", 0);
            this.cAd = jSONObject.optInt("sign_max_num", 50);
            this.czS = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.czT = jSONObject.optString("button_content");
            if (this.czS == 1) {
                this.czJ = true;
            } else {
                this.czJ = false;
            }
            this.czP = String.valueOf(this.level) + this.title;
            this.czO = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(i.C0057i.sign_all_forum_tip);
            z.cBv = this.cAd;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), z.cBv);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.amY() == 0) {
                            if (this.czI == 0) {
                                if (this.czJ) {
                                    eVar.fl(true);
                                } else if (eVar.ana() > this.level) {
                                    eVar.fl(true);
                                }
                            }
                            if (eVar.ana() >= this.level) {
                                this.czN++;
                            } else {
                                this.czL++;
                            }
                            this.cAa.add(eVar);
                            this.cAb.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.ana() >= this.level) {
                                this.czM++;
                            } else {
                                this.czK++;
                            }
                            this.czZ.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.ang(), -1);
                        }
                        this.czY.add(eVar);
                        Collections.sort(this.czY, new d(this));
                    }
                }
            }
            fj(false);
        }
    }

    private void fj(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.czY.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.czY.removeAll(arrayList);
        }
        if (this.czN + this.czM > 0) {
            if (this.czM > 0) {
                this.czR = TbadkApplication.getInst().getContext().getString(i.C0057i.signallforum_res, Integer.valueOf(this.czM), Integer.valueOf(this.czN));
            } else {
                this.czR = TbadkApplication.getInst().getContext().getString(i.C0057i.signallforum_count, Integer.valueOf(this.czN + this.czM));
            }
            if (this.czY.size() > 0) {
                this.czY.add(0, new b(this.czP, this.czR));
            }
        }
        if (this.czL + this.czK > 0) {
            if (this.czK > 0) {
                this.czQ = TbadkApplication.getInst().getContext().getString(i.C0057i.signallforum_res, Integer.valueOf(this.czK), Integer.valueOf(this.czL));
            } else {
                this.czQ = TbadkApplication.getInst().getContext().getString(i.C0057i.signallforum_count, Integer.valueOf(this.czL + this.czK));
            }
            if (this.czN + this.czM > 0) {
                if (this.czY.size() > this.czN + this.czM + 1) {
                    this.czY.add(this.czN + this.czM + 1, new b(this.czO, this.czQ));
                }
            } else if (this.czY.size() > 0) {
                this.czY.add(0, new b(this.czO, this.czQ));
            }
        }
        if (this.czY.size() <= 0) {
            this.czU = 3;
        } else if (this.czJ) {
            if (this.czI == 1 && this.cAa.size() > 0) {
                this.czU = 0;
            } else {
                this.czU = 2;
            }
        } else if (this.czI == 1 && this.czN > 0) {
            this.czU = 0;
        } else if (this.czN + this.czM > 0) {
            this.czU = 2;
        } else if (this.czN + this.czM <= 0) {
            this.czU = 3;
        }
    }
}
