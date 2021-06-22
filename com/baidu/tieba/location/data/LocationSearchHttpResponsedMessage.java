package com.baidu.tieba.location.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import d.a.o0.o1.c.a;
import tbclient.GetSuggestionByAddrName.GetSuggestionByAddrNameResIdl;
/* loaded from: classes3.dex */
public class LocationSearchHttpResponsedMessage extends HttpResponsedMessage {
    public a mLocationData;

    public LocationSearchHttpResponsedMessage(int i2) {
        super(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME);
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void setLocationData(a aVar) {
        this.mLocationData = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetSuggestionByAddrNameResIdl getSuggestionByAddrNameResIdl = (GetSuggestionByAddrNameResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSuggestionByAddrNameResIdl.class);
        setError(getSuggestionByAddrNameResIdl.error.errorno.intValue());
        setErrorString(getSuggestionByAddrNameResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        a aVar = new a();
        this.mLocationData = aVar;
        aVar.b(getSuggestionByAddrNameResIdl.data);
        BdLog.detailException(null);
    }
}
