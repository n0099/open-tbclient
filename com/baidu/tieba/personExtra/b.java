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
    private int gTM;
    private int jjW = 0;
    private int jjX = 0;
    private ArrayList<ForumData> jjP = new ArrayList<>();
    private ArrayList<ForumData> jjQ = new ArrayList<>();
    private ArrayList<ForumData> jjR = new ArrayList<>();
    private ArrayList<ForumData> jjS = new ArrayList<>();
    private ArrayList<ForumData> jjU = new ArrayList<>();
    private ArrayList<ForumData> jjT = new ArrayList<>();
    private ap page = new ap();
    private Date jjV = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cvP() {
        return this.jjW;
    }

    public void zN(int i) {
        this.jjW = i;
    }

    public void zO(int i) {
        this.jjW += i;
    }

    public int cvQ() {
        return this.jjX;
    }

    public void zP(int i) {
        this.jjX = i;
    }

    public void zQ(int i) {
        this.jjX += i;
    }

    public ArrayList<ForumData> cvR() {
        return this.jjQ;
    }

    public ArrayList<ForumData> cvS() {
        return this.jjR;
    }

    public ArrayList<ForumData> cvT() {
        return this.jjT;
    }

    public ArrayList<ForumData> cvU() {
        return this.jjU;
    }

    public ArrayList<ForumData> cvV() {
        return this.jjP;
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jjP == null) {
            this.jjP = new ArrayList<>();
        }
        if (this.jjQ != null && arrayList != null) {
            this.jjQ.clear();
            this.jjQ.addAll(arrayList);
        }
        if (this.jjR != null && arrayList2 != null) {
            this.jjR.clear();
            this.jjR.addAll(arrayList2);
        }
        if (this.jjQ != null || this.jjR != null) {
            this.jjP.clear();
            if (this.jjQ != null) {
                this.jjP.addAll(this.jjQ);
            }
            if (this.jjR != null) {
                this.jjP.addAll(this.jjR);
            }
        }
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jjP == null) {
            this.jjP = new ArrayList<>();
        }
        if (this.jjQ != null && arrayList != null) {
            this.jjQ.addAll(arrayList);
        }
        if (this.jjR != null && arrayList2 != null) {
            this.jjR.addAll(arrayList2);
        }
        if (this.jjQ != null || this.jjR != null) {
            this.jjP.clear();
            if (this.jjQ != null) {
                this.jjP.addAll(this.jjQ);
            }
            if (this.jjR != null) {
                this.jjP.addAll(this.jjR);
            }
        }
    }

    public ArrayList<ForumData> cvW() {
        return this.jjS;
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jjS == null) {
            this.jjS = new ArrayList<>();
        }
        if (this.jjT != null && arrayList != null) {
            this.jjT.addAll(arrayList);
        }
        if (this.jjU != null && arrayList2 != null) {
            this.jjU.addAll(arrayList2);
        }
        if (this.jjT != null || this.jjU != null) {
            this.jjS.clear();
            if (this.jjT != null) {
                this.jjS.addAll(this.jjT);
            }
            if (this.jjU != null) {
                this.jjS.addAll(this.jjU);
            }
        }
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jjS == null) {
            this.jjS = new ArrayList<>();
        }
        if (this.jjT != null && arrayList != null) {
            this.jjT.clear();
            this.jjT.addAll(arrayList);
        }
        if (this.jjU != null && arrayList2 != null) {
            this.jjU.clear();
            this.jjU.addAll(arrayList2);
        }
        if (this.jjT != null || this.jjU != null) {
            this.jjS.clear();
            if (this.jjT != null) {
                this.jjS.addAll(this.jjT);
            }
            if (this.jjU != null) {
                this.jjS.addAll(this.jjU);
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
            this.gTM = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.jjV = new Date(optLong);
            } else {
                this.jjV = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.jjW = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.jjQ.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.jjR.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.jjX = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.jjT.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.jjU.add(forumData4);
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
        return this.gTM == 1;
    }

    public void setHasMore(boolean z) {
        this.gTM = z ? 1 : 0;
    }
}
