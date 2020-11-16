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
/* loaded from: classes23.dex */
public class c {
    private String aRJ;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int level;
    private String mNT;
    private String mNU;
    private String mNV;
    private String mNW;
    private int mNX;
    private String mNY;
    private boolean mNZ;
    private int mOa;
    private int mOb;
    private int mOc;
    private int mOd;
    private String mOe;
    private String mOf;
    private String mOg;
    private String mOh;
    private int mOi;
    private String mOj;
    private int mOk;
    private boolean mOl;
    private int mOm;
    private int mOn;
    private int mOt;
    private String title;
    private int valid;
    private String mNS = "0";
    private ArrayList<d> mOo = new ArrayList<>();
    private ArrayList<d> mOp = new ArrayList<>();
    private ArrayList<d> mOq = new ArrayList<>();
    private HashMap<String, d> mOr = new HashMap<>();
    private a mOs = new a();
    private f mOu = new f();
    private k mOv = new k();

    public boolean dGH() {
        return (this.mOu == null || StringUtils.isNull(this.mOu.mOM)) ? false : true;
    }

    public String bCA() {
        return this.mOu.exe;
    }

    public String dGI() {
        return this.mOu.mOM;
    }

    public String dGJ() {
        return this.mOv.mQl;
    }

    public String dGK() {
        return this.mOv.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dGL() {
        return !StringUtils.isNull(this.mNS) && this.mNS.equals("1");
    }

    public String dGM() {
        return this.mNT;
    }

    public String dpS() {
        return this.aRJ;
    }

    public String dGN() {
        return this.mNU;
    }

    public String dGO() {
        return this.mNV;
    }

    public String dGP() {
        return this.mNW;
    }

    public int dGQ() {
        return this.mNX;
    }

    public String dGR() {
        return this.mNY;
    }

    public ArrayList<d> dGS() {
        return this.mOo;
    }

    public a dGT() {
        return this.mOs;
    }

    public ArrayList<d> dGU() {
        return this.mOp;
    }

    public ArrayList<d> dGV() {
        return this.mOq;
    }

    public boolean dGW() {
        return this.mNZ;
    }

    public String dGX() {
        return this.mOj;
    }

    public String getContent() {
        return this.content;
    }

    public int dGY() {
        return this.mOk;
    }

    public boolean dGZ() {
        return this.mOl;
    }

    public int dHa() {
        return this.mOm;
    }

    public int dHb() {
        return this.mOn;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.mOr.get(signData.forumId)) != null) {
            dVar.JK(1);
            dVar.JL(signData.count_sign_num);
            dVar.JN(signData.sign_bonus_point);
            dVar.xh(true);
            dVar.xi(false);
            dVar.xj(false);
            a(dVar);
            dHc();
            xg(true);
        }
    }

    private void a(d dVar) {
        if (dVar.dHf() >= this.level) {
            this.mOc++;
            this.mOd--;
        } else {
            this.mOa++;
            this.mOb--;
        }
        this.mOr.remove(String.valueOf(dVar.getForumId()));
        this.mOq.remove(dVar);
        if (dVar.dHg() + dVar.dHk() >= dVar.dHh()) {
            dVar.JM(dVar.dHf() + 1);
            dVar.xk(true);
            if (dVar.dHf() == this.level) {
                this.mOc++;
                this.mOa--;
            }
        }
        this.mOp.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dHk(), -1);
    }

    private void dHc() {
        if (this.mNZ) {
            if (this.mOd + this.mOb <= 0) {
                this.mOl = true;
            } else {
                this.mOl = false;
            }
        } else if (this.mOd <= 0) {
            this.mOl = true;
        } else {
            this.mOl = false;
        }
    }

    public void a(h hVar) {
        this.mOm = 0;
        this.mOn = 0;
        ArrayList<i> dHu = hVar.dHu();
        int size = dHu.size();
        for (int i = 0; i < size; i++) {
            i iVar = dHu.get(i);
            d dVar = this.mOr.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dHx() != 0) {
                    this.mOm++;
                    dVar.JK(1);
                    dVar.JL(iVar.dHy());
                    dVar.JN(iVar.getCurScore());
                    dVar.xh(true);
                    dVar.xi(false);
                    dVar.xj(false);
                    a(dVar);
                } else {
                    this.mOn++;
                    dVar.xh(false);
                    dVar.xi(true);
                    dVar.xj(false);
                    dVar.setErrorMsg(iVar.dGT().getUserMsg());
                }
            }
        }
        dHc();
        xg(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.mOs.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.mNS = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.mNT = jSONObject.optString("text_pre");
            this.aRJ = jSONObject.optString("text_color");
            this.mNU = jSONObject.optString("text_mid");
            this.mNV = jSONObject.optString("text_suf");
            this.mNW = jSONObject.optString("num_notice");
            this.mNX = jSONObject.optInt("show_dialog");
            this.mNY = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.mOt = jSONObject.optInt("sign_max_num", 50);
            this.mOi = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.mOj = jSONObject.optString("button_content");
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
            if (this.mOi == 1) {
                this.mNZ = true;
            } else {
                this.mNZ = false;
            }
            this.mOf = this.level + this.title;
            this.mOe = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.mQb = this.mOt;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.mQb);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dHd() == 0) {
                            if (this.valid == 0) {
                                if (this.mNZ) {
                                    dVar.xi(true);
                                } else if (dVar.dHf() > this.level) {
                                    dVar.xi(true);
                                }
                            }
                            if (dVar.dHf() >= this.level) {
                                this.mOd++;
                            } else {
                                this.mOb++;
                            }
                            this.mOq.add(dVar);
                            this.mOr.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.dHf() >= this.level) {
                                this.mOc++;
                            } else {
                                this.mOa++;
                            }
                            this.mOp.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dHk(), -1);
                        }
                        this.mOo.add(dVar);
                        Collections.sort(this.mOo, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.dHf() - dVar2.dHf();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.mOu == null) {
                this.mOu = new f();
            }
            this.mOu.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.mOv == null) {
                this.mOv = new k();
            }
            this.mOv.parserJson(optJSONObject3);
            xg(false);
        }
    }

    private void xg(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.mOo.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.mOo.removeAll(arrayList);
        }
        if (this.mOd + this.mOc > 0) {
            if (this.mOc > 0) {
                this.mOh = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.mOc), Integer.valueOf(this.mOd));
            } else {
                this.mOh = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.mOd + this.mOc));
            }
            if (this.mOo.size() > 0) {
                this.mOo.add(0, new b(this.mOf, this.mOh));
            }
        }
        if (this.mOb + this.mOa > 0) {
            if (this.mOa > 0) {
                this.mOg = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.mOa), Integer.valueOf(this.mOb));
            } else {
                this.mOg = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.mOb + this.mOa));
            }
            if (this.mOd + this.mOc > 0) {
                if (this.mOo.size() > this.mOd + this.mOc + 1) {
                    this.mOo.add(this.mOd + this.mOc + 1, new b(this.mOe, this.mOg));
                }
            } else if (this.mOo.size() > 0) {
                this.mOo.add(0, new b(this.mOe, this.mOg));
            }
        }
        if (this.mOo.size() <= 0) {
            this.mOk = 3;
        } else if (this.mNZ) {
            if (this.valid == 1 && this.mOq.size() > 0) {
                this.mOk = 0;
            } else {
                this.mOk = 2;
            }
        } else if (this.valid == 1 && this.mOd > 0) {
            this.mOk = 0;
        } else if (this.mOd + this.mOc > 0) {
            this.mOk = 2;
        } else if (this.mOd + this.mOc <= 0) {
            this.mOk = 3;
        }
    }
}
