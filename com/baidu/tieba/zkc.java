package com.baidu.tieba;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yy.render.trans.SimpleClientMessageSender;
import com.yy.transvod.player.log.TLog;
import com.yy.transvod.preference.Preference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class zkc extends SimpleClientMessageSender {
    public static /* synthetic */ Interceptable $ic;
    public static int i;
    public transient /* synthetic */ FieldHolder $fh;
    public final String f;
    public final Gson g;
    public final ExecutorService h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948364279, "Lcom/baidu/tieba/zkc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948364279, "Lcom/baidu/tieba/zkc;");
        }
    }

    @Override // com.yy.render.trans.SimpleClientMessageSender
    public void d(String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
        }
    }

    @Override // com.yy.render.trans.SimpleClientMessageSender
    public String e(String str, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bitmap)) == null) {
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.yy.render.trans.SimpleClientMessageSender
    public void f(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bundle) == null) {
        }
    }

    @Override // com.yy.render.trans.SimpleClientMessageSender
    public String g(String str, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, bundle)) == null) {
            return null;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.yy.render.trans.SimpleClientMessageSender
    public void j(String str, int i2, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048582, this, str, i2, str2, str3) == null) {
        }
    }

    @Override // com.yy.render.trans.SimpleClientMessageSender
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(zkc zkcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zkcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                return new Thread(runnable, "C-preference-" + zkc.n());
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zkc a;

        public b(zkc zkcVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zkcVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zkcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TLog.h("[PreferenceClient]", "initPreference");
                ugc ugcVar = new ugc();
                ugcVar.a = "initPreference";
                zkc zkcVar = this.a;
                zkcVar.l(zkcVar.g.toJson(ugcVar));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ zkc b;

        public c(zkc zkcVar, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zkcVar, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zkcVar;
            this.a = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TLog.h("[PreferenceClient]", "setMediaConfig");
                String json = this.b.g.toJson(this.a);
                ugc ugcVar = new ugc();
                ugcVar.a = "setMediaConfig";
                ugcVar.b.put("configs", json);
                zkc zkcVar = this.b;
                zkcVar.l(zkcVar.g.toJson(ugcVar));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ukc a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ qhc e;
        public final /* synthetic */ boolean f;

        public d(zkc zkcVar, ukc ukcVar, int i, int i2, String str, qhc qhcVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zkcVar, ukcVar, Integer.valueOf(i), Integer.valueOf(i2), str, qhcVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ukcVar;
            this.b = i;
            this.c = i2;
            this.d = str;
            this.e = qhcVar;
            this.f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a != null && (i = this.b) == 0) {
                    if (i == 0) {
                        TLog.h("[PreferenceClient]", "onStatistics,taskId:" + this.c + ",type:" + this.b + ",text:" + this.d);
                        this.a.a(this.c, this.b, this.d);
                        return;
                    } else if (this.e == null) {
                        TLog.h("[PreferenceClient]", "onStatistics,taskId:" + this.c + ",type:" + this.b + ",text:" + this.d);
                        this.a.a(this.c, this.b, this.d);
                        return;
                    }
                }
                if (this.b == 0) {
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("pkg", sgc.a(null));
                hashMap.put("appinfo", sgc.b(null));
                String str = "";
                String str2 = "";
                for (Map.Entry entry : hashMap.entrySet()) {
                    str2 = str2 + "&" + entry.getKey() + "=" + entry.getValue();
                }
                String str3 = this.d + str2;
                if (this.e != null && this.b != 0) {
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    this.e.a(this.c, this.b, this.f, hashMap2);
                    if (hashMap2.size() > 0) {
                        if (this.d.contains("scene=")) {
                            hashMap2.remove("scene");
                        }
                        hashMap2.remove("pkg");
                        hashMap2.remove("appinfo");
                        for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                            str = str + "&" + ((Object) entry2.getKey()) + "=" + ((Object) entry2.getValue());
                        }
                        str3 = str3 + str;
                    }
                }
                TLog.h("[PreferenceClient]", "PlayerStatisticsParams,taskId:" + this.c + ",stop:" + this.f + ",type:" + this.b + ",text:" + str3);
                pkc.i(this.c, this.b, str3);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zkc(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = Executors.newSingleThreadExecutor(new a(this));
        this.f = str;
        this.g = new GsonBuilder().excludeFieldsWithModifiers(128, 8).serializeNulls().create();
    }

    public static /* synthetic */ int n() {
        return r();
    }

    public static synchronized int r() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (zkc.class) {
                i2 = i;
                i = i2 + 1;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.h.execute(new b(this));
        }
    }

    public void s(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, hashMap) == null) && hashMap != null) {
            this.h.execute(new c(this, hashMap));
        }
    }

    @Override // com.yy.render.trans.SimpleClientMessageSender
    public void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, str, str2) != null) || !str.equals(this.f)) {
            return;
        }
        try {
            p(str2);
        } catch (Exception e) {
            e.printStackTrace();
            TLog.d("[PreferenceClient]", "(onDataFromServer) ex" + e.getMessage());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
        return "";
     */
    @Override // com.yy.render.trans.SimpleClientMessageSender
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String i(String str, String str2) {
        InterceptResult invokeLL;
        rkc e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            String str3 = "";
            if (!str.equals(this.f)) {
                return "";
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("cmd");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                char c2 = 65535;
                if (optString.hashCode() == 2015108602 && optString.equals("onDnsHostResolve")) {
                    c2 = 0;
                }
                skc a2 = Preference.a();
                if (a2 == null || (e = a2.e(jSONObject2.optString("hostName"))) == null) {
                    return "";
                }
                str3 = rkc.b(e);
                TLog.h("[PreferenceClient]", "return DnsHostResolve result to subprocess:" + str3);
                return str3;
            } catch (Exception e2) {
                e2.printStackTrace();
                TLog.d("[PreferenceClient]", "(onDataFromServerForStr) ex" + e2.getMessage());
                return str3;
            }
        }
        return (String) invokeLL.objValue;
    }

    public final void p(String str) throws Exception {
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("cmd");
            if (optString.hashCode() == -1048965022 && optString.equals("onStatistics")) {
                c2 = 0;
            } else {
                c2 = 65535;
            }
            if (c2 == 0) {
                ukc b2 = Preference.b();
                qhc c3 = Preference.c();
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                int optInt = jSONObject2.optInt("taskId");
                this.h.execute(new d(this, b2, jSONObject2.optInt("type"), optInt, jSONObject2.optString("text"), c3, jSONObject2.optBoolean("stop")));
            }
        }
    }
}
