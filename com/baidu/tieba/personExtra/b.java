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
    private int hEQ;
    private int jVO = 0;
    private int jVP = 0;
    private ArrayList<ForumData> jVH = new ArrayList<>();
    private ArrayList<ForumData> jVI = new ArrayList<>();
    private ArrayList<ForumData> jVJ = new ArrayList<>();
    private ArrayList<ForumData> jVK = new ArrayList<>();
    private ArrayList<ForumData> jVM = new ArrayList<>();
    private ArrayList<ForumData> jVL = new ArrayList<>();
    private ap page = new ap();
    private Date jVN = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cGQ() {
        return this.jVO;
    }

    public void Aw(int i) {
        this.jVO = i;
    }

    public void Ax(int i) {
        this.jVO += i;
    }

    public int cGR() {
        return this.jVP;
    }

    public void Ay(int i) {
        this.jVP = i;
    }

    public void Az(int i) {
        this.jVP += i;
    }

    public ArrayList<ForumData> cGS() {
        return this.jVI;
    }

    public ArrayList<ForumData> cGT() {
        return this.jVJ;
    }

    public ArrayList<ForumData> cGU() {
        return this.jVL;
    }

    public ArrayList<ForumData> cGV() {
        return this.jVM;
    }

    public ArrayList<ForumData> cGW() {
        return this.jVH;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jVH == null) {
            this.jVH = new ArrayList<>();
        }
        if (this.jVI != null && arrayList != null) {
            this.jVI.clear();
            this.jVI.addAll(arrayList);
        }
        if (this.jVJ != null && arrayList2 != null) {
            this.jVJ.clear();
            this.jVJ.addAll(arrayList2);
        }
        if (this.jVI != null || this.jVJ != null) {
            this.jVH.clear();
            if (this.jVI != null) {
                this.jVH.addAll(this.jVI);
            }
            if (this.jVJ != null) {
                this.jVH.addAll(this.jVJ);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jVH == null) {
            this.jVH = new ArrayList<>();
        }
        if (this.jVI != null && arrayList != null) {
            this.jVI.addAll(arrayList);
        }
        if (this.jVJ != null && arrayList2 != null) {
            this.jVJ.addAll(arrayList2);
        }
        if (this.jVI != null || this.jVJ != null) {
            this.jVH.clear();
            if (this.jVI != null) {
                this.jVH.addAll(this.jVI);
            }
            if (this.jVJ != null) {
                this.jVH.addAll(this.jVJ);
            }
        }
    }

    public ArrayList<ForumData> cGX() {
        return this.jVK;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jVK == null) {
            this.jVK = new ArrayList<>();
        }
        if (this.jVL != null && arrayList != null) {
            this.jVL.addAll(arrayList);
        }
        if (this.jVM != null && arrayList2 != null) {
            this.jVM.addAll(arrayList2);
        }
        if (this.jVL != null || this.jVM != null) {
            this.jVK.clear();
            if (this.jVL != null) {
                this.jVK.addAll(this.jVL);
            }
            if (this.jVM != null) {
                this.jVK.addAll(this.jVM);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.jVK == null) {
            this.jVK = new ArrayList<>();
        }
        if (this.jVL != null && arrayList != null) {
            this.jVL.clear();
            this.jVL.addAll(arrayList);
        }
        if (this.jVM != null && arrayList2 != null) {
            this.jVM.clear();
            this.jVM.addAll(arrayList2);
        }
        if (this.jVL != null || this.jVM != null) {
            this.jVK.clear();
            if (this.jVL != null) {
                this.jVK.addAll(this.jVL);
            }
            if (this.jVM != null) {
                this.jVK.addAll(this.jVM);
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
            this.hEQ = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.jVN = new Date(optLong);
            } else {
                this.jVN = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.jVO = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.jVI.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.jVJ.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.jVP = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.jVL.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.jVM.add(forumData4);
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
        return this.hEQ == 1;
    }

    public void setHasMore(boolean z) {
        this.hEQ = z ? 1 : 0;
    }
}
