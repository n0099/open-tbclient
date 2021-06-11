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
    public ImageView f23791a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f23792b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23793c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23794d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f23795e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f23796f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f23797g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout.AnimationStyle f23798h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f23799i;

    public HeaderLoadingLayout(Context context) {
        super(context);
        this.f23798h = LoadingLayout.AnimationStyle.FLIP;
        a(context);
    }

    private void a(Context context) {
        setLayerType(1, null);
        this.f23791a = (ImageView) findViewById(ResUtils.id(context, "bd_wallet_tip_img"));
        this.f23793c = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_title"));
        this.f23792b = (ProgressBar) findViewById(ResUtils.id(context, "bd_wallet_progress_bar"));
        this.f23794d = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_time"));
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_up"));
        this.f23795e = loadAnimation;
        loadAnimation.setFillAfter(true);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_down"));
        this.f23796f = loadAnimation2;
        loadAnimation2.setFillAfter(true);
        this.f23799i = RotateLoadingLayout.getRotateYAnim(this.f23791a);
        if (this.f23798h == LoadingLayout.AnimationStyle.ROTATE) {
            this.f23791a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(context));
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
        if (this.f23798h == LoadingLayout.AnimationStyle.ROTATE) {
            Drawable drawable = this.f23791a.getDrawable();
            if (drawable instanceof RefreshLoadingDrawable) {
                ((RefreshLoadingDrawable) drawable).setProgress(RotateLoadingLayout.getProgress(f2));
                this.f23791a.invalidate();
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onPullToRefresh() {
        if (this.f23798h == LoadingLayout.AnimationStyle.FLIP && LoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.f23791a.clearAnimation();
            this.f23791a.startAnimation(this.f23796f);
        }
        this.f23793c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onRefreshing() {
        if (this.f23798h == LoadingLayout.AnimationStyle.FLIP) {
            this.f23791a.clearAnimation();
            this.f23791a.setVisibility(4);
            this.f23792b.setVisibility(0);
        } else {
            this.f23799i.start();
            this.f23791a.setVisibility(0);
            this.f23792b.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.f23797g)) {
            this.f23793c.setText(ResUtils.getString(getContext(), "wallet_refresh_loading"));
        } else {
            this.f23793c.setText(this.f23797g);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReleaseToRefresh() {
        if (this.f23798h == LoadingLayout.AnimationStyle.FLIP) {
            this.f23791a.clearAnimation();
            this.f23791a.startAnimation(this.f23795e);
        }
        this.f23793c.setText(ResUtils.getString(getContext(), "wallet_refresh_release"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReset() {
        if (this.f23798h == LoadingLayout.AnimationStyle.FLIP) {
            this.f23791a.clearAnimation();
        } else {
            this.f23799i.cancel();
            this.f23791a.setRotationY(0.0f);
        }
        this.f23793c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onStateChanged(LoadingLayout.State state, LoadingLayout.State state2) {
        if (this.f23798h == LoadingLayout.AnimationStyle.FLIP) {
            this.f23791a.setVisibility(0);
            this.f23792b.setVisibility(4);
        } else {
            this.f23791a.setVisibility(0);
            this.f23792b.setVisibility(8);
        }
        super.onStateChanged(state, state2);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.f23794d.setText(charSequence);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f23797g = charSequence;
        TextView textView = this.f23793c;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public HeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23798h = LoadingLayout.AnimationStyle.FLIP;
        a(context);
    }

    public void a(LoadingLayout.AnimationStyle animationStyle) {
        this.f23798h = animationStyle;
        if (animationStyle == LoadingLayout.AnimationStyle.ROTATE) {
            this.f23791a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(getContext()));
        } else {
            this.f23791a.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_refresh_arrow"));
        }
    }
}
