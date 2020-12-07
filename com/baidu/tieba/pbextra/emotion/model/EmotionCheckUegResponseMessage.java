package com.baidu.tieba.pbextra.emotion.model;

import android.text.TextUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class EmotionCheckUegResponseMessage extends JsonHttpResponsedMessage {
    private String msg;
    private String status;
    public static String STATUS_OK = "1";
    public static String STATUS_FAIL = "2";

    public EmotionCheckUegResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            String optString = jSONObject.optString("data");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                this.status = jSONObject2.optString("status");
                this.msg = jSONObject2.optString("words");
            }
        }
    }

    public String getStatus() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }
}
