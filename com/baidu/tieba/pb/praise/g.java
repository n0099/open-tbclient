package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements j {
    private int bDC = 0;
    private List<a> bDD = null;

    @Override // com.baidu.tbadk.mvc.b.j
    public void c(JSONObject jSONObject) {
        this.bDC = jSONObject.optInt("num");
        JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
        if (optJSONArray != null) {
            this.bDD = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.c(optJSONObject);
                    this.bDD.add(aVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public int Zc() {
        return this.bDC;
    }

    public List<a> Zd() {
        return this.bDD;
    }
}
