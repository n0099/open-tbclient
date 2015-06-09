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
    private String chD;
    private int chE;
    private String chF;
    private int chG;
    private boolean chH;
    private int chI;
    private int chJ;
    private ArrayList<e> chK = new ArrayList<>();
    private ArrayList<e> chL = new ArrayList<>();
    private ArrayList<e> chM = new ArrayList<>();
    private HashMap<String, e> chN = new HashMap<>();
    private a chO = new a();
    private int chP;
    private String chn;
    private String cho;
    private String chp;
    private String chq;
    private String chr;
    private int chs;
    private String cht;
    private int chu;
    private boolean chv;
    private int chw;
    private int chx;
    private int chy;
    private int chz;
    private String content;
    private int level;
    private String title;

    public int getLevel() {
        return this.level;
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

    public String akj() {
        return this.chr;
    }

    public int akk() {
        return this.chs;
    }

    public String akl() {
        return this.cht;
    }

    public ArrayList<e> akm() {
        return this.chK;
    }

    public a akn() {
        return this.chO;
    }

    public ArrayList<e> ako() {
        return this.chL;
    }

    public ArrayList<e> akp() {
        return this.chM;
    }

    public boolean akq() {
        return this.chv;
    }

    public String akr() {
        return this.chF;
    }

    public String getContent() {
        return this.content;
    }

    public int aks() {
        return this.chG;
    }

    public boolean akt() {
        return this.chH;
    }

    public int aku() {
        return this.chI;
    }

    public int akv() {
        return this.chJ;
    }

    public void b(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.chN.get(signData.getForumId())) != null) {
            eVar.ix(1);
            eVar.iy(signData.getCountSignNum());
            eVar.iA(signData.getBonusPoint());
            eVar.eR(true);
            eVar.eS(false);
            eVar.eT(false);
            a(eVar);
            akw();
            eQ(true);
        }
    }

    private void a(e eVar) {
        if (eVar.akz() >= this.level) {
            this.chy++;
            this.chz--;
        } else {
            this.chw++;
            this.chx--;
        }
        this.chN.remove(String.valueOf(eVar.getForumId()));
        this.chM.remove(eVar);
        if (eVar.akA() + eVar.akF() >= eVar.akB()) {
            eVar.iz(eVar.akz() + 1);
            eVar.eU(true);
            if (eVar.akz() == this.level) {
                this.chy++;
                this.chw--;
            }
        }
        this.chL.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.akF(), -1);
    }

    private void akw() {
        if (this.chv) {
            if (this.chz + this.chx <= 0) {
                this.chH = true;
            } else {
                this.chH = false;
            }
        } else if (this.chz <= 0) {
            this.chH = true;
        } else {
            this.chH = false;
        }
    }

    public void a(s sVar) {
        this.chI = 0;
        this.chJ = 0;
        ArrayList<t> akL = sVar.akL();
        int size = akL.size();
        for (int i = 0; i < size; i++) {
            t tVar = akL.get(i);
            e eVar = this.chN.get(new StringBuilder(String.valueOf(tVar.getForumId())).toString());
            if (eVar != null) {
                if (tVar.getSigned() != 0) {
                    this.chI++;
                    eVar.ix(1);
                    eVar.iy(tVar.akO());
                    eVar.iA(tVar.getCurScore());
                    eVar.eR(true);
                    eVar.eS(false);
                    eVar.eT(false);
                    a(eVar);
                } else {
                    this.chJ++;
                    eVar.eR(false);
                    eVar.eS(true);
                    eVar.eT(false);
                    eVar.setErrorMsg(tVar.akn().getUserMsg());
                }
            }
        }
        akw();
        eQ(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.chO.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.chn = jSONObject.optString("text_pre");
            this.cho = jSONObject.optString("text_color");
            this.chp = jSONObject.optString("text_mid");
            this.chq = jSONObject.optString("text_suf");
            this.chr = jSONObject.optString("num_notice");
            this.chs = jSONObject.optInt("show_dialog");
            this.cht = jSONObject.optString("sign_notice");
            this.chu = jSONObject.optInt("valid", 0);
            this.chP = jSONObject.optInt("sign_max_num", 50);
            this.chE = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.chF = jSONObject.optString("button_content");
            if (this.chE == 1) {
                this.chv = true;
            } else {
                this.chv = false;
            }
            this.chB = String.valueOf(this.level) + this.title;
            this.chA = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(com.baidu.tieba.t.sign_all_forum_tip);
            ae.cji = this.chP;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), ae.cji);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.akx() == 0) {
                            if (this.chu == 0) {
                                if (this.chv) {
                                    eVar.eS(true);
                                } else if (eVar.akz() > this.level) {
                                    eVar.eS(true);
                                }
                            }
                            if (eVar.akz() >= this.level) {
                                this.chz++;
                            } else {
                                this.chx++;
                            }
                            this.chM.add(eVar);
                            this.chN.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.akz() >= this.level) {
                                this.chy++;
                            } else {
                                this.chw++;
                            }
                            this.chL.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.akF(), -1);
                        }
                        this.chK.add(eVar);
                        Collections.sort(this.chK, new d(this));
                    }
                }
            }
            eQ(false);
        }
    }

    private void eQ(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.chK.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.chK.removeAll(arrayList);
        }
        if (this.chz + this.chy > 0) {
            if (this.chy > 0) {
                this.chD = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.t.signallforum_res, Integer.valueOf(this.chy), Integer.valueOf(this.chz));
            } else {
                this.chD = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.t.signallforum_count, Integer.valueOf(this.chz + this.chy));
            }
            if (this.chK.size() > 0) {
                this.chK.add(0, new b(this.chB, this.chD));
            }
        }
        if (this.chx + this.chw > 0) {
            if (this.chw > 0) {
                this.chC = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.t.signallforum_res, Integer.valueOf(this.chw), Integer.valueOf(this.chx));
            } else {
                this.chC = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.t.signallforum_count, Integer.valueOf(this.chx + this.chw));
            }
            if (this.chz + this.chy > 0) {
                if (this.chK.size() > this.chz + this.chy + 1) {
                    this.chK.add(this.chz + this.chy + 1, new b(this.chA, this.chC));
                }
            } else if (this.chK.size() > 0) {
                this.chK.add(0, new b(this.chA, this.chC));
            }
        }
        if (this.chK.size() <= 0) {
            this.chG = 3;
        } else if (this.chv) {
            if (this.chu == 1 && this.chM.size() > 0) {
                this.chG = 0;
            } else {
                this.chG = 2;
            }
        } else if (this.chu == 1 && this.chz > 0) {
            this.chG = 0;
        } else if (this.chz + this.chy > 0) {
            this.chG = 2;
        } else if (this.chz + this.chy <= 0) {
            this.chG = 3;
        }
    }
}
