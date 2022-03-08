package com.baidu.wallet.base.widget.pulltorefresh.ui;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout;
import com.tachikoma.core.component.anim.AnimationProperty;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class RotateLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static final int f49513c = 1200;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public final Animation f49514d;

    /* renamed from: e  reason: collision with root package name */
    public final ObjectAnimator f49515e;

    /* renamed from: f  reason: collision with root package name */
    public final Matrix f49516f;

    /* renamed from: g  reason: collision with root package name */
    public float f49517g;

    /* renamed from: h  reason: collision with root package name */
    public float f49518h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f49519i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RotateLoadingLayout(Context context, LoadingLayout.Mode mode, LoadingLayout.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mode, orientation, typedArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (LoadingLayout.Mode) objArr2[1], (LoadingLayout.Orientation) objArr2[2], (TypedArray) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f49519i = true;
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.f49516f = matrix;
        this.mHeaderImage.setImageMatrix(matrix);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.f49514d = rotateAnimation;
        rotateAnimation.setInterpolator(LoadingLayout.f49494b);
        this.f49514d.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.f49514d.setRepeatCount(-1);
        this.f49514d.setRepeatMode(1);
        this.f49515e = getRotateYAnim(this.mHeaderImage);
    }

    private void a() {
        Matrix matrix;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (matrix = this.f49516f) == null) {
            return;
        }
        matrix.reset();
        this.mHeaderImage.setImageMatrix(this.f49516f);
    }

    public static int getProgress(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65538, null, f2)) == null) {
            if (f2 <= 0.0f) {
                return 0;
            }
            if (f2 >= 1.0f) {
                return 100;
            }
            int max = Math.max(Math.min(10 - ((int) (10.0f * f2)), 10), 1);
            double d2 = f2;
            if (d2 > 0.5d) {
                max = 2;
            }
            return (int) (Math.pow(d2, max) * 100.0d);
        }
        return invokeF.intValue;
    }

    public static ObjectAnimator getRotateYAnim(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(obj, AnimationProperty.ROTATE_Y, 0.0f, 1800.0f).setDuration(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
            duration.setRepeatMode(1);
            duration.setRepeatCount(-1);
            return duration;
        }
        return (ObjectAnimator) invokeL.objValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public int getDefaultDrawableResId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ResUtils.drawable(getContext(), "wallet_finance_refresh_arrow") : invokeV.intValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public int getLoadingLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ResUtils.layout(getContext(), "wallet_finance_tab_home_surprise_refresh_bar") : invokeV.intValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, drawable) == null) || drawable == null) {
            return;
        }
        this.f49517g = Math.round(drawable.getIntrinsicWidth() / 2.0f);
        this.f49518h = Math.round(drawable.getIntrinsicHeight() / 2.0f);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public void onPullImpl(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
            Drawable drawable = this.mHeaderImage.getDrawable();
            if (drawable instanceof RefreshLoadingDrawable) {
                ((RefreshLoadingDrawable) drawable).setProgress(getProgress(f2));
                this.mHeaderImage.invalidate();
                return;
            }
            this.f49516f.setRotate(f2 * 90.0f, this.f49517g, this.f49518h);
            this.mHeaderImage.setImageMatrix(this.f49516f);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public void pullToRefreshImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public void refreshingImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.mHeaderImage.getDrawable() instanceof RefreshLoadingDrawable) {
                this.f49515e.start();
            } else {
                this.mHeaderImage.startAnimation(this.f49514d);
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public void releaseToRefreshImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public void resetImpl() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.mHeaderImage.getDrawable() instanceof RefreshLoadingDrawable) {
                this.f49515e.cancel();
                this.mHeaderImage.setRotationY(0.0f);
            } else {
                this.mHeaderImage.clearAnimation();
            }
            a();
        }
    }
}
