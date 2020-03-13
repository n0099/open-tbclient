package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.net.update.UpdateConstants;
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
    private String acA;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String jXO;
    private String jXP;
    private String jXQ;
    private String jXR;
    private int jXS;
    private String jXT;
    private boolean jXU;
    private int jXV;
    private int jXW;
    private int jXX;
    private int jXY;
    private String jXZ;
    private String jYa;
    private String jYb;
    private String jYc;
    private int jYd;
    private String jYe;
    private int jYf;
    private boolean jYg;
    private int jYh;
    private int jYi;
    private int jYo;
    private int level;
    private String title;
    private int valid;
    private String jXN = "0";
    private ArrayList<d> jYj = new ArrayList<>();
    private ArrayList<d> jYk = new ArrayList<>();
    private ArrayList<d> jYl = new ArrayList<>();
    private HashMap<String, d> jYm = new HashMap<>();
    private a jYn = new a();
    private f jYp = new f();
    private k jYq = new k();

    public boolean cIn() {
        return (this.jYp == null || StringUtils.isNull(this.jYp.jYI)) ? false : true;
    }

    public String aRQ() {
        return this.jYp.cMZ;
    }

    public String cIo() {
        return this.jYp.jYI;
    }

    public String cIp() {
        return this.jYq.kac;
    }

    public String cIq() {
        return this.jYq.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean cIr() {
        return !StringUtils.isNull(this.jXN) && this.jXN.equals("1");
    }

    public String cIs() {
        return this.jXO;
    }

    public String csk() {
        return this.acA;
    }

    public String cIt() {
        return this.jXP;
    }

    public String cIu() {
        return this.jXQ;
    }

    public String cIv() {
        return this.jXR;
    }

    public int cIw() {
        return this.jXS;
    }

    public String cIx() {
        return this.jXT;
    }

    public ArrayList<d> cIy() {
        return this.jYj;
    }

    public a cIz() {
        return this.jYn;
    }

    public ArrayList<d> cIA() {
        return this.jYk;
    }

    public ArrayList<d> cIB() {
        return this.jYl;
    }

    public boolean cIC() {
        return this.jXU;
    }

    public String cID() {
        return this.jYe;
    }

    public String getContent() {
        return this.content;
    }

    public int cIE() {
        return this.jYf;
    }

    public boolean cIF() {
        return this.jYg;
    }

    public int cIG() {
        return this.jYh;
    }

    public int cIH() {
        return this.jYi;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.jYm.get(signData.forumId)) != null) {
            dVar.Ce(1);
            dVar.Cf(signData.count_sign_num);
            dVar.Ch(signData.sign_bonus_point);
            dVar.sz(true);
            dVar.sA(false);
            dVar.sB(false);
            a(dVar);
            cII();
            sy(true);
        }
    }

    private void a(d dVar) {
        if (dVar.cIL() >= this.level) {
            this.jXX++;
            this.jXY--;
        } else {
            this.jXV++;
            this.jXW--;
        }
        this.jYm.remove(String.valueOf(dVar.getForumId()));
        this.jYl.remove(dVar);
        if (dVar.cIM() + dVar.cIQ() >= dVar.cIN()) {
            dVar.Cg(dVar.cIL() + 1);
            dVar.sC(true);
            if (dVar.cIL() == this.level) {
                this.jXX++;
                this.jXV--;
            }
        }
        this.jYk.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cIQ(), -1);
    }

    private void cII() {
        if (this.jXU) {
            if (this.jXY + this.jXW <= 0) {
                this.jYg = true;
            } else {
                this.jYg = false;
            }
        } else if (this.jXY <= 0) {
            this.jYg = true;
        } else {
            this.jYg = false;
        }
    }

    public void a(h hVar) {
        this.jYh = 0;
        this.jYi = 0;
        ArrayList<i> cJa = hVar.cJa();
        int size = cJa.size();
        for (int i = 0; i < size; i++) {
            i iVar = cJa.get(i);
            d dVar = this.jYm.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.cJd() != 0) {
                    this.jYh++;
                    dVar.Ce(1);
                    dVar.Cf(iVar.cJe());
                    dVar.Ch(iVar.getCurScore());
                    dVar.sz(true);
                    dVar.sA(false);
                    dVar.sB(false);
                    a(dVar);
                } else {
                    this.jYi++;
                    dVar.sz(false);
                    dVar.sA(true);
                    dVar.sB(false);
                    dVar.setErrorMsg(iVar.cIz().getUserMsg());
                }
            }
        }
        cII();
        sy(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.jYn.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 7);
            this.jXN = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.jXO = jSONObject.optString("text_pre");
            this.acA = jSONObject.optString("text_color");
            this.jXP = jSONObject.optString("text_mid");
            this.jXQ = jSONObject.optString("text_suf");
            this.jXR = jSONObject.optString("num_notice");
            this.jXS = jSONObject.optInt("show_dialog");
            this.jXT = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(UpdateConstants.VALID_KEY, 0);
            this.jYo = jSONObject.optInt("sign_max_num", 50);
            this.jYd = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.jYe = jSONObject.optString("button_content");
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
            if (this.jYd == 1) {
                this.jXU = true;
            } else {
                this.jXU = false;
            }
            this.jYa = this.level + this.title;
            this.jXZ = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.jZS = this.jYo;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.jZS);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.cIJ() == 0) {
                            if (this.valid == 0) {
                                if (this.jXU) {
                                    dVar.sA(true);
                                } else if (dVar.cIL() > this.level) {
                                    dVar.sA(true);
                                }
                            }
                            if (dVar.cIL() >= this.level) {
                                this.jXY++;
                            } else {
                                this.jXW++;
                            }
                            this.jYl.add(dVar);
                            this.jYm.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.cIL() >= this.level) {
                                this.jXX++;
                            } else {
                                this.jXV++;
                            }
                            this.jYk.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.cIQ(), -1);
                        }
                        this.jYj.add(dVar);
                        Collections.sort(this.jYj, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.cIL() - dVar2.cIL();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.jYp == null) {
                this.jYp = new f();
            }
            this.jYp.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.jYq == null) {
                this.jYq = new k();
            }
            this.jYq.parserJson(optJSONObject3);
            sy(false);
        }
    }

    private void sy(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.jYj.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.jYj.removeAll(arrayList);
        }
        if (this.jXY + this.jXX > 0) {
            if (this.jXX > 0) {
                this.jYc = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jXX), Integer.valueOf(this.jXY));
            } else {
                this.jYc = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jXY + this.jXX));
            }
            if (this.jYj.size() > 0) {
                this.jYj.add(0, new b(this.jYa, this.jYc));
            }
        }
        if (this.jXW + this.jXV > 0) {
            if (this.jXV > 0) {
                this.jYb = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.jXV), Integer.valueOf(this.jXW));
            } else {
                this.jYb = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.jXW + this.jXV));
            }
            if (this.jXY + this.jXX > 0) {
                if (this.jYj.size() > this.jXY + this.jXX + 1) {
                    this.jYj.add(this.jXY + this.jXX + 1, new b(this.jXZ, this.jYb));
                }
            } else if (this.jYj.size() > 0) {
                this.jYj.add(0, new b(this.jXZ, this.jYb));
            }
        }
        if (this.jYj.size() <= 0) {
            this.jYf = 3;
        } else if (this.jXU) {
            if (this.valid == 1 && this.jYl.size() > 0) {
                this.jYf = 0;
            } else {
                this.jYf = 2;
            }
        } else if (this.valid == 1 && this.jXY > 0) {
            this.jYf = 0;
        } else if (this.jXY + this.jXX > 0) {
            this.jYf = 2;
        } else if (this.jXY + this.jXX <= 0) {
            this.jYf = 3;
        }
    }
}
