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
    private String eiA;
    private String eiB;
    private String eiC;
    private String eiD;
    private int eiE;
    private String eiF;
    private int eiG;
    private boolean eiH;
    private int eiI;
    private int eiJ;
    private int eiP;
    private String ein;
    private String eio;
    private String eip;
    private String eiq;
    private String eir;
    private int eis;
    private String eit;
    private int eiu;
    private boolean eiv;
    private int eiw;
    private int eix;
    private int eiy;
    private int eiz;
    private int level;
    private String title;
    private String eim = "0";
    private ArrayList<e> eiK = new ArrayList<>();
    private ArrayList<e> eiL = new ArrayList<>();
    private ArrayList<e> eiM = new ArrayList<>();
    private HashMap<String, e> eiN = new HashMap<>();
    private a eiO = new a();
    private i eiQ = new i();

    public boolean aPG() {
        return (this.eiQ == null || StringUtils.isNull(this.eiQ.ejj)) ? false : true;
    }

    public String Fl() {
        return this.eiQ.MQ;
    }

    public String UR() {
        return this.eiQ.ejj;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean aPH() {
        return !StringUtils.isNull(this.eim) && this.eim.equals("1");
    }

    public String aPI() {
        return this.ein;
    }

    public String aAK() {
        return this.eio;
    }

    public String aPJ() {
        return this.eip;
    }

    public String aPK() {
        return this.eiq;
    }

    public String aPL() {
        return this.eir;
    }

    public int aPM() {
        return this.eis;
    }

    public String aPN() {
        return this.eit;
    }

    public ArrayList<e> aPO() {
        return this.eiK;
    }

    public a aPP() {
        return this.eiO;
    }

    public ArrayList<e> aPQ() {
        return this.eiL;
    }

    public ArrayList<e> aPR() {
        return this.eiM;
    }

    public boolean aPS() {
        return this.eiv;
    }

    public String aPT() {
        return this.eiF;
    }

    public String getContent() {
        return this.content;
    }

    public int aPU() {
        return this.eiG;
    }

    public boolean aPV() {
        return this.eiH;
    }

    public int aPW() {
        return this.eiI;
    }

    public int aPX() {
        return this.eiJ;
    }

    public void a(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.eiN.get(signData.getForumId())) != null) {
            eVar.oP(1);
            eVar.oQ(signData.getCountSignNum());
            eVar.oR(signData.getBonusPoint());
            eVar.jk(true);
            eVar.jl(false);
            eVar.jm(false);
            a(eVar);
            aPY();
            jj(true);
        }
    }

    private void a(e eVar) {
        if (eVar.getUserLevel() >= this.level) {
            this.eiy++;
            this.eiz--;
        } else {
            this.eiw++;
            this.eix--;
        }
        this.eiN.remove(String.valueOf(eVar.getForumId()));
        this.eiM.remove(eVar);
        if (eVar.aQb() + eVar.aQg() >= eVar.aQc()) {
            eVar.setUserLevel(eVar.getUserLevel() + 1);
            eVar.jn(true);
            if (eVar.getUserLevel() == this.level) {
                this.eiy++;
                this.eiw--;
            }
        }
        this.eiL.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aQg(), -1);
    }

    private void aPY() {
        if (this.eiv) {
            if (this.eiz + this.eix <= 0) {
                this.eiH = true;
            } else {
                this.eiH = false;
            }
        } else if (this.eiz <= 0) {
            this.eiH = true;
        } else {
            this.eiH = false;
        }
    }

    public void a(u uVar) {
        this.eiI = 0;
        this.eiJ = 0;
        ArrayList<v> aQp = uVar.aQp();
        int size = aQp.size();
        for (int i = 0; i < size; i++) {
            v vVar = aQp.get(i);
            e eVar = this.eiN.get(new StringBuilder(String.valueOf(vVar.getForumId())).toString());
            if (eVar != null) {
                if (vVar.getSigned() != 0) {
                    this.eiI++;
                    eVar.oP(1);
                    eVar.oQ(vVar.aQs());
                    eVar.oR(vVar.getCurScore());
                    eVar.jk(true);
                    eVar.jl(false);
                    eVar.jm(false);
                    a(eVar);
                } else {
                    this.eiJ++;
                    eVar.jk(false);
                    eVar.jl(true);
                    eVar.jm(false);
                    eVar.setErrorMsg(vVar.aPP().getUserMsg());
                }
            }
        }
        aPY();
        jj(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eiO.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.eim = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.ein = jSONObject.optString("text_pre");
            this.eio = jSONObject.optString("text_color");
            this.eip = jSONObject.optString("text_mid");
            this.eiq = jSONObject.optString("text_suf");
            this.eir = jSONObject.optString("num_notice");
            this.eis = jSONObject.optInt("show_dialog");
            this.eit = jSONObject.optString("sign_notice");
            this.eiu = jSONObject.optInt("valid", 0);
            this.eiP = jSONObject.optInt("sign_max_num", 50);
            this.eiE = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.eiF = jSONObject.optString("button_content");
            if (this.eiE == 1) {
                this.eiv = true;
            } else {
                this.eiv = false;
            }
            this.eiB = String.valueOf(this.level) + this.title;
            this.eiA = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(t.j.sign_all_forum_tip);
            af.ekp = this.eiP;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), af.ekp);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.aPZ() == 0) {
                            if (this.eiu == 0) {
                                if (this.eiv) {
                                    eVar.jl(true);
                                } else if (eVar.getUserLevel() > this.level) {
                                    eVar.jl(true);
                                }
                            }
                            if (eVar.getUserLevel() >= this.level) {
                                this.eiz++;
                            } else {
                                this.eix++;
                            }
                            this.eiM.add(eVar);
                            this.eiN.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.getUserLevel() >= this.level) {
                                this.eiy++;
                            } else {
                                this.eiw++;
                            }
                            this.eiL.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aQg(), -1);
                        }
                        this.eiK.add(eVar);
                        Collections.sort(this.eiK, new d(this));
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("advert");
            if (this.eiQ == null) {
                this.eiQ = new i();
            }
            this.eiQ.parserJson(optJSONObject);
            jj(false);
        }
    }

    private void jj(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.eiK.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.eiK.removeAll(arrayList);
        }
        if (this.eiz + this.eiy > 0) {
            if (this.eiy > 0) {
                this.eiD = TbadkApplication.getInst().getContext().getString(t.j.signallforum_res, Integer.valueOf(this.eiy), Integer.valueOf(this.eiz));
            } else {
                this.eiD = TbadkApplication.getInst().getContext().getString(t.j.signallforum_count, Integer.valueOf(this.eiz + this.eiy));
            }
            if (this.eiK.size() > 0) {
                this.eiK.add(0, new b(this.eiB, this.eiD));
            }
        }
        if (this.eix + this.eiw > 0) {
            if (this.eiw > 0) {
                this.eiC = TbadkApplication.getInst().getContext().getString(t.j.signallforum_res, Integer.valueOf(this.eiw), Integer.valueOf(this.eix));
            } else {
                this.eiC = TbadkApplication.getInst().getContext().getString(t.j.signallforum_count, Integer.valueOf(this.eix + this.eiw));
            }
            if (this.eiz + this.eiy > 0) {
                if (this.eiK.size() > this.eiz + this.eiy + 1) {
                    this.eiK.add(this.eiz + this.eiy + 1, new b(this.eiA, this.eiC));
                }
            } else if (this.eiK.size() > 0) {
                this.eiK.add(0, new b(this.eiA, this.eiC));
            }
        }
        if (this.eiK.size() <= 0) {
            this.eiG = 3;
        } else if (this.eiv) {
            if (this.eiu == 1 && this.eiM.size() > 0) {
                this.eiG = 0;
            } else {
                this.eiG = 2;
            }
        } else if (this.eiu == 1 && this.eiz > 0) {
            this.eiG = 0;
        } else if (this.eiz + this.eiy > 0) {
            this.eiG = 2;
        } else if (this.eiz + this.eiy <= 0) {
            this.eiG = 3;
        }
    }
}
