package com.baidu.tieba.imMessageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes2.dex */
public class RequestNewFriendDataMessage extends CustomMessage<Long> {
    public RequestNewFriendDataMessage(long j) {
        super((int) CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID, Long.valueOf(j));
    }
}
