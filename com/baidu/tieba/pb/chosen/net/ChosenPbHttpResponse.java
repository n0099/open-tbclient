package com.baidu.tieba.pb.chosen.net;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qs7;
import com.repackage.tr4;
import com.repackage.ue;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.Error;
import tbclient.ExcPbPage.DataRes;
import tbclient.ExcPbPage.ExcContent;
import tbclient.ExcPbPage.ExcPbPageResIdl;
import tbclient.ExcPbPage.ExcellentPbThreadInfo;
import tbclient.ExcPbPage.UserInfo;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes3.dex */
public class ChosenPbHttpResponse extends HttpResponsedMessage implements qs7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Post> postList;
    public ExcellentPbThreadInfo threadInfo;
    public UserInfo userInfo;
    public List<User> userList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChosenPbHttpResponse(int i) {
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

    @Override // com.repackage.qs7
    public int getErroCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? super.getError() : invokeV.intValue;
    }

    @Override // com.repackage.qs7
    public String getErrorText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? getErrorString() : (String) invokeV.objValue;
    }

    @Override // com.repackage.qs7
    public List<Post> getPostList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.postList : (List) invokeV.objValue;
    }

    @Override // com.repackage.qs7
    public ExcellentPbThreadInfo getThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.threadInfo : (ExcellentPbThreadInfo) invokeV.objValue;
    }

    @Override // com.repackage.qs7
    public UserInfo getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.userInfo : (UserInfo) invokeV.objValue;
    }

    @Override // com.repackage.qs7
    public List<User> getUserList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.userList : (List) invokeV.objValue;
    }

    @Override // com.repackage.qs7
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
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            tr4.f();
            ue<byte[]> d = tr4.d("tb.pb_normal");
            d.remove("chosen_pb_page_cache");
            d.g("chosen_pb_page_cache", bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        ExcPbPageResIdl excPbPageResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i, bArr) == null) || (excPbPageResIdl = (ExcPbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcPbPageResIdl.class)) == null) {
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
