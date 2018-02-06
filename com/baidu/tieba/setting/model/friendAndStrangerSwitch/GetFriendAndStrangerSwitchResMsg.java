package com.baidu.tieba.setting.model.friendAndStrangerSwitch;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetFriendAndStrangerSwitchResMsg extends JsonHttpResponsedMessage {
    public static final int INVALID_TYPE = -1;
    public int mMaskType;

    public GetFriendAndStrangerSwitchResMsg() {
        super(CmdConfigHttp.CMD_GET_FRIEND_AND_STRANGER_MSG_SWITCH);
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
