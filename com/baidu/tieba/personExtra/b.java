package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class b {
    private int jlH;
    private int lSp = 0;
    private int lSq = 0;
    private ArrayList<ForumData> lSi = new ArrayList<>();
    private ArrayList<ForumData> lSj = new ArrayList<>();
    private ArrayList<ForumData> lSk = new ArrayList<>();
    private ArrayList<ForumData> lSl = new ArrayList<>();
    private ArrayList<ForumData> lSn = new ArrayList<>();
    private ArrayList<ForumData> lSm = new ArrayList<>();
    private av page = new av();
    private Date lSo = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int drI() {
        return this.lSp;
    }

    public void GF(int i) {
        this.lSp = i;
    }

    public void GG(int i) {
        this.lSp += i;
    }

    public int drJ() {
        return this.lSq;
    }

    public void GH(int i) {
        this.lSq = i;
    }

    public void GI(int i) {
        this.lSq += i;
    }

    public ArrayList<ForumData> drK() {
        return this.lSj;
    }

    public ArrayList<ForumData> drL() {
        return this.lSk;
    }

    public ArrayList<ForumData> drM() {
        return this.lSm;
    }

    public ArrayList<ForumData> drN() {
        return this.lSn;
    }

    public ArrayList<ForumData> drO() {
        return this.lSi;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lSi == null) {
            this.lSi = new ArrayList<>();
        }
        if (this.lSj != null && arrayList != null) {
            this.lSj.clear();
            this.lSj.addAll(arrayList);
        }
        if (this.lSk != null && arrayList2 != null) {
            this.lSk.clear();
            this.lSk.addAll(arrayList2);
        }
        if (this.lSj != null || this.lSk != null) {
            this.lSi.clear();
            if (this.lSj != null) {
                this.lSi.addAll(this.lSj);
            }
            if (this.lSk != null) {
                this.lSi.addAll(this.lSk);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lSi == null) {
            this.lSi = new ArrayList<>();
        }
        if (this.lSj != null && arrayList != null) {
            this.lSj.addAll(arrayList);
        }
        if (this.lSk != null && arrayList2 != null) {
            this.lSk.addAll(arrayList2);
        }
        if (this.lSj != null || this.lSk != null) {
            this.lSi.clear();
            if (this.lSj != null) {
                this.lSi.addAll(this.lSj);
            }
            if (this.lSk != null) {
                this.lSi.addAll(this.lSk);
            }
        }
    }

    public ArrayList<ForumData> drP() {
        return this.lSl;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lSl == null) {
            this.lSl = new ArrayList<>();
        }
        if (this.lSm != null && arrayList != null) {
            this.lSm.addAll(arrayList);
        }
        if (this.lSn != null && arrayList2 != null) {
            this.lSn.addAll(arrayList2);
        }
        if (this.lSm != null || this.lSn != null) {
            this.lSl.clear();
            if (this.lSm != null) {
                this.lSl.addAll(this.lSm);
            }
            if (this.lSn != null) {
                this.lSl.addAll(this.lSn);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lSl == null) {
            this.lSl = new ArrayList<>();
        }
        if (this.lSm != null && arrayList != null) {
            this.lSm.clear();
            this.lSm.addAll(arrayList);
        }
        if (this.lSn != null && arrayList2 != null) {
            this.lSn.clear();
            this.lSn.addAll(arrayList2);
        }
        if (this.lSm != null || this.lSn != null) {
            this.lSl.clear();
            if (this.lSm != null) {
                this.lSl.addAll(this.lSm);
            }
            if (this.lSn != null) {
                this.lSl.addAll(this.lSn);
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
            this.jlH = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.lSo = new Date(optLong);
            } else {
                this.lSo = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.lSp = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.lSj.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.lSk.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.lSq = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.lSm.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.lSn.add(forumData4);
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
        return this.jlH == 1;
    }

    public void setHasMore(boolean z) {
        this.jlH = z ? 1 : 0;
    }
}
