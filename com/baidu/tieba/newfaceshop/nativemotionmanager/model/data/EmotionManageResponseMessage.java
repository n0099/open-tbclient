package com.baidu.tieba.newfaceshop.nativemotionmanager.model.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class EmotionManageResponseMessage extends JsonHttpResponsedMessage {
    public EmotionManageData data;

    public EmotionManageResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.data = (EmotionManageData) OrmObject.objectWithJson(jSONObject, EmotionManageData.class);
        }
    }
}
