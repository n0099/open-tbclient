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
    private String bJZ;
    private int bKB;
    private String bKa;
    private String bKb;
    private String bKc;
    private String bKd;
    private int bKe;
    private String bKf;
    private int bKg;
    private boolean bKh;
    private int bKi;
    private int bKj;
    private int bKk;
    private int bKl;
    private String bKm;
    private String bKn;
    private String bKo;
    private String bKp;
    private int bKq;
    private String bKr;
    private int bKs;
    private boolean bKt;
    private int bKu;
    private int bKv;
    private String content;
    private int level;
    private String title;
    private ArrayList<d> bKw = new ArrayList<>();
    private ArrayList<d> bKx = new ArrayList<>();
    private ArrayList<d> bKy = new ArrayList<>();
    private HashMap<String, d> bKz = new HashMap<>();
    private com.baidu.tieba.home.t bKA = new com.baidu.tieba.home.t();

    public int getLevel() {
        return this.level;
    }

    public String act() {
        return this.bJZ;
    }

    public String acu() {
        return this.bKa;
    }

    public String acv() {
        return this.bKb;
    }

    public String acw() {
        return this.bKc;
    }

    public String acx() {
        return this.bKd;
    }

    public int acy() {
        return this.bKe;
    }

    public String acz() {
        return this.bKf;
    }

    public ArrayList<d> acA() {
        return this.bKw;
    }

    public com.baidu.tieba.home.t acB() {
        return this.bKA;
    }

    public ArrayList<d> acC() {
        return this.bKx;
    }

    public ArrayList<d> acD() {
        return this.bKy;
    }

    public boolean acE() {
        return this.bKh;
    }

    public String acF() {
        return this.bKr;
    }

    public String getContent() {
        return this.content;
    }

    public int acG() {
        return this.bKs;
    }

    public boolean acH() {
        return this.bKt;
    }

    public int acI() {
        return this.bKu;
    }

    public int acJ() {
        return this.bKv;
    }

    public void c(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.bKz.get(signData.getForumId())) != null) {
            dVar.hk(1);
            dVar.hl(signData.getCountSignNum());
            dVar.hm(signData.getBonusPoint());
            dVar.eD(true);
            dVar.eE(false);
            dVar.eF(false);
            a(dVar);
            acK();
            eC(true);
        }
    }

    private void a(d dVar) {
        if (dVar.zB() >= this.level) {
            this.bKk++;
            this.bKl--;
        } else {
            this.bKi++;
            this.bKj--;
        }
        this.bKz.remove(String.valueOf(dVar.getForumId()));
        this.bKy.remove(dVar);
        if (dVar.acN() + dVar.acS() >= dVar.acO()) {
            dVar.ed(dVar.zB() + 1);
            dVar.eG(true);
            if (dVar.zB() == this.level) {
                this.bKk++;
                this.bKi--;
            }
        }
        this.bKx.add(dVar);
        aj.wm().f(dVar.getForumName(), dVar.acS(), -1);
    }

    private void acK() {
        if (this.bKh) {
            if (this.bKl + this.bKj <= 0) {
                this.bKt = true;
            } else {
                this.bKt = false;
            }
        } else if (this.bKl <= 0) {
            this.bKt = true;
        } else {
            this.bKt = false;
        }
    }

    public void a(s sVar) {
        this.bKu = 0;
        this.bKv = 0;
        ArrayList<t> acZ = sVar.acZ();
        int size = acZ.size();
        for (int i = 0; i < size; i++) {
            t tVar = acZ.get(i);
            d dVar = this.bKz.get(new StringBuilder(String.valueOf(tVar.getForumId())).toString());
            if (dVar != null) {
                if (tVar.getSigned() != 0) {
                    this.bKu++;
                    dVar.hk(1);
                    dVar.hl(tVar.adc());
                    dVar.hm(tVar.getCurScore());
                    dVar.eD(true);
                    dVar.eE(false);
                    dVar.eF(false);
                    a(dVar);
                } else {
                    this.bKv++;
                    dVar.eD(false);
                    dVar.eE(true);
                    dVar.eF(false);
                    dVar.setErrorMsg(tVar.acB().getUserMsg());
                }
            }
        }
        acK();
        eC(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bKA.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.bJZ = jSONObject.optString("text_pre");
            this.bKa = jSONObject.optString("text_color");
            this.bKb = jSONObject.optString("text_mid");
            this.bKc = jSONObject.optString("text_suf");
            this.bKd = jSONObject.optString("num_notice");
            this.bKe = jSONObject.optInt("show_dialog");
            this.bKf = jSONObject.optString("sign_notice");
            this.bKg = jSONObject.optInt("valid", 0);
            this.bKB = jSONObject.optInt("sign_max_num", 50);
            this.bKq = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.bKr = jSONObject.optString("button_content");
            if (this.bKq == 1) {
                this.bKh = true;
            } else {
                this.bKh = false;
            }
            this.bKn = String.valueOf(this.level) + this.title;
            this.bKm = "1-" + (this.level - 1) + TbadkApplication.m251getInst().getString(com.baidu.tieba.y.sign_all_forum_tip);
            ab.bLS = this.bKB;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), ab.bLS);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.acL() == 0) {
                            if (this.bKg == 0) {
                                if (this.bKh) {
                                    dVar.eE(true);
                                } else if (dVar.zB() > this.level) {
                                    dVar.eE(true);
                                }
                            }
                            if (dVar.zB() >= this.level) {
                                this.bKl++;
                            } else {
                                this.bKj++;
                            }
                            this.bKy.add(dVar);
                            this.bKz.put(new StringBuilder(String.valueOf(dVar.getForumId())).toString(), dVar);
                        } else {
                            if (dVar.zB() >= this.level) {
                                this.bKk++;
                            } else {
                                this.bKi++;
                            }
                            this.bKx.add(dVar);
                            aj.wm().f(dVar.getForumName(), dVar.acS(), -1);
                        }
                        this.bKw.add(dVar);
                        Collections.sort(this.bKw, new c(this));
                    }
                }
            }
            eC(false);
        }
    }

    private void eC(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.bKw.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof a) {
                    arrayList.add(next);
                }
            }
            this.bKw.removeAll(arrayList);
        }
        if (this.bKl + this.bKk > 0) {
            if (this.bKk > 0) {
                this.bKp = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.signallforum_res, new Object[]{Integer.valueOf(this.bKk), Integer.valueOf(this.bKl)});
            } else {
                this.bKp = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.signallforum_count, new Object[]{Integer.valueOf(this.bKl + this.bKk)});
            }
            if (this.bKw.size() > 0) {
                this.bKw.add(0, new a(this.bKn, this.bKp));
            }
        }
        if (this.bKj + this.bKi > 0) {
            if (this.bKi > 0) {
                this.bKo = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.signallforum_res, new Object[]{Integer.valueOf(this.bKi), Integer.valueOf(this.bKj)});
            } else {
                this.bKo = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.signallforum_count, new Object[]{Integer.valueOf(this.bKj + this.bKi)});
            }
            if (this.bKl + this.bKk > 0) {
                if (this.bKw.size() > this.bKl + this.bKk + 1) {
                    this.bKw.add(this.bKl + this.bKk + 1, new a(this.bKm, this.bKo));
                }
            } else if (this.bKw.size() > 0) {
                this.bKw.add(0, new a(this.bKm, this.bKo));
            }
        }
        if (this.bKw.size() <= 0) {
            this.bKs = 3;
        } else if (this.bKh) {
            if (this.bKg == 1 && this.bKy.size() > 0) {
                this.bKs = 0;
            } else {
                this.bKs = 2;
            }
        } else if (this.bKg == 1 && this.bKl > 0) {
            this.bKs = 0;
        } else if (this.bKl + this.bKk > 0) {
            this.bKs = 2;
        } else if (this.bKl + this.bKk <= 0) {
            this.bKs = 3;
        }
    }
}
