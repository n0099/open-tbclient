package com.baidu.tieba.myAttentionAndFans.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes3.dex */
public class ResponseFollowListSwitchMsg extends JsonHttpResponsedMessage {
    public ResponseFollowListSwitchMsg() {
        super(CmdConfigHttp.CMD_FOLLOW_SWITCH);
    }
}
