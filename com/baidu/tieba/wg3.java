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
import com.baidu.tieba.lb3;
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
public class wg3 extends ku1 {
    public static /* synthetic */ Interceptable $ic;
    public static final zk3<gh3<fh3>> f;
    public static final zk3<gh3<List<fh3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ku1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ku1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements j13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ eh3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ wg3 d;

        /* renamed from: com.baidu.tieba.wg3$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0517a implements zk3<gh3<fh3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0517a(a aVar) {
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
            @Override // com.baidu.tieba.zk3
            /* renamed from: b */
            public void a(gh3<fh3> gh3Var) {
                hy1 hy1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gh3Var) == null) {
                    if (gh3Var.a != 0) {
                        g32.i("WifiApi", "connectWifi: " + gh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gh3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (gh3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", gh3Var.c.n());
                        } catch (JSONException e) {
                            g32.i("WifiApi", "getConnectedWifi: " + gh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gh3Var.b + ZeusCrashHandler.NAME_SEPERATOR + gh3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    wg3 wg3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        hy1Var = new hy1(gh3Var.a, gh3Var.b);
                    } else {
                        hy1Var = new hy1(gh3Var.a, gh3Var.b, jSONObject);
                    }
                    wg3Var.d(str, hy1Var);
                }
            }
        }

        public a(wg3 wg3Var, Activity activity, eh3 eh3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg3Var, activity, eh3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = wg3Var;
            this.a = activity;
            this.b = eh3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.j13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                dh3.s(this.a).a(this.b, new C0517a(this));
            }
        }

        @Override // com.baidu.tieba.j13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                g32.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new hy1((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements j13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wg3 c;

        /* loaded from: classes8.dex */
        public class a implements zk3<gh3<Void>> {
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
            @Override // com.baidu.tieba.zk3
            /* renamed from: b */
            public void a(gh3<Void> gh3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gh3Var) == null) {
                    if (gh3Var.a != 0) {
                        g32.i("WifiApi", "getWifiList: " + gh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gh3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new hy1(gh3Var.a, gh3Var.b));
                }
            }
        }

        public g(wg3 wg3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wg3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.j13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                dh3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.j13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                g32.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new hy1((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements j13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ wg3 c;

        /* loaded from: classes8.dex */
        public class a implements zk3<gh3<fh3>> {
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
            @Override // com.baidu.tieba.zk3
            /* renamed from: b */
            public void a(gh3<fh3> gh3Var) {
                hy1 hy1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gh3Var) == null) {
                    if (gh3Var.a != 0) {
                        g32.i("WifiApi", "getConnectedWifi: " + gh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gh3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (gh3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", gh3Var.c.n());
                        } catch (JSONException e) {
                            g32.i("WifiApi", "getConnectedWifi: " + gh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gh3Var.b + ZeusCrashHandler.NAME_SEPERATOR + gh3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    wg3 wg3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        hy1Var = new hy1(gh3Var.a, gh3Var.b);
                    } else {
                        hy1Var = new hy1(gh3Var.a, gh3Var.b, jSONObject);
                    }
                    wg3Var.d(str, hy1Var);
                }
            }
        }

        public i(wg3 wg3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wg3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.j13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                dh3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.j13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                g32.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new hy1((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements zk3<gh3<fh3>> {
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
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(gh3<fh3> gh3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gh3Var) == null) && gh3Var != null && gh3Var.a == 0 && gh3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", gh3Var.c);
                } catch (JSONException e) {
                    g32.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                tr2.V().v(new hg2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements zk3<gh3<List<fh3>>> {
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
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(gh3<List<fh3>> gh3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gh3Var) == null) && gh3Var != null && gh3Var.a == 0 && gh3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (fh3 fh3Var : gh3Var.c) {
                    jSONArray.put(fh3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    g32.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                tr2.V().v(new hg2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements zk3<gh3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wg3 b;

        public d(wg3 wg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wg3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(gh3<Void> gh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gh3Var) == null) {
                if (gh3Var.a != 0) {
                    g32.i("WifiApi", "startWifi: " + gh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gh3Var.b);
                }
                this.b.d(this.a, new hy1(gh3Var.a, gh3Var.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements zk3<gh3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wg3 b;

        public e(wg3 wg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wg3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(gh3<Void> gh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gh3Var) == null) {
                if (gh3Var.a != 0) {
                    g32.i("WifiApi", "stopWifi: " + gh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + gh3Var.b);
                }
                this.b.d(this.a, new hy1(gh3Var.a, gh3Var.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements zk3<jb3<lb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wg3 b;

        public f(wg3 wg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wg3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(jb3<lb3.e> jb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jb3Var) == null) {
                if (!eb3.h(jb3Var)) {
                    int b = jb3Var.b();
                    g32.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + eb3.f(b));
                    this.b.d(this.a, new hy1(b, eb3.f(b)));
                    return;
                }
                this.b.G(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements zk3<jb3<lb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wg3 b;

        public h(wg3 wg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = wg3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(jb3<lb3.e> jb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jb3Var) == null) {
                if (!eb3.h(jb3Var)) {
                    int b = jb3Var.b();
                    g32.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + eb3.f(b));
                    this.b.d(this.a, new hy1(b, eb3.f(b)));
                    return;
                }
                this.b.F(this.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements zk3<jb3<lb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ eh3 b;
        public final /* synthetic */ wg3 c;

        public j(wg3 wg3Var, String str, eh3 eh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wg3Var, str, eh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wg3Var;
            this.a = str;
            this.b = eh3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.zk3
        /* renamed from: b */
        public void a(jb3<lb3.e> jb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jb3Var) == null) {
                if (eb3.h(jb3Var)) {
                    this.c.E(this.a, this.b);
                    return;
                }
                int b = jb3Var.b();
                g32.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + eb3.f(b));
                this.c.d(this.a, new hy1(b, eb3.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948269574, "Lcom/baidu/tieba/wg3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948269574, "Lcom/baidu/tieba/wg3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wg3(@NonNull iu1 iu1Var) {
        super(iu1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((iu1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void E(String str, eh3 eh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, eh3Var) == null) {
            SwanAppActivity w = f63.K().w();
            i13.f(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, eh3Var, str));
        }
    }

    public hy1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#connectWifi", false);
            g63 c0 = g63.c0();
            if (c0 == null) {
                g32.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new hy1(1001, "swan app is null");
            } else if (c0.w() == null) {
                g32.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new hy1(1001, "swan activity is null");
            } else {
                Pair<hy1, JSONObject> t = t(str);
                hy1 hy1Var = (hy1) t.first;
                if (!hy1Var.isSuccess()) {
                    return hy1Var;
                }
                JSONObject jSONObject = (JSONObject) t.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    g32.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new hy1(201, "callback is null");
                }
                eh3 a2 = eh3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    g32.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new hy1(12008, "invalid ssid");
                } else if (c0.o0()) {
                    g32.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new hy1((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    c0.f0().g(i(), "mapp_location", new j(this, optString, a2));
                    return hy1.f();
                }
            }
        }
        return (hy1) invokeL.objValue;
    }

    public hy1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#startWifi", false);
            g63 c0 = g63.c0();
            if (c0 == null) {
                g32.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new hy1(1001, "swan app is null");
            }
            SwanAppActivity w = c0.w();
            if (w == null) {
                g32.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new hy1(1001, "swan activity is null");
            }
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                return hy1Var;
            }
            String optString = ((JSONObject) t.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                g32.c("WifiApi", "startWifi: 201 : callback is null");
                return new hy1(201, "callback is null");
            }
            dh3 s = dh3.s(w);
            if (s.n(f) && s.d(g)) {
                s.p(new d(this, optString));
                return hy1.f();
            }
            g32.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new hy1(12010, "unknown failed");
        }
        return (hy1) invokeL.objValue;
    }

    public hy1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            r("#stopWifi", false);
            g63 c0 = g63.c0();
            if (c0 == null) {
                g32.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new hy1(1001, "swan app is null");
            }
            SwanAppActivity w = c0.w();
            if (w == null) {
                g32.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new hy1(1001, "swan activity is null");
            }
            Pair<hy1, JSONObject> t = t(str);
            hy1 hy1Var = (hy1) t.first;
            if (!hy1Var.isSuccess()) {
                return hy1Var;
            }
            String optString = ((JSONObject) t.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                g32.c("WifiApi", "stopWifi: 201 : callback is null");
                return new hy1(201, "callback is null");
            }
            dh3 s = dh3.s(w);
            if (s.r(f) && s.b(g)) {
                s.q(new e(this, optString));
                return hy1.f();
            }
            g32.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new hy1(12010, "unknown failed");
        }
        return (hy1) invokeL.objValue;
    }

    public hy1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#getConnectedWifi", false);
            g63 c0 = g63.c0();
            if (c0 == null) {
                g32.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new hy1(1001, "swan app is null");
            } else if (c0.w() == null) {
                g32.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new hy1(1001, "swan activity is null");
            } else {
                Pair<hy1, JSONObject> t = t(str);
                hy1 hy1Var = (hy1) t.first;
                if (!hy1Var.isSuccess()) {
                    return hy1Var;
                }
                String optString = ((JSONObject) t.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    g32.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new hy1(201, "callback is null");
                } else if (c0.o0()) {
                    g32.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new hy1((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    c0.f0().g(i(), "mapp_location", new h(this, optString));
                    return hy1.f();
                }
            }
        }
        return (hy1) invokeL.objValue;
    }

    public hy1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#getWifiList", false);
            g63 c0 = g63.c0();
            if (c0 == null) {
                g32.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new hy1(1001, "swan app is null");
            } else if (c0.w() == null) {
                g32.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new hy1(1001, "swan activity is null");
            } else {
                Pair<hy1, JSONObject> t = t(str);
                hy1 hy1Var = (hy1) t.first;
                if (!hy1Var.isSuccess()) {
                    return hy1Var;
                }
                String optString = ((JSONObject) t.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    g32.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new hy1(201, "callback is null");
                } else if (c0.o0()) {
                    g32.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new hy1((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    c0.f0().g(i(), "mapp_location", new f(this, optString));
                    return hy1.f();
                }
            }
        }
        return (hy1) invokeL.objValue;
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = f63.K().w();
            i13.f(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = f63.K().w();
            i13.f(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
