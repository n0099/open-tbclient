package com.baidu.tieba.mainentrance.searchsuggestlist;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.SearchSug.DataRes;
import tbclient.SearchSug.SearchSugResIdl;
/* loaded from: classes5.dex */
public class SearchListSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List forums;
    public DataRes suggestData;
    public List suggests;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchListSocketResMessage() {
        super(309438);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.suggests = null;
        this.forums = null;
        this.suggestData = null;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            SearchSugResIdl searchSugResIdl = (SearchSugResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchSugResIdl.class);
            if (searchSugResIdl == null) {
                return null;
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
                this.suggestData = dataRes;
            }
            return searchSugResIdl;
        }
        return invokeIL.objValue;
    }
}
