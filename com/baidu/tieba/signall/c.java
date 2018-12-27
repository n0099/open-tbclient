package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.touch.AiAppsTouchHelper;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.e;
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
    private String heA;
    private String heB;
    private String heC;
    private int heD;
    private String heE;
    private int heF;
    private boolean heG;
    private int heH;
    private int heI;
    private int heO;
    private String hem;
    private String hen;
    private String heo;
    private String hep;
    private String heq;
    private int her;
    private String hes;
    private int het;
    private boolean heu;
    private int hev;
    private int hew;
    private int hex;
    private int hey;
    private String hez;
    private int level;
    private String title;
    private String hel = "0";
    private ArrayList<d> heJ = new ArrayList<>();
    private ArrayList<d> heK = new ArrayList<>();
    private ArrayList<d> heL = new ArrayList<>();
    private HashMap<String, d> heM = new HashMap<>();
    private a heN = new a();
    private f heP = new f();
    private k heQ = new k();

    public boolean bAc() {
        return (this.heP == null || StringUtils.isNull(this.heP.hfi)) ? false : true;
    }

    public String PM() {
        return this.heP.apt;
    }

    public String bAd() {
        return this.heP.hfi;
    }

    public String bAe() {
        return this.heQ.hgC;
    }

    public String bAf() {
        return this.heQ.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bAg() {
        return !StringUtils.isNull(this.hel) && this.hel.equals("1");
    }

    public String bAh() {
        return this.hem;
    }

    public String bnS() {
        return this.hen;
    }

    public String bAi() {
        return this.heo;
    }

    public String bAj() {
        return this.hep;
    }

    public String bAk() {
        return this.heq;
    }

    public int bAl() {
        return this.her;
    }

    public String bAm() {
        return this.hes;
    }

    public ArrayList<d> bAn() {
        return this.heJ;
    }

    public a bAo() {
        return this.heN;
    }

    public ArrayList<d> bAp() {
        return this.heK;
    }

    public ArrayList<d> bAq() {
        return this.heL;
    }

    public boolean bAr() {
        return this.heu;
    }

    public String bAs() {
        return this.heE;
    }

    public String getContent() {
        return this.content;
    }

    public int bAt() {
        return this.heF;
    }

    public boolean bAu() {
        return this.heG;
    }

    public int bAv() {
        return this.heH;
    }

    public int bAw() {
        return this.heI;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.heM.get(signData.forumId)) != null) {
            dVar.vh(1);
            dVar.vi(signData.count_sign_num);
            dVar.vk(signData.sign_bonus_point);
            dVar.ni(true);
            dVar.nj(false);
            dVar.nk(false);
            a(dVar);
            bAx();
            nh(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bAA() >= this.level) {
            this.hex++;
            this.hey--;
        } else {
            this.hev++;
            this.hew--;
        }
        this.heM.remove(String.valueOf(dVar.getForumId()));
        this.heL.remove(dVar);
        if (dVar.bAB() + dVar.bAF() >= dVar.bAC()) {
            dVar.vj(dVar.bAA() + 1);
            dVar.nl(true);
            if (dVar.bAA() == this.level) {
                this.hex++;
                this.hev--;
            }
        }
        this.heK.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bAF(), -1);
    }

    private void bAx() {
        if (this.heu) {
            if (this.hey + this.hew <= 0) {
                this.heG = true;
            } else {
                this.heG = false;
            }
        } else if (this.hey <= 0) {
            this.heG = true;
        } else {
            this.heG = false;
        }
    }

    public void a(h hVar) {
        this.heH = 0;
        this.heI = 0;
        ArrayList<i> bAP = hVar.bAP();
        int size = bAP.size();
        for (int i = 0; i < size; i++) {
            i iVar = bAP.get(i);
            d dVar = this.heM.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.bAS() != 0) {
                    this.heH++;
                    dVar.vh(1);
                    dVar.vi(iVar.bAT());
                    dVar.vk(iVar.getCurScore());
                    dVar.ni(true);
                    dVar.nj(false);
                    dVar.nk(false);
                    a(dVar);
                } else {
                    this.heI++;
                    dVar.ni(false);
                    dVar.nj(true);
                    dVar.nk(false);
                    dVar.setErrorMsg(iVar.bAo().getUserMsg());
                }
            }
        }
        bAx();
        nh(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.heN.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.hel = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.hem = jSONObject.optString("text_pre");
            this.hen = jSONObject.optString("text_color");
            this.heo = jSONObject.optString("text_mid");
            this.hep = jSONObject.optString("text_suf");
            this.heq = jSONObject.optString("num_notice");
            this.her = jSONObject.optInt("show_dialog");
            this.hes = jSONObject.optString("sign_notice");
            this.het = jSONObject.optInt("valid", 0);
            this.heO = jSONObject.optInt("sign_max_num", 50);
            this.heD = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.heE = jSONObject.optString("button_content");
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
            if (this.heD == 1) {
                this.heu = true;
            } else {
                this.heu = false;
            }
            this.heA = this.level + this.title;
            this.hez = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(e.j.sign_all_forum_tip);
            j.hgs = this.heO;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.hgs);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.bAy() == 0) {
                            if (this.het == 0) {
                                if (this.heu) {
                                    dVar.nj(true);
                                } else if (dVar.bAA() > this.level) {
                                    dVar.nj(true);
                                }
                            }
                            if (dVar.bAA() >= this.level) {
                                this.hey++;
                            } else {
                                this.hew++;
                            }
                            this.heL.add(dVar);
                            this.heM.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bAA() >= this.level) {
                                this.hex++;
                            } else {
                                this.hev++;
                            }
                            this.heK.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bAF(), -1);
                        }
                        this.heJ.add(dVar);
                        Collections.sort(this.heJ, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bAA() - dVar2.bAA();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.heP == null) {
                this.heP = new f();
            }
            this.heP.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.heQ == null) {
                this.heQ = new k();
            }
            this.heQ.parserJson(optJSONObject3);
            nh(false);
        }
    }

    private void nh(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.heJ.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.heJ.removeAll(arrayList);
        }
        if (this.hey + this.hex > 0) {
            if (this.hex > 0) {
                this.heC = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.hex), Integer.valueOf(this.hey));
            } else {
                this.heC = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.hey + this.hex));
            }
            if (this.heJ.size() > 0) {
                this.heJ.add(0, new b(this.heA, this.heC));
            }
        }
        if (this.hew + this.hev > 0) {
            if (this.hev > 0) {
                this.heB = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.hev), Integer.valueOf(this.hew));
            } else {
                this.heB = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.hew + this.hev));
            }
            if (this.hey + this.hex > 0) {
                if (this.heJ.size() > this.hey + this.hex + 1) {
                    this.heJ.add(this.hey + this.hex + 1, new b(this.hez, this.heB));
                }
            } else if (this.heJ.size() > 0) {
                this.heJ.add(0, new b(this.hez, this.heB));
            }
        }
        if (this.heJ.size() <= 0) {
            this.heF = 3;
        } else if (this.heu) {
            if (this.het == 1 && this.heL.size() > 0) {
                this.heF = 0;
            } else {
                this.heF = 2;
            }
        } else if (this.het == 1 && this.hey > 0) {
            this.heF = 0;
        } else if (this.hey + this.hex > 0) {
            this.heF = 2;
        } else if (this.hey + this.hex <= 0) {
            this.heF = 3;
        }
    }
}
