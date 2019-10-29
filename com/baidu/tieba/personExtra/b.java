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
    private int eTa;
    private int iob = 0;
    private int ioc = 0;
    private ArrayList<ForumData> inU = new ArrayList<>();
    private ArrayList<ForumData> inV = new ArrayList<>();
    private ArrayList<ForumData> inW = new ArrayList<>();
    private ArrayList<ForumData> inX = new ArrayList<>();
    private ArrayList<ForumData> inZ = new ArrayList<>();
    private ArrayList<ForumData> inY = new ArrayList<>();
    private an page = new an();
    private Date ioa = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int bZS() {
        return this.iob;
    }

    public void xq(int i) {
        this.iob = i;
    }

    public void xr(int i) {
        this.iob += i;
    }

    public int bZT() {
        return this.ioc;
    }

    public void xs(int i) {
        this.ioc = i;
    }

    public void xt(int i) {
        this.ioc += i;
    }

    public ArrayList<ForumData> bZU() {
        return this.inV;
    }

    public ArrayList<ForumData> bZV() {
        return this.inW;
    }

    public ArrayList<ForumData> bZW() {
        return this.inY;
    }

    public ArrayList<ForumData> bZX() {
        return this.inZ;
    }

    public ArrayList<ForumData> bZY() {
        return this.inU;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.inU == null) {
            this.inU = new ArrayList<>();
        }
        if (this.inV != null && arrayList != null) {
            this.inV.clear();
            this.inV.addAll(arrayList);
        }
        if (this.inW != null && arrayList2 != null) {
            this.inW.clear();
            this.inW.addAll(arrayList2);
        }
        if (this.inV != null || this.inW != null) {
            this.inU.clear();
            if (this.inV != null) {
                this.inU.addAll(this.inV);
            }
            if (this.inW != null) {
                this.inU.addAll(this.inW);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.inU == null) {
            this.inU = new ArrayList<>();
        }
        if (this.inV != null && arrayList != null) {
            this.inV.addAll(arrayList);
        }
        if (this.inW != null && arrayList2 != null) {
            this.inW.addAll(arrayList2);
        }
        if (this.inV != null || this.inW != null) {
            this.inU.clear();
            if (this.inV != null) {
                this.inU.addAll(this.inV);
            }
            if (this.inW != null) {
                this.inU.addAll(this.inW);
            }
        }
    }

    public ArrayList<ForumData> bZZ() {
        return this.inX;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.inX == null) {
            this.inX = new ArrayList<>();
        }
        if (this.inY != null && arrayList != null) {
            this.inY.addAll(arrayList);
        }
        if (this.inZ != null && arrayList2 != null) {
            this.inZ.addAll(arrayList2);
        }
        if (this.inY != null || this.inZ != null) {
            this.inX.clear();
            if (this.inY != null) {
                this.inX.addAll(this.inY);
            }
            if (this.inZ != null) {
                this.inX.addAll(this.inZ);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.inX == null) {
            this.inX = new ArrayList<>();
        }
        if (this.inY != null && arrayList != null) {
            this.inY.clear();
            this.inY.addAll(arrayList);
        }
        if (this.inZ != null && arrayList2 != null) {
            this.inZ.clear();
            this.inZ.addAll(arrayList2);
        }
        if (this.inY != null || this.inZ != null) {
            this.inX.clear();
            if (this.inY != null) {
                this.inX.addAll(this.inY);
            }
            if (this.inZ != null) {
                this.inX.addAll(this.inZ);
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
            this.eTa = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.ioa = new Date(optLong);
            } else {
                this.ioa = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.iob = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.inV.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.inW.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.ioc = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.inY.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.inZ.add(forumData4);
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
        return this.eTa == 1;
    }

    public void setHasMore(boolean z) {
        this.eTa = z ? 1 : 0;
    }
}
