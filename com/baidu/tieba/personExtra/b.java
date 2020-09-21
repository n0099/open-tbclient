package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class b {
    private int iKv;
    private int lqG = 0;
    private int lqH = 0;
    private ArrayList<ForumData> lqz = new ArrayList<>();
    private ArrayList<ForumData> lqA = new ArrayList<>();
    private ArrayList<ForumData> lqB = new ArrayList<>();
    private ArrayList<ForumData> lqC = new ArrayList<>();
    private ArrayList<ForumData> lqE = new ArrayList<>();
    private ArrayList<ForumData> lqD = new ArrayList<>();
    private av page = new av();
    private Date lqF = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int dkR() {
        return this.lqG;
    }

    public void FG(int i) {
        this.lqG = i;
    }

    public void FH(int i) {
        this.lqG += i;
    }

    public int dkS() {
        return this.lqH;
    }

    public void FI(int i) {
        this.lqH = i;
    }

    public void FJ(int i) {
        this.lqH += i;
    }

    public ArrayList<ForumData> dkT() {
        return this.lqA;
    }

    public ArrayList<ForumData> dkU() {
        return this.lqB;
    }

    public ArrayList<ForumData> dkV() {
        return this.lqD;
    }

    public ArrayList<ForumData> dkW() {
        return this.lqE;
    }

    public ArrayList<ForumData> dkX() {
        return this.lqz;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lqz == null) {
            this.lqz = new ArrayList<>();
        }
        if (this.lqA != null && arrayList != null) {
            this.lqA.clear();
            this.lqA.addAll(arrayList);
        }
        if (this.lqB != null && arrayList2 != null) {
            this.lqB.clear();
            this.lqB.addAll(arrayList2);
        }
        if (this.lqA != null || this.lqB != null) {
            this.lqz.clear();
            if (this.lqA != null) {
                this.lqz.addAll(this.lqA);
            }
            if (this.lqB != null) {
                this.lqz.addAll(this.lqB);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lqz == null) {
            this.lqz = new ArrayList<>();
        }
        if (this.lqA != null && arrayList != null) {
            this.lqA.addAll(arrayList);
        }
        if (this.lqB != null && arrayList2 != null) {
            this.lqB.addAll(arrayList2);
        }
        if (this.lqA != null || this.lqB != null) {
            this.lqz.clear();
            if (this.lqA != null) {
                this.lqz.addAll(this.lqA);
            }
            if (this.lqB != null) {
                this.lqz.addAll(this.lqB);
            }
        }
    }

    public ArrayList<ForumData> dkY() {
        return this.lqC;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lqC == null) {
            this.lqC = new ArrayList<>();
        }
        if (this.lqD != null && arrayList != null) {
            this.lqD.addAll(arrayList);
        }
        if (this.lqE != null && arrayList2 != null) {
            this.lqE.addAll(arrayList2);
        }
        if (this.lqD != null || this.lqE != null) {
            this.lqC.clear();
            if (this.lqD != null) {
                this.lqC.addAll(this.lqD);
            }
            if (this.lqE != null) {
                this.lqC.addAll(this.lqE);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lqC == null) {
            this.lqC = new ArrayList<>();
        }
        if (this.lqD != null && arrayList != null) {
            this.lqD.clear();
            this.lqD.addAll(arrayList);
        }
        if (this.lqE != null && arrayList2 != null) {
            this.lqE.clear();
            this.lqE.addAll(arrayList2);
        }
        if (this.lqD != null || this.lqE != null) {
            this.lqC.clear();
            if (this.lqD != null) {
                this.lqC.addAll(this.lqD);
            }
            if (this.lqE != null) {
                this.lqC.addAll(this.lqE);
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
            this.iKv = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.lqF = new Date(optLong);
            } else {
                this.lqF = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.lqG = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.lqA.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.lqB.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.lqH = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.lqD.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.lqE.add(forumData4);
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
        return this.iKv == 1;
    }

    public void setHasMore(boolean z) {
        this.iKv = z ? 1 : 0;
    }
}
