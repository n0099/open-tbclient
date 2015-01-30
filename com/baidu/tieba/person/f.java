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
    private int bGO = 0;
    private int bGP = 0;
    private ArrayList<ForumData> bGH = new ArrayList<>();
    private ArrayList<ForumData> bGI = new ArrayList<>();
    private ArrayList<ForumData> bGJ = new ArrayList<>();
    private ArrayList<ForumData> bGK = new ArrayList<>();
    private ArrayList<ForumData> bGM = new ArrayList<>();
    private ArrayList<ForumData> bGL = new ArrayList<>();
    private com.baidu.tbadk.core.data.q btD = new com.baidu.tbadk.core.data.q();
    private Date bGN = null;
    private boolean Rs = true;

    public f() {
        setHasMore(false);
    }

    public int aaD() {
        return this.bGO;
    }

    public void hj(int i) {
        this.bGO = i;
    }

    public void hk(int i) {
        this.bGO += i;
    }

    public int aaE() {
        return this.bGP;
    }

    public void hl(int i) {
        this.bGP = i;
    }

    public void hm(int i) {
        this.bGP += i;
    }

    public ArrayList<ForumData> aaF() {
        return this.bGI;
    }

    public ArrayList<ForumData> aaG() {
        return this.bGJ;
    }

    public ArrayList<ForumData> aaH() {
        return this.bGL;
    }

    public ArrayList<ForumData> aaI() {
        return this.bGM;
    }

    public ArrayList<ForumData> aaJ() {
        return this.bGH;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bGH == null) {
            this.bGH = new ArrayList<>();
        }
        if (this.bGI != null && arrayList != null) {
            this.bGI.clear();
            this.bGI.addAll(arrayList);
        }
        if (this.bGJ != null && arrayList2 != null) {
            this.bGJ.clear();
            this.bGJ.addAll(arrayList2);
        }
        if (this.bGI != null || this.bGJ != null) {
            this.bGH.clear();
            if (this.bGI != null) {
                this.bGH.addAll(this.bGI);
            }
            if (this.bGJ != null) {
                this.bGH.addAll(this.bGJ);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bGH == null) {
            this.bGH = new ArrayList<>();
        }
        if (this.bGI != null && arrayList != null) {
            this.bGI.addAll(arrayList);
        }
        if (this.bGJ != null && arrayList2 != null) {
            this.bGJ.addAll(arrayList2);
        }
        if (this.bGI != null || this.bGJ != null) {
            this.bGH.clear();
            if (this.bGI != null) {
                this.bGH.addAll(this.bGI);
            }
            if (this.bGJ != null) {
                this.bGH.addAll(this.bGJ);
            }
        }
    }

    public ArrayList<ForumData> aaK() {
        return this.bGK;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bGK == null) {
            this.bGK = new ArrayList<>();
        }
        if (this.bGL != null && arrayList != null) {
            this.bGL.addAll(arrayList);
        }
        if (this.bGM != null && arrayList2 != null) {
            this.bGM.addAll(arrayList2);
        }
        if (this.bGL != null || this.bGM != null) {
            this.bGK.clear();
            if (this.bGL != null) {
                this.bGK.addAll(this.bGL);
            }
            if (this.bGM != null) {
                this.bGK.addAll(this.bGM);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bGK == null) {
            this.bGK = new ArrayList<>();
        }
        if (this.bGL != null && arrayList != null) {
            this.bGL.clear();
            this.bGL.addAll(arrayList);
        }
        if (this.bGM != null && arrayList2 != null) {
            this.bGM.clear();
            this.bGM.addAll(arrayList2);
        }
        if (this.bGL != null || this.bGM != null) {
            this.bGK.clear();
            if (this.bGL != null) {
                this.bGK.addAll(this.bGL);
            }
            if (this.bGM != null) {
                this.bGK.addAll(this.bGM);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Rs = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.btD.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.bGN = new Date(optLong);
            } else {
                this.bGN = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.bGO = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.bGI.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bGJ.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.bGP = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.bGL.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.bGM.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Rs = false;
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
