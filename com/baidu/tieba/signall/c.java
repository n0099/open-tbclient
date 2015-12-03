package com.baidu.tieba.signall;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private String content;
    private String dpA;
    private String dpB;
    private String dpC;
    private int dpD;
    private String dpE;
    private int dpF;
    private boolean dpG;
    private int dpH;
    private int dpI;
    private ArrayList<e> dpJ = new ArrayList<>();
    private ArrayList<e> dpK = new ArrayList<>();
    private ArrayList<e> dpL = new ArrayList<>();
    private HashMap<String, e> dpM = new HashMap<>();
    private a dpN = new a();
    private int dpO;
    private String dpm;
    private String dpn;
    private String dpo;
    private String dpp;
    private String dpq;
    private int dpr;
    private String dps;
    private int dpt;
    private boolean dpu;
    private int dpv;
    private int dpw;
    private int dpx;
    private int dpy;
    private String dpz;
    private int level;
    private String title;

    public int getLevel() {
        return this.level;
    }

    public String azo() {
        return this.dpm;
    }

    public String amY() {
        return this.dpn;
    }

    public String azp() {
        return this.dpo;
    }

    public String azq() {
        return this.dpp;
    }

    public String azr() {
        return this.dpq;
    }

    public int azs() {
        return this.dpr;
    }

    public String azt() {
        return this.dps;
    }

    public ArrayList<e> azu() {
        return this.dpJ;
    }

    public a azv() {
        return this.dpN;
    }

    public ArrayList<e> azw() {
        return this.dpK;
    }

    public ArrayList<e> azx() {
        return this.dpL;
    }

    public boolean azy() {
        return this.dpu;
    }

    public String azz() {
        return this.dpE;
    }

    public String getContent() {
        return this.content;
    }

    public int azA() {
        return this.dpF;
    }

    public boolean azB() {
        return this.dpG;
    }

    public int azC() {
        return this.dpH;
    }

    public int azD() {
        return this.dpI;
    }

    public void b(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.dpM.get(signData.getForumId())) != null) {
            eVar.ma(1);
            eVar.mb(signData.getCountSignNum());
            eVar.mc(signData.getBonusPoint());
            eVar.gY(true);
            eVar.gZ(false);
            eVar.ha(false);
            a(eVar);
            azE();
            gX(true);
        }
    }

    private void a(e eVar) {
        if (eVar.RI() >= this.level) {
            this.dpx++;
            this.dpy--;
        } else {
            this.dpv++;
            this.dpw--;
        }
        this.dpM.remove(String.valueOf(eVar.getForumId()));
        this.dpL.remove(eVar);
        if (eVar.azH() + eVar.azM() >= eVar.azI()) {
            eVar.gV(eVar.RI() + 1);
            eVar.hb(true);
            if (eVar.RI() == this.level) {
                this.dpx++;
                this.dpv--;
            }
        }
        this.dpK.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.azM(), -1);
    }

    private void azE() {
        if (this.dpu) {
            if (this.dpy + this.dpw <= 0) {
                this.dpG = true;
            } else {
                this.dpG = false;
            }
        } else if (this.dpy <= 0) {
            this.dpG = true;
        } else {
            this.dpG = false;
        }
    }

    public void a(p pVar) {
        this.dpH = 0;
        this.dpI = 0;
        ArrayList<q> azT = pVar.azT();
        int size = azT.size();
        for (int i = 0; i < size; i++) {
            q qVar = azT.get(i);
            e eVar = this.dpM.get(new StringBuilder(String.valueOf(qVar.getForumId())).toString());
            if (eVar != null) {
                if (qVar.getSigned() != 0) {
                    this.dpH++;
                    eVar.ma(1);
                    eVar.mb(qVar.azW());
                    eVar.mc(qVar.getCurScore());
                    eVar.gY(true);
                    eVar.gZ(false);
                    eVar.ha(false);
                    a(eVar);
                } else {
                    this.dpI++;
                    eVar.gY(false);
                    eVar.gZ(true);
                    eVar.ha(false);
                    eVar.setErrorMsg(qVar.azv().getUserMsg());
                }
            }
        }
        azE();
        gX(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dpN.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.dpm = jSONObject.optString("text_pre");
            this.dpn = jSONObject.optString("text_color");
            this.dpo = jSONObject.optString("text_mid");
            this.dpp = jSONObject.optString("text_suf");
            this.dpq = jSONObject.optString("num_notice");
            this.dpr = jSONObject.optInt("show_dialog");
            this.dps = jSONObject.optString("sign_notice");
            this.dpt = jSONObject.optInt("valid", 0);
            this.dpO = jSONObject.optInt("sign_max_num", 50);
            this.dpD = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.dpE = jSONObject.optString("button_content");
            if (this.dpD == 1) {
                this.dpu = true;
            } else {
                this.dpu = false;
            }
            this.dpA = String.valueOf(this.level) + this.title;
            this.dpz = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(n.i.sign_all_forum_tip);
            z.bAj = this.dpO;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), z.bAj);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.azF() == 0) {
                            if (this.dpt == 0) {
                                if (this.dpu) {
                                    eVar.gZ(true);
                                } else if (eVar.RI() > this.level) {
                                    eVar.gZ(true);
                                }
                            }
                            if (eVar.RI() >= this.level) {
                                this.dpy++;
                            } else {
                                this.dpw++;
                            }
                            this.dpL.add(eVar);
                            this.dpM.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.RI() >= this.level) {
                                this.dpx++;
                            } else {
                                this.dpv++;
                            }
                            this.dpK.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.azM(), -1);
                        }
                        this.dpJ.add(eVar);
                        Collections.sort(this.dpJ, new d(this));
                    }
                }
            }
            gX(false);
        }
    }

    private void gX(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.dpJ.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.dpJ.removeAll(arrayList);
        }
        if (this.dpy + this.dpx > 0) {
            if (this.dpx > 0) {
                this.dpC = TbadkApplication.getInst().getContext().getString(n.i.signallforum_res, Integer.valueOf(this.dpx), Integer.valueOf(this.dpy));
            } else {
                this.dpC = TbadkApplication.getInst().getContext().getString(n.i.signallforum_count, Integer.valueOf(this.dpy + this.dpx));
            }
            if (this.dpJ.size() > 0) {
                this.dpJ.add(0, new b(this.dpA, this.dpC));
            }
        }
        if (this.dpw + this.dpv > 0) {
            if (this.dpv > 0) {
                this.dpB = TbadkApplication.getInst().getContext().getString(n.i.signallforum_res, Integer.valueOf(this.dpv), Integer.valueOf(this.dpw));
            } else {
                this.dpB = TbadkApplication.getInst().getContext().getString(n.i.signallforum_count, Integer.valueOf(this.dpw + this.dpv));
            }
            if (this.dpy + this.dpx > 0) {
                if (this.dpJ.size() > this.dpy + this.dpx + 1) {
                    this.dpJ.add(this.dpy + this.dpx + 1, new b(this.dpz, this.dpB));
                }
            } else if (this.dpJ.size() > 0) {
                this.dpJ.add(0, new b(this.dpz, this.dpB));
            }
        }
        if (this.dpJ.size() <= 0) {
            this.dpF = 3;
        } else if (this.dpu) {
            if (this.dpt == 1 && this.dpL.size() > 0) {
                this.dpF = 0;
            } else {
                this.dpF = 2;
            }
        } else if (this.dpt == 1 && this.dpy > 0) {
            this.dpF = 0;
        } else if (this.dpy + this.dpx > 0) {
            this.dpF = 2;
        } else if (this.dpy + this.dpx <= 0) {
            this.dpF = 3;
        }
    }
}
