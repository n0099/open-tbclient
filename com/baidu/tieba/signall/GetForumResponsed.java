package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.k0.z2.c;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetForumResponsed extends JsonHttpResponsedMessage {
    public c listData;

    public GetForumResponsed(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) {
        if (getError() != 0 || jSONObject == null) {
            return;
        }
        c cVar = new c();
        this.listData = cVar;
        try {
            cVar.F(jSONObject);
        } catch (Exception e2) {
            this.listData = null;
            BdLog.e(e2.getMessage());
        }
    }
}
