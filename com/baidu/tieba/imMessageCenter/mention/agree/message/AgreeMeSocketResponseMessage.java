package com.baidu.tieba.imMessageCenter.mention.agree.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.squareup.wire.Wire;
import d.a.j0.f1.b.p.a;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
import tbclient.AgreeMe.DataRes;
import tbclient.Error;
/* loaded from: classes4.dex */
public class AgreeMeSocketResponseMessage extends SocketResponsedMessage {
    public ArrayList<a> datas;
    public boolean hasMore;

    public AgreeMeSocketResponseMessage() {
        super(309593);
        this.datas = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        if (!hasError() && (getOrginalMessage().getExtra() instanceof AgreeMeRequestMessage) && ((AgreeMeRequestMessage) getOrginalMessage().getExtra()).id == 0) {
            d.a.i0.r.r.a.f().e("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName()).a("agree_me_cache_key", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        DataRes dataRes;
        String str;
        Integer num;
        AgreeMeResIdl agreeMeResIdl = (AgreeMeResIdl) new Wire(new Class[0]).parseFrom(bArr, AgreeMeResIdl.class);
        if (agreeMeResIdl == null) {
            return;
        }
        Error error = agreeMeResIdl.error;
        if (error != null && (num = error.errorno) != null) {
            setError(num.intValue());
        }
        Error error2 = agreeMeResIdl.error;
        if (error2 != null && (str = error2.usermsg) != null && str.length() > 0) {
            setErrorString(agreeMeResIdl.error.usermsg);
        }
        if (getError() == 0 && (dataRes = agreeMeResIdl.data) != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            for (AgreeList agreeList : agreeMeResIdl.data.agree_list) {
                if (agreeList != null) {
                    a aVar = new a();
                    aVar.G(agreeList);
                    this.datas.add(aVar);
                }
            }
        }
    }
}
