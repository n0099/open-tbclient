package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.net.update.UpdateConstants;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
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
/* loaded from: classes11.dex */
public class c {
    private String acA;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String jXC;
    private String jXD;
    private String jXE;
    private String jXF;
    private int jXG;
    private String jXH;
    private boolean jXI;
    private int jXJ;
    private int jXK;
    private int jXL;
    private int jXM;
    private String jXN;
    private String jXO;
    private String jXP;
    private String jXQ;
    private int jXR;
    private String jXS;
    private int jXT;
    private boolean jXU;
    private int jXV;
    private int jXW;
    private int jYc;
    private int level;
    private String title;
    private int valid;
    private String jXB = "0";
    private ArrayList<d> jXX = new ArrayList<>();
    private ArrayList<d> jXY = new ArrayList<>();
    private ArrayList<d> jXZ = new ArrayList<>();
    private HashMap<String, d> jYa = new HashMap<>();
    private a jYb = new a();
    private f jYd = new f();
    private k jYe = new k();

    public boolean cIm() {
        return (this.jYd == null || StringUtils.isNull(this.jYd.jYw)) ? false : true;
    }

    public String aRP() {
        return this.jYd.cMY;
    }

    public String cIn() {
        return this.jYd.jYw;
    }

    public String cIo() {
        return this.jYe.jZQ;
    }

    public String cIp() {
        return this.jYe.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cIq() {
        return !StringUtils.isNull(this.jXB) && this.jXB.equals("1");
    }

    public String cIr() {
        return this.jXC;
    }

    public String csj() {
        return this.acA;
    }

    public String cIs() {
        return this.jXD;
    }

    public String cIt() {
        return this.jXE;
    }

    public String cIu() {
        return this.jXF;
    }

    public int cIv() {
        return this.jXG;
    }

    public String cIw() {
        return this.jXH;
    }

    public ArrayList<d> cIx() {
        return this.jXX;
    }

    public a cIy() {
        return this.jYb;
    }

    public ArrayList<d> cIz() {
        return this.jXY;
    }

    public ArrayList<d> cIA() {
        return this.jXZ;
    }

    public boolean cIB() {
        return this.jXI;
    }

    public String cIC() {
        return this.jXS;
    }

    public String getContent() {
        return this.content;
    }

    public int cID() {
        return this.jXT;
    }

    public boolean cIE() {
        return this.jXU;
    }

    public int cIF() {
        return this.jXV;
    }

    public int cIG() {
        return this.jXW;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.jYa.get(signData.forumId)) != null) {
            dVar.Ce(1);
            dVar.Cf(signData.count_sign_num);
            dVar.Ch(signData.sign_bonus_point);
            dVar.sz(true);
            dVar.sA(false);
            dVar.sB(false);
            a(dVar);
            cIH();
            sy(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cIK() >= this.level) {
            this.jXL++;
            this.jXM--;
        } else {
            this.jXJ++;
            this.jXK--;
        }
        this.jYa.remove(String.valueOf(dVar.getForumId()));
        this.jXZ.remove(dVar);
        if (dVar.cIL() + dVar.cIP() >= dVar.cIM()) {
            dVar.Cg(dVar.cIK() + 1);
            dVar.sC(true);
            if (dVar.cIK() == this.level) {
                this.jXL++;
                this.jXJ--;
            }
        }
        this.jXY.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cIP(), -1);
    }

    private void cIH() {
        if (this.jXI) {
            if (this.jXM + this.jXK <= 0) {
                this.jXU = true;
            } else {
                this.jXU = false;
            }
        } else if (this.jXM <= 0) {
            this.jXU = true;
        } else {
            this.jXU = false;
        }
    }

    public void a(h hVar) {
        this.jXV = 0;
        this.jXW = 0;
        ArrayList<i> cIZ = hVar.cIZ();
        int size = cIZ.size();
        for (int i = 0; i < size; i++) {
            i iVar = cIZ.get(i);
            d dVar = this.jYa.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cJc() != 0) {
                    this.jXV++;
                    dVar.Ce(1);
                    dVar.Cf(iVar.cJd());
                    dVar.Ch(iVar.getCurScore());
                    dVar.sz(true);
                    dVar.sA(false);
                    dVar.sB(false);
                    a(dVar);
                } else {
                    this.jXW++;
                    dVar.sz(false);
                    dVar.sA(true);
                    dVar.sB(false);
                    dVar.setErrorMsg(iVar.cIy().getUserMsg());
                }
            }
        }
        cIH();
        sy(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.jYb.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.jXB = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.jXC = jSONObject.optString("text_pre");
            this.acA = jSONObject.optString("text_color");
            this.jXD = jSONObject.optString("text_mid");
            this.jXE = jSONObject.optString("text_suf");
            this.jXF = jSONObject.optString("num_notice");
            this.jXG = jSONObject.optInt("show_dialog");
            this.jXH = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(UpdateConstants.VALID_KEY, 0);
            this.jYc = jSONObject.optInt("sign_max_num", 50);
            this.jXR = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.jXS = jSONObject.optString("button_content");
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
            if (this.jXR == 1) {
                this.jXI = true;
            } else {
                this.jXI = false;
            }
            this.jXO = this.level + this.title;
            this.jXN = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.jZG = this.jYc;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.jZG);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cII() == 0) {
                            if (this.valid == 0) {
                                if (this.jXI) {
                                    dVar.sA(true);
                                } else if (dVar.cIK() > this.level) {
                                    dVar.sA(true);
                                }
                            }
                            if (dVar.cIK() >= this.level) {
                                this.jXM++;
                            } else {
                                this.jXK++;
                            }
                            this.jXZ.add(dVar);
                            this.jYa.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cIK() >= this.level) {
                                this.jXL++;
                            } else {
                                this.jXJ++;
                            }
                            this.jXY.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cIP(), -1);
                        }
                        this.jXX.add(dVar);
                        Collections.sort(this.jXX, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cIK() - dVar2.cIK();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.jYd == null) {
                this.jYd = new f();
            }
            this.jYd.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.jYe == null) {
                this.jYe = new k();
            }
            this.jYe.parserJson(optJSONObject3);
            sy(false);
        }
    }

    private void sy(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.jXX.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.jXX.removeAll(arrayList);
        }
        if (this.jXM + this.jXL > 0) {
            if (this.jXL > 0) {
                this.jXQ = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jXL), Integer.valueOf(this.jXM));
            } else {
                this.jXQ = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jXM + this.jXL));
            }
            if (this.jXX.size() > 0) {
                this.jXX.add(0, new b(this.jXO, this.jXQ));
            }
        }
        if (this.jXK + this.jXJ > 0) {
            if (this.jXJ > 0) {
                this.jXP = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jXJ), Integer.valueOf(this.jXK));
            } else {
                this.jXP = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jXK + this.jXJ));
            }
            if (this.jXM + this.jXL > 0) {
                if (this.jXX.size() > this.jXM + this.jXL + 1) {
                    this.jXX.add(this.jXM + this.jXL + 1, new b(this.jXN, this.jXP));
                }
            } else if (this.jXX.size() > 0) {
                this.jXX.add(0, new b(this.jXN, this.jXP));
            }
        }
        if (this.jXX.size() <= 0) {
            this.jXT = 3;
        } else if (this.jXI) {
            if (this.valid == 1 && this.jXZ.size() > 0) {
                this.jXT = 0;
            } else {
                this.jXT = 2;
            }
        } else if (this.valid == 1 && this.jXM > 0) {
            this.jXT = 0;
        } else if (this.jXM + this.jXL > 0) {
            this.jXT = 2;
        } else if (this.jXM + this.jXL <= 0) {
            this.jXT = 3;
        }
    }
}
