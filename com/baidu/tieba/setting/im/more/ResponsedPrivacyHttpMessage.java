package com.baidu.tieba.setting.im.more;

import c.a.r0.b3.b.a.a;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetPrivateInfo.GetPrivateInfoResIdl;
import tbclient.GetPrivateInfo.ResData;
import tbclient.SimpleUser;
/* loaded from: classes7.dex */
public class ResponsedPrivacyHttpMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a privacyData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponsedPrivacyHttpMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.privacyData = new a();
    }

    public a getPrivacyData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.privacyData : (a) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetPrivateInfoResIdl getPrivateInfoResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getPrivateInfoResIdl = (GetPrivateInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetPrivateInfoResIdl.class)) == null) {
            return;
        }
        Error error = getPrivateInfoResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getPrivateInfoResIdl.error.errmsg);
        }
        ResData resData = getPrivateInfoResIdl.data;
        if (resData == null) {
            return;
        }
        Integer num = resData.like;
        if (num != null) {
            this.privacyData.r(num.intValue());
        }
        Integer num2 = getPrivateInfoResIdl.data.group;
        if (num2 != null) {
            this.privacyData.s(num2.intValue());
        }
        Integer num3 = getPrivateInfoResIdl.data.post;
        if (num3 != null) {
            this.privacyData.y(num3.intValue());
        }
        Integer num4 = getPrivateInfoResIdl.data.location;
        if (num4 != null) {
            this.privacyData.u(num4.intValue());
        }
        SimpleUser simpleUser = getPrivateInfoResIdl.data.user;
        if (simpleUser != null) {
            this.privacyData.v(simpleUser);
        }
        Integer num5 = getPrivateInfoResIdl.data.live;
        if (num5 != null) {
            this.privacyData.t(num5.intValue());
        }
        Integer num6 = getPrivateInfoResIdl.data.forum_num;
        if (num6 != null) {
            this.privacyData.q(num6.intValue());
        }
        Integer num7 = getPrivateInfoResIdl.data.reply;
        if (num7 != null) {
            this.privacyData.w(num7.intValue());
        }
        Integer num8 = getPrivateInfoResIdl.data.bazhu_show_inside;
        if (num8 != null) {
            this.privacyData.o(num8.intValue());
        }
        Integer num9 = getPrivateInfoResIdl.data.bazhu_show_outside;
        if (num9 != null) {
            this.privacyData.p(num9.intValue());
        }
    }
}
