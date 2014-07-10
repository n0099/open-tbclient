package com.baidu.tieba.person;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class t {
    private int f = 0;
    private ArrayList<ForumData> a = new ArrayList<>();
    private ArrayList<ForumData> b = new ArrayList<>();
    private com.baidu.tbadk.core.data.k c = new com.baidu.tbadk.core.data.k();
    private Date d = null;
    private boolean e = true;

    public int a() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public ArrayList<ForumData> b() {
        return this.a;
    }

    public void a(ArrayList<ForumData> arrayList) {
        this.a = arrayList;
    }

    public ArrayList<ForumData> c() {
        return this.b;
    }

    public void b(ArrayList<ForumData> arrayList) {
        this.b = arrayList;
    }

    public void a(String str) {
        if (str != null) {
            try {
                a(new JSONObject(str));
            } catch (Exception e) {
                this.e = false;
                BdLog.e(e.getMessage());
            }
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.f = optJSONArray.length();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        ForumData forumData = new ForumData();
                        forumData.parserJson(optJSONArray.getJSONObject(i));
                        this.a.add(forumData);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        ForumData forumData2 = new ForumData();
                        forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                        this.a.add(forumData2);
                    }
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
                if (optJSONObject2 != null) {
                    JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
                    if (optJSONArray3 != null) {
                        this.f = optJSONArray3.length();
                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                            ForumData forumData3 = new ForumData();
                            forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                            this.b.add(forumData3);
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
                    if (optJSONArray4 != null) {
                        for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                            ForumData forumData4 = new ForumData();
                            forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                            this.b.add(forumData4);
                        }
                    }
                    this.c.a(jSONObject.optJSONObject("page"));
                    long optLong = jSONObject.optLong("ctime", 0L);
                    if (optLong > 0) {
                        this.d = new Date(optLong);
                    } else {
                        this.d = new Date();
                    }
                }
            }
        } catch (Exception e) {
            this.e = false;
            BdLog.e(e.getMessage());
        }
    }
}
