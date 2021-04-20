package com.baidu.tieba.pbextra;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.PushThread.DataRes;
import tbclient.PushThread.PushThreadResIdl;
/* loaded from: classes3.dex */
public class PbPushHttpResponseMessage extends TbHttpResponsedMessage {
    public int mPushType;

    public PbPushHttpResponseMessage(int i) {
        super(i);
    }

    public int getPushType() {
        return this.mPushType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PushThreadResIdl pushThreadResIdl = (PushThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, PushThreadResIdl.class);
        Error error = pushThreadResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(pushThreadResIdl.error.errmsg);
        }
        DataRes dataRes = pushThreadResIdl.data;
        if (dataRes == null) {
            return;
        }
        this.mPushType = dataRes.push_type.intValue();
    }
}
