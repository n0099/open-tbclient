package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.mvc.b.j;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements j {
    private int bFn = 0;
    private List<a> bFo = null;

    @Override // com.baidu.tbadk.mvc.b.j
    public void c(JSONObject jSONObject) {
        this.bFn = jSONObject.optInt("num");
        JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
        if (optJSONArray != null) {
            this.bFo = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.c(optJSONObject);
                    this.bFo.add(aVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
    }

    public int ZH() {
        return this.bFn;
    }

    public List<a> ZI() {
        return this.bFo;
    }
}
