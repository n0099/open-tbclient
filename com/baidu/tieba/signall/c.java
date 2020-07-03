package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
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
/* loaded from: classes11.dex */
public class c {
    private String aCB;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private int level;
    private int lwD;
    private String lwd;
    private String lwe;
    private String lwf;
    private String lwg;
    private int lwh;
    private String lwi;
    private boolean lwj;
    private int lwk;
    private int lwl;
    private int lwm;
    private int lwn;
    private String lwo;
    private String lwp;
    private String lwq;
    private String lwr;
    private int lws;
    private String lwt;
    private int lwu;
    private boolean lwv;
    private int lww;
    private int lwx;
    private String title;
    private int valid;
    private String lwc = "0";
    private ArrayList<d> lwy = new ArrayList<>();
    private ArrayList<d> lwz = new ArrayList<>();
    private ArrayList<d> lwA = new ArrayList<>();
    private HashMap<String, d> lwB = new HashMap<>();
    private a lwC = new a();
    private f lwE = new f();
    private k lwF = new k();

    public boolean deS() {
        return (this.lwE == null || StringUtils.isNull(this.lwE.lwX)) ? false : true;
    }

    public String biz() {
        return this.lwE.dGN;
    }

    public String deT() {
        return this.lwE.lwX;
    }

    public String deU() {
        return this.lwF.lyv;
    }

    public String deV() {
        return this.lwF.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean deW() {
        return !StringUtils.isNull(this.lwc) && this.lwc.equals("1");
    }

    public String deX() {
        return this.lwd;
    }

    public String cOO() {
        return this.aCB;
    }

    public String deY() {
        return this.lwe;
    }

    public String deZ() {
        return this.lwf;
    }

    public String dfa() {
        return this.lwg;
    }

    public int dfb() {
        return this.lwh;
    }

    public String dfc() {
        return this.lwi;
    }

    public ArrayList<d> dfd() {
        return this.lwy;
    }

    public a dfe() {
        return this.lwC;
    }

    public ArrayList<d> dff() {
        return this.lwz;
    }

    public ArrayList<d> dfg() {
        return this.lwA;
    }

    public boolean dfh() {
        return this.lwj;
    }

    public String dfi() {
        return this.lwt;
    }

    public String getContent() {
        return this.content;
    }

    public int dfj() {
        return this.lwu;
    }

    public boolean dfk() {
        return this.lwv;
    }

    public int dfl() {
        return this.lww;
    }

    public int dfm() {
        return this.lwx;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.lwB.get(signData.forumId)) != null) {
            dVar.EA(1);
            dVar.EB(signData.count_sign_num);
            dVar.ED(signData.sign_bonus_point);
            dVar.ut(true);
            dVar.uu(false);
            dVar.uv(false);
            a(dVar);
            dfn();
            us(true);
        }
    }

    private void a(d dVar) {
        if (dVar.dfq() >= this.level) {
            this.lwm++;
            this.lwn--;
        } else {
            this.lwk++;
            this.lwl--;
        }
        this.lwB.remove(String.valueOf(dVar.getForumId()));
        this.lwA.remove(dVar);
        if (dVar.dfr() + dVar.dfv() >= dVar.dfs()) {
            dVar.EC(dVar.dfq() + 1);
            dVar.uw(true);
            if (dVar.dfq() == this.level) {
                this.lwm++;
                this.lwk--;
            }
        }
        this.lwz.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dfv(), -1);
    }

    private void dfn() {
        if (this.lwj) {
            if (this.lwn + this.lwl <= 0) {
                this.lwv = true;
            } else {
                this.lwv = false;
            }
        } else if (this.lwn <= 0) {
            this.lwv = true;
        } else {
            this.lwv = false;
        }
    }

    public void a(h hVar) {
        this.lww = 0;
        this.lwx = 0;
        ArrayList<i> dfF = hVar.dfF();
        int size = dfF.size();
        for (int i = 0; i < size; i++) {
            i iVar = dfF.get(i);
            d dVar = this.lwB.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dfI() != 0) {
                    this.lww++;
                    dVar.EA(1);
                    dVar.EB(iVar.dfJ());
                    dVar.ED(iVar.getCurScore());
                    dVar.ut(true);
                    dVar.uu(false);
                    dVar.uv(false);
                    a(dVar);
                } else {
                    this.lwx++;
                    dVar.ut(false);
                    dVar.uu(true);
                    dVar.uv(false);
                    dVar.setErrorMsg(iVar.dfe().getUserMsg());
                }
            }
        }
        dfn();
        us(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lwC.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.lwc = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.lwd = jSONObject.optString("text_pre");
            this.aCB = jSONObject.optString("text_color");
            this.lwe = jSONObject.optString("text_mid");
            this.lwf = jSONObject.optString("text_suf");
            this.lwg = jSONObject.optString("num_notice");
            this.lwh = jSONObject.optInt("show_dialog");
            this.lwi = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.lwD = jSONObject.optInt("sign_max_num", 50);
            this.lws = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.lwt = jSONObject.optString("button_content");
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
            if (this.lws == 1) {
                this.lwj = true;
            } else {
                this.lwj = false;
            }
            this.lwp = this.level + this.title;
            this.lwo = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.lyk = this.lwD;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.lyk);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dfo() == 0) {
                            if (this.valid == 0) {
                                if (this.lwj) {
                                    dVar.uu(true);
                                } else if (dVar.dfq() > this.level) {
                                    dVar.uu(true);
                                }
                            }
                            if (dVar.dfq() >= this.level) {
                                this.lwn++;
                            } else {
                                this.lwl++;
                            }
                            this.lwA.add(dVar);
                            this.lwB.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.dfq() >= this.level) {
                                this.lwm++;
                            } else {
                                this.lwk++;
                            }
                            this.lwz.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dfv(), -1);
                        }
                        this.lwy.add(dVar);
                        Collections.sort(this.lwy, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.dfq() - dVar2.dfq();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.lwE == null) {
                this.lwE = new f();
            }
            this.lwE.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.lwF == null) {
                this.lwF = new k();
            }
            this.lwF.parserJson(optJSONObject3);
            us(false);
        }
    }

    private void us(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.lwy.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.lwy.removeAll(arrayList);
        }
        if (this.lwn + this.lwm > 0) {
            if (this.lwm > 0) {
                this.lwr = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lwm), Integer.valueOf(this.lwn));
            } else {
                this.lwr = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lwn + this.lwm));
            }
            if (this.lwy.size() > 0) {
                this.lwy.add(0, new b(this.lwp, this.lwr));
            }
        }
        if (this.lwl + this.lwk > 0) {
            if (this.lwk > 0) {
                this.lwq = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lwk), Integer.valueOf(this.lwl));
            } else {
                this.lwq = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lwl + this.lwk));
            }
            if (this.lwn + this.lwm > 0) {
                if (this.lwy.size() > this.lwn + this.lwm + 1) {
                    this.lwy.add(this.lwn + this.lwm + 1, new b(this.lwo, this.lwq));
                }
            } else if (this.lwy.size() > 0) {
                this.lwy.add(0, new b(this.lwo, this.lwq));
            }
        }
        if (this.lwy.size() <= 0) {
            this.lwu = 3;
        } else if (this.lwj) {
            if (this.valid == 1 && this.lwA.size() > 0) {
                this.lwu = 0;
            } else {
                this.lwu = 2;
            }
        } else if (this.valid == 1 && this.lwn > 0) {
            this.lwu = 0;
        } else if (this.lwn + this.lwm > 0) {
            this.lwu = 2;
        } else if (this.lwn + this.lwm <= 0) {
            this.lwu = 3;
        }
    }
}
