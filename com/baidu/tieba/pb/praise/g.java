package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements j {
    private int bFm = 0;
    private List<a> bFn = null;

    @Override // com.baidu.tbadk.mvc.b.j
    public void c(JSONObject jSONObject) {
        this.bFm = jSONObject.optInt("num");
        JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
        if (optJSONArray != null) {
            this.bFn = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.c(optJSONObject);
                    this.bFn.add(aVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public int ZC() {
        return this.bFm;
    }

    public List<a> ZD() {
        return this.bFn;
    }
}
