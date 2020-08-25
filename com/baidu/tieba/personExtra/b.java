package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class b {
    private int iCU;
    private int lhE = 0;
    private int lhF = 0;
    private ArrayList<ForumData> lhx = new ArrayList<>();
    private ArrayList<ForumData> lhy = new ArrayList<>();
    private ArrayList<ForumData> lhz = new ArrayList<>();
    private ArrayList<ForumData> lhA = new ArrayList<>();
    private ArrayList<ForumData> lhC = new ArrayList<>();
    private ArrayList<ForumData> lhB = new ArrayList<>();
    private av page = new av();
    private Date lhD = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int dhl() {
        return this.lhE;
    }

    public void Ff(int i) {
        this.lhE = i;
    }

    public void Fg(int i) {
        this.lhE += i;
    }

    public int dhm() {
        return this.lhF;
    }

    public void Fh(int i) {
        this.lhF = i;
    }

    public void Fi(int i) {
        this.lhF += i;
    }

    public ArrayList<ForumData> dhn() {
        return this.lhy;
    }

    public ArrayList<ForumData> dho() {
        return this.lhz;
    }

    public ArrayList<ForumData> dhp() {
        return this.lhB;
    }

    public ArrayList<ForumData> dhq() {
        return this.lhC;
    }

    public ArrayList<ForumData> dhr() {
        return this.lhx;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lhx == null) {
            this.lhx = new ArrayList<>();
        }
        if (this.lhy != null && arrayList != null) {
            this.lhy.clear();
            this.lhy.addAll(arrayList);
        }
        if (this.lhz != null && arrayList2 != null) {
            this.lhz.clear();
            this.lhz.addAll(arrayList2);
        }
        if (this.lhy != null || this.lhz != null) {
            this.lhx.clear();
            if (this.lhy != null) {
                this.lhx.addAll(this.lhy);
            }
            if (this.lhz != null) {
                this.lhx.addAll(this.lhz);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lhx == null) {
            this.lhx = new ArrayList<>();
        }
        if (this.lhy != null && arrayList != null) {
            this.lhy.addAll(arrayList);
        }
        if (this.lhz != null && arrayList2 != null) {
            this.lhz.addAll(arrayList2);
        }
        if (this.lhy != null || this.lhz != null) {
            this.lhx.clear();
            if (this.lhy != null) {
                this.lhx.addAll(this.lhy);
            }
            if (this.lhz != null) {
                this.lhx.addAll(this.lhz);
            }
        }
    }

    public ArrayList<ForumData> dhs() {
        return this.lhA;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lhA == null) {
            this.lhA = new ArrayList<>();
        }
        if (this.lhB != null && arrayList != null) {
            this.lhB.addAll(arrayList);
        }
        if (this.lhC != null && arrayList2 != null) {
            this.lhC.addAll(arrayList2);
        }
        if (this.lhB != null || this.lhC != null) {
            this.lhA.clear();
            if (this.lhB != null) {
                this.lhA.addAll(this.lhB);
            }
            if (this.lhC != null) {
                this.lhA.addAll(this.lhC);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lhA == null) {
            this.lhA = new ArrayList<>();
        }
        if (this.lhB != null && arrayList != null) {
            this.lhB.clear();
            this.lhB.addAll(arrayList);
        }
        if (this.lhC != null && arrayList2 != null) {
            this.lhC.clear();
            this.lhC.addAll(arrayList2);
        }
        if (this.lhB != null || this.lhC != null) {
            this.lhA.clear();
            if (this.lhB != null) {
                this.lhA.addAll(this.lhB);
            }
            if (this.lhC != null) {
                this.lhA.addAll(this.lhC);
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
            this.iCU = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.lhD = new Date(optLong);
            } else {
                this.lhD = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.lhE = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.lhy.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.lhz.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.lhF = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.lhB.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.lhC.add(forumData4);
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
        return this.iCU == 1;
    }

    public void setHasMore(boolean z) {
        this.iCU = z ? 1 : 0;
    }
}
