package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private int hasMore;
    private int bGN = 0;
    private int bGO = 0;
    private ArrayList<ForumData> bGG = new ArrayList<>();
    private ArrayList<ForumData> bGH = new ArrayList<>();
    private ArrayList<ForumData> bGI = new ArrayList<>();
    private ArrayList<ForumData> bGJ = new ArrayList<>();
    private ArrayList<ForumData> bGL = new ArrayList<>();
    private ArrayList<ForumData> bGK = new ArrayList<>();
    private com.baidu.tbadk.core.data.q btC = new com.baidu.tbadk.core.data.q();
    private Date bGM = null;
    private boolean Rp = true;

    public f() {
        setHasMore(false);
    }

    public int aay() {
        return this.bGN;
    }

    public void hj(int i) {
        this.bGN = i;
    }

    public void hk(int i) {
        this.bGN += i;
    }

    public int aaz() {
        return this.bGO;
    }

    public void hl(int i) {
        this.bGO = i;
    }

    public void hm(int i) {
        this.bGO += i;
    }

    public ArrayList<ForumData> aaA() {
        return this.bGH;
    }

    public ArrayList<ForumData> aaB() {
        return this.bGI;
    }

    public ArrayList<ForumData> aaC() {
        return this.bGK;
    }

    public ArrayList<ForumData> aaD() {
        return this.bGL;
    }

    public ArrayList<ForumData> aaE() {
        return this.bGG;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bGG == null) {
            this.bGG = new ArrayList<>();
        }
        if (this.bGH != null && arrayList != null) {
            this.bGH.clear();
            this.bGH.addAll(arrayList);
        }
        if (this.bGI != null && arrayList2 != null) {
            this.bGI.clear();
            this.bGI.addAll(arrayList2);
        }
        if (this.bGH != null || this.bGI != null) {
            this.bGG.clear();
            if (this.bGH != null) {
                this.bGG.addAll(this.bGH);
            }
            if (this.bGI != null) {
                this.bGG.addAll(this.bGI);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bGG == null) {
            this.bGG = new ArrayList<>();
        }
        if (this.bGH != null && arrayList != null) {
            this.bGH.addAll(arrayList);
        }
        if (this.bGI != null && arrayList2 != null) {
            this.bGI.addAll(arrayList2);
        }
        if (this.bGH != null || this.bGI != null) {
            this.bGG.clear();
            if (this.bGH != null) {
                this.bGG.addAll(this.bGH);
            }
            if (this.bGI != null) {
                this.bGG.addAll(this.bGI);
            }
        }
    }

    public ArrayList<ForumData> aaF() {
        return this.bGJ;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bGJ == null) {
            this.bGJ = new ArrayList<>();
        }
        if (this.bGK != null && arrayList != null) {
            this.bGK.addAll(arrayList);
        }
        if (this.bGL != null && arrayList2 != null) {
            this.bGL.addAll(arrayList2);
        }
        if (this.bGK != null || this.bGL != null) {
            this.bGJ.clear();
            if (this.bGK != null) {
                this.bGJ.addAll(this.bGK);
            }
            if (this.bGL != null) {
                this.bGJ.addAll(this.bGL);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bGJ == null) {
            this.bGJ = new ArrayList<>();
        }
        if (this.bGK != null && arrayList != null) {
            this.bGK.clear();
            this.bGK.addAll(arrayList);
        }
        if (this.bGL != null && arrayList2 != null) {
            this.bGL.clear();
            this.bGL.addAll(arrayList2);
        }
        if (this.bGK != null || this.bGL != null) {
            this.bGJ.clear();
            if (this.bGK != null) {
                this.bGJ.addAll(this.bGK);
            }
            if (this.bGL != null) {
                this.bGJ.addAll(this.bGL);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Rp = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.btC.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.bGM = new Date(optLong);
            } else {
                this.bGM = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.bGN = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.bGH.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bGI.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.bGO = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.bGK.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.bGL.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Rp = false;
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
