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
    private int eDJ;
    private int igh = 0;
    private int igi = 0;
    private ArrayList<ForumData> iga = new ArrayList<>();
    private ArrayList<ForumData> igb = new ArrayList<>();
    private ArrayList<ForumData> igc = new ArrayList<>();
    private ArrayList<ForumData> igd = new ArrayList<>();
    private ArrayList<ForumData> igf = new ArrayList<>();
    private ArrayList<ForumData> ige = new ArrayList<>();
    private an page = new an();
    private Date igg = null;
    private boolean Hh = true;

    public b() {
        setHasMore(false);
    }

    public int bYW() {
        return this.igh;
    }

    public void yb(int i) {
        this.igh = i;
    }

    public void yc(int i) {
        this.igh += i;
    }

    public int bYX() {
        return this.igi;
    }

    public void yd(int i) {
        this.igi = i;
    }

    public void ye(int i) {
        this.igi += i;
    }

    public ArrayList<ForumData> bYY() {
        return this.igb;
    }

    public ArrayList<ForumData> bYZ() {
        return this.igc;
    }

    public ArrayList<ForumData> bZa() {
        return this.ige;
    }

    public ArrayList<ForumData> bZb() {
        return this.igf;
    }

    public ArrayList<ForumData> bZc() {
        return this.iga;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.iga == null) {
            this.iga = new ArrayList<>();
        }
        if (this.igb != null && arrayList != null) {
            this.igb.clear();
            this.igb.addAll(arrayList);
        }
        if (this.igc != null && arrayList2 != null) {
            this.igc.clear();
            this.igc.addAll(arrayList2);
        }
        if (this.igb != null || this.igc != null) {
            this.iga.clear();
            if (this.igb != null) {
                this.iga.addAll(this.igb);
            }
            if (this.igc != null) {
                this.iga.addAll(this.igc);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.iga == null) {
            this.iga = new ArrayList<>();
        }
        if (this.igb != null && arrayList != null) {
            this.igb.addAll(arrayList);
        }
        if (this.igc != null && arrayList2 != null) {
            this.igc.addAll(arrayList2);
        }
        if (this.igb != null || this.igc != null) {
            this.iga.clear();
            if (this.igb != null) {
                this.iga.addAll(this.igb);
            }
            if (this.igc != null) {
                this.iga.addAll(this.igc);
            }
        }
    }

    public ArrayList<ForumData> bZd() {
        return this.igd;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.igd == null) {
            this.igd = new ArrayList<>();
        }
        if (this.ige != null && arrayList != null) {
            this.ige.addAll(arrayList);
        }
        if (this.igf != null && arrayList2 != null) {
            this.igf.addAll(arrayList2);
        }
        if (this.ige != null || this.igf != null) {
            this.igd.clear();
            if (this.ige != null) {
                this.igd.addAll(this.ige);
            }
            if (this.igf != null) {
                this.igd.addAll(this.igf);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.igd == null) {
            this.igd = new ArrayList<>();
        }
        if (this.ige != null && arrayList != null) {
            this.ige.clear();
            this.ige.addAll(arrayList);
        }
        if (this.igf != null && arrayList2 != null) {
            this.igf.clear();
            this.igf.addAll(arrayList2);
        }
        if (this.ige != null || this.igf != null) {
            this.igd.clear();
            if (this.ige != null) {
                this.igd.addAll(this.ige);
            }
            if (this.igf != null) {
                this.igd.addAll(this.igf);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Hh = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.page.parserJson(jSONObject.optJSONObject("page"));
            this.eDJ = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.igg = new Date(optLong);
            } else {
                this.igg = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.igh = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.igb.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.igc.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.igi = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.ige.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.igf.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Hh = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.eDJ == 1;
    }

    public void setHasMore(boolean z) {
        this.eDJ = z ? 1 : 0;
    }
}
