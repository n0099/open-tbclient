package com.baidu.wallet.base.widget.pulltorefresh.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public abstract class LoadingLayout extends FrameLayout implements ILoadingLayout {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23751a = "PullToRefresh-LoadingLayout";

    /* renamed from: b  reason: collision with root package name */
    public static final Interpolator f23752b = new LinearInterpolator();

    /* renamed from: c  reason: collision with root package name */
    public View f23753c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f23754d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23755e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f23756f;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f23757g;

    /* renamed from: h  reason: collision with root package name */
    public CharSequence f23758h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f23759i;
    public float j;
    public final ImageView mHeaderImage;
    public final ProgressBar mHeaderProgress;
    public final Mode mMode;
    public final Orientation mScrollDirection;

    /* renamed from: com.baidu.wallet.base.widget.pulltorefresh.ui.LoadingLayout$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23760a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f23761b;

        static {
            int[] iArr = new int[Orientation.values().length];
            f23761b = iArr;
            try {
                iArr[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23761b[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            f23760a = iArr2;
            try {
                iArr2[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23760a[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum Mode {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);
        
        public static Mode PULL_DOWN_TO_REFRESH;
        public static Mode PULL_UP_TO_REFRESH;
        public int mIntValue;

        static {
            Mode mode = PULL_FROM_START;
            Mode mode2 = PULL_FROM_END;
            PULL_DOWN_TO_REFRESH = mode;
            PULL_UP_TO_REFRESH = mode2;
        }

        Mode(int i2) {
            this.mIntValue = i2;
        }

        public static Mode getDefault() {
            return PULL_FROM_START;
        }

        public static Mode mapIntToValue(int i2) {
            Mode[] values;
            for (Mode mode : values()) {
                if (i2 == mode.getIntValue()) {
                    return mode;
                }
            }
            return getDefault();
        }

        public int getIntValue() {
            return this.mIntValue;
        }

        public boolean permitsPullToRefresh() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
        }

        public boolean showFooterLoadingLayout() {
            return this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY;
        }

        public boolean showHeaderLoadingLayout() {
            return this == PULL_FROM_START || this == BOTH;
        }
    }

    /* loaded from: classes5.dex */
    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    public LoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        super(context);
        this.mMode = mode;
        this.mScrollDirection = orientation;
        int loadingLayout = getLoadingLayout();
        LayoutInflater.from(context).inflate(loadingLayout <= 0 ? ResUtils.layout(getContext(), "wallet_finance_tab_home_surprise_refresh_bar") : loadingLayout, this);
        this.f23753c = findViewById(ResUtils.id(getContext(), "load_layout"));
        this.f23755e = (TextView) findViewById(ResUtils.id(getContext(), "surprise_text"));
        this.f23756f = (TextView) findViewById(ResUtils.id(getContext(), "pull_to_refresh_text"));
        this.mHeaderProgress = (ProgressBar) findViewById(ResUtils.id(getContext(), "pull_to_refresh_progress"));
        this.mHeaderImage = (ImageView) findViewById(ResUtils.id(getContext(), "pull_to_refresh_image"));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f23753c.getLayoutParams();
        if (AnonymousClass1.f23760a[mode.ordinal()] != 1) {
            layoutParams.gravity = orientation == Orientation.VERTICAL ? 80 : 5;
            this.f23757g = context.getString(ResUtils.string(getContext(), "wallet_refresh_pull_down"));
            this.f23758h = context.getString(ResUtils.string(getContext(), "wallet_refresh_loading"));
            this.f23759i = context.getString(ResUtils.string(getContext(), "wallet_refresh_release"));
        } else {
            layoutParams.gravity = orientation == Orientation.VERTICAL ? 48 : 3;
            this.f23757g = context.getString(ResUtils.string(getContext(), "wallet_tab_pull_to_refresh_from_bottom_pull_label"));
            this.f23758h = context.getString(ResUtils.string(getContext(), "wallet_tab_pull_to_refresh_from_bottom_refreshing_label"));
            this.f23759i = context.getString(ResUtils.string(getContext(), "wallet_tab_pull_to_refresh_from_bottom_release_label"));
        }
        if (this.j > 0.0f) {
            this.f23753c.getLayoutParams().height = (int) this.j;
        }
        setLoadingDrawable(context.getResources().getDrawable(getDefaultDrawableResId()));
        reset();
    }

    private void setTextAppearance(int i2) {
        TextView textView = this.f23756f;
        if (textView != null) {
            textView.setTextAppearance(getContext(), i2);
        }
    }

    private void setTextColor(ColorStateList colorStateList) {
        TextView textView = this.f23756f;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public final int getContentSize() {
        float f2 = this.j;
        if (f2 > 0.0f) {
            return (int) f2;
        }
        if (AnonymousClass1.f23761b[this.mScrollDirection.ordinal()] != 1) {
            return this.f23753c.getHeight();
        }
        return this.f23753c.getWidth();
    }

    public abstract int getDefaultDrawableResId();

    public abstract int getLoadingLayout();

    public final void hideAllViews() {
        if (this.f23756f.getVisibility() == 0) {
            this.f23756f.setVisibility(4);
        }
        if (this.mHeaderProgress.getVisibility() == 0) {
            this.mHeaderProgress.setVisibility(4);
        }
        if (this.mHeaderImage.getVisibility() == 0) {
            this.mHeaderImage.setVisibility(4);
        }
    }

    public abstract void onLoadingDrawableSet(Drawable drawable);

    public final void onPull(float f2) {
        if (this.f23754d) {
            return;
        }
        onPullImpl(f2);
    }

    public abstract void onPullImpl(float f2);

    public final void pullToRefresh() {
        TextView textView = this.f23756f;
        if (textView != null) {
            textView.setText(this.f23757g);
        }
        pullToRefreshImpl();
    }

    public abstract void pullToRefreshImpl();

    public final void refreshing() {
        TextView textView = this.f23756f;
        if (textView != null) {
            textView.setText(this.f23758h);
        }
        if (this.f23754d) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).start();
        } else {
            refreshingImpl();
        }
    }

    public abstract void refreshingImpl();

    public final void releaseToRefresh() {
        TextView textView = this.f23756f;
        if (textView != null) {
            textView.setText(this.f23759i);
        }
        releaseToRefreshImpl();
    }

    public abstract void releaseToRefreshImpl();

    public final void reset() {
        TextView textView = this.f23756f;
        if (textView != null) {
            textView.setText(this.f23757g);
        }
        this.mHeaderImage.setVisibility(0);
        if (this.f23754d) {
            ((AnimationDrawable) this.mHeaderImage.getDrawable()).stop();
        } else {
            resetImpl();
        }
    }

    public abstract void resetImpl();

    public final void setHeight(int i2) {
        getLayoutParams().height = i2;
        requestLayout();
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.ILoadingLayout
    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.ILoadingLayout
    public final void setLoadingDrawable(Drawable drawable) {
        this.mHeaderImage.setImageDrawable(drawable);
        this.f23754d = drawable instanceof AnimationDrawable;
        onLoadingDrawableSet(drawable);
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.ILoadingLayout
    public void setPullLabel(CharSequence charSequence) {
        this.f23757g = charSequence;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.ILoadingLayout
    public void setRefreshingLabel(CharSequence charSequence) {
        this.f23758h = charSequence;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.ILoadingLayout
    public void setReleaseLabel(CharSequence charSequence) {
        this.f23759i = charSequence;
    }

    @Override // com.baidu.wallet.base.widget.pulltorefresh.ui.ILoadingLayout
    public void setTextTypeface(Typeface typeface) {
        this.f23756f.setTypeface(typeface);
    }

    public final void setWidth(int i2) {
        getLayoutParams().width = i2;
        requestLayout();
    }

    public final void showInvisibleViews() {
        if (4 == this.f23756f.getVisibility()) {
            this.f23756f.setVisibility(0);
        }
        if (4 == this.mHeaderProgress.getVisibility()) {
            this.mHeaderProgress.setVisibility(0);
        }
        if (4 == this.mHeaderImage.getVisibility()) {
            this.mHeaderImage.setVisibility(0);
        }
    }

    public void showSurprise(CharSequence charSequence, String str, int i2) {
        if (TextUtils.isEmpty(charSequence) && TextUtils.isEmpty(str)) {
            this.f23755e.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f23755e.setText(charSequence);
        }
        TextUtils.isEmpty(str);
        this.f23755e.setVisibility(0);
    }

    public void showSurpriseText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        this.f23755e.setText(charSequence);
        this.f23755e.setVisibility(0);
    }

    public void showSurprise(CharSequence charSequence, int i2) {
        if (TextUtils.isEmpty(charSequence) && i2 <= 0) {
            this.f23755e.setVisibility(8);
            return;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f23755e.setText(charSequence);
        }
        this.f23755e.setVisibility(0);
    }
}
