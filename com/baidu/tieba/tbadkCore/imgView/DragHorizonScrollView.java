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
    private BaseAdapter dCP;
    private final float gOA;
    private View gOB;
    private int gOC;
    private com.baidu.tieba.tbadkCore.imgView.a gOD;
    private int gOE;
    private Scroller gOF;
    private Rect gOG;
    private boolean gOH;
    private boolean gOI;
    private a gOJ;
    private int gOK;
    private int gOL;
    private boolean gOM;
    private View gON;
    private final int gOO;
    private final int gOP;
    private boolean gOQ;
    private ArrayList<View> gOR;
    private boolean gOS;
    private boolean gOT;
    private boolean gOU;
    private boolean gOV;
    private boolean gOW;
    private Runnable gOX;
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
        void F(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.gOA = 2.0f;
        this.gOG = new Rect();
        this.gOL = 10;
        this.gOO = 300;
        this.gOP = 500;
        this.gOR = new ArrayList<>();
        this.gOV = false;
        this.gOW = true;
        this.gOX = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gOF.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gOF;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.tO(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gOF.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gOA = 2.0f;
        this.gOG = new Rect();
        this.gOL = 10;
        this.gOO = 300;
        this.gOP = 500;
        this.gOR = new ArrayList<>();
        this.gOV = false;
        this.gOW = true;
        this.gOX = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gOF.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gOF;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tO(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gOF.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gOA = 2.0f;
        this.gOG = new Rect();
        this.gOL = 10;
        this.gOO = 300;
        this.gOP = 500;
        this.gOR = new ArrayList<>();
        this.gOV = false;
        this.gOW = true;
        this.gOX = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gOF.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gOF;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tO(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gOF.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gOB = null;
        this.gOC = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.gOF = new Scroller(context);
        this.gOK = getResources().getDimensionPixelSize(d.e.ds66);
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
        this.mItemCount = this.dCP == null ? 0 : this.dCP.getCount();
        this.mItemCount = Math.min(this.gOL, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View tN = tN(0);
            measureScrapChild(tN, i, i2);
            i4 = tN.getMeasuredWidth();
            i3 = tN.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] z = z(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(z[0], i);
                this.gOT = true;
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
        this.gOE = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.gON) {
                this.gOR.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.gOK;
        if (this.gOV) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds32);
            if (this.mItemCount > 0) {
                View tN = tN(0);
                measureScrapChild(tN, this.gOE, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - tN.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.gON != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.gOK * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.gON.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.gON.setLayoutParams(layoutParams);
                measureScrapChild(this.gON, this.gOE, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.gON.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View tN2 = tN(i7);
            if (tN2 != null && tN2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = tN2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    tN2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(tN2, -1, layoutParams2, true);
                measureScrapChild(tN2, this.gOE, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = tN2.getMeasuredWidth() + i6;
                tN2.layout(i6, paddingTop, measuredWidth2, tN2.getMeasuredHeight() + paddingTop);
                tN2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.gON != null) {
            if (this.gOW) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.gOK * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.gON.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.gON.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.gON, this.gOE, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.gON.getMeasuredWidth() + i6;
            this.gON.layout(i6, paddingTop2, measuredWidth4, this.gON.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.gOL) {
                i6 = measuredWidth4 - this.gON.getMeasuredWidth();
                this.gOQ = false;
            } else {
                addViewInLayout(this.gON, -1, this.gON.getLayoutParams(), true);
                this.gOQ = true;
                i6 = measuredWidth4;
            }
        }
        this.mContentWidth = (this.gOK + i6) - this.mPadding;
        if (this.gOM || z) {
            scrollTo(0, 0);
            scrollBy(bxY(), 0);
            this.gOM = false;
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
                    if (!this.gOF.isFinished()) {
                        removeCallbacks(this.gOX);
                        this.gOF.forceFinished(true);
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
                    if (!this.gOF.isFinished()) {
                        removeCallbacks(this.gOX);
                        this.gOF.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.gOX);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.mLastFlingX = i2;
                        this.gOF.fling(i2, 0, i, 0, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                        post(this.gOX);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    tO((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void setAdapter(BaseAdapter baseAdapter, boolean z) {
        this.dCP = baseAdapter;
        this.mScroller.forceFinished(true);
        this.gOF.forceFinished(true);
        if (!this.gOM && z) {
            this.gOM = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.dCP;
    }

    private View tN(int i) {
        View view = null;
        if (this.gOR.size() > 0) {
            view = this.gOR.remove(0);
        }
        View view2 = this.dCP.getView(i, view, this);
        if (view2 != view) {
            this.gOR.add(view);
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

    private int[] z(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.dCP == null) {
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
            View tN = tN(i);
            if (tN.getVisibility() != 8) {
                measureScrapChild(tN, i3, i4);
                paddingRight += tN.getMeasuredWidth();
                paddingTop = Math.max(tN.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bxY() {
        if (canScroll()) {
            return this.mContentWidth - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tO(int i) {
        scrollBy(tP(i), 0);
        invalidate();
    }

    private int tP(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bxY()) {
                i = bxY() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.gOU) {
            this.gOU = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.gOD.b(view, null);
            this.gOB = view;
            this.gOC = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.gOH || this.gOI) && this.gOD != null) {
                this.gOD.swap();
                return;
            }
            return;
        }
        this.gOH = false;
        this.gOI = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.c
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.gOD = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void k(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.gOC && (childAt = getChildAt(i)) != this.gON) {
                childAt.getHitRect(this.gOG);
                if (this.gOG.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.gOC;
                    bL(i2, i);
                    bK(i2, i);
                    this.gOC = i;
                    return;
                }
            }
        }
    }

    private void bK(int i, int i2) {
        if (this.gOJ != null) {
            this.gOJ.F(i, i2);
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
    public void bxZ() {
        if (!this.gOH) {
            this.gOH = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void bya() {
        if (!this.gOI) {
            this.gOI = true;
            int bxY = bxY();
            int scrollX = getScrollX();
            int scrollX2 = bxY - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void byb() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.gOH = false;
        this.gOI = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void byc() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.gOJ = aVar;
    }

    public void setMaxItemNum(int i) {
        this.gOL = i;
    }

    public int getMaxItemNum() {
        return this.gOL;
    }

    public void setAddView(View view) {
        this.gON = view;
    }

    public int bA(View view) {
        this.gOS = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.gOQ) {
            this.mContentWidth -= measuredWidth;
        } else {
            if (this.gON != null) {
                addViewInLayout(this.gON, -1, this.gON.getLayoutParams(), true);
                this.mContentWidth += this.gON.getMeasuredWidth();
            }
            this.mContentWidth -= measuredWidth;
            this.gOQ = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.gOR.add(view);
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
        } else if (scrollX > bxY()) {
            this.mScroller.startScroll(scrollX, 0, bxY() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.gOS = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bxY()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bxY(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.gOT) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean byd() {
        return this.gOS;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.gOX);
        this.mScroller.forceFinished(true);
        this.gOF.forceFinished(true);
        if (this.gOB != null) {
            this.gOB.setVisibility(0);
            this.gOB = null;
        }
        this.gOC = -1;
        this.gOH = false;
        this.gOI = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.gOU = false;
    }

    public void setCenterStart(boolean z) {
        this.gOV = z;
    }

    public void setStartEndSpace(int i) {
        this.gOK = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.gOW = z;
    }
}
