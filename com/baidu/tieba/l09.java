package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.videoplay.verticalviewpager.fragment.VideoLoadingFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes4.dex */
public final /* synthetic */ class l09 implements View.OnLongClickListener {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ l09 a = new l09();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ l09() {
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) ? VideoLoadingFragment.v1(view2) : invokeL.booleanValue;
    }
}
