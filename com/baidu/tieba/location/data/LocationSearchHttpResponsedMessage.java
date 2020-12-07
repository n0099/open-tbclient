package com.baidu.tieba.location.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.GetSuggestionByAddrName.GetSuggestionByAddrNameResIdl;
/* loaded from: classes23.dex */
public class LocationSearchHttpResponsedMessage extends HttpResponsedMessage {
    private a mLocationData;

    public LocationSearchHttpResponsedMessage(int i) {
        super(1003002);
    }

    public a getLocationData() {
        return this.mLocationData;
    }

    public void setLocationData(a aVar) {
        this.mLocationData = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetSuggestionByAddrNameResIdl getSuggestionByAddrNameResIdl = (GetSuggestionByAddrNameResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSuggestionByAddrNameResIdl.class);
        setError(getSuggestionByAddrNameResIdl.error.errorno.intValue());
        setErrorString(getSuggestionByAddrNameResIdl.error.usermsg);
        if (getError() == 0) {
            this.mLocationData = new a();
            this.mLocationData.a(getSuggestionByAddrNameResIdl.data);
            BdLog.detailException(null);
        }
    }
}
