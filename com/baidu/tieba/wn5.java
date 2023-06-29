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
public class wn5 implements vn5 {
    public static /* synthetic */ Interceptable $ic;
    public static final TreeSet<ChatMsg> d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final vn5 c;

    @Override // com.baidu.tieba.vn5
    public void c(@NonNull Context context, long j, @Nullable ko5 ko5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, Long.valueOf(j), ko5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.vn5
    public void d(@NonNull Context context, long j, @NonNull fo5 fo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, Long.valueOf(j), fo5Var}) == null) {
        }
    }

    @Override // com.baidu.tieba.vn5
    public void f(@NonNull go5 go5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, go5Var) == null) {
        }
    }

    @Override // com.baidu.tieba.vn5
    public void g(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull fo5 fo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, fo5Var}) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948276363, "Lcom/baidu/tieba/wn5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948276363, "Lcom/baidu/tieba/wn5;");
                return;
            }
        }
        d = new TreeSet<>(vn5.b);
    }

    public wn5(@NonNull vn5 vn5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vn5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = vn5Var;
    }

    @Override // com.baidu.tieba.vn5
    public void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.c.b(j);
        }
    }

    @Override // com.baidu.tieba.vn5
    public void h(@NonNull go5 go5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, go5Var) == null) {
            this.c.h(go5Var);
        }
    }

    @Override // com.baidu.tieba.vn5
    public void a(@NonNull Context context, long j, long j2, int i, boolean z, boolean z2, @Nullable io5 io5Var, @NonNull ho5 ho5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{context, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), io5Var, ho5Var}) == null) {
            ho5Var.a(-1003, "", d);
        }
    }

    @Override // com.baidu.tieba.vn5
    public void e(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull fo5 fo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, fo5Var}) == null) {
            this.c.e(context, i, j, list, fo5Var);
        }
    }

    @Override // com.baidu.tieba.vn5
    public void j(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull eo5 eo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, eo5Var}) == null) {
            eo5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.vn5
    public void m(@NonNull Context context, int i, long j, @NonNull List<Long> list, @NonNull eo5 eo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{context, Integer.valueOf(i), Long.valueOf(j), list, eo5Var}) == null) {
            eo5Var.a(i, j, list, -1003, "");
        }
    }

    @Override // com.baidu.tieba.vn5
    public void i(@NonNull Context context, long j, @NonNull co5 co5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, Long.valueOf(j), co5Var}) == null) {
            co5Var.a(j, -1003, "", null);
        }
    }

    @Override // com.baidu.tieba.vn5
    public void l(@NonNull Context context, long j, @NonNull fo5 fo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{context, Long.valueOf(j), fo5Var}) == null) {
            this.c.l(context, j, fo5Var);
        }
    }

    @Override // com.baidu.tieba.vn5
    public void n(@NonNull Context context, long j, @NonNull do5 do5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{context, Long.valueOf(j), do5Var}) == null) {
            this.c.n(context, j, do5Var);
        }
    }

    @Override // com.baidu.tieba.vn5
    public void k(@NonNull Context context, long j, @NonNull ChatMsg chatMsg, @NonNull jo5 jo5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{context, Long.valueOf(j), chatMsg, jo5Var}) == null) {
            jo5Var.onSendMessageResult(-1003, null);
        }
    }
}
