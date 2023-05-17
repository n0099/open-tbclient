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
/* loaded from: classes6.dex */
public class kj5 implements jj5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final jj5 c;

    @Override // com.baidu.tieba.jj5
    public void c(@NonNull Context context, @NonNull List<Long> list, @NonNull tj5 tj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, list, tj5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.jj5
    public void e(@NonNull uj5 uj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, uj5Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947915027, "Lcom/baidu/tieba/kj5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947915027, "Lcom/baidu/tieba/kj5;");
                return;
            }
        }
        d = new TreeSet<>(jj5.b);
    }

    public kj5(@NonNull jj5 jj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jj5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = jj5Var;
    }

    @Override // com.baidu.tieba.jj5
    public void g(@NonNull uj5 uj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, uj5Var) == null) {
            this.c.g(uj5Var);
        }
    }

    @Override // com.baidu.tieba.jj5
    public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull tj5 tj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, tj5Var) == null) {
            this.c.a(context, list, tj5Var);
        }
    }

    @Override // com.baidu.tieba.jj5
    public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
            this.c.h(context, str, list);
        }
    }

    @Override // com.baidu.tieba.jj5
    public void b(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable wj5 wj5Var, @NonNull vj5 vj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), wj5Var, vj5Var}) == null) {
            vj5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.jj5
    public void d(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull qj5 qj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, str, list, qj5Var) == null) {
            for (Long l : list) {
                qj5Var.a(l.longValue(), -1003, "", null);
            }
        }
    }

    @Override // com.baidu.tieba.jj5
    public void f(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull rj5 rj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, context, str, list, rj5Var) == null) {
            this.c.f(context, str, list, rj5Var);
        }
    }

    @Override // com.baidu.tieba.jj5
    public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull xj5 xj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, xj5Var}) == null) {
            xj5Var.onSendMessageResult(-1003, null);
        }
    }
}
