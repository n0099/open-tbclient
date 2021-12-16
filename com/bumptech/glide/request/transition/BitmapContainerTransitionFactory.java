package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;
/* loaded from: classes2.dex */
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TransitionFactory<Drawable> realFactory;

    /* loaded from: classes2.dex */
    public final class BitmapGlideAnimation implements Transition<R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BitmapContainerTransitionFactory this$0;
        public final Transition<Drawable> transition;

        public BitmapGlideAnimation(BitmapContainerTransitionFactory bitmapContainerTransitionFactory, Transition<Drawable> transition) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bitmapContainerTransitionFactory, transition};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bitmapContainerTransitionFactory;
            this.transition = transition;
        }

        @Override // com.bumptech.glide.request.transition.Transition
        public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, r, viewAdapter)) == null) ? this.transition.transition(new BitmapDrawable(viewAdapter.getView().getResources(), this.this$0.getBitmap(r)), viewAdapter) : invokeLL.booleanValue;
        }
    }

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {transitionFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.realFactory = transitionFactory;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, dataSource, z)) == null) ? new BitmapGlideAnimation(this, this.realFactory.build(dataSource, z)) : (Transition) invokeLZ.objValue;
    }

    public abstract Bitmap getBitmap(R r);
}
