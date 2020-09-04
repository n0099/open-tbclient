package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.av;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class b {
    private int iDa;
    private int lhL = 0;
    private int lhM = 0;
    private ArrayList<ForumData> lhE = new ArrayList<>();
    private ArrayList<ForumData> lhF = new ArrayList<>();
    private ArrayList<ForumData> lhG = new ArrayList<>();
    private ArrayList<ForumData> lhH = new ArrayList<>();
    private ArrayList<ForumData> lhJ = new ArrayList<>();
    private ArrayList<ForumData> lhI = new ArrayList<>();
    private av page = new av();
    private Date lhK = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int dhm() {
        return this.lhL;
    }

    public void Ff(int i) {
        this.lhL = i;
    }

    public void Fg(int i) {
        this.lhL += i;
    }

    public int dhn() {
        return this.lhM;
    }

    public void Fh(int i) {
        this.lhM = i;
    }

    public void Fi(int i) {
        this.lhM += i;
    }

    public ArrayList<ForumData> dho() {
        return this.lhF;
    }

    public ArrayList<ForumData> dhp() {
        return this.lhG;
    }

    public ArrayList<ForumData> dhq() {
        return this.lhI;
    }

    public ArrayList<ForumData> dhr() {
        return this.lhJ;
    }

    public ArrayList<ForumData> dhs() {
        return this.lhE;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lhE == null) {
            this.lhE = new ArrayList<>();
        }
        if (this.lhF != null && arrayList != null) {
            this.lhF.clear();
            this.lhF.addAll(arrayList);
        }
        if (this.lhG != null && arrayList2 != null) {
            this.lhG.clear();
            this.lhG.addAll(arrayList2);
        }
        if (this.lhF != null || this.lhG != null) {
            this.lhE.clear();
            if (this.lhF != null) {
                this.lhE.addAll(this.lhF);
            }
            if (this.lhG != null) {
                this.lhE.addAll(this.lhG);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lhE == null) {
            this.lhE = new ArrayList<>();
        }
        if (this.lhF != null && arrayList != null) {
            this.lhF.addAll(arrayList);
        }
        if (this.lhG != null && arrayList2 != null) {
            this.lhG.addAll(arrayList2);
        }
        if (this.lhF != null || this.lhG != null) {
            this.lhE.clear();
            if (this.lhF != null) {
                this.lhE.addAll(this.lhF);
            }
            if (this.lhG != null) {
                this.lhE.addAll(this.lhG);
            }
        }
    }

    public ArrayList<ForumData> dht() {
        return this.lhH;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lhH == null) {
            this.lhH = new ArrayList<>();
        }
        if (this.lhI != null && arrayList != null) {
            this.lhI.addAll(arrayList);
        }
        if (this.lhJ != null && arrayList2 != null) {
            this.lhJ.addAll(arrayList2);
        }
        if (this.lhI != null || this.lhJ != null) {
            this.lhH.clear();
            if (this.lhI != null) {
                this.lhH.addAll(this.lhI);
            }
            if (this.lhJ != null) {
                this.lhH.addAll(this.lhJ);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.lhH == null) {
            this.lhH = new ArrayList<>();
        }
        if (this.lhI != null && arrayList != null) {
            this.lhI.clear();
            this.lhI.addAll(arrayList);
        }
        if (this.lhJ != null && arrayList2 != null) {
            this.lhJ.clear();
            this.lhJ.addAll(arrayList2);
        }
        if (this.lhI != null || this.lhJ != null) {
            this.lhH.clear();
            if (this.lhI != null) {
                this.lhH.addAll(this.lhI);
            }
            if (this.lhJ != null) {
                this.lhH.addAll(this.lhJ);
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
            this.iDa = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.lhK = new Date(optLong);
            } else {
                this.lhK = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.lhL = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.lhF.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.lhG.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.lhM = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.lhI.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.lhJ.add(forumData4);
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
        return this.iDa == 1;
    }

    public void setHasMore(boolean z) {
        this.iDa = z ? 1 : 0;
    }
}
