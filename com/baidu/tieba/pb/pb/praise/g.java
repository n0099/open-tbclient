package com.baidu.tieba.pb.pb.praise;

import com.baidu.tbadk.mvc.b.k;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements k {
    private int bMT = 0;
    private List<a> bMU = null;

    @Override // com.baidu.tbadk.mvc.b.k
    public void c(JSONObject jSONObject) {
        this.bMT = jSONObject.optInt("num");
        JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
        if (optJSONArray != null) {
            this.bMU = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.c(optJSONObject);
                    this.bMU.add(aVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.k
    public void a(Message message) {
    }

    public int abK() {
        return this.bMT;
    }

    public List<a> abL() {
        return this.bMU;
    }
}
