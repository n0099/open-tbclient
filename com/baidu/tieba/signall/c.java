package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.f;
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
    private String gDP;
    private String gDQ;
    private String gDR;
    private String gDS;
    private String gDT;
    private int gDU;
    private String gDV;
    private int gDW;
    private boolean gDX;
    private int gDY;
    private int gDZ;
    private int gEa;
    private int gEb;
    private String gEc;
    private String gEd;
    private String gEe;
    private String gEf;
    private int gEg;
    private String gEh;
    private int gEi;
    private boolean gEj;
    private int gEk;
    private int gEl;
    private int gEr;
    private int level;
    private String title;
    private String gDO = "0";
    private ArrayList<d> gEm = new ArrayList<>();
    private ArrayList<d> gEn = new ArrayList<>();
    private ArrayList<d> gEo = new ArrayList<>();
    private HashMap<String, d> gEp = new HashMap<>();
    private a gEq = new a();
    private f gEs = new f();
    private k gEt = new k();

    public boolean bsd() {
        return (this.gEs == null || StringUtils.isNull(this.gEs.gEL)) ? false : true;
    }

    public String Lg() {
        return this.gEs.adH;
    }

    public String bse() {
        return this.gEs.gEL;
    }

    public String bsf() {
        return this.gEt.gGj;
    }

    public String bsg() {
        return this.gEt.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bsh() {
        return !StringUtils.isNull(this.gDO) && this.gDO.equals("1");
    }

    public String bsi() {
        return this.gDP;
    }

    public String bgd() {
        return this.gDQ;
    }

    public String bsj() {
        return this.gDR;
    }

    public String bsk() {
        return this.gDS;
    }

    public String bsl() {
        return this.gDT;
    }

    public int bsm() {
        return this.gDU;
    }

    public String bsn() {
        return this.gDV;
    }

    public ArrayList<d> bso() {
        return this.gEm;
    }

    public a bsp() {
        return this.gEq;
    }

    public ArrayList<d> bsq() {
        return this.gEn;
    }

    public ArrayList<d> bsr() {
        return this.gEo;
    }

    public boolean bss() {
        return this.gDX;
    }

    public String bst() {
        return this.gEh;
    }

    public String getContent() {
        return this.content;
    }

    public int bsu() {
        return this.gEi;
    }

    public boolean bsv() {
        return this.gEj;
    }

    public int bsw() {
        return this.gEk;
    }

    public int bsx() {
        return this.gEl;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gEp.get(signData.forumId)) != null) {
            dVar.ti(1);
            dVar.tj(signData.count_sign_num);
            dVar.tl(signData.sign_bonus_point);
            dVar.md(true);
            dVar.me(false);
            dVar.mf(false);
            a(dVar);
            bsy();
            mc(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bsB() >= this.level) {
            this.gEa++;
            this.gEb--;
        } else {
            this.gDY++;
            this.gDZ--;
        }
        this.gEp.remove(String.valueOf(dVar.getForumId()));
        this.gEo.remove(dVar);
        if (dVar.bsC() + dVar.bsG() >= dVar.bsD()) {
            dVar.tk(dVar.bsB() + 1);
            dVar.mg(true);
            if (dVar.bsB() == this.level) {
                this.gEa++;
                this.gDY--;
            }
        }
        this.gEn.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bsG(), -1);
    }

    private void bsy() {
        if (this.gDX) {
            if (this.gEb + this.gDZ <= 0) {
                this.gEj = true;
            } else {
                this.gEj = false;
            }
        } else if (this.gEb <= 0) {
            this.gEj = true;
        } else {
            this.gEj = false;
        }
    }

    public void a(h hVar) {
        this.gEk = 0;
        this.gEl = 0;
        ArrayList<i> bsP = hVar.bsP();
        int size = bsP.size();
        for (int i = 0; i < size; i++) {
            i iVar = bsP.get(i);
            d dVar = this.gEp.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.bsS() != 0) {
                    this.gEk++;
                    dVar.ti(1);
                    dVar.tj(iVar.bsT());
                    dVar.tl(iVar.getCurScore());
                    dVar.md(true);
                    dVar.me(false);
                    dVar.mf(false);
                    a(dVar);
                } else {
                    this.gEl++;
                    dVar.md(false);
                    dVar.me(true);
                    dVar.mf(false);
                    dVar.setErrorMsg(iVar.bsp().getUserMsg());
                }
            }
        }
        bsy();
        mc(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gEq.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.gDO = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gDP = jSONObject.optString("text_pre");
            this.gDQ = jSONObject.optString("text_color");
            this.gDR = jSONObject.optString("text_mid");
            this.gDS = jSONObject.optString("text_suf");
            this.gDT = jSONObject.optString("num_notice");
            this.gDU = jSONObject.optInt("show_dialog");
            this.gDV = jSONObject.optString("sign_notice");
            this.gDW = jSONObject.optInt("valid", 0);
            this.gEr = jSONObject.optInt("sign_max_num", 50);
            this.gEg = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gEh = jSONObject.optString("button_content");
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
            if (this.gEg == 1) {
                this.gDX = true;
            } else {
                this.gDX = false;
            }
            this.gEd = this.level + this.title;
            this.gEc = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(f.j.sign_all_forum_tip);
            j.gFX = this.gEr;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.gFX);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.bsz() == 0) {
                            if (this.gDW == 0) {
                                if (this.gDX) {
                                    dVar.me(true);
                                } else if (dVar.bsB() > this.level) {
                                    dVar.me(true);
                                }
                            }
                            if (dVar.bsB() >= this.level) {
                                this.gEb++;
                            } else {
                                this.gDZ++;
                            }
                            this.gEo.add(dVar);
                            this.gEp.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bsB() >= this.level) {
                                this.gEa++;
                            } else {
                                this.gDY++;
                            }
                            this.gEn.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bsG(), -1);
                        }
                        this.gEm.add(dVar);
                        Collections.sort(this.gEm, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bsB() - dVar2.bsB();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.gEs == null) {
                this.gEs = new f();
            }
            this.gEs.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gEt == null) {
                this.gEt = new k();
            }
            this.gEt.parserJson(optJSONObject3);
            mc(false);
        }
    }

    private void mc(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gEm.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gEm.removeAll(arrayList);
        }
        if (this.gEb + this.gEa > 0) {
            if (this.gEa > 0) {
                this.gEf = TbadkApplication.getInst().getContext().getString(f.j.signallforum_res, Integer.valueOf(this.gEa), Integer.valueOf(this.gEb));
            } else {
                this.gEf = TbadkApplication.getInst().getContext().getString(f.j.signallforum_count, Integer.valueOf(this.gEb + this.gEa));
            }
            if (this.gEm.size() > 0) {
                this.gEm.add(0, new b(this.gEd, this.gEf));
            }
        }
        if (this.gDZ + this.gDY > 0) {
            if (this.gDY > 0) {
                this.gEe = TbadkApplication.getInst().getContext().getString(f.j.signallforum_res, Integer.valueOf(this.gDY), Integer.valueOf(this.gDZ));
            } else {
                this.gEe = TbadkApplication.getInst().getContext().getString(f.j.signallforum_count, Integer.valueOf(this.gDZ + this.gDY));
            }
            if (this.gEb + this.gEa > 0) {
                if (this.gEm.size() > this.gEb + this.gEa + 1) {
                    this.gEm.add(this.gEb + this.gEa + 1, new b(this.gEc, this.gEe));
                }
            } else if (this.gEm.size() > 0) {
                this.gEm.add(0, new b(this.gEc, this.gEe));
            }
        }
        if (this.gEm.size() <= 0) {
            this.gEi = 3;
        } else if (this.gDX) {
            if (this.gDW == 1 && this.gEo.size() > 0) {
                this.gEi = 0;
            } else {
                this.gEi = 2;
            }
        } else if (this.gDW == 1 && this.gEb > 0) {
            this.gEi = 0;
        } else if (this.gEb + this.gEa > 0) {
            this.gEi = 2;
        } else if (this.gEb + this.gEa <= 0) {
            this.gEi = 3;
        }
    }
}
