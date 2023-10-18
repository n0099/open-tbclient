package com.baidu.tieba;

import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
@JvmName(name = "CardUtil")
/* loaded from: classes8.dex */
public final class vj6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(wr<?> wrVar, int i, int i2) {
        ys ysVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65536, null, wrVar, i, i2) == null) {
            if (wrVar instanceof ys) {
                ysVar = (ys) wrVar;
            } else {
                ysVar = null;
            }
            if (ysVar != null && (ysVar.f.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ysVar.f.d.getLayoutParams();
                marginLayoutParams.width = i;
                marginLayoutParams.height = i2;
                if (ysVar.f.d.getVisibility() != 8) {
                    ysVar.f.d.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }
}
