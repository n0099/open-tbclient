package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.f63;
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
public class qb3 extends dp1 {
    public static /* synthetic */ Interceptable $ic;
    public static final tf3<ac3<zb3>> f;
    public static final tf3<ac3<List<zb3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements dw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ yb3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ qb3 d;

        /* renamed from: com.baidu.tieba.qb3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0384a implements tf3<ac3<zb3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0384a(a aVar) {
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
            @Override // com.baidu.tieba.tf3
            /* renamed from: b */
            public void a(ac3<zb3> ac3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ac3Var) == null) {
                    if (ac3Var.a != 0) {
                        ay1.i("WifiApi", "connectWifi: " + ac3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ac3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ac3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ac3Var.c.n());
                        } catch (JSONException e) {
                            ay1.i("WifiApi", "getConnectedWifi: " + ac3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ac3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ac3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    aVar.d.d(aVar.c, jSONObject == null ? new at1(ac3Var.a, ac3Var.b) : new at1(ac3Var.a, ac3Var.b, jSONObject));
                }
            }
        }

        public a(qb3 qb3Var, Activity activity, yb3 yb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb3Var, activity, yb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = qb3Var;
            this.a = activity;
            this.b = yb3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.dw2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                xb3.s(this.a).a(this.b, new C0384a(this));
            }
        }

        @Override // com.baidu.tieba.dw2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ay1.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new at1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements tf3<ac3<zb3>> {
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
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(ac3<zb3> ac3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ac3Var) == null) || ac3Var == null || ac3Var.a != 0 || ac3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", ac3Var.c);
            } catch (JSONException e) {
                ay1.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            nm2.U().u(new bb2("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements tf3<ac3<List<zb3>>> {
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
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(ac3<List<zb3>> ac3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ac3Var) == null) || ac3Var == null || ac3Var.a != 0 || ac3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (zb3 zb3Var : ac3Var.c) {
                jSONArray.put(zb3Var);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e) {
                ay1.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            nm2.U().u(new bb2("getWifiList", hashMap));
        }
    }

    /* loaded from: classes5.dex */
    public class d implements tf3<ac3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qb3 b;

        public d(qb3 qb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qb3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(ac3<Void> ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ac3Var) == null) {
                if (ac3Var.a != 0) {
                    ay1.i("WifiApi", "startWifi: " + ac3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ac3Var.b);
                }
                this.b.d(this.a, new at1(ac3Var.a, ac3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements tf3<ac3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qb3 b;

        public e(qb3 qb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qb3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(ac3<Void> ac3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ac3Var) == null) {
                if (ac3Var.a != 0) {
                    ay1.i("WifiApi", "stopWifi: " + ac3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ac3Var.b);
                }
                this.b.d(this.a, new at1(ac3Var.a, ac3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements tf3<d63<f63.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qb3 b;

        public f(qb3 qb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qb3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(d63<f63.e> d63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d63Var) == null) {
                if (y53.h(d63Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = d63Var.b();
                ay1.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + y53.f(b));
                this.b.d(this.a, new at1(b, y53.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements dw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ qb3 c;

        /* loaded from: classes5.dex */
        public class a implements tf3<ac3<Void>> {
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
            @Override // com.baidu.tieba.tf3
            /* renamed from: b */
            public void a(ac3<Void> ac3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ac3Var) == null) {
                    if (ac3Var.a != 0) {
                        ay1.i("WifiApi", "getWifiList: " + ac3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ac3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new at1(ac3Var.a, ac3Var.b));
                }
            }
        }

        public g(qb3 qb3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qb3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.dw2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                xb3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.dw2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ay1.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new at1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements tf3<d63<f63.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qb3 b;

        public h(qb3 qb3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qb3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(d63<f63.e> d63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d63Var) == null) {
                if (y53.h(d63Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = d63Var.b();
                ay1.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + y53.f(b));
                this.b.d(this.a, new at1(b, y53.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements dw2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ qb3 c;

        /* loaded from: classes5.dex */
        public class a implements tf3<ac3<zb3>> {
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
            @Override // com.baidu.tieba.tf3
            /* renamed from: b */
            public void a(ac3<zb3> ac3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ac3Var) == null) {
                    if (ac3Var.a != 0) {
                        ay1.i("WifiApi", "getConnectedWifi: " + ac3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ac3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ac3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ac3Var.c.n());
                        } catch (JSONException e) {
                            ay1.i("WifiApi", "getConnectedWifi: " + ac3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ac3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ac3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    iVar.c.d(iVar.b, jSONObject == null ? new at1(ac3Var.a, ac3Var.b) : new at1(ac3Var.a, ac3Var.b, jSONObject));
                }
            }
        }

        public i(qb3 qb3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qb3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.dw2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                xb3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.dw2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                ay1.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new at1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements tf3<d63<f63.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yb3 b;
        public final /* synthetic */ qb3 c;

        public j(qb3 qb3Var, String str, yb3 yb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qb3Var, str, yb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qb3Var;
            this.a = str;
            this.b = yb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.tf3
        /* renamed from: b */
        public void a(d63<f63.e> d63Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d63Var) == null) {
                if (y53.h(d63Var)) {
                    this.c.D(this.a, this.b);
                    return;
                }
                int b = d63Var.b();
                ay1.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + y53.f(b));
                this.c.d(this.a, new at1(b, y53.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948086023, "Lcom/baidu/tieba/qb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948086023, "Lcom/baidu/tieba/qb3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qb3(@NonNull bp1 bp1Var) {
        super(bp1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bp1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((bp1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public at1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            a13 b0 = a13.b0();
            if (b0 == null) {
                ay1.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new at1(1001, "swan app is null");
            } else if (b0.w() == null) {
                ay1.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new at1(1001, "swan activity is null");
            } else {
                Pair<at1, JSONObject> s = s(str);
                at1 at1Var = (at1) s.first;
                if (at1Var.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        ay1.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new at1(201, "callback is null");
                    }
                    yb3 a2 = yb3.a(jSONObject);
                    if (TextUtils.isEmpty(a2.a)) {
                        ay1.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new at1(12008, "invalid ssid");
                    } else if (b0.n0()) {
                        ay1.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new at1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                        return at1.f();
                    }
                }
                return at1Var;
            }
        }
        return (at1) invokeL.objValue;
    }

    public at1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            a13 b0 = a13.b0();
            if (b0 == null) {
                ay1.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new at1(1001, "swan app is null");
            } else if (b0.w() == null) {
                ay1.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new at1(1001, "swan activity is null");
            } else {
                Pair<at1, JSONObject> s = s(str);
                at1 at1Var = (at1) s.first;
                if (at1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        ay1.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new at1(201, "callback is null");
                    } else if (b0.n0()) {
                        ay1.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new at1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                        return at1.f();
                    }
                }
                return at1Var;
            }
        }
        return (at1) invokeL.objValue;
    }

    public at1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            a13 b0 = a13.b0();
            if (b0 == null) {
                ay1.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new at1(1001, "swan app is null");
            } else if (b0.w() == null) {
                ay1.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new at1(1001, "swan activity is null");
            } else {
                Pair<at1, JSONObject> s = s(str);
                at1 at1Var = (at1) s.first;
                if (at1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        ay1.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new at1(201, "callback is null");
                    } else if (b0.n0()) {
                        ay1.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new at1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                        return at1.f();
                    }
                }
                return at1Var;
            }
        }
        return (at1) invokeL.objValue;
    }

    public final void D(String str, yb3 yb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, yb3Var) == null) {
            SwanAppActivity w = z03.K().w();
            cw2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, yb3Var, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = z03.K().w();
            cw2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = z03.K().w();
            cw2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }

    public at1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            a13 b0 = a13.b0();
            if (b0 == null) {
                ay1.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new at1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                ay1.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new at1(1001, "swan activity is null");
            }
            Pair<at1, JSONObject> s = s(str);
            at1 at1Var = (at1) s.first;
            if (at1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    ay1.c("WifiApi", "startWifi: 201 : callback is null");
                    return new at1(201, "callback is null");
                }
                xb3 s2 = xb3.s(w);
                if (s2.n(f) && s2.d(g)) {
                    s2.p(new d(this, optString));
                    return at1.f();
                }
                ay1.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new at1(12010, "unknown failed");
            }
            return at1Var;
        }
        return (at1) invokeL.objValue;
    }

    public at1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            a13 b0 = a13.b0();
            if (b0 == null) {
                ay1.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new at1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                ay1.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new at1(1001, "swan activity is null");
            }
            Pair<at1, JSONObject> s = s(str);
            at1 at1Var = (at1) s.first;
            if (at1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    ay1.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new at1(201, "callback is null");
                }
                xb3 s2 = xb3.s(w);
                if (s2.r(f) && s2.b(g)) {
                    s2.q(new e(this, optString));
                    return at1.f();
                }
                ay1.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new at1(12010, "unknown failed");
            }
            return at1Var;
        }
        return (at1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dp1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
