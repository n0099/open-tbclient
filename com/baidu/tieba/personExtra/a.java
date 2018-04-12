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
    private int cuI;
    private int fGf = 0;
    private int fGg = 0;
    private ArrayList<ForumData> fFY = new ArrayList<>();
    private ArrayList<ForumData> fFZ = new ArrayList<>();
    private ArrayList<ForumData> fGa = new ArrayList<>();
    private ArrayList<ForumData> fGb = new ArrayList<>();
    private ArrayList<ForumData> fGd = new ArrayList<>();
    private ArrayList<ForumData> fGc = new ArrayList<>();
    private am enA = new am();
    private Date fGe = null;
    private boolean Aj = true;

    public a() {
        setHasMore(false);
    }

    public int bem() {
        return this.fGf;
    }

    public void rb(int i) {
        this.fGf = i;
    }

    public void rc(int i) {
        this.fGf += i;
    }

    public int ben() {
        return this.fGg;
    }

    public void rd(int i) {
        this.fGg = i;
    }

    public void re(int i) {
        this.fGg += i;
    }

    public ArrayList<ForumData> beo() {
        return this.fFZ;
    }

    public ArrayList<ForumData> bep() {
        return this.fGa;
    }

    public ArrayList<ForumData> beq() {
        return this.fGc;
    }

    public ArrayList<ForumData> ber() {
        return this.fGd;
    }

    public ArrayList<ForumData> bes() {
        return this.fFY;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fFY == null) {
            this.fFY = new ArrayList<>();
        }
        if (this.fFZ != null && arrayList != null) {
            this.fFZ.clear();
            this.fFZ.addAll(arrayList);
        }
        if (this.fGa != null && arrayList2 != null) {
            this.fGa.clear();
            this.fGa.addAll(arrayList2);
        }
        if (this.fFZ != null || this.fGa != null) {
            this.fFY.clear();
            if (this.fFZ != null) {
                this.fFY.addAll(this.fFZ);
            }
            if (this.fGa != null) {
                this.fFY.addAll(this.fGa);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fFY == null) {
            this.fFY = new ArrayList<>();
        }
        if (this.fFZ != null && arrayList != null) {
            this.fFZ.addAll(arrayList);
        }
        if (this.fGa != null && arrayList2 != null) {
            this.fGa.addAll(arrayList2);
        }
        if (this.fFZ != null || this.fGa != null) {
            this.fFY.clear();
            if (this.fFZ != null) {
                this.fFY.addAll(this.fFZ);
            }
            if (this.fGa != null) {
                this.fFY.addAll(this.fGa);
            }
        }
    }

    public ArrayList<ForumData> bet() {
        return this.fGb;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fGb == null) {
            this.fGb = new ArrayList<>();
        }
        if (this.fGc != null && arrayList != null) {
            this.fGc.addAll(arrayList);
        }
        if (this.fGd != null && arrayList2 != null) {
            this.fGd.addAll(arrayList2);
        }
        if (this.fGc != null || this.fGd != null) {
            this.fGb.clear();
            if (this.fGc != null) {
                this.fGb.addAll(this.fGc);
            }
            if (this.fGd != null) {
                this.fGb.addAll(this.fGd);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fGb == null) {
            this.fGb = new ArrayList<>();
        }
        if (this.fGc != null && arrayList != null) {
            this.fGc.clear();
            this.fGc.addAll(arrayList);
        }
        if (this.fGd != null && arrayList2 != null) {
            this.fGd.clear();
            this.fGd.addAll(arrayList2);
        }
        if (this.fGc != null || this.fGd != null) {
            this.fGb.clear();
            if (this.fGc != null) {
                this.fGb.addAll(this.fGc);
            }
            if (this.fGd != null) {
                this.fGb.addAll(this.fGd);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Aj = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.enA.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
            this.cuI = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.fGe = new Date(optLong);
            } else {
                this.fGe = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.fGf = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.fFZ.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.fGa.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.fGg = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.fGc.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.fGd.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Aj = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.cuI == 1;
    }

    public void setHasMore(boolean z) {
        this.cuI = z ? 1 : 0;
    }
}
