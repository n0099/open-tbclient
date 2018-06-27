package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String gCE;
    private String gCF;
    private String gCG;
    private String gCH;
    private String gCI;
    private int gCJ;
    private String gCK;
    private int gCL;
    private boolean gCM;
    private int gCN;
    private int gCO;
    private int gCP;
    private int gCQ;
    private String gCR;
    private String gCS;
    private String gCT;
    private String gCU;
    private int gCV;
    private String gCW;
    private int gCX;
    private boolean gCY;
    private int gCZ;
    private int gDa;
    private int gDg;
    private int level;
    private String title;
    private String gCD = "0";
    private ArrayList<d> gDb = new ArrayList<>();
    private ArrayList<d> gDc = new ArrayList<>();
    private ArrayList<d> gDd = new ArrayList<>();
    private HashMap<String, d> gDe = new HashMap<>();
    private a gDf = new a();
    private f gDh = new f();
    private k gDi = new k();

    public boolean btz() {
        return (this.gDh == null || StringUtils.isNull(this.gDh.gDA)) ? false : true;
    }

    public String Lh() {
        return this.gDh.aed;
    }

    public String btA() {
        return this.gDh.gDA;
    }

    public String btB() {
        return this.gDi.gEX;
    }

    public String btC() {
        return this.gDi.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean btD() {
        return !StringUtils.isNull(this.gCD) && this.gCD.equals("1");
    }

    public String btE() {
        return this.gCE;
    }

    public String bhP() {
        return this.gCF;
    }

    public String btF() {
        return this.gCG;
    }

    public String btG() {
        return this.gCH;
    }

    public String btH() {
        return this.gCI;
    }

    public int btI() {
        return this.gCJ;
    }

    public String btJ() {
        return this.gCK;
    }

    public ArrayList<d> btK() {
        return this.gDb;
    }

    public a btL() {
        return this.gDf;
    }

    public ArrayList<d> btM() {
        return this.gDc;
    }

    public ArrayList<d> btN() {
        return this.gDd;
    }

    public boolean btO() {
        return this.gCM;
    }

    public String btP() {
        return this.gCW;
    }

    public String getContent() {
        return this.content;
    }

    public int btQ() {
        return this.gCX;
    }

    public boolean btR() {
        return this.gCY;
    }

    public int btS() {
        return this.gCZ;
    }

    public int btT() {
        return this.gDa;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gDe.get(signData.forumId)) != null) {
            dVar.tk(1);
            dVar.tl(signData.count_sign_num);
            dVar.tn(signData.sign_bonus_point);
            dVar.ms(true);
            dVar.mt(false);
            dVar.mu(false);
            a(dVar);
            btU();
            mr(true);
        }
    }

    private void a(d dVar) {
        if (dVar.btX() >= this.level) {
            this.gCP++;
            this.gCQ--;
        } else {
            this.gCN++;
            this.gCO--;
        }
        this.gDe.remove(String.valueOf(dVar.getForumId()));
        this.gDd.remove(dVar);
        if (dVar.btY() + dVar.buc() >= dVar.btZ()) {
            dVar.tm(dVar.btX() + 1);
            dVar.mv(true);
            if (dVar.btX() == this.level) {
                this.gCP++;
                this.gCN--;
            }
        }
        this.gDc.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.buc(), -1);
    }

    private void btU() {
        if (this.gCM) {
            if (this.gCQ + this.gCO <= 0) {
                this.gCY = true;
            } else {
                this.gCY = false;
            }
        } else if (this.gCQ <= 0) {
            this.gCY = true;
        } else {
            this.gCY = false;
        }
    }

    public void a(h hVar) {
        this.gCZ = 0;
        this.gDa = 0;
        ArrayList<i> bul = hVar.bul();
        int size = bul.size();
        for (int i = 0; i < size; i++) {
            i iVar = bul.get(i);
            d dVar = this.gDe.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.buo() != 0) {
                    this.gCZ++;
                    dVar.tk(1);
                    dVar.tl(iVar.bup());
                    dVar.tn(iVar.getCurScore());
                    dVar.ms(true);
                    dVar.mt(false);
                    dVar.mu(false);
                    a(dVar);
                } else {
                    this.gDa++;
                    dVar.ms(false);
                    dVar.mt(true);
                    dVar.mu(false);
                    dVar.setErrorMsg(iVar.btL().getUserMsg());
                }
            }
        }
        btU();
        mr(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gDf.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.gCD = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gCE = jSONObject.optString("text_pre");
            this.gCF = jSONObject.optString("text_color");
            this.gCG = jSONObject.optString("text_mid");
            this.gCH = jSONObject.optString("text_suf");
            this.gCI = jSONObject.optString("num_notice");
            this.gCJ = jSONObject.optInt("show_dialog");
            this.gCK = jSONObject.optString("sign_notice");
            this.gCL = jSONObject.optInt("valid", 0);
            this.gDg = jSONObject.optInt("sign_max_num", 50);
            this.gCV = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gCW = jSONObject.optString("button_content");
            JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
            if (optJSONObject != null) {
                this.blockPopInfoData = new BlockPopInfoData();
                this.blockPopInfoData.block_info = optJSONObject.optString("block_content");
                this.blockPopInfoData.ahead_info = optJSONObject.optString("block_confirm");
                this.blockPopInfoData.ahead_url = optJSONObject.optString("block_dealurl");
                this.blockPopInfoData.ok_info = optJSONObject.optString("block_cancel");
            }
            if (this.gCV == 1) {
                this.gCM = true;
            } else {
                this.gCM = false;
            }
            this.gCS = this.level + this.title;
            this.gCR = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(d.k.sign_all_forum_tip);
            j.gEL = this.gDg;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.gEL);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.btV() == 0) {
                            if (this.gCL == 0) {
                                if (this.gCM) {
                                    dVar.mt(true);
                                } else if (dVar.btX() > this.level) {
                                    dVar.mt(true);
                                }
                            }
                            if (dVar.btX() >= this.level) {
                                this.gCQ++;
                            } else {
                                this.gCO++;
                            }
                            this.gDd.add(dVar);
                            this.gDe.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.btX() >= this.level) {
                                this.gCP++;
                            } else {
                                this.gCN++;
                            }
                            this.gDc.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.buc(), -1);
                        }
                        this.gDb.add(dVar);
                        Collections.sort(this.gDb, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.btX() - dVar2.btX();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.gDh == null) {
                this.gDh = new f();
            }
            this.gDh.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gDi == null) {
                this.gDi = new k();
            }
            this.gDi.parserJson(optJSONObject3);
            mr(false);
        }
    }

    private void mr(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gDb.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gDb.removeAll(arrayList);
        }
        if (this.gCQ + this.gCP > 0) {
            if (this.gCP > 0) {
                this.gCU = TbadkApplication.getInst().getContext().getString(d.k.signallforum_res, Integer.valueOf(this.gCP), Integer.valueOf(this.gCQ));
            } else {
                this.gCU = TbadkApplication.getInst().getContext().getString(d.k.signallforum_count, Integer.valueOf(this.gCQ + this.gCP));
            }
            if (this.gDb.size() > 0) {
                this.gDb.add(0, new b(this.gCS, this.gCU));
            }
        }
        if (this.gCO + this.gCN > 0) {
            if (this.gCN > 0) {
                this.gCT = TbadkApplication.getInst().getContext().getString(d.k.signallforum_res, Integer.valueOf(this.gCN), Integer.valueOf(this.gCO));
            } else {
                this.gCT = TbadkApplication.getInst().getContext().getString(d.k.signallforum_count, Integer.valueOf(this.gCO + this.gCN));
            }
            if (this.gCQ + this.gCP > 0) {
                if (this.gDb.size() > this.gCQ + this.gCP + 1) {
                    this.gDb.add(this.gCQ + this.gCP + 1, new b(this.gCR, this.gCT));
                }
            } else if (this.gDb.size() > 0) {
                this.gDb.add(0, new b(this.gCR, this.gCT));
            }
        }
        if (this.gDb.size() <= 0) {
            this.gCX = 3;
        } else if (this.gCM) {
            if (this.gCL == 1 && this.gDd.size() > 0) {
                this.gCX = 0;
            } else {
                this.gCX = 2;
            }
        } else if (this.gCL == 1 && this.gCQ > 0) {
            this.gCX = 0;
        } else if (this.gCQ + this.gCP > 0) {
            this.gCX = 2;
        } else if (this.gCQ + this.gCP <= 0) {
            this.gCX = 3;
        }
    }
}
