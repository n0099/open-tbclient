package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private String content;
    private String dwA;
    private String dwB;
    private String dwC;
    private int dwD;
    private String dwE;
    private int dwF;
    private boolean dwG;
    private int dwH;
    private int dwI;
    private int dwJ;
    private int dwK;
    private String dwL;
    private String dwM;
    private String dwN;
    private String dwO;
    private int dwP;
    private String dwQ;
    private int dwR;
    private boolean dwS;
    private int dwT;
    private int dwU;
    private String dwy;
    private String dwz;
    private int dxa;
    private int level;
    private String title;
    private ArrayList<e> dwV = new ArrayList<>();
    private ArrayList<e> dwW = new ArrayList<>();
    private ArrayList<e> dwX = new ArrayList<>();
    private HashMap<String, e> dwY = new HashMap<>();
    private a dwZ = new a();
    private i dxb = new i();

    public boolean aBu() {
        return (this.dxb == null || StringUtils.isNull(this.dxb.dxv)) ? false : true;
    }

    public String Fa() {
        return this.dxb.UQ;
    }

    public String QV() {
        return this.dxb.dxv;
    }

    public int getLevel() {
        return this.level;
    }

    public String aBv() {
        return this.dwy;
    }

    public String aoj() {
        return this.dwz;
    }

    public String aBw() {
        return this.dwA;
    }

    public String aBx() {
        return this.dwB;
    }

    public String aBy() {
        return this.dwC;
    }

    public int aBz() {
        return this.dwD;
    }

    public String aBA() {
        return this.dwE;
    }

    public ArrayList<e> aBB() {
        return this.dwV;
    }

    public a aBC() {
        return this.dwZ;
    }

    public ArrayList<e> aBD() {
        return this.dwW;
    }

    public ArrayList<e> aBE() {
        return this.dwX;
    }

    public boolean aBF() {
        return this.dwG;
    }

    public String aBG() {
        return this.dwQ;
    }

    public String getContent() {
        return this.content;
    }

    public int aBH() {
        return this.dwR;
    }

    public boolean aBI() {
        return this.dwS;
    }

    public int aBJ() {
        return this.dwT;
    }

    public int aBK() {
        return this.dwU;
    }

    public void b(SignData signData) {
        e eVar;
        if (signData != null && (eVar = this.dwY.get(signData.getForumId())) != null) {
            eVar.mC(1);
            eVar.mD(signData.getCountSignNum());
            eVar.mE(signData.getBonusPoint());
            eVar.hh(true);
            eVar.hi(false);
            eVar.hj(false);
            a(eVar);
            aBL();
            hg(true);
        }
    }

    private void a(e eVar) {
        if (eVar.Sa() >= this.level) {
            this.dwJ++;
            this.dwK--;
        } else {
            this.dwH++;
            this.dwI--;
        }
        this.dwY.remove(String.valueOf(eVar.getForumId()));
        this.dwX.remove(eVar);
        if (eVar.aBO() + eVar.aBT() >= eVar.aBP()) {
            eVar.gO(eVar.Sa() + 1);
            eVar.hk(true);
            if (eVar.Sa() == this.level) {
                this.dwJ++;
                this.dwH--;
            }
        }
        this.dwW.add(eVar);
        TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aBT(), -1);
    }

    private void aBL() {
        if (this.dwG) {
            if (this.dwK + this.dwI <= 0) {
                this.dwS = true;
            } else {
                this.dwS = false;
            }
        } else if (this.dwK <= 0) {
            this.dwS = true;
        } else {
            this.dwS = false;
        }
    }

    public void a(u uVar) {
        this.dwT = 0;
        this.dwU = 0;
        ArrayList<v> aCb = uVar.aCb();
        int size = aCb.size();
        for (int i = 0; i < size; i++) {
            v vVar = aCb.get(i);
            e eVar = this.dwY.get(new StringBuilder(String.valueOf(vVar.getForumId())).toString());
            if (eVar != null) {
                if (vVar.getSigned() != 0) {
                    this.dwT++;
                    eVar.mC(1);
                    eVar.mD(vVar.aCe());
                    eVar.mE(vVar.getCurScore());
                    eVar.hh(true);
                    eVar.hi(false);
                    eVar.hj(false);
                    a(eVar);
                } else {
                    this.dwU++;
                    eVar.hh(false);
                    eVar.hi(true);
                    eVar.hj(false);
                    eVar.setErrorMsg(vVar.aBC().getUserMsg());
                }
            }
        }
        aBL();
        hg(true);
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.dwZ.parserJson(jSONObject.optJSONObject("error"));
            this.level = jSONObject.optInt("level", 7);
            this.title = jSONObject.optString("title");
            this.dwy = jSONObject.optString("text_pre");
            this.dwz = jSONObject.optString("text_color");
            this.dwA = jSONObject.optString("text_mid");
            this.dwB = jSONObject.optString("text_suf");
            this.dwC = jSONObject.optString("num_notice");
            this.dwD = jSONObject.optInt("show_dialog");
            this.dwE = jSONObject.optString("sign_notice");
            this.dwF = jSONObject.optInt("valid", 0);
            this.dxa = jSONObject.optInt("sign_max_num", 50);
            this.dwP = jSONObject.optInt("can_use", 0);
            this.content = jSONObject.optString(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT);
            this.dwQ = jSONObject.optString("button_content");
            if (this.dwP == 1) {
                this.dwG = true;
            } else {
                this.dwG = false;
            }
            this.dwM = String.valueOf(this.level) + this.title;
            this.dwL = "1-" + (this.level - 1) + TbadkApplication.getInst().getContext().getString(n.j.sign_all_forum_tip);
            ae.dyz = this.dxa;
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_info");
            if (optJSONArray != null) {
                int min = Math.min(optJSONArray.length(), ae.dyz);
                for (int i = 0; i < min; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        e eVar = new e();
                        eVar.parserJson(jSONObject2);
                        if (eVar.aBM() == 0) {
                            if (this.dwF == 0) {
                                if (this.dwG) {
                                    eVar.hi(true);
                                } else if (eVar.Sa() > this.level) {
                                    eVar.hi(true);
                                }
                            }
                            if (eVar.Sa() >= this.level) {
                                this.dwK++;
                            } else {
                                this.dwI++;
                            }
                            this.dwX.add(eVar);
                            this.dwY.put(new StringBuilder(String.valueOf(eVar.getForumId())).toString(), eVar);
                        } else {
                            if (eVar.Sa() >= this.level) {
                                this.dwJ++;
                            } else {
                                this.dwH++;
                            }
                            this.dwW.add(eVar);
                            TbadkApplication.getInst().addSignedForum(eVar.getForumName(), eVar.aBT(), -1);
                        }
                        this.dwV.add(eVar);
                        Collections.sort(this.dwV, new d(this));
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("advert");
            if (this.dxb == null) {
                this.dxb = new i();
            }
            this.dxb.parserJson(optJSONObject);
            hg(false);
        }
    }

    private void hg(boolean z) {
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<e> it = this.dwV.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next instanceof b) {
                    arrayList.add(next);
                }
            }
            this.dwV.removeAll(arrayList);
        }
        if (this.dwK + this.dwJ > 0) {
            if (this.dwJ > 0) {
                this.dwO = TbadkApplication.getInst().getContext().getString(n.j.signallforum_res, Integer.valueOf(this.dwJ), Integer.valueOf(this.dwK));
            } else {
                this.dwO = TbadkApplication.getInst().getContext().getString(n.j.signallforum_count, Integer.valueOf(this.dwK + this.dwJ));
            }
            if (this.dwV.size() > 0) {
                this.dwV.add(0, new b(this.dwM, this.dwO));
            }
        }
        if (this.dwI + this.dwH > 0) {
            if (this.dwH > 0) {
                this.dwN = TbadkApplication.getInst().getContext().getString(n.j.signallforum_res, Integer.valueOf(this.dwH), Integer.valueOf(this.dwI));
            } else {
                this.dwN = TbadkApplication.getInst().getContext().getString(n.j.signallforum_count, Integer.valueOf(this.dwI + this.dwH));
            }
            if (this.dwK + this.dwJ > 0) {
                if (this.dwV.size() > this.dwK + this.dwJ + 1) {
                    this.dwV.add(this.dwK + this.dwJ + 1, new b(this.dwL, this.dwN));
                }
            } else if (this.dwV.size() > 0) {
                this.dwV.add(0, new b(this.dwL, this.dwN));
            }
        }
        if (this.dwV.size() <= 0) {
            this.dwR = 3;
        } else if (this.dwG) {
            if (this.dwF == 1 && this.dwX.size() > 0) {
                this.dwR = 0;
            } else {
                this.dwR = 2;
            }
        } else if (this.dwF == 1 && this.dwK > 0) {
            this.dwR = 0;
        } else if (this.dwK + this.dwJ > 0) {
            this.dwR = 2;
        } else if (this.dwK + this.dwJ <= 0) {
            this.dwR = 3;
        }
    }
}
