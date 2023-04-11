package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y61 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, PopupWindow popupWindow) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, context, popupWindow) != null) || !(context instanceof Activity)) {
            return;
        }
        popupWindow.getContentView().setSystemUiVisibility(((Activity) context).getWindow().getDecorView().getSystemUiVisibility() | 512 | 2);
    }

    public static ViewGroup b(Context context, ViewGroup viewGroup, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, context, viewGroup, z)) == null) {
            if (!(context instanceof Activity)) {
                return null;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
                viewGroup.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                ColorDrawable colorDrawable = new ColorDrawable(-16777216);
                colorDrawable.setAlpha(86);
                viewGroup.setBackground(colorDrawable);
            }
            ViewGroup viewGroup2 = (ViewGroup) ((Activity) context).getWindow().getDecorView();
            if (viewGroup.getParent() != null) {
                viewGroup2.removeView(viewGroup);
            }
            if (z) {
                viewGroup2.addView(viewGroup);
            }
            return viewGroup;
        }
        return (ViewGroup) invokeLLZ.objValue;
    }
}
