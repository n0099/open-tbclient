package com.baidu.tieba;

import android.view.View;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class v28 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ v28 a = new v28();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ v28() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            w28.c(view2);
        }
    }
}
