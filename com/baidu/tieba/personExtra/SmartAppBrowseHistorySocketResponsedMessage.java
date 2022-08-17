package com.baidu.tieba.personExtra;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.p48;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.HistorySwan.HistorySwanResIdl;
/* loaded from: classes4.dex */
public class SmartAppBrowseHistorySocketResponsedMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p48 mData;

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
                p48 p48Var = new p48();
                this.mData = p48Var;
                p48Var.b(historySwanResIdl.data);
            }
            return historySwanResIdl;
        }
        return invokeIL.objValue;
    }

    public p48 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mData : (p48) invokeV.objValue;
    }
}
