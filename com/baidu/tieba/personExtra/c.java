package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.al;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private int dcP;
    private int glI = 0;
    private int glJ = 0;
    private ArrayList<ForumData> glB = new ArrayList<>();
    private ArrayList<ForumData> glC = new ArrayList<>();
    private ArrayList<ForumData> glD = new ArrayList<>();
    private ArrayList<ForumData> glE = new ArrayList<>();
    private ArrayList<ForumData> glG = new ArrayList<>();
    private ArrayList<ForumData> glF = new ArrayList<>();
    private al eSZ = new al();
    private Date glH = null;
    private boolean apH = true;

    public c() {
        setHasMore(false);
    }

    public int bjk() {
        return this.glI;
    }

    public void tE(int i) {
        this.glI = i;
    }

    public void tF(int i) {
        this.glI += i;
    }

    public int bjl() {
        return this.glJ;
    }

    public void tG(int i) {
        this.glJ = i;
    }

    public void tH(int i) {
        this.glJ += i;
    }

    public ArrayList<ForumData> bjm() {
        return this.glC;
    }

    public ArrayList<ForumData> bjn() {
        return this.glD;
    }

    public ArrayList<ForumData> bjo() {
        return this.glF;
    }

    public ArrayList<ForumData> bjp() {
        return this.glG;
    }

    public ArrayList<ForumData> bjq() {
        return this.glB;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glB == null) {
            this.glB = new ArrayList<>();
        }
        if (this.glC != null && arrayList != null) {
            this.glC.clear();
            this.glC.addAll(arrayList);
        }
        if (this.glD != null && arrayList2 != null) {
            this.glD.clear();
            this.glD.addAll(arrayList2);
        }
        if (this.glC != null || this.glD != null) {
            this.glB.clear();
            if (this.glC != null) {
                this.glB.addAll(this.glC);
            }
            if (this.glD != null) {
                this.glB.addAll(this.glD);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glB == null) {
            this.glB = new ArrayList<>();
        }
        if (this.glC != null && arrayList != null) {
            this.glC.addAll(arrayList);
        }
        if (this.glD != null && arrayList2 != null) {
            this.glD.addAll(arrayList2);
        }
        if (this.glC != null || this.glD != null) {
            this.glB.clear();
            if (this.glC != null) {
                this.glB.addAll(this.glC);
            }
            if (this.glD != null) {
                this.glB.addAll(this.glD);
            }
        }
    }

    public ArrayList<ForumData> bjr() {
        return this.glE;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glE == null) {
            this.glE = new ArrayList<>();
        }
        if (this.glF != null && arrayList != null) {
            this.glF.addAll(arrayList);
        }
        if (this.glG != null && arrayList2 != null) {
            this.glG.addAll(arrayList2);
        }
        if (this.glF != null || this.glG != null) {
            this.glE.clear();
            if (this.glF != null) {
                this.glE.addAll(this.glF);
            }
            if (this.glG != null) {
                this.glE.addAll(this.glG);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glE == null) {
            this.glE = new ArrayList<>();
        }
        if (this.glF != null && arrayList != null) {
            this.glF.clear();
            this.glF.addAll(arrayList);
        }
        if (this.glG != null && arrayList2 != null) {
            this.glG.clear();
            this.glG.addAll(arrayList2);
        }
        if (this.glF != null || this.glG != null) {
            this.glE.clear();
            if (this.glF != null) {
                this.glE.addAll(this.glF);
            }
            if (this.glG != null) {
                this.glE.addAll(this.glG);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.apH = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.eSZ.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
            this.dcP = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.glH = new Date(optLong);
            } else {
                this.glH = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.glI = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.glC.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.glD.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.glJ = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.glF.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.glG.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.apH = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.dcP == 1;
    }

    public void setHasMore(boolean z) {
        this.dcP = z ? 1 : 0;
    }
}
