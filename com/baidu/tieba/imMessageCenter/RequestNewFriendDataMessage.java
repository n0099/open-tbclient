package com.baidu.tieba.imMessageCenter;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes3.dex */
public class RequestNewFriendDataMessage extends CustomMessage<Long> {
    public RequestNewFriendDataMessage(long j) {
        super(2001305, Long.valueOf(j));
    }
}
