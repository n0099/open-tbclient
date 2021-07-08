package com.baidu.wallet.core.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanConstants;
/* loaded from: classes5.dex */
public final class BaiduWalletUtils {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean IS_BAIDUAPP_PLUGIN = false;

    /* renamed from: a  reason: collision with root package name */
    public static int f24708a;

    /* renamed from: b  reason: collision with root package name */
    public static int f24709b;

    /* renamed from: c  reason: collision with root package name */
    public static int f24710c;

    /* renamed from: d  reason: collision with root package name */
    public static int f24711d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface IRequestPermissionCallBack {
        void isAllAgree(Boolean bool);

        void isShow(String str, Boolean bool);

        void requestResult(String str, Boolean bool);
    }

    public BaiduWalletUtils() {
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

    public static void finishActivityAnim(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, context) == null) || context == null) {
            return;
        }
        if (f24710c == 0 || f24711d == 0) {
            f24710c = ResUtils.anim(context, "wallet_base_slide_from_left");
            f24711d = ResUtils.anim(context, "wallet_base_slide_to_right");
        }
        if ((context instanceof Activity) && BeanConstants.needActAnimation) {
            ((Activity) context).overridePendingTransition(f24710c, f24711d);
        }
        LogUtil.v("xyz", "BaiduWalletUtils-finishActivityAnim-context:" + context + ", mCloseEnter:" + f24710c + ", mCloseExit:" + f24711d);
    }

    public static String getBaiduappVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String getBaiduappVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String[] getForegroundActivityInfo(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                return new String[]{activity.getPackageName(), activity.getComponentName().getClassName()};
            } else if (context == null) {
                return null;
            } else {
                try {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    ActivityManager.RunningTaskInfo runningTaskInfo = activityManager != null ? activityManager.getRunningTasks(1).get(0) : null;
                    if (runningTaskInfo != null) {
                        ComponentName componentName = runningTaskInfo.topActivity;
                        return new String[]{componentName.getPackageName(), componentName.getClassName()};
                    }
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        return (String[]) invokeL.objValue;
    }

    public static void invokeHostLightapp(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str) == null) {
        }
    }

    public static boolean isActivity(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? (context instanceof Activity) || (context instanceof BaseActivity) : invokeL.booleanValue;
    }

    public static boolean isNightMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void overridePendingTransitionNoAnim(Activity activity) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, activity) == null) || activity == null) {
            return;
        }
        activity.overridePendingTransition(0, 0);
    }

    public static void requestPermissionsDialog(String str, Activity activity, String[] strArr, IRequestPermissionCallBack iRequestPermissionCallBack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65545, null, str, activity, strArr, iRequestPermissionCallBack) == null) {
            DangerousPermissionUtils.getInstance().requestPermissionsDialog(str, activity, strArr, iRequestPermissionCallBack);
        }
    }

    public static void startActivity(Intent intent, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, intent, context) == null) || context == null) {
            return;
        }
        context.startActivity(intent);
    }

    public static void startActivityAnim(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, context) == null) || context == null) {
            return;
        }
        if (f24708a == 0 || f24709b == 0) {
            f24708a = ResUtils.anim(context, "wallet_base_slide_from_right");
            f24709b = ResUtils.anim(context, "wallet_base_slide_to_left");
        }
        if ((context instanceof Activity) && BeanConstants.needActAnimation) {
            ((Activity) context).overridePendingTransition(f24708a, f24709b);
        }
    }
}
