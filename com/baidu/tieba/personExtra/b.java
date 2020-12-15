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
    private int jFO;
    private int mmN = 0;
    private int mmO = 0;
    private ArrayList<ForumData> mmG = new ArrayList<>();
    private ArrayList<ForumData> mmH = new ArrayList<>();
    private ArrayList<ForumData> mmI = new ArrayList<>();
    private ArrayList<ForumData> mmJ = new ArrayList<>();
    private ArrayList<ForumData> mmL = new ArrayList<>();
    private ArrayList<ForumData> mmK = new ArrayList<>();
    private ax page = new ax();
    private Date mmM = null;
    private boolean isSucc = true;

    public b() {
        setHasMore(false);
    }

    public int dzd() {
        return this.mmN;
    }

    public void Ih(int i) {
        this.mmN = i;
    }

    public void Ii(int i) {
        this.mmN += i;
    }

    public int dze() {
        return this.mmO;
    }

    public void Ij(int i) {
        this.mmO = i;
    }

    public void Ik(int i) {
        this.mmO += i;
    }

    public ArrayList<ForumData> dzf() {
        return this.mmH;
    }

    public ArrayList<ForumData> dzg() {
        return this.mmI;
    }

    public ArrayList<ForumData> dzh() {
        return this.mmK;
    }

    public ArrayList<ForumData> dzi() {
        return this.mmL;
    }

    public ArrayList<ForumData> dzj() {
        return this.mmG;
    }

    public void f(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mmG == null) {
            this.mmG = new ArrayList<>();
        }
        if (this.mmH != null && arrayList != null) {
            this.mmH.clear();
            this.mmH.addAll(arrayList);
        }
        if (this.mmI != null && arrayList2 != null) {
            this.mmI.clear();
            this.mmI.addAll(arrayList2);
        }
        if (this.mmH != null || this.mmI != null) {
            this.mmG.clear();
            if (this.mmH != null) {
                this.mmG.addAll(this.mmH);
            }
            if (this.mmI != null) {
                this.mmG.addAll(this.mmI);
            }
        }
    }

    public void g(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mmG == null) {
            this.mmG = new ArrayList<>();
        }
        if (this.mmH != null && arrayList != null) {
            this.mmH.addAll(arrayList);
        }
        if (this.mmI != null && arrayList2 != null) {
            this.mmI.addAll(arrayList2);
        }
        if (this.mmH != null || this.mmI != null) {
            this.mmG.clear();
            if (this.mmH != null) {
                this.mmG.addAll(this.mmH);
            }
            if (this.mmI != null) {
                this.mmG.addAll(this.mmI);
            }
        }
    }

    public ArrayList<ForumData> dzk() {
        return this.mmJ;
    }

    public void h(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mmJ == null) {
            this.mmJ = new ArrayList<>();
        }
        if (this.mmK != null && arrayList != null) {
            this.mmK.addAll(arrayList);
        }
        if (this.mmL != null && arrayList2 != null) {
            this.mmL.addAll(arrayList2);
        }
        if (this.mmK != null || this.mmL != null) {
            this.mmJ.clear();
            if (this.mmK != null) {
                this.mmJ.addAll(this.mmK);
            }
            if (this.mmL != null) {
                this.mmJ.addAll(this.mmL);
            }
        }
    }

    public void i(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.mmJ == null) {
            this.mmJ = new ArrayList<>();
        }
        if (this.mmK != null && arrayList != null) {
            this.mmK.clear();
            this.mmK.addAll(arrayList);
        }
        if (this.mmL != null && arrayList2 != null) {
            this.mmL.clear();
            this.mmL.addAll(arrayList2);
        }
        if (this.mmK != null || this.mmL != null) {
            this.mmJ.clear();
            if (this.mmK != null) {
                this.mmJ.addAll(this.mmK);
            }
            if (this.mmL != null) {
                this.mmJ.addAll(this.mmL);
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
            this.jFO = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.mmM = new Date(optLong);
            } else {
                this.mmM = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.mmN = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.mmH.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.mmI.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.mmO = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.mmK.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.mmL.add(forumData4);
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
        return this.jFO == 1;
    }

    public void setHasMore(boolean z) {
        this.jFO = z ? 1 : 0;
    }
}
