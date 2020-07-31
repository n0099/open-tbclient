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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, c, d {
    private final float lOS;
    private View lOT;
    private int lOU;
    private com.baidu.tieba.tbadkCore.imgView.a lOV;
    private int lOW;
    private Scroller lOX;
    private Rect lOY;
    private boolean lOZ;
    private boolean lPa;
    private a lPb;
    private int lPc;
    private int lPd;
    private boolean lPe;
    private View lPf;
    private final int lPg;
    private final int lPh;
    private boolean lPi;
    private ArrayList<View> lPj;
    private boolean lPk;
    private boolean lPl;
    private boolean lPm;
    private boolean lPn;
    private boolean lPo;
    private Runnable lPp;
    private BaseAdapter mAdapter;
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
        void aW(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.lOS = 2.0f;
        this.lOY = new Rect();
        this.lPd = 10;
        this.lPg = 300;
        this.lPh = 500;
        this.lPj = new ArrayList<>();
        this.lPn = false;
        this.lPo = true;
        this.lPp = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.lOX.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.lOX;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.Fy(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.lOX.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lOS = 2.0f;
        this.lOY = new Rect();
        this.lPd = 10;
        this.lPg = 300;
        this.lPh = 500;
        this.lPj = new ArrayList<>();
        this.lPn = false;
        this.lPo = true;
        this.lPp = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.lOX.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.lOX;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.Fy(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.lOX.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lOS = 2.0f;
        this.lOY = new Rect();
        this.lPd = 10;
        this.lPg = 300;
        this.lPh = 500;
        this.lPj = new ArrayList<>();
        this.lPn = false;
        this.lPo = true;
        this.lPp = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.lOX.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.lOX;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.Fy(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.lOX.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.lOT = null;
        this.lOU = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.lOX = new Scroller(context);
        this.lPc = getResources().getDimensionPixelSize(R.dimen.ds66);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds32);
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
        this.mItemCount = this.mAdapter == null ? 0 : this.mAdapter.getCount();
        this.mItemCount = Math.min(this.lPd, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View Fx = Fx(0);
            measureScrapChild(Fx, i, i2);
            i4 = Fx.getMeasuredWidth();
            i3 = Fx.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] G = G(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(G[0], i);
                this.lPl = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(G[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.lOW = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.lPf) {
                this.lPj.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.lPc;
        if (this.lPn) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds32);
            if (this.mItemCount > 0) {
                View Fx = Fx(0);
                measureScrapChild(Fx, this.lOW, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - Fx.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.lPf != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.lPc * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.lPf.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.lPf.setLayoutParams(layoutParams);
                measureScrapChild(this.lPf, this.lOW, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.lPf.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View Fx2 = Fx(i7);
            if (Fx2 != null && Fx2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = Fx2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    Fx2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(Fx2, -1, layoutParams2, true);
                measureScrapChild(Fx2, this.lOW, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = Fx2.getMeasuredWidth() + i6;
                Fx2.layout(i6, paddingTop, measuredWidth2, Fx2.getMeasuredHeight() + paddingTop);
                Fx2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.lPf != null) {
            if (this.lPo) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.lPc * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.lPf.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.lPf.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.lPf, this.lOW, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.lPf.getMeasuredWidth() + i6;
            this.lPf.layout(i6, paddingTop2, measuredWidth4, this.lPf.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.lPd) {
                i6 = measuredWidth4 - this.lPf.getMeasuredWidth();
                this.lPi = false;
            } else {
                addViewInLayout(this.lPf, -1, this.lPf.getLayoutParams(), true);
                this.lPi = true;
                i6 = measuredWidth4;
            }
        }
        this.mContentWidth = (this.lPc + i6) - this.mPadding;
        if (this.lPe || z) {
            scrollTo(0, 0);
            scrollBy(dlC(), 0);
            this.lPe = false;
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
                    if (!this.lOX.isFinished()) {
                        removeCallbacks(this.lPp);
                        this.lOX.forceFinished(true);
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
                    if (!this.lOX.isFinished()) {
                        removeCallbacks(this.lPp);
                        this.lOX.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.lPp);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.mLastFlingX = i2;
                        this.lOX.fling(i2, 0, i, 0, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                        post(this.lPp);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    Fy((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void setAdapter(BaseAdapter baseAdapter, boolean z) {
        this.mAdapter = baseAdapter;
        this.mScroller.forceFinished(true);
        this.lOX.forceFinished(true);
        if (!this.lPe && z) {
            this.lPe = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.mAdapter;
    }

    private View Fx(int i) {
        View view = null;
        if (this.lPj.size() > 0) {
            view = this.lPj.remove(0);
        }
        View view2 = this.mAdapter.getView(i, view, this);
        if (view2 != view) {
            this.lPj.add(view);
        }
        if (view2 != null) {
            view2.setOnLongClickListener(this);
        }
        return view2;
    }

    private void measureScrapChild(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view.setLayoutParams(layoutParams);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    private int[] G(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.mAdapter == null) {
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
            View Fx = Fx(i);
            if (Fx.getVisibility() != 8) {
                measureScrapChild(Fx, i3, i4);
                paddingRight += Fx.getMeasuredWidth();
                paddingTop = Math.max(Fx.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dlC() {
        if (canScroll()) {
            return this.mContentWidth - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fy(int i) {
        scrollBy(Fz(i), 0);
        invalidate();
    }

    private int Fz(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > dlC()) {
                i = dlC() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.lPm) {
            this.lPm = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.lOV.b(view, null);
            this.lOT = view;
            this.lOU = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.lOZ || this.lPa) && this.lOV != null) {
                this.lOV.dlB();
                return;
            }
            return;
        }
        this.lOZ = false;
        this.lPa = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.c
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.lOV = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void j(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.lOU && (childAt = getChildAt(i)) != this.lPf) {
                childAt.getHitRect(this.lOY);
                if (this.lOY.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.lOU;
                    df(i2, i);
                    de(i2, i);
                    this.lOU = i;
                    return;
                }
            }
        }
    }

    private void de(int i, int i2) {
        if (this.lPb != null) {
            this.lPb.aW(i, i2);
        }
    }

    private void df(int i, int i2) {
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
    public void dlD() {
        if (!this.lOZ) {
            this.lOZ = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void dlE() {
        if (!this.lPa) {
            this.lPa = true;
            int dlC = dlC();
            int scrollX = getScrollX();
            int scrollX2 = dlC - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void dlF() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.lOZ = false;
        this.lPa = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void dlG() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.lPb = aVar;
    }

    public void setMaxItemNum(int i) {
        this.lPd = i;
    }

    public int getMaxItemNum() {
        return this.lPd;
    }

    public void setAddView(View view) {
        this.lPf = view;
    }

    public int dj(View view) {
        this.lPk = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.lPi) {
            this.mContentWidth -= measuredWidth;
        } else {
            if (this.lPf != null) {
                addViewInLayout(this.lPf, -1, this.lPf.getLayoutParams(), true);
                this.mContentWidth += this.lPf.getMeasuredWidth();
            }
            this.mContentWidth -= measuredWidth;
            this.lPi = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.lPj.add(view);
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
        } else if (scrollX > dlC()) {
            this.mScroller.startScroll(scrollX, 0, dlC() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.lPk = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.dlC()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.dlC(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.lPl) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean dlH() {
        return this.lPk;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.lPp);
        this.mScroller.forceFinished(true);
        this.lOX.forceFinished(true);
        if (this.lOT != null) {
            this.lOT.setVisibility(0);
            this.lOT = null;
        }
        this.lOU = -1;
        this.lOZ = false;
        this.lPa = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.lPm = false;
    }

    public void setCenterStart(boolean z) {
        this.lPn = z;
    }

    public void setStartEndSpace(int i) {
        this.lPc = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.lPo = z;
    }
}
