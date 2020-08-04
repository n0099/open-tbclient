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
    private int kRO = 0;
    private int kRP = 0;
    private ArrayList<ForumData> kRH = new ArrayList<>();
    private ArrayList<ForumData> kRI = new ArrayList<>();
    private ArrayList<ForumData> kRJ = new ArrayList<>();
    private ArrayList<ForumData> kRK = new ArrayList<>();
    private ArrayList<ForumData> kRM = new ArrayList<>();
    private ArrayList<ForumData> kRL = new ArrayList<>();
    private au page = new au();
    private Date kRN = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cWo() {
        return this.kRO;
    }

    public void CL(int i) {
        this.kRO = i;
    }

    public void CM(int i) {
        this.kRO += i;
    }

    public int cWp() {
        return this.kRP;
    }

    public void CN(int i) {
        this.kRP = i;
    }

    public void CO(int i) {
        this.kRP += i;
    }

    public ArrayList<ForumData> cWq() {
        return this.kRI;
    }

    public ArrayList<ForumData> cWr() {
        return this.kRJ;
    }

    public ArrayList<ForumData> cWs() {
        return this.kRL;
    }

    public ArrayList<ForumData> cWt() {
        return this.kRM;
    }

    public ArrayList<ForumData> cWu() {
        return this.kRH;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.kRH == null) {
            this.kRH = new ArrayList<>();
        }
        if (this.kRI != null && arrayList != null) {
            this.kRI.clear();
            this.kRI.addAll(arrayList);
        }
        if (this.kRJ != null && arrayList2 != null) {
            this.kRJ.clear();
            this.kRJ.addAll(arrayList2);
        }
        if (this.kRI != null || this.kRJ != null) {
            this.kRH.clear();
            if (this.kRI != null) {
                this.kRH.addAll(this.kRI);
            }
            if (this.kRJ != null) {
                this.kRH.addAll(this.kRJ);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.kRH == null) {
            this.kRH = new ArrayList<>();
        }
        if (this.kRI != null && arrayList != null) {
            this.kRI.addAll(arrayList);
        }
        if (this.kRJ != null && arrayList2 != null) {
            this.kRJ.addAll(arrayList2);
        }
        if (this.kRI != null || this.kRJ != null) {
            this.kRH.clear();
            if (this.kRI != null) {
                this.kRH.addAll(this.kRI);
            }
            if (this.kRJ != null) {
                this.kRH.addAll(this.kRJ);
            }
        }
    }

    public ArrayList<ForumData> cWv() {
        return this.kRK;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.kRK == null) {
            this.kRK = new ArrayList<>();
        }
        if (this.kRL != null && arrayList != null) {
            this.kRL.addAll(arrayList);
        }
        if (this.kRM != null && arrayList2 != null) {
            this.kRM.addAll(arrayList2);
        }
        if (this.kRL != null || this.kRM != null) {
            this.kRK.clear();
            if (this.kRL != null) {
                this.kRK.addAll(this.kRL);
            }
            if (this.kRM != null) {
                this.kRK.addAll(this.kRM);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.kRK == null) {
            this.kRK = new ArrayList<>();
        }
        if (this.kRL != null && arrayList != null) {
            this.kRL.clear();
            this.kRL.addAll(arrayList);
        }
        if (this.kRM != null && arrayList2 != null) {
            this.kRM.clear();
            this.kRM.addAll(arrayList2);
        }
        if (this.kRL != null || this.kRM != null) {
            this.kRK.clear();
            if (this.kRL != null) {
                this.kRK.addAll(this.kRL);
            }
            if (this.kRM != null) {
                this.kRK.addAll(this.kRM);
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
                this.kRN = new Date(optLong);
            } else {
                this.kRN = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.kRO = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.kRI.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.kRJ.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.kRP = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.kRL.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.kRM.add(forumData4);
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
