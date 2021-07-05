package com.baidu.tieba.imMessageCenter.mention;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.CheckPost.CheckPostResIdl;
import tbclient.CheckPost.ResData;
/* loaded from: classes5.dex */
public class CheckPostResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long forumId;
    public String forumName;
    public long postState;
    public long quoteId;
    public long repostId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckPostResponseMessage() {
        super(303010);
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

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.forumId : invokeV.longValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.forumName : (String) invokeV.objValue;
    }

    public long getPostState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.postState : invokeV.longValue;
    }

    public long getQuoteId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.quoteId : invokeV.longValue;
    }

    public long getRepostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.repostId : invokeV.longValue;
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.forumId = j;
        }
    }

    public void setPostState(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.postState = j;
        }
    }

    public void setQuoteId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.quoteId = j;
        }
    }

    public void setRepostId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.repostId = j;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            CheckPostResIdl checkPostResIdl = (CheckPostResIdl) new Wire(new Class[0]).parseFrom(bArr, CheckPostResIdl.class);
            setError(checkPostResIdl.error.errorno.intValue());
            setErrorString(checkPostResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            this.postState = checkPostResIdl.data.postState.longValue();
            this.forumId = checkPostResIdl.data.forumId.longValue();
            ResData resData = checkPostResIdl.data;
            this.forumName = resData.fname;
            Long l = resData.quoteId;
            if (l != null) {
                this.quoteId = l.longValue();
            }
            Long l2 = checkPostResIdl.data.repostId;
            if (l2 != null) {
                this.repostId = l2.longValue();
            }
        }
    }
}
