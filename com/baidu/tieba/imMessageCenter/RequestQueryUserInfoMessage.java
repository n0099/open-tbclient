package com.baidu.tieba.imMessageCenter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import protobuf.QueryUserInfos.DataReq;
import protobuf.QueryUserInfos.QueryUserInfosReqIdl;
/* loaded from: classes10.dex */
public class RequestQueryUserInfoMessage extends TbSocketMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataReq.Builder dataBuilder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestQueryUserInfoMessage() {
        super(205003);
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
        this.dataBuilder = new DataReq.Builder();
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                QueryUserInfosReqIdl.Builder builder = new QueryUserInfosReqIdl.Builder();
                builder.data = this.dataBuilder.build(false);
                return builder.build(false);
            } catch (Exception unused) {
                return null;
            }
        }
        return invokeV.objValue;
    }

    public void setReqUserId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            this.dataBuilder.reqUserId = Long.valueOf(j2);
        }
    }
}
