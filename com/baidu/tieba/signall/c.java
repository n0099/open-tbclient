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
    private String aAq;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String laX;
    private String laY;
    private String laZ;
    private String lba;
    private int lbb;
    private String lbc;
    private boolean lbd;
    private int lbe;
    private int lbf;
    private int lbg;
    private int lbh;
    private String lbi;
    private String lbj;
    private String lbk;
    private String lbl;
    private int lbm;
    private String lbn;
    private int lbo;
    private boolean lbp;
    private int lbq;
    private int lbr;
    private int lbx;
    private int level;
    private String title;
    private int valid;
    private String laW = "0";
    private ArrayList<d> lbs = new ArrayList<>();
    private ArrayList<d> lbt = new ArrayList<>();
    private ArrayList<d> lbu = new ArrayList<>();
    private HashMap<String, d> lbv = new HashMap<>();
    private a lbw = new a();
    private f lby = new f();
    private k lbz = new k();

    public boolean dam() {
        return (this.lby == null || StringUtils.isNull(this.lby.lbR)) ? false : true;
    }

    public String bgl() {
        return this.lby.dAw;
    }

    public String dan() {
        return this.lby.lbR;
    }

    public String dao() {
        return this.lbz.ldo;
    }

    public String dap() {
        return this.lbz.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean daq() {
        return !StringUtils.isNull(this.laW) && this.laW.equals("1");
    }

    public String dar() {
        return this.laX;
    }

    public String cKh() {
        return this.aAq;
    }

    public String das() {
        return this.laY;
    }

    public String dat() {
        return this.laZ;
    }

    public String dau() {
        return this.lba;
    }

    public int dav() {
        return this.lbb;
    }

    public String daw() {
        return this.lbc;
    }

    public ArrayList<d> dax() {
        return this.lbs;
    }

    public a day() {
        return this.lbw;
    }

    public ArrayList<d> daz() {
        return this.lbt;
    }

    public ArrayList<d> daA() {
        return this.lbu;
    }

    public boolean daB() {
        return this.lbd;
    }

    public String daC() {
        return this.lbn;
    }

    public String getContent() {
        return this.content;
    }

    public int daD() {
        return this.lbo;
    }

    public boolean daE() {
        return this.lbp;
    }

    public int daF() {
        return this.lbq;
    }

    public int daG() {
        return this.lbr;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.lbv.get(signData.forumId)) != null) {
            dVar.Dw(1);
            dVar.Dx(signData.count_sign_num);
            dVar.Dz(signData.sign_bonus_point);
            dVar.ue(true);
            dVar.uf(false);
            dVar.ug(false);
            a(dVar);
            daH();
            ud(true);
        }
    }

    private void a(d dVar) {
        if (dVar.daK() >= this.level) {
            this.lbg++;
            this.lbh--;
        } else {
            this.lbe++;
            this.lbf--;
        }
        this.lbv.remove(String.valueOf(dVar.getForumId()));
        this.lbu.remove(dVar);
        if (dVar.daL() + dVar.daP() >= dVar.daM()) {
            dVar.Dy(dVar.daK() + 1);
            dVar.uh(true);
            if (dVar.daK() == this.level) {
                this.lbg++;
                this.lbe--;
            }
        }
        this.lbt.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.daP(), -1);
    }

    private void daH() {
        if (this.lbd) {
            if (this.lbh + this.lbf <= 0) {
                this.lbp = true;
            } else {
                this.lbp = false;
            }
        } else if (this.lbh <= 0) {
            this.lbp = true;
        } else {
            this.lbp = false;
        }
    }

    public void a(h hVar) {
        this.lbq = 0;
        this.lbr = 0;
        ArrayList<i> dba = hVar.dba();
        int size = dba.size();
        for (int i = 0; i < size; i++) {
            i iVar = dba.get(i);
            d dVar = this.lbv.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dbd() != 0) {
                    this.lbq++;
                    dVar.Dw(1);
                    dVar.Dx(iVar.dbe());
                    dVar.Dz(iVar.getCurScore());
                    dVar.ue(true);
                    dVar.uf(false);
                    dVar.ug(false);
                    a(dVar);
                } else {
                    this.lbr++;
                    dVar.ue(false);
                    dVar.uf(true);
                    dVar.ug(false);
                    dVar.setErrorMsg(iVar.day().getUserMsg());
                }
            }
        }
        daH();
        ud(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lbw.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.laW = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.laX = jSONObject.optString("text_pre");
            this.aAq = jSONObject.optString("text_color");
            this.laY = jSONObject.optString("text_mid");
            this.laZ = jSONObject.optString("text_suf");
            this.lba = jSONObject.optString("num_notice");
            this.lbb = jSONObject.optInt("show_dialog");
            this.lbc = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.lbx = jSONObject.optInt("sign_max_num", 50);
            this.lbm = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.lbn = jSONObject.optString("button_content");
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
            if (this.lbm == 1) {
                this.lbd = true;
            } else {
                this.lbd = false;
            }
            this.lbj = this.level + this.title;
            this.lbi = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.lde = this.lbx;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.lde);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.daI() == 0) {
                            if (this.valid == 0) {
                                if (this.lbd) {
                                    dVar.uf(true);
                                } else if (dVar.daK() > this.level) {
                                    dVar.uf(true);
                                }
                            }
                            if (dVar.daK() >= this.level) {
                                this.lbh++;
                            } else {
                                this.lbf++;
                            }
                            this.lbu.add(dVar);
                            this.lbv.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.daK() >= this.level) {
                                this.lbg++;
                            } else {
                                this.lbe++;
                            }
                            this.lbt.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.daP(), -1);
                        }
                        this.lbs.add(dVar);
                        Collections.sort(this.lbs, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.daK() - dVar2.daK();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.lby == null) {
                this.lby = new f();
            }
            this.lby.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.lbz == null) {
                this.lbz = new k();
            }
            this.lbz.parserJson(optJSONObject3);
            ud(false);
        }
    }

    private void ud(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.lbs.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.lbs.removeAll(arrayList);
        }
        if (this.lbh + this.lbg > 0) {
            if (this.lbg > 0) {
                this.lbl = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lbg), Integer.valueOf(this.lbh));
            } else {
                this.lbl = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lbh + this.lbg));
            }
            if (this.lbs.size() > 0) {
                this.lbs.add(0, new b(this.lbj, this.lbl));
            }
        }
        if (this.lbf + this.lbe > 0) {
            if (this.lbe > 0) {
                this.lbk = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lbe), Integer.valueOf(this.lbf));
            } else {
                this.lbk = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lbf + this.lbe));
            }
            if (this.lbh + this.lbg > 0) {
                if (this.lbs.size() > this.lbh + this.lbg + 1) {
                    this.lbs.add(this.lbh + this.lbg + 1, new b(this.lbi, this.lbk));
                }
            } else if (this.lbs.size() > 0) {
                this.lbs.add(0, new b(this.lbi, this.lbk));
            }
        }
        if (this.lbs.size() <= 0) {
            this.lbo = 3;
        } else if (this.lbd) {
            if (this.valid == 1 && this.lbu.size() > 0) {
                this.lbo = 0;
            } else {
                this.lbo = 2;
            }
        } else if (this.valid == 1 && this.lbh > 0) {
            this.lbo = 0;
        } else if (this.lbh + this.lbg > 0) {
            this.lbo = 2;
        } else if (this.lbh + this.lbg <= 0) {
            this.lbo = 3;
        }
    }
}
