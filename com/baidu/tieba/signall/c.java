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
    private String avc;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String kID;
    private String kIE;
    private String kIF;
    private String kIG;
    private int kIH;
    private String kII;
    private boolean kIJ;
    private int kIK;
    private int kIL;
    private int kIM;
    private int kIN;
    private String kIO;
    private String kIP;
    private String kIQ;
    private String kIR;
    private int kIS;
    private String kIT;
    private int kIU;
    private boolean kIV;
    private int kIW;
    private int kIX;
    private int kJd;
    private int level;
    private String title;
    private int valid;
    private String kIC = "0";
    private ArrayList<d> kIY = new ArrayList<>();
    private ArrayList<d> kIZ = new ArrayList<>();
    private ArrayList<d> kJa = new ArrayList<>();
    private HashMap<String, d> kJb = new HashMap<>();
    private a kJc = new a();
    private f kJe = new f();
    private k kJf = new k();

    public boolean cTk() {
        return (this.kJe == null || StringUtils.isNull(this.kJe.kJx)) ? false : true;
    }

    public String bad() {
        return this.kJe.dmq;
    }

    public String cTl() {
        return this.kJe.kJx;
    }

    public String cTm() {
        return this.kJf.kKU;
    }

    public String cTn() {
        return this.kJf.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cTo() {
        return !StringUtils.isNull(this.kIC) && this.kIC.equals("1");
    }

    public String cTp() {
        return this.kID;
    }

    public String cDl() {
        return this.avc;
    }

    public String cTq() {
        return this.kIE;
    }

    public String cTr() {
        return this.kIF;
    }

    public String cTs() {
        return this.kIG;
    }

    public int cTt() {
        return this.kIH;
    }

    public String cTu() {
        return this.kII;
    }

    public ArrayList<d> cTv() {
        return this.kIY;
    }

    public a cTw() {
        return this.kJc;
    }

    public ArrayList<d> cTx() {
        return this.kIZ;
    }

    public ArrayList<d> cTy() {
        return this.kJa;
    }

    public boolean cTz() {
        return this.kIJ;
    }

    public String cTA() {
        return this.kIT;
    }

    public String getContent() {
        return this.content;
    }

    public int cTB() {
        return this.kIU;
    }

    public boolean cTC() {
        return this.kIV;
    }

    public int cTD() {
        return this.kIW;
    }

    public int cTE() {
        return this.kIX;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.kJb.get(signData.forumId)) != null) {
            dVar.CM(1);
            dVar.CN(signData.count_sign_num);
            dVar.CP(signData.sign_bonus_point);
            dVar.tG(true);
            dVar.tH(false);
            dVar.tI(false);
            a(dVar);
            cTF();
            tF(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cTI() >= this.level) {
            this.kIM++;
            this.kIN--;
        } else {
            this.kIK++;
            this.kIL--;
        }
        this.kJb.remove(String.valueOf(dVar.getForumId()));
        this.kJa.remove(dVar);
        if (dVar.cTJ() + dVar.cTN() >= dVar.cTK()) {
            dVar.CO(dVar.cTI() + 1);
            dVar.tJ(true);
            if (dVar.cTI() == this.level) {
                this.kIM++;
                this.kIK--;
            }
        }
        this.kIZ.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cTN(), -1);
    }

    private void cTF() {
        if (this.kIJ) {
            if (this.kIN + this.kIL <= 0) {
                this.kIV = true;
            } else {
                this.kIV = false;
            }
        } else if (this.kIN <= 0) {
            this.kIV = true;
        } else {
            this.kIV = false;
        }
    }

    public void a(h hVar) {
        this.kIW = 0;
        this.kIX = 0;
        ArrayList<i> cTY = hVar.cTY();
        int size = cTY.size();
        for (int i = 0; i < size; i++) {
            i iVar = cTY.get(i);
            d dVar = this.kJb.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cUb() != 0) {
                    this.kIW++;
                    dVar.CM(1);
                    dVar.CN(iVar.cUc());
                    dVar.CP(iVar.getCurScore());
                    dVar.tG(true);
                    dVar.tH(false);
                    dVar.tI(false);
                    a(dVar);
                } else {
                    this.kIX++;
                    dVar.tG(false);
                    dVar.tH(true);
                    dVar.tI(false);
                    dVar.setErrorMsg(iVar.cTw().getUserMsg());
                }
            }
        }
        cTF();
        tF(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.kJc.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.kIC = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.kID = jSONObject.optString("text_pre");
            this.avc = jSONObject.optString("text_color");
            this.kIE = jSONObject.optString("text_mid");
            this.kIF = jSONObject.optString("text_suf");
            this.kIG = jSONObject.optString("num_notice");
            this.kIH = jSONObject.optInt("show_dialog");
            this.kII = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.kJd = jSONObject.optInt("sign_max_num", 50);
            this.kIS = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.kIT = jSONObject.optString("button_content");
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
            if (this.kIS == 1) {
                this.kIJ = true;
            } else {
                this.kIJ = false;
            }
            this.kIP = this.level + this.title;
            this.kIO = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.kKK = this.kJd;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.kKK);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cTG() == 0) {
                            if (this.valid == 0) {
                                if (this.kIJ) {
                                    dVar.tH(true);
                                } else if (dVar.cTI() > this.level) {
                                    dVar.tH(true);
                                }
                            }
                            if (dVar.cTI() >= this.level) {
                                this.kIN++;
                            } else {
                                this.kIL++;
                            }
                            this.kJa.add(dVar);
                            this.kJb.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cTI() >= this.level) {
                                this.kIM++;
                            } else {
                                this.kIK++;
                            }
                            this.kIZ.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cTN(), -1);
                        }
                        this.kIY.add(dVar);
                        Collections.sort(this.kIY, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cTI() - dVar2.cTI();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.kJe == null) {
                this.kJe = new f();
            }
            this.kJe.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.kJf == null) {
                this.kJf = new k();
            }
            this.kJf.parserJson(optJSONObject3);
            tF(false);
        }
    }

    private void tF(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.kIY.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.kIY.removeAll(arrayList);
        }
        if (this.kIN + this.kIM > 0) {
            if (this.kIM > 0) {
                this.kIR = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.kIM), Integer.valueOf(this.kIN));
            } else {
                this.kIR = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.kIN + this.kIM));
            }
            if (this.kIY.size() > 0) {
                this.kIY.add(0, new b(this.kIP, this.kIR));
            }
        }
        if (this.kIL + this.kIK > 0) {
            if (this.kIK > 0) {
                this.kIQ = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.kIK), Integer.valueOf(this.kIL));
            } else {
                this.kIQ = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.kIL + this.kIK));
            }
            if (this.kIN + this.kIM > 0) {
                if (this.kIY.size() > this.kIN + this.kIM + 1) {
                    this.kIY.add(this.kIN + this.kIM + 1, new b(this.kIO, this.kIQ));
                }
            } else if (this.kIY.size() > 0) {
                this.kIY.add(0, new b(this.kIO, this.kIQ));
            }
        }
        if (this.kIY.size() <= 0) {
            this.kIU = 3;
        } else if (this.kIJ) {
            if (this.valid == 1 && this.kJa.size() > 0) {
                this.kIU = 0;
            } else {
                this.kIU = 2;
            }
        } else if (this.valid == 1 && this.kIN > 0) {
            this.kIU = 0;
        } else if (this.kIN + this.kIM > 0) {
            this.kIU = 2;
        } else if (this.kIN + this.kIM <= 0) {
            this.kIU = 3;
        }
    }
}
