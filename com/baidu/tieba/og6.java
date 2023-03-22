package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public class og6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Intent a(Context context, String str, String str2, boolean z, ng6 ng6Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, str, str2, Boolean.valueOf(z), ng6Var})) == null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            int i = 0;
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            while (true) {
                if (i >= queryIntentActivities.size()) {
                    break;
                }
                String str3 = queryIntentActivities.get(i).activityInfo.packageName;
                if (TextUtils.equals(str3, str2)) {
                    intent.setPackage(str3);
                    break;
                }
                i++;
            }
            if (z && !TextUtils.isEmpty(str2) && TextUtils.isEmpty(intent.getPackage())) {
                if (ng6Var != null) {
                    ng6Var.onFailed(-104);
                    return null;
                }
                return null;
            }
            return intent;
        }
        return (Intent) invokeCommon.objValue;
    }

    public static Intent b(@NonNull Context context, String str, String str2, boolean z, @Nullable ng6 ng6Var) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, str, str2, Boolean.valueOf(z), ng6Var})) == null) {
            if (!d(str) && !e(str)) {
                return a(context, str, str2, z, ng6Var);
            }
            return c(context, str, str2, ng6Var);
        }
        return (Intent) invokeCommon.objValue;
    }

    @Nullable
    public static Intent c(Context context, String str, String str2, ng6 ng6Var) {
        InterceptResult invokeLLLL;
        List<ResolveInfo> queryIntentActivities;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, context, str, str2, ng6Var)) == null) {
            Intent intent = null;
            try {
                Intent parseUri = Intent.parseUri(str, 1);
                if (parseUri == null) {
                    if (ng6Var != null) {
                        ng6Var.onFailed(-103);
                    }
                    return null;
                }
                String str3 = parseUri.getPackage();
                if (str3 != null && !TextUtils.isEmpty(str3)) {
                    parseUri.setFlags(LaunchTaskConstants.OTHER_PROCESS);
                    Set<String> categories = parseUri.getCategories();
                    if (categories == null || categories.isEmpty()) {
                        parseUri.addCategory("android.intent.category.LAUNCHER");
                    }
                    if (parseUri.getComponent() == null && (queryIntentActivities = context.getPackageManager().queryIntentActivities(parseUri, 0)) != null && queryIntentActivities.size() > 0) {
                        parseUri.setComponent(new ComponentName(str3, queryIntentActivities.iterator().next().activityInfo.name));
                    }
                    return parseUri;
                }
                return context.getPackageManager().getLaunchIntentForPackage(str2);
            } catch (URISyntaxException unused) {
                if (!TextUtils.isEmpty(str2)) {
                    intent = context.getPackageManager().getLaunchIntentForPackage(str2);
                }
                if (intent == null && ng6Var != null) {
                    ng6Var.onFailed(-102);
                }
                return intent;
            }
        }
        return (Intent) invokeLLLL.objValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("android-app:");
        }
        return invokeL.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!str.startsWith("intent:") && !str.startsWith("#Intent;")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
