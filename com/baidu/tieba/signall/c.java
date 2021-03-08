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
/* loaded from: classes7.dex */
public class c {
    private String aIi;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int level;
    private String npA;
    private String npB;
    private String npC;
    private String npD;
    private int npE;
    private String npF;
    private int npG;
    private boolean npH;
    private int npI;
    private int npJ;
    private int npP;
    private String npp;
    private String npq;
    private String npr;
    private String nps;
    private int npt;
    private String npu;
    private boolean npv;
    private int npw;
    private int npx;
    private int npy;
    private int npz;
    private String title;
    private int valid;
    private String npo = "0";
    private ArrayList<d> npK = new ArrayList<>();
    private ArrayList<d> npL = new ArrayList<>();
    private ArrayList<d> npM = new ArrayList<>();
    private HashMap<String, d> npN = new HashMap<>();
    private a npO = new a();
    private f npQ = new f();
    private k npR = new k();

    public boolean dKB() {
        return (this.npQ == null || StringUtils.isNull(this.npQ.nqi)) ? false : true;
    }

    public String bFc() {
        return this.npQ.eMW;
    }

    public String dKC() {
        return this.npQ.nqi;
    }

    public String dKD() {
        return this.npR.nrF;
    }

    public String dKE() {
        return this.npR.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dKF() {
        return !StringUtils.isNull(this.npo) && this.npo.equals("1");
    }

    public String dKG() {
        return this.npp;
    }

    public String Bv() {
        return this.aIi;
    }

    public String dKH() {
        return this.npq;
    }

    public String dKI() {
        return this.npr;
    }

    public String dKJ() {
        return this.nps;
    }

    public int dKK() {
        return this.npt;
    }

    public String dKL() {
        return this.npu;
    }

    public ArrayList<d> dKM() {
        return this.npK;
    }

    public a dKN() {
        return this.npO;
    }

    public ArrayList<d> dKO() {
        return this.npL;
    }

    public ArrayList<d> dKP() {
        return this.npM;
    }

    public boolean dKQ() {
        return this.npv;
    }

    public String dKR() {
        return this.npF;
    }

    public String getContent() {
        return this.content;
    }

    public int dKS() {
        return this.npG;
    }

    public boolean dKT() {
        return this.npH;
    }

    public int dKU() {
        return this.npI;
    }

    public int dKV() {
        return this.npJ;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.npN.get(signData.forumId)) != null) {
            dVar.Jn(1);
            dVar.Jo(signData.count_sign_num);
            dVar.Jp(signData.sign_bonus_point);
            dVar.yc(true);
            dVar.yd(false);
            dVar.ye(false);
            a(dVar);
            dKW();
            yb(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bKG() >= this.level) {
            this.npy++;
            this.npz--;
        } else {
            this.npw++;
            this.npx--;
        }
        this.npN.remove(String.valueOf(dVar.getForumId()));
        this.npM.remove(dVar);
        if (dVar.dKZ() + dVar.dLd() >= dVar.dLa()) {
            dVar.setUserLevel(dVar.bKG() + 1);
            dVar.yf(true);
            if (dVar.bKG() == this.level) {
                this.npy++;
                this.npw--;
            }
        }
        this.npL.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dLd(), -1);
    }

    private void dKW() {
        if (this.npv) {
            if (this.npz + this.npx <= 0) {
                this.npH = true;
            } else {
                this.npH = false;
            }
        } else if (this.npz <= 0) {
            this.npH = true;
        } else {
            this.npH = false;
        }
    }

    public void a(h hVar) {
        this.npI = 0;
        this.npJ = 0;
        ArrayList<i> dLn = hVar.dLn();
        int size = dLn.size();
        for (int i = 0; i < size; i++) {
            i iVar = dLn.get(i);
            d dVar = this.npN.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dLq() != 0) {
                    this.npI++;
                    dVar.Jn(1);
                    dVar.Jo(iVar.dLr());
                    dVar.Jp(iVar.getCurScore());
                    dVar.yc(true);
                    dVar.yd(false);
                    dVar.ye(false);
                    a(dVar);
                } else {
                    this.npJ++;
                    dVar.yc(false);
                    dVar.yd(true);
                    dVar.ye(false);
                    dVar.setErrorMsg(iVar.dKN().getUserMsg());
                }
            }
        }
        dKW();
        yb(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.npO.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.npo = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.npp = jSONObject.optString("text_pre");
            this.aIi = jSONObject.optString("text_color");
            this.npq = jSONObject.optString("text_mid");
            this.npr = jSONObject.optString("text_suf");
            this.nps = jSONObject.optString("num_notice");
            this.npt = jSONObject.optInt("show_dialog");
            this.npu = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.npP = jSONObject.optInt("sign_max_num", 50);
            this.npE = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.npF = jSONObject.optString("button_content");
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
            if (this.npE == 1) {
                this.npv = true;
            } else {
                this.npv = false;
            }
            this.npB = this.level + this.title;
            this.npA = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.nrv = this.npP;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.nrv);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dKX() == 0) {
                            if (this.valid == 0) {
                                if (this.npv) {
                                    dVar.yd(true);
                                } else if (dVar.bKG() > this.level) {
                                    dVar.yd(true);
                                }
                            }
                            if (dVar.bKG() >= this.level) {
                                this.npz++;
                            } else {
                                this.npx++;
                            }
                            this.npM.add(dVar);
                            this.npN.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bKG() >= this.level) {
                                this.npy++;
                            } else {
                                this.npw++;
                            }
                            this.npL.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dLd(), -1);
                        }
                        this.npK.add(dVar);
                        Collections.sort(this.npK, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bKG() - dVar2.bKG();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.npQ == null) {
                this.npQ = new f();
            }
            this.npQ.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.npR == null) {
                this.npR = new k();
            }
            this.npR.parserJson(optJSONObject3);
            yb(false);
        }
    }

    private void yb(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.npK.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.npK.removeAll(arrayList);
        }
        if (this.npz + this.npy > 0) {
            if (this.npy > 0) {
                this.npD = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.npy), Integer.valueOf(this.npz));
            } else {
                this.npD = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.npz + this.npy));
            }
            if (this.npK.size() > 0) {
                this.npK.add(0, new b(this.npB, this.npD));
            }
        }
        if (this.npx + this.npw > 0) {
            if (this.npw > 0) {
                this.npC = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.npw), Integer.valueOf(this.npx));
            } else {
                this.npC = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.npx + this.npw));
            }
            if (this.npz + this.npy > 0) {
                if (this.npK.size() > this.npz + this.npy + 1) {
                    this.npK.add(this.npz + this.npy + 1, new b(this.npA, this.npC));
                }
            } else if (this.npK.size() > 0) {
                this.npK.add(0, new b(this.npA, this.npC));
            }
        }
        if (this.npK.size() <= 0) {
            this.npG = 3;
        } else if (this.npv) {
            if (this.valid == 1 && this.npM.size() > 0) {
                this.npG = 0;
            } else {
                this.npG = 2;
            }
        } else if (this.valid == 1 && this.npz > 0) {
            this.npG = 0;
        } else if (this.npz + this.npy > 0) {
            this.npG = 2;
        } else if (this.npz + this.npy <= 0) {
            this.npG = 3;
        }
    }
}
