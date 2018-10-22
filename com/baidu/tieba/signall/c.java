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
    private String gSQ;
    private String gSR;
    private String gSS;
    private String gST;
    private String gSU;
    private int gSV;
    private String gSW;
    private int gSX;
    private boolean gSY;
    private int gSZ;
    private int gTa;
    private int gTb;
    private int gTc;
    private String gTd;
    private String gTe;
    private String gTf;
    private String gTg;
    private int gTh;
    private String gTi;
    private int gTj;
    private boolean gTk;
    private int gTl;
    private int gTm;
    private int gTs;
    private int level;
    private String title;
    private String gSP = "0";
    private ArrayList<d> gTn = new ArrayList<>();
    private ArrayList<d> gTo = new ArrayList<>();
    private ArrayList<d> gTp = new ArrayList<>();
    private HashMap<String, d> gTq = new HashMap<>();
    private a gTr = new a();
    private f gTt = new f();
    private k gTu = new k();

    public boolean bxX() {
        return (this.gTt == null || StringUtils.isNull(this.gTt.gTM)) ? false : true;
    }

    public String Ov() {
        return this.gTt.ale;
    }

    public String bxY() {
        return this.gTt.gTM;
    }

    public String bxZ() {
        return this.gTu.gVi;
    }

    public String bya() {
        return this.gTu.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean byb() {
        return !StringUtils.isNull(this.gSP) && this.gSP.equals("1");
    }

    public String byc() {
        return this.gSQ;
    }

    public String blS() {
        return this.gSR;
    }

    public String byd() {
        return this.gSS;
    }

    public String bye() {
        return this.gST;
    }

    public String byf() {
        return this.gSU;
    }

    public int byg() {
        return this.gSV;
    }

    public String byh() {
        return this.gSW;
    }

    public ArrayList<d> byi() {
        return this.gTn;
    }

    public a byj() {
        return this.gTr;
    }

    public ArrayList<d> byk() {
        return this.gTo;
    }

    public ArrayList<d> byl() {
        return this.gTp;
    }

    public boolean bym() {
        return this.gSY;
    }

    public String byn() {
        return this.gTi;
    }

    public String getContent() {
        return this.content;
    }

    public int byo() {
        return this.gTj;
    }

    public boolean byp() {
        return this.gTk;
    }

    public int byq() {
        return this.gTl;
    }

    public int byr() {
        return this.gTm;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gTq.get(signData.forumId)) != null) {
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
            this.gTb++;
            this.gTc--;
        } else {
            this.gSZ++;
            this.gTa--;
        }
        this.gTq.remove(String.valueOf(dVar.getForumId()));
        this.gTp.remove(dVar);
        if (dVar.byw() + dVar.byA() >= dVar.byx()) {
            dVar.uh(dVar.byv() + 1);
            dVar.mV(true);
            if (dVar.byv() == this.level) {
                this.gTb++;
                this.gSZ--;
            }
        }
        this.gTo.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.byA(), -1);
    }

    private void bys() {
        if (this.gSY) {
            if (this.gTc + this.gTa <= 0) {
                this.gTk = true;
            } else {
                this.gTk = false;
            }
        } else if (this.gTc <= 0) {
            this.gTk = true;
        } else {
            this.gTk = false;
        }
    }

    public void a(h hVar) {
        this.gTl = 0;
        this.gTm = 0;
        ArrayList<i> byK = hVar.byK();
        int size = byK.size();
        for (int i = 0; i < size; i++) {
            i iVar = byK.get(i);
            d dVar = this.gTq.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.byN() != 0) {
                    this.gTl++;
                    dVar.uf(1);
                    dVar.ug(iVar.byO());
                    dVar.ui(iVar.getCurScore());
                    dVar.mS(true);
                    dVar.mT(false);
                    dVar.mU(false);
                    a(dVar);
                } else {
                    this.gTm++;
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
            this.gTr.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.gSP = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gSQ = jSONObject.optString("text_pre");
            this.gSR = jSONObject.optString("text_color");
            this.gSS = jSONObject.optString("text_mid");
            this.gST = jSONObject.optString("text_suf");
            this.gSU = jSONObject.optString("num_notice");
            this.gSV = jSONObject.optInt("show_dialog");
            this.gSW = jSONObject.optString("sign_notice");
            this.gSX = jSONObject.optInt("valid", 0);
            this.gTs = jSONObject.optInt("sign_max_num", 50);
            this.gTh = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gTi = jSONObject.optString("button_content");
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
            if (this.gTh == 1) {
                this.gSY = true;
            } else {
                this.gSY = false;
            }
            this.gTe = this.level + this.title;
            this.gTd = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(e.j.sign_all_forum_tip);
            j.gUY = this.gTs;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.gUY);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.byt() == 0) {
                            if (this.gSX == 0) {
                                if (this.gSY) {
                                    dVar.mT(true);
                                } else if (dVar.byv() > this.level) {
                                    dVar.mT(true);
                                }
                            }
                            if (dVar.byv() >= this.level) {
                                this.gTc++;
                            } else {
                                this.gTa++;
                            }
                            this.gTp.add(dVar);
                            this.gTq.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.byv() >= this.level) {
                                this.gTb++;
                            } else {
                                this.gSZ++;
                            }
                            this.gTo.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.byA(), -1);
                        }
                        this.gTn.add(dVar);
                        Collections.sort(this.gTn, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
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
            if (this.gTt == null) {
                this.gTt = new f();
            }
            this.gTt.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gTu == null) {
                this.gTu = new k();
            }
            this.gTu.parserJson(optJSONObject3);
            mR(false);
        }
    }

    private void mR(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gTn.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gTn.removeAll(arrayList);
        }
        if (this.gTc + this.gTb > 0) {
            if (this.gTb > 0) {
                this.gTg = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.gTb), Integer.valueOf(this.gTc));
            } else {
                this.gTg = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.gTc + this.gTb));
            }
            if (this.gTn.size() > 0) {
                this.gTn.add(0, new b(this.gTe, this.gTg));
            }
        }
        if (this.gTa + this.gSZ > 0) {
            if (this.gSZ > 0) {
                this.gTf = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.gSZ), Integer.valueOf(this.gTa));
            } else {
                this.gTf = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.gTa + this.gSZ));
            }
            if (this.gTc + this.gTb > 0) {
                if (this.gTn.size() > this.gTc + this.gTb + 1) {
                    this.gTn.add(this.gTc + this.gTb + 1, new b(this.gTd, this.gTf));
                }
            } else if (this.gTn.size() > 0) {
                this.gTn.add(0, new b(this.gTd, this.gTf));
            }
        }
        if (this.gTn.size() <= 0) {
            this.gTj = 3;
        } else if (this.gSY) {
            if (this.gSX == 1 && this.gTp.size() > 0) {
                this.gTj = 0;
            } else {
                this.gTj = 2;
            }
        } else if (this.gSX == 1 && this.gTc > 0) {
            this.gTj = 0;
        } else if (this.gTc + this.gTb > 0) {
            this.gTj = 2;
        } else if (this.gTc + this.gTb <= 0) {
            this.gTj = 3;
        }
    }
}
