package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.al;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private int dcY;
    private int glD = 0;
    private int glE = 0;
    private ArrayList<ForumData> glw = new ArrayList<>();
    private ArrayList<ForumData> glx = new ArrayList<>();
    private ArrayList<ForumData> gly = new ArrayList<>();
    private ArrayList<ForumData> glz = new ArrayList<>();
    private ArrayList<ForumData> glB = new ArrayList<>();
    private ArrayList<ForumData> glA = new ArrayList<>();
    private al eSW = new al();
    private Date glC = null;
    private boolean apP = true;

    public c() {
        setHasMore(false);
    }

    public int bjk() {
        return this.glD;
    }

    public void tD(int i) {
        this.glD = i;
    }

    public void tE(int i) {
        this.glD += i;
    }

    public int bjl() {
        return this.glE;
    }

    public void tF(int i) {
        this.glE = i;
    }

    public void tG(int i) {
        this.glE += i;
    }

    public ArrayList<ForumData> bjm() {
        return this.glx;
    }

    public ArrayList<ForumData> bjn() {
        return this.gly;
    }

    public ArrayList<ForumData> bjo() {
        return this.glA;
    }

    public ArrayList<ForumData> bjp() {
        return this.glB;
    }

    public ArrayList<ForumData> bjq() {
        return this.glw;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glw == null) {
            this.glw = new ArrayList<>();
        }
        if (this.glx != null && arrayList != null) {
            this.glx.clear();
            this.glx.addAll(arrayList);
        }
        if (this.gly != null && arrayList2 != null) {
            this.gly.clear();
            this.gly.addAll(arrayList2);
        }
        if (this.glx != null || this.gly != null) {
            this.glw.clear();
            if (this.glx != null) {
                this.glw.addAll(this.glx);
            }
            if (this.gly != null) {
                this.glw.addAll(this.gly);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glw == null) {
            this.glw = new ArrayList<>();
        }
        if (this.glx != null && arrayList != null) {
            this.glx.addAll(arrayList);
        }
        if (this.gly != null && arrayList2 != null) {
            this.gly.addAll(arrayList2);
        }
        if (this.glx != null || this.gly != null) {
            this.glw.clear();
            if (this.glx != null) {
                this.glw.addAll(this.glx);
            }
            if (this.gly != null) {
                this.glw.addAll(this.gly);
            }
        }
    }

    public ArrayList<ForumData> bjr() {
        return this.glz;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glz == null) {
            this.glz = new ArrayList<>();
        }
        if (this.glA != null && arrayList != null) {
            this.glA.addAll(arrayList);
        }
        if (this.glB != null && arrayList2 != null) {
            this.glB.addAll(arrayList2);
        }
        if (this.glA != null || this.glB != null) {
            this.glz.clear();
            if (this.glA != null) {
                this.glz.addAll(this.glA);
            }
            if (this.glB != null) {
                this.glz.addAll(this.glB);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glz == null) {
            this.glz = new ArrayList<>();
        }
        if (this.glA != null && arrayList != null) {
            this.glA.clear();
            this.glA.addAll(arrayList);
        }
        if (this.glB != null && arrayList2 != null) {
            this.glB.clear();
            this.glB.addAll(arrayList2);
        }
        if (this.glA != null || this.glB != null) {
            this.glz.clear();
            if (this.glA != null) {
                this.glz.addAll(this.glA);
            }
            if (this.glB != null) {
                this.glz.addAll(this.glB);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.apP = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.eSW.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
            this.dcY = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.glC = new Date(optLong);
            } else {
                this.glC = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.glD = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.glx.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.gly.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.glE = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.glA.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.glB.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.apP = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.dcY == 1;
    }

    public void setHasMore(boolean z) {
        this.dcY = z ? 1 : 0;
    }
}
