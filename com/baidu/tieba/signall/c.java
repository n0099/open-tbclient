package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    private String alc;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String iVX;
    private String iVY;
    private String iVZ;
    private String iWa;
    private int iWb;
    private String iWc;
    private int iWd;
    private boolean iWe;
    private int iWf;
    private int iWg;
    private int iWh;
    private int iWi;
    private String iWj;
    private String iWk;
    private String iWl;
    private String iWm;
    private int iWn;
    private String iWo;
    private int iWp;
    private boolean iWq;
    private int iWr;
    private int iWs;
    private int iWy;
    private int level;
    private String title;
    private String iVW = "0";
    private ArrayList<d> iWt = new ArrayList<>();
    private ArrayList<d> iWu = new ArrayList<>();
    private ArrayList<d> iWv = new ArrayList<>();
    private HashMap<String, d> iWw = new HashMap<>();
    private a iWx = new a();
    private f iWz = new f();
    private k iWA = new k();

    public boolean cmx() {
        return (this.iWz == null || StringUtils.isNull(this.iWz.iWS)) ? false : true;
    }

    public String avZ() {
        return this.iWz.bEV;
    }

    public String cmy() {
        return this.iWz.iWS;
    }

    public String cmz() {
        return this.iWA.iYm;
    }

    public String cmA() {
        return this.iWA.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cmB() {
        return !StringUtils.isNull(this.iVW) && this.iVW.equals("1");
    }

    public String cmC() {
        return this.iVX;
    }

    public String bZG() {
        return this.alc;
    }

    public String cmD() {
        return this.iVY;
    }

    public String cmE() {
        return this.iVZ;
    }

    public String cmF() {
        return this.iWa;
    }

    public int cmG() {
        return this.iWb;
    }

    public String cmH() {
        return this.iWc;
    }

    public ArrayList<d> cmI() {
        return this.iWt;
    }

    public a cmJ() {
        return this.iWx;
    }

    public ArrayList<d> cmK() {
        return this.iWu;
    }

    public ArrayList<d> cmL() {
        return this.iWv;
    }

    public boolean cmM() {
        return this.iWe;
    }

    public String cmN() {
        return this.iWo;
    }

    public String getContent() {
        return this.content;
    }

    public int cmO() {
        return this.iWp;
    }

    public boolean cmP() {
        return this.iWq;
    }

    public int cmQ() {
        return this.iWr;
    }

    public int cmR() {
        return this.iWs;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.iWw.get(signData.forumId)) != null) {
            dVar.AK(1);
            dVar.AL(signData.count_sign_num);
            dVar.AN(signData.sign_bonus_point);
            dVar.qO(true);
            dVar.qP(false);
            dVar.qQ(false);
            a(dVar);
            cmS();
            qN(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cmV() >= this.level) {
            this.iWh++;
            this.iWi--;
        } else {
            this.iWf++;
            this.iWg--;
        }
        this.iWw.remove(String.valueOf(dVar.getForumId()));
        this.iWv.remove(dVar);
        if (dVar.cmW() + dVar.cna() >= dVar.cmX()) {
            dVar.AM(dVar.cmV() + 1);
            dVar.qR(true);
            if (dVar.cmV() == this.level) {
                this.iWh++;
                this.iWf--;
            }
        }
        this.iWu.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cna(), -1);
    }

    private void cmS() {
        if (this.iWe) {
            if (this.iWi + this.iWg <= 0) {
                this.iWq = true;
            } else {
                this.iWq = false;
            }
        } else if (this.iWi <= 0) {
            this.iWq = true;
        } else {
            this.iWq = false;
        }
    }

    public void a(h hVar) {
        this.iWr = 0;
        this.iWs = 0;
        ArrayList<i> cnk = hVar.cnk();
        int size = cnk.size();
        for (int i = 0; i < size; i++) {
            i iVar = cnk.get(i);
            d dVar = this.iWw.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cnn() != 0) {
                    this.iWr++;
                    dVar.AK(1);
                    dVar.AL(iVar.cno());
                    dVar.AN(iVar.getCurScore());
                    dVar.qO(true);
                    dVar.qP(false);
                    dVar.qQ(false);
                    a(dVar);
                } else {
                    this.iWs++;
                    dVar.qO(false);
                    dVar.qP(true);
                    dVar.qQ(false);
                    dVar.setErrorMsg(iVar.cmJ().getUserMsg());
                }
            }
        }
        cmS();
        qN(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.iWx.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.iVW = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.iVX = jSONObject.optString("text_pre");
            this.alc = jSONObject.optString("text_color");
            this.iVY = jSONObject.optString("text_mid");
            this.iVZ = jSONObject.optString("text_suf");
            this.iWa = jSONObject.optString("num_notice");
            this.iWb = jSONObject.optInt("show_dialog");
            this.iWc = jSONObject.optString("sign_notice");
            this.iWd = jSONObject.optInt("valid", 0);
            this.iWy = jSONObject.optInt("sign_max_num", 50);
            this.iWn = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.iWo = jSONObject.optString("button_content");
            JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
            if (optJSONObject != null) {
                this.blockPopInfoData = new BlockPopInfoData();
                this.blockPopInfoData.block_info = optJSONObject.optString("block_content");
                this.blockPopInfoData.ahead_info = optJSONObject.optString("block_confirm");
                this.blockPopInfoData.ahead_url = optJSONObject.optString("block_dealurl");
                this.blockPopInfoData.ok_info = optJSONObject.optString("block_cancel");
                this.blockPopInfoData.appeal_status = optJSONObject.optInt("appeal_status");
                this.blockPopInfoData.appeal_msg = optJSONObject.optString("appeal_msg");
            }
            if (this.iWn == 1) {
                this.iWe = true;
            } else {
                this.iWe = false;
            }
            this.iWk = this.level + this.title;
            this.iWj = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.iYc = this.iWy;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.iYc);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cmT() == 0) {
                            if (this.iWd == 0) {
                                if (this.iWe) {
                                    dVar.qP(true);
                                } else if (dVar.cmV() > this.level) {
                                    dVar.qP(true);
                                }
                            }
                            if (dVar.cmV() >= this.level) {
                                this.iWi++;
                            } else {
                                this.iWg++;
                            }
                            this.iWv.add(dVar);
                            this.iWw.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cmV() >= this.level) {
                                this.iWh++;
                            } else {
                                this.iWf++;
                            }
                            this.iWu.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cna(), -1);
                        }
                        this.iWt.add(dVar);
                        Collections.sort(this.iWt, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cmV() - dVar2.cmV();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.iWz == null) {
                this.iWz = new f();
            }
            this.iWz.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.iWA == null) {
                this.iWA = new k();
            }
            this.iWA.parserJson(optJSONObject3);
            qN(false);
        }
    }

    private void qN(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.iWt.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.iWt.removeAll(arrayList);
        }
        if (this.iWi + this.iWh > 0) {
            if (this.iWh > 0) {
                this.iWm = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iWh), Integer.valueOf(this.iWi));
            } else {
                this.iWm = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iWi + this.iWh));
            }
            if (this.iWt.size() > 0) {
                this.iWt.add(0, new b(this.iWk, this.iWm));
            }
        }
        if (this.iWg + this.iWf > 0) {
            if (this.iWf > 0) {
                this.iWl = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iWf), Integer.valueOf(this.iWg));
            } else {
                this.iWl = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iWg + this.iWf));
            }
            if (this.iWi + this.iWh > 0) {
                if (this.iWt.size() > this.iWi + this.iWh + 1) {
                    this.iWt.add(this.iWi + this.iWh + 1, new b(this.iWj, this.iWl));
                }
            } else if (this.iWt.size() > 0) {
                this.iWt.add(0, new b(this.iWj, this.iWl));
            }
        }
        if (this.iWt.size() <= 0) {
            this.iWp = 3;
        } else if (this.iWe) {
            if (this.iWd == 1 && this.iWv.size() > 0) {
                this.iWp = 0;
            } else {
                this.iWp = 2;
            }
        } else if (this.iWd == 1 && this.iWi > 0) {
            this.iWp = 0;
        } else if (this.iWi + this.iWh > 0) {
            this.iWp = 2;
        } else if (this.iWi + this.iWh <= 0) {
            this.iWp = 3;
        }
    }
}
