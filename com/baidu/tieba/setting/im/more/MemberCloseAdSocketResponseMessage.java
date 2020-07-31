package com.baidu.tieba.setting.im.more;

import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import tbclient.CloseAd.CloseAdResIdl;
/* loaded from: classes20.dex */
public class MemberCloseAdSocketResponseMessage extends TbSocketReponsedMessage {
    private CloseAdData mData;

    public MemberCloseAdSocketResponseMessage(int i) {
        super(i);
    }

    public CloseAdData getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
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
}
