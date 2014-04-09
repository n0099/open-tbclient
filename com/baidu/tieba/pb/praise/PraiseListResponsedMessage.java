package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PraiseListResponsedMessage extends JsonHttpResponsedMessage {
    private int a;
    private String b;
    private int c;
    private List<a> d;

    public PraiseListResponsedMessage(int i) {
        super(i);
        this.a = 0;
        this.b = "";
        this.c = 0;
        this.d = null;
    }

    public final String i() {
        return this.b;
    }

    public final int j() {
        return this.c;
    }

    public final List<a> k() {
        return this.d;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public final void a(JSONObject jSONObject) {
        int d = d();
        int e = e();
        if (d == 200 && e == 0) {
            this.a = jSONObject.optInt("error_code");
            this.b = jSONObject.optString("error_msg");
            this.c = jSONObject.optInt("num");
            JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
            if (optJSONArray != null) {
                this.d = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < optJSONArray.length()) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                        this.d.add(new a(jSONObject2.optString("id"), jSONObject2.optString("name"), jSONObject2.optString("portrait"), jSONObject2.optString("name_show"), jSONObject2.optLong("zan_time") * 1000));
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
