package com.baidu.tieba.pb.pb.praise;

import com.baidu.tbadk.mvc.b.k;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements k {
    private int bPi = 0;
    private List<a> bPj = null;

    @Override // com.baidu.tbadk.mvc.b.k
    public void c(JSONObject jSONObject) {
        this.bPi = jSONObject.optInt("num");
        JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
        if (optJSONArray != null) {
            this.bPj = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.c(optJSONObject);
                    this.bPj.add(aVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void a(Message message) {
    }

    public int acS() {
        return this.bPi;
    }

    public List<a> acT() {
        return this.bPj;
    }
}
