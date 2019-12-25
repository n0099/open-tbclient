package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ap;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private int gOe;
    private int jfh = 0;
    private int jfi = 0;
    private ArrayList<ForumData> jfa = new ArrayList<>();
    private ArrayList<ForumData> jfb = new ArrayList<>();
    private ArrayList<ForumData> jfc = new ArrayList<>();
    private ArrayList<ForumData> jfd = new ArrayList<>();
    private ArrayList<ForumData> jff = new ArrayList<>();
    private ArrayList<ForumData> jfe = new ArrayList<>();
    private ap page = new ap();
    private Date jfg = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int ctk() {
        return this.jfh;
    }

    public void zB(int i) {
        this.jfh = i;
    }

    public void zC(int i) {
        this.jfh += i;
    }

    public int ctl() {
        return this.jfi;
    }

    public void zD(int i) {
        this.jfi = i;
    }

    public void zE(int i) {
        this.jfi += i;
    }

    public ArrayList<ForumData> ctm() {
        return this.jfb;
    }

    public ArrayList<ForumData> ctn() {
        return this.jfc;
    }

    public ArrayList<ForumData> cto() {
        return this.jfe;
    }

    public ArrayList<ForumData> ctp() {
        return this.jff;
    }

    public ArrayList<ForumData> ctq() {
        return this.jfa;
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jfa == null) {
            this.jfa = new ArrayList<>();
        }
        if (this.jfb != null && arrayList != null) {
            this.jfb.clear();
            this.jfb.addAll(arrayList);
        }
        if (this.jfc != null && arrayList2 != null) {
            this.jfc.clear();
            this.jfc.addAll(arrayList2);
        }
        if (this.jfb != null || this.jfc != null) {
            this.jfa.clear();
            if (this.jfb != null) {
                this.jfa.addAll(this.jfb);
            }
            if (this.jfc != null) {
                this.jfa.addAll(this.jfc);
            }
        }
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jfa == null) {
            this.jfa = new ArrayList<>();
        }
        if (this.jfb != null && arrayList != null) {
            this.jfb.addAll(arrayList);
        }
        if (this.jfc != null && arrayList2 != null) {
            this.jfc.addAll(arrayList2);
        }
        if (this.jfb != null || this.jfc != null) {
            this.jfa.clear();
            if (this.jfb != null) {
                this.jfa.addAll(this.jfb);
            }
            if (this.jfc != null) {
                this.jfa.addAll(this.jfc);
            }
        }
    }

    public ArrayList<ForumData> ctr() {
        return this.jfd;
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jfd == null) {
            this.jfd = new ArrayList<>();
        }
        if (this.jfe != null && arrayList != null) {
            this.jfe.addAll(arrayList);
        }
        if (this.jff != null && arrayList2 != null) {
            this.jff.addAll(arrayList2);
        }
        if (this.jfe != null || this.jff != null) {
            this.jfd.clear();
            if (this.jfe != null) {
                this.jfd.addAll(this.jfe);
            }
            if (this.jff != null) {
                this.jfd.addAll(this.jff);
            }
        }
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jfd == null) {
            this.jfd = new ArrayList<>();
        }
        if (this.jfe != null && arrayList != null) {
            this.jfe.clear();
            this.jfe.addAll(arrayList);
        }
        if (this.jff != null && arrayList2 != null) {
            this.jff.clear();
            this.jff.addAll(arrayList2);
        }
        if (this.jfe != null || this.jff != null) {
            this.jfd.clear();
            if (this.jfe != null) {
                this.jfd.addAll(this.jfe);
            }
            if (this.jff != null) {
                this.jfd.addAll(this.jff);
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
            this.gOe = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.jfg = new Date(optLong);
            } else {
                this.jfg = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.jfh = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.jfb.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.jfc.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.jfi = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.jfe.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.jff.add(forumData4);
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
        return this.gOe == 1;
    }

    public void setHasMore(boolean z) {
        this.gOe = z ? 1 : 0;
    }
}
