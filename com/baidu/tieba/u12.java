package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.Animatable;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
/* loaded from: classes8.dex */
public final class u12 extends y02<SimpleDraweeView, v12> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t12 i;
    public SwanAppComponentContainerView j;
    public SimpleDraweeView k;

    /* loaded from: classes8.dex */
    public class a extends BaseControllerListener<ImageInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ SimpleDraweeView b;
        public final /* synthetic */ u12 c;

        public a(u12 u12Var, boolean z, SimpleDraweeView simpleDraweeView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u12Var, Boolean.valueOf(z), simpleDraweeView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = u12Var;
            this.a = z;
            this.b = simpleDraweeView;
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFailure(String str, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, th) == null) {
                super.onFailure(str, th);
                if (this.a && this.c.i != null) {
                    this.c.i.a(0, this.b, null);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, imageInfo, animatable) == null) {
                super.onFinalImageSet(str, (String) imageInfo, animatable);
                if (this.a && this.c.i != null) {
                    this.c.i.a(1, this.b, null);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u12(@NonNull Context context, @NonNull v12 v12Var) {
        super(context, v12Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, v12Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (z02) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g(4);
        this.j = new SwanAppComponentContainerView(context);
        this.k = new SimpleDraweeView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f12
    @NonNull
    /* renamed from: c0 */
    public SimpleDraweeView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            return this.k;
        }
        return (SimpleDraweeView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f12
    /* renamed from: d0 */
    public void B(@NonNull SimpleDraweeView simpleDraweeView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, simpleDraweeView) == null) {
            super.B(simpleDraweeView);
            simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        }
    }

    public void g0(t12 t12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t12Var) == null) {
            this.i = t12Var;
        }
    }

    @Override // com.baidu.tieba.f12
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            return this.j;
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d12
    /* renamed from: e0 */
    public void Q(@NonNull SimpleDraweeView simpleDraweeView, @NonNull v12 v12Var, @NonNull h22 h22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, simpleDraweeView, v12Var, h22Var) == null) {
            super.V(simpleDraweeView, v12Var, h22Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.d12, com.baidu.tieba.f12
    @NonNull
    /* renamed from: a0 */
    public h22 k(@NonNull v12 v12Var, @NonNull v12 v12Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, v12Var, v12Var2)) == null) {
            h22 U = super.U(v12Var, v12Var2);
            if (v12Var.u != v12Var2.u) {
                U.b(9);
            }
            return U;
        }
        return (h22) invokeLL.objValue;
    }

    public final BaseControllerListener<ImageInfo> b0(@NonNull SimpleDraweeView simpleDraweeView, @NonNull v12 v12Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, simpleDraweeView, v12Var)) == null) {
            return new a(this, v12Var.u, simpleDraweeView);
        }
        return (BaseControllerListener) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y02
    /* renamed from: f0 */
    public void W(@NonNull SimpleDraweeView simpleDraweeView, @NonNull v12 v12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, simpleDraweeView, v12Var) == null) {
            super.X(simpleDraweeView, v12Var, b0(simpleDraweeView, v12Var));
        }
    }
}
