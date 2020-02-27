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
    private String jXA;
    private String jXB;
    private String jXC;
    private String jXD;
    private int jXE;
    private String jXF;
    private boolean jXG;
    private int jXH;
    private int jXI;
    private int jXJ;
    private int jXK;
    private String jXL;
    private String jXM;
    private String jXN;
    private String jXO;
    private int jXP;
    private String jXQ;
    private int jXR;
    private boolean jXS;
    private int jXT;
    private int jXU;
    private int jYa;
    private int level;
    private String title;
    private int valid;
    private String jXz = "0";
    private ArrayList<d> jXV = new ArrayList<>();
    private ArrayList<d> jXW = new ArrayList<>();
    private ArrayList<d> jXX = new ArrayList<>();
    private HashMap<String, d> jXY = new HashMap<>();
    private a jXZ = new a();
    private f jYb = new f();
    private k jYc = new k();

    public boolean cIk() {
        return (this.jYb == null || StringUtils.isNull(this.jYb.jYu)) ? false : true;
    }

    public String aRN() {
        return this.jYb.cMX;
    }

    public String cIl() {
        return this.jYb.jYu;
    }

    public String cIm() {
        return this.jYc.jZO;
    }

    public String cIn() {
        return this.jYc.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cIo() {
        return !StringUtils.isNull(this.jXz) && this.jXz.equals("1");
    }

    public String cIp() {
        return this.jXA;
    }

    public String csh() {
        return this.acA;
    }

    public String cIq() {
        return this.jXB;
    }

    public String cIr() {
        return this.jXC;
    }

    public String cIs() {
        return this.jXD;
    }

    public int cIt() {
        return this.jXE;
    }

    public String cIu() {
        return this.jXF;
    }

    public ArrayList<d> cIv() {
        return this.jXV;
    }

    public a cIw() {
        return this.jXZ;
    }

    public ArrayList<d> cIx() {
        return this.jXW;
    }

    public ArrayList<d> cIy() {
        return this.jXX;
    }

    public boolean cIz() {
        return this.jXG;
    }

    public String cIA() {
        return this.jXQ;
    }

    public String getContent() {
        return this.content;
    }

    public int cIB() {
        return this.jXR;
    }

    public boolean cIC() {
        return this.jXS;
    }

    public int cID() {
        return this.jXT;
    }

    public int cIE() {
        return this.jXU;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.jXY.get(signData.forumId)) != null) {
            dVar.Ce(1);
            dVar.Cf(signData.count_sign_num);
            dVar.Ch(signData.sign_bonus_point);
            dVar.sz(true);
            dVar.sA(false);
            dVar.sB(false);
            a(dVar);
            cIF();
            sy(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cII() >= this.level) {
            this.jXJ++;
            this.jXK--;
        } else {
            this.jXH++;
            this.jXI--;
        }
        this.jXY.remove(String.valueOf(dVar.getForumId()));
        this.jXX.remove(dVar);
        if (dVar.cIJ() + dVar.cIN() >= dVar.cIK()) {
            dVar.Cg(dVar.cII() + 1);
            dVar.sC(true);
            if (dVar.cII() == this.level) {
                this.jXJ++;
                this.jXH--;
            }
        }
        this.jXW.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cIN(), -1);
    }

    private void cIF() {
        if (this.jXG) {
            if (this.jXK + this.jXI <= 0) {
                this.jXS = true;
            } else {
                this.jXS = false;
            }
        } else if (this.jXK <= 0) {
            this.jXS = true;
        } else {
            this.jXS = false;
        }
    }

    public void a(h hVar) {
        this.jXT = 0;
        this.jXU = 0;
        ArrayList<i> cIX = hVar.cIX();
        int size = cIX.size();
        for (int i = 0; i < size; i++) {
            i iVar = cIX.get(i);
            d dVar = this.jXY.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cJa() != 0) {
                    this.jXT++;
                    dVar.Ce(1);
                    dVar.Cf(iVar.cJb());
                    dVar.Ch(iVar.getCurScore());
                    dVar.sz(true);
                    dVar.sA(false);
                    dVar.sB(false);
                    a(dVar);
                } else {
                    this.jXU++;
                    dVar.sz(false);
                    dVar.sA(true);
                    dVar.sB(false);
                    dVar.setErrorMsg(iVar.cIw().getUserMsg());
                }
            }
        }
        cIF();
        sy(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.jXZ.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.jXz = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.jXA = jSONObject.optString("text_pre");
            this.acA = jSONObject.optString("text_color");
            this.jXB = jSONObject.optString("text_mid");
            this.jXC = jSONObject.optString("text_suf");
            this.jXD = jSONObject.optString("num_notice");
            this.jXE = jSONObject.optInt("show_dialog");
            this.jXF = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(UpdateConstants.VALID_KEY, 0);
            this.jYa = jSONObject.optInt("sign_max_num", 50);
            this.jXP = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.jXQ = jSONObject.optString("button_content");
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
            if (this.jXP == 1) {
                this.jXG = true;
            } else {
                this.jXG = false;
            }
            this.jXM = this.level + this.title;
            this.jXL = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.jZE = this.jYa;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.jZE);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cIG() == 0) {
                            if (this.valid == 0) {
                                if (this.jXG) {
                                    dVar.sA(true);
                                } else if (dVar.cII() > this.level) {
                                    dVar.sA(true);
                                }
                            }
                            if (dVar.cII() >= this.level) {
                                this.jXK++;
                            } else {
                                this.jXI++;
                            }
                            this.jXX.add(dVar);
                            this.jXY.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cII() >= this.level) {
                                this.jXJ++;
                            } else {
                                this.jXH++;
                            }
                            this.jXW.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cIN(), -1);
                        }
                        this.jXV.add(dVar);
                        Collections.sort(this.jXV, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cII() - dVar2.cII();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.jYb == null) {
                this.jYb = new f();
            }
            this.jYb.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.jYc == null) {
                this.jYc = new k();
            }
            this.jYc.parserJson(optJSONObject3);
            sy(false);
        }
    }

    private void sy(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.jXV.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.jXV.removeAll(arrayList);
        }
        if (this.jXK + this.jXJ > 0) {
            if (this.jXJ > 0) {
                this.jXO = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jXJ), Integer.valueOf(this.jXK));
            } else {
                this.jXO = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jXK + this.jXJ));
            }
            if (this.jXV.size() > 0) {
                this.jXV.add(0, new b(this.jXM, this.jXO));
            }
        }
        if (this.jXI + this.jXH > 0) {
            if (this.jXH > 0) {
                this.jXN = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jXH), Integer.valueOf(this.jXI));
            } else {
                this.jXN = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jXI + this.jXH));
            }
            if (this.jXK + this.jXJ > 0) {
                if (this.jXV.size() > this.jXK + this.jXJ + 1) {
                    this.jXV.add(this.jXK + this.jXJ + 1, new b(this.jXL, this.jXN));
                }
            } else if (this.jXV.size() > 0) {
                this.jXV.add(0, new b(this.jXL, this.jXN));
            }
        }
        if (this.jXV.size() <= 0) {
            this.jXR = 3;
        } else if (this.jXG) {
            if (this.valid == 1 && this.jXX.size() > 0) {
                this.jXR = 0;
            } else {
                this.jXR = 2;
            }
        } else if (this.valid == 1 && this.jXK > 0) {
            this.jXR = 0;
        } else if (this.jXK + this.jXJ > 0) {
            this.jXR = 2;
        } else if (this.jXK + this.jXJ <= 0) {
            this.jXR = 3;
        }
    }
}
