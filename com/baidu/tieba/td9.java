package com.baidu.tieba;

import android.util.SparseArray;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class td9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<sd9<ChatMsg, qb9<?>>> a;
    public final HashMap<Class<? extends ChatMsg>, Integer> b;

    public td9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new SparseArray<>();
        this.b = new HashMap<>();
    }

    public final void a(int i, sd9<ChatMsg, qb9<?>> converter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, converter) == null) {
            Intrinsics.checkNotNullParameter(converter, "converter");
            this.a.put(i, converter);
        }
    }

    public final void b(Class<? extends ChatMsg> sdkMsg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sdkMsg, i) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            this.b.put(sdkMsg, Integer.valueOf(i));
        }
    }

    public final ChatMsg c(qb9<?> tbMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbMsg)) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            sd9<ChatMsg, qb9<?>> sd9Var = this.a.get(tbMsg.e().d());
            if (sd9Var == null) {
                return null;
            }
            return sd9Var.b(tbMsg);
        }
        return (ChatMsg) invokeL.objValue;
    }

    public final qb9<?> d(ChatMsg sdkMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sdkMsg)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            Integer num = this.b.get(sdkMsg.getClass());
            if (num == null) {
                return null;
            }
            sd9<ChatMsg, qb9<?>> sd9Var = this.a.get(num.intValue());
            if (sd9Var == null) {
                return null;
            }
            return sd9Var.a(sdkMsg);
        }
        return (qb9) invokeL.objValue;
    }
}
