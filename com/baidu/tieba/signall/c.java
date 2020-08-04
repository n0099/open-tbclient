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
    private int lDA;
    private String lDB;
    private boolean lDC;
    private int lDD;
    private int lDE;
    private int lDF;
    private int lDG;
    private String lDH;
    private String lDI;
    private String lDJ;
    private String lDK;
    private int lDL;
    private String lDM;
    private int lDN;
    private boolean lDO;
    private int lDP;
    private int lDQ;
    private int lDW;
    private String lDw;
    private String lDx;
    private String lDy;
    private String lDz;
    private int level;
    private String title;
    private int valid;
    private String lDv = "0";
    private ArrayList<d> lDR = new ArrayList<>();
    private ArrayList<d> lDS = new ArrayList<>();
    private ArrayList<d> lDT = new ArrayList<>();
    private HashMap<String, d> lDU = new HashMap<>();
    private a lDV = new a();
    private f lDX = new f();
    private k lDY = new k();

    public boolean dic() {
        return (this.lDX == null || StringUtils.isNull(this.lDX.lEq)) ? false : true;
    }

    public String bmn() {
        return this.lDX.dMY;
    }

    public String did() {
        return this.lDX.lEq;
    }

    public String die() {
        return this.lDY.lFN;
    }

    public String dif() {
        return this.lDY.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dig() {
        return !StringUtils.isNull(this.lDv) && this.lDv.equals("1");
    }

    public String dih() {
        return this.lDw;
    }

    public String cSC() {
        return this.aDW;
    }

    public String dii() {
        return this.lDx;
    }

    public String dij() {
        return this.lDy;
    }

    public String dik() {
        return this.lDz;
    }

    public int dil() {
        return this.lDA;
    }

    public String dim() {
        return this.lDB;
    }

    public ArrayList<d> din() {
        return this.lDR;
    }

    public a dio() {
        return this.lDV;
    }

    public ArrayList<d> dip() {
        return this.lDS;
    }

    public ArrayList<d> diq() {
        return this.lDT;
    }

    public boolean dir() {
        return this.lDC;
    }

    public String dis() {
        return this.lDM;
    }

    public String getContent() {
        return this.content;
    }

    public int dit() {
        return this.lDN;
    }

    public boolean diu() {
        return this.lDO;
    }

    public int div() {
        return this.lDP;
    }

    public int diw() {
        return this.lDQ;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.lDU.get(signData.forumId)) != null) {
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
            this.lDF++;
            this.lDG--;
        } else {
            this.lDD++;
            this.lDE--;
        }
        this.lDU.remove(String.valueOf(dVar.getForumId()));
        this.lDT.remove(dVar);
        if (dVar.diB() + dVar.diF() >= dVar.diC()) {
            dVar.EY(dVar.diA() + 1);
            dVar.va(true);
            if (dVar.diA() == this.level) {
                this.lDF++;
                this.lDD--;
            }
        }
        this.lDS.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.diF(), -1);
    }

    private void dix() {
        if (this.lDC) {
            if (this.lDG + this.lDE <= 0) {
                this.lDO = true;
            } else {
                this.lDO = false;
            }
        } else if (this.lDG <= 0) {
            this.lDO = true;
        } else {
            this.lDO = false;
        }
    }

    public void a(h hVar) {
        this.lDP = 0;
        this.lDQ = 0;
        ArrayList<i> diP = hVar.diP();
        int size = diP.size();
        for (int i = 0; i < size; i++) {
            i iVar = diP.get(i);
            d dVar = this.lDU.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.diS() != 0) {
                    this.lDP++;
                    dVar.EW(1);
                    dVar.EX(iVar.diT());
                    dVar.EZ(iVar.getCurScore());
                    dVar.uX(true);
                    dVar.uY(false);
                    dVar.uZ(false);
                    a(dVar);
                } else {
                    this.lDQ++;
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
            this.lDV.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.lDv = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.lDw = jSONObject.optString("text_pre");
            this.aDW = jSONObject.optString("text_color");
            this.lDx = jSONObject.optString("text_mid");
            this.lDy = jSONObject.optString("text_suf");
            this.lDz = jSONObject.optString("num_notice");
            this.lDA = jSONObject.optInt("show_dialog");
            this.lDB = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.lDW = jSONObject.optInt("sign_max_num", 50);
            this.lDL = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.lDM = jSONObject.optString("button_content");
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
            if (this.lDL == 1) {
                this.lDC = true;
            } else {
                this.lDC = false;
            }
            this.lDI = this.level + this.title;
            this.lDH = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.lFD = this.lDW;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.lFD);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.diy() == 0) {
                            if (this.valid == 0) {
                                if (this.lDC) {
                                    dVar.uY(true);
                                } else if (dVar.diA() > this.level) {
                                    dVar.uY(true);
                                }
                            }
                            if (dVar.diA() >= this.level) {
                                this.lDG++;
                            } else {
                                this.lDE++;
                            }
                            this.lDT.add(dVar);
                            this.lDU.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.diA() >= this.level) {
                                this.lDF++;
                            } else {
                                this.lDD++;
                            }
                            this.lDS.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.diF(), -1);
                        }
                        this.lDR.add(dVar);
                        Collections.sort(this.lDR, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
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
            if (this.lDX == null) {
                this.lDX = new f();
            }
            this.lDX.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.lDY == null) {
                this.lDY = new k();
            }
            this.lDY.parserJson(optJSONObject3);
            uW(false);
        }
    }

    private void uW(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.lDR.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.lDR.removeAll(arrayList);
        }
        if (this.lDG + this.lDF > 0) {
            if (this.lDF > 0) {
                this.lDK = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lDF), Integer.valueOf(this.lDG));
            } else {
                this.lDK = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lDG + this.lDF));
            }
            if (this.lDR.size() > 0) {
                this.lDR.add(0, new b(this.lDI, this.lDK));
            }
        }
        if (this.lDE + this.lDD > 0) {
            if (this.lDD > 0) {
                this.lDJ = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lDD), Integer.valueOf(this.lDE));
            } else {
                this.lDJ = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lDE + this.lDD));
            }
            if (this.lDG + this.lDF > 0) {
                if (this.lDR.size() > this.lDG + this.lDF + 1) {
                    this.lDR.add(this.lDG + this.lDF + 1, new b(this.lDH, this.lDJ));
                }
            } else if (this.lDR.size() > 0) {
                this.lDR.add(0, new b(this.lDH, this.lDJ));
            }
        }
        if (this.lDR.size() <= 0) {
            this.lDN = 3;
        } else if (this.lDC) {
            if (this.valid == 1 && this.lDT.size() > 0) {
                this.lDN = 0;
            } else {
                this.lDN = 2;
            }
        } else if (this.valid == 1 && this.lDG > 0) {
            this.lDN = 0;
        } else if (this.lDG + this.lDF > 0) {
            this.lDN = 2;
        } else if (this.lDG + this.lDF <= 0) {
            this.lDN = 3;
        }
    }
}
