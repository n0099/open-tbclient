package com.baidu.tieba.pb.data;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PbEcommRecommendResponsedHttpMessage extends JsonHttpResponsedMessage {
    public j mData;

    public PbEcommRecommendResponsedHttpMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("recommend_info");
            if (jSONObject != null) {
                this.mData = new j();
                this.mData.recommendations = optJSONObject.optLong("recommendations");
                this.mData.add = optJSONObject.optInt("add");
                this.mData.eks = optJSONObject.optInt("reduce");
            }
        }
    }
}
