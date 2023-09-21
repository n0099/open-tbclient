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
import com.baidu.tieba.lg3;
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
public class wl3 extends jz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final zp3<gm3<fm3>> f;
    public static final zp3<gm3<List<fm3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.jz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements j63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ em3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ wl3 d;

        /* renamed from: com.baidu.tieba.wl3$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0495a implements zp3<gm3<fm3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0495a(a aVar) {
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
            @Override // com.baidu.tieba.zp3
            /* renamed from: b */
            public void a(gm3<fm3> gm3Var) {
                g32 g32Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gm3Var) == null) {
                    if (gm3Var.a != 0) {
                        g82.i("WifiApi", "connectWifi: " + gm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gm3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (gm3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", gm3Var.c.n());
                        } catch (JSONException e) {
                            g82.i("WifiApi", "getConnectedWifi: " + gm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gm3Var.b + ZeusCrashHandler.NAME_SEPERATOR + gm3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    wl3 wl3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        g32Var = new g32(gm3Var.a, gm3Var.b);
                    } else {
                        g32Var = new g32(gm3Var.a, gm3Var.b, jSONObject);
                    }
                    wl3Var.d(str, g32Var);
                }
            }
        }

        public a(wl3 wl3Var, Activity activity, em3 em3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl3Var, activity, em3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = wl3Var;
            this.a = activity;
            this.b = em3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.j63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                dm3.s(this.a).a(this.b, new C0495a(this));
            }
        }

        @Override // com.baidu.tieba.j63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                g82.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new g32((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements j63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wl3 c;

        /* loaded from: classes8.dex */
        public class a implements zp3<gm3<Void>> {
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
            @Override // com.baidu.tieba.zp3
            /* renamed from: b */
            public void a(gm3<Void> gm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gm3Var) == null) {
                    if (gm3Var.a != 0) {
                        g82.i("WifiApi", "getWifiList: " + gm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gm3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new g32(gm3Var.a, gm3Var.b));
                }
            }
        }

        public g(wl3 wl3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wl3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.j63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                dm3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.j63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                g82.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new g32((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements j63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wl3 c;

        /* loaded from: classes8.dex */
        public class a implements zp3<gm3<fm3>> {
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
            @Override // com.baidu.tieba.zp3
            /* renamed from: b */
            public void a(gm3<fm3> gm3Var) {
                g32 g32Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gm3Var) == null) {
                    if (gm3Var.a != 0) {
                        g82.i("WifiApi", "getConnectedWifi: " + gm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gm3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (gm3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", gm3Var.c.n());
                        } catch (JSONException e) {
                            g82.i("WifiApi", "getConnectedWifi: " + gm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gm3Var.b + ZeusCrashHandler.NAME_SEPERATOR + gm3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    wl3 wl3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        g32Var = new g32(gm3Var.a, gm3Var.b);
                    } else {
                        g32Var = new g32(gm3Var.a, gm3Var.b, jSONObject);
                    }
                    wl3Var.d(str, g32Var);
                }
            }
        }

        public i(wl3 wl3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wl3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.j63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                dm3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.j63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                g82.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new g32((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements zp3<gm3<fm3>> {
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
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(gm3<fm3> gm3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gm3Var) == null) && gm3Var != null && gm3Var.a == 0 && gm3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", gm3Var.c);
                } catch (JSONException e) {
                    g82.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                tw2.T().u(new hl2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements zp3<gm3<List<fm3>>> {
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
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(gm3<List<fm3>> gm3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gm3Var) == null) && gm3Var != null && gm3Var.a == 0 && gm3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (fm3 fm3Var : gm3Var.c) {
                    jSONArray.put(fm3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    g82.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                tw2.T().u(new hl2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements zp3<gm3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wl3 b;

        public d(wl3 wl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(gm3<Void> gm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gm3Var) == null) {
                if (gm3Var.a != 0) {
                    g82.i("WifiApi", "startWifi: " + gm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gm3Var.b);
                }
                this.b.d(this.a, new g32(gm3Var.a, gm3Var.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements zp3<gm3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wl3 b;

        public e(wl3 wl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(gm3<Void> gm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gm3Var) == null) {
                if (gm3Var.a != 0) {
                    g82.i("WifiApi", "stopWifi: " + gm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gm3Var.b);
                }
                this.b.d(this.a, new g32(gm3Var.a, gm3Var.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements zp3<jg3<lg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wl3 b;

        public f(wl3 wl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(jg3<lg3.e> jg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jg3Var) == null) {
                if (eg3.h(jg3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = jg3Var.b();
                g82.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + eg3.f(b));
                this.b.d(this.a, new g32(b, eg3.f(b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements zp3<jg3<lg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wl3 b;

        public h(wl3 wl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(jg3<lg3.e> jg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jg3Var) == null) {
                if (eg3.h(jg3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = jg3Var.b();
                g82.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + eg3.f(b));
                this.b.d(this.a, new g32(b, eg3.f(b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements zp3<jg3<lg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ em3 b;
        public final /* synthetic */ wl3 c;

        public j(wl3 wl3Var, String str, em3 em3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wl3Var, str, em3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wl3Var;
            this.a = str;
            this.b = em3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zp3
        /* renamed from: b */
        public void a(jg3<lg3.e> jg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jg3Var) == null) {
                if (!eg3.h(jg3Var)) {
                    int b = jg3Var.b();
                    g82.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + eg3.f(b));
                    this.c.d(this.a, new g32(b, eg3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948274379, "Lcom/baidu/tieba/wl3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948274379, "Lcom/baidu/tieba/wl3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wl3(@NonNull hz1 hz1Var) {
        super(hz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((hz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, em3 em3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, em3Var) == null) {
            SwanAppActivity w = fb3.K().w();
            i63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, em3Var, str));
        }
    }

    public g32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            gb3 b0 = gb3.b0();
            if (b0 == null) {
                g82.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new g32(1001, "swan app is null");
            } else if (b0.w() == null) {
                g82.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new g32(1001, "swan activity is null");
            } else {
                Pair<g32, JSONObject> s = s(str);
                g32 g32Var = (g32) s.first;
                if (!g32Var.isSuccess()) {
                    return g32Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    g82.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new g32(201, "callback is null");
                }
                em3 a2 = em3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    g82.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new g32(12008, "invalid ssid");
                } else if (b0.n0()) {
                    g82.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new g32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return g32.f();
                }
            }
        }
        return (g32) invokeL.objValue;
    }

    public g32 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            gb3 b0 = gb3.b0();
            if (b0 == null) {
                g82.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new g32(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                g82.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new g32(1001, "swan activity is null");
            }
            Pair<g32, JSONObject> s = s(str);
            g32 g32Var = (g32) s.first;
            if (!g32Var.isSuccess()) {
                return g32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                g82.c("WifiApi", "startWifi: 201 : callback is null");
                return new g32(201, "callback is null");
            }
            dm3 s2 = dm3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return g32.f();
            }
            g82.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new g32(12010, "unknown failed");
        }
        return (g32) invokeL.objValue;
    }

    public g32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            gb3 b0 = gb3.b0();
            if (b0 == null) {
                g82.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new g32(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                g82.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new g32(1001, "swan activity is null");
            }
            Pair<g32, JSONObject> s = s(str);
            g32 g32Var = (g32) s.first;
            if (!g32Var.isSuccess()) {
                return g32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                g82.c("WifiApi", "stopWifi: 201 : callback is null");
                return new g32(201, "callback is null");
            }
            dm3 s2 = dm3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return g32.f();
            }
            g82.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new g32(12010, "unknown failed");
        }
        return (g32) invokeL.objValue;
    }

    public g32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            gb3 b0 = gb3.b0();
            if (b0 == null) {
                g82.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new g32(1001, "swan app is null");
            } else if (b0.w() == null) {
                g82.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new g32(1001, "swan activity is null");
            } else {
                Pair<g32, JSONObject> s = s(str);
                g32 g32Var = (g32) s.first;
                if (!g32Var.isSuccess()) {
                    return g32Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    g82.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new g32(201, "callback is null");
                } else if (b0.n0()) {
                    g82.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new g32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return g32.f();
                }
            }
        }
        return (g32) invokeL.objValue;
    }

    public g32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            gb3 b0 = gb3.b0();
            if (b0 == null) {
                g82.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new g32(1001, "swan app is null");
            } else if (b0.w() == null) {
                g82.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new g32(1001, "swan activity is null");
            } else {
                Pair<g32, JSONObject> s = s(str);
                g32 g32Var = (g32) s.first;
                if (!g32Var.isSuccess()) {
                    return g32Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    g82.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new g32(201, "callback is null");
                } else if (b0.n0()) {
                    g82.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new g32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return g32.f();
                }
            }
        }
        return (g32) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = fb3.K().w();
            i63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = fb3.K().w();
            i63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
