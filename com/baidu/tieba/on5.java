package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.TreeSet;
/* loaded from: classes7.dex */
public class on5 implements nn5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final nn5 c;

    @Override // com.baidu.tieba.nn5
    public void c(@NonNull Context context, @NonNull List<Long> list, @NonNull xn5 xn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, list, xn5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.nn5
    public void e(@NonNull yn5 yn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yn5Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948038035, "Lcom/baidu/tieba/on5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948038035, "Lcom/baidu/tieba/on5;");
                return;
            }
        }
        d = new TreeSet<>(nn5.b);
    }

    public on5(@NonNull nn5 nn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nn5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = nn5Var;
    }

    @Override // com.baidu.tieba.nn5
    public void g(@NonNull yn5 yn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yn5Var) == null) {
            this.c.g(yn5Var);
        }
    }

    @Override // com.baidu.tieba.nn5
    public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull xn5 xn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, xn5Var) == null) {
            this.c.a(context, list, xn5Var);
        }
    }

    @Override // com.baidu.tieba.nn5
    public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
            this.c.h(context, str, list);
        }
    }

    @Override // com.baidu.tieba.nn5
    public void b(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable ao5 ao5Var, @NonNull zn5 zn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), ao5Var, zn5Var}) == null) {
            zn5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.nn5
    public void d(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull un5 un5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, list, un5Var) == null) {
            for (Long l : list) {
                un5Var.a(l.longValue(), -1003, "", null);
            }
        }
    }

    @Override // com.baidu.tieba.nn5
    public void f(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull vn5 vn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, list, vn5Var) == null) {
            this.c.f(context, str, list, vn5Var);
        }
    }

    @Override // com.baidu.tieba.nn5
    public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull bo5 bo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, bo5Var}) == null) {
            bo5Var.onSendMessageResult(-1003, null);
        }
    }
}
