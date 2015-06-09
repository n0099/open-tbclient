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
    private int bRK = 0;
    private int bRL = 0;
    private ArrayList<ForumData> bRD = new ArrayList<>();
    private ArrayList<ForumData> bRE = new ArrayList<>();
    private ArrayList<ForumData> bRF = new ArrayList<>();
    private ArrayList<ForumData> bRG = new ArrayList<>();
    private ArrayList<ForumData> bRI = new ArrayList<>();
    private ArrayList<ForumData> bRH = new ArrayList<>();
    private com.baidu.tbadk.core.data.q bGl = new com.baidu.tbadk.core.data.q();
    private Date bRJ = null;
    private boolean acq = true;

    public u() {
        setHasMore(false);
    }

    public int aee() {
        return this.bRK;
    }

    public void hK(int i) {
        this.bRK = i;
    }

    public void hL(int i) {
        this.bRK += i;
    }

    public int aef() {
        return this.bRL;
    }

    public void hM(int i) {
        this.bRL = i;
    }

    public void hN(int i) {
        this.bRL += i;
    }

    public ArrayList<ForumData> aeg() {
        return this.bRE;
    }

    public ArrayList<ForumData> aeh() {
        return this.bRF;
    }

    public ArrayList<ForumData> aei() {
        return this.bRH;
    }

    public ArrayList<ForumData> aej() {
        return this.bRI;
    }

    public ArrayList<ForumData> aek() {
        return this.bRD;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bRD == null) {
            this.bRD = new ArrayList<>();
        }
        if (this.bRE != null && arrayList != null) {
            this.bRE.clear();
            this.bRE.addAll(arrayList);
        }
        if (this.bRF != null && arrayList2 != null) {
            this.bRF.clear();
            this.bRF.addAll(arrayList2);
        }
        if (this.bRE != null || this.bRF != null) {
            this.bRD.clear();
            if (this.bRE != null) {
                this.bRD.addAll(this.bRE);
            }
            if (this.bRF != null) {
                this.bRD.addAll(this.bRF);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bRD == null) {
            this.bRD = new ArrayList<>();
        }
        if (this.bRE != null && arrayList != null) {
            this.bRE.addAll(arrayList);
        }
        if (this.bRF != null && arrayList2 != null) {
            this.bRF.addAll(arrayList2);
        }
        if (this.bRE != null || this.bRF != null) {
            this.bRD.clear();
            if (this.bRE != null) {
                this.bRD.addAll(this.bRE);
            }
            if (this.bRF != null) {
                this.bRD.addAll(this.bRF);
            }
        }
    }

    public ArrayList<ForumData> ael() {
        return this.bRG;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bRG == null) {
            this.bRG = new ArrayList<>();
        }
        if (this.bRH != null && arrayList != null) {
            this.bRH.addAll(arrayList);
        }
        if (this.bRI != null && arrayList2 != null) {
            this.bRI.addAll(arrayList2);
        }
        if (this.bRH != null || this.bRI != null) {
            this.bRG.clear();
            if (this.bRH != null) {
                this.bRG.addAll(this.bRH);
            }
            if (this.bRI != null) {
                this.bRG.addAll(this.bRI);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.bRG == null) {
            this.bRG = new ArrayList<>();
        }
        if (this.bRH != null && arrayList != null) {
            this.bRH.clear();
            this.bRH.addAll(arrayList);
        }
        if (this.bRI != null && arrayList2 != null) {
            this.bRI.clear();
            this.bRI.addAll(arrayList2);
        }
        if (this.bRH != null || this.bRI != null) {
            this.bRG.clear();
            if (this.bRH != null) {
                this.bRG.addAll(this.bRH);
            }
            if (this.bRI != null) {
                this.bRG.addAll(this.bRI);
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
            this.bGl.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.bRJ = new Date(optLong);
            } else {
                this.bRJ = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.bRK = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.bRE.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.bRF.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.bRL = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.bRH.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.bRI.add(forumData4);
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
