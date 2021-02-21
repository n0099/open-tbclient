package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
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
    private String aGI;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int level;
    private int nnA;
    private boolean nnB;
    private int nnC;
    private int nnD;
    private int nnJ;
    private String nnj;
    private String nnk;
    private String nnl;
    private String nnm;
    private int nnn;
    private String nno;
    private boolean nnp;
    private int nnq;
    private int nnr;
    private int nns;
    private int nnt;
    private String nnu;
    private String nnv;
    private String nnw;
    private String nnx;
    private int nny;
    private String nnz;
    private String title;
    private int valid;
    private String nni = "0";
    private ArrayList<d> nnE = new ArrayList<>();
    private ArrayList<d> nnF = new ArrayList<>();
    private ArrayList<d> nnG = new ArrayList<>();
    private HashMap<String, d> nnH = new HashMap<>();
    private a nnI = new a();
    private f nnK = new f();
    private k nnL = new k();

    public boolean dKt() {
        return (this.nnK == null || StringUtils.isNull(this.nnK.noc)) ? false : true;
    }

    public String bEY() {
        return this.nnK.eLv;
    }

    public String dKu() {
        return this.nnK.noc;
    }

    public String dKv() {
        return this.nnL.npB;
    }

    public String dKw() {
        return this.nnL.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dKx() {
        return !StringUtils.isNull(this.nni) && this.nni.equals("1");
    }

    public String dKy() {
        return this.nnj;
    }

    public String Bs() {
        return this.aGI;
    }

    public String dKz() {
        return this.nnk;
    }

    public String dKA() {
        return this.nnl;
    }

    public String dKB() {
        return this.nnm;
    }

    public int dKC() {
        return this.nnn;
    }

    public String dKD() {
        return this.nno;
    }

    public ArrayList<d> dKE() {
        return this.nnE;
    }

    public a dKF() {
        return this.nnI;
    }

    public ArrayList<d> dKG() {
        return this.nnF;
    }

    public ArrayList<d> dKH() {
        return this.nnG;
    }

    public boolean dKI() {
        return this.nnp;
    }

    public String dKJ() {
        return this.nnz;
    }

    public String getContent() {
        return this.content;
    }

    public int dKK() {
        return this.nnA;
    }

    public boolean dKL() {
        return this.nnB;
    }

    public int dKM() {
        return this.nnC;
    }

    public int dKN() {
        return this.nnD;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.nnH.get(signData.forumId)) != null) {
            dVar.Jj(1);
            dVar.Jk(signData.count_sign_num);
            dVar.Jl(signData.sign_bonus_point);
            dVar.yc(true);
            dVar.yd(false);
            dVar.ye(false);
            a(dVar);
            dKO();
            yb(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bKC() >= this.level) {
            this.nns++;
            this.nnt--;
        } else {
            this.nnq++;
            this.nnr--;
        }
        this.nnH.remove(String.valueOf(dVar.getForumId()));
        this.nnG.remove(dVar);
        if (dVar.dKR() + dVar.dKV() >= dVar.dKS()) {
            dVar.setUserLevel(dVar.bKC() + 1);
            dVar.yf(true);
            if (dVar.bKC() == this.level) {
                this.nns++;
                this.nnq--;
            }
        }
        this.nnF.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dKV(), -1);
    }

    private void dKO() {
        if (this.nnp) {
            if (this.nnt + this.nnr <= 0) {
                this.nnB = true;
            } else {
                this.nnB = false;
            }
        } else if (this.nnt <= 0) {
            this.nnB = true;
        } else {
            this.nnB = false;
        }
    }

    public void a(h hVar) {
        this.nnC = 0;
        this.nnD = 0;
        ArrayList<i> dLf = hVar.dLf();
        int size = dLf.size();
        for (int i = 0; i < size; i++) {
            i iVar = dLf.get(i);
            d dVar = this.nnH.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dLi() != 0) {
                    this.nnC++;
                    dVar.Jj(1);
                    dVar.Jk(iVar.dLj());
                    dVar.Jl(iVar.getCurScore());
                    dVar.yc(true);
                    dVar.yd(false);
                    dVar.ye(false);
                    a(dVar);
                } else {
                    this.nnD++;
                    dVar.yc(false);
                    dVar.yd(true);
                    dVar.ye(false);
                    dVar.setErrorMsg(iVar.dKF().getUserMsg());
                }
            }
        }
        dKO();
        yb(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.nnI.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.nni = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.nnj = jSONObject.optString("text_pre");
            this.aGI = jSONObject.optString("text_color");
            this.nnk = jSONObject.optString("text_mid");
            this.nnl = jSONObject.optString("text_suf");
            this.nnm = jSONObject.optString("num_notice");
            this.nnn = jSONObject.optInt("show_dialog");
            this.nno = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.nnJ = jSONObject.optInt("sign_max_num", 50);
            this.nny = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.nnz = jSONObject.optString("button_content");
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
            if (this.nny == 1) {
                this.nnp = true;
            } else {
                this.nnp = false;
            }
            this.nnv = this.level + this.title;
            this.nnu = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.npr = this.nnJ;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.npr);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dKP() == 0) {
                            if (this.valid == 0) {
                                if (this.nnp) {
                                    dVar.yd(true);
                                } else if (dVar.bKC() > this.level) {
                                    dVar.yd(true);
                                }
                            }
                            if (dVar.bKC() >= this.level) {
                                this.nnt++;
                            } else {
                                this.nnr++;
                            }
                            this.nnG.add(dVar);
                            this.nnH.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bKC() >= this.level) {
                                this.nns++;
                            } else {
                                this.nnq++;
                            }
                            this.nnF.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dKV(), -1);
                        }
                        this.nnE.add(dVar);
                        Collections.sort(this.nnE, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bKC() - dVar2.bKC();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.nnK == null) {
                this.nnK = new f();
            }
            this.nnK.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.nnL == null) {
                this.nnL = new k();
            }
            this.nnL.parserJson(optJSONObject3);
            yb(false);
        }
    }

    private void yb(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.nnE.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.nnE.removeAll(arrayList);
        }
        if (this.nnt + this.nns > 0) {
            if (this.nns > 0) {
                this.nnx = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.nns), Integer.valueOf(this.nnt));
            } else {
                this.nnx = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.nnt + this.nns));
            }
            if (this.nnE.size() > 0) {
                this.nnE.add(0, new b(this.nnv, this.nnx));
            }
        }
        if (this.nnr + this.nnq > 0) {
            if (this.nnq > 0) {
                this.nnw = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.nnq), Integer.valueOf(this.nnr));
            } else {
                this.nnw = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.nnr + this.nnq));
            }
            if (this.nnt + this.nns > 0) {
                if (this.nnE.size() > this.nnt + this.nns + 1) {
                    this.nnE.add(this.nnt + this.nns + 1, new b(this.nnu, this.nnw));
                }
            } else if (this.nnE.size() > 0) {
                this.nnE.add(0, new b(this.nnu, this.nnw));
            }
        }
        if (this.nnE.size() <= 0) {
            this.nnA = 3;
        } else if (this.nnp) {
            if (this.valid == 1 && this.nnG.size() > 0) {
                this.nnA = 0;
            } else {
                this.nnA = 2;
            }
        } else if (this.valid == 1 && this.nnt > 0) {
            this.nnA = 0;
        } else if (this.nnt + this.nns > 0) {
            this.nnA = 2;
        } else if (this.nnt + this.nns <= 0) {
            this.nnA = 3;
        }
    }
}
