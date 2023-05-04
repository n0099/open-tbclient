package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.cd3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ni3 extends aw1 {
    public static /* synthetic */ Interceptable $ic;
    public static final qm3<xi3<wi3>> f;
    public static final qm3<xi3<List<wi3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.aw1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.aw1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements a33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ vi3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ni3 d;

        /* renamed from: com.baidu.tieba.ni3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0369a implements qm3<xi3<wi3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0369a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.qm3
            /* renamed from: b */
            public void a(xi3<wi3> xi3Var) {
                xz1 xz1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi3Var) == null) {
                    if (xi3Var.a != 0) {
                        x42.i("WifiApi", "connectWifi: " + xi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + xi3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (xi3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", xi3Var.c.n());
                        } catch (JSONException e) {
                            x42.i("WifiApi", "getConnectedWifi: " + xi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + xi3Var.b + ZeusCrashHandler.NAME_SEPERATOR + xi3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    ni3 ni3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        xz1Var = new xz1(xi3Var.a, xi3Var.b);
                    } else {
                        xz1Var = new xz1(xi3Var.a, xi3Var.b, jSONObject);
                    }
                    ni3Var.d(str, xz1Var);
                }
            }
        }

        public a(ni3 ni3Var, Activity activity, vi3 vi3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni3Var, activity, vi3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ni3Var;
            this.a = activity;
            this.b = vi3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.a33
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ui3.s(this.a).a(this.b, new C0369a(this));
            }
        }

        @Override // com.baidu.tieba.a33
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                x42.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new xz1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ni3 c;

        /* loaded from: classes5.dex */
        public class a implements qm3<xi3<Void>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.qm3
            /* renamed from: b */
            public void a(xi3<Void> xi3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi3Var) == null) {
                    if (xi3Var.a != 0) {
                        x42.i("WifiApi", "getWifiList: " + xi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + xi3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new xz1(xi3Var.a, xi3Var.b));
                }
            }
        }

        public g(ni3 ni3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ni3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.a33
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ui3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.a33
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                x42.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new xz1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements a33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ni3 c;

        /* loaded from: classes5.dex */
        public class a implements qm3<xi3<wi3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.qm3
            /* renamed from: b */
            public void a(xi3<wi3> xi3Var) {
                xz1 xz1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi3Var) == null) {
                    if (xi3Var.a != 0) {
                        x42.i("WifiApi", "getConnectedWifi: " + xi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + xi3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (xi3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", xi3Var.c.n());
                        } catch (JSONException e) {
                            x42.i("WifiApi", "getConnectedWifi: " + xi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + xi3Var.b + ZeusCrashHandler.NAME_SEPERATOR + xi3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    ni3 ni3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        xz1Var = new xz1(xi3Var.a, xi3Var.b);
                    } else {
                        xz1Var = new xz1(xi3Var.a, xi3Var.b, jSONObject);
                    }
                    ni3Var.d(str, xz1Var);
                }
            }
        }

        public i(ni3 ni3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ni3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.a33
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ui3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.a33
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                x42.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new xz1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements qm3<xi3<wi3>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(xi3<wi3> xi3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi3Var) == null) && xi3Var != null && xi3Var.a == 0 && xi3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", xi3Var.c);
                } catch (JSONException e) {
                    x42.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                kt2.U().u(new yh2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements qm3<xi3<List<wi3>>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(xi3<List<wi3>> xi3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi3Var) == null) && xi3Var != null && xi3Var.a == 0 && xi3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (wi3 wi3Var : xi3Var.c) {
                    jSONArray.put(wi3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    x42.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                kt2.U().u(new yh2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements qm3<xi3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ni3 b;

        public d(ni3 ni3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ni3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(xi3<Void> xi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi3Var) == null) {
                if (xi3Var.a != 0) {
                    x42.i("WifiApi", "startWifi: " + xi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + xi3Var.b);
                }
                this.b.d(this.a, new xz1(xi3Var.a, xi3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements qm3<xi3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ni3 b;

        public e(ni3 ni3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ni3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(xi3<Void> xi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xi3Var) == null) {
                if (xi3Var.a != 0) {
                    x42.i("WifiApi", "stopWifi: " + xi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + xi3Var.b);
                }
                this.b.d(this.a, new xz1(xi3Var.a, xi3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements qm3<ad3<cd3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ni3 b;

        public f(ni3 ni3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ni3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(ad3<cd3.e> ad3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ad3Var) == null) {
                if (vc3.h(ad3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = ad3Var.b();
                x42.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + vc3.f(b));
                this.b.d(this.a, new xz1(b, vc3.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements qm3<ad3<cd3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ni3 b;

        public h(ni3 ni3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ni3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(ad3<cd3.e> ad3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ad3Var) == null) {
                if (vc3.h(ad3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = ad3Var.b();
                x42.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + vc3.f(b));
                this.b.d(this.a, new xz1(b, vc3.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements qm3<ad3<cd3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ vi3 b;
        public final /* synthetic */ ni3 c;

        public j(ni3 ni3Var, String str, vi3 vi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ni3Var, str, vi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ni3Var;
            this.a = str;
            this.b = vi3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(ad3<cd3.e> ad3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ad3Var) == null) {
                if (!vc3.h(ad3Var)) {
                    int b = ad3Var.b();
                    x42.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + vc3.f(b));
                    this.c.d(this.a, new xz1(b, vc3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948003377, "Lcom/baidu/tieba/ni3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948003377, "Lcom/baidu/tieba/ni3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ni3(@NonNull yv1 yv1Var) {
        super(yv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((yv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, vi3 vi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, vi3Var) == null) {
            SwanAppActivity w = w73.K().w();
            z23.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, vi3Var, str));
        }
    }

    public xz1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            x73 b0 = x73.b0();
            if (b0 == null) {
                x42.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new xz1(1001, "swan app is null");
            } else if (b0.w() == null) {
                x42.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new xz1(1001, "swan activity is null");
            } else {
                Pair<xz1, JSONObject> s = s(str);
                xz1 xz1Var = (xz1) s.first;
                if (!xz1Var.isSuccess()) {
                    return xz1Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    x42.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new xz1(201, "callback is null");
                }
                vi3 a2 = vi3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    x42.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new xz1(12008, "invalid ssid");
                } else if (b0.n0()) {
                    x42.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new xz1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return xz1.f();
                }
            }
        }
        return (xz1) invokeL.objValue;
    }

    public xz1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            x73 b0 = x73.b0();
            if (b0 == null) {
                x42.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new xz1(1001, "swan app is null");
            } else if (b0.w() == null) {
                x42.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new xz1(1001, "swan activity is null");
            } else {
                Pair<xz1, JSONObject> s = s(str);
                xz1 xz1Var = (xz1) s.first;
                if (!xz1Var.isSuccess()) {
                    return xz1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    x42.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new xz1(201, "callback is null");
                } else if (b0.n0()) {
                    x42.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new xz1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return xz1.f();
                }
            }
        }
        return (xz1) invokeL.objValue;
    }

    public xz1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            x73 b0 = x73.b0();
            if (b0 == null) {
                x42.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new xz1(1001, "swan app is null");
            } else if (b0.w() == null) {
                x42.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new xz1(1001, "swan activity is null");
            } else {
                Pair<xz1, JSONObject> s = s(str);
                xz1 xz1Var = (xz1) s.first;
                if (!xz1Var.isSuccess()) {
                    return xz1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    x42.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new xz1(201, "callback is null");
                } else if (b0.n0()) {
                    x42.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new xz1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return xz1.f();
                }
            }
        }
        return (xz1) invokeL.objValue;
    }

    public xz1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            x73 b0 = x73.b0();
            if (b0 == null) {
                x42.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new xz1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                x42.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new xz1(1001, "swan activity is null");
            }
            Pair<xz1, JSONObject> s = s(str);
            xz1 xz1Var = (xz1) s.first;
            if (!xz1Var.isSuccess()) {
                return xz1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                x42.c("WifiApi", "startWifi: 201 : callback is null");
                return new xz1(201, "callback is null");
            }
            ui3 s2 = ui3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return xz1.f();
            }
            x42.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new xz1(12010, "unknown failed");
        }
        return (xz1) invokeL.objValue;
    }

    public xz1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            x73 b0 = x73.b0();
            if (b0 == null) {
                x42.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new xz1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                x42.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new xz1(1001, "swan activity is null");
            }
            Pair<xz1, JSONObject> s = s(str);
            xz1 xz1Var = (xz1) s.first;
            if (!xz1Var.isSuccess()) {
                return xz1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                x42.c("WifiApi", "stopWifi: 201 : callback is null");
                return new xz1(201, "callback is null");
            }
            ui3 s2 = ui3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return xz1.f();
            }
            x42.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new xz1(12010, "unknown failed");
        }
        return (xz1) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = w73.K().w();
            z23.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = w73.K().w();
            z23.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
