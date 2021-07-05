package com.bumptech.glide.request.transition;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
/* loaded from: classes6.dex */
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ViewPropertyTransition<R> animation;
    public final ViewPropertyTransition.Animator animator;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator animator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {animator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.animator = animator;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, dataSource, z)) == null) {
            if (dataSource != DataSource.MEMORY_CACHE && z) {
                if (this.animation == null) {
                    this.animation = new ViewPropertyTransition<>(this.animator);
                }
                return this.animation;
            }
            return NoTransition.get();
        }
        return (Transition) invokeLZ.objValue;
    }
}
