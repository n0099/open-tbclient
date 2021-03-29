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
/* loaded from: classes5.dex */
public class MultiNestedLayout extends RelativeLayout implements NestedScrollingParent, NestedScrollingChild {

    /* renamed from: e  reason: collision with root package name */
    public View f19959e;

    /* renamed from: f  reason: collision with root package name */
    public NestedScrollingParentHelper f19960f;

    /* renamed from: g  reason: collision with root package name */
    public NestedScrollingChildHelper f19961g;

    /* renamed from: h  reason: collision with root package name */
    public int f19962h;
    public final int[] i;
    public int j;
    public int k;
    public c l;
    public a m;
    public b n;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onScrollToTop();
    }

    public MultiNestedLayout(Context context) {
        this(context, null);
    }

    private void setTargetOffsetTopAndBottom(int i) {
        scrollTo(0, -i);
    }

    public final void a() {
        if (this.f19959e == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof NestedScrollingChild) {
                    this.f19959e = childAt;
                    this.f19962h = childAt.getTop();
                    return;
                }
            }
        }
    }

    public final void b() {
        this.f19961g = new NestedScrollingChildHelper(this);
        this.f19960f = new NestedScrollingParentHelper(this);
        setNestedScrollingEnabled(true);
    }

    public final boolean c() {
        return this.f19959e != null && this.f19962h > -10000;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f19961g.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f19961g.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f19961g.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f19961g.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.f19961g.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f19961g.isNestedScrollingEnabled();
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f19959e;
        if (view != null) {
            this.f19962h = view.getTop();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f19959e == null) {
            a();
        }
        View view = this.f19959e;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (c()) {
            int[] iArr2 = this.i;
            if (i2 > 0 && dispatchNestedPreScroll(i, i2, iArr2, null)) {
                iArr[0] = iArr[0] + iArr2[0];
                iArr[1] = iArr[1] + iArr2[1];
                int i3 = iArr2[0];
                i2 -= iArr2[1];
            }
            if (i2 >= 0) {
                int i4 = this.f19962h;
                int i5 = this.j;
                if (i4 - i5 > i2) {
                    iArr[1] = iArr[1] + i2;
                    this.j = i5 + i2;
                    if (i2 > 0) {
                        this.k = 2;
                        b bVar = this.n;
                        if (bVar != null) {
                            bVar.a(2);
                        }
                    }
                } else {
                    iArr[1] = iArr[1] + (i4 - i5);
                    this.j = i4;
                    this.k = 1;
                    c cVar = this.l;
                    if (cVar != null) {
                        cVar.onScrollToTop();
                    }
                    b bVar2 = this.n;
                    if (bVar2 != null) {
                        bVar2.a(this.k);
                    }
                }
            } else if (this.j > Math.abs(i2)) {
                iArr[1] = iArr[1] + i2;
                this.j += i2;
                this.k = 2;
                b bVar3 = this.n;
                if (bVar3 != null) {
                    bVar3.a(2);
                }
            } else {
                iArr[1] = iArr[1] + (-this.j);
                this.j = 0;
                this.k = 0;
                a aVar = this.m;
                if (aVar != null) {
                    aVar.a();
                }
                b bVar4 = this.n;
                if (bVar4 != null) {
                    bVar4.a(this.k);
                }
            }
            setTargetOffsetTopAndBottom(-this.j);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        super.onNestedScroll(view, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f19960f.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        super.onStopNestedScroll(view);
    }

    public void setMaxOffset() {
        setOffset(this.f19962h);
    }

    public void setMinOffset() {
        setOffset(0);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.f19961g.setNestedScrollingEnabled(z);
    }

    public void setOffset(int i) {
        if (c()) {
            this.j = i;
            setTargetOffsetTopAndBottom(-i);
            int i2 = this.j;
            if (i2 == this.f19962h) {
                this.k = 1;
                c cVar = this.l;
                if (cVar != null) {
                    cVar.onScrollToTop();
                }
            } else if (i2 == 0) {
                this.k = 0;
                a aVar = this.m;
                if (aVar != null) {
                    aVar.a();
                }
            } else {
                this.k = 2;
            }
            b bVar = this.n;
            if (bVar != null) {
                bVar.a(this.k);
            }
        }
    }

    public void setScrollBottomListener(a aVar) {
        this.m = aVar;
    }

    public void setScrollStateChangeListener(b bVar) {
        this.n = bVar;
    }

    public void setScrollToTopListener(c cVar) {
        this.l = cVar;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.f19961g.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f19961g.stopNestedScroll();
    }

    public MultiNestedLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiNestedLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19962h = Integer.MIN_VALUE;
        this.i = new int[2];
        this.j = 0;
        this.k = 0;
        this.l = null;
        this.m = null;
        this.n = null;
        b();
    }
}
