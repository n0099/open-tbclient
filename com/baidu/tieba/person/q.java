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
    private int cjj = 0;
    private int cjk = 0;
    private ArrayList<ForumData> cjc = new ArrayList<>();
    private ArrayList<ForumData> cjd = new ArrayList<>();
    private ArrayList<ForumData> cje = new ArrayList<>();
    private ArrayList<ForumData> cjf = new ArrayList<>();
    private ArrayList<ForumData> cjh = new ArrayList<>();
    private ArrayList<ForumData> cjg = new ArrayList<>();
    private com.baidu.tbadk.core.data.o bWI = new com.baidu.tbadk.core.data.o();
    private Date cji = null;
    private boolean Ci = true;

    public q() {
        setHasMore(false);
    }

    public int agl() {
        return this.cjj;
    }

    public void iQ(int i) {
        this.cjj = i;
    }

    public void iR(int i) {
        this.cjj += i;
    }

    public int agm() {
        return this.cjk;
    }

    public void iS(int i) {
        this.cjk = i;
    }

    public void iT(int i) {
        this.cjk += i;
    }

    public ArrayList<ForumData> agn() {
        return this.cjd;
    }

    public ArrayList<ForumData> ago() {
        return this.cje;
    }

    public ArrayList<ForumData> agp() {
        return this.cjg;
    }

    public ArrayList<ForumData> agq() {
        return this.cjh;
    }

    public ArrayList<ForumData> agr() {
        return this.cjc;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cjc == null) {
            this.cjc = new ArrayList<>();
        }
        if (this.cjd != null && arrayList != null) {
            this.cjd.clear();
            this.cjd.addAll(arrayList);
        }
        if (this.cje != null && arrayList2 != null) {
            this.cje.clear();
            this.cje.addAll(arrayList2);
        }
        if (this.cjd != null || this.cje != null) {
            this.cjc.clear();
            if (this.cjd != null) {
                this.cjc.addAll(this.cjd);
            }
            if (this.cje != null) {
                this.cjc.addAll(this.cje);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cjc == null) {
            this.cjc = new ArrayList<>();
        }
        if (this.cjd != null && arrayList != null) {
            this.cjd.addAll(arrayList);
        }
        if (this.cje != null && arrayList2 != null) {
            this.cje.addAll(arrayList2);
        }
        if (this.cjd != null || this.cje != null) {
            this.cjc.clear();
            if (this.cjd != null) {
                this.cjc.addAll(this.cjd);
            }
            if (this.cje != null) {
                this.cjc.addAll(this.cje);
            }
        }
    }

    public ArrayList<ForumData> ags() {
        return this.cjf;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cjf == null) {
            this.cjf = new ArrayList<>();
        }
        if (this.cjg != null && arrayList != null) {
            this.cjg.addAll(arrayList);
        }
        if (this.cjh != null && arrayList2 != null) {
            this.cjh.addAll(arrayList2);
        }
        if (this.cjg != null || this.cjh != null) {
            this.cjf.clear();
            if (this.cjg != null) {
                this.cjf.addAll(this.cjg);
            }
            if (this.cjh != null) {
                this.cjf.addAll(this.cjh);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cjf == null) {
            this.cjf = new ArrayList<>();
        }
        if (this.cjg != null && arrayList != null) {
            this.cjg.clear();
            this.cjg.addAll(arrayList);
        }
        if (this.cjh != null && arrayList2 != null) {
            this.cjh.clear();
            this.cjh.addAll(arrayList2);
        }
        if (this.cjg != null || this.cjh != null) {
            this.cjf.clear();
            if (this.cjg != null) {
                this.cjf.addAll(this.cjg);
            }
            if (this.cjh != null) {
                this.cjf.addAll(this.cjh);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Ci = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.bWI.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.cji = new Date(optLong);
            } else {
                this.cji = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.cjj = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.cjd.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cje.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.cjk = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.cjg.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.cjh.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Ci = false;
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
