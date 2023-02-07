package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.be3;
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
public class mj3 extends zw1 {
    public static /* synthetic */ Interceptable $ic;
    public static final pn3<wj3<vj3>> f;
    public static final pn3<wj3<List<vj3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.zw1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.zw1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements z33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ uj3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ mj3 d;

        /* renamed from: com.baidu.tieba.mj3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0349a implements pn3<wj3<vj3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0349a(a aVar) {
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
            @Override // com.baidu.tieba.pn3
            /* renamed from: b */
            public void a(wj3<vj3> wj3Var) {
                w02 w02Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wj3Var) == null) {
                    if (wj3Var.a != 0) {
                        w52.i("WifiApi", "connectWifi: " + wj3Var.a + ZeusCrashHandler.NAME_SEPERATOR + wj3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (wj3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", wj3Var.c.n());
                        } catch (JSONException e) {
                            w52.i("WifiApi", "getConnectedWifi: " + wj3Var.a + ZeusCrashHandler.NAME_SEPERATOR + wj3Var.b + ZeusCrashHandler.NAME_SEPERATOR + wj3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    mj3 mj3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        w02Var = new w02(wj3Var.a, wj3Var.b);
                    } else {
                        w02Var = new w02(wj3Var.a, wj3Var.b, jSONObject);
                    }
                    mj3Var.d(str, w02Var);
                }
            }
        }

        public a(mj3 mj3Var, Activity activity, uj3 uj3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj3Var, activity, uj3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = mj3Var;
            this.a = activity;
            this.b = uj3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.z33
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                tj3.s(this.a).a(this.b, new C0349a(this));
            }
        }

        @Override // com.baidu.tieba.z33
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                w52.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new w02(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements z33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mj3 c;

        /* loaded from: classes5.dex */
        public class a implements pn3<wj3<Void>> {
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
            @Override // com.baidu.tieba.pn3
            /* renamed from: b */
            public void a(wj3<Void> wj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wj3Var) == null) {
                    if (wj3Var.a != 0) {
                        w52.i("WifiApi", "getWifiList: " + wj3Var.a + ZeusCrashHandler.NAME_SEPERATOR + wj3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new w02(wj3Var.a, wj3Var.b));
                }
            }
        }

        public g(mj3 mj3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mj3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.z33
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                tj3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.z33
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                w52.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new w02(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements z33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mj3 c;

        /* loaded from: classes5.dex */
        public class a implements pn3<wj3<vj3>> {
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
            @Override // com.baidu.tieba.pn3
            /* renamed from: b */
            public void a(wj3<vj3> wj3Var) {
                w02 w02Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wj3Var) == null) {
                    if (wj3Var.a != 0) {
                        w52.i("WifiApi", "getConnectedWifi: " + wj3Var.a + ZeusCrashHandler.NAME_SEPERATOR + wj3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (wj3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", wj3Var.c.n());
                        } catch (JSONException e) {
                            w52.i("WifiApi", "getConnectedWifi: " + wj3Var.a + ZeusCrashHandler.NAME_SEPERATOR + wj3Var.b + ZeusCrashHandler.NAME_SEPERATOR + wj3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    mj3 mj3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        w02Var = new w02(wj3Var.a, wj3Var.b);
                    } else {
                        w02Var = new w02(wj3Var.a, wj3Var.b, jSONObject);
                    }
                    mj3Var.d(str, w02Var);
                }
            }
        }

        public i(mj3 mj3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mj3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.z33
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                tj3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.z33
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                w52.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new w02(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements pn3<wj3<vj3>> {
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
        @Override // com.baidu.tieba.pn3
        /* renamed from: b */
        public void a(wj3<vj3> wj3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wj3Var) == null) && wj3Var != null && wj3Var.a == 0 && wj3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", wj3Var.c);
                } catch (JSONException e) {
                    w52.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                ju2.U().u(new xi2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements pn3<wj3<List<vj3>>> {
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
        @Override // com.baidu.tieba.pn3
        /* renamed from: b */
        public void a(wj3<List<vj3>> wj3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wj3Var) == null) && wj3Var != null && wj3Var.a == 0 && wj3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (vj3 vj3Var : wj3Var.c) {
                    jSONArray.put(vj3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    w52.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                ju2.U().u(new xi2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements pn3<wj3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mj3 b;

        public d(mj3 mj3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mj3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pn3
        /* renamed from: b */
        public void a(wj3<Void> wj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wj3Var) == null) {
                if (wj3Var.a != 0) {
                    w52.i("WifiApi", "startWifi: " + wj3Var.a + ZeusCrashHandler.NAME_SEPERATOR + wj3Var.b);
                }
                this.b.d(this.a, new w02(wj3Var.a, wj3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements pn3<wj3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mj3 b;

        public e(mj3 mj3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mj3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pn3
        /* renamed from: b */
        public void a(wj3<Void> wj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wj3Var) == null) {
                if (wj3Var.a != 0) {
                    w52.i("WifiApi", "stopWifi: " + wj3Var.a + ZeusCrashHandler.NAME_SEPERATOR + wj3Var.b);
                }
                this.b.d(this.a, new w02(wj3Var.a, wj3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements pn3<zd3<be3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mj3 b;

        public f(mj3 mj3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mj3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pn3
        /* renamed from: b */
        public void a(zd3<be3.e> zd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zd3Var) == null) {
                if (ud3.h(zd3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = zd3Var.b();
                w52.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + ud3.f(b));
                this.b.d(this.a, new w02(b, ud3.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements pn3<zd3<be3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ mj3 b;

        public h(mj3 mj3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = mj3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pn3
        /* renamed from: b */
        public void a(zd3<be3.e> zd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zd3Var) == null) {
                if (ud3.h(zd3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = zd3Var.b();
                w52.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + ud3.f(b));
                this.b.d(this.a, new w02(b, ud3.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements pn3<zd3<be3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ uj3 b;
        public final /* synthetic */ mj3 c;

        public j(mj3 mj3Var, String str, uj3 uj3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mj3Var, str, uj3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = mj3Var;
            this.a = str;
            this.b = uj3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pn3
        /* renamed from: b */
        public void a(zd3<be3.e> zd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zd3Var) == null) {
                if (!ud3.h(zd3Var)) {
                    int b = zd3Var.b();
                    w52.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + ud3.f(b));
                    this.c.d(this.a, new w02(b, ud3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947974547, "Lcom/baidu/tieba/mj3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947974547, "Lcom/baidu/tieba/mj3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mj3(@NonNull xw1 xw1Var) {
        super(xw1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xw1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((xw1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, uj3 uj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, uj3Var) == null) {
            SwanAppActivity w = v83.K().w();
            y33.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, uj3Var, str));
        }
    }

    public w02 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            w83 b0 = w83.b0();
            if (b0 == null) {
                w52.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new w02(1001, "swan app is null");
            } else if (b0.w() == null) {
                w52.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new w02(1001, "swan activity is null");
            } else {
                Pair<w02, JSONObject> s = s(str);
                w02 w02Var = (w02) s.first;
                if (!w02Var.isSuccess()) {
                    return w02Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    w52.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new w02(201, "callback is null");
                }
                uj3 a2 = uj3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    w52.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new w02(12008, "invalid ssid");
                } else if (b0.n0()) {
                    w52.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new w02(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return w02.f();
                }
            }
        }
        return (w02) invokeL.objValue;
    }

    public w02 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            w83 b0 = w83.b0();
            if (b0 == null) {
                w52.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new w02(1001, "swan app is null");
            } else if (b0.w() == null) {
                w52.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new w02(1001, "swan activity is null");
            } else {
                Pair<w02, JSONObject> s = s(str);
                w02 w02Var = (w02) s.first;
                if (!w02Var.isSuccess()) {
                    return w02Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    w52.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new w02(201, "callback is null");
                } else if (b0.n0()) {
                    w52.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new w02(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return w02.f();
                }
            }
        }
        return (w02) invokeL.objValue;
    }

    public w02 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            w83 b0 = w83.b0();
            if (b0 == null) {
                w52.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new w02(1001, "swan app is null");
            } else if (b0.w() == null) {
                w52.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new w02(1001, "swan activity is null");
            } else {
                Pair<w02, JSONObject> s = s(str);
                w02 w02Var = (w02) s.first;
                if (!w02Var.isSuccess()) {
                    return w02Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    w52.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new w02(201, "callback is null");
                } else if (b0.n0()) {
                    w52.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new w02(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return w02.f();
                }
            }
        }
        return (w02) invokeL.objValue;
    }

    public w02 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            w83 b0 = w83.b0();
            if (b0 == null) {
                w52.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new w02(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                w52.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new w02(1001, "swan activity is null");
            }
            Pair<w02, JSONObject> s = s(str);
            w02 w02Var = (w02) s.first;
            if (!w02Var.isSuccess()) {
                return w02Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                w52.c("WifiApi", "startWifi: 201 : callback is null");
                return new w02(201, "callback is null");
            }
            tj3 s2 = tj3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return w02.f();
            }
            w52.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new w02(12010, "unknown failed");
        }
        return (w02) invokeL.objValue;
    }

    public w02 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            w83 b0 = w83.b0();
            if (b0 == null) {
                w52.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new w02(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                w52.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new w02(1001, "swan activity is null");
            }
            Pair<w02, JSONObject> s = s(str);
            w02 w02Var = (w02) s.first;
            if (!w02Var.isSuccess()) {
                return w02Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                w52.c("WifiApi", "stopWifi: 201 : callback is null");
                return new w02(201, "callback is null");
            }
            tj3 s2 = tj3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return w02.f();
            }
            w52.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new w02(12010, "unknown failed");
        }
        return (w02) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = v83.K().w();
            y33.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = v83.K().w();
            y33.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
