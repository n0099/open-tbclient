package com.baidu.tieba.signall;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetForumResponsed extends JsonHttpResponsedMessage {
    public c listData;

    public GetForumResponsed(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        if (getError() == 0 && jSONObject != null) {
            this.listData = new c();
            try {
                this.listData.parserJson(jSONObject);
            } catch (Exception e) {
                this.listData = null;
                BdLog.e(e.getMessage());
            }
        }
    }
}
