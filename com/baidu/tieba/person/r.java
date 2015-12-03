package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private int hasMore;
    private int cJO = 0;
    private int cJP = 0;
    private ArrayList<ForumData> cJH = new ArrayList<>();
    private ArrayList<ForumData> cJI = new ArrayList<>();
    private ArrayList<ForumData> cJJ = new ArrayList<>();
    private ArrayList<ForumData> cJK = new ArrayList<>();
    private ArrayList<ForumData> cJM = new ArrayList<>();
    private ArrayList<ForumData> cJL = new ArrayList<>();
    private com.baidu.tbadk.core.data.q ceI = new com.baidu.tbadk.core.data.q();
    private Date cJN = null;
    private boolean Cq = true;

    public r() {
        setHasMore(false);
    }

    public int anp() {
        return this.cJO;
    }

    public void ki(int i) {
        this.cJO = i;
    }

    public void kj(int i) {
        this.cJO += i;
    }

    public int anq() {
        return this.cJP;
    }

    public void kk(int i) {
        this.cJP = i;
    }

    public void kl(int i) {
        this.cJP += i;
    }

    public ArrayList<ForumData> anr() {
        return this.cJI;
    }

    public ArrayList<ForumData> ans() {
        return this.cJJ;
    }

    public ArrayList<ForumData> ant() {
        return this.cJL;
    }

    public ArrayList<ForumData> anu() {
        return this.cJM;
    }

    public ArrayList<ForumData> anv() {
        return this.cJH;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cJH == null) {
            this.cJH = new ArrayList<>();
        }
        if (this.cJI != null && arrayList != null) {
            this.cJI.clear();
            this.cJI.addAll(arrayList);
        }
        if (this.cJJ != null && arrayList2 != null) {
            this.cJJ.clear();
            this.cJJ.addAll(arrayList2);
        }
        if (this.cJI != null || this.cJJ != null) {
            this.cJH.clear();
            if (this.cJI != null) {
                this.cJH.addAll(this.cJI);
            }
            if (this.cJJ != null) {
                this.cJH.addAll(this.cJJ);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cJH == null) {
            this.cJH = new ArrayList<>();
        }
        if (this.cJI != null && arrayList != null) {
            this.cJI.addAll(arrayList);
        }
        if (this.cJJ != null && arrayList2 != null) {
            this.cJJ.addAll(arrayList2);
        }
        if (this.cJI != null || this.cJJ != null) {
            this.cJH.clear();
            if (this.cJI != null) {
                this.cJH.addAll(this.cJI);
            }
            if (this.cJJ != null) {
                this.cJH.addAll(this.cJJ);
            }
        }
    }

    public ArrayList<ForumData> anw() {
        return this.cJK;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cJK == null) {
            this.cJK = new ArrayList<>();
        }
        if (this.cJL != null && arrayList != null) {
            this.cJL.addAll(arrayList);
        }
        if (this.cJM != null && arrayList2 != null) {
            this.cJM.addAll(arrayList2);
        }
        if (this.cJL != null || this.cJM != null) {
            this.cJK.clear();
            if (this.cJL != null) {
                this.cJK.addAll(this.cJL);
            }
            if (this.cJM != null) {
                this.cJK.addAll(this.cJM);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cJK == null) {
            this.cJK = new ArrayList<>();
        }
        if (this.cJL != null && arrayList != null) {
            this.cJL.clear();
            this.cJL.addAll(arrayList);
        }
        if (this.cJM != null && arrayList2 != null) {
            this.cJM.clear();
            this.cJM.addAll(arrayList2);
        }
        if (this.cJL != null || this.cJM != null) {
            this.cJK.clear();
            if (this.cJL != null) {
                this.cJK.addAll(this.cJL);
            }
            if (this.cJM != null) {
                this.cJK.addAll(this.cJM);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Cq = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.ceI.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.cJN = new Date(optLong);
            } else {
                this.cJN = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.cJO = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.cJI.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cJJ.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.cJP = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.cJL.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.cJM.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Cq = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.hasMore == 1;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z ? 1 : 0;
    }
}
