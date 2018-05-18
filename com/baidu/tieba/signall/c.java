package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String gnA;
    private String gnB;
    private String gnC;
    private String gnD;
    private int gnE;
    private String gnF;
    private int gnG;
    private boolean gnH;
    private int gnI;
    private int gnJ;
    private int gnP;
    private String gnn;
    private String gno;
    private String gnp;
    private String gnq;
    private String gnr;
    private int gns;
    private String gnt;
    private int gnu;
    private boolean gnv;
    private int gnw;
    private int gnx;
    private int gny;
    private int gnz;
    private int level;
    private String title;
    private String gnm = "0";
    private ArrayList<d> gnK = new ArrayList<>();
    private ArrayList<d> gnL = new ArrayList<>();
    private ArrayList<d> gnM = new ArrayList<>();
    private HashMap<String, d> gnN = new HashMap<>();
    private a gnO = new a();
    private f gnQ = new f();
    private k gnR = new k();

    public boolean bnZ() {
        return (this.gnQ == null || StringUtils.isNull(this.gnQ.goj)) ? false : true;
    }

    public String Hv() {
        return this.gnQ.VO;
    }

    public String boa() {
        return this.gnQ.goj;
    }

    public String bob() {
        return this.gnR.gpG;
    }

    public String boc() {
        return this.gnR.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bod() {
        return !StringUtils.isNull(this.gnm) && this.gnm.equals("1");
    }

    public String boe() {
        return this.gnn;
    }

    public String bcj() {
        return this.gno;
    }

    public String bof() {
        return this.gnp;
    }

    public String bog() {
        return this.gnq;
    }

    public String boh() {
        return this.gnr;
    }

    public int boi() {
        return this.gns;
    }

    public String boj() {
        return this.gnt;
    }

    public ArrayList<d> bok() {
        return this.gnK;
    }

    public a bol() {
        return this.gnO;
    }

    public ArrayList<d> bom() {
        return this.gnL;
    }

    public ArrayList<d> bon() {
        return this.gnM;
    }

    public boolean boo() {
        return this.gnv;
    }

    public String bop() {
        return this.gnF;
    }

    public String getContent() {
        return this.content;
    }

    public int boq() {
        return this.gnG;
    }

    public boolean bor() {
        return this.gnH;
    }

    public int bos() {
        return this.gnI;
    }

    public int bot() {
        return this.gnJ;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gnN.get(signData.forumId)) != null) {
            dVar.sO(1);
            dVar.sP(signData.count_sign_num);
            dVar.sR(signData.sign_bonus_point);
            dVar.mb(true);
            dVar.mc(false);
            dVar.md(false);
            a(dVar);
            bou();
            ma(true);
        }
    }

    private void a(d dVar) {
        if (dVar.box() >= this.level) {
            this.gny++;
            this.gnz--;
        } else {
            this.gnw++;
            this.gnx--;
        }
        this.gnN.remove(String.valueOf(dVar.getForumId()));
        this.gnM.remove(dVar);
        if (dVar.boy() + dVar.boC() >= dVar.boz()) {
            dVar.sQ(dVar.box() + 1);
            dVar.me(true);
            if (dVar.box() == this.level) {
                this.gny++;
                this.gnw--;
            }
        }
        this.gnL.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.boC(), -1);
    }

    private void bou() {
        if (this.gnv) {
            if (this.gnz + this.gnx <= 0) {
                this.gnH = true;
            } else {
                this.gnH = false;
            }
        } else if (this.gnz <= 0) {
            this.gnH = true;
        } else {
            this.gnH = false;
        }
    }

    public void a(h hVar) {
        this.gnI = 0;
        this.gnJ = 0;
        ArrayList<i> boL = hVar.boL();
        int size = boL.size();
        for (int i = 0; i < size; i++) {
            i iVar = boL.get(i);
            d dVar = this.gnN.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.boO() != 0) {
                    this.gnI++;
                    dVar.sO(1);
                    dVar.sP(iVar.boP());
                    dVar.sR(iVar.getCurScore());
                    dVar.mb(true);
                    dVar.mc(false);
                    dVar.md(false);
                    a(dVar);
                } else {
                    this.gnJ++;
                    dVar.mb(false);
                    dVar.mc(true);
                    dVar.md(false);
                    dVar.setErrorMsg(iVar.bol().getUserMsg());
                }
            }
        }
        bou();
        ma(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gnO.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.gnm = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gnn = jSONObject.optString("text_pre");
            this.gno = jSONObject.optString("text_color");
            this.gnp = jSONObject.optString("text_mid");
            this.gnq = jSONObject.optString("text_suf");
            this.gnr = jSONObject.optString("num_notice");
            this.gns = jSONObject.optInt("show_dialog");
            this.gnt = jSONObject.optString("sign_notice");
            this.gnu = jSONObject.optInt("valid", 0);
            this.gnP = jSONObject.optInt("sign_max_num", 50);
            this.gnE = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gnF = jSONObject.optString("button_content");
            JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
            if (optJSONObject != null) {
                this.blockPopInfoData = new BlockPopInfoData();
                this.blockPopInfoData.block_info = optJSONObject.optString("block_content");
                this.blockPopInfoData.ahead_info = optJSONObject.optString("block_confirm");
                this.blockPopInfoData.ahead_url = optJSONObject.optString("block_dealurl");
                this.blockPopInfoData.ok_info = optJSONObject.optString("block_cancel");
            }
            if (this.gnE == 1) {
                this.gnv = true;
            } else {
                this.gnv = false;
            }
            this.gnB = this.level + this.title;
            this.gnA = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(d.k.sign_all_forum_tip);
            j.gpu = this.gnP;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.gpu);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.bov() == 0) {
                            if (this.gnu == 0) {
                                if (this.gnv) {
                                    dVar.mc(true);
                                } else if (dVar.box() > this.level) {
                                    dVar.mc(true);
                                }
                            }
                            if (dVar.box() >= this.level) {
                                this.gnz++;
                            } else {
                                this.gnx++;
                            }
                            this.gnM.add(dVar);
                            this.gnN.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.box() >= this.level) {
                                this.gny++;
                            } else {
                                this.gnw++;
                            }
                            this.gnL.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.boC(), -1);
                        }
                        this.gnK.add(dVar);
                        Collections.sort(this.gnK, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.box() - dVar2.box();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.gnQ == null) {
                this.gnQ = new f();
            }
            this.gnQ.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gnR == null) {
                this.gnR = new k();
            }
            this.gnR.parserJson(optJSONObject3);
            ma(false);
        }
    }

    private void ma(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gnK.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gnK.removeAll(arrayList);
        }
        if (this.gnz + this.gny > 0) {
            if (this.gny > 0) {
                this.gnD = TbadkApplication.getInst().getContext().getString(d.k.signallforum_res, Integer.valueOf(this.gny), Integer.valueOf(this.gnz));
            } else {
                this.gnD = TbadkApplication.getInst().getContext().getString(d.k.signallforum_count, Integer.valueOf(this.gnz + this.gny));
            }
            if (this.gnK.size() > 0) {
                this.gnK.add(0, new b(this.gnB, this.gnD));
            }
        }
        if (this.gnx + this.gnw > 0) {
            if (this.gnw > 0) {
                this.gnC = TbadkApplication.getInst().getContext().getString(d.k.signallforum_res, Integer.valueOf(this.gnw), Integer.valueOf(this.gnx));
            } else {
                this.gnC = TbadkApplication.getInst().getContext().getString(d.k.signallforum_count, Integer.valueOf(this.gnx + this.gnw));
            }
            if (this.gnz + this.gny > 0) {
                if (this.gnK.size() > this.gnz + this.gny + 1) {
                    this.gnK.add(this.gnz + this.gny + 1, new b(this.gnA, this.gnC));
                }
            } else if (this.gnK.size() > 0) {
                this.gnK.add(0, new b(this.gnA, this.gnC));
            }
        }
        if (this.gnK.size() <= 0) {
            this.gnG = 3;
        } else if (this.gnv) {
            if (this.gnu == 1 && this.gnM.size() > 0) {
                this.gnG = 0;
            } else {
                this.gnG = 2;
            }
        } else if (this.gnu == 1 && this.gnz > 0) {
            this.gnG = 0;
        } else if (this.gnz + this.gny > 0) {
            this.gnG = 2;
        } else if (this.gnz + this.gny <= 0) {
            this.gnG = 3;
        }
    }
}
