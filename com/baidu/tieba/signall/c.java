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
    private String nmJ;
    private String nmK;
    private String nmL;
    private String nmM;
    private int nmN;
    private String nmO;
    private boolean nmP;
    private int nmQ;
    private int nmR;
    private int nmS;
    private int nmT;
    private String nmU;
    private String nmV;
    private String nmW;
    private String nmX;
    private int nmY;
    private String nmZ;
    private int nna;
    private boolean nnb;
    private int nnc;
    private int nnd;
    private int nnj;
    private String title;
    private int valid;
    private String nmI = "0";
    private ArrayList<d> nne = new ArrayList<>();
    private ArrayList<d> nnf = new ArrayList<>();
    private ArrayList<d> nng = new ArrayList<>();
    private HashMap<String, d> nnh = new HashMap<>();
    private a nni = new a();
    private f nnk = new f();
    private k nnl = new k();

    public boolean dKl() {
        return (this.nnk == null || StringUtils.isNull(this.nnk.nnC)) ? false : true;
    }

    public String bEY() {
        return this.nnk.eLw;
    }

    public String dKm() {
        return this.nnk.nnC;
    }

    public String dKn() {
        return this.nnl.npb;
    }

    public String dKo() {
        return this.nnl.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dKp() {
        return !StringUtils.isNull(this.nmI) && this.nmI.equals("1");
    }

    public String dKq() {
        return this.nmJ;
    }

    public String Bs() {
        return this.aGI;
    }

    public String dKr() {
        return this.nmK;
    }

    public String dKs() {
        return this.nmL;
    }

    public String dKt() {
        return this.nmM;
    }

    public int dKu() {
        return this.nmN;
    }

    public String dKv() {
        return this.nmO;
    }

    public ArrayList<d> dKw() {
        return this.nne;
    }

    public a dKx() {
        return this.nni;
    }

    public ArrayList<d> dKy() {
        return this.nnf;
    }

    public ArrayList<d> dKz() {
        return this.nng;
    }

    public boolean dKA() {
        return this.nmP;
    }

    public String dKB() {
        return this.nmZ;
    }

    public String getContent() {
        return this.content;
    }

    public int dKC() {
        return this.nna;
    }

    public boolean dKD() {
        return this.nnb;
    }

    public int dKE() {
        return this.nnc;
    }

    public int dKF() {
        return this.nnd;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.nnh.get(signData.forumId)) != null) {
            dVar.Jj(1);
            dVar.Jk(signData.count_sign_num);
            dVar.Jl(signData.sign_bonus_point);
            dVar.yc(true);
            dVar.yd(false);
            dVar.ye(false);
            a(dVar);
            dKG();
            yb(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bKx() >= this.level) {
            this.nmS++;
            this.nmT--;
        } else {
            this.nmQ++;
            this.nmR--;
        }
        this.nnh.remove(String.valueOf(dVar.getForumId()));
        this.nng.remove(dVar);
        if (dVar.dKJ() + dVar.dKN() >= dVar.dKK()) {
            dVar.setUserLevel(dVar.bKx() + 1);
            dVar.yf(true);
            if (dVar.bKx() == this.level) {
                this.nmS++;
                this.nmQ--;
            }
        }
        this.nnf.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dKN(), -1);
    }

    private void dKG() {
        if (this.nmP) {
            if (this.nmT + this.nmR <= 0) {
                this.nnb = true;
            } else {
                this.nnb = false;
            }
        } else if (this.nmT <= 0) {
            this.nnb = true;
        } else {
            this.nnb = false;
        }
    }

    public void a(h hVar) {
        this.nnc = 0;
        this.nnd = 0;
        ArrayList<i> dKX = hVar.dKX();
        int size = dKX.size();
        for (int i = 0; i < size; i++) {
            i iVar = dKX.get(i);
            d dVar = this.nnh.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dLa() != 0) {
                    this.nnc++;
                    dVar.Jj(1);
                    dVar.Jk(iVar.dLb());
                    dVar.Jl(iVar.getCurScore());
                    dVar.yc(true);
                    dVar.yd(false);
                    dVar.ye(false);
                    a(dVar);
                } else {
                    this.nnd++;
                    dVar.yc(false);
                    dVar.yd(true);
                    dVar.ye(false);
                    dVar.setErrorMsg(iVar.dKx().getUserMsg());
                }
            }
        }
        dKG();
        yb(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.nni.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.nmI = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.nmJ = jSONObject.optString("text_pre");
            this.aGI = jSONObject.optString("text_color");
            this.nmK = jSONObject.optString("text_mid");
            this.nmL = jSONObject.optString("text_suf");
            this.nmM = jSONObject.optString("num_notice");
            this.nmN = jSONObject.optInt("show_dialog");
            this.nmO = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.nnj = jSONObject.optInt("sign_max_num", 50);
            this.nmY = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.nmZ = jSONObject.optString("button_content");
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
            if (this.nmY == 1) {
                this.nmP = true;
            } else {
                this.nmP = false;
            }
            this.nmV = this.level + this.title;
            this.nmU = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.noR = this.nnj;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.noR);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dKH() == 0) {
                            if (this.valid == 0) {
                                if (this.nmP) {
                                    dVar.yd(true);
                                } else if (dVar.bKx() > this.level) {
                                    dVar.yd(true);
                                }
                            }
                            if (dVar.bKx() >= this.level) {
                                this.nmT++;
                            } else {
                                this.nmR++;
                            }
                            this.nng.add(dVar);
                            this.nnh.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bKx() >= this.level) {
                                this.nmS++;
                            } else {
                                this.nmQ++;
                            }
                            this.nnf.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dKN(), -1);
                        }
                        this.nne.add(dVar);
                        Collections.sort(this.nne, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bKx() - dVar2.bKx();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.nnk == null) {
                this.nnk = new f();
            }
            this.nnk.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.nnl == null) {
                this.nnl = new k();
            }
            this.nnl.parserJson(optJSONObject3);
            yb(false);
        }
    }

    private void yb(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.nne.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.nne.removeAll(arrayList);
        }
        if (this.nmT + this.nmS > 0) {
            if (this.nmS > 0) {
                this.nmX = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.nmS), Integer.valueOf(this.nmT));
            } else {
                this.nmX = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.nmT + this.nmS));
            }
            if (this.nne.size() > 0) {
                this.nne.add(0, new b(this.nmV, this.nmX));
            }
        }
        if (this.nmR + this.nmQ > 0) {
            if (this.nmQ > 0) {
                this.nmW = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.nmQ), Integer.valueOf(this.nmR));
            } else {
                this.nmW = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.nmR + this.nmQ));
            }
            if (this.nmT + this.nmS > 0) {
                if (this.nne.size() > this.nmT + this.nmS + 1) {
                    this.nne.add(this.nmT + this.nmS + 1, new b(this.nmU, this.nmW));
                }
            } else if (this.nne.size() > 0) {
                this.nne.add(0, new b(this.nmU, this.nmW));
            }
        }
        if (this.nne.size() <= 0) {
            this.nna = 3;
        } else if (this.nmP) {
            if (this.valid == 1 && this.nng.size() > 0) {
                this.nna = 0;
            } else {
                this.nna = 2;
            }
        } else if (this.valid == 1 && this.nmT > 0) {
            this.nna = 0;
        } else if (this.nmT + this.nmS > 0) {
            this.nna = 2;
        } else if (this.nmT + this.nmS <= 0) {
            this.nna = 3;
        }
    }
}
