package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private int hasMore;
    private int coM = 0;
    private int coN = 0;
    private ArrayList<ForumData> coF = new ArrayList<>();
    private ArrayList<ForumData> coG = new ArrayList<>();
    private ArrayList<ForumData> coH = new ArrayList<>();
    private ArrayList<ForumData> coI = new ArrayList<>();
    private ArrayList<ForumData> coK = new ArrayList<>();
    private ArrayList<ForumData> coJ = new ArrayList<>();
    private com.baidu.tbadk.core.data.n caw = new com.baidu.tbadk.core.data.n();
    private Date coL = null;
    private boolean Cj = true;

    public q() {
        setHasMore(false);
    }

    public int aik() {
        return this.coM;
    }

    public void ja(int i) {
        this.coM = i;
    }

    public void jb(int i) {
        this.coM += i;
    }

    public int ail() {
        return this.coN;
    }

    public void jc(int i) {
        this.coN = i;
    }

    public void jd(int i) {
        this.coN += i;
    }

    public ArrayList<ForumData> aim() {
        return this.coG;
    }

    public ArrayList<ForumData> ain() {
        return this.coH;
    }

    public ArrayList<ForumData> aio() {
        return this.coJ;
    }

    public ArrayList<ForumData> aip() {
        return this.coK;
    }

    public ArrayList<ForumData> aiq() {
        return this.coF;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.coF == null) {
            this.coF = new ArrayList<>();
        }
        if (this.coG != null && arrayList != null) {
            this.coG.clear();
            this.coG.addAll(arrayList);
        }
        if (this.coH != null && arrayList2 != null) {
            this.coH.clear();
            this.coH.addAll(arrayList2);
        }
        if (this.coG != null || this.coH != null) {
            this.coF.clear();
            if (this.coG != null) {
                this.coF.addAll(this.coG);
            }
            if (this.coH != null) {
                this.coF.addAll(this.coH);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.coF == null) {
            this.coF = new ArrayList<>();
        }
        if (this.coG != null && arrayList != null) {
            this.coG.addAll(arrayList);
        }
        if (this.coH != null && arrayList2 != null) {
            this.coH.addAll(arrayList2);
        }
        if (this.coG != null || this.coH != null) {
            this.coF.clear();
            if (this.coG != null) {
                this.coF.addAll(this.coG);
            }
            if (this.coH != null) {
                this.coF.addAll(this.coH);
            }
        }
    }

    public ArrayList<ForumData> air() {
        return this.coI;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.coI == null) {
            this.coI = new ArrayList<>();
        }
        if (this.coJ != null && arrayList != null) {
            this.coJ.addAll(arrayList);
        }
        if (this.coK != null && arrayList2 != null) {
            this.coK.addAll(arrayList2);
        }
        if (this.coJ != null || this.coK != null) {
            this.coI.clear();
            if (this.coJ != null) {
                this.coI.addAll(this.coJ);
            }
            if (this.coK != null) {
                this.coI.addAll(this.coK);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.coI == null) {
            this.coI = new ArrayList<>();
        }
        if (this.coJ != null && arrayList != null) {
            this.coJ.clear();
            this.coJ.addAll(arrayList);
        }
        if (this.coK != null && arrayList2 != null) {
            this.coK.clear();
            this.coK.addAll(arrayList2);
        }
        if (this.coJ != null || this.coK != null) {
            this.coI.clear();
            if (this.coJ != null) {
                this.coI.addAll(this.coJ);
            }
            if (this.coK != null) {
                this.coI.addAll(this.coK);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Cj = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.caw.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.coL = new Date(optLong);
            } else {
                this.coL = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.coM = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.coG.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.coH.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.coN = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.coJ.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.coK.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Cj = false;
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
