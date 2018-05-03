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
    private int cuF;
    private int fGc = 0;
    private int fGd = 0;
    private ArrayList<ForumData> fFV = new ArrayList<>();
    private ArrayList<ForumData> fFW = new ArrayList<>();
    private ArrayList<ForumData> fFX = new ArrayList<>();
    private ArrayList<ForumData> fFY = new ArrayList<>();
    private ArrayList<ForumData> fGa = new ArrayList<>();
    private ArrayList<ForumData> fFZ = new ArrayList<>();
    private am enx = new am();
    private Date fGb = null;
    private boolean Aj = true;

    public a() {
        setHasMore(false);
    }

    public int bem() {
        return this.fGc;
    }

    public void ra(int i) {
        this.fGc = i;
    }

    public void rb(int i) {
        this.fGc += i;
    }

    public int ben() {
        return this.fGd;
    }

    public void rc(int i) {
        this.fGd = i;
    }

    public void rd(int i) {
        this.fGd += i;
    }

    public ArrayList<ForumData> beo() {
        return this.fFW;
    }

    public ArrayList<ForumData> bep() {
        return this.fFX;
    }

    public ArrayList<ForumData> beq() {
        return this.fFZ;
    }

    public ArrayList<ForumData> ber() {
        return this.fGa;
    }

    public ArrayList<ForumData> bes() {
        return this.fFV;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fFV == null) {
            this.fFV = new ArrayList<>();
        }
        if (this.fFW != null && arrayList != null) {
            this.fFW.clear();
            this.fFW.addAll(arrayList);
        }
        if (this.fFX != null && arrayList2 != null) {
            this.fFX.clear();
            this.fFX.addAll(arrayList2);
        }
        if (this.fFW != null || this.fFX != null) {
            this.fFV.clear();
            if (this.fFW != null) {
                this.fFV.addAll(this.fFW);
            }
            if (this.fFX != null) {
                this.fFV.addAll(this.fFX);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fFV == null) {
            this.fFV = new ArrayList<>();
        }
        if (this.fFW != null && arrayList != null) {
            this.fFW.addAll(arrayList);
        }
        if (this.fFX != null && arrayList2 != null) {
            this.fFX.addAll(arrayList2);
        }
        if (this.fFW != null || this.fFX != null) {
            this.fFV.clear();
            if (this.fFW != null) {
                this.fFV.addAll(this.fFW);
            }
            if (this.fFX != null) {
                this.fFV.addAll(this.fFX);
            }
        }
    }

    public ArrayList<ForumData> bet() {
        return this.fFY;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
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

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
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
            this.enx.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
            this.cuF = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.fGb = new Date(optLong);
            } else {
                this.fGb = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.fGc = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.fFW.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.fFX.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.fGd = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.fFZ.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.fGa.add(forumData4);
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
        return this.cuF == 1;
    }

    public void setHasMore(boolean z) {
        this.cuF = z ? 1 : 0;
    }
}
