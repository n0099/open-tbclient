package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public abstract class LoadingLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f24277a;

    /* renamed from: b  reason: collision with root package name */
    public State f24278b;

    /* renamed from: c  reason: collision with root package name */
    public State f24279c;

    /* renamed from: com.baidu.wallet.base.widget.LoadingLayout$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24280a;

        static {
            int[] iArr = new int[State.values().length];
            f24280a = iArr;
            try {
                iArr[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24280a[State.RELEASE_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24280a[State.PULL_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24280a[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f24280a[State.NO_MORE_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum State {
        NONE,
        RESET,
        PULL_TO_REFRESH,
        RELEASE_TO_REFRESH,
        REFRESHING,
        NO_MORE_DATA
    }

    public LoadingLayout(Context context) {
        this(context, null);
    }

    public abstract View createLoadingView(Context context, AttributeSet attributeSet);

    public State getPreState() {
        return this.f24279c;
    }

    public State getState() {
        return this.f24278b;
    }

    public void init(Context context, AttributeSet attributeSet) {
        View createLoadingView = createLoadingView(context, attributeSet);
        this.f24277a = createLoadingView;
        if (createLoadingView != null) {
            addView(this.f24277a, new FrameLayout.LayoutParams(-1, -2));
            return;
        }
        throw new NullPointerException("Loading view can not be null.");
    }

    public void onNoMoreData() {
    }

    public void onPullToRefresh() {
    }

    public void onRefreshing() {
    }

    public void onReleaseToRefresh() {
    }

    public void onReset() {
    }

    public void onStateChanged(State state, State state2) {
        int i2 = AnonymousClass1.f24280a[state.ordinal()];
        if (i2 == 1) {
            onReset();
        } else if (i2 == 2) {
            onReleaseToRefresh();
        } else if (i2 == 3) {
            onPullToRefresh();
        } else if (i2 == 4) {
            onRefreshing();
        } else if (i2 != 5) {
        } else {
            onNoMoreData();
        }
    }

    public void setLoadingDrawable(Drawable drawable) {
    }

    public void setPullLabel(CharSequence charSequence) {
    }

    public void setRefreshingLabel(CharSequence charSequence) {
    }

    public void setReleaseLabel(CharSequence charSequence) {
    }

    public void setState(State state) {
        State state2 = this.f24278b;
        if (state2 != state) {
            this.f24279c = state2;
            this.f24278b = state;
            onStateChanged(state, state2);
        }
    }

    public void show(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        if (z == (getVisibility() == 0) || (layoutParams = this.f24277a.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            layoutParams.height = -2;
        } else {
            layoutParams.height = 0;
        }
        requestLayout();
        setVisibility(z ? 0 : 4);
    }

    public LoadingLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        State state = State.NONE;
        this.f24278b = state;
        this.f24279c = state;
        init(context, attributeSet);
    }
}
