package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ax;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private int jTg;
    private int mrX = 0;
    private int mrY = 0;
    private ArrayList<ForumData> mrQ = new ArrayList<>();
    private ArrayList<ForumData> mrR = new ArrayList<>();
    private ArrayList<ForumData> mrS = new ArrayList<>();
    private ArrayList<ForumData> mrT = new ArrayList<>();
    private ArrayList<ForumData> mrV = new ArrayList<>();
    private ArrayList<ForumData> mrU = new ArrayList<>();
    private ax page = new ax();
    private Date mrW = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int dyS() {
        return this.mrX;
    }

    public void Ia(int i) {
        this.mrX = i;
    }

    public void Ib(int i) {
        this.mrX += i;
    }

    public int dyT() {
        return this.mrY;
    }

    public void Ic(int i) {
        this.mrY = i;
    }

    public void Id(int i) {
        this.mrY += i;
    }

    public ArrayList<ForumData> dyU() {
        return this.mrR;
    }

    public ArrayList<ForumData> dyV() {
        return this.mrS;
    }

    public ArrayList<ForumData> dyW() {
        return this.mrU;
    }

    public ArrayList<ForumData> dyX() {
        return this.mrV;
    }

    public ArrayList<ForumData> dyY() {
        return this.mrQ;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mrQ == null) {
            this.mrQ = new ArrayList<>();
        }
        if (this.mrR != null && arrayList != null) {
            this.mrR.clear();
            this.mrR.addAll(arrayList);
        }
        if (this.mrS != null && arrayList2 != null) {
            this.mrS.clear();
            this.mrS.addAll(arrayList2);
        }
        if (this.mrR != null || this.mrS != null) {
            this.mrQ.clear();
            if (this.mrR != null) {
                this.mrQ.addAll(this.mrR);
            }
            if (this.mrS != null) {
                this.mrQ.addAll(this.mrS);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mrQ == null) {
            this.mrQ = new ArrayList<>();
        }
        if (this.mrR != null && arrayList != null) {
            this.mrR.addAll(arrayList);
        }
        if (this.mrS != null && arrayList2 != null) {
            this.mrS.addAll(arrayList2);
        }
        if (this.mrR != null || this.mrS != null) {
            this.mrQ.clear();
            if (this.mrR != null) {
                this.mrQ.addAll(this.mrR);
            }
            if (this.mrS != null) {
                this.mrQ.addAll(this.mrS);
            }
        }
    }

    public ArrayList<ForumData> dyZ() {
        return this.mrT;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mrT == null) {
            this.mrT = new ArrayList<>();
        }
        if (this.mrU != null && arrayList != null) {
            this.mrU.addAll(arrayList);
        }
        if (this.mrV != null && arrayList2 != null) {
            this.mrV.addAll(arrayList2);
        }
        if (this.mrU != null || this.mrV != null) {
            this.mrT.clear();
            if (this.mrU != null) {
                this.mrT.addAll(this.mrU);
            }
            if (this.mrV != null) {
                this.mrT.addAll(this.mrV);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mrT == null) {
            this.mrT = new ArrayList<>();
        }
        if (this.mrU != null && arrayList != null) {
            this.mrU.clear();
            this.mrU.addAll(arrayList);
        }
        if (this.mrV != null && arrayList2 != null) {
            this.mrV.clear();
            this.mrV.addAll(arrayList2);
        }
        if (this.mrU != null || this.mrV != null) {
            this.mrT.clear();
            if (this.mrU != null) {
                this.mrT.addAll(this.mrU);
            }
            if (this.mrV != null) {
                this.mrT.addAll(this.mrV);
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
            this.jTg = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.mrW = new Date(optLong);
            } else {
                this.mrW = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.mrX = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.mrR.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.mrS.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.mrY = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.mrU.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.mrV.add(forumData4);
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
        return this.jTg == 1;
    }

    public void setHasMore(boolean z) {
        this.jTg = z ? 1 : 0;
    }
}
