package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class b {
    private int iZn;
    private int lFT = 0;
    private int lFU = 0;
    private ArrayList<ForumData> lFM = new ArrayList<>();
    private ArrayList<ForumData> lFN = new ArrayList<>();
    private ArrayList<ForumData> lFO = new ArrayList<>();
    private ArrayList<ForumData> lFP = new ArrayList<>();
    private ArrayList<ForumData> lFR = new ArrayList<>();
    private ArrayList<ForumData> lFQ = new ArrayList<>();
    private av page = new av();
    private Date lFS = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int doB() {
        return this.lFT;
    }

    public void Gm(int i) {
        this.lFT = i;
    }

    public void Gn(int i) {
        this.lFT += i;
    }

    public int doC() {
        return this.lFU;
    }

    public void Go(int i) {
        this.lFU = i;
    }

    public void Gp(int i) {
        this.lFU += i;
    }

    public ArrayList<ForumData> doD() {
        return this.lFN;
    }

    public ArrayList<ForumData> doE() {
        return this.lFO;
    }

    public ArrayList<ForumData> doF() {
        return this.lFQ;
    }

    public ArrayList<ForumData> doG() {
        return this.lFR;
    }

    public ArrayList<ForumData> doH() {
        return this.lFM;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lFM == null) {
            this.lFM = new ArrayList<>();
        }
        if (this.lFN != null && arrayList != null) {
            this.lFN.clear();
            this.lFN.addAll(arrayList);
        }
        if (this.lFO != null && arrayList2 != null) {
            this.lFO.clear();
            this.lFO.addAll(arrayList2);
        }
        if (this.lFN != null || this.lFO != null) {
            this.lFM.clear();
            if (this.lFN != null) {
                this.lFM.addAll(this.lFN);
            }
            if (this.lFO != null) {
                this.lFM.addAll(this.lFO);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lFM == null) {
            this.lFM = new ArrayList<>();
        }
        if (this.lFN != null && arrayList != null) {
            this.lFN.addAll(arrayList);
        }
        if (this.lFO != null && arrayList2 != null) {
            this.lFO.addAll(arrayList2);
        }
        if (this.lFN != null || this.lFO != null) {
            this.lFM.clear();
            if (this.lFN != null) {
                this.lFM.addAll(this.lFN);
            }
            if (this.lFO != null) {
                this.lFM.addAll(this.lFO);
            }
        }
    }

    public ArrayList<ForumData> doI() {
        return this.lFP;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lFP == null) {
            this.lFP = new ArrayList<>();
        }
        if (this.lFQ != null && arrayList != null) {
            this.lFQ.addAll(arrayList);
        }
        if (this.lFR != null && arrayList2 != null) {
            this.lFR.addAll(arrayList2);
        }
        if (this.lFQ != null || this.lFR != null) {
            this.lFP.clear();
            if (this.lFQ != null) {
                this.lFP.addAll(this.lFQ);
            }
            if (this.lFR != null) {
                this.lFP.addAll(this.lFR);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lFP == null) {
            this.lFP = new ArrayList<>();
        }
        if (this.lFQ != null && arrayList != null) {
            this.lFQ.clear();
            this.lFQ.addAll(arrayList);
        }
        if (this.lFR != null && arrayList2 != null) {
            this.lFR.clear();
            this.lFR.addAll(arrayList2);
        }
        if (this.lFQ != null || this.lFR != null) {
            this.lFP.clear();
            if (this.lFQ != null) {
                this.lFP.addAll(this.lFQ);
            }
            if (this.lFR != null) {
                this.lFP.addAll(this.lFR);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.isSucc = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.page.parserJson(jSONObject.optJSONObject("page"));
            this.iZn = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.lFS = new Date(optLong);
            } else {
                this.lFS = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.lFT = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.lFN.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.lFO.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.lFU = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.lFQ.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.lFR.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.isSucc = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.iZn == 1;
    }

    public void setHasMore(boolean z) {
        this.iZn = z ? 1 : 0;
    }
}
