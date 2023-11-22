package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.im.lib.socket.msg.data.TopBubbleData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@Nullable String str, @NonNull String str2) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            if (StringUtils.isNull(str) || (split = str.split(":")) == null || split.length != 3) {
                return true;
            }
            long j = JavaTypesHelper.toLong(split[2].trim(), 0L);
            if (j > SharedPrefHelper.getInstance().getLong(SharedPrefHelper.getSharedPrefKeyWithAccount("excellent_msg_" + str2), 0L)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void e(@Nullable String str, @NonNull String str2) {
        String[] split;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) && !StringUtils.isNull(str) && (split = str.split(":")) != null && split.length == 3) {
            SharedPrefHelper.getInstance().putLong(SharedPrefHelper.getSharedPrefKeyWithAccount("excellent_msg_" + str2), JavaTypesHelper.toLong(split[2].trim(), 0L));
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(str), false);
        }
        return invokeL.booleanValue;
    }

    public static boolean c(@NonNull TopBubbleData topBubbleData) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, topBubbleData)) == null) {
            String versionKey = topBubbleData.getVersionKey();
            if (StringUtils.isNull(versionKey) || (split = versionKey.split("_")) == null || split.length != 3) {
                return false;
            }
            long j = JavaTypesHelper.toLong(split[1].trim(), 0L);
            int i = JavaTypesHelper.toInt(split[2].trim(), 0);
            topBubbleData.setActivityID(j);
            topBubbleData.setActivityStatus(i);
            return true;
        }
        return invokeL.booleanValue;
    }

    public static String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String str2 = "?";
            try {
                Uri parse = Uri.parse(str);
                String fragment = parse.getFragment();
                String query = parse.getQuery();
                if (fragment != null) {
                    if (fragment.contains("?")) {
                        str2 = "&";
                    }
                    if (!TextUtils.isEmpty(query)) {
                        return str.substring(0, str.indexOf("#")) + "&time=" + System.currentTimeMillis() + "#" + fragment + str2;
                    }
                    return str.substring(0, str.indexOf("#")) + "?time=" + System.currentTimeMillis() + "#" + fragment + str2;
                }
                return str;
            } catch (Exception e) {
                BdLog.d("parseRouterUrl Exception " + e);
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static void f(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, null, str, z) == null) {
            SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount(str), z);
        }
    }
}
