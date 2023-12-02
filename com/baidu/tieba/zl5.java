package com.baidu.tieba;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.module.imaibot.AibotArgs;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
/* loaded from: classes9.dex */
public interface zl5 {
    public static final a a = a.a;

    void a(Context context, String str, String str2, AibotArgs aibotArgs);

    void b(List<String> list, Function1<? super Boolean, Unit> function1);

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ a a;
        public static final ServiceReference b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-228134839, "Lcom/baidu/tieba/zl5$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-228134839, "Lcom/baidu/tieba/zl5$a;");
                    return;
                }
            }
            a = new a();
            b = new ServiceReference("aibot", "AibotChatService");
        }

        public a() {
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

        @JvmStatic
        public final zl5 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Object service = ServiceManager.getService(b);
                if (service != null) {
                    return (zl5) service;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            return (zl5) invokeV.objValue;
        }
    }
}
