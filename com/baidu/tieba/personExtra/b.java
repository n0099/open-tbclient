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
    private int jrF;
    private int lYl = 0;
    private int lYm = 0;
    private ArrayList<ForumData> lYe = new ArrayList<>();
    private ArrayList<ForumData> lYf = new ArrayList<>();
    private ArrayList<ForumData> lYg = new ArrayList<>();
    private ArrayList<ForumData> lYh = new ArrayList<>();
    private ArrayList<ForumData> lYj = new ArrayList<>();
    private ArrayList<ForumData> lYi = new ArrayList<>();
    private av page = new av();
    private Date lYk = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int duk() {
        return this.lYl;
    }

    public void GS(int i) {
        this.lYl = i;
    }

    public void GT(int i) {
        this.lYl += i;
    }

    public int dul() {
        return this.lYm;
    }

    public void GU(int i) {
        this.lYm = i;
    }

    public void GV(int i) {
        this.lYm += i;
    }

    public ArrayList<ForumData> dum() {
        return this.lYf;
    }

    public ArrayList<ForumData> dun() {
        return this.lYg;
    }

    public ArrayList<ForumData> duo() {
        return this.lYi;
    }

    public ArrayList<ForumData> dup() {
        return this.lYj;
    }

    public ArrayList<ForumData> duq() {
        return this.lYe;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lYe == null) {
            this.lYe = new ArrayList<>();
        }
        if (this.lYf != null && arrayList != null) {
            this.lYf.clear();
            this.lYf.addAll(arrayList);
        }
        if (this.lYg != null && arrayList2 != null) {
            this.lYg.clear();
            this.lYg.addAll(arrayList2);
        }
        if (this.lYf != null || this.lYg != null) {
            this.lYe.clear();
            if (this.lYf != null) {
                this.lYe.addAll(this.lYf);
            }
            if (this.lYg != null) {
                this.lYe.addAll(this.lYg);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lYe == null) {
            this.lYe = new ArrayList<>();
        }
        if (this.lYf != null && arrayList != null) {
            this.lYf.addAll(arrayList);
        }
        if (this.lYg != null && arrayList2 != null) {
            this.lYg.addAll(arrayList2);
        }
        if (this.lYf != null || this.lYg != null) {
            this.lYe.clear();
            if (this.lYf != null) {
                this.lYe.addAll(this.lYf);
            }
            if (this.lYg != null) {
                this.lYe.addAll(this.lYg);
            }
        }
    }

    public ArrayList<ForumData> dur() {
        return this.lYh;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lYh == null) {
            this.lYh = new ArrayList<>();
        }
        if (this.lYi != null && arrayList != null) {
            this.lYi.addAll(arrayList);
        }
        if (this.lYj != null && arrayList2 != null) {
            this.lYj.addAll(arrayList2);
        }
        if (this.lYi != null || this.lYj != null) {
            this.lYh.clear();
            if (this.lYi != null) {
                this.lYh.addAll(this.lYi);
            }
            if (this.lYj != null) {
                this.lYh.addAll(this.lYj);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lYh == null) {
            this.lYh = new ArrayList<>();
        }
        if (this.lYi != null && arrayList != null) {
            this.lYi.clear();
            this.lYi.addAll(arrayList);
        }
        if (this.lYj != null && arrayList2 != null) {
            this.lYj.clear();
            this.lYj.addAll(arrayList2);
        }
        if (this.lYi != null || this.lYj != null) {
            this.lYh.clear();
            if (this.lYi != null) {
                this.lYh.addAll(this.lYi);
            }
            if (this.lYj != null) {
                this.lYh.addAll(this.lYj);
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
            this.jrF = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.lYk = new Date(optLong);
            } else {
                this.lYk = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.lYl = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.lYf.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.lYg.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.lYm = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.lYi.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.lYj.add(forumData4);
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
        return this.jrF == 1;
    }

    public void setHasMore(boolean z) {
        this.jrF = z ? 1 : 0;
    }
}
