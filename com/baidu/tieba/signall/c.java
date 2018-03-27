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
    private int gRA;
    private int gRG;
    private String gRe;
    private String gRf;
    private String gRg;
    private String gRh;
    private String gRi;
    private int gRj;
    private String gRk;
    private int gRl;
    private boolean gRm;
    private int gRn;
    private int gRo;
    private int gRp;
    private int gRq;
    private String gRr;
    private String gRs;
    private String gRt;
    private String gRu;
    private int gRv;
    private String gRw;
    private int gRx;
    private boolean gRy;
    private int gRz;
    private int level;
    private String title;
    private String gRd = "0";
    private ArrayList<d> gRB = new ArrayList<>();
    private ArrayList<d> gRC = new ArrayList<>();
    private ArrayList<d> gRD = new ArrayList<>();
    private HashMap<String, d> gRE = new HashMap<>();
    private a gRF = new a();
    private f gRH = new f();
    private l gRI = new l();

    public boolean bsS() {
        return (this.gRH == null || StringUtils.isNull(this.gRH.gSa)) ? false : true;
    }

    public String OU() {
        return this.gRH.aKy;
    }

    public String bsT() {
        return this.gRH.gSa;
    }

    public String bsU() {
        return this.gRI.gTx;
    }

    public String bsV() {
        return this.gRI.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bsW() {
        return !StringUtils.isNull(this.gRd) && this.gRd.equals("1");
    }

    public String bsX() {
        return this.gRe;
    }

    public String bhj() {
        return this.gRf;
    }

    public String bsY() {
        return this.gRg;
    }

    public String bsZ() {
        return this.gRh;
    }

    public String bta() {
        return this.gRi;
    }

    public int btb() {
        return this.gRj;
    }

    public String btc() {
        return this.gRk;
    }

    public ArrayList<d> btd() {
        return this.gRB;
    }

    public a bte() {
        return this.gRF;
    }

    public ArrayList<d> btf() {
        return this.gRC;
    }

    public ArrayList<d> btg() {
        return this.gRD;
    }

    public boolean bth() {
        return this.gRm;
    }

    public String bti() {
        return this.gRw;
    }

    public String getContent() {
        return this.content;
    }

    public int btj() {
        return this.gRx;
    }

    public boolean btk() {
        return this.gRy;
    }

    public int btl() {
        return this.gRz;
    }

    public int btm() {
        return this.gRA;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.gRE.get(signData.forumId)) != null) {
            dVar.vn(1);
            dVar.vo(signData.count_sign_num);
            dVar.vq(signData.sign_bonus_point);
            dVar.mz(true);
            dVar.mA(false);
            dVar.mB(false);
            a(dVar);
            btn();
            my(true);
        }
    }

    private void a(d dVar) {
        if (dVar.btq() >= this.level) {
            this.gRp++;
            this.gRq--;
        } else {
            this.gRn++;
            this.gRo--;
        }
        this.gRE.remove(String.valueOf(dVar.getForumId()));
        this.gRD.remove(dVar);
        if (dVar.btr() + dVar.btv() >= dVar.bts()) {
            dVar.vp(dVar.btq() + 1);
            dVar.mC(true);
            if (dVar.btq() == this.level) {
                this.gRp++;
                this.gRn--;
            }
        }
        this.gRC.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.btv(), -1);
    }

    private void btn() {
        if (this.gRm) {
            if (this.gRq + this.gRo <= 0) {
                this.gRy = true;
            } else {
                this.gRy = false;
            }
        } else if (this.gRq <= 0) {
            this.gRy = true;
        } else {
            this.gRy = false;
        }
    }

    public void a(h hVar) {
        this.gRz = 0;
        this.gRA = 0;
        ArrayList<i> btE = hVar.btE();
        int size = btE.size();
        for (int i = 0; i < size; i++) {
            i iVar = btE.get(i);
            d dVar = this.gRE.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.btH() != 0) {
                    this.gRz++;
                    dVar.vn(1);
                    dVar.vo(iVar.btI());
                    dVar.vq(iVar.getCurScore());
                    dVar.mz(true);
                    dVar.mA(false);
                    dVar.mB(false);
                    a(dVar);
                } else {
                    this.gRA++;
                    dVar.mz(false);
                    dVar.mA(true);
                    dVar.mB(false);
                    dVar.setErrorMsg(iVar.bte().getUserMsg());
                }
            }
        }
        btn();
        my(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gRF.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.gRd = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.gRe = jSONObject.optString("text_pre");
            this.gRf = jSONObject.optString("text_color");
            this.gRg = jSONObject.optString("text_mid");
            this.gRh = jSONObject.optString("text_suf");
            this.gRi = jSONObject.optString("num_notice");
            this.gRj = jSONObject.optInt("show_dialog");
            this.gRk = jSONObject.optString("sign_notice");
            this.gRl = jSONObject.optInt("valid", 0);
            this.gRG = jSONObject.optInt("sign_max_num", 50);
            this.gRv = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.gRw = jSONObject.optString("button_content");
            JSONObject optJSONObject = jSONObject.optJSONObject("anti_info");
            if (optJSONObject != null) {
                this.blockPopInfoData = new BlockPopInfoData();
                this.blockPopInfoData.block_info = optJSONObject.optString("block_content");
                this.blockPopInfoData.ahead_info = optJSONObject.optString("block_confirm");
                this.blockPopInfoData.ahead_url = optJSONObject.optString("block_dealurl");
                this.blockPopInfoData.ok_info = optJSONObject.optString("block_cancel");
            }
            if (this.gRv == 1) {
                this.gRm = true;
            } else {
                this.gRm = false;
            }
            this.gRs = this.level + this.title;
            this.gRr = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(d.j.sign_all_forum_tip);
            k.gTl = this.gRG;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), k.gTl);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.bto() == 0) {
                            if (this.gRl == 0) {
                                if (this.gRm) {
                                    dVar.mA(true);
                                } else if (dVar.btq() > this.level) {
                                    dVar.mA(true);
                                }
                            }
                            if (dVar.btq() >= this.level) {
                                this.gRq++;
                            } else {
                                this.gRo++;
                            }
                            this.gRD.add(dVar);
                            this.gRE.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.btq() >= this.level) {
                                this.gRp++;
                            } else {
                                this.gRn++;
                            }
                            this.gRC.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.btv(), -1);
                        }
                        this.gRB.add(dVar);
                        Collections.sort(this.gRB, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
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
            if (this.gRH == null) {
                this.gRH = new f();
            }
            this.gRH.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.gRI == null) {
                this.gRI = new l();
            }
            this.gRI.parserJson(optJSONObject3);
            my(false);
        }
    }

    private void my(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.gRB.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.gRB.removeAll(arrayList);
        }
        if (this.gRq + this.gRp > 0) {
            if (this.gRp > 0) {
                this.gRu = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.gRp), Integer.valueOf(this.gRq));
            } else {
                this.gRu = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.gRq + this.gRp));
            }
            if (this.gRB.size() > 0) {
                this.gRB.add(0, new b(this.gRs, this.gRu));
            }
        }
        if (this.gRo + this.gRn > 0) {
            if (this.gRn > 0) {
                this.gRt = TbadkApplication.getInst().getContext().getString(d.j.signallforum_res, Integer.valueOf(this.gRn), Integer.valueOf(this.gRo));
            } else {
                this.gRt = TbadkApplication.getInst().getContext().getString(d.j.signallforum_count, Integer.valueOf(this.gRo + this.gRn));
            }
            if (this.gRq + this.gRp > 0) {
                if (this.gRB.size() > this.gRq + this.gRp + 1) {
                    this.gRB.add(this.gRq + this.gRp + 1, new b(this.gRr, this.gRt));
                }
            } else if (this.gRB.size() > 0) {
                this.gRB.add(0, new b(this.gRr, this.gRt));
            }
        }
        if (this.gRB.size() <= 0) {
            this.gRx = 3;
        } else if (this.gRm) {
            if (this.gRl == 1 && this.gRD.size() > 0) {
                this.gRx = 0;
            } else {
                this.gRx = 2;
            }
        } else if (this.gRl == 1 && this.gRq > 0) {
            this.gRx = 0;
        } else if (this.gRq + this.gRp > 0) {
            this.gRx = 2;
        } else if (this.gRq + this.gRp <= 0) {
            this.gRx = 3;
        }
    }
}
