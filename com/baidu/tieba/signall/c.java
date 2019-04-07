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
    private String akm;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String iwM;
    private String iwN;
    private String iwO;
    private String iwP;
    private int iwQ;
    private String iwR;
    private int iwS;
    private boolean iwT;
    private int iwU;
    private int iwV;
    private int iwW;
    private int iwX;
    private String iwY;
    private String iwZ;
    private String ixa;
    private String ixb;
    private int ixc;
    private String ixd;
    private int ixe;
    private boolean ixf;
    private int ixg;
    private int ixh;
    private int ixn;
    private int level;
    private String title;
    private String iwL = "0";
    private ArrayList<d> ixi = new ArrayList<>();
    private ArrayList<d> ixj = new ArrayList<>();
    private ArrayList<d> ixk = new ArrayList<>();
    private HashMap<String, d> ixl = new HashMap<>();
    private a ixm = new a();
    private f ixo = new f();
    private k ixp = new k();

    public boolean cby() {
        return (this.ixo == null || StringUtils.isNull(this.ixo.ixH)) ? false : true;
    }

    public String apM() {
        return this.ixo.bwI;
    }

    public String cbz() {
        return this.ixo.ixH;
    }

    public String cbA() {
        return this.ixp.izb;
    }

    public String cbB() {
        return this.ixp.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cbC() {
        return !StringUtils.isNull(this.iwL) && this.iwL.equals("1");
    }

    public String cbD() {
        return this.iwM;
    }

    public String bOU() {
        return this.akm;
    }

    public String cbE() {
        return this.iwN;
    }

    public String cbF() {
        return this.iwO;
    }

    public String cbG() {
        return this.iwP;
    }

    public int cbH() {
        return this.iwQ;
    }

    public String cbI() {
        return this.iwR;
    }

    public ArrayList<d> cbJ() {
        return this.ixi;
    }

    public a cbK() {
        return this.ixm;
    }

    public ArrayList<d> cbL() {
        return this.ixj;
    }

    public ArrayList<d> cbM() {
        return this.ixk;
    }

    public boolean cbN() {
        return this.iwT;
    }

    public String cbO() {
        return this.ixd;
    }

    public String getContent() {
        return this.content;
    }

    public int cbP() {
        return this.ixe;
    }

    public boolean cbQ() {
        return this.ixf;
    }

    public int cbR() {
        return this.ixg;
    }

    public int cbS() {
        return this.ixh;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.ixl.get(signData.forumId)) != null) {
            dVar.yW(1);
            dVar.yX(signData.count_sign_num);
            dVar.yZ(signData.sign_bonus_point);
            dVar.pJ(true);
            dVar.pK(false);
            dVar.pL(false);
            a(dVar);
            cbT();
            pI(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cbW() >= this.level) {
            this.iwW++;
            this.iwX--;
        } else {
            this.iwU++;
            this.iwV--;
        }
        this.ixl.remove(String.valueOf(dVar.getForumId()));
        this.ixk.remove(dVar);
        if (dVar.cbX() + dVar.ccb() >= dVar.cbY()) {
            dVar.yY(dVar.cbW() + 1);
            dVar.pM(true);
            if (dVar.cbW() == this.level) {
                this.iwW++;
                this.iwU--;
            }
        }
        this.ixj.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.ccb(), -1);
    }

    private void cbT() {
        if (this.iwT) {
            if (this.iwX + this.iwV <= 0) {
                this.ixf = true;
            } else {
                this.ixf = false;
            }
        } else if (this.iwX <= 0) {
            this.ixf = true;
        } else {
            this.ixf = false;
        }
    }

    public void a(h hVar) {
        this.ixg = 0;
        this.ixh = 0;
        ArrayList<i> ccl = hVar.ccl();
        int size = ccl.size();
        for (int i = 0; i < size; i++) {
            i iVar = ccl.get(i);
            d dVar = this.ixl.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cco() != 0) {
                    this.ixg++;
                    dVar.yW(1);
                    dVar.yX(iVar.ccp());
                    dVar.yZ(iVar.getCurScore());
                    dVar.pJ(true);
                    dVar.pK(false);
                    dVar.pL(false);
                    a(dVar);
                } else {
                    this.ixh++;
                    dVar.pJ(false);
                    dVar.pK(true);
                    dVar.pL(false);
                    dVar.setErrorMsg(iVar.cbK().getUserMsg());
                }
            }
        }
        cbT();
        pI(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.ixm.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.iwL = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.iwM = jSONObject.optString("text_pre");
            this.akm = jSONObject.optString("text_color");
            this.iwN = jSONObject.optString("text_mid");
            this.iwO = jSONObject.optString("text_suf");
            this.iwP = jSONObject.optString("num_notice");
            this.iwQ = jSONObject.optInt("show_dialog");
            this.iwR = jSONObject.optString("sign_notice");
            this.iwS = jSONObject.optInt("valid", 0);
            this.ixn = jSONObject.optInt("sign_max_num", 50);
            this.ixc = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.ixd = jSONObject.optString("button_content");
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
            if (this.ixc == 1) {
                this.iwT = true;
            } else {
                this.iwT = false;
            }
            this.iwZ = this.level + this.title;
            this.iwY = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(d.j.sign_all_forum_tip);
            j.iyR = this.ixn;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.iyR);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cbU() == 0) {
                            if (this.iwS == 0) {
                                if (this.iwT) {
                                    dVar.pK(true);
                                } else if (dVar.cbW() > this.level) {
                                    dVar.pK(true);
                                }
                            }
                            if (dVar.cbW() >= this.level) {
                                this.iwX++;
                            } else {
                                this.iwV++;
                            }
                            this.ixk.add(dVar);
                            this.ixl.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cbW() >= this.level) {
                                this.iwW++;
                            } else {
                                this.iwU++;
                            }
                            this.ixj.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.ccb(), -1);
                        }
                        this.ixi.add(dVar);
                        Collections.sort(this.ixi, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cbW() - dVar2.cbW();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.ixo == null) {
                this.ixo = new f();
            }
            this.ixo.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.ixp == null) {
                this.ixp = new k();
            }
            this.ixp.parserJson(optJSONObject3);
            pI(false);
        }
    }

    private void pI(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.ixi.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.ixi.removeAll(arrayList);
        }
        if (this.iwX + this.iwW > 0) {
            if (this.iwW > 0) {
                this.ixb = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.iwW), Integer.valueOf(this.iwX));
            } else {
                this.ixb = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.iwX + this.iwW));
            }
            if (this.ixi.size() > 0) {
                this.ixi.add(0, new b(this.iwZ, this.ixb));
            }
        }
        if (this.iwV + this.iwU > 0) {
            if (this.iwU > 0) {
                this.ixa = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.iwU), Integer.valueOf(this.iwV));
            } else {
                this.ixa = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.iwV + this.iwU));
            }
            if (this.iwX + this.iwW > 0) {
                if (this.ixi.size() > this.iwX + this.iwW + 1) {
                    this.ixi.add(this.iwX + this.iwW + 1, new b(this.iwY, this.ixa));
                }
            } else if (this.ixi.size() > 0) {
                this.ixi.add(0, new b(this.iwY, this.ixa));
            }
        }
        if (this.ixi.size() <= 0) {
            this.ixe = 3;
        } else if (this.iwT) {
            if (this.iwS == 1 && this.ixk.size() > 0) {
                this.ixe = 0;
            } else {
                this.ixe = 2;
            }
        } else if (this.iwS == 1 && this.iwX > 0) {
            this.ixe = 0;
        } else if (this.iwX + this.iwW > 0) {
            this.ixe = 2;
        } else if (this.iwX + this.iwW <= 0) {
            this.ixe = 3;
        }
    }
}
