package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.am;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private int cCk;
    private int fWD = 0;
    private int fWE = 0;
    private ArrayList<ForumData> fWw = new ArrayList<>();
    private ArrayList<ForumData> fWx = new ArrayList<>();
    private ArrayList<ForumData> fWy = new ArrayList<>();
    private ArrayList<ForumData> fWz = new ArrayList<>();
    private ArrayList<ForumData> fWB = new ArrayList<>();
    private ArrayList<ForumData> fWA = new ArrayList<>();
    private am eDN = new am();
    private Date fWC = null;
    private boolean Gr = true;

    public a() {
        setHasMore(false);
    }

    public int bjS() {
        return this.fWD;
    }

    public void ru(int i) {
        this.fWD = i;
    }

    public void rv(int i) {
        this.fWD += i;
    }

    public int bjT() {
        return this.fWE;
    }

    public void rw(int i) {
        this.fWE = i;
    }

    public void rx(int i) {
        this.fWE += i;
    }

    public ArrayList<ForumData> bjU() {
        return this.fWx;
    }

    public ArrayList<ForumData> bjV() {
        return this.fWy;
    }

    public ArrayList<ForumData> bjW() {
        return this.fWA;
    }

    public ArrayList<ForumData> bjX() {
        return this.fWB;
    }

    public ArrayList<ForumData> bjY() {
        return this.fWw;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fWw == null) {
            this.fWw = new ArrayList<>();
        }
        if (this.fWx != null && arrayList != null) {
            this.fWx.clear();
            this.fWx.addAll(arrayList);
        }
        if (this.fWy != null && arrayList2 != null) {
            this.fWy.clear();
            this.fWy.addAll(arrayList2);
        }
        if (this.fWx != null || this.fWy != null) {
            this.fWw.clear();
            if (this.fWx != null) {
                this.fWw.addAll(this.fWx);
            }
            if (this.fWy != null) {
                this.fWw.addAll(this.fWy);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fWw == null) {
            this.fWw = new ArrayList<>();
        }
        if (this.fWx != null && arrayList != null) {
            this.fWx.addAll(arrayList);
        }
        if (this.fWy != null && arrayList2 != null) {
            this.fWy.addAll(arrayList2);
        }
        if (this.fWx != null || this.fWy != null) {
            this.fWw.clear();
            if (this.fWx != null) {
                this.fWw.addAll(this.fWx);
            }
            if (this.fWy != null) {
                this.fWw.addAll(this.fWy);
            }
        }
    }

    public ArrayList<ForumData> bjZ() {
        return this.fWz;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fWz == null) {
            this.fWz = new ArrayList<>();
        }
        if (this.fWA != null && arrayList != null) {
            this.fWA.addAll(arrayList);
        }
        if (this.fWB != null && arrayList2 != null) {
            this.fWB.addAll(arrayList2);
        }
        if (this.fWA != null || this.fWB != null) {
            this.fWz.clear();
            if (this.fWA != null) {
                this.fWz.addAll(this.fWA);
            }
            if (this.fWB != null) {
                this.fWz.addAll(this.fWB);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fWz == null) {
            this.fWz = new ArrayList<>();
        }
        if (this.fWA != null && arrayList != null) {
            this.fWA.clear();
            this.fWA.addAll(arrayList);
        }
        if (this.fWB != null && arrayList2 != null) {
            this.fWB.clear();
            this.fWB.addAll(arrayList2);
        }
        if (this.fWA != null || this.fWB != null) {
            this.fWz.clear();
            if (this.fWA != null) {
                this.fWz.addAll(this.fWA);
            }
            if (this.fWB != null) {
                this.fWz.addAll(this.fWB);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Gr = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.eDN.parserJson(jSONObject.optJSONObject("page"));
            this.cCk = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.fWC = new Date(optLong);
            } else {
                this.fWC = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.fWD = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.fWx.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.fWy.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.fWE = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.fWA.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.fWB.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Gr = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.cCk == 1;
    }

    public void setHasMore(boolean z) {
        this.cCk = z ? 1 : 0;
    }
}
