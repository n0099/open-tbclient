package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
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
    private String avi;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String kIH;
    private String kII;
    private String kIJ;
    private String kIK;
    private int kIL;
    private String kIM;
    private boolean kIN;
    private int kIO;
    private int kIP;
    private int kIQ;
    private int kIR;
    private String kIS;
    private String kIT;
    private String kIU;
    private String kIV;
    private int kIW;
    private String kIX;
    private int kIY;
    private boolean kIZ;
    private int kJa;
    private int kJb;
    private int kJh;
    private int level;
    private String title;
    private int valid;
    private String kIG = "0";
    private ArrayList<d> kJc = new ArrayList<>();
    private ArrayList<d> kJd = new ArrayList<>();
    private ArrayList<d> kJe = new ArrayList<>();
    private HashMap<String, d> kJf = new HashMap<>();
    private a kJg = new a();
    private f kJi = new f();
    private k kJj = new k();

    public boolean cTi() {
        return (this.kJi == null || StringUtils.isNull(this.kJi.kJB)) ? false : true;
    }

    public String bab() {
        return this.kJi.dmu;
    }

    public String cTj() {
        return this.kJi.kJB;
    }

    public String cTk() {
        return this.kJj.kKY;
    }

    public String cTl() {
        return this.kJj.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cTm() {
        return !StringUtils.isNull(this.kIG) && this.kIG.equals("1");
    }

    public String cTn() {
        return this.kIH;
    }

    public String cDj() {
        return this.avi;
    }

    public String cTo() {
        return this.kII;
    }

    public String cTp() {
        return this.kIJ;
    }

    public String cTq() {
        return this.kIK;
    }

    public int cTr() {
        return this.kIL;
    }

    public String cTs() {
        return this.kIM;
    }

    public ArrayList<d> cTt() {
        return this.kJc;
    }

    public a cTu() {
        return this.kJg;
    }

    public ArrayList<d> cTv() {
        return this.kJd;
    }

    public ArrayList<d> cTw() {
        return this.kJe;
    }

    public boolean cTx() {
        return this.kIN;
    }

    public String cTy() {
        return this.kIX;
    }

    public String getContent() {
        return this.content;
    }

    public int cTz() {
        return this.kIY;
    }

    public boolean cTA() {
        return this.kIZ;
    }

    public int cTB() {
        return this.kJa;
    }

    public int cTC() {
        return this.kJb;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.kJf.get(signData.forumId)) != null) {
            dVar.CM(1);
            dVar.CN(signData.count_sign_num);
            dVar.CP(signData.sign_bonus_point);
            dVar.tG(true);
            dVar.tH(false);
            dVar.tI(false);
            a(dVar);
            cTD();
            tF(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cTG() >= this.level) {
            this.kIQ++;
            this.kIR--;
        } else {
            this.kIO++;
            this.kIP--;
        }
        this.kJf.remove(String.valueOf(dVar.getForumId()));
        this.kJe.remove(dVar);
        if (dVar.cTH() + dVar.cTL() >= dVar.cTI()) {
            dVar.CO(dVar.cTG() + 1);
            dVar.tJ(true);
            if (dVar.cTG() == this.level) {
                this.kIQ++;
                this.kIO--;
            }
        }
        this.kJd.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cTL(), -1);
    }

    private void cTD() {
        if (this.kIN) {
            if (this.kIR + this.kIP <= 0) {
                this.kIZ = true;
            } else {
                this.kIZ = false;
            }
        } else if (this.kIR <= 0) {
            this.kIZ = true;
        } else {
            this.kIZ = false;
        }
    }

    public void a(h hVar) {
        this.kJa = 0;
        this.kJb = 0;
        ArrayList<i> cTW = hVar.cTW();
        int size = cTW.size();
        for (int i = 0; i < size; i++) {
            i iVar = cTW.get(i);
            d dVar = this.kJf.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cTZ() != 0) {
                    this.kJa++;
                    dVar.CM(1);
                    dVar.CN(iVar.cUa());
                    dVar.CP(iVar.getCurScore());
                    dVar.tG(true);
                    dVar.tH(false);
                    dVar.tI(false);
                    a(dVar);
                } else {
                    this.kJb++;
                    dVar.tG(false);
                    dVar.tH(true);
                    dVar.tI(false);
                    dVar.setErrorMsg(iVar.cTu().getUserMsg());
                }
            }
        }
        cTD();
        tF(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.kJg.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.kIG = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.kIH = jSONObject.optString("text_pre");
            this.avi = jSONObject.optString("text_color");
            this.kII = jSONObject.optString("text_mid");
            this.kIJ = jSONObject.optString("text_suf");
            this.kIK = jSONObject.optString("num_notice");
            this.kIL = jSONObject.optInt("show_dialog");
            this.kIM = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.kJh = jSONObject.optInt("sign_max_num", 50);
            this.kIW = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.kIX = jSONObject.optString("button_content");
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
            if (this.kIW == 1) {
                this.kIN = true;
            } else {
                this.kIN = false;
            }
            this.kIT = this.level + this.title;
            this.kIS = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.kKO = this.kJh;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.kKO);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cTE() == 0) {
                            if (this.valid == 0) {
                                if (this.kIN) {
                                    dVar.tH(true);
                                } else if (dVar.cTG() > this.level) {
                                    dVar.tH(true);
                                }
                            }
                            if (dVar.cTG() >= this.level) {
                                this.kIR++;
                            } else {
                                this.kIP++;
                            }
                            this.kJe.add(dVar);
                            this.kJf.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cTG() >= this.level) {
                                this.kIQ++;
                            } else {
                                this.kIO++;
                            }
                            this.kJd.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cTL(), -1);
                        }
                        this.kJc.add(dVar);
                        Collections.sort(this.kJc, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cTG() - dVar2.cTG();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.kJi == null) {
                this.kJi = new f();
            }
            this.kJi.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.kJj == null) {
                this.kJj = new k();
            }
            this.kJj.parserJson(optJSONObject3);
            tF(false);
        }
    }

    private void tF(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.kJc.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.kJc.removeAll(arrayList);
        }
        if (this.kIR + this.kIQ > 0) {
            if (this.kIQ > 0) {
                this.kIV = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.kIQ), Integer.valueOf(this.kIR));
            } else {
                this.kIV = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.kIR + this.kIQ));
            }
            if (this.kJc.size() > 0) {
                this.kJc.add(0, new b(this.kIT, this.kIV));
            }
        }
        if (this.kIP + this.kIO > 0) {
            if (this.kIO > 0) {
                this.kIU = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.kIO), Integer.valueOf(this.kIP));
            } else {
                this.kIU = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.kIP + this.kIO));
            }
            if (this.kIR + this.kIQ > 0) {
                if (this.kJc.size() > this.kIR + this.kIQ + 1) {
                    this.kJc.add(this.kIR + this.kIQ + 1, new b(this.kIS, this.kIU));
                }
            } else if (this.kJc.size() > 0) {
                this.kJc.add(0, new b(this.kIS, this.kIU));
            }
        }
        if (this.kJc.size() <= 0) {
            this.kIY = 3;
        } else if (this.kIN) {
            if (this.valid == 1 && this.kJe.size() > 0) {
                this.kIY = 0;
            } else {
                this.kIY = 2;
            }
        } else if (this.valid == 1 && this.kIR > 0) {
            this.kIY = 0;
        } else if (this.kIR + this.kIQ > 0) {
            this.kIY = 2;
        } else if (this.kIR + this.kIQ <= 0) {
            this.kIY = 3;
        }
    }
}
