package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import com.squareup.wire.Wire;
import d.a.d.e.d.l;
import d.a.p0.s.r.a;
import d.a.q0.v1.c.b.m;
import tbclient.Error;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.GetVipInfoResIdl;
/* loaded from: classes4.dex */
public class MembercenterSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m mMembercenter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MembercenterSocketResponseMessage() {
        super(309062);
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
    }

    public m getMembercenterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mMembercenter : (m) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetVipInfoResIdl getVipInfoResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getVipInfoResIdl = (GetVipInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetVipInfoResIdl.class)) == null) {
            return;
        }
        Error error = getVipInfoResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getVipInfoResIdl.error.usermsg);
        }
        DataRes dataRes = getVipInfoResIdl.data;
        if (dataRes != null) {
            this.mMembercenter = new m(dataRes);
        }
        if (getError() == 0) {
            l<byte[]> e2 = a.f().e("tb_member_center", TbadkCoreApplication.isLogin() ? TbadkCoreApplication.getCurrentAccount() : SevenZipUtils.FILE_NAME_TEMP);
            if (e2 == null || bArr == null) {
                return;
            }
            e2.g("member_center_cache_key", bArr);
        }
    }
}
