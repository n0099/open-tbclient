package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.t;
import tbclient.HistorySwan.DataReq;
import tbclient.HistorySwan.HistorySwanReqIdl;
/* loaded from: classes11.dex */
public class SmartAppBrowseHistoryRequestMessage extends NetMessage {
    public SmartAppBrowseHistoryRequestMessage() {
        super(CmdConfigHttp.CMD_HISTORY_SWAN, 309638);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        if (z) {
            t.a(builder, true);
        }
        HistorySwanReqIdl.Builder builder2 = new HistorySwanReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
