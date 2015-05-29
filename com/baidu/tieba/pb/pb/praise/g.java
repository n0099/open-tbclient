package com.baidu.tieba.pb.pb.praise;

import com.baidu.tbadk.mvc.b.k;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements k {
    private int bPh = 0;
    private List<a> bPi = null;

    @Override // com.baidu.tbadk.mvc.b.k
    public void c(JSONObject jSONObject) {
        this.bPh = jSONObject.optInt("num");
        JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
        if (optJSONArray != null) {
            this.bPi = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.c(optJSONObject);
                    this.bPi.add(aVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void a(Message message) {
    }

    public int acR() {
        return this.bPh;
    }

    public List<a> acS() {
        return this.bPi;
    }
}
