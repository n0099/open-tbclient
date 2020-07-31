package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.au;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class b {
    private int gvX;
    private int kRM = 0;
    private int kRN = 0;
    private ArrayList<ForumData> kRF = new ArrayList<>();
    private ArrayList<ForumData> kRG = new ArrayList<>();
    private ArrayList<ForumData> kRH = new ArrayList<>();
    private ArrayList<ForumData> kRI = new ArrayList<>();
    private ArrayList<ForumData> kRK = new ArrayList<>();
    private ArrayList<ForumData> kRJ = new ArrayList<>();
    private au page = new au();
    private Date kRL = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cWo() {
        return this.kRM;
    }

    public void CL(int i) {
        this.kRM = i;
    }

    public void CM(int i) {
        this.kRM += i;
    }

    public int cWp() {
        return this.kRN;
    }

    public void CN(int i) {
        this.kRN = i;
    }

    public void CO(int i) {
        this.kRN += i;
    }

    public ArrayList<ForumData> cWq() {
        return this.kRG;
    }

    public ArrayList<ForumData> cWr() {
        return this.kRH;
    }

    public ArrayList<ForumData> cWs() {
        return this.kRJ;
    }

    public ArrayList<ForumData> cWt() {
        return this.kRK;
    }

    public ArrayList<ForumData> cWu() {
        return this.kRF;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.kRF == null) {
            this.kRF = new ArrayList<>();
        }
        if (this.kRG != null && arrayList != null) {
            this.kRG.clear();
            this.kRG.addAll(arrayList);
        }
        if (this.kRH != null && arrayList2 != null) {
            this.kRH.clear();
            this.kRH.addAll(arrayList2);
        }
        if (this.kRG != null || this.kRH != null) {
            this.kRF.clear();
            if (this.kRG != null) {
                this.kRF.addAll(this.kRG);
            }
            if (this.kRH != null) {
                this.kRF.addAll(this.kRH);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.kRF == null) {
            this.kRF = new ArrayList<>();
        }
        if (this.kRG != null && arrayList != null) {
            this.kRG.addAll(arrayList);
        }
        if (this.kRH != null && arrayList2 != null) {
            this.kRH.addAll(arrayList2);
        }
        if (this.kRG != null || this.kRH != null) {
            this.kRF.clear();
            if (this.kRG != null) {
                this.kRF.addAll(this.kRG);
            }
            if (this.kRH != null) {
                this.kRF.addAll(this.kRH);
            }
        }
    }

    public ArrayList<ForumData> cWv() {
        return this.kRI;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.kRI == null) {
            this.kRI = new ArrayList<>();
        }
        if (this.kRJ != null && arrayList != null) {
            this.kRJ.addAll(arrayList);
        }
        if (this.kRK != null && arrayList2 != null) {
            this.kRK.addAll(arrayList2);
        }
        if (this.kRJ != null || this.kRK != null) {
            this.kRI.clear();
            if (this.kRJ != null) {
                this.kRI.addAll(this.kRJ);
            }
            if (this.kRK != null) {
                this.kRI.addAll(this.kRK);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.kRI == null) {
            this.kRI = new ArrayList<>();
        }
        if (this.kRJ != null && arrayList != null) {
            this.kRJ.clear();
            this.kRJ.addAll(arrayList);
        }
        if (this.kRK != null && arrayList2 != null) {
            this.kRK.clear();
            this.kRK.addAll(arrayList2);
        }
        if (this.kRJ != null || this.kRK != null) {
            this.kRI.clear();
            if (this.kRJ != null) {
                this.kRI.addAll(this.kRJ);
            }
            if (this.kRK != null) {
                this.kRI.addAll(this.kRK);
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
            this.gvX = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.kRL = new Date(optLong);
            } else {
                this.kRL = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.kRM = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.kRG.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.kRH.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.kRN = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.kRJ.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.kRK.add(forumData4);
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
        return this.gvX == 1;
    }

    public void setHasMore(boolean z) {
        this.gvX = z ? 1 : 0;
    }
}
