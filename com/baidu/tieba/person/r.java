package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private int Or;
    private int dvw = 0;
    private int dvx = 0;
    private ArrayList<ForumData> dvp = new ArrayList<>();
    private ArrayList<ForumData> dvq = new ArrayList<>();
    private ArrayList<ForumData> dvr = new ArrayList<>();
    private ArrayList<ForumData> dvs = new ArrayList<>();
    private ArrayList<ForumData> dvu = new ArrayList<>();
    private ArrayList<ForumData> dvt = new ArrayList<>();
    private com.baidu.tbadk.core.data.ad cyL = new com.baidu.tbadk.core.data.ad();
    private Date dvv = null;
    private boolean sZ = true;

    public r() {
        setHasMore(false);
    }

    public int aBx() {
        return this.dvw;
    }

    public void mk(int i) {
        this.dvw = i;
    }

    public void ml(int i) {
        this.dvw += i;
    }

    public int aBy() {
        return this.dvx;
    }

    public void mm(int i) {
        this.dvx = i;
    }

    public void mn(int i) {
        this.dvx += i;
    }

    public ArrayList<ForumData> aBz() {
        return this.dvq;
    }

    public ArrayList<ForumData> aBA() {
        return this.dvr;
    }

    public ArrayList<ForumData> aBB() {
        return this.dvt;
    }

    public ArrayList<ForumData> aBC() {
        return this.dvu;
    }

    public ArrayList<ForumData> aBD() {
        return this.dvp;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.dvp == null) {
            this.dvp = new ArrayList<>();
        }
        if (this.dvq != null && arrayList != null) {
            this.dvq.clear();
            this.dvq.addAll(arrayList);
        }
        if (this.dvr != null && arrayList2 != null) {
            this.dvr.clear();
            this.dvr.addAll(arrayList2);
        }
        if (this.dvq != null || this.dvr != null) {
            this.dvp.clear();
            if (this.dvq != null) {
                this.dvp.addAll(this.dvq);
            }
            if (this.dvr != null) {
                this.dvp.addAll(this.dvr);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.dvp == null) {
            this.dvp = new ArrayList<>();
        }
        if (this.dvq != null && arrayList != null) {
            this.dvq.addAll(arrayList);
        }
        if (this.dvr != null && arrayList2 != null) {
            this.dvr.addAll(arrayList2);
        }
        if (this.dvq != null || this.dvr != null) {
            this.dvp.clear();
            if (this.dvq != null) {
                this.dvp.addAll(this.dvq);
            }
            if (this.dvr != null) {
                this.dvp.addAll(this.dvr);
            }
        }
    }

    public ArrayList<ForumData> aBE() {
        return this.dvs;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.dvs == null) {
            this.dvs = new ArrayList<>();
        }
        if (this.dvt != null && arrayList != null) {
            this.dvt.addAll(arrayList);
        }
        if (this.dvu != null && arrayList2 != null) {
            this.dvu.addAll(arrayList2);
        }
        if (this.dvt != null || this.dvu != null) {
            this.dvs.clear();
            if (this.dvt != null) {
                this.dvs.addAll(this.dvt);
            }
            if (this.dvu != null) {
                this.dvs.addAll(this.dvu);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.dvs == null) {
            this.dvs = new ArrayList<>();
        }
        if (this.dvt != null && arrayList != null) {
            this.dvt.clear();
            this.dvt.addAll(arrayList);
        }
        if (this.dvu != null && arrayList2 != null) {
            this.dvu.clear();
            this.dvu.addAll(arrayList2);
        }
        if (this.dvt != null || this.dvu != null) {
            this.dvs.clear();
            if (this.dvt != null) {
                this.dvs.addAll(this.dvt);
            }
            if (this.dvu != null) {
                this.dvs.addAll(this.dvu);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.sZ = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.cyL.parserJson(jSONObject.optJSONObject("page"));
            this.Or = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.dvv = new Date(optLong);
            } else {
                this.dvv = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.dvw = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.dvq.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.dvr.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.dvx = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.dvt.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.dvu.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.sZ = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.Or == 1;
    }

    public void setHasMore(boolean z) {
        this.Or = z ? 1 : 0;
    }
}
