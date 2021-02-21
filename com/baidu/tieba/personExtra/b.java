package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.az;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private int jWr;
    private int mwH = 0;
    private int mwI = 0;
    private ArrayList<ForumData> mwA = new ArrayList<>();
    private ArrayList<ForumData> mwB = new ArrayList<>();
    private ArrayList<ForumData> mwC = new ArrayList<>();
    private ArrayList<ForumData> mwD = new ArrayList<>();
    private ArrayList<ForumData> mwF = new ArrayList<>();
    private ArrayList<ForumData> mwE = new ArrayList<>();
    private az page = new az();
    private Date mwG = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int dxr() {
        return this.mwH;
    }

    public void GM(int i) {
        this.mwH = i;
    }

    public void GN(int i) {
        this.mwH += i;
    }

    public int dxs() {
        return this.mwI;
    }

    public void GO(int i) {
        this.mwI = i;
    }

    public void GP(int i) {
        this.mwI += i;
    }

    public ArrayList<ForumData> dxt() {
        return this.mwB;
    }

    public ArrayList<ForumData> dxu() {
        return this.mwC;
    }

    public ArrayList<ForumData> dxv() {
        return this.mwE;
    }

    public ArrayList<ForumData> dxw() {
        return this.mwF;
    }

    public ArrayList<ForumData> dxx() {
        return this.mwA;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mwA == null) {
            this.mwA = new ArrayList<>();
        }
        if (this.mwB != null && arrayList != null) {
            this.mwB.clear();
            this.mwB.addAll(arrayList);
        }
        if (this.mwC != null && arrayList2 != null) {
            this.mwC.clear();
            this.mwC.addAll(arrayList2);
        }
        if (this.mwB != null || this.mwC != null) {
            this.mwA.clear();
            if (this.mwB != null) {
                this.mwA.addAll(this.mwB);
            }
            if (this.mwC != null) {
                this.mwA.addAll(this.mwC);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mwA == null) {
            this.mwA = new ArrayList<>();
        }
        if (this.mwB != null && arrayList != null) {
            this.mwB.addAll(arrayList);
        }
        if (this.mwC != null && arrayList2 != null) {
            this.mwC.addAll(arrayList2);
        }
        if (this.mwB != null || this.mwC != null) {
            this.mwA.clear();
            if (this.mwB != null) {
                this.mwA.addAll(this.mwB);
            }
            if (this.mwC != null) {
                this.mwA.addAll(this.mwC);
            }
        }
    }

    public ArrayList<ForumData> dxy() {
        return this.mwD;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mwD == null) {
            this.mwD = new ArrayList<>();
        }
        if (this.mwE != null && arrayList != null) {
            this.mwE.addAll(arrayList);
        }
        if (this.mwF != null && arrayList2 != null) {
            this.mwF.addAll(arrayList2);
        }
        if (this.mwE != null || this.mwF != null) {
            this.mwD.clear();
            if (this.mwE != null) {
                this.mwD.addAll(this.mwE);
            }
            if (this.mwF != null) {
                this.mwD.addAll(this.mwF);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mwD == null) {
            this.mwD = new ArrayList<>();
        }
        if (this.mwE != null && arrayList != null) {
            this.mwE.clear();
            this.mwE.addAll(arrayList);
        }
        if (this.mwF != null && arrayList2 != null) {
            this.mwF.clear();
            this.mwF.addAll(arrayList2);
        }
        if (this.mwE != null || this.mwF != null) {
            this.mwD.clear();
            if (this.mwE != null) {
                this.mwD.addAll(this.mwE);
            }
            if (this.mwF != null) {
                this.mwD.addAll(this.mwF);
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
            this.jWr = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.mwG = new Date(optLong);
            } else {
                this.mwG = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.mwH = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.mwB.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.mwC.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.mwI = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.mwE.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.mwF.add(forumData4);
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
        return this.jWr == 1;
    }

    public void setHasMore(boolean z) {
        this.jWr = z ? 1 : 0;
    }
}
