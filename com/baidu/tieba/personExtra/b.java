package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ap;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private int gRy;
    private int jiP = 0;
    private int jiQ = 0;
    private ArrayList<ForumData> jiI = new ArrayList<>();
    private ArrayList<ForumData> jiJ = new ArrayList<>();
    private ArrayList<ForumData> jiK = new ArrayList<>();
    private ArrayList<ForumData> jiL = new ArrayList<>();
    private ArrayList<ForumData> jiN = new ArrayList<>();
    private ArrayList<ForumData> jiM = new ArrayList<>();
    private ap page = new ap();
    private Date jiO = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cut() {
        return this.jiP;
    }

    public void zG(int i) {
        this.jiP = i;
    }

    public void zH(int i) {
        this.jiP += i;
    }

    public int cuu() {
        return this.jiQ;
    }

    public void zI(int i) {
        this.jiQ = i;
    }

    public void zJ(int i) {
        this.jiQ += i;
    }

    public ArrayList<ForumData> cuv() {
        return this.jiJ;
    }

    public ArrayList<ForumData> cuw() {
        return this.jiK;
    }

    public ArrayList<ForumData> cux() {
        return this.jiM;
    }

    public ArrayList<ForumData> cuy() {
        return this.jiN;
    }

    public ArrayList<ForumData> cuz() {
        return this.jiI;
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jiI == null) {
            this.jiI = new ArrayList<>();
        }
        if (this.jiJ != null && arrayList != null) {
            this.jiJ.clear();
            this.jiJ.addAll(arrayList);
        }
        if (this.jiK != null && arrayList2 != null) {
            this.jiK.clear();
            this.jiK.addAll(arrayList2);
        }
        if (this.jiJ != null || this.jiK != null) {
            this.jiI.clear();
            if (this.jiJ != null) {
                this.jiI.addAll(this.jiJ);
            }
            if (this.jiK != null) {
                this.jiI.addAll(this.jiK);
            }
        }
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jiI == null) {
            this.jiI = new ArrayList<>();
        }
        if (this.jiJ != null && arrayList != null) {
            this.jiJ.addAll(arrayList);
        }
        if (this.jiK != null && arrayList2 != null) {
            this.jiK.addAll(arrayList2);
        }
        if (this.jiJ != null || this.jiK != null) {
            this.jiI.clear();
            if (this.jiJ != null) {
                this.jiI.addAll(this.jiJ);
            }
            if (this.jiK != null) {
                this.jiI.addAll(this.jiK);
            }
        }
    }

    public ArrayList<ForumData> cuA() {
        return this.jiL;
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jiL == null) {
            this.jiL = new ArrayList<>();
        }
        if (this.jiM != null && arrayList != null) {
            this.jiM.addAll(arrayList);
        }
        if (this.jiN != null && arrayList2 != null) {
            this.jiN.addAll(arrayList2);
        }
        if (this.jiM != null || this.jiN != null) {
            this.jiL.clear();
            if (this.jiM != null) {
                this.jiL.addAll(this.jiM);
            }
            if (this.jiN != null) {
                this.jiL.addAll(this.jiN);
            }
        }
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jiL == null) {
            this.jiL = new ArrayList<>();
        }
        if (this.jiM != null && arrayList != null) {
            this.jiM.clear();
            this.jiM.addAll(arrayList);
        }
        if (this.jiN != null && arrayList2 != null) {
            this.jiN.clear();
            this.jiN.addAll(arrayList2);
        }
        if (this.jiM != null || this.jiN != null) {
            this.jiL.clear();
            if (this.jiM != null) {
                this.jiL.addAll(this.jiM);
            }
            if (this.jiN != null) {
                this.jiL.addAll(this.jiN);
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
            this.gRy = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.jiO = new Date(optLong);
            } else {
                this.jiO = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.jiP = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.jiJ.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.jiK.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.jiQ = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.jiM.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.jiN.add(forumData4);
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
        return this.gRy == 1;
    }

    public void setHasMore(boolean z) {
        this.gRy = z ? 1 : 0;
    }
}
