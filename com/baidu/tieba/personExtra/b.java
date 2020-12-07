package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ax;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class b {
    private int jFM;
    private int mmL = 0;
    private int mmM = 0;
    private ArrayList<ForumData> mmE = new ArrayList<>();
    private ArrayList<ForumData> mmF = new ArrayList<>();
    private ArrayList<ForumData> mmG = new ArrayList<>();
    private ArrayList<ForumData> mmH = new ArrayList<>();
    private ArrayList<ForumData> mmJ = new ArrayList<>();
    private ArrayList<ForumData> mmI = new ArrayList<>();
    private ax page = new ax();
    private Date mmK = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int dzc() {
        return this.mmL;
    }

    public void Ih(int i) {
        this.mmL = i;
    }

    public void Ii(int i) {
        this.mmL += i;
    }

    public int dzd() {
        return this.mmM;
    }

    public void Ij(int i) {
        this.mmM = i;
    }

    public void Ik(int i) {
        this.mmM += i;
    }

    public ArrayList<ForumData> dze() {
        return this.mmF;
    }

    public ArrayList<ForumData> dzf() {
        return this.mmG;
    }

    public ArrayList<ForumData> dzg() {
        return this.mmI;
    }

    public ArrayList<ForumData> dzh() {
        return this.mmJ;
    }

    public ArrayList<ForumData> dzi() {
        return this.mmE;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mmE == null) {
            this.mmE = new ArrayList<>();
        }
        if (this.mmF != null && arrayList != null) {
            this.mmF.clear();
            this.mmF.addAll(arrayList);
        }
        if (this.mmG != null && arrayList2 != null) {
            this.mmG.clear();
            this.mmG.addAll(arrayList2);
        }
        if (this.mmF != null || this.mmG != null) {
            this.mmE.clear();
            if (this.mmF != null) {
                this.mmE.addAll(this.mmF);
            }
            if (this.mmG != null) {
                this.mmE.addAll(this.mmG);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mmE == null) {
            this.mmE = new ArrayList<>();
        }
        if (this.mmF != null && arrayList != null) {
            this.mmF.addAll(arrayList);
        }
        if (this.mmG != null && arrayList2 != null) {
            this.mmG.addAll(arrayList2);
        }
        if (this.mmF != null || this.mmG != null) {
            this.mmE.clear();
            if (this.mmF != null) {
                this.mmE.addAll(this.mmF);
            }
            if (this.mmG != null) {
                this.mmE.addAll(this.mmG);
            }
        }
    }

    public ArrayList<ForumData> dzj() {
        return this.mmH;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mmH == null) {
            this.mmH = new ArrayList<>();
        }
        if (this.mmI != null && arrayList != null) {
            this.mmI.addAll(arrayList);
        }
        if (this.mmJ != null && arrayList2 != null) {
            this.mmJ.addAll(arrayList2);
        }
        if (this.mmI != null || this.mmJ != null) {
            this.mmH.clear();
            if (this.mmI != null) {
                this.mmH.addAll(this.mmI);
            }
            if (this.mmJ != null) {
                this.mmH.addAll(this.mmJ);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mmH == null) {
            this.mmH = new ArrayList<>();
        }
        if (this.mmI != null && arrayList != null) {
            this.mmI.clear();
            this.mmI.addAll(arrayList);
        }
        if (this.mmJ != null && arrayList2 != null) {
            this.mmJ.clear();
            this.mmJ.addAll(arrayList2);
        }
        if (this.mmI != null || this.mmJ != null) {
            this.mmH.clear();
            if (this.mmI != null) {
                this.mmH.addAll(this.mmI);
            }
            if (this.mmJ != null) {
                this.mmH.addAll(this.mmJ);
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
            this.jFM = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.mmK = new Date(optLong);
            } else {
                this.mmK = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.mmL = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.mmF.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.mmG.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.mmM = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.mmI.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.mmJ.add(forumData4);
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
        return this.jFM == 1;
    }

    public void setHasMore(boolean z) {
        this.jFM = z ? 1 : 0;
    }
}
