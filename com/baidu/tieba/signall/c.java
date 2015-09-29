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
    private String cOU;
    private String cOV;
    private String cOW;
    private String cOX;
    private String cOY;
    private int cOZ;
    private String cPa;
    private int cPb;
    private boolean cPc;
    private int cPd;
    private int cPe;
    private int cPf;
    private int cPg;
    private String cPh;
    private String cPi;
    private String cPj;
    private String cPk;
    private int cPl;
    private String cPm;
    private int cPn;
    private boolean cPo;
    private int cPp;
    private int cPq;
    private ArrayList<e> cPr = new ArrayList<>();
    private ArrayList<e> cPs = new ArrayList<>();
    private ArrayList<e> cPt = new ArrayList<>();
    private HashMap<String, e> cPu = new HashMap<>();
    private a cPv = new a();
    private int cPw;
    private String content;
    private int level;
    private String title;

    public int getLevel() {
        return this.level;
    }

    public String ate() {
        return this.cOU;
    }

    public String ahT() {
        return this.cOV;
    }

    public String atf() {
        return this.cOW;
    }

    public String atg() {
        return this.cOX;
    }

    public String ath() {
        return this.cOY;
    }

    public int ati() {
        return this.cOZ;
    }

    public String atj() {
        return this.cPa;
    }

    public ArrayList<e> atk() {
        return this.cPr;
    }

    public a atl() {
        return this.cPv;
    }

    public ArrayList<e> atm() {
        return this.cPs;
    }

    public ArrayList<e> atn() {
        return this.cPt;
    }

    public boolean ato() {
        return this.cPc;
    }

    public String atp() {
        return this.cPm;
    }

    public String getContent() {
        return this.content;
    }

    public int atq() {
        return this.cPn;
    }

    public boolean atr() {
        return this.cPo;
    }

    public int ats() {
        return this.cPp;
    }

    public int att() {
        return this.cPq;
    }

    public void b(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.cPu.get(signData.getForumId())) != null) {
            eVar.kB(1);
            eVar.kC(signData.getCountSignNum());
            eVar.kE(signData.getBonusPoint());
            eVar.gg(true);
            eVar.gh(false);
            eVar.gi(false);
            a(eVar);
            atu();
            gf(true);
        }
    }

    private void a(e eVar) {
        if (eVar.atx() >= this.level) {
            this.cPf++;
            this.cPg--;
        } else {
            this.cPd++;
            this.cPe--;
        }
        this.cPu.remove(String.valueOf(eVar.getForumId()));
        this.cPt.remove(eVar);
        if (eVar.aty() + eVar.atD() >= eVar.atz()) {
            eVar.kD(eVar.atx() + 1);
            eVar.gj(true);
            if (eVar.atx() == this.level) {
                this.cPf++;
                this.cPd--;
            }
        }
        this.cPs.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.atD(), -1);
    }

    private void atu() {
        if (this.cPc) {
            if (this.cPg + this.cPe <= 0) {
                this.cPo = true;
            } else {
                this.cPo = false;
            }
        } else if (this.cPg <= 0) {
            this.cPo = true;
        } else {
            this.cPo = false;
        }
    }

    public void a(p pVar) {
        this.cPp = 0;
        this.cPq = 0;
        ArrayList<q> atJ = pVar.atJ();
        int size = atJ.size();
        for (int i = 0; i < size; i++) {
            q qVar = atJ.get(i);
            e eVar = this.cPu.get(new StringBuilder(String.valueOf(qVar.getForumId())).toString());
            if (eVar != null) {
                if (qVar.getSigned() != 0) {
                    this.cPp++;
                    eVar.kB(1);
                    eVar.kC(qVar.atM());
                    eVar.kE(qVar.getCurScore());
                    eVar.gg(true);
                    eVar.gh(false);
                    eVar.gi(false);
                    a(eVar);
                } else {
                    this.cPq++;
                    eVar.gg(false);
                    eVar.gh(true);
                    eVar.gi(false);
                    eVar.setErrorMsg(qVar.atl().getUserMsg());
                }
            }
        }
        atu();
        gf(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cPv.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.cOU = jSONObject.optString("text_pre");
            this.cOV = jSONObject.optString("text_color");
            this.cOW = jSONObject.optString("text_mid");
            this.cOX = jSONObject.optString("text_suf");
            this.cOY = jSONObject.optString("num_notice");
            this.cOZ = jSONObject.optInt("show_dialog");
            this.cPa = jSONObject.optString("sign_notice");
            this.cPb = jSONObject.optInt("valid", 0);
            this.cPw = jSONObject.optInt("sign_max_num", 50);
            this.cPl = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.cPm = jSONObject.optString("button_content");
            if (this.cPl == 1) {
                this.cPc = true;
            } else {
                this.cPc = false;
            }
            this.cPi = String.valueOf(this.level) + this.title;
            this.cPh = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(i.h.sign_all_forum_tip);
            z.cQO = this.cPw;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), z.cQO);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.atv() == 0) {
                            if (this.cPb == 0) {
                                if (this.cPc) {
                                    eVar.gh(true);
                                } else if (eVar.atx() > this.level) {
                                    eVar.gh(true);
                                }
                            }
                            if (eVar.atx() >= this.level) {
                                this.cPg++;
                            } else {
                                this.cPe++;
                            }
                            this.cPt.add(eVar);
                            this.cPu.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.atx() >= this.level) {
                                this.cPf++;
                            } else {
                                this.cPd++;
                            }
                            this.cPs.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.atD(), -1);
                        }
                        this.cPr.add(eVar);
                        Collections.sort(this.cPr, new d(this));
                    }
                }
            }
            gf(false);
        }
    }

    private void gf(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.cPr.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.cPr.removeAll(arrayList);
        }
        if (this.cPg + this.cPf > 0) {
            if (this.cPf > 0) {
                this.cPk = TbadkApplication.getInst().getContext().getString(i.h.signallforum_res, Integer.valueOf(this.cPf), Integer.valueOf(this.cPg));
            } else {
                this.cPk = TbadkApplication.getInst().getContext().getString(i.h.signallforum_count, Integer.valueOf(this.cPg + this.cPf));
            }
            if (this.cPr.size() > 0) {
                this.cPr.add(0, new b(this.cPi, this.cPk));
            }
        }
        if (this.cPe + this.cPd > 0) {
            if (this.cPd > 0) {
                this.cPj = TbadkApplication.getInst().getContext().getString(i.h.signallforum_res, Integer.valueOf(this.cPd), Integer.valueOf(this.cPe));
            } else {
                this.cPj = TbadkApplication.getInst().getContext().getString(i.h.signallforum_count, Integer.valueOf(this.cPe + this.cPd));
            }
            if (this.cPg + this.cPf > 0) {
                if (this.cPr.size() > this.cPg + this.cPf + 1) {
                    this.cPr.add(this.cPg + this.cPf + 1, new b(this.cPh, this.cPj));
                }
            } else if (this.cPr.size() > 0) {
                this.cPr.add(0, new b(this.cPh, this.cPj));
            }
        }
        if (this.cPr.size() <= 0) {
            this.cPn = 3;
        } else if (this.cPc) {
            if (this.cPb == 1 && this.cPt.size() > 0) {
                this.cPn = 0;
            } else {
                this.cPn = 2;
            }
        } else if (this.cPb == 1 && this.cPg > 0) {
            this.cPn = 0;
        } else if (this.cPg + this.cPf > 0) {
            this.cPn = 2;
        } else if (this.cPg + this.cPf <= 0) {
            this.cPn = 3;
        }
    }
}
