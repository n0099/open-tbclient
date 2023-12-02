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
/* loaded from: classes9.dex */
public final class xd9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SparseArray<wd9<ChatMsg, ub9<?>>> a;
    public final HashMap<Class<? extends ChatMsg>, Integer> b;

    public xd9() {
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

    public final void a(int i, wd9<ChatMsg, ub9<?>> converter) {
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

    public final ChatMsg c(ub9<?> tbMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbMsg)) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            wd9<ChatMsg, ub9<?>> wd9Var = this.a.get(tbMsg.e().d());
            if (wd9Var == null) {
                return null;
            }
            return wd9Var.b(tbMsg);
        }
        return (ChatMsg) invokeL.objValue;
    }

    public final ub9<?> d(ChatMsg sdkMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, sdkMsg)) == null) {
            Intrinsics.checkNotNullParameter(sdkMsg, "sdkMsg");
            Integer num = this.b.get(sdkMsg.getClass());
            if (num == null) {
                return null;
            }
            wd9<ChatMsg, ub9<?>> wd9Var = this.a.get(num.intValue());
            if (wd9Var == null) {
                return null;
            }
            return wd9Var.a(sdkMsg);
        }
        return (ub9) invokeL.objValue;
    }
}
