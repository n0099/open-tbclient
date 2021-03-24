package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.CloseAd.CloseAdResIdl;
import tbclient.Error;
/* loaded from: classes5.dex */
public class MemberCloseAdHttpResponseMessage extends TbHttpResponsedMessage {
    public CloseAdData mData;

    public MemberCloseAdHttpResponseMessage(int i) {
        super(i);
    }

    public CloseAdData getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        CloseAdResIdl closeAdResIdl;
        Error error;
        super.decodeInBackGround(i, bArr);
        if (bArr == null || (error = (closeAdResIdl = (CloseAdResIdl) new Wire(new Class[0]).parseFrom(bArr, CloseAdResIdl.class)).error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(closeAdResIdl.error.usermsg);
        if (getError() == 0 && closeAdResIdl.data != null) {
            CloseAdData closeAdData = new CloseAdData();
            this.mData = closeAdData;
            closeAdData.u(closeAdResIdl.data.vip_close_ad);
        }
    }
}
