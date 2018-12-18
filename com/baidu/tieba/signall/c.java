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
    private String hbA;
    private int hbB;
    private boolean hbC;
    private int hbD;
    private int hbE;
    private int hbK;
    private String hbi;
    private String hbj;
    private String hbk;
    private String hbl;
    private String hbm;
    private int hbn;
    private String hbo;
    private int hbp;
    private boolean hbq;
    private int hbr;
    private int hbs;
    private int hbt;
    private int hbu;
    private String hbv;
    private String hbw;
    private String hbx;
    private String hby;
    private int hbz;
    private int level;
    private String title;
    private String hbh = "0";
    private ArrayList<d> hbF = new ArrayList<>();
    private ArrayList<d> hbG = new ArrayList<>();
    private ArrayList<d> hbH = new ArrayList<>();
    private HashMap<String, d> hbI = new HashMap<>();
    private a hbJ = new a();
    private f hbL = new f();
    private k hbM = new k();

    public boolean bzm() {
        return (this.hbL == null || StringUtils.isNull(this.hbL.hce)) ? false : true;
    }

    public String PK() {
        return this.hbL.apt;
    }

    public String bzn() {
        return this.hbL.hce;
    }

    public String bzo() {
        return this.hbM.hdy;
    }

    public String bzp() {
        return this.hbM.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean bzq() {
        return !StringUtils.isNull(this.hbh) && this.hbh.equals("1");
    }

    public String bzr() {
        return this.hbi;
    }

    public String bng() {
        return this.hbj;
    }

    public String bzs() {
        return this.hbk;
    }

    public String bzt() {
        return this.hbl;
    }

    public String bzu() {
        return this.hbm;
    }

    public int bzv() {
        return this.hbn;
    }

    public String bzw() {
        return this.hbo;
    }

    public ArrayList<d> bzx() {
        return this.hbF;
    }

    public a bzy() {
        return this.hbJ;
    }

    public ArrayList<d> bzz() {
        return this.hbG;
    }

    public ArrayList<d> bzA() {
        return this.hbH;
    }

    public boolean bzB() {
        return this.hbq;
    }

    public String bzC() {
        return this.hbA;
    }

    public String getContent() {
        return this.content;
    }

    public int bzD() {
        return this.hbB;
    }

    public boolean bzE() {
        return this.hbC;
    }

    public int bzF() {
        return this.hbD;
    }

    public int bzG() {
        return this.hbE;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void a(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.hbI.get(signData.forumId)) != null) {
            dVar.uU(1);
            dVar.uV(signData.count_sign_num);
            dVar.uX(signData.sign_bonus_point);
            dVar.nf(true);
            dVar.ng(false);
            dVar.nh(false);
            a(dVar);
            bzH();
            ne(true);
        }
    }

    private void a(d dVar) {
        if (dVar.bzK() >= this.level) {
            this.hbt++;
            this.hbu--;
        } else {
            this.hbr++;
            this.hbs--;
        }
        this.hbI.remove(String.valueOf(dVar.getForumId()));
        this.hbH.remove(dVar);
        if (dVar.bzL() + dVar.bzP() >= dVar.bzM()) {
            dVar.uW(dVar.bzK() + 1);
            dVar.ni(true);
            if (dVar.bzK() == this.level) {
                this.hbt++;
                this.hbr--;
            }
        }
        this.hbG.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bzP(), -1);
    }

    private void bzH() {
        if (this.hbq) {
            if (this.hbu + this.hbs <= 0) {
                this.hbC = true;
            } else {
                this.hbC = false;
            }
        } else if (this.hbu <= 0) {
            this.hbC = true;
        } else {
            this.hbC = false;
        }
    }

    public void a(h hVar) {
        this.hbD = 0;
        this.hbE = 0;
        ArrayList<i> bzZ = hVar.bzZ();
        int size = bzZ.size();
        for (int i = 0; i < size; i++) {
            i iVar = bzZ.get(i);
            d dVar = this.hbI.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.bAc() != 0) {
                    this.hbD++;
                    dVar.uU(1);
                    dVar.uV(iVar.bAd());
                    dVar.uX(iVar.getCurScore());
                    dVar.nf(true);
                    dVar.ng(false);
                    dVar.nh(false);
                    a(dVar);
                } else {
                    this.hbE++;
                    dVar.nf(false);
                    dVar.ng(true);
                    dVar.nh(false);
                    dVar.setErrorMsg(iVar.bzy().getUserMsg());
                }
            }
        }
        bzH();
        ne(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.hbJ.parserJson(jSONObject.optJSONObject(AiAppsTouchHelper.TouchEventName.TOUCH_ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.hbh = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.hbi = jSONObject.optString("text_pre");
            this.hbj = jSONObject.optString("text_color");
            this.hbk = jSONObject.optString("text_mid");
            this.hbl = jSONObject.optString("text_suf");
            this.hbm = jSONObject.optString("num_notice");
            this.hbn = jSONObject.optInt("show_dialog");
            this.hbo = jSONObject.optString("sign_notice");
            this.hbp = jSONObject.optInt("valid", 0);
            this.hbK = jSONObject.optInt("sign_max_num", 50);
            this.hbz = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.hbA = jSONObject.optString("button_content");
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
            if (this.hbz == 1) {
                this.hbq = true;
            } else {
                this.hbq = false;
            }
            this.hbw = this.level + this.title;
            this.hbv = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(e.j.sign_all_forum_tip);
            j.hdo = this.hbK;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.hdo);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.bzI() == 0) {
                            if (this.hbp == 0) {
                                if (this.hbq) {
                                    dVar.ng(true);
                                } else if (dVar.bzK() > this.level) {
                                    dVar.ng(true);
                                }
                            }
                            if (dVar.bzK() >= this.level) {
                                this.hbu++;
                            } else {
                                this.hbs++;
                            }
                            this.hbH.add(dVar);
                            this.hbI.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.bzK() >= this.level) {
                                this.hbt++;
                            } else {
                                this.hbr++;
                            }
                            this.hbG.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.bzP(), -1);
                        }
                        this.hbF.add(dVar);
                        Collections.sort(this.hbF, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.bzK() - dVar2.bzK();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.hbL == null) {
                this.hbL = new f();
            }
            this.hbL.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.hbM == null) {
                this.hbM = new k();
            }
            this.hbM.parserJson(optJSONObject3);
            ne(false);
        }
    }

    private void ne(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.hbF.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.hbF.removeAll(arrayList);
        }
        if (this.hbu + this.hbt > 0) {
            if (this.hbt > 0) {
                this.hby = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.hbt), Integer.valueOf(this.hbu));
            } else {
                this.hby = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.hbu + this.hbt));
            }
            if (this.hbF.size() > 0) {
                this.hbF.add(0, new b(this.hbw, this.hby));
            }
        }
        if (this.hbs + this.hbr > 0) {
            if (this.hbr > 0) {
                this.hbx = TbadkApplication.getInst().getContext().getString(e.j.signallforum_res, Integer.valueOf(this.hbr), Integer.valueOf(this.hbs));
            } else {
                this.hbx = TbadkApplication.getInst().getContext().getString(e.j.signallforum_count, Integer.valueOf(this.hbs + this.hbr));
            }
            if (this.hbu + this.hbt > 0) {
                if (this.hbF.size() > this.hbu + this.hbt + 1) {
                    this.hbF.add(this.hbu + this.hbt + 1, new b(this.hbv, this.hbx));
                }
            } else if (this.hbF.size() > 0) {
                this.hbF.add(0, new b(this.hbv, this.hbx));
            }
        }
        if (this.hbF.size() <= 0) {
            this.hbB = 3;
        } else if (this.hbq) {
            if (this.hbp == 1 && this.hbH.size() > 0) {
                this.hbB = 0;
            } else {
                this.hbB = 2;
            }
        } else if (this.hbp == 1 && this.hbu > 0) {
            this.hbB = 0;
        } else if (this.hbu + this.hbt > 0) {
            this.hbB = 2;
        } else if (this.hbu + this.hbt <= 0) {
            this.hbB = 3;
        }
    }
}
