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
    private String gQO;
    private String gQP;
    private String gQQ;
    private String gQR;
    private String gQS;
    private int gQT;
    private String gQU;
    private int gQV;
    private boolean gQW;
    private int gQX;
    private int gQY;
    private int gQZ;
    private int gRa;
    private String gRb;
    private String gRc;
    private String gRd;
    private String gRe;
    private int gRf;
    private String gRg;
    private int gRh;
    private boolean gRi;
    private int gRj;
    private int gRk;
    private int gRq;
    private int level;
    private String title;
    private String gQN = "0";
    private ArrayList<d> gRl = new ArrayList<>();
    private ArrayList<d> gRm = new ArrayList<>();
    private ArrayList<d> gRn = new ArrayList<>();
    private HashMap<String, d> gRo = new HashMap<>();
    private a gRp = new a();
    private f gRr = new f();
    private l gRs = new l();

    public boolean bsR() {
        return (this.gRr == null || StringUtils.isNull(this.gRr.gRK)) ? false : true;
    }

    public String OT() {
        return this.gRr.aKx;
    }

    public String bsS() {
        return this.gRr.gRK;
    }

    public String bsT() {
        return this.gRs.gTh;
    }

    public String bsU() {
        return this.gRs.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bsV() {
        return !StringUtils.isNull(this.gQN) && this.gQN.equals("1");
    }

    public String bsW() {
        return this.gQO;
    }

    public String bhi() {
        return this.gQP;
    }

    public String bsX() {
        return this.gQQ;
    }

    public String bsY() {
        return this.gQR;
    }

    public String bsZ() {
        return this.gQS;
    }

    public int bta() {
        return this.gQT;
    }

    public String btb() {
        return this.gQU;
    }

    public ArrayList<d> btc() {
        return this.gRl;
    }

    public a btd() {
        return this.gRp;
    }

    public ArrayList<d> bte() {
        return this.gRm;
    }

    public ArrayList<d> btf() {
        return this.gRn;
    }

    public boolean btg() {
        return this.gQW;
    }

    public String bth() {
        return this.gRg;
    }

    public String getContent() {
        return this.content;
    }

    public int bti() {
        return this.gRh;
    }

    public boolean btj() {
        return this.gRi;
    }

    public int btk() {
        return this.gRj;
    }

    public int btl() {
        return this.gRk;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gRo.get(signData.forumId)) != null) {
            dVar.vn(1);
            dVar.vo(signData.count_sign_num);
            dVar.vq(signData.sign_bonus_point);
            dVar.mu(true);
            dVar.mv(false);
            dVar.mw(false);
            a(dVar);
            btm();
            mt(true);
        }
    }

    private void a(d dVar) {
        if (dVar.btp() >= this.level) {
            this.gQZ++;
            this.gRa--;
        } else {
            this.gQX++;
            this.gQY--;
        }
        this.gRo.remove(String.valueOf(dVar.getForumId()));
        this.gRn.remove(dVar);
        if (dVar.btq() + dVar.btu() >= dVar.btr()) {
            dVar.vp(dVar.btp() + 1);
            dVar.mx(true);
            if (dVar.btp() == this.level) {
                this.gQZ++;
                this.gQX--;
            }
        }
        this.gRm.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.btu(), -1);
    }

    private void btm() {
        if (this.gQW) {
            if (this.gRa + this.gQY <= 0) {
                this.gRi = true;
            } else {
                this.gRi = false;
            }
        } else if (this.gRa <= 0) {
            this.gRi = true;
        } else {
            this.gRi = false;
        }
    }

    public void a(h hVar) {
        this.gRj = 0;
        this.gRk = 0;
        ArrayList<i> btD = hVar.btD();
        int size = btD.size();
        for (int i = 0; i < size; i++) {
            i iVar = btD.get(i);
            d dVar = this.gRo.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.btG() != 0) {
                    this.gRj++;
                    dVar.vn(1);
                    dVar.vo(iVar.btH());
                    dVar.vq(iVar.getCurScore());
                    dVar.mu(true);
                    dVar.mv(false);
                    dVar.mw(false);
                    a(dVar);
                } else {
                    this.gRk++;
                    dVar.mu(false);
                    dVar.mv(true);
                    dVar.mw(false);
                    dVar.setErrorMsg(iVar.btd().getUserMsg());
                }
            }
        }
        btm();
        mt(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gRp.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.gQN = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gQO = jSONObject.optString("text_pre");
            this.gQP = jSONObject.optString("text_color");
            this.gQQ = jSONObject.optString("text_mid");
            this.gQR = jSONObject.optString("text_suf");
            this.gQS = jSONObject.optString("num_notice");
            this.gQT = jSONObject.optInt("show_dialog");
            this.gQU = jSONObject.optString("sign_notice");
            this.gQV = jSONObject.optInt("valid", 0);
            this.gRq = jSONObject.optInt("sign_max_num", 50);
            this.gRf = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gRg = jSONObject.optString("button_content");
            JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
            if (optJSONObject != null) {
                this.blockPopInfoData = new BlockPopInfoData();
                this.blockPopInfoData.block_info = optJSONObject.optString("block_content");
                this.blockPopInfoData.ahead_info = optJSONObject.optString("block_confirm");
                this.blockPopInfoData.ahead_url = optJSONObject.optString("block_dealurl");
                this.blockPopInfoData.ok_info = optJSONObject.optString("block_cancel");
            }
            if (this.gRf == 1) {
                this.gQW = true;
            } else {
                this.gQW = false;
            }
            this.gRc = this.level + this.title;
            this.gRb = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(d.j.sign_all_forum_tip);
            k.gSV = this.gRq;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), k.gSV);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.btn() == 0) {
                            if (this.gQV == 0) {
                                if (this.gQW) {
                                    dVar.mv(true);
                                } else if (dVar.btp() > this.level) {
                                    dVar.mv(true);
                                }
                            }
                            if (dVar.btp() >= this.level) {
                                this.gRa++;
                            } else {
                                this.gQY++;
                            }
                            this.gRn.add(dVar);
                            this.gRo.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.btp() >= this.level) {
                                this.gQZ++;
                            } else {
                                this.gQX++;
                            }
                            this.gRm.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.btu(), -1);
                        }
                        this.gRl.add(dVar);
                        Collections.sort(this.gRl, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.btp() - dVar2.btp();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.gRr == null) {
                this.gRr = new f();
            }
            this.gRr.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gRs == null) {
                this.gRs = new l();
            }
            this.gRs.parserJson(optJSONObject3);
            mt(false);
        }
    }

    private void mt(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gRl.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gRl.removeAll(arrayList);
        }
        if (this.gRa + this.gQZ > 0) {
            if (this.gQZ > 0) {
                this.gRe = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.gQZ), Integer.valueOf(this.gRa));
            } else {
                this.gRe = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.gRa + this.gQZ));
            }
            if (this.gRl.size() > 0) {
                this.gRl.add(0, new b(this.gRc, this.gRe));
            }
        }
        if (this.gQY + this.gQX > 0) {
            if (this.gQX > 0) {
                this.gRd = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.gQX), Integer.valueOf(this.gQY));
            } else {
                this.gRd = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.gQY + this.gQX));
            }
            if (this.gRa + this.gQZ > 0) {
                if (this.gRl.size() > this.gRa + this.gQZ + 1) {
                    this.gRl.add(this.gRa + this.gQZ + 1, new b(this.gRb, this.gRd));
                }
            } else if (this.gRl.size() > 0) {
                this.gRl.add(0, new b(this.gRb, this.gRd));
            }
        }
        if (this.gRl.size() <= 0) {
            this.gRh = 3;
        } else if (this.gQW) {
            if (this.gQV == 1 && this.gRn.size() > 0) {
                this.gRh = 0;
            } else {
                this.gRh = 2;
            }
        } else if (this.gQV == 1 && this.gRa > 0) {
            this.gRh = 0;
        } else if (this.gRa + this.gQZ > 0) {
            this.gRh = 2;
        } else if (this.gRa + this.gQZ <= 0) {
            this.gRh = 3;
        }
    }
}
