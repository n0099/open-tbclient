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
    private int gTA;
    private int jjK = 0;
    private int jjL = 0;
    private ArrayList<ForumData> jjD = new ArrayList<>();
    private ArrayList<ForumData> jjE = new ArrayList<>();
    private ArrayList<ForumData> jjF = new ArrayList<>();
    private ArrayList<ForumData> jjG = new ArrayList<>();
    private ArrayList<ForumData> jjI = new ArrayList<>();
    private ArrayList<ForumData> jjH = new ArrayList<>();
    private ap page = new ap();
    private Date jjJ = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cvO() {
        return this.jjK;
    }

    public void zN(int i) {
        this.jjK = i;
    }

    public void zO(int i) {
        this.jjK += i;
    }

    public int cvP() {
        return this.jjL;
    }

    public void zP(int i) {
        this.jjL = i;
    }

    public void zQ(int i) {
        this.jjL += i;
    }

    public ArrayList<ForumData> cvQ() {
        return this.jjE;
    }

    public ArrayList<ForumData> cvR() {
        return this.jjF;
    }

    public ArrayList<ForumData> cvS() {
        return this.jjH;
    }

    public ArrayList<ForumData> cvT() {
        return this.jjI;
    }

    public ArrayList<ForumData> cvU() {
        return this.jjD;
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jjD == null) {
            this.jjD = new ArrayList<>();
        }
        if (this.jjE != null && arrayList != null) {
            this.jjE.clear();
            this.jjE.addAll(arrayList);
        }
        if (this.jjF != null && arrayList2 != null) {
            this.jjF.clear();
            this.jjF.addAll(arrayList2);
        }
        if (this.jjE != null || this.jjF != null) {
            this.jjD.clear();
            if (this.jjE != null) {
                this.jjD.addAll(this.jjE);
            }
            if (this.jjF != null) {
                this.jjD.addAll(this.jjF);
            }
        }
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jjD == null) {
            this.jjD = new ArrayList<>();
        }
        if (this.jjE != null && arrayList != null) {
            this.jjE.addAll(arrayList);
        }
        if (this.jjF != null && arrayList2 != null) {
            this.jjF.addAll(arrayList2);
        }
        if (this.jjE != null || this.jjF != null) {
            this.jjD.clear();
            if (this.jjE != null) {
                this.jjD.addAll(this.jjE);
            }
            if (this.jjF != null) {
                this.jjD.addAll(this.jjF);
            }
        }
    }

    public ArrayList<ForumData> cvV() {
        return this.jjG;
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jjG == null) {
            this.jjG = new ArrayList<>();
        }
        if (this.jjH != null && arrayList != null) {
            this.jjH.addAll(arrayList);
        }
        if (this.jjI != null && arrayList2 != null) {
            this.jjI.addAll(arrayList2);
        }
        if (this.jjH != null || this.jjI != null) {
            this.jjG.clear();
            if (this.jjH != null) {
                this.jjG.addAll(this.jjH);
            }
            if (this.jjI != null) {
                this.jjG.addAll(this.jjI);
            }
        }
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jjG == null) {
            this.jjG = new ArrayList<>();
        }
        if (this.jjH != null && arrayList != null) {
            this.jjH.clear();
            this.jjH.addAll(arrayList);
        }
        if (this.jjI != null && arrayList2 != null) {
            this.jjI.clear();
            this.jjI.addAll(arrayList2);
        }
        if (this.jjH != null || this.jjI != null) {
            this.jjG.clear();
            if (this.jjH != null) {
                this.jjG.addAll(this.jjH);
            }
            if (this.jjI != null) {
                this.jjG.addAll(this.jjI);
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
            this.gTA = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.jjJ = new Date(optLong);
            } else {
                this.jjJ = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.jjK = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.jjE.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.jjF.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.jjL = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.jjH.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.jjI.add(forumData4);
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
        return this.gTA == 1;
    }

    public void setHasMore(boolean z) {
        this.gTA = z ? 1 : 0;
    }
}
