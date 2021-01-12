package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.CloseAd.CloseAdResIdl;
/* loaded from: classes7.dex */
public class MemberCloseAdHttpResponseMessage extends TbHttpResponsedMessage {
    private CloseAdData mData;

    public MemberCloseAdHttpResponseMessage(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        if (bArr != null) {
            CloseAdResIdl closeAdResIdl = (CloseAdResIdl) new Wire(new Class[0]).parseFrom(bArr, CloseAdResIdl.class);
            if (closeAdResIdl.error != null) {
                setError(closeAdResIdl.error.errorno.intValue());
                setErrorString(closeAdResIdl.error.usermsg);
                if (getError() == 0 && closeAdResIdl.data != null) {
                    this.mData = new CloseAdData();
                    this.mData.a(closeAdResIdl.data.vip_close_ad);
                }
            }
        }
    }

    public CloseAdData getData() {
        return this.mData;
    }
}
