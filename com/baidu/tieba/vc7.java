package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class vc7 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948236063, "Lcom/baidu/tieba/vc7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948236063, "Lcom/baidu/tieba/vc7;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final void a(w97 w97Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, w97Var) == null) && w97Var != null) {
                w97Var.a().a(w97Var.b());
                String c = w97Var.c();
                if (c != null && c.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(w97Var.c());
                for (Map.Entry<String, String> entry : w97Var.b().entrySet()) {
                    statisticItem.param(entry.getKey(), entry.getValue());
                }
                for (Map.Entry<String, String> entry2 : w97Var.d().entrySet()) {
                    statisticItem.param(entry2.getKey(), entry2.getValue());
                }
                TiebaStatic.log(statisticItem);
            }
        }

        public final void b(w97 statData, int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, statData, i) == null) {
                Intrinsics.checkNotNullParameter(statData, "statData");
                if (statData.e().length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && (statData.b() instanceof HashMap)) {
                    ((HashMap) statData.b()).put(statData.e(), String.valueOf(i));
                }
            }
        }
    }
}
