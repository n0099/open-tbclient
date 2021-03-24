package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.i0.y2.c;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class GetForumResponsed extends JsonHttpResponsedMessage {
    public c listData;

    public GetForumResponsed(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
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
