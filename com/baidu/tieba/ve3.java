package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.k93;
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
public class ve3 extends is1 {
    public static /* synthetic */ Interceptable $ic;
    public static final yi3<ff3<ef3>> f;
    public static final yi3<ff3<List<ef3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.is1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.is1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements iz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ df3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ve3 d;

        /* renamed from: com.baidu.tieba.ve3$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0451a implements yi3<ff3<ef3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0451a(a aVar) {
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
            @Override // com.baidu.tieba.yi3
            /* renamed from: b */
            public void a(ff3<ef3> ff3Var) {
                fw1 fw1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ff3Var) == null) {
                    if (ff3Var.a != 0) {
                        f12.i("WifiApi", "connectWifi: " + ff3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ff3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ff3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ff3Var.c.n());
                        } catch (JSONException e) {
                            f12.i("WifiApi", "getConnectedWifi: " + ff3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ff3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ff3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    ve3 ve3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        fw1Var = new fw1(ff3Var.a, ff3Var.b);
                    } else {
                        fw1Var = new fw1(ff3Var.a, ff3Var.b, jSONObject);
                    }
                    ve3Var.d(str, fw1Var);
                }
            }
        }

        public a(ve3 ve3Var, Activity activity, df3 df3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve3Var, activity, df3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ve3Var;
            this.a = activity;
            this.b = df3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.iz2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                cf3.s(this.a).a(this.b, new C0451a(this));
            }
        }

        @Override // com.baidu.tieba.iz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                f12.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new fw1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements iz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ve3 c;

        /* loaded from: classes6.dex */
        public class a implements yi3<ff3<Void>> {
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
            @Override // com.baidu.tieba.yi3
            /* renamed from: b */
            public void a(ff3<Void> ff3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ff3Var) == null) {
                    if (ff3Var.a != 0) {
                        f12.i("WifiApi", "getWifiList: " + ff3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ff3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new fw1(ff3Var.a, ff3Var.b));
                }
            }
        }

        public g(ve3 ve3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ve3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.iz2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                cf3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.iz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                f12.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new fw1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements iz2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ve3 c;

        /* loaded from: classes6.dex */
        public class a implements yi3<ff3<ef3>> {
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
            @Override // com.baidu.tieba.yi3
            /* renamed from: b */
            public void a(ff3<ef3> ff3Var) {
                fw1 fw1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ff3Var) == null) {
                    if (ff3Var.a != 0) {
                        f12.i("WifiApi", "getConnectedWifi: " + ff3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ff3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ff3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ff3Var.c.n());
                        } catch (JSONException e) {
                            f12.i("WifiApi", "getConnectedWifi: " + ff3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ff3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ff3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    ve3 ve3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        fw1Var = new fw1(ff3Var.a, ff3Var.b);
                    } else {
                        fw1Var = new fw1(ff3Var.a, ff3Var.b, jSONObject);
                    }
                    ve3Var.d(str, fw1Var);
                }
            }
        }

        public i(ve3 ve3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ve3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.iz2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                cf3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.iz2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                f12.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new fw1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements yi3<ff3<ef3>> {
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
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(ff3<ef3> ff3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ff3Var) == null) && ff3Var != null && ff3Var.a == 0 && ff3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", ff3Var.c);
                } catch (JSONException e) {
                    f12.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                sp2.U().u(new ge2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements yi3<ff3<List<ef3>>> {
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
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(ff3<List<ef3>> ff3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ff3Var) == null) && ff3Var != null && ff3Var.a == 0 && ff3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (ef3 ef3Var : ff3Var.c) {
                    jSONArray.put(ef3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    f12.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                sp2.U().u(new ge2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements yi3<ff3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ve3 b;

        public d(ve3 ve3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ve3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(ff3<Void> ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ff3Var) == null) {
                if (ff3Var.a != 0) {
                    f12.i("WifiApi", "startWifi: " + ff3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ff3Var.b);
                }
                this.b.d(this.a, new fw1(ff3Var.a, ff3Var.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements yi3<ff3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ve3 b;

        public e(ve3 ve3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ve3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(ff3<Void> ff3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ff3Var) == null) {
                if (ff3Var.a != 0) {
                    f12.i("WifiApi", "stopWifi: " + ff3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ff3Var.b);
                }
                this.b.d(this.a, new fw1(ff3Var.a, ff3Var.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements yi3<i93<k93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ve3 b;

        public f(ve3 ve3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ve3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(i93<k93.e> i93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i93Var) == null) {
                if (d93.h(i93Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = i93Var.b();
                f12.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + d93.f(b));
                this.b.d(this.a, new fw1(b, d93.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements yi3<i93<k93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ve3 b;

        public h(ve3 ve3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ve3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(i93<k93.e> i93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i93Var) == null) {
                if (d93.h(i93Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = i93Var.b();
                f12.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + d93.f(b));
                this.b.d(this.a, new fw1(b, d93.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements yi3<i93<k93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ df3 b;
        public final /* synthetic */ ve3 c;

        public j(ve3 ve3Var, String str, df3 df3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve3Var, str, df3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ve3Var;
            this.a = str;
            this.b = df3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.yi3
        /* renamed from: b */
        public void a(i93<k93.e> i93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i93Var) == null) {
                if (!d93.h(i93Var)) {
                    int b = i93Var.b();
                    f12.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + d93.f(b));
                    this.c.d(this.a, new fw1(b, d93.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948237861, "Lcom/baidu/tieba/ve3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948237861, "Lcom/baidu/tieba/ve3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ve3(@NonNull gs1 gs1Var) {
        super(gs1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gs1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((gs1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, df3 df3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, df3Var) == null) {
            SwanAppActivity w = e43.K().w();
            hz2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, df3Var, str));
        }
    }

    public fw1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            f43 b0 = f43.b0();
            if (b0 == null) {
                f12.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new fw1(1001, "swan app is null");
            } else if (b0.w() == null) {
                f12.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new fw1(1001, "swan activity is null");
            } else {
                Pair<fw1, JSONObject> s = s(str);
                fw1 fw1Var = (fw1) s.first;
                if (!fw1Var.isSuccess()) {
                    return fw1Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    f12.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new fw1(201, "callback is null");
                }
                df3 a2 = df3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    f12.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new fw1(12008, "invalid ssid");
                } else if (b0.n0()) {
                    f12.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new fw1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return fw1.f();
                }
            }
        }
        return (fw1) invokeL.objValue;
    }

    public fw1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            f43 b0 = f43.b0();
            if (b0 == null) {
                f12.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new fw1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                f12.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new fw1(1001, "swan activity is null");
            }
            Pair<fw1, JSONObject> s = s(str);
            fw1 fw1Var = (fw1) s.first;
            if (!fw1Var.isSuccess()) {
                return fw1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                f12.c("WifiApi", "startWifi: 201 : callback is null");
                return new fw1(201, "callback is null");
            }
            cf3 s2 = cf3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return fw1.f();
            }
            f12.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new fw1(12010, "unknown failed");
        }
        return (fw1) invokeL.objValue;
    }

    public fw1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            f43 b0 = f43.b0();
            if (b0 == null) {
                f12.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new fw1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                f12.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new fw1(1001, "swan activity is null");
            }
            Pair<fw1, JSONObject> s = s(str);
            fw1 fw1Var = (fw1) s.first;
            if (!fw1Var.isSuccess()) {
                return fw1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                f12.c("WifiApi", "stopWifi: 201 : callback is null");
                return new fw1(201, "callback is null");
            }
            cf3 s2 = cf3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return fw1.f();
            }
            f12.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new fw1(12010, "unknown failed");
        }
        return (fw1) invokeL.objValue;
    }

    public fw1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            f43 b0 = f43.b0();
            if (b0 == null) {
                f12.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new fw1(1001, "swan app is null");
            } else if (b0.w() == null) {
                f12.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new fw1(1001, "swan activity is null");
            } else {
                Pair<fw1, JSONObject> s = s(str);
                fw1 fw1Var = (fw1) s.first;
                if (!fw1Var.isSuccess()) {
                    return fw1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    f12.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new fw1(201, "callback is null");
                } else if (b0.n0()) {
                    f12.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new fw1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return fw1.f();
                }
            }
        }
        return (fw1) invokeL.objValue;
    }

    public fw1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            f43 b0 = f43.b0();
            if (b0 == null) {
                f12.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new fw1(1001, "swan app is null");
            } else if (b0.w() == null) {
                f12.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new fw1(1001, "swan activity is null");
            } else {
                Pair<fw1, JSONObject> s = s(str);
                fw1 fw1Var = (fw1) s.first;
                if (!fw1Var.isSuccess()) {
                    return fw1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    f12.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new fw1(201, "callback is null");
                } else if (b0.n0()) {
                    f12.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new fw1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return fw1.f();
                }
            }
        }
        return (fw1) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = e43.K().w();
            hz2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = e43.K().w();
            hz2.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
