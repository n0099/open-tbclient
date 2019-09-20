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
    private int eKv;
    private int ipC = 0;
    private int ipD = 0;
    private ArrayList<ForumData> ipv = new ArrayList<>();
    private ArrayList<ForumData> ipw = new ArrayList<>();
    private ArrayList<ForumData> ipx = new ArrayList<>();
    private ArrayList<ForumData> ipy = new ArrayList<>();
    private ArrayList<ForumData> ipA = new ArrayList<>();
    private ArrayList<ForumData> ipz = new ArrayList<>();
    private an page = new an();
    private Date ipB = null;
    private boolean Hs = true;

    public b() {
        setHasMore(false);
    }

    public int ccR() {
        return this.ipC;
    }

    public void yL(int i) {
        this.ipC = i;
    }

    public void yM(int i) {
        this.ipC += i;
    }

    public int ccS() {
        return this.ipD;
    }

    public void yN(int i) {
        this.ipD = i;
    }

    public void yO(int i) {
        this.ipD += i;
    }

    public ArrayList<ForumData> ccT() {
        return this.ipw;
    }

    public ArrayList<ForumData> ccU() {
        return this.ipx;
    }

    public ArrayList<ForumData> ccV() {
        return this.ipz;
    }

    public ArrayList<ForumData> ccW() {
        return this.ipA;
    }

    public ArrayList<ForumData> ccX() {
        return this.ipv;
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.ipv == null) {
            this.ipv = new ArrayList<>();
        }
        if (this.ipw != null && arrayList != null) {
            this.ipw.clear();
            this.ipw.addAll(arrayList);
        }
        if (this.ipx != null && arrayList2 != null) {
            this.ipx.clear();
            this.ipx.addAll(arrayList2);
        }
        if (this.ipw != null || this.ipx != null) {
            this.ipv.clear();
            if (this.ipw != null) {
                this.ipv.addAll(this.ipw);
            }
            if (this.ipx != null) {
                this.ipv.addAll(this.ipx);
            }
        }
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.ipv == null) {
            this.ipv = new ArrayList<>();
        }
        if (this.ipw != null && arrayList != null) {
            this.ipw.addAll(arrayList);
        }
        if (this.ipx != null && arrayList2 != null) {
            this.ipx.addAll(arrayList2);
        }
        if (this.ipw != null || this.ipx != null) {
            this.ipv.clear();
            if (this.ipw != null) {
                this.ipv.addAll(this.ipw);
            }
            if (this.ipx != null) {
                this.ipv.addAll(this.ipx);
            }
        }
    }

    public ArrayList<ForumData> ccY() {
        return this.ipy;
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.ipy == null) {
            this.ipy = new ArrayList<>();
        }
        if (this.ipz != null && arrayList != null) {
            this.ipz.addAll(arrayList);
        }
        if (this.ipA != null && arrayList2 != null) {
            this.ipA.addAll(arrayList2);
        }
        if (this.ipz != null || this.ipA != null) {
            this.ipy.clear();
            if (this.ipz != null) {
                this.ipy.addAll(this.ipz);
            }
            if (this.ipA != null) {
                this.ipy.addAll(this.ipA);
            }
        }
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.ipy == null) {
            this.ipy = new ArrayList<>();
        }
        if (this.ipz != null && arrayList != null) {
            this.ipz.clear();
            this.ipz.addAll(arrayList);
        }
        if (this.ipA != null && arrayList2 != null) {
            this.ipA.clear();
            this.ipA.addAll(arrayList2);
        }
        if (this.ipz != null || this.ipA != null) {
            this.ipy.clear();
            if (this.ipz != null) {
                this.ipy.addAll(this.ipz);
            }
            if (this.ipA != null) {
                this.ipy.addAll(this.ipA);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Hs = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.page.parserJson(jSONObject.optJSONObject("page"));
            this.eKv = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.ipB = new Date(optLong);
            } else {
                this.ipB = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.ipC = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.ipw.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.ipx.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.ipD = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.ipz.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.ipA.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Hs = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.eKv == 1;
    }

    public void setHasMore(boolean z) {
        this.eKv = z ? 1 : 0;
    }
}
