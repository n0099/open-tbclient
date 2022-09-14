package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.d83;
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
public class od3 extends br1 {
    public static /* synthetic */ Interceptable $ic;
    public static final rh3<yd3<xd3>> f;
    public static final rh3<yd3<List<xd3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements by2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ wd3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ od3 d;

        /* renamed from: com.baidu.tieba.od3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0355a implements rh3<yd3<xd3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0355a(a aVar) {
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
            @Override // com.baidu.tieba.rh3
            /* renamed from: b */
            public void a(yd3<xd3> yd3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yd3Var) == null) {
                    if (yd3Var.a != 0) {
                        yz1.i("WifiApi", "connectWifi: " + yd3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yd3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (yd3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", yd3Var.c.n());
                        } catch (JSONException e) {
                            yz1.i("WifiApi", "getConnectedWifi: " + yd3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yd3Var.b + ZeusCrashHandler.NAME_SEPERATOR + yd3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    aVar.d.d(aVar.c, jSONObject == null ? new yu1(yd3Var.a, yd3Var.b) : new yu1(yd3Var.a, yd3Var.b, jSONObject));
                }
            }
        }

        public a(od3 od3Var, Activity activity, wd3 wd3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od3Var, activity, wd3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = od3Var;
            this.a = activity;
            this.b = wd3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.by2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vd3.s(this.a).a(this.b, new C0355a(this));
            }
        }

        @Override // com.baidu.tieba.by2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                yz1.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new yu1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements rh3<yd3<xd3>> {
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
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(yd3<xd3> yd3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yd3Var) == null) || yd3Var == null || yd3Var.a != 0 || yd3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("wifiInfo", yd3Var.c);
            } catch (JSONException e) {
                yz1.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            lo2.U().u(new zc2("wifiConnected", hashMap));
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements rh3<yd3<List<xd3>>> {
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
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(yd3<List<xd3>> yd3Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yd3Var) == null) || yd3Var == null || yd3Var.a != 0 || yd3Var.c == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (xd3 xd3Var : yd3Var.c) {
                jSONArray.put(xd3Var);
            }
            try {
                jSONObject.put("wifiList", jSONArray);
            } catch (JSONException e) {
                yz1.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject.toString());
            lo2.U().u(new zc2("getWifiList", hashMap));
        }
    }

    /* loaded from: classes5.dex */
    public class d implements rh3<yd3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ od3 b;

        public d(od3 od3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = od3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(yd3<Void> yd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yd3Var) == null) {
                if (yd3Var.a != 0) {
                    yz1.i("WifiApi", "startWifi: " + yd3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yd3Var.b);
                }
                this.b.d(this.a, new yu1(yd3Var.a, yd3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements rh3<yd3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ od3 b;

        public e(od3 od3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = od3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(yd3<Void> yd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yd3Var) == null) {
                if (yd3Var.a != 0) {
                    yz1.i("WifiApi", "stopWifi: " + yd3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yd3Var.b);
                }
                this.b.d(this.a, new yu1(yd3Var.a, yd3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements rh3<b83<d83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ od3 b;

        public f(od3 od3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = od3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(b83<d83.e> b83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b83Var) == null) {
                if (w73.h(b83Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = b83Var.b();
                yz1.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + w73.f(b));
                this.b.d(this.a, new yu1(b, w73.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements by2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ od3 c;

        /* loaded from: classes5.dex */
        public class a implements rh3<yd3<Void>> {
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
            @Override // com.baidu.tieba.rh3
            /* renamed from: b */
            public void a(yd3<Void> yd3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yd3Var) == null) {
                    if (yd3Var.a != 0) {
                        yz1.i("WifiApi", "getWifiList: " + yd3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yd3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new yu1(yd3Var.a, yd3Var.b));
                }
            }
        }

        public g(od3 od3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = od3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.by2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vd3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.by2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                yz1.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new yu1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements rh3<b83<d83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ od3 b;

        public h(od3 od3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = od3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(b83<d83.e> b83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b83Var) == null) {
                if (w73.h(b83Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = b83Var.b();
                yz1.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + w73.f(b));
                this.b.d(this.a, new yu1(b, w73.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements by2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ od3 c;

        /* loaded from: classes5.dex */
        public class a implements rh3<yd3<xd3>> {
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
            @Override // com.baidu.tieba.rh3
            /* renamed from: b */
            public void a(yd3<xd3> yd3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yd3Var) == null) {
                    if (yd3Var.a != 0) {
                        yz1.i("WifiApi", "getConnectedWifi: " + yd3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yd3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (yd3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", yd3Var.c.n());
                        } catch (JSONException e) {
                            yz1.i("WifiApi", "getConnectedWifi: " + yd3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yd3Var.b + ZeusCrashHandler.NAME_SEPERATOR + yd3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    iVar.c.d(iVar.b, jSONObject == null ? new yu1(yd3Var.a, yd3Var.b) : new yu1(yd3Var.a, yd3Var.b, jSONObject));
                }
            }
        }

        public i(od3 od3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = od3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.by2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vd3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.by2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                yz1.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new yu1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements rh3<b83<d83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wd3 b;
        public final /* synthetic */ od3 c;

        public j(od3 od3Var, String str, wd3 wd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od3Var, str, wd3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = od3Var;
            this.a = str;
            this.b = wd3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(b83<d83.e> b83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b83Var) == null) {
                if (w73.h(b83Var)) {
                    this.c.D(this.a, this.b);
                    return;
                }
                int b = b83Var.b();
                yz1.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + w73.f(b));
                this.c.d(this.a, new yu1(b, w73.f(b)));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948028363, "Lcom/baidu/tieba/od3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948028363, "Lcom/baidu/tieba/od3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public od3(@NonNull zq1 zq1Var) {
        super(zq1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zq1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((zq1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public yu1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            y23 b0 = y23.b0();
            if (b0 == null) {
                yz1.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new yu1(1001, "swan app is null");
            } else if (b0.w() == null) {
                yz1.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new yu1(1001, "swan activity is null");
            } else {
                Pair<yu1, JSONObject> s = s(str);
                yu1 yu1Var = (yu1) s.first;
                if (yu1Var.isSuccess()) {
                    JSONObject jSONObject = (JSONObject) s.second;
                    String optString = jSONObject.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        yz1.c("WifiApi", "connectWifi: 201 : callback is null");
                        return new yu1(201, "callback is null");
                    }
                    wd3 a2 = wd3.a(jSONObject);
                    if (TextUtils.isEmpty(a2.a)) {
                        yz1.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                        return new yu1(12008, "invalid ssid");
                    } else if (b0.n0()) {
                        yz1.i("WifiApi", "connectWifi: 12011 : app is invisible");
                        return new yu1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                        return yu1.f();
                    }
                }
                return yu1Var;
            }
        }
        return (yu1) invokeL.objValue;
    }

    public yu1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            y23 b0 = y23.b0();
            if (b0 == null) {
                yz1.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new yu1(1001, "swan app is null");
            } else if (b0.w() == null) {
                yz1.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new yu1(1001, "swan activity is null");
            } else {
                Pair<yu1, JSONObject> s = s(str);
                yu1 yu1Var = (yu1) s.first;
                if (yu1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        yz1.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                        return new yu1(201, "callback is null");
                    } else if (b0.n0()) {
                        yz1.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                        return new yu1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                        return yu1.f();
                    }
                }
                return yu1Var;
            }
        }
        return (yu1) invokeL.objValue;
    }

    public yu1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            y23 b0 = y23.b0();
            if (b0 == null) {
                yz1.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new yu1(1001, "swan app is null");
            } else if (b0.w() == null) {
                yz1.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new yu1(1001, "swan activity is null");
            } else {
                Pair<yu1, JSONObject> s = s(str);
                yu1 yu1Var = (yu1) s.first;
                if (yu1Var.isSuccess()) {
                    String optString = ((JSONObject) s.second).optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        yz1.c("WifiApi", "getWifiList: 201 : callback is null");
                        return new yu1(201, "callback is null");
                    } else if (b0.n0()) {
                        yz1.i("WifiApi", "getWifiList: 12011 : app is invisible");
                        return new yu1(12011, "app is invisible");
                    } else {
                        b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                        return yu1.f();
                    }
                }
                return yu1Var;
            }
        }
        return (yu1) invokeL.objValue;
    }

    public final void D(String str, wd3 wd3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, wd3Var) == null) {
            SwanAppActivity w = x23.K().w();
            ay2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, wd3Var, str));
        }
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = x23.K().w();
            ay2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = x23.K().w();
            ay2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }

    public yu1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            y23 b0 = y23.b0();
            if (b0 == null) {
                yz1.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new yu1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                yz1.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new yu1(1001, "swan activity is null");
            }
            Pair<yu1, JSONObject> s = s(str);
            yu1 yu1Var = (yu1) s.first;
            if (yu1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    yz1.c("WifiApi", "startWifi: 201 : callback is null");
                    return new yu1(201, "callback is null");
                }
                vd3 s2 = vd3.s(w);
                if (s2.n(f) && s2.d(g)) {
                    s2.p(new d(this, optString));
                    return yu1.f();
                }
                yz1.i("WifiApi", "startWifi: 12010 : unknown failed");
                return new yu1(12010, "unknown failed");
            }
            return yu1Var;
        }
        return (yu1) invokeL.objValue;
    }

    public yu1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            y23 b0 = y23.b0();
            if (b0 == null) {
                yz1.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new yu1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                yz1.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new yu1(1001, "swan activity is null");
            }
            Pair<yu1, JSONObject> s = s(str);
            yu1 yu1Var = (yu1) s.first;
            if (yu1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    yz1.c("WifiApi", "stopWifi: 201 : callback is null");
                    return new yu1(201, "callback is null");
                }
                vd3 s2 = vd3.s(w);
                if (s2.r(f) && s2.b(g)) {
                    s2.q(new e(this, optString));
                    return yu1.f();
                }
                yz1.i("WifiApi", "stopWifi: 12010 : unknown failed");
                return new yu1(12010, "unknown failed");
            }
            return yu1Var;
        }
        return (yu1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.br1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.br1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }
}
