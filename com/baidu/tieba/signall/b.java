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
    private String bPZ;
    private int bQB;
    private String bQa;
    private String bQb;
    private String bQc;
    private String bQd;
    private int bQe;
    private String bQf;
    private int bQg;
    private boolean bQh;
    private int bQi;
    private int bQj;
    private int bQk;
    private int bQl;
    private String bQm;
    private String bQn;
    private String bQo;
    private String bQp;
    private int bQq;
    private String bQr;
    private int bQs;
    private boolean bQt;
    private int bQu;
    private int bQv;
    private String content;
    private int level;
    private String title;
    private ArrayList<d> bQw = new ArrayList<>();
    private ArrayList<d> bQx = new ArrayList<>();
    private ArrayList<d> bQy = new ArrayList<>();
    private HashMap<String, d> bQz = new HashMap<>();
    private com.baidu.tieba.home.t bQA = new com.baidu.tieba.home.t();

    public int getLevel() {
        return this.level;
    }

    public String ads() {
        return this.bPZ;
    }

    public String adt() {
        return this.bQa;
    }

    public String adu() {
        return this.bQb;
    }

    public String adv() {
        return this.bQc;
    }

    public String adw() {
        return this.bQd;
    }

    public int adx() {
        return this.bQe;
    }

    public String ady() {
        return this.bQf;
    }

    public ArrayList<d> adz() {
        return this.bQw;
    }

    public com.baidu.tieba.home.t adA() {
        return this.bQA;
    }

    public ArrayList<d> adB() {
        return this.bQx;
    }

    public ArrayList<d> adC() {
        return this.bQy;
    }

    public boolean adD() {
        return this.bQh;
    }

    public String adE() {
        return this.bQr;
    }

    public String getContent() {
        return this.content;
    }

    public int adF() {
        return this.bQs;
    }

    public boolean adG() {
        return this.bQt;
    }

    public int adH() {
        return this.bQu;
    }

    public int adI() {
        return this.bQv;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.bQz.get(signData.getForumId())) != null) {
            dVar.hC(1);
            dVar.hD(signData.getCountSignNum());
            dVar.hF(signData.getBonusPoint());
            dVar.er(true);
            dVar.es(false);
            dVar.et(false);
            a(dVar);
            adJ();
            eq(true);
        }
    }

    private void a(d dVar) {
        if (dVar.adM() >= this.level) {
            this.bQk++;
            this.bQl--;
        } else {
            this.bQi++;
            this.bQj--;
        }
        this.bQz.remove(String.valueOf(dVar.getForumId()));
        this.bQy.remove(dVar);
        if (dVar.adN() + dVar.adS() >= dVar.adO()) {
            dVar.hE(dVar.adM() + 1);
            dVar.eu(true);
            if (dVar.adM() == this.level) {
                this.bQk++;
                this.bQi--;
            }
        }
        this.bQx.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.adS(), -1);
    }

    private void adJ() {
        if (this.bQh) {
            if (this.bQl + this.bQj <= 0) {
                this.bQt = true;
            } else {
                this.bQt = false;
            }
        } else if (this.bQl <= 0) {
            this.bQt = true;
        } else {
            this.bQt = false;
        }
    }

    public void a(s sVar) {
        this.bQu = 0;
        this.bQv = 0;
        ArrayList<t> adZ = sVar.adZ();
        int size = adZ.size();
        for (int i = 0; i < size; i++) {
            t tVar = adZ.get(i);
            d dVar = this.bQz.get(new StringBuilder(String.valueOf(tVar.getForumId())).toString());
            if (dVar != null) {
                if (tVar.getSigned() != 0) {
                    this.bQu++;
                    dVar.hC(1);
                    dVar.hD(tVar.aec());
                    dVar.hF(tVar.getCurScore());
                    dVar.er(true);
                    dVar.es(false);
                    dVar.et(false);
                    a(dVar);
                } else {
                    this.bQv++;
                    dVar.er(false);
                    dVar.es(true);
                    dVar.et(false);
                    dVar.setErrorMsg(tVar.adA().getUserMsg());
                }
            }
        }
        adJ();
        eq(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bQA.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.bPZ = jSONObject.optString("text_pre");
            this.bQa = jSONObject.optString("text_color");
            this.bQb = jSONObject.optString("text_mid");
            this.bQc = jSONObject.optString("text_suf");
            this.bQd = jSONObject.optString("num_notice");
            this.bQe = jSONObject.optInt("show_dialog");
            this.bQf = jSONObject.optString("sign_notice");
            this.bQg = jSONObject.optInt("valid", 0);
            this.bQB = jSONObject.optInt("sign_max_num", 50);
            this.bQq = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.bQr = jSONObject.optString("button_content");
            if (this.bQq == 1) {
                this.bQh = true;
            } else {
                this.bQh = false;
            }
            this.bQn = String.valueOf(this.level) + this.title;
            this.bQm = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.sign_all_forum_tip);
            ad.bRT = this.bQB;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), ad.bRT);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.adK() == 0) {
                            if (this.bQg == 0) {
                                if (this.bQh) {
                                    dVar.es(true);
                                } else if (dVar.adM() > this.level) {
                                    dVar.es(true);
                                }
                            }
                            if (dVar.adM() >= this.level) {
                                this.bQl++;
                            } else {
                                this.bQj++;
                            }
                            this.bQy.add(dVar);
                            this.bQz.put(new StringBuilder(String.valueOf(dVar.getForumId())).toString(), dVar);
                        } else {
                            if (dVar.adM() >= this.level) {
                                this.bQk++;
                            } else {
                                this.bQi++;
                            }
                            this.bQx.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.adS(), -1);
                        }
                        this.bQw.add(dVar);
                        Collections.sort(this.bQw, new c(this));
                    }
                }
            }
            eq(false);
        }
    }

    private void eq(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.bQw.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof a) {
                    arrayList.add(next);
                }
            }
            this.bQw.removeAll(arrayList);
        }
        if (this.bQl + this.bQk > 0) {
            if (this.bQk > 0) {
                this.bQp = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.signallforum_res, Integer.valueOf(this.bQk), Integer.valueOf(this.bQl));
            } else {
                this.bQp = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.signallforum_count, Integer.valueOf(this.bQl + this.bQk));
            }
            if (this.bQw.size() > 0) {
                this.bQw.add(0, new a(this.bQn, this.bQp));
            }
        }
        if (this.bQj + this.bQi > 0) {
            if (this.bQi > 0) {
                this.bQo = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.signallforum_res, Integer.valueOf(this.bQi), Integer.valueOf(this.bQj));
            } else {
                this.bQo = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.signallforum_count, Integer.valueOf(this.bQj + this.bQi));
            }
            if (this.bQl + this.bQk > 0) {
                if (this.bQw.size() > this.bQl + this.bQk + 1) {
                    this.bQw.add(this.bQl + this.bQk + 1, new a(this.bQm, this.bQo));
                }
            } else if (this.bQw.size() > 0) {
                this.bQw.add(0, new a(this.bQm, this.bQo));
            }
        }
        if (this.bQw.size() <= 0) {
            this.bQs = 3;
        } else if (this.bQh) {
            if (this.bQg == 1 && this.bQy.size() > 0) {
                this.bQs = 0;
            } else {
                this.bQs = 2;
            }
        } else if (this.bQg == 1 && this.bQl > 0) {
            this.bQs = 0;
        } else if (this.bQl + this.bQk > 0) {
            this.bQs = 2;
        } else if (this.bQl + this.bQk <= 0) {
            this.bQs = 3;
        }
    }
}
