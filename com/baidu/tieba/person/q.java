package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class q {
    private int hasMore;
    private int cip = 0;
    private int ciq = 0;
    private ArrayList<ForumData> cii = new ArrayList<>();
    private ArrayList<ForumData> cij = new ArrayList<>();
    private ArrayList<ForumData> cik = new ArrayList<>();
    private ArrayList<ForumData> cil = new ArrayList<>();
    private ArrayList<ForumData> cin = new ArrayList<>();
    private ArrayList<ForumData> cim = new ArrayList<>();
    private com.baidu.tbadk.core.data.p bWc = new com.baidu.tbadk.core.data.p();
    private Date cio = null;
    private boolean ahA = true;

    public q() {
        setHasMore(false);
    }

    public int afV() {
        return this.cip;
    }

    public void iE(int i) {
        this.cip = i;
    }

    public void iF(int i) {
        this.cip += i;
    }

    public int afW() {
        return this.ciq;
    }

    public void iG(int i) {
        this.ciq = i;
    }

    public void iH(int i) {
        this.ciq += i;
    }

    public ArrayList<ForumData> afX() {
        return this.cij;
    }

    public ArrayList<ForumData> afY() {
        return this.cik;
    }

    public ArrayList<ForumData> afZ() {
        return this.cim;
    }

    public ArrayList<ForumData> aga() {
        return this.cin;
    }

    public ArrayList<ForumData> agb() {
        return this.cii;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cii == null) {
            this.cii = new ArrayList<>();
        }
        if (this.cij != null && arrayList != null) {
            this.cij.clear();
            this.cij.addAll(arrayList);
        }
        if (this.cik != null && arrayList2 != null) {
            this.cik.clear();
            this.cik.addAll(arrayList2);
        }
        if (this.cij != null || this.cik != null) {
            this.cii.clear();
            if (this.cij != null) {
                this.cii.addAll(this.cij);
            }
            if (this.cik != null) {
                this.cii.addAll(this.cik);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cii == null) {
            this.cii = new ArrayList<>();
        }
        if (this.cij != null && arrayList != null) {
            this.cij.addAll(arrayList);
        }
        if (this.cik != null && arrayList2 != null) {
            this.cik.addAll(arrayList2);
        }
        if (this.cij != null || this.cik != null) {
            this.cii.clear();
            if (this.cij != null) {
                this.cii.addAll(this.cij);
            }
            if (this.cik != null) {
                this.cii.addAll(this.cik);
            }
        }
    }

    public ArrayList<ForumData> agc() {
        return this.cil;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cil == null) {
            this.cil = new ArrayList<>();
        }
        if (this.cim != null && arrayList != null) {
            this.cim.addAll(arrayList);
        }
        if (this.cin != null && arrayList2 != null) {
            this.cin.addAll(arrayList2);
        }
        if (this.cim != null || this.cin != null) {
            this.cil.clear();
            if (this.cim != null) {
                this.cil.addAll(this.cim);
            }
            if (this.cin != null) {
                this.cil.addAll(this.cin);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.cil == null) {
            this.cil = new ArrayList<>();
        }
        if (this.cim != null && arrayList != null) {
            this.cim.clear();
            this.cim.addAll(arrayList);
        }
        if (this.cin != null && arrayList2 != null) {
            this.cin.clear();
            this.cin.addAll(arrayList2);
        }
        if (this.cim != null || this.cin != null) {
            this.cil.clear();
            if (this.cim != null) {
                this.cil.addAll(this.cim);
            }
            if (this.cin != null) {
                this.cil.addAll(this.cin);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.ahA = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.bWc.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.cio = new Date(optLong);
            } else {
                this.cio = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.cip = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.cij.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.cik.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.ciq = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.cim.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.cin.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.ahA = false;
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
