package com.baidu.tieba.pb.data;

import com.baidu.ar.gesture.GestureAR;
import com.baidu.tbadk.coreExtra.data.AuthTokenData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PbFloorAgreeResponseMessage extends JsonHttpResponsedMessage {
    private CustomDialogData mActDialogData;
    private ContriInfo mContriInfo;
    private int mScore;
    private AuthTokenData tokenData;

    public PbFloorAgreeResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("agree");
            if (optJSONObject2 != null) {
                this.mScore = optJSONObject2.optInt(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE);
            }
            this.mActDialogData = com.baidu.tieba.pb.b.eG(optJSONObject);
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("contri_info");
            this.mContriInfo = new ContriInfo();
            this.mContriInfo.parseJson(optJSONObject3);
            this.tokenData = AuthTokenData.parse(jSONObject);
        }
    }

    public int getScore() {
        return this.mScore;
    }

    public CustomDialogData getActivityDialogData() {
        return this.mActDialogData;
    }

    public ContriInfo getContriInfo() {
        return this.mContriInfo;
    }

    public void setContriInfo(ContriInfo contriInfo) {
        this.mContriInfo = contriInfo;
    }

    public AuthTokenData getTokenData() {
        return this.tokenData;
    }
}
