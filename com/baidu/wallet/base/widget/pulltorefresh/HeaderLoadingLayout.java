package com.baidu.wallet.base.widget.pulltorefresh;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.ui.RefreshLoadingDrawable;
import com.baidu.wallet.base.widget.pulltorefresh.ui.RotateLoadingLayout;
/* loaded from: classes13.dex */
public class HeaderLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f50864b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f50865c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f50866d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f50867e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f50868f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f50869g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout.AnimationStyle f50870h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f50871i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderLoadingLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50870h = LoadingLayout.AnimationStyle.FLIP;
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            setLayerType(1, null);
            this.a = (ImageView) findViewById(ResUtils.id(context, "bd_wallet_tip_img"));
            this.f50865c = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_title"));
            this.f50864b = (ProgressBar) findViewById(ResUtils.id(context, "bd_wallet_progress_bar"));
            this.f50866d = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_time"));
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_up"));
            this.f50867e = loadAnimation;
            loadAnimation.setFillAfter(true);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_down"));
            this.f50868f = loadAnimation2;
            loadAnimation2.setFillAfter(true);
            this.f50871i = RotateLoadingLayout.getRotateYAnim(this.a);
            if (this.f50870h == LoadingLayout.AnimationStyle.ROTATE) {
                this.a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(context));
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    @SuppressLint({"InflateParams"})
    public View createLoadingView(Context context, AttributeSet attributeSet) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, attributeSet)) == null) ? LayoutInflater.from(context).inflate(ResUtils.layout(getContext(), "wallet_ui_refresh_bar"), (ViewGroup) null) : (View) invokeLL.objValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public int getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (int) getResources().getDimension(ResUtils.dimen(getContext(), "wallet_header_height")) : invokeV.intValue;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onPull(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048579, this, f2) == null) && this.f50870h == LoadingLayout.AnimationStyle.ROTATE) {
            Drawable drawable = this.a.getDrawable();
            if (drawable instanceof RefreshLoadingDrawable) {
                ((RefreshLoadingDrawable) drawable).setProgress(RotateLoadingLayout.getProgress(f2));
                this.a.invalidate();
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onPullToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f50870h == LoadingLayout.AnimationStyle.FLIP && LoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
                this.a.clearAnimation();
                this.a.startAnimation(this.f50868f);
            }
            this.f50865c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f50870h == LoadingLayout.AnimationStyle.FLIP) {
                this.a.clearAnimation();
                this.a.setVisibility(4);
                this.f50864b.setVisibility(0);
            } else {
                this.f50871i.start();
                this.a.setVisibility(0);
                this.f50864b.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.f50869g)) {
                this.f50865c.setText(ResUtils.getString(getContext(), "wallet_refresh_loading"));
            } else {
                this.f50865c.setText(this.f50869g);
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReleaseToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f50870h == LoadingLayout.AnimationStyle.FLIP) {
                this.a.clearAnimation();
                this.a.startAnimation(this.f50867e);
            }
            this.f50865c.setText(ResUtils.getString(getContext(), "wallet_refresh_release"));
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f50870h == LoadingLayout.AnimationStyle.FLIP) {
                this.a.clearAnimation();
            } else {
                this.f50871i.cancel();
                this.a.setRotationY(0.0f);
            }
            this.f50865c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onStateChanged(LoadingLayout.State state, LoadingLayout.State state2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, state, state2) == null) {
            if (this.f50870h == LoadingLayout.AnimationStyle.FLIP) {
                this.a.setVisibility(0);
                this.f50864b.setVisibility(4);
            } else {
                this.a.setVisibility(0);
                this.f50864b.setVisibility(8);
            }
            super.onStateChanged(state, state2);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, charSequence) == null) {
            this.f50866d.setText(charSequence);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, charSequence) == null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f50869g = charSequence;
        TextView textView = this.f50865c;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f50870h = LoadingLayout.AnimationStyle.FLIP;
        a(context);
    }

    public void a(LoadingLayout.AnimationStyle animationStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animationStyle) == null) {
            this.f50870h = animationStyle;
            if (animationStyle == LoadingLayout.AnimationStyle.ROTATE) {
                this.a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(getContext()));
            } else {
                this.a.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_refresh_arrow"));
            }
        }
    }
}
