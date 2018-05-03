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
    private int gmA;
    private boolean gmB;
    private int gmC;
    private int gmD;
    private int gmJ;
    private String gmh;
    private String gmi;
    private String gmj;
    private String gmk;
    private String gml;
    private int gmm;
    private String gmn;
    private int gmo;
    private boolean gmp;
    private int gmq;
    private int gmr;
    private int gms;
    private int gmt;
    private String gmu;
    private String gmv;
    private String gmw;
    private String gmx;
    private int gmy;
    private String gmz;
    private int level;
    private String title;
    private String gmg = "0";
    private ArrayList<d> gmE = new ArrayList<>();
    private ArrayList<d> gmF = new ArrayList<>();
    private ArrayList<d> gmG = new ArrayList<>();
    private HashMap<String, d> gmH = new HashMap<>();
    private a gmI = new a();
    private f gmK = new f();
    private k gmL = new k();

    public boolean bob() {
        return (this.gmK == null || StringUtils.isNull(this.gmK.gnd)) ? false : true;
    }

    public String Hx() {
        return this.gmK.VS;
    }

    public String boc() {
        return this.gmK.gnd;
    }

    public String bod() {
        return this.gmL.goB;
    }

    public String boe() {
        return this.gmL.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bof() {
        return !StringUtils.isNull(this.gmg) && this.gmg.equals("1");
    }

    public String bog() {
        return this.gmh;
    }

    public String bcj() {
        return this.gmi;
    }

    public String boh() {
        return this.gmj;
    }

    public String boi() {
        return this.gmk;
    }

    public String boj() {
        return this.gml;
    }

    public int bok() {
        return this.gmm;
    }

    public String bol() {
        return this.gmn;
    }

    public ArrayList<d> bom() {
        return this.gmE;
    }

    public a bon() {
        return this.gmI;
    }

    public ArrayList<d> boo() {
        return this.gmF;
    }

    public ArrayList<d> bop() {
        return this.gmG;
    }

    public boolean boq() {
        return this.gmp;
    }

    public String bor() {
        return this.gmz;
    }

    public String getContent() {
        return this.content;
    }

    public int bos() {
        return this.gmA;
    }

    public boolean bot() {
        return this.gmB;
    }

    public int bou() {
        return this.gmC;
    }

    public int bov() {
        return this.gmD;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gmH.get(signData.forumId)) != null) {
            dVar.sP(1);
            dVar.sQ(signData.count_sign_num);
            dVar.sS(signData.sign_bonus_point);
            dVar.ma(true);
            dVar.mb(false);
            dVar.mc(false);
            a(dVar);
            bow();
            lZ(true);
        }
    }

    private void a(d dVar) {
        if (dVar.boz() >= this.level) {
            this.gms++;
            this.gmt--;
        } else {
            this.gmq++;
            this.gmr--;
        }
        this.gmH.remove(String.valueOf(dVar.getForumId()));
        this.gmG.remove(dVar);
        if (dVar.boA() + dVar.boE() >= dVar.boB()) {
            dVar.sR(dVar.boz() + 1);
            dVar.md(true);
            if (dVar.boz() == this.level) {
                this.gms++;
                this.gmq--;
            }
        }
        this.gmF.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.boE(), -1);
    }

    private void bow() {
        if (this.gmp) {
            if (this.gmt + this.gmr <= 0) {
                this.gmB = true;
            } else {
                this.gmB = false;
            }
        } else if (this.gmt <= 0) {
            this.gmB = true;
        } else {
            this.gmB = false;
        }
    }

    public void a(h hVar) {
        this.gmC = 0;
        this.gmD = 0;
        ArrayList<i> boN = hVar.boN();
        int size = boN.size();
        for (int i = 0; i < size; i++) {
            i iVar = boN.get(i);
            d dVar = this.gmH.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.boQ() != 0) {
                    this.gmC++;
                    dVar.sP(1);
                    dVar.sQ(iVar.boR());
                    dVar.sS(iVar.getCurScore());
                    dVar.ma(true);
                    dVar.mb(false);
                    dVar.mc(false);
                    a(dVar);
                } else {
                    this.gmD++;
                    dVar.ma(false);
                    dVar.mb(true);
                    dVar.mc(false);
                    dVar.setErrorMsg(iVar.bon().getUserMsg());
                }
            }
        }
        bow();
        lZ(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gmI.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.gmg = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gmh = jSONObject.optString("text_pre");
            this.gmi = jSONObject.optString("text_color");
            this.gmj = jSONObject.optString("text_mid");
            this.gmk = jSONObject.optString("text_suf");
            this.gml = jSONObject.optString("num_notice");
            this.gmm = jSONObject.optInt("show_dialog");
            this.gmn = jSONObject.optString("sign_notice");
            this.gmo = jSONObject.optInt("valid", 0);
            this.gmJ = jSONObject.optInt("sign_max_num", 50);
            this.gmy = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gmz = jSONObject.optString("button_content");
            JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
            if (optJSONObject != null) {
                this.blockPopInfoData = new BlockPopInfoData();
                this.blockPopInfoData.block_info = optJSONObject.optString("block_content");
                this.blockPopInfoData.ahead_info = optJSONObject.optString("block_confirm");
                this.blockPopInfoData.ahead_url = optJSONObject.optString("block_dealurl");
                this.blockPopInfoData.ok_info = optJSONObject.optString("block_cancel");
            }
            if (this.gmy == 1) {
                this.gmp = true;
            } else {
                this.gmp = false;
            }
            this.gmv = this.level + this.title;
            this.gmu = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(d.k.sign_all_forum_tip);
            j.gop = this.gmJ;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.gop);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.box() == 0) {
                            if (this.gmo == 0) {
                                if (this.gmp) {
                                    dVar.mb(true);
                                } else if (dVar.boz() > this.level) {
                                    dVar.mb(true);
                                }
                            }
                            if (dVar.boz() >= this.level) {
                                this.gmt++;
                            } else {
                                this.gmr++;
                            }
                            this.gmG.add(dVar);
                            this.gmH.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.boz() >= this.level) {
                                this.gms++;
                            } else {
                                this.gmq++;
                            }
                            this.gmF.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.boE(), -1);
                        }
                        this.gmE.add(dVar);
                        Collections.sort(this.gmE, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.boz() - dVar2.boz();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.gmK == null) {
                this.gmK = new f();
            }
            this.gmK.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gmL == null) {
                this.gmL = new k();
            }
            this.gmL.parserJson(optJSONObject3);
            lZ(false);
        }
    }

    private void lZ(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gmE.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gmE.removeAll(arrayList);
        }
        if (this.gmt + this.gms > 0) {
            if (this.gms > 0) {
                this.gmx = TbadkApplication.getInst().getContext().getString(d.k.signallforum_res, Integer.valueOf(this.gms), Integer.valueOf(this.gmt));
            } else {
                this.gmx = TbadkApplication.getInst().getContext().getString(d.k.signallforum_count, Integer.valueOf(this.gmt + this.gms));
            }
            if (this.gmE.size() > 0) {
                this.gmE.add(0, new b(this.gmv, this.gmx));
            }
        }
        if (this.gmr + this.gmq > 0) {
            if (this.gmq > 0) {
                this.gmw = TbadkApplication.getInst().getContext().getString(d.k.signallforum_res, Integer.valueOf(this.gmq), Integer.valueOf(this.gmr));
            } else {
                this.gmw = TbadkApplication.getInst().getContext().getString(d.k.signallforum_count, Integer.valueOf(this.gmr + this.gmq));
            }
            if (this.gmt + this.gms > 0) {
                if (this.gmE.size() > this.gmt + this.gms + 1) {
                    this.gmE.add(this.gmt + this.gms + 1, new b(this.gmu, this.gmw));
                }
            } else if (this.gmE.size() > 0) {
                this.gmE.add(0, new b(this.gmu, this.gmw));
            }
        }
        if (this.gmE.size() <= 0) {
            this.gmA = 3;
        } else if (this.gmp) {
            if (this.gmo == 1 && this.gmG.size() > 0) {
                this.gmA = 0;
            } else {
                this.gmA = 2;
            }
        } else if (this.gmo == 1 && this.gmt > 0) {
            this.gmA = 0;
        } else if (this.gmt + this.gms > 0) {
            this.gmA = 2;
        } else if (this.gmt + this.gms <= 0) {
            this.gmA = 3;
        }
    }
}
