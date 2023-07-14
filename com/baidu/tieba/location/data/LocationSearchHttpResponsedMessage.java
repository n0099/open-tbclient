package com.baidu.tieba.location.data;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.b29;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.GetSuggestionByAddrName.GetSuggestionByAddrNameResIdl;
/* loaded from: classes6.dex */
public class LocationSearchHttpResponsedMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b29 mLocationData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationSearchHttpResponsedMessage(int i) {
        super(CmdConfigHttp.CMD_GET_SUGGESTLOCSTION_BY_NAME);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            GetSuggestionByAddrNameResIdl getSuggestionByAddrNameResIdl = (GetSuggestionByAddrNameResIdl) new Wire(new Class[0]).parseFrom(bArr, GetSuggestionByAddrNameResIdl.class);
            setError(getSuggestionByAddrNameResIdl.error.errorno.intValue());
            setErrorString(getSuggestionByAddrNameResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            b29 b29Var = new b29();
            this.mLocationData = b29Var;
            b29Var.b(getSuggestionByAddrNameResIdl.data);
            BdLog.detailException(null);
        }
    }

    public b29 getLocationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mLocationData;
        }
        return (b29) invokeV.objValue;
    }

    public void setLocationData(b29 b29Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b29Var) == null) {
            this.mLocationData = b29Var;
        }
    }
}
