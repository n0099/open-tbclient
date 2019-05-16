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
    private int eDI;
    private int igd = 0;
    private int ige = 0;
    private ArrayList<ForumData> ifW = new ArrayList<>();
    private ArrayList<ForumData> ifX = new ArrayList<>();
    private ArrayList<ForumData> ifY = new ArrayList<>();
    private ArrayList<ForumData> ifZ = new ArrayList<>();
    private ArrayList<ForumData> igb = new ArrayList<>();
    private ArrayList<ForumData> iga = new ArrayList<>();
    private an page = new an();
    private Date igc = null;
    private boolean Hi = true;

    public b() {
        setHasMore(false);
    }

    public int bYS() {
        return this.igd;
    }

    public void yb(int i) {
        this.igd = i;
    }

    public void yc(int i) {
        this.igd += i;
    }

    public int bYT() {
        return this.ige;
    }

    public void yd(int i) {
        this.ige = i;
    }

    public void ye(int i) {
        this.ige += i;
    }

    public ArrayList<ForumData> bYU() {
        return this.ifX;
    }

    public ArrayList<ForumData> bYV() {
        return this.ifY;
    }

    public ArrayList<ForumData> bYW() {
        return this.iga;
    }

    public ArrayList<ForumData> bYX() {
        return this.igb;
    }

    public ArrayList<ForumData> bYY() {
        return this.ifW;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.ifW == null) {
            this.ifW = new ArrayList<>();
        }
        if (this.ifX != null && arrayList != null) {
            this.ifX.clear();
            this.ifX.addAll(arrayList);
        }
        if (this.ifY != null && arrayList2 != null) {
            this.ifY.clear();
            this.ifY.addAll(arrayList2);
        }
        if (this.ifX != null || this.ifY != null) {
            this.ifW.clear();
            if (this.ifX != null) {
                this.ifW.addAll(this.ifX);
            }
            if (this.ifY != null) {
                this.ifW.addAll(this.ifY);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.ifW == null) {
            this.ifW = new ArrayList<>();
        }
        if (this.ifX != null && arrayList != null) {
            this.ifX.addAll(arrayList);
        }
        if (this.ifY != null && arrayList2 != null) {
            this.ifY.addAll(arrayList2);
        }
        if (this.ifX != null || this.ifY != null) {
            this.ifW.clear();
            if (this.ifX != null) {
                this.ifW.addAll(this.ifX);
            }
            if (this.ifY != null) {
                this.ifW.addAll(this.ifY);
            }
        }
    }

    public ArrayList<ForumData> bYZ() {
        return this.ifZ;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
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

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
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
            this.eDI = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.igc = new Date(optLong);
            } else {
                this.igc = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.igd = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.ifX.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.ifY.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.ige = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.iga.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.igb.add(forumData4);
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
        return this.eDI == 1;
    }

    public void setHasMore(boolean z) {
        this.eDI = z ? 1 : 0;
    }
}
