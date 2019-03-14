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
/* loaded from: classes6.dex */
public class c {
    private String aki;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int ixD;
    private String ixc;
    private String ixd;
    private String ixe;
    private String ixf;
    private int ixg;
    private String ixh;
    private int ixi;
    private boolean ixj;
    private int ixk;
    private int ixl;
    private int ixm;
    private int ixn;
    private String ixo;
    private String ixp;
    private String ixq;
    private String ixr;
    private int ixs;
    private String ixt;
    private int ixu;
    private boolean ixv;
    private int ixw;
    private int ixx;
    private int level;
    private String title;
    private String ixb = "0";
    private ArrayList<d> ixy = new ArrayList<>();
    private ArrayList<d> ixz = new ArrayList<>();
    private ArrayList<d> ixA = new ArrayList<>();
    private HashMap<String, d> ixB = new HashMap<>();
    private a ixC = new a();
    private f ixE = new f();
    private k ixF = new k();

    public boolean cbC() {
        return (this.ixE == null || StringUtils.isNull(this.ixE.ixX)) ? false : true;
    }

    public String apP() {
        return this.ixE.bwF;
    }

    public String cbD() {
        return this.ixE.ixX;
    }

    public String cbE() {
        return this.ixF.izr;
    }

    public String cbF() {
        return this.ixF.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cbG() {
        return !StringUtils.isNull(this.ixb) && this.ixb.equals("1");
    }

    public String cbH() {
        return this.ixc;
    }

    public String bOX() {
        return this.aki;
    }

    public String cbI() {
        return this.ixd;
    }

    public String cbJ() {
        return this.ixe;
    }

    public String cbK() {
        return this.ixf;
    }

    public int cbL() {
        return this.ixg;
    }

    public String cbM() {
        return this.ixh;
    }

    public ArrayList<d> cbN() {
        return this.ixy;
    }

    public a cbO() {
        return this.ixC;
    }

    public ArrayList<d> cbP() {
        return this.ixz;
    }

    public ArrayList<d> cbQ() {
        return this.ixA;
    }

    public boolean cbR() {
        return this.ixj;
    }

    public String cbS() {
        return this.ixt;
    }

    public String getContent() {
        return this.content;
    }

    public int cbT() {
        return this.ixu;
    }

    public boolean cbU() {
        return this.ixv;
    }

    public int cbV() {
        return this.ixw;
    }

    public int cbW() {
        return this.ixx;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.ixB.get(signData.forumId)) != null) {
            dVar.za(1);
            dVar.zb(signData.count_sign_num);
            dVar.zd(signData.sign_bonus_point);
            dVar.pJ(true);
            dVar.pK(false);
            dVar.pL(false);
            a(dVar);
            cbX();
            pI(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cca() >= this.level) {
            this.ixm++;
            this.ixn--;
        } else {
            this.ixk++;
            this.ixl--;
        }
        this.ixB.remove(String.valueOf(dVar.getForumId()));
        this.ixA.remove(dVar);
        if (dVar.ccb() + dVar.ccf() >= dVar.ccc()) {
            dVar.zc(dVar.cca() + 1);
            dVar.pM(true);
            if (dVar.cca() == this.level) {
                this.ixm++;
                this.ixk--;
            }
        }
        this.ixz.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.ccf(), -1);
    }

    private void cbX() {
        if (this.ixj) {
            if (this.ixn + this.ixl <= 0) {
                this.ixv = true;
            } else {
                this.ixv = false;
            }
        } else if (this.ixn <= 0) {
            this.ixv = true;
        } else {
            this.ixv = false;
        }
    }

    public void a(h hVar) {
        this.ixw = 0;
        this.ixx = 0;
        ArrayList<i> ccp = hVar.ccp();
        int size = ccp.size();
        for (int i = 0; i < size; i++) {
            i iVar = ccp.get(i);
            d dVar = this.ixB.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.ccs() != 0) {
                    this.ixw++;
                    dVar.za(1);
                    dVar.zb(iVar.cct());
                    dVar.zd(iVar.getCurScore());
                    dVar.pJ(true);
                    dVar.pK(false);
                    dVar.pL(false);
                    a(dVar);
                } else {
                    this.ixx++;
                    dVar.pJ(false);
                    dVar.pK(true);
                    dVar.pL(false);
                    dVar.setErrorMsg(iVar.cbO().getUserMsg());
                }
            }
        }
        cbX();
        pI(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.ixC.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.ixb = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.ixc = jSONObject.optString("text_pre");
            this.aki = jSONObject.optString("text_color");
            this.ixd = jSONObject.optString("text_mid");
            this.ixe = jSONObject.optString("text_suf");
            this.ixf = jSONObject.optString("num_notice");
            this.ixg = jSONObject.optInt("show_dialog");
            this.ixh = jSONObject.optString("sign_notice");
            this.ixi = jSONObject.optInt("valid", 0);
            this.ixD = jSONObject.optInt("sign_max_num", 50);
            this.ixs = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.ixt = jSONObject.optString("button_content");
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
            if (this.ixs == 1) {
                this.ixj = true;
            } else {
                this.ixj = false;
            }
            this.ixp = this.level + this.title;
            this.ixo = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(d.j.sign_all_forum_tip);
            j.izh = this.ixD;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.izh);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cbY() == 0) {
                            if (this.ixi == 0) {
                                if (this.ixj) {
                                    dVar.pK(true);
                                } else if (dVar.cca() > this.level) {
                                    dVar.pK(true);
                                }
                            }
                            if (dVar.cca() >= this.level) {
                                this.ixn++;
                            } else {
                                this.ixl++;
                            }
                            this.ixA.add(dVar);
                            this.ixB.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cca() >= this.level) {
                                this.ixm++;
                            } else {
                                this.ixk++;
                            }
                            this.ixz.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.ccf(), -1);
                        }
                        this.ixy.add(dVar);
                        Collections.sort(this.ixy, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cca() - dVar2.cca();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.ixE == null) {
                this.ixE = new f();
            }
            this.ixE.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.ixF == null) {
                this.ixF = new k();
            }
            this.ixF.parserJson(optJSONObject3);
            pI(false);
        }
    }

    private void pI(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.ixy.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.ixy.removeAll(arrayList);
        }
        if (this.ixn + this.ixm > 0) {
            if (this.ixm > 0) {
                this.ixr = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.ixm), Integer.valueOf(this.ixn));
            } else {
                this.ixr = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.ixn + this.ixm));
            }
            if (this.ixy.size() > 0) {
                this.ixy.add(0, new b(this.ixp, this.ixr));
            }
        }
        if (this.ixl + this.ixk > 0) {
            if (this.ixk > 0) {
                this.ixq = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.ixk), Integer.valueOf(this.ixl));
            } else {
                this.ixq = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.ixl + this.ixk));
            }
            if (this.ixn + this.ixm > 0) {
                if (this.ixy.size() > this.ixn + this.ixm + 1) {
                    this.ixy.add(this.ixn + this.ixm + 1, new b(this.ixo, this.ixq));
                }
            } else if (this.ixy.size() > 0) {
                this.ixy.add(0, new b(this.ixo, this.ixq));
            }
        }
        if (this.ixy.size() <= 0) {
            this.ixu = 3;
        } else if (this.ixj) {
            if (this.ixi == 1 && this.ixA.size() > 0) {
                this.ixu = 0;
            } else {
                this.ixu = 2;
            }
        } else if (this.ixi == 1 && this.ixn > 0) {
            this.ixu = 0;
        } else if (this.ixn + this.ixm > 0) {
            this.ixu = 2;
        } else if (this.ixn + this.ixm <= 0) {
            this.ixu = 3;
        }
    }
}
