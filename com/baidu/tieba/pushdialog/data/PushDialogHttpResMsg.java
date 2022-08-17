package com.baidu.tieba.pushdialog.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.pushdialog.PushDialogStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ma8;
import java.io.IOException;
import tbclient.GetLockWindowMsg.GetLockWindowMsgResIdl;
/* loaded from: classes4.dex */
public class PushDialogHttpResMsg extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ma8 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushDialogHttpResMsg(int i) {
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

    public ma8 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (ma8) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            try {
                GetLockWindowMsgResIdl getLockWindowMsgResIdl = (GetLockWindowMsgResIdl) PushDialogStatic.a.parseFrom(bArr, GetLockWindowMsgResIdl.class);
                setError(getLockWindowMsgResIdl.error.errorno.intValue());
                setErrorString(getLockWindowMsgResIdl.error.usermsg);
                if (getLockWindowMsgResIdl.data != null) {
                    ma8 ma8Var = new ma8();
                    this.mData = ma8Var;
                    ma8Var.e(getLockWindowMsgResIdl.data);
                }
            } catch (IOException unused) {
            }
        }
    }
}
