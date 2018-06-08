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
    private String gyL;
    private String gyM;
    private String gyN;
    private String gyO;
    private String gyP;
    private int gyQ;
    private String gyR;
    private int gyS;
    private boolean gyT;
    private int gyU;
    private int gyV;
    private int gyW;
    private int gyX;
    private String gyY;
    private String gyZ;
    private String gza;
    private String gzb;
    private int gzc;
    private String gzd;
    private int gze;
    private boolean gzf;
    private int gzg;
    private int gzh;
    private int gzn;
    private int level;
    private String title;
    private String gyK = "0";
    private ArrayList<d> gzi = new ArrayList<>();
    private ArrayList<d> gzj = new ArrayList<>();
    private ArrayList<d> gzk = new ArrayList<>();
    private HashMap<String, d> gzl = new HashMap<>();
    private a gzm = new a();
    private f gzo = new f();
    private k gzp = new k();

    public boolean bsZ() {
        return (this.gzo == null || StringUtils.isNull(this.gzo.gzH)) ? false : true;
    }

    public String KP() {
        return this.gzo.adO;
    }

    public String bta() {
        return this.gzo.gzH;
    }

    public String btb() {
        return this.gzp.gBe;
    }

    public String btc() {
        return this.gzp.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean btd() {
        return !StringUtils.isNull(this.gyK) && this.gyK.equals("1");
    }

    public String bte() {
        return this.gyL;
    }

    public String bhj() {
        return this.gyM;
    }

    public String btf() {
        return this.gyN;
    }

    public String btg() {
        return this.gyO;
    }

    public String bth() {
        return this.gyP;
    }

    public int bti() {
        return this.gyQ;
    }

    public String btj() {
        return this.gyR;
    }

    public ArrayList<d> btk() {
        return this.gzi;
    }

    public a btl() {
        return this.gzm;
    }

    public ArrayList<d> btm() {
        return this.gzj;
    }

    public ArrayList<d> btn() {
        return this.gzk;
    }

    public boolean bto() {
        return this.gyT;
    }

    public String btp() {
        return this.gzd;
    }

    public String getContent() {
        return this.content;
    }

    public int btq() {
        return this.gze;
    }

    public boolean btr() {
        return this.gzf;
    }

    public int bts() {
        return this.gzg;
    }

    public int btt() {
        return this.gzh;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gzl.get(signData.forumId)) != null) {
            dVar.ta(1);
            dVar.tb(signData.count_sign_num);
            dVar.td(signData.sign_bonus_point);
            dVar.mh(true);
            dVar.mi(false);
            dVar.mj(false);
            a(dVar);
            btu();
            mg(true);
        }
    }

    private void a(d dVar) {
        if (dVar.btx() >= this.level) {
            this.gyW++;
            this.gyX--;
        } else {
            this.gyU++;
            this.gyV--;
        }
        this.gzl.remove(String.valueOf(dVar.getForumId()));
        this.gzk.remove(dVar);
        if (dVar.bty() + dVar.btC() >= dVar.btz()) {
            dVar.tc(dVar.btx() + 1);
            dVar.mk(true);
            if (dVar.btx() == this.level) {
                this.gyW++;
                this.gyU--;
            }
        }
        this.gzj.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.btC(), -1);
    }

    private void btu() {
        if (this.gyT) {
            if (this.gyX + this.gyV <= 0) {
                this.gzf = true;
            } else {
                this.gzf = false;
            }
        } else if (this.gyX <= 0) {
            this.gzf = true;
        } else {
            this.gzf = false;
        }
    }

    public void a(h hVar) {
        this.gzg = 0;
        this.gzh = 0;
        ArrayList<i> btL = hVar.btL();
        int size = btL.size();
        for (int i = 0; i < size; i++) {
            i iVar = btL.get(i);
            d dVar = this.gzl.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.btO() != 0) {
                    this.gzg++;
                    dVar.ta(1);
                    dVar.tb(iVar.btP());
                    dVar.td(iVar.getCurScore());
                    dVar.mh(true);
                    dVar.mi(false);
                    dVar.mj(false);
                    a(dVar);
                } else {
                    this.gzh++;
                    dVar.mh(false);
                    dVar.mi(true);
                    dVar.mj(false);
                    dVar.setErrorMsg(iVar.btl().getUserMsg());
                }
            }
        }
        btu();
        mg(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gzm.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.gyK = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gyL = jSONObject.optString("text_pre");
            this.gyM = jSONObject.optString("text_color");
            this.gyN = jSONObject.optString("text_mid");
            this.gyO = jSONObject.optString("text_suf");
            this.gyP = jSONObject.optString("num_notice");
            this.gyQ = jSONObject.optInt("show_dialog");
            this.gyR = jSONObject.optString("sign_notice");
            this.gyS = jSONObject.optInt("valid", 0);
            this.gzn = jSONObject.optInt("sign_max_num", 50);
            this.gzc = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gzd = jSONObject.optString("button_content");
            JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
            if (optJSONObject != null) {
                this.blockPopInfoData = new BlockPopInfoData();
                this.blockPopInfoData.block_info = optJSONObject.optString("block_content");
                this.blockPopInfoData.ahead_info = optJSONObject.optString("block_confirm");
                this.blockPopInfoData.ahead_url = optJSONObject.optString("block_dealurl");
                this.blockPopInfoData.ok_info = optJSONObject.optString("block_cancel");
            }
            if (this.gzc == 1) {
                this.gyT = true;
            } else {
                this.gyT = false;
            }
            this.gyZ = this.level + this.title;
            this.gyY = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(d.k.sign_all_forum_tip);
            j.gAS = this.gzn;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.gAS);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.btv() == 0) {
                            if (this.gyS == 0) {
                                if (this.gyT) {
                                    dVar.mi(true);
                                } else if (dVar.btx() > this.level) {
                                    dVar.mi(true);
                                }
                            }
                            if (dVar.btx() >= this.level) {
                                this.gyX++;
                            } else {
                                this.gyV++;
                            }
                            this.gzk.add(dVar);
                            this.gzl.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.btx() >= this.level) {
                                this.gyW++;
                            } else {
                                this.gyU++;
                            }
                            this.gzj.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.btC(), -1);
                        }
                        this.gzi.add(dVar);
                        Collections.sort(this.gzi, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.btx() - dVar2.btx();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.gzo == null) {
                this.gzo = new f();
            }
            this.gzo.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gzp == null) {
                this.gzp = new k();
            }
            this.gzp.parserJson(optJSONObject3);
            mg(false);
        }
    }

    private void mg(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gzi.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gzi.removeAll(arrayList);
        }
        if (this.gyX + this.gyW > 0) {
            if (this.gyW > 0) {
                this.gzb = TbadkApplication.getInst().getContext().getString(d.k.signallforum_res, Integer.valueOf(this.gyW), Integer.valueOf(this.gyX));
            } else {
                this.gzb = TbadkApplication.getInst().getContext().getString(d.k.signallforum_count, Integer.valueOf(this.gyX + this.gyW));
            }
            if (this.gzi.size() > 0) {
                this.gzi.add(0, new b(this.gyZ, this.gzb));
            }
        }
        if (this.gyV + this.gyU > 0) {
            if (this.gyU > 0) {
                this.gza = TbadkApplication.getInst().getContext().getString(d.k.signallforum_res, Integer.valueOf(this.gyU), Integer.valueOf(this.gyV));
            } else {
                this.gza = TbadkApplication.getInst().getContext().getString(d.k.signallforum_count, Integer.valueOf(this.gyV + this.gyU));
            }
            if (this.gyX + this.gyW > 0) {
                if (this.gzi.size() > this.gyX + this.gyW + 1) {
                    this.gzi.add(this.gyX + this.gyW + 1, new b(this.gyY, this.gza));
                }
            } else if (this.gzi.size() > 0) {
                this.gzi.add(0, new b(this.gyY, this.gza));
            }
        }
        if (this.gzi.size() <= 0) {
            this.gze = 3;
        } else if (this.gyT) {
            if (this.gyS == 1 && this.gzk.size() > 0) {
                this.gze = 0;
            } else {
                this.gze = 2;
            }
        } else if (this.gyS == 1 && this.gyX > 0) {
            this.gze = 0;
        } else if (this.gyX + this.gyW > 0) {
            this.gze = 2;
        } else if (this.gyX + this.gyW <= 0) {
            this.gze = 3;
        }
    }
}
