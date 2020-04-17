package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ap;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private int hEK;
    private int jVK = 0;
    private int jVL = 0;
    private ArrayList<ForumData> jVD = new ArrayList<>();
    private ArrayList<ForumData> jVE = new ArrayList<>();
    private ArrayList<ForumData> jVF = new ArrayList<>();
    private ArrayList<ForumData> jVG = new ArrayList<>();
    private ArrayList<ForumData> jVI = new ArrayList<>();
    private ArrayList<ForumData> jVH = new ArrayList<>();
    private ap page = new ap();
    private Date jVJ = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cGT() {
        return this.jVK;
    }

    public void Aw(int i) {
        this.jVK = i;
    }

    public void Ax(int i) {
        this.jVK += i;
    }

    public int cGU() {
        return this.jVL;
    }

    public void Ay(int i) {
        this.jVL = i;
    }

    public void Az(int i) {
        this.jVL += i;
    }

    public ArrayList<ForumData> cGV() {
        return this.jVE;
    }

    public ArrayList<ForumData> cGW() {
        return this.jVF;
    }

    public ArrayList<ForumData> cGX() {
        return this.jVH;
    }

    public ArrayList<ForumData> cGY() {
        return this.jVI;
    }

    public ArrayList<ForumData> cGZ() {
        return this.jVD;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jVD == null) {
            this.jVD = new ArrayList<>();
        }
        if (this.jVE != null && arrayList != null) {
            this.jVE.clear();
            this.jVE.addAll(arrayList);
        }
        if (this.jVF != null && arrayList2 != null) {
            this.jVF.clear();
            this.jVF.addAll(arrayList2);
        }
        if (this.jVE != null || this.jVF != null) {
            this.jVD.clear();
            if (this.jVE != null) {
                this.jVD.addAll(this.jVE);
            }
            if (this.jVF != null) {
                this.jVD.addAll(this.jVF);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jVD == null) {
            this.jVD = new ArrayList<>();
        }
        if (this.jVE != null && arrayList != null) {
            this.jVE.addAll(arrayList);
        }
        if (this.jVF != null && arrayList2 != null) {
            this.jVF.addAll(arrayList2);
        }
        if (this.jVE != null || this.jVF != null) {
            this.jVD.clear();
            if (this.jVE != null) {
                this.jVD.addAll(this.jVE);
            }
            if (this.jVF != null) {
                this.jVD.addAll(this.jVF);
            }
        }
    }

    public ArrayList<ForumData> cHa() {
        return this.jVG;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jVG == null) {
            this.jVG = new ArrayList<>();
        }
        if (this.jVH != null && arrayList != null) {
            this.jVH.addAll(arrayList);
        }
        if (this.jVI != null && arrayList2 != null) {
            this.jVI.addAll(arrayList2);
        }
        if (this.jVH != null || this.jVI != null) {
            this.jVG.clear();
            if (this.jVH != null) {
                this.jVG.addAll(this.jVH);
            }
            if (this.jVI != null) {
                this.jVG.addAll(this.jVI);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jVG == null) {
            this.jVG = new ArrayList<>();
        }
        if (this.jVH != null && arrayList != null) {
            this.jVH.clear();
            this.jVH.addAll(arrayList);
        }
        if (this.jVI != null && arrayList2 != null) {
            this.jVI.clear();
            this.jVI.addAll(arrayList2);
        }
        if (this.jVH != null || this.jVI != null) {
            this.jVG.clear();
            if (this.jVH != null) {
                this.jVG.addAll(this.jVH);
            }
            if (this.jVI != null) {
                this.jVG.addAll(this.jVI);
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
            this.hEK = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.jVJ = new Date(optLong);
            } else {
                this.jVJ = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.jVK = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.jVE.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.jVF.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.jVL = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.jVH.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.jVI.add(forumData4);
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
        return this.hEK == 1;
    }

    public void setHasMore(boolean z) {
        this.hEK = z ? 1 : 0;
    }
}
