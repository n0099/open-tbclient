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
    private String Tz;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String iYA;
    private int iYB;
    private String iYC;
    private boolean iYD;
    private int iYE;
    private int iYF;
    private int iYG;
    private int iYH;
    private String iYI;
    private String iYJ;
    private String iYK;
    private String iYL;
    private int iYM;
    private String iYN;
    private int iYO;
    private boolean iYP;
    private int iYQ;
    private int iYR;
    private int iYX;
    private String iYx;
    private String iYy;
    private String iYz;
    private int level;
    private String title;
    private int valid;
    private String iYw = "0";
    private ArrayList<d> iYS = new ArrayList<>();
    private ArrayList<d> iYT = new ArrayList<>();
    private ArrayList<d> iYU = new ArrayList<>();
    private HashMap<String, d> iYV = new HashMap<>();
    private a iYW = new a();
    private f iYY = new f();
    private k iYZ = new k();

    public boolean clq() {
        return (this.iYY == null || StringUtils.isNull(this.iYY.iZs)) ? false : true;
    }

    public String axq() {
        return this.iYY.bWv;
    }

    public String clr() {
        return this.iYY.iZs;
    }

    public String cls() {
        return this.iYZ.jaL;
    }

    public String clt() {
        return this.iYZ.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean clu() {
        return !StringUtils.isNull(this.iYw) && this.iYw.equals("1");
    }

    public String clv() {
        return this.iYx;
    }

    public String bXM() {
        return this.Tz;
    }

    public String clw() {
        return this.iYy;
    }

    public String clx() {
        return this.iYz;
    }

    public String cly() {
        return this.iYA;
    }

    public int clz() {
        return this.iYB;
    }

    public String clA() {
        return this.iYC;
    }

    public ArrayList<d> clB() {
        return this.iYS;
    }

    public a clC() {
        return this.iYW;
    }

    public ArrayList<d> clD() {
        return this.iYT;
    }

    public ArrayList<d> clE() {
        return this.iYU;
    }

    public boolean clF() {
        return this.iYD;
    }

    public String clG() {
        return this.iYN;
    }

    public String getContent() {
        return this.content;
    }

    public int clH() {
        return this.iYO;
    }

    public boolean clI() {
        return this.iYP;
    }

    public int clJ() {
        return this.iYQ;
    }

    public int clK() {
        return this.iYR;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.iYV.get(signData.forumId)) != null) {
            dVar.zw(1);
            dVar.zx(signData.count_sign_num);
            dVar.zz(signData.sign_bonus_point);
            dVar.qB(true);
            dVar.qC(false);
            dVar.qD(false);
            a(dVar);
            clL();
            qA(true);
        }
    }

    private void a(d dVar) {
        if (dVar.clO() >= this.level) {
            this.iYG++;
            this.iYH--;
        } else {
            this.iYE++;
            this.iYF--;
        }
        this.iYV.remove(String.valueOf(dVar.getForumId()));
        this.iYU.remove(dVar);
        if (dVar.clP() + dVar.clT() >= dVar.clQ()) {
            dVar.zy(dVar.clO() + 1);
            dVar.qE(true);
            if (dVar.clO() == this.level) {
                this.iYG++;
                this.iYE--;
            }
        }
        this.iYT.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.clT(), -1);
    }

    private void clL() {
        if (this.iYD) {
            if (this.iYH + this.iYF <= 0) {
                this.iYP = true;
            } else {
                this.iYP = false;
            }
        } else if (this.iYH <= 0) {
            this.iYP = true;
        } else {
            this.iYP = false;
        }
    }

    public void a(h hVar) {
        this.iYQ = 0;
        this.iYR = 0;
        ArrayList<i> cmd = hVar.cmd();
        int size = cmd.size();
        for (int i = 0; i < size; i++) {
            i iVar = cmd.get(i);
            d dVar = this.iYV.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cmg() != 0) {
                    this.iYQ++;
                    dVar.zw(1);
                    dVar.zx(iVar.cmh());
                    dVar.zz(iVar.getCurScore());
                    dVar.qB(true);
                    dVar.qC(false);
                    dVar.qD(false);
                    a(dVar);
                } else {
                    this.iYR++;
                    dVar.qB(false);
                    dVar.qC(true);
                    dVar.qD(false);
                    dVar.setErrorMsg(iVar.clC().getUserMsg());
                }
            }
        }
        clL();
        qA(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.iYW.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.iYw = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.iYx = jSONObject.optString("text_pre");
            this.Tz = jSONObject.optString("text_color");
            this.iYy = jSONObject.optString("text_mid");
            this.iYz = jSONObject.optString("text_suf");
            this.iYA = jSONObject.optString("num_notice");
            this.iYB = jSONObject.optInt("show_dialog");
            this.iYC = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt("valid", 0);
            this.iYX = jSONObject.optInt("sign_max_num", 50);
            this.iYM = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.iYN = jSONObject.optString("button_content");
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
            if (this.iYM == 1) {
                this.iYD = true;
            } else {
                this.iYD = false;
            }
            this.iYJ = this.level + this.title;
            this.iYI = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.jaB = this.iYX;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.jaB);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.clM() == 0) {
                            if (this.valid == 0) {
                                if (this.iYD) {
                                    dVar.qC(true);
                                } else if (dVar.clO() > this.level) {
                                    dVar.qC(true);
                                }
                            }
                            if (dVar.clO() >= this.level) {
                                this.iYH++;
                            } else {
                                this.iYF++;
                            }
                            this.iYU.add(dVar);
                            this.iYV.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.clO() >= this.level) {
                                this.iYG++;
                            } else {
                                this.iYE++;
                            }
                            this.iYT.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.clT(), -1);
                        }
                        this.iYS.add(dVar);
                        Collections.sort(this.iYS, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.clO() - dVar2.clO();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.iYY == null) {
                this.iYY = new f();
            }
            this.iYY.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.iYZ == null) {
                this.iYZ = new k();
            }
            this.iYZ.parserJson(optJSONObject3);
            qA(false);
        }
    }

    private void qA(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.iYS.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.iYS.removeAll(arrayList);
        }
        if (this.iYH + this.iYG > 0) {
            if (this.iYG > 0) {
                this.iYL = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iYG), Integer.valueOf(this.iYH));
            } else {
                this.iYL = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iYH + this.iYG));
            }
            if (this.iYS.size() > 0) {
                this.iYS.add(0, new b(this.iYJ, this.iYL));
            }
        }
        if (this.iYF + this.iYE > 0) {
            if (this.iYE > 0) {
                this.iYK = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iYE), Integer.valueOf(this.iYF));
            } else {
                this.iYK = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iYF + this.iYE));
            }
            if (this.iYH + this.iYG > 0) {
                if (this.iYS.size() > this.iYH + this.iYG + 1) {
                    this.iYS.add(this.iYH + this.iYG + 1, new b(this.iYI, this.iYK));
                }
            } else if (this.iYS.size() > 0) {
                this.iYS.add(0, new b(this.iYI, this.iYK));
            }
        }
        if (this.iYS.size() <= 0) {
            this.iYO = 3;
        } else if (this.iYD) {
            if (this.valid == 1 && this.iYU.size() > 0) {
                this.iYO = 0;
            } else {
                this.iYO = 2;
            }
        } else if (this.valid == 1 && this.iYH > 0) {
            this.iYO = 0;
        } else if (this.iYH + this.iYG > 0) {
            this.iYO = 2;
        } else if (this.iYH + this.iYG <= 0) {
            this.iYO = 3;
        }
    }
}
