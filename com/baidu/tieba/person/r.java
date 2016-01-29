package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private int bfj;
    private int cXy = 0;
    private int cXz = 0;
    private ArrayList<ForumData> cXr = new ArrayList<>();
    private ArrayList<ForumData> cXs = new ArrayList<>();
    private ArrayList<ForumData> cXt = new ArrayList<>();
    private ArrayList<ForumData> cXu = new ArrayList<>();
    private ArrayList<ForumData> cXw = new ArrayList<>();
    private ArrayList<ForumData> cXv = new ArrayList<>();
    private com.baidu.tbadk.core.data.u cnk = new com.baidu.tbadk.core.data.u();
    private Date cXx = null;
    private boolean CF = true;

    public r() {
        setHasMore(false);
    }

    public int atr() {
        return this.cXy;
    }

    public void ll(int i) {
        this.cXy = i;
    }

    public void lm(int i) {
        this.cXy += i;
    }

    public int ats() {
        return this.cXz;
    }

    public void ln(int i) {
        this.cXz = i;
    }

    public void lo(int i) {
        this.cXz += i;
    }

    public ArrayList<ForumData> att() {
        return this.cXs;
    }

    public ArrayList<ForumData> atu() {
        return this.cXt;
    }

    public ArrayList<ForumData> atv() {
        return this.cXv;
    }

    public ArrayList<ForumData> atw() {
        return this.cXw;
    }

    public ArrayList<ForumData> atx() {
        return this.cXr;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cXr == null) {
            this.cXr = new ArrayList<>();
        }
        if (this.cXs != null && arrayList != null) {
            this.cXs.clear();
            this.cXs.addAll(arrayList);
        }
        if (this.cXt != null && arrayList2 != null) {
            this.cXt.clear();
            this.cXt.addAll(arrayList2);
        }
        if (this.cXs != null || this.cXt != null) {
            this.cXr.clear();
            if (this.cXs != null) {
                this.cXr.addAll(this.cXs);
            }
            if (this.cXt != null) {
                this.cXr.addAll(this.cXt);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cXr == null) {
            this.cXr = new ArrayList<>();
        }
        if (this.cXs != null && arrayList != null) {
            this.cXs.addAll(arrayList);
        }
        if (this.cXt != null && arrayList2 != null) {
            this.cXt.addAll(arrayList2);
        }
        if (this.cXs != null || this.cXt != null) {
            this.cXr.clear();
            if (this.cXs != null) {
                this.cXr.addAll(this.cXs);
            }
            if (this.cXt != null) {
                this.cXr.addAll(this.cXt);
            }
        }
    }

    public ArrayList<ForumData> aty() {
        return this.cXu;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cXu == null) {
            this.cXu = new ArrayList<>();
        }
        if (this.cXv != null && arrayList != null) {
            this.cXv.addAll(arrayList);
        }
        if (this.cXw != null && arrayList2 != null) {
            this.cXw.addAll(arrayList2);
        }
        if (this.cXv != null || this.cXw != null) {
            this.cXu.clear();
            if (this.cXv != null) {
                this.cXu.addAll(this.cXv);
            }
            if (this.cXw != null) {
                this.cXu.addAll(this.cXw);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cXu == null) {
            this.cXu = new ArrayList<>();
        }
        if (this.cXv != null && arrayList != null) {
            this.cXv.clear();
            this.cXv.addAll(arrayList);
        }
        if (this.cXw != null && arrayList2 != null) {
            this.cXw.clear();
            this.cXw.addAll(arrayList2);
        }
        if (this.cXv != null || this.cXw != null) {
            this.cXu.clear();
            if (this.cXv != null) {
                this.cXu.addAll(this.cXv);
            }
            if (this.cXw != null) {
                this.cXu.addAll(this.cXw);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.CF = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.cnk.parserJson(jSONObject.optJSONObject("page"));
            this.bfj = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.cXx = new Date(optLong);
            } else {
                this.cXx = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.cXy = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.cXs.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cXt.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.cXz = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.cXv.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.cXw.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.CF = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.bfj == 1;
    }

    public void setHasMore(boolean z) {
        this.bfj = z ? 1 : 0;
    }
}
