package com.baidu.tieba;

import android.app.Activity;
import android.os.Build;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes5.dex */
public class ma0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activity)) == null) {
            if (Build.VERSION.SDK_INT < 16) {
                return false;
            }
            return ((ViewGroup) activity.findViewById(16908290)).getChildAt(0).getFitsSystemWindows();
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            if ((activity.getWindow().getAttributes().flags & 1024) != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, activity)) == null) {
            if (Build.VERSION.SDK_INT < 19 || (activity.getWindow().getAttributes().flags & CodedInputStream.DEFAULT_SIZE_LIMIT) == 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
