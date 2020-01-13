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
    private int jiK = 0;
    private int jiL = 0;
    private ArrayList<ForumData> jiD = new ArrayList<>();
    private ArrayList<ForumData> jiE = new ArrayList<>();
    private ArrayList<ForumData> jiF = new ArrayList<>();
    private ArrayList<ForumData> jiG = new ArrayList<>();
    private ArrayList<ForumData> jiI = new ArrayList<>();
    private ArrayList<ForumData> jiH = new ArrayList<>();
    private ap page = new ap();
    private Date jiJ = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cur() {
        return this.jiK;
    }

    public void zG(int i) {
        this.jiK = i;
    }

    public void zH(int i) {
        this.jiK += i;
    }

    public int cus() {
        return this.jiL;
    }

    public void zI(int i) {
        this.jiL = i;
    }

    public void zJ(int i) {
        this.jiL += i;
    }

    public ArrayList<ForumData> cut() {
        return this.jiE;
    }

    public ArrayList<ForumData> cuu() {
        return this.jiF;
    }

    public ArrayList<ForumData> cuv() {
        return this.jiH;
    }

    public ArrayList<ForumData> cuw() {
        return this.jiI;
    }

    public ArrayList<ForumData> cux() {
        return this.jiD;
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jiD == null) {
            this.jiD = new ArrayList<>();
        }
        if (this.jiE != null && arrayList != null) {
            this.jiE.clear();
            this.jiE.addAll(arrayList);
        }
        if (this.jiF != null && arrayList2 != null) {
            this.jiF.clear();
            this.jiF.addAll(arrayList2);
        }
        if (this.jiE != null || this.jiF != null) {
            this.jiD.clear();
            if (this.jiE != null) {
                this.jiD.addAll(this.jiE);
            }
            if (this.jiF != null) {
                this.jiD.addAll(this.jiF);
            }
        }
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jiD == null) {
            this.jiD = new ArrayList<>();
        }
        if (this.jiE != null && arrayList != null) {
            this.jiE.addAll(arrayList);
        }
        if (this.jiF != null && arrayList2 != null) {
            this.jiF.addAll(arrayList2);
        }
        if (this.jiE != null || this.jiF != null) {
            this.jiD.clear();
            if (this.jiE != null) {
                this.jiD.addAll(this.jiE);
            }
            if (this.jiF != null) {
                this.jiD.addAll(this.jiF);
            }
        }
    }

    public ArrayList<ForumData> cuy() {
        return this.jiG;
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jiG == null) {
            this.jiG = new ArrayList<>();
        }
        if (this.jiH != null && arrayList != null) {
            this.jiH.addAll(arrayList);
        }
        if (this.jiI != null && arrayList2 != null) {
            this.jiI.addAll(arrayList2);
        }
        if (this.jiH != null || this.jiI != null) {
            this.jiG.clear();
            if (this.jiH != null) {
                this.jiG.addAll(this.jiH);
            }
            if (this.jiI != null) {
                this.jiG.addAll(this.jiI);
            }
        }
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jiG == null) {
            this.jiG = new ArrayList<>();
        }
        if (this.jiH != null && arrayList != null) {
            this.jiH.clear();
            this.jiH.addAll(arrayList);
        }
        if (this.jiI != null && arrayList2 != null) {
            this.jiI.clear();
            this.jiI.addAll(arrayList2);
        }
        if (this.jiH != null || this.jiI != null) {
            this.jiG.clear();
            if (this.jiH != null) {
                this.jiG.addAll(this.jiH);
            }
            if (this.jiI != null) {
                this.jiG.addAll(this.jiI);
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
                this.jiJ = new Date(optLong);
            } else {
                this.jiJ = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.jiK = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.jiE.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.jiF.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.jiL = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.jiH.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.jiI.add(forumData4);
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
