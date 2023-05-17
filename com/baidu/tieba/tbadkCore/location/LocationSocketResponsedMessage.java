package com.baidu.tieba.tbadkCore.location;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.GetPoisByLocation.GetPoisByLocationResIdl;
/* loaded from: classes7.dex */
public class LocationSocketResponsedMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LocationData mLocationData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationSocketResponsedMessage() {
        super(303017);
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

    public LocationData getLocationData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mLocationData;
        }
        return (LocationData) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetPoisByLocationResIdl getPoisByLocationResIdl = (GetPoisByLocationResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPoisByLocationResIdl.class);
            setError(getPoisByLocationResIdl.error.errorno.intValue());
            setErrorString(getPoisByLocationResIdl.error.usermsg);
            if (getError() != 0) {
                return getPoisByLocationResIdl;
            }
            LocationData locationData = new LocationData();
            this.mLocationData = locationData;
            locationData.parserProtoBuf(getPoisByLocationResIdl.data);
            BdLog.detailException(null);
            return getPoisByLocationResIdl;
        }
        return invokeIL.objValue;
    }

    public void setLocationData(LocationData locationData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, locationData) == null) {
            this.mLocationData = locationData;
        }
    }
}
