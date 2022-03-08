package com.bytedance.pangle.b;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f51583b = "request_finish";

    /* renamed from: c  reason: collision with root package name */
    public static String f51584c = "download_start";

    /* renamed from: d  reason: collision with root package name */
    public static String f51585d = "download_finish";

    /* renamed from: e  reason: collision with root package name */
    public static String f51586e = "install_start";

    /* renamed from: f  reason: collision with root package name */
    public static String f51587f = "install_finish";

    /* renamed from: g  reason: collision with root package name */
    public static String f51588g = "load_start";

    /* renamed from: h  reason: collision with root package name */
    public static String f51589h = "load_finish";

    /* renamed from: i  reason: collision with root package name */
    public static String f51590i = "zeus_error";

    /* renamed from: j  reason: collision with root package name */
    public static volatile b f51591j;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<com.bytedance.pangle.b.a> a;

    /* loaded from: classes7.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = 11000;

        /* renamed from: b  reason: collision with root package name */
        public static int f51592b = 12000;

        /* renamed from: c  reason: collision with root package name */
        public static int f51593c = 12001;

        /* renamed from: d  reason: collision with root package name */
        public static int f51594d = 20000;

        /* renamed from: e  reason: collision with root package name */
        public static int f51595e = 21000;

        /* renamed from: f  reason: collision with root package name */
        public static int f51596f = 21001;

        /* renamed from: g  reason: collision with root package name */
        public static int f51597g = 21002;

        /* renamed from: h  reason: collision with root package name */
        public static int f51598h = 22000;

        /* renamed from: i  reason: collision with root package name */
        public static int f51599i = 22001;

        /* renamed from: j  reason: collision with root package name */
        public static int f51600j = 22002;
        public static int k = 22999;
        public static int l = 30000;
        public static int m = 31000;
        public static int n = 32000;
        public static int o = 32001;
        public static int p = 32002;
        public static int q = 32003;
        public static int r = 32004;
        public static int s = 32005;
        public static int t = 32006;
        public static int u = 32007;
        public static int v = 32999;
        public static int w = 40000;
        public static int x = 41000;
        public static int y = 42000;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(684196983, "Lcom/bytedance/pangle/b/b$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(684196983, "Lcom/bytedance/pangle/b/b$a;");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-294259756, "Lcom/bytedance/pangle/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-294259756, "Lcom/bytedance/pangle/b/b;");
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f51591j == null) {
                synchronized (b.class) {
                    f51591j = new b();
                }
            }
            return f51591j;
        }
        return (b) invokeV.objValue;
    }

    public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, jSONObject, jSONObject2, jSONObject3) == null) {
            synchronized (this.a) {
                for (com.bytedance.pangle.b.a aVar : this.a) {
                    aVar.a(str, jSONObject, jSONObject2, jSONObject3);
                }
            }
        }
    }
}
