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
/* loaded from: classes8.dex */
public class tk5 implements sk5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final sk5 c;

    @Override // com.baidu.tieba.sk5
    public void c(@NonNull Context context, long j, @Nullable kl5 kl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), kl5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.sk5
    public void d(@NonNull Context context, long j, @NonNull cl5 cl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), cl5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.sk5
    public void g(@NonNull dl5 dl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dl5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.sk5
    public void j(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull cl5 cl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, cl5Var}) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948184107, "Lcom/baidu/tieba/tk5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948184107, "Lcom/baidu/tieba/tk5;");
                return;
            }
        }
        d = new TreeSet<>(sk5.b);
    }

    public tk5(@NonNull sk5 sk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sk5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = sk5Var;
    }

    @Override // com.baidu.tieba.sk5
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.c.a(j);
        }
    }

    @Override // com.baidu.tieba.sk5
    public void k(@NonNull dl5 dl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dl5Var) == null) {
            this.c.k(dl5Var);
        }
    }

    @Override // com.baidu.tieba.sk5
    public void b(@NonNull Context context, @NonNull String str, long j, @NonNull ChatMsg chatMsg, boolean z, @NonNull il5 il5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, Long.valueOf(j), chatMsg, Boolean.valueOf(z), il5Var}) == null) {
            this.c.b(context, str, j, chatMsg, z, il5Var);
        }
    }

    @Override // com.baidu.tieba.sk5
    public void e(@NonNull Context context, boolean z, int i, @NonNull hl5 hl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), hl5Var}) == null) {
            this.c.e(context, z, i, hl5Var);
        }
    }

    @Override // com.baidu.tieba.sk5
    public void i(@NonNull Context context, long j, @NonNull List<ChatMsg> list, @NonNull fl5 fl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), list, fl5Var}) == null) {
            this.c.i(context, j, list, fl5Var);
        }
    }

    @Override // com.baidu.tieba.sk5
    public void n(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull jl5 jl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, Long.valueOf(j), chatMsg, jl5Var}) == null) {
            jl5Var.onSendMessageResult(-1003, null);
        }
    }

    @Override // com.baidu.tieba.sk5
    public void f(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull cl5 cl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, cl5Var}) == null) {
            this.c.f(context, i, j, list, cl5Var);
        }
    }

    @Override // com.baidu.tieba.sk5
    public void m(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull bl5 bl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, bl5Var}) == null) {
            bl5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.sk5
    public void q(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull bl5 bl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, bl5Var}) == null) {
            bl5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.sk5
    public void h(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable b55<List<? extends ChatMsg>> b55Var, @NonNull gl5 gl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), b55Var, gl5Var}) == null) {
            gl5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.sk5
    public void l(@NonNull Context context, long j, @NonNull zk5 zk5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, Long.valueOf(j), zk5Var}) == null) {
            zk5Var.a(j, -1003, "", null);
        }
    }

    @Override // com.baidu.tieba.sk5
    public void o(@NonNull Context context, long j, @NonNull cl5 cl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Long.valueOf(j), cl5Var}) == null) {
            this.c.o(context, j, cl5Var);
        }
    }

    @Override // com.baidu.tieba.sk5
    public void r(@NonNull Context context, long j, @NonNull al5 al5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, Long.valueOf(j), al5Var}) == null) {
            this.c.r(context, j, al5Var);
        }
    }

    @Override // com.baidu.tieba.sk5
    public void p(@NonNull Context context, long j, long j2, @NonNull String str, long j3, int i, @NonNull el5 el5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i), el5Var}) == null) {
            this.c.p(context, j, j2, str, j3, i, el5Var);
        }
    }
}
