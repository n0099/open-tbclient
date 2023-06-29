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
import com.baidu.tieba.hh3;
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
public class sm3 extends f02 {
    public static /* synthetic */ Interceptable $ic;
    public static final vq3<cn3<bn3>> f;
    public static final vq3<cn3<List<bn3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.f02
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements f73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ an3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ sm3 d;

        /* renamed from: com.baidu.tieba.sm3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0470a implements vq3<cn3<bn3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0470a(a aVar) {
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
            @Override // com.baidu.tieba.vq3
            /* renamed from: b */
            public void a(cn3<bn3> cn3Var) {
                c42 c42Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cn3Var) == null) {
                    if (cn3Var.a != 0) {
                        c92.i("WifiApi", "connectWifi: " + cn3Var.a + ZeusCrashHandler.NAME_SEPERATOR + cn3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (cn3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cn3Var.c.n());
                        } catch (JSONException e) {
                            c92.i("WifiApi", "getConnectedWifi: " + cn3Var.a + ZeusCrashHandler.NAME_SEPERATOR + cn3Var.b + ZeusCrashHandler.NAME_SEPERATOR + cn3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    sm3 sm3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        c42Var = new c42(cn3Var.a, cn3Var.b);
                    } else {
                        c42Var = new c42(cn3Var.a, cn3Var.b, jSONObject);
                    }
                    sm3Var.d(str, c42Var);
                }
            }
        }

        public a(sm3 sm3Var, Activity activity, an3 an3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm3Var, activity, an3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = sm3Var;
            this.a = activity;
            this.b = an3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.f73
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                zm3.s(this.a).a(this.b, new C0470a(this));
            }
        }

        @Override // com.baidu.tieba.f73
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                c92.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new c42(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements f73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sm3 c;

        /* loaded from: classes7.dex */
        public class a implements vq3<cn3<Void>> {
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
            @Override // com.baidu.tieba.vq3
            /* renamed from: b */
            public void a(cn3<Void> cn3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cn3Var) == null) {
                    if (cn3Var.a != 0) {
                        c92.i("WifiApi", "getWifiList: " + cn3Var.a + ZeusCrashHandler.NAME_SEPERATOR + cn3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new c42(cn3Var.a, cn3Var.b));
                }
            }
        }

        public g(sm3 sm3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sm3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.f73
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                zm3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.f73
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                c92.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new c42(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements f73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ sm3 c;

        /* loaded from: classes7.dex */
        public class a implements vq3<cn3<bn3>> {
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
            @Override // com.baidu.tieba.vq3
            /* renamed from: b */
            public void a(cn3<bn3> cn3Var) {
                c42 c42Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cn3Var) == null) {
                    if (cn3Var.a != 0) {
                        c92.i("WifiApi", "getConnectedWifi: " + cn3Var.a + ZeusCrashHandler.NAME_SEPERATOR + cn3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (cn3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", cn3Var.c.n());
                        } catch (JSONException e) {
                            c92.i("WifiApi", "getConnectedWifi: " + cn3Var.a + ZeusCrashHandler.NAME_SEPERATOR + cn3Var.b + ZeusCrashHandler.NAME_SEPERATOR + cn3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    sm3 sm3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        c42Var = new c42(cn3Var.a, cn3Var.b);
                    } else {
                        c42Var = new c42(cn3Var.a, cn3Var.b, jSONObject);
                    }
                    sm3Var.d(str, c42Var);
                }
            }
        }

        public i(sm3 sm3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sm3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.f73
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                zm3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.f73
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                c92.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new c42(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements vq3<cn3<bn3>> {
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
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(cn3<bn3> cn3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cn3Var) == null) && cn3Var != null && cn3Var.a == 0 && cn3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", cn3Var.c);
                } catch (JSONException e) {
                    c92.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                px2.T().u(new dm2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements vq3<cn3<List<bn3>>> {
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
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(cn3<List<bn3>> cn3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cn3Var) == null) && cn3Var != null && cn3Var.a == 0 && cn3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (bn3 bn3Var : cn3Var.c) {
                    jSONArray.put(bn3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    c92.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                px2.T().u(new dm2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements vq3<cn3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sm3 b;

        public d(sm3 sm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sm3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(cn3<Void> cn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cn3Var) == null) {
                if (cn3Var.a != 0) {
                    c92.i("WifiApi", "startWifi: " + cn3Var.a + ZeusCrashHandler.NAME_SEPERATOR + cn3Var.b);
                }
                this.b.d(this.a, new c42(cn3Var.a, cn3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements vq3<cn3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sm3 b;

        public e(sm3 sm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sm3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(cn3<Void> cn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cn3Var) == null) {
                if (cn3Var.a != 0) {
                    c92.i("WifiApi", "stopWifi: " + cn3Var.a + ZeusCrashHandler.NAME_SEPERATOR + cn3Var.b);
                }
                this.b.d(this.a, new c42(cn3Var.a, cn3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements vq3<fh3<hh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sm3 b;

        public f(sm3 sm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sm3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(fh3<hh3.e> fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) == null) {
                if (ah3.h(fh3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = fh3Var.b();
                c92.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + ah3.f(b));
                this.b.d(this.a, new c42(b, ah3.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements vq3<fh3<hh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sm3 b;

        public h(sm3 sm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = sm3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(fh3<hh3.e> fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) == null) {
                if (ah3.h(fh3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = fh3Var.b();
                c92.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + ah3.f(b));
                this.b.d(this.a, new c42(b, ah3.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements vq3<fh3<hh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ an3 b;
        public final /* synthetic */ sm3 c;

        public j(sm3 sm3Var, String str, an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sm3Var, str, an3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = sm3Var;
            this.a = str;
            this.b = an3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(fh3<hh3.e> fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) == null) {
                if (!ah3.h(fh3Var)) {
                    int b = fh3Var.b();
                    c92.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + ah3.f(b));
                    this.c.d(this.a, new c42(b, ah3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948156176, "Lcom/baidu/tieba/sm3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948156176, "Lcom/baidu/tieba/sm3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sm3(@NonNull d02 d02Var) {
        super(d02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d02Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, an3 an3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, an3Var) == null) {
            SwanAppActivity w = bc3.K().w();
            e73.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, an3Var, str));
        }
    }

    public c42 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            cc3 b0 = cc3.b0();
            if (b0 == null) {
                c92.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new c42(1001, "swan app is null");
            } else if (b0.w() == null) {
                c92.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new c42(1001, "swan activity is null");
            } else {
                Pair<c42, JSONObject> s = s(str);
                c42 c42Var = (c42) s.first;
                if (!c42Var.isSuccess()) {
                    return c42Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c92.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new c42(201, "callback is null");
                }
                an3 a2 = an3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    c92.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new c42(12008, "invalid ssid");
                } else if (b0.n0()) {
                    c92.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new c42((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return c42.f();
                }
            }
        }
        return (c42) invokeL.objValue;
    }

    public c42 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            cc3 b0 = cc3.b0();
            if (b0 == null) {
                c92.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new c42(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                c92.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new c42(1001, "swan activity is null");
            }
            Pair<c42, JSONObject> s = s(str);
            c42 c42Var = (c42) s.first;
            if (!c42Var.isSuccess()) {
                return c42Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c92.c("WifiApi", "startWifi: 201 : callback is null");
                return new c42(201, "callback is null");
            }
            zm3 s2 = zm3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return c42.f();
            }
            c92.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new c42(12010, "unknown failed");
        }
        return (c42) invokeL.objValue;
    }

    public c42 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            cc3 b0 = cc3.b0();
            if (b0 == null) {
                c92.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new c42(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                c92.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new c42(1001, "swan activity is null");
            }
            Pair<c42, JSONObject> s = s(str);
            c42 c42Var = (c42) s.first;
            if (!c42Var.isSuccess()) {
                return c42Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c92.c("WifiApi", "stopWifi: 201 : callback is null");
                return new c42(201, "callback is null");
            }
            zm3 s2 = zm3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return c42.f();
            }
            c92.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new c42(12010, "unknown failed");
        }
        return (c42) invokeL.objValue;
    }

    public c42 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            cc3 b0 = cc3.b0();
            if (b0 == null) {
                c92.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new c42(1001, "swan app is null");
            } else if (b0.w() == null) {
                c92.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new c42(1001, "swan activity is null");
            } else {
                Pair<c42, JSONObject> s = s(str);
                c42 c42Var = (c42) s.first;
                if (!c42Var.isSuccess()) {
                    return c42Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c92.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new c42(201, "callback is null");
                } else if (b0.n0()) {
                    c92.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new c42((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return c42.f();
                }
            }
        }
        return (c42) invokeL.objValue;
    }

    public c42 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            cc3 b0 = cc3.b0();
            if (b0 == null) {
                c92.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new c42(1001, "swan app is null");
            } else if (b0.w() == null) {
                c92.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new c42(1001, "swan activity is null");
            } else {
                Pair<c42, JSONObject> s = s(str);
                c42 c42Var = (c42) s.first;
                if (!c42Var.isSuccess()) {
                    return c42Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c92.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new c42(201, "callback is null");
                } else if (b0.n0()) {
                    c92.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new c42((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return c42.f();
                }
            }
        }
        return (c42) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = bc3.K().w();
            e73.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = bc3.K().w();
            e73.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
