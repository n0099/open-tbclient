package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.az;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private int jWd;
    private int mws = 0;
    private int mwt = 0;
    private ArrayList<ForumData> mwl = new ArrayList<>();
    private ArrayList<ForumData> mwm = new ArrayList<>();
    private ArrayList<ForumData> mwn = new ArrayList<>();
    private ArrayList<ForumData> mwo = new ArrayList<>();
    private ArrayList<ForumData> mwq = new ArrayList<>();
    private ArrayList<ForumData> mwp = new ArrayList<>();
    private az page = new az();
    private Date mwr = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int dxk() {
        return this.mws;
    }

    public void GM(int i) {
        this.mws = i;
    }

    public void GN(int i) {
        this.mws += i;
    }

    public int dxl() {
        return this.mwt;
    }

    public void GO(int i) {
        this.mwt = i;
    }

    public void GP(int i) {
        this.mwt += i;
    }

    public ArrayList<ForumData> dxm() {
        return this.mwm;
    }

    public ArrayList<ForumData> dxn() {
        return this.mwn;
    }

    public ArrayList<ForumData> dxo() {
        return this.mwp;
    }

    public ArrayList<ForumData> dxp() {
        return this.mwq;
    }

    public ArrayList<ForumData> dxq() {
        return this.mwl;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mwl == null) {
            this.mwl = new ArrayList<>();
        }
        if (this.mwm != null && arrayList != null) {
            this.mwm.clear();
            this.mwm.addAll(arrayList);
        }
        if (this.mwn != null && arrayList2 != null) {
            this.mwn.clear();
            this.mwn.addAll(arrayList2);
        }
        if (this.mwm != null || this.mwn != null) {
            this.mwl.clear();
            if (this.mwm != null) {
                this.mwl.addAll(this.mwm);
            }
            if (this.mwn != null) {
                this.mwl.addAll(this.mwn);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mwl == null) {
            this.mwl = new ArrayList<>();
        }
        if (this.mwm != null && arrayList != null) {
            this.mwm.addAll(arrayList);
        }
        if (this.mwn != null && arrayList2 != null) {
            this.mwn.addAll(arrayList2);
        }
        if (this.mwm != null || this.mwn != null) {
            this.mwl.clear();
            if (this.mwm != null) {
                this.mwl.addAll(this.mwm);
            }
            if (this.mwn != null) {
                this.mwl.addAll(this.mwn);
            }
        }
    }

    public ArrayList<ForumData> dxr() {
        return this.mwo;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mwo == null) {
            this.mwo = new ArrayList<>();
        }
        if (this.mwp != null && arrayList != null) {
            this.mwp.addAll(arrayList);
        }
        if (this.mwq != null && arrayList2 != null) {
            this.mwq.addAll(arrayList2);
        }
        if (this.mwp != null || this.mwq != null) {
            this.mwo.clear();
            if (this.mwp != null) {
                this.mwo.addAll(this.mwp);
            }
            if (this.mwq != null) {
                this.mwo.addAll(this.mwq);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mwo == null) {
            this.mwo = new ArrayList<>();
        }
        if (this.mwp != null && arrayList != null) {
            this.mwp.clear();
            this.mwp.addAll(arrayList);
        }
        if (this.mwq != null && arrayList2 != null) {
            this.mwq.clear();
            this.mwq.addAll(arrayList2);
        }
        if (this.mwp != null || this.mwq != null) {
            this.mwo.clear();
            if (this.mwp != null) {
                this.mwo.addAll(this.mwp);
            }
            if (this.mwq != null) {
                this.mwo.addAll(this.mwq);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.isSucc = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.page.parserJson(jSONObject.optJSONObject("page"));
            this.jWd = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.mwr = new Date(optLong);
            } else {
                this.mwr = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.mws = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.mwm.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.mwn.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.mwt = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.mwp.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.mwq.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.isSucc = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.jWd == 1;
    }

    public void setHasMore(boolean z) {
        this.jWd = z ? 1 : 0;
    }
}
