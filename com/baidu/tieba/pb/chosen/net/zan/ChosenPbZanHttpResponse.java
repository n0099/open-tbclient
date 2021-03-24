package com.baidu.tieba.pb.chosen.net.zan;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.ExcZan.ExcZanResIdl;
/* loaded from: classes4.dex */
public class ChosenPbZanHttpResponse extends HttpResponsedMessage {
    public ChosenPbZanHttpResponse(int i) {
        super(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Error error;
        ExcZanResIdl excZanResIdl = (ExcZanResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcZanResIdl.class);
        if (excZanResIdl == null || (error = excZanResIdl.error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(excZanResIdl.error.usermsg);
    }
}
