package com.baidu.wallet.lightapp.base;

import android.app.Activity;
import android.view.WindowManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.base.utils.LightappUtils;
/* loaded from: classes8.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(float f2, Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Float.valueOf(f2), activity}) == null) || activity == null) {
            return;
        }
        LightappUtils.runOnUiThread(new Runnable(activity, f2) { // from class: com.baidu.wallet.lightapp.base.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Activity f61901a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ float f61902b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {activity, Float.valueOf(f2)};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61901a = activity;
                this.f61902b = f2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    WindowManager.LayoutParams attributes = this.f61901a.getWindow().getAttributes();
                    float f3 = attributes.screenBrightness;
                    float f4 = this.f61902b;
                    if (f3 == f4) {
                        return;
                    }
                    if (f4 >= 0.0f && f4 <= 1.0f) {
                        attributes.screenBrightness = f4;
                    } else {
                        attributes.screenBrightness = -1.0f;
                    }
                    this.f61901a.getWindow().setAttributes(attributes);
                }
            }
        });
    }

    public static void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, activity) == null) {
            a(-1.0f, activity);
        }
    }
}
