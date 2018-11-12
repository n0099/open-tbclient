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
    private int gUA;
    private int gUB;
    private int gUC;
    private String gUD;
    private String gUE;
    private String gUF;
    private String gUG;
    private int gUH;
    private String gUI;
    private int gUJ;
    private boolean gUK;
    private int gUL;
    private int gUM;
    private int gUS;
    private String gUq;
    private String gUr;
    private String gUs;
    private String gUt;
    private String gUu;
    private int gUv;
    private String gUw;
    private int gUx;
    private boolean gUy;
    private int gUz;
    private int level;
    private String title;
    private String gUp = "0";
    private ArrayList<d> gUN = new ArrayList<>();
    private ArrayList<d> gUO = new ArrayList<>();
    private ArrayList<d> gUP = new ArrayList<>();
    private HashMap<String, d> gUQ = new HashMap<>();
    private a gUR = new a();
    private f gUT = new f();
    private k gUU = new k();

    public boolean bxt() {
        return (this.gUT == null || StringUtils.isNull(this.gUT.gVm)) ? false : true;
    }

    public String OE() {
        return this.gUT.alS;
    }

    public String bxu() {
        return this.gUT.gVm;
    }

    public String bxv() {
        return this.gUU.gWG;
    }

    public String bxw() {
        return this.gUU.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bxx() {
        return !StringUtils.isNull(this.gUp) && this.gUp.equals("1");
    }

    public String bxy() {
        return this.gUq;
    }

    public String blo() {
        return this.gUr;
    }

    public String bxz() {
        return this.gUs;
    }

    public String bxA() {
        return this.gUt;
    }

    public String bxB() {
        return this.gUu;
    }

    public int bxC() {
        return this.gUv;
    }

    public String bxD() {
        return this.gUw;
    }

    public ArrayList<d> bxE() {
        return this.gUN;
    }

    public a bxF() {
        return this.gUR;
    }

    public ArrayList<d> bxG() {
        return this.gUO;
    }

    public ArrayList<d> bxH() {
        return this.gUP;
    }

    public boolean bxI() {
        return this.gUy;
    }

    public String bxJ() {
        return this.gUI;
    }

    public String getContent() {
        return this.content;
    }

    public int bxK() {
        return this.gUJ;
    }

    public boolean bxL() {
        return this.gUK;
    }

    public int bxM() {
        return this.gUL;
    }

    public int bxN() {
        return this.gUM;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gUQ.get(signData.forumId)) != null) {
            dVar.uy(1);
            dVar.uz(signData.count_sign_num);
            dVar.uB(signData.sign_bonus_point);
            dVar.nd(true);
            dVar.ne(false);
            dVar.nf(false);
            a(dVar);
            bxO();
            nc(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bxR() >= this.level) {
            this.gUB++;
            this.gUC--;
        } else {
            this.gUz++;
            this.gUA--;
        }
        this.gUQ.remove(String.valueOf(dVar.getForumId()));
        this.gUP.remove(dVar);
        if (dVar.bxS() + dVar.bxW() >= dVar.bxT()) {
            dVar.uA(dVar.bxR() + 1);
            dVar.ng(true);
            if (dVar.bxR() == this.level) {
                this.gUB++;
                this.gUz--;
            }
        }
        this.gUO.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bxW(), -1);
    }

    private void bxO() {
        if (this.gUy) {
            if (this.gUC + this.gUA <= 0) {
                this.gUK = true;
            } else {
                this.gUK = false;
            }
        } else if (this.gUC <= 0) {
            this.gUK = true;
        } else {
            this.gUK = false;
        }
    }

    public void a(h hVar) {
        this.gUL = 0;
        this.gUM = 0;
        ArrayList<i> byg = hVar.byg();
        int size = byg.size();
        for (int i = 0; i < size; i++) {
            i iVar = byg.get(i);
            d dVar = this.gUQ.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.byj() != 0) {
                    this.gUL++;
                    dVar.uy(1);
                    dVar.uz(iVar.byk());
                    dVar.uB(iVar.getCurScore());
                    dVar.nd(true);
                    dVar.ne(false);
                    dVar.nf(false);
                    a(dVar);
                } else {
                    this.gUM++;
                    dVar.nd(false);
                    dVar.ne(true);
                    dVar.nf(false);
                    dVar.setErrorMsg(iVar.bxF().getUserMsg());
                }
            }
        }
        bxO();
        nc(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gUR.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.gUp = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gUq = jSONObject.optString("text_pre");
            this.gUr = jSONObject.optString("text_color");
            this.gUs = jSONObject.optString("text_mid");
            this.gUt = jSONObject.optString("text_suf");
            this.gUu = jSONObject.optString("num_notice");
            this.gUv = jSONObject.optInt("show_dialog");
            this.gUw = jSONObject.optString("sign_notice");
            this.gUx = jSONObject.optInt("valid", 0);
            this.gUS = jSONObject.optInt("sign_max_num", 50);
            this.gUH = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gUI = jSONObject.optString("button_content");
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
            if (this.gUH == 1) {
                this.gUy = true;
            } else {
                this.gUy = false;
            }
            this.gUE = this.level + this.title;
            this.gUD = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(e.j.sign_all_forum_tip);
            j.gWw = this.gUS;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.gWw);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.bxP() == 0) {
                            if (this.gUx == 0) {
                                if (this.gUy) {
                                    dVar.ne(true);
                                } else if (dVar.bxR() > this.level) {
                                    dVar.ne(true);
                                }
                            }
                            if (dVar.bxR() >= this.level) {
                                this.gUC++;
                            } else {
                                this.gUA++;
                            }
                            this.gUP.add(dVar);
                            this.gUQ.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bxR() >= this.level) {
                                this.gUB++;
                            } else {
                                this.gUz++;
                            }
                            this.gUO.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bxW(), -1);
                        }
                        this.gUN.add(dVar);
                        Collections.sort(this.gUN, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bxR() - dVar2.bxR();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.gUT == null) {
                this.gUT = new f();
            }
            this.gUT.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gUU == null) {
                this.gUU = new k();
            }
            this.gUU.parserJson(optJSONObject3);
            nc(false);
        }
    }

    private void nc(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gUN.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gUN.removeAll(arrayList);
        }
        if (this.gUC + this.gUB > 0) {
            if (this.gUB > 0) {
                this.gUG = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.gUB), Integer.valueOf(this.gUC));
            } else {
                this.gUG = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.gUC + this.gUB));
            }
            if (this.gUN.size() > 0) {
                this.gUN.add(0, new b(this.gUE, this.gUG));
            }
        }
        if (this.gUA + this.gUz > 0) {
            if (this.gUz > 0) {
                this.gUF = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.gUz), Integer.valueOf(this.gUA));
            } else {
                this.gUF = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.gUA + this.gUz));
            }
            if (this.gUC + this.gUB > 0) {
                if (this.gUN.size() > this.gUC + this.gUB + 1) {
                    this.gUN.add(this.gUC + this.gUB + 1, new b(this.gUD, this.gUF));
                }
            } else if (this.gUN.size() > 0) {
                this.gUN.add(0, new b(this.gUD, this.gUF));
            }
        }
        if (this.gUN.size() <= 0) {
            this.gUJ = 3;
        } else if (this.gUy) {
            if (this.gUx == 1 && this.gUP.size() > 0) {
                this.gUJ = 0;
            } else {
                this.gUJ = 2;
            }
        } else if (this.gUx == 1 && this.gUC > 0) {
            this.gUJ = 0;
        } else if (this.gUC + this.gUB > 0) {
            this.gUJ = 2;
        } else if (this.gUC + this.gUB <= 0) {
            this.gUJ = 3;
        }
    }
}
