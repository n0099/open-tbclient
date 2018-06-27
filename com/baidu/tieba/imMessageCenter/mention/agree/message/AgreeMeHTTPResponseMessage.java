package com.baidu.tieba.imMessageCenter.mention.agree.message;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.imMessageCenter.mention.base.a;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import tbclient.AgreeList;
import tbclient.AgreeMe.AgreeMeResIdl;
/* loaded from: classes2.dex */
public class AgreeMeHTTPResponseMessage extends TbHttpResponsedMessage {
    public ArrayList<a> datas;
    public boolean hasMore;

    public AgreeMeHTTPResponseMessage() {
        super(CmdConfigHttp.AGREE_ME_HTTP_CMD);
        this.datas = new ArrayList<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AgreeMeResIdl agreeMeResIdl = (AgreeMeResIdl) new Wire(new Class[0]).parseFrom(bArr, AgreeMeResIdl.class);
        if (agreeMeResIdl != null) {
            if (agreeMeResIdl.error != null && agreeMeResIdl.error.errorno != null) {
                setError(agreeMeResIdl.error.errorno.intValue());
            }
            if (agreeMeResIdl.error != null && agreeMeResIdl.error.usermsg != null && agreeMeResIdl.error.usermsg.length() > 0) {
                setErrorString(agreeMeResIdl.error.usermsg);
            }
            if (getError() == 0 && agreeMeResIdl.data != null) {
                this.hasMore = agreeMeResIdl.data.has_more.intValue() == 1;
                for (AgreeList agreeList : agreeMeResIdl.data.agree_list) {
                    if (agreeList != null) {
                        a aVar = new a();
                        aVar.a(agreeList);
                        this.datas.add(aVar);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        if (!hasError() && (getOrginalMessage().getExtra() instanceof AgreeMeRequestMessage) && ((AgreeMeRequestMessage) getOrginalMessage().getExtra()).id == 0) {
            com.baidu.tbadk.core.c.a.xj().Q("tb_user_agreeme", TbadkCoreApplication.getCurrentAccountName()).f("agree_me_cache_key", bArr);
        }
    }
}
