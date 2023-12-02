package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.gca;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetRecommendGodList.GetRecommendGodListResIdl;
/* loaded from: classes7.dex */
public class RecommendGodHttpResponseMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gca recommendGodData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendGodHttpResponseMessage() {
        super(CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST);
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetRecommendGodListResIdl getRecommendGodListResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (getRecommendGodListResIdl = (GetRecommendGodListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetRecommendGodListResIdl.class)) == null) {
            return;
        }
        Error error = getRecommendGodListResIdl.error;
        if (error != null) {
            Integer num = error.errorno;
            if (num != null) {
                setError(num.intValue());
            }
            setErrorString(getRecommendGodListResIdl.error.usermsg);
        }
        gca gcaVar = new gca();
        this.recommendGodData = gcaVar;
        gcaVar.b(getRecommendGodListResIdl.data);
    }
}
