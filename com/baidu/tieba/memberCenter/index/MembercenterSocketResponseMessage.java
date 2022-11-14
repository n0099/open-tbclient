package com.baidu.tieba.memberCenter.index;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.df;
import com.baidu.tieba.gp7;
import com.baidu.tieba.iv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.GetVipInfoResIdl;
/* loaded from: classes5.dex */
public class MembercenterSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gp7 mMembercenter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MembercenterSocketResponseMessage() {
        super(309062);
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

    public gp7 getMembercenterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mMembercenter;
        }
        return (gp7) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetVipInfoResIdl getVipInfoResIdl = (GetVipInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetVipInfoResIdl.class);
            if (getVipInfoResIdl == null) {
                return null;
            }
            Error error = getVipInfoResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getVipInfoResIdl.error.usermsg);
            }
            DataRes dataRes = getVipInfoResIdl.data;
            if (dataRes != null) {
                this.mMembercenter = new gp7(dataRes);
            }
            if (getError() == 0) {
                if (TbadkCoreApplication.isLogin()) {
                    str = TbadkCoreApplication.getCurrentAccount();
                } else {
                    str = SevenZipUtils.FILE_NAME_TEMP;
                }
                iv4.f();
                df<byte[]> e = iv4.e("tb_member_center", str);
                if (e != null && bArr != null) {
                    e.g("member_center_cache_key", bArr);
                }
            }
            return getVipInfoResIdl;
        }
        return invokeIL.objValue;
    }
}
