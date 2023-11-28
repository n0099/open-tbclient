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
import com.baidu.tieba.mb3;
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
/* loaded from: classes9.dex */
public class xg3 extends lu1 {
    public static /* synthetic */ Interceptable $ic;
    public static final al3<hh3<gh3>> f;
    public static final al3<hh3<List<gh3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.lu1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lu1
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public class a implements k13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ fh3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ xg3 d;

        /* renamed from: com.baidu.tieba.xg3$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C0532a implements al3<hh3<gh3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0532a(a aVar) {
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
            @Override // com.baidu.tieba.al3
            /* renamed from: b */
            public void a(hh3<gh3> hh3Var) {
                iy1 iy1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hh3Var) == null) {
                    if (hh3Var.a != 0) {
                        h32.i("WifiApi", "connectWifi: " + hh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hh3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (hh3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", hh3Var.c.n());
                        } catch (JSONException e) {
                            h32.i("WifiApi", "getConnectedWifi: " + hh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hh3Var.b + ZeusCrashHandler.NAME_SEPERATOR + hh3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    xg3 xg3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        iy1Var = new iy1(hh3Var.a, hh3Var.b);
                    } else {
                        iy1Var = new iy1(hh3Var.a, hh3Var.b, jSONObject);
                    }
                    xg3Var.d(str, iy1Var);
                }
            }
        }

        public a(xg3 xg3Var, Activity activity, fh3 fh3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg3Var, activity, fh3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xg3Var;
            this.a = activity;
            this.b = fh3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.k13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                eh3.s(this.a).a(this.b, new C0532a(this));
            }
        }

        @Override // com.baidu.tieba.k13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                h32.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new iy1((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements k13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xg3 c;

        /* loaded from: classes9.dex */
        public class a implements al3<hh3<Void>> {
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
            @Override // com.baidu.tieba.al3
            /* renamed from: b */
            public void a(hh3<Void> hh3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hh3Var) == null) {
                    if (hh3Var.a != 0) {
                        h32.i("WifiApi", "getWifiList: " + hh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hh3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new iy1(hh3Var.a, hh3Var.b));
                }
            }
        }

        public g(xg3 xg3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xg3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.k13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                eh3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.k13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                h32.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new iy1((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements k13 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ xg3 c;

        /* loaded from: classes9.dex */
        public class a implements al3<hh3<gh3>> {
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
            @Override // com.baidu.tieba.al3
            /* renamed from: b */
            public void a(hh3<gh3> hh3Var) {
                iy1 iy1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hh3Var) == null) {
                    if (hh3Var.a != 0) {
                        h32.i("WifiApi", "getConnectedWifi: " + hh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hh3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (hh3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", hh3Var.c.n());
                        } catch (JSONException e) {
                            h32.i("WifiApi", "getConnectedWifi: " + hh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hh3Var.b + ZeusCrashHandler.NAME_SEPERATOR + hh3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    xg3 xg3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        iy1Var = new iy1(hh3Var.a, hh3Var.b);
                    } else {
                        iy1Var = new iy1(hh3Var.a, hh3Var.b, jSONObject);
                    }
                    xg3Var.d(str, iy1Var);
                }
            }
        }

        public i(xg3 xg3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xg3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.k13
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                eh3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.k13
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                h32.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new iy1((int) CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, "no location permission"));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements al3<hh3<gh3>> {
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
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(hh3<gh3> hh3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hh3Var) == null) && hh3Var != null && hh3Var.a == 0 && hh3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", hh3Var.c);
                } catch (JSONException e) {
                    h32.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                ur2.V().v(new ig2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements al3<hh3<List<gh3>>> {
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
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(hh3<List<gh3>> hh3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hh3Var) == null) && hh3Var != null && hh3Var.a == 0 && hh3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (gh3 gh3Var : hh3Var.c) {
                    jSONArray.put(gh3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    h32.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                ur2.V().v(new ig2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements al3<hh3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xg3 b;

        public d(xg3 xg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xg3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(hh3<Void> hh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hh3Var) == null) {
                if (hh3Var.a != 0) {
                    h32.i("WifiApi", "startWifi: " + hh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hh3Var.b);
                }
                this.b.d(this.a, new iy1(hh3Var.a, hh3Var.b));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements al3<hh3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xg3 b;

        public e(xg3 xg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xg3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(hh3<Void> hh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hh3Var) == null) {
                if (hh3Var.a != 0) {
                    h32.i("WifiApi", "stopWifi: " + hh3Var.a + ZeusCrashHandler.NAME_SEPERATOR + hh3Var.b);
                }
                this.b.d(this.a, new iy1(hh3Var.a, hh3Var.b));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements al3<kb3<mb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xg3 b;

        public f(xg3 xg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xg3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(kb3<mb3.e> kb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kb3Var) == null) {
                if (!fb3.h(kb3Var)) {
                    int b = kb3Var.b();
                    h32.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + fb3.f(b));
                    this.b.d(this.a, new iy1(b, fb3.f(b)));
                    return;
                }
                this.b.G(this.a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements al3<kb3<mb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ xg3 b;

        public h(xg3 xg3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xg3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(kb3<mb3.e> kb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kb3Var) == null) {
                if (!fb3.h(kb3Var)) {
                    int b = kb3Var.b();
                    h32.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + fb3.f(b));
                    this.b.d(this.a, new iy1(b, fb3.f(b)));
                    return;
                }
                this.b.F(this.a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements al3<kb3<mb3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ fh3 b;
        public final /* synthetic */ xg3 c;

        public j(xg3 xg3Var, String str, fh3 fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xg3Var, str, fh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = xg3Var;
            this.a = str;
            this.b = fh3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.al3
        /* renamed from: b */
        public void a(kb3<mb3.e> kb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kb3Var) == null) {
                if (fb3.h(kb3Var)) {
                    this.c.E(this.a, this.b);
                    return;
                }
                int b = kb3Var.b();
                h32.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + fb3.f(b));
                this.c.d(this.a, new iy1(b, fb3.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948299365, "Lcom/baidu/tieba/xg3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948299365, "Lcom/baidu/tieba/xg3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xg3(@NonNull ju1 ju1Var) {
        super(ju1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ju1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ju1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void E(String str, fh3 fh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, fh3Var) == null) {
            SwanAppActivity w = g63.K().w();
            j13.f(w, new String[]{com.kuaishou.weapon.p0.g.g, com.kuaishou.weapon.p0.g.h}, 0, new a(this, w, fh3Var, str));
        }
    }

    public iy1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            r("#connectWifi", false);
            h63 c0 = h63.c0();
            if (c0 == null) {
                h32.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new iy1(1001, "swan app is null");
            } else if (c0.w() == null) {
                h32.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new iy1(1001, "swan activity is null");
            } else {
                Pair<iy1, JSONObject> t = t(str);
                iy1 iy1Var = (iy1) t.first;
                if (!iy1Var.isSuccess()) {
                    return iy1Var;
                }
                JSONObject jSONObject = (JSONObject) t.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    h32.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new iy1(201, "callback is null");
                }
                fh3 a2 = fh3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    h32.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new iy1(12008, "invalid ssid");
                } else if (c0.o0()) {
                    h32.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new iy1((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    c0.f0().g(i(), "mapp_location", new j(this, optString, a2));
                    return iy1.f();
                }
            }
        }
        return (iy1) invokeL.objValue;
    }

    public iy1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            r("#startWifi", false);
            h63 c0 = h63.c0();
            if (c0 == null) {
                h32.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new iy1(1001, "swan app is null");
            }
            SwanAppActivity w = c0.w();
            if (w == null) {
                h32.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new iy1(1001, "swan activity is null");
            }
            Pair<iy1, JSONObject> t = t(str);
            iy1 iy1Var = (iy1) t.first;
            if (!iy1Var.isSuccess()) {
                return iy1Var;
            }
            String optString = ((JSONObject) t.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                h32.c("WifiApi", "startWifi: 201 : callback is null");
                return new iy1(201, "callback is null");
            }
            eh3 s = eh3.s(w);
            if (s.n(f) && s.d(g)) {
                s.p(new d(this, optString));
                return iy1.f();
            }
            h32.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new iy1(12010, "unknown failed");
        }
        return (iy1) invokeL.objValue;
    }

    public iy1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            r("#stopWifi", false);
            h63 c0 = h63.c0();
            if (c0 == null) {
                h32.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new iy1(1001, "swan app is null");
            }
            SwanAppActivity w = c0.w();
            if (w == null) {
                h32.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new iy1(1001, "swan activity is null");
            }
            Pair<iy1, JSONObject> t = t(str);
            iy1 iy1Var = (iy1) t.first;
            if (!iy1Var.isSuccess()) {
                return iy1Var;
            }
            String optString = ((JSONObject) t.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                h32.c("WifiApi", "stopWifi: 201 : callback is null");
                return new iy1(201, "callback is null");
            }
            eh3 s = eh3.s(w);
            if (s.r(f) && s.b(g)) {
                s.q(new e(this, optString));
                return iy1.f();
            }
            h32.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new iy1(12010, "unknown failed");
        }
        return (iy1) invokeL.objValue;
    }

    public iy1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            r("#getConnectedWifi", false);
            h63 c0 = h63.c0();
            if (c0 == null) {
                h32.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new iy1(1001, "swan app is null");
            } else if (c0.w() == null) {
                h32.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new iy1(1001, "swan activity is null");
            } else {
                Pair<iy1, JSONObject> t = t(str);
                iy1 iy1Var = (iy1) t.first;
                if (!iy1Var.isSuccess()) {
                    return iy1Var;
                }
                String optString = ((JSONObject) t.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    h32.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new iy1(201, "callback is null");
                } else if (c0.o0()) {
                    h32.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new iy1((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    c0.f0().g(i(), "mapp_location", new h(this, optString));
                    return iy1.f();
                }
            }
        }
        return (iy1) invokeL.objValue;
    }

    public iy1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            r("#getWifiList", false);
            h63 c0 = h63.c0();
            if (c0 == null) {
                h32.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new iy1(1001, "swan app is null");
            } else if (c0.w() == null) {
                h32.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new iy1(1001, "swan activity is null");
            } else {
                Pair<iy1, JSONObject> t = t(str);
                iy1 iy1Var = (iy1) t.first;
                if (!iy1Var.isSuccess()) {
                    return iy1Var;
                }
                String optString = ((JSONObject) t.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    h32.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new iy1(201, "callback is null");
                } else if (c0.o0()) {
                    h32.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new iy1((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    c0.f0().g(i(), "mapp_location", new f(this, optString));
                    return iy1.f();
                }
            }
        }
        return (iy1) invokeL.objValue;
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = g63.K().w();
            j13.f(w, new String[]{com.kuaishou.weapon.p0.g.g, com.kuaishou.weapon.p0.g.h}, 0, new i(this, w, str));
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = g63.K().w();
            j13.f(w, new String[]{com.kuaishou.weapon.p0.g.g, com.kuaishou.weapon.p0.g.h}, 0, new g(this, w, str));
        }
    }
}
