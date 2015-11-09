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
    private int cqt = 0;
    private int cqu = 0;
    private ArrayList<ForumData> cqm = new ArrayList<>();
    private ArrayList<ForumData> cqn = new ArrayList<>();
    private ArrayList<ForumData> cqo = new ArrayList<>();
    private ArrayList<ForumData> cqp = new ArrayList<>();
    private ArrayList<ForumData> cqr = new ArrayList<>();
    private ArrayList<ForumData> cqq = new ArrayList<>();
    private com.baidu.tbadk.core.data.o cbi = new com.baidu.tbadk.core.data.o();
    private Date cqs = null;
    private boolean Cj = true;

    public q() {
        setHasMore(false);
    }

    public int aiM() {
        return this.cqt;
    }

    public void jo(int i) {
        this.cqt = i;
    }

    public void jp(int i) {
        this.cqt += i;
    }

    public int aiN() {
        return this.cqu;
    }

    public void jq(int i) {
        this.cqu = i;
    }

    public void jr(int i) {
        this.cqu += i;
    }

    public ArrayList<ForumData> aiO() {
        return this.cqn;
    }

    public ArrayList<ForumData> aiP() {
        return this.cqo;
    }

    public ArrayList<ForumData> aiQ() {
        return this.cqq;
    }

    public ArrayList<ForumData> aiR() {
        return this.cqr;
    }

    public ArrayList<ForumData> aiS() {
        return this.cqm;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cqm == null) {
            this.cqm = new ArrayList<>();
        }
        if (this.cqn != null && arrayList != null) {
            this.cqn.clear();
            this.cqn.addAll(arrayList);
        }
        if (this.cqo != null && arrayList2 != null) {
            this.cqo.clear();
            this.cqo.addAll(arrayList2);
        }
        if (this.cqn != null || this.cqo != null) {
            this.cqm.clear();
            if (this.cqn != null) {
                this.cqm.addAll(this.cqn);
            }
            if (this.cqo != null) {
                this.cqm.addAll(this.cqo);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cqm == null) {
            this.cqm = new ArrayList<>();
        }
        if (this.cqn != null && arrayList != null) {
            this.cqn.addAll(arrayList);
        }
        if (this.cqo != null && arrayList2 != null) {
            this.cqo.addAll(arrayList2);
        }
        if (this.cqn != null || this.cqo != null) {
            this.cqm.clear();
            if (this.cqn != null) {
                this.cqm.addAll(this.cqn);
            }
            if (this.cqo != null) {
                this.cqm.addAll(this.cqo);
            }
        }
    }

    public ArrayList<ForumData> aiT() {
        return this.cqp;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cqp == null) {
            this.cqp = new ArrayList<>();
        }
        if (this.cqq != null && arrayList != null) {
            this.cqq.addAll(arrayList);
        }
        if (this.cqr != null && arrayList2 != null) {
            this.cqr.addAll(arrayList2);
        }
        if (this.cqq != null || this.cqr != null) {
            this.cqp.clear();
            if (this.cqq != null) {
                this.cqp.addAll(this.cqq);
            }
            if (this.cqr != null) {
                this.cqp.addAll(this.cqr);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cqp == null) {
            this.cqp = new ArrayList<>();
        }
        if (this.cqq != null && arrayList != null) {
            this.cqq.clear();
            this.cqq.addAll(arrayList);
        }
        if (this.cqr != null && arrayList2 != null) {
            this.cqr.clear();
            this.cqr.addAll(arrayList2);
        }
        if (this.cqq != null || this.cqr != null) {
            this.cqp.clear();
            if (this.cqq != null) {
                this.cqp.addAll(this.cqq);
            }
            if (this.cqr != null) {
                this.cqp.addAll(this.cqr);
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
            this.cbi.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.cqs = new Date(optLong);
            } else {
                this.cqs = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.cqt = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.cqn.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cqo.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.cqu = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.cqq.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.cqr.add(forumData4);
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
