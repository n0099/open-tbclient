package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
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
/* loaded from: classes5.dex */
public class ph5 implements oh5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final oh5 c;

    @Override // com.baidu.tieba.oh5
    public void b(@NonNull Context context, @NonNull List<Long> list, @NonNull th5 th5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, th5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.oh5
    public void d(@NonNull uh5 uh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, uh5Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948062060, "Lcom/baidu/tieba/ph5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948062060, "Lcom/baidu/tieba/ph5;");
                return;
            }
        }
        d = new TreeSet<>(oh5.b);
    }

    public ph5(@NonNull oh5 oh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oh5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = oh5Var;
    }

    @Override // com.baidu.tieba.oh5
    public void g(@NonNull uh5 uh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uh5Var) == null) {
            this.c.g(uh5Var);
        }
    }

    @Override // com.baidu.tieba.oh5
    public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull th5 th5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, th5Var) == null) {
            this.c.a(context, list, th5Var);
        }
    }

    @Override // com.baidu.tieba.oh5
    public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
            this.c.h(context, str, list);
        }
    }

    @Override // com.baidu.tieba.oh5
    public void c(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull qh5 qh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, list, qh5Var) == null) {
            for (Long l : list) {
                qh5Var.a(l.longValue(), -1003, "", null);
            }
        }
    }

    @Override // com.baidu.tieba.oh5
    public void e(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull rh5 rh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, list, rh5Var) == null) {
            this.c.e(context, str, list, rh5Var);
        }
    }

    @Override // com.baidu.tieba.oh5
    public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull wh5 wh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, wh5Var}) == null) {
            wh5Var.onSendMessageResult(-1003, null);
        }
    }

    @Override // com.baidu.tieba.oh5
    public void f(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @NonNull vh5 vh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), vh5Var}) == null) {
            vh5Var.a(-1003, "", d);
        }
    }
}
