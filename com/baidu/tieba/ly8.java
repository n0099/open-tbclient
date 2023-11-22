package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ly8 {
    public static /* synthetic */ Interceptable $ic;
    public static final ly8 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947959326, "Lcom/baidu/tieba/ly8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947959326, "Lcom/baidu/tieba/ly8;");
                return;
            }
        }
        a = new ly8();
    }

    public ly8() {
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

    public final void a(List<?> data, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, data, str) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data.size() > 0 && data.get(0) != null && (data.get(0) instanceof ChatGroupInfo)) {
                Object obj = data.get(0);
                if (obj != null) {
                    ChatGroupInfo chatGroupInfo = (ChatGroupInfo) obj;
                    if (chatGroupInfo.getRoomInfoList() != null && chatGroupInfo.getRoomInfoList().get(0) != null) {
                        chatGroupInfo.getRoomInfoList().get(0).setSingleListHotText(str);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.immessagecenter.chatgroup.data.ChatGroupInfo");
            }
        }
    }

    public final boolean b(List<?> data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            int size = data.size();
            for (int i = 0; i < size; i++) {
                if (data.get(i) instanceof ChatGroupInfo) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean c(List<?> data) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            int size = data.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                if ((data.get(i2) instanceof ChatGroupInfo) && (i = i + 1) > 1) {
                    return false;
                }
            }
            if (i != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
