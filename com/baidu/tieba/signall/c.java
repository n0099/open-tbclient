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
    private String cHZ;
    private int cIB;
    private String cIa;
    private String cIb;
    private String cIc;
    private String cId;
    private int cIe;
    private String cIf;
    private int cIg;
    private boolean cIh;
    private int cIi;
    private int cIj;
    private int cIk;
    private int cIl;
    private String cIm;
    private String cIn;
    private String cIo;
    private String cIp;
    private int cIq;
    private String cIr;
    private int cIs;
    private boolean cIt;
    private int cIu;
    private int cIv;
    private String content;
    private int level;
    private String title;
    private ArrayList<e> cIw = new ArrayList<>();
    private ArrayList<e> cIx = new ArrayList<>();
    private ArrayList<e> cIy = new ArrayList<>();
    private HashMap<String, e> cIz = new HashMap<>();
    private a cIA = new a();

    public int getLevel() {
        return this.level;
    }

    public String aqQ() {
        return this.cHZ;
    }

    public String afU() {
        return this.cIa;
    }

    public String aqR() {
        return this.cIb;
    }

    public String aqS() {
        return this.cIc;
    }

    public String aqT() {
        return this.cId;
    }

    public int aqU() {
        return this.cIe;
    }

    public String aqV() {
        return this.cIf;
    }

    public ArrayList<e> aqW() {
        return this.cIw;
    }

    public a aqX() {
        return this.cIA;
    }

    public ArrayList<e> aqY() {
        return this.cIx;
    }

    public ArrayList<e> aqZ() {
        return this.cIy;
    }

    public boolean ara() {
        return this.cIh;
    }

    public String arb() {
        return this.cIr;
    }

    public String getContent() {
        return this.content;
    }

    public int arc() {
        return this.cIs;
    }

    public boolean ard() {
        return this.cIt;
    }

    public int are() {
        return this.cIu;
    }

    public int arf() {
        return this.cIv;
    }

    public void b(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.cIz.get(signData.getForumId())) != null) {
            eVar.kc(1);
            eVar.kd(signData.getCountSignNum());
            eVar.kf(signData.getBonusPoint());
            eVar.fV(true);
            eVar.fW(false);
            eVar.fX(false);
            a(eVar);
            arg();
            fU(true);
        }
    }

    private void a(e eVar) {
        if (eVar.arj() >= this.level) {
            this.cIk++;
            this.cIl--;
        } else {
            this.cIi++;
            this.cIj--;
        }
        this.cIz.remove(String.valueOf(eVar.getForumId()));
        this.cIy.remove(eVar);
        if (eVar.ark() + eVar.arp() >= eVar.arl()) {
            eVar.ke(eVar.arj() + 1);
            eVar.fY(true);
            if (eVar.arj() == this.level) {
                this.cIk++;
                this.cIi--;
            }
        }
        this.cIx.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.arp(), -1);
    }

    private void arg() {
        if (this.cIh) {
            if (this.cIl + this.cIj <= 0) {
                this.cIt = true;
            } else {
                this.cIt = false;
            }
        } else if (this.cIl <= 0) {
            this.cIt = true;
        } else {
            this.cIt = false;
        }
    }

    public void a(p pVar) {
        this.cIu = 0;
        this.cIv = 0;
        ArrayList<q> arv = pVar.arv();
        int size = arv.size();
        for (int i = 0; i < size; i++) {
            q qVar = arv.get(i);
            e eVar = this.cIz.get(new StringBuilder(String.valueOf(qVar.getForumId())).toString());
            if (eVar != null) {
                if (qVar.getSigned() != 0) {
                    this.cIu++;
                    eVar.kc(1);
                    eVar.kd(qVar.ary());
                    eVar.kf(qVar.getCurScore());
                    eVar.fV(true);
                    eVar.fW(false);
                    eVar.fX(false);
                    a(eVar);
                } else {
                    this.cIv++;
                    eVar.fV(false);
                    eVar.fW(true);
                    eVar.fX(false);
                    eVar.setErrorMsg(qVar.aqX().getUserMsg());
                }
            }
        }
        arg();
        fU(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cIA.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.cHZ = jSONObject.optString("text_pre");
            this.cIa = jSONObject.optString("text_color");
            this.cIb = jSONObject.optString("text_mid");
            this.cIc = jSONObject.optString("text_suf");
            this.cId = jSONObject.optString("num_notice");
            this.cIe = jSONObject.optInt("show_dialog");
            this.cIf = jSONObject.optString("sign_notice");
            this.cIg = jSONObject.optInt("valid", 0);
            this.cIB = jSONObject.optInt("sign_max_num", 50);
            this.cIq = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.cIr = jSONObject.optString("button_content");
            if (this.cIq == 1) {
                this.cIh = true;
            } else {
                this.cIh = false;
            }
            this.cIn = String.valueOf(this.level) + this.title;
            this.cIm = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(i.h.sign_all_forum_tip);
            z.cJT = this.cIB;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), z.cJT);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.arh() == 0) {
                            if (this.cIg == 0) {
                                if (this.cIh) {
                                    eVar.fW(true);
                                } else if (eVar.arj() > this.level) {
                                    eVar.fW(true);
                                }
                            }
                            if (eVar.arj() >= this.level) {
                                this.cIl++;
                            } else {
                                this.cIj++;
                            }
                            this.cIy.add(eVar);
                            this.cIz.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.arj() >= this.level) {
                                this.cIk++;
                            } else {
                                this.cIi++;
                            }
                            this.cIx.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.arp(), -1);
                        }
                        this.cIw.add(eVar);
                        Collections.sort(this.cIw, new d(this));
                    }
                }
            }
            fU(false);
        }
    }

    private void fU(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.cIw.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.cIw.removeAll(arrayList);
        }
        if (this.cIl + this.cIk > 0) {
            if (this.cIk > 0) {
                this.cIp = TbadkApplication.getInst().getContext().getString(i.h.signallforum_res, Integer.valueOf(this.cIk), Integer.valueOf(this.cIl));
            } else {
                this.cIp = TbadkApplication.getInst().getContext().getString(i.h.signallforum_count, Integer.valueOf(this.cIl + this.cIk));
            }
            if (this.cIw.size() > 0) {
                this.cIw.add(0, new b(this.cIn, this.cIp));
            }
        }
        if (this.cIj + this.cIi > 0) {
            if (this.cIi > 0) {
                this.cIo = TbadkApplication.getInst().getContext().getString(i.h.signallforum_res, Integer.valueOf(this.cIi), Integer.valueOf(this.cIj));
            } else {
                this.cIo = TbadkApplication.getInst().getContext().getString(i.h.signallforum_count, Integer.valueOf(this.cIj + this.cIi));
            }
            if (this.cIl + this.cIk > 0) {
                if (this.cIw.size() > this.cIl + this.cIk + 1) {
                    this.cIw.add(this.cIl + this.cIk + 1, new b(this.cIm, this.cIo));
                }
            } else if (this.cIw.size() > 0) {
                this.cIw.add(0, new b(this.cIm, this.cIo));
            }
        }
        if (this.cIw.size() <= 0) {
            this.cIs = 3;
        } else if (this.cIh) {
            if (this.cIg == 1 && this.cIy.size() > 0) {
                this.cIs = 0;
            } else {
                this.cIs = 2;
            }
        } else if (this.cIg == 1 && this.cIl > 0) {
            this.cIs = 0;
        } else if (this.cIl + this.cIk > 0) {
            this.cIs = 2;
        } else if (this.cIl + this.cIk <= 0) {
            this.cIs = 3;
        }
    }
}
