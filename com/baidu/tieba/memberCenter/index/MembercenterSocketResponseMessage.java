package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.cache.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.c.a;
import com.baidu.tieba.memberCenter.index.a.m;
import com.squareup.wire.Wire;
import tbclient.GetVipInfo.GetVipInfoResIdl;
/* loaded from: classes8.dex */
public class MembercenterSocketResponseMessage extends SocketResponsedMessage {
    private m mMembercenter;

    public MembercenterSocketResponseMessage() {
        super(CmdConfigSocket.CMD_MEMBERCENTER_INDEX);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
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
                l<byte[]> dK = a.bpZ().dK("tb_member_center", str);
                if (dK != null && bArr != null) {
                    dK.setForever("member_center_cache_key", bArr);
                }
            }
        }
    }

    public m getMembercenterData() {
        return this.mMembercenter;
    }
}
