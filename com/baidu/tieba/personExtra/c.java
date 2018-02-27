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
    private int dcM;
    private int gls = 0;
    private int glt = 0;
    private ArrayList<ForumData> gll = new ArrayList<>();
    private ArrayList<ForumData> glm = new ArrayList<>();
    private ArrayList<ForumData> gln = new ArrayList<>();
    private ArrayList<ForumData> glo = new ArrayList<>();
    private ArrayList<ForumData> glq = new ArrayList<>();
    private ArrayList<ForumData> glp = new ArrayList<>();
    private al eSK = new al();
    private Date glr = null;
    private boolean apG = true;

    public c() {
        setHasMore(false);
    }

    public int bjj() {
        return this.gls;
    }

    public void tE(int i) {
        this.gls = i;
    }

    public void tF(int i) {
        this.gls += i;
    }

    public int bjk() {
        return this.glt;
    }

    public void tG(int i) {
        this.glt = i;
    }

    public void tH(int i) {
        this.glt += i;
    }

    public ArrayList<ForumData> bjl() {
        return this.glm;
    }

    public ArrayList<ForumData> bjm() {
        return this.gln;
    }

    public ArrayList<ForumData> bjn() {
        return this.glp;
    }

    public ArrayList<ForumData> bjo() {
        return this.glq;
    }

    public ArrayList<ForumData> bjp() {
        return this.gll;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gll == null) {
            this.gll = new ArrayList<>();
        }
        if (this.glm != null && arrayList != null) {
            this.glm.clear();
            this.glm.addAll(arrayList);
        }
        if (this.gln != null && arrayList2 != null) {
            this.gln.clear();
            this.gln.addAll(arrayList2);
        }
        if (this.glm != null || this.gln != null) {
            this.gll.clear();
            if (this.glm != null) {
                this.gll.addAll(this.glm);
            }
            if (this.gln != null) {
                this.gll.addAll(this.gln);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gll == null) {
            this.gll = new ArrayList<>();
        }
        if (this.glm != null && arrayList != null) {
            this.glm.addAll(arrayList);
        }
        if (this.gln != null && arrayList2 != null) {
            this.gln.addAll(arrayList2);
        }
        if (this.glm != null || this.gln != null) {
            this.gll.clear();
            if (this.glm != null) {
                this.gll.addAll(this.glm);
            }
            if (this.gln != null) {
                this.gll.addAll(this.gln);
            }
        }
    }

    public ArrayList<ForumData> bjq() {
        return this.glo;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glo == null) {
            this.glo = new ArrayList<>();
        }
        if (this.glp != null && arrayList != null) {
            this.glp.addAll(arrayList);
        }
        if (this.glq != null && arrayList2 != null) {
            this.glq.addAll(arrayList2);
        }
        if (this.glp != null || this.glq != null) {
            this.glo.clear();
            if (this.glp != null) {
                this.glo.addAll(this.glp);
            }
            if (this.glq != null) {
                this.glo.addAll(this.glq);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glo == null) {
            this.glo = new ArrayList<>();
        }
        if (this.glp != null && arrayList != null) {
            this.glp.clear();
            this.glp.addAll(arrayList);
        }
        if (this.glq != null && arrayList2 != null) {
            this.glq.clear();
            this.glq.addAll(arrayList2);
        }
        if (this.glp != null || this.glq != null) {
            this.glo.clear();
            if (this.glp != null) {
                this.glo.addAll(this.glp);
            }
            if (this.glq != null) {
                this.glo.addAll(this.glq);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.apG = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.eSK.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
            this.dcM = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.glr = new Date(optLong);
            } else {
                this.glr = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.gls = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.glm.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.gln.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.glt = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.glp.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.glq.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.apG = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.dcM == 1;
    }

    public void setHasMore(boolean z) {
        this.dcM = z ? 1 : 0;
    }
}
