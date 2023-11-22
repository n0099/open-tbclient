package com.baidu.tieba;

import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class qg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(OvalActionButton ovalActionButton, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(65536, null, ovalActionButton, f) == null) {
            Intrinsics.checkNotNullParameter(ovalActionButton, "<this>");
            ovalActionButton.setAlpha(f);
        }
    }
}
