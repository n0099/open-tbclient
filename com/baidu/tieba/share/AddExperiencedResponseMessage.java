package com.baidu.tieba.share;

import com.baidu.mobstat.Config;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.pb.data.ContriInfo;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AddExperiencedResponseMessage extends JsonHttpResponsedMessage {
    private ContriInfo mContriInfo;

    public AddExperiencedResponseMessage(int i) {
        super(1003332);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(Config.LAUNCH_INFO)) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("contri_info");
            this.mContriInfo = new ContriInfo();
            this.mContriInfo.parseJson(optJSONObject2);
        }
    }

    public ContriInfo getContriInfo() {
        return this.mContriInfo;
    }

    public void setContriInfo(ContriInfo contriInfo) {
        this.mContriInfo = contriInfo;
    }
}
