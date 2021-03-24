package com.baidu.tieba.mainentrance.searchSuggestList;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.SearchSug.DataRes;
import tbclient.SearchSug.ForumInfo;
import tbclient.SearchSug.SearchSugResIdl;
/* loaded from: classes3.dex */
public class SearchListHttpResMessage extends TbHttpResponsedMessage {
    public List<ForumInfo> forums;
    public List<String> suggests;

    public SearchListHttpResMessage(int i) {
        super(CmdConfigHttp.CMD_SEARCH_LIST);
        this.suggests = null;
        this.forums = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SearchSugResIdl searchSugResIdl = (SearchSugResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchSugResIdl.class);
        if (searchSugResIdl == null) {
            return;
        }
        Error error = searchSugResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(searchSugResIdl.error.usermsg);
        }
        DataRes dataRes = searchSugResIdl.data;
        if (dataRes != null) {
            this.suggests = dataRes.list;
            this.forums = dataRes.forum_list;
        }
    }

    public SearchListHttpResMessage() {
        super(CmdConfigHttp.CMD_SEARCH_LIST);
        this.suggests = null;
        this.forums = null;
    }
}
