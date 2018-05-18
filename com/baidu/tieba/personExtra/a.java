package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.am;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private int cvO;
    private int fHi = 0;
    private int fHj = 0;
    private ArrayList<ForumData> fHb = new ArrayList<>();
    private ArrayList<ForumData> fHc = new ArrayList<>();
    private ArrayList<ForumData> fHd = new ArrayList<>();
    private ArrayList<ForumData> fHe = new ArrayList<>();
    private ArrayList<ForumData> fHg = new ArrayList<>();
    private ArrayList<ForumData> fHf = new ArrayList<>();
    private am eoG = new am();
    private Date fHh = null;
    private boolean Ai = true;

    public a() {
        setHasMore(false);
    }

    public int bem() {
        return this.fHi;
    }

    public void qZ(int i) {
        this.fHi = i;
    }

    public void ra(int i) {
        this.fHi += i;
    }

    public int ben() {
        return this.fHj;
    }

    public void rb(int i) {
        this.fHj = i;
    }

    public void rc(int i) {
        this.fHj += i;
    }

    public ArrayList<ForumData> beo() {
        return this.fHc;
    }

    public ArrayList<ForumData> bep() {
        return this.fHd;
    }

    public ArrayList<ForumData> beq() {
        return this.fHf;
    }

    public ArrayList<ForumData> ber() {
        return this.fHg;
    }

    public ArrayList<ForumData> bes() {
        return this.fHb;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fHb == null) {
            this.fHb = new ArrayList<>();
        }
        if (this.fHc != null && arrayList != null) {
            this.fHc.clear();
            this.fHc.addAll(arrayList);
        }
        if (this.fHd != null && arrayList2 != null) {
            this.fHd.clear();
            this.fHd.addAll(arrayList2);
        }
        if (this.fHc != null || this.fHd != null) {
            this.fHb.clear();
            if (this.fHc != null) {
                this.fHb.addAll(this.fHc);
            }
            if (this.fHd != null) {
                this.fHb.addAll(this.fHd);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fHb == null) {
            this.fHb = new ArrayList<>();
        }
        if (this.fHc != null && arrayList != null) {
            this.fHc.addAll(arrayList);
        }
        if (this.fHd != null && arrayList2 != null) {
            this.fHd.addAll(arrayList2);
        }
        if (this.fHc != null || this.fHd != null) {
            this.fHb.clear();
            if (this.fHc != null) {
                this.fHb.addAll(this.fHc);
            }
            if (this.fHd != null) {
                this.fHb.addAll(this.fHd);
            }
        }
    }

    public ArrayList<ForumData> bet() {
        return this.fHe;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fHe == null) {
            this.fHe = new ArrayList<>();
        }
        if (this.fHf != null && arrayList != null) {
            this.fHf.addAll(arrayList);
        }
        if (this.fHg != null && arrayList2 != null) {
            this.fHg.addAll(arrayList2);
        }
        if (this.fHf != null || this.fHg != null) {
            this.fHe.clear();
            if (this.fHf != null) {
                this.fHe.addAll(this.fHf);
            }
            if (this.fHg != null) {
                this.fHe.addAll(this.fHg);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fHe == null) {
            this.fHe = new ArrayList<>();
        }
        if (this.fHf != null && arrayList != null) {
            this.fHf.clear();
            this.fHf.addAll(arrayList);
        }
        if (this.fHg != null && arrayList2 != null) {
            this.fHg.clear();
            this.fHg.addAll(arrayList2);
        }
        if (this.fHf != null || this.fHg != null) {
            this.fHe.clear();
            if (this.fHf != null) {
                this.fHe.addAll(this.fHf);
            }
            if (this.fHg != null) {
                this.fHe.addAll(this.fHg);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Ai = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.eoG.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
            this.cvO = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.fHh = new Date(optLong);
            } else {
                this.fHh = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.fHi = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.fHc.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.fHd.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.fHj = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.fHf.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.fHg.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Ai = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.cvO == 1;
    }

    public void setHasMore(boolean z) {
        this.cvO = z ? 1 : 0;
    }
}
