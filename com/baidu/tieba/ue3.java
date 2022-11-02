package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.j93;
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
public class ue3 extends hs1 {
    public static /* synthetic */ Interceptable $ic;
    public static final xi3<ef3<df3>> f;
    public static final xi3<ef3<List<df3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.hs1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hs1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements hz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ cf3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ue3 d;

        /* renamed from: com.baidu.tieba.ue3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0434a implements xi3<ef3<df3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0434a(a aVar) {
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
            @Override // com.baidu.tieba.xi3
            /* renamed from: b */
            public void a(ef3<df3> ef3Var) {
                ew1 ew1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef3Var) == null) {
                    if (ef3Var.a != 0) {
                        e12.i("WifiApi", "connectWifi: " + ef3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ef3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ef3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ef3Var.c.n());
                        } catch (JSONException e) {
                            e12.i("WifiApi", "getConnectedWifi: " + ef3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ef3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ef3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    ue3 ue3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        ew1Var = new ew1(ef3Var.a, ef3Var.b);
                    } else {
                        ew1Var = new ew1(ef3Var.a, ef3Var.b, jSONObject);
                    }
                    ue3Var.d(str, ew1Var);
                }
            }
        }

        public a(ue3 ue3Var, Activity activity, cf3 cf3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, activity, cf3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ue3Var;
            this.a = activity;
            this.b = cf3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.hz2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                bf3.s(this.a).a(this.b, new C0434a(this));
            }
        }

        @Override // com.baidu.tieba.hz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                e12.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new ew1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements hz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ue3 c;

        /* loaded from: classes6.dex */
        public class a implements xi3<ef3<Void>> {
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
            @Override // com.baidu.tieba.xi3
            /* renamed from: b */
            public void a(ef3<Void> ef3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef3Var) == null) {
                    if (ef3Var.a != 0) {
                        e12.i("WifiApi", "getWifiList: " + ef3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ef3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new ew1(ef3Var.a, ef3Var.b));
                }
            }
        }

        public g(ue3 ue3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ue3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.hz2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                bf3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.hz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                e12.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new ew1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements hz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ue3 c;

        /* loaded from: classes6.dex */
        public class a implements xi3<ef3<df3>> {
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
            @Override // com.baidu.tieba.xi3
            /* renamed from: b */
            public void a(ef3<df3> ef3Var) {
                ew1 ew1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef3Var) == null) {
                    if (ef3Var.a != 0) {
                        e12.i("WifiApi", "getConnectedWifi: " + ef3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ef3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ef3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ef3Var.c.n());
                        } catch (JSONException e) {
                            e12.i("WifiApi", "getConnectedWifi: " + ef3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ef3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ef3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    ue3 ue3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        ew1Var = new ew1(ef3Var.a, ef3Var.b);
                    } else {
                        ew1Var = new ew1(ef3Var.a, ef3Var.b, jSONObject);
                    }
                    ue3Var.d(str, ew1Var);
                }
            }
        }

        public i(ue3 ue3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ue3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.hz2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                bf3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.hz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                e12.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new ew1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements xi3<ef3<df3>> {
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
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(ef3<df3> ef3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef3Var) == null) && ef3Var != null && ef3Var.a == 0 && ef3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", ef3Var.c);
                } catch (JSONException e) {
                    e12.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                rp2.U().u(new fe2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements xi3<ef3<List<df3>>> {
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
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(ef3<List<df3>> ef3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef3Var) == null) && ef3Var != null && ef3Var.a == 0 && ef3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (df3 df3Var : ef3Var.c) {
                    jSONArray.put(df3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    e12.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                rp2.U().u(new fe2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements xi3<ef3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ue3 b;

        public d(ue3 ue3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ue3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(ef3<Void> ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef3Var) == null) {
                if (ef3Var.a != 0) {
                    e12.i("WifiApi", "startWifi: " + ef3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ef3Var.b);
                }
                this.b.d(this.a, new ew1(ef3Var.a, ef3Var.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements xi3<ef3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ue3 b;

        public e(ue3 ue3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ue3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(ef3<Void> ef3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ef3Var) == null) {
                if (ef3Var.a != 0) {
                    e12.i("WifiApi", "stopWifi: " + ef3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ef3Var.b);
                }
                this.b.d(this.a, new ew1(ef3Var.a, ef3Var.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ue3 b;

        public f(ue3 ue3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ue3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                if (c93.h(h93Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = h93Var.b();
                e12.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + c93.f(b));
                this.b.d(this.a, new ew1(b, c93.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ue3 b;

        public h(ue3 ue3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ue3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                if (c93.h(h93Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = h93Var.b();
                e12.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + c93.f(b));
                this.b.d(this.a, new ew1(b, c93.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cf3 b;
        public final /* synthetic */ ue3 c;

        public j(ue3 ue3Var, String str, cf3 cf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ue3Var, str, cf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ue3Var;
            this.a = str;
            this.b = cf3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                if (!c93.h(h93Var)) {
                    int b = h93Var.b();
                    e12.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + c93.f(b));
                    this.c.d(this.a, new ew1(b, c93.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948208070, "Lcom/baidu/tieba/ue3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948208070, "Lcom/baidu/tieba/ue3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ue3(@NonNull fs1 fs1Var) {
        super(fs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fs1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((fs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, cf3 cf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, cf3Var) == null) {
            SwanAppActivity w = d43.K().w();
            gz2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, cf3Var, str));
        }
    }

    public ew1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            e43 b0 = e43.b0();
            if (b0 == null) {
                e12.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new ew1(1001, "swan app is null");
            } else if (b0.w() == null) {
                e12.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new ew1(1001, "swan activity is null");
            } else {
                Pair<ew1, JSONObject> s = s(str);
                ew1 ew1Var = (ew1) s.first;
                if (!ew1Var.isSuccess()) {
                    return ew1Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    e12.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new ew1(201, "callback is null");
                }
                cf3 a2 = cf3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    e12.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new ew1(12008, "invalid ssid");
                } else if (b0.n0()) {
                    e12.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new ew1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return ew1.f();
                }
            }
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            e43 b0 = e43.b0();
            if (b0 == null) {
                e12.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new ew1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                e12.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new ew1(1001, "swan activity is null");
            }
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (!ew1Var.isSuccess()) {
                return ew1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                e12.c("WifiApi", "startWifi: 201 : callback is null");
                return new ew1(201, "callback is null");
            }
            bf3 s2 = bf3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return ew1.f();
            }
            e12.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new ew1(12010, "unknown failed");
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            e43 b0 = e43.b0();
            if (b0 == null) {
                e12.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new ew1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                e12.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new ew1(1001, "swan activity is null");
            }
            Pair<ew1, JSONObject> s = s(str);
            ew1 ew1Var = (ew1) s.first;
            if (!ew1Var.isSuccess()) {
                return ew1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                e12.c("WifiApi", "stopWifi: 201 : callback is null");
                return new ew1(201, "callback is null");
            }
            bf3 s2 = bf3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return ew1.f();
            }
            e12.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new ew1(12010, "unknown failed");
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            e43 b0 = e43.b0();
            if (b0 == null) {
                e12.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new ew1(1001, "swan app is null");
            } else if (b0.w() == null) {
                e12.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new ew1(1001, "swan activity is null");
            } else {
                Pair<ew1, JSONObject> s = s(str);
                ew1 ew1Var = (ew1) s.first;
                if (!ew1Var.isSuccess()) {
                    return ew1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    e12.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new ew1(201, "callback is null");
                } else if (b0.n0()) {
                    e12.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new ew1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return ew1.f();
                }
            }
        }
        return (ew1) invokeL.objValue;
    }

    public ew1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            e43 b0 = e43.b0();
            if (b0 == null) {
                e12.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new ew1(1001, "swan app is null");
            } else if (b0.w() == null) {
                e12.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new ew1(1001, "swan activity is null");
            } else {
                Pair<ew1, JSONObject> s = s(str);
                ew1 ew1Var = (ew1) s.first;
                if (!ew1Var.isSuccess()) {
                    return ew1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    e12.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new ew1(201, "callback is null");
                } else if (b0.n0()) {
                    e12.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new ew1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return ew1.f();
                }
            }
        }
        return (ew1) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = d43.K().w();
            gz2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = d43.K().w();
            gz2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
