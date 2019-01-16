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
    private String hfD;
    private String hfE;
    private String hfF;
    private String hfG;
    private int hfH;
    private String hfI;
    private int hfJ;
    private boolean hfK;
    private int hfL;
    private int hfM;
    private int hfS;
    private String hfq;
    private String hfr;
    private String hfs;
    private String hft;
    private String hfu;
    private int hfv;
    private String hfw;
    private int hfx;
    private boolean hfy;
    private int hfz;
    private int level;
    private String title;
    private String hfp = "0";
    private ArrayList<d> hfN = new ArrayList<>();
    private ArrayList<d> hfO = new ArrayList<>();
    private ArrayList<d> hfP = new ArrayList<>();
    private HashMap<String, d> hfQ = new HashMap<>();
    private a hfR = new a();
    private f hfT = new f();
    private k hfU = new k();

    public boolean bAL() {
        return (this.hfT == null || StringUtils.isNull(this.hfT.hgm)) ? false : true;
    }

    public String Qe() {
        return this.hfT.apV;
    }

    public String bAM() {
        return this.hfT.hgm;
    }

    public String bAN() {
        return this.hfU.hhG;
    }

    public String bAO() {
        return this.hfU.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bAP() {
        return !StringUtils.isNull(this.hfp) && this.hfp.equals("1");
    }

    public String bAQ() {
        return this.hfq;
    }

    public String boA() {
        return this.hfr;
    }

    public String bAR() {
        return this.hfs;
    }

    public String bAS() {
        return this.hft;
    }

    public String bAT() {
        return this.hfu;
    }

    public int bAU() {
        return this.hfv;
    }

    public String bAV() {
        return this.hfw;
    }

    public ArrayList<d> bAW() {
        return this.hfN;
    }

    public a bAX() {
        return this.hfR;
    }

    public ArrayList<d> bAY() {
        return this.hfO;
    }

    public ArrayList<d> bAZ() {
        return this.hfP;
    }

    public boolean bBa() {
        return this.hfy;
    }

    public String bBb() {
        return this.hfI;
    }

    public String getContent() {
        return this.content;
    }

    public int bBc() {
        return this.hfJ;
    }

    public boolean bBd() {
        return this.hfK;
    }

    public int bBe() {
        return this.hfL;
    }

    public int bBf() {
        return this.hfM;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.hfQ.get(signData.forumId)) != null) {
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
            this.hfB++;
            this.hfC--;
        } else {
            this.hfz++;
            this.hfA--;
        }
        this.hfQ.remove(String.valueOf(dVar.getForumId()));
        this.hfP.remove(dVar);
        if (dVar.bBk() + dVar.bBo() >= dVar.bBl()) {
            dVar.vm(dVar.bBj() + 1);
            dVar.nm(true);
            if (dVar.bBj() == this.level) {
                this.hfB++;
                this.hfz--;
            }
        }
        this.hfO.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bBo(), -1);
    }

    private void bBg() {
        if (this.hfy) {
            if (this.hfC + this.hfA <= 0) {
                this.hfK = true;
            } else {
                this.hfK = false;
            }
        } else if (this.hfC <= 0) {
            this.hfK = true;
        } else {
            this.hfK = false;
        }
    }

    public void a(h hVar) {
        this.hfL = 0;
        this.hfM = 0;
        ArrayList<i> bBy = hVar.bBy();
        int size = bBy.size();
        for (int i = 0; i < size; i++) {
            i iVar = bBy.get(i);
            d dVar = this.hfQ.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.bBB() != 0) {
                    this.hfL++;
                    dVar.vk(1);
                    dVar.vl(iVar.bBC());
                    dVar.vn(iVar.getCurScore());
                    dVar.nj(true);
                    dVar.nk(false);
                    dVar.nl(false);
                    a(dVar);
                } else {
                    this.hfM++;
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
            this.hfR.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.hfp = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.hfq = jSONObject.optString("text_pre");
            this.hfr = jSONObject.optString("text_color");
            this.hfs = jSONObject.optString("text_mid");
            this.hft = jSONObject.optString("text_suf");
            this.hfu = jSONObject.optString("num_notice");
            this.hfv = jSONObject.optInt("show_dialog");
            this.hfw = jSONObject.optString("sign_notice");
            this.hfx = jSONObject.optInt("valid", 0);
            this.hfS = jSONObject.optInt("sign_max_num", 50);
            this.hfH = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.hfI = jSONObject.optString("button_content");
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
            if (this.hfH == 1) {
                this.hfy = true;
            } else {
                this.hfy = false;
            }
            this.hfE = this.level + this.title;
            this.hfD = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(e.j.sign_all_forum_tip);
            j.hhw = this.hfS;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.hhw);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.bBh() == 0) {
                            if (this.hfx == 0) {
                                if (this.hfy) {
                                    dVar.nk(true);
                                } else if (dVar.bBj() > this.level) {
                                    dVar.nk(true);
                                }
                            }
                            if (dVar.bBj() >= this.level) {
                                this.hfC++;
                            } else {
                                this.hfA++;
                            }
                            this.hfP.add(dVar);
                            this.hfQ.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bBj() >= this.level) {
                                this.hfB++;
                            } else {
                                this.hfz++;
                            }
                            this.hfO.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bBo(), -1);
                        }
                        this.hfN.add(dVar);
                        Collections.sort(this.hfN, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
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
            if (this.hfT == null) {
                this.hfT = new f();
            }
            this.hfT.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.hfU == null) {
                this.hfU = new k();
            }
            this.hfU.parserJson(optJSONObject3);
            ni(false);
        }
    }

    private void ni(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.hfN.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.hfN.removeAll(arrayList);
        }
        if (this.hfC + this.hfB > 0) {
            if (this.hfB > 0) {
                this.hfG = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.hfB), Integer.valueOf(this.hfC));
            } else {
                this.hfG = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.hfC + this.hfB));
            }
            if (this.hfN.size() > 0) {
                this.hfN.add(0, new b(this.hfE, this.hfG));
            }
        }
        if (this.hfA + this.hfz > 0) {
            if (this.hfz > 0) {
                this.hfF = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.hfz), Integer.valueOf(this.hfA));
            } else {
                this.hfF = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.hfA + this.hfz));
            }
            if (this.hfC + this.hfB > 0) {
                if (this.hfN.size() > this.hfC + this.hfB + 1) {
                    this.hfN.add(this.hfC + this.hfB + 1, new b(this.hfD, this.hfF));
                }
            } else if (this.hfN.size() > 0) {
                this.hfN.add(0, new b(this.hfD, this.hfF));
            }
        }
        if (this.hfN.size() <= 0) {
            this.hfJ = 3;
        } else if (this.hfy) {
            if (this.hfx == 1 && this.hfP.size() > 0) {
                this.hfJ = 0;
            } else {
                this.hfJ = 2;
            }
        } else if (this.hfx == 1 && this.hfC > 0) {
            this.hfJ = 0;
        } else if (this.hfC + this.hfB > 0) {
            this.hfJ = 2;
        } else if (this.hfC + this.hfB <= 0) {
            this.hfJ = 3;
        }
    }
}
