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
    private int enY;
    private int hNH = 0;
    private int hNI = 0;
    private ArrayList<ForumData> hNA = new ArrayList<>();
    private ArrayList<ForumData> hNB = new ArrayList<>();
    private ArrayList<ForumData> hNC = new ArrayList<>();
    private ArrayList<ForumData> hND = new ArrayList<>();
    private ArrayList<ForumData> hNF = new ArrayList<>();
    private ArrayList<ForumData> hNE = new ArrayList<>();
    private an page = new an();
    private Date hNG = null;
    private boolean Jy = true;

    public a() {
        setHasMore(false);
    }

    public int bQV() {
        return this.hNH;
    }

    public void wV(int i) {
        this.hNH = i;
    }

    public void wW(int i) {
        this.hNH += i;
    }

    public int bQW() {
        return this.hNI;
    }

    public void wX(int i) {
        this.hNI = i;
    }

    public void wY(int i) {
        this.hNI += i;
    }

    public ArrayList<ForumData> bQX() {
        return this.hNB;
    }

    public ArrayList<ForumData> bQY() {
        return this.hNC;
    }

    public ArrayList<ForumData> bQZ() {
        return this.hNE;
    }

    public ArrayList<ForumData> bRa() {
        return this.hNF;
    }

    public ArrayList<ForumData> bRb() {
        return this.hNA;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.hNA == null) {
            this.hNA = new ArrayList<>();
        }
        if (this.hNB != null && arrayList != null) {
            this.hNB.clear();
            this.hNB.addAll(arrayList);
        }
        if (this.hNC != null && arrayList2 != null) {
            this.hNC.clear();
            this.hNC.addAll(arrayList2);
        }
        if (this.hNB != null || this.hNC != null) {
            this.hNA.clear();
            if (this.hNB != null) {
                this.hNA.addAll(this.hNB);
            }
            if (this.hNC != null) {
                this.hNA.addAll(this.hNC);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.hNA == null) {
            this.hNA = new ArrayList<>();
        }
        if (this.hNB != null && arrayList != null) {
            this.hNB.addAll(arrayList);
        }
        if (this.hNC != null && arrayList2 != null) {
            this.hNC.addAll(arrayList2);
        }
        if (this.hNB != null || this.hNC != null) {
            this.hNA.clear();
            if (this.hNB != null) {
                this.hNA.addAll(this.hNB);
            }
            if (this.hNC != null) {
                this.hNA.addAll(this.hNC);
            }
        }
    }

    public ArrayList<ForumData> bRc() {
        return this.hND;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.hND == null) {
            this.hND = new ArrayList<>();
        }
        if (this.hNE != null && arrayList != null) {
            this.hNE.addAll(arrayList);
        }
        if (this.hNF != null && arrayList2 != null) {
            this.hNF.addAll(arrayList2);
        }
        if (this.hNE != null || this.hNF != null) {
            this.hND.clear();
            if (this.hNE != null) {
                this.hND.addAll(this.hNE);
            }
            if (this.hNF != null) {
                this.hND.addAll(this.hNF);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.hND == null) {
            this.hND = new ArrayList<>();
        }
        if (this.hNE != null && arrayList != null) {
            this.hNE.clear();
            this.hNE.addAll(arrayList);
        }
        if (this.hNF != null && arrayList2 != null) {
            this.hNF.clear();
            this.hNF.addAll(arrayList2);
        }
        if (this.hNE != null || this.hNF != null) {
            this.hND.clear();
            if (this.hNE != null) {
                this.hND.addAll(this.hNE);
            }
            if (this.hNF != null) {
                this.hND.addAll(this.hNF);
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
            this.enY = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.hNG = new Date(optLong);
            } else {
                this.hNG = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.hNH = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.hNB.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.hNC.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.hNI = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.hNE.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.hNF.add(forumData4);
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
        return this.enY == 1;
    }

    public void setHasMore(boolean z) {
        this.enY = z ? 1 : 0;
    }
}
