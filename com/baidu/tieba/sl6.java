package com.baidu.tieba;

import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmName;
@JvmName(name = "CardUtil")
/* loaded from: classes8.dex */
public final class sl6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(ns<?> nsVar, int i, int i2) {
        pt ptVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65536, null, nsVar, i, i2) == null) {
            if (nsVar instanceof pt) {
                ptVar = (pt) nsVar;
            } else {
                ptVar = null;
            }
            if (ptVar != null && (ptVar.f.d.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ptVar.f.d.getLayoutParams();
                marginLayoutParams.width = i;
                marginLayoutParams.height = i2;
                if (ptVar.f.d.getVisibility() != 8) {
                    ptVar.f.d.setLayoutParams(marginLayoutParams);
                }
            }
        }
    }
}
