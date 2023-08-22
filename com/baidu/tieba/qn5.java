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
public class qn5 implements pn5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final pn5 c;

    @Override // com.baidu.tieba.pn5
    public void c(@NonNull Context context, long j, @Nullable ho5 ho5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), ho5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.pn5
    public void d(@NonNull Context context, long j, @NonNull zn5 zn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), zn5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.pn5
    public void g(@NonNull ao5 ao5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, ao5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.pn5
    public void j(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull zn5 zn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, zn5Var}) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948097617, "Lcom/baidu/tieba/qn5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948097617, "Lcom/baidu/tieba/qn5;");
                return;
            }
        }
        d = new TreeSet<>(pn5.b);
    }

    public qn5(@NonNull pn5 pn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pn5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = pn5Var;
    }

    @Override // com.baidu.tieba.pn5
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.c.a(j);
        }
    }

    @Override // com.baidu.tieba.pn5
    public void k(@NonNull ao5 ao5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ao5Var) == null) {
            this.c.k(ao5Var);
        }
    }

    @Override // com.baidu.tieba.pn5
    public void b(@NonNull Context context, @NonNull String str, long j, @NonNull ChatMsg chatMsg, boolean z, @NonNull fo5 fo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, Long.valueOf(j), chatMsg, Boolean.valueOf(z), fo5Var}) == null) {
            this.c.b(context, str, j, chatMsg, z, fo5Var);
        }
    }

    @Override // com.baidu.tieba.pn5
    public void e(@NonNull Context context, boolean z, int i, @NonNull eo5 eo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), eo5Var}) == null) {
            this.c.e(context, z, i, eo5Var);
        }
    }

    @Override // com.baidu.tieba.pn5
    public void i(@NonNull Context context, long j, @NonNull List<ChatMsg> list, @NonNull co5 co5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), list, co5Var}) == null) {
            this.c.i(context, j, list, co5Var);
        }
    }

    @Override // com.baidu.tieba.pn5
    public void n(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull go5 go5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, Long.valueOf(j), chatMsg, go5Var}) == null) {
            go5Var.onSendMessageResult(-1003, null);
        }
    }

    @Override // com.baidu.tieba.pn5
    public void f(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull zn5 zn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, zn5Var}) == null) {
            this.c.f(context, i, j, list, zn5Var);
        }
    }

    @Override // com.baidu.tieba.pn5
    public void m(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull yn5 yn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, yn5Var}) == null) {
            yn5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.pn5
    public void q(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull yn5 yn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, yn5Var}) == null) {
            yn5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.pn5
    public void h(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable d95<List<? extends ChatMsg>> d95Var, @NonNull do5 do5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), d95Var, do5Var}) == null) {
            do5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.pn5
    public void l(@NonNull Context context, long j, @NonNull wn5 wn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, Long.valueOf(j), wn5Var}) == null) {
            wn5Var.a(j, -1003, "", null);
        }
    }

    @Override // com.baidu.tieba.pn5
    public void o(@NonNull Context context, long j, @NonNull zn5 zn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Long.valueOf(j), zn5Var}) == null) {
            this.c.o(context, j, zn5Var);
        }
    }

    @Override // com.baidu.tieba.pn5
    public void r(@NonNull Context context, long j, @NonNull xn5 xn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, Long.valueOf(j), xn5Var}) == null) {
            this.c.r(context, j, xn5Var);
        }
    }

    @Override // com.baidu.tieba.pn5
    public void p(@NonNull Context context, long j, long j2, @NonNull String str, long j3, int i, @NonNull bo5 bo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i), bo5Var}) == null) {
            this.c.p(context, j, j2, str, j3, i, bo5Var);
        }
    }
}
