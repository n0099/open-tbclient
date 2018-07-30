package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.al;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private int cEP;
    private int fWU = 0;
    private int fWV = 0;
    private ArrayList<ForumData> fWN = new ArrayList<>();
    private ArrayList<ForumData> fWO = new ArrayList<>();
    private ArrayList<ForumData> fWP = new ArrayList<>();
    private ArrayList<ForumData> fWQ = new ArrayList<>();
    private ArrayList<ForumData> fWS = new ArrayList<>();
    private ArrayList<ForumData> fWR = new ArrayList<>();
    private al eHH = new al();
    private Date fWT = null;
    private boolean Gp = true;

    public a() {
        setHasMore(false);
    }

    public int bil() {
        return this.fWU;
    }

    public void rr(int i) {
        this.fWU = i;
    }

    public void rs(int i) {
        this.fWU += i;
    }

    public int bim() {
        return this.fWV;
    }

    public void rt(int i) {
        this.fWV = i;
    }

    public void ru(int i) {
        this.fWV += i;
    }

    public ArrayList<ForumData> bin() {
        return this.fWO;
    }

    public ArrayList<ForumData> bio() {
        return this.fWP;
    }

    public ArrayList<ForumData> bip() {
        return this.fWR;
    }

    public ArrayList<ForumData> biq() {
        return this.fWS;
    }

    public ArrayList<ForumData> bir() {
        return this.fWN;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fWN == null) {
            this.fWN = new ArrayList<>();
        }
        if (this.fWO != null && arrayList != null) {
            this.fWO.clear();
            this.fWO.addAll(arrayList);
        }
        if (this.fWP != null && arrayList2 != null) {
            this.fWP.clear();
            this.fWP.addAll(arrayList2);
        }
        if (this.fWO != null || this.fWP != null) {
            this.fWN.clear();
            if (this.fWO != null) {
                this.fWN.addAll(this.fWO);
            }
            if (this.fWP != null) {
                this.fWN.addAll(this.fWP);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fWN == null) {
            this.fWN = new ArrayList<>();
        }
        if (this.fWO != null && arrayList != null) {
            this.fWO.addAll(arrayList);
        }
        if (this.fWP != null && arrayList2 != null) {
            this.fWP.addAll(arrayList2);
        }
        if (this.fWO != null || this.fWP != null) {
            this.fWN.clear();
            if (this.fWO != null) {
                this.fWN.addAll(this.fWO);
            }
            if (this.fWP != null) {
                this.fWN.addAll(this.fWP);
            }
        }
    }

    public ArrayList<ForumData> bis() {
        return this.fWQ;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fWQ == null) {
            this.fWQ = new ArrayList<>();
        }
        if (this.fWR != null && arrayList != null) {
            this.fWR.addAll(arrayList);
        }
        if (this.fWS != null && arrayList2 != null) {
            this.fWS.addAll(arrayList2);
        }
        if (this.fWR != null || this.fWS != null) {
            this.fWQ.clear();
            if (this.fWR != null) {
                this.fWQ.addAll(this.fWR);
            }
            if (this.fWS != null) {
                this.fWQ.addAll(this.fWS);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fWQ == null) {
            this.fWQ = new ArrayList<>();
        }
        if (this.fWR != null && arrayList != null) {
            this.fWR.clear();
            this.fWR.addAll(arrayList);
        }
        if (this.fWS != null && arrayList2 != null) {
            this.fWS.clear();
            this.fWS.addAll(arrayList2);
        }
        if (this.fWR != null || this.fWS != null) {
            this.fWQ.clear();
            if (this.fWR != null) {
                this.fWQ.addAll(this.fWR);
            }
            if (this.fWS != null) {
                this.fWQ.addAll(this.fWS);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Gp = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.eHH.parserJson(jSONObject.optJSONObject("page"));
            this.cEP = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.fWT = new Date(optLong);
            } else {
                this.fWT = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.fWU = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.fWO.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.fWP.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.fWV = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.fWR.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.fWS.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Gp = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.cEP == 1;
    }

    public void setHasMore(boolean z) {
        this.cEP = z ? 1 : 0;
    }
}
