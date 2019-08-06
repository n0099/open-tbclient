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
    private String alc;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int iXC;
    private String iXb;
    private String iXc;
    private String iXd;
    private String iXe;
    private int iXf;
    private String iXg;
    private int iXh;
    private boolean iXi;
    private int iXj;
    private int iXk;
    private int iXl;
    private int iXm;
    private String iXn;
    private String iXo;
    private String iXp;
    private String iXq;
    private int iXr;
    private String iXs;
    private int iXt;
    private boolean iXu;
    private int iXv;
    private int iXw;
    private int level;
    private String title;
    private String iXa = "0";
    private ArrayList<d> iXx = new ArrayList<>();
    private ArrayList<d> iXy = new ArrayList<>();
    private ArrayList<d> iXz = new ArrayList<>();
    private HashMap<String, d> iXA = new HashMap<>();
    private a iXB = new a();
    private f iXD = new f();
    private k iXE = new k();

    public boolean cmP() {
        return (this.iXD == null || StringUtils.isNull(this.iXD.iXW)) ? false : true;
    }

    public String awb() {
        return this.iXD.bEW;
    }

    public String cmQ() {
        return this.iXD.iXW;
    }

    public String cmR() {
        return this.iXE.iZq;
    }

    public String cmS() {
        return this.iXE.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cmT() {
        return !StringUtils.isNull(this.iXa) && this.iXa.equals("1");
    }

    public String cmU() {
        return this.iXb;
    }

    public String bZX() {
        return this.alc;
    }

    public String cmV() {
        return this.iXc;
    }

    public String cmW() {
        return this.iXd;
    }

    public String cmX() {
        return this.iXe;
    }

    public int cmY() {
        return this.iXf;
    }

    public String cmZ() {
        return this.iXg;
    }

    public ArrayList<d> cna() {
        return this.iXx;
    }

    public a cnb() {
        return this.iXB;
    }

    public ArrayList<d> cnc() {
        return this.iXy;
    }

    public ArrayList<d> cnd() {
        return this.iXz;
    }

    public boolean cne() {
        return this.iXi;
    }

    public String cnf() {
        return this.iXs;
    }

    public String getContent() {
        return this.content;
    }

    public int cng() {
        return this.iXt;
    }

    public boolean cnh() {
        return this.iXu;
    }

    public int cni() {
        return this.iXv;
    }

    public int cnj() {
        return this.iXw;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.iXA.get(signData.forumId)) != null) {
            dVar.AM(1);
            dVar.AN(signData.count_sign_num);
            dVar.AP(signData.sign_bonus_point);
            dVar.qP(true);
            dVar.qQ(false);
            dVar.qR(false);
            a(dVar);
            cnk();
            qO(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cnn() >= this.level) {
            this.iXl++;
            this.iXm--;
        } else {
            this.iXj++;
            this.iXk--;
        }
        this.iXA.remove(String.valueOf(dVar.getForumId()));
        this.iXz.remove(dVar);
        if (dVar.cno() + dVar.cns() >= dVar.cnp()) {
            dVar.AO(dVar.cnn() + 1);
            dVar.qS(true);
            if (dVar.cnn() == this.level) {
                this.iXl++;
                this.iXj--;
            }
        }
        this.iXy.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cns(), -1);
    }

    private void cnk() {
        if (this.iXi) {
            if (this.iXm + this.iXk <= 0) {
                this.iXu = true;
            } else {
                this.iXu = false;
            }
        } else if (this.iXm <= 0) {
            this.iXu = true;
        } else {
            this.iXu = false;
        }
    }

    public void a(h hVar) {
        this.iXv = 0;
        this.iXw = 0;
        ArrayList<i> cnC = hVar.cnC();
        int size = cnC.size();
        for (int i = 0; i < size; i++) {
            i iVar = cnC.get(i);
            d dVar = this.iXA.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cnF() != 0) {
                    this.iXv++;
                    dVar.AM(1);
                    dVar.AN(iVar.cnG());
                    dVar.AP(iVar.getCurScore());
                    dVar.qP(true);
                    dVar.qQ(false);
                    dVar.qR(false);
                    a(dVar);
                } else {
                    this.iXw++;
                    dVar.qP(false);
                    dVar.qQ(true);
                    dVar.qR(false);
                    dVar.setErrorMsg(iVar.cnb().getUserMsg());
                }
            }
        }
        cnk();
        qO(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.iXB.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.iXa = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.iXb = jSONObject.optString("text_pre");
            this.alc = jSONObject.optString("text_color");
            this.iXc = jSONObject.optString("text_mid");
            this.iXd = jSONObject.optString("text_suf");
            this.iXe = jSONObject.optString("num_notice");
            this.iXf = jSONObject.optInt("show_dialog");
            this.iXg = jSONObject.optString("sign_notice");
            this.iXh = jSONObject.optInt("valid", 0);
            this.iXC = jSONObject.optInt("sign_max_num", 50);
            this.iXr = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.iXs = jSONObject.optString("button_content");
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
            if (this.iXr == 1) {
                this.iXi = true;
            } else {
                this.iXi = false;
            }
            this.iXo = this.level + this.title;
            this.iXn = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.iZg = this.iXC;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.iZg);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cnl() == 0) {
                            if (this.iXh == 0) {
                                if (this.iXi) {
                                    dVar.qQ(true);
                                } else if (dVar.cnn() > this.level) {
                                    dVar.qQ(true);
                                }
                            }
                            if (dVar.cnn() >= this.level) {
                                this.iXm++;
                            } else {
                                this.iXk++;
                            }
                            this.iXz.add(dVar);
                            this.iXA.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cnn() >= this.level) {
                                this.iXl++;
                            } else {
                                this.iXj++;
                            }
                            this.iXy.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cns(), -1);
                        }
                        this.iXx.add(dVar);
                        Collections.sort(this.iXx, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cnn() - dVar2.cnn();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.iXD == null) {
                this.iXD = new f();
            }
            this.iXD.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.iXE == null) {
                this.iXE = new k();
            }
            this.iXE.parserJson(optJSONObject3);
            qO(false);
        }
    }

    private void qO(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.iXx.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.iXx.removeAll(arrayList);
        }
        if (this.iXm + this.iXl > 0) {
            if (this.iXl > 0) {
                this.iXq = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iXl), Integer.valueOf(this.iXm));
            } else {
                this.iXq = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iXm + this.iXl));
            }
            if (this.iXx.size() > 0) {
                this.iXx.add(0, new b(this.iXo, this.iXq));
            }
        }
        if (this.iXk + this.iXj > 0) {
            if (this.iXj > 0) {
                this.iXp = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.iXj), Integer.valueOf(this.iXk));
            } else {
                this.iXp = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.iXk + this.iXj));
            }
            if (this.iXm + this.iXl > 0) {
                if (this.iXx.size() > this.iXm + this.iXl + 1) {
                    this.iXx.add(this.iXm + this.iXl + 1, new b(this.iXn, this.iXp));
                }
            } else if (this.iXx.size() > 0) {
                this.iXx.add(0, new b(this.iXn, this.iXp));
            }
        }
        if (this.iXx.size() <= 0) {
            this.iXt = 3;
        } else if (this.iXi) {
            if (this.iXh == 1 && this.iXz.size() > 0) {
                this.iXt = 0;
            } else {
                this.iXt = 2;
            }
        } else if (this.iXh == 1 && this.iXm > 0) {
            this.iXt = 0;
        } else if (this.iXm + this.iXl > 0) {
            this.iXt = 2;
        } else if (this.iXm + this.iXl <= 0) {
            this.iXt = 3;
        }
    }
}
