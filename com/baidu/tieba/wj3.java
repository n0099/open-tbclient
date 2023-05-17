package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.le3;
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
/* loaded from: classes8.dex */
public class wj3 extends jx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final zn3<gk3<fk3>> f;
    public static final zn3<gk3<List<fk3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jx1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jx1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements j43 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ek3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ wj3 d;

        /* renamed from: com.baidu.tieba.wj3$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0486a implements zn3<gk3<fk3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0486a(a aVar) {
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
            @Override // com.baidu.tieba.zn3
            /* renamed from: b */
            public void a(gk3<fk3> gk3Var) {
                g12 g12Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gk3Var) == null) {
                    if (gk3Var.a != 0) {
                        g62.i("WifiApi", "connectWifi: " + gk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gk3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (gk3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", gk3Var.c.n());
                        } catch (JSONException e) {
                            g62.i("WifiApi", "getConnectedWifi: " + gk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gk3Var.b + ZeusCrashHandler.NAME_SEPERATOR + gk3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    wj3 wj3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        g12Var = new g12(gk3Var.a, gk3Var.b);
                    } else {
                        g12Var = new g12(gk3Var.a, gk3Var.b, jSONObject);
                    }
                    wj3Var.d(str, g12Var);
                }
            }
        }

        public a(wj3 wj3Var, Activity activity, ek3 ek3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj3Var, activity, ek3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = wj3Var;
            this.a = activity;
            this.b = ek3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.j43
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                dk3.s(this.a).a(this.b, new C0486a(this));
            }
        }

        @Override // com.baidu.tieba.j43
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                g62.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new g12(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements j43 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wj3 c;

        /* loaded from: classes8.dex */
        public class a implements zn3<gk3<Void>> {
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
            @Override // com.baidu.tieba.zn3
            /* renamed from: b */
            public void a(gk3<Void> gk3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gk3Var) == null) {
                    if (gk3Var.a != 0) {
                        g62.i("WifiApi", "getWifiList: " + gk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gk3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new g12(gk3Var.a, gk3Var.b));
                }
            }
        }

        public g(wj3 wj3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wj3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.j43
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                dk3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.j43
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                g62.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new g12(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements j43 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wj3 c;

        /* loaded from: classes8.dex */
        public class a implements zn3<gk3<fk3>> {
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
            @Override // com.baidu.tieba.zn3
            /* renamed from: b */
            public void a(gk3<fk3> gk3Var) {
                g12 g12Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gk3Var) == null) {
                    if (gk3Var.a != 0) {
                        g62.i("WifiApi", "getConnectedWifi: " + gk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gk3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (gk3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", gk3Var.c.n());
                        } catch (JSONException e) {
                            g62.i("WifiApi", "getConnectedWifi: " + gk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gk3Var.b + ZeusCrashHandler.NAME_SEPERATOR + gk3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    wj3 wj3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        g12Var = new g12(gk3Var.a, gk3Var.b);
                    } else {
                        g12Var = new g12(gk3Var.a, gk3Var.b, jSONObject);
                    }
                    wj3Var.d(str, g12Var);
                }
            }
        }

        public i(wj3 wj3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wj3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.j43
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                dk3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.j43
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                g62.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new g12(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements zn3<gk3<fk3>> {
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
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(gk3<fk3> gk3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gk3Var) == null) && gk3Var != null && gk3Var.a == 0 && gk3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", gk3Var.c);
                } catch (JSONException e) {
                    g62.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                tu2.U().u(new hj2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements zn3<gk3<List<fk3>>> {
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
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(gk3<List<fk3>> gk3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gk3Var) == null) && gk3Var != null && gk3Var.a == 0 && gk3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (fk3 fk3Var : gk3Var.c) {
                    jSONArray.put(fk3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    g62.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                tu2.U().u(new hj2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements zn3<gk3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wj3 b;

        public d(wj3 wj3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wj3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(gk3<Void> gk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gk3Var) == null) {
                if (gk3Var.a != 0) {
                    g62.i("WifiApi", "startWifi: " + gk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gk3Var.b);
                }
                this.b.d(this.a, new g12(gk3Var.a, gk3Var.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements zn3<gk3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wj3 b;

        public e(wj3 wj3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wj3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(gk3<Void> gk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gk3Var) == null) {
                if (gk3Var.a != 0) {
                    g62.i("WifiApi", "stopWifi: " + gk3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gk3Var.b);
                }
                this.b.d(this.a, new g12(gk3Var.a, gk3Var.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements zn3<je3<le3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wj3 b;

        public f(wj3 wj3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wj3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(je3<le3.e> je3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, je3Var) == null) {
                if (ee3.h(je3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = je3Var.b();
                g62.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + ee3.f(b));
                this.b.d(this.a, new g12(b, ee3.f(b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements zn3<je3<le3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wj3 b;

        public h(wj3 wj3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wj3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(je3<le3.e> je3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, je3Var) == null) {
                if (ee3.h(je3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = je3Var.b();
                g62.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + ee3.f(b));
                this.b.d(this.a, new g12(b, ee3.f(b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements zn3<je3<le3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ek3 b;
        public final /* synthetic */ wj3 c;

        public j(wj3 wj3Var, String str, ek3 ek3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj3Var, str, ek3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wj3Var;
            this.a = str;
            this.b = ek3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zn3
        /* renamed from: b */
        public void a(je3<le3.e> je3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, je3Var) == null) {
                if (!ee3.h(je3Var)) {
                    int b = je3Var.b();
                    g62.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + ee3.f(b));
                    this.c.d(this.a, new g12(b, ee3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948272457, "Lcom/baidu/tieba/wj3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948272457, "Lcom/baidu/tieba/wj3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wj3(@NonNull hx1 hx1Var) {
        super(hx1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hx1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((hx1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, ek3 ek3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ek3Var) == null) {
            SwanAppActivity w = f93.K().w();
            i43.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, ek3Var, str));
        }
    }

    public g12 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            g93 b0 = g93.b0();
            if (b0 == null) {
                g62.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new g12(1001, "swan app is null");
            } else if (b0.w() == null) {
                g62.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new g12(1001, "swan activity is null");
            } else {
                Pair<g12, JSONObject> s = s(str);
                g12 g12Var = (g12) s.first;
                if (!g12Var.isSuccess()) {
                    return g12Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    g62.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new g12(201, "callback is null");
                }
                ek3 a2 = ek3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    g62.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new g12(12008, "invalid ssid");
                } else if (b0.n0()) {
                    g62.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new g12(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return g12.f();
                }
            }
        }
        return (g12) invokeL.objValue;
    }

    public g12 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            g93 b0 = g93.b0();
            if (b0 == null) {
                g62.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new g12(1001, "swan app is null");
            } else if (b0.w() == null) {
                g62.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new g12(1001, "swan activity is null");
            } else {
                Pair<g12, JSONObject> s = s(str);
                g12 g12Var = (g12) s.first;
                if (!g12Var.isSuccess()) {
                    return g12Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    g62.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new g12(201, "callback is null");
                } else if (b0.n0()) {
                    g62.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new g12(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return g12.f();
                }
            }
        }
        return (g12) invokeL.objValue;
    }

    public g12 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            g93 b0 = g93.b0();
            if (b0 == null) {
                g62.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new g12(1001, "swan app is null");
            } else if (b0.w() == null) {
                g62.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new g12(1001, "swan activity is null");
            } else {
                Pair<g12, JSONObject> s = s(str);
                g12 g12Var = (g12) s.first;
                if (!g12Var.isSuccess()) {
                    return g12Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    g62.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new g12(201, "callback is null");
                } else if (b0.n0()) {
                    g62.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new g12(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return g12.f();
                }
            }
        }
        return (g12) invokeL.objValue;
    }

    public g12 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            g93 b0 = g93.b0();
            if (b0 == null) {
                g62.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new g12(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                g62.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new g12(1001, "swan activity is null");
            }
            Pair<g12, JSONObject> s = s(str);
            g12 g12Var = (g12) s.first;
            if (!g12Var.isSuccess()) {
                return g12Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                g62.c("WifiApi", "startWifi: 201 : callback is null");
                return new g12(201, "callback is null");
            }
            dk3 s2 = dk3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return g12.f();
            }
            g62.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new g12(12010, "unknown failed");
        }
        return (g12) invokeL.objValue;
    }

    public g12 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            g93 b0 = g93.b0();
            if (b0 == null) {
                g62.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new g12(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                g62.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new g12(1001, "swan activity is null");
            }
            Pair<g12, JSONObject> s = s(str);
            g12 g12Var = (g12) s.first;
            if (!g12Var.isSuccess()) {
                return g12Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                g62.c("WifiApi", "stopWifi: 201 : callback is null");
                return new g12(201, "callback is null");
            }
            dk3 s2 = dk3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return g12.f();
            }
            g62.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new g12(12010, "unknown failed");
        }
        return (g12) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = f93.K().w();
            i43.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = f93.K().w();
            i43.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
