package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ap;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private int gUT;
    private int jlv = 0;
    private int jlw = 0;
    private ArrayList<ForumData> jlo = new ArrayList<>();
    private ArrayList<ForumData> jlp = new ArrayList<>();
    private ArrayList<ForumData> jlq = new ArrayList<>();
    private ArrayList<ForumData> jlr = new ArrayList<>();
    private ArrayList<ForumData> jlt = new ArrayList<>();
    private ArrayList<ForumData> jls = new ArrayList<>();
    private ap page = new ap();
    private Date jlu = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cwi() {
        return this.jlv;
    }

    public void zV(int i) {
        this.jlv = i;
    }

    public void zW(int i) {
        this.jlv += i;
    }

    public int cwj() {
        return this.jlw;
    }

    public void zX(int i) {
        this.jlw = i;
    }

    public void zY(int i) {
        this.jlw += i;
    }

    public ArrayList<ForumData> cwk() {
        return this.jlp;
    }

    public ArrayList<ForumData> cwl() {
        return this.jlq;
    }

    public ArrayList<ForumData> cwm() {
        return this.jls;
    }

    public ArrayList<ForumData> cwn() {
        return this.jlt;
    }

    public ArrayList<ForumData> cwo() {
        return this.jlo;
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jlo == null) {
            this.jlo = new ArrayList<>();
        }
        if (this.jlp != null && arrayList != null) {
            this.jlp.clear();
            this.jlp.addAll(arrayList);
        }
        if (this.jlq != null && arrayList2 != null) {
            this.jlq.clear();
            this.jlq.addAll(arrayList2);
        }
        if (this.jlp != null || this.jlq != null) {
            this.jlo.clear();
            if (this.jlp != null) {
                this.jlo.addAll(this.jlp);
            }
            if (this.jlq != null) {
                this.jlo.addAll(this.jlq);
            }
        }
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jlo == null) {
            this.jlo = new ArrayList<>();
        }
        if (this.jlp != null && arrayList != null) {
            this.jlp.addAll(arrayList);
        }
        if (this.jlq != null && arrayList2 != null) {
            this.jlq.addAll(arrayList2);
        }
        if (this.jlp != null || this.jlq != null) {
            this.jlo.clear();
            if (this.jlp != null) {
                this.jlo.addAll(this.jlp);
            }
            if (this.jlq != null) {
                this.jlo.addAll(this.jlq);
            }
        }
    }

    public ArrayList<ForumData> cwp() {
        return this.jlr;
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jlr == null) {
            this.jlr = new ArrayList<>();
        }
        if (this.jls != null && arrayList != null) {
            this.jls.addAll(arrayList);
        }
        if (this.jlt != null && arrayList2 != null) {
            this.jlt.addAll(arrayList2);
        }
        if (this.jls != null || this.jlt != null) {
            this.jlr.clear();
            if (this.jls != null) {
                this.jlr.addAll(this.jls);
            }
            if (this.jlt != null) {
                this.jlr.addAll(this.jlt);
            }
        }
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jlr == null) {
            this.jlr = new ArrayList<>();
        }
        if (this.jls != null && arrayList != null) {
            this.jls.clear();
            this.jls.addAll(arrayList);
        }
        if (this.jlt != null && arrayList2 != null) {
            this.jlt.clear();
            this.jlt.addAll(arrayList2);
        }
        if (this.jls != null || this.jlt != null) {
            this.jlr.clear();
            if (this.jls != null) {
                this.jlr.addAll(this.jls);
            }
            if (this.jlt != null) {
                this.jlr.addAll(this.jlt);
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
            this.gUT = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.jlu = new Date(optLong);
            } else {
                this.jlu = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.jlv = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.jlp.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.jlq.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.jlw = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.jls.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.jlt.add(forumData4);
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
        return this.gUT == 1;
    }

    public void setHasMore(boolean z) {
        this.gUT = z ? 1 : 0;
    }
}
