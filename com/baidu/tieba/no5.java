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
public class no5 implements mo5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final mo5 c;

    @Override // com.baidu.tieba.mo5
    public void c(@NonNull Context context, long j, @Nullable ep5 ep5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), ep5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.mo5
    public void d(@NonNull Context context, long j, @NonNull wo5 wo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), wo5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.mo5
    public void g(@NonNull xo5 xo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, xo5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.mo5
    public void j(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull wo5 wo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, wo5Var}) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948009205, "Lcom/baidu/tieba/no5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948009205, "Lcom/baidu/tieba/no5;");
                return;
            }
        }
        d = new TreeSet<>(mo5.b);
    }

    public no5(@NonNull mo5 mo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mo5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = mo5Var;
    }

    @Override // com.baidu.tieba.mo5
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.c.a(j);
        }
    }

    @Override // com.baidu.tieba.mo5
    public void k(@NonNull xo5 xo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xo5Var) == null) {
            this.c.k(xo5Var);
        }
    }

    @Override // com.baidu.tieba.mo5
    public void b(@NonNull Context context, @NonNull String str, long j, @NonNull ChatMsg chatMsg, boolean z, @NonNull cp5 cp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, Long.valueOf(j), chatMsg, Boolean.valueOf(z), cp5Var}) == null) {
            this.c.b(context, str, j, chatMsg, z, cp5Var);
        }
    }

    @Override // com.baidu.tieba.mo5
    public void e(@NonNull Context context, boolean z, int i, @NonNull bp5 bp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i), bp5Var}) == null) {
            this.c.e(context, z, i, bp5Var);
        }
    }

    @Override // com.baidu.tieba.mo5
    public void i(@NonNull Context context, long j, @NonNull List<ChatMsg> list, @NonNull zo5 zo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), list, zo5Var}) == null) {
            this.c.i(context, j, list, zo5Var);
        }
    }

    @Override // com.baidu.tieba.mo5
    public void n(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull dp5 dp5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, Long.valueOf(j), chatMsg, dp5Var}) == null) {
            dp5Var.onSendMessageResult(-1003, null);
        }
    }

    @Override // com.baidu.tieba.mo5
    public void f(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull wo5 wo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, wo5Var}) == null) {
            this.c.f(context, i, j, list, wo5Var);
        }
    }

    @Override // com.baidu.tieba.mo5
    public void m(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull vo5 vo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, vo5Var}) == null) {
            vo5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.mo5
    public void q(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull vo5 vo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, vo5Var}) == null) {
            vo5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.mo5
    public void h(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable q95<List<? extends ChatMsg>> q95Var, @NonNull ap5 ap5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), q95Var, ap5Var}) == null) {
            ap5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.mo5
    public void l(@NonNull Context context, long j, @NonNull to5 to5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, Long.valueOf(j), to5Var}) == null) {
            to5Var.a(j, -1003, "", null);
        }
    }

    @Override // com.baidu.tieba.mo5
    public void o(@NonNull Context context, long j, @NonNull wo5 wo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{context, Long.valueOf(j), wo5Var}) == null) {
            this.c.o(context, j, wo5Var);
        }
    }

    @Override // com.baidu.tieba.mo5
    public void r(@NonNull Context context, long j, @NonNull uo5 uo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{context, Long.valueOf(j), uo5Var}) == null) {
            this.c.r(context, j, uo5Var);
        }
    }

    @Override // com.baidu.tieba.mo5
    public void p(@NonNull Context context, long j, long j2, @NonNull String str, long j3, int i, @NonNull yo5 yo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), str, Long.valueOf(j3), Integer.valueOf(i), yo5Var}) == null) {
            this.c.p(context, j, j2, str, j3, i, yo5Var);
        }
    }
}
