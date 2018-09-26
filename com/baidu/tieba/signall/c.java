package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
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
    private boolean gLA;
    private int gLB;
    private int gLC;
    private int gLD;
    private int gLE;
    private String gLF;
    private String gLG;
    private String gLH;
    private String gLI;
    private int gLJ;
    private String gLK;
    private int gLL;
    private boolean gLM;
    private int gLN;
    private int gLO;
    private int gLU;
    private String gLs;
    private String gLt;
    private String gLu;
    private String gLv;
    private String gLw;
    private int gLx;
    private String gLy;
    private int gLz;
    private int level;
    private String title;
    private String gLr = "0";
    private ArrayList<d> gLP = new ArrayList<>();
    private ArrayList<d> gLQ = new ArrayList<>();
    private ArrayList<d> gLR = new ArrayList<>();
    private HashMap<String, d> gLS = new HashMap<>();
    private a gLT = new a();
    private f gLV = new f();
    private k gLW = new k();

    public boolean buI() {
        return (this.gLV == null || StringUtils.isNull(this.gLV.gMo)) ? false : true;
    }

    public String Mx() {
        return this.gLV.agi;
    }

    public String buJ() {
        return this.gLV.gMo;
    }

    public String buK() {
        return this.gLW.gNK;
    }

    public String buL() {
        return this.gLW.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean buM() {
        return !StringUtils.isNull(this.gLr) && this.gLr.equals("1");
    }

    public String buN() {
        return this.gLs;
    }

    public String biG() {
        return this.gLt;
    }

    public String buO() {
        return this.gLu;
    }

    public String buP() {
        return this.gLv;
    }

    public String buQ() {
        return this.gLw;
    }

    public int buR() {
        return this.gLx;
    }

    public String buS() {
        return this.gLy;
    }

    public ArrayList<d> buT() {
        return this.gLP;
    }

    public a buU() {
        return this.gLT;
    }

    public ArrayList<d> buV() {
        return this.gLQ;
    }

    public ArrayList<d> buW() {
        return this.gLR;
    }

    public boolean buX() {
        return this.gLA;
    }

    public String buY() {
        return this.gLK;
    }

    public String getContent() {
        return this.content;
    }

    public int buZ() {
        return this.gLL;
    }

    public boolean bva() {
        return this.gLM;
    }

    public int bvb() {
        return this.gLN;
    }

    public int bvc() {
        return this.gLO;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gLS.get(signData.forumId)) != null) {
            dVar.tI(1);
            dVar.tJ(signData.count_sign_num);
            dVar.tL(signData.sign_bonus_point);
            dVar.mA(true);
            dVar.mB(false);
            dVar.mC(false);
            a(dVar);
            bvd();
            mz(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bvg() >= this.level) {
            this.gLD++;
            this.gLE--;
        } else {
            this.gLB++;
            this.gLC--;
        }
        this.gLS.remove(String.valueOf(dVar.getForumId()));
        this.gLR.remove(dVar);
        if (dVar.bvh() + dVar.bvl() >= dVar.bvi()) {
            dVar.tK(dVar.bvg() + 1);
            dVar.mD(true);
            if (dVar.bvg() == this.level) {
                this.gLD++;
                this.gLB--;
            }
        }
        this.gLQ.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bvl(), -1);
    }

    private void bvd() {
        if (this.gLA) {
            if (this.gLE + this.gLC <= 0) {
                this.gLM = true;
            } else {
                this.gLM = false;
            }
        } else if (this.gLE <= 0) {
            this.gLM = true;
        } else {
            this.gLM = false;
        }
    }

    public void a(h hVar) {
        this.gLN = 0;
        this.gLO = 0;
        ArrayList<i> bvv = hVar.bvv();
        int size = bvv.size();
        for (int i = 0; i < size; i++) {
            i iVar = bvv.get(i);
            d dVar = this.gLS.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.bvy() != 0) {
                    this.gLN++;
                    dVar.tI(1);
                    dVar.tJ(iVar.bvz());
                    dVar.tL(iVar.getCurScore());
                    dVar.mA(true);
                    dVar.mB(false);
                    dVar.mC(false);
                    a(dVar);
                } else {
                    this.gLO++;
                    dVar.mA(false);
                    dVar.mB(true);
                    dVar.mC(false);
                    dVar.setErrorMsg(iVar.buU().getUserMsg());
                }
            }
        }
        bvd();
        mz(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gLT.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.gLr = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gLs = jSONObject.optString("text_pre");
            this.gLt = jSONObject.optString("text_color");
            this.gLu = jSONObject.optString("text_mid");
            this.gLv = jSONObject.optString("text_suf");
            this.gLw = jSONObject.optString("num_notice");
            this.gLx = jSONObject.optInt("show_dialog");
            this.gLy = jSONObject.optString("sign_notice");
            this.gLz = jSONObject.optInt("valid", 0);
            this.gLU = jSONObject.optInt("sign_max_num", 50);
            this.gLJ = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gLK = jSONObject.optString("button_content");
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
            if (this.gLJ == 1) {
                this.gLA = true;
            } else {
                this.gLA = false;
            }
            this.gLG = this.level + this.title;
            this.gLF = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(e.j.sign_all_forum_tip);
            j.gNA = this.gLU;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.gNA);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.bve() == 0) {
                            if (this.gLz == 0) {
                                if (this.gLA) {
                                    dVar.mB(true);
                                } else if (dVar.bvg() > this.level) {
                                    dVar.mB(true);
                                }
                            }
                            if (dVar.bvg() >= this.level) {
                                this.gLE++;
                            } else {
                                this.gLC++;
                            }
                            this.gLR.add(dVar);
                            this.gLS.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bvg() >= this.level) {
                                this.gLD++;
                            } else {
                                this.gLB++;
                            }
                            this.gLQ.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bvl(), -1);
                        }
                        this.gLP.add(dVar);
                        Collections.sort(this.gLP, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bvg() - dVar2.bvg();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.gLV == null) {
                this.gLV = new f();
            }
            this.gLV.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gLW == null) {
                this.gLW = new k();
            }
            this.gLW.parserJson(optJSONObject3);
            mz(false);
        }
    }

    private void mz(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gLP.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gLP.removeAll(arrayList);
        }
        if (this.gLE + this.gLD > 0) {
            if (this.gLD > 0) {
                this.gLI = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.gLD), Integer.valueOf(this.gLE));
            } else {
                this.gLI = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.gLE + this.gLD));
            }
            if (this.gLP.size() > 0) {
                this.gLP.add(0, new b(this.gLG, this.gLI));
            }
        }
        if (this.gLC + this.gLB > 0) {
            if (this.gLB > 0) {
                this.gLH = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.gLB), Integer.valueOf(this.gLC));
            } else {
                this.gLH = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.gLC + this.gLB));
            }
            if (this.gLE + this.gLD > 0) {
                if (this.gLP.size() > this.gLE + this.gLD + 1) {
                    this.gLP.add(this.gLE + this.gLD + 1, new b(this.gLF, this.gLH));
                }
            } else if (this.gLP.size() > 0) {
                this.gLP.add(0, new b(this.gLF, this.gLH));
            }
        }
        if (this.gLP.size() <= 0) {
            this.gLL = 3;
        } else if (this.gLA) {
            if (this.gLz == 1 && this.gLR.size() > 0) {
                this.gLL = 0;
            } else {
                this.gLL = 2;
            }
        } else if (this.gLz == 1 && this.gLE > 0) {
            this.gLL = 0;
        } else if (this.gLE + this.gLD > 0) {
            this.gLL = 2;
        } else if (this.gLE + this.gLD <= 0) {
            this.gLL = 3;
        }
    }
}
