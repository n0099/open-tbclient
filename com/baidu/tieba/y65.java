package com.baidu.tieba;

import android.text.Editable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupForegroundColorSpan;
import com.baidu.tieba.y65;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class y65<T extends y65> {
    public static /* synthetic */ Interceptable $ic = null;
    public static int h = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public boolean b;
    public Editable c;
    public int d;
    public int e;
    public int f;
    public a g;

    /* loaded from: classes7.dex */
    public interface a {
        void e(int i, boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948282129, "Lcom/baidu/tieba/y65;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948282129, "Lcom/baidu/tieba/y65;");
        }
    }

    public abstract void r(Editable editable);

    public abstract void s(Editable editable, int i);

    public y65() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int i3 = h;
        h = i3 + 1;
        this.a = i3;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public Editable g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (Editable) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Editable editable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) || (editable = this.c) == null) {
            return;
        }
        for (SpanGroupForegroundColorSpan spanGroupForegroundColorSpan : (SpanGroupForegroundColorSpan[]) editable.getSpans(this.d, this.e, SpanGroupForegroundColorSpan.class)) {
            this.c.removeSpan(spanGroupForegroundColorSpan);
        }
    }

    public void j() {
        Editable editable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || (editable = this.c) == null) {
            return;
        }
        for (EMRichTextAnyIconSpan eMRichTextAnyIconSpan : (EMRichTextAnyIconSpan[]) editable.getSpans(this.d, this.e, EMRichTextAnyIconSpan.class)) {
            this.c.removeSpan(eMRichTextAnyIconSpan);
        }
    }

    public void a(Editable editable, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, editable, i, i2, i3) == null) {
            this.c = editable;
            this.d = i;
            this.e = i2;
            this.f = i3;
        }
    }

    public void n(Object obj, int i, int i2, int i3) {
        Editable editable;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(1048589, this, obj, i, i2, i3) != null) || (editable = this.c) == null) {
            return;
        }
        editable.setSpan(obj, i, i2, i3);
    }

    public void b(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) {
            this.b = t.h();
            this.c = t.g();
            this.d = t.f();
            this.e = t.c();
            this.f = t.d();
        }
    }

    public void k(@NonNull CharSequence charSequence) {
        Editable editable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, charSequence) == null) && (editable = this.c) != null && charSequence != null) {
            try {
                editable.replace(this.d, this.e, charSequence);
            } catch (Exception e) {
                BdLog.e(e);
            }
            this.e = this.d + charSequence.length();
        }
    }

    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.e = i;
        }
    }

    public void m(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.g = aVar;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.d = i;
        }
    }

    public void p(Editable editable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, editable) == null) {
            this.c = editable;
        }
    }

    public void q(boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            boolean z2 = this.b;
            this.b = z;
            if (z2 != z && (aVar = this.g) != null) {
                aVar.e(this.a, z);
            }
        }
    }
}
