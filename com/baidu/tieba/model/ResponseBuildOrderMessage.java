package com.baidu.tieba.model;

import com.baidu.tbadk.core.atomData.EcommOrderDetailActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseBuildOrderMessage extends JsonHttpResponsedMessage {
    private long openId;
    private String orderId;

    public ResponseBuildOrderMessage(int i) {
        super(i);
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public long getOpenId() {
        return this.openId;
    }

    public void setOpenId(long j) {
        this.openId = j;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (getStatusCode() == 200 && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.orderId = optJSONObject.optString(EcommOrderDetailActivityConfig.ORDER_ID);
            this.openId = optJSONObject.optLong("open_id");
        }
    }
}
