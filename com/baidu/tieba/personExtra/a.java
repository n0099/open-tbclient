package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.al;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private int cSW;
    private int glM = 0;
    private int glN = 0;
    private ArrayList<ForumData> glF = new ArrayList<>();
    private ArrayList<ForumData> glG = new ArrayList<>();
    private ArrayList<ForumData> glH = new ArrayList<>();
    private ArrayList<ForumData> glI = new ArrayList<>();
    private ArrayList<ForumData> glK = new ArrayList<>();
    private ArrayList<ForumData> glJ = new ArrayList<>();
    private al eWB = new al();
    private Date glL = null;
    private boolean Jo = true;

    public a() {
        setHasMore(false);
    }

    public int bnU() {
        return this.glM;
    }

    public void sl(int i) {
        this.glM = i;
    }

    public void sm(int i) {
        this.glM += i;
    }

    public int bnV() {
        return this.glN;
    }

    public void sn(int i) {
        this.glN = i;
    }

    public void so(int i) {
        this.glN += i;
    }

    public ArrayList<ForumData> bnW() {
        return this.glG;
    }

    public ArrayList<ForumData> bnX() {
        return this.glH;
    }

    public ArrayList<ForumData> bnY() {
        return this.glJ;
    }

    public ArrayList<ForumData> bnZ() {
        return this.glK;
    }

    public ArrayList<ForumData> boa() {
        return this.glF;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glF == null) {
            this.glF = new ArrayList<>();
        }
        if (this.glG != null && arrayList != null) {
            this.glG.clear();
            this.glG.addAll(arrayList);
        }
        if (this.glH != null && arrayList2 != null) {
            this.glH.clear();
            this.glH.addAll(arrayList2);
        }
        if (this.glG != null || this.glH != null) {
            this.glF.clear();
            if (this.glG != null) {
                this.glF.addAll(this.glG);
            }
            if (this.glH != null) {
                this.glF.addAll(this.glH);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glF == null) {
            this.glF = new ArrayList<>();
        }
        if (this.glG != null && arrayList != null) {
            this.glG.addAll(arrayList);
        }
        if (this.glH != null && arrayList2 != null) {
            this.glH.addAll(arrayList2);
        }
        if (this.glG != null || this.glH != null) {
            this.glF.clear();
            if (this.glG != null) {
                this.glF.addAll(this.glG);
            }
            if (this.glH != null) {
                this.glF.addAll(this.glH);
            }
        }
    }

    public ArrayList<ForumData> bob() {
        return this.glI;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glI == null) {
            this.glI = new ArrayList<>();
        }
        if (this.glJ != null && arrayList != null) {
            this.glJ.addAll(arrayList);
        }
        if (this.glK != null && arrayList2 != null) {
            this.glK.addAll(arrayList2);
        }
        if (this.glJ != null || this.glK != null) {
            this.glI.clear();
            if (this.glJ != null) {
                this.glI.addAll(this.glJ);
            }
            if (this.glK != null) {
                this.glI.addAll(this.glK);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.glI == null) {
            this.glI = new ArrayList<>();
        }
        if (this.glJ != null && arrayList != null) {
            this.glJ.clear();
            this.glJ.addAll(arrayList);
        }
        if (this.glK != null && arrayList2 != null) {
            this.glK.clear();
            this.glK.addAll(arrayList2);
        }
        if (this.glJ != null || this.glK != null) {
            this.glI.clear();
            if (this.glJ != null) {
                this.glI.addAll(this.glJ);
            }
            if (this.glK != null) {
                this.glI.addAll(this.glK);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Jo = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.eWB.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
            this.cSW = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.glL = new Date(optLong);
            } else {
                this.glL = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.glM = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.glG.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.glH.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.glN = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.glJ.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.glK.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Jo = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.cSW == 1;
    }

    public void setHasMore(boolean z) {
        this.cSW = z ? 1 : 0;
    }
}
