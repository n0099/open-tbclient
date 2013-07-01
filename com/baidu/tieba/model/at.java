package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class at {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1025a = new ArrayList();

    public ArrayList a() {
        return this.f1025a;
    }

    public void a(ArrayList arrayList) {
        this.f1025a = arrayList;
    }

    public void a(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1025a.size()) {
                if (((au) this.f1025a.get(i2)).a() == 1 && ((au) this.f1025a.get(i2)).d().equals(str)) {
                    ((au) this.f1025a.get(i2)).a(true);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void b(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("NearbyForumListModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        au auVar = null;
        try {
            int size = this.f1025a.size();
            if (size > 0) {
                auVar = (au) this.f1025a.get(size - 1);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("forum_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i = 0;
                au auVar2 = auVar;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    au auVar3 = new au(this);
                    auVar3.c = optJSONObject.optString("fname");
                    auVar3.b = optJSONObject.optString("distance");
                    auVar3.d = optJSONObject.optString("fid");
                    auVar3.e = optJSONObject.optInt("heat", 0);
                    auVar3.g = optJSONObject.optInt("member_count", 0);
                    auVar3.h = optJSONObject.optInt("post_num", 0);
                    auVar3.f = optJSONObject.optInt("is_like", 0) == 1;
                    auVar3.f1026a = 1;
                    if (auVar2 != null && auVar3.b.equals(auVar2.b)) {
                        this.f1025a.add(auVar3);
                    } else {
                        au auVar4 = new au(this);
                        auVar4.b = auVar3.b;
                        auVar4.f1026a = 0;
                        this.f1025a.add(auVar4);
                        this.f1025a.add(auVar3);
                    }
                    i++;
                    auVar2 = auVar3;
                }
            }
        } catch (Exception e) {
            com.baidu.tieba.util.z.b("NearbyForumListModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
