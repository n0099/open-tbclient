package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private int hasMore;
    private int bPG = 0;
    private int bPH = 0;
    private ArrayList<ForumData> bPz = new ArrayList<>();
    private ArrayList<ForumData> bPA = new ArrayList<>();
    private ArrayList<ForumData> bPB = new ArrayList<>();
    private ArrayList<ForumData> bPC = new ArrayList<>();
    private ArrayList<ForumData> bPE = new ArrayList<>();
    private ArrayList<ForumData> bPD = new ArrayList<>();
    private com.baidu.tbadk.core.data.q bDp = new com.baidu.tbadk.core.data.q();
    private Date bPF = null;
    private boolean abm = true;

    public u() {
        setHasMore(false);
    }

    public int add() {
        return this.bPG;
    }

    public void hx(int i) {
        this.bPG = i;
    }

    public void hy(int i) {
        this.bPG += i;
    }

    public int ade() {
        return this.bPH;
    }

    public void hz(int i) {
        this.bPH = i;
    }

    public void hA(int i) {
        this.bPH += i;
    }

    public ArrayList<ForumData> adf() {
        return this.bPA;
    }

    public ArrayList<ForumData> adg() {
        return this.bPB;
    }

    public ArrayList<ForumData> adh() {
        return this.bPD;
    }

    public ArrayList<ForumData> adi() {
        return this.bPE;
    }

    public ArrayList<ForumData> adj() {
        return this.bPz;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bPz == null) {
            this.bPz = new ArrayList<>();
        }
        if (this.bPA != null && arrayList != null) {
            this.bPA.clear();
            this.bPA.addAll(arrayList);
        }
        if (this.bPB != null && arrayList2 != null) {
            this.bPB.clear();
            this.bPB.addAll(arrayList2);
        }
        if (this.bPA != null || this.bPB != null) {
            this.bPz.clear();
            if (this.bPA != null) {
                this.bPz.addAll(this.bPA);
            }
            if (this.bPB != null) {
                this.bPz.addAll(this.bPB);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bPz == null) {
            this.bPz = new ArrayList<>();
        }
        if (this.bPA != null && arrayList != null) {
            this.bPA.addAll(arrayList);
        }
        if (this.bPB != null && arrayList2 != null) {
            this.bPB.addAll(arrayList2);
        }
        if (this.bPA != null || this.bPB != null) {
            this.bPz.clear();
            if (this.bPA != null) {
                this.bPz.addAll(this.bPA);
            }
            if (this.bPB != null) {
                this.bPz.addAll(this.bPB);
            }
        }
    }

    public ArrayList<ForumData> adk() {
        return this.bPC;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bPC == null) {
            this.bPC = new ArrayList<>();
        }
        if (this.bPD != null && arrayList != null) {
            this.bPD.addAll(arrayList);
        }
        if (this.bPE != null && arrayList2 != null) {
            this.bPE.addAll(arrayList2);
        }
        if (this.bPD != null || this.bPE != null) {
            this.bPC.clear();
            if (this.bPD != null) {
                this.bPC.addAll(this.bPD);
            }
            if (this.bPE != null) {
                this.bPC.addAll(this.bPE);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bPC == null) {
            this.bPC = new ArrayList<>();
        }
        if (this.bPD != null && arrayList != null) {
            this.bPD.clear();
            this.bPD.addAll(arrayList);
        }
        if (this.bPE != null && arrayList2 != null) {
            this.bPE.clear();
            this.bPE.addAll(arrayList2);
        }
        if (this.bPD != null || this.bPE != null) {
            this.bPC.clear();
            if (this.bPD != null) {
                this.bPC.addAll(this.bPD);
            }
            if (this.bPE != null) {
                this.bPC.addAll(this.bPE);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.abm = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.bDp.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.bPF = new Date(optLong);
            } else {
                this.bPF = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.bPG = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.bPA.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bPB.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.bPH = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.bPD.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.bPE.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.abm = false;
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
