package com.baidu.tieba.personExtra;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.an;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private int eon;
    private int hNV = 0;
    private int hNW = 0;
    private ArrayList<ForumData> hNO = new ArrayList<>();
    private ArrayList<ForumData> hNP = new ArrayList<>();
    private ArrayList<ForumData> hNQ = new ArrayList<>();
    private ArrayList<ForumData> hNR = new ArrayList<>();
    private ArrayList<ForumData> hNT = new ArrayList<>();
    private ArrayList<ForumData> hNS = new ArrayList<>();
    private an page = new an();
    private Date hNU = null;
    private boolean Jy = true;

    public a() {
        setHasMore(false);
    }

    public int bQZ() {
        return this.hNV;
    }

    public void wZ(int i) {
        this.hNV = i;
    }

    public void xa(int i) {
        this.hNV += i;
    }

    public int bRa() {
        return this.hNW;
    }

    public void xb(int i) {
        this.hNW = i;
    }

    public void xc(int i) {
        this.hNW += i;
    }

    public ArrayList<ForumData> bRb() {
        return this.hNP;
    }

    public ArrayList<ForumData> bRc() {
        return this.hNQ;
    }

    public ArrayList<ForumData> bRd() {
        return this.hNS;
    }

    public ArrayList<ForumData> bRe() {
        return this.hNT;
    }

    public ArrayList<ForumData> bRf() {
        return this.hNO;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.hNO == null) {
            this.hNO = new ArrayList<>();
        }
        if (this.hNP != null && arrayList != null) {
            this.hNP.clear();
            this.hNP.addAll(arrayList);
        }
        if (this.hNQ != null && arrayList2 != null) {
            this.hNQ.clear();
            this.hNQ.addAll(arrayList2);
        }
        if (this.hNP != null || this.hNQ != null) {
            this.hNO.clear();
            if (this.hNP != null) {
                this.hNO.addAll(this.hNP);
            }
            if (this.hNQ != null) {
                this.hNO.addAll(this.hNQ);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.hNO == null) {
            this.hNO = new ArrayList<>();
        }
        if (this.hNP != null && arrayList != null) {
            this.hNP.addAll(arrayList);
        }
        if (this.hNQ != null && arrayList2 != null) {
            this.hNQ.addAll(arrayList2);
        }
        if (this.hNP != null || this.hNQ != null) {
            this.hNO.clear();
            if (this.hNP != null) {
                this.hNO.addAll(this.hNP);
            }
            if (this.hNQ != null) {
                this.hNO.addAll(this.hNQ);
            }
        }
    }

    public ArrayList<ForumData> bRg() {
        return this.hNR;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.hNR == null) {
            this.hNR = new ArrayList<>();
        }
        if (this.hNS != null && arrayList != null) {
            this.hNS.addAll(arrayList);
        }
        if (this.hNT != null && arrayList2 != null) {
            this.hNT.addAll(arrayList2);
        }
        if (this.hNS != null || this.hNT != null) {
            this.hNR.clear();
            if (this.hNS != null) {
                this.hNR.addAll(this.hNS);
            }
            if (this.hNT != null) {
                this.hNR.addAll(this.hNT);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.hNR == null) {
            this.hNR = new ArrayList<>();
        }
        if (this.hNS != null && arrayList != null) {
            this.hNS.clear();
            this.hNS.addAll(arrayList);
        }
        if (this.hNT != null && arrayList2 != null) {
            this.hNT.clear();
            this.hNT.addAll(arrayList2);
        }
        if (this.hNS != null || this.hNT != null) {
            this.hNR.clear();
            if (this.hNS != null) {
                this.hNR.addAll(this.hNS);
            }
            if (this.hNT != null) {
                this.hNR.addAll(this.hNT);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.Jy = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.page.parserJson(jSONObject.optJSONObject("page"));
            this.eon = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.hNU = new Date(optLong);
            } else {
                this.hNU = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.hNV = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.hNP.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.hNQ.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.hNW = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.hNS.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.hNT.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.Jy = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.eon == 1;
    }

    public void setHasMore(boolean z) {
        this.eon = z ? 1 : 0;
    }
}
