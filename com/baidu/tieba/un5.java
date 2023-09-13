package com.baidu.tieba;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class un5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static tn5 a(View view2, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, view2, z)) == null) {
            if (view2 == null) {
                return null;
            }
            if (view2 instanceof LinearLayout) {
                return new vn5();
            }
            if (view2 instanceof RelativeLayout) {
                return new xn5();
            }
            if (!(view2 instanceof FrameLayout)) {
                return null;
            }
            if (z) {
                return new yn5();
            }
            return new rn5();
        }
        return (tn5) invokeLZ.objValue;
    }
}
