package com.baidu.webkit.sdk.dumper;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ApisInteractWithMario;
import com.baidu.webkit.sdk.WebViewFactory;
/* loaded from: classes11.dex */
public class ZwDebug {
    public static /* synthetic */ Interceptable $ic;
    public static boolean debugModel;
    public transient /* synthetic */ FieldHolder $fh;

    public ZwDebug() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void clearCrashKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            ApisInteractWithMario.clearCrashKey(str);
        }
    }

    public static void crashIntentionally(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65538, null, i2) == null) && debugModel) {
            WebViewFactory.getProvider().getStatics().crashIntentionally(i2);
        }
    }

    public static boolean debugModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? debugModel : invokeV.booleanValue;
    }

    public static synchronized void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) {
            synchronized (ZwDebug.class) {
                try {
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    if (applicationInfo != null) {
                        debugModel = (applicationInfo.flags & 2) != 0;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void setCrashKeyValue(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, str2) == null) {
            ApisInteractWithMario.setCrashKeyValue(str, str2);
        }
    }
}
