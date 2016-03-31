package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.PushThread.PushThreadResIdl;
/* loaded from: classes.dex */
public class PbPushHttpResponseMessage extends TbHttpResponsedMessage {
    private int mPushType;

    public PbPushHttpResponseMessage(int i) {
        super(i);
    }

    public int getPushType() {
        return this.mPushType;
    }

    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        PushThreadResIdl pushThreadResIdl = (PushThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, PushThreadResIdl.class);
        if (pushThreadResIdl.error != null) {
            setError(pushThreadResIdl.error.errorno.intValue());
            setErrorString(pushThreadResIdl.error.errmsg);
        }
        if (pushThreadResIdl.data != null) {
            this.mPushType = pushThreadResIdl.data.push_type.intValue();
        }
    }
}
