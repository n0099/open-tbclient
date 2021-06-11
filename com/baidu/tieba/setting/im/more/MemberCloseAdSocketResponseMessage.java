package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.CloseAd.CloseAdResIdl;
import tbclient.Error;
/* loaded from: classes5.dex */
public class MemberCloseAdSocketResponseMessage extends TbSocketReponsedMessage {
    public CloseAdData mData;

    public MemberCloseAdSocketResponseMessage(int i2) {
        super(i2);
    }

    public CloseAdData getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        CloseAdResIdl closeAdResIdl;
        Error error;
        if (bArr == null || (error = (closeAdResIdl = (CloseAdResIdl) new Wire(new Class[0]).parseFrom(bArr, CloseAdResIdl.class)).error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(closeAdResIdl.error.usermsg);
        if (getError() == 0 && closeAdResIdl.data != null) {
            CloseAdData closeAdData = new CloseAdData();
            this.mData = closeAdData;
            closeAdData.y(closeAdResIdl.data.vip_close_ad);
        }
    }
}
