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
    private String iPG;
    private String iPH;
    private String iPI;
    private String iPJ;
    private int iPK;
    private String iPL;
    private int iPM;
    private boolean iPN;
    private int iPO;
    private int iPP;
    private int iPQ;
    private int iPR;
    private String iPS;
    private String iPT;
    private String iPU;
    private String iPV;
    private int iPW;
    private String iPX;
    private int iPY;
    private boolean iPZ;
    private int iQa;
    private int iQb;
    private int iQh;
    private int level;
    private String title;
    private String iPF = "0";
    private ArrayList<d> iQc = new ArrayList<>();
    private ArrayList<d> iQd = new ArrayList<>();
    private ArrayList<d> iQe = new ArrayList<>();
    private HashMap<String, d> iQf = new HashMap<>();
    private a iQg = new a();
    private f iQi = new f();
    private k iQj = new k();

    public boolean cjG() {
        return (this.iQi == null || StringUtils.isNull(this.iQi.iQB)) ? false : true;
    }

    public String auQ() {
        return this.iQi.bDV;
    }

    public String cjH() {
        return this.iQi.iQB;
    }

    public String cjI() {
        return this.iQj.iRV;
    }

    public String cjJ() {
        return this.iQj.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cjK() {
        return !StringUtils.isNull(this.iPF) && this.iPF.equals("1");
    }

    public String cjL() {
        return this.iPG;
    }

    public String bWR() {
        return this.akz;
    }

    public String cjM() {
        return this.iPH;
    }

    public String cjN() {
        return this.iPI;
    }

    public String cjO() {
        return this.iPJ;
    }

    public int cjP() {
        return this.iPK;
    }

    public String cjQ() {
        return this.iPL;
    }

    public ArrayList<d> cjR() {
        return this.iQc;
    }

    public a cjS() {
        return this.iQg;
    }

    public ArrayList<d> cjT() {
        return this.iQd;
    }

    public ArrayList<d> cjU() {
        return this.iQe;
    }

    public boolean cjV() {
        return this.iPN;
    }

    public String cjW() {
        return this.iPX;
    }

    public String getContent() {
        return this.content;
    }

    public int cjX() {
        return this.iPY;
    }

    public boolean cjY() {
        return this.iPZ;
    }

    public int cjZ() {
        return this.iQa;
    }

    public int cka() {
        return this.iQb;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.iQf.get(signData.forumId)) != null) {
            dVar.Ae(1);
            dVar.Af(signData.count_sign_num);
            dVar.Ah(signData.sign_bonus_point);
            dVar.qz(true);
            dVar.qA(false);
            dVar.qB(false);
            a(dVar);
            ckb();
            qy(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cke() >= this.level) {
            this.iPQ++;
            this.iPR--;
        } else {
            this.iPO++;
            this.iPP--;
        }
        this.iQf.remove(String.valueOf(dVar.getForumId()));
        this.iQe.remove(dVar);
        if (dVar.ckf() + dVar.ckj() >= dVar.ckg()) {
            dVar.Ag(dVar.cke() + 1);
            dVar.qC(true);
            if (dVar.cke() == this.level) {
                this.iPQ++;
                this.iPO--;
            }
        }
        this.iQd.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.ckj(), -1);
    }

    private void ckb() {
        if (this.iPN) {
            if (this.iPR + this.iPP <= 0) {
                this.iPZ = true;
            } else {
                this.iPZ = false;
            }
        } else if (this.iPR <= 0) {
            this.iPZ = true;
        } else {
            this.iPZ = false;
        }
    }

    public void a(h hVar) {
        this.iQa = 0;
        this.iQb = 0;
        ArrayList<i> ckt = hVar.ckt();
        int size = ckt.size();
        for (int i = 0; i < size; i++) {
            i iVar = ckt.get(i);
            d dVar = this.iQf.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.ckw() != 0) {
                    this.iQa++;
                    dVar.Ae(1);
                    dVar.Af(iVar.ckx());
                    dVar.Ah(iVar.getCurScore());
                    dVar.qz(true);
                    dVar.qA(false);
                    dVar.qB(false);
                    a(dVar);
                } else {
                    this.iQb++;
                    dVar.qz(false);
                    dVar.qA(true);
                    dVar.qB(false);
                    dVar.setErrorMsg(iVar.cjS().getUserMsg());
                }
            }
        }
        ckb();
        qy(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.iQg.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.iPF = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.iPG = jSONObject.optString("text_pre");
            this.akz = jSONObject.optString("text_color");
            this.iPH = jSONObject.optString("text_mid");
            this.iPI = jSONObject.optString("text_suf");
            this.iPJ = jSONObject.optString("num_notice");
            this.iPK = jSONObject.optInt("show_dialog");
            this.iPL = jSONObject.optString("sign_notice");
            this.iPM = jSONObject.optInt("valid", 0);
            this.iQh = jSONObject.optInt("sign_max_num", 50);
            this.iPW = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.iPX = jSONObject.optString("button_content");
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
            if (this.iPW == 1) {
                this.iPN = true;
            } else {
                this.iPN = false;
            }
            this.iPT = this.level + this.title;
            this.iPS = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.iRL = this.iQh;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.iRL);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.ckc() == 0) {
                            if (this.iPM == 0) {
                                if (this.iPN) {
                                    dVar.qA(true);
                                } else if (dVar.cke() > this.level) {
                                    dVar.qA(true);
                                }
                            }
                            if (dVar.cke() >= this.level) {
                                this.iPR++;
                            } else {
                                this.iPP++;
                            }
                            this.iQe.add(dVar);
                            this.iQf.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cke() >= this.level) {
                                this.iPQ++;
                            } else {
                                this.iPO++;
                            }
                            this.iQd.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.ckj(), -1);
                        }
                        this.iQc.add(dVar);
                        Collections.sort(this.iQc, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cke() - dVar2.cke();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.iQi == null) {
                this.iQi = new f();
            }
            this.iQi.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.iQj == null) {
                this.iQj = new k();
            }
            this.iQj.parserJson(optJSONObject3);
            qy(false);
        }
    }

    private void qy(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.iQc.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.iQc.removeAll(arrayList);
        }
        if (this.iPR + this.iPQ > 0) {
            if (this.iPQ > 0) {
                this.iPV = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iPQ), Integer.valueOf(this.iPR));
            } else {
                this.iPV = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iPR + this.iPQ));
            }
            if (this.iQc.size() > 0) {
                this.iQc.add(0, new b(this.iPT, this.iPV));
            }
        }
        if (this.iPP + this.iPO > 0) {
            if (this.iPO > 0) {
                this.iPU = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iPO), Integer.valueOf(this.iPP));
            } else {
                this.iPU = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iPP + this.iPO));
            }
            if (this.iPR + this.iPQ > 0) {
                if (this.iQc.size() > this.iPR + this.iPQ + 1) {
                    this.iQc.add(this.iPR + this.iPQ + 1, new b(this.iPS, this.iPU));
                }
            } else if (this.iQc.size() > 0) {
                this.iQc.add(0, new b(this.iPS, this.iPU));
            }
        }
        if (this.iQc.size() <= 0) {
            this.iPY = 3;
        } else if (this.iPN) {
            if (this.iPM == 1 && this.iQe.size() > 0) {
                this.iPY = 0;
            } else {
                this.iPY = 2;
            }
        } else if (this.iPM == 1 && this.iPR > 0) {
            this.iPY = 0;
        } else if (this.iPR + this.iPQ > 0) {
            this.iPY = 2;
        } else if (this.iPR + this.iPQ <= 0) {
            this.iPY = 3;
        }
    }
}
