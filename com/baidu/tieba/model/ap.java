package com.baidu.tieba.model;

import com.baidu.android.pushservice.PushConstants;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ap {
    private com.baidu.tieba.data.af c = new com.baidu.tieba.data.af();
    private ArrayList a = new ArrayList();
    private com.baidu.tieba.data.ai b = new com.baidu.tieba.data.ai();
    private boolean d = true;

    public boolean a() {
        return this.d;
    }

    public void a(ArrayList arrayList) {
        this.a = arrayList;
    }

    public ArrayList b() {
        return this.a;
    }

    public com.baidu.tieba.data.ai c() {
        return this.b;
    }

    public void a(String str) {
        try {
            a(new JSONObject(str));
        } catch (Exception e) {
            this.d = false;
            com.baidu.tieba.util.z.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("reply_list");
            JSONArray optJSONArray2 = optJSONArray == null ? jSONObject.optJSONArray("at_list") : optJSONArray;
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    com.baidu.tieba.data.q qVar = new com.baidu.tieba.data.q();
                    qVar.a(optJSONArray2.optJSONObject(i));
                    this.a.add(qVar);
                }
            }
            this.c.a(jSONObject.optJSONObject(PushConstants.EXTRA_PUSH_MESSAGE));
            this.b.a(jSONObject.optJSONObject("page"));
        } catch (Exception e) {
            this.d = false;
            com.baidu.tieba.util.z.b("MentionModel", "parserJson", "error = " + e.getMessage());
        }
    }
}
