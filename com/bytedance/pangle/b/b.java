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
/* loaded from: classes11.dex */
public class b {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f61243b = "request_finish";

    /* renamed from: c  reason: collision with root package name */
    public static String f61244c = "download_start";

    /* renamed from: d  reason: collision with root package name */
    public static String f61245d = "download_finish";

    /* renamed from: e  reason: collision with root package name */
    public static String f61246e = "install_start";

    /* renamed from: f  reason: collision with root package name */
    public static String f61247f = "install_finish";

    /* renamed from: g  reason: collision with root package name */
    public static String f61248g = "load_start";

    /* renamed from: h  reason: collision with root package name */
    public static String f61249h = "load_finish";

    /* renamed from: i  reason: collision with root package name */
    public static String f61250i = "zeus_error";
    public static volatile b j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<com.bytedance.pangle.b.a> f61251a;

    /* loaded from: classes11.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;

        /* renamed from: a  reason: collision with root package name */
        public static int f61252a = 11000;

        /* renamed from: b  reason: collision with root package name */
        public static int f61253b = 12000;

        /* renamed from: c  reason: collision with root package name */
        public static int f61254c = 12001;

        /* renamed from: d  reason: collision with root package name */
        public static int f61255d = 20000;

        /* renamed from: e  reason: collision with root package name */
        public static int f61256e = 21000;

        /* renamed from: f  reason: collision with root package name */
        public static int f61257f = 21001;

        /* renamed from: g  reason: collision with root package name */
        public static int f61258g = 21002;

        /* renamed from: h  reason: collision with root package name */
        public static int f61259h = 22000;

        /* renamed from: i  reason: collision with root package name */
        public static int f61260i = 22001;
        public static int j = 22002;
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
        this.f61251a = new ArrayList();
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (j == null) {
                synchronized (b.class) {
                    j = new b();
                }
            }
            return j;
        }
        return (b) invokeV.objValue;
    }

    public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, jSONObject, jSONObject2, jSONObject3) == null) {
            synchronized (this.f61251a) {
                for (com.bytedance.pangle.b.a aVar : this.f61251a) {
                    aVar.a(str, jSONObject, jSONObject2, jSONObject3);
                }
            }
        }
    }
}
