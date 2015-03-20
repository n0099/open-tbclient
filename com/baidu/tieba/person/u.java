package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private int hasMore;
    private int bPq = 0;
    private int bPr = 0;
    private ArrayList<ForumData> bPj = new ArrayList<>();
    private ArrayList<ForumData> bPk = new ArrayList<>();
    private ArrayList<ForumData> bPl = new ArrayList<>();
    private ArrayList<ForumData> bPm = new ArrayList<>();
    private ArrayList<ForumData> bPo = new ArrayList<>();
    private ArrayList<ForumData> bPn = new ArrayList<>();
    private com.baidu.tbadk.core.data.q bDc = new com.baidu.tbadk.core.data.q();
    private Date bPp = null;
    private boolean abe = true;

    public u() {
        setHasMore(false);
    }

    public int acO() {
        return this.bPq;
    }

    public void hu(int i) {
        this.bPq = i;
    }

    public void hv(int i) {
        this.bPq += i;
    }

    public int acP() {
        return this.bPr;
    }

    public void hw(int i) {
        this.bPr = i;
    }

    public void hx(int i) {
        this.bPr += i;
    }

    public ArrayList<ForumData> acQ() {
        return this.bPk;
    }

    public ArrayList<ForumData> acR() {
        return this.bPl;
    }

    public ArrayList<ForumData> acS() {
        return this.bPn;
    }

    public ArrayList<ForumData> acT() {
        return this.bPo;
    }

    public ArrayList<ForumData> acU() {
        return this.bPj;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bPj == null) {
            this.bPj = new ArrayList<>();
        }
        if (this.bPk != null && arrayList != null) {
            this.bPk.clear();
            this.bPk.addAll(arrayList);
        }
        if (this.bPl != null && arrayList2 != null) {
            this.bPl.clear();
            this.bPl.addAll(arrayList2);
        }
        if (this.bPk != null || this.bPl != null) {
            this.bPj.clear();
            if (this.bPk != null) {
                this.bPj.addAll(this.bPk);
            }
            if (this.bPl != null) {
                this.bPj.addAll(this.bPl);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bPj == null) {
            this.bPj = new ArrayList<>();
        }
        if (this.bPk != null && arrayList != null) {
            this.bPk.addAll(arrayList);
        }
        if (this.bPl != null && arrayList2 != null) {
            this.bPl.addAll(arrayList2);
        }
        if (this.bPk != null || this.bPl != null) {
            this.bPj.clear();
            if (this.bPk != null) {
                this.bPj.addAll(this.bPk);
            }
            if (this.bPl != null) {
                this.bPj.addAll(this.bPl);
            }
        }
    }

    public ArrayList<ForumData> acV() {
        return this.bPm;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bPm == null) {
            this.bPm = new ArrayList<>();
        }
        if (this.bPn != null && arrayList != null) {
            this.bPn.addAll(arrayList);
        }
        if (this.bPo != null && arrayList2 != null) {
            this.bPo.addAll(arrayList2);
        }
        if (this.bPn != null || this.bPo != null) {
            this.bPm.clear();
            if (this.bPn != null) {
                this.bPm.addAll(this.bPn);
            }
            if (this.bPo != null) {
                this.bPm.addAll(this.bPo);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bPm == null) {
            this.bPm = new ArrayList<>();
        }
        if (this.bPn != null && arrayList != null) {
            this.bPn.clear();
            this.bPn.addAll(arrayList);
        }
        if (this.bPo != null && arrayList2 != null) {
            this.bPo.clear();
            this.bPo.addAll(arrayList2);
        }
        if (this.bPn != null || this.bPo != null) {
            this.bPm.clear();
            if (this.bPn != null) {
                this.bPm.addAll(this.bPn);
            }
            if (this.bPo != null) {
                this.bPm.addAll(this.bPo);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.abe = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.bDc.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.bPp = new Date(optLong);
            } else {
                this.bPp = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.bPq = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.bPk.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bPl.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.bPr = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.bPn.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.bPo.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.abe = false;
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
