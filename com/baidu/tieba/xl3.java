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
import com.baidu.tieba.mg3;
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
public class xl3 extends kz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final aq3<hm3<gm3>> f;
    public static final aq3<hm3<List<gm3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements k63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ fm3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ xl3 d;

        /* renamed from: com.baidu.tieba.xl3$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0529a implements aq3<hm3<gm3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0529a(a aVar) {
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
            @Override // com.baidu.tieba.aq3
            /* renamed from: b */
            public void a(hm3<gm3> hm3Var) {
                h32 h32Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hm3Var) == null) {
                    if (hm3Var.a != 0) {
                        h82.i("WifiApi", "connectWifi: " + hm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hm3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (hm3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", hm3Var.c.n());
                        } catch (JSONException e) {
                            h82.i("WifiApi", "getConnectedWifi: " + hm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hm3Var.b + ZeusCrashHandler.NAME_SEPERATOR + hm3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    xl3 xl3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        h32Var = new h32(hm3Var.a, hm3Var.b);
                    } else {
                        h32Var = new h32(hm3Var.a, hm3Var.b, jSONObject);
                    }
                    xl3Var.d(str, h32Var);
                }
            }
        }

        public a(xl3 xl3Var, Activity activity, fm3 fm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl3Var, activity, fm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xl3Var;
            this.a = activity;
            this.b = fm3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.k63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                em3.s(this.a).a(this.b, new C0529a(this));
            }
        }

        @Override // com.baidu.tieba.k63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                h82.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new h32((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements k63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xl3 c;

        /* loaded from: classes8.dex */
        public class a implements aq3<hm3<Void>> {
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
            @Override // com.baidu.tieba.aq3
            /* renamed from: b */
            public void a(hm3<Void> hm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hm3Var) == null) {
                    if (hm3Var.a != 0) {
                        h82.i("WifiApi", "getWifiList: " + hm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hm3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new h32(hm3Var.a, hm3Var.b));
                }
            }
        }

        public g(xl3 xl3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xl3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.k63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                em3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.k63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                h82.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new h32((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements k63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xl3 c;

        /* loaded from: classes8.dex */
        public class a implements aq3<hm3<gm3>> {
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
            @Override // com.baidu.tieba.aq3
            /* renamed from: b */
            public void a(hm3<gm3> hm3Var) {
                h32 h32Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hm3Var) == null) {
                    if (hm3Var.a != 0) {
                        h82.i("WifiApi", "getConnectedWifi: " + hm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hm3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (hm3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", hm3Var.c.n());
                        } catch (JSONException e) {
                            h82.i("WifiApi", "getConnectedWifi: " + hm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hm3Var.b + ZeusCrashHandler.NAME_SEPERATOR + hm3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    xl3 xl3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        h32Var = new h32(hm3Var.a, hm3Var.b);
                    } else {
                        h32Var = new h32(hm3Var.a, hm3Var.b, jSONObject);
                    }
                    xl3Var.d(str, h32Var);
                }
            }
        }

        public i(xl3 xl3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xl3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.k63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                em3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.k63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                h82.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new h32((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements aq3<hm3<gm3>> {
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
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(hm3<gm3> hm3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hm3Var) == null) && hm3Var != null && hm3Var.a == 0 && hm3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", hm3Var.c);
                } catch (JSONException e) {
                    h82.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                uw2.T().u(new il2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements aq3<hm3<List<gm3>>> {
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
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(hm3<List<gm3>> hm3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hm3Var) == null) && hm3Var != null && hm3Var.a == 0 && hm3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (gm3 gm3Var : hm3Var.c) {
                    jSONArray.put(gm3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    h82.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                uw2.T().u(new il2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements aq3<hm3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xl3 b;

        public d(xl3 xl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(hm3<Void> hm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hm3Var) == null) {
                if (hm3Var.a != 0) {
                    h82.i("WifiApi", "startWifi: " + hm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hm3Var.b);
                }
                this.b.d(this.a, new h32(hm3Var.a, hm3Var.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements aq3<hm3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xl3 b;

        public e(xl3 xl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(hm3<Void> hm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hm3Var) == null) {
                if (hm3Var.a != 0) {
                    h82.i("WifiApi", "stopWifi: " + hm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hm3Var.b);
                }
                this.b.d(this.a, new h32(hm3Var.a, hm3Var.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xl3 b;

        public f(xl3 xl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (fg3.h(kg3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = kg3Var.b();
                h82.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + fg3.f(b));
                this.b.d(this.a, new h32(b, fg3.f(b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xl3 b;

        public h(xl3 xl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (fg3.h(kg3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = kg3Var.b();
                h82.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + fg3.f(b));
                this.b.d(this.a, new h32(b, fg3.f(b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fm3 b;
        public final /* synthetic */ xl3 c;

        public j(xl3 xl3Var, String str, fm3 fm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xl3Var, str, fm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xl3Var;
            this.a = str;
            this.b = fm3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (!fg3.h(kg3Var)) {
                    int b = kg3Var.b();
                    h82.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + fg3.f(b));
                    this.c.d(this.a, new h32(b, fg3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948304170, "Lcom/baidu/tieba/xl3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948304170, "Lcom/baidu/tieba/xl3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xl3(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, fm3 fm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, fm3Var) == null) {
            SwanAppActivity w = gb3.K().w();
            j63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, fm3Var, str));
        }
    }

    public h32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                h82.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new h32(1001, "swan app is null");
            } else if (b0.w() == null) {
                h82.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new h32(1001, "swan activity is null");
            } else {
                Pair<h32, JSONObject> s = s(str);
                h32 h32Var = (h32) s.first;
                if (!h32Var.isSuccess()) {
                    return h32Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    h82.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new h32(201, "callback is null");
                }
                fm3 a2 = fm3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    h82.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new h32(12008, "invalid ssid");
                } else if (b0.n0()) {
                    h82.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new h32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return h32.f();
                }
            }
        }
        return (h32) invokeL.objValue;
    }

    public h32 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                h82.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new h32(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                h82.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new h32(1001, "swan activity is null");
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                h82.c("WifiApi", "startWifi: 201 : callback is null");
                return new h32(201, "callback is null");
            }
            em3 s2 = em3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return h32.f();
            }
            h82.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new h32(12010, "unknown failed");
        }
        return (h32) invokeL.objValue;
    }

    public h32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                h82.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new h32(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                h82.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new h32(1001, "swan activity is null");
            }
            Pair<h32, JSONObject> s = s(str);
            h32 h32Var = (h32) s.first;
            if (!h32Var.isSuccess()) {
                return h32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                h82.c("WifiApi", "stopWifi: 201 : callback is null");
                return new h32(201, "callback is null");
            }
            em3 s2 = em3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return h32.f();
            }
            h82.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new h32(12010, "unknown failed");
        }
        return (h32) invokeL.objValue;
    }

    public h32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                h82.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new h32(1001, "swan app is null");
            } else if (b0.w() == null) {
                h82.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new h32(1001, "swan activity is null");
            } else {
                Pair<h32, JSONObject> s = s(str);
                h32 h32Var = (h32) s.first;
                if (!h32Var.isSuccess()) {
                    return h32Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    h82.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new h32(201, "callback is null");
                } else if (b0.n0()) {
                    h82.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new h32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return h32.f();
                }
            }
        }
        return (h32) invokeL.objValue;
    }

    public h32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                h82.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new h32(1001, "swan app is null");
            } else if (b0.w() == null) {
                h82.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new h32(1001, "swan activity is null");
            } else {
                Pair<h32, JSONObject> s = s(str);
                h32 h32Var = (h32) s.first;
                if (!h32Var.isSuccess()) {
                    return h32Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    h82.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new h32(201, "callback is null");
                } else if (b0.n0()) {
                    h82.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new h32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return h32.f();
                }
            }
        }
        return (h32) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = gb3.K().w();
            j63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = gb3.K().w();
            j63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
