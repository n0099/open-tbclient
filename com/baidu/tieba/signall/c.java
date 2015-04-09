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
    private String cdA;
    private int cdB;
    private boolean cdC;
    private int cdD;
    private int cdE;
    private ArrayList<e> cdF = new ArrayList<>();
    private ArrayList<e> cdG = new ArrayList<>();
    private ArrayList<e> cdH = new ArrayList<>();
    private HashMap<String, e> cdI = new HashMap<>();
    private a cdJ = new a();
    private int cdK;
    private String cdi;
    private String cdj;
    private String cdk;
    private String cdl;
    private String cdm;
    private int cdn;
    private String cdo;
    private int cdp;
    private boolean cdq;
    private int cdr;
    private int cds;
    private int cdt;
    private int cdu;
    private String cdv;
    private String cdw;
    private String cdx;
    private String cdy;
    private int cdz;
    private String content;
    private int level;
    private String title;

    public int getLevel() {
        return this.level;
    }

    public String aiu() {
        return this.cdi;
    }

    public String aiv() {
        return this.cdj;
    }

    public String aiw() {
        return this.cdk;
    }

    public String aix() {
        return this.cdl;
    }

    public String aiy() {
        return this.cdm;
    }

    public int aiz() {
        return this.cdn;
    }

    public String aiA() {
        return this.cdo;
    }

    public ArrayList<e> aiB() {
        return this.cdF;
    }

    public a aiC() {
        return this.cdJ;
    }

    public ArrayList<e> aiD() {
        return this.cdG;
    }

    public ArrayList<e> aiE() {
        return this.cdH;
    }

    public boolean aiF() {
        return this.cdq;
    }

    public String aiG() {
        return this.cdA;
    }

    public String getContent() {
        return this.content;
    }

    public int aiH() {
        return this.cdB;
    }

    public boolean aiI() {
        return this.cdC;
    }

    public int aiJ() {
        return this.cdD;
    }

    public int aiK() {
        return this.cdE;
    }

    public void b(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.cdI.get(signData.getForumId())) != null) {
            eVar.ib(1);
            eVar.ic(signData.getCountSignNum());
            eVar.ie(signData.getBonusPoint());
            eVar.ex(true);
            eVar.ey(false);
            eVar.ez(false);
            a(eVar);
            aiL();
            ew(true);
        }
    }

    private void a(e eVar) {
        if (eVar.aiO() >= this.level) {
            this.cdt++;
            this.cdu--;
        } else {
            this.cdr++;
            this.cds--;
        }
        this.cdI.remove(String.valueOf(eVar.getForumId()));
        this.cdH.remove(eVar);
        if (eVar.aiP() + eVar.aiU() >= eVar.aiQ()) {
            eVar.id(eVar.aiO() + 1);
            eVar.eA(true);
            if (eVar.aiO() == this.level) {
                this.cdt++;
                this.cdr--;
            }
        }
        this.cdG.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aiU(), -1);
    }

    private void aiL() {
        if (this.cdq) {
            if (this.cdu + this.cds <= 0) {
                this.cdC = true;
            } else {
                this.cdC = false;
            }
        } else if (this.cdu <= 0) {
            this.cdC = true;
        } else {
            this.cdC = false;
        }
    }

    public void a(s sVar) {
        this.cdD = 0;
        this.cdE = 0;
        ArrayList<t> aja = sVar.aja();
        int size = aja.size();
        for (int i = 0; i < size; i++) {
            t tVar = aja.get(i);
            e eVar = this.cdI.get(new StringBuilder(String.valueOf(tVar.getForumId())).toString());
            if (eVar != null) {
                if (tVar.getSigned() != 0) {
                    this.cdD++;
                    eVar.ib(1);
                    eVar.ic(tVar.ajd());
                    eVar.ie(tVar.getCurScore());
                    eVar.ex(true);
                    eVar.ey(false);
                    eVar.ez(false);
                    a(eVar);
                } else {
                    this.cdE++;
                    eVar.ex(false);
                    eVar.ey(true);
                    eVar.ez(false);
                    eVar.setErrorMsg(tVar.aiC().getUserMsg());
                }
            }
        }
        aiL();
        ew(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cdJ.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.cdi = jSONObject.optString("text_pre");
            this.cdj = jSONObject.optString("text_color");
            this.cdk = jSONObject.optString("text_mid");
            this.cdl = jSONObject.optString("text_suf");
            this.cdm = jSONObject.optString("num_notice");
            this.cdn = jSONObject.optInt("show_dialog");
            this.cdo = jSONObject.optString("sign_notice");
            this.cdp = jSONObject.optInt("valid", 0);
            this.cdK = jSONObject.optInt("sign_max_num", 50);
            this.cdz = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.cdA = jSONObject.optString("button_content");
            if (this.cdz == 1) {
                this.cdq = true;
            } else {
                this.cdq = false;
            }
            this.cdw = String.valueOf(this.level) + this.title;
            this.cdv = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(com.baidu.tieba.y.sign_all_forum_tip);
            ae.cfd = this.cdK;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), ae.cfd);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.aiM() == 0) {
                            if (this.cdp == 0) {
                                if (this.cdq) {
                                    eVar.ey(true);
                                } else if (eVar.aiO() > this.level) {
                                    eVar.ey(true);
                                }
                            }
                            if (eVar.aiO() >= this.level) {
                                this.cdu++;
                            } else {
                                this.cds++;
                            }
                            this.cdH.add(eVar);
                            this.cdI.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.aiO() >= this.level) {
                                this.cdt++;
                            } else {
                                this.cdr++;
                            }
                            this.cdG.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aiU(), -1);
                        }
                        this.cdF.add(eVar);
                        Collections.sort(this.cdF, new d(this));
                    }
                }
            }
            ew(false);
        }
    }

    private void ew(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.cdF.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.cdF.removeAll(arrayList);
        }
        if (this.cdu + this.cdt > 0) {
            if (this.cdt > 0) {
                this.cdy = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.y.signallforum_res, Integer.valueOf(this.cdt), Integer.valueOf(this.cdu));
            } else {
                this.cdy = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.y.signallforum_count, Integer.valueOf(this.cdu + this.cdt));
            }
            if (this.cdF.size() > 0) {
                this.cdF.add(0, new b(this.cdw, this.cdy));
            }
        }
        if (this.cds + this.cdr > 0) {
            if (this.cdr > 0) {
                this.cdx = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.y.signallforum_res, Integer.valueOf(this.cdr), Integer.valueOf(this.cds));
            } else {
                this.cdx = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.y.signallforum_count, Integer.valueOf(this.cds + this.cdr));
            }
            if (this.cdu + this.cdt > 0) {
                if (this.cdF.size() > this.cdu + this.cdt + 1) {
                    this.cdF.add(this.cdu + this.cdt + 1, new b(this.cdv, this.cdx));
                }
            } else if (this.cdF.size() > 0) {
                this.cdF.add(0, new b(this.cdv, this.cdx));
            }
        }
        if (this.cdF.size() <= 0) {
            this.cdB = 3;
        } else if (this.cdq) {
            if (this.cdp == 1 && this.cdH.size() > 0) {
                this.cdB = 0;
            } else {
                this.cdB = 2;
            }
        } else if (this.cdp == 1 && this.cdu > 0) {
            this.cdB = 0;
        } else if (this.cdu + this.cdt > 0) {
            this.cdB = 2;
        } else if (this.cdu + this.cdt <= 0) {
            this.cdB = 3;
        }
    }
}
