package com.baidu.tieba.newfaceshop.facemake;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class UploadFaceGroupResponseMessage extends JsonHttpResponsedMessage {
    public String mGroupId;

    public UploadFaceGroupResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mGroupId = jSONObject.optString("package_id");
        }
    }

    public String getGroupId() {
        return this.mGroupId;
    }
}
