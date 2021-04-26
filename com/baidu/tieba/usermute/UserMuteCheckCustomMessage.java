package com.baidu.tieba.usermute;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes5.dex */
public class UserMuteCheckCustomMessage extends CustomMessage {
    public BdUniqueId mId;
    public long userIdF;
    public long userIdT;

    public UserMuteCheckCustomMessage(int i2) {
        super(i2);
    }
}
