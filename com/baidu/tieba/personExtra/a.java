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
    private int deq;
    private int gxX = 0;
    private int gxY = 0;
    private ArrayList<ForumData> gxQ = new ArrayList<>();
    private ArrayList<ForumData> gxR = new ArrayList<>();
    private ArrayList<ForumData> gxS = new ArrayList<>();
    private ArrayList<ForumData> gxT = new ArrayList<>();
    private ArrayList<ForumData> gxV = new ArrayList<>();
    private ArrayList<ForumData> gxU = new ArrayList<>();
    private al fip = new al();
    private Date gxW = null;
    private boolean Jr = true;

    public a() {
        setHasMore(false);
    }

    public int bqC() {
        return this.gxX;
    }

    public void tp(int i) {
        this.gxX = i;
    }

    public void tq(int i) {
        this.gxX += i;
    }

    public int bqD() {
        return this.gxY;
    }

    public void tr(int i) {
        this.gxY = i;
    }

    public void ts(int i) {
        this.gxY += i;
    }

    public ArrayList<ForumData> bqE() {
        return this.gxR;
    }

    public ArrayList<ForumData> bqF() {
        return this.gxS;
    }

    public ArrayList<ForumData> bqG() {
        return this.gxU;
    }

    public ArrayList<ForumData> bqH() {
        return this.gxV;
    }

    public ArrayList<ForumData> bqI() {
        return this.gxQ;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gxQ == null) {
            this.gxQ = new ArrayList<>();
        }
        if (this.gxR != null && arrayList != null) {
            this.gxR.clear();
            this.gxR.addAll(arrayList);
        }
        if (this.gxS != null && arrayList2 != null) {
            this.gxS.clear();
            this.gxS.addAll(arrayList2);
        }
        if (this.gxR != null || this.gxS != null) {
            this.gxQ.clear();
            if (this.gxR != null) {
                this.gxQ.addAll(this.gxR);
            }
            if (this.gxS != null) {
                this.gxQ.addAll(this.gxS);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gxQ == null) {
            this.gxQ = new ArrayList<>();
        }
        if (this.gxR != null && arrayList != null) {
            this.gxR.addAll(arrayList);
        }
        if (this.gxS != null && arrayList2 != null) {
            this.gxS.addAll(arrayList2);
        }
        if (this.gxR != null || this.gxS != null) {
            this.gxQ.clear();
            if (this.gxR != null) {
                this.gxQ.addAll(this.gxR);
            }
            if (this.gxS != null) {
                this.gxQ.addAll(this.gxS);
            }
        }
    }

    public ArrayList<ForumData> bqJ() {
        return this.gxT;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gxT == null) {
            this.gxT = new ArrayList<>();
        }
        if (this.gxU != null && arrayList != null) {
            this.gxU.addAll(arrayList);
        }
        if (this.gxV != null && arrayList2 != null) {
            this.gxV.addAll(arrayList2);
        }
        if (this.gxU != null || this.gxV != null) {
            this.gxT.clear();
            if (this.gxU != null) {
                this.gxT.addAll(this.gxU);
            }
            if (this.gxV != null) {
                this.gxT.addAll(this.gxV);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gxT == null) {
            this.gxT = new ArrayList<>();
        }
        if (this.gxU != null && arrayList != null) {
            this.gxU.clear();
            this.gxU.addAll(arrayList);
        }
        if (this.gxV != null && arrayList2 != null) {
            this.gxV.clear();
            this.gxV.addAll(arrayList2);
        }
        if (this.gxU != null || this.gxV != null) {
            this.gxT.clear();
            if (this.gxU != null) {
                this.gxT.addAll(this.gxU);
            }
            if (this.gxV != null) {
                this.gxT.addAll(this.gxV);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Jr = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.fip.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
            this.deq = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.gxW = new Date(optLong);
            } else {
                this.gxW = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.gxX = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.gxR.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.gxS.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.gxY = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.gxU.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.gxV.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Jr = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.deq == 1;
    }

    public void setHasMore(boolean z) {
        this.deq = z ? 1 : 0;
    }
}
