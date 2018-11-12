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
    private int cUc;
    private int gnl = 0;
    private int gnm = 0;
    private ArrayList<ForumData> gne = new ArrayList<>();
    private ArrayList<ForumData> gnf = new ArrayList<>();
    private ArrayList<ForumData> gng = new ArrayList<>();
    private ArrayList<ForumData> gnh = new ArrayList<>();
    private ArrayList<ForumData> gnj = new ArrayList<>();
    private ArrayList<ForumData> gni = new ArrayList<>();
    private al eXT = new al();
    private Date gnk = null;
    private boolean Jr = true;

    public a() {
        setHasMore(false);
    }

    public int bnp() {
        return this.gnl;
    }

    public void sE(int i) {
        this.gnl = i;
    }

    public void sF(int i) {
        this.gnl += i;
    }

    public int bnq() {
        return this.gnm;
    }

    public void sG(int i) {
        this.gnm = i;
    }

    public void sH(int i) {
        this.gnm += i;
    }

    public ArrayList<ForumData> bnr() {
        return this.gnf;
    }

    public ArrayList<ForumData> bns() {
        return this.gng;
    }

    public ArrayList<ForumData> bnt() {
        return this.gni;
    }

    public ArrayList<ForumData> bnu() {
        return this.gnj;
    }

    public ArrayList<ForumData> bnv() {
        return this.gne;
    }

    public void b(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gne == null) {
            this.gne = new ArrayList<>();
        }
        if (this.gnf != null && arrayList != null) {
            this.gnf.clear();
            this.gnf.addAll(arrayList);
        }
        if (this.gng != null && arrayList2 != null) {
            this.gng.clear();
            this.gng.addAll(arrayList2);
        }
        if (this.gnf != null || this.gng != null) {
            this.gne.clear();
            if (this.gnf != null) {
                this.gne.addAll(this.gnf);
            }
            if (this.gng != null) {
                this.gne.addAll(this.gng);
            }
        }
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gne == null) {
            this.gne = new ArrayList<>();
        }
        if (this.gnf != null && arrayList != null) {
            this.gnf.addAll(arrayList);
        }
        if (this.gng != null && arrayList2 != null) {
            this.gng.addAll(arrayList2);
        }
        if (this.gnf != null || this.gng != null) {
            this.gne.clear();
            if (this.gnf != null) {
                this.gne.addAll(this.gnf);
            }
            if (this.gng != null) {
                this.gne.addAll(this.gng);
            }
        }
    }

    public ArrayList<ForumData> bnw() {
        return this.gnh;
    }

    public void d(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gnh == null) {
            this.gnh = new ArrayList<>();
        }
        if (this.gni != null && arrayList != null) {
            this.gni.addAll(arrayList);
        }
        if (this.gnj != null && arrayList2 != null) {
            this.gnj.addAll(arrayList2);
        }
        if (this.gni != null || this.gnj != null) {
            this.gnh.clear();
            if (this.gni != null) {
                this.gnh.addAll(this.gni);
            }
            if (this.gnj != null) {
                this.gnh.addAll(this.gnj);
            }
        }
    }

    public void e(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.gnh == null) {
            this.gnh = new ArrayList<>();
        }
        if (this.gni != null && arrayList != null) {
            this.gni.clear();
            this.gni.addAll(arrayList);
        }
        if (this.gnj != null && arrayList2 != null) {
            this.gnj.clear();
            this.gnj.addAll(arrayList2);
        }
        if (this.gni != null || this.gnj != null) {
            this.gnh.clear();
            if (this.gni != null) {
                this.gnh.addAll(this.gni);
            }
            if (this.gnj != null) {
                this.gnh.addAll(this.gnj);
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
            this.eXT.parserJson(jSONObject.optJSONObject(SystemScreenshotManager.PAGE));
            this.cUc = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.gnk = new Date(optLong);
            } else {
                this.gnk = new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.gnl = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.gnf.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.gng.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.gnm = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.gni.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.gnj.add(forumData4);
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
        return this.cUc == 1;
    }

    public void setHasMore(boolean z) {
        this.cUc = z ? 1 : 0;
    }
}
