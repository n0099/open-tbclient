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
public class b {
    private int bOA;
    private int bOB;
    private String bOC;
    private String bOD;
    private String bOE;
    private String bOF;
    private int bOG;
    private String bOH;
    private int bOI;
    private boolean bOJ;
    private int bOK;
    private int bOL;
    private ArrayList<d> bOM = new ArrayList<>();
    private ArrayList<d> bON = new ArrayList<>();
    private ArrayList<d> bOO = new ArrayList<>();
    private HashMap<String, d> bOP = new HashMap<>();
    private com.baidu.tieba.home.u bOQ = new com.baidu.tieba.home.u();
    private int bOR;
    private String bOp;
    private String bOq;
    private String bOr;
    private String bOs;
    private String bOt;
    private int bOu;
    private String bOv;
    private int bOw;
    private boolean bOx;
    private int bOy;
    private int bOz;
    private String content;
    private int level;
    private String title;

    public int getLevel() {
        return this.level;
    }

    public String acO() {
        return this.bOp;
    }

    public String acP() {
        return this.bOq;
    }

    public String acQ() {
        return this.bOr;
    }

    public String acR() {
        return this.bOs;
    }

    public String acS() {
        return this.bOt;
    }

    public int acT() {
        return this.bOu;
    }

    public String acU() {
        return this.bOv;
    }

    public ArrayList<d> acV() {
        return this.bOM;
    }

    public com.baidu.tieba.home.u acW() {
        return this.bOQ;
    }

    public ArrayList<d> acX() {
        return this.bON;
    }

    public ArrayList<d> acY() {
        return this.bOO;
    }

    public boolean acZ() {
        return this.bOx;
    }

    public String ada() {
        return this.bOH;
    }

    public String getContent() {
        return this.content;
    }

    public int adb() {
        return this.bOI;
    }

    public boolean adc() {
        return this.bOJ;
    }

    public int add() {
        return this.bOK;
    }

    public int ade() {
        return this.bOL;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.bOP.get(signData.getForumId())) != null) {
            dVar.ht(1);
            dVar.hu(signData.getCountSignNum());
            dVar.hw(signData.getBonusPoint());
            dVar.ek(true);
            dVar.el(false);
            dVar.em(false);
            a(dVar);
            adf();
            ej(true);
        }
    }

    private void a(d dVar) {
        if (dVar.adi() >= this.level) {
            this.bOA++;
            this.bOB--;
        } else {
            this.bOy++;
            this.bOz--;
        }
        this.bOP.remove(String.valueOf(dVar.getForumId()));
        this.bOO.remove(dVar);
        if (dVar.adj() + dVar.ado() >= dVar.adk()) {
            dVar.hv(dVar.adi() + 1);
            dVar.en(true);
            if (dVar.adi() == this.level) {
                this.bOA++;
                this.bOy--;
            }
        }
        this.bON.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.ado(), -1);
    }

    private void adf() {
        if (this.bOx) {
            if (this.bOB + this.bOz <= 0) {
                this.bOJ = true;
            } else {
                this.bOJ = false;
            }
        } else if (this.bOB <= 0) {
            this.bOJ = true;
        } else {
            this.bOJ = false;
        }
    }

    public void a(s sVar) {
        this.bOK = 0;
        this.bOL = 0;
        ArrayList<t> adv = sVar.adv();
        int size = adv.size();
        for (int i = 0; i < size; i++) {
            t tVar = adv.get(i);
            d dVar = this.bOP.get(new StringBuilder(String.valueOf(tVar.getForumId())).toString());
            if (dVar != null) {
                if (tVar.getSigned() != 0) {
                    this.bOK++;
                    dVar.ht(1);
                    dVar.hu(tVar.ady());
                    dVar.hw(tVar.getCurScore());
                    dVar.ek(true);
                    dVar.el(false);
                    dVar.em(false);
                    a(dVar);
                } else {
                    this.bOL++;
                    dVar.ek(false);
                    dVar.el(true);
                    dVar.em(false);
                    dVar.setErrorMsg(tVar.acW().getUserMsg());
                }
            }
        }
        adf();
        ej(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bOQ.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.bOp = jSONObject.optString("text_pre");
            this.bOq = jSONObject.optString("text_color");
            this.bOr = jSONObject.optString("text_mid");
            this.bOs = jSONObject.optString("text_suf");
            this.bOt = jSONObject.optString("num_notice");
            this.bOu = jSONObject.optInt("show_dialog");
            this.bOv = jSONObject.optString("sign_notice");
            this.bOw = jSONObject.optInt("valid", 0);
            this.bOR = jSONObject.optInt("sign_max_num", 50);
            this.bOG = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.bOH = jSONObject.optString("button_content");
            if (this.bOG == 1) {
                this.bOx = true;
            } else {
                this.bOx = false;
            }
            this.bOD = String.valueOf(this.level) + this.title;
            this.bOC = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.sign_all_forum_tip);
            ad.bQi = this.bOR;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), ad.bQi);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.adg() == 0) {
                            if (this.bOw == 0) {
                                if (this.bOx) {
                                    dVar.el(true);
                                } else if (dVar.adi() > this.level) {
                                    dVar.el(true);
                                }
                            }
                            if (dVar.adi() >= this.level) {
                                this.bOB++;
                            } else {
                                this.bOz++;
                            }
                            this.bOO.add(dVar);
                            this.bOP.put(new StringBuilder(String.valueOf(dVar.getForumId())).toString(), dVar);
                        } else {
                            if (dVar.adi() >= this.level) {
                                this.bOA++;
                            } else {
                                this.bOy++;
                            }
                            this.bON.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.ado(), -1);
                        }
                        this.bOM.add(dVar);
                        Collections.sort(this.bOM, new c(this));
                    }
                }
            }
            ej(false);
        }
    }

    private void ej(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.bOM.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof a) {
                    arrayList.add(next);
                }
            }
            this.bOM.removeAll(arrayList);
        }
        if (this.bOB + this.bOA > 0) {
            if (this.bOA > 0) {
                this.bOF = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.signallforum_res, Integer.valueOf(this.bOA), Integer.valueOf(this.bOB));
            } else {
                this.bOF = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.signallforum_count, Integer.valueOf(this.bOB + this.bOA));
            }
            if (this.bOM.size() > 0) {
                this.bOM.add(0, new a(this.bOD, this.bOF));
            }
        }
        if (this.bOz + this.bOy > 0) {
            if (this.bOy > 0) {
                this.bOE = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.signallforum_res, Integer.valueOf(this.bOy), Integer.valueOf(this.bOz));
            } else {
                this.bOE = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.signallforum_count, Integer.valueOf(this.bOz + this.bOy));
            }
            if (this.bOB + this.bOA > 0) {
                if (this.bOM.size() > this.bOB + this.bOA + 1) {
                    this.bOM.add(this.bOB + this.bOA + 1, new a(this.bOC, this.bOE));
                }
            } else if (this.bOM.size() > 0) {
                this.bOM.add(0, new a(this.bOC, this.bOE));
            }
        }
        if (this.bOM.size() <= 0) {
            this.bOI = 3;
        } else if (this.bOx) {
            if (this.bOw == 1 && this.bOO.size() > 0) {
                this.bOI = 0;
            } else {
                this.bOI = 2;
            }
        } else if (this.bOw == 1 && this.bOB > 0) {
            this.bOI = 0;
        } else if (this.bOB + this.bOA > 0) {
            this.bOI = 2;
        } else if (this.bOB + this.bOA <= 0) {
            this.bOI = 3;
        }
    }
}
