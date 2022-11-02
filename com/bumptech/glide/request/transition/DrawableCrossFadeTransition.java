package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.request.transition.Transition;
/* loaded from: classes7.dex */
public class DrawableCrossFadeTransition implements Transition<Drawable> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int duration;
    public final boolean isCrossFadeEnabled;

    public DrawableCrossFadeTransition(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.duration = i;
        this.isCrossFadeEnabled = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(Drawable drawable, Transition.ViewAdapter viewAdapter) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, drawable, viewAdapter)) == null) {
            Drawable currentDrawable = viewAdapter.getCurrentDrawable();
            if (currentDrawable == null) {
                currentDrawable = new ColorDrawable(0);
            }
            TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{currentDrawable, drawable});
            transitionDrawable.setCrossFadeEnabled(this.isCrossFadeEnabled);
            transitionDrawable.startTransition(this.duration);
            viewAdapter.setDrawable(transitionDrawable);
            return true;
        }
        return invokeLL.booleanValue;
    }
}
