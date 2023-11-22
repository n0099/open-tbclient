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
public class jk5 implements ik5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final ik5 c;

    @Override // com.baidu.tieba.ik5
    public void c(@NonNull Context context, long j, @Nullable al5 al5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), al5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.ik5
    public void d(@NonNull Context context, long j, @NonNull sk5 sk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), sk5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.ik5
    public void g(@NonNull tk5 tk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, tk5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.ik5
    public void j(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull sk5 sk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, sk5Var}) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947886197, "Lcom/baidu/tieba/jk5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947886197, "Lcom/baidu/tieba/jk5;");
                return;
            }
        }
        d = new TreeSet<>(ik5.b);
    }

    public jk5(@NonNull ik5 ik5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ik5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = ik5Var;
    }

    @Override // com.baidu.tieba.ik5
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.c.a(j);
        }
    }

    @Override // com.baidu.tieba.ik5
    public void k(@NonNull tk5 tk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tk5Var) == null) {
            this.c.k(tk5Var);
        }
    }

    @Override // com.baidu.tieba.ik5
    public void b(@NonNull Context context, @NonNull String str, long j, @NonNull ChatMsg chatMsg, boolean z, @NonNull yk5 yk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, Long.valueOf(j), chatMsg, Boolean.valueOf(z), yk5Var}) == null) {
            this.c.b(context, str, j, chatMsg, z, yk5Var);
        }
    }

    @Override // com.baidu.tieba.ik5
    public void e(@NonNull Context context, boolean z, int i, @NonNull xk5 xk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), xk5Var}) == null) {
            this.c.e(context, z, i, xk5Var);
        }
    }

    @Override // com.baidu.tieba.ik5
    public void i(@NonNull Context context, long j, @NonNull List<ChatMsg> list, @NonNull vk5 vk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), list, vk5Var}) == null) {
            this.c.i(context, j, list, vk5Var);
        }
    }

    @Override // com.baidu.tieba.ik5
    public void n(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull zk5 zk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, Long.valueOf(j), chatMsg, zk5Var}) == null) {
            zk5Var.onSendMessageResult(-1003, null);
        }
    }

    @Override // com.baidu.tieba.ik5
    public void f(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull sk5 sk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, sk5Var}) == null) {
            this.c.f(context, i, j, list, sk5Var);
        }
    }

    @Override // com.baidu.tieba.ik5
    public void m(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull rk5 rk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, rk5Var}) == null) {
            rk5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.ik5
    public void q(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull rk5 rk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, rk5Var}) == null) {
            rk5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.ik5
    public void h(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable t45<List<? extends ChatMsg>> t45Var, @NonNull wk5 wk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), t45Var, wk5Var}) == null) {
            wk5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.ik5
    public void l(@NonNull Context context, long j, @NonNull pk5 pk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, Long.valueOf(j), pk5Var}) == null) {
            pk5Var.a(j, -1003, "", null);
        }
    }

    @Override // com.baidu.tieba.ik5
    public void o(@NonNull Context context, long j, @NonNull sk5 sk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Long.valueOf(j), sk5Var}) == null) {
            this.c.o(context, j, sk5Var);
        }
    }

    @Override // com.baidu.tieba.ik5
    public void r(@NonNull Context context, long j, @NonNull qk5 qk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, Long.valueOf(j), qk5Var}) == null) {
            this.c.r(context, j, qk5Var);
        }
    }

    @Override // com.baidu.tieba.ik5
    public void p(@NonNull Context context, long j, long j2, @NonNull String str, long j3, int i, @NonNull uk5 uk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i), uk5Var}) == null) {
            this.c.p(context, j, j2, str, j3, i, uk5Var);
        }
    }
}
