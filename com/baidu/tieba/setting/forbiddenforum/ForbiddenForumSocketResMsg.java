package com.baidu.tieba.setting.forbiddenforum;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vi8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetDislikeList.GetDislikeListResIdl;
/* loaded from: classes5.dex */
public class ForbiddenForumSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vi8 pageData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForbiddenForumSocketResMsg() {
        super(309692);
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

    public vi8 getPageData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.pageData;
        }
        return (vi8) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetDislikeListResIdl getDislikeListResIdl = (GetDislikeListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetDislikeListResIdl.class);
            if (getDislikeListResIdl == null) {
                return null;
            }
            Error error = getDislikeListResIdl.error;
            if (error != null) {
                Integer num = error.errorno;
                if (num != null) {
                    setError(num.intValue());
                }
                setErrorString(getDislikeListResIdl.error.usermsg);
            }
            vi8 vi8Var = new vi8();
            this.pageData = vi8Var;
            vi8Var.a(getDislikeListResIdl.data);
            return getDislikeListResIdl;
        }
        return invokeIL.objValue;
    }
}
