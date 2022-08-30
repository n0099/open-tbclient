package com.baidu.tieba;

import android.app.Activity;
import android.os.Build;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes4.dex */
public class l90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activity)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return ((ViewGroup) activity.findViewById(16908290)).getChildAt(0).getFitsSystemWindows();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) ? (activity.getWindow().getAttributes().flags & 1024) != 0 : invokeL.booleanValue;
    }

    public static boolean c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) ? Build.VERSION.SDK_INT >= 19 && (activity.getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) != 0 : invokeL.booleanValue;
    }
}
