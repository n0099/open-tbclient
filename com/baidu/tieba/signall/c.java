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
/* loaded from: classes18.dex */
public class c {
    private String aDW;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private boolean lDA;
    private int lDB;
    private int lDC;
    private int lDD;
    private int lDE;
    private String lDF;
    private String lDG;
    private String lDH;
    private String lDI;
    private int lDJ;
    private String lDK;
    private int lDL;
    private boolean lDM;
    private int lDN;
    private int lDO;
    private int lDU;
    private String lDu;
    private String lDv;
    private String lDw;
    private String lDx;
    private int lDy;
    private String lDz;
    private int level;
    private String title;
    private int valid;
    private String lDt = "0";
    private ArrayList<d> lDP = new ArrayList<>();
    private ArrayList<d> lDQ = new ArrayList<>();
    private ArrayList<d> lDR = new ArrayList<>();
    private HashMap<String, d> lDS = new HashMap<>();
    private a lDT = new a();
    private f lDV = new f();
    private k lDW = new k();

    public boolean dic() {
        return (this.lDV == null || StringUtils.isNull(this.lDV.lEo)) ? false : true;
    }

    public String bmn() {
        return this.lDV.dMY;
    }

    public String did() {
        return this.lDV.lEo;
    }

    public String die() {
        return this.lDW.lFL;
    }

    public String dif() {
        return this.lDW.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dig() {
        return !StringUtils.isNull(this.lDt) && this.lDt.equals("1");
    }

    public String dih() {
        return this.lDu;
    }

    public String cSC() {
        return this.aDW;
    }

    public String dii() {
        return this.lDv;
    }

    public String dij() {
        return this.lDw;
    }

    public String dik() {
        return this.lDx;
    }

    public int dil() {
        return this.lDy;
    }

    public String dim() {
        return this.lDz;
    }

    public ArrayList<d> din() {
        return this.lDP;
    }

    public a dio() {
        return this.lDT;
    }

    public ArrayList<d> dip() {
        return this.lDQ;
    }

    public ArrayList<d> diq() {
        return this.lDR;
    }

    public boolean dir() {
        return this.lDA;
    }

    public String dis() {
        return this.lDK;
    }

    public String getContent() {
        return this.content;
    }

    public int dit() {
        return this.lDL;
    }

    public boolean diu() {
        return this.lDM;
    }

    public int div() {
        return this.lDN;
    }

    public int diw() {
        return this.lDO;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.lDS.get(signData.forumId)) != null) {
            dVar.EW(1);
            dVar.EX(signData.count_sign_num);
            dVar.EZ(signData.sign_bonus_point);
            dVar.uX(true);
            dVar.uY(false);
            dVar.uZ(false);
            a(dVar);
            dix();
            uW(true);
        }
    }

    private void a(d dVar) {
        if (dVar.diA() >= this.level) {
            this.lDD++;
            this.lDE--;
        } else {
            this.lDB++;
            this.lDC--;
        }
        this.lDS.remove(String.valueOf(dVar.getForumId()));
        this.lDR.remove(dVar);
        if (dVar.diB() + dVar.diF() >= dVar.diC()) {
            dVar.EY(dVar.diA() + 1);
            dVar.va(true);
            if (dVar.diA() == this.level) {
                this.lDD++;
                this.lDB--;
            }
        }
        this.lDQ.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.diF(), -1);
    }

    private void dix() {
        if (this.lDA) {
            if (this.lDE + this.lDC <= 0) {
                this.lDM = true;
            } else {
                this.lDM = false;
            }
        } else if (this.lDE <= 0) {
            this.lDM = true;
        } else {
            this.lDM = false;
        }
    }

    public void a(h hVar) {
        this.lDN = 0;
        this.lDO = 0;
        ArrayList<i> diP = hVar.diP();
        int size = diP.size();
        for (int i = 0; i < size; i++) {
            i iVar = diP.get(i);
            d dVar = this.lDS.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.diS() != 0) {
                    this.lDN++;
                    dVar.EW(1);
                    dVar.EX(iVar.diT());
                    dVar.EZ(iVar.getCurScore());
                    dVar.uX(true);
                    dVar.uY(false);
                    dVar.uZ(false);
                    a(dVar);
                } else {
                    this.lDO++;
                    dVar.uX(false);
                    dVar.uY(true);
                    dVar.uZ(false);
                    dVar.setErrorMsg(iVar.dio().getUserMsg());
                }
            }
        }
        dix();
        uW(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lDT.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.lDt = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.lDu = jSONObject.optString("text_pre");
            this.aDW = jSONObject.optString("text_color");
            this.lDv = jSONObject.optString("text_mid");
            this.lDw = jSONObject.optString("text_suf");
            this.lDx = jSONObject.optString("num_notice");
            this.lDy = jSONObject.optInt("show_dialog");
            this.lDz = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.lDU = jSONObject.optInt("sign_max_num", 50);
            this.lDJ = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.lDK = jSONObject.optString("button_content");
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
            if (this.lDJ == 1) {
                this.lDA = true;
            } else {
                this.lDA = false;
            }
            this.lDG = this.level + this.title;
            this.lDF = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.lFB = this.lDU;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.lFB);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.diy() == 0) {
                            if (this.valid == 0) {
                                if (this.lDA) {
                                    dVar.uY(true);
                                } else if (dVar.diA() > this.level) {
                                    dVar.uY(true);
                                }
                            }
                            if (dVar.diA() >= this.level) {
                                this.lDE++;
                            } else {
                                this.lDC++;
                            }
                            this.lDR.add(dVar);
                            this.lDS.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.diA() >= this.level) {
                                this.lDD++;
                            } else {
                                this.lDB++;
                            }
                            this.lDQ.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.diF(), -1);
                        }
                        this.lDP.add(dVar);
                        Collections.sort(this.lDP, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.diA() - dVar2.diA();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.lDV == null) {
                this.lDV = new f();
            }
            this.lDV.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.lDW == null) {
                this.lDW = new k();
            }
            this.lDW.parserJson(optJSONObject3);
            uW(false);
        }
    }

    private void uW(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.lDP.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.lDP.removeAll(arrayList);
        }
        if (this.lDE + this.lDD > 0) {
            if (this.lDD > 0) {
                this.lDI = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lDD), Integer.valueOf(this.lDE));
            } else {
                this.lDI = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lDE + this.lDD));
            }
            if (this.lDP.size() > 0) {
                this.lDP.add(0, new b(this.lDG, this.lDI));
            }
        }
        if (this.lDC + this.lDB > 0) {
            if (this.lDB > 0) {
                this.lDH = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lDB), Integer.valueOf(this.lDC));
            } else {
                this.lDH = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lDC + this.lDB));
            }
            if (this.lDE + this.lDD > 0) {
                if (this.lDP.size() > this.lDE + this.lDD + 1) {
                    this.lDP.add(this.lDE + this.lDD + 1, new b(this.lDF, this.lDH));
                }
            } else if (this.lDP.size() > 0) {
                this.lDP.add(0, new b(this.lDF, this.lDH));
            }
        }
        if (this.lDP.size() <= 0) {
            this.lDL = 3;
        } else if (this.lDA) {
            if (this.valid == 1 && this.lDR.size() > 0) {
                this.lDL = 0;
            } else {
                this.lDL = 2;
            }
        } else if (this.valid == 1 && this.lDE > 0) {
            this.lDL = 0;
        } else if (this.lDE + this.lDD > 0) {
            this.lDL = 2;
        } else if (this.lDE + this.lDD <= 0) {
            this.lDL = 3;
        }
    }
}
