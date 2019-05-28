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
    private int igg = 0;
    private int igh = 0;
    private ArrayList<ForumData> ifZ = new ArrayList<>();
    private ArrayList<ForumData> iga = new ArrayList<>();
    private ArrayList<ForumData> igb = new ArrayList<>();
    private ArrayList<ForumData> igc = new ArrayList<>();
    private ArrayList<ForumData> ige = new ArrayList<>();
    private ArrayList<ForumData> igd = new ArrayList<>();
    private an page = new an();
    private Date igf = null;
    private boolean Hi = true;

    public b() {
        setHasMore(false);
    }

    public int bYV() {
        return this.igg;
    }

    public void yb(int i) {
        this.igg = i;
    }

    public void yc(int i) {
        this.igg += i;
    }

    public int bYW() {
        return this.igh;
    }

    public void yd(int i) {
        this.igh = i;
    }

    public void ye(int i) {
        this.igh += i;
    }

    public ArrayList<ForumData> bYX() {
        return this.iga;
    }

    public ArrayList<ForumData> bYY() {
        return this.igb;
    }

    public ArrayList<ForumData> bYZ() {
        return this.igd;
    }

    public ArrayList<ForumData> bZa() {
        return this.ige;
    }

    public ArrayList<ForumData> bZb() {
        return this.ifZ;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.ifZ == null) {
            this.ifZ = new ArrayList<>();
        }
        if (this.iga != null && arrayList != null) {
            this.iga.clear();
            this.iga.addAll(arrayList);
        }
        if (this.igb != null && arrayList2 != null) {
            this.igb.clear();
            this.igb.addAll(arrayList2);
        }
        if (this.iga != null || this.igb != null) {
            this.ifZ.clear();
            if (this.iga != null) {
                this.ifZ.addAll(this.iga);
            }
            if (this.igb != null) {
                this.ifZ.addAll(this.igb);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.ifZ == null) {
            this.ifZ = new ArrayList<>();
        }
        if (this.iga != null && arrayList != null) {
            this.iga.addAll(arrayList);
        }
        if (this.igb != null && arrayList2 != null) {
            this.igb.addAll(arrayList2);
        }
        if (this.iga != null || this.igb != null) {
            this.ifZ.clear();
            if (this.iga != null) {
                this.ifZ.addAll(this.iga);
            }
            if (this.igb != null) {
                this.ifZ.addAll(this.igb);
            }
        }
    }

    public ArrayList<ForumData> bZc() {
        return this.igc;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.igc == null) {
            this.igc = new ArrayList<>();
        }
        if (this.igd != null && arrayList != null) {
            this.igd.addAll(arrayList);
        }
        if (this.ige != null && arrayList2 != null) {
            this.ige.addAll(arrayList2);
        }
        if (this.igd != null || this.ige != null) {
            this.igc.clear();
            if (this.igd != null) {
                this.igc.addAll(this.igd);
            }
            if (this.ige != null) {
                this.igc.addAll(this.ige);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.igc == null) {
            this.igc = new ArrayList<>();
        }
        if (this.igd != null && arrayList != null) {
            this.igd.clear();
            this.igd.addAll(arrayList);
        }
        if (this.ige != null && arrayList2 != null) {
            this.ige.clear();
            this.ige.addAll(arrayList2);
        }
        if (this.igd != null || this.ige != null) {
            this.igc.clear();
            if (this.igd != null) {
                this.igc.addAll(this.igd);
            }
            if (this.ige != null) {
                this.igc.addAll(this.ige);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Hi = false;
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
                this.igf = new Date(optLong);
            } else {
                this.igf = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.igg = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.iga.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.igb.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.igh = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.igd.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.ige.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Hi = false;
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
