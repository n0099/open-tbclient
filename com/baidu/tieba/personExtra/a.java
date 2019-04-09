package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.an;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private int enZ;
    private int hNI = 0;
    private int hNJ = 0;
    private ArrayList<ForumData> hNB = new ArrayList<>();
    private ArrayList<ForumData> hNC = new ArrayList<>();
    private ArrayList<ForumData> hND = new ArrayList<>();
    private ArrayList<ForumData> hNE = new ArrayList<>();
    private ArrayList<ForumData> hNG = new ArrayList<>();
    private ArrayList<ForumData> hNF = new ArrayList<>();
    private an page = new an();
    private Date hNH = null;
    private boolean Jy = true;

    public a() {
        setHasMore(false);
    }

    public int bQV() {
        return this.hNI;
    }

    public void wV(int i) {
        this.hNI = i;
    }

    public void wW(int i) {
        this.hNI += i;
    }

    public int bQW() {
        return this.hNJ;
    }

    public void wX(int i) {
        this.hNJ = i;
    }

    public void wY(int i) {
        this.hNJ += i;
    }

    public ArrayList<ForumData> bQX() {
        return this.hNC;
    }

    public ArrayList<ForumData> bQY() {
        return this.hND;
    }

    public ArrayList<ForumData> bQZ() {
        return this.hNF;
    }

    public ArrayList<ForumData> bRa() {
        return this.hNG;
    }

    public ArrayList<ForumData> bRb() {
        return this.hNB;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.hNB == null) {
            this.hNB = new ArrayList<>();
        }
        if (this.hNC != null && arrayList != null) {
            this.hNC.clear();
            this.hNC.addAll(arrayList);
        }
        if (this.hND != null && arrayList2 != null) {
            this.hND.clear();
            this.hND.addAll(arrayList2);
        }
        if (this.hNC != null || this.hND != null) {
            this.hNB.clear();
            if (this.hNC != null) {
                this.hNB.addAll(this.hNC);
            }
            if (this.hND != null) {
                this.hNB.addAll(this.hND);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.hNB == null) {
            this.hNB = new ArrayList<>();
        }
        if (this.hNC != null && arrayList != null) {
            this.hNC.addAll(arrayList);
        }
        if (this.hND != null && arrayList2 != null) {
            this.hND.addAll(arrayList2);
        }
        if (this.hNC != null || this.hND != null) {
            this.hNB.clear();
            if (this.hNC != null) {
                this.hNB.addAll(this.hNC);
            }
            if (this.hND != null) {
                this.hNB.addAll(this.hND);
            }
        }
    }

    public ArrayList<ForumData> bRc() {
        return this.hNE;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.hNE == null) {
            this.hNE = new ArrayList<>();
        }
        if (this.hNF != null && arrayList != null) {
            this.hNF.addAll(arrayList);
        }
        if (this.hNG != null && arrayList2 != null) {
            this.hNG.addAll(arrayList2);
        }
        if (this.hNF != null || this.hNG != null) {
            this.hNE.clear();
            if (this.hNF != null) {
                this.hNE.addAll(this.hNF);
            }
            if (this.hNG != null) {
                this.hNE.addAll(this.hNG);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.hNE == null) {
            this.hNE = new ArrayList<>();
        }
        if (this.hNF != null && arrayList != null) {
            this.hNF.clear();
            this.hNF.addAll(arrayList);
        }
        if (this.hNG != null && arrayList2 != null) {
            this.hNG.clear();
            this.hNG.addAll(arrayList2);
        }
        if (this.hNF != null || this.hNG != null) {
            this.hNE.clear();
            if (this.hNF != null) {
                this.hNE.addAll(this.hNF);
            }
            if (this.hNG != null) {
                this.hNE.addAll(this.hNG);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Jy = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.page.parserJson(jSONObject.optJSONObject("page"));
            this.enZ = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.hNH = new Date(optLong);
            } else {
                this.hNH = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.hNI = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.hNC.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.hND.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.hNJ = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.hNF.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.hNG.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Jy = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.enZ == 1;
    }

    public void setHasMore(boolean z) {
        this.enZ = z ? 1 : 0;
    }
}
