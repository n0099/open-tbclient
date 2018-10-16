package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.e;
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
    private String gSP;
    private String gSQ;
    private String gSR;
    private String gSS;
    private String gST;
    private int gSU;
    private String gSV;
    private int gSW;
    private boolean gSX;
    private int gSY;
    private int gSZ;
    private int gTa;
    private int gTb;
    private String gTc;
    private String gTd;
    private String gTe;
    private String gTf;
    private int gTg;
    private String gTh;
    private int gTi;
    private boolean gTj;
    private int gTk;
    private int gTl;
    private int gTr;
    private int level;
    private String title;
    private String gSO = "0";
    private ArrayList<d> gTm = new ArrayList<>();
    private ArrayList<d> gTn = new ArrayList<>();
    private ArrayList<d> gTo = new ArrayList<>();
    private HashMap<String, d> gTp = new HashMap<>();
    private a gTq = new a();
    private f gTs = new f();
    private k gTt = new k();

    public boolean bxX() {
        return (this.gTs == null || StringUtils.isNull(this.gTs.gTL)) ? false : true;
    }

    public String Ov() {
        return this.gTs.ale;
    }

    public String bxY() {
        return this.gTs.gTL;
    }

    public String bxZ() {
        return this.gTt.gVh;
    }

    public String bya() {
        return this.gTt.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean byb() {
        return !StringUtils.isNull(this.gSO) && this.gSO.equals("1");
    }

    public String byc() {
        return this.gSP;
    }

    public String blS() {
        return this.gSQ;
    }

    public String byd() {
        return this.gSR;
    }

    public String bye() {
        return this.gSS;
    }

    public String byf() {
        return this.gST;
    }

    public int byg() {
        return this.gSU;
    }

    public String byh() {
        return this.gSV;
    }

    public ArrayList<d> byi() {
        return this.gTm;
    }

    public a byj() {
        return this.gTq;
    }

    public ArrayList<d> byk() {
        return this.gTn;
    }

    public ArrayList<d> byl() {
        return this.gTo;
    }

    public boolean bym() {
        return this.gSX;
    }

    public String byn() {
        return this.gTh;
    }

    public String getContent() {
        return this.content;
    }

    public int byo() {
        return this.gTi;
    }

    public boolean byp() {
        return this.gTj;
    }

    public int byq() {
        return this.gTk;
    }

    public int byr() {
        return this.gTl;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gTp.get(signData.forumId)) != null) {
            dVar.uf(1);
            dVar.ug(signData.count_sign_num);
            dVar.ui(signData.sign_bonus_point);
            dVar.mS(true);
            dVar.mT(false);
            dVar.mU(false);
            a(dVar);
            bys();
            mR(true);
        }
    }

    private void a(d dVar) {
        if (dVar.byv() >= this.level) {
            this.gTa++;
            this.gTb--;
        } else {
            this.gSY++;
            this.gSZ--;
        }
        this.gTp.remove(String.valueOf(dVar.getForumId()));
        this.gTo.remove(dVar);
        if (dVar.byw() + dVar.byA() >= dVar.byx()) {
            dVar.uh(dVar.byv() + 1);
            dVar.mV(true);
            if (dVar.byv() == this.level) {
                this.gTa++;
                this.gSY--;
            }
        }
        this.gTn.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.byA(), -1);
    }

    private void bys() {
        if (this.gSX) {
            if (this.gTb + this.gSZ <= 0) {
                this.gTj = true;
            } else {
                this.gTj = false;
            }
        } else if (this.gTb <= 0) {
            this.gTj = true;
        } else {
            this.gTj = false;
        }
    }

    public void a(h hVar) {
        this.gTk = 0;
        this.gTl = 0;
        ArrayList<i> byK = hVar.byK();
        int size = byK.size();
        for (int i = 0; i < size; i++) {
            i iVar = byK.get(i);
            d dVar = this.gTp.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.byN() != 0) {
                    this.gTk++;
                    dVar.uf(1);
                    dVar.ug(iVar.byO());
                    dVar.ui(iVar.getCurScore());
                    dVar.mS(true);
                    dVar.mT(false);
                    dVar.mU(false);
                    a(dVar);
                } else {
                    this.gTl++;
                    dVar.mS(false);
                    dVar.mT(true);
                    dVar.mU(false);
                    dVar.setErrorMsg(iVar.byj().getUserMsg());
                }
            }
        }
        bys();
        mR(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gTq.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.gSO = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gSP = jSONObject.optString("text_pre");
            this.gSQ = jSONObject.optString("text_color");
            this.gSR = jSONObject.optString("text_mid");
            this.gSS = jSONObject.optString("text_suf");
            this.gST = jSONObject.optString("num_notice");
            this.gSU = jSONObject.optInt("show_dialog");
            this.gSV = jSONObject.optString("sign_notice");
            this.gSW = jSONObject.optInt("valid", 0);
            this.gTr = jSONObject.optInt("sign_max_num", 50);
            this.gTg = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gTh = jSONObject.optString("button_content");
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
            if (this.gTg == 1) {
                this.gSX = true;
            } else {
                this.gSX = false;
            }
            this.gTd = this.level + this.title;
            this.gTc = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(e.j.sign_all_forum_tip);
            j.gUX = this.gTr;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.gUX);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.byt() == 0) {
                            if (this.gSW == 0) {
                                if (this.gSX) {
                                    dVar.mT(true);
                                } else if (dVar.byv() > this.level) {
                                    dVar.mT(true);
                                }
                            }
                            if (dVar.byv() >= this.level) {
                                this.gTb++;
                            } else {
                                this.gSZ++;
                            }
                            this.gTo.add(dVar);
                            this.gTp.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.byv() >= this.level) {
                                this.gTa++;
                            } else {
                                this.gSY++;
                            }
                            this.gTn.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.byA(), -1);
                        }
                        this.gTm.add(dVar);
                        Collections.sort(this.gTm, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.byv() - dVar2.byv();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.gTs == null) {
                this.gTs = new f();
            }
            this.gTs.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gTt == null) {
                this.gTt = new k();
            }
            this.gTt.parserJson(optJSONObject3);
            mR(false);
        }
    }

    private void mR(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gTm.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gTm.removeAll(arrayList);
        }
        if (this.gTb + this.gTa > 0) {
            if (this.gTa > 0) {
                this.gTf = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.gTa), Integer.valueOf(this.gTb));
            } else {
                this.gTf = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.gTb + this.gTa));
            }
            if (this.gTm.size() > 0) {
                this.gTm.add(0, new b(this.gTd, this.gTf));
            }
        }
        if (this.gSZ + this.gSY > 0) {
            if (this.gSY > 0) {
                this.gTe = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.gSY), Integer.valueOf(this.gSZ));
            } else {
                this.gTe = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.gSZ + this.gSY));
            }
            if (this.gTb + this.gTa > 0) {
                if (this.gTm.size() > this.gTb + this.gTa + 1) {
                    this.gTm.add(this.gTb + this.gTa + 1, new b(this.gTc, this.gTe));
                }
            } else if (this.gTm.size() > 0) {
                this.gTm.add(0, new b(this.gTc, this.gTe));
            }
        }
        if (this.gTm.size() <= 0) {
            this.gTi = 3;
        } else if (this.gSX) {
            if (this.gSW == 1 && this.gTo.size() > 0) {
                this.gTi = 0;
            } else {
                this.gTi = 2;
            }
        } else if (this.gSW == 1 && this.gTb > 0) {
            this.gTi = 0;
        } else if (this.gTb + this.gTa > 0) {
            this.gTi = 2;
        } else if (this.gTb + this.gTa <= 0) {
            this.gTi = 3;
        }
    }
}
