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
    private int gRF;
    private String gRd;
    private String gRe;
    private String gRf;
    private String gRg;
    private String gRh;
    private int gRi;
    private String gRj;
    private int gRk;
    private boolean gRl;
    private int gRm;
    private int gRn;
    private int gRo;
    private int gRp;
    private String gRq;
    private String gRr;
    private String gRs;
    private String gRt;
    private int gRu;
    private String gRv;
    private int gRw;
    private boolean gRx;
    private int gRy;
    private int gRz;
    private int level;
    private String title;
    private String gRc = "0";
    private ArrayList<d> gRA = new ArrayList<>();
    private ArrayList<d> gRB = new ArrayList<>();
    private ArrayList<d> gRC = new ArrayList<>();
    private HashMap<String, d> gRD = new HashMap<>();
    private a gRE = new a();
    private f gRG = new f();
    private l gRH = new l();

    public boolean bsS() {
        return (this.gRG == null || StringUtils.isNull(this.gRG.gRZ)) ? false : true;
    }

    public String OU() {
        return this.gRG.aKI;
    }

    public String bsT() {
        return this.gRG.gRZ;
    }

    public String bsU() {
        return this.gRH.gTw;
    }

    public String bsV() {
        return this.gRH.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bsW() {
        return !StringUtils.isNull(this.gRc) && this.gRc.equals("1");
    }

    public String bsX() {
        return this.gRd;
    }

    public String bhj() {
        return this.gRe;
    }

    public String bsY() {
        return this.gRf;
    }

    public String bsZ() {
        return this.gRg;
    }

    public String bta() {
        return this.gRh;
    }

    public int btb() {
        return this.gRi;
    }

    public String btc() {
        return this.gRj;
    }

    public ArrayList<d> btd() {
        return this.gRA;
    }

    public a bte() {
        return this.gRE;
    }

    public ArrayList<d> btf() {
        return this.gRB;
    }

    public ArrayList<d> btg() {
        return this.gRC;
    }

    public boolean bth() {
        return this.gRl;
    }

    public String bti() {
        return this.gRv;
    }

    public String getContent() {
        return this.content;
    }

    public int btj() {
        return this.gRw;
    }

    public boolean btk() {
        return this.gRx;
    }

    public int btl() {
        return this.gRy;
    }

    public int btm() {
        return this.gRz;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gRD.get(signData.forumId)) != null) {
            dVar.vm(1);
            dVar.vn(signData.count_sign_num);
            dVar.vp(signData.sign_bonus_point);
            dVar.mu(true);
            dVar.mv(false);
            dVar.mw(false);
            a(dVar);
            btn();
            mt(true);
        }
    }

    private void a(d dVar) {
        if (dVar.btq() >= this.level) {
            this.gRo++;
            this.gRp--;
        } else {
            this.gRm++;
            this.gRn--;
        }
        this.gRD.remove(String.valueOf(dVar.getForumId()));
        this.gRC.remove(dVar);
        if (dVar.btr() + dVar.btv() >= dVar.bts()) {
            dVar.vo(dVar.btq() + 1);
            dVar.mx(true);
            if (dVar.btq() == this.level) {
                this.gRo++;
                this.gRm--;
            }
        }
        this.gRB.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.btv(), -1);
    }

    private void btn() {
        if (this.gRl) {
            if (this.gRp + this.gRn <= 0) {
                this.gRx = true;
            } else {
                this.gRx = false;
            }
        } else if (this.gRp <= 0) {
            this.gRx = true;
        } else {
            this.gRx = false;
        }
    }

    public void a(h hVar) {
        this.gRy = 0;
        this.gRz = 0;
        ArrayList<i> btE = hVar.btE();
        int size = btE.size();
        for (int i = 0; i < size; i++) {
            i iVar = btE.get(i);
            d dVar = this.gRD.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.btH() != 0) {
                    this.gRy++;
                    dVar.vm(1);
                    dVar.vn(iVar.btI());
                    dVar.vp(iVar.getCurScore());
                    dVar.mu(true);
                    dVar.mv(false);
                    dVar.mw(false);
                    a(dVar);
                } else {
                    this.gRz++;
                    dVar.mu(false);
                    dVar.mv(true);
                    dVar.mw(false);
                    dVar.setErrorMsg(iVar.bte().getUserMsg());
                }
            }
        }
        btn();
        mt(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gRE.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.gRc = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gRd = jSONObject.optString("text_pre");
            this.gRe = jSONObject.optString("text_color");
            this.gRf = jSONObject.optString("text_mid");
            this.gRg = jSONObject.optString("text_suf");
            this.gRh = jSONObject.optString("num_notice");
            this.gRi = jSONObject.optInt("show_dialog");
            this.gRj = jSONObject.optString("sign_notice");
            this.gRk = jSONObject.optInt("valid", 0);
            this.gRF = jSONObject.optInt("sign_max_num", 50);
            this.gRu = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gRv = jSONObject.optString("button_content");
            JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
            if (optJSONObject != null) {
                this.blockPopInfoData = new BlockPopInfoData();
                this.blockPopInfoData.block_info = optJSONObject.optString("block_content");
                this.blockPopInfoData.ahead_info = optJSONObject.optString("block_confirm");
                this.blockPopInfoData.ahead_url = optJSONObject.optString("block_dealurl");
                this.blockPopInfoData.ok_info = optJSONObject.optString("block_cancel");
            }
            if (this.gRu == 1) {
                this.gRl = true;
            } else {
                this.gRl = false;
            }
            this.gRr = this.level + this.title;
            this.gRq = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(d.j.sign_all_forum_tip);
            k.gTk = this.gRF;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), k.gTk);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.bto() == 0) {
                            if (this.gRk == 0) {
                                if (this.gRl) {
                                    dVar.mv(true);
                                } else if (dVar.btq() > this.level) {
                                    dVar.mv(true);
                                }
                            }
                            if (dVar.btq() >= this.level) {
                                this.gRp++;
                            } else {
                                this.gRn++;
                            }
                            this.gRC.add(dVar);
                            this.gRD.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.btq() >= this.level) {
                                this.gRo++;
                            } else {
                                this.gRm++;
                            }
                            this.gRB.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.btv(), -1);
                        }
                        this.gRA.add(dVar);
                        Collections.sort(this.gRA, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.btq() - dVar2.btq();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.gRG == null) {
                this.gRG = new f();
            }
            this.gRG.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gRH == null) {
                this.gRH = new l();
            }
            this.gRH.parserJson(optJSONObject3);
            mt(false);
        }
    }

    private void mt(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gRA.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gRA.removeAll(arrayList);
        }
        if (this.gRp + this.gRo > 0) {
            if (this.gRo > 0) {
                this.gRt = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.gRo), Integer.valueOf(this.gRp));
            } else {
                this.gRt = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.gRp + this.gRo));
            }
            if (this.gRA.size() > 0) {
                this.gRA.add(0, new b(this.gRr, this.gRt));
            }
        }
        if (this.gRn + this.gRm > 0) {
            if (this.gRm > 0) {
                this.gRs = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.gRm), Integer.valueOf(this.gRn));
            } else {
                this.gRs = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.gRn + this.gRm));
            }
            if (this.gRp + this.gRo > 0) {
                if (this.gRA.size() > this.gRp + this.gRo + 1) {
                    this.gRA.add(this.gRp + this.gRo + 1, new b(this.gRq, this.gRs));
                }
            } else if (this.gRA.size() > 0) {
                this.gRA.add(0, new b(this.gRq, this.gRs));
            }
        }
        if (this.gRA.size() <= 0) {
            this.gRw = 3;
        } else if (this.gRl) {
            if (this.gRk == 1 && this.gRC.size() > 0) {
                this.gRw = 0;
            } else {
                this.gRw = 2;
            }
        } else if (this.gRk == 1 && this.gRp > 0) {
            this.gRw = 0;
        } else if (this.gRp + this.gRo > 0) {
            this.gRw = 2;
        } else if (this.gRp + this.gRo <= 0) {
            this.gRw = 3;
        }
    }
}
