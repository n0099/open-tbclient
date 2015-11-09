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
    private String cQP;
    private String cQQ;
    private String cQR;
    private String cQS;
    private String cQT;
    private int cQU;
    private String cQV;
    private int cQW;
    private boolean cQX;
    private int cQY;
    private int cQZ;
    private int cRa;
    private int cRb;
    private String cRc;
    private String cRd;
    private String cRe;
    private String cRf;
    private int cRg;
    private String cRh;
    private int cRi;
    private boolean cRj;
    private int cRk;
    private int cRl;
    private ArrayList<e> cRm = new ArrayList<>();
    private ArrayList<e> cRn = new ArrayList<>();
    private ArrayList<e> cRo = new ArrayList<>();
    private HashMap<String, e> cRp = new HashMap<>();
    private a cRq = new a();
    private int cRr;
    private String content;
    private int level;
    private String title;

    public int getLevel() {
        return this.level;
    }

    public String atM() {
        return this.cQP;
    }

    public String aiv() {
        return this.cQQ;
    }

    public String atN() {
        return this.cQR;
    }

    public String atO() {
        return this.cQS;
    }

    public String atP() {
        return this.cQT;
    }

    public int atQ() {
        return this.cQU;
    }

    public String atR() {
        return this.cQV;
    }

    public ArrayList<e> atS() {
        return this.cRm;
    }

    public a atT() {
        return this.cRq;
    }

    public ArrayList<e> atU() {
        return this.cRn;
    }

    public ArrayList<e> atV() {
        return this.cRo;
    }

    public boolean atW() {
        return this.cQX;
    }

    public String atX() {
        return this.cRh;
    }

    public String getContent() {
        return this.content;
    }

    public int atY() {
        return this.cRi;
    }

    public boolean atZ() {
        return this.cRj;
    }

    public int aua() {
        return this.cRk;
    }

    public int aub() {
        return this.cRl;
    }

    public void b(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.cRp.get(signData.getForumId())) != null) {
            eVar.kR(1);
            eVar.kS(signData.getCountSignNum());
            eVar.kU(signData.getBonusPoint());
            eVar.gj(true);
            eVar.gk(false);
            eVar.gl(false);
            a(eVar);
            auc();
            gi(true);
        }
    }

    private void a(e eVar) {
        if (eVar.auf() >= this.level) {
            this.cRa++;
            this.cRb--;
        } else {
            this.cQY++;
            this.cQZ--;
        }
        this.cRp.remove(String.valueOf(eVar.getForumId()));
        this.cRo.remove(eVar);
        if (eVar.aug() + eVar.aul() >= eVar.auh()) {
            eVar.kT(eVar.auf() + 1);
            eVar.gm(true);
            if (eVar.auf() == this.level) {
                this.cRa++;
                this.cQY--;
            }
        }
        this.cRn.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aul(), -1);
    }

    private void auc() {
        if (this.cQX) {
            if (this.cRb + this.cQZ <= 0) {
                this.cRj = true;
            } else {
                this.cRj = false;
            }
        } else if (this.cRb <= 0) {
            this.cRj = true;
        } else {
            this.cRj = false;
        }
    }

    public void a(p pVar) {
        this.cRk = 0;
        this.cRl = 0;
        ArrayList<q> aur = pVar.aur();
        int size = aur.size();
        for (int i = 0; i < size; i++) {
            q qVar = aur.get(i);
            e eVar = this.cRp.get(new StringBuilder(String.valueOf(qVar.getForumId())).toString());
            if (eVar != null) {
                if (qVar.getSigned() != 0) {
                    this.cRk++;
                    eVar.kR(1);
                    eVar.kS(qVar.auu());
                    eVar.kU(qVar.getCurScore());
                    eVar.gj(true);
                    eVar.gk(false);
                    eVar.gl(false);
                    a(eVar);
                } else {
                    this.cRl++;
                    eVar.gj(false);
                    eVar.gk(true);
                    eVar.gl(false);
                    eVar.setErrorMsg(qVar.atT().getUserMsg());
                }
            }
        }
        auc();
        gi(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cRq.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.cQP = jSONObject.optString("text_pre");
            this.cQQ = jSONObject.optString("text_color");
            this.cQR = jSONObject.optString("text_mid");
            this.cQS = jSONObject.optString("text_suf");
            this.cQT = jSONObject.optString("num_notice");
            this.cQU = jSONObject.optInt("show_dialog");
            this.cQV = jSONObject.optString("sign_notice");
            this.cQW = jSONObject.optInt("valid", 0);
            this.cRr = jSONObject.optInt("sign_max_num", 50);
            this.cRg = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.cRh = jSONObject.optString("button_content");
            if (this.cRg == 1) {
                this.cQX = true;
            } else {
                this.cQX = false;
            }
            this.cRd = String.valueOf(this.level) + this.title;
            this.cRc = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(i.h.sign_all_forum_tip);
            z.cSI = this.cRr;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), z.cSI);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.aud() == 0) {
                            if (this.cQW == 0) {
                                if (this.cQX) {
                                    eVar.gk(true);
                                } else if (eVar.auf() > this.level) {
                                    eVar.gk(true);
                                }
                            }
                            if (eVar.auf() >= this.level) {
                                this.cRb++;
                            } else {
                                this.cQZ++;
                            }
                            this.cRo.add(eVar);
                            this.cRp.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.auf() >= this.level) {
                                this.cRa++;
                            } else {
                                this.cQY++;
                            }
                            this.cRn.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aul(), -1);
                        }
                        this.cRm.add(eVar);
                        Collections.sort(this.cRm, new d(this));
                    }
                }
            }
            gi(false);
        }
    }

    private void gi(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.cRm.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.cRm.removeAll(arrayList);
        }
        if (this.cRb + this.cRa > 0) {
            if (this.cRa > 0) {
                this.cRf = TbadkApplication.getInst().getContext().getString(i.h.signallforum_res, Integer.valueOf(this.cRa), Integer.valueOf(this.cRb));
            } else {
                this.cRf = TbadkApplication.getInst().getContext().getString(i.h.signallforum_count, Integer.valueOf(this.cRb + this.cRa));
            }
            if (this.cRm.size() > 0) {
                this.cRm.add(0, new b(this.cRd, this.cRf));
            }
        }
        if (this.cQZ + this.cQY > 0) {
            if (this.cQY > 0) {
                this.cRe = TbadkApplication.getInst().getContext().getString(i.h.signallforum_res, Integer.valueOf(this.cQY), Integer.valueOf(this.cQZ));
            } else {
                this.cRe = TbadkApplication.getInst().getContext().getString(i.h.signallforum_count, Integer.valueOf(this.cQZ + this.cQY));
            }
            if (this.cRb + this.cRa > 0) {
                if (this.cRm.size() > this.cRb + this.cRa + 1) {
                    this.cRm.add(this.cRb + this.cRa + 1, new b(this.cRc, this.cRe));
                }
            } else if (this.cRm.size() > 0) {
                this.cRm.add(0, new b(this.cRc, this.cRe));
            }
        }
        if (this.cRm.size() <= 0) {
            this.cRi = 3;
        } else if (this.cQX) {
            if (this.cQW == 1 && this.cRo.size() > 0) {
                this.cRi = 0;
            } else {
                this.cRi = 2;
            }
        } else if (this.cQW == 1 && this.cRb > 0) {
            this.cRi = 0;
        } else if (this.cRb + this.cRa > 0) {
            this.cRi = 2;
        } else if (this.cRb + this.cRa <= 0) {
            this.cRi = 3;
        }
    }
}
