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
    private int gTy;
    private int jjI = 0;
    private int jjJ = 0;
    private ArrayList<ForumData> jjB = new ArrayList<>();
    private ArrayList<ForumData> jjC = new ArrayList<>();
    private ArrayList<ForumData> jjD = new ArrayList<>();
    private ArrayList<ForumData> jjE = new ArrayList<>();
    private ArrayList<ForumData> jjG = new ArrayList<>();
    private ArrayList<ForumData> jjF = new ArrayList<>();
    private ap page = new ap();
    private Date jjH = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cvM() {
        return this.jjI;
    }

    public void zN(int i) {
        this.jjI = i;
    }

    public void zO(int i) {
        this.jjI += i;
    }

    public int cvN() {
        return this.jjJ;
    }

    public void zP(int i) {
        this.jjJ = i;
    }

    public void zQ(int i) {
        this.jjJ += i;
    }

    public ArrayList<ForumData> cvO() {
        return this.jjC;
    }

    public ArrayList<ForumData> cvP() {
        return this.jjD;
    }

    public ArrayList<ForumData> cvQ() {
        return this.jjF;
    }

    public ArrayList<ForumData> cvR() {
        return this.jjG;
    }

    public ArrayList<ForumData> cvS() {
        return this.jjB;
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jjB == null) {
            this.jjB = new ArrayList<>();
        }
        if (this.jjC != null && arrayList != null) {
            this.jjC.clear();
            this.jjC.addAll(arrayList);
        }
        if (this.jjD != null && arrayList2 != null) {
            this.jjD.clear();
            this.jjD.addAll(arrayList2);
        }
        if (this.jjC != null || this.jjD != null) {
            this.jjB.clear();
            if (this.jjC != null) {
                this.jjB.addAll(this.jjC);
            }
            if (this.jjD != null) {
                this.jjB.addAll(this.jjD);
            }
        }
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jjB == null) {
            this.jjB = new ArrayList<>();
        }
        if (this.jjC != null && arrayList != null) {
            this.jjC.addAll(arrayList);
        }
        if (this.jjD != null && arrayList2 != null) {
            this.jjD.addAll(arrayList2);
        }
        if (this.jjC != null || this.jjD != null) {
            this.jjB.clear();
            if (this.jjC != null) {
                this.jjB.addAll(this.jjC);
            }
            if (this.jjD != null) {
                this.jjB.addAll(this.jjD);
            }
        }
    }

    public ArrayList<ForumData> cvT() {
        return this.jjE;
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jjE == null) {
            this.jjE = new ArrayList<>();
        }
        if (this.jjF != null && arrayList != null) {
            this.jjF.addAll(arrayList);
        }
        if (this.jjG != null && arrayList2 != null) {
            this.jjG.addAll(arrayList2);
        }
        if (this.jjF != null || this.jjG != null) {
            this.jjE.clear();
            if (this.jjF != null) {
                this.jjE.addAll(this.jjF);
            }
            if (this.jjG != null) {
                this.jjE.addAll(this.jjG);
            }
        }
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jjE == null) {
            this.jjE = new ArrayList<>();
        }
        if (this.jjF != null && arrayList != null) {
            this.jjF.clear();
            this.jjF.addAll(arrayList);
        }
        if (this.jjG != null && arrayList2 != null) {
            this.jjG.clear();
            this.jjG.addAll(arrayList2);
        }
        if (this.jjF != null || this.jjG != null) {
            this.jjE.clear();
            if (this.jjF != null) {
                this.jjE.addAll(this.jjF);
            }
            if (this.jjG != null) {
                this.jjE.addAll(this.jjG);
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
            this.gTy = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.jjH = new Date(optLong);
            } else {
                this.jjH = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.jjI = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.jjC.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.jjD.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.jjJ = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.jjF.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.jjG.add(forumData4);
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
        return this.gTy == 1;
    }

    public void setHasMore(boolean z) {
        this.gTy = z ? 1 : 0;
    }
}
