package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.am;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    private int cEr;
    private int fSB = 0;
    private int fSC = 0;
    private ArrayList<ForumData> fSu = new ArrayList<>();
    private ArrayList<ForumData> fSv = new ArrayList<>();
    private ArrayList<ForumData> fSw = new ArrayList<>();
    private ArrayList<ForumData> fSx = new ArrayList<>();
    private ArrayList<ForumData> fSz = new ArrayList<>();
    private ArrayList<ForumData> fSy = new ArrayList<>();
    private am ezX = new am();
    private Date fSA = null;
    private boolean Gp = true;

    public a() {
        setHasMore(false);
    }

    public int bjm() {
        return this.fSB;
    }

    public void rl(int i) {
        this.fSB = i;
    }

    public void rm(int i) {
        this.fSB += i;
    }

    public int bjn() {
        return this.fSC;
    }

    public void rn(int i) {
        this.fSC = i;
    }

    public void ro(int i) {
        this.fSC += i;
    }

    public ArrayList<ForumData> bjo() {
        return this.fSv;
    }

    public ArrayList<ForumData> bjp() {
        return this.fSw;
    }

    public ArrayList<ForumData> bjq() {
        return this.fSy;
    }

    public ArrayList<ForumData> bjr() {
        return this.fSz;
    }

    public ArrayList<ForumData> bjs() {
        return this.fSu;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fSu == null) {
            this.fSu = new ArrayList<>();
        }
        if (this.fSv != null && arrayList != null) {
            this.fSv.clear();
            this.fSv.addAll(arrayList);
        }
        if (this.fSw != null && arrayList2 != null) {
            this.fSw.clear();
            this.fSw.addAll(arrayList2);
        }
        if (this.fSv != null || this.fSw != null) {
            this.fSu.clear();
            if (this.fSv != null) {
                this.fSu.addAll(this.fSv);
            }
            if (this.fSw != null) {
                this.fSu.addAll(this.fSw);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fSu == null) {
            this.fSu = new ArrayList<>();
        }
        if (this.fSv != null && arrayList != null) {
            this.fSv.addAll(arrayList);
        }
        if (this.fSw != null && arrayList2 != null) {
            this.fSw.addAll(arrayList2);
        }
        if (this.fSv != null || this.fSw != null) {
            this.fSu.clear();
            if (this.fSv != null) {
                this.fSu.addAll(this.fSv);
            }
            if (this.fSw != null) {
                this.fSu.addAll(this.fSw);
            }
        }
    }

    public ArrayList<ForumData> bjt() {
        return this.fSx;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fSx == null) {
            this.fSx = new ArrayList<>();
        }
        if (this.fSy != null && arrayList != null) {
            this.fSy.addAll(arrayList);
        }
        if (this.fSz != null && arrayList2 != null) {
            this.fSz.addAll(arrayList2);
        }
        if (this.fSy != null || this.fSz != null) {
            this.fSx.clear();
            if (this.fSy != null) {
                this.fSx.addAll(this.fSy);
            }
            if (this.fSz != null) {
                this.fSx.addAll(this.fSz);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.fSx == null) {
            this.fSx = new ArrayList<>();
        }
        if (this.fSy != null && arrayList != null) {
            this.fSy.clear();
            this.fSy.addAll(arrayList);
        }
        if (this.fSz != null && arrayList2 != null) {
            this.fSz.clear();
            this.fSz.addAll(arrayList2);
        }
        if (this.fSy != null || this.fSz != null) {
            this.fSx.clear();
            if (this.fSy != null) {
                this.fSx.addAll(this.fSy);
            }
            if (this.fSz != null) {
                this.fSx.addAll(this.fSz);
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
            this.ezX.parserJson(jSONObject.optJSONObject(WBPageConstants.ParamKey.PAGE));
            this.cEr = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.fSA = new Date(optLong);
            } else {
                this.fSA = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.fSB = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.fSv.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.fSw.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.fSC = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.fSy.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.fSz.add(forumData4);
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
        return this.cEr == 1;
    }

    public void setHasMore(boolean z) {
        this.cEr = z ? 1 : 0;
    }
}
