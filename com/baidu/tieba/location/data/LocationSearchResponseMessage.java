package com.baidu.tieba.location.data;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ff7;
import com.squareup.wire.Wire;
import tbclient.GetSuggestionByAddrName.GetSuggestionByAddrNameResIdl;
/* loaded from: classes3.dex */
public class LocationSearchResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ff7 mLocationData;

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

    public ff7 getLocationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mLocationData : (ff7) invokeV.objValue;
    }

    public void setLocationData(ff7 ff7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ff7Var) == null) {
            this.mLocationData = ff7Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            GetSuggestionByAddrNameResIdl getSuggestionByAddrNameResIdl = (GetSuggestionByAddrNameResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSuggestionByAddrNameResIdl.class);
            setError(getSuggestionByAddrNameResIdl.error.errorno.intValue());
            setErrorString(getSuggestionByAddrNameResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            ff7 ff7Var = new ff7();
            this.mLocationData = ff7Var;
            ff7Var.b(getSuggestionByAddrNameResIdl.data);
            BdLog.detailException(null);
        }
    }
}
