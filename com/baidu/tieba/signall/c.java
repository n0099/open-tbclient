package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    private String TU;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String iZA;
    private String iZB;
    private String iZC;
    private int iZD;
    private String iZE;
    private int iZF;
    private boolean iZG;
    private int iZH;
    private int iZI;
    private int iZO;
    private String iZo;
    private String iZp;
    private String iZq;
    private String iZr;
    private int iZs;
    private String iZt;
    private boolean iZu;
    private int iZv;
    private int iZw;
    private int iZx;
    private int iZy;
    private String iZz;
    private int level;
    private String title;
    private int valid;
    private String iZn = "0";
    private ArrayList<d> iZJ = new ArrayList<>();
    private ArrayList<d> iZK = new ArrayList<>();
    private ArrayList<d> iZL = new ArrayList<>();
    private HashMap<String, d> iZM = new HashMap<>();
    private a iZN = new a();
    private f iZP = new f();
    private k iZQ = new k();

    public boolean cls() {
        return (this.iZP == null || StringUtils.isNull(this.iZP.jaj)) ? false : true;
    }

    public String axs() {
        return this.iZP.bXm;
    }

    public String clt() {
        return this.iZP.jaj;
    }

    public String clu() {
        return this.iZQ.jbC;
    }

    public String clv() {
        return this.iZQ.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean clw() {
        return !StringUtils.isNull(this.iZn) && this.iZn.equals("1");
    }

    public String clx() {
        return this.iZo;
    }

    public String bXO() {
        return this.TU;
    }

    public String cly() {
        return this.iZp;
    }

    public String clz() {
        return this.iZq;
    }

    public String clA() {
        return this.iZr;
    }

    public int clB() {
        return this.iZs;
    }

    public String clC() {
        return this.iZt;
    }

    public ArrayList<d> clD() {
        return this.iZJ;
    }

    public a clE() {
        return this.iZN;
    }

    public ArrayList<d> clF() {
        return this.iZK;
    }

    public ArrayList<d> clG() {
        return this.iZL;
    }

    public boolean clH() {
        return this.iZu;
    }

    public String clI() {
        return this.iZE;
    }

    public String getContent() {
        return this.content;
    }

    public int clJ() {
        return this.iZF;
    }

    public boolean clK() {
        return this.iZG;
    }

    public int clL() {
        return this.iZH;
    }

    public int clM() {
        return this.iZI;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.iZM.get(signData.forumId)) != null) {
            dVar.zx(1);
            dVar.zy(signData.count_sign_num);
            dVar.zA(signData.sign_bonus_point);
            dVar.qB(true);
            dVar.qC(false);
            dVar.qD(false);
            a(dVar);
            clN();
            qA(true);
        }
    }

    private void a(d dVar) {
        if (dVar.clQ() >= this.level) {
            this.iZx++;
            this.iZy--;
        } else {
            this.iZv++;
            this.iZw--;
        }
        this.iZM.remove(String.valueOf(dVar.getForumId()));
        this.iZL.remove(dVar);
        if (dVar.clR() + dVar.clV() >= dVar.clS()) {
            dVar.zz(dVar.clQ() + 1);
            dVar.qE(true);
            if (dVar.clQ() == this.level) {
                this.iZx++;
                this.iZv--;
            }
        }
        this.iZK.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.clV(), -1);
    }

    private void clN() {
        if (this.iZu) {
            if (this.iZy + this.iZw <= 0) {
                this.iZG = true;
            } else {
                this.iZG = false;
            }
        } else if (this.iZy <= 0) {
            this.iZG = true;
        } else {
            this.iZG = false;
        }
    }

    public void a(h hVar) {
        this.iZH = 0;
        this.iZI = 0;
        ArrayList<i> cmf = hVar.cmf();
        int size = cmf.size();
        for (int i = 0; i < size; i++) {
            i iVar = cmf.get(i);
            d dVar = this.iZM.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cmi() != 0) {
                    this.iZH++;
                    dVar.zx(1);
                    dVar.zy(iVar.cmj());
                    dVar.zA(iVar.getCurScore());
                    dVar.qB(true);
                    dVar.qC(false);
                    dVar.qD(false);
                    a(dVar);
                } else {
                    this.iZI++;
                    dVar.qB(false);
                    dVar.qC(true);
                    dVar.qD(false);
                    dVar.setErrorMsg(iVar.clE().getUserMsg());
                }
            }
        }
        clN();
        qA(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.iZN.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.iZn = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.iZo = jSONObject.optString("text_pre");
            this.TU = jSONObject.optString("text_color");
            this.iZp = jSONObject.optString("text_mid");
            this.iZq = jSONObject.optString("text_suf");
            this.iZr = jSONObject.optString("num_notice");
            this.iZs = jSONObject.optInt("show_dialog");
            this.iZt = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt("valid", 0);
            this.iZO = jSONObject.optInt("sign_max_num", 50);
            this.iZD = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.iZE = jSONObject.optString("button_content");
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
            if (this.iZD == 1) {
                this.iZu = true;
            } else {
                this.iZu = false;
            }
            this.iZA = this.level + this.title;
            this.iZz = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.jbs = this.iZO;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.jbs);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.clO() == 0) {
                            if (this.valid == 0) {
                                if (this.iZu) {
                                    dVar.qC(true);
                                } else if (dVar.clQ() > this.level) {
                                    dVar.qC(true);
                                }
                            }
                            if (dVar.clQ() >= this.level) {
                                this.iZy++;
                            } else {
                                this.iZw++;
                            }
                            this.iZL.add(dVar);
                            this.iZM.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.clQ() >= this.level) {
                                this.iZx++;
                            } else {
                                this.iZv++;
                            }
                            this.iZK.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.clV(), -1);
                        }
                        this.iZJ.add(dVar);
                        Collections.sort(this.iZJ, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.clQ() - dVar2.clQ();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.iZP == null) {
                this.iZP = new f();
            }
            this.iZP.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.iZQ == null) {
                this.iZQ = new k();
            }
            this.iZQ.parserJson(optJSONObject3);
            qA(false);
        }
    }

    private void qA(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.iZJ.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.iZJ.removeAll(arrayList);
        }
        if (this.iZy + this.iZx > 0) {
            if (this.iZx > 0) {
                this.iZC = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iZx), Integer.valueOf(this.iZy));
            } else {
                this.iZC = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iZy + this.iZx));
            }
            if (this.iZJ.size() > 0) {
                this.iZJ.add(0, new b(this.iZA, this.iZC));
            }
        }
        if (this.iZw + this.iZv > 0) {
            if (this.iZv > 0) {
                this.iZB = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iZv), Integer.valueOf(this.iZw));
            } else {
                this.iZB = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iZw + this.iZv));
            }
            if (this.iZy + this.iZx > 0) {
                if (this.iZJ.size() > this.iZy + this.iZx + 1) {
                    this.iZJ.add(this.iZy + this.iZx + 1, new b(this.iZz, this.iZB));
                }
            } else if (this.iZJ.size() > 0) {
                this.iZJ.add(0, new b(this.iZz, this.iZB));
            }
        }
        if (this.iZJ.size() <= 0) {
            this.iZF = 3;
        } else if (this.iZu) {
            if (this.valid == 1 && this.iZL.size() > 0) {
                this.iZF = 0;
            } else {
                this.iZF = 2;
            }
        } else if (this.valid == 1 && this.iZy > 0) {
            this.iZF = 0;
        } else if (this.iZy + this.iZx > 0) {
            this.iZF = 2;
        } else if (this.iZy + this.iZx <= 0) {
            this.iZF = 3;
        }
    }
}
