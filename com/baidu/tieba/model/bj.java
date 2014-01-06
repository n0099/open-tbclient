package com.baidu.tieba.model;

import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bj {
    private com.baidu.tieba.data.ak c = new com.baidu.tieba.data.ak();
    private ArrayList<com.baidu.tieba.data.u> a = new ArrayList<>();
    private com.baidu.tieba.data.an b = new com.baidu.tieba.data.an();
    private boolean d = true;

    public boolean a() {
        return this.d;
    }

    public void a(ArrayList<com.baidu.tieba.data.u> arrayList) {
        this.a = arrayList;
    }

    public ArrayList<com.baidu.tieba.data.u> b() {
        return this.a;
    }

    public com.baidu.tieba.data.an c() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            com.baidu.tieba.util.bo.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    com.baidu.tieba.data.u uVar = new com.baidu.tieba.data.u();
                    uVar.a(optJSONArray2.optJSONObject(i));
                    this.a.add(uVar);
                }
            }
            this.c.a(jSONObject.optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE));
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            this.d = false;
            com.baidu.tieba.util.bo.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
