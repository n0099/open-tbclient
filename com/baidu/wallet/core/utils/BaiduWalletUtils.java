package com.baidu.wallet.core.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.beans.BeanConstants;
/* loaded from: classes5.dex */
public final class BaiduWalletUtils {
    public static final boolean IS_BAIDUAPP_PLUGIN = false;

    /* renamed from: a  reason: collision with root package name */
    public static int f24255a;

    /* renamed from: b  reason: collision with root package name */
    public static int f24256b;

    /* renamed from: c  reason: collision with root package name */
    public static int f24257c;

    /* renamed from: d  reason: collision with root package name */
    public static int f24258d;

    /* loaded from: classes5.dex */
    public interface IRequestPermissionCallBack {
        void isAllAgree(Boolean bool);

        void isShow(String str, Boolean bool);

        void requestResult(String str, Boolean bool);
    }

    public static void finishActivityAnim(Context context) {
        if (context == null) {
            return;
        }
        if (f24257c == 0 || f24258d == 0) {
            f24257c = ResUtils.anim(context, "wallet_base_slide_from_left");
            f24258d = ResUtils.anim(context, "wallet_base_slide_to_right");
        }
        if ((context instanceof Activity) && BeanConstants.needActAnimation) {
            ((Activity) context).overridePendingTransition(f24257c, f24258d);
        }
        LogUtil.v("xyz", "BaiduWalletUtils-finishActivityAnim-context:" + context + ", mCloseEnter:" + f24257c + ", mCloseExit:" + f24258d);
    }

    public static String getBaiduappVersionCode(Context context) {
        return null;
    }

    public static String getBaiduappVersionName(Context context) {
        return null;
    }

    public static String[] getForegroundActivityInfo(Context context) {
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

    public static void invokeHostLightapp(Context context, String str) {
    }

    public static boolean isActivity(Context context) {
        return (context instanceof Activity) || (context instanceof BaseActivity);
    }

    public static boolean isNightMode() {
        return false;
    }

    public static void overridePendingTransitionNoAnim(Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    public static void requestPermissionsDialog(String str, Activity activity, String[] strArr, IRequestPermissionCallBack iRequestPermissionCallBack) {
        DangerousPermissionUtils.getInstance().requestPermissionsDialog(str, activity, strArr, iRequestPermissionCallBack);
    }

    public static void startActivity(Intent intent, Context context) {
        if (context == null) {
            return;
        }
        context.startActivity(intent);
    }

    public static void startActivityAnim(Context context) {
        if (context == null) {
            return;
        }
        if (f24255a == 0 || f24256b == 0) {
            f24255a = ResUtils.anim(context, "wallet_base_slide_from_right");
            f24256b = ResUtils.anim(context, "wallet_base_slide_to_left");
        }
        if ((context instanceof Activity) && BeanConstants.needActAnimation) {
            ((Activity) context).overridePendingTransition(f24255a, f24256b);
        }
    }
}
