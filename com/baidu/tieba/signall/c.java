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
/* loaded from: classes24.dex */
public class c {
    private String aUL;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int level;
    private int ncB;
    private String ncb;
    private String ncc;
    private String ncd;
    private String nce;
    private int ncf;
    private String ncg;
    private boolean nch;
    private int nci;
    private int ncj;
    private int nck;
    private int ncl;
    private String ncm;
    private String ncn;
    private String nco;
    private String ncp;
    private int ncq;
    private String ncr;
    private int ncs;
    private boolean nct;
    private int ncu;
    private int ncv;
    private String title;
    private int valid;
    private String nca = "0";
    private ArrayList<d> ncw = new ArrayList<>();
    private ArrayList<d> ncx = new ArrayList<>();
    private ArrayList<d> ncy = new ArrayList<>();
    private HashMap<String, d> ncz = new HashMap<>();
    private a ncA = new a();
    private f ncC = new f();
    private k ncD = new k();

    public boolean dLZ() {
        return (this.ncC == null || StringUtils.isNull(this.ncC.ncU)) ? false : true;
    }

    public String bGb() {
        return this.ncC.eEf;
    }

    public String dMa() {
        return this.ncC.ncU;
    }

    public String dMb() {
        return this.ncD.ner;
    }

    public String dMc() {
        return this.ncD.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dMd() {
        return !StringUtils.isNull(this.nca) && this.nca.equals("1");
    }

    public String dMe() {
        return this.ncb;
    }

    public String dvm() {
        return this.aUL;
    }

    public String dMf() {
        return this.ncc;
    }

    public String dMg() {
        return this.ncd;
    }

    public String dMh() {
        return this.nce;
    }

    public int dMi() {
        return this.ncf;
    }

    public String dMj() {
        return this.ncg;
    }

    public ArrayList<d> dMk() {
        return this.ncw;
    }

    public a dMl() {
        return this.ncA;
    }

    public ArrayList<d> dMm() {
        return this.ncx;
    }

    public ArrayList<d> dMn() {
        return this.ncy;
    }

    public boolean dMo() {
        return this.nch;
    }

    public String dMp() {
        return this.ncr;
    }

    public String getContent() {
        return this.content;
    }

    public int dMq() {
        return this.ncs;
    }

    public boolean dMr() {
        return this.nct;
    }

    public int dMs() {
        return this.ncu;
    }

    public int dMt() {
        return this.ncv;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.ncz.get(signData.forumId)) != null) {
            dVar.KB(1);
            dVar.KC(signData.count_sign_num);
            dVar.KD(signData.sign_bonus_point);
            dVar.xL(true);
            dVar.xM(false);
            dVar.xN(false);
            a(dVar);
            dMu();
            xK(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bLC() >= this.level) {
            this.nck++;
            this.ncl--;
        } else {
            this.nci++;
            this.ncj--;
        }
        this.ncz.remove(String.valueOf(dVar.getForumId()));
        this.ncy.remove(dVar);
        if (dVar.dMx() + dVar.dMB() >= dVar.dMy()) {
            dVar.setUserLevel(dVar.bLC() + 1);
            dVar.xO(true);
            if (dVar.bLC() == this.level) {
                this.nck++;
                this.nci--;
            }
        }
        this.ncx.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dMB(), -1);
    }

    private void dMu() {
        if (this.nch) {
            if (this.ncl + this.ncj <= 0) {
                this.nct = true;
            } else {
                this.nct = false;
            }
        } else if (this.ncl <= 0) {
            this.nct = true;
        } else {
            this.nct = false;
        }
    }

    public void a(h hVar) {
        this.ncu = 0;
        this.ncv = 0;
        ArrayList<i> dML = hVar.dML();
        int size = dML.size();
        for (int i = 0; i < size; i++) {
            i iVar = dML.get(i);
            d dVar = this.ncz.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dMO() != 0) {
                    this.ncu++;
                    dVar.KB(1);
                    dVar.KC(iVar.dMP());
                    dVar.KD(iVar.getCurScore());
                    dVar.xL(true);
                    dVar.xM(false);
                    dVar.xN(false);
                    a(dVar);
                } else {
                    this.ncv++;
                    dVar.xL(false);
                    dVar.xM(true);
                    dVar.xN(false);
                    dVar.setErrorMsg(iVar.dMl().getUserMsg());
                }
            }
        }
        dMu();
        xK(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.ncA.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.nca = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.ncb = jSONObject.optString("text_pre");
            this.aUL = jSONObject.optString("text_color");
            this.ncc = jSONObject.optString("text_mid");
            this.ncd = jSONObject.optString("text_suf");
            this.nce = jSONObject.optString("num_notice");
            this.ncf = jSONObject.optInt("show_dialog");
            this.ncg = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.ncB = jSONObject.optInt("sign_max_num", 50);
            this.ncq = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.ncr = jSONObject.optString("button_content");
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
            if (this.ncq == 1) {
                this.nch = true;
            } else {
                this.nch = false;
            }
            this.ncn = this.level + this.title;
            this.ncm = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.neh = this.ncB;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.neh);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dMv() == 0) {
                            if (this.valid == 0) {
                                if (this.nch) {
                                    dVar.xM(true);
                                } else if (dVar.bLC() > this.level) {
                                    dVar.xM(true);
                                }
                            }
                            if (dVar.bLC() >= this.level) {
                                this.ncl++;
                            } else {
                                this.ncj++;
                            }
                            this.ncy.add(dVar);
                            this.ncz.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bLC() >= this.level) {
                                this.nck++;
                            } else {
                                this.nci++;
                            }
                            this.ncx.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dMB(), -1);
                        }
                        this.ncw.add(dVar);
                        Collections.sort(this.ncw, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bLC() - dVar2.bLC();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.ncC == null) {
                this.ncC = new f();
            }
            this.ncC.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.ncD == null) {
                this.ncD = new k();
            }
            this.ncD.parserJson(optJSONObject3);
            xK(false);
        }
    }

    private void xK(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.ncw.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.ncw.removeAll(arrayList);
        }
        if (this.ncl + this.nck > 0) {
            if (this.nck > 0) {
                this.ncp = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.nck), Integer.valueOf(this.ncl));
            } else {
                this.ncp = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.ncl + this.nck));
            }
            if (this.ncw.size() > 0) {
                this.ncw.add(0, new b(this.ncn, this.ncp));
            }
        }
        if (this.ncj + this.nci > 0) {
            if (this.nci > 0) {
                this.nco = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.nci), Integer.valueOf(this.ncj));
            } else {
                this.nco = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.ncj + this.nci));
            }
            if (this.ncl + this.nck > 0) {
                if (this.ncw.size() > this.ncl + this.nck + 1) {
                    this.ncw.add(this.ncl + this.nck + 1, new b(this.ncm, this.nco));
                }
            } else if (this.ncw.size() > 0) {
                this.ncw.add(0, new b(this.ncm, this.nco));
            }
        }
        if (this.ncw.size() <= 0) {
            this.ncs = 3;
        } else if (this.nch) {
            if (this.valid == 1 && this.ncy.size() > 0) {
                this.ncs = 0;
            } else {
                this.ncs = 2;
            }
        } else if (this.valid == 1 && this.ncl > 0) {
            this.ncs = 0;
        } else if (this.ncl + this.nck > 0) {
            this.ncs = 2;
        } else if (this.ncl + this.nck <= 0) {
            this.ncs = 3;
        }
    }
}
