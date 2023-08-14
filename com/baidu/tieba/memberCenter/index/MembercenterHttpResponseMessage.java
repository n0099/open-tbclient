package com.baidu.tieba.memberCenter.index;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.l45;
import com.baidu.tieba.ne;
import com.baidu.tieba.q49;
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
/* loaded from: classes7.dex */
public class MembercenterHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q49 mMembercenter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MembercenterHttpResponseMessage() {
        super(CmdConfigHttp.CMD_MEMBERCENTER_INDEX);
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

    public q49 getMembercenterData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mMembercenter;
        }
        return (q49) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetVipInfoResIdl getVipInfoResIdl;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (getVipInfoResIdl = (GetVipInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetVipInfoResIdl.class)) == null) {
            return;
        }
        Error error = getVipInfoResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getVipInfoResIdl.error.usermsg);
        }
        DataRes dataRes = getVipInfoResIdl.data;
        if (dataRes != null) {
            this.mMembercenter = new q49(dataRes);
        }
        if (getError() == 0) {
            if (TbadkCoreApplication.isLogin()) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = SevenZipUtils.FILE_NAME_TEMP;
            }
            l45.e();
            ne<byte[]> d = l45.d("tb_member_center", str);
            if (d != null && bArr != null) {
                d.g("member_center_cache_key", bArr);
            }
        }
    }
}
