package com.bytedance.pangle.util;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.activity.IPluginActivity;
import com.bytedance.pangle.log.ZeusLogger;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(com.bytedance.pangle.wrapper.a aVar, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, aVar, activity) == null) {
            try {
                FieldUtils.writeField(aVar, "mTheme", (Object) null);
                FieldUtils.writeField((Object) aVar, "mThemeResource", (Object) 0);
                int[] a = a(activity);
                if (a == null) {
                    return;
                }
                for (int i2 : a) {
                    if (i2 != 0) {
                        aVar.setWrapperActivityTheme(i2);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static int[] a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            Resources.Theme theme = activity.getTheme();
            if (theme == null) {
                return null;
            }
            try {
                if (h.c()) {
                    Object readField = FieldUtils.readField(theme, "mThemeImpl");
                    if (readField == null) {
                        return null;
                    }
                    try {
                        Object invokeMethod = MethodUtils.invokeMethod(readField, "getKey", new Object[0]);
                        if (invokeMethod != null) {
                            return (int[]) FieldUtils.readField(invokeMethod, "mResId");
                        }
                    } catch (Exception unused) {
                    }
                    Object invoke = com.bytedance.pangle.a.b.a.a(readField.getClass(), "getKey", new Class[0]).invoke(readField, new Object[0]);
                    if (invoke == null) {
                        ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey failed!");
                        return null;
                    }
                    ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey success by doubleReflector!");
                    return (int[]) com.bytedance.pangle.a.b.a.a(invoke.getClass(), "mResId").get(invoke);
                }
                if (Build.VERSION.SDK_INT > 22) {
                    Object invokeMethod2 = MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
                    if (invokeMethod2 == null) {
                        return null;
                    }
                    return (int[]) FieldUtils.readField(invokeMethod2, "mResId");
                }
                String str = (String) MethodUtils.invokeMethod(theme, "getKey", new Object[0]);
                if (str == null) {
                    return null;
                }
                String[] split = str.trim().replace("!", "").split(" ");
                int[] iArr = new int[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    iArr[i2] = Integer.parseInt(split[i2], 16);
                }
                return iArr;
            } catch (Throwable th) {
                ZeusLogger.d(ZeusLogger.TAG_ACTIVITY, "getKey exception!" + th.getMessage());
                return null;
            }
        }
        return (int[]) invokeL.objValue;
    }

    public static void a(IPluginActivity iPluginActivity, Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, iPluginActivity, activity) == null) {
            try {
                FieldUtils.writeField(iPluginActivity, "mTheme", (Object) null);
                FieldUtils.writeField((Object) iPluginActivity, "mThemeResource", (Object) 0);
                int[] a = a(activity);
                if (a == null) {
                    return;
                }
                for (int i2 : a) {
                    if (i2 != 0) {
                        iPluginActivity.setProxyTheme2Plugin(i2);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
