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
    public ImageView f23873a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f23874b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23875c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23876d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f23877e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f23878f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f23879g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout.AnimationStyle f23880h;

    /* renamed from: i  reason: collision with root package name */
    public ObjectAnimator f23881i;

    public HeaderLoadingLayout(Context context) {
        super(context);
        this.f23880h = LoadingLayout.AnimationStyle.FLIP;
        a(context);
    }

    private void a(Context context) {
        setLayerType(1, null);
        this.f23873a = (ImageView) findViewById(ResUtils.id(context, "bd_wallet_tip_img"));
        this.f23875c = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_title"));
        this.f23874b = (ProgressBar) findViewById(ResUtils.id(context, "bd_wallet_progress_bar"));
        this.f23876d = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_time"));
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_up"));
        this.f23877e = loadAnimation;
        loadAnimation.setFillAfter(true);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_down"));
        this.f23878f = loadAnimation2;
        loadAnimation2.setFillAfter(true);
        this.f23881i = RotateLoadingLayout.getRotateYAnim(this.f23873a);
        if (this.f23880h == LoadingLayout.AnimationStyle.ROTATE) {
            this.f23873a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(context));
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
        if (this.f23880h == LoadingLayout.AnimationStyle.ROTATE) {
            Drawable drawable = this.f23873a.getDrawable();
            if (drawable instanceof RefreshLoadingDrawable) {
                ((RefreshLoadingDrawable) drawable).setProgress(RotateLoadingLayout.getProgress(f2));
                this.f23873a.invalidate();
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onPullToRefresh() {
        if (this.f23880h == LoadingLayout.AnimationStyle.FLIP && LoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.f23873a.clearAnimation();
            this.f23873a.startAnimation(this.f23878f);
        }
        this.f23875c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onRefreshing() {
        if (this.f23880h == LoadingLayout.AnimationStyle.FLIP) {
            this.f23873a.clearAnimation();
            this.f23873a.setVisibility(4);
            this.f23874b.setVisibility(0);
        } else {
            this.f23881i.start();
            this.f23873a.setVisibility(0);
            this.f23874b.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.f23879g)) {
            this.f23875c.setText(ResUtils.getString(getContext(), "wallet_refresh_loading"));
        } else {
            this.f23875c.setText(this.f23879g);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReleaseToRefresh() {
        if (this.f23880h == LoadingLayout.AnimationStyle.FLIP) {
            this.f23873a.clearAnimation();
            this.f23873a.startAnimation(this.f23877e);
        }
        this.f23875c.setText(ResUtils.getString(getContext(), "wallet_refresh_release"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReset() {
        if (this.f23880h == LoadingLayout.AnimationStyle.FLIP) {
            this.f23873a.clearAnimation();
        } else {
            this.f23881i.cancel();
            this.f23873a.setRotationY(0.0f);
        }
        this.f23875c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onStateChanged(LoadingLayout.State state, LoadingLayout.State state2) {
        if (this.f23880h == LoadingLayout.AnimationStyle.FLIP) {
            this.f23873a.setVisibility(0);
            this.f23874b.setVisibility(4);
        } else {
            this.f23873a.setVisibility(0);
            this.f23874b.setVisibility(8);
        }
        super.onStateChanged(state, state2);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.f23876d.setText(charSequence);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f23879g = charSequence;
        TextView textView = this.f23875c;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public HeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23880h = LoadingLayout.AnimationStyle.FLIP;
        a(context);
    }

    public void a(LoadingLayout.AnimationStyle animationStyle) {
        this.f23880h = animationStyle;
        if (animationStyle == LoadingLayout.AnimationStyle.ROTATE) {
            this.f23873a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(getContext()));
        } else {
            this.f23873a.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_refresh_arrow"));
        }
    }
}
