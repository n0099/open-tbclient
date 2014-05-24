package com.baidu.tieba.model;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int e = 0;
    private ArrayList<ForumData> a = new ArrayList<>();
    private com.baidu.tbadk.core.data.l b = new com.baidu.tbadk.core.data.l();
    private Date c = null;
    private boolean d = true;

    public int a() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public ArrayList<ForumData> b() {
        return this.a;
    }

    public void a(ArrayList<ForumData> arrayList) {
        this.a = arrayList;
    }

    public void a(String str) {
        if (str != null) {
            try {
                a(new JSONObject(str));
            } catch (Exception e) {
                this.d = false;
                BdLog.e("BarlistModel", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
                if (optJSONArray != null) {
                    this.e = optJSONArray.length();
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
                this.b.a(jSONObject.optJSONObject("page"));
                long optLong = jSONObject.optLong("ctime", 0L);
                if (optLong > 0) {
                    this.c = new Date(optLong);
                } else {
                    this.c = new Date();
                }
            }
        } catch (Exception e) {
            this.d = false;
            BdLog.e("BarlistModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
