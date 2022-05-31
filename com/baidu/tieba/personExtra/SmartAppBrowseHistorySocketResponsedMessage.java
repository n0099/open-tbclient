package com.baidu.tieba.personExtra;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.k08;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.HistorySwan.HistorySwanResIdl;
/* loaded from: classes3.dex */
public class SmartAppBrowseHistorySocketResponsedMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k08 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartAppBrowseHistorySocketResponsedMessage() {
        super(309638);
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

    public k08 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (k08) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        HistorySwanResIdl historySwanResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (historySwanResIdl = (HistorySwanResIdl) new Wire(new Class[0]).parseFrom(bArr, HistorySwanResIdl.class)) == null) {
            return;
        }
        Error error = historySwanResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(historySwanResIdl.error.usermsg);
        }
        if (historySwanResIdl.data != null) {
            k08 k08Var = new k08();
            this.mData = k08Var;
            k08Var.b(historySwanResIdl.data);
        }
    }
}
