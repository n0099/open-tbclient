package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.c.a;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.memberCenter.index.a.m;
import com.squareup.wire.Wire;
import tbclient.GetVipInfo.GetVipInfoResIdl;
/* loaded from: classes9.dex */
public class MembercenterHttpResponseMessage extends TbHttpResponsedMessage {
    private m mMembercenter;

    public MembercenterHttpResponseMessage() {
        super(1003048);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        String str;
        GetVipInfoResIdl getVipInfoResIdl = (GetVipInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetVipInfoResIdl.class);
        if (getVipInfoResIdl != null) {
            if (getVipInfoResIdl.error != null) {
                setError(getVipInfoResIdl.error.errorno.intValue());
                setErrorString(getVipInfoResIdl.error.usermsg);
            }
            if (getVipInfoResIdl.data != null) {
                this.mMembercenter = new m(getVipInfoResIdl.data);
            }
            if (getError() == 0) {
                if (TbadkCoreApplication.isLogin()) {
                    str = TbadkCoreApplication.getCurrentAccount();
                } else {
                    str = "temp";
                }
                l<byte[]> dE = a.bqr().dE("tb_member_center", str);
                if (dE != null && bArr != null) {
                    dE.setForever("member_center_cache_key", bArr);
                }
            }
        }
    }

    public m getMembercenterData() {
        return this.mMembercenter;
    }
}
