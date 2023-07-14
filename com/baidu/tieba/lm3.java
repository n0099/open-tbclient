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
import com.baidu.tieba.ah3;
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
/* loaded from: classes6.dex */
public class lm3 extends yz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final oq3<vm3<um3>> f;
    public static final oq3<vm3<List<um3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements y63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ tm3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ lm3 d;

        /* renamed from: com.baidu.tieba.lm3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0395a implements oq3<vm3<um3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0395a(a aVar) {
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
            @Override // com.baidu.tieba.oq3
            /* renamed from: b */
            public void a(vm3<um3> vm3Var) {
                v32 v32Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vm3Var) == null) {
                    if (vm3Var.a != 0) {
                        v82.i("WifiApi", "connectWifi: " + vm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vm3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (vm3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", vm3Var.c.n());
                        } catch (JSONException e) {
                            v82.i("WifiApi", "getConnectedWifi: " + vm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vm3Var.b + ZeusCrashHandler.NAME_SEPERATOR + vm3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    lm3 lm3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        v32Var = new v32(vm3Var.a, vm3Var.b);
                    } else {
                        v32Var = new v32(vm3Var.a, vm3Var.b, jSONObject);
                    }
                    lm3Var.d(str, v32Var);
                }
            }
        }

        public a(lm3 lm3Var, Activity activity, tm3 tm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm3Var, activity, tm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = lm3Var;
            this.a = activity;
            this.b = tm3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.y63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                sm3.s(this.a).a(this.b, new C0395a(this));
            }
        }

        @Override // com.baidu.tieba.y63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                v82.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new v32(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements y63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lm3 c;

        /* loaded from: classes6.dex */
        public class a implements oq3<vm3<Void>> {
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
            @Override // com.baidu.tieba.oq3
            /* renamed from: b */
            public void a(vm3<Void> vm3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vm3Var) == null) {
                    if (vm3Var.a != 0) {
                        v82.i("WifiApi", "getWifiList: " + vm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vm3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new v32(vm3Var.a, vm3Var.b));
                }
            }
        }

        public g(lm3 lm3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lm3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.y63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                sm3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.y63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                v82.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new v32(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements y63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ lm3 c;

        /* loaded from: classes6.dex */
        public class a implements oq3<vm3<um3>> {
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
            @Override // com.baidu.tieba.oq3
            /* renamed from: b */
            public void a(vm3<um3> vm3Var) {
                v32 v32Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vm3Var) == null) {
                    if (vm3Var.a != 0) {
                        v82.i("WifiApi", "getConnectedWifi: " + vm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vm3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (vm3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", vm3Var.c.n());
                        } catch (JSONException e) {
                            v82.i("WifiApi", "getConnectedWifi: " + vm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vm3Var.b + ZeusCrashHandler.NAME_SEPERATOR + vm3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    lm3 lm3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        v32Var = new v32(vm3Var.a, vm3Var.b);
                    } else {
                        v32Var = new v32(vm3Var.a, vm3Var.b, jSONObject);
                    }
                    lm3Var.d(str, v32Var);
                }
            }
        }

        public i(lm3 lm3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lm3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.y63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                sm3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.y63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                v82.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new v32(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements oq3<vm3<um3>> {
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
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(vm3<um3> vm3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vm3Var) == null) && vm3Var != null && vm3Var.a == 0 && vm3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", vm3Var.c);
                } catch (JSONException e) {
                    v82.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                ix2.T().u(new wl2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements oq3<vm3<List<um3>>> {
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
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(vm3<List<um3>> vm3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vm3Var) == null) && vm3Var != null && vm3Var.a == 0 && vm3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (um3 um3Var : vm3Var.c) {
                    jSONArray.put(um3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    v82.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                ix2.T().u(new wl2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements oq3<vm3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lm3 b;

        public d(lm3 lm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lm3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(vm3<Void> vm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vm3Var) == null) {
                if (vm3Var.a != 0) {
                    v82.i("WifiApi", "startWifi: " + vm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vm3Var.b);
                }
                this.b.d(this.a, new v32(vm3Var.a, vm3Var.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements oq3<vm3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lm3 b;

        public e(lm3 lm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lm3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(vm3<Void> vm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vm3Var) == null) {
                if (vm3Var.a != 0) {
                    v82.i("WifiApi", "stopWifi: " + vm3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vm3Var.b);
                }
                this.b.d(this.a, new v32(vm3Var.a, vm3Var.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lm3 b;

        public f(lm3 lm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lm3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (tg3.h(yg3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = yg3Var.b();
                v82.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + tg3.f(b));
                this.b.d(this.a, new v32(b, tg3.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lm3 b;

        public h(lm3 lm3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = lm3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (tg3.h(yg3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = yg3Var.b();
                v82.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + tg3.f(b));
                this.b.d(this.a, new v32(b, tg3.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements oq3<yg3<ah3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tm3 b;
        public final /* synthetic */ lm3 c;

        public j(lm3 lm3Var, String str, tm3 tm3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lm3Var, str, tm3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lm3Var;
            this.a = str;
            this.b = tm3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.oq3
        /* renamed from: b */
        public void a(yg3<ah3.e> yg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yg3Var) == null) {
                if (!tg3.h(yg3Var)) {
                    int b = yg3Var.b();
                    v82.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + tg3.f(b));
                    this.c.d(this.a, new v32(b, tg3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947947639, "Lcom/baidu/tieba/lm3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947947639, "Lcom/baidu/tieba/lm3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lm3(@NonNull wz1 wz1Var) {
        super(wz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((wz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, tm3 tm3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, tm3Var) == null) {
            SwanAppActivity w = ub3.K().w();
            x63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, tm3Var, str));
        }
    }

    public v32 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                v82.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new v32(1001, "swan app is null");
            } else if (b0.w() == null) {
                v82.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new v32(1001, "swan activity is null");
            } else {
                Pair<v32, JSONObject> s = s(str);
                v32 v32Var = (v32) s.first;
                if (!v32Var.isSuccess()) {
                    return v32Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    v82.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new v32(201, "callback is null");
                }
                tm3 a2 = tm3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    v82.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new v32(12008, "invalid ssid");
                } else if (b0.n0()) {
                    v82.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new v32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return v32.f();
                }
            }
        }
        return (v32) invokeL.objValue;
    }

    public v32 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                v82.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new v32(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                v82.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new v32(1001, "swan activity is null");
            }
            Pair<v32, JSONObject> s = s(str);
            v32 v32Var = (v32) s.first;
            if (!v32Var.isSuccess()) {
                return v32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                v82.c("WifiApi", "startWifi: 201 : callback is null");
                return new v32(201, "callback is null");
            }
            sm3 s2 = sm3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return v32.f();
            }
            v82.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new v32(12010, "unknown failed");
        }
        return (v32) invokeL.objValue;
    }

    public v32 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                v82.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new v32(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                v82.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new v32(1001, "swan activity is null");
            }
            Pair<v32, JSONObject> s = s(str);
            v32 v32Var = (v32) s.first;
            if (!v32Var.isSuccess()) {
                return v32Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                v82.c("WifiApi", "stopWifi: 201 : callback is null");
                return new v32(201, "callback is null");
            }
            sm3 s2 = sm3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return v32.f();
            }
            v82.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new v32(12010, "unknown failed");
        }
        return (v32) invokeL.objValue;
    }

    public v32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                v82.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new v32(1001, "swan app is null");
            } else if (b0.w() == null) {
                v82.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new v32(1001, "swan activity is null");
            } else {
                Pair<v32, JSONObject> s = s(str);
                v32 v32Var = (v32) s.first;
                if (!v32Var.isSuccess()) {
                    return v32Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    v82.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new v32(201, "callback is null");
                } else if (b0.n0()) {
                    v82.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new v32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return v32.f();
                }
            }
        }
        return (v32) invokeL.objValue;
    }

    public v32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                v82.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new v32(1001, "swan app is null");
            } else if (b0.w() == null) {
                v82.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new v32(1001, "swan activity is null");
            } else {
                Pair<v32, JSONObject> s = s(str);
                v32 v32Var = (v32) s.first;
                if (!v32Var.isSuccess()) {
                    return v32Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    v82.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new v32(201, "callback is null");
                } else if (b0.n0()) {
                    v82.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new v32((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return v32.f();
                }
            }
        }
        return (v32) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = ub3.K().w();
            x63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = ub3.K().w();
            x63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
