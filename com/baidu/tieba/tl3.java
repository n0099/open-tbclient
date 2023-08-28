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
import com.baidu.tieba.ig3;
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
public class tl3 extends gz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final wp3<dm3<cm3>> f;
    public static final wp3<dm3<List<cm3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a implements g63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ bm3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ tl3 d;

        /* renamed from: com.baidu.tieba.tl3$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0488a implements wp3<dm3<cm3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0488a(a aVar) {
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
            @Override // com.baidu.tieba.wp3
            /* renamed from: b */
            public void a(dm3<cm3> dm3Var) {
                d32 d32Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm3Var) == null) {
                    if (dm3Var.a != 0) {
                        d82.i("WifiApi", "connectWifi: " + dm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + dm3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (dm3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", dm3Var.c.n());
                        } catch (JSONException e) {
                            d82.i("WifiApi", "getConnectedWifi: " + dm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + dm3Var.b + ZeusCrashHandler.NAME_SEPERATOR + dm3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    tl3 tl3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        d32Var = new d32(dm3Var.a, dm3Var.b);
                    } else {
                        d32Var = new d32(dm3Var.a, dm3Var.b, jSONObject);
                    }
                    tl3Var.d(str, d32Var);
                }
            }
        }

        public a(tl3 tl3Var, Activity activity, bm3 bm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl3Var, activity, bm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = tl3Var;
            this.a = activity;
            this.b = bm3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.g63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                am3.s(this.a).a(this.b, new C0488a(this));
            }
        }

        @Override // com.baidu.tieba.g63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                d82.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new d32(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements g63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tl3 c;

        /* loaded from: classes8.dex */
        public class a implements wp3<dm3<Void>> {
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
            @Override // com.baidu.tieba.wp3
            /* renamed from: b */
            public void a(dm3<Void> dm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm3Var) == null) {
                    if (dm3Var.a != 0) {
                        d82.i("WifiApi", "getWifiList: " + dm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + dm3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new d32(dm3Var.a, dm3Var.b));
                }
            }
        }

        public g(tl3 tl3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tl3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.g63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                am3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.g63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                d82.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new d32(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements g63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ tl3 c;

        /* loaded from: classes8.dex */
        public class a implements wp3<dm3<cm3>> {
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
            @Override // com.baidu.tieba.wp3
            /* renamed from: b */
            public void a(dm3<cm3> dm3Var) {
                d32 d32Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm3Var) == null) {
                    if (dm3Var.a != 0) {
                        d82.i("WifiApi", "getConnectedWifi: " + dm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + dm3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (dm3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", dm3Var.c.n());
                        } catch (JSONException e) {
                            d82.i("WifiApi", "getConnectedWifi: " + dm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + dm3Var.b + ZeusCrashHandler.NAME_SEPERATOR + dm3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    tl3 tl3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        d32Var = new d32(dm3Var.a, dm3Var.b);
                    } else {
                        d32Var = new d32(dm3Var.a, dm3Var.b, jSONObject);
                    }
                    tl3Var.d(str, d32Var);
                }
            }
        }

        public i(tl3 tl3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tl3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.g63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                am3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.g63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                d82.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new d32(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements wp3<dm3<cm3>> {
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
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(dm3<cm3> dm3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm3Var) == null) && dm3Var != null && dm3Var.a == 0 && dm3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", dm3Var.c);
                } catch (JSONException e) {
                    d82.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                qw2.T().u(new el2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements wp3<dm3<List<cm3>>> {
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
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(dm3<List<cm3>> dm3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm3Var) == null) && dm3Var != null && dm3Var.a == 0 && dm3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (cm3 cm3Var : dm3Var.c) {
                    jSONArray.put(cm3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    d82.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                qw2.T().u(new el2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements wp3<dm3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tl3 b;

        public d(tl3 tl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(dm3<Void> dm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm3Var) == null) {
                if (dm3Var.a != 0) {
                    d82.i("WifiApi", "startWifi: " + dm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + dm3Var.b);
                }
                this.b.d(this.a, new d32(dm3Var.a, dm3Var.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements wp3<dm3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tl3 b;

        public e(tl3 tl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(dm3<Void> dm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dm3Var) == null) {
                if (dm3Var.a != 0) {
                    d82.i("WifiApi", "stopWifi: " + dm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + dm3Var.b);
                }
                this.b.d(this.a, new d32(dm3Var.a, dm3Var.b));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tl3 b;

        public f(tl3 tl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (bg3.h(gg3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = gg3Var.b();
                d82.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + bg3.f(b));
                this.b.d(this.a, new d32(b, bg3.f(b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tl3 b;

        public h(tl3 tl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tl3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (bg3.h(gg3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = gg3Var.b();
                d82.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + bg3.f(b));
                this.b.d(this.a, new d32(b, bg3.f(b)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ bm3 b;
        public final /* synthetic */ tl3 c;

        public j(tl3 tl3Var, String str, bm3 bm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl3Var, str, bm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tl3Var;
            this.a = str;
            this.b = bm3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (!bg3.h(gg3Var)) {
                    int b = gg3Var.b();
                    d82.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + bg3.f(b));
                    this.c.d(this.a, new d32(b, bg3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948185006, "Lcom/baidu/tieba/tl3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948185006, "Lcom/baidu/tieba/tl3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tl3(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ez1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, bm3 bm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, bm3Var) == null) {
            SwanAppActivity w = cb3.K().w();
            f63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, bm3Var, str));
        }
    }

    public d32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            db3 b0 = db3.b0();
            if (b0 == null) {
                d82.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new d32(1001, "swan app is null");
            } else if (b0.w() == null) {
                d82.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new d32(1001, "swan activity is null");
            } else {
                Pair<d32, JSONObject> s = s(str);
                d32 d32Var = (d32) s.first;
                if (!d32Var.isSuccess()) {
                    return d32Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    d82.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new d32(201, "callback is null");
                }
                bm3 a2 = bm3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    d82.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new d32(12008, "invalid ssid");
                } else if (b0.n0()) {
                    d82.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new d32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return d32.f();
                }
            }
        }
        return (d32) invokeL.objValue;
    }

    public d32 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            db3 b0 = db3.b0();
            if (b0 == null) {
                d82.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new d32(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                d82.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new d32(1001, "swan activity is null");
            }
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d82.c("WifiApi", "startWifi: 201 : callback is null");
                return new d32(201, "callback is null");
            }
            am3 s2 = am3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return d32.f();
            }
            d82.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new d32(12010, "unknown failed");
        }
        return (d32) invokeL.objValue;
    }

    public d32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            db3 b0 = db3.b0();
            if (b0 == null) {
                d82.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new d32(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                d82.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new d32(1001, "swan activity is null");
            }
            Pair<d32, JSONObject> s = s(str);
            d32 d32Var = (d32) s.first;
            if (!d32Var.isSuccess()) {
                return d32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d82.c("WifiApi", "stopWifi: 201 : callback is null");
                return new d32(201, "callback is null");
            }
            am3 s2 = am3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return d32.f();
            }
            d82.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new d32(12010, "unknown failed");
        }
        return (d32) invokeL.objValue;
    }

    public d32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            db3 b0 = db3.b0();
            if (b0 == null) {
                d82.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new d32(1001, "swan app is null");
            } else if (b0.w() == null) {
                d82.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new d32(1001, "swan activity is null");
            } else {
                Pair<d32, JSONObject> s = s(str);
                d32 d32Var = (d32) s.first;
                if (!d32Var.isSuccess()) {
                    return d32Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    d82.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new d32(201, "callback is null");
                } else if (b0.n0()) {
                    d82.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new d32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return d32.f();
                }
            }
        }
        return (d32) invokeL.objValue;
    }

    public d32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            db3 b0 = db3.b0();
            if (b0 == null) {
                d82.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new d32(1001, "swan app is null");
            } else if (b0.w() == null) {
                d82.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new d32(1001, "swan activity is null");
            } else {
                Pair<d32, JSONObject> s = s(str);
                d32 d32Var = (d32) s.first;
                if (!d32Var.isSuccess()) {
                    return d32Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    d82.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new d32(201, "callback is null");
                } else if (b0.n0()) {
                    d82.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new d32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return d32.f();
                }
            }
        }
        return (d32) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = cb3.K().w();
            f63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = cb3.K().w();
            f63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
