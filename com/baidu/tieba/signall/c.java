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
    private String ccT;
    private String ccU;
    private String ccV;
    private String ccW;
    private String ccX;
    private int ccY;
    private String ccZ;
    private int cda;
    private boolean cdb;
    private int cdc;
    private int cdd;
    private int cde;
    private int cdf;
    private String cdg;
    private String cdh;
    private String cdi;
    private String cdj;
    private int cdk;
    private String cdl;
    private int cdm;
    private boolean cdn;
    private int cdo;
    private int cdp;
    private ArrayList<e> cdq = new ArrayList<>();
    private ArrayList<e> cdr = new ArrayList<>();
    private ArrayList<e> cds = new ArrayList<>();
    private HashMap<String, e> cdt = new HashMap<>();
    private a cdu = new a();
    private int cdv;
    private String content;
    private int level;
    private String title;

    public int getLevel() {
        return this.level;
    }

    public String aif() {
        return this.ccT;
    }

    public String aig() {
        return this.ccU;
    }

    public String aih() {
        return this.ccV;
    }

    public String aii() {
        return this.ccW;
    }

    public String aij() {
        return this.ccX;
    }

    public int aik() {
        return this.ccY;
    }

    public String ail() {
        return this.ccZ;
    }

    public ArrayList<e> aim() {
        return this.cdq;
    }

    public a ain() {
        return this.cdu;
    }

    public ArrayList<e> aio() {
        return this.cdr;
    }

    public ArrayList<e> aip() {
        return this.cds;
    }

    public boolean aiq() {
        return this.cdb;
    }

    public String air() {
        return this.cdl;
    }

    public String getContent() {
        return this.content;
    }

    public int ais() {
        return this.cdm;
    }

    public boolean ait() {
        return this.cdn;
    }

    public int aiu() {
        return this.cdo;
    }

    public int aiv() {
        return this.cdp;
    }

    public void b(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.cdt.get(signData.getForumId())) != null) {
            eVar.hY(1);
            eVar.hZ(signData.getCountSignNum());
            eVar.ib(signData.getBonusPoint());
            eVar.ez(true);
            eVar.eA(false);
            eVar.eB(false);
            a(eVar);
            aiw();
            ey(true);
        }
    }

    private void a(e eVar) {
        if (eVar.aiz() >= this.level) {
            this.cde++;
            this.cdf--;
        } else {
            this.cdc++;
            this.cdd--;
        }
        this.cdt.remove(String.valueOf(eVar.getForumId()));
        this.cds.remove(eVar);
        if (eVar.aiA() + eVar.aiF() >= eVar.aiB()) {
            eVar.ia(eVar.aiz() + 1);
            eVar.eC(true);
            if (eVar.aiz() == this.level) {
                this.cde++;
                this.cdc--;
            }
        }
        this.cdr.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aiF(), -1);
    }

    private void aiw() {
        if (this.cdb) {
            if (this.cdf + this.cdd <= 0) {
                this.cdn = true;
            } else {
                this.cdn = false;
            }
        } else if (this.cdf <= 0) {
            this.cdn = true;
        } else {
            this.cdn = false;
        }
    }

    public void a(s sVar) {
        this.cdo = 0;
        this.cdp = 0;
        ArrayList<t> aiL = sVar.aiL();
        int size = aiL.size();
        for (int i = 0; i < size; i++) {
            t tVar = aiL.get(i);
            e eVar = this.cdt.get(new StringBuilder(String.valueOf(tVar.getForumId())).toString());
            if (eVar != null) {
                if (tVar.getSigned() != 0) {
                    this.cdo++;
                    eVar.hY(1);
                    eVar.hZ(tVar.aiO());
                    eVar.ib(tVar.getCurScore());
                    eVar.ez(true);
                    eVar.eA(false);
                    eVar.eB(false);
                    a(eVar);
                } else {
                    this.cdp++;
                    eVar.ez(false);
                    eVar.eA(true);
                    eVar.eB(false);
                    eVar.setErrorMsg(tVar.ain().getUserMsg());
                }
            }
        }
        aiw();
        ey(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cdu.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.ccT = jSONObject.optString("text_pre");
            this.ccU = jSONObject.optString("text_color");
            this.ccV = jSONObject.optString("text_mid");
            this.ccW = jSONObject.optString("text_suf");
            this.ccX = jSONObject.optString("num_notice");
            this.ccY = jSONObject.optInt("show_dialog");
            this.ccZ = jSONObject.optString("sign_notice");
            this.cda = jSONObject.optInt("valid", 0);
            this.cdv = jSONObject.optInt("sign_max_num", 50);
            this.cdk = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.cdl = jSONObject.optString("button_content");
            if (this.cdk == 1) {
                this.cdb = true;
            } else {
                this.cdb = false;
            }
            this.cdh = String.valueOf(this.level) + this.title;
            this.cdg = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(com.baidu.tieba.y.sign_all_forum_tip);
            ae.ceO = this.cdv;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), ae.ceO);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.aix() == 0) {
                            if (this.cda == 0) {
                                if (this.cdb) {
                                    eVar.eA(true);
                                } else if (eVar.aiz() > this.level) {
                                    eVar.eA(true);
                                }
                            }
                            if (eVar.aiz() >= this.level) {
                                this.cdf++;
                            } else {
                                this.cdd++;
                            }
                            this.cds.add(eVar);
                            this.cdt.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.aiz() >= this.level) {
                                this.cde++;
                            } else {
                                this.cdc++;
                            }
                            this.cdr.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aiF(), -1);
                        }
                        this.cdq.add(eVar);
                        Collections.sort(this.cdq, new d(this));
                    }
                }
            }
            ey(false);
        }
    }

    private void ey(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.cdq.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.cdq.removeAll(arrayList);
        }
        if (this.cdf + this.cde > 0) {
            if (this.cde > 0) {
                this.cdj = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.y.signallforum_res, Integer.valueOf(this.cde), Integer.valueOf(this.cdf));
            } else {
                this.cdj = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.y.signallforum_count, Integer.valueOf(this.cdf + this.cde));
            }
            if (this.cdq.size() > 0) {
                this.cdq.add(0, new b(this.cdh, this.cdj));
            }
        }
        if (this.cdd + this.cdc > 0) {
            if (this.cdc > 0) {
                this.cdi = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.y.signallforum_res, Integer.valueOf(this.cdc), Integer.valueOf(this.cdd));
            } else {
                this.cdi = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.y.signallforum_count, Integer.valueOf(this.cdd + this.cdc));
            }
            if (this.cdf + this.cde > 0) {
                if (this.cdq.size() > this.cdf + this.cde + 1) {
                    this.cdq.add(this.cdf + this.cde + 1, new b(this.cdg, this.cdi));
                }
            } else if (this.cdq.size() > 0) {
                this.cdq.add(0, new b(this.cdg, this.cdi));
            }
        }
        if (this.cdq.size() <= 0) {
            this.cdm = 3;
        } else if (this.cdb) {
            if (this.cda == 1 && this.cds.size() > 0) {
                this.cdm = 0;
            } else {
                this.cdm = 2;
            }
        } else if (this.cda == 1 && this.cdf > 0) {
            this.cdm = 0;
        } else if (this.cdf + this.cde > 0) {
            this.cdm = 2;
        } else if (this.cdf + this.cde <= 0) {
            this.cdm = 3;
        }
    }
}
