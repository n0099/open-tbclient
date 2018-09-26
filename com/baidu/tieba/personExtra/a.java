package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.al;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private int cKD;
    private int gej = 0;
    private int gek = 0;
    private ArrayList<ForumData> gec = new ArrayList<>();
    private ArrayList<ForumData> ged = new ArrayList<>();
    private ArrayList<ForumData> gee = new ArrayList<>();
    private ArrayList<ForumData> gef = new ArrayList<>();
    private ArrayList<ForumData> geh = new ArrayList<>();
    private ArrayList<ForumData> geg = new ArrayList<>();
    private al eOS = new al();
    private Date gei = null;
    private boolean IM = true;

    public a() {
        setHasMore(false);
    }

    public int bkJ() {
        return this.gej;
    }

    public void rO(int i) {
        this.gej = i;
    }

    public void rP(int i) {
        this.gej += i;
    }

    public int bkK() {
        return this.gek;
    }

    public void rQ(int i) {
        this.gek = i;
    }

    public void rR(int i) {
        this.gek += i;
    }

    public ArrayList<ForumData> bkL() {
        return this.ged;
    }

    public ArrayList<ForumData> bkM() {
        return this.gee;
    }

    public ArrayList<ForumData> bkN() {
        return this.geg;
    }

    public ArrayList<ForumData> bkO() {
        return this.geh;
    }

    public ArrayList<ForumData> bkP() {
        return this.gec;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gec == null) {
            this.gec = new ArrayList<>();
        }
        if (this.ged != null && arrayList != null) {
            this.ged.clear();
            this.ged.addAll(arrayList);
        }
        if (this.gee != null && arrayList2 != null) {
            this.gee.clear();
            this.gee.addAll(arrayList2);
        }
        if (this.ged != null || this.gee != null) {
            this.gec.clear();
            if (this.ged != null) {
                this.gec.addAll(this.ged);
            }
            if (this.gee != null) {
                this.gec.addAll(this.gee);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gec == null) {
            this.gec = new ArrayList<>();
        }
        if (this.ged != null && arrayList != null) {
            this.ged.addAll(arrayList);
        }
        if (this.gee != null && arrayList2 != null) {
            this.gee.addAll(arrayList2);
        }
        if (this.ged != null || this.gee != null) {
            this.gec.clear();
            if (this.ged != null) {
                this.gec.addAll(this.ged);
            }
            if (this.gee != null) {
                this.gec.addAll(this.gee);
            }
        }
    }

    public ArrayList<ForumData> bkQ() {
        return this.gef;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gef == null) {
            this.gef = new ArrayList<>();
        }
        if (this.geg != null && arrayList != null) {
            this.geg.addAll(arrayList);
        }
        if (this.geh != null && arrayList2 != null) {
            this.geh.addAll(arrayList2);
        }
        if (this.geg != null || this.geh != null) {
            this.gef.clear();
            if (this.geg != null) {
                this.gef.addAll(this.geg);
            }
            if (this.geh != null) {
                this.gef.addAll(this.geh);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gef == null) {
            this.gef = new ArrayList<>();
        }
        if (this.geg != null && arrayList != null) {
            this.geg.clear();
            this.geg.addAll(arrayList);
        }
        if (this.geh != null && arrayList2 != null) {
            this.geh.clear();
            this.geh.addAll(arrayList2);
        }
        if (this.geg != null || this.geh != null) {
            this.gef.clear();
            if (this.geg != null) {
                this.gef.addAll(this.geg);
            }
            if (this.geh != null) {
                this.gef.addAll(this.geh);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.IM = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.eOS.parserJson(jSONObject.optJSONObject("page"));
            this.cKD = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.gei = new Date(optLong);
            } else {
                this.gei = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.gej = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.ged.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.gee.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.gek = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.geg.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.geh.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.IM = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.cKD == 1;
    }

    public void setHasMore(boolean z) {
        this.cKD = z ? 1 : 0;
    }
}
