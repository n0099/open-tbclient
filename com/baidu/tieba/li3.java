package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.ad3;
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
public class li3 extends yv1 {
    public static /* synthetic */ Interceptable $ic;
    public static final om3<vi3<ui3>> f;
    public static final om3<vi3<List<ui3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.yv1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements y23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ti3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ li3 d;

        /* renamed from: com.baidu.tieba.li3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0326a implements om3<vi3<ui3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0326a(a aVar) {
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
            @Override // com.baidu.tieba.om3
            /* renamed from: b */
            public void a(vi3<ui3> vi3Var) {
                vz1 vz1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vi3Var) == null) {
                    if (vi3Var.a != 0) {
                        v42.i("WifiApi", "connectWifi: " + vi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vi3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (vi3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", vi3Var.c.n());
                        } catch (JSONException e) {
                            v42.i("WifiApi", "getConnectedWifi: " + vi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vi3Var.b + ZeusCrashHandler.NAME_SEPERATOR + vi3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    li3 li3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        vz1Var = new vz1(vi3Var.a, vi3Var.b);
                    } else {
                        vz1Var = new vz1(vi3Var.a, vi3Var.b, jSONObject);
                    }
                    li3Var.d(str, vz1Var);
                }
            }
        }

        public a(li3 li3Var, Activity activity, ti3 ti3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li3Var, activity, ti3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = li3Var;
            this.a = activity;
            this.b = ti3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.y23
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                si3.s(this.a).a(this.b, new C0326a(this));
            }
        }

        @Override // com.baidu.tieba.y23
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                v42.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new vz1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements y23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ li3 c;

        /* loaded from: classes5.dex */
        public class a implements om3<vi3<Void>> {
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
            @Override // com.baidu.tieba.om3
            /* renamed from: b */
            public void a(vi3<Void> vi3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vi3Var) == null) {
                    if (vi3Var.a != 0) {
                        v42.i("WifiApi", "getWifiList: " + vi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vi3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new vz1(vi3Var.a, vi3Var.b));
                }
            }
        }

        public g(li3 li3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = li3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.y23
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                si3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.y23
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                v42.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new vz1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements y23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ li3 c;

        /* loaded from: classes5.dex */
        public class a implements om3<vi3<ui3>> {
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
            @Override // com.baidu.tieba.om3
            /* renamed from: b */
            public void a(vi3<ui3> vi3Var) {
                vz1 vz1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vi3Var) == null) {
                    if (vi3Var.a != 0) {
                        v42.i("WifiApi", "getConnectedWifi: " + vi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vi3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (vi3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", vi3Var.c.n());
                        } catch (JSONException e) {
                            v42.i("WifiApi", "getConnectedWifi: " + vi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vi3Var.b + ZeusCrashHandler.NAME_SEPERATOR + vi3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    li3 li3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        vz1Var = new vz1(vi3Var.a, vi3Var.b);
                    } else {
                        vz1Var = new vz1(vi3Var.a, vi3Var.b, jSONObject);
                    }
                    li3Var.d(str, vz1Var);
                }
            }
        }

        public i(li3 li3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = li3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.y23
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                si3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.y23
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                v42.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new vz1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements om3<vi3<ui3>> {
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
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(vi3<ui3> vi3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vi3Var) == null) && vi3Var != null && vi3Var.a == 0 && vi3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", vi3Var.c);
                } catch (JSONException e) {
                    v42.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                it2.U().u(new wh2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements om3<vi3<List<ui3>>> {
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
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(vi3<List<ui3>> vi3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vi3Var) == null) && vi3Var != null && vi3Var.a == 0 && vi3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (ui3 ui3Var : vi3Var.c) {
                    jSONArray.put(ui3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    v42.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                it2.U().u(new wh2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements om3<vi3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ li3 b;

        public d(li3 li3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = li3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(vi3<Void> vi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vi3Var) == null) {
                if (vi3Var.a != 0) {
                    v42.i("WifiApi", "startWifi: " + vi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vi3Var.b);
                }
                this.b.d(this.a, new vz1(vi3Var.a, vi3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements om3<vi3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ li3 b;

        public e(li3 li3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = li3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(vi3<Void> vi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vi3Var) == null) {
                if (vi3Var.a != 0) {
                    v42.i("WifiApi", "stopWifi: " + vi3Var.a + ZeusCrashHandler.NAME_SEPERATOR + vi3Var.b);
                }
                this.b.d(this.a, new vz1(vi3Var.a, vi3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements om3<yc3<ad3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ li3 b;

        public f(li3 li3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = li3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(yc3<ad3.e> yc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yc3Var) == null) {
                if (tc3.h(yc3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = yc3Var.b();
                v42.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + tc3.f(b));
                this.b.d(this.a, new vz1(b, tc3.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements om3<yc3<ad3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ li3 b;

        public h(li3 li3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = li3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(yc3<ad3.e> yc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yc3Var) == null) {
                if (tc3.h(yc3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = yc3Var.b();
                v42.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + tc3.f(b));
                this.b.d(this.a, new vz1(b, tc3.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements om3<yc3<ad3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ti3 b;
        public final /* synthetic */ li3 c;

        public j(li3 li3Var, String str, ti3 ti3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {li3Var, str, ti3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = li3Var;
            this.a = str;
            this.b = ti3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.om3
        /* renamed from: b */
        public void a(yc3<ad3.e> yc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yc3Var) == null) {
                if (!tc3.h(yc3Var)) {
                    int b = yc3Var.b();
                    v42.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + tc3.f(b));
                    this.c.d(this.a, new vz1(b, tc3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947943795, "Lcom/baidu/tieba/li3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947943795, "Lcom/baidu/tieba/li3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public li3(@NonNull wv1 wv1Var) {
        super(wv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((wv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, ti3 ti3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ti3Var) == null) {
            SwanAppActivity w = u73.K().w();
            x23.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, ti3Var, str));
        }
    }

    public vz1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            v73 b0 = v73.b0();
            if (b0 == null) {
                v42.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new vz1(1001, "swan app is null");
            } else if (b0.w() == null) {
                v42.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new vz1(1001, "swan activity is null");
            } else {
                Pair<vz1, JSONObject> s = s(str);
                vz1 vz1Var = (vz1) s.first;
                if (!vz1Var.isSuccess()) {
                    return vz1Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    v42.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new vz1(201, "callback is null");
                }
                ti3 a2 = ti3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    v42.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new vz1(12008, "invalid ssid");
                } else if (b0.n0()) {
                    v42.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new vz1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return vz1.f();
                }
            }
        }
        return (vz1) invokeL.objValue;
    }

    public vz1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            v73 b0 = v73.b0();
            if (b0 == null) {
                v42.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new vz1(1001, "swan app is null");
            } else if (b0.w() == null) {
                v42.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new vz1(1001, "swan activity is null");
            } else {
                Pair<vz1, JSONObject> s = s(str);
                vz1 vz1Var = (vz1) s.first;
                if (!vz1Var.isSuccess()) {
                    return vz1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    v42.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new vz1(201, "callback is null");
                } else if (b0.n0()) {
                    v42.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new vz1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return vz1.f();
                }
            }
        }
        return (vz1) invokeL.objValue;
    }

    public vz1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            v73 b0 = v73.b0();
            if (b0 == null) {
                v42.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new vz1(1001, "swan app is null");
            } else if (b0.w() == null) {
                v42.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new vz1(1001, "swan activity is null");
            } else {
                Pair<vz1, JSONObject> s = s(str);
                vz1 vz1Var = (vz1) s.first;
                if (!vz1Var.isSuccess()) {
                    return vz1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    v42.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new vz1(201, "callback is null");
                } else if (b0.n0()) {
                    v42.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new vz1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return vz1.f();
                }
            }
        }
        return (vz1) invokeL.objValue;
    }

    public vz1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            v73 b0 = v73.b0();
            if (b0 == null) {
                v42.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new vz1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                v42.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new vz1(1001, "swan activity is null");
            }
            Pair<vz1, JSONObject> s = s(str);
            vz1 vz1Var = (vz1) s.first;
            if (!vz1Var.isSuccess()) {
                return vz1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                v42.c("WifiApi", "startWifi: 201 : callback is null");
                return new vz1(201, "callback is null");
            }
            si3 s2 = si3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return vz1.f();
            }
            v42.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new vz1(12010, "unknown failed");
        }
        return (vz1) invokeL.objValue;
    }

    public vz1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            v73 b0 = v73.b0();
            if (b0 == null) {
                v42.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new vz1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                v42.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new vz1(1001, "swan activity is null");
            }
            Pair<vz1, JSONObject> s = s(str);
            vz1 vz1Var = (vz1) s.first;
            if (!vz1Var.isSuccess()) {
                return vz1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                v42.c("WifiApi", "stopWifi: 201 : callback is null");
                return new vz1(201, "callback is null");
            }
            si3 s2 = si3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return vz1.f();
            }
            v42.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new vz1(12010, "unknown failed");
        }
        return (vz1) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = u73.K().w();
            x23.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = u73.K().w();
            x23.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
