package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.aj9;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PbPage.PbPageResIdl;
/* loaded from: classes7.dex */
public class PbPageReadLocalResponseMessage extends CustomResponsedMessage<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean markCache;
    public aj9 pbData;
    public String postId;
    public int updateType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPageReadLocalResponseMessage() {
        super(2004003);
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

    public aj9 getPbData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.pbData;
        }
        return (aj9) invokeV.objValue;
    }

    public int getUpdateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.updateType;
        }
        return invokeV.intValue;
    }

    public boolean isMarkCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.markCache;
        }
        return invokeV.booleanValue;
    }

    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(1048576, this, i, bArr) != null) || bArr == null) {
            return;
        }
        PbPageResIdl pbPageResIdl = (PbPageResIdl) PbPageRequestMessage.WIRE.parseFrom(bArr, PbPageResIdl.class);
        setError(pbPageResIdl.error.errorno.intValue());
        setErrorString(pbPageResIdl.error.usermsg);
        if (getError() == 0 && pbPageResIdl.data != null) {
            aj9 aj9Var = new aj9();
            this.pbData = aj9Var;
            aj9Var.F0(1);
            try {
                this.pbData.E0(pbPageResIdl.data);
                if (!this.pbData.w0()) {
                    this.pbData = null;
                } else if (isMarkCache() && this.pbData.u() != null && !this.pbData.u().equals(this.postId)) {
                    this.pbData = null;
                }
            } catch (Exception unused) {
            }
        }
    }

    public void setMarkCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.markCache = z;
        }
    }

    public void setPostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.postId = str;
        }
    }

    public void setUpdateType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.updateType = i;
        }
    }
}
