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
/* loaded from: classes6.dex */
public class rb5 implements qb5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final qb5 c;

    @Override // com.baidu.tieba.qb5
    public void b(@NonNull Context context, @NonNull List<Long> list, @NonNull vb5 vb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, list, vb5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.qb5
    public void d(@NonNull wb5 wb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wb5Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948115876, "Lcom/baidu/tieba/rb5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948115876, "Lcom/baidu/tieba/rb5;");
                return;
            }
        }
        d = new TreeSet<>(qb5.b);
    }

    public rb5(@NonNull qb5 qb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qb5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = qb5Var;
    }

    @Override // com.baidu.tieba.qb5
    public void g(@NonNull wb5 wb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, wb5Var) == null) {
            this.c.g(wb5Var);
        }
    }

    @Override // com.baidu.tieba.qb5
    public void a(@NonNull Context context, @NonNull List<Long> list, @NonNull vb5 vb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, list, vb5Var) == null) {
            this.c.a(context, list, vb5Var);
        }
    }

    @Override // com.baidu.tieba.qb5
    public void h(@NonNull Context context, @NonNull String str, @NonNull List<Long> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, str, list) == null) {
            this.c.h(context, str, list);
        }
    }

    @Override // com.baidu.tieba.qb5
    public void c(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull sb5 sb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, str, list, sb5Var) == null) {
            for (Long l : list) {
                sb5Var.a(l.longValue(), -1003, "", null);
            }
        }
    }

    @Override // com.baidu.tieba.qb5
    public void e(@NonNull Context context, @NonNull String str, @NonNull List<Long> list, @NonNull tb5 tb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, list, tb5Var) == null) {
            this.c.e(context, str, list, tb5Var);
        }
    }

    @Override // com.baidu.tieba.qb5
    public void i(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull yb5 yb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), chatMsg, yb5Var}) == null) {
            yb5Var.onSendMessageResult(-1003, null);
        }
    }

    @Override // com.baidu.tieba.qb5
    public void f(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @NonNull xb5 xb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), xb5Var}) == null) {
            xb5Var.a(-1003, "", d);
        }
    }
}
