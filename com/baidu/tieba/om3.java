package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.dh3;
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
/* loaded from: classes7.dex */
public class om3 extends b02 {
    public static /* synthetic */ Interceptable $ic;
    public static final rq3<ym3<xm3>> f;
    public static final rq3<ym3<List<xm3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.b02
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements b73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ wm3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ om3 d;

        /* renamed from: com.baidu.tieba.om3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0402a implements rq3<ym3<xm3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0402a(a aVar) {
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
            @Override // com.baidu.tieba.rq3
            /* renamed from: b */
            public void a(ym3<xm3> ym3Var) {
                y32 y32Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ym3Var) == null) {
                    if (ym3Var.a != 0) {
                        y82.i("WifiApi", "connectWifi: " + ym3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ym3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ym3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ym3Var.c.n());
                        } catch (JSONException e) {
                            y82.i("WifiApi", "getConnectedWifi: " + ym3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ym3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ym3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    om3 om3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        y32Var = new y32(ym3Var.a, ym3Var.b);
                    } else {
                        y32Var = new y32(ym3Var.a, ym3Var.b, jSONObject);
                    }
                    om3Var.d(str, y32Var);
                }
            }
        }

        public a(om3 om3Var, Activity activity, wm3 wm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om3Var, activity, wm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = om3Var;
            this.a = activity;
            this.b = wm3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.b73
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vm3.s(this.a).a(this.b, new C0402a(this));
            }
        }

        @Override // com.baidu.tieba.b73
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                y82.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new y32(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements b73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ om3 c;

        /* loaded from: classes7.dex */
        public class a implements rq3<ym3<Void>> {
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
            @Override // com.baidu.tieba.rq3
            /* renamed from: b */
            public void a(ym3<Void> ym3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ym3Var) == null) {
                    if (ym3Var.a != 0) {
                        y82.i("WifiApi", "getWifiList: " + ym3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ym3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new y32(ym3Var.a, ym3Var.b));
                }
            }
        }

        public g(om3 om3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = om3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.b73
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vm3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.b73
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                y82.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new y32(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements b73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ om3 c;

        /* loaded from: classes7.dex */
        public class a implements rq3<ym3<xm3>> {
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
            @Override // com.baidu.tieba.rq3
            /* renamed from: b */
            public void a(ym3<xm3> ym3Var) {
                y32 y32Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ym3Var) == null) {
                    if (ym3Var.a != 0) {
                        y82.i("WifiApi", "getConnectedWifi: " + ym3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ym3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ym3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ym3Var.c.n());
                        } catch (JSONException e) {
                            y82.i("WifiApi", "getConnectedWifi: " + ym3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ym3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ym3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    om3 om3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        y32Var = new y32(ym3Var.a, ym3Var.b);
                    } else {
                        y32Var = new y32(ym3Var.a, ym3Var.b, jSONObject);
                    }
                    om3Var.d(str, y32Var);
                }
            }
        }

        public i(om3 om3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = om3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.b73
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vm3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.b73
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                y82.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new y32(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements rq3<ym3<xm3>> {
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
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(ym3<xm3> ym3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ym3Var) == null) && ym3Var != null && ym3Var.a == 0 && ym3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", ym3Var.c);
                } catch (JSONException e) {
                    y82.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                lx2.T().u(new zl2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements rq3<ym3<List<xm3>>> {
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
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(ym3<List<xm3>> ym3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ym3Var) == null) && ym3Var != null && ym3Var.a == 0 && ym3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (xm3 xm3Var : ym3Var.c) {
                    jSONArray.put(xm3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    y82.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                lx2.T().u(new zl2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements rq3<ym3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ om3 b;

        public d(om3 om3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(ym3<Void> ym3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ym3Var) == null) {
                if (ym3Var.a != 0) {
                    y82.i("WifiApi", "startWifi: " + ym3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ym3Var.b);
                }
                this.b.d(this.a, new y32(ym3Var.a, ym3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements rq3<ym3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ om3 b;

        public e(om3 om3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(ym3<Void> ym3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ym3Var) == null) {
                if (ym3Var.a != 0) {
                    y82.i("WifiApi", "stopWifi: " + ym3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ym3Var.b);
                }
                this.b.d(this.a, new y32(ym3Var.a, ym3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements rq3<bh3<dh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ om3 b;

        public f(om3 om3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(bh3<dh3.e> bh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bh3Var) == null) {
                if (wg3.h(bh3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = bh3Var.b();
                y82.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + wg3.f(b));
                this.b.d(this.a, new y32(b, wg3.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements rq3<bh3<dh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ om3 b;

        public h(om3 om3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = om3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(bh3<dh3.e> bh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bh3Var) == null) {
                if (wg3.h(bh3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = bh3Var.b();
                y82.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + wg3.f(b));
                this.b.d(this.a, new y32(b, wg3.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements rq3<bh3<dh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wm3 b;
        public final /* synthetic */ om3 c;

        public j(om3 om3Var, String str, wm3 wm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {om3Var, str, wm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = om3Var;
            this.a = str;
            this.b = wm3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(bh3<dh3.e> bh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bh3Var) == null) {
                if (!wg3.h(bh3Var)) {
                    int b = bh3Var.b();
                    y82.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + wg3.f(b));
                    this.c.d(this.a, new y32(b, wg3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948037012, "Lcom/baidu/tieba/om3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948037012, "Lcom/baidu/tieba/om3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public om3(@NonNull zz1 zz1Var) {
        super(zz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((zz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, wm3 wm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, wm3Var) == null) {
            SwanAppActivity w = xb3.K().w();
            a73.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, wm3Var, str));
        }
    }

    public y32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            yb3 b0 = yb3.b0();
            if (b0 == null) {
                y82.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new y32(1001, "swan app is null");
            } else if (b0.w() == null) {
                y82.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new y32(1001, "swan activity is null");
            } else {
                Pair<y32, JSONObject> s = s(str);
                y32 y32Var = (y32) s.first;
                if (!y32Var.isSuccess()) {
                    return y32Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    y82.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new y32(201, "callback is null");
                }
                wm3 a2 = wm3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    y82.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new y32(12008, "invalid ssid");
                } else if (b0.n0()) {
                    y82.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new y32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return y32.f();
                }
            }
        }
        return (y32) invokeL.objValue;
    }

    public y32 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            yb3 b0 = yb3.b0();
            if (b0 == null) {
                y82.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new y32(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                y82.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new y32(1001, "swan activity is null");
            }
            Pair<y32, JSONObject> s = s(str);
            y32 y32Var = (y32) s.first;
            if (!y32Var.isSuccess()) {
                return y32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                y82.c("WifiApi", "startWifi: 201 : callback is null");
                return new y32(201, "callback is null");
            }
            vm3 s2 = vm3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return y32.f();
            }
            y82.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new y32(12010, "unknown failed");
        }
        return (y32) invokeL.objValue;
    }

    public y32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            yb3 b0 = yb3.b0();
            if (b0 == null) {
                y82.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new y32(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                y82.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new y32(1001, "swan activity is null");
            }
            Pair<y32, JSONObject> s = s(str);
            y32 y32Var = (y32) s.first;
            if (!y32Var.isSuccess()) {
                return y32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                y82.c("WifiApi", "stopWifi: 201 : callback is null");
                return new y32(201, "callback is null");
            }
            vm3 s2 = vm3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return y32.f();
            }
            y82.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new y32(12010, "unknown failed");
        }
        return (y32) invokeL.objValue;
    }

    public y32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            yb3 b0 = yb3.b0();
            if (b0 == null) {
                y82.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new y32(1001, "swan app is null");
            } else if (b0.w() == null) {
                y82.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new y32(1001, "swan activity is null");
            } else {
                Pair<y32, JSONObject> s = s(str);
                y32 y32Var = (y32) s.first;
                if (!y32Var.isSuccess()) {
                    return y32Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    y82.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new y32(201, "callback is null");
                } else if (b0.n0()) {
                    y82.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new y32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return y32.f();
                }
            }
        }
        return (y32) invokeL.objValue;
    }

    public y32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            yb3 b0 = yb3.b0();
            if (b0 == null) {
                y82.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new y32(1001, "swan app is null");
            } else if (b0.w() == null) {
                y82.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new y32(1001, "swan activity is null");
            } else {
                Pair<y32, JSONObject> s = s(str);
                y32 y32Var = (y32) s.first;
                if (!y32Var.isSuccess()) {
                    return y32Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    y82.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new y32(201, "callback is null");
                } else if (b0.n0()) {
                    y82.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new y32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return y32.f();
                }
            }
        }
        return (y32) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = xb3.K().w();
            a73.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = xb3.K().w();
            a73.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
