package com.baidu.tieba.newfaceshop.message;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class BazhuInfoResponseMessage extends JsonHttpResponsedMessage {
    public BazhuInfoData data;

    public BazhuInfoResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.data = (BazhuInfoData) OrmObject.objectWithJson(jSONObject.optJSONObject("data"), BazhuInfoData.class);
        }
    }
}
