package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
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
/* loaded from: classes18.dex */
public class c {
    private String aJi;
    private BlockPopInfoData blockPopInfoData;
    private String content;
    private String lVA;
    private String lVB;
    private String lVC;
    private String lVD;
    private int lVE;
    private String lVF;
    private int lVG;
    private boolean lVH;
    private int lVI;
    private int lVJ;
    private int lVP;
    private String lVp;
    private String lVq;
    private String lVr;
    private String lVs;
    private int lVt;
    private String lVu;
    private boolean lVv;
    private int lVw;
    private int lVx;
    private int lVy;
    private int lVz;
    private int level;
    private String title;
    private int valid;
    private String lVo = "0";
    private ArrayList<d> lVK = new ArrayList<>();
    private ArrayList<d> lVL = new ArrayList<>();
    private ArrayList<d> lVM = new ArrayList<>();
    private HashMap<String, d> lVN = new HashMap<>();
    private a lVO = new a();
    private f lVQ = new f();
    private k lVR = new k();

    public boolean dtC() {
        return (this.lVQ == null || StringUtils.isNull(this.lVQ.lWj)) ? false : true;
    }

    public String bvb() {
        return this.lVQ.dWl;
    }

    public String dtD() {
        return this.lVQ.lWj;
    }

    public String dtE() {
        return this.lVR.lXH;
    }

    public String dtF() {
        return this.lVR.link;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean dtG() {
        return !StringUtils.isNull(this.lVo) && this.lVo.equals("1");
    }

    public String dtH() {
        return this.lVp;
    }

    public String ddv() {
        return this.aJi;
    }

    public String dtI() {
        return this.lVq;
    }

    public String dtJ() {
        return this.lVr;
    }

    public String dtK() {
        return this.lVs;
    }

    public int dtL() {
        return this.lVt;
    }

    public String dtM() {
        return this.lVu;
    }

    public ArrayList<d> dtN() {
        return this.lVK;
    }

    public a dtO() {
        return this.lVO;
    }

    public ArrayList<d> dtP() {
        return this.lVL;
    }

    public ArrayList<d> dtQ() {
        return this.lVM;
    }

    public boolean dtR() {
        return this.lVv;
    }

    public String dtS() {
        return this.lVF;
    }

    public String getContent() {
        return this.content;
    }

    public int dtT() {
        return this.lVG;
    }

    public boolean dtU() {
        return this.lVH;
    }

    public int dtV() {
        return this.lVI;
    }

    public int dtW() {
        return this.lVJ;
    }

    public BlockPopInfoData getBlockPopInfoData() {
        return this.blockPopInfoData;
    }

    public void b(SignData signData) {
        d dVar;
        if (signData != null && (dVar = this.lVN.get(signData.forumId)) != null) {
            dVar.Ht(1);
            dVar.Hu(signData.count_sign_num);
            dVar.Hw(signData.sign_bonus_point);
            dVar.vO(true);
            dVar.vP(false);
            dVar.vQ(false);
            a(dVar);
            dtX();
            vN(true);
        }
    }

    private void a(d dVar) {
        if (dVar.dua() >= this.level) {
            this.lVy++;
            this.lVz--;
        } else {
            this.lVw++;
            this.lVx--;
        }
        this.lVN.remove(String.valueOf(dVar.getForumId()));
        this.lVM.remove(dVar);
        if (dVar.dub() + dVar.duf() >= dVar.duc()) {
            dVar.Hv(dVar.dua() + 1);
            dVar.vR(true);
            if (dVar.dua() == this.level) {
                this.lVy++;
                this.lVw--;
            }
        }
        this.lVL.add(dVar);
        TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.duf(), -1);
    }

    private void dtX() {
        if (this.lVv) {
            if (this.lVz + this.lVx <= 0) {
                this.lVH = true;
            } else {
                this.lVH = false;
            }
        } else if (this.lVz <= 0) {
            this.lVH = true;
        } else {
            this.lVH = false;
        }
    }

    public void a(h hVar) {
        this.lVI = 0;
        this.lVJ = 0;
        ArrayList<i> dup = hVar.dup();
        int size = dup.size();
        for (int i = 0; i < size; i++) {
            i iVar = dup.get(i);
            d dVar = this.lVN.get(iVar.getForumId() + "");
            if (dVar != null) {
                if (iVar.dus() != 0) {
                    this.lVI++;
                    dVar.Ht(1);
                    dVar.Hu(iVar.dut());
                    dVar.Hw(iVar.getCurScore());
                    dVar.vO(true);
                    dVar.vP(false);
                    dVar.vQ(false);
                    a(dVar);
                } else {
                    this.lVJ++;
                    dVar.vO(false);
                    dVar.vP(true);
                    dVar.vQ(false);
                    dVar.setErrorMsg(iVar.dtO().getUserMsg());
                }
            }
        }
        dtX();
        vN(true);
    }

    public void parserJson(JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.lVO.parserJson(jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR));
            this.level = jSONObject.optInt("level", 7);
            this.lVo = jSONObject.optString("sign_new");
            this.title = jSONObject.optString("title");
            this.lVp = jSONObject.optString("text_pre");
            this.aJi = jSONObject.optString("text_color");
            this.lVq = jSONObject.optString("text_mid");
            this.lVr = jSONObject.optString("text_suf");
            this.lVs = jSONObject.optString("num_notice");
            this.lVt = jSONObject.optInt("show_dialog");
            this.lVu = jSONObject.optString("sign_notice");
            this.valid = jSONObject.optInt(CloudControlUBCUtils.KEY_VALID, 0);
            this.lVP = jSONObject.optInt("sign_max_num", 50);
            this.lVE = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString("content");
            this.lVF = jSONObject.optString("button_content");
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
            if (this.lVE == 1) {
                this.lVv = true;
            } else {
                this.lVv = false;
            }
            this.lVB = this.level + this.title;
            this.lVA = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(R.string.sign_all_forum_tip);
            j.lXx = this.lVP;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), j.lXx);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        d dVar = new d();
                        dVar.parserJson(jSONObject2);
                        if (dVar.dtY() == 0) {
                            if (this.valid == 0) {
                                if (this.lVv) {
                                    dVar.vP(true);
                                } else if (dVar.dua() > this.level) {
                                    dVar.vP(true);
                                }
                            }
                            if (dVar.dua() >= this.level) {
                                this.lVz++;
                            } else {
                                this.lVx++;
                            }
                            this.lVM.add(dVar);
                            this.lVN.put(dVar.getForumId() + "", dVar);
                        } else {
                            if (dVar.dua() >= this.level) {
                                this.lVy++;
                            } else {
                                this.lVw++;
                            }
                            this.lVL.add(dVar);
                            TbadkApplication.getInst().addSignedForum(dVar.getForumName(), dVar.duf(), -1);
                        }
                        this.lVK.add(dVar);
                        Collections.sort(this.lVK, new Comparator<d>() { // from class: com.baidu.tieba.signall.c.1
                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // java.util.Comparator
                            /* renamed from: a */
                            public int compare(d dVar2, d dVar3) {
                                return dVar3.dua() - dVar2.dua();
                            }
                        });
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("advert");
            if (this.lVQ == null) {
                this.lVQ = new f();
            }
            this.lVQ.parserJson(optJSONObject2);
            JSONObject optJSONObject3 = jSONObject.optJSONObject("wefan");
            if (this.lVR == null) {
                this.lVR = new k();
            }
            this.lVR.parserJson(optJSONObject3);
            vN(false);
        }
    }

    private void vN(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<d> it = this.lVK.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.lVK.removeAll(arrayList);
        }
        if (this.lVz + this.lVy > 0) {
            if (this.lVy > 0) {
                this.lVD = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lVy), Integer.valueOf(this.lVz));
            } else {
                this.lVD = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lVz + this.lVy));
            }
            if (this.lVK.size() > 0) {
                this.lVK.add(0, new b(this.lVB, this.lVD));
            }
        }
        if (this.lVx + this.lVw > 0) {
            if (this.lVw > 0) {
                this.lVC = TbadkApplication.getInst().getContext().getString(R.string.signallforum_res, Integer.valueOf(this.lVw), Integer.valueOf(this.lVx));
            } else {
                this.lVC = TbadkApplication.getInst().getContext().getString(R.string.signallforum_count, Integer.valueOf(this.lVx + this.lVw));
            }
            if (this.lVz + this.lVy > 0) {
                if (this.lVK.size() > this.lVz + this.lVy + 1) {
                    this.lVK.add(this.lVz + this.lVy + 1, new b(this.lVA, this.lVC));
                }
            } else if (this.lVK.size() > 0) {
                this.lVK.add(0, new b(this.lVA, this.lVC));
            }
        }
        if (this.lVK.size() <= 0) {
            this.lVG = 3;
        } else if (this.lVv) {
            if (this.valid == 1 && this.lVM.size() > 0) {
                this.lVG = 0;
            } else {
                this.lVG = 2;
            }
        } else if (this.valid == 1 && this.lVz > 0) {
            this.lVG = 0;
        } else if (this.lVz + this.lVy > 0) {
            this.lVG = 2;
        } else if (this.lVz + this.lVy <= 0) {
            this.lVG = 3;
        }
    }
}
