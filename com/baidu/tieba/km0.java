package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class km0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onResult(boolean z);
    }

    /* loaded from: classes6.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public static final km0 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-656797476, "Lcom/baidu/tieba/km0$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-656797476, "Lcom/baidu/tieba/km0$c;");
                    return;
                }
            }
            a = new km0(null);
        }
    }

    public km0() {
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

    public static km0 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c.a;
        }
        return (km0) invokeV.objValue;
    }

    public /* synthetic */ km0(a aVar) {
        this();
    }

    public final String a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            return String.valueOf(j) + String.valueOf(((int) (Math.random() * 1.0E8d)) << 1);
        }
        return (String) invokeJ.objValue;
    }

    public boolean c(Context context, HashMap<String, String> hashMap, @Nullable b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hashMap, bVar)) == null) {
            return d(context, hashMap, bVar);
        }
        return invokeLLL.booleanValue;
    }

    public final void e(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) && !TextUtils.isEmpty(str2)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.u(ClogBuilder.Page.SCHEDULED_DOWNLOAD);
            clogBuilder.z(str);
            clogBuilder.p(str2);
            clogBuilder.j(str3);
            q31.e(clogBuilder);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b7, code lost:
        r14.onResult(false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean d(Context context, HashMap<String, String> hashMap, @Nullable b bVar) {
        InterceptResult invokeLLL;
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, context, hashMap, bVar)) == null) {
            String str4 = "";
            try {
                str = (String) c31.b(hashMap, "pkgName");
                str2 = (String) c31.b(hashMap, "channelId");
                str3 = (String) c31.b(hashMap, "extraParams");
            } catch (Exception unused) {
            }
            try {
                String str5 = (String) c31.b(hashMap, "scheduledTime");
                String str6 = (String) c31.b(hashMap, "requestUrl");
                String str7 = (String) c31.b(hashMap, "business");
                String str8 = (String) c31.b(hashMap, "source");
                String str9 = (String) c31.b(hashMap, "convertUrl");
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str)) {
                    lm0 lm0Var = new lm0(str, str2, Long.valueOf(Long.parseLong(str5)), str3, str6);
                    if (!TextUtils.isEmpty(str7)) {
                        lm0Var.g = str7;
                    }
                    if (!TextUtils.isEmpty(str8)) {
                        lm0Var.h = str8;
                    }
                    jm0.b().a(lm0Var);
                    e(ClogBuilder.LogType.SCHEDULED_DOWNLOAD_SUCCESS.type, str3, GrsBaseInfo.CountryCodeSource.APP);
                    if (!TextUtils.isEmpty(str9)) {
                        f(str9);
                    }
                    im0.d().e(lm0Var.b, lm0Var.c, context);
                    if (bVar != null) {
                        bVar.onResult(true);
                    }
                    return true;
                }
                if (!TextUtils.isEmpty(str3)) {
                    e(ClogBuilder.LogType.SCHEDULED_DOWNLOAD_SUCCESS.type, str3, "PARAMS_ERROR");
                }
                return false;
            } catch (Exception unused2) {
                str4 = str3;
                if (bVar != null) {
                    bVar.onResult(false);
                }
                if (!TextUtils.isEmpty(str4)) {
                    e(ClogBuilder.LogType.SCHEDULED_DOWNLOAD_SUCCESS.type, str4, "FORMAT_ERROR");
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final void f(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String replace = str.replace("__PVID__", a(currentTimeMillis)).replace("__MICRO_TIME__", String.valueOf(currentTimeMillis)).replace("__TIME_STAMP__", String.valueOf(currentTimeMillis / 1000));
        nt0 nt0Var = new nt0();
        nt0Var.l(replace);
        nt0Var.a("Content-Type", "application/json");
        nt0Var.a("Origin", "feedScheduledDownload");
        nt0Var.j(10000);
        nt0Var.g(10000);
        nt0Var.c();
        us0.b().a().a(nt0Var, null);
    }
}
