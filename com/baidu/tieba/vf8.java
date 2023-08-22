package com.baidu.tieba;

import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class vf8 extends uf8 {
    public static /* synthetic */ Interceptable $ic;
    public static final vf8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948238977, "Lcom/baidu/tieba/vf8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948238977, "Lcom/baidu/tieba/vf8;");
                return;
            }
        }
        a = new vf8();
    }

    public vf8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.eg8
    /* renamed from: e */
    public void a(ChatMsg sdkMsg, TbBaseMsg tbMsg, String extJson) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, sdkMsg, tbMsg, extJson) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            Intrinsics.checkNotNullParameter(extJson, "extJson");
            sdkMsg.setCategory(0);
            sdkMsg.setChatType(7);
            sdkMsg.setContentExtra(extJson);
            sdkMsg.setMsgContent(sdkMsg.getSendMsgContent());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.eg8
    /* renamed from: f */
    public String c(ChatMsg sdkMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sdkMsg)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            String contentExtra = sdkMsg.getContentExtra();
            Intrinsics.checkNotNullExpressionValue(contentExtra, "sdkMsg.contentExtra");
            return contentExtra;
        }
        return (String) invokeL.objValue;
    }
}
