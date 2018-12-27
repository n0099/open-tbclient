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
    private int ddD;
    private int gwS = 0;
    private int gwT = 0;
    private ArrayList<ForumData> gwL = new ArrayList<>();
    private ArrayList<ForumData> gwM = new ArrayList<>();
    private ArrayList<ForumData> gwN = new ArrayList<>();
    private ArrayList<ForumData> gwO = new ArrayList<>();
    private ArrayList<ForumData> gwQ = new ArrayList<>();
    private ArrayList<ForumData> gwP = new ArrayList<>();
    private al fhz = new al();
    private Date gwR = null;
    private boolean Jr = true;

    public a() {
        setHasMore(false);
    }

    public int bpT() {
        return this.gwS;
    }

    public void tl(int i) {
        this.gwS = i;
    }

    public void tm(int i) {
        this.gwS += i;
    }

    public int bpU() {
        return this.gwT;
    }

    public void tn(int i) {
        this.gwT = i;
    }

    public void to(int i) {
        this.gwT += i;
    }

    public ArrayList<ForumData> bpV() {
        return this.gwM;
    }

    public ArrayList<ForumData> bpW() {
        return this.gwN;
    }

    public ArrayList<ForumData> bpX() {
        return this.gwP;
    }

    public ArrayList<ForumData> bpY() {
        return this.gwQ;
    }

    public ArrayList<ForumData> bpZ() {
        return this.gwL;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gwL == null) {
            this.gwL = new ArrayList<>();
        }
        if (this.gwM != null && arrayList != null) {
            this.gwM.clear();
            this.gwM.addAll(arrayList);
        }
        if (this.gwN != null && arrayList2 != null) {
            this.gwN.clear();
            this.gwN.addAll(arrayList2);
        }
        if (this.gwM != null || this.gwN != null) {
            this.gwL.clear();
            if (this.gwM != null) {
                this.gwL.addAll(this.gwM);
            }
            if (this.gwN != null) {
                this.gwL.addAll(this.gwN);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gwL == null) {
            this.gwL = new ArrayList<>();
        }
        if (this.gwM != null && arrayList != null) {
            this.gwM.addAll(arrayList);
        }
        if (this.gwN != null && arrayList2 != null) {
            this.gwN.addAll(arrayList2);
        }
        if (this.gwM != null || this.gwN != null) {
            this.gwL.clear();
            if (this.gwM != null) {
                this.gwL.addAll(this.gwM);
            }
            if (this.gwN != null) {
                this.gwL.addAll(this.gwN);
            }
        }
    }

    public ArrayList<ForumData> bqa() {
        return this.gwO;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gwO == null) {
            this.gwO = new ArrayList<>();
        }
        if (this.gwP != null && arrayList != null) {
            this.gwP.addAll(arrayList);
        }
        if (this.gwQ != null && arrayList2 != null) {
            this.gwQ.addAll(arrayList2);
        }
        if (this.gwP != null || this.gwQ != null) {
            this.gwO.clear();
            if (this.gwP != null) {
                this.gwO.addAll(this.gwP);
            }
            if (this.gwQ != null) {
                this.gwO.addAll(this.gwQ);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gwO == null) {
            this.gwO = new ArrayList<>();
        }
        if (this.gwP != null && arrayList != null) {
            this.gwP.clear();
            this.gwP.addAll(arrayList);
        }
        if (this.gwQ != null && arrayList2 != null) {
            this.gwQ.clear();
            this.gwQ.addAll(arrayList2);
        }
        if (this.gwP != null || this.gwQ != null) {
            this.gwO.clear();
            if (this.gwP != null) {
                this.gwO.addAll(this.gwP);
            }
            if (this.gwQ != null) {
                this.gwO.addAll(this.gwQ);
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
            this.fhz.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
            this.ddD = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.gwR = new Date(optLong);
            } else {
                this.gwR = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.gwS = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.gwM.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.gwN.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.gwT = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.gwP.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.gwQ.add(forumData4);
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
        return this.ddD == 1;
    }

    public void setHasMore(boolean z) {
        this.ddD = z ? 1 : 0;
    }
}
