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
    private int cPA;
    private boolean cPB;
    private int cPC;
    private int cPD;
    private int cPE;
    private int cPF;
    private String cPG;
    private String cPH;
    private String cPI;
    private String cPJ;
    private int cPK;
    private String cPL;
    private int cPM;
    private boolean cPN;
    private int cPO;
    private int cPP;
    private ArrayList<e> cPQ = new ArrayList<>();
    private ArrayList<e> cPR = new ArrayList<>();
    private ArrayList<e> cPS = new ArrayList<>();
    private HashMap<String, e> cPT = new HashMap<>();
    private a cPU = new a();
    private int cPV;
    private String cPt;
    private String cPu;
    private String cPv;
    private String cPw;
    private String cPx;
    private int cPy;
    private String cPz;
    private String content;
    private int level;
    private String title;

    public int getLevel() {
        return this.level;
    }

    public String atk() {
        return this.cPt;
    }

    public String ahT() {
        return this.cPu;
    }

    public String atl() {
        return this.cPv;
    }

    public String atm() {
        return this.cPw;
    }

    public String atn() {
        return this.cPx;
    }

    public int ato() {
        return this.cPy;
    }

    public String atp() {
        return this.cPz;
    }

    public ArrayList<e> atq() {
        return this.cPQ;
    }

    public a atr() {
        return this.cPU;
    }

    public ArrayList<e> ats() {
        return this.cPR;
    }

    public ArrayList<e> att() {
        return this.cPS;
    }

    public boolean atu() {
        return this.cPB;
    }

    public String atv() {
        return this.cPL;
    }

    public String getContent() {
        return this.content;
    }

    public int atw() {
        return this.cPM;
    }

    public boolean atx() {
        return this.cPN;
    }

    public int aty() {
        return this.cPO;
    }

    public int atz() {
        return this.cPP;
    }

    public void b(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.cPT.get(signData.getForumId())) != null) {
            eVar.kD(1);
            eVar.kE(signData.getCountSignNum());
            eVar.kG(signData.getBonusPoint());
            eVar.gg(true);
            eVar.gh(false);
            eVar.gi(false);
            a(eVar);
            atA();
            gf(true);
        }
    }

    private void a(e eVar) {
        if (eVar.atD() >= this.level) {
            this.cPE++;
            this.cPF--;
        } else {
            this.cPC++;
            this.cPD--;
        }
        this.cPT.remove(String.valueOf(eVar.getForumId()));
        this.cPS.remove(eVar);
        if (eVar.atE() + eVar.atJ() >= eVar.atF()) {
            eVar.kF(eVar.atD() + 1);
            eVar.gj(true);
            if (eVar.atD() == this.level) {
                this.cPE++;
                this.cPC--;
            }
        }
        this.cPR.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.atJ(), -1);
    }

    private void atA() {
        if (this.cPB) {
            if (this.cPF + this.cPD <= 0) {
                this.cPN = true;
            } else {
                this.cPN = false;
            }
        } else if (this.cPF <= 0) {
            this.cPN = true;
        } else {
            this.cPN = false;
        }
    }

    public void a(p pVar) {
        this.cPO = 0;
        this.cPP = 0;
        ArrayList<q> atP = pVar.atP();
        int size = atP.size();
        for (int i = 0; i < size; i++) {
            q qVar = atP.get(i);
            e eVar = this.cPT.get(new StringBuilder(String.valueOf(qVar.getForumId())).toString());
            if (eVar != null) {
                if (qVar.getSigned() != 0) {
                    this.cPO++;
                    eVar.kD(1);
                    eVar.kE(qVar.atS());
                    eVar.kG(qVar.getCurScore());
                    eVar.gg(true);
                    eVar.gh(false);
                    eVar.gi(false);
                    a(eVar);
                } else {
                    this.cPP++;
                    eVar.gg(false);
                    eVar.gh(true);
                    eVar.gi(false);
                    eVar.setErrorMsg(qVar.atr().getUserMsg());
                }
            }
        }
        atA();
        gf(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cPU.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.cPt = jSONObject.optString("text_pre");
            this.cPu = jSONObject.optString("text_color");
            this.cPv = jSONObject.optString("text_mid");
            this.cPw = jSONObject.optString("text_suf");
            this.cPx = jSONObject.optString("num_notice");
            this.cPy = jSONObject.optInt("show_dialog");
            this.cPz = jSONObject.optString("sign_notice");
            this.cPA = jSONObject.optInt("valid", 0);
            this.cPV = jSONObject.optInt("sign_max_num", 50);
            this.cPK = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.cPL = jSONObject.optString("button_content");
            if (this.cPK == 1) {
                this.cPB = true;
            } else {
                this.cPB = false;
            }
            this.cPH = String.valueOf(this.level) + this.title;
            this.cPG = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(i.h.sign_all_forum_tip);
            z.cRn = this.cPV;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), z.cRn);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.atB() == 0) {
                            if (this.cPA == 0) {
                                if (this.cPB) {
                                    eVar.gh(true);
                                } else if (eVar.atD() > this.level) {
                                    eVar.gh(true);
                                }
                            }
                            if (eVar.atD() >= this.level) {
                                this.cPF++;
                            } else {
                                this.cPD++;
                            }
                            this.cPS.add(eVar);
                            this.cPT.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.atD() >= this.level) {
                                this.cPE++;
                            } else {
                                this.cPC++;
                            }
                            this.cPR.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.atJ(), -1);
                        }
                        this.cPQ.add(eVar);
                        Collections.sort(this.cPQ, new d(this));
                    }
                }
            }
            gf(false);
        }
    }

    private void gf(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.cPQ.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.cPQ.removeAll(arrayList);
        }
        if (this.cPF + this.cPE > 0) {
            if (this.cPE > 0) {
                this.cPJ = TbadkApplication.getInst().getContext().getString(i.h.signallforum_res, Integer.valueOf(this.cPE), Integer.valueOf(this.cPF));
            } else {
                this.cPJ = TbadkApplication.getInst().getContext().getString(i.h.signallforum_count, Integer.valueOf(this.cPF + this.cPE));
            }
            if (this.cPQ.size() > 0) {
                this.cPQ.add(0, new b(this.cPH, this.cPJ));
            }
        }
        if (this.cPD + this.cPC > 0) {
            if (this.cPC > 0) {
                this.cPI = TbadkApplication.getInst().getContext().getString(i.h.signallforum_res, Integer.valueOf(this.cPC), Integer.valueOf(this.cPD));
            } else {
                this.cPI = TbadkApplication.getInst().getContext().getString(i.h.signallforum_count, Integer.valueOf(this.cPD + this.cPC));
            }
            if (this.cPF + this.cPE > 0) {
                if (this.cPQ.size() > this.cPF + this.cPE + 1) {
                    this.cPQ.add(this.cPF + this.cPE + 1, new b(this.cPG, this.cPI));
                }
            } else if (this.cPQ.size() > 0) {
                this.cPQ.add(0, new b(this.cPG, this.cPI));
            }
        }
        if (this.cPQ.size() <= 0) {
            this.cPM = 3;
        } else if (this.cPB) {
            if (this.cPA == 1 && this.cPS.size() > 0) {
                this.cPM = 0;
            } else {
                this.cPM = 2;
            }
        } else if (this.cPA == 1 && this.cPF > 0) {
            this.cPM = 0;
        } else if (this.cPF + this.cPE > 0) {
            this.cPM = 2;
        } else if (this.cPF + this.cPE <= 0) {
            this.cPM = 3;
        }
    }
}
