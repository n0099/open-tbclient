package com.baidu.tieba.personExtra;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.se9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.HistorySwan.HistorySwanResIdl;
/* loaded from: classes7.dex */
public class SmartAppBrowseHistorySocketResponsedMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public se9 mData;

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

    public se9 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mData;
        }
        return (se9) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            HistorySwanResIdl historySwanResIdl = (HistorySwanResIdl) new Wire(new Class[0]).parseFrom(bArr, HistorySwanResIdl.class);
            if (historySwanResIdl == null) {
                return null;
            }
            Error error = historySwanResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(historySwanResIdl.error.usermsg);
            }
            if (historySwanResIdl.data != null) {
                se9 se9Var = new se9();
                this.mData = se9Var;
                se9Var.b(historySwanResIdl.data);
            }
            return historySwanResIdl;
        }
        return invokeIL.objValue;
    }
}
