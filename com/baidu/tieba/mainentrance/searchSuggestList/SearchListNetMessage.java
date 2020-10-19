package com.baidu.tieba.mainentrance.searchSuggestList;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.util.u;
import tbclient.SearchSug.DataReq;
import tbclient.SearchSug.SearchSugReqIdl;
/* loaded from: classes24.dex */
public class SearchListNetMessage extends NetMessage {
    public Integer isForum;
    public String mKey;

    public SearchListNetMessage() {
        super(1003196, CmdConfigSocket.CMD_SEARCH_LIST);
        this.mKey = "";
        this.isForum = 0;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.word = this.mKey;
        builder.isforum = String.valueOf(this.isForum);
        if (z) {
            u.a(builder, true);
        }
        SearchSugReqIdl.Builder builder2 = new SearchSugReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
