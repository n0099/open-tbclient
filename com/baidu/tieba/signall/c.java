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
    private String nhH;
    private String nhI;
    private String nhJ;
    private String nhK;
    private int nhL;
    private String nhM;
    private boolean nhN;
    private int nhO;
    private int nhP;
    private int nhQ;
    private int nhR;
    private String nhS;
    private String nhT;
    private String nhU;
    private String nhV;
    private int nhW;
    private String nhX;
    private int nhY;
    private boolean nhZ;
    private int nia;
    private int nib;
    private int nii;
    private String title;
    private int valid;
    private String nhG = "0";
    private ArrayList<d> nic = new ArrayList<>();
    private ArrayList<d> nie = new ArrayList<>();
    private ArrayList<d> nif = new ArrayList<>();
    private HashMap<String, d> nig = new HashMap<>();
    private a nih = new a();
    private f nij = new f();
    private k nik = new k();

    public boolean dLR() {
        return (this.nij == null || StringUtils.isNull(this.nij.niB)) ? false : true;
    }

    public String bIw() {
        return this.nij.eNV;
    }

    public String dLS() {
        return this.nij.niB;
    }

    public String dLT() {
        return this.nik.njY;
    }

    public String dLU() {
        return this.nik.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dLV() {
        return !StringUtils.isNull(this.nhG) && this.nhG.equals("1");
    }

    public String dLW() {
        return this.nhH;
    }

    public String dvb() {
        return this.aWd;
    }

    public String dLX() {
        return this.nhI;
    }

    public String dLY() {
        return this.nhJ;
    }

    public String dLZ() {
        return this.nhK;
    }

    public int dMa() {
        return this.nhL;
    }

    public String dMb() {
        return this.nhM;
    }

    public ArrayList<d> dMc() {
        return this.nic;
    }

    public a dMd() {
        return this.nih;
    }

    public ArrayList<d> dMe() {
        return this.nie;
    }

    public ArrayList<d> dMf() {
        return this.nif;
    }

    public boolean dMg() {
        return this.nhN;
    }

    public String dMh() {
        return this.nhX;
    }

    public String getContent() {
        return this.content;
    }

    public int dMi() {
        return this.nhY;
    }

    public boolean dMj() {
        return this.nhZ;
    }

    public int dMk() {
        return this.nia;
    }

    public int dMl() {
        return this.nib;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.nig.get(signData.forumId)) != null) {
            dVar.Kw(1);
            dVar.Kx(signData.count_sign_num);
            dVar.Ky(signData.sign_bonus_point);
            dVar.xN(true);
            dVar.xO(false);
            dVar.xP(false);
            a(dVar);
            dMm();
            xM(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bNU() >= this.level) {
            this.nhQ++;
            this.nhR--;
        } else {
            this.nhO++;
            this.nhP--;
        }
        this.nig.remove(String.valueOf(dVar.getForumId()));
        this.nif.remove(dVar);
        if (dVar.dMp() + dVar.dMt() >= dVar.dMq()) {
            dVar.setUserLevel(dVar.bNU() + 1);
            dVar.xQ(true);
            if (dVar.bNU() == this.level) {
                this.nhQ++;
                this.nhO--;
            }
        }
        this.nie.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dMt(), -1);
    }

    private void dMm() {
        if (this.nhN) {
            if (this.nhR + this.nhP <= 0) {
                this.nhZ = true;
            } else {
                this.nhZ = false;
            }
        } else if (this.nhR <= 0) {
            this.nhZ = true;
        } else {
            this.nhZ = false;
        }
    }

    public void a(h hVar) {
        this.nia = 0;
        this.nib = 0;
        ArrayList<i> dMD = hVar.dMD();
        int size = dMD.size();
        for (int i = 0; i < size; i++) {
            i iVar = dMD.get(i);
            d dVar = this.nig.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dMG() != 0) {
                    this.nia++;
                    dVar.Kw(1);
                    dVar.Kx(iVar.dMH());
                    dVar.Ky(iVar.getCurScore());
                    dVar.xN(true);
                    dVar.xO(false);
                    dVar.xP(false);
                    a(dVar);
                } else {
                    this.nib++;
                    dVar.xN(false);
                    dVar.xO(true);
                    dVar.xP(false);
                    dVar.setErrorMsg(iVar.dMd().getUserMsg());
                }
            }
        }
        dMm();
        xM(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.nih.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(MapBundleKey.MapObjKey.OBJ_LEVEL, 7);
            this.nhG = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.nhH = jSONObject.optString("text_pre");
            this.aWd = jSONObject.optString("text_color");
            this.nhI = jSONObject.optString("text_mid");
            this.nhJ = jSONObject.optString("text_suf");
            this.nhK = jSONObject.optString("num_notice");
            this.nhL = jSONObject.optInt("show_dialog");
            this.nhM = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.nii = jSONObject.optInt("sign_max_num", 50);
            this.nhW = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.nhX = jSONObject.optString("button_content");
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
            if (this.nhW == 1) {
                this.nhN = true;
            } else {
                this.nhN = false;
            }
            this.nhT = this.level + this.title;
            this.nhS = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.njO = this.nii;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.njO);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dMn() == 0) {
                            if (this.valid == 0) {
                                if (this.nhN) {
                                    dVar.xO(true);
                                } else if (dVar.bNU() > this.level) {
                                    dVar.xO(true);
                                }
                            }
                            if (dVar.bNU() >= this.level) {
                                this.nhR++;
                            } else {
                                this.nhP++;
                            }
                            this.nif.add(dVar);
                            this.nig.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bNU() >= this.level) {
                                this.nhQ++;
                            } else {
                                this.nhO++;
                            }
                            this.nie.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dMt(), -1);
                        }
                        this.nic.add(dVar);
                        Collections.sort(this.nic, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bNU() - dVar2.bNU();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.nij == null) {
                this.nij = new f();
            }
            this.nij.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.nik == null) {
                this.nik = new k();
            }
            this.nik.parserJson(optJSONObject3);
            xM(false);
        }
    }

    private void xM(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.nic.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.nic.removeAll(arrayList);
        }
        if (this.nhR + this.nhQ > 0) {
            if (this.nhQ > 0) {
                this.nhV = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.nhQ), Integer.valueOf(this.nhR));
            } else {
                this.nhV = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.nhR + this.nhQ));
            }
            if (this.nic.size() > 0) {
                this.nic.add(0, new b(this.nhT, this.nhV));
            }
        }
        if (this.nhP + this.nhO > 0) {
            if (this.nhO > 0) {
                this.nhU = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.nhO), Integer.valueOf(this.nhP));
            } else {
                this.nhU = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.nhP + this.nhO));
            }
            if (this.nhR + this.nhQ > 0) {
                if (this.nic.size() > this.nhR + this.nhQ + 1) {
                    this.nic.add(this.nhR + this.nhQ + 1, new b(this.nhS, this.nhU));
                }
            } else if (this.nic.size() > 0) {
                this.nic.add(0, new b(this.nhS, this.nhU));
            }
        }
        if (this.nic.size() <= 0) {
            this.nhY = 3;
        } else if (this.nhN) {
            if (this.valid == 1 && this.nif.size() > 0) {
                this.nhY = 0;
            } else {
                this.nhY = 2;
            }
        } else if (this.valid == 1 && this.nhR > 0) {
            this.nhY = 0;
        } else if (this.nhR + this.nhQ > 0) {
            this.nhY = 2;
        } else if (this.nhR + this.nhQ <= 0) {
            this.nhY = 3;
        }
    }
}
