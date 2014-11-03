package com.baidu.tieba.pb.praise;

import com.baidu.tbadk.mvc.b.i;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements i {
    private int bzK = 0;
    private List<a> bzL = null;

    @Override // com.baidu.tbadk.mvc.b.i
    public void d(JSONObject jSONObject) {
        this.bzK = jSONObject.optInt("num");
        JSONArray optJSONArray = jSONObject.optJSONArray("user_list");
        if (optJSONArray != null) {
            this.bzL = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    a aVar = new a();
                    aVar.d(optJSONObject);
                    this.bzL.add(aVar);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.mvc.b.i
    public void a(Message message) {
    }

    public int YE() {
        return this.bzK;
    }

    public List<a> YF() {
        return this.bzL;
    }
}
