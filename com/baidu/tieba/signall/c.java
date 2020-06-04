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
    private int lcA;
    private int lcG;
    private String lcg;
    private String lch;
    private String lci;
    private String lcj;
    private int lck;
    private String lcl;
    private boolean lcm;
    private int lcn;
    private int lco;
    private int lcp;
    private int lcq;
    private String lcr;
    private String lcs;
    private String lct;
    private String lcu;
    private int lcv;
    private String lcw;
    private int lcx;
    private boolean lcy;
    private int lcz;
    private int level;
    private String title;
    private int valid;
    private String lcf = "0";
    private ArrayList<d> lcB = new ArrayList<>();
    private ArrayList<d> lcC = new ArrayList<>();
    private ArrayList<d> lcD = new ArrayList<>();
    private HashMap<String, d> lcE = new HashMap<>();
    private a lcF = new a();
    private f lcH = new f();
    private k lcI = new k();

    public boolean daC() {
        return (this.lcH == null || StringUtils.isNull(this.lcH.lda)) ? false : true;
    }

    public String bgm() {
        return this.lcH.dAw;
    }

    public String daD() {
        return this.lcH.lda;
    }

    public String daE() {
        return this.lcI.ley;
    }

    public String daF() {
        return this.lcI.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean daG() {
        return !StringUtils.isNull(this.lcf) && this.lcf.equals("1");
    }

    public String daH() {
        return this.lcg;
    }

    public String cKx() {
        return this.aAq;
    }

    public String daI() {
        return this.lch;
    }

    public String daJ() {
        return this.lci;
    }

    public String daK() {
        return this.lcj;
    }

    public int daL() {
        return this.lck;
    }

    public String daM() {
        return this.lcl;
    }

    public ArrayList<d> daN() {
        return this.lcB;
    }

    public a daO() {
        return this.lcF;
    }

    public ArrayList<d> daP() {
        return this.lcC;
    }

    public ArrayList<d> daQ() {
        return this.lcD;
    }

    public boolean daR() {
        return this.lcm;
    }

    public String daS() {
        return this.lcw;
    }

    public String getContent() {
        return this.content;
    }

    public int daT() {
        return this.lcx;
    }

    public boolean daU() {
        return this.lcy;
    }

    public int daV() {
        return this.lcz;
    }

    public int daW() {
        return this.lcA;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.lcE.get(signData.forumId)) != null) {
            dVar.Dy(1);
            dVar.Dz(signData.count_sign_num);
            dVar.DB(signData.sign_bonus_point);
            dVar.ue(true);
            dVar.uf(false);
            dVar.ug(false);
            a(dVar);
            daX();
            ud(true);
        }
    }

    private void a(d dVar) {
        if (dVar.dba() >= this.level) {
            this.lcp++;
            this.lcq--;
        } else {
            this.lcn++;
            this.lco--;
        }
        this.lcE.remove(String.valueOf(dVar.getForumId()));
        this.lcD.remove(dVar);
        if (dVar.dbb() + dVar.dbf() >= dVar.dbc()) {
            dVar.DA(dVar.dba() + 1);
            dVar.uh(true);
            if (dVar.dba() == this.level) {
                this.lcp++;
                this.lcn--;
            }
        }
        this.lcC.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dbf(), -1);
    }

    private void daX() {
        if (this.lcm) {
            if (this.lcq + this.lco <= 0) {
                this.lcy = true;
            } else {
                this.lcy = false;
            }
        } else if (this.lcq <= 0) {
            this.lcy = true;
        } else {
            this.lcy = false;
        }
    }

    public void a(h hVar) {
        this.lcz = 0;
        this.lcA = 0;
        ArrayList<i> dbq = hVar.dbq();
        int size = dbq.size();
        for (int i = 0; i < size; i++) {
            i iVar = dbq.get(i);
            d dVar = this.lcE.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dbt() != 0) {
                    this.lcz++;
                    dVar.Dy(1);
                    dVar.Dz(iVar.dbu());
                    dVar.DB(iVar.getCurScore());
                    dVar.ue(true);
                    dVar.uf(false);
                    dVar.ug(false);
                    a(dVar);
                } else {
                    this.lcA++;
                    dVar.ue(false);
                    dVar.uf(true);
                    dVar.ug(false);
                    dVar.setErrorMsg(iVar.daO().getUserMsg());
                }
            }
        }
        daX();
        ud(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lcF.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.lcf = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.lcg = jSONObject.optString("text_pre");
            this.aAq = jSONObject.optString("text_color");
            this.lch = jSONObject.optString("text_mid");
            this.lci = jSONObject.optString("text_suf");
            this.lcj = jSONObject.optString("num_notice");
            this.lck = jSONObject.optInt("show_dialog");
            this.lcl = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.lcG = jSONObject.optInt("sign_max_num", 50);
            this.lcv = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.lcw = jSONObject.optString("button_content");
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
            if (this.lcv == 1) {
                this.lcm = true;
            } else {
                this.lcm = false;
            }
            this.lcs = this.level + this.title;
            this.lcr = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.leo = this.lcG;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.leo);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.daY() == 0) {
                            if (this.valid == 0) {
                                if (this.lcm) {
                                    dVar.uf(true);
                                } else if (dVar.dba() > this.level) {
                                    dVar.uf(true);
                                }
                            }
                            if (dVar.dba() >= this.level) {
                                this.lcq++;
                            } else {
                                this.lco++;
                            }
                            this.lcD.add(dVar);
                            this.lcE.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.dba() >= this.level) {
                                this.lcp++;
                            } else {
                                this.lcn++;
                            }
                            this.lcC.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.dbf(), -1);
                        }
                        this.lcB.add(dVar);
                        Collections.sort(this.lcB, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.dba() - dVar2.dba();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.lcH == null) {
                this.lcH = new f();
            }
            this.lcH.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.lcI == null) {
                this.lcI = new k();
            }
            this.lcI.parserJson(optJSONObject3);
            ud(false);
        }
    }

    private void ud(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.lcB.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.lcB.removeAll(arrayList);
        }
        if (this.lcq + this.lcp > 0) {
            if (this.lcp > 0) {
                this.lcu = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lcp), Integer.valueOf(this.lcq));
            } else {
                this.lcu = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lcq + this.lcp));
            }
            if (this.lcB.size() > 0) {
                this.lcB.add(0, new b(this.lcs, this.lcu));
            }
        }
        if (this.lco + this.lcn > 0) {
            if (this.lcn > 0) {
                this.lct = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lcn), Integer.valueOf(this.lco));
            } else {
                this.lct = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lco + this.lcn));
            }
            if (this.lcq + this.lcp > 0) {
                if (this.lcB.size() > this.lcq + this.lcp + 1) {
                    this.lcB.add(this.lcq + this.lcp + 1, new b(this.lcr, this.lct));
                }
            } else if (this.lcB.size() > 0) {
                this.lcB.add(0, new b(this.lcr, this.lct));
            }
        }
        if (this.lcB.size() <= 0) {
            this.lcx = 3;
        } else if (this.lcm) {
            if (this.valid == 1 && this.lcD.size() > 0) {
                this.lcx = 0;
            } else {
                this.lcx = 2;
            }
        } else if (this.valid == 1 && this.lcq > 0) {
            this.lcx = 0;
        } else if (this.lcq + this.lcp > 0) {
            this.lcx = 2;
        } else if (this.lcq + this.lcp <= 0) {
            this.lcx = 3;
        }
    }
}
