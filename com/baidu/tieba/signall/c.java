package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
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
    private String akz;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String iPC;
    private String iPD;
    private String iPE;
    private String iPF;
    private int iPG;
    private String iPH;
    private int iPI;
    private boolean iPJ;
    private int iPK;
    private int iPL;
    private int iPM;
    private int iPN;
    private String iPO;
    private String iPP;
    private String iPQ;
    private String iPR;
    private int iPS;
    private String iPT;
    private int iPU;
    private boolean iPV;
    private int iPW;
    private int iPX;
    private int iQd;
    private int level;
    private String title;
    private String iPB = "0";
    private ArrayList<d> iPY = new ArrayList<>();
    private ArrayList<d> iPZ = new ArrayList<>();
    private ArrayList<d> iQa = new ArrayList<>();
    private HashMap<String, d> iQb = new HashMap<>();
    private a iQc = new a();
    private f iQe = new f();
    private k iQf = new k();

    public boolean cjF() {
        return (this.iQe == null || StringUtils.isNull(this.iQe.iQx)) ? false : true;
    }

    public String auQ() {
        return this.iQe.bDU;
    }

    public String cjG() {
        return this.iQe.iQx;
    }

    public String cjH() {
        return this.iQf.iRR;
    }

    public String cjI() {
        return this.iQf.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cjJ() {
        return !StringUtils.isNull(this.iPB) && this.iPB.equals("1");
    }

    public String cjK() {
        return this.iPC;
    }

    public String bWQ() {
        return this.akz;
    }

    public String cjL() {
        return this.iPD;
    }

    public String cjM() {
        return this.iPE;
    }

    public String cjN() {
        return this.iPF;
    }

    public int cjO() {
        return this.iPG;
    }

    public String cjP() {
        return this.iPH;
    }

    public ArrayList<d> cjQ() {
        return this.iPY;
    }

    public a cjR() {
        return this.iQc;
    }

    public ArrayList<d> cjS() {
        return this.iPZ;
    }

    public ArrayList<d> cjT() {
        return this.iQa;
    }

    public boolean cjU() {
        return this.iPJ;
    }

    public String cjV() {
        return this.iPT;
    }

    public String getContent() {
        return this.content;
    }

    public int cjW() {
        return this.iPU;
    }

    public boolean cjX() {
        return this.iPV;
    }

    public int cjY() {
        return this.iPW;
    }

    public int cjZ() {
        return this.iPX;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.iQb.get(signData.forumId)) != null) {
            dVar.Ae(1);
            dVar.Af(signData.count_sign_num);
            dVar.Ah(signData.sign_bonus_point);
            dVar.qy(true);
            dVar.qz(false);
            dVar.qA(false);
            a(dVar);
            cka();
            qx(true);
        }
    }

    private void a(d dVar) {
        if (dVar.ckd() >= this.level) {
            this.iPM++;
            this.iPN--;
        } else {
            this.iPK++;
            this.iPL--;
        }
        this.iQb.remove(String.valueOf(dVar.getForumId()));
        this.iQa.remove(dVar);
        if (dVar.cke() + dVar.cki() >= dVar.ckf()) {
            dVar.Ag(dVar.ckd() + 1);
            dVar.qB(true);
            if (dVar.ckd() == this.level) {
                this.iPM++;
                this.iPK--;
            }
        }
        this.iPZ.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cki(), -1);
    }

    private void cka() {
        if (this.iPJ) {
            if (this.iPN + this.iPL <= 0) {
                this.iPV = true;
            } else {
                this.iPV = false;
            }
        } else if (this.iPN <= 0) {
            this.iPV = true;
        } else {
            this.iPV = false;
        }
    }

    public void a(h hVar) {
        this.iPW = 0;
        this.iPX = 0;
        ArrayList<i> cks = hVar.cks();
        int size = cks.size();
        for (int i = 0; i < size; i++) {
            i iVar = cks.get(i);
            d dVar = this.iQb.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.ckv() != 0) {
                    this.iPW++;
                    dVar.Ae(1);
                    dVar.Af(iVar.ckw());
                    dVar.Ah(iVar.getCurScore());
                    dVar.qy(true);
                    dVar.qz(false);
                    dVar.qA(false);
                    a(dVar);
                } else {
                    this.iPX++;
                    dVar.qy(false);
                    dVar.qz(true);
                    dVar.qA(false);
                    dVar.setErrorMsg(iVar.cjR().getUserMsg());
                }
            }
        }
        cka();
        qx(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.iQc.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.iPB = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.iPC = jSONObject.optString("text_pre");
            this.akz = jSONObject.optString("text_color");
            this.iPD = jSONObject.optString("text_mid");
            this.iPE = jSONObject.optString("text_suf");
            this.iPF = jSONObject.optString("num_notice");
            this.iPG = jSONObject.optInt("show_dialog");
            this.iPH = jSONObject.optString("sign_notice");
            this.iPI = jSONObject.optInt("valid", 0);
            this.iQd = jSONObject.optInt("sign_max_num", 50);
            this.iPS = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.iPT = jSONObject.optString("button_content");
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
            if (this.iPS == 1) {
                this.iPJ = true;
            } else {
                this.iPJ = false;
            }
            this.iPP = this.level + this.title;
            this.iPO = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.iRH = this.iQd;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.iRH);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.ckb() == 0) {
                            if (this.iPI == 0) {
                                if (this.iPJ) {
                                    dVar.qz(true);
                                } else if (dVar.ckd() > this.level) {
                                    dVar.qz(true);
                                }
                            }
                            if (dVar.ckd() >= this.level) {
                                this.iPN++;
                            } else {
                                this.iPL++;
                            }
                            this.iQa.add(dVar);
                            this.iQb.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.ckd() >= this.level) {
                                this.iPM++;
                            } else {
                                this.iPK++;
                            }
                            this.iPZ.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cki(), -1);
                        }
                        this.iPY.add(dVar);
                        Collections.sort(this.iPY, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.ckd() - dVar2.ckd();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.iQe == null) {
                this.iQe = new f();
            }
            this.iQe.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.iQf == null) {
                this.iQf = new k();
            }
            this.iQf.parserJson(optJSONObject3);
            qx(false);
        }
    }

    private void qx(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.iPY.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.iPY.removeAll(arrayList);
        }
        if (this.iPN + this.iPM > 0) {
            if (this.iPM > 0) {
                this.iPR = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iPM), Integer.valueOf(this.iPN));
            } else {
                this.iPR = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iPN + this.iPM));
            }
            if (this.iPY.size() > 0) {
                this.iPY.add(0, new b(this.iPP, this.iPR));
            }
        }
        if (this.iPL + this.iPK > 0) {
            if (this.iPK > 0) {
                this.iPQ = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iPK), Integer.valueOf(this.iPL));
            } else {
                this.iPQ = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iPL + this.iPK));
            }
            if (this.iPN + this.iPM > 0) {
                if (this.iPY.size() > this.iPN + this.iPM + 1) {
                    this.iPY.add(this.iPN + this.iPM + 1, new b(this.iPO, this.iPQ));
                }
            } else if (this.iPY.size() > 0) {
                this.iPY.add(0, new b(this.iPO, this.iPQ));
            }
        }
        if (this.iPY.size() <= 0) {
            this.iPU = 3;
        } else if (this.iPJ) {
            if (this.iPI == 1 && this.iQa.size() > 0) {
                this.iPU = 0;
            } else {
                this.iPU = 2;
            }
        } else if (this.iPI == 1 && this.iPN > 0) {
            this.iPU = 0;
        } else if (this.iPN + this.iPM > 0) {
            this.iPU = 2;
        } else if (this.iPN + this.iPM <= 0) {
            this.iPU = 3;
        }
    }
}
