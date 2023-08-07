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
import com.baidu.tieba.dg3;
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
public class ol3 extends bz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final rp3<yl3<xl3>> f;
    public static final rp3<yl3<List<xl3>>> g;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bz1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "Wifi" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? "WifiApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements b63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ wl3 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ol3 d;

        /* renamed from: com.baidu.tieba.ol3$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0417a implements rp3<yl3<xl3>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0417a(a aVar) {
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
            @Override // com.baidu.tieba.rp3
            /* renamed from: b */
            public void a(yl3<xl3> yl3Var) {
                y22 y22Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yl3Var) == null) {
                    if (yl3Var.a != 0) {
                        y72.i("WifiApi", "connectWifi: " + yl3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yl3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (yl3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", yl3Var.c.n());
                        } catch (JSONException e) {
                            y72.i("WifiApi", "getConnectedWifi: " + yl3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yl3Var.b + ZeusCrashHandler.NAME_SEPERATOR + yl3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    a aVar = this.a;
                    ol3 ol3Var = aVar.d;
                    String str = aVar.c;
                    if (jSONObject == null) {
                        y22Var = new y22(yl3Var.a, yl3Var.b);
                    } else {
                        y22Var = new y22(yl3Var.a, yl3Var.b, jSONObject);
                    }
                    ol3Var.d(str, y22Var);
                }
            }
        }

        public a(ol3 ol3Var, Activity activity, wl3 wl3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol3Var, activity, wl3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ol3Var;
            this.a = activity;
            this.b = wl3Var;
            this.c = str;
        }

        @Override // com.baidu.tieba.b63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vl3.s(this.a).a(this.b, new C0417a(this));
            }
        }

        @Override // com.baidu.tieba.b63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                y72.i("WifiApi", "connectWifi: 12012 : no location permission");
                this.d.d(this.c, new y22(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements b63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ol3 c;

        /* loaded from: classes7.dex */
        public class a implements rp3<yl3<Void>> {
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
            @Override // com.baidu.tieba.rp3
            /* renamed from: b */
            public void a(yl3<Void> yl3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yl3Var) == null) {
                    if (yl3Var.a != 0) {
                        y72.i("WifiApi", "getWifiList: " + yl3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yl3Var.b);
                    }
                    g gVar = this.a;
                    gVar.c.d(gVar.b, new y22(yl3Var.a, yl3Var.b));
                }
            }
        }

        public g(ol3 ol3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ol3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.b63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vl3.s(this.a).c(new a(this));
            }
        }

        @Override // com.baidu.tieba.b63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                y72.i("WifiApi", "getWifiList: 12012 : no location permission");
                this.c.d(this.b, new y22(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements b63 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ol3 c;

        /* loaded from: classes7.dex */
        public class a implements rp3<yl3<xl3>> {
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
            @Override // com.baidu.tieba.rp3
            /* renamed from: b */
            public void a(yl3<xl3> yl3Var) {
                y22 y22Var;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yl3Var) == null) {
                    if (yl3Var.a != 0) {
                        y72.i("WifiApi", "getConnectedWifi: " + yl3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yl3Var.b);
                    }
                    JSONObject jSONObject = null;
                    if (yl3Var.c != null) {
                        jSONObject = new JSONObject();
                        try {
                            jSONObject.put("wifi", yl3Var.c.n());
                        } catch (JSONException e) {
                            y72.i("WifiApi", "getConnectedWifi: " + yl3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yl3Var.b + ZeusCrashHandler.NAME_SEPERATOR + yl3Var.c + "\n" + Log.getStackTraceString(e));
                        }
                    }
                    i iVar = this.a;
                    ol3 ol3Var = iVar.c;
                    String str = iVar.b;
                    if (jSONObject == null) {
                        y22Var = new y22(yl3Var.a, yl3Var.b);
                    } else {
                        y22Var = new y22(yl3Var.a, yl3Var.b, jSONObject);
                    }
                    ol3Var.d(str, y22Var);
                }
            }
        }

        public i(ol3 ol3Var, Activity activity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol3Var, activity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ol3Var;
            this.a = activity;
            this.b = str;
        }

        @Override // com.baidu.tieba.b63
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                vl3.s(this.a).j(new a(this));
            }
        }

        @Override // com.baidu.tieba.b63
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                y72.i("WifiApi", "getConnectedWifi: 12012 : no location permission");
                this.c.d(this.b, new y22(12012, "no location permission"));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements rp3<yl3<xl3>> {
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
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(yl3<xl3> yl3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yl3Var) == null) && yl3Var != null && yl3Var.a == 0 && yl3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("wifiInfo", yl3Var.c);
                } catch (JSONException e) {
                    y72.c("WifiApi", "dispatch event onWifiConnected: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                lw2.T().u(new zk2("wifiConnected", hashMap));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements rp3<yl3<List<xl3>>> {
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
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(yl3<List<xl3>> yl3Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yl3Var) == null) && yl3Var != null && yl3Var.a == 0 && yl3Var.c != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (xl3 xl3Var : yl3Var.c) {
                    jSONArray.put(xl3Var);
                }
                try {
                    jSONObject.put("wifiList", jSONArray);
                } catch (JSONException e) {
                    y72.c("WifiApi", "dispatch event onGetWifiList: " + Log.getStackTraceString(e));
                }
                HashMap hashMap = new HashMap();
                hashMap.put("data", jSONObject.toString());
                lw2.T().u(new zk2("getWifiList", hashMap));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements rp3<yl3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ol3 b;

        public d(ol3 ol3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ol3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(yl3<Void> yl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yl3Var) == null) {
                if (yl3Var.a != 0) {
                    y72.i("WifiApi", "startWifi: " + yl3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yl3Var.b);
                }
                this.b.d(this.a, new y22(yl3Var.a, yl3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements rp3<yl3<Void>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ol3 b;

        public e(ol3 ol3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ol3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(yl3<Void> yl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yl3Var) == null) {
                if (yl3Var.a != 0) {
                    y72.i("WifiApi", "stopWifi: " + yl3Var.a + ZeusCrashHandler.NAME_SEPERATOR + yl3Var.b);
                }
                this.b.d(this.a, new y22(yl3Var.a, yl3Var.b));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements rp3<bg3<dg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ol3 b;

        public f(ol3 ol3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ol3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(bg3<dg3.e> bg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bg3Var) == null) {
                if (wf3.h(bg3Var)) {
                    this.b.F(this.a);
                    return;
                }
                int b = bg3Var.b();
                y72.i("WifiApi", "getWifiList: " + b + ZeusCrashHandler.NAME_SEPERATOR + wf3.f(b));
                this.b.d(this.a, new y22(b, wf3.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements rp3<bg3<dg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ol3 b;

        public h(ol3 ol3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ol3Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(bg3<dg3.e> bg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bg3Var) == null) {
                if (wf3.h(bg3Var)) {
                    this.b.E(this.a);
                    return;
                }
                int b = bg3Var.b();
                y72.i("WifiApi", "getConnectedWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + wf3.f(b));
                this.b.d(this.a, new y22(b, wf3.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements rp3<bg3<dg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ wl3 b;
        public final /* synthetic */ ol3 c;

        public j(ol3 ol3Var, String str, wl3 wl3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ol3Var, str, wl3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ol3Var;
            this.a = str;
            this.b = wl3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(bg3<dg3.e> bg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bg3Var) == null) {
                if (!wf3.h(bg3Var)) {
                    int b = bg3Var.b();
                    y72.i("WifiApi", "connectWifi: " + b + ZeusCrashHandler.NAME_SEPERATOR + wf3.f(b));
                    this.c.d(this.a, new y22(b, wf3.f(b)));
                    return;
                }
                this.c.D(this.a, this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948036051, "Lcom/baidu/tieba/ol3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948036051, "Lcom/baidu/tieba/ol3;");
                return;
            }
        }
        f = new b();
        g = new c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ol3(@NonNull zy1 zy1Var) {
        super(zy1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zy1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((zy1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void D(String str, wl3 wl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, wl3Var) == null) {
            SwanAppActivity w = xa3.K().w();
            a63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new a(this, w, wl3Var, str));
        }
    }

    public y22 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#connectWifi", false);
            ya3 b0 = ya3.b0();
            if (b0 == null) {
                y72.c("WifiApi", "connectWifi: 1001 : swan app is null");
                return new y22(1001, "swan app is null");
            } else if (b0.w() == null) {
                y72.c("WifiApi", "connectWifi: 1001 : swan activity is null");
                return new y22(1001, "swan activity is null");
            } else {
                Pair<y22, JSONObject> s = s(str);
                y22 y22Var = (y22) s.first;
                if (!y22Var.isSuccess()) {
                    return y22Var;
                }
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    y72.c("WifiApi", "connectWifi: 201 : callback is null");
                    return new y22(201, "callback is null");
                }
                wl3 a2 = wl3.a(jSONObject);
                if (TextUtils.isEmpty(a2.a)) {
                    y72.i("WifiApi", "connectWifi: 12008 : invalid ssid");
                    return new y22(12008, "invalid ssid");
                } else if (b0.n0()) {
                    y72.i("WifiApi", "connectWifi: 12011 : app is invisible");
                    return new y22((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new j(this, optString, a2));
                    return y22.f();
                }
            }
        }
        return (y22) invokeL.objValue;
    }

    public y22 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#startWifi", false);
            ya3 b0 = ya3.b0();
            if (b0 == null) {
                y72.c("WifiApi", "startWifi: 1001 : swan app is null");
                return new y22(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                y72.c("WifiApi", "startWifi: 1001 : swan activity is null");
                return new y22(1001, "swan activity is null");
            }
            Pair<y22, JSONObject> s = s(str);
            y22 y22Var = (y22) s.first;
            if (!y22Var.isSuccess()) {
                return y22Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                y72.c("WifiApi", "startWifi: 201 : callback is null");
                return new y22(201, "callback is null");
            }
            vl3 s2 = vl3.s(w);
            if (s2.n(f) && s2.d(g)) {
                s2.p(new d(this, optString));
                return y22.f();
            }
            y72.i("WifiApi", "startWifi: 12010 : unknown failed");
            return new y22(12010, "unknown failed");
        }
        return (y22) invokeL.objValue;
    }

    public y22 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#stopWifi", false);
            ya3 b0 = ya3.b0();
            if (b0 == null) {
                y72.c("WifiApi", "stopWifi: 1001 : swan app is null");
                return new y22(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                y72.c("WifiApi", "stopWifi: 1001 : swan activity is null");
                return new y22(1001, "swan activity is null");
            }
            Pair<y22, JSONObject> s = s(str);
            y22 y22Var = (y22) s.first;
            if (!y22Var.isSuccess()) {
                return y22Var;
            }
            String optString = ((JSONObject) s.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                y72.c("WifiApi", "stopWifi: 201 : callback is null");
                return new y22(201, "callback is null");
            }
            vl3 s2 = vl3.s(w);
            if (s2.r(f) && s2.b(g)) {
                s2.q(new e(this, optString));
                return y22.f();
            }
            y72.i("WifiApi", "stopWifi: 12010 : unknown failed");
            return new y22(12010, "unknown failed");
        }
        return (y22) invokeL.objValue;
    }

    public y22 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#getConnectedWifi", false);
            ya3 b0 = ya3.b0();
            if (b0 == null) {
                y72.c("WifiApi", "getConnectedWifi: 1001 : swan app is null");
                return new y22(1001, "swan app is null");
            } else if (b0.w() == null) {
                y72.c("WifiApi", "getConnectedWifi: 1001 : swan activity is null");
                return new y22(1001, "swan activity is null");
            } else {
                Pair<y22, JSONObject> s = s(str);
                y22 y22Var = (y22) s.first;
                if (!y22Var.isSuccess()) {
                    return y22Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    y72.c("WifiApi", "getConnectedWifi: 201 : callback is null");
                    return new y22(201, "callback is null");
                } else if (b0.n0()) {
                    y72.i("WifiApi", "getConnectedWifi: 12011 : app is invisible");
                    return new y22((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new h(this, optString));
                    return y22.f();
                }
            }
        }
        return (y22) invokeL.objValue;
    }

    public y22 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getWifiList", false);
            ya3 b0 = ya3.b0();
            if (b0 == null) {
                y72.c("WifiApi", "getWifiList: 1001 : swan app is null");
                return new y22(1001, "swan app is null");
            } else if (b0.w() == null) {
                y72.c("WifiApi", "getWifiList: 1001 : swan activity is null");
                return new y22(1001, "swan activity is null");
            } else {
                Pair<y22, JSONObject> s = s(str);
                y22 y22Var = (y22) s.first;
                if (!y22Var.isSuccess()) {
                    return y22Var;
                }
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    y72.c("WifiApi", "getWifiList: 201 : callback is null");
                    return new y22(201, "callback is null");
                } else if (b0.n0()) {
                    y72.i("WifiApi", "getWifiList: 12011 : app is invisible");
                    return new y22((int) CyberPlayerManager.MEDIA_INFO_HTTP_REDIECT, "app is invisible");
                } else {
                    b0.e0().g(getContext(), "mapp_location", new f(this, optString));
                    return y22.f();
                }
            }
        }
        return (y22) invokeL.objValue;
    }

    public final void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SwanAppActivity w = xa3.K().w();
            a63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new i(this, w, str));
        }
    }

    public final void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            SwanAppActivity w = xa3.K().w();
            a63.g(w, new String[]{com.kuaishou.weapon.p0.h.g, com.kuaishou.weapon.p0.h.h}, 0, new g(this, w, str));
        }
    }
}
