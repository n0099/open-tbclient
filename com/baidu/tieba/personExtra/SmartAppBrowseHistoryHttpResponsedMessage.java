package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import d.b.i0.g2.a;
import tbclient.Error;
import tbclient.HistorySwan.HistorySwanResIdl;
/* loaded from: classes5.dex */
public class SmartAppBrowseHistoryHttpResponsedMessage extends HttpResponsedMessage {
    public a mData;

    public SmartAppBrowseHistoryHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_HISTORY_SWAN);
    }

    public a getData() {
        return this.mData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        HistorySwanResIdl historySwanResIdl = (HistorySwanResIdl) new Wire(new Class[0]).parseFrom(bArr, HistorySwanResIdl.class);
        if (historySwanResIdl == null) {
            return;
        }
        Error error = historySwanResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(historySwanResIdl.error.usermsg);
        }
        if (historySwanResIdl.data != null) {
            a aVar = new a();
            this.mData = aVar;
            aVar.b(historySwanResIdl.data);
        }
    }
}
