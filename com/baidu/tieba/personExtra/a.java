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
    private int dep;
    private int gxW = 0;
    private int gxX = 0;
    private ArrayList<ForumData> gxP = new ArrayList<>();
    private ArrayList<ForumData> gxQ = new ArrayList<>();
    private ArrayList<ForumData> gxR = new ArrayList<>();
    private ArrayList<ForumData> gxS = new ArrayList<>();
    private ArrayList<ForumData> gxU = new ArrayList<>();
    private ArrayList<ForumData> gxT = new ArrayList<>();
    private al fio = new al();
    private Date gxV = null;
    private boolean Jr = true;

    public a() {
        setHasMore(false);
    }

    public int bqC() {
        return this.gxW;
    }

    public void tp(int i) {
        this.gxW = i;
    }

    public void tq(int i) {
        this.gxW += i;
    }

    public int bqD() {
        return this.gxX;
    }

    public void tr(int i) {
        this.gxX = i;
    }

    public void ts(int i) {
        this.gxX += i;
    }

    public ArrayList<ForumData> bqE() {
        return this.gxQ;
    }

    public ArrayList<ForumData> bqF() {
        return this.gxR;
    }

    public ArrayList<ForumData> bqG() {
        return this.gxT;
    }

    public ArrayList<ForumData> bqH() {
        return this.gxU;
    }

    public ArrayList<ForumData> bqI() {
        return this.gxP;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gxP == null) {
            this.gxP = new ArrayList<>();
        }
        if (this.gxQ != null && arrayList != null) {
            this.gxQ.clear();
            this.gxQ.addAll(arrayList);
        }
        if (this.gxR != null && arrayList2 != null) {
            this.gxR.clear();
            this.gxR.addAll(arrayList2);
        }
        if (this.gxQ != null || this.gxR != null) {
            this.gxP.clear();
            if (this.gxQ != null) {
                this.gxP.addAll(this.gxQ);
            }
            if (this.gxR != null) {
                this.gxP.addAll(this.gxR);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gxP == null) {
            this.gxP = new ArrayList<>();
        }
        if (this.gxQ != null && arrayList != null) {
            this.gxQ.addAll(arrayList);
        }
        if (this.gxR != null && arrayList2 != null) {
            this.gxR.addAll(arrayList2);
        }
        if (this.gxQ != null || this.gxR != null) {
            this.gxP.clear();
            if (this.gxQ != null) {
                this.gxP.addAll(this.gxQ);
            }
            if (this.gxR != null) {
                this.gxP.addAll(this.gxR);
            }
        }
    }

    public ArrayList<ForumData> bqJ() {
        return this.gxS;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gxS == null) {
            this.gxS = new ArrayList<>();
        }
        if (this.gxT != null && arrayList != null) {
            this.gxT.addAll(arrayList);
        }
        if (this.gxU != null && arrayList2 != null) {
            this.gxU.addAll(arrayList2);
        }
        if (this.gxT != null || this.gxU != null) {
            this.gxS.clear();
            if (this.gxT != null) {
                this.gxS.addAll(this.gxT);
            }
            if (this.gxU != null) {
                this.gxS.addAll(this.gxU);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gxS == null) {
            this.gxS = new ArrayList<>();
        }
        if (this.gxT != null && arrayList != null) {
            this.gxT.clear();
            this.gxT.addAll(arrayList);
        }
        if (this.gxU != null && arrayList2 != null) {
            this.gxU.clear();
            this.gxU.addAll(arrayList2);
        }
        if (this.gxT != null || this.gxU != null) {
            this.gxS.clear();
            if (this.gxT != null) {
                this.gxS.addAll(this.gxT);
            }
            if (this.gxU != null) {
                this.gxS.addAll(this.gxU);
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
            this.fio.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
            this.dep = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.gxV = new Date(optLong);
            } else {
                this.gxV = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.gxW = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.gxQ.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.gxR.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.gxX = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.gxT.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.gxU.add(forumData4);
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
        return this.dep == 1;
    }

    public void setHasMore(boolean z) {
        this.dep = z ? 1 : 0;
    }
}
