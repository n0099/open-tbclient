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
import com.baidu.apollon.utils.ResUtils;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public class RotateLoadingLayout extends LoadingLayout {

    /* renamed from: c  reason: collision with root package name */
    public static final int f23771c = 1200;

    /* renamed from: d  reason: collision with root package name */
    public final Animation f23772d;

    /* renamed from: e  reason: collision with root package name */
    public final ObjectAnimator f23773e;

    /* renamed from: f  reason: collision with root package name */
    public final Matrix f23774f;

    /* renamed from: g  reason: collision with root package name */
    public float f23775g;

    /* renamed from: h  reason: collision with root package name */
    public float f23776h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f23777i;

    public RotateLoadingLayout(Context context, LoadingLayout.Mode mode, LoadingLayout.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.f23777i = true;
        this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.f23774f = matrix;
        this.mHeaderImage.setImageMatrix(matrix);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
        this.f23772d = rotateAnimation;
        rotateAnimation.setInterpolator(LoadingLayout.f23752b);
        this.f23772d.setDuration(IMLikeRequest.TIME_INTERVAL);
        this.f23772d.setRepeatCount(-1);
        this.f23772d.setRepeatMode(1);
        this.f23773e = getRotateYAnim(this.mHeaderImage);
    }

    private void a() {
        Matrix matrix = this.f23774f;
        if (matrix != null) {
            matrix.reset();
            this.mHeaderImage.setImageMatrix(this.f23774f);
        }
    }

    public static int getProgress(float f2) {
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

    public static ObjectAnimator getRotateYAnim(Object obj) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(obj, "rotationY", 0.0f, 1800.0f).setDuration(TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
        duration.setRepeatMode(1);
        duration.setRepeatCount(-1);
        return duration;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public int getDefaultDrawableResId() {
        return ResUtils.drawable(getContext(), "wallet_finance_refresh_arrow");
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public int getLoadingLayout() {
        return ResUtils.layout(getContext(), "wallet_finance_tab_home_surprise_refresh_bar");
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public void onLoadingDrawableSet(Drawable drawable) {
        if (drawable != null) {
            this.f23775g = Math.round(drawable.getIntrinsicWidth() / 2.0f);
            this.f23776h = Math.round(drawable.getIntrinsicHeight() / 2.0f);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public void onPullImpl(float f2) {
        Drawable drawable = this.mHeaderImage.getDrawable();
        if (drawable instanceof RefreshLoadingDrawable) {
            ((RefreshLoadingDrawable) drawable).setProgress(getProgress(f2));
            this.mHeaderImage.invalidate();
            return;
        }
        this.f23774f.setRotate(f2 * 90.0f, this.f23775g, this.f23776h);
        this.mHeaderImage.setImageMatrix(this.f23774f);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public void pullToRefreshImpl() {
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public void refreshingImpl() {
        if (this.mHeaderImage.getDrawable() instanceof RefreshLoadingDrawable) {
            this.f23773e.start();
        } else {
            this.mHeaderImage.startAnimation(this.f23772d);
        }
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public void releaseToRefreshImpl() {
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout
    public void resetImpl() {
        if (this.mHeaderImage.getDrawable() instanceof RefreshLoadingDrawable) {
            this.f23773e.cancel();
            this.mHeaderImage.setRotationY(0.0f);
        } else {
            this.mHeaderImage.clearAnimation();
        }
        a();
    }
}
