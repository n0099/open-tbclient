package com.baidu.tieba.pb.data;

import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.b.i0.c2.b;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PbFloorAgreeResponseMessage extends JsonHttpResponsedMessage {
    public CustomDialogData mActDialogData;
    public ContriInfo mContriInfo;
    public int mScore;
    public AuthTokenData tokenData;

    public PbFloorAgreeResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode != 200 || error < 0 || jSONObject == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("agree");
        if (optJSONObject2 != null) {
            this.mScore = optJSONObject2.optInt("score");
        }
        this.mActDialogData = b.a(optJSONObject);
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("contri_info");
        ContriInfo contriInfo = new ContriInfo();
        this.mContriInfo = contriInfo;
        contriInfo.parseJson(optJSONObject3);
        this.tokenData = AuthTokenData.parse(jSONObject);
    }

    public CustomDialogData getActivityDialogData() {
        return this.mActDialogData;
    }

    public ContriInfo getContriInfo() {
        return this.mContriInfo;
    }

    public int getScore() {
        return this.mScore;
    }

    public AuthTokenData getTokenData() {
        return this.tokenData;
    }

    public void setContriInfo(ContriInfo contriInfo) {
        this.mContriInfo = contriInfo;
    }
}
