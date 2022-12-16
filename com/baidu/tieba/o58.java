package com.baidu.tieba;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class o58 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ o58 a = new o58();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ o58() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            p58.c(view2);
        }
    }
}
