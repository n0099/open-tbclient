package com.baidu.tieba.mainentrance.searchSuggestList;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.r;
import tbclient.SearchSug.DataReq;
import tbclient.SearchSug.SearchSugReqIdl;
/* loaded from: classes6.dex */
public class SearchListNetMessage extends NetMessage {
    public Integer isForum;
    public String mKey;

    public SearchListNetMessage() {
        super(CmdConfigHttp.CMD_SEARCH_LIST, 309438);
        this.mKey = "";
        this.isForum = 0;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.word = this.mKey;
        builder.isforum = String.valueOf(this.isForum);
        if (z) {
            r.bindCommonParamsToProtobufData(builder, true);
        }
        SearchSugReqIdl.Builder builder2 = new SearchSugReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
