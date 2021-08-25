package com.bytedance.sdk.component.adnet;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.c.b;
import com.bytedance.sdk.component.adnet.core.k;
import com.bytedance.sdk.component.adnet.core.l;
import com.bytedance.sdk.component.adnet.core.n;
import com.bytedance.sdk.component.adnet.core.o;
import com.bytedance.sdk.component.net.tnc.AppConfig;
import java.io.File;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static n f64022a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f64023b = null;

    /* renamed from: c  reason: collision with root package name */
    public static b f64024c = null;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f64025d = true;

    /* renamed from: e  reason: collision with root package name */
    public static com.bytedance.sdk.component.adnet.c.a f64026e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1209716820, "Lcom/bytedance/sdk/component/adnet/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1209716820, "Lcom/bytedance/sdk/component/adnet/a;");
        }
    }

    public static l a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? k.a(context) : (l) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) {
            try {
                if (TextUtils.isEmpty(f64023b)) {
                    File file = new File(context.getCacheDir(), "VAdNetSdk");
                    file.mkdirs();
                    f64023b = file.getAbsolutePath();
                }
            } catch (Throwable th) {
                o.a(th, "init adnetsdk default directory error ", new Object[0]);
            }
            return f64023b;
        }
        return (String) invokeL.objValue;
    }

    public static com.bytedance.sdk.component.adnet.c.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f64026e : (com.bytedance.sdk.component.adnet.c.a) invokeV.objValue;
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            b bVar = f64024c;
            if (bVar != null) {
                return bVar;
            }
            throw new IllegalArgumentException("sITTNetDepend is null");
        }
        return (b) invokeV.objValue;
    }

    public static void a(com.bytedance.sdk.component.adnet.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, aVar) == null) {
            f64026e = aVar;
        }
    }

    public static void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, activity) == null) || activity == null) {
            return;
        }
        AppConfig.getInstance(activity.getApplicationContext()).getThreadPoolExecutor().execute(new Runnable(activity.getApplicationContext()) { // from class: com.bytedance.sdk.component.adnet.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f64027a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {r6};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64027a = r6;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    com.bytedance.sdk.component.adnet.a.a.a(this.f64027a).c();
                    com.bytedance.sdk.component.adnet.a.a.a(this.f64027a);
                    com.bytedance.sdk.component.adnet.a.a.b(this.f64027a);
                }
            }
        });
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f64025d : invokeV.booleanValue;
    }
}
