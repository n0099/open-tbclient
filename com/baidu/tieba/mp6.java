package com.baidu.tieba;

import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
@JvmName(name = "CardUtil")
/* loaded from: classes7.dex */
public final class mp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(zw<?> zwVar, int i, int i2) {
        by byVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65536, null, zwVar, i, i2) == null) {
            if (zwVar instanceof by) {
                byVar = (by) zwVar;
            } else {
                byVar = null;
            }
            if (byVar != null && (byVar.f.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) byVar.f.d.getLayoutParams();
                marginLayoutParams.width = i;
                marginLayoutParams.height = i2;
                if (byVar.f.d.getVisibility() != 8) {
                    byVar.f.d.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }
}
