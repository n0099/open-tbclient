package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.platform.comapi.map.MapBundleKey;
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
    private String aWd;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int level;
    private String nhG;
    private String nhH;
    private String nhI;
    private String nhJ;
    private int nhK;
    private String nhL;
    private boolean nhM;
    private int nhN;
    private int nhO;
    private int nhP;
    private int nhQ;
    private String nhR;
    private String nhS;
    private String nhT;
    private String nhU;
    private int nhV;
    private String nhW;
    private int nhX;
    private boolean nhY;
    private int nhZ;
    private int nia;
    private int nih;
    private String title;
    private int valid;
    private String nhF = "0";
    private ArrayList<d> nib = new ArrayList<>();
    private ArrayList<d> nic = new ArrayList<>();
    private ArrayList<d> nie = new ArrayList<>();
    private HashMap<String, d> nif = new HashMap<>();
    private a nig = new a();
    private f nii = new f();
    private k nij = new k();

    public boolean dLS() {
        return (this.nii == null || StringUtils.isNull(this.nii.niA)) ? false : true;
    }

    public String bIx() {
        return this.nii.eNV;
    }

    public String dLT() {
        return this.nii.niA;
    }

    public String dLU() {
        return this.nij.njX;
    }

    public String dLV() {
        return this.nij.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dLW() {
        return !StringUtils.isNull(this.nhF) && this.nhF.equals("1");
    }

    public String dLX() {
        return this.nhG;
    }

    public String dvc() {
        return this.aWd;
    }

    public String dLY() {
        return this.nhH;
    }

    public String dLZ() {
        return this.nhI;
    }

    public String dMa() {
        return this.nhJ;
    }

    public int dMb() {
        return this.nhK;
    }

    public String dMc() {
        return this.nhL;
    }

    public ArrayList<d> dMd() {
        return this.nib;
    }

    public a dMe() {
        return this.nig;
    }

    public ArrayList<d> dMf() {
        return this.nic;
    }

    public ArrayList<d> dMg() {
        return this.nie;
    }

    public boolean dMh() {
        return this.nhM;
    }

    public String dMi() {
        return this.nhW;
    }

    public String getContent() {
        return this.content;
    }

    public int dMj() {
        return this.nhX;
    }

    public boolean dMk() {
        return this.nhY;
    }

    public int dMl() {
        return this.nhZ;
    }

    public int dMm() {
        return this.nia;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.nif.get(signData.forumId)) != null) {
            dVar.Kw(1);
            dVar.Kx(signData.count_sign_num);
            dVar.Ky(signData.sign_bonus_point);
            dVar.xN(true);
            dVar.xO(false);
            dVar.xP(false);
            a(dVar);
            dMn();
            xM(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bNV() >= this.level) {
            this.nhP++;
            this.nhQ--;
        } else {
            this.nhN++;
            this.nhO--;
        }
        this.nif.remove(String.valueOf(dVar.getForumId()));
        this.nie.remove(dVar);
        if (dVar.dMq() + dVar.dMu() >= dVar.dMr()) {
            dVar.setUserLevel(dVar.bNV() + 1);
            dVar.xQ(true);
            if (dVar.bNV() == this.level) {
                this.nhP++;
                this.nhN--;
            }
        }
        this.nic.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dMu(), -1);
    }

    private void dMn() {
        if (this.nhM) {
            if (this.nhQ + this.nhO <= 0) {
                this.nhY = true;
            } else {
                this.nhY = false;
            }
        } else if (this.nhQ <= 0) {
            this.nhY = true;
        } else {
            this.nhY = false;
        }
    }

    public void a(h hVar) {
        this.nhZ = 0;
        this.nia = 0;
        ArrayList<i> dME = hVar.dME();
        int size = dME.size();
        for (int i = 0; i < size; i++) {
            i iVar = dME.get(i);
            d dVar = this.nif.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dMH() != 0) {
                    this.nhZ++;
                    dVar.Kw(1);
                    dVar.Kx(iVar.dMI());
                    dVar.Ky(iVar.getCurScore());
                    dVar.xN(true);
                    dVar.xO(false);
                    dVar.xP(false);
                    a(dVar);
                } else {
                    this.nia++;
                    dVar.xN(false);
                    dVar.xO(true);
                    dVar.xP(false);
                    dVar.setErrorMsg(iVar.dMe().getUserMsg());
                }
            }
        }
        dMn();
        xM(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.nig.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(MapBundleKey.MapObjKey.OBJ_LEVEL, 7);
            this.nhF = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.nhG = jSONObject.optString("text_pre");
            this.aWd = jSONObject.optString("text_color");
            this.nhH = jSONObject.optString("text_mid");
            this.nhI = jSONObject.optString("text_suf");
            this.nhJ = jSONObject.optString("num_notice");
            this.nhK = jSONObject.optInt("show_dialog");
            this.nhL = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.nih = jSONObject.optInt("sign_max_num", 50);
            this.nhV = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.nhW = jSONObject.optString("button_content");
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
            if (this.nhV == 1) {
                this.nhM = true;
            } else {
                this.nhM = false;
            }
            this.nhS = this.level + this.title;
            this.nhR = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.njN = this.nih;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.njN);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dMo() == 0) {
                            if (this.valid == 0) {
                                if (this.nhM) {
                                    dVar.xO(true);
                                } else if (dVar.bNV() > this.level) {
                                    dVar.xO(true);
                                }
                            }
                            if (dVar.bNV() >= this.level) {
                                this.nhQ++;
                            } else {
                                this.nhO++;
                            }
                            this.nie.add(dVar);
                            this.nif.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bNV() >= this.level) {
                                this.nhP++;
                            } else {
                                this.nhN++;
                            }
                            this.nic.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dMu(), -1);
                        }
                        this.nib.add(dVar);
                        Collections.sort(this.nib, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bNV() - dVar2.bNV();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.nii == null) {
                this.nii = new f();
            }
            this.nii.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.nij == null) {
                this.nij = new k();
            }
            this.nij.parserJson(optJSONObject3);
            xM(false);
        }
    }

    private void xM(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.nib.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.nib.removeAll(arrayList);
        }
        if (this.nhQ + this.nhP > 0) {
            if (this.nhP > 0) {
                this.nhU = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.nhP), Integer.valueOf(this.nhQ));
            } else {
                this.nhU = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.nhQ + this.nhP));
            }
            if (this.nib.size() > 0) {
                this.nib.add(0, new b(this.nhS, this.nhU));
            }
        }
        if (this.nhO + this.nhN > 0) {
            if (this.nhN > 0) {
                this.nhT = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.nhN), Integer.valueOf(this.nhO));
            } else {
                this.nhT = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.nhO + this.nhN));
            }
            if (this.nhQ + this.nhP > 0) {
                if (this.nib.size() > this.nhQ + this.nhP + 1) {
                    this.nib.add(this.nhQ + this.nhP + 1, new b(this.nhR, this.nhT));
                }
            } else if (this.nib.size() > 0) {
                this.nib.add(0, new b(this.nhR, this.nhT));
            }
        }
        if (this.nib.size() <= 0) {
            this.nhX = 3;
        } else if (this.nhM) {
            if (this.valid == 1 && this.nie.size() > 0) {
                this.nhX = 0;
            } else {
                this.nhX = 2;
            }
        } else if (this.valid == 1 && this.nhQ > 0) {
            this.nhX = 0;
        } else if (this.nhQ + this.nhP > 0) {
            this.nhX = 2;
        } else if (this.nhQ + this.nhP <= 0) {
            this.nhX = 3;
        }
    }
}
