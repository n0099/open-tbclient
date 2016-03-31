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
    private int efE;
    private String efc;
    private String efd;
    private String efe;
    private String eff;
    private String efg;
    private int efh;
    private String efi;
    private int efj;
    private boolean efk;
    private int efl;
    private int efm;
    private int efn;
    private int efo;
    private String efp;
    private String efq;
    private String efr;
    private String efs;
    private int eft;
    private String efu;
    private int efv;
    private boolean efw;
    private int efx;
    private int efy;
    private int level;
    private String title;
    private ArrayList<e> efz = new ArrayList<>();
    private ArrayList<e> efA = new ArrayList<>();
    private ArrayList<e> efB = new ArrayList<>();
    private HashMap<String, e> efC = new HashMap<>();
    private a efD = new a();
    private i efF = new i();

    public boolean aPr() {
        return (this.efF == null || StringUtils.isNull(this.efF.efY)) ? false : true;
    }

    public String Ho() {
        return this.efF.Sc;
    }

    public String UT() {
        return this.efF.efY;
    }

    public int getLevel() {
        return this.level;
    }

    public String aPs() {
        return this.efc;
    }

    public String aAC() {
        return this.efd;
    }

    public String aPt() {
        return this.efe;
    }

    public String aPu() {
        return this.eff;
    }

    public String aPv() {
        return this.efg;
    }

    public int aPw() {
        return this.efh;
    }

    public String aPx() {
        return this.efi;
    }

    public ArrayList<e> aPy() {
        return this.efz;
    }

    public a aPz() {
        return this.efD;
    }

    public ArrayList<e> aPA() {
        return this.efA;
    }

    public ArrayList<e> aPB() {
        return this.efB;
    }

    public boolean aPC() {
        return this.efk;
    }

    public String aPD() {
        return this.efu;
    }

    public String getContent() {
        return this.content;
    }

    public int aPE() {
        return this.efv;
    }

    public boolean aPF() {
        return this.efw;
    }

    public int aPG() {
        return this.efx;
    }

    public int aPH() {
        return this.efy;
    }

    public void a(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.efC.get(signData.getForumId())) != null) {
            eVar.oV(1);
            eVar.oW(signData.getCountSignNum());
            eVar.oX(signData.getBonusPoint());
            eVar.iw(true);
            eVar.ix(false);
            eVar.iy(false);
            a(eVar);
            aPI();
            iv(true);
        }
    }

    private void a(e eVar) {
        if (eVar.getUserLevel() >= this.level) {
            this.efn++;
            this.efo--;
        } else {
            this.efl++;
            this.efm--;
        }
        this.efC.remove(String.valueOf(eVar.getForumId()));
        this.efB.remove(eVar);
        if (eVar.aPL() + eVar.aPQ() >= eVar.aPM()) {
            eVar.setUserLevel(eVar.getUserLevel() + 1);
            eVar.iz(true);
            if (eVar.getUserLevel() == this.level) {
                this.efn++;
                this.efl--;
            }
        }
        this.efA.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aPQ(), -1);
    }

    private void aPI() {
        if (this.efk) {
            if (this.efo + this.efm <= 0) {
                this.efw = true;
            } else {
                this.efw = false;
            }
        } else if (this.efo <= 0) {
            this.efw = true;
        } else {
            this.efw = false;
        }
    }

    public void a(u uVar) {
        this.efx = 0;
        this.efy = 0;
        ArrayList<v> aPY = uVar.aPY();
        int size = aPY.size();
        for (int i = 0; i < size; i++) {
            v vVar = aPY.get(i);
            e eVar = this.efC.get(new StringBuilder(String.valueOf(vVar.getForumId())).toString());
            if (eVar != null) {
                if (vVar.getSigned() != 0) {
                    this.efx++;
                    eVar.oV(1);
                    eVar.oW(vVar.aQb());
                    eVar.oX(vVar.getCurScore());
                    eVar.iw(true);
                    eVar.ix(false);
                    eVar.iy(false);
                    a(eVar);
                } else {
                    this.efy++;
                    eVar.iw(false);
                    eVar.ix(true);
                    eVar.iy(false);
                    eVar.setErrorMsg(vVar.aPz().getUserMsg());
                }
            }
        }
        aPI();
        iv(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.efD.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.efc = jSONObject.optString("text_pre");
            this.efd = jSONObject.optString("text_color");
            this.efe = jSONObject.optString("text_mid");
            this.eff = jSONObject.optString("text_suf");
            this.efg = jSONObject.optString("num_notice");
            this.efh = jSONObject.optInt("show_dialog");
            this.efi = jSONObject.optString("sign_notice");
            this.efj = jSONObject.optInt("valid", 0);
            this.efE = jSONObject.optInt("sign_max_num", 50);
            this.eft = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.efu = jSONObject.optString("button_content");
            if (this.eft == 1) {
                this.efk = true;
            } else {
                this.efk = false;
            }
            this.efq = String.valueOf(this.level) + this.title;
            this.efp = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(t.j.sign_all_forum_tip);
            af.ehd = this.efE;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), af.ehd);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.aPJ() == 0) {
                            if (this.efj == 0) {
                                if (this.efk) {
                                    eVar.ix(true);
                                } else if (eVar.getUserLevel() > this.level) {
                                    eVar.ix(true);
                                }
                            }
                            if (eVar.getUserLevel() >= this.level) {
                                this.efo++;
                            } else {
                                this.efm++;
                            }
                            this.efB.add(eVar);
                            this.efC.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.getUserLevel() >= this.level) {
                                this.efn++;
                            } else {
                                this.efl++;
                            }
                            this.efA.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aPQ(), -1);
                        }
                        this.efz.add(eVar);
                        Collections.sort(this.efz, new d(this));
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("advert");
            if (this.efF == null) {
                this.efF = new i();
            }
            this.efF.parserJson(optJSONObject);
            iv(false);
        }
    }

    private void iv(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.efz.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.efz.removeAll(arrayList);
        }
        if (this.efo + this.efn > 0) {
            if (this.efn > 0) {
                this.efs = TbadkApplication.getInst().getContext().getString(t.j.signallforum_res, Integer.valueOf(this.efn), Integer.valueOf(this.efo));
            } else {
                this.efs = TbadkApplication.getInst().getContext().getString(t.j.signallforum_count, Integer.valueOf(this.efo + this.efn));
            }
            if (this.efz.size() > 0) {
                this.efz.add(0, new b(this.efq, this.efs));
            }
        }
        if (this.efm + this.efl > 0) {
            if (this.efl > 0) {
                this.efr = TbadkApplication.getInst().getContext().getString(t.j.signallforum_res, Integer.valueOf(this.efl), Integer.valueOf(this.efm));
            } else {
                this.efr = TbadkApplication.getInst().getContext().getString(t.j.signallforum_count, Integer.valueOf(this.efm + this.efl));
            }
            if (this.efo + this.efn > 0) {
                if (this.efz.size() > this.efo + this.efn + 1) {
                    this.efz.add(this.efo + this.efn + 1, new b(this.efp, this.efr));
                }
            } else if (this.efz.size() > 0) {
                this.efz.add(0, new b(this.efp, this.efr));
            }
        }
        if (this.efz.size() <= 0) {
            this.efv = 3;
        } else if (this.efk) {
            if (this.efj == 1 && this.efB.size() > 0) {
                this.efv = 0;
            } else {
                this.efv = 2;
            }
        } else if (this.efj == 1 && this.efo > 0) {
            this.efv = 0;
        } else if (this.efo + this.efn > 0) {
            this.efv = 2;
        } else if (this.efo + this.efn <= 0) {
            this.efv = 3;
        }
    }
}
