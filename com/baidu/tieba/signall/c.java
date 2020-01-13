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
/* loaded from: classes9.dex */
public class c {
    private String aaC;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String jWA;
    private boolean jWB;
    private int jWC;
    private int jWD;
    private int jWE;
    private int jWF;
    private String jWG;
    private String jWH;
    private String jWI;
    private String jWJ;
    private int jWK;
    private String jWL;
    private int jWM;
    private boolean jWN;
    private int jWO;
    private int jWP;
    private int jWV;
    private String jWv;
    private String jWw;
    private String jWx;
    private String jWy;
    private int jWz;
    private int level;
    private String title;
    private int valid;
    private String jWu = "0";
    private ArrayList<d> jWQ = new ArrayList<>();
    private ArrayList<d> jWR = new ArrayList<>();
    private ArrayList<d> jWS = new ArrayList<>();
    private HashMap<String, d> jWT = new HashMap<>();
    private a jWU = new a();
    private f jWW = new f();
    private k jWX = new k();

    public boolean cGE() {
        return (this.jWW == null || StringUtils.isNull(this.jWW.jXq)) ? false : true;
    }

    public String aPw() {
        return this.jWW.cIU;
    }

    public String cGF() {
        return this.jWW.jXq;
    }

    public String cGG() {
        return this.jWX.jYK;
    }

    public String cGH() {
        return this.jWX.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cGI() {
        return !StringUtils.isNull(this.jWu) && this.jWu.equals("1");
    }

    public String cGJ() {
        return this.jWv;
    }

    public String cqP() {
        return this.aaC;
    }

    public String cGK() {
        return this.jWw;
    }

    public String cGL() {
        return this.jWx;
    }

    public String cGM() {
        return this.jWy;
    }

    public int cGN() {
        return this.jWz;
    }

    public String cGO() {
        return this.jWA;
    }

    public ArrayList<d> cGP() {
        return this.jWQ;
    }

    public a cGQ() {
        return this.jWU;
    }

    public ArrayList<d> cGR() {
        return this.jWR;
    }

    public ArrayList<d> cGS() {
        return this.jWS;
    }

    public boolean cGT() {
        return this.jWB;
    }

    public String cGU() {
        return this.jWL;
    }

    public String getContent() {
        return this.content;
    }

    public int cGV() {
        return this.jWM;
    }

    public boolean cGW() {
        return this.jWN;
    }

    public int cGX() {
        return this.jWO;
    }

    public int cGY() {
        return this.jWP;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.jWT.get(signData.forumId)) != null) {
            dVar.BX(1);
            dVar.BY(signData.count_sign_num);
            dVar.Ca(signData.sign_bonus_point);
            dVar.sv(true);
            dVar.sw(false);
            dVar.sx(false);
            a(dVar);
            cGZ();
            su(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cHc() >= this.level) {
            this.jWE++;
            this.jWF--;
        } else {
            this.jWC++;
            this.jWD--;
        }
        this.jWT.remove(String.valueOf(dVar.getForumId()));
        this.jWS.remove(dVar);
        if (dVar.cHd() + dVar.cHh() >= dVar.cHe()) {
            dVar.BZ(dVar.cHc() + 1);
            dVar.sy(true);
            if (dVar.cHc() == this.level) {
                this.jWE++;
                this.jWC--;
            }
        }
        this.jWR.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cHh(), -1);
    }

    private void cGZ() {
        if (this.jWB) {
            if (this.jWF + this.jWD <= 0) {
                this.jWN = true;
            } else {
                this.jWN = false;
            }
        } else if (this.jWF <= 0) {
            this.jWN = true;
        } else {
            this.jWN = false;
        }
    }

    public void a(h hVar) {
        this.jWO = 0;
        this.jWP = 0;
        ArrayList<i> cHr = hVar.cHr();
        int size = cHr.size();
        for (int i = 0; i < size; i++) {
            i iVar = cHr.get(i);
            d dVar = this.jWT.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cHu() != 0) {
                    this.jWO++;
                    dVar.BX(1);
                    dVar.BY(iVar.cHv());
                    dVar.Ca(iVar.getCurScore());
                    dVar.sv(true);
                    dVar.sw(false);
                    dVar.sx(false);
                    a(dVar);
                } else {
                    this.jWP++;
                    dVar.sv(false);
                    dVar.sw(true);
                    dVar.sx(false);
                    dVar.setErrorMsg(iVar.cGQ().getUserMsg());
                }
            }
        }
        cGZ();
        su(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.jWU.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.jWu = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.jWv = jSONObject.optString("text_pre");
            this.aaC = jSONObject.optString("text_color");
            this.jWw = jSONObject.optString("text_mid");
            this.jWx = jSONObject.optString("text_suf");
            this.jWy = jSONObject.optString("num_notice");
            this.jWz = jSONObject.optInt("show_dialog");
            this.jWA = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(UpdateConstants.VALID_KEY, 0);
            this.jWV = jSONObject.optInt("sign_max_num", 50);
            this.jWK = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.jWL = jSONObject.optString("button_content");
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
            if (this.jWK == 1) {
                this.jWB = true;
            } else {
                this.jWB = false;
            }
            this.jWH = this.level + this.title;
            this.jWG = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.jYA = this.jWV;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.jYA);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cHa() == 0) {
                            if (this.valid == 0) {
                                if (this.jWB) {
                                    dVar.sw(true);
                                } else if (dVar.cHc() > this.level) {
                                    dVar.sw(true);
                                }
                            }
                            if (dVar.cHc() >= this.level) {
                                this.jWF++;
                            } else {
                                this.jWD++;
                            }
                            this.jWS.add(dVar);
                            this.jWT.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cHc() >= this.level) {
                                this.jWE++;
                            } else {
                                this.jWC++;
                            }
                            this.jWR.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cHh(), -1);
                        }
                        this.jWQ.add(dVar);
                        Collections.sort(this.jWQ, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cHc() - dVar2.cHc();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.jWW == null) {
                this.jWW = new f();
            }
            this.jWW.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.jWX == null) {
                this.jWX = new k();
            }
            this.jWX.parserJson(optJSONObject3);
            su(false);
        }
    }

    private void su(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.jWQ.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.jWQ.removeAll(arrayList);
        }
        if (this.jWF + this.jWE > 0) {
            if (this.jWE > 0) {
                this.jWJ = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jWE), Integer.valueOf(this.jWF));
            } else {
                this.jWJ = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jWF + this.jWE));
            }
            if (this.jWQ.size() > 0) {
                this.jWQ.add(0, new b(this.jWH, this.jWJ));
            }
        }
        if (this.jWD + this.jWC > 0) {
            if (this.jWC > 0) {
                this.jWI = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jWC), Integer.valueOf(this.jWD));
            } else {
                this.jWI = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jWD + this.jWC));
            }
            if (this.jWF + this.jWE > 0) {
                if (this.jWQ.size() > this.jWF + this.jWE + 1) {
                    this.jWQ.add(this.jWF + this.jWE + 1, new b(this.jWG, this.jWI));
                }
            } else if (this.jWQ.size() > 0) {
                this.jWQ.add(0, new b(this.jWG, this.jWI));
            }
        }
        if (this.jWQ.size() <= 0) {
            this.jWM = 3;
        } else if (this.jWB) {
            if (this.valid == 1 && this.jWS.size() > 0) {
                this.jWM = 0;
            } else {
                this.jWM = 2;
            }
        } else if (this.valid == 1 && this.jWF > 0) {
            this.jWM = 0;
        } else if (this.jWF + this.jWE > 0) {
            this.jWM = 2;
        } else if (this.jWF + this.jWE <= 0) {
            this.jWM = 3;
        }
    }
}
