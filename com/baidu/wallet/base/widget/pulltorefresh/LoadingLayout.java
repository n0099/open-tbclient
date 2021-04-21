package com.baidu.wallet.base.widget.pulltorefresh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
/* loaded from: classes5.dex */
public abstract class LoadingLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f23784a;

    /* renamed from: b  reason: collision with root package name */
    public State f23785b;

    /* renamed from: c  reason: collision with root package name */
    public State f23786c;

    /* renamed from: com.baidu.wallet.base.widget.pulltorefresh.LoadingLayout$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f23787a;

        static {
            int[] iArr = new int[State.values().length];
            f23787a = iArr;
            try {
                iArr[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23787a[State.RELEASE_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23787a[State.PULL_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23787a[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23787a[State.NO_MORE_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum AnimationStyle {
        ROTATE,
        FLIP
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

    public abstract int getContentSize();

    public State getPreState() {
        return this.f23786c;
    }

    public State getState() {
        return this.f23785b;
    }

    public void init(Context context, AttributeSet attributeSet) {
        View createLoadingView = createLoadingView(context, attributeSet);
        this.f23784a = createLoadingView;
        if (createLoadingView != null) {
            addView(this.f23784a, new FrameLayout.LayoutParams(-1, -2));
            return;
        }
        throw new NullPointerException("Loading view can not be null.");
    }

    public void onNoMoreData() {
    }

    public void onPull(float f2) {
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
        int i = AnonymousClass1.f23787a[state.ordinal()];
        if (i == 1) {
            onReset();
        } else if (i == 2) {
            onReleaseToRefresh();
        } else if (i == 3) {
            onPullToRefresh();
        } else if (i == 4) {
            onRefreshing();
        } else if (i != 5) {
        } else {
            onNoMoreData();
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    public void setLoadingDrawable(Drawable drawable) {
    }

    public void setNoMoreDataLabel(CharSequence charSequence) {
    }

    public void setPullLabel(CharSequence charSequence) {
    }

    public void setRefreshingLabel(CharSequence charSequence) {
    }

    public void setReleaseLabel(CharSequence charSequence) {
    }

    public void setState(State state) {
        State state2 = this.f23785b;
        if (state2 != state) {
            this.f23786c = state2;
            this.f23785b = state;
            onStateChanged(state, state2);
        }
    }

    public void show(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        if (z == (getVisibility() == 0) || (layoutParams = this.f23784a.getLayoutParams()) == null) {
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

    public LoadingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        State state = State.NONE;
        this.f23785b = state;
        this.f23786c = state;
        init(context, attributeSet);
    }
}
