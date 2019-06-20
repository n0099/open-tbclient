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
    private View daY;
    private com.baidu.tieba.tbadkCore.imgView.a jaA;
    private int jaB;
    private Scroller jaC;
    private Rect jaD;
    private boolean jaE;
    private boolean jaF;
    private a jaG;
    private int jaH;
    private int jaI;
    private boolean jaJ;
    private final int jaK;
    private final int jaL;
    private boolean jaM;
    private ArrayList<View> jaN;
    private boolean jaO;
    private boolean jaP;
    private boolean jaQ;
    private boolean jaR;
    private boolean jaS;
    private Runnable jaT;
    private final float jax;
    private View jay;
    private int jaz;
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
        void ag(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.jax = 2.0f;
        this.jaD = new Rect();
        this.jaI = 10;
        this.jaK = 300;
        this.jaL = 500;
        this.jaN = new ArrayList<>();
        this.jaR = false;
        this.jaS = true;
        this.jaT = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.jaC.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.jaC;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.AB(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.jaC.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jax = 2.0f;
        this.jaD = new Rect();
        this.jaI = 10;
        this.jaK = 300;
        this.jaL = 500;
        this.jaN = new ArrayList<>();
        this.jaR = false;
        this.jaS = true;
        this.jaT = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.jaC.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.jaC;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.AB(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.jaC.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jax = 2.0f;
        this.jaD = new Rect();
        this.jaI = 10;
        this.jaK = 300;
        this.jaL = 500;
        this.jaN = new ArrayList<>();
        this.jaR = false;
        this.jaS = true;
        this.jaT = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.jaC.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.jaC;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.AB(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.jaC.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.jay = null;
        this.jaz = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.jaC = new Scroller(context);
        this.jaH = getResources().getDimensionPixelSize(R.dimen.ds66);
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
        this.mItemCount = Math.min(this.jaI, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View AA = AA(0);
            measureScrapChild(AA, i, i2);
            i4 = AA.getMeasuredWidth();
            i3 = AA.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] B = B(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(B[0], i);
                this.jaP = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(B[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.jaB = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.daY) {
                this.jaN.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.jaH;
        if (this.jaR) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds32);
            if (this.mItemCount > 0) {
                View AA = AA(0);
                measureScrapChild(AA, this.jaB, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - AA.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.daY != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.jaH * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.daY.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.daY.setLayoutParams(layoutParams);
                measureScrapChild(this.daY, this.jaB, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.daY.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View AA2 = AA(i7);
            if (AA2 != null && AA2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = AA2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    AA2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(AA2, -1, layoutParams2, true);
                measureScrapChild(AA2, this.jaB, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = AA2.getMeasuredWidth() + i6;
                AA2.layout(i6, paddingTop, measuredWidth2, AA2.getMeasuredHeight() + paddingTop);
                AA2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.daY != null) {
            if (this.jaS) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.jaH * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.daY.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.daY.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.daY, this.jaB, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.daY.getMeasuredWidth() + i6;
            this.daY.layout(i6, paddingTop2, measuredWidth4, this.daY.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.jaI) {
                i6 = measuredWidth4 - this.daY.getMeasuredWidth();
                this.jaM = false;
            } else {
                addViewInLayout(this.daY, -1, this.daY.getLayoutParams(), true);
                this.jaM = true;
                i6 = measuredWidth4;
            }
        }
        this.mContentWidth = (this.jaH + i6) - this.mPadding;
        if (this.jaJ || z) {
            scrollTo(0, 0);
            scrollBy(cmS(), 0);
            this.jaJ = false;
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
                    if (!this.jaC.isFinished()) {
                        removeCallbacks(this.jaT);
                        this.jaC.forceFinished(true);
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
                    if (!this.jaC.isFinished()) {
                        removeCallbacks(this.jaT);
                        this.jaC.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.jaT);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.mLastFlingX = i2;
                        this.jaC.fling(i2, 0, i, 0, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                        post(this.jaT);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    AB((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void setAdapter(BaseAdapter baseAdapter, boolean z) {
        this.mAdapter = baseAdapter;
        this.mScroller.forceFinished(true);
        this.jaC.forceFinished(true);
        if (!this.jaJ && z) {
            this.jaJ = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.mAdapter;
    }

    private View AA(int i) {
        View view = null;
        if (this.jaN.size() > 0) {
            view = this.jaN.remove(0);
        }
        View view2 = this.mAdapter.getView(i, view, this);
        if (view2 != view) {
            this.jaN.add(view);
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

    private int[] B(int i, int i2, int i3, int i4) {
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
            View AA = AA(i);
            if (AA.getVisibility() != 8) {
                measureScrapChild(AA, i3, i4);
                paddingRight += AA.getMeasuredWidth();
                paddingTop = Math.max(AA.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cmS() {
        if (canScroll()) {
            return this.mContentWidth - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AB(int i) {
        scrollBy(AC(i), 0);
        invalidate();
    }

    private int AC(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > cmS()) {
                i = cmS() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.jaQ) {
            this.jaQ = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.jaA.b(view, null);
            this.jay = view;
            this.jaz = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.jaE || this.jaF) && this.jaA != null) {
                this.jaA.swap();
                return;
            }
            return;
        }
        this.jaE = false;
        this.jaF = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.c
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.jaA = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void o(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.jaz && (childAt = getChildAt(i)) != this.daY) {
                childAt.getHitRect(this.jaD);
                if (this.jaD.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.jaz;
                    cx(i2, i);
                    cw(i2, i);
                    this.jaz = i;
                    return;
                }
            }
        }
    }

    private void cw(int i, int i2) {
        if (this.jaG != null) {
            this.jaG.ag(i, i2);
        }
    }

    private void cx(int i, int i2) {
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
    public void cmT() {
        if (!this.jaE) {
            this.jaE = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void cmU() {
        if (!this.jaF) {
            this.jaF = true;
            int cmS = cmS();
            int scrollX = getScrollX();
            int scrollX2 = cmS - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void cmV() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.jaE = false;
        this.jaF = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void cmW() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.jaG = aVar;
    }

    public void setMaxItemNum(int i) {
        this.jaI = i;
    }

    public int getMaxItemNum() {
        return this.jaI;
    }

    public void setAddView(View view) {
        this.daY = view;
    }

    public int cP(View view) {
        this.jaO = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.jaM) {
            this.mContentWidth -= measuredWidth;
        } else {
            if (this.daY != null) {
                addViewInLayout(this.daY, -1, this.daY.getLayoutParams(), true);
                this.mContentWidth += this.daY.getMeasuredWidth();
            }
            this.mContentWidth -= measuredWidth;
            this.jaM = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.jaN.add(view);
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
        } else if (scrollX > cmS()) {
            this.mScroller.startScroll(scrollX, 0, cmS() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.jaO = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.cmS()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.cmS(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.jaP) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean cmX() {
        return this.jaO;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.jaT);
        this.mScroller.forceFinished(true);
        this.jaC.forceFinished(true);
        if (this.jay != null) {
            this.jay.setVisibility(0);
            this.jay = null;
        }
        this.jaz = -1;
        this.jaE = false;
        this.jaF = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.jaQ = false;
    }

    public void setCenterStart(boolean z) {
        this.jaR = z;
    }

    public void setStartEndSpace(int i) {
        this.jaH = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.jaS = z;
    }
}
