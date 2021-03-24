package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.squareup.wire.Wire;
import d.b.b.e.d.l;
import d.b.h0.r.r.a;
import d.b.i0.q1.c.b.m;
import tbclient.Error;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.GetVipInfoResIdl;
/* loaded from: classes3.dex */
public class MembercenterSocketResponseMessage extends SocketResponsedMessage {
    public m mMembercenter;

    public MembercenterSocketResponseMessage() {
        super(309062);
    }

    public m getMembercenterData() {
        return this.mMembercenter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetVipInfoResIdl getVipInfoResIdl = (GetVipInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetVipInfoResIdl.class);
        if (getVipInfoResIdl == null) {
            return;
        }
        Error error = getVipInfoResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getVipInfoResIdl.error.usermsg);
        }
        DataRes dataRes = getVipInfoResIdl.data;
        if (dataRes != null) {
            this.mMembercenter = new m(dataRes);
        }
        if (getError() == 0) {
            l<byte[]> e2 = a.f().e("tb_member_center", TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAccount() : SevenZipUtils.FILE_NAME_TEMP);
            if (e2 == null || bArr == null) {
                return;
            }
            e2.g("member_center_cache_key", bArr);
        }
    }
}
