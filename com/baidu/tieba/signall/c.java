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
    private String iPA;
    private String iPB;
    private String iPC;
    private String iPD;
    private int iPE;
    private String iPF;
    private int iPG;
    private boolean iPH;
    private int iPI;
    private int iPJ;
    private int iPK;
    private int iPL;
    private String iPM;
    private String iPN;
    private String iPO;
    private String iPP;
    private int iPQ;
    private String iPR;
    private int iPS;
    private boolean iPT;
    private int iPU;
    private int iPV;
    private int iQb;
    private int level;
    private String title;
    private String iPz = "0";
    private ArrayList<d> iPW = new ArrayList<>();
    private ArrayList<d> iPX = new ArrayList<>();
    private ArrayList<d> iPY = new ArrayList<>();
    private HashMap<String, d> iPZ = new HashMap<>();
    private a iQa = new a();
    private f iQc = new f();
    private k iQd = new k();

    public boolean cjD() {
        return (this.iQc == null || StringUtils.isNull(this.iQc.iQv)) ? false : true;
    }

    public String auQ() {
        return this.iQc.bDU;
    }

    public String cjE() {
        return this.iQc.iQv;
    }

    public String cjF() {
        return this.iQd.iRP;
    }

    public String cjG() {
        return this.iQd.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cjH() {
        return !StringUtils.isNull(this.iPz) && this.iPz.equals("1");
    }

    public String cjI() {
        return this.iPA;
    }

    public String bWN() {
        return this.akz;
    }

    public String cjJ() {
        return this.iPB;
    }

    public String cjK() {
        return this.iPC;
    }

    public String cjL() {
        return this.iPD;
    }

    public int cjM() {
        return this.iPE;
    }

    public String cjN() {
        return this.iPF;
    }

    public ArrayList<d> cjO() {
        return this.iPW;
    }

    public a cjP() {
        return this.iQa;
    }

    public ArrayList<d> cjQ() {
        return this.iPX;
    }

    public ArrayList<d> cjR() {
        return this.iPY;
    }

    public boolean cjS() {
        return this.iPH;
    }

    public String cjT() {
        return this.iPR;
    }

    public String getContent() {
        return this.content;
    }

    public int cjU() {
        return this.iPS;
    }

    public boolean cjV() {
        return this.iPT;
    }

    public int cjW() {
        return this.iPU;
    }

    public int cjX() {
        return this.iPV;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.iPZ.get(signData.forumId)) != null) {
            dVar.Ae(1);
            dVar.Af(signData.count_sign_num);
            dVar.Ah(signData.sign_bonus_point);
            dVar.qy(true);
            dVar.qz(false);
            dVar.qA(false);
            a(dVar);
            cjY();
            qx(true);
        }
    }

    private void a(d dVar) {
        if (dVar.ckb() >= this.level) {
            this.iPK++;
            this.iPL--;
        } else {
            this.iPI++;
            this.iPJ--;
        }
        this.iPZ.remove(String.valueOf(dVar.getForumId()));
        this.iPY.remove(dVar);
        if (dVar.ckc() + dVar.ckg() >= dVar.ckd()) {
            dVar.Ag(dVar.ckb() + 1);
            dVar.qB(true);
            if (dVar.ckb() == this.level) {
                this.iPK++;
                this.iPI--;
            }
        }
        this.iPX.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.ckg(), -1);
    }

    private void cjY() {
        if (this.iPH) {
            if (this.iPL + this.iPJ <= 0) {
                this.iPT = true;
            } else {
                this.iPT = false;
            }
        } else if (this.iPL <= 0) {
            this.iPT = true;
        } else {
            this.iPT = false;
        }
    }

    public void a(h hVar) {
        this.iPU = 0;
        this.iPV = 0;
        ArrayList<i> ckq = hVar.ckq();
        int size = ckq.size();
        for (int i = 0; i < size; i++) {
            i iVar = ckq.get(i);
            d dVar = this.iPZ.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.ckt() != 0) {
                    this.iPU++;
                    dVar.Ae(1);
                    dVar.Af(iVar.cku());
                    dVar.Ah(iVar.getCurScore());
                    dVar.qy(true);
                    dVar.qz(false);
                    dVar.qA(false);
                    a(dVar);
                } else {
                    this.iPV++;
                    dVar.qy(false);
                    dVar.qz(true);
                    dVar.qA(false);
                    dVar.setErrorMsg(iVar.cjP().getUserMsg());
                }
            }
        }
        cjY();
        qx(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.iQa.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.iPz = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.iPA = jSONObject.optString("text_pre");
            this.akz = jSONObject.optString("text_color");
            this.iPB = jSONObject.optString("text_mid");
            this.iPC = jSONObject.optString("text_suf");
            this.iPD = jSONObject.optString("num_notice");
            this.iPE = jSONObject.optInt("show_dialog");
            this.iPF = jSONObject.optString("sign_notice");
            this.iPG = jSONObject.optInt("valid", 0);
            this.iQb = jSONObject.optInt("sign_max_num", 50);
            this.iPQ = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.iPR = jSONObject.optString("button_content");
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
            if (this.iPQ == 1) {
                this.iPH = true;
            } else {
                this.iPH = false;
            }
            this.iPN = this.level + this.title;
            this.iPM = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.iRF = this.iQb;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.iRF);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cjZ() == 0) {
                            if (this.iPG == 0) {
                                if (this.iPH) {
                                    dVar.qz(true);
                                } else if (dVar.ckb() > this.level) {
                                    dVar.qz(true);
                                }
                            }
                            if (dVar.ckb() >= this.level) {
                                this.iPL++;
                            } else {
                                this.iPJ++;
                            }
                            this.iPY.add(dVar);
                            this.iPZ.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.ckb() >= this.level) {
                                this.iPK++;
                            } else {
                                this.iPI++;
                            }
                            this.iPX.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.ckg(), -1);
                        }
                        this.iPW.add(dVar);
                        Collections.sort(this.iPW, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.ckb() - dVar2.ckb();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.iQc == null) {
                this.iQc = new f();
            }
            this.iQc.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.iQd == null) {
                this.iQd = new k();
            }
            this.iQd.parserJson(optJSONObject3);
            qx(false);
        }
    }

    private void qx(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.iPW.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.iPW.removeAll(arrayList);
        }
        if (this.iPL + this.iPK > 0) {
            if (this.iPK > 0) {
                this.iPP = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iPK), Integer.valueOf(this.iPL));
            } else {
                this.iPP = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iPL + this.iPK));
            }
            if (this.iPW.size() > 0) {
                this.iPW.add(0, new b(this.iPN, this.iPP));
            }
        }
        if (this.iPJ + this.iPI > 0) {
            if (this.iPI > 0) {
                this.iPO = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iPI), Integer.valueOf(this.iPJ));
            } else {
                this.iPO = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iPJ + this.iPI));
            }
            if (this.iPL + this.iPK > 0) {
                if (this.iPW.size() > this.iPL + this.iPK + 1) {
                    this.iPW.add(this.iPL + this.iPK + 1, new b(this.iPM, this.iPO));
                }
            } else if (this.iPW.size() > 0) {
                this.iPW.add(0, new b(this.iPM, this.iPO));
            }
        }
        if (this.iPW.size() <= 0) {
            this.iPS = 3;
        } else if (this.iPH) {
            if (this.iPG == 1 && this.iPY.size() > 0) {
                this.iPS = 0;
            } else {
                this.iPS = 2;
            }
        } else if (this.iPG == 1 && this.iPL > 0) {
            this.iPS = 0;
        } else if (this.iPL + this.iPK > 0) {
            this.iPS = 2;
        } else if (this.iPL + this.iPK <= 0) {
            this.iPS = 3;
        }
    }
}
