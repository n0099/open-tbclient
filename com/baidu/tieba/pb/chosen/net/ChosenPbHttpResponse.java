package com.baidu.tieba.pb.chosen.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.d.e.d.l;
import d.a.q0.h2.g.c.a;
import java.util.List;
import tbclient.Error;
import tbclient.ExcPbPage.DataRes;
import tbclient.ExcPbPage.ExcContent;
import tbclient.ExcPbPage.ExcPbPageResIdl;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes4.dex */
public class ChosenPbHttpResponse extends HttpResponsedMessage implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Post> postList;
    public ExcellentPbThreadInfo threadInfo;
    public UserInfo userInfo;
    public List<User> userList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChosenPbHttpResponse(int i2) {
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
    }

    @Override // d.a.q0.h2.g.c.a
    public int getErroCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? super.getError() : invokeV.intValue;
    }

    @Override // d.a.q0.h2.g.c.a
    public String getErrorText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getErrorString() : (String) invokeV.objValue;
    }

    @Override // d.a.q0.h2.g.c.a
    public List<Post> getPostList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.postList : (List) invokeV.objValue;
    }

    @Override // d.a.q0.h2.g.c.a
    public ExcellentPbThreadInfo getThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.threadInfo : (ExcellentPbThreadInfo) invokeV.objValue;
    }

    @Override // d.a.q0.h2.g.c.a
    public UserInfo getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.userInfo : (UserInfo) invokeV.objValue;
    }

    @Override // d.a.q0.h2.g.c.a
    public List<User> getUserList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.userList : (List) invokeV.objValue;
    }

    @Override // d.a.q0.h2.g.c.a
    public boolean isEmpty() {
        InterceptResult invokeV;
        List<ExcContent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ExcellentPbThreadInfo excellentPbThreadInfo = this.threadInfo;
            return excellentPbThreadInfo == null || (list = excellentPbThreadInfo.content) == null || list.size() <= 0;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            super.afterDispatchInBackGround(i2, (int) bArr);
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            l<byte[]> d2 = d.a.p0.s.r.a.f().d("tb.pb_normal");
            d2.remove(PbChosenActivity.CHOSEN_PB_TABLE_NAME);
            d2.g(PbChosenActivity.CHOSEN_PB_TABLE_NAME, bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        ExcPbPageResIdl excPbPageResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) || (excPbPageResIdl = (ExcPbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcPbPageResIdl.class)) == null) {
            return;
        }
        Error error = excPbPageResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(excPbPageResIdl.error.usermsg);
        }
        DataRes dataRes = excPbPageResIdl.data;
        if (dataRes == null) {
            return;
        }
        this.userInfo = dataRes.user_info;
        this.threadInfo = dataRes.thread_info;
        this.postList = dataRes.post_list;
        this.userList = dataRes.user_list;
    }
}
