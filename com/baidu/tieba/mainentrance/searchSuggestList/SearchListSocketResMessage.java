package com.baidu.tieba.mainentrance.searchSuggestList;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.SearchSug.SearchSugResIdl;
/* loaded from: classes3.dex */
public class SearchListSocketResMessage extends SocketResponsedMessage {
    public List<String> suggests;

    public SearchListSocketResMessage() {
        super(309438);
        this.suggests = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SearchSugResIdl searchSugResIdl = (SearchSugResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchSugResIdl.class);
        if (searchSugResIdl != null) {
            if (searchSugResIdl.error != null) {
                setError(searchSugResIdl.error.errorno.intValue());
                setErrorString(searchSugResIdl.error.usermsg);
            }
            if (searchSugResIdl.data != null) {
                this.suggests = searchSugResIdl.data.list;
            }
        }
    }
}
