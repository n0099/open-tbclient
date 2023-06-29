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
public abstract class qp8<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final bq8<T> a;
    public Function2<? super View, ? super bq8<T>, Unit> b;
    public Function2<? super View, ? super bq8<T>, Unit> c;

    public qp8(bq8<T> data) {
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

    public boolean f(qp8<?> other) {
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

    public final bq8<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (bq8) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super com.baidu.tieba.bq8<T>, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, com.baidu.tieba.bq8<T>, kotlin.Unit> */
    public final Function2<View, bq8<T>, Unit> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (Function2<? super View, ? super bq8<T>, Unit>) this.b;
        }
        return (Function2) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.view.View, ? super com.baidu.tieba.bq8<T>, kotlin.Unit>, kotlin.jvm.functions.Function2<android.view.View, com.baidu.tieba.bq8<T>, kotlin.Unit> */
    public final Function2<View, bq8<T>, Unit> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (Function2<? super View, ? super bq8<T>, Unit>) this.c;
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
        qp8 qp8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            bq8<T> bq8Var = (bq8<T>) false;
            if (obj instanceof qp8) {
                qp8Var = (qp8) obj;
            } else {
                qp8Var = null;
            }
            if (this instanceof sp8) {
                String a = ((sp8) this).c().g().a();
                ?? r1 = bq8Var;
                if (qp8Var != null) {
                    bq8<T> bq8Var2 = qp8Var.a;
                    r1 = bq8Var;
                    if (bq8Var2 != null) {
                        aq8 g = bq8Var2.g();
                        r1 = bq8Var;
                        if (g != null) {
                            r1 = (bq8<T>) g.a();
                        }
                    }
                }
                return TextUtils.equals(a, r1);
            }
            bq8<T> bq8Var3 = this.a;
            bq8<T> bq8Var4 = bq8Var;
            if (qp8Var != null) {
                bq8Var4 = qp8Var.a;
            }
            return Objects.equals(bq8Var3, bq8Var4);
        }
        return invokeL.booleanValue;
    }

    public final void g(Function2<? super View, ? super bq8<T>, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, function2) == null) {
            this.b = function2;
        }
    }

    public final void h(Function2<? super View, ? super bq8<T>, Unit> function2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, function2) == null) {
            this.c = function2;
        }
    }
}
