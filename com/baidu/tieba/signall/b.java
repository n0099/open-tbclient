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
    private String bPY;
    private String bPZ;
    private int bQA;
    private String bQa;
    private String bQb;
    private String bQc;
    private int bQd;
    private String bQe;
    private int bQf;
    private boolean bQg;
    private int bQh;
    private int bQi;
    private int bQj;
    private int bQk;
    private String bQl;
    private String bQm;
    private String bQn;
    private String bQo;
    private int bQp;
    private String bQq;
    private int bQr;
    private boolean bQs;
    private int bQt;
    private int bQu;
    private ArrayList<d> bQv = new ArrayList<>();
    private ArrayList<d> bQw = new ArrayList<>();
    private ArrayList<d> bQx = new ArrayList<>();
    private HashMap<String, d> bQy = new HashMap<>();
    private com.baidu.tieba.home.t bQz = new com.baidu.tieba.home.t();
    private String content;
    private int level;
    private String title;

    public int getLevel() {
        return this.level;
    }

    public String adn() {
        return this.bPY;
    }

    public String ado() {
        return this.bPZ;
    }

    public String adp() {
        return this.bQa;
    }

    public String adq() {
        return this.bQb;
    }

    public String adr() {
        return this.bQc;
    }

    public int ads() {
        return this.bQd;
    }

    public String adt() {
        return this.bQe;
    }

    public ArrayList<d> adu() {
        return this.bQv;
    }

    public com.baidu.tieba.home.t adv() {
        return this.bQz;
    }

    public ArrayList<d> adw() {
        return this.bQw;
    }

    public ArrayList<d> adx() {
        return this.bQx;
    }

    public boolean ady() {
        return this.bQg;
    }

    public String adz() {
        return this.bQq;
    }

    public String getContent() {
        return this.content;
    }

    public int adA() {
        return this.bQr;
    }

    public boolean adB() {
        return this.bQs;
    }

    public int adC() {
        return this.bQt;
    }

    public int adD() {
        return this.bQu;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.bQy.get(signData.getForumId())) != null) {
            dVar.hC(1);
            dVar.hD(signData.getCountSignNum());
            dVar.hF(signData.getBonusPoint());
            dVar.er(true);
            dVar.es(false);
            dVar.et(false);
            a(dVar);
            adE();
            eq(true);
        }
    }

    private void a(d dVar) {
        if (dVar.adH() >= this.level) {
            this.bQj++;
            this.bQk--;
        } else {
            this.bQh++;
            this.bQi--;
        }
        this.bQy.remove(String.valueOf(dVar.getForumId()));
        this.bQx.remove(dVar);
        if (dVar.adI() + dVar.adN() >= dVar.adJ()) {
            dVar.hE(dVar.adH() + 1);
            dVar.eu(true);
            if (dVar.adH() == this.level) {
                this.bQj++;
                this.bQh--;
            }
        }
        this.bQw.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.adN(), -1);
    }

    private void adE() {
        if (this.bQg) {
            if (this.bQk + this.bQi <= 0) {
                this.bQs = true;
            } else {
                this.bQs = false;
            }
        } else if (this.bQk <= 0) {
            this.bQs = true;
        } else {
            this.bQs = false;
        }
    }

    public void a(s sVar) {
        this.bQt = 0;
        this.bQu = 0;
        ArrayList<t> adU = sVar.adU();
        int size = adU.size();
        for (int i = 0; i < size; i++) {
            t tVar = adU.get(i);
            d dVar = this.bQy.get(new StringBuilder(String.valueOf(tVar.getForumId())).toString());
            if (dVar != null) {
                if (tVar.getSigned() != 0) {
                    this.bQt++;
                    dVar.hC(1);
                    dVar.hD(tVar.adX());
                    dVar.hF(tVar.getCurScore());
                    dVar.er(true);
                    dVar.es(false);
                    dVar.et(false);
                    a(dVar);
                } else {
                    this.bQu++;
                    dVar.er(false);
                    dVar.es(true);
                    dVar.et(false);
                    dVar.setErrorMsg(tVar.adv().getUserMsg());
                }
            }
        }
        adE();
        eq(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.bQz.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.bPY = jSONObject.optString("text_pre");
            this.bPZ = jSONObject.optString("text_color");
            this.bQa = jSONObject.optString("text_mid");
            this.bQb = jSONObject.optString("text_suf");
            this.bQc = jSONObject.optString("num_notice");
            this.bQd = jSONObject.optInt("show_dialog");
            this.bQe = jSONObject.optString("sign_notice");
            this.bQf = jSONObject.optInt("valid", 0);
            this.bQA = jSONObject.optInt("sign_max_num", 50);
            this.bQp = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.bQq = jSONObject.optString("button_content");
            if (this.bQp == 1) {
                this.bQg = true;
            } else {
                this.bQg = false;
            }
            this.bQm = String.valueOf(this.level) + this.title;
            this.bQl = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.sign_all_forum_tip);
            ad.bRS = this.bQA;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), ad.bRS);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.adF() == 0) {
                            if (this.bQf == 0) {
                                if (this.bQg) {
                                    dVar.es(true);
                                } else if (dVar.adH() > this.level) {
                                    dVar.es(true);
                                }
                            }
                            if (dVar.adH() >= this.level) {
                                this.bQk++;
                            } else {
                                this.bQi++;
                            }
                            this.bQx.add(dVar);
                            this.bQy.put(new StringBuilder(String.valueOf(dVar.getForumId())).toString(), dVar);
                        } else {
                            if (dVar.adH() >= this.level) {
                                this.bQj++;
                            } else {
                                this.bQh++;
                            }
                            this.bQw.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.adN(), -1);
                        }
                        this.bQv.add(dVar);
                        Collections.sort(this.bQv, new c(this));
                    }
                }
            }
            eq(false);
        }
    }

    private void eq(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.bQv.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof a) {
                    arrayList.add(next);
                }
            }
            this.bQv.removeAll(arrayList);
        }
        if (this.bQk + this.bQj > 0) {
            if (this.bQj > 0) {
                this.bQo = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.signallforum_res, Integer.valueOf(this.bQj), Integer.valueOf(this.bQk));
            } else {
                this.bQo = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.signallforum_count, Integer.valueOf(this.bQk + this.bQj));
            }
            if (this.bQv.size() > 0) {
                this.bQv.add(0, new a(this.bQm, this.bQo));
            }
        }
        if (this.bQi + this.bQh > 0) {
            if (this.bQh > 0) {
                this.bQn = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.signallforum_res, Integer.valueOf(this.bQh), Integer.valueOf(this.bQi));
            } else {
                this.bQn = TbadkApplication.getInst().getContext().getString(com.baidu.tieba.z.signallforum_count, Integer.valueOf(this.bQi + this.bQh));
            }
            if (this.bQk + this.bQj > 0) {
                if (this.bQv.size() > this.bQk + this.bQj + 1) {
                    this.bQv.add(this.bQk + this.bQj + 1, new a(this.bQl, this.bQn));
                }
            } else if (this.bQv.size() > 0) {
                this.bQv.add(0, new a(this.bQl, this.bQn));
            }
        }
        if (this.bQv.size() <= 0) {
            this.bQr = 3;
        } else if (this.bQg) {
            if (this.bQf == 1 && this.bQx.size() > 0) {
                this.bQr = 0;
            } else {
                this.bQr = 2;
            }
        } else if (this.bQf == 1 && this.bQk > 0) {
            this.bQr = 0;
        } else if (this.bQk + this.bQj > 0) {
            this.bQr = 2;
        } else if (this.bQk + this.bQj <= 0) {
            this.bQr = 3;
        }
    }
}
