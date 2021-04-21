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
    public ImageView f23776a;

    /* renamed from: b  reason: collision with root package name */
    public ProgressBar f23777b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23778c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f23779d;

    /* renamed from: e  reason: collision with root package name */
    public Animation f23780e;

    /* renamed from: f  reason: collision with root package name */
    public Animation f23781f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f23782g;

    /* renamed from: h  reason: collision with root package name */
    public LoadingLayout.AnimationStyle f23783h;
    public ObjectAnimator i;

    public HeaderLoadingLayout(Context context) {
        super(context);
        this.f23783h = LoadingLayout.AnimationStyle.FLIP;
        a(context);
    }

    private void a(Context context) {
        setLayerType(1, null);
        this.f23776a = (ImageView) findViewById(ResUtils.id(context, "bd_wallet_tip_img"));
        this.f23778c = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_title"));
        this.f23777b = (ProgressBar) findViewById(ResUtils.id(context, "bd_wallet_progress_bar"));
        this.f23779d = (TextView) findViewById(ResUtils.id(context, "bd_wallet_tip_time"));
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_up"));
        this.f23780e = loadAnimation;
        loadAnimation.setFillAfter(true);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), ResUtils.anim(context, "wallet_base_rotate_down"));
        this.f23781f = loadAnimation2;
        loadAnimation2.setFillAfter(true);
        this.i = RotateLoadingLayout.getRotateYAnim(this.f23776a);
        if (this.f23783h == LoadingLayout.AnimationStyle.ROTATE) {
            this.f23776a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(context));
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
        if (this.f23783h == LoadingLayout.AnimationStyle.ROTATE) {
            Drawable drawable = this.f23776a.getDrawable();
            if (drawable instanceof RefreshLoadingDrawable) {
                ((RefreshLoadingDrawable) drawable).setProgress(RotateLoadingLayout.getProgress(f2));
                this.f23776a.invalidate();
            }
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onPullToRefresh() {
        if (this.f23783h == LoadingLayout.AnimationStyle.FLIP && LoadingLayout.State.RELEASE_TO_REFRESH == getPreState()) {
            this.f23776a.clearAnimation();
            this.f23776a.startAnimation(this.f23781f);
        }
        this.f23778c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onRefreshing() {
        if (this.f23783h == LoadingLayout.AnimationStyle.FLIP) {
            this.f23776a.clearAnimation();
            this.f23776a.setVisibility(4);
            this.f23777b.setVisibility(0);
        } else {
            this.i.start();
            this.f23776a.setVisibility(0);
            this.f23777b.setVisibility(8);
        }
        if (TextUtils.isEmpty(this.f23782g)) {
            this.f23778c.setText(ResUtils.getString(getContext(), "wallet_refresh_loading"));
        } else {
            this.f23778c.setText(this.f23782g);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReleaseToRefresh() {
        if (this.f23783h == LoadingLayout.AnimationStyle.FLIP) {
            this.f23776a.clearAnimation();
            this.f23776a.startAnimation(this.f23780e);
        }
        this.f23778c.setText(ResUtils.getString(getContext(), "wallet_refresh_release"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onReset() {
        if (this.f23783h == LoadingLayout.AnimationStyle.FLIP) {
            this.f23776a.clearAnimation();
        } else {
            this.i.cancel();
            this.f23776a.setRotationY(0.0f);
        }
        this.f23778c.setText(ResUtils.getString(getContext(), "wallet_refresh_pull_down"));
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void onStateChanged(LoadingLayout.State state, LoadingLayout.State state2) {
        if (this.f23783h == LoadingLayout.AnimationStyle.FLIP) {
            this.f23776a.setVisibility(0);
            this.f23777b.setVisibility(4);
        } else {
            this.f23776a.setVisibility(0);
            this.f23777b.setVisibility(8);
        }
        super.onStateChanged(state, state2);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
        this.f23779d.setText(charSequence);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f23782g = charSequence;
        TextView textView = this.f23778c;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public HeaderLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23783h = LoadingLayout.AnimationStyle.FLIP;
        a(context);
    }

    public void a(LoadingLayout.AnimationStyle animationStyle) {
        this.f23783h = animationStyle;
        if (animationStyle == LoadingLayout.AnimationStyle.ROTATE) {
            this.f23776a.setImageDrawable(RefreshLoadingDrawable.newInstanceRed(getContext()));
        } else {
            this.f23776a.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_base_refresh_arrow"));
        }
    }
}
