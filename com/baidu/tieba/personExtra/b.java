package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.an;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private int eSj;
    private int inj = 0;
    private int ink = 0;
    private ArrayList<ForumData> inc = new ArrayList<>();
    private ArrayList<ForumData> ind = new ArrayList<>();
    private ArrayList<ForumData> ine = new ArrayList<>();
    private ArrayList<ForumData> inf = new ArrayList<>();
    private ArrayList<ForumData> inh = new ArrayList<>();
    private ArrayList<ForumData> ing = new ArrayList<>();
    private an page = new an();
    private Date ini = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int bZQ() {
        return this.inj;
    }

    public void xp(int i) {
        this.inj = i;
    }

    public void xq(int i) {
        this.inj += i;
    }

    public int bZR() {
        return this.ink;
    }

    public void xr(int i) {
        this.ink = i;
    }

    public void xs(int i) {
        this.ink += i;
    }

    public ArrayList<ForumData> bZS() {
        return this.ind;
    }

    public ArrayList<ForumData> bZT() {
        return this.ine;
    }

    public ArrayList<ForumData> bZU() {
        return this.ing;
    }

    public ArrayList<ForumData> bZV() {
        return this.inh;
    }

    public ArrayList<ForumData> bZW() {
        return this.inc;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.inc == null) {
            this.inc = new ArrayList<>();
        }
        if (this.ind != null && arrayList != null) {
            this.ind.clear();
            this.ind.addAll(arrayList);
        }
        if (this.ine != null && arrayList2 != null) {
            this.ine.clear();
            this.ine.addAll(arrayList2);
        }
        if (this.ind != null || this.ine != null) {
            this.inc.clear();
            if (this.ind != null) {
                this.inc.addAll(this.ind);
            }
            if (this.ine != null) {
                this.inc.addAll(this.ine);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.inc == null) {
            this.inc = new ArrayList<>();
        }
        if (this.ind != null && arrayList != null) {
            this.ind.addAll(arrayList);
        }
        if (this.ine != null && arrayList2 != null) {
            this.ine.addAll(arrayList2);
        }
        if (this.ind != null || this.ine != null) {
            this.inc.clear();
            if (this.ind != null) {
                this.inc.addAll(this.ind);
            }
            if (this.ine != null) {
                this.inc.addAll(this.ine);
            }
        }
    }

    public ArrayList<ForumData> bZX() {
        return this.inf;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.inf == null) {
            this.inf = new ArrayList<>();
        }
        if (this.ing != null && arrayList != null) {
            this.ing.addAll(arrayList);
        }
        if (this.inh != null && arrayList2 != null) {
            this.inh.addAll(arrayList2);
        }
        if (this.ing != null || this.inh != null) {
            this.inf.clear();
            if (this.ing != null) {
                this.inf.addAll(this.ing);
            }
            if (this.inh != null) {
                this.inf.addAll(this.inh);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.inf == null) {
            this.inf = new ArrayList<>();
        }
        if (this.ing != null && arrayList != null) {
            this.ing.clear();
            this.ing.addAll(arrayList);
        }
        if (this.inh != null && arrayList2 != null) {
            this.inh.clear();
            this.inh.addAll(arrayList2);
        }
        if (this.ing != null || this.inh != null) {
            this.inf.clear();
            if (this.ing != null) {
                this.inf.addAll(this.ing);
            }
            if (this.inh != null) {
                this.inf.addAll(this.inh);
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
            this.eSj = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.ini = new Date(optLong);
            } else {
                this.ini = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.inj = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.ind.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.ine.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.ink = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.ing.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.inh.add(forumData4);
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
        return this.eSj == 1;
    }

    public void setHasMore(boolean z) {
        this.eSj = z ? 1 : 0;
    }
}
