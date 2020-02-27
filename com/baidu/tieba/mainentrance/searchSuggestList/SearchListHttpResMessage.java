package com.baidu.tieba.mainentrance.searchSuggestList;

import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.SearchSug.ForumInfo;
import tbclient.SearchSug.SearchSugResIdl;
/* loaded from: classes11.dex */
public class SearchListHttpResMessage extends TbHttpResponsedMessage {
    public List<ForumInfo> forums;
    public List<String> suggests;

    public SearchListHttpResMessage(int i) {
        super(1003196);
        this.suggests = null;
        this.forums = null;
    }

    public SearchListHttpResMessage() {
        super(1003196);
        this.suggests = null;
        this.forums = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SearchSugResIdl searchSugResIdl = (SearchSugResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchSugResIdl.class);
        if (searchSugResIdl != null) {
            if (searchSugResIdl.error != null) {
                setError(searchSugResIdl.error.errorno.intValue());
                setErrorString(searchSugResIdl.error.usermsg);
            }
            if (searchSugResIdl.data != null) {
                this.suggests = searchSugResIdl.data.list;
                this.forums = searchSugResIdl.data.forum_list;
            }
        }
    }
}
