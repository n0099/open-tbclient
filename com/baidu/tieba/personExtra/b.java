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
    private int mrW = 0;
    private int mrX = 0;
    private ArrayList<ForumData> mrP = new ArrayList<>();
    private ArrayList<ForumData> mrQ = new ArrayList<>();
    private ArrayList<ForumData> mrR = new ArrayList<>();
    private ArrayList<ForumData> mrS = new ArrayList<>();
    private ArrayList<ForumData> mrU = new ArrayList<>();
    private ArrayList<ForumData> mrT = new ArrayList<>();
    private ax page = new ax();
    private Date mrV = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int dyT() {
        return this.mrW;
    }

    public void Ia(int i) {
        this.mrW = i;
    }

    public void Ib(int i) {
        this.mrW += i;
    }

    public int dyU() {
        return this.mrX;
    }

    public void Ic(int i) {
        this.mrX = i;
    }

    public void Id(int i) {
        this.mrX += i;
    }

    public ArrayList<ForumData> dyV() {
        return this.mrQ;
    }

    public ArrayList<ForumData> dyW() {
        return this.mrR;
    }

    public ArrayList<ForumData> dyX() {
        return this.mrT;
    }

    public ArrayList<ForumData> dyY() {
        return this.mrU;
    }

    public ArrayList<ForumData> dyZ() {
        return this.mrP;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mrP == null) {
            this.mrP = new ArrayList<>();
        }
        if (this.mrQ != null && arrayList != null) {
            this.mrQ.clear();
            this.mrQ.addAll(arrayList);
        }
        if (this.mrR != null && arrayList2 != null) {
            this.mrR.clear();
            this.mrR.addAll(arrayList2);
        }
        if (this.mrQ != null || this.mrR != null) {
            this.mrP.clear();
            if (this.mrQ != null) {
                this.mrP.addAll(this.mrQ);
            }
            if (this.mrR != null) {
                this.mrP.addAll(this.mrR);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mrP == null) {
            this.mrP = new ArrayList<>();
        }
        if (this.mrQ != null && arrayList != null) {
            this.mrQ.addAll(arrayList);
        }
        if (this.mrR != null && arrayList2 != null) {
            this.mrR.addAll(arrayList2);
        }
        if (this.mrQ != null || this.mrR != null) {
            this.mrP.clear();
            if (this.mrQ != null) {
                this.mrP.addAll(this.mrQ);
            }
            if (this.mrR != null) {
                this.mrP.addAll(this.mrR);
            }
        }
    }

    public ArrayList<ForumData> dza() {
        return this.mrS;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mrS == null) {
            this.mrS = new ArrayList<>();
        }
        if (this.mrT != null && arrayList != null) {
            this.mrT.addAll(arrayList);
        }
        if (this.mrU != null && arrayList2 != null) {
            this.mrU.addAll(arrayList2);
        }
        if (this.mrT != null || this.mrU != null) {
            this.mrS.clear();
            if (this.mrT != null) {
                this.mrS.addAll(this.mrT);
            }
            if (this.mrU != null) {
                this.mrS.addAll(this.mrU);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mrS == null) {
            this.mrS = new ArrayList<>();
        }
        if (this.mrT != null && arrayList != null) {
            this.mrT.clear();
            this.mrT.addAll(arrayList);
        }
        if (this.mrU != null && arrayList2 != null) {
            this.mrU.clear();
            this.mrU.addAll(arrayList2);
        }
        if (this.mrT != null || this.mrU != null) {
            this.mrS.clear();
            if (this.mrT != null) {
                this.mrS.addAll(this.mrT);
            }
            if (this.mrU != null) {
                this.mrS.addAll(this.mrU);
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
                this.mrV = new Date(optLong);
            } else {
                this.mrV = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.mrW = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.mrQ.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.mrR.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.mrX = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.mrT.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.mrU.add(forumData4);
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
