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
public abstract class pu8<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final av8<T> a;
    public Function2<? super View, ? super av8<T>, Unit> b;
    public Function2<? super View, ? super av8<T>, Unit> c;

    public pu8(av8<T> data) {
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

    public boolean f(pu8<?> other) {
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

    public final av8<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (av8) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super com.baidu.tieba.av8<T>, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, com.baidu.tieba.av8<T>, kotlin.Unit> */
    public final Function2<View, av8<T>, Unit> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (Function2<? super View, ? super av8<T>, Unit>) this.b;
        }
        return (Function2) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super com.baidu.tieba.av8<T>, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, com.baidu.tieba.av8<T>, kotlin.Unit> */
    public final Function2<View, av8<T>, Unit> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (Function2<? super View, ? super av8<T>, Unit>) this.c;
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
        pu8 pu8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            av8<T> av8Var = (av8<T>) false;
            if (obj instanceof pu8) {
                pu8Var = (pu8) obj;
            } else {
                pu8Var = null;
            }
            if (this instanceof ru8) {
                String a = ((ru8) this).c().g().a();
                ?? r1 = av8Var;
                if (pu8Var != null) {
                    av8<T> av8Var2 = pu8Var.a;
                    r1 = av8Var;
                    if (av8Var2 != null) {
                        zu8 g = av8Var2.g();
                        r1 = av8Var;
                        if (g != null) {
                            r1 = (av8<T>) g.a();
                        }
                    }
                }
                return TextUtils.equals(a, r1);
            }
            av8<T> av8Var3 = this.a;
            av8<T> av8Var4 = av8Var;
            if (pu8Var != null) {
                av8Var4 = pu8Var.a;
            }
            return Objects.equals(av8Var3, av8Var4);
        }
        return invokeL.booleanValue;
    }

    public final void g(Function2<? super View, ? super av8<T>, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, function2) == null) {
            this.b = function2;
        }
    }

    public final void h(Function2<? super View, ? super av8<T>, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, function2) == null) {
            this.c = function2;
        }
    }
}
