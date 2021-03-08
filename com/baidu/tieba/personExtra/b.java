package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.az;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private int jYt;
    private int myJ = 0;
    private int myK = 0;
    private ArrayList<ForumData> myC = new ArrayList<>();
    private ArrayList<ForumData> myD = new ArrayList<>();
    private ArrayList<ForumData> myE = new ArrayList<>();
    private ArrayList<ForumData> myF = new ArrayList<>();
    private ArrayList<ForumData> myH = new ArrayList<>();
    private ArrayList<ForumData> myG = new ArrayList<>();
    private az page = new az();
    private Date myI = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int dxA() {
        return this.myJ;
    }

    public void GP(int i) {
        this.myJ = i;
    }

    public void GQ(int i) {
        this.myJ += i;
    }

    public int dxB() {
        return this.myK;
    }

    public void GR(int i) {
        this.myK = i;
    }

    public void GS(int i) {
        this.myK += i;
    }

    public ArrayList<ForumData> dxC() {
        return this.myD;
    }

    public ArrayList<ForumData> dxD() {
        return this.myE;
    }

    public ArrayList<ForumData> dxE() {
        return this.myG;
    }

    public ArrayList<ForumData> dxF() {
        return this.myH;
    }

    public ArrayList<ForumData> dxG() {
        return this.myC;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.myC == null) {
            this.myC = new ArrayList<>();
        }
        if (this.myD != null && arrayList != null) {
            this.myD.clear();
            this.myD.addAll(arrayList);
        }
        if (this.myE != null && arrayList2 != null) {
            this.myE.clear();
            this.myE.addAll(arrayList2);
        }
        if (this.myD != null || this.myE != null) {
            this.myC.clear();
            if (this.myD != null) {
                this.myC.addAll(this.myD);
            }
            if (this.myE != null) {
                this.myC.addAll(this.myE);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.myC == null) {
            this.myC = new ArrayList<>();
        }
        if (this.myD != null && arrayList != null) {
            this.myD.addAll(arrayList);
        }
        if (this.myE != null && arrayList2 != null) {
            this.myE.addAll(arrayList2);
        }
        if (this.myD != null || this.myE != null) {
            this.myC.clear();
            if (this.myD != null) {
                this.myC.addAll(this.myD);
            }
            if (this.myE != null) {
                this.myC.addAll(this.myE);
            }
        }
    }

    public ArrayList<ForumData> dxH() {
        return this.myF;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.myF == null) {
            this.myF = new ArrayList<>();
        }
        if (this.myG != null && arrayList != null) {
            this.myG.addAll(arrayList);
        }
        if (this.myH != null && arrayList2 != null) {
            this.myH.addAll(arrayList2);
        }
        if (this.myG != null || this.myH != null) {
            this.myF.clear();
            if (this.myG != null) {
                this.myF.addAll(this.myG);
            }
            if (this.myH != null) {
                this.myF.addAll(this.myH);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.myF == null) {
            this.myF = new ArrayList<>();
        }
        if (this.myG != null && arrayList != null) {
            this.myG.clear();
            this.myG.addAll(arrayList);
        }
        if (this.myH != null && arrayList2 != null) {
            this.myH.clear();
            this.myH.addAll(arrayList2);
        }
        if (this.myG != null || this.myH != null) {
            this.myF.clear();
            if (this.myG != null) {
                this.myF.addAll(this.myG);
            }
            if (this.myH != null) {
                this.myF.addAll(this.myH);
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
            this.jYt = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.myI = new Date(optLong);
            } else {
                this.myI = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.myJ = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.myD.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.myE.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.myK = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.myG.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.myH.add(forumData4);
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
        return this.jYt == 1;
    }

    public void setHasMore(boolean z) {
        this.jYt = z ? 1 : 0;
    }
}
