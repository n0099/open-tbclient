package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class u {
    private int hasMore;
    private int bRJ = 0;
    private int bRK = 0;
    private ArrayList<ForumData> bRC = new ArrayList<>();
    private ArrayList<ForumData> bRD = new ArrayList<>();
    private ArrayList<ForumData> bRE = new ArrayList<>();
    private ArrayList<ForumData> bRF = new ArrayList<>();
    private ArrayList<ForumData> bRH = new ArrayList<>();
    private ArrayList<ForumData> bRG = new ArrayList<>();
    private com.baidu.tbadk.core.data.q bGk = new com.baidu.tbadk.core.data.q();
    private Date bRI = null;
    private boolean acq = true;

    public u() {
        setHasMore(false);
    }

    public int aed() {
        return this.bRJ;
    }

    public void hK(int i) {
        this.bRJ = i;
    }

    public void hL(int i) {
        this.bRJ += i;
    }

    public int aee() {
        return this.bRK;
    }

    public void hM(int i) {
        this.bRK = i;
    }

    public void hN(int i) {
        this.bRK += i;
    }

    public ArrayList<ForumData> aef() {
        return this.bRD;
    }

    public ArrayList<ForumData> aeg() {
        return this.bRE;
    }

    public ArrayList<ForumData> aeh() {
        return this.bRG;
    }

    public ArrayList<ForumData> aei() {
        return this.bRH;
    }

    public ArrayList<ForumData> aej() {
        return this.bRC;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bRC == null) {
            this.bRC = new ArrayList<>();
        }
        if (this.bRD != null && arrayList != null) {
            this.bRD.clear();
            this.bRD.addAll(arrayList);
        }
        if (this.bRE != null && arrayList2 != null) {
            this.bRE.clear();
            this.bRE.addAll(arrayList2);
        }
        if (this.bRD != null || this.bRE != null) {
            this.bRC.clear();
            if (this.bRD != null) {
                this.bRC.addAll(this.bRD);
            }
            if (this.bRE != null) {
                this.bRC.addAll(this.bRE);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bRC == null) {
            this.bRC = new ArrayList<>();
        }
        if (this.bRD != null && arrayList != null) {
            this.bRD.addAll(arrayList);
        }
        if (this.bRE != null && arrayList2 != null) {
            this.bRE.addAll(arrayList2);
        }
        if (this.bRD != null || this.bRE != null) {
            this.bRC.clear();
            if (this.bRD != null) {
                this.bRC.addAll(this.bRD);
            }
            if (this.bRE != null) {
                this.bRC.addAll(this.bRE);
            }
        }
    }

    public ArrayList<ForumData> aek() {
        return this.bRF;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bRF == null) {
            this.bRF = new ArrayList<>();
        }
        if (this.bRG != null && arrayList != null) {
            this.bRG.addAll(arrayList);
        }
        if (this.bRH != null && arrayList2 != null) {
            this.bRH.addAll(arrayList2);
        }
        if (this.bRG != null || this.bRH != null) {
            this.bRF.clear();
            if (this.bRG != null) {
                this.bRF.addAll(this.bRG);
            }
            if (this.bRH != null) {
                this.bRF.addAll(this.bRH);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bRF == null) {
            this.bRF = new ArrayList<>();
        }
        if (this.bRG != null && arrayList != null) {
            this.bRG.clear();
            this.bRG.addAll(arrayList);
        }
        if (this.bRH != null && arrayList2 != null) {
            this.bRH.clear();
            this.bRH.addAll(arrayList2);
        }
        if (this.bRG != null || this.bRH != null) {
            this.bRF.clear();
            if (this.bRG != null) {
                this.bRF.addAll(this.bRG);
            }
            if (this.bRH != null) {
                this.bRF.addAll(this.bRH);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.acq = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.bGk.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.bRI = new Date(optLong);
            } else {
                this.bRI = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.bRJ = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.bRD.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bRE.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.bRK = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.bRG.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.bRH.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.acq = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.hasMore == 1;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z ? 1 : 0;
    }
}
