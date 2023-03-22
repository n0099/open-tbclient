package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.l9a;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class m9a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public static volatile m9a o;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public File b;
    public boolean c;
    public boolean d;
    public long e;
    public int f;
    public int g;
    public long h;
    public long i;
    public long j;
    public int k;
    public int l;
    public HashMap<String, l9a> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947928884, "Lcom/baidu/tieba/m9a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947928884, "Lcom/baidu/tieba/m9a;");
                return;
            }
        }
        n = AppConfig.isDebug();
    }

    public m9a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        n();
    }

    public static m9a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (o == null) {
                synchronized (m9a.class) {
                    if (o == null) {
                        o = new m9a();
                    }
                }
            }
            return o;
        }
        return (m9a) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.j;
        }
        return invokeV.longValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.h;
        }
        return invokeV.longValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i > 0 && i <= n9a.k) {
                this.f = i;
            } else {
                this.f = n9a.k;
            }
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        l9a l9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.c;
            }
            HashMap<String, l9a> hashMap = this.m;
            if (hashMap != null && (l9aVar = hashMap.get(str)) != null) {
                return l9aVar.e();
            }
            return this.c;
        }
        return invokeL.booleanValue;
    }

    public long b(String str) {
        InterceptResult invokeL;
        l9a l9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.i;
            }
            HashMap<String, l9a> hashMap = this.m;
            if (hashMap != null && (l9aVar = hashMap.get(str)) != null) {
                return l9aVar.a();
            }
            return this.i;
        }
        return invokeL.longValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        l9a l9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.l;
            }
            HashMap<String, l9a> hashMap = this.m;
            if (hashMap != null && (l9aVar = hashMap.get(str)) != null) {
                return l9aVar.b();
            }
            return this.l;
        }
        return invokeL.intValue;
    }

    public long d(String str) {
        InterceptResult invokeL;
        l9a l9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.h;
            }
            HashMap<String, l9a> hashMap = this.m;
            if (hashMap != null && (l9aVar = hashMap.get(str)) != null) {
                return l9aVar.d();
            }
            return this.h;
        }
        return invokeL.longValue;
    }

    public int e(String str) {
        InterceptResult invokeL;
        l9a l9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.g;
            }
            HashMap<String, l9a> hashMap = this.m;
            if (hashMap != null && (l9aVar = hashMap.get(str)) != null) {
                return l9aVar.c();
            }
            return this.g;
        }
        return invokeL.intValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.d = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.c = z;
        }
    }

    public void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            if (j <= 0) {
                this.i = n9a.g;
            } else {
                this.i = j;
            }
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            if (i > 0 && i <= n9a.i) {
                this.k = i;
            } else {
                this.k = n9a.i;
            }
        }
    }

    public void w(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            if (j > 0 && j <= n9a.h) {
                this.j = j;
            } else {
                this.j = n9a.h;
            }
        }
    }

    public void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j) == null) {
            if (j > 0 && j <= DownloadManager.MIN_LEFT_SIZE) {
                this.h = j;
            } else {
                this.h = DownloadManager.MIN_LEFT_SIZE;
            }
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            if (i > 0 && i <= n9a.j) {
                this.g = i;
            } else {
                this.g = n9a.j;
            }
        }
    }

    public void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            if (j <= 0) {
                this.e = n9a.e;
            } else {
                this.e = j;
            }
        }
    }

    public final boolean B(JSONObject jSONObject) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            if (jSONObject == null || jSONObject.length() == 0) {
                return false;
            }
            if (jSONObject.optInt(SetImageWatermarkTypeReqMsg.SWITCH) != n9a.p) {
                t(n9a.a);
            } else {
                t(n9a.b);
            }
            if (jSONObject.optInt("clear") != n9a.q) {
                r(n9a.c);
            } else {
                r(n9a.d);
            }
            long j2 = 1000;
            z(jSONObject.optInt("upload_interval") * 60 * 1000);
            A(jSONObject.optInt("max_count_per_round"));
            u(jSONObject.optInt("expired_time") * 24 * 60 * 60 * 1000);
            v(jSONObject.optInt("total_max_count"));
            w(jSONObject.optInt("total_max_size") * 1024 * 1024);
            y(jSONObject.optInt("single_max_count"));
            x(jSONObject.optInt("single_max_size") * 1024 * 1024);
            JSONObject optJSONObject = jSONObject.optJSONObject("set");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                    if (optJSONObject2 != null && optJSONObject2.length() != 0) {
                        l9a g = new l9a.b(next).g();
                        if (optJSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH) != n9a.p) {
                            g.f(n9a.a);
                        } else {
                            g.f(n9a.b);
                        }
                        int optInt = optJSONObject2.optInt("expired_time", 0);
                        if (optInt > 0) {
                            g.g(optInt * 24 * 60 * 60 * j2);
                        }
                        int optInt2 = optJSONObject2.optInt("single_max_count", 0);
                        if (optInt2 > 0) {
                            g.i(optInt2);
                        }
                        int optInt3 = optJSONObject2.optInt("single_max_size", 0);
                        if (optInt3 > 0) {
                            j = 1024;
                            g.j(optInt3 * 1024 * 1024);
                        } else {
                            j = 1024;
                        }
                        if (optJSONObject2.has("only_wifi")) {
                            g.h(optJSONObject2.optInt("only_wifi"));
                        }
                        if (!g.e() || g.a() != this.i || g.c() != this.g || g.d() != this.h || g.b() != this.l) {
                            if (this.m == null) {
                                this.m = new HashMap<>();
                            }
                            this.m.put(next, g);
                        }
                        j2 = 1000;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean C(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject != null && jSONObject.length() != 0) {
                if (n) {
                    Log.d("VoyagerConfig", "update Config: " + jSONObject.toString());
                }
                if (B(jSONObject)) {
                    boolean D = D();
                    if (D && !this.c && this.d) {
                        ((baa) ServiceManager.getService(baa.a)).f();
                    }
                    return D;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        l9a l9aVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("en", this.c);
                jSONObject.put("c", this.d);
                jSONObject.put(TaskUIData.key, this.e);
                jSONObject.put("utc", this.f);
                jSONObject.put("et", this.i);
                jSONObject.put("mfc", this.k);
                jSONObject.put("mfs", this.j);
                jSONObject.put("an", this.l);
                jSONObject.put("stmc", this.g);
                jSONObject.put("stms", this.h);
                if (this.m != null && this.m.size() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str : this.m.keySet()) {
                        if (!TextUtils.isEmpty(str) && (l9aVar = this.m.get(str)) != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            if (l9aVar.e()) {
                                i = n9a.o;
                            } else {
                                i = n9a.p;
                            }
                            jSONObject3.put("en", i);
                            jSONObject3.put("et", l9aVar.a());
                            jSONObject3.put("stmc", l9aVar.c());
                            jSONObject3.put("stms", l9aVar.d());
                            jSONObject3.put("an", l9aVar.b());
                            jSONObject2.put(str, jSONObject3);
                        }
                    }
                    if (jSONObject2.length() > 0) {
                        jSONObject.put("set", jSONObject2);
                    }
                }
            } catch (JSONException e) {
                if (n) {
                    e.printStackTrace();
                }
            }
            if (!this.a.exists()) {
                try {
                    this.a.createNewFile();
                } catch (IOException e2) {
                    if (n) {
                        e2.printStackTrace();
                    }
                }
            }
            return eaa.g(jSONObject.toString(), this.a);
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            File file = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "/config/");
            this.b = file;
            if (!file.exists()) {
                this.b.mkdirs();
            }
            File file2 = new File(this.b, "voyager_config.txt");
            this.a = file2;
            if (file2.exists()) {
                q();
            } else {
                s();
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.c = n9a.a;
            this.d = n9a.c;
            this.e = n9a.e;
            this.f = n9a.f;
            this.i = n9a.g;
            this.k = n9a.i;
            this.j = n9a.h;
            this.g = n9a.j;
            this.h = n9a.l;
            this.l = n9a.m;
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            String f = eaa.f(this.a);
            if (n) {
                Log.d("VoyagerConfig", "read from local: " + f);
            }
            if (TextUtils.isEmpty(f)) {
                s();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(f);
                this.c = jSONObject.optBoolean("en", n9a.a);
                this.d = jSONObject.optBoolean("c", n9a.c);
                this.e = jSONObject.optLong(TaskUIData.key, n9a.e);
                this.f = jSONObject.optInt("utc", n9a.f);
                this.i = jSONObject.optLong("et", n9a.g);
                this.k = jSONObject.optInt("mfc", n9a.i);
                this.j = jSONObject.optLong("mfs", n9a.h);
                this.l = jSONObject.optInt("an", n9a.m);
                this.g = jSONObject.optInt("stmc", n9a.j);
                this.h = jSONObject.optLong("stms", n9a.l);
                JSONObject optJSONObject = jSONObject.optJSONObject("set");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                        if (optJSONObject2 != null && optJSONObject2.length() != 0) {
                            l9a g = new l9a.b(next).g();
                            if (optJSONObject2.optInt("en") != n9a.p) {
                                g.f(n9a.a);
                            } else {
                                g.f(n9a.b);
                            }
                            long optInt = optJSONObject2.optInt("et", 0);
                            if (optInt > 0) {
                                g.g(optInt);
                            } else {
                                g.g(this.i);
                            }
                            int optInt2 = optJSONObject2.optInt("stmc", 0);
                            if (optInt2 > 0) {
                                g.i(optInt2);
                            } else {
                                g.i(this.g);
                            }
                            long optLong = optJSONObject2.optLong("stms", 0L);
                            if (optLong > 0) {
                                g.j(optLong);
                            } else {
                                g.j(this.h);
                            }
                            if (optJSONObject2.optInt("an") != n9a.n) {
                                g.h(n9a.m);
                            } else {
                                g.h(n9a.n);
                            }
                            if (!g.e() || g.a() != this.i || g.c() != this.g || g.d() != this.h || g.b() != this.l) {
                                if (this.m == null) {
                                    this.m = new HashMap<>();
                                }
                                this.m.put(next, g);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (n) {
                    e.printStackTrace();
                }
            }
        }
    }
}
