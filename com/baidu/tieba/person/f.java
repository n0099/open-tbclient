package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private int hasMore;
    private int bFd = 0;
    private int bFe = 0;
    private ArrayList<ForumData> bEW = new ArrayList<>();
    private ArrayList<ForumData> bEX = new ArrayList<>();
    private ArrayList<ForumData> bEY = new ArrayList<>();
    private ArrayList<ForumData> bEZ = new ArrayList<>();
    private ArrayList<ForumData> bFb = new ArrayList<>();
    private ArrayList<ForumData> bFa = new ArrayList<>();
    private com.baidu.tbadk.core.data.p bsg = new com.baidu.tbadk.core.data.p();
    private Date bFc = null;
    private boolean QO = true;

    public f() {
        setHasMore(false);
    }

    public int ZY() {
        return this.bFd;
    }

    public void ha(int i) {
        this.bFd = i;
    }

    public void hb(int i) {
        this.bFd += i;
    }

    public int ZZ() {
        return this.bFe;
    }

    public void hc(int i) {
        this.bFe = i;
    }

    public void hd(int i) {
        this.bFe += i;
    }

    public ArrayList<ForumData> aaa() {
        return this.bEX;
    }

    public ArrayList<ForumData> aab() {
        return this.bEY;
    }

    public ArrayList<ForumData> aac() {
        return this.bFa;
    }

    public ArrayList<ForumData> aad() {
        return this.bFb;
    }

    public ArrayList<ForumData> aae() {
        return this.bEW;
    }

    public void a(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bEW == null) {
            this.bEW = new ArrayList<>();
        }
        if (this.bEX != null && arrayList != null) {
            this.bEX.clear();
            this.bEX.addAll(arrayList);
        }
        if (this.bEY != null && arrayList2 != null) {
            this.bEY.clear();
            this.bEY.addAll(arrayList2);
        }
        if (this.bEX != null || this.bEY != null) {
            this.bEW.clear();
            if (this.bEX != null) {
                this.bEW.addAll(this.bEX);
            }
            if (this.bEY != null) {
                this.bEW.addAll(this.bEY);
            }
        }
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bEW == null) {
            this.bEW = new ArrayList<>();
        }
        if (this.bEX != null && arrayList != null) {
            this.bEX.addAll(arrayList);
        }
        if (this.bEY != null && arrayList2 != null) {
            this.bEY.addAll(arrayList2);
        }
        if (this.bEX != null || this.bEY != null) {
            this.bEW.clear();
            if (this.bEX != null) {
                this.bEW.addAll(this.bEX);
            }
            if (this.bEY != null) {
                this.bEW.addAll(this.bEY);
            }
        }
    }

    public ArrayList<ForumData> aaf() {
        return this.bEZ;
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bEZ == null) {
            this.bEZ = new ArrayList<>();
        }
        if (this.bFa != null && arrayList != null) {
            this.bFa.addAll(arrayList);
        }
        if (this.bFb != null && arrayList2 != null) {
            this.bFb.addAll(arrayList2);
        }
        if (this.bFa != null || this.bFb != null) {
            this.bEZ.clear();
            if (this.bFa != null) {
                this.bEZ.addAll(this.bFa);
            }
            if (this.bFb != null) {
                this.bEZ.addAll(this.bFb);
            }
        }
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bEZ == null) {
            this.bEZ = new ArrayList<>();
        }
        if (this.bFa != null && arrayList != null) {
            this.bFa.clear();
            this.bFa.addAll(arrayList);
        }
        if (this.bFb != null && arrayList2 != null) {
            this.bFb.clear();
            this.bFb.addAll(arrayList2);
        }
        if (this.bFa != null || this.bFb != null) {
            this.bEZ.clear();
            if (this.bFa != null) {
                this.bEZ.addAll(this.bFa);
            }
            if (this.bFb != null) {
                this.bEZ.addAll(this.bFb);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.QO = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.bsg.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.bFc = new Date(optLong);
            } else {
                this.bFc = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.bFd = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.bEX.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bEY.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.bFe = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.bFa.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.bFb.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.QO = false;
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
