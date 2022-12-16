package com.baidu.tieba.setting.im.more;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.CloseAdData;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.CloseAd.CloseAdResIdl;
import tbclient.Error;
/* loaded from: classes6.dex */
public class MemberCloseAdSocketResponseMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CloseAdData mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberCloseAdSocketResponseMessage(int i) {
        super(i);
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            CloseAdResIdl closeAdResIdl = (CloseAdResIdl) new Wire(new Class[0]).parseFrom(bArr, CloseAdResIdl.class);
            Error error = closeAdResIdl.error;
            if (error == null) {
                return closeAdResIdl;
            }
            setError(error.errorno.intValue());
            setErrorString(closeAdResIdl.error.usermsg);
            if (getError() != 0) {
                return closeAdResIdl;
            }
            if (closeAdResIdl.data != null) {
                CloseAdData closeAdData = new CloseAdData();
                this.mData = closeAdData;
                closeAdData.I(closeAdResIdl.data.vip_close_ad);
            }
            return closeAdResIdl;
        }
        return invokeIL.objValue;
    }

    public CloseAdData getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mData;
        }
        return (CloseAdData) invokeV.objValue;
    }
}
