package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class r {
    private int TD;
    private int dsa = 0;
    private int dsb = 0;
    private ArrayList<ForumData> drT = new ArrayList<>();
    private ArrayList<ForumData> drU = new ArrayList<>();
    private ArrayList<ForumData> drV = new ArrayList<>();
    private ArrayList<ForumData> drW = new ArrayList<>();
    private ArrayList<ForumData> drY = new ArrayList<>();
    private ArrayList<ForumData> drX = new ArrayList<>();
    private com.baidu.tbadk.core.data.ac cxM = new com.baidu.tbadk.core.data.ac();
    private Date drZ = null;
    private boolean CK = true;

    public r() {
        setHasMore(false);
    }

    public int aAX() {
        return this.dsa;
    }

    public void mu(int i) {
        this.dsa = i;
    }

    public void mv(int i) {
        this.dsa += i;
    }

    public int aAY() {
        return this.dsb;
    }

    public void mw(int i) {
        this.dsb = i;
    }

    public void mx(int i) {
        this.dsb += i;
    }

    public ArrayList<ForumData> aAZ() {
        return this.drU;
    }

    public ArrayList<ForumData> aBa() {
        return this.drV;
    }

    public ArrayList<ForumData> aBb() {
        return this.drX;
    }

    public ArrayList<ForumData> aBc() {
        return this.drY;
    }

    public ArrayList<ForumData> aBd() {
        return this.drT;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.drT == null) {
            this.drT = new ArrayList<>();
        }
        if (this.drU != null && arrayList != null) {
            this.drU.clear();
            this.drU.addAll(arrayList);
        }
        if (this.drV != null && arrayList2 != null) {
            this.drV.clear();
            this.drV.addAll(arrayList2);
        }
        if (this.drU != null || this.drV != null) {
            this.drT.clear();
            if (this.drU != null) {
                this.drT.addAll(this.drU);
            }
            if (this.drV != null) {
                this.drT.addAll(this.drV);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.drT == null) {
            this.drT = new ArrayList<>();
        }
        if (this.drU != null && arrayList != null) {
            this.drU.addAll(arrayList);
        }
        if (this.drV != null && arrayList2 != null) {
            this.drV.addAll(arrayList2);
        }
        if (this.drU != null || this.drV != null) {
            this.drT.clear();
            if (this.drU != null) {
                this.drT.addAll(this.drU);
            }
            if (this.drV != null) {
                this.drT.addAll(this.drV);
            }
        }
    }

    public ArrayList<ForumData> aBe() {
        return this.drW;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.drW == null) {
            this.drW = new ArrayList<>();
        }
        if (this.drX != null && arrayList != null) {
            this.drX.addAll(arrayList);
        }
        if (this.drY != null && arrayList2 != null) {
            this.drY.addAll(arrayList2);
        }
        if (this.drX != null || this.drY != null) {
            this.drW.clear();
            if (this.drX != null) {
                this.drW.addAll(this.drX);
            }
            if (this.drY != null) {
                this.drW.addAll(this.drY);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.drW == null) {
            this.drW = new ArrayList<>();
        }
        if (this.drX != null && arrayList != null) {
            this.drX.clear();
            this.drX.addAll(arrayList);
        }
        if (this.drY != null && arrayList2 != null) {
            this.drY.clear();
            this.drY.addAll(arrayList2);
        }
        if (this.drX != null || this.drY != null) {
            this.drW.clear();
            if (this.drX != null) {
                this.drW.addAll(this.drX);
            }
            if (this.drY != null) {
                this.drW.addAll(this.drY);
            }
        }
    }

    public void parserJson(String str) {
        if (str != null) {
            try {
                parserJson(new JSONObject(str));
            } catch (Exception e) {
                this.CK = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void parserJson(JSONObject jSONObject) {
        try {
            this.cxM.parserJson(jSONObject.optJSONObject("page"));
            this.TD = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.drZ = new Date(optLong);
            } else {
                this.drZ = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.dsa = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.drU.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.drV.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.dsb = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.drX.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.drY.add(forumData4);
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.CK = false;
            BdLog.e(e.getMessage());
        }
    }

    public boolean isHasMore() {
        return this.TD == 1;
    }

    public void setHasMore(boolean z) {
        this.TD = z ? 1 : 0;
    }
}
