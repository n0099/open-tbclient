package com.baidu.tieba;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.j5b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class q5b {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948044235, "Lcom/baidu/tieba/q5b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948044235, "Lcom/baidu/tieba/q5b;");
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends z5b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* loaded from: classes7.dex */
        public class a implements j5b.a<JSONObject> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.j5b.a
            public final void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                }
            }

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.tieba.j5b.a
            public final /* synthetic */ void a(JSONObject jSONObject) {
                a6b.a("status_updated");
            }
        }

        public e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // com.baidu.tieba.z5b
        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || a6b.b("status_updated")) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("exids", this.a);
            j5b.c(j5b.d("http://absample.baidu.com/appabapp/appapi/updateStatus", hashMap), new a(this));
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements j5b.a<JSONArray> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.j5b.a
        public final /* synthetic */ void a(JSONArray jSONArray) {
            JSONArray jSONArray2 = jSONArray;
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray2.length(); i++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                com.baidu.ubs.analytics.a.g gVar = new com.baidu.ubs.analytics.a.g();
                gVar.setGroup(optJSONObject.optString("group"));
                gVar.setId(optJSONObject.optString("id"));
                gVar.y(optJSONObject.optString("sid"));
                if (i > 0) {
                    stringBuffer.append("_");
                }
                stringBuffer.append(gVar.getId());
                arrayList.add(gVar);
            }
            w4b.h().c(arrayList);
            q5b.a(stringBuffer.toString());
        }

        @Override // com.baidu.tieba.j5b.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                while (q5b.a < 2) {
                    synchronized (this) {
                        q5b.f();
                    }
                    q5b.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends z5b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.tieba.z5b
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                q5b.k(this.a);
                if (w4b.h().i() != null && !w4b.h().i().equals("")) {
                    f6b.a("BaiDuAB sdk  init success");
                } else {
                    String h = q5b.h(w4b.h().getContext());
                    if (h == null || h.equals("")) {
                        f6b.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY in Manifest or network is available");
                        return;
                    }
                }
                q5b.d();
                q5b.c();
                y5b.b(new u5b(), p5b.e(), p5b.c());
                g6b.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements j5b.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ Context b;

        public c(long j, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.j5b.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("token");
            if (optString != null && !optString.isEmpty()) {
                w4b.h().b(optString);
                a6b.f("token", optString);
                a6b.g("token_update_time", this.a);
                a6b.f("lastkey", q5b.i(this.b));
            }
        }

        @Override // com.baidu.tieba.j5b.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                f6b.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY  in Manifest   or network is available");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements j5b.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.j5b.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("cuid");
            if (TextUtils.isEmpty(optString)) {
                w4b.h().e("");
                return;
            }
            w4b.h().e(optString);
            a6b.f("cuid", optString);
        }

        @Override // com.baidu.tieba.j5b.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && str.equals("1")) {
                w4b.h().e("");
            }
        }
    }

    public static /* synthetic */ void a(String str) {
        y5b.a(new e(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(v4b v4bVar) {
        byte b2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, v4bVar) == null) {
            int g = v4bVar.g();
            if (g < 1000) {
                String e2 = s5b.e(v4bVar.a());
                int length = e2.length();
                int i2 = length << 1;
                byte[] bArr = new byte[i2];
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    char charAt = e2.charAt(i4);
                    int i5 = i3 + 1;
                    bArr[i3] = (byte) (charAt & 255);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) (charAt >> '\b');
                }
                int i6 = (-1756908916) ^ i2;
                int i7 = i2 / 4;
                for (int i8 = 0; i8 < i7; i8++) {
                    int i9 = i8 * 4;
                    int i10 = ((bArr[i9 + 0] & 255) + ((bArr[i9 + 1] & 255) << 8) + ((bArr[i9 + 2] & 255) << 16) + ((bArr[i9 + 3] & 255) << 24)) * 1540483477;
                    i6 = (i6 * 1540483477) ^ (((i10 >>> 24) ^ i10) * 1540483477);
                }
                int i11 = i2 % 4;
                if (i11 == 3) {
                    int i12 = i2 & (-4);
                    i6 = (i6 ^ ((bArr[i12 + 2] & 255) << 16)) ^ ((bArr[i12 + 1] & 255) << 8);
                    b2 = bArr[i12];
                } else if (i11 == 2) {
                    int i13 = i2 & (-4);
                    i6 ^= (bArr[i13 + 1] & 255) << 8;
                    b2 = bArr[i13];
                } else {
                    if (i11 == 1) {
                        b2 = bArr[i2 & (-4)];
                    }
                    i = (i6 ^ (i6 >>> 13)) * 1540483477;
                    if (Math.abs((i ^ (i >>> 15)) % 1000) >= g) {
                        u4b.f(false);
                        return;
                    }
                }
                i6 = (i6 ^ (b2 & 255)) * 1540483477;
                i = (i6 ^ (i6 >>> 13)) * 1540483477;
                if (Math.abs((i ^ (i >>> 15)) % 1000) >= g) {
                }
            }
            w4b.h().a(v4bVar.a());
            u4b.f(true);
            f6b.g(v4bVar.b());
            x5b.b(com.baidu.ubs.analytics.d.a.c() + "-进行一次 初始化   " + new Date().toLocaleString() + GlideException.IndentedAppendable.INDENT + j(v4bVar.a()));
            p5b.b(v4bVar.c());
            p5b.f(v4bVar.d());
            p5b.g(v4bVar.f());
            p5b.h(v4bVar.e());
            l5b.a(v4bVar.a());
            y5b.a(new b(v4bVar.a()));
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (TextUtils.isEmpty(w4b.h().j())) {
                d();
            }
            if (TextUtils.isEmpty(w4b.h().j())) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("package", w4b.h().getContext().getPackageName());
            hashMap.put("cuid", w4b.h().j());
            j5b.c(j5b.d("http://absample.baidu.com/appabapp/appapi/getgroup", hashMap), new a());
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            String e2 = a6b.e("cuid", "");
            if (!TextUtils.isEmpty(e2)) {
                x5b.b("本地 取得  cuid~~");
                w4b.h().e(e2);
                return;
            }
            x5b.b("网络请求  cuid~~");
            HashMap hashMap = new HashMap();
            hashMap.put("imei", s5b.g(w4b.h().getContext()));
            hashMap.put("mac", s5b.h(w4b.h().getContext()));
            j5b.c(j5b.d("http://absample.baidu.com/appabapp/appapi/getcuid", hashMap), new d());
        }
    }

    public static /* synthetic */ int f() {
        int i = a;
        a = i + 1;
        return i;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String i = i(context);
            HashMap hashMap = new HashMap();
            hashMap.put("key", i);
            hashMap.put("package", context.getPackageName());
            j5b.c(j5b.d("http://absample.baidu.com/appabapp/appapi/gettoken", hashMap), new c(currentTimeMillis, context));
            return w4b.h().i();
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("BAIDUAB_APPKEY");
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager.getRunningAppProcesses() == null) {
                return DownloadStatisticConstants.UBC_VALUE_UNKNOW;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return DownloadStatisticConstants.UBC_VALUE_UNKNOW;
        }
        return (String) invokeL.objValue;
    }

    public static /* synthetic */ String k(Context context) {
        String e2 = a6b.e("lastkey", "");
        long c2 = a6b.c("token_update_time");
        if (e2.equals(i(context)) && c2 + 86400000 >= System.currentTimeMillis()) {
            String e3 = a6b.e("token", "");
            if (!e3.equals("")) {
                w4b.h().b(e3);
                return e3;
            }
        }
        return h(context);
    }
}
