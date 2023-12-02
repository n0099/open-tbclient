package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.forum.widget.TbNestedScrollView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class mp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(TbNestedScrollView tbNestedScrollView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbNestedScrollView)) == null) {
            Intrinsics.checkNotNullParameter(tbNestedScrollView, "<this>");
            View nestedScrollChild = tbNestedScrollView.getNestedScrollChild();
            if (nestedScrollChild == null) {
                return true;
            }
            int nestedScrollAxes = tbNestedScrollView.getNestedScrollAxes();
            if (nestedScrollAxes != 1) {
                if (nestedScrollAxes != 2) {
                    return true;
                }
                if (nestedScrollChild.getY() - tbNestedScrollView.getScrollY() >= 0.0f && (nestedScrollChild.getY() + nestedScrollChild.getHeight()) - tbNestedScrollView.getScrollY() <= tbNestedScrollView.getHeight()) {
                    return true;
                }
            } else if (nestedScrollChild.getX() - tbNestedScrollView.getScrollX() >= 0.0f && (nestedScrollChild.getX() + nestedScrollChild.getWidth()) - tbNestedScrollView.getScrollX() <= tbNestedScrollView.getWidth()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
