package com.baidu.tieba.signall;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private String chA;
    private String chB;
    private String chC;
    private int chD;
    private String chE;
    private int chF;
    private boolean chG;
    private int chH;
    private int chI;
    private ArrayList<e> chJ = new ArrayList<>();
    private ArrayList<e> chK = new ArrayList<>();
    private ArrayList<e> chL = new ArrayList<>();
    private HashMap<String, e> chM = new HashMap<>();
    private a chN = new a();
    private int chO;
    private String chm;
    private String chn;
    private String cho;
    private String chp;
    private String chq;
    private int chr;
    private String chs;
    private int cht;
    private boolean chu;
    private int chv;
    private int chw;
    private int chx;
    private int chy;
    private String chz;
    private String content;
    private int level;
    private String title;

    public int getLevel() {
        return this.level;
    }

    public String ake() {
        return this.chm;
    }

    public String akf() {
        return this.chn;
    }

    public String akg() {
        return this.cho;
    }

    public String akh() {
        return this.chp;
    }

    public String aki() {
        return this.chq;
    }

    public int akj() {
        return this.chr;
    }

    public String akk() {
        return this.chs;
    }

    public ArrayList<e> akl() {
        return this.chJ;
    }

    public a akm() {
        return this.chN;
    }

    public ArrayList<e> akn() {
        return this.chK;
    }

    public ArrayList<e> ako() {
        return this.chL;
    }

    public boolean akp() {
        return this.chu;
    }

    public String akq() {
        return this.chE;
    }

    public String getContent() {
        return this.content;
    }

    public int akr() {
        return this.chF;
    }

    public boolean aks() {
        return this.chG;
    }

    public int akt() {
        return this.chH;
    }

    public int aku() {
        return this.chI;
    }

    public void b(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.chM.get(signData.getForumId())) != null) {
            eVar.ix(1);
            eVar.iy(signData.getCountSignNum());
            eVar.iA(signData.getBonusPoint());
            eVar.eR(true);
            eVar.eS(false);
            eVar.eT(false);
            a(eVar);
            akv();
            eQ(true);
        }
    }

    private void a(e eVar) {
        if (eVar.aky() >= this.level) {
            this.chx++;
            this.chy--;
        } else {
            this.chv++;
            this.chw--;
        }
        this.chM.remove(String.valueOf(eVar.getForumId()));
        this.chL.remove(eVar);
        if (eVar.akz() + eVar.akE() >= eVar.akA()) {
            eVar.iz(eVar.aky() + 1);
            eVar.eU(true);
            if (eVar.aky() == this.level) {
                this.chx++;
                this.chv--;
            }
        }
        this.chK.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.akE(), -1);
    }

    private void akv() {
        if (this.chu) {
            if (this.chy + this.chw <= 0) {
                this.chG = true;
            } else {
                this.chG = false;
            }
        } else if (this.chy <= 0) {
            this.chG = true;
        } else {
            this.chG = false;
        }
    }

    public void a(s sVar) {
        this.chH = 0;
        this.chI = 0;
        ArrayList<t> akK = sVar.akK();
        int size = akK.size();
        for (int i = 0; i < size; i++) {
            t tVar = akK.get(i);
            e eVar = this.chM.get(new StringBuilder(String.valueOf(tVar.getForumId())).toString());
            if (eVar != null) {
                if (tVar.getSigned() != 0) {
                    this.chH++;
                    eVar.ix(1);
                    eVar.iy(tVar.akN());
                    eVar.iA(tVar.getCurScore());
                    eVar.eR(true);
                    eVar.eS(false);
                    eVar.eT(false);
                    a(eVar);
                } else {
                    this.chI++;
                    eVar.eR(false);
                    eVar.eS(true);
                    eVar.eT(false);
                    eVar.setErrorMsg(tVar.akm().getUserMsg());
                }
            }
        }
        akv();
        eQ(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.chN.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.chm = jSONObject.optString("text_pre");
            this.chn = jSONObject.optString("text_color");
            this.cho = jSONObject.optString("text_mid");
            this.chp = jSONObject.optString("text_suf");
            this.chq = jSONObject.optString("num_notice");
            this.chr = jSONObject.optInt("show_dialog");
            this.chs = jSONObject.optString("sign_notice");
            this.cht = jSONObject.optInt("valid", 0);
            this.chO = jSONObject.optInt("sign_max_num", 50);
            this.chD = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.chE = jSONObject.optString("button_content");
            if (this.chD == 1) {
                this.chu = true;
            } else {
                this.chu = false;
            }
            this.chA = String.valueOf(this.level) + this.title;
            this.chz = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(com.baidu.tieba.t.sign_all_forum_tip);
            ae.cjh = this.chO;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), ae.cjh);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.akw() == 0) {
                            if (this.cht == 0) {
                                if (this.chu) {
                                    eVar.eS(true);
                                } else if (eVar.aky() > this.level) {
                                    eVar.eS(true);
                                }
                            }
                            if (eVar.aky() >= this.level) {
                                this.chy++;
                            } else {
                                this.chw++;
                            }
                            this.chL.add(eVar);
                            this.chM.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.aky() >= this.level) {
                                this.chx++;
                            } else {
                                this.chv++;
                            }
                            this.chK.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.akE(), -1);
                        }
                        this.chJ.add(eVar);
                        Collections.sort(this.chJ, new d(this));
                    }
                }
            }
            eQ(false);
        }
    }

    private void eQ(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.chJ.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.chJ.removeAll(arrayList);
        }
        if (this.chy + this.chx > 0) {
            if (this.chx > 0) {
                this.chC = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.t.signallforum_res, Integer.valueOf(this.chx), Integer.valueOf(this.chy));
            } else {
                this.chC = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.t.signallforum_count, Integer.valueOf(this.chy + this.chx));
            }
            if (this.chJ.size() > 0) {
                this.chJ.add(0, new b(this.chA, this.chC));
            }
        }
        if (this.chw + this.chv > 0) {
            if (this.chv > 0) {
                this.chB = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.t.signallforum_res, Integer.valueOf(this.chv), Integer.valueOf(this.chw));
            } else {
                this.chB = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.t.signallforum_count, Integer.valueOf(this.chw + this.chv));
            }
            if (this.chy + this.chx > 0) {
                if (this.chJ.size() > this.chy + this.chx + 1) {
                    this.chJ.add(this.chy + this.chx + 1, new b(this.chz, this.chB));
                }
            } else if (this.chJ.size() > 0) {
                this.chJ.add(0, new b(this.chz, this.chB));
            }
        }
        if (this.chJ.size() <= 0) {
            this.chF = 3;
        } else if (this.chu) {
            if (this.cht == 1 && this.chL.size() > 0) {
                this.chF = 0;
            } else {
                this.chF = 2;
            }
        } else if (this.cht == 1 && this.chy > 0) {
            this.chF = 0;
        } else if (this.chy + this.chx > 0) {
            this.chF = 2;
        } else if (this.chy + this.chx <= 0) {
            this.chF = 3;
        }
    }
}
