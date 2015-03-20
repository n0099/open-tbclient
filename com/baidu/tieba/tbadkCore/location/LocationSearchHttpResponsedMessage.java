package com.baidu.tieba.tbadkCore.location;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.squareup.wire.Wire;
import tbclient.GetSuggestionByAddrName.GetSuggestionByAddrNameResIdl;
/* loaded from: classes.dex */
public class LocationSearchHttpResponsedMessage extends HttpResponsedMessage {
    private l mLocationData;

    public LocationSearchHttpResponsedMessage(int i) {
        super(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME);
    }

    public l getLocationData() {
        return this.mLocationData;
    }

    public void setLocationData(l lVar) {
        this.mLocationData = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.b
    public void decodeInBackGround(int i, byte[] bArr) {
        GetSuggestionByAddrNameResIdl getSuggestionByAddrNameResIdl = (GetSuggestionByAddrNameResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSuggestionByAddrNameResIdl.class);
        setError(getSuggestionByAddrNameResIdl.error.errorno.intValue());
        setErrorString(getSuggestionByAddrNameResIdl.error.usermsg);
        if (getError() == 0) {
            this.mLocationData = new l();
            this.mLocationData.a(getSuggestionByAddrNameResIdl.data);
            BdLog.detailException(null);
        }
    }
}
