package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.at;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private int iiK;
    private int kIL = 0;
    private int kIM = 0;
    private ArrayList<ForumData> kIE = new ArrayList<>();
    private ArrayList<ForumData> kIF = new ArrayList<>();
    private ArrayList<ForumData> kIG = new ArrayList<>();
    private ArrayList<ForumData> kIH = new ArrayList<>();
    private ArrayList<ForumData> kIJ = new ArrayList<>();
    private ArrayList<ForumData> kII = new ArrayList<>();
    private at page = new at();
    private Date kIK = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int cSx() {
        return this.kIL;
    }

    public void Cl(int i) {
        this.kIL = i;
    }

    public void Cm(int i) {
        this.kIL += i;
    }

    public int cSy() {
        return this.kIM;
    }

    public void Cn(int i) {
        this.kIM = i;
    }

    public void Co(int i) {
        this.kIM += i;
    }

    public ArrayList<ForumData> cSz() {
        return this.kIF;
    }

    public ArrayList<ForumData> cSA() {
        return this.kIG;
    }

    public ArrayList<ForumData> cSB() {
        return this.kII;
    }

    public ArrayList<ForumData> cSC() {
        return this.kIJ;
    }

    public ArrayList<ForumData> cSD() {
        return this.kIE;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.kIE == null) {
            this.kIE = new ArrayList<>();
        }
        if (this.kIF != null && arrayList != null) {
            this.kIF.clear();
            this.kIF.addAll(arrayList);
        }
        if (this.kIG != null && arrayList2 != null) {
            this.kIG.clear();
            this.kIG.addAll(arrayList2);
        }
        if (this.kIF != null || this.kIG != null) {
            this.kIE.clear();
            if (this.kIF != null) {
                this.kIE.addAll(this.kIF);
            }
            if (this.kIG != null) {
                this.kIE.addAll(this.kIG);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.kIE == null) {
            this.kIE = new ArrayList<>();
        }
        if (this.kIF != null && arrayList != null) {
            this.kIF.addAll(arrayList);
        }
        if (this.kIG != null && arrayList2 != null) {
            this.kIG.addAll(arrayList2);
        }
        if (this.kIF != null || this.kIG != null) {
            this.kIE.clear();
            if (this.kIF != null) {
                this.kIE.addAll(this.kIF);
            }
            if (this.kIG != null) {
                this.kIE.addAll(this.kIG);
            }
        }
    }

    public ArrayList<ForumData> cSE() {
        return this.kIH;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.kIH == null) {
            this.kIH = new ArrayList<>();
        }
        if (this.kII != null && arrayList != null) {
            this.kII.addAll(arrayList);
        }
        if (this.kIJ != null && arrayList2 != null) {
            this.kIJ.addAll(arrayList2);
        }
        if (this.kII != null || this.kIJ != null) {
            this.kIH.clear();
            if (this.kII != null) {
                this.kIH.addAll(this.kII);
            }
            if (this.kIJ != null) {
                this.kIH.addAll(this.kIJ);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.kIH == null) {
            this.kIH = new ArrayList<>();
        }
        if (this.kII != null && arrayList != null) {
            this.kII.clear();
            this.kII.addAll(arrayList);
        }
        if (this.kIJ != null && arrayList2 != null) {
            this.kIJ.clear();
            this.kIJ.addAll(arrayList2);
        }
        if (this.kII != null || this.kIJ != null) {
            this.kIH.clear();
            if (this.kII != null) {
                this.kIH.addAll(this.kII);
            }
            if (this.kIJ != null) {
                this.kIH.addAll(this.kIJ);
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
            this.iiK = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.kIK = new Date(optLong);
            } else {
                this.kIK = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.kIL = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.kIF.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.kIG.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.kIM = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.kII.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.kIJ.add(forumData4);
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
        return this.iiK == 1;
    }

    public void setHasMore(boolean z) {
        this.iiK = z ? 1 : 0;
    }
}
