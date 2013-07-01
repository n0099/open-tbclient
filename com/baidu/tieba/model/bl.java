package com.baidu.tieba.model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bl extends com.baidu.tieba.data.b {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f1041a = new ArrayList();
    private com.baidu.tieba.data.ai b = new com.baidu.tieba.data.ai();

    public ArrayList a() {
        return this.f1041a;
    }

    public com.baidu.tieba.data.ai b() {
        return this.b;
    }

    @Override // com.baidu.tieba.data.b
    public void parserJson(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("thread_list");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                com.baidu.tieba.data.al alVar = new com.baidu.tieba.data.al();
                alVar.parserJson(optJSONArray.optJSONObject(i));
                this.f1041a.add(alVar);
            }
        }
        this.b.a(jSONObject.optJSONObject("page"));
    }
}
