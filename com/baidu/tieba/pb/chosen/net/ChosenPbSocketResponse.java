package com.baidu.tieba.pb.chosen.net;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.jf;
import com.baidu.tieba.mu4;
import com.baidu.tieba.vu7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes5.dex */
public class ChosenPbSocketResponse extends SocketResponsedMessage implements vu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Post> postList;
    public ExcellentPbThreadInfo threadInfo;
    public UserInfo userInfo;
    public List<User> userList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChosenPbSocketResponse() {
        super(309093);
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            ExcPbPageResIdl excPbPageResIdl = (ExcPbPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ExcPbPageResIdl.class);
            if (excPbPageResIdl == null) {
                return null;
            }
            Error error = excPbPageResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(excPbPageResIdl.error.usermsg);
            }
            DataRes dataRes = excPbPageResIdl.data;
            if (dataRes == null) {
                return excPbPageResIdl;
            }
            this.userInfo = dataRes.user_info;
            this.threadInfo = dataRes.thread_info;
            this.postList = dataRes.post_list;
            this.userList = dataRes.user_list;
            return excPbPageResIdl;
        }
        return invokeIL.objValue;
    }

    @Override // com.baidu.tieba.vu7
    public int getErroCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? getError() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.vu7
    public String getErrorText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getErrorString() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vu7
    public List<Post> getPostList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.postList : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vu7
    public ExcellentPbThreadInfo getThreadInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.threadInfo : (ExcellentPbThreadInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vu7
    public UserInfo getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.userInfo : (UserInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vu7
    public List<User> getUserList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.userList : (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vu7
    public boolean isEmpty() {
        InterceptResult invokeV;
        List<ExcContent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
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
            mu4.f();
            jf<byte[]> d = mu4.d("tb.pb_normal");
            d.remove("chosen_pb_page_cache");
            d.g("chosen_pb_page_cache", bArr);
        }
    }
}
