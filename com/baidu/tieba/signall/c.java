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
    private String aRq;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int level;
    private int ndB;
    private String ndb;
    private String ndc;
    private String ndd;
    private String nde;
    private int ndf;
    private String ndg;
    private boolean ndh;
    private int ndi;
    private int ndj;
    private int ndk;
    private int ndl;
    private String ndm;
    private String ndn;
    private String ndo;
    private String ndp;
    private int ndq;
    private String ndr;
    private int nds;
    private boolean ndt;
    private int ndu;
    private int ndv;
    private String title;
    private int valid;
    private String nda = "0";
    private ArrayList<d> ndw = new ArrayList<>();
    private ArrayList<d> ndx = new ArrayList<>();
    private ArrayList<d> ndy = new ArrayList<>();
    private HashMap<String, d> ndz = new HashMap<>();
    private a ndA = new a();
    private f ndC = new f();
    private k ndD = new k();

    public boolean dIa() {
        return (this.ndC == null || StringUtils.isNull(this.ndC.ndU)) ? false : true;
    }

    public String bEF() {
        return this.ndC.eJk;
    }

    public String dIb() {
        return this.ndC.ndU;
    }

    public String dIc() {
        return this.ndD.nfs;
    }

    public String dId() {
        return this.ndD.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dIe() {
        return !StringUtils.isNull(this.nda) && this.nda.equals("1");
    }

    public String dIf() {
        return this.ndb;
    }

    public String drk() {
        return this.aRq;
    }

    public String dIg() {
        return this.ndc;
    }

    public String dIh() {
        return this.ndd;
    }

    public String dIi() {
        return this.nde;
    }

    public int dIj() {
        return this.ndf;
    }

    public String dIk() {
        return this.ndg;
    }

    public ArrayList<d> dIl() {
        return this.ndw;
    }

    public a dIm() {
        return this.ndA;
    }

    public ArrayList<d> dIn() {
        return this.ndx;
    }

    public ArrayList<d> dIo() {
        return this.ndy;
    }

    public boolean dIp() {
        return this.ndh;
    }

    public String dIq() {
        return this.ndr;
    }

    public String getContent() {
        return this.content;
    }

    public int dIr() {
        return this.nds;
    }

    public boolean dIs() {
        return this.ndt;
    }

    public int dIt() {
        return this.ndu;
    }

    public int dIu() {
        return this.ndv;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.ndz.get(signData.forumId)) != null) {
            dVar.IP(1);
            dVar.IQ(signData.count_sign_num);
            dVar.IR(signData.sign_bonus_point);
            dVar.xJ(true);
            dVar.xK(false);
            dVar.xL(false);
            a(dVar);
            dIv();
            xI(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bKd() >= this.level) {
            this.ndk++;
            this.ndl--;
        } else {
            this.ndi++;
            this.ndj--;
        }
        this.ndz.remove(String.valueOf(dVar.getForumId()));
        this.ndy.remove(dVar);
        if (dVar.dIy() + dVar.dIC() >= dVar.dIz()) {
            dVar.setUserLevel(dVar.bKd() + 1);
            dVar.xM(true);
            if (dVar.bKd() == this.level) {
                this.ndk++;
                this.ndi--;
            }
        }
        this.ndx.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dIC(), -1);
    }

    private void dIv() {
        if (this.ndh) {
            if (this.ndl + this.ndj <= 0) {
                this.ndt = true;
            } else {
                this.ndt = false;
            }
        } else if (this.ndl <= 0) {
            this.ndt = true;
        } else {
            this.ndt = false;
        }
    }

    public void a(h hVar) {
        this.ndu = 0;
        this.ndv = 0;
        ArrayList<i> dIM = hVar.dIM();
        int size = dIM.size();
        for (int i = 0; i < size; i++) {
            i iVar = dIM.get(i);
            d dVar = this.ndz.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dIP() != 0) {
                    this.ndu++;
                    dVar.IP(1);
                    dVar.IQ(iVar.dIQ());
                    dVar.IR(iVar.getCurScore());
                    dVar.xJ(true);
                    dVar.xK(false);
                    dVar.xL(false);
                    a(dVar);
                } else {
                    this.ndv++;
                    dVar.xJ(false);
                    dVar.xK(true);
                    dVar.xL(false);
                    dVar.setErrorMsg(iVar.dIm().getUserMsg());
                }
            }
        }
        dIv();
        xI(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.ndA.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.nda = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.ndb = jSONObject.optString("text_pre");
            this.aRq = jSONObject.optString("text_color");
            this.ndc = jSONObject.optString("text_mid");
            this.ndd = jSONObject.optString("text_suf");
            this.nde = jSONObject.optString("num_notice");
            this.ndf = jSONObject.optInt("show_dialog");
            this.ndg = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.ndB = jSONObject.optInt("sign_max_num", 50);
            this.ndq = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.ndr = jSONObject.optString("button_content");
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
            if (this.ndq == 1) {
                this.ndh = true;
            } else {
                this.ndh = false;
            }
            this.ndn = this.level + this.title;
            this.ndm = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.nfi = this.ndB;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.nfi);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dIw() == 0) {
                            if (this.valid == 0) {
                                if (this.ndh) {
                                    dVar.xK(true);
                                } else if (dVar.bKd() > this.level) {
                                    dVar.xK(true);
                                }
                            }
                            if (dVar.bKd() >= this.level) {
                                this.ndl++;
                            } else {
                                this.ndj++;
                            }
                            this.ndy.add(dVar);
                            this.ndz.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bKd() >= this.level) {
                                this.ndk++;
                            } else {
                                this.ndi++;
                            }
                            this.ndx.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dIC(), -1);
                        }
                        this.ndw.add(dVar);
                        Collections.sort(this.ndw, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bKd() - dVar2.bKd();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.ndC == null) {
                this.ndC = new f();
            }
            this.ndC.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.ndD == null) {
                this.ndD = new k();
            }
            this.ndD.parserJson(optJSONObject3);
            xI(false);
        }
    }

    private void xI(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.ndw.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.ndw.removeAll(arrayList);
        }
        if (this.ndl + this.ndk > 0) {
            if (this.ndk > 0) {
                this.ndp = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.ndk), Integer.valueOf(this.ndl));
            } else {
                this.ndp = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.ndl + this.ndk));
            }
            if (this.ndw.size() > 0) {
                this.ndw.add(0, new b(this.ndn, this.ndp));
            }
        }
        if (this.ndj + this.ndi > 0) {
            if (this.ndi > 0) {
                this.ndo = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.ndi), Integer.valueOf(this.ndj));
            } else {
                this.ndo = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.ndj + this.ndi));
            }
            if (this.ndl + this.ndk > 0) {
                if (this.ndw.size() > this.ndl + this.ndk + 1) {
                    this.ndw.add(this.ndl + this.ndk + 1, new b(this.ndm, this.ndo));
                }
            } else if (this.ndw.size() > 0) {
                this.ndw.add(0, new b(this.ndm, this.ndo));
            }
        }
        if (this.ndw.size() <= 0) {
            this.nds = 3;
        } else if (this.ndh) {
            if (this.valid == 1 && this.ndy.size() > 0) {
                this.nds = 0;
            } else {
                this.nds = 2;
            }
        } else if (this.valid == 1 && this.ndl > 0) {
            this.nds = 0;
        } else if (this.ndl + this.ndk > 0) {
            this.nds = 2;
        } else if (this.ndl + this.ndk <= 0) {
            this.nds = 3;
        }
    }
}
