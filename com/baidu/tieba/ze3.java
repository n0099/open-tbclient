package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.o93;
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
public class ze3 extends ms1 {
    public static /* synthetic */ Interceptable $ic;
    public static final cj3<jf3<if3>> f;
    public static final cj3<jf3<List<if3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ms1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ms1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements mz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ hf3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ze3 d;

        /* renamed from: com.baidu.tieba.ze3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0495a implements cj3<jf3<if3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0495a(a aVar) {
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
            @Override // com.baidu.tieba.cj3
            /* renamed from: b */
            public void a(jf3<if3> jf3Var) {
                jw1 jw1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jf3Var) == null) {
                    if (jf3Var.a != 0) {
                        j12.i("WifiApi", "connectWifi: " + jf3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jf3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (jf3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", jf3Var.c.n());
                        } catch (JSONException e) {
                            j12.i("WifiApi", "getConnectedWifi: " + jf3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jf3Var.b + ZeusCrashHandler.NAME_SEPERATOR + jf3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    ze3 ze3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        jw1Var = new jw1(jf3Var.a, jf3Var.b);
                    } else {
                        jw1Var = new jw1(jf3Var.a, jf3Var.b, jSONObject);
                    }
                    ze3Var.d(str, jw1Var);
                }
            }
        }

        public a(ze3 ze3Var, Activity activity, hf3 hf3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze3Var, activity, hf3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ze3Var;
            this.a = activity;
            this.b = hf3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.mz2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                gf3.s(this.a).a(this.b, new C0495a(this));
            }
        }

        @Override // com.baidu.tieba.mz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                j12.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new jw1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements mz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ze3 c;

        /* loaded from: classes7.dex */
        public class a implements cj3<jf3<Void>> {
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
            @Override // com.baidu.tieba.cj3
            /* renamed from: b */
            public void a(jf3<Void> jf3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jf3Var) == null) {
                    if (jf3Var.a != 0) {
                        j12.i("WifiApi", "getWifiList: " + jf3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jf3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new jw1(jf3Var.a, jf3Var.b));
                }
            }
        }

        public g(ze3 ze3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ze3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.mz2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                gf3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.mz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                j12.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new jw1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements mz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ze3 c;

        /* loaded from: classes7.dex */
        public class a implements cj3<jf3<if3>> {
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
            @Override // com.baidu.tieba.cj3
            /* renamed from: b */
            public void a(jf3<if3> jf3Var) {
                jw1 jw1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jf3Var) == null) {
                    if (jf3Var.a != 0) {
                        j12.i("WifiApi", "getConnectedWifi: " + jf3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jf3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (jf3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", jf3Var.c.n());
                        } catch (JSONException e) {
                            j12.i("WifiApi", "getConnectedWifi: " + jf3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jf3Var.b + ZeusCrashHandler.NAME_SEPERATOR + jf3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    ze3 ze3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        jw1Var = new jw1(jf3Var.a, jf3Var.b);
                    } else {
                        jw1Var = new jw1(jf3Var.a, jf3Var.b, jSONObject);
                    }
                    ze3Var.d(str, jw1Var);
                }
            }
        }

        public i(ze3 ze3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ze3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.mz2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                gf3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.mz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                j12.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new jw1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements cj3<jf3<if3>> {
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
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(jf3<if3> jf3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jf3Var) == null) && jf3Var != null && jf3Var.a == 0 && jf3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", jf3Var.c);
                } catch (JSONException e) {
                    j12.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                wp2.U().u(new ke2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements cj3<jf3<List<if3>>> {
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
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(jf3<List<if3>> jf3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jf3Var) == null) && jf3Var != null && jf3Var.a == 0 && jf3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (if3 if3Var : jf3Var.c) {
                    jSONArray.put(if3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    j12.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                wp2.U().u(new ke2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements cj3<jf3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ze3 b;

        public d(ze3 ze3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(jf3<Void> jf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jf3Var) == null) {
                if (jf3Var.a != 0) {
                    j12.i("WifiApi", "startWifi: " + jf3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jf3Var.b);
                }
                this.b.d(this.a, new jw1(jf3Var.a, jf3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements cj3<jf3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ze3 b;

        public e(ze3 ze3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(jf3<Void> jf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jf3Var) == null) {
                if (jf3Var.a != 0) {
                    j12.i("WifiApi", "stopWifi: " + jf3Var.a + ZeusCrashHandler.NAME_SEPERATOR + jf3Var.b);
                }
                this.b.d(this.a, new jw1(jf3Var.a, jf3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements cj3<m93<o93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ze3 b;

        public f(ze3 ze3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(m93<o93.e> m93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m93Var) == null) {
                if (h93.h(m93Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = m93Var.b();
                j12.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + h93.f(b));
                this.b.d(this.a, new jw1(b, h93.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements cj3<m93<o93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ze3 b;

        public h(ze3 ze3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ze3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(m93<o93.e> m93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m93Var) == null) {
                if (h93.h(m93Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = m93Var.b();
                j12.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + h93.f(b));
                this.b.d(this.a, new jw1(b, h93.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements cj3<m93<o93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hf3 b;
        public final /* synthetic */ ze3 c;

        public j(ze3 ze3Var, String str, hf3 hf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ze3Var, str, hf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ze3Var;
            this.a = str;
            this.b = hf3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cj3
        /* renamed from: b */
        public void a(m93<o93.e> m93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m93Var) == null) {
                if (!h93.h(m93Var)) {
                    int b = m93Var.b();
                    j12.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + h93.f(b));
                    this.c.d(this.a, new jw1(b, h93.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948357025, "Lcom/baidu/tieba/ze3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948357025, "Lcom/baidu/tieba/ze3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ze3(@NonNull ks1 ks1Var) {
        super(ks1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ks1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((ks1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, hf3 hf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, hf3Var) == null) {
            SwanAppActivity w = i43.K().w();
            lz2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, hf3Var, str));
        }
    }

    public jw1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            j43 b0 = j43.b0();
            if (b0 == null) {
                j12.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new jw1(1001, "swan app is null");
            } else if (b0.w() == null) {
                j12.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new jw1(1001, "swan activity is null");
            } else {
                Pair<jw1, JSONObject> s = s(str);
                jw1 jw1Var = (jw1) s.first;
                if (!jw1Var.isSuccess()) {
                    return jw1Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j12.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new jw1(201, "callback is null");
                }
                hf3 a2 = hf3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    j12.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new jw1(12008, "invalid ssid");
                } else if (b0.n0()) {
                    j12.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new jw1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return jw1.f();
                }
            }
        }
        return (jw1) invokeL.objValue;
    }

    public jw1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            j43 b0 = j43.b0();
            if (b0 == null) {
                j12.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new jw1(1001, "swan app is null");
            } else if (b0.w() == null) {
                j12.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new jw1(1001, "swan activity is null");
            } else {
                Pair<jw1, JSONObject> s = s(str);
                jw1 jw1Var = (jw1) s.first;
                if (!jw1Var.isSuccess()) {
                    return jw1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j12.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new jw1(201, "callback is null");
                } else if (b0.n0()) {
                    j12.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new jw1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return jw1.f();
                }
            }
        }
        return (jw1) invokeL.objValue;
    }

    public jw1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            j43 b0 = j43.b0();
            if (b0 == null) {
                j12.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new jw1(1001, "swan app is null");
            } else if (b0.w() == null) {
                j12.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new jw1(1001, "swan activity is null");
            } else {
                Pair<jw1, JSONObject> s = s(str);
                jw1 jw1Var = (jw1) s.first;
                if (!jw1Var.isSuccess()) {
                    return jw1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j12.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new jw1(201, "callback is null");
                } else if (b0.n0()) {
                    j12.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new jw1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return jw1.f();
                }
            }
        }
        return (jw1) invokeL.objValue;
    }

    public jw1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            j43 b0 = j43.b0();
            if (b0 == null) {
                j12.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new jw1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                j12.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new jw1(1001, "swan activity is null");
            }
            Pair<jw1, JSONObject> s = s(str);
            jw1 jw1Var = (jw1) s.first;
            if (!jw1Var.isSuccess()) {
                return jw1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j12.c("WifiApi", "startWifi: 201 : callback is null");
                return new jw1(201, "callback is null");
            }
            gf3 s2 = gf3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return jw1.f();
            }
            j12.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new jw1(12010, "unknown failed");
        }
        return (jw1) invokeL.objValue;
    }

    public jw1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            j43 b0 = j43.b0();
            if (b0 == null) {
                j12.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new jw1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                j12.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new jw1(1001, "swan activity is null");
            }
            Pair<jw1, JSONObject> s = s(str);
            jw1 jw1Var = (jw1) s.first;
            if (!jw1Var.isSuccess()) {
                return jw1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j12.c("WifiApi", "stopWifi: 201 : callback is null");
                return new jw1(201, "callback is null");
            }
            gf3 s2 = gf3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return jw1.f();
            }
            j12.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new jw1(12010, "unknown failed");
        }
        return (jw1) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = i43.K().w();
            lz2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = i43.K().w();
            lz2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
