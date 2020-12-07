package com.baidu.tieba.setting.model.friendAndStrangerSwitch;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes26.dex */
public class GetFriendAndStrangerSwitchResMsg extends JsonHttpResponsedMessage {
    public static final int INVALID_TYPE = -1;
    public int mMaskType;

    public GetFriendAndStrangerSwitchResMsg() {
        super(1003319);
        this.mMaskType = -1;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        try {
            this.mMaskType = jSONObject.getInt("data");
        } catch (Exception e) {
            BdLog.e(e);
        }
    }
}
