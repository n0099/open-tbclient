package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Scroller;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, c, d {
    private BaseAdapter dpl;
    private final float gxW;
    private View gxX;
    private int gxY;
    private com.baidu.tieba.tbadkCore.imgView.a gxZ;
    private int gya;
    private Scroller gyb;
    private Rect gyc;
    private boolean gyd;
    private boolean gye;
    private a gyf;
    private int gyg;
    private int gyh;
    private boolean gyi;
    private View gyj;
    private final int gyk;
    private final int gyl;
    private boolean gym;
    private ArrayList<View> gyn;
    private boolean gyo;
    private boolean gyp;
    private boolean gyq;
    private boolean gyr;
    private boolean gys;
    private Runnable gyt;
    private int mContentWidth;
    private int mHeightMeasureSpec;
    private int mItemCount;
    private int mLastFlingX;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void E(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.gxW = 2.0f;
        this.gyc = new Rect();
        this.gyh = 10;
        this.gyk = 300;
        this.gyl = 500;
        this.gyn = new ArrayList<>();
        this.gyr = false;
        this.gys = true;
        this.gyt = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gyb.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gyb;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.tr(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gyb.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gxW = 2.0f;
        this.gyc = new Rect();
        this.gyh = 10;
        this.gyk = 300;
        this.gyl = 500;
        this.gyn = new ArrayList<>();
        this.gyr = false;
        this.gys = true;
        this.gyt = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gyb.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gyb;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tr(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gyb.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gxW = 2.0f;
        this.gyc = new Rect();
        this.gyh = 10;
        this.gyk = 300;
        this.gyl = 500;
        this.gyn = new ArrayList<>();
        this.gyr = false;
        this.gys = true;
        this.gyt = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gyb.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gyb;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tr(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gyb.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gxX = null;
        this.gxY = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.gyb = new Scroller(context);
        this.gyg = getResources().getDimensionPixelSize(d.e.ds66);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds32);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        this.mItemCount = this.dpl == null ? 0 : this.dpl.getCount();
        this.mItemCount = Math.min(this.gyh, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View tq = tq(0);
            measureScrapChild(tq, i, i2);
            i4 = tq.getMeasuredWidth();
            i3 = tq.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] z = z(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(z[0], i);
                this.gyp = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(z[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.gya = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.gyj) {
                this.gyn.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.gyg;
        if (this.gyr) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds32);
            if (this.mItemCount > 0) {
                View tq = tq(0);
                measureScrapChild(tq, this.gya, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - tq.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.gyj != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.gyg * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.gyj.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.gyj.setLayoutParams(layoutParams);
                measureScrapChild(this.gyj, this.gya, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.gyj.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View tq2 = tq(i7);
            if (tq2 != null && tq2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = tq2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    tq2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(tq2, -1, layoutParams2, true);
                measureScrapChild(tq2, this.gya, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = tq2.getMeasuredWidth() + i6;
                tq2.layout(i6, paddingTop, measuredWidth2, tq2.getMeasuredHeight() + paddingTop);
                tq2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.gyj != null) {
            if (this.gys) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.gyg * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.gyj.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.gyj.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.gyj, this.gya, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.gyj.getMeasuredWidth() + i6;
            this.gyj.layout(i6, paddingTop2, measuredWidth4, this.gyj.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.gyh) {
                i6 = measuredWidth4 - this.gyj.getMeasuredWidth();
                this.gym = false;
            } else {
                addViewInLayout(this.gyj, -1, this.gyj.getLayoutParams(), true);
                this.gym = true;
                i6 = measuredWidth4;
            }
        }
        this.mContentWidth = (this.gyg + i6) - this.mPadding;
        if (this.gyi || z) {
            scrollTo(0, 0);
            scrollBy(bss(), 0);
            this.gyi = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.mContentWidth > getMeasuredWidth();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2) {
        }
        if (canScroll()) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            float x = motionEvent.getX();
            switch (action) {
                case 0:
                    this.mLastMotionX = x;
                    if (!this.gyb.isFinished()) {
                        removeCallbacks(this.gyt);
                        this.gyb.forceFinished(true);
                        z = false;
                        break;
                    }
                    z = false;
                    break;
                case 1:
                case 3:
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                    z = false;
                    break;
                case 2:
                    int abs = (int) Math.abs(x - this.mLastMotionX);
                    this.mLastMotionX = x;
                    if (abs > this.mTouchSlop) {
                        if (getParent() != null) {
                            getParent().requestDisallowInterceptTouchEvent(true);
                            break;
                        }
                    }
                    z = false;
                    break;
                default:
                    z = false;
                    break;
            }
            return z;
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) && canScroll()) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int action = motionEvent.getAction();
            float x = motionEvent.getX();
            switch (action) {
                case 0:
                    if (!this.gyb.isFinished()) {
                        removeCallbacks(this.gyt);
                        this.gyb.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.gyt);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.mLastFlingX = i2;
                        this.gyb.fling(i2, 0, i, 0, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                        post(this.gyt);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    tr((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void setAdapter(BaseAdapter baseAdapter, boolean z) {
        this.dpl = baseAdapter;
        this.mScroller.forceFinished(true);
        this.gyb.forceFinished(true);
        if (!this.gyi && z) {
            this.gyi = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.dpl;
    }

    private View tq(int i) {
        View view2 = null;
        if (this.gyn.size() > 0) {
            view2 = this.gyn.remove(0);
        }
        View view3 = this.dpl.getView(i, view2, this);
        if (view3 != view2) {
            this.gyn.add(view2);
        }
        if (view3 != null) {
            view3.setOnLongClickListener(this);
        }
        return view3;
    }

    private void measureScrapChild(View view2, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view2.setLayoutParams(layoutParams);
        }
        view2.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    private int[] z(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.dpl == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.mItemCount - 1;
        }
        while (i <= i2) {
            View tq = tq(i);
            if (tq.getVisibility() != 8) {
                measureScrapChild(tq, i3, i4);
                paddingRight += tq.getMeasuredWidth();
                paddingTop = Math.max(tq.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bss() {
        if (canScroll()) {
            return this.mContentWidth - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tr(int i) {
        scrollBy(ts(i), 0);
        invalidate();
    }

    private int ts(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bss()) {
                i = bss() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view2) {
        if (!this.gyq) {
            this.gyq = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.gxZ.b(view2, null);
            this.gxX = view2;
            this.gxY = indexOfChild(view2);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.gyd || this.gye) && this.gxZ != null) {
                this.gxZ.swap();
                return;
            }
            return;
        }
        this.gyd = false;
        this.gye = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.c
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.gxZ = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void k(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.gxY && (childAt = getChildAt(i)) != this.gyj) {
                childAt.getHitRect(this.gyc);
                if (this.gyc.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.gxY;
                    bL(i2, i);
                    bK(i2, i);
                    this.gxY = i;
                    return;
                }
            }
        }
    }

    private void bK(int i, int i2) {
        if (this.gyf != null) {
            this.gyf.E(i, i2);
        }
    }

    private void bL(int i, int i2) {
        if (i != i2) {
            View childAt = getChildAt(i);
            View childAt2 = getChildAt(i2);
            if (childAt != null && childAt2 != null) {
                if (i < i2) {
                    detachViewFromParent(i);
                    int i3 = -childAt.getMeasuredWidth();
                    int left = childAt2.getLeft() - childAt.getLeft();
                    while (i < i2) {
                        View childAt3 = getChildAt(i);
                        if (childAt3 != null) {
                            childAt3.offsetLeftAndRight(i3);
                            TranslateAnimation translateAnimation = new TranslateAnimation(-i3, 0.0f, 0.0f, 0.0f);
                            translateAnimation.setDuration(300L);
                            translateAnimation.setFillAfter(true);
                            childAt3.startAnimation(translateAnimation);
                        }
                        i++;
                    }
                    attachViewToParent(childAt, i2, childAt.getLayoutParams());
                    childAt.offsetLeftAndRight(left);
                    return;
                }
                detachViewFromParent(i);
                int measuredWidth = childAt.getMeasuredWidth();
                int left2 = childAt2.getLeft() - childAt.getLeft();
                for (int i4 = i2; i4 < i; i4++) {
                    View childAt4 = getChildAt(i4);
                    if (childAt4 != null) {
                        childAt4.offsetLeftAndRight(measuredWidth);
                        TranslateAnimation translateAnimation2 = new TranslateAnimation(-measuredWidth, 0.0f, 0.0f, 0.0f);
                        translateAnimation2.setDuration(300L);
                        translateAnimation2.setFillAfter(true);
                        childAt4.startAnimation(translateAnimation2);
                    }
                }
                attachViewToParent(childAt, i2, childAt.getLayoutParams());
                childAt.offsetLeftAndRight(left2);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void bst() {
        if (!this.gyd) {
            this.gyd = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void bsu() {
        if (!this.gye) {
            this.gye = true;
            int bss = bss();
            int scrollX = getScrollX();
            int scrollX2 = bss - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void bsv() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.gyd = false;
        this.gye = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void bsw() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.gyf = aVar;
    }

    public void setMaxItemNum(int i) {
        this.gyh = i;
    }

    public int getMaxItemNum() {
        return this.gyh;
    }

    public void setAddView(View view2) {
        this.gyj = view2;
    }

    public int bw(View view2) {
        this.gyo = true;
        view2.clearAnimation();
        int indexOfChild = indexOfChild(view2);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view2.getMeasuredWidth();
        if (this.gym) {
            this.mContentWidth -= measuredWidth;
        } else {
            if (this.gyj != null) {
                addViewInLayout(this.gyj, -1, this.gyj.getLayoutParams(), true);
                this.mContentWidth += this.gyj.getMeasuredWidth();
            }
            this.mContentWidth -= measuredWidth;
            this.gym = true;
        }
        this.mItemCount--;
        removeViewInLayout(view2);
        this.gyn.add(view2);
        int childCount = getChildCount();
        if (childCount > 1) {
            for (int i = indexOfChild; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != null) {
                    childAt.offsetLeftAndRight(-measuredWidth);
                    TranslateAnimation translateAnimation = new TranslateAnimation(measuredWidth, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(500L);
                    translateAnimation.setFillAfter(true);
                    childAt.startAnimation(translateAnimation);
                }
            }
        }
        int scrollX = getScrollX();
        if (!canScroll()) {
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, 500);
            postInvalidate();
        } else if (scrollX > bss()) {
            this.mScroller.startScroll(scrollX, 0, bss() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.gyo = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bss()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bss(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.gyp) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bsx() {
        return this.gyo;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.gyt);
        this.mScroller.forceFinished(true);
        this.gyb.forceFinished(true);
        if (this.gxX != null) {
            this.gxX.setVisibility(0);
            this.gxX = null;
        }
        this.gxY = -1;
        this.gyd = false;
        this.gye = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.gyq = false;
    }

    public void setCenterStart(boolean z) {
        this.gyr = z;
    }

    public void setStartEndSpace(int i) {
        this.gyg = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.gys = z;
    }
}
