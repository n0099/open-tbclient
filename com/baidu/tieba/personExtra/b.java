package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ao;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private int hUq;
    private int koN = 0;
    private int koO = 0;
    private ArrayList<ForumData> koG = new ArrayList<>();
    private ArrayList<ForumData> koH = new ArrayList<>();
    private ArrayList<ForumData> koI = new ArrayList<>();
    private ArrayList<ForumData> koJ = new ArrayList<>();
    private ArrayList<ForumData> koL = new ArrayList<>();
    private ArrayList<ForumData> koK = new ArrayList<>();
    private ao page = new ao();
    private Date koM = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cOg() {
        return this.koN;
    }

    public void Bj(int i) {
        this.koN = i;
    }

    public void Bk(int i) {
        this.koN += i;
    }

    public int cOh() {
        return this.koO;
    }

    public void Bl(int i) {
        this.koO = i;
    }

    public void Bm(int i) {
        this.koO += i;
    }

    public ArrayList<ForumData> cOi() {
        return this.koH;
    }

    public ArrayList<ForumData> cOj() {
        return this.koI;
    }

    public ArrayList<ForumData> cOk() {
        return this.koK;
    }

    public ArrayList<ForumData> cOl() {
        return this.koL;
    }

    public ArrayList<ForumData> cOm() {
        return this.koG;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.koG == null) {
            this.koG = new ArrayList<>();
        }
        if (this.koH != null && arrayList != null) {
            this.koH.clear();
            this.koH.addAll(arrayList);
        }
        if (this.koI != null && arrayList2 != null) {
            this.koI.clear();
            this.koI.addAll(arrayList2);
        }
        if (this.koH != null || this.koI != null) {
            this.koG.clear();
            if (this.koH != null) {
                this.koG.addAll(this.koH);
            }
            if (this.koI != null) {
                this.koG.addAll(this.koI);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.koG == null) {
            this.koG = new ArrayList<>();
        }
        if (this.koH != null && arrayList != null) {
            this.koH.addAll(arrayList);
        }
        if (this.koI != null && arrayList2 != null) {
            this.koI.addAll(arrayList2);
        }
        if (this.koH != null || this.koI != null) {
            this.koG.clear();
            if (this.koH != null) {
                this.koG.addAll(this.koH);
            }
            if (this.koI != null) {
                this.koG.addAll(this.koI);
            }
        }
    }

    public ArrayList<ForumData> cOn() {
        return this.koJ;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.koJ == null) {
            this.koJ = new ArrayList<>();
        }
        if (this.koK != null && arrayList != null) {
            this.koK.addAll(arrayList);
        }
        if (this.koL != null && arrayList2 != null) {
            this.koL.addAll(arrayList2);
        }
        if (this.koK != null || this.koL != null) {
            this.koJ.clear();
            if (this.koK != null) {
                this.koJ.addAll(this.koK);
            }
            if (this.koL != null) {
                this.koJ.addAll(this.koL);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.koJ == null) {
            this.koJ = new ArrayList<>();
        }
        if (this.koK != null && arrayList != null) {
            this.koK.clear();
            this.koK.addAll(arrayList);
        }
        if (this.koL != null && arrayList2 != null) {
            this.koL.clear();
            this.koL.addAll(arrayList2);
        }
        if (this.koK != null || this.koL != null) {
            this.koJ.clear();
            if (this.koK != null) {
                this.koJ.addAll(this.koK);
            }
            if (this.koL != null) {
                this.koJ.addAll(this.koL);
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
            this.hUq = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.koM = new Date(optLong);
            } else {
                this.koM = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.koN = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.koH.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.koI.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.koO = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.koK.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.koL.add(forumData4);
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
        return this.hUq == 1;
    }

    public void setHasMore(boolean z) {
        this.hUq = z ? 1 : 0;
    }
}
