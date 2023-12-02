package com.baidu.tieba;

import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class lu4 {
    public static /* synthetic */ Interceptable $ic;
    public static final a b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, List<c>> a;

    /* loaded from: classes7.dex */
    public interface c {
        void a(String str);
    }

    /* loaded from: classes7.dex */
    public interface d extends c {
        String getKey();
    }

    /* loaded from: classes7.dex */
    public interface e extends d {
        TbWebView b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947955358, "Lcom/baidu/tieba/lu4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947955358, "Lcom/baidu/tieba/lu4;");
                return;
            }
        }
        b = new a(null);
    }

    public /* synthetic */ lu4(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final lu4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a() : (lu4) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
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

        @JvmStatic
        public final lu4 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.a.a();
            }
            return (lu4) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public static final lu4 b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-620661024, "Lcom/baidu/tieba/lu4$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-620661024, "Lcom/baidu/tieba/lu4$b;");
                    return;
                }
            }
            a = new b();
            b = new lu4(null);
        }

        public b() {
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

        public final lu4 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b;
            }
            return (lu4) invokeV.objValue;
        }
    }

    public lu4() {
        List<d> list;
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
        this.a = new HashMap();
        ku4 ku4Var = new ku4();
        tf1<d> tf1Var = ku4Var.a;
        if (tf1Var != null) {
            list = tf1Var.getList();
        } else {
            list = null;
        }
        if (!ListUtils.isEmpty(list)) {
            for (d inject : ku4Var.a.getList()) {
                Intrinsics.checkNotNullExpressionValue(inject, "inject");
                c(inject);
            }
        }
    }

    public final void b(WebView webView, String key, String data) {
        List<c> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, webView, key, data) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(data, "data");
            if (!TextUtils.isEmpty(key) && (list = this.a.get(key)) != null) {
                for (c cVar : list) {
                    if (cVar instanceof e) {
                        TbWebView b2 = ((e) cVar).b();
                        boolean z = true;
                        if ((b2 == null || !b2.u(webView)) ? false : false) {
                        }
                    }
                    cVar.a(data);
                }
            }
        }
    }

    public final void c(d listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            d(listener.getKey(), listener, false);
        }
    }

    public final void e(d listener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, listener) == null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            f(listener.getKey(), listener);
        }
    }

    public final void d(String str, c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, str, cVar, z) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        List<c> list = this.a.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.a.put(str, list);
        }
        list.add(cVar);
    }

    public final void f(String notifyKey, c listener) {
        List<c> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, notifyKey, listener) == null) {
            Intrinsics.checkNotNullParameter(notifyKey, "notifyKey");
            Intrinsics.checkNotNullParameter(listener, "listener");
            if (!TextUtils.isEmpty(notifyKey) && (list = this.a.get(notifyKey)) != null) {
                list.remove(listener);
            }
        }
    }
}
