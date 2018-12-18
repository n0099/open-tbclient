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
    private int daL;
    private int gub = 0;
    private int guc = 0;
    private ArrayList<ForumData> gtU = new ArrayList<>();
    private ArrayList<ForumData> gtV = new ArrayList<>();
    private ArrayList<ForumData> gtW = new ArrayList<>();
    private ArrayList<ForumData> gtX = new ArrayList<>();
    private ArrayList<ForumData> gtZ = new ArrayList<>();
    private ArrayList<ForumData> gtY = new ArrayList<>();
    private al feI = new al();
    private Date gua = null;
    private boolean Jr = true;

    public a() {
        setHasMore(false);
    }

    public int bph() {
        return this.gub;
    }

    public void sY(int i) {
        this.gub = i;
    }

    public void sZ(int i) {
        this.gub += i;
    }

    public int bpi() {
        return this.guc;
    }

    public void ta(int i) {
        this.guc = i;
    }

    public void tb(int i) {
        this.guc += i;
    }

    public ArrayList<ForumData> bpj() {
        return this.gtV;
    }

    public ArrayList<ForumData> bpk() {
        return this.gtW;
    }

    public ArrayList<ForumData> bpl() {
        return this.gtY;
    }

    public ArrayList<ForumData> bpm() {
        return this.gtZ;
    }

    public ArrayList<ForumData> bpn() {
        return this.gtU;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gtU == null) {
            this.gtU = new ArrayList<>();
        }
        if (this.gtV != null && arrayList != null) {
            this.gtV.clear();
            this.gtV.addAll(arrayList);
        }
        if (this.gtW != null && arrayList2 != null) {
            this.gtW.clear();
            this.gtW.addAll(arrayList2);
        }
        if (this.gtV != null || this.gtW != null) {
            this.gtU.clear();
            if (this.gtV != null) {
                this.gtU.addAll(this.gtV);
            }
            if (this.gtW != null) {
                this.gtU.addAll(this.gtW);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gtU == null) {
            this.gtU = new ArrayList<>();
        }
        if (this.gtV != null && arrayList != null) {
            this.gtV.addAll(arrayList);
        }
        if (this.gtW != null && arrayList2 != null) {
            this.gtW.addAll(arrayList2);
        }
        if (this.gtV != null || this.gtW != null) {
            this.gtU.clear();
            if (this.gtV != null) {
                this.gtU.addAll(this.gtV);
            }
            if (this.gtW != null) {
                this.gtU.addAll(this.gtW);
            }
        }
    }

    public ArrayList<ForumData> bpo() {
        return this.gtX;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gtX == null) {
            this.gtX = new ArrayList<>();
        }
        if (this.gtY != null && arrayList != null) {
            this.gtY.addAll(arrayList);
        }
        if (this.gtZ != null && arrayList2 != null) {
            this.gtZ.addAll(arrayList2);
        }
        if (this.gtY != null || this.gtZ != null) {
            this.gtX.clear();
            if (this.gtY != null) {
                this.gtX.addAll(this.gtY);
            }
            if (this.gtZ != null) {
                this.gtX.addAll(this.gtZ);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gtX == null) {
            this.gtX = new ArrayList<>();
        }
        if (this.gtY != null && arrayList != null) {
            this.gtY.clear();
            this.gtY.addAll(arrayList);
        }
        if (this.gtZ != null && arrayList2 != null) {
            this.gtZ.clear();
            this.gtZ.addAll(arrayList2);
        }
        if (this.gtY != null || this.gtZ != null) {
            this.gtX.clear();
            if (this.gtY != null) {
                this.gtX.addAll(this.gtY);
            }
            if (this.gtZ != null) {
                this.gtX.addAll(this.gtZ);
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
            this.feI.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
            this.daL = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.gua = new Date(optLong);
            } else {
                this.gua = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.gub = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.gtV.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.gtW.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.guc = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.gtY.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.gtZ.add(forumData4);
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
        return this.daL == 1;
    }

    public void setHasMore(boolean z) {
        this.daL = z ? 1 : 0;
    }
}
