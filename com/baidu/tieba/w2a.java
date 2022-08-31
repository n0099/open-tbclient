package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, View view2, GridView gridView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65536, null, i, view2, gridView) == null) || i == 0 || gridView == null || view2 == null) {
            return;
        }
        int i2 = i >= 3 ? 82 : 110;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (i == 1) {
            gridView.setNumColumns(1);
            layoutParams.width = o2a.a(i2);
        } else if (i == 2) {
            gridView.setNumColumns(2);
            layoutParams.width = o2a.a((i2 * 2) + 7);
        } else if (i == 3) {
            gridView.setNumColumns(3);
            layoutParams.width = o2a.a((i2 * 3) + 14);
        } else if (i != 4) {
            gridView.setNumColumns(3);
            layoutParams.width = o2a.a((i2 * 3) + 14);
        } else {
            gridView.setNumColumns(2);
            layoutParams.width = o2a.a((i2 * 2) + 7);
        }
        view2.setLayoutParams(layoutParams);
    }
}
