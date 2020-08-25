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
/* loaded from: classes18.dex */
public class c {
    private String aJg;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int lVA;
    private String lVa;
    private String lVb;
    private String lVc;
    private String lVd;
    private int lVe;
    private String lVf;
    private boolean lVg;
    private int lVh;
    private int lVi;
    private int lVj;
    private int lVk;
    private String lVl;
    private String lVm;
    private String lVn;
    private String lVo;
    private int lVp;
    private String lVq;
    private int lVr;
    private boolean lVs;
    private int lVt;
    private int lVu;
    private int level;
    private String title;
    private int valid;
    private String lUZ = "0";
    private ArrayList<d> lVv = new ArrayList<>();
    private ArrayList<d> lVw = new ArrayList<>();
    private ArrayList<d> lVx = new ArrayList<>();
    private HashMap<String, d> lVy = new HashMap<>();
    private a lVz = new a();
    private f lVB = new f();
    private k lVC = new k();

    public boolean dtx() {
        return (this.lVB == null || StringUtils.isNull(this.lVB.lVU)) ? false : true;
    }

    public String bva() {
        return this.lVB.dWh;
    }

    public String dty() {
        return this.lVB.lVU;
    }

    public String dtz() {
        return this.lVC.lXs;
    }

    public String dtA() {
        return this.lVC.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dtB() {
        return !StringUtils.isNull(this.lUZ) && this.lUZ.equals("1");
    }

    public String dtC() {
        return this.lVa;
    }

    public String ddu() {
        return this.aJg;
    }

    public String dtD() {
        return this.lVb;
    }

    public String dtE() {
        return this.lVc;
    }

    public String dtF() {
        return this.lVd;
    }

    public int dtG() {
        return this.lVe;
    }

    public String dtH() {
        return this.lVf;
    }

    public ArrayList<d> dtI() {
        return this.lVv;
    }

    public a dtJ() {
        return this.lVz;
    }

    public ArrayList<d> dtK() {
        return this.lVw;
    }

    public ArrayList<d> dtL() {
        return this.lVx;
    }

    public boolean dtM() {
        return this.lVg;
    }

    public String dtN() {
        return this.lVq;
    }

    public String getContent() {
        return this.content;
    }

    public int dtO() {
        return this.lVr;
    }

    public boolean dtP() {
        return this.lVs;
    }

    public int dtQ() {
        return this.lVt;
    }

    public int dtR() {
        return this.lVu;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.lVy.get(signData.forumId)) != null) {
            dVar.Ht(1);
            dVar.Hu(signData.count_sign_num);
            dVar.Hw(signData.sign_bonus_point);
            dVar.vM(true);
            dVar.vN(false);
            dVar.vO(false);
            a(dVar);
            dtS();
            vL(true);
        }
    }

    private void a(d dVar) {
        if (dVar.dtV() >= this.level) {
            this.lVj++;
            this.lVk--;
        } else {
            this.lVh++;
            this.lVi--;
        }
        this.lVy.remove(String.valueOf(dVar.getForumId()));
        this.lVx.remove(dVar);
        if (dVar.dtW() + dVar.dua() >= dVar.dtX()) {
            dVar.Hv(dVar.dtV() + 1);
            dVar.vP(true);
            if (dVar.dtV() == this.level) {
                this.lVj++;
                this.lVh--;
            }
        }
        this.lVw.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dua(), -1);
    }

    private void dtS() {
        if (this.lVg) {
            if (this.lVk + this.lVi <= 0) {
                this.lVs = true;
            } else {
                this.lVs = false;
            }
        } else if (this.lVk <= 0) {
            this.lVs = true;
        } else {
            this.lVs = false;
        }
    }

    public void a(h hVar) {
        this.lVt = 0;
        this.lVu = 0;
        ArrayList<i> duk = hVar.duk();
        int size = duk.size();
        for (int i = 0; i < size; i++) {
            i iVar = duk.get(i);
            d dVar = this.lVy.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dun() != 0) {
                    this.lVt++;
                    dVar.Ht(1);
                    dVar.Hu(iVar.duo());
                    dVar.Hw(iVar.getCurScore());
                    dVar.vM(true);
                    dVar.vN(false);
                    dVar.vO(false);
                    a(dVar);
                } else {
                    this.lVu++;
                    dVar.vM(false);
                    dVar.vN(true);
                    dVar.vO(false);
                    dVar.setErrorMsg(iVar.dtJ().getUserMsg());
                }
            }
        }
        dtS();
        vL(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lVz.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.lUZ = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.lVa = jSONObject.optString("text_pre");
            this.aJg = jSONObject.optString("text_color");
            this.lVb = jSONObject.optString("text_mid");
            this.lVc = jSONObject.optString("text_suf");
            this.lVd = jSONObject.optString("num_notice");
            this.lVe = jSONObject.optInt("show_dialog");
            this.lVf = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.lVA = jSONObject.optInt("sign_max_num", 50);
            this.lVp = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.lVq = jSONObject.optString("button_content");
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
            if (this.lVp == 1) {
                this.lVg = true;
            } else {
                this.lVg = false;
            }
            this.lVm = this.level + this.title;
            this.lVl = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.lXi = this.lVA;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.lXi);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dtT() == 0) {
                            if (this.valid == 0) {
                                if (this.lVg) {
                                    dVar.vN(true);
                                } else if (dVar.dtV() > this.level) {
                                    dVar.vN(true);
                                }
                            }
                            if (dVar.dtV() >= this.level) {
                                this.lVk++;
                            } else {
                                this.lVi++;
                            }
                            this.lVx.add(dVar);
                            this.lVy.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.dtV() >= this.level) {
                                this.lVj++;
                            } else {
                                this.lVh++;
                            }
                            this.lVw.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dua(), -1);
                        }
                        this.lVv.add(dVar);
                        Collections.sort(this.lVv, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.dtV() - dVar2.dtV();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.lVB == null) {
                this.lVB = new f();
            }
            this.lVB.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.lVC == null) {
                this.lVC = new k();
            }
            this.lVC.parserJson(optJSONObject3);
            vL(false);
        }
    }

    private void vL(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.lVv.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.lVv.removeAll(arrayList);
        }
        if (this.lVk + this.lVj > 0) {
            if (this.lVj > 0) {
                this.lVo = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lVj), Integer.valueOf(this.lVk));
            } else {
                this.lVo = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lVk + this.lVj));
            }
            if (this.lVv.size() > 0) {
                this.lVv.add(0, new b(this.lVm, this.lVo));
            }
        }
        if (this.lVi + this.lVh > 0) {
            if (this.lVh > 0) {
                this.lVn = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lVh), Integer.valueOf(this.lVi));
            } else {
                this.lVn = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lVi + this.lVh));
            }
            if (this.lVk + this.lVj > 0) {
                if (this.lVv.size() > this.lVk + this.lVj + 1) {
                    this.lVv.add(this.lVk + this.lVj + 1, new b(this.lVl, this.lVn));
                }
            } else if (this.lVv.size() > 0) {
                this.lVv.add(0, new b(this.lVl, this.lVn));
            }
        }
        if (this.lVv.size() <= 0) {
            this.lVr = 3;
        } else if (this.lVg) {
            if (this.valid == 1 && this.lVx.size() > 0) {
                this.lVr = 0;
            } else {
                this.lVr = 2;
            }
        } else if (this.valid == 1 && this.lVk > 0) {
            this.lVr = 0;
        } else if (this.lVk + this.lVj > 0) {
            this.lVr = 2;
        } else if (this.lVk + this.lVj <= 0) {
            this.lVr = 3;
        }
    }
}
