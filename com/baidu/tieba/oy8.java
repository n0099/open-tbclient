package com.baidu.tieba;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class oy8 implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ oy8 a = new oy8();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ oy8() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) ? VideoVerticalPageFragment.k2(view2, motionEvent) : invokeLL.booleanValue;
    }
}
