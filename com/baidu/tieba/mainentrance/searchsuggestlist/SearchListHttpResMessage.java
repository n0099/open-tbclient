package com.baidu.tieba.mainentrance.searchsuggestlist;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.SearchSug.DataRes;
import tbclient.SearchSug.SearchSugResIdl;
/* loaded from: classes5.dex */
public class SearchListHttpResMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List forums;
    public DataRes suggestData;
    public List suggests;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchListHttpResMessage() {
        super(CmdConfigHttp.CMD_SEARCH_LIST);
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchListHttpResMessage(int i) {
        super(CmdConfigHttp.CMD_SEARCH_LIST);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.suggests = null;
        this.forums = null;
        this.suggestData = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SearchSugResIdl searchSugResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (searchSugResIdl = (SearchSugResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchSugResIdl.class)) == null) {
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
            this.suggestData = dataRes;
        }
    }
}
