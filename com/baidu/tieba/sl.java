package com.baidu.tieba;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes6.dex */
public final class sl {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448317044, "Lcom/baidu/tieba/sl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448317044, "Lcom/baidu/tieba/sl;");
                return;
            }
        }
        a = new a(null);
    }

    @JvmStatic
    public static final void a(PackageInfo packageInfo, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, packageInfo, str) == null) {
            a.a(packageInfo, str);
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

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

        public final String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return Application.getProcessName();
                }
                return "";
            }
            return (String) invokeV.objValue;
        }

        @JvmStatic
        public final void a(PackageInfo packageInfo, String str) {
            Object obj;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, packageInfo, str) == null) && packageInfo != null && !TextUtils.isEmpty(packageInfo.name)) {
                String str2 = packageInfo.name;
                Intrinsics.checkNotNullExpressionValue(str2, "packageInfo.name");
                boolean z = false;
                if (StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "nama", false, 2, (Object) null)) {
                    vg8 defaultLog = DefaultLog.getInstance();
                    StringBuilder sb = new StringBuilder();
                    if ((str == null || str.length() == 0) ? true : true) {
                        str = "";
                    }
                    sb.append(str);
                    sb.append(", abi:");
                    if (Build.VERSION.SDK_INT >= 21) {
                        obj = (Serializable) Build.SUPPORTED_ABIS;
                    } else {
                        obj = Build.CPU_ABI2;
                    }
                    sb.append(obj);
                    sb.append(", process: ");
                    sb.append(b());
                    sb.append(", thread:");
                    sb.append(Thread.currentThread().getId());
                    sb.append(", packageinfo: ");
                    sb.append(packageInfo);
                    defaultLog.c("libnama check", sb.toString());
                }
            }
        }
    }
}
