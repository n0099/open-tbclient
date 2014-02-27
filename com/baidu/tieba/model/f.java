package com.baidu.tieba.model;

import com.baidu.tieba.data.ForumData;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f {
    private ArrayList<ForumData> a = new ArrayList<>();
    private com.baidu.tieba.data.al b = new com.baidu.tieba.data.al();
    private Date c = null;
    private boolean d = true;

    public final ArrayList<ForumData> a() {
        return this.a;
    }

    public final void a(ArrayList<ForumData> arrayList) {
        this.a = arrayList;
    }

    public final void a(String str) {
        if (str != null) {
            try {
                a(new JSONObject(str));
            } catch (Exception e) {
                this.d = false;
                com.baidu.adp.lib.util.e.b("BarlistModel", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ForumData forumData = new ForumData();
                    forumData.parserJson(optJSONArray.getJSONObject(i));
                    this.a.add(forumData);
                }
            }
            this.b.a(jSONObject.optJSONObject("page"));
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                this.c = new Date(optLong);
            } else {
                this.c = new Date();
            }
        } catch (Exception e) {
            this.d = false;
            com.baidu.adp.lib.util.e.b("BarlistModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
