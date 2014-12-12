package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.squareup.wire.Wire;
import tbclient.GetSuggestionByAddrName.GetSuggestionByAddrNameResIdl;
/* loaded from: classes.dex */
public class LocationSearchResponseMessage extends SocketResponsedMessage {
    private k mLocationData;

    public LocationSearchResponseMessage() {
        super(303018);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetSuggestionByAddrNameResIdl getSuggestionByAddrNameResIdl = (GetSuggestionByAddrNameResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSuggestionByAddrNameResIdl.class);
        setError(getSuggestionByAddrNameResIdl.error.errorno.intValue());
        setErrorString(getSuggestionByAddrNameResIdl.error.usermsg);
        if (getError() == 0) {
            this.mLocationData = new k();
            this.mLocationData.a(getSuggestionByAddrNameResIdl.data);
            BdLog.detailException(null);
        }
    }

    public k getLocationData() {
        return this.mLocationData;
    }

    public void setLocationData(k kVar) {
        this.mLocationData = kVar;
    }
}
