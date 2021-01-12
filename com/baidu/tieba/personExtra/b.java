package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ax;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private int jOB;
    private int mnr = 0;
    private int mns = 0;
    private ArrayList<ForumData> mnk = new ArrayList<>();
    private ArrayList<ForumData> mnl = new ArrayList<>();
    private ArrayList<ForumData> mnm = new ArrayList<>();
    private ArrayList<ForumData> mnn = new ArrayList<>();
    private ArrayList<ForumData> mnp = new ArrayList<>();
    private ArrayList<ForumData> mno = new ArrayList<>();
    private ax page = new ax();
    private Date mnq = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int dvb() {
        return this.mnr;
    }

    public void Gu(int i) {
        this.mnr = i;
    }

    public void Gv(int i) {
        this.mnr += i;
    }

    public int dvc() {
        return this.mns;
    }

    public void Gw(int i) {
        this.mns = i;
    }

    public void Gx(int i) {
        this.mns += i;
    }

    public ArrayList<ForumData> dvd() {
        return this.mnl;
    }

    public ArrayList<ForumData> dve() {
        return this.mnm;
    }

    public ArrayList<ForumData> dvf() {
        return this.mno;
    }

    public ArrayList<ForumData> dvg() {
        return this.mnp;
    }

    public ArrayList<ForumData> dvh() {
        return this.mnk;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mnk == null) {
            this.mnk = new ArrayList<>();
        }
        if (this.mnl != null && arrayList != null) {
            this.mnl.clear();
            this.mnl.addAll(arrayList);
        }
        if (this.mnm != null && arrayList2 != null) {
            this.mnm.clear();
            this.mnm.addAll(arrayList2);
        }
        if (this.mnl != null || this.mnm != null) {
            this.mnk.clear();
            if (this.mnl != null) {
                this.mnk.addAll(this.mnl);
            }
            if (this.mnm != null) {
                this.mnk.addAll(this.mnm);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mnk == null) {
            this.mnk = new ArrayList<>();
        }
        if (this.mnl != null && arrayList != null) {
            this.mnl.addAll(arrayList);
        }
        if (this.mnm != null && arrayList2 != null) {
            this.mnm.addAll(arrayList2);
        }
        if (this.mnl != null || this.mnm != null) {
            this.mnk.clear();
            if (this.mnl != null) {
                this.mnk.addAll(this.mnl);
            }
            if (this.mnm != null) {
                this.mnk.addAll(this.mnm);
            }
        }
    }

    public ArrayList<ForumData> dvi() {
        return this.mnn;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mnn == null) {
            this.mnn = new ArrayList<>();
        }
        if (this.mno != null && arrayList != null) {
            this.mno.addAll(arrayList);
        }
        if (this.mnp != null && arrayList2 != null) {
            this.mnp.addAll(arrayList2);
        }
        if (this.mno != null || this.mnp != null) {
            this.mnn.clear();
            if (this.mno != null) {
                this.mnn.addAll(this.mno);
            }
            if (this.mnp != null) {
                this.mnn.addAll(this.mnp);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mnn == null) {
            this.mnn = new ArrayList<>();
        }
        if (this.mno != null && arrayList != null) {
            this.mno.clear();
            this.mno.addAll(arrayList);
        }
        if (this.mnp != null && arrayList2 != null) {
            this.mnp.clear();
            this.mnp.addAll(arrayList2);
        }
        if (this.mno != null || this.mnp != null) {
            this.mnn.clear();
            if (this.mno != null) {
                this.mnn.addAll(this.mno);
            }
            if (this.mnp != null) {
                this.mnn.addAll(this.mnp);
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
            this.jOB = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.mnq = new Date(optLong);
            } else {
                this.mnq = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.mnr = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.mnl.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.mnm.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.mns = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.mno.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.mnp.add(forumData4);
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
        return this.jOB == 1;
    }

    public void setHasMore(boolean z) {
        this.jOB = z ? 1 : 0;
    }
}
