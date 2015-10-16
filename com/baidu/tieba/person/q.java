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
    private int coX = 0;
    private int coY = 0;
    private ArrayList<ForumData> coQ = new ArrayList<>();
    private ArrayList<ForumData> coR = new ArrayList<>();
    private ArrayList<ForumData> coS = new ArrayList<>();
    private ArrayList<ForumData> coT = new ArrayList<>();
    private ArrayList<ForumData> coV = new ArrayList<>();
    private ArrayList<ForumData> coU = new ArrayList<>();
    private com.baidu.tbadk.core.data.o caH = new com.baidu.tbadk.core.data.o();
    private Date coW = null;
    private boolean Cj = true;

    public q() {
        setHasMore(false);
    }

    public int aik() {
        return this.coX;
    }

    public void ja(int i) {
        this.coX = i;
    }

    public void jb(int i) {
        this.coX += i;
    }

    public int ail() {
        return this.coY;
    }

    public void jc(int i) {
        this.coY = i;
    }

    public void jd(int i) {
        this.coY += i;
    }

    public ArrayList<ForumData> aim() {
        return this.coR;
    }

    public ArrayList<ForumData> ain() {
        return this.coS;
    }

    public ArrayList<ForumData> aio() {
        return this.coU;
    }

    public ArrayList<ForumData> aip() {
        return this.coV;
    }

    public ArrayList<ForumData> aiq() {
        return this.coQ;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.coQ == null) {
            this.coQ = new ArrayList<>();
        }
        if (this.coR != null && arrayList != null) {
            this.coR.clear();
            this.coR.addAll(arrayList);
        }
        if (this.coS != null && arrayList2 != null) {
            this.coS.clear();
            this.coS.addAll(arrayList2);
        }
        if (this.coR != null || this.coS != null) {
            this.coQ.clear();
            if (this.coR != null) {
                this.coQ.addAll(this.coR);
            }
            if (this.coS != null) {
                this.coQ.addAll(this.coS);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.coQ == null) {
            this.coQ = new ArrayList<>();
        }
        if (this.coR != null && arrayList != null) {
            this.coR.addAll(arrayList);
        }
        if (this.coS != null && arrayList2 != null) {
            this.coS.addAll(arrayList2);
        }
        if (this.coR != null || this.coS != null) {
            this.coQ.clear();
            if (this.coR != null) {
                this.coQ.addAll(this.coR);
            }
            if (this.coS != null) {
                this.coQ.addAll(this.coS);
            }
        }
    }

    public ArrayList<ForumData> air() {
        return this.coT;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.coT == null) {
            this.coT = new ArrayList<>();
        }
        if (this.coU != null && arrayList != null) {
            this.coU.addAll(arrayList);
        }
        if (this.coV != null && arrayList2 != null) {
            this.coV.addAll(arrayList2);
        }
        if (this.coU != null || this.coV != null) {
            this.coT.clear();
            if (this.coU != null) {
                this.coT.addAll(this.coU);
            }
            if (this.coV != null) {
                this.coT.addAll(this.coV);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.coT == null) {
            this.coT = new ArrayList<>();
        }
        if (this.coU != null && arrayList != null) {
            this.coU.clear();
            this.coU.addAll(arrayList);
        }
        if (this.coV != null && arrayList2 != null) {
            this.coV.clear();
            this.coV.addAll(arrayList2);
        }
        if (this.coU != null || this.coV != null) {
            this.coT.clear();
            if (this.coU != null) {
                this.coT.addAll(this.coU);
            }
            if (this.coV != null) {
                this.coT.addAll(this.coV);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Cj = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.caH.parserJson(jSONObject.optJSONObject("page"));
            this.hasMore = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.coW = new Date(optLong);
            } else {
                this.coW = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.coX = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.coR.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.coS.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.coY = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.coU.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.coV.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Cj = false;
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
