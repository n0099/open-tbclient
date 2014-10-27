package com.baidu.tieba.signall;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.aj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    private String bJK;
    private String bJL;
    private String bJM;
    private String bJN;
    private String bJO;
    private int bJP;
    private String bJQ;
    private int bJR;
    private boolean bJS;
    private int bJT;
    private int bJU;
    private int bJV;
    private int bJW;
    private String bJX;
    private String bJY;
    private String bJZ;
    private String bKa;
    private int bKb;
    private String bKc;
    private int bKd;
    private boolean bKe;
    private int bKf;
    private int bKg;
    private ArrayList<d> bKh = new ArrayList<>();
    private ArrayList<d> bKi = new ArrayList<>();
    private ArrayList<d> bKj = new ArrayList<>();
    private HashMap<String, d> bKk = new HashMap<>();
    private com.baidu.tieba.home.t bKl = new com.baidu.tieba.home.t();
    private int bKm;
    private String content;
    private int level;
    private String title;

    public int getLevel() {
        return this.level;
    }

    public String acq() {
        return this.bJK;
    }

    public String acr() {
        return this.bJL;
    }

    public String acs() {
        return this.bJM;
    }

    public String act() {
        return this.bJN;
    }

    public String acu() {
        return this.bJO;
    }

    public int acv() {
        return this.bJP;
    }

    public String acw() {
        return this.bJQ;
    }

    public ArrayList<d> acx() {
        return this.bKh;
    }

    public com.baidu.tieba.home.t acy() {
        return this.bKl;
    }

    public ArrayList<d> acz() {
        return this.bKi;
    }

    public ArrayList<d> acA() {
        return this.bKj;
    }

    public boolean acB() {
        return this.bJS;
    }

    public String acC() {
        return this.bKc;
    }

    public String getContent() {
        return this.content;
    }

    public int acD() {
        return this.bKd;
    }

    public boolean acE() {
        return this.bKe;
    }

    public int acF() {
        return this.bKf;
    }

    public int acG() {
        return this.bKg;
    }

    public void c(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.bKk.get(signData.getForumId())) != null) {
            dVar.hk(1);
            dVar.hl(signData.getCountSignNum());
            dVar.hm(signData.getBonusPoint());
            dVar.eD(true);
            dVar.eE(false);
            dVar.eF(false);
            a(dVar);
            acH();
            eC(true);
        }
    }

    private void a(d dVar) {
        if (dVar.zz() >= this.level) {
            this.bJV++;
            this.bJW--;
        } else {
            this.bJT++;
            this.bJU--;
        }
        this.bKk.remove(String.valueOf(dVar.getForumId()));
        this.bKj.remove(dVar);
        if (dVar.acK() + dVar.acP() >= dVar.acL()) {
            dVar.ed(dVar.zz() + 1);
            dVar.eG(true);
            if (dVar.zz() == this.level) {
                this.bJV++;
                this.bJT--;
            }
        }
        this.bKi.add(dVar);
        aj.wk().f(dVar.getForumName(), dVar.acP(), -1);
    }

    private void acH() {
        if (this.bJS) {
            if (this.bJW + this.bJU <= 0) {
                this.bKe = true;
            } else {
                this.bKe = false;
            }
        } else if (this.bJW <= 0) {
            this.bKe = true;
        } else {
            this.bKe = false;
        }
    }

    public void a(s sVar) {
        this.bKf = 0;
        this.bKg = 0;
        ArrayList<t> acW = sVar.acW();
        int size = acW.size();
        for (int i = 0; i < size; i++) {
            t tVar = acW.get(i);
            d dVar = this.bKk.get(new StringBuilder(String.valueOf(tVar.getForumId())).toString());
            if (dVar != null) {
                if (tVar.getSigned() != 0) {
                    this.bKf++;
                    dVar.hk(1);
                    dVar.hl(tVar.acZ());
                    dVar.hm(tVar.getCurScore());
                    dVar.eD(true);
                    dVar.eE(false);
                    dVar.eF(false);
                    a(dVar);
                } else {
                    this.bKg++;
                    dVar.eD(false);
                    dVar.eE(true);
                    dVar.eF(false);
                    dVar.setErrorMsg(tVar.acy().getUserMsg());
                }
            }
        }
        acH();
        eC(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bKl.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.bJK = jSONObject.optString("text_pre");
            this.bJL = jSONObject.optString("text_color");
            this.bJM = jSONObject.optString("text_mid");
            this.bJN = jSONObject.optString("text_suf");
            this.bJO = jSONObject.optString("num_notice");
            this.bJP = jSONObject.optInt("show_dialog");
            this.bJQ = jSONObject.optString("sign_notice");
            this.bJR = jSONObject.optInt("valid", 0);
            this.bKm = jSONObject.optInt("sign_max_num", 50);
            this.bKb = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.bKc = jSONObject.optString("button_content");
            if (this.bKb == 1) {
                this.bJS = true;
            } else {
                this.bJS = false;
            }
            this.bJY = String.valueOf(this.level) + this.title;
            this.bJX = "1-" + (this.level - 1) + TbadkApplication.m251getInst().getString(com.baidu.tieba.y.sign_all_forum_tip);
            ab.bLD = this.bKm;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), ab.bLD);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.acI() == 0) {
                            if (this.bJR == 0) {
                                if (this.bJS) {
                                    dVar.eE(true);
                                } else if (dVar.zz() > this.level) {
                                    dVar.eE(true);
                                }
                            }
                            if (dVar.zz() >= this.level) {
                                this.bJW++;
                            } else {
                                this.bJU++;
                            }
                            this.bKj.add(dVar);
                            this.bKk.put(new StringBuilder(String.valueOf(dVar.getForumId())).toString(), dVar);
                        } else {
                            if (dVar.zz() >= this.level) {
                                this.bJV++;
                            } else {
                                this.bJT++;
                            }
                            this.bKi.add(dVar);
                            aj.wk().f(dVar.getForumName(), dVar.acP(), -1);
                        }
                        this.bKh.add(dVar);
                        Collections.sort(this.bKh, new c(this));
                    }
                }
            }
            eC(false);
        }
    }

    private void eC(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.bKh.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof a) {
                    arrayList.add(next);
                }
            }
            this.bKh.removeAll(arrayList);
        }
        if (this.bJW + this.bJV > 0) {
            if (this.bJV > 0) {
                this.bKa = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.signallforum_res, new Object[]{Integer.valueOf(this.bJV), Integer.valueOf(this.bJW)});
            } else {
                this.bKa = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.signallforum_count, new Object[]{Integer.valueOf(this.bJW + this.bJV)});
            }
            if (this.bKh.size() > 0) {
                this.bKh.add(0, new a(this.bJY, this.bKa));
            }
        }
        if (this.bJU + this.bJT > 0) {
            if (this.bJT > 0) {
                this.bJZ = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.signallforum_res, new Object[]{Integer.valueOf(this.bJT), Integer.valueOf(this.bJU)});
            } else {
                this.bJZ = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.signallforum_count, new Object[]{Integer.valueOf(this.bJU + this.bJT)});
            }
            if (this.bJW + this.bJV > 0) {
                if (this.bKh.size() > this.bJW + this.bJV + 1) {
                    this.bKh.add(this.bJW + this.bJV + 1, new a(this.bJX, this.bJZ));
                }
            } else if (this.bKh.size() > 0) {
                this.bKh.add(0, new a(this.bJX, this.bJZ));
            }
        }
        if (this.bKh.size() <= 0) {
            this.bKd = 3;
        } else if (this.bJS) {
            if (this.bJR == 1 && this.bKj.size() > 0) {
                this.bKd = 0;
            } else {
                this.bKd = 2;
            }
        } else if (this.bJR == 1 && this.bJW > 0) {
            this.bKd = 0;
        } else if (this.bJW + this.bJV > 0) {
            this.bKd = 2;
        } else if (this.bJW + this.bJV <= 0) {
            this.bKd = 3;
        }
    }
}
