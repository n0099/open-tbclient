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
    private String gDM;
    private String gDN;
    private String gDO;
    private String gDP;
    private String gDQ;
    private int gDR;
    private String gDS;
    private int gDT;
    private boolean gDU;
    private int gDV;
    private int gDW;
    private int gDX;
    private int gDY;
    private String gDZ;
    private String gEa;
    private String gEb;
    private String gEc;
    private int gEd;
    private String gEe;
    private int gEf;
    private boolean gEg;
    private int gEh;
    private int gEi;
    private int gEo;
    private int level;
    private String title;
    private String gDL = "0";
    private ArrayList<d> gEj = new ArrayList<>();
    private ArrayList<d> gEk = new ArrayList<>();
    private ArrayList<d> gEl = new ArrayList<>();
    private HashMap<String, d> gEm = new HashMap<>();
    private a gEn = new a();
    private f gEp = new f();
    private k gEq = new k();

    public boolean bsc() {
        return (this.gEp == null || StringUtils.isNull(this.gEp.gEI)) ? false : true;
    }

    public String Lc() {
        return this.gEp.adH;
    }

    public String bsd() {
        return this.gEp.gEI;
    }

    public String bse() {
        return this.gEq.gGg;
    }

    public String bsf() {
        return this.gEq.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bsg() {
        return !StringUtils.isNull(this.gDL) && this.gDL.equals("1");
    }

    public String bsh() {
        return this.gDM;
    }

    public String bgi() {
        return this.gDN;
    }

    public String bsi() {
        return this.gDO;
    }

    public String bsj() {
        return this.gDP;
    }

    public String bsk() {
        return this.gDQ;
    }

    public int bsl() {
        return this.gDR;
    }

    public String bsm() {
        return this.gDS;
    }

    public ArrayList<d> bsn() {
        return this.gEj;
    }

    public a bso() {
        return this.gEn;
    }

    public ArrayList<d> bsp() {
        return this.gEk;
    }

    public ArrayList<d> bsq() {
        return this.gEl;
    }

    public boolean bsr() {
        return this.gDU;
    }

    public String bss() {
        return this.gEe;
    }

    public String getContent() {
        return this.content;
    }

    public int bst() {
        return this.gEf;
    }

    public boolean bsu() {
        return this.gEg;
    }

    public int bsv() {
        return this.gEh;
    }

    public int bsw() {
        return this.gEi;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gEm.get(signData.forumId)) != null) {
            dVar.ti(1);
            dVar.tj(signData.count_sign_num);
            dVar.tl(signData.sign_bonus_point);
            dVar.md(true);
            dVar.me(false);
            dVar.mf(false);
            a(dVar);
            bsx();
            mc(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bsA() >= this.level) {
            this.gDX++;
            this.gDY--;
        } else {
            this.gDV++;
            this.gDW--;
        }
        this.gEm.remove(String.valueOf(dVar.getForumId()));
        this.gEl.remove(dVar);
        if (dVar.bsB() + dVar.bsF() >= dVar.bsC()) {
            dVar.tk(dVar.bsA() + 1);
            dVar.mg(true);
            if (dVar.bsA() == this.level) {
                this.gDX++;
                this.gDV--;
            }
        }
        this.gEk.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bsF(), -1);
    }

    private void bsx() {
        if (this.gDU) {
            if (this.gDY + this.gDW <= 0) {
                this.gEg = true;
            } else {
                this.gEg = false;
            }
        } else if (this.gDY <= 0) {
            this.gEg = true;
        } else {
            this.gEg = false;
        }
    }

    public void a(h hVar) {
        this.gEh = 0;
        this.gEi = 0;
        ArrayList<i> bsO = hVar.bsO();
        int size = bsO.size();
        for (int i = 0; i < size; i++) {
            i iVar = bsO.get(i);
            d dVar = this.gEm.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.bsR() != 0) {
                    this.gEh++;
                    dVar.ti(1);
                    dVar.tj(iVar.bsS());
                    dVar.tl(iVar.getCurScore());
                    dVar.md(true);
                    dVar.me(false);
                    dVar.mf(false);
                    a(dVar);
                } else {
                    this.gEi++;
                    dVar.md(false);
                    dVar.me(true);
                    dVar.mf(false);
                    dVar.setErrorMsg(iVar.bso().getUserMsg());
                }
            }
        }
        bsx();
        mc(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gEn.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.gDL = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gDM = jSONObject.optString("text_pre");
            this.gDN = jSONObject.optString("text_color");
            this.gDO = jSONObject.optString("text_mid");
            this.gDP = jSONObject.optString("text_suf");
            this.gDQ = jSONObject.optString("num_notice");
            this.gDR = jSONObject.optInt("show_dialog");
            this.gDS = jSONObject.optString("sign_notice");
            this.gDT = jSONObject.optInt("valid", 0);
            this.gEo = jSONObject.optInt("sign_max_num", 50);
            this.gEd = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gEe = jSONObject.optString("button_content");
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
            if (this.gEd == 1) {
                this.gDU = true;
            } else {
                this.gDU = false;
            }
            this.gEa = this.level + this.title;
            this.gDZ = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(d.j.sign_all_forum_tip);
            j.gFU = this.gEo;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.gFU);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.bsy() == 0) {
                            if (this.gDT == 0) {
                                if (this.gDU) {
                                    dVar.me(true);
                                } else if (dVar.bsA() > this.level) {
                                    dVar.me(true);
                                }
                            }
                            if (dVar.bsA() >= this.level) {
                                this.gDY++;
                            } else {
                                this.gDW++;
                            }
                            this.gEl.add(dVar);
                            this.gEm.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bsA() >= this.level) {
                                this.gDX++;
                            } else {
                                this.gDV++;
                            }
                            this.gEk.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bsF(), -1);
                        }
                        this.gEj.add(dVar);
                        Collections.sort(this.gEj, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bsA() - dVar2.bsA();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.gEp == null) {
                this.gEp = new f();
            }
            this.gEp.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gEq == null) {
                this.gEq = new k();
            }
            this.gEq.parserJson(optJSONObject3);
            mc(false);
        }
    }

    private void mc(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gEj.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gEj.removeAll(arrayList);
        }
        if (this.gDY + this.gDX > 0) {
            if (this.gDX > 0) {
                this.gEc = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.gDX), Integer.valueOf(this.gDY));
            } else {
                this.gEc = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.gDY + this.gDX));
            }
            if (this.gEj.size() > 0) {
                this.gEj.add(0, new b(this.gEa, this.gEc));
            }
        }
        if (this.gDW + this.gDV > 0) {
            if (this.gDV > 0) {
                this.gEb = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.gDV), Integer.valueOf(this.gDW));
            } else {
                this.gEb = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.gDW + this.gDV));
            }
            if (this.gDY + this.gDX > 0) {
                if (this.gEj.size() > this.gDY + this.gDX + 1) {
                    this.gEj.add(this.gDY + this.gDX + 1, new b(this.gDZ, this.gEb));
                }
            } else if (this.gEj.size() > 0) {
                this.gEj.add(0, new b(this.gDZ, this.gEb));
            }
        }
        if (this.gEj.size() <= 0) {
            this.gEf = 3;
        } else if (this.gDU) {
            if (this.gDT == 1 && this.gEl.size() > 0) {
                this.gEf = 0;
            } else {
                this.gEf = 2;
            }
        } else if (this.gDT == 1 && this.gDY > 0) {
            this.gEf = 0;
        } else if (this.gDY + this.gDX > 0) {
            this.gEf = 2;
        } else if (this.gDY + this.gDX <= 0) {
            this.gEf = 3;
        }
    }
}
