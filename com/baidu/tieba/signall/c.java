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
    private String gmA;
    private int gmB;
    private String gmC;
    private int gmD;
    private boolean gmE;
    private int gmF;
    private int gmG;
    private int gmM;
    private String gmk;
    private String gml;
    private String gmm;
    private String gmn;
    private String gmo;
    private int gmp;
    private String gmq;
    private int gmr;
    private boolean gms;
    private int gmt;
    private int gmu;
    private int gmv;
    private int gmw;
    private String gmx;
    private String gmy;
    private String gmz;
    private int level;
    private String title;
    private String gmj = "0";
    private ArrayList<d> gmH = new ArrayList<>();
    private ArrayList<d> gmI = new ArrayList<>();
    private ArrayList<d> gmJ = new ArrayList<>();
    private HashMap<String, d> gmK = new HashMap<>();
    private a gmL = new a();
    private f gmN = new f();
    private k gmO = new k();

    public boolean bob() {
        return (this.gmN == null || StringUtils.isNull(this.gmN.gng)) ? false : true;
    }

    public String Hx() {
        return this.gmN.VS;
    }

    public String boc() {
        return this.gmN.gng;
    }

    public String bod() {
        return this.gmO.goE;
    }

    public String boe() {
        return this.gmO.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bof() {
        return !StringUtils.isNull(this.gmj) && this.gmj.equals("1");
    }

    public String bog() {
        return this.gmk;
    }

    public String bcj() {
        return this.gml;
    }

    public String boh() {
        return this.gmm;
    }

    public String boi() {
        return this.gmn;
    }

    public String boj() {
        return this.gmo;
    }

    public int bok() {
        return this.gmp;
    }

    public String bol() {
        return this.gmq;
    }

    public ArrayList<d> bom() {
        return this.gmH;
    }

    public a bon() {
        return this.gmL;
    }

    public ArrayList<d> boo() {
        return this.gmI;
    }

    public ArrayList<d> bop() {
        return this.gmJ;
    }

    public boolean boq() {
        return this.gms;
    }

    public String bor() {
        return this.gmC;
    }

    public String getContent() {
        return this.content;
    }

    public int bos() {
        return this.gmD;
    }

    public boolean bot() {
        return this.gmE;
    }

    public int bou() {
        return this.gmF;
    }

    public int bov() {
        return this.gmG;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gmK.get(signData.forumId)) != null) {
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
            this.gmv++;
            this.gmw--;
        } else {
            this.gmt++;
            this.gmu--;
        }
        this.gmK.remove(String.valueOf(dVar.getForumId()));
        this.gmJ.remove(dVar);
        if (dVar.boA() + dVar.boE() >= dVar.boB()) {
            dVar.sR(dVar.boz() + 1);
            dVar.md(true);
            if (dVar.boz() == this.level) {
                this.gmv++;
                this.gmt--;
            }
        }
        this.gmI.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.boE(), -1);
    }

    private void bow() {
        if (this.gms) {
            if (this.gmw + this.gmu <= 0) {
                this.gmE = true;
            } else {
                this.gmE = false;
            }
        } else if (this.gmw <= 0) {
            this.gmE = true;
        } else {
            this.gmE = false;
        }
    }

    public void a(h hVar) {
        this.gmF = 0;
        this.gmG = 0;
        ArrayList<i> boN = hVar.boN();
        int size = boN.size();
        for (int i = 0; i < size; i++) {
            i iVar = boN.get(i);
            d dVar = this.gmK.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.boQ() != 0) {
                    this.gmF++;
                    dVar.sP(1);
                    dVar.sQ(iVar.boR());
                    dVar.sS(iVar.getCurScore());
                    dVar.ma(true);
                    dVar.mb(false);
                    dVar.mc(false);
                    a(dVar);
                } else {
                    this.gmG++;
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
            this.gmL.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.gmj = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gmk = jSONObject.optString("text_pre");
            this.gml = jSONObject.optString("text_color");
            this.gmm = jSONObject.optString("text_mid");
            this.gmn = jSONObject.optString("text_suf");
            this.gmo = jSONObject.optString("num_notice");
            this.gmp = jSONObject.optInt("show_dialog");
            this.gmq = jSONObject.optString("sign_notice");
            this.gmr = jSONObject.optInt("valid", 0);
            this.gmM = jSONObject.optInt("sign_max_num", 50);
            this.gmB = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gmC = jSONObject.optString("button_content");
            JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
            if (optJSONObject != null) {
                this.blockPopInfoData = new BlockPopInfoData();
                this.blockPopInfoData.block_info = optJSONObject.optString("block_content");
                this.blockPopInfoData.ahead_info = optJSONObject.optString("block_confirm");
                this.blockPopInfoData.ahead_url = optJSONObject.optString("block_dealurl");
                this.blockPopInfoData.ok_info = optJSONObject.optString("block_cancel");
            }
            if (this.gmB == 1) {
                this.gms = true;
            } else {
                this.gms = false;
            }
            this.gmy = this.level + this.title;
            this.gmx = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(d.k.sign_all_forum_tip);
            j.gos = this.gmM;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.gos);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.box() == 0) {
                            if (this.gmr == 0) {
                                if (this.gms) {
                                    dVar.mb(true);
                                } else if (dVar.boz() > this.level) {
                                    dVar.mb(true);
                                }
                            }
                            if (dVar.boz() >= this.level) {
                                this.gmw++;
                            } else {
                                this.gmu++;
                            }
                            this.gmJ.add(dVar);
                            this.gmK.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.boz() >= this.level) {
                                this.gmv++;
                            } else {
                                this.gmt++;
                            }
                            this.gmI.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.boE(), -1);
                        }
                        this.gmH.add(dVar);
                        Collections.sort(this.gmH, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
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
            if (this.gmN == null) {
                this.gmN = new f();
            }
            this.gmN.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gmO == null) {
                this.gmO = new k();
            }
            this.gmO.parserJson(optJSONObject3);
            lZ(false);
        }
    }

    private void lZ(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gmH.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gmH.removeAll(arrayList);
        }
        if (this.gmw + this.gmv > 0) {
            if (this.gmv > 0) {
                this.gmA = TbadkApplication.getInst().getContext().getString(d.k.signallforum_res, Integer.valueOf(this.gmv), Integer.valueOf(this.gmw));
            } else {
                this.gmA = TbadkApplication.getInst().getContext().getString(d.k.signallforum_count, Integer.valueOf(this.gmw + this.gmv));
            }
            if (this.gmH.size() > 0) {
                this.gmH.add(0, new b(this.gmy, this.gmA));
            }
        }
        if (this.gmu + this.gmt > 0) {
            if (this.gmt > 0) {
                this.gmz = TbadkApplication.getInst().getContext().getString(d.k.signallforum_res, Integer.valueOf(this.gmt), Integer.valueOf(this.gmu));
            } else {
                this.gmz = TbadkApplication.getInst().getContext().getString(d.k.signallforum_count, Integer.valueOf(this.gmu + this.gmt));
            }
            if (this.gmw + this.gmv > 0) {
                if (this.gmH.size() > this.gmw + this.gmv + 1) {
                    this.gmH.add(this.gmw + this.gmv + 1, new b(this.gmx, this.gmz));
                }
            } else if (this.gmH.size() > 0) {
                this.gmH.add(0, new b(this.gmx, this.gmz));
            }
        }
        if (this.gmH.size() <= 0) {
            this.gmD = 3;
        } else if (this.gms) {
            if (this.gmr == 1 && this.gmJ.size() > 0) {
                this.gmD = 0;
            } else {
                this.gmD = 2;
            }
        } else if (this.gmr == 1 && this.gmw > 0) {
            this.gmD = 0;
        } else if (this.gmw + this.gmv > 0) {
            this.gmD = 2;
        } else if (this.gmw + this.gmv <= 0) {
            this.gmD = 3;
        }
    }
}
