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
    private int hfA;
    private int hfB;
    private int hfC;
    private int hfD;
    private String hfE;
    private String hfF;
    private String hfG;
    private String hfH;
    private int hfI;
    private String hfJ;
    private int hfK;
    private boolean hfL;
    private int hfM;
    private int hfN;
    private int hfT;
    private String hfr;
    private String hfs;
    private String hft;
    private String hfu;
    private String hfv;
    private int hfw;
    private String hfx;
    private int hfy;
    private boolean hfz;
    private int level;
    private String title;
    private String hfq = "0";
    private ArrayList<d> hfO = new ArrayList<>();
    private ArrayList<d> hfP = new ArrayList<>();
    private ArrayList<d> hfQ = new ArrayList<>();
    private HashMap<String, d> hfR = new HashMap<>();
    private a hfS = new a();
    private f hfU = new f();
    private k hfV = new k();

    public boolean bAL() {
        return (this.hfU == null || StringUtils.isNull(this.hfU.hgn)) ? false : true;
    }

    public String Qe() {
        return this.hfU.apW;
    }

    public String bAM() {
        return this.hfU.hgn;
    }

    public String bAN() {
        return this.hfV.hhH;
    }

    public String bAO() {
        return this.hfV.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bAP() {
        return !StringUtils.isNull(this.hfq) && this.hfq.equals("1");
    }

    public String bAQ() {
        return this.hfr;
    }

    public String boA() {
        return this.hfs;
    }

    public String bAR() {
        return this.hft;
    }

    public String bAS() {
        return this.hfu;
    }

    public String bAT() {
        return this.hfv;
    }

    public int bAU() {
        return this.hfw;
    }

    public String bAV() {
        return this.hfx;
    }

    public ArrayList<d> bAW() {
        return this.hfO;
    }

    public a bAX() {
        return this.hfS;
    }

    public ArrayList<d> bAY() {
        return this.hfP;
    }

    public ArrayList<d> bAZ() {
        return this.hfQ;
    }

    public boolean bBa() {
        return this.hfz;
    }

    public String bBb() {
        return this.hfJ;
    }

    public String getContent() {
        return this.content;
    }

    public int bBc() {
        return this.hfK;
    }

    public boolean bBd() {
        return this.hfL;
    }

    public int bBe() {
        return this.hfM;
    }

    public int bBf() {
        return this.hfN;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.hfR.get(signData.forumId)) != null) {
            dVar.vk(1);
            dVar.vl(signData.count_sign_num);
            dVar.vn(signData.sign_bonus_point);
            dVar.nj(true);
            dVar.nk(false);
            dVar.nl(false);
            a(dVar);
            bBg();
            ni(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bBj() >= this.level) {
            this.hfC++;
            this.hfD--;
        } else {
            this.hfA++;
            this.hfB--;
        }
        this.hfR.remove(String.valueOf(dVar.getForumId()));
        this.hfQ.remove(dVar);
        if (dVar.bBk() + dVar.bBo() >= dVar.bBl()) {
            dVar.vm(dVar.bBj() + 1);
            dVar.nm(true);
            if (dVar.bBj() == this.level) {
                this.hfC++;
                this.hfA--;
            }
        }
        this.hfP.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bBo(), -1);
    }

    private void bBg() {
        if (this.hfz) {
            if (this.hfD + this.hfB <= 0) {
                this.hfL = true;
            } else {
                this.hfL = false;
            }
        } else if (this.hfD <= 0) {
            this.hfL = true;
        } else {
            this.hfL = false;
        }
    }

    public void a(h hVar) {
        this.hfM = 0;
        this.hfN = 0;
        ArrayList<i> bBy = hVar.bBy();
        int size = bBy.size();
        for (int i = 0; i < size; i++) {
            i iVar = bBy.get(i);
            d dVar = this.hfR.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.bBB() != 0) {
                    this.hfM++;
                    dVar.vk(1);
                    dVar.vl(iVar.bBC());
                    dVar.vn(iVar.getCurScore());
                    dVar.nj(true);
                    dVar.nk(false);
                    dVar.nl(false);
                    a(dVar);
                } else {
                    this.hfN++;
                    dVar.nj(false);
                    dVar.nk(true);
                    dVar.nl(false);
                    dVar.setErrorMsg(iVar.bAX().getUserMsg());
                }
            }
        }
        bBg();
        ni(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.hfS.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.hfq = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.hfr = jSONObject.optString("text_pre");
            this.hfs = jSONObject.optString("text_color");
            this.hft = jSONObject.optString("text_mid");
            this.hfu = jSONObject.optString("text_suf");
            this.hfv = jSONObject.optString("num_notice");
            this.hfw = jSONObject.optInt("show_dialog");
            this.hfx = jSONObject.optString("sign_notice");
            this.hfy = jSONObject.optInt("valid", 0);
            this.hfT = jSONObject.optInt("sign_max_num", 50);
            this.hfI = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.hfJ = jSONObject.optString("button_content");
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
            if (this.hfI == 1) {
                this.hfz = true;
            } else {
                this.hfz = false;
            }
            this.hfF = this.level + this.title;
            this.hfE = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(e.j.sign_all_forum_tip);
            j.hhx = this.hfT;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.hhx);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.bBh() == 0) {
                            if (this.hfy == 0) {
                                if (this.hfz) {
                                    dVar.nk(true);
                                } else if (dVar.bBj() > this.level) {
                                    dVar.nk(true);
                                }
                            }
                            if (dVar.bBj() >= this.level) {
                                this.hfD++;
                            } else {
                                this.hfB++;
                            }
                            this.hfQ.add(dVar);
                            this.hfR.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bBj() >= this.level) {
                                this.hfC++;
                            } else {
                                this.hfA++;
                            }
                            this.hfP.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bBo(), -1);
                        }
                        this.hfO.add(dVar);
                        Collections.sort(this.hfO, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bBj() - dVar2.bBj();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.hfU == null) {
                this.hfU = new f();
            }
            this.hfU.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.hfV == null) {
                this.hfV = new k();
            }
            this.hfV.parserJson(optJSONObject3);
            ni(false);
        }
    }

    private void ni(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.hfO.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.hfO.removeAll(arrayList);
        }
        if (this.hfD + this.hfC > 0) {
            if (this.hfC > 0) {
                this.hfH = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.hfC), Integer.valueOf(this.hfD));
            } else {
                this.hfH = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.hfD + this.hfC));
            }
            if (this.hfO.size() > 0) {
                this.hfO.add(0, new b(this.hfF, this.hfH));
            }
        }
        if (this.hfB + this.hfA > 0) {
            if (this.hfA > 0) {
                this.hfG = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.hfA), Integer.valueOf(this.hfB));
            } else {
                this.hfG = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.hfB + this.hfA));
            }
            if (this.hfD + this.hfC > 0) {
                if (this.hfO.size() > this.hfD + this.hfC + 1) {
                    this.hfO.add(this.hfD + this.hfC + 1, new b(this.hfE, this.hfG));
                }
            } else if (this.hfO.size() > 0) {
                this.hfO.add(0, new b(this.hfE, this.hfG));
            }
        }
        if (this.hfO.size() <= 0) {
            this.hfK = 3;
        } else if (this.hfz) {
            if (this.hfy == 1 && this.hfQ.size() > 0) {
                this.hfK = 0;
            } else {
                this.hfK = 2;
            }
        } else if (this.hfy == 1 && this.hfD > 0) {
            this.hfK = 0;
        } else if (this.hfD + this.hfC > 0) {
            this.hfK = 2;
        } else if (this.hfD + this.hfC <= 0) {
            this.hfK = 3;
        }
    }
}
