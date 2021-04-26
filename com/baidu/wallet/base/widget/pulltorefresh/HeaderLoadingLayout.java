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
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.ui.RefreshLoadingDrawable;
import com.baidu.wallet.base.widget.pulltorefresh.ui.RotateLoadingLayout;
/* loaded from: classes5.dex */
public class HeaderLoadingLayout extends LoadingLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f24514a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f24515b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f24516c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f24517d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f24518e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f24519f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f24520g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout.AnimationStyle f24521h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f24522i;

    public HeaderLoadingLayout(Context context) {
        super(context);
        this.f24521h = LoadingLayout.AnimationStyle.FLIP;
        a(context);
    }

    private void a(Context context) {
        setLayerType(1, null);
        this.f24514a = (ImageView) findViewById(ResUtils.id(context, "bd_wallet_tip_img"));
        this.f24516c = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_title"));
        this.f24515b = (ProgressBar) findViewById(ResUtils.id(context, "bd_wallet_progress_bar"));
        this.f24517d = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_time"));
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_up"));
        this.f24518e = loadAnimation;
        loadAnimation.setFillAfter(true);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_down"));
        this.f24519f = loadAnimation2;
        loadAnimation2.setFillAfter(true);
        this.f24522i = RotateLoadingLayout.getRotateYAnim(this.f24514a);
        if (this.f24521h == LoadingLayout.AnimationStyle.ROTATE) {
            this.f24514a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(context));
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    @SuppressLint({"InflateParams"})
    public View createLoadingView(Context context, AttributeSet attributeSet) {
        return LayoutInflater.from(context).inflate(ResUtils.layout(getContext(), "wallet_ui_refresh_bar"), (ViewGroup) null);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public int getContentSize() {
        return (int) getResources().getDimension(ResUtils.dimen(getContext(), "wallet_header_height"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onPull(float f2) {
        if (this.f24521h == LoadingLayout.AnimationStyle.ROTATE) {
            Drawable drawable = this.f24514a.getDrawable();
            if (drawable instanceof RefreshLoadingDrawable) {
                ((RefreshLoadingDrawable) drawable).setProgress(RotateLoadingLayout.getProgress(f2));
                this.f24514a.invalidate();
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onPullToRefresh() {
        if (this.f24521h == LoadingLayout.AnimationStyle.FLIP && LoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.f24514a.clearAnimation();
            this.f24514a.startAnimation(this.f24519f);
        }
        this.f24516c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onRefreshing() {
        if (this.f24521h == LoadingLayout.AnimationStyle.FLIP) {
            this.f24514a.clearAnimation();
            this.f24514a.setVisibility(4);
            this.f24515b.setVisibility(0);
        } else {
            this.f24522i.start();
            this.f24514a.setVisibility(0);
            this.f24515b.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.f24520g)) {
            this.f24516c.setText(ResUtils.getString(getContext(), "wallet_refresh_loading"));
        } else {
            this.f24516c.setText(this.f24520g);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReleaseToRefresh() {
        if (this.f24521h == LoadingLayout.AnimationStyle.FLIP) {
            this.f24514a.clearAnimation();
            this.f24514a.startAnimation(this.f24518e);
        }
        this.f24516c.setText(ResUtils.getString(getContext(), "wallet_refresh_release"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReset() {
        if (this.f24521h == LoadingLayout.AnimationStyle.FLIP) {
            this.f24514a.clearAnimation();
        } else {
            this.f24522i.cancel();
            this.f24514a.setRotationY(0.0f);
        }
        this.f24516c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onStateChanged(LoadingLayout.State state, LoadingLayout.State state2) {
        if (this.f24521h == LoadingLayout.AnimationStyle.FLIP) {
            this.f24514a.setVisibility(0);
            this.f24515b.setVisibility(4);
        } else {
            this.f24514a.setVisibility(0);
            this.f24515b.setVisibility(8);
        }
        super.onStateChanged(state, state2);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.f24517d.setText(charSequence);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f24520g = charSequence;
        TextView textView = this.f24516c;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public HeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24521h = LoadingLayout.AnimationStyle.FLIP;
        a(context);
    }

    public void a(LoadingLayout.AnimationStyle animationStyle) {
        this.f24521h = animationStyle;
        if (animationStyle == LoadingLayout.AnimationStyle.ROTATE) {
            this.f24514a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(getContext()));
        } else {
            this.f24514a.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_refresh_arrow"));
        }
    }
}
