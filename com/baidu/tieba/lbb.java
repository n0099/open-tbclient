package com.baidu.tieba;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.ebb;
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
public final class lbb {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947938525, "Lcom/baidu/tieba/lbb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947938525, "Lcom/baidu/tieba/lbb;");
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends ubb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* loaded from: classes7.dex */
        public class a implements ebb.a<JSONObject> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.ebb.a
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
            @Override // com.baidu.tieba.ebb.a
            public final /* synthetic */ void a(JSONObject jSONObject) {
                vbb.a("status_updated");
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

        @Override // com.baidu.tieba.ubb
        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || vbb.b("status_updated")) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("exids", this.a);
            ebb.c(ebb.d("http://absample.baidu.com/appabapp/appapi/updateStatus", hashMap), new a(this));
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements ebb.a<JSONArray> {
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
        @Override // com.baidu.tieba.ebb.a
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
            rab.h().c(arrayList);
            lbb.a(stringBuffer.toString());
        }

        @Override // com.baidu.tieba.ebb.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                while (lbb.a < 2) {
                    synchronized (this) {
                        lbb.f();
                    }
                    lbb.c();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends ubb {
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

        @Override // com.baidu.tieba.ubb
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lbb.k(this.a);
                if (rab.h().i() != null && !rab.h().i().equals("")) {
                    acb.a("BaiDuAB sdk  init success");
                } else {
                    String h = lbb.h(rab.h().getContext());
                    if (h == null || h.equals("")) {
                        acb.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY in Manifest or network is available");
                        return;
                    }
                }
                lbb.d();
                lbb.c();
                tbb.b(new pbb(), kbb.e(), kbb.c());
                bcb.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements ebb.a<JSONObject> {
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
        @Override // com.baidu.tieba.ebb.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("token");
            if (optString != null && !optString.isEmpty()) {
                rab.h().b(optString);
                vbb.f("token", optString);
                vbb.g("token_update_time", this.a);
                vbb.f("lastkey", lbb.i(this.b));
            }
        }

        @Override // com.baidu.tieba.ebb.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                acb.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY  in Manifest   or network is available");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements ebb.a<JSONObject> {
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
        @Override // com.baidu.tieba.ebb.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("cuid");
            if (TextUtils.isEmpty(optString)) {
                rab.h().e("");
                return;
            }
            rab.h().e(optString);
            vbb.f("cuid", optString);
        }

        @Override // com.baidu.tieba.ebb.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && str.equals("1")) {
                rab.h().e("");
            }
        }
    }

    public static /* synthetic */ void a(String str) {
        tbb.a(new e(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(qab qabVar) {
        byte b2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, qabVar) == null) {
            int g = qabVar.g();
            if (g < 1000) {
                String e2 = nbb.e(qabVar.a());
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
                        pab.f(false);
                        return;
                    }
                }
                i6 = (i6 ^ (b2 & 255)) * 1540483477;
                i = (i6 ^ (i6 >>> 13)) * 1540483477;
                if (Math.abs((i ^ (i >>> 15)) % 1000) >= g) {
                }
            }
            rab.h().a(qabVar.a());
            pab.f(true);
            acb.g(qabVar.b());
            sbb.b(com.baidu.ubs.analytics.d.a.c() + "-进行一次 初始化   " + new Date().toLocaleString() + GlideException.IndentedAppendable.INDENT + j(qabVar.a()));
            kbb.b(qabVar.c());
            kbb.f(qabVar.d());
            kbb.g(qabVar.f());
            kbb.h(qabVar.e());
            gbb.a(qabVar.a());
            tbb.a(new b(qabVar.a()));
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (TextUtils.isEmpty(rab.h().j())) {
                d();
            }
            if (TextUtils.isEmpty(rab.h().j())) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("package", rab.h().getContext().getPackageName());
            hashMap.put("cuid", rab.h().j());
            ebb.c(ebb.d("http://absample.baidu.com/appabapp/appapi/getgroup", hashMap), new a());
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            String e2 = vbb.e("cuid", "");
            if (!TextUtils.isEmpty(e2)) {
                sbb.b("本地 取得  cuid~~");
                rab.h().e(e2);
                return;
            }
            sbb.b("网络请求  cuid~~");
            HashMap hashMap = new HashMap();
            hashMap.put("imei", nbb.g(rab.h().getContext()));
            hashMap.put("mac", nbb.h(rab.h().getContext()));
            ebb.c(ebb.d("http://absample.baidu.com/appabapp/appapi/getcuid", hashMap), new d());
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
            ebb.c(ebb.d("http://absample.baidu.com/appabapp/appapi/gettoken", hashMap), new c(currentTimeMillis, context));
            return rab.h().i();
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
        String e2 = vbb.e("lastkey", "");
        long c2 = vbb.c("token_update_time");
        if (e2.equals(i(context)) && c2 + 86400000 >= System.currentTimeMillis()) {
            String e3 = vbb.e("token", "");
            if (!e3.equals("")) {
                rab.h().b(e3);
                return e3;
            }
        }
        return h(context);
    }
}
