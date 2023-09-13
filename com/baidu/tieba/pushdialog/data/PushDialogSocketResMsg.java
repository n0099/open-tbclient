package com.baidu.tieba.pushdialog.data;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pushdialog.PushDialogStatic;
import com.baidu.tieba.w1a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import tbclient.GetLockWindowMsg.GetLockWindowMsgResIdl;
/* loaded from: classes7.dex */
public class PushDialogSocketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w1a mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushDialogSocketResMsg(int i) {
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            try {
                GetLockWindowMsgResIdl getLockWindowMsgResIdl = (GetLockWindowMsgResIdl) PushDialogStatic.a.parseFrom(bArr, GetLockWindowMsgResIdl.class);
                setError(getLockWindowMsgResIdl.error.errorno.intValue());
                setErrorString(getLockWindowMsgResIdl.error.usermsg);
                if (getLockWindowMsgResIdl.data != null) {
                    w1a w1aVar = new w1a();
                    this.mData = w1aVar;
                    w1aVar.e(getLockWindowMsgResIdl.data);
                }
                return getLockWindowMsgResIdl;
            } catch (IOException unused) {
                return null;
            }
        }
        return invokeIL.objValue;
    }

    public w1a getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mData;
        }
        return (w1a) invokeV.objValue;
    }
}
