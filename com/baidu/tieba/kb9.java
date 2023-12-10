package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class kb9<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final vb9<T> a;
    public Function2<? super View, ? super vb9<T>, Unit> b;
    public Function2<? super View, ? super vb9<T>, Unit> c;

    public kb9(vb9<T> data) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {data};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.a = data;
    }

    public boolean f(kb9<?> other) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, other)) == null) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (this.a.e().c() != 2 && other.a.e().c() != 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final vb9<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (vb9) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super com.baidu.tieba.vb9<T>, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, com.baidu.tieba.vb9<T>, kotlin.Unit> */
    public final Function2<View, vb9<T>, Unit> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (Function2<? super View, ? super vb9<T>, Unit>) this.b;
        }
        return (Function2) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super com.baidu.tieba.vb9<T>, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, com.baidu.tieba.vb9<T>, kotlin.Unit> */
    public final Function2<View, vb9<T>, Unit> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (Function2<? super View, ? super vb9<T>, Unit>) this.c;
        }
        return (Function2) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return Objects.hashCode(this.a);
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        kb9 kb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            vb9<T> vb9Var = (vb9<T>) false;
            if (obj instanceof kb9) {
                kb9Var = (kb9) obj;
            } else {
                kb9Var = null;
            }
            if (this instanceof mb9) {
                String b = ((mb9) this).c().g().b();
                ?? r1 = vb9Var;
                if (kb9Var != null) {
                    vb9<T> vb9Var2 = kb9Var.a;
                    r1 = vb9Var;
                    if (vb9Var2 != null) {
                        ub9 g = vb9Var2.g();
                        r1 = vb9Var;
                        if (g != null) {
                            r1 = (vb9<T>) g.b();
                        }
                    }
                }
                return TextUtils.equals(b, r1);
            }
            vb9<T> vb9Var3 = this.a;
            vb9<T> vb9Var4 = vb9Var;
            if (kb9Var != null) {
                vb9Var4 = kb9Var.a;
            }
            return Objects.equals(vb9Var3, vb9Var4);
        }
        return invokeL.booleanValue;
    }

    public final void g(Function2<? super View, ? super vb9<T>, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, function2) == null) {
            this.b = function2;
        }
    }

    public final void h(Function2<? super View, ? super vb9<T>, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, function2) == null) {
            this.c = function2;
        }
    }
}
