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
    private String akn;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String iwN;
    private String iwO;
    private String iwP;
    private String iwQ;
    private int iwR;
    private String iwS;
    private int iwT;
    private boolean iwU;
    private int iwV;
    private int iwW;
    private int iwX;
    private int iwY;
    private String iwZ;
    private String ixa;
    private String ixb;
    private String ixc;
    private int ixd;
    private String ixe;
    private int ixf;
    private boolean ixg;
    private int ixh;
    private int ixi;
    private int ixo;
    private int level;
    private String title;
    private String iwM = "0";
    private ArrayList<d> ixj = new ArrayList<>();
    private ArrayList<d> ixk = new ArrayList<>();
    private ArrayList<d> ixl = new ArrayList<>();
    private HashMap<String, d> ixm = new HashMap<>();
    private a ixn = new a();
    private f ixp = new f();
    private k ixq = new k();

    public boolean cby() {
        return (this.ixp == null || StringUtils.isNull(this.ixp.ixI)) ? false : true;
    }

    public String apM() {
        return this.ixp.bwJ;
    }

    public String cbz() {
        return this.ixp.ixI;
    }

    public String cbA() {
        return this.ixq.izc;
    }

    public String cbB() {
        return this.ixq.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cbC() {
        return !StringUtils.isNull(this.iwM) && this.iwM.equals("1");
    }

    public String cbD() {
        return this.iwN;
    }

    public String bOU() {
        return this.akn;
    }

    public String cbE() {
        return this.iwO;
    }

    public String cbF() {
        return this.iwP;
    }

    public String cbG() {
        return this.iwQ;
    }

    public int cbH() {
        return this.iwR;
    }

    public String cbI() {
        return this.iwS;
    }

    public ArrayList<d> cbJ() {
        return this.ixj;
    }

    public a cbK() {
        return this.ixn;
    }

    public ArrayList<d> cbL() {
        return this.ixk;
    }

    public ArrayList<d> cbM() {
        return this.ixl;
    }

    public boolean cbN() {
        return this.iwU;
    }

    public String cbO() {
        return this.ixe;
    }

    public String getContent() {
        return this.content;
    }

    public int cbP() {
        return this.ixf;
    }

    public boolean cbQ() {
        return this.ixg;
    }

    public int cbR() {
        return this.ixh;
    }

    public int cbS() {
        return this.ixi;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.ixm.get(signData.forumId)) != null) {
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
            this.iwX++;
            this.iwY--;
        } else {
            this.iwV++;
            this.iwW--;
        }
        this.ixm.remove(String.valueOf(dVar.getForumId()));
        this.ixl.remove(dVar);
        if (dVar.cbX() + dVar.ccb() >= dVar.cbY()) {
            dVar.yY(dVar.cbW() + 1);
            dVar.pM(true);
            if (dVar.cbW() == this.level) {
                this.iwX++;
                this.iwV--;
            }
        }
        this.ixk.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.ccb(), -1);
    }

    private void cbT() {
        if (this.iwU) {
            if (this.iwY + this.iwW <= 0) {
                this.ixg = true;
            } else {
                this.ixg = false;
            }
        } else if (this.iwY <= 0) {
            this.ixg = true;
        } else {
            this.ixg = false;
        }
    }

    public void a(h hVar) {
        this.ixh = 0;
        this.ixi = 0;
        ArrayList<i> ccl = hVar.ccl();
        int size = ccl.size();
        for (int i = 0; i < size; i++) {
            i iVar = ccl.get(i);
            d dVar = this.ixm.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cco() != 0) {
                    this.ixh++;
                    dVar.yW(1);
                    dVar.yX(iVar.ccp());
                    dVar.yZ(iVar.getCurScore());
                    dVar.pJ(true);
                    dVar.pK(false);
                    dVar.pL(false);
                    a(dVar);
                } else {
                    this.ixi++;
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
            this.ixn.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.iwM = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.iwN = jSONObject.optString("text_pre");
            this.akn = jSONObject.optString("text_color");
            this.iwO = jSONObject.optString("text_mid");
            this.iwP = jSONObject.optString("text_suf");
            this.iwQ = jSONObject.optString("num_notice");
            this.iwR = jSONObject.optInt("show_dialog");
            this.iwS = jSONObject.optString("sign_notice");
            this.iwT = jSONObject.optInt("valid", 0);
            this.ixo = jSONObject.optInt("sign_max_num", 50);
            this.ixd = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.ixe = jSONObject.optString("button_content");
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
            if (this.ixd == 1) {
                this.iwU = true;
            } else {
                this.iwU = false;
            }
            this.ixa = this.level + this.title;
            this.iwZ = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(d.j.sign_all_forum_tip);
            j.iyS = this.ixo;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.iyS);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cbU() == 0) {
                            if (this.iwT == 0) {
                                if (this.iwU) {
                                    dVar.pK(true);
                                } else if (dVar.cbW() > this.level) {
                                    dVar.pK(true);
                                }
                            }
                            if (dVar.cbW() >= this.level) {
                                this.iwY++;
                            } else {
                                this.iwW++;
                            }
                            this.ixl.add(dVar);
                            this.ixm.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cbW() >= this.level) {
                                this.iwX++;
                            } else {
                                this.iwV++;
                            }
                            this.ixk.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.ccb(), -1);
                        }
                        this.ixj.add(dVar);
                        Collections.sort(this.ixj, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
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
            if (this.ixp == null) {
                this.ixp = new f();
            }
            this.ixp.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.ixq == null) {
                this.ixq = new k();
            }
            this.ixq.parserJson(optJSONObject3);
            pI(false);
        }
    }

    private void pI(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.ixj.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.ixj.removeAll(arrayList);
        }
        if (this.iwY + this.iwX > 0) {
            if (this.iwX > 0) {
                this.ixc = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.iwX), Integer.valueOf(this.iwY));
            } else {
                this.ixc = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.iwY + this.iwX));
            }
            if (this.ixj.size() > 0) {
                this.ixj.add(0, new b(this.ixa, this.ixc));
            }
        }
        if (this.iwW + this.iwV > 0) {
            if (this.iwV > 0) {
                this.ixb = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.iwV), Integer.valueOf(this.iwW));
            } else {
                this.ixb = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.iwW + this.iwV));
            }
            if (this.iwY + this.iwX > 0) {
                if (this.ixj.size() > this.iwY + this.iwX + 1) {
                    this.ixj.add(this.iwY + this.iwX + 1, new b(this.iwZ, this.ixb));
                }
            } else if (this.ixj.size() > 0) {
                this.ixj.add(0, new b(this.iwZ, this.ixb));
            }
        }
        if (this.ixj.size() <= 0) {
            this.ixf = 3;
        } else if (this.iwU) {
            if (this.iwT == 1 && this.ixl.size() > 0) {
                this.ixf = 0;
            } else {
                this.ixf = 2;
            }
        } else if (this.iwT == 1 && this.iwY > 0) {
            this.ixf = 0;
        } else if (this.iwY + this.iwX > 0) {
            this.ixf = 2;
        } else if (this.iwY + this.iwX <= 0) {
            this.ixf = 3;
        }
    }
}
