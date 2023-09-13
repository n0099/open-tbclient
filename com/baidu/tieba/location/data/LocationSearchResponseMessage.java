package com.baidu.tieba.location.data;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.c59;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.GetSuggestionByAddrName.GetSuggestionByAddrNameResIdl;
/* loaded from: classes6.dex */
public class LocationSearchResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c59 mLocationData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationSearchResponseMessage() {
        super(303018);
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

    public c59 getLocationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mLocationData;
        }
        return (c59) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetSuggestionByAddrNameResIdl getSuggestionByAddrNameResIdl = (GetSuggestionByAddrNameResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSuggestionByAddrNameResIdl.class);
            setError(getSuggestionByAddrNameResIdl.error.errorno.intValue());
            setErrorString(getSuggestionByAddrNameResIdl.error.usermsg);
            if (getError() != 0) {
                return getSuggestionByAddrNameResIdl;
            }
            c59 c59Var = new c59();
            this.mLocationData = c59Var;
            c59Var.b(getSuggestionByAddrNameResIdl.data);
            BdLog.detailException(null);
            return getSuggestionByAddrNameResIdl;
        }
        return invokeIL.objValue;
    }

    public void setLocationData(c59 c59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c59Var) == null) {
            this.mLocationData = c59Var;
        }
    }
}
