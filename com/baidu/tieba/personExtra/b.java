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
    private int eIM;
    private int inD = 0;
    private int inE = 0;
    private ArrayList<ForumData> inw = new ArrayList<>();
    private ArrayList<ForumData> inx = new ArrayList<>();
    private ArrayList<ForumData> iny = new ArrayList<>();
    private ArrayList<ForumData> inz = new ArrayList<>();
    private ArrayList<ForumData> inB = new ArrayList<>();
    private ArrayList<ForumData> inA = new ArrayList<>();
    private an page = new an();
    private Date inC = null;
    private boolean Hs = true;

    public b() {
        setHasMore(false);
    }

    public int ccd() {
        return this.inD;
    }

    public void yI(int i) {
        this.inD = i;
    }

    public void yJ(int i) {
        this.inD += i;
    }

    public int cce() {
        return this.inE;
    }

    public void yK(int i) {
        this.inE = i;
    }

    public void yL(int i) {
        this.inE += i;
    }

    public ArrayList<ForumData> ccf() {
        return this.inx;
    }

    public ArrayList<ForumData> ccg() {
        return this.iny;
    }

    public ArrayList<ForumData> cch() {
        return this.inA;
    }

    public ArrayList<ForumData> cci() {
        return this.inB;
    }

    public ArrayList<ForumData> ccj() {
        return this.inw;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.inw == null) {
            this.inw = new ArrayList<>();
        }
        if (this.inx != null && arrayList != null) {
            this.inx.clear();
            this.inx.addAll(arrayList);
        }
        if (this.iny != null && arrayList2 != null) {
            this.iny.clear();
            this.iny.addAll(arrayList2);
        }
        if (this.inx != null || this.iny != null) {
            this.inw.clear();
            if (this.inx != null) {
                this.inw.addAll(this.inx);
            }
            if (this.iny != null) {
                this.inw.addAll(this.iny);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.inw == null) {
            this.inw = new ArrayList<>();
        }
        if (this.inx != null && arrayList != null) {
            this.inx.addAll(arrayList);
        }
        if (this.iny != null && arrayList2 != null) {
            this.iny.addAll(arrayList2);
        }
        if (this.inx != null || this.iny != null) {
            this.inw.clear();
            if (this.inx != null) {
                this.inw.addAll(this.inx);
            }
            if (this.iny != null) {
                this.inw.addAll(this.iny);
            }
        }
    }

    public ArrayList<ForumData> cck() {
        return this.inz;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.inz == null) {
            this.inz = new ArrayList<>();
        }
        if (this.inA != null && arrayList != null) {
            this.inA.addAll(arrayList);
        }
        if (this.inB != null && arrayList2 != null) {
            this.inB.addAll(arrayList2);
        }
        if (this.inA != null || this.inB != null) {
            this.inz.clear();
            if (this.inA != null) {
                this.inz.addAll(this.inA);
            }
            if (this.inB != null) {
                this.inz.addAll(this.inB);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.inz == null) {
            this.inz = new ArrayList<>();
        }
        if (this.inA != null && arrayList != null) {
            this.inA.clear();
            this.inA.addAll(arrayList);
        }
        if (this.inB != null && arrayList2 != null) {
            this.inB.clear();
            this.inB.addAll(arrayList2);
        }
        if (this.inA != null || this.inB != null) {
            this.inz.clear();
            if (this.inA != null) {
                this.inz.addAll(this.inA);
            }
            if (this.inB != null) {
                this.inz.addAll(this.inB);
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
            this.eIM = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.inC = new Date(optLong);
            } else {
                this.inC = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.inD = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.inx.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.iny.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.inE = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.inA.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.inB.add(forumData4);
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
        return this.eIM == 1;
    }

    public void setHasMore(boolean z) {
        this.eIM = z ? 1 : 0;
    }
}
