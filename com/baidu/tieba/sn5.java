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
public class sn5 implements rn5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final rn5 c;

    @Override // com.baidu.tieba.rn5
    public void c(@NonNull Context context, @NonNull List<Long> list, @NonNull bo5 bo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, list, bo5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.rn5
    public void e(@NonNull co5 co5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, co5Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948157199, "Lcom/baidu/tieba/sn5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948157199, "Lcom/baidu/tieba/sn5;");
                return;
            }
        }
        d = new TreeSet<>(rn5.b);
    }

    public sn5(@NonNull rn5 rn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rn5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = rn5Var;
    }

    @Override // com.baidu.tieba.rn5
    public void g(@NonNull co5 co5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, co5Var) == null) {
            this.c.g(co5Var);
        }
    }

    @Override // com.baidu.tieba.rn5
    public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull bo5 bo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, bo5Var) == null) {
            this.c.a(context, list, bo5Var);
        }
    }

    @Override // com.baidu.tieba.rn5
    public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
            this.c.h(context, str, list);
        }
    }

    @Override // com.baidu.tieba.rn5
    public void b(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable eo5 eo5Var, @NonNull do5 do5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), eo5Var, do5Var}) == null) {
            do5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.rn5
    public void d(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull yn5 yn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, list, yn5Var) == null) {
            for (Long l : list) {
                yn5Var.a(l.longValue(), -1003, "", null);
            }
        }
    }

    @Override // com.baidu.tieba.rn5
    public void f(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull zn5 zn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, list, zn5Var) == null) {
            this.c.f(context, str, list, zn5Var);
        }
    }

    @Override // com.baidu.tieba.rn5
    public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull fo5 fo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, fo5Var}) == null) {
            fo5Var.onSendMessageResult(-1003, null);
        }
    }
}
