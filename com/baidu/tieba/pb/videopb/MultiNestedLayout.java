package com.baidu.tieba.pb.videopb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
/* loaded from: classes2.dex */
public class MultiNestedLayout extends RelativeLayout implements NestedScrollingChild, NestedScrollingParent {
    private NestedScrollingChildHelper mNestedScrollingChildHelper;
    private NestedScrollingParentHelper mNestedScrollingParentHelper;
    private final int[] mParentScrollConsumed;
    private int mState;
    private View mTarget;
    private int maI;
    private int maJ;
    private c maK;
    private a maL;
    private b maM;

    /* loaded from: classes2.dex */
    public interface a {
        void dpQ();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void hF(int i);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void onScrollToTop();
    }

    public MultiNestedLayout(Context context) {
        this(context, null);
    }

    public MultiNestedLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiNestedLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maI = Integer.MIN_VALUE;
        this.mParentScrollConsumed = new int[2];
        this.maJ = 0;
        this.mState = 0;
        this.maK = null;
        this.maL = null;
        this.maM = null;
        dry();
    }

    private void dry() {
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        setNestedScrollingEnabled(true);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == null) {
            ensureTarget();
        }
        if (this.mTarget != null) {
            this.mTarget.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mTarget != null) {
            this.maI = this.mTarget.getTop();
        }
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof NestedScrollingChild) {
                    this.mTarget = childAt;
                    this.maI = this.mTarget.getTop();
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (drz()) {
            int[] iArr2 = this.mParentScrollConsumed;
            if (i2 > 0 && dispatchNestedPreScroll(i, i2, iArr2, null)) {
                iArr[0] = iArr[0] + iArr2[0];
                iArr[1] = iArr[1] + iArr2[1];
                int i3 = i - iArr2[0];
                i2 -= iArr2[1];
            }
            if (i2 >= 0) {
                if (this.maI - this.maJ > i2) {
                    iArr[1] = iArr[1] + i2;
                    this.maJ += i2;
                    if (i2 > 0) {
                        this.mState = 2;
                        if (this.maM != null) {
                            this.maM.hF(this.mState);
                        }
                    }
                } else {
                    iArr[1] = iArr[1] + (this.maI - this.maJ);
                    this.maJ = this.maI;
                    this.mState = 1;
                    if (this.maK != null) {
                        this.maK.onScrollToTop();
                    }
                    if (this.maM != null) {
                        this.maM.hF(this.mState);
                    }
                }
            } else if (this.maJ > Math.abs(i2)) {
                iArr[1] = iArr[1] + i2;
                this.maJ += i2;
                this.mState = 2;
                if (this.maM != null) {
                    this.maM.hF(this.mState);
                }
            } else {
                iArr[1] = iArr[1] + (-this.maJ);
                this.maJ = 0;
                this.mState = 0;
                if (this.maL != null) {
                    this.maL.dpQ();
                }
                if (this.maM != null) {
                    this.maM.hF(this.mState);
                }
            }
            setTargetOffsetTopAndBottom(-this.maJ);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        super.onNestedScroll(view, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        super.onStopNestedScroll(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.mNestedScrollingChildHelper.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f, f2);
    }

    private void setTargetOffsetTopAndBottom(int i) {
        scrollTo(0, -i);
    }

    public void setOffset(int i) {
        if (drz()) {
            this.maJ = i;
            setTargetOffsetTopAndBottom(-this.maJ);
            if (this.maJ == this.maI) {
                this.mState = 1;
                if (this.maK != null) {
                    this.maK.onScrollToTop();
                }
            } else if (this.maJ == 0) {
                this.mState = 0;
                if (this.maL != null) {
                    this.maL.dpQ();
                }
            } else {
                this.mState = 2;
            }
            if (this.maM != null) {
                this.maM.hF(this.mState);
            }
        }
    }

    public void setMaxOffset() {
        setOffset(this.maI);
    }

    public void setMinOffset() {
        setOffset(0);
    }

    private boolean drz() {
        return this.mTarget != null && this.maI > -10000;
    }

    public void setScrollToTopListener(c cVar) {
        this.maK = cVar;
    }

    public void setScrollBottomListener(a aVar) {
        this.maL = aVar;
    }

    public void setScrollStateChangeListener(b bVar) {
        this.maM = bVar;
    }
}
