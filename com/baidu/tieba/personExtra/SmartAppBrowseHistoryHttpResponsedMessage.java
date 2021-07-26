package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.q0.l2.a;
import tbclient.Error;
import tbclient.HistorySwan.HistorySwanResIdl;
/* loaded from: classes4.dex */
public class SmartAppBrowseHistoryHttpResponsedMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartAppBrowseHistoryHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_HISTORY_SWAN);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        HistorySwanResIdl historySwanResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (historySwanResIdl = (HistorySwanResIdl) new Wire(new Class[0]).parseFrom(bArr, HistorySwanResIdl.class)) == null) {
            return;
        }
        Error error = historySwanResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(historySwanResIdl.error.usermsg);
        }
        if (historySwanResIdl.data != null) {
            a aVar = new a();
            this.mData = aVar;
            aVar.b(historySwanResIdl.data);
        }
    }
}
