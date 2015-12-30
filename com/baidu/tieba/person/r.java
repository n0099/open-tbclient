package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private int hasMore;
    private int cOe = 0;
    private int cOf = 0;
    private ArrayList<ForumData> cNX = new ArrayList<>();
    private ArrayList<ForumData> cNY = new ArrayList<>();
    private ArrayList<ForumData> cNZ = new ArrayList<>();
    private ArrayList<ForumData> cOa = new ArrayList<>();
    private ArrayList<ForumData> cOc = new ArrayList<>();
    private ArrayList<ForumData> cOb = new ArrayList<>();
    private com.baidu.tbadk.core.data.q ciK = new com.baidu.tbadk.core.data.q();
    private Date cOd = null;
    private boolean Cv = true;

    public r() {
        setHasMore(false);
    }

    public int aoA() {
        return this.cOe;
    }

    public void kF(int i) {
        this.cOe = i;
    }

    public void kG(int i) {
        this.cOe += i;
    }

    public int aoB() {
        return this.cOf;
    }

    public void kH(int i) {
        this.cOf = i;
    }

    public void kI(int i) {
        this.cOf += i;
    }

    public ArrayList<ForumData> aoC() {
        return this.cNY;
    }

    public ArrayList<ForumData> aoD() {
        return this.cNZ;
    }

    public ArrayList<ForumData> aoE() {
        return this.cOb;
    }

    public ArrayList<ForumData> aoF() {
        return this.cOc;
    }

    public ArrayList<ForumData> aoG() {
        return this.cNX;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cNX == null) {
            this.cNX = new ArrayList<>();
        }
        if (this.cNY != null && arrayList != null) {
            this.cNY.clear();
            this.cNY.addAll(arrayList);
        }
        if (this.cNZ != null && arrayList2 != null) {
            this.cNZ.clear();
            this.cNZ.addAll(arrayList2);
        }
        if (this.cNY != null || this.cNZ != null) {
            this.cNX.clear();
            if (this.cNY != null) {
                this.cNX.addAll(this.cNY);
            }
            if (this.cNZ != null) {
                this.cNX.addAll(this.cNZ);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cNX == null) {
            this.cNX = new ArrayList<>();
        }
        if (this.cNY != null && arrayList != null) {
            this.cNY.addAll(arrayList);
        }
        if (this.cNZ != null && arrayList2 != null) {
            this.cNZ.addAll(arrayList2);
        }
        if (this.cNY != null || this.cNZ != null) {
            this.cNX.clear();
            if (this.cNY != null) {
                this.cNX.addAll(this.cNY);
            }
            if (this.cNZ != null) {
                this.cNX.addAll(this.cNZ);
            }
        }
    }

    public ArrayList<ForumData> aoH() {
        return this.cOa;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cOa == null) {
            this.cOa = new ArrayList<>();
        }
        if (this.cOb != null && arrayList != null) {
            this.cOb.addAll(arrayList);
        }
        if (this.cOc != null && arrayList2 != null) {
            this.cOc.addAll(arrayList2);
        }
        if (this.cOb != null || this.cOc != null) {
            this.cOa.clear();
            if (this.cOb != null) {
                this.cOa.addAll(this.cOb);
            }
            if (this.cOc != null) {
                this.cOa.addAll(this.cOc);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cOa == null) {
            this.cOa = new ArrayList<>();
        }
        if (this.cOb != null && arrayList != null) {
            this.cOb.clear();
            this.cOb.addAll(arrayList);
        }
        if (this.cOc != null && arrayList2 != null) {
            this.cOc.clear();
            this.cOc.addAll(arrayList2);
        }
        if (this.cOb != null || this.cOc != null) {
            this.cOa.clear();
            if (this.cOb != null) {
                this.cOa.addAll(this.cOb);
            }
            if (this.cOc != null) {
                this.cOa.addAll(this.cOc);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Cv = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.ciK.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.cOd = new Date(optLong);
            } else {
                this.cOd = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.cOe = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.cNY.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cNZ.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.cOf = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.cOb.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.cOc.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Cv = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.hasMore == 1;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z ? 1 : 0;
    }
}
