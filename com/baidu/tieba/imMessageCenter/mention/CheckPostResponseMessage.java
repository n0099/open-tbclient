package com.baidu.tieba.imMessageCenter.mention;

import androidx.annotation.Nullable;
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
/* loaded from: classes4.dex */
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

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.forumId;
        }
        return invokeV.longValue;
    }

    public String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    public long getPostState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.postState;
        }
        return invokeV.longValue;
    }

    public long getQuoteId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.quoteId;
        }
        return invokeV.longValue;
    }

    public long getRepostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.repostId;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            CheckPostResIdl checkPostResIdl = (CheckPostResIdl) new Wire(new Class[0]).parseFrom(bArr, CheckPostResIdl.class);
            setError(checkPostResIdl.error.errorno.intValue());
            setErrorString(checkPostResIdl.error.usermsg);
            if (getError() != 0) {
                return checkPostResIdl;
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
            return checkPostResIdl;
        }
        return invokeIL.objValue;
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.forumId = j;
        }
    }

    public void setPostState(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.postState = j;
        }
    }

    public void setQuoteId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.quoteId = j;
        }
    }

    public void setRepostId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.repostId = j;
        }
    }
}
