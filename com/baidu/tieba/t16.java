package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class t16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Drawable a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            if (i != 0) {
                return SkinManager.getDrawable(R.drawable.icon_xiangqing_n);
            }
            return SkinManager.getDrawable(R.drawable.icon_xiangqing_n);
        }
        return (Drawable) invokeI.objValue;
    }
}
