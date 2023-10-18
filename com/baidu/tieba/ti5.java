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
public class ti5 implements si5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final si5 c;

    @Override // com.baidu.tieba.si5
    public void c(@NonNull Context context, long j, @Nullable kj5 kj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), kj5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.si5
    public void d(@NonNull Context context, long j, @NonNull cj5 cj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), cj5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.si5
    public void g(@NonNull dj5 dj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dj5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.si5
    public void j(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull cj5 cj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, cj5Var}) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948182185, "Lcom/baidu/tieba/ti5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948182185, "Lcom/baidu/tieba/ti5;");
                return;
            }
        }
        d = new TreeSet<>(si5.b);
    }

    public ti5(@NonNull si5 si5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {si5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = si5Var;
    }

    @Override // com.baidu.tieba.si5
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.c.a(j);
        }
    }

    @Override // com.baidu.tieba.si5
    public void k(@NonNull dj5 dj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dj5Var) == null) {
            this.c.k(dj5Var);
        }
    }

    @Override // com.baidu.tieba.si5
    public void b(@NonNull Context context, @NonNull String str, long j, @NonNull ChatMsg chatMsg, boolean z, @NonNull ij5 ij5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, Long.valueOf(j), chatMsg, Boolean.valueOf(z), ij5Var}) == null) {
            this.c.b(context, str, j, chatMsg, z, ij5Var);
        }
    }

    @Override // com.baidu.tieba.si5
    public void e(@NonNull Context context, boolean z, int i, @NonNull hj5 hj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), hj5Var}) == null) {
            this.c.e(context, z, i, hj5Var);
        }
    }

    @Override // com.baidu.tieba.si5
    public void i(@NonNull Context context, long j, @NonNull List<ChatMsg> list, @NonNull fj5 fj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), list, fj5Var}) == null) {
            this.c.i(context, j, list, fj5Var);
        }
    }

    @Override // com.baidu.tieba.si5
    public void n(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull jj5 jj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, Long.valueOf(j), chatMsg, jj5Var}) == null) {
            jj5Var.onSendMessageResult(-1003, null);
        }
    }

    @Override // com.baidu.tieba.si5
    public void f(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull cj5 cj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, cj5Var}) == null) {
            this.c.f(context, i, j, list, cj5Var);
        }
    }

    @Override // com.baidu.tieba.si5
    public void m(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull bj5 bj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, bj5Var}) == null) {
            bj5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.si5
    public void q(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull bj5 bj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, bj5Var}) == null) {
            bj5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.si5
    public void h(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable y35<List<? extends ChatMsg>> y35Var, @NonNull gj5 gj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), y35Var, gj5Var}) == null) {
            gj5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.si5
    public void l(@NonNull Context context, long j, @NonNull zi5 zi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, Long.valueOf(j), zi5Var}) == null) {
            zi5Var.a(j, -1003, "", null);
        }
    }

    @Override // com.baidu.tieba.si5
    public void o(@NonNull Context context, long j, @NonNull cj5 cj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Long.valueOf(j), cj5Var}) == null) {
            this.c.o(context, j, cj5Var);
        }
    }

    @Override // com.baidu.tieba.si5
    public void r(@NonNull Context context, long j, @NonNull aj5 aj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, Long.valueOf(j), aj5Var}) == null) {
            this.c.r(context, j, aj5Var);
        }
    }

    @Override // com.baidu.tieba.si5
    public void p(@NonNull Context context, long j, long j2, @NonNull String str, long j3, int i, @NonNull ej5 ej5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i), ej5Var}) == null) {
            this.c.p(context, j, j2, str, j3, i, ej5Var);
        }
    }
}
