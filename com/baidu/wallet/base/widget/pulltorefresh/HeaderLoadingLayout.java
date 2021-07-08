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
/* loaded from: classes5.dex */
public class HeaderLoadingLayout extends LoadingLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageView f24526a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f24527b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24528c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24529d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f24530e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f24531f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f24532g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout.AnimationStyle f24533h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f24534i;

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
        this.f24533h = LoadingLayout.AnimationStyle.FLIP;
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            setLayerType(1, null);
            this.f24526a = (ImageView) findViewById(ResUtils.id(context, "bd_wallet_tip_img"));
            this.f24528c = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_title"));
            this.f24527b = (ProgressBar) findViewById(ResUtils.id(context, "bd_wallet_progress_bar"));
            this.f24529d = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_time"));
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_up"));
            this.f24530e = loadAnimation;
            loadAnimation.setFillAfter(true);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_down"));
            this.f24531f = loadAnimation2;
            loadAnimation2.setFillAfter(true);
            this.f24534i = RotateLoadingLayout.getRotateYAnim(this.f24526a);
            if (this.f24533h == LoadingLayout.AnimationStyle.ROTATE) {
                this.f24526a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(context));
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
        if ((interceptable == null || interceptable.invokeF(1048579, this, f2) == null) && this.f24533h == LoadingLayout.AnimationStyle.ROTATE) {
            Drawable drawable = this.f24526a.getDrawable();
            if (drawable instanceof RefreshLoadingDrawable) {
                ((RefreshLoadingDrawable) drawable).setProgress(RotateLoadingLayout.getProgress(f2));
                this.f24526a.invalidate();
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onPullToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f24533h == LoadingLayout.AnimationStyle.FLIP && LoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
                this.f24526a.clearAnimation();
                this.f24526a.startAnimation(this.f24531f);
            }
            this.f24528c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.f24533h == LoadingLayout.AnimationStyle.FLIP) {
                this.f24526a.clearAnimation();
                this.f24526a.setVisibility(4);
                this.f24527b.setVisibility(0);
            } else {
                this.f24534i.start();
                this.f24526a.setVisibility(0);
                this.f24527b.setVisibility(8);
            }
            if (TextUtils.isEmpty(this.f24532g)) {
                this.f24528c.setText(ResUtils.getString(getContext(), "wallet_refresh_loading"));
            } else {
                this.f24528c.setText(this.f24532g);
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReleaseToRefresh() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f24533h == LoadingLayout.AnimationStyle.FLIP) {
                this.f24526a.clearAnimation();
                this.f24526a.startAnimation(this.f24530e);
            }
            this.f24528c.setText(ResUtils.getString(getContext(), "wallet_refresh_release"));
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.f24533h == LoadingLayout.AnimationStyle.FLIP) {
                this.f24526a.clearAnimation();
            } else {
                this.f24534i.cancel();
                this.f24526a.setRotationY(0.0f);
            }
            this.f24528c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onStateChanged(LoadingLayout.State state, LoadingLayout.State state2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, state, state2) == null) {
            if (this.f24533h == LoadingLayout.AnimationStyle.FLIP) {
                this.f24526a.setVisibility(0);
                this.f24527b.setVisibility(4);
            } else {
                this.f24526a.setVisibility(0);
                this.f24527b.setVisibility(8);
            }
            super.onStateChanged(state, state2);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, charSequence) == null) {
            this.f24529d.setText(charSequence);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, charSequence) == null) || TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f24532g = charSequence;
        TextView textView = this.f24528c;
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
        this.f24533h = LoadingLayout.AnimationStyle.FLIP;
        a(context);
    }

    public void a(LoadingLayout.AnimationStyle animationStyle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, animationStyle) == null) {
            this.f24533h = animationStyle;
            if (animationStyle == LoadingLayout.AnimationStyle.ROTATE) {
                this.f24526a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(getContext()));
            } else {
                this.f24526a.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_refresh_arrow"));
            }
        }
    }
}
