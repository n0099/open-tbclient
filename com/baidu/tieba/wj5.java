package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.switchs.ThreadCardImgClickToPBSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, String str, tr4 tr4Var) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, context, str, tr4Var)) == null) {
            if (context == null || tr4Var == null) {
                return false;
            }
            if ("index".equals(str)) {
                i = 2;
            } else if (ImageViewerConfig.FROM_CONCERN.equals(str)) {
                i = 1;
            } else if ("hot_topic".equals(str)) {
                i = 0;
            } else if ("frs".equals(str)) {
                i = 3;
            } else {
                i = -1;
            }
            if (i == -1) {
                return false;
            }
            ThreadCardUtils.jumpToPB(tr4Var.getThreadData().originalThreadData, context, i, (Rect) null, tr4Var.getThreadData().getForum_name());
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(Context context, String str, tr4 tr4Var) {
        InterceptResult invokeLLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, tr4Var)) == null) {
            if (context == null || tr4Var == null) {
                return false;
            }
            if ("index".equals(str)) {
                i = 2;
            } else if (ImageViewerConfig.FROM_CONCERN.equals(str)) {
                i = 1;
            } else if ("hot_topic".equals(str)) {
                i = 0;
            } else if ("frs".equals(str)) {
                i = 3;
            } else {
                i = -1;
            }
            if (i == -1) {
                return false;
            }
            ThreadCardUtils.jumpToPB(tr4Var, context, i, false);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (ThreadCardImgClickToPBSwitch.getIsOn() && UbsABTestHelper.isImgClickToPb()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
