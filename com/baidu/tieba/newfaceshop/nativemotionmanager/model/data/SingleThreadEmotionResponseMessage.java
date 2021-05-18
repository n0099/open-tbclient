package com.baidu.tieba.newfaceshop.nativemotionmanager.model.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SingleThreadEmotionResponseMessage extends JsonHttpResponsedMessage {
    public SingleThreadEmotionData data;

    public SingleThreadEmotionResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.data = (SingleThreadEmotionData) OrmObject.objectWithJson(jSONObject, SingleThreadEmotionData.class);
        }
    }
}
