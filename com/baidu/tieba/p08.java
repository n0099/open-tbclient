package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.q18;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class p08 {
    public static /* synthetic */ Interceptable $ic;
    public static final p08 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948008337, "Lcom/baidu/tieba/p08;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948008337, "Lcom/baidu/tieba/p08;");
                return;
            }
        }
        a = new p08();
    }

    public p08() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final qs6<?> a(k08<?> k08Var, q18.e eVar, boolean z, Function2<? super View, ? super k08<?>, Unit> function2) {
        InterceptResult invokeCommon;
        String str;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{k08Var, eVar, Boolean.valueOf(z), function2})) == null) {
            Object f = k08Var.f();
            Class<?> cls = null;
            if (f instanceof l08) {
                if (k08Var.e().d()) {
                    str = "text_right";
                } else {
                    str = "text_left";
                }
                g08 g08Var = new g08(k08Var, str);
                if (eVar.getType() == 3 && z && !k08Var.e().d()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                g08Var.i(z2);
                g08Var.f(function2);
                return g08Var;
            } else if (f instanceof i08) {
                return new f08(k08Var, "loading_left");
            } else {
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    return null;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("unknown msg content ");
                Object f2 = k08Var.f();
                if (f2 != null) {
                    cls = f2.getClass();
                }
                sb.append(cls);
                throw new IllegalStateException(sb.toString());
            }
        }
        return (qs6) invokeCommon.objValue;
    }

    public final List<qs6<?>> b(List<? extends h08> list, q18.e loadType, Function2<? super View, ? super k08<?>, Unit> resendClick) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, loadType, resendClick)) == null) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            Intrinsics.checkNotNullParameter(resendClick, "resendClick");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                h08 h08Var = (h08) obj;
                if (h08Var instanceof k08) {
                    p08 p08Var = a;
                    k08<?> k08Var = (k08) h08Var;
                    boolean z = true;
                    if (i != list.size() - 1) {
                        z = false;
                    }
                    qs6<?> a2 = p08Var.a(k08Var, loadType, z, resendClick);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new IllegalStateException("unknown msg template " + h08Var.getClass());
                }
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
