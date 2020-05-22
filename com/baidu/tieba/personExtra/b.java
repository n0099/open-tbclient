package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ao;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private int hTD;
    private int knH = 0;
    private int knI = 0;
    private ArrayList<ForumData> knA = new ArrayList<>();
    private ArrayList<ForumData> knB = new ArrayList<>();
    private ArrayList<ForumData> knC = new ArrayList<>();
    private ArrayList<ForumData> knD = new ArrayList<>();
    private ArrayList<ForumData> knF = new ArrayList<>();
    private ArrayList<ForumData> knE = new ArrayList<>();
    private ao page = new ao();
    private Date knG = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cNQ() {
        return this.knH;
    }

    public void Bh(int i) {
        this.knH = i;
    }

    public void Bi(int i) {
        this.knH += i;
    }

    public int cNR() {
        return this.knI;
    }

    public void Bj(int i) {
        this.knI = i;
    }

    public void Bk(int i) {
        this.knI += i;
    }

    public ArrayList<ForumData> cNS() {
        return this.knB;
    }

    public ArrayList<ForumData> cNT() {
        return this.knC;
    }

    public ArrayList<ForumData> cNU() {
        return this.knE;
    }

    public ArrayList<ForumData> cNV() {
        return this.knF;
    }

    public ArrayList<ForumData> cNW() {
        return this.knA;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.knA == null) {
            this.knA = new ArrayList<>();
        }
        if (this.knB != null && arrayList != null) {
            this.knB.clear();
            this.knB.addAll(arrayList);
        }
        if (this.knC != null && arrayList2 != null) {
            this.knC.clear();
            this.knC.addAll(arrayList2);
        }
        if (this.knB != null || this.knC != null) {
            this.knA.clear();
            if (this.knB != null) {
                this.knA.addAll(this.knB);
            }
            if (this.knC != null) {
                this.knA.addAll(this.knC);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.knA == null) {
            this.knA = new ArrayList<>();
        }
        if (this.knB != null && arrayList != null) {
            this.knB.addAll(arrayList);
        }
        if (this.knC != null && arrayList2 != null) {
            this.knC.addAll(arrayList2);
        }
        if (this.knB != null || this.knC != null) {
            this.knA.clear();
            if (this.knB != null) {
                this.knA.addAll(this.knB);
            }
            if (this.knC != null) {
                this.knA.addAll(this.knC);
            }
        }
    }

    public ArrayList<ForumData> cNX() {
        return this.knD;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.knD == null) {
            this.knD = new ArrayList<>();
        }
        if (this.knE != null && arrayList != null) {
            this.knE.addAll(arrayList);
        }
        if (this.knF != null && arrayList2 != null) {
            this.knF.addAll(arrayList2);
        }
        if (this.knE != null || this.knF != null) {
            this.knD.clear();
            if (this.knE != null) {
                this.knD.addAll(this.knE);
            }
            if (this.knF != null) {
                this.knD.addAll(this.knF);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.knD == null) {
            this.knD = new ArrayList<>();
        }
        if (this.knE != null && arrayList != null) {
            this.knE.clear();
            this.knE.addAll(arrayList);
        }
        if (this.knF != null && arrayList2 != null) {
            this.knF.clear();
            this.knF.addAll(arrayList2);
        }
        if (this.knE != null || this.knF != null) {
            this.knD.clear();
            if (this.knE != null) {
                this.knD.addAll(this.knE);
            }
            if (this.knF != null) {
                this.knD.addAll(this.knF);
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
            this.hTD = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.knG = new Date(optLong);
            } else {
                this.knG = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.knH = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.knB.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.knC.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.knI = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.knE.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.knF.add(forumData4);
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
        return this.hTD == 1;
    }

    public void setHasMore(boolean z) {
        this.hTD = z ? 1 : 0;
    }
}
