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
/* loaded from: classes8.dex */
public class c {
    private String aaq;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String jST;
    private String jSU;
    private String jSV;
    private String jSW;
    private int jSX;
    private String jSY;
    private boolean jSZ;
    private int jTa;
    private int jTb;
    private int jTc;
    private int jTd;
    private String jTe;
    private String jTf;
    private String jTg;
    private String jTh;
    private int jTi;
    private String jTj;
    private int jTk;
    private boolean jTl;
    private int jTm;
    private int jTn;
    private int jTt;
    private int level;
    private String title;
    private int valid;
    private String jSS = "0";
    private ArrayList<d> jTo = new ArrayList<>();
    private ArrayList<d> jTp = new ArrayList<>();
    private ArrayList<d> jTq = new ArrayList<>();
    private HashMap<String, d> jTr = new HashMap<>();
    private a jTs = new a();
    private f jTu = new f();
    private k jTv = new k();

    public boolean cFA() {
        return (this.jTu == null || StringUtils.isNull(this.jTu.jTO)) ? false : true;
    }

    public String aPd() {
        return this.jTu.cII;
    }

    public String cFB() {
        return this.jTu.jTO;
    }

    public String cFC() {
        return this.jTv.jVi;
    }

    public String cFD() {
        return this.jTv.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cFE() {
        return !StringUtils.isNull(this.jSS) && this.jSS.equals("1");
    }

    public String cFF() {
        return this.jST;
    }

    public String cpI() {
        return this.aaq;
    }

    public String cFG() {
        return this.jSU;
    }

    public String cFH() {
        return this.jSV;
    }

    public String cFI() {
        return this.jSW;
    }

    public int cFJ() {
        return this.jSX;
    }

    public String cFK() {
        return this.jSY;
    }

    public ArrayList<d> cFL() {
        return this.jTo;
    }

    public a cFM() {
        return this.jTs;
    }

    public ArrayList<d> cFN() {
        return this.jTp;
    }

    public ArrayList<d> cFO() {
        return this.jTq;
    }

    public boolean cFP() {
        return this.jSZ;
    }

    public String cFQ() {
        return this.jTj;
    }

    public String getContent() {
        return this.content;
    }

    public int cFR() {
        return this.jTk;
    }

    public boolean cFS() {
        return this.jTl;
    }

    public int cFT() {
        return this.jTm;
    }

    public int cFU() {
        return this.jTn;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.jTr.get(signData.forumId)) != null) {
            dVar.BS(1);
            dVar.BT(signData.count_sign_num);
            dVar.BV(signData.sign_bonus_point);
            dVar.sj(true);
            dVar.sk(false);
            dVar.sl(false);
            a(dVar);
            cFV();
            si(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cFY() >= this.level) {
            this.jTc++;
            this.jTd--;
        } else {
            this.jTa++;
            this.jTb--;
        }
        this.jTr.remove(String.valueOf(dVar.getForumId()));
        this.jTq.remove(dVar);
        if (dVar.cFZ() + dVar.cGd() >= dVar.cGa()) {
            dVar.BU(dVar.cFY() + 1);
            dVar.sm(true);
            if (dVar.cFY() == this.level) {
                this.jTc++;
                this.jTa--;
            }
        }
        this.jTp.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cGd(), -1);
    }

    private void cFV() {
        if (this.jSZ) {
            if (this.jTd + this.jTb <= 0) {
                this.jTl = true;
            } else {
                this.jTl = false;
            }
        } else if (this.jTd <= 0) {
            this.jTl = true;
        } else {
            this.jTl = false;
        }
    }

    public void a(h hVar) {
        this.jTm = 0;
        this.jTn = 0;
        ArrayList<i> cGn = hVar.cGn();
        int size = cGn.size();
        for (int i = 0; i < size; i++) {
            i iVar = cGn.get(i);
            d dVar = this.jTr.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cGq() != 0) {
                    this.jTm++;
                    dVar.BS(1);
                    dVar.BT(iVar.cGr());
                    dVar.BV(iVar.getCurScore());
                    dVar.sj(true);
                    dVar.sk(false);
                    dVar.sl(false);
                    a(dVar);
                } else {
                    this.jTn++;
                    dVar.sj(false);
                    dVar.sk(true);
                    dVar.sl(false);
                    dVar.setErrorMsg(iVar.cFM().getUserMsg());
                }
            }
        }
        cFV();
        si(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.jTs.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.jSS = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.jST = jSONObject.optString("text_pre");
            this.aaq = jSONObject.optString("text_color");
            this.jSU = jSONObject.optString("text_mid");
            this.jSV = jSONObject.optString("text_suf");
            this.jSW = jSONObject.optString("num_notice");
            this.jSX = jSONObject.optInt("show_dialog");
            this.jSY = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(UpdateConstants.VALID_KEY, 0);
            this.jTt = jSONObject.optInt("sign_max_num", 50);
            this.jTi = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.jTj = jSONObject.optString("button_content");
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
            if (this.jTi == 1) {
                this.jSZ = true;
            } else {
                this.jSZ = false;
            }
            this.jTf = this.level + this.title;
            this.jTe = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.jUY = this.jTt;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.jUY);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cFW() == 0) {
                            if (this.valid == 0) {
                                if (this.jSZ) {
                                    dVar.sk(true);
                                } else if (dVar.cFY() > this.level) {
                                    dVar.sk(true);
                                }
                            }
                            if (dVar.cFY() >= this.level) {
                                this.jTd++;
                            } else {
                                this.jTb++;
                            }
                            this.jTq.add(dVar);
                            this.jTr.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cFY() >= this.level) {
                                this.jTc++;
                            } else {
                                this.jTa++;
                            }
                            this.jTp.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cGd(), -1);
                        }
                        this.jTo.add(dVar);
                        Collections.sort(this.jTo, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cFY() - dVar2.cFY();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.jTu == null) {
                this.jTu = new f();
            }
            this.jTu.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.jTv == null) {
                this.jTv = new k();
            }
            this.jTv.parserJson(optJSONObject3);
            si(false);
        }
    }

    private void si(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.jTo.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.jTo.removeAll(arrayList);
        }
        if (this.jTd + this.jTc > 0) {
            if (this.jTc > 0) {
                this.jTh = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jTc), Integer.valueOf(this.jTd));
            } else {
                this.jTh = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jTd + this.jTc));
            }
            if (this.jTo.size() > 0) {
                this.jTo.add(0, new b(this.jTf, this.jTh));
            }
        }
        if (this.jTb + this.jTa > 0) {
            if (this.jTa > 0) {
                this.jTg = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jTa), Integer.valueOf(this.jTb));
            } else {
                this.jTg = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jTb + this.jTa));
            }
            if (this.jTd + this.jTc > 0) {
                if (this.jTo.size() > this.jTd + this.jTc + 1) {
                    this.jTo.add(this.jTd + this.jTc + 1, new b(this.jTe, this.jTg));
                }
            } else if (this.jTo.size() > 0) {
                this.jTo.add(0, new b(this.jTe, this.jTg));
            }
        }
        if (this.jTo.size() <= 0) {
            this.jTk = 3;
        } else if (this.jSZ) {
            if (this.valid == 1 && this.jTq.size() > 0) {
                this.jTk = 0;
            } else {
                this.jTk = 2;
            }
        } else if (this.valid == 1 && this.jTd > 0) {
            this.jTk = 0;
        } else if (this.jTd + this.jTc > 0) {
            this.jTk = 2;
        } else if (this.jTd + this.jTc <= 0) {
            this.jTk = 3;
        }
    }
}
