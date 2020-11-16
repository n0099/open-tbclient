package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.aw;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class b {
    private int jsm;
    private int lYD = 0;
    private int lYE = 0;
    private ArrayList<ForumData> lYw = new ArrayList<>();
    private ArrayList<ForumData> lYx = new ArrayList<>();
    private ArrayList<ForumData> lYy = new ArrayList<>();
    private ArrayList<ForumData> lYz = new ArrayList<>();
    private ArrayList<ForumData> lYB = new ArrayList<>();
    private ArrayList<ForumData> lYA = new ArrayList<>();
    private aw page = new aw();
    private Date lYC = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int dtK() {
        return this.lYD;
    }

    public void Hq(int i) {
        this.lYD = i;
    }

    public void Hr(int i) {
        this.lYD += i;
    }

    public int dtL() {
        return this.lYE;
    }

    public void Hs(int i) {
        this.lYE = i;
    }

    public void Ht(int i) {
        this.lYE += i;
    }

    public ArrayList<ForumData> dtM() {
        return this.lYx;
    }

    public ArrayList<ForumData> dtN() {
        return this.lYy;
    }

    public ArrayList<ForumData> dtO() {
        return this.lYA;
    }

    public ArrayList<ForumData> dtP() {
        return this.lYB;
    }

    public ArrayList<ForumData> dtQ() {
        return this.lYw;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lYw == null) {
            this.lYw = new ArrayList<>();
        }
        if (this.lYx != null && arrayList != null) {
            this.lYx.clear();
            this.lYx.addAll(arrayList);
        }
        if (this.lYy != null && arrayList2 != null) {
            this.lYy.clear();
            this.lYy.addAll(arrayList2);
        }
        if (this.lYx != null || this.lYy != null) {
            this.lYw.clear();
            if (this.lYx != null) {
                this.lYw.addAll(this.lYx);
            }
            if (this.lYy != null) {
                this.lYw.addAll(this.lYy);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lYw == null) {
            this.lYw = new ArrayList<>();
        }
        if (this.lYx != null && arrayList != null) {
            this.lYx.addAll(arrayList);
        }
        if (this.lYy != null && arrayList2 != null) {
            this.lYy.addAll(arrayList2);
        }
        if (this.lYx != null || this.lYy != null) {
            this.lYw.clear();
            if (this.lYx != null) {
                this.lYw.addAll(this.lYx);
            }
            if (this.lYy != null) {
                this.lYw.addAll(this.lYy);
            }
        }
    }

    public ArrayList<ForumData> dtR() {
        return this.lYz;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lYz == null) {
            this.lYz = new ArrayList<>();
        }
        if (this.lYA != null && arrayList != null) {
            this.lYA.addAll(arrayList);
        }
        if (this.lYB != null && arrayList2 != null) {
            this.lYB.addAll(arrayList2);
        }
        if (this.lYA != null || this.lYB != null) {
            this.lYz.clear();
            if (this.lYA != null) {
                this.lYz.addAll(this.lYA);
            }
            if (this.lYB != null) {
                this.lYz.addAll(this.lYB);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lYz == null) {
            this.lYz = new ArrayList<>();
        }
        if (this.lYA != null && arrayList != null) {
            this.lYA.clear();
            this.lYA.addAll(arrayList);
        }
        if (this.lYB != null && arrayList2 != null) {
            this.lYB.clear();
            this.lYB.addAll(arrayList2);
        }
        if (this.lYA != null || this.lYB != null) {
            this.lYz.clear();
            if (this.lYA != null) {
                this.lYz.addAll(this.lYA);
            }
            if (this.lYB != null) {
                this.lYz.addAll(this.lYB);
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
            this.jsm = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.lYC = new Date(optLong);
            } else {
                this.lYC = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.lYD = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.lYx.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.lYy.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.lYE = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.lYA.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.lYB.add(forumData4);
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
        return this.jsm == 1;
    }

    public void setHasMore(boolean z) {
        this.jsm = z ? 1 : 0;
    }
}
