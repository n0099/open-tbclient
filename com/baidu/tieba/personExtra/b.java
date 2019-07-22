package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.an;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    private int eIF;
    private int imy = 0;
    private int imz = 0;
    private ArrayList<ForumData> imr = new ArrayList<>();
    private ArrayList<ForumData> ims = new ArrayList<>();
    private ArrayList<ForumData> imt = new ArrayList<>();
    private ArrayList<ForumData> imu = new ArrayList<>();
    private ArrayList<ForumData> imw = new ArrayList<>();
    private ArrayList<ForumData> imv = new ArrayList<>();
    private an page = new an();
    private Date imx = null;
    private boolean Hs = true;

    public b() {
        setHasMore(false);
    }

    public int cbL() {
        return this.imy;
    }

    public void yG(int i) {
        this.imy = i;
    }

    public void yH(int i) {
        this.imy += i;
    }

    public int cbM() {
        return this.imz;
    }

    public void yI(int i) {
        this.imz = i;
    }

    public void yJ(int i) {
        this.imz += i;
    }

    public ArrayList<ForumData> cbN() {
        return this.ims;
    }

    public ArrayList<ForumData> cbO() {
        return this.imt;
    }

    public ArrayList<ForumData> cbP() {
        return this.imv;
    }

    public ArrayList<ForumData> cbQ() {
        return this.imw;
    }

    public ArrayList<ForumData> cbR() {
        return this.imr;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.imr == null) {
            this.imr = new ArrayList<>();
        }
        if (this.ims != null && arrayList != null) {
            this.ims.clear();
            this.ims.addAll(arrayList);
        }
        if (this.imt != null && arrayList2 != null) {
            this.imt.clear();
            this.imt.addAll(arrayList2);
        }
        if (this.ims != null || this.imt != null) {
            this.imr.clear();
            if (this.ims != null) {
                this.imr.addAll(this.ims);
            }
            if (this.imt != null) {
                this.imr.addAll(this.imt);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.imr == null) {
            this.imr = new ArrayList<>();
        }
        if (this.ims != null && arrayList != null) {
            this.ims.addAll(arrayList);
        }
        if (this.imt != null && arrayList2 != null) {
            this.imt.addAll(arrayList2);
        }
        if (this.ims != null || this.imt != null) {
            this.imr.clear();
            if (this.ims != null) {
                this.imr.addAll(this.ims);
            }
            if (this.imt != null) {
                this.imr.addAll(this.imt);
            }
        }
    }

    public ArrayList<ForumData> cbS() {
        return this.imu;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.imu == null) {
            this.imu = new ArrayList<>();
        }
        if (this.imv != null && arrayList != null) {
            this.imv.addAll(arrayList);
        }
        if (this.imw != null && arrayList2 != null) {
            this.imw.addAll(arrayList2);
        }
        if (this.imv != null || this.imw != null) {
            this.imu.clear();
            if (this.imv != null) {
                this.imu.addAll(this.imv);
            }
            if (this.imw != null) {
                this.imu.addAll(this.imw);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.imu == null) {
            this.imu = new ArrayList<>();
        }
        if (this.imv != null && arrayList != null) {
            this.imv.clear();
            this.imv.addAll(arrayList);
        }
        if (this.imw != null && arrayList2 != null) {
            this.imw.clear();
            this.imw.addAll(arrayList2);
        }
        if (this.imv != null || this.imw != null) {
            this.imu.clear();
            if (this.imv != null) {
                this.imu.addAll(this.imv);
            }
            if (this.imw != null) {
                this.imu.addAll(this.imw);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Hs = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.page.parserJson(jSONObject.optJSONObject("page"));
            this.eIF = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.imx = new Date(optLong);
            } else {
                this.imx = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.imy = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.ims.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.imt.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.imz = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.imv.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.imw.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Hs = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.eIF == 1;
    }

    public void setHasMore(boolean z) {
        this.eIF = z ? 1 : 0;
    }
}
