package com.baidu.tieba;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class p08 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ p08 a = new p08();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ p08() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            q08.c(view2);
        }
    }
}
