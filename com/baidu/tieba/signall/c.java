package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private String content;
    private String dMC;
    private String dMD;
    private String dME;
    private String dMF;
    private String dMG;
    private int dMH;
    private String dMI;
    private int dMJ;
    private boolean dMK;
    private int dML;
    private int dMM;
    private int dMN;
    private int dMO;
    private String dMP;
    private String dMQ;
    private String dMR;
    private String dMS;
    private int dMT;
    private String dMU;
    private int dMV;
    private boolean dMW;
    private int dMX;
    private int dMY;
    private int dNe;
    private int level;
    private String title;
    private ArrayList<e> dMZ = new ArrayList<>();
    private ArrayList<e> dNa = new ArrayList<>();
    private ArrayList<e> dNb = new ArrayList<>();
    private HashMap<String, e> dNc = new HashMap<>();
    private a dNd = new a();
    private i dNf = new i();

    public boolean aIB() {
        return (this.dNf == null || StringUtils.isNull(this.dNf.dNz)) ? false : true;
    }

    public String Gs() {
        return this.dNf.Uw;
    }

    public String Tc() {
        return this.dNf.dNz;
    }

    public int getLevel() {
        return this.level;
    }

    public String aIC() {
        return this.dMC;
    }

    public String asS() {
        return this.dMD;
    }

    public String aID() {
        return this.dME;
    }

    public String aIE() {
        return this.dMF;
    }

    public String aIF() {
        return this.dMG;
    }

    public int aIG() {
        return this.dMH;
    }

    public String aIH() {
        return this.dMI;
    }

    public ArrayList<e> aII() {
        return this.dMZ;
    }

    public a aIJ() {
        return this.dNd;
    }

    public ArrayList<e> aIK() {
        return this.dNa;
    }

    public ArrayList<e> aIL() {
        return this.dNb;
    }

    public boolean aIM() {
        return this.dMK;
    }

    public String aIN() {
        return this.dMU;
    }

    public String getContent() {
        return this.content;
    }

    public int aIO() {
        return this.dMV;
    }

    public boolean aIP() {
        return this.dMW;
    }

    public int aIQ() {
        return this.dMX;
    }

    public int aIR() {
        return this.dMY;
    }

    public void b(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.dNc.get(signData.getForumId())) != null) {
            eVar.nO(1);
            eVar.nP(signData.getCountSignNum());
            eVar.nQ(signData.getBonusPoint());
            eVar.hH(true);
            eVar.hI(false);
            eVar.hJ(false);
            a(eVar);
            aIS();
            hG(true);
        }
    }

    private void a(e eVar) {
        if (eVar.getUserLevel() >= this.level) {
            this.dMN++;
            this.dMO--;
        } else {
            this.dML++;
            this.dMM--;
        }
        this.dNc.remove(String.valueOf(eVar.getForumId()));
        this.dNb.remove(eVar);
        if (eVar.aIV() + eVar.aJa() >= eVar.aIW()) {
            eVar.setUserLevel(eVar.getUserLevel() + 1);
            eVar.hK(true);
            if (eVar.getUserLevel() == this.level) {
                this.dMN++;
                this.dML--;
            }
        }
        this.dNa.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aJa(), -1);
    }

    private void aIS() {
        if (this.dMK) {
            if (this.dMO + this.dMM <= 0) {
                this.dMW = true;
            } else {
                this.dMW = false;
            }
        } else if (this.dMO <= 0) {
            this.dMW = true;
        } else {
            this.dMW = false;
        }
    }

    public void a(u uVar) {
        this.dMX = 0;
        this.dMY = 0;
        ArrayList<v> aJi = uVar.aJi();
        int size = aJi.size();
        for (int i = 0; i < size; i++) {
            v vVar = aJi.get(i);
            e eVar = this.dNc.get(new StringBuilder(String.valueOf(vVar.getForumId())).toString());
            if (eVar != null) {
                if (vVar.getSigned() != 0) {
                    this.dMX++;
                    eVar.nO(1);
                    eVar.nP(vVar.aJl());
                    eVar.nQ(vVar.getCurScore());
                    eVar.hH(true);
                    eVar.hI(false);
                    eVar.hJ(false);
                    a(eVar);
                } else {
                    this.dMY++;
                    eVar.hH(false);
                    eVar.hI(true);
                    eVar.hJ(false);
                    eVar.setErrorMsg(vVar.aIJ().getUserMsg());
                }
            }
        }
        aIS();
        hG(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dNd.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.dMC = jSONObject.optString("text_pre");
            this.dMD = jSONObject.optString("text_color");
            this.dME = jSONObject.optString("text_mid");
            this.dMF = jSONObject.optString("text_suf");
            this.dMG = jSONObject.optString("num_notice");
            this.dMH = jSONObject.optInt("show_dialog");
            this.dMI = jSONObject.optString("sign_notice");
            this.dMJ = jSONObject.optInt("valid", 0);
            this.dNe = jSONObject.optInt("sign_max_num", 50);
            this.dMT = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.dMU = jSONObject.optString("button_content");
            if (this.dMT == 1) {
                this.dMK = true;
            } else {
                this.dMK = false;
            }
            this.dMQ = String.valueOf(this.level) + this.title;
            this.dMP = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(t.j.sign_all_forum_tip);
            af.dOD = this.dNe;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), af.dOD);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.aIT() == 0) {
                            if (this.dMJ == 0) {
                                if (this.dMK) {
                                    eVar.hI(true);
                                } else if (eVar.getUserLevel() > this.level) {
                                    eVar.hI(true);
                                }
                            }
                            if (eVar.getUserLevel() >= this.level) {
                                this.dMO++;
                            } else {
                                this.dMM++;
                            }
                            this.dNb.add(eVar);
                            this.dNc.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.getUserLevel() >= this.level) {
                                this.dMN++;
                            } else {
                                this.dML++;
                            }
                            this.dNa.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aJa(), -1);
                        }
                        this.dMZ.add(eVar);
                        Collections.sort(this.dMZ, new d(this));
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("advert");
            if (this.dNf == null) {
                this.dNf = new i();
            }
            this.dNf.parserJson(optJSONObject);
            hG(false);
        }
    }

    private void hG(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.dMZ.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.dMZ.removeAll(arrayList);
        }
        if (this.dMO + this.dMN > 0) {
            if (this.dMN > 0) {
                this.dMS = TbadkApplication.getInst().getContext().getString(t.j.signallforum_res, Integer.valueOf(this.dMN), Integer.valueOf(this.dMO));
            } else {
                this.dMS = TbadkApplication.getInst().getContext().getString(t.j.signallforum_count, Integer.valueOf(this.dMO + this.dMN));
            }
            if (this.dMZ.size() > 0) {
                this.dMZ.add(0, new b(this.dMQ, this.dMS));
            }
        }
        if (this.dMM + this.dML > 0) {
            if (this.dML > 0) {
                this.dMR = TbadkApplication.getInst().getContext().getString(t.j.signallforum_res, Integer.valueOf(this.dML), Integer.valueOf(this.dMM));
            } else {
                this.dMR = TbadkApplication.getInst().getContext().getString(t.j.signallforum_count, Integer.valueOf(this.dMM + this.dML));
            }
            if (this.dMO + this.dMN > 0) {
                if (this.dMZ.size() > this.dMO + this.dMN + 1) {
                    this.dMZ.add(this.dMO + this.dMN + 1, new b(this.dMP, this.dMR));
                }
            } else if (this.dMZ.size() > 0) {
                this.dMZ.add(0, new b(this.dMP, this.dMR));
            }
        }
        if (this.dMZ.size() <= 0) {
            this.dMV = 3;
        } else if (this.dMK) {
            if (this.dMJ == 1 && this.dNb.size() > 0) {
                this.dMV = 0;
            } else {
                this.dMV = 2;
            }
        } else if (this.dMJ == 1 && this.dMO > 0) {
            this.dMV = 0;
        } else if (this.dMO + this.dMN > 0) {
            this.dMV = 2;
        } else if (this.dMO + this.dMN <= 0) {
            this.dMV = 3;
        }
    }
}
