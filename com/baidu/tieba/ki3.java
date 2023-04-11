package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.zc3;
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
public class ki3 extends xv1 {
    public static /* synthetic */ Interceptable $ic;
    public static final nm3<ui3<ti3>> f;
    public static final nm3<ui3<List<ti3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.xv1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements x23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ si3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ki3 d;

        /* renamed from: com.baidu.tieba.ki3$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0325a implements nm3<ui3<ti3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0325a(a aVar) {
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
            @Override // com.baidu.tieba.nm3
            /* renamed from: b */
            public void a(ui3<ti3> ui3Var) {
                uz1 uz1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ui3Var) == null) {
                    if (ui3Var.a != 0) {
                        u42.i("WifiApi", "connectWifi: " + ui3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ui3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ui3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ui3Var.c.n());
                        } catch (JSONException e) {
                            u42.i("WifiApi", "getConnectedWifi: " + ui3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ui3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ui3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    ki3 ki3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        uz1Var = new uz1(ui3Var.a, ui3Var.b);
                    } else {
                        uz1Var = new uz1(ui3Var.a, ui3Var.b, jSONObject);
                    }
                    ki3Var.d(str, uz1Var);
                }
            }
        }

        public a(ki3 ki3Var, Activity activity, si3 si3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki3Var, activity, si3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ki3Var;
            this.a = activity;
            this.b = si3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.x23
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ri3.s(this.a).a(this.b, new C0325a(this));
            }
        }

        @Override // com.baidu.tieba.x23
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                u42.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new uz1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements x23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ki3 c;

        /* loaded from: classes5.dex */
        public class a implements nm3<ui3<Void>> {
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
            @Override // com.baidu.tieba.nm3
            /* renamed from: b */
            public void a(ui3<Void> ui3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ui3Var) == null) {
                    if (ui3Var.a != 0) {
                        u42.i("WifiApi", "getWifiList: " + ui3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ui3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new uz1(ui3Var.a, ui3Var.b));
                }
            }
        }

        public g(ki3 ki3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ki3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.x23
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ri3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.x23
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                u42.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new uz1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements x23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ki3 c;

        /* loaded from: classes5.dex */
        public class a implements nm3<ui3<ti3>> {
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
            @Override // com.baidu.tieba.nm3
            /* renamed from: b */
            public void a(ui3<ti3> ui3Var) {
                uz1 uz1Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ui3Var) == null) {
                    if (ui3Var.a != 0) {
                        u42.i("WifiApi", "getConnectedWifi: " + ui3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ui3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (ui3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", ui3Var.c.n());
                        } catch (JSONException e) {
                            u42.i("WifiApi", "getConnectedWifi: " + ui3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ui3Var.b + ZeusCrashHandler.NAME_SEPERATOR + ui3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    ki3 ki3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        uz1Var = new uz1(ui3Var.a, ui3Var.b);
                    } else {
                        uz1Var = new uz1(ui3Var.a, ui3Var.b, jSONObject);
                    }
                    ki3Var.d(str, uz1Var);
                }
            }
        }

        public i(ki3 ki3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ki3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.x23
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                ri3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.x23
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                u42.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new uz1(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements nm3<ui3<ti3>> {
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
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(ui3<ti3> ui3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ui3Var) == null) && ui3Var != null && ui3Var.a == 0 && ui3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", ui3Var.c);
                } catch (JSONException e) {
                    u42.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                ht2.U().u(new vh2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements nm3<ui3<List<ti3>>> {
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
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(ui3<List<ti3>> ui3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ui3Var) == null) && ui3Var != null && ui3Var.a == 0 && ui3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (ti3 ti3Var : ui3Var.c) {
                    jSONArray.put(ti3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    u42.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                ht2.U().u(new vh2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements nm3<ui3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ki3 b;

        public d(ki3 ki3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ki3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(ui3<Void> ui3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ui3Var) == null) {
                if (ui3Var.a != 0) {
                    u42.i("WifiApi", "startWifi: " + ui3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ui3Var.b);
                }
                this.b.d(this.a, new uz1(ui3Var.a, ui3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements nm3<ui3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ki3 b;

        public e(ki3 ki3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ki3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(ui3<Void> ui3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ui3Var) == null) {
                if (ui3Var.a != 0) {
                    u42.i("WifiApi", "stopWifi: " + ui3Var.a + ZeusCrashHandler.NAME_SEPERATOR + ui3Var.b);
                }
                this.b.d(this.a, new uz1(ui3Var.a, ui3Var.b));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements nm3<xc3<zc3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ki3 b;

        public f(ki3 ki3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ki3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(xc3<zc3.e> xc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xc3Var) == null) {
                if (sc3.h(xc3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = xc3Var.b();
                u42.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + sc3.f(b));
                this.b.d(this.a, new uz1(b, sc3.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements nm3<xc3<zc3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ki3 b;

        public h(ki3 ki3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ki3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(xc3<zc3.e> xc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xc3Var) == null) {
                if (sc3.h(xc3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = xc3Var.b();
                u42.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + sc3.f(b));
                this.b.d(this.a, new uz1(b, sc3.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements nm3<xc3<zc3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ si3 b;
        public final /* synthetic */ ki3 c;

        public j(ki3 ki3Var, String str, si3 si3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ki3Var, str, si3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ki3Var;
            this.a = str;
            this.b = si3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(xc3<zc3.e> xc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xc3Var) == null) {
                if (!sc3.h(xc3Var)) {
                    int b = xc3Var.b();
                    u42.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + sc3.f(b));
                    this.c.d(this.a, new uz1(b, sc3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947914004, "Lcom/baidu/tieba/ki3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947914004, "Lcom/baidu/tieba/ki3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ki3(@NonNull vv1 vv1Var) {
        super(vv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((vv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, si3 si3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, si3Var) == null) {
            SwanAppActivity w = t73.K().w();
            w23.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, si3Var, str));
        }
    }

    public uz1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            u73 b0 = u73.b0();
            if (b0 == null) {
                u42.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new uz1(1001, "swan app is null");
            } else if (b0.w() == null) {
                u42.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new uz1(1001, "swan activity is null");
            } else {
                Pair<uz1, JSONObject> s = s(str);
                uz1 uz1Var = (uz1) s.first;
                if (!uz1Var.isSuccess()) {
                    return uz1Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    u42.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new uz1(201, "callback is null");
                }
                si3 a2 = si3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    u42.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new uz1(12008, "invalid ssid");
                } else if (b0.n0()) {
                    u42.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new uz1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return uz1.f();
                }
            }
        }
        return (uz1) invokeL.objValue;
    }

    public uz1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            u73 b0 = u73.b0();
            if (b0 == null) {
                u42.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new uz1(1001, "swan app is null");
            } else if (b0.w() == null) {
                u42.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new uz1(1001, "swan activity is null");
            } else {
                Pair<uz1, JSONObject> s = s(str);
                uz1 uz1Var = (uz1) s.first;
                if (!uz1Var.isSuccess()) {
                    return uz1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    u42.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new uz1(201, "callback is null");
                } else if (b0.n0()) {
                    u42.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new uz1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return uz1.f();
                }
            }
        }
        return (uz1) invokeL.objValue;
    }

    public uz1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            u73 b0 = u73.b0();
            if (b0 == null) {
                u42.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new uz1(1001, "swan app is null");
            } else if (b0.w() == null) {
                u42.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new uz1(1001, "swan activity is null");
            } else {
                Pair<uz1, JSONObject> s = s(str);
                uz1 uz1Var = (uz1) s.first;
                if (!uz1Var.isSuccess()) {
                    return uz1Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    u42.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new uz1(201, "callback is null");
                } else if (b0.n0()) {
                    u42.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new uz1(12011, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return uz1.f();
                }
            }
        }
        return (uz1) invokeL.objValue;
    }

    public uz1 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            u73 b0 = u73.b0();
            if (b0 == null) {
                u42.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new uz1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                u42.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new uz1(1001, "swan activity is null");
            }
            Pair<uz1, JSONObject> s = s(str);
            uz1 uz1Var = (uz1) s.first;
            if (!uz1Var.isSuccess()) {
                return uz1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                u42.c("WifiApi", "startWifi: 201 : callback is null");
                return new uz1(201, "callback is null");
            }
            ri3 s2 = ri3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return uz1.f();
            }
            u42.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new uz1(12010, "unknown failed");
        }
        return (uz1) invokeL.objValue;
    }

    public uz1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            u73 b0 = u73.b0();
            if (b0 == null) {
                u42.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new uz1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                u42.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new uz1(1001, "swan activity is null");
            }
            Pair<uz1, JSONObject> s = s(str);
            uz1 uz1Var = (uz1) s.first;
            if (!uz1Var.isSuccess()) {
                return uz1Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                u42.c("WifiApi", "stopWifi: 201 : callback is null");
                return new uz1(201, "callback is null");
            }
            ri3 s2 = ri3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return uz1.f();
            }
            u42.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new uz1(12010, "unknown failed");
        }
        return (uz1) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = t73.K().w();
            w23.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = t73.K().w();
            w23.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
