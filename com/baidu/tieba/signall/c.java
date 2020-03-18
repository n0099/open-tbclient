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
    private String acK;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int jZA;
    private String jZB;
    private String jZC;
    private String jZD;
    private String jZE;
    private int jZF;
    private String jZG;
    private int jZH;
    private boolean jZI;
    private int jZJ;
    private int jZK;
    private int jZQ;
    private String jZq;
    private String jZr;
    private String jZs;
    private String jZt;
    private int jZu;
    private String jZv;
    private boolean jZw;
    private int jZx;
    private int jZy;
    private int jZz;
    private int level;
    private String title;
    private int valid;
    private String jZp = "0";
    private ArrayList<d> jZL = new ArrayList<>();
    private ArrayList<d> jZM = new ArrayList<>();
    private ArrayList<d> jZN = new ArrayList<>();
    private HashMap<String, d> jZO = new HashMap<>();
    private a jZP = new a();
    private f jZR = new f();
    private k jZS = new k();

    public boolean cIH() {
        return (this.jZR == null || StringUtils.isNull(this.jZR.kak)) ? false : true;
    }

    public String aRU() {
        return this.jZR.cNm;
    }

    public String cII() {
        return this.jZR.kak;
    }

    public String cIJ() {
        return this.jZS.kbF;
    }

    public String cIK() {
        return this.jZS.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cIL() {
        return !StringUtils.isNull(this.jZp) && this.jZp.equals("1");
    }

    public String cIM() {
        return this.jZq;
    }

    public String csF() {
        return this.acK;
    }

    public String cIN() {
        return this.jZr;
    }

    public String cIO() {
        return this.jZs;
    }

    public String cIP() {
        return this.jZt;
    }

    public int cIQ() {
        return this.jZu;
    }

    public String cIR() {
        return this.jZv;
    }

    public ArrayList<d> cIS() {
        return this.jZL;
    }

    public a cIT() {
        return this.jZP;
    }

    public ArrayList<d> cIU() {
        return this.jZM;
    }

    public ArrayList<d> cIV() {
        return this.jZN;
    }

    public boolean cIW() {
        return this.jZw;
    }

    public String cIX() {
        return this.jZG;
    }

    public String getContent() {
        return this.content;
    }

    public int cIY() {
        return this.jZH;
    }

    public boolean cIZ() {
        return this.jZI;
    }

    public int cJa() {
        return this.jZJ;
    }

    public int cJb() {
        return this.jZK;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.jZO.get(signData.forumId)) != null) {
            dVar.Cm(1);
            dVar.Cn(signData.count_sign_num);
            dVar.Cp(signData.sign_bonus_point);
            dVar.sF(true);
            dVar.sG(false);
            dVar.sH(false);
            a(dVar);
            cJc();
            sE(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cJf() >= this.level) {
            this.jZz++;
            this.jZA--;
        } else {
            this.jZx++;
            this.jZy--;
        }
        this.jZO.remove(String.valueOf(dVar.getForumId()));
        this.jZN.remove(dVar);
        if (dVar.cJg() + dVar.cJk() >= dVar.cJh()) {
            dVar.Co(dVar.cJf() + 1);
            dVar.sI(true);
            if (dVar.cJf() == this.level) {
                this.jZz++;
                this.jZx--;
            }
        }
        this.jZM.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cJk(), -1);
    }

    private void cJc() {
        if (this.jZw) {
            if (this.jZA + this.jZy <= 0) {
                this.jZI = true;
            } else {
                this.jZI = false;
            }
        } else if (this.jZA <= 0) {
            this.jZI = true;
        } else {
            this.jZI = false;
        }
    }

    public void a(h hVar) {
        this.jZJ = 0;
        this.jZK = 0;
        ArrayList<i> cJu = hVar.cJu();
        int size = cJu.size();
        for (int i = 0; i < size; i++) {
            i iVar = cJu.get(i);
            d dVar = this.jZO.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cJx() != 0) {
                    this.jZJ++;
                    dVar.Cm(1);
                    dVar.Cn(iVar.cJy());
                    dVar.Cp(iVar.getCurScore());
                    dVar.sF(true);
                    dVar.sG(false);
                    dVar.sH(false);
                    a(dVar);
                } else {
                    this.jZK++;
                    dVar.sF(false);
                    dVar.sG(true);
                    dVar.sH(false);
                    dVar.setErrorMsg(iVar.cIT().getUserMsg());
                }
            }
        }
        cJc();
        sE(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.jZP.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.jZp = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.jZq = jSONObject.optString("text_pre");
            this.acK = jSONObject.optString("text_color");
            this.jZr = jSONObject.optString("text_mid");
            this.jZs = jSONObject.optString("text_suf");
            this.jZt = jSONObject.optString("num_notice");
            this.jZu = jSONObject.optInt("show_dialog");
            this.jZv = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(UpdateConstants.VALID_KEY, 0);
            this.jZQ = jSONObject.optInt("sign_max_num", 50);
            this.jZF = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.jZG = jSONObject.optString("button_content");
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
            if (this.jZF == 1) {
                this.jZw = true;
            } else {
                this.jZw = false;
            }
            this.jZC = this.level + this.title;
            this.jZB = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.kbv = this.jZQ;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.kbv);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cJd() == 0) {
                            if (this.valid == 0) {
                                if (this.jZw) {
                                    dVar.sG(true);
                                } else if (dVar.cJf() > this.level) {
                                    dVar.sG(true);
                                }
                            }
                            if (dVar.cJf() >= this.level) {
                                this.jZA++;
                            } else {
                                this.jZy++;
                            }
                            this.jZN.add(dVar);
                            this.jZO.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cJf() >= this.level) {
                                this.jZz++;
                            } else {
                                this.jZx++;
                            }
                            this.jZM.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cJk(), -1);
                        }
                        this.jZL.add(dVar);
                        Collections.sort(this.jZL, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cJf() - dVar2.cJf();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.jZR == null) {
                this.jZR = new f();
            }
            this.jZR.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.jZS == null) {
                this.jZS = new k();
            }
            this.jZS.parserJson(optJSONObject3);
            sE(false);
        }
    }

    private void sE(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.jZL.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.jZL.removeAll(arrayList);
        }
        if (this.jZA + this.jZz > 0) {
            if (this.jZz > 0) {
                this.jZE = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jZz), Integer.valueOf(this.jZA));
            } else {
                this.jZE = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jZA + this.jZz));
            }
            if (this.jZL.size() > 0) {
                this.jZL.add(0, new b(this.jZC, this.jZE));
            }
        }
        if (this.jZy + this.jZx > 0) {
            if (this.jZx > 0) {
                this.jZD = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jZx), Integer.valueOf(this.jZy));
            } else {
                this.jZD = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jZy + this.jZx));
            }
            if (this.jZA + this.jZz > 0) {
                if (this.jZL.size() > this.jZA + this.jZz + 1) {
                    this.jZL.add(this.jZA + this.jZz + 1, new b(this.jZB, this.jZD));
                }
            } else if (this.jZL.size() > 0) {
                this.jZL.add(0, new b(this.jZB, this.jZD));
            }
        }
        if (this.jZL.size() <= 0) {
            this.jZH = 3;
        } else if (this.jZw) {
            if (this.valid == 1 && this.jZN.size() > 0) {
                this.jZH = 0;
            } else {
                this.jZH = 2;
            }
        } else if (this.valid == 1 && this.jZA > 0) {
            this.jZH = 0;
        } else if (this.jZA + this.jZz > 0) {
            this.jZH = 2;
        } else if (this.jZA + this.jZz <= 0) {
            this.jZH = 3;
        }
    }
}
