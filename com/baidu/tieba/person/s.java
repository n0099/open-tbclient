package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s {
    private int Oq;
    private int edO = 0;
    private int edP = 0;
    private ArrayList<ForumData> edH = new ArrayList<>();
    private ArrayList<ForumData> edI = new ArrayList<>();
    private ArrayList<ForumData> edJ = new ArrayList<>();
    private ArrayList<ForumData> edK = new ArrayList<>();
    private ArrayList<ForumData> edM = new ArrayList<>();
    private ArrayList<ForumData> edL = new ArrayList<>();
    private com.baidu.tbadk.core.data.af deh = new com.baidu.tbadk.core.data.af();
    private Date edN = null;
    private boolean tb = true;

    public s() {
        setHasMore(false);
    }

    public int aKp() {
        return this.edO;
    }

    public void nL(int i) {
        this.edO = i;
    }

    public void nM(int i) {
        this.edO += i;
    }

    public int aKq() {
        return this.edP;
    }

    public void nN(int i) {
        this.edP = i;
    }

    public void nO(int i) {
        this.edP += i;
    }

    public ArrayList<ForumData> aKr() {
        return this.edI;
    }

    public ArrayList<ForumData> aKs() {
        return this.edJ;
    }

    public ArrayList<ForumData> aKt() {
        return this.edL;
    }

    public ArrayList<ForumData> aKu() {
        return this.edM;
    }

    public ArrayList<ForumData> aKv() {
        return this.edH;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.edH == null) {
            this.edH = new ArrayList<>();
        }
        if (this.edI != null && arrayList != null) {
            this.edI.clear();
            this.edI.addAll(arrayList);
        }
        if (this.edJ != null && arrayList2 != null) {
            this.edJ.clear();
            this.edJ.addAll(arrayList2);
        }
        if (this.edI != null || this.edJ != null) {
            this.edH.clear();
            if (this.edI != null) {
                this.edH.addAll(this.edI);
            }
            if (this.edJ != null) {
                this.edH.addAll(this.edJ);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.edH == null) {
            this.edH = new ArrayList<>();
        }
        if (this.edI != null && arrayList != null) {
            this.edI.addAll(arrayList);
        }
        if (this.edJ != null && arrayList2 != null) {
            this.edJ.addAll(arrayList2);
        }
        if (this.edI != null || this.edJ != null) {
            this.edH.clear();
            if (this.edI != null) {
                this.edH.addAll(this.edI);
            }
            if (this.edJ != null) {
                this.edH.addAll(this.edJ);
            }
        }
    }

    public ArrayList<ForumData> aKw() {
        return this.edK;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.edK == null) {
            this.edK = new ArrayList<>();
        }
        if (this.edL != null && arrayList != null) {
            this.edL.addAll(arrayList);
        }
        if (this.edM != null && arrayList2 != null) {
            this.edM.addAll(arrayList2);
        }
        if (this.edL != null || this.edM != null) {
            this.edK.clear();
            if (this.edL != null) {
                this.edK.addAll(this.edL);
            }
            if (this.edM != null) {
                this.edK.addAll(this.edM);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.edK == null) {
            this.edK = new ArrayList<>();
        }
        if (this.edL != null && arrayList != null) {
            this.edL.clear();
            this.edL.addAll(arrayList);
        }
        if (this.edM != null && arrayList2 != null) {
            this.edM.clear();
            this.edM.addAll(arrayList2);
        }
        if (this.edL != null || this.edM != null) {
            this.edK.clear();
            if (this.edL != null) {
                this.edK.addAll(this.edL);
            }
            if (this.edM != null) {
                this.edK.addAll(this.edM);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.tb = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.deh.parserJson(jSONObject.optJSONObject("page"));
            this.Oq = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.edN = new Date(optLong);
            } else {
                this.edN = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.edO = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.edI.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.edJ.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.edP = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.edL.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.edM.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.tb = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.Oq == 1;
    }

    public void setHasMore(boolean z) {
        this.Oq = z ? 1 : 0;
    }
}
