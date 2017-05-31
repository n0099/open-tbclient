package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Rect;
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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, f, g {
    private int cDG;
    private int cEv;
    private BaseAdapter cga;
    private int fDA;
    private b fDB;
    private int fDC;
    private int fDD;
    private Scroller fDE;
    private Rect fDF;
    private boolean fDG;
    private boolean fDH;
    private a fDI;
    private int fDJ;
    private int fDK;
    private boolean fDL;
    private View fDM;
    private final int fDN;
    private final int fDO;
    private boolean fDP;
    private ArrayList<View> fDQ;
    private boolean fDR;
    private boolean fDS;
    private boolean fDT;
    private boolean fDU;
    private boolean fDV;
    private Runnable fDW;
    private final float fDy;
    private View fDz;
    private int mItemCount;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void J(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.fDy = 2.0f;
        this.fDF = new Rect();
        this.fDK = 10;
        this.fDN = 300;
        this.fDO = 500;
        this.fDQ = new ArrayList<>();
        this.fDU = false;
        this.fDV = true;
        this.fDW = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDy = 2.0f;
        this.fDF = new Rect();
        this.fDK = 10;
        this.fDN = 300;
        this.fDO = 500;
        this.fDQ = new ArrayList<>();
        this.fDU = false;
        this.fDV = true;
        this.fDW = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDy = 2.0f;
        this.fDF = new Rect();
        this.fDK = 10;
        this.fDN = 300;
        this.fDO = 500;
        this.fDQ = new ArrayList<>();
        this.fDU = false;
        this.fDV = true;
        this.fDW = new c(this);
        init(context);
    }

    private void init(Context context) {
        this.fDz = null;
        this.fDA = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.fDE = new Scroller(context);
        this.fDJ = getResources().getDimensionPixelSize(w.f.ds66);
        this.mPadding = getResources().getDimensionPixelSize(w.f.ds32);
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
        this.mItemCount = this.cga == null ? 0 : this.cga.getCount();
        this.mItemCount = Math.min(this.fDK, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View so = so(0);
            measureScrapChild(so, i, i2);
            i4 = so.getMeasuredWidth();
            i3 = so.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] q = q(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(q[0], i);
                this.fDS = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(q[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.fDC = i;
        this.cDG = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.fDM) {
                this.fDQ.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.fDJ;
        if (this.fDU) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds32);
            if (this.mItemCount > 0) {
                View so = so(0);
                measureScrapChild(so, this.fDC, this.cDG);
                paddingLeft = ((getMeasuredWidth() - so.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.fDM != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.fDJ * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.fDM.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.fDM.setLayoutParams(layoutParams);
                measureScrapChild(this.fDM, this.fDC, this.cDG);
                paddingLeft = ((getMeasuredWidth() - this.fDM.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View so2 = so(i7);
            if (so2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = so2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    so2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(so2, -1, layoutParams2, true);
                measureScrapChild(so2, this.fDC, this.cDG);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = so2.getMeasuredWidth() + i6;
                so2.layout(i6, paddingTop, measuredWidth2, so2.getMeasuredHeight() + paddingTop);
                so2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.fDM != null) {
            if (this.fDV) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.fDJ * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.fDM.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.fDM.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.fDM, this.fDC, this.cDG);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.fDM.getMeasuredWidth() + i6;
            this.fDM.layout(i6, paddingTop2, measuredWidth4, this.fDM.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.fDK) {
                i6 = measuredWidth4 - this.fDM.getMeasuredWidth();
                this.fDP = false;
            } else {
                addViewInLayout(this.fDM, -1, this.fDM.getLayoutParams(), true);
                this.fDP = true;
                i6 = measuredWidth4;
            }
        }
        this.fDD = (this.fDJ + i6) - this.mPadding;
        if (this.fDL || z) {
            scrollTo(0, 0);
            scrollBy(biA(), 0);
            this.fDL = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.fDD > getMeasuredWidth();
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
                    if (!this.fDE.isFinished()) {
                        removeCallbacks(this.fDW);
                        this.fDE.forceFinished(true);
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
                    if (!this.fDE.isFinished()) {
                        removeCallbacks(this.fDW);
                        this.fDE.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.fDW);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cEv = i2;
                        this.fDE.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.fDW);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    sp((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cga = baseAdapter;
        this.mScroller.forceFinished(true);
        this.fDE.forceFinished(true);
        if (!this.fDL && z) {
            this.fDL = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cga;
    }

    private View so(int i) {
        View view = null;
        if (this.fDQ.size() > 0) {
            view = this.fDQ.remove(0);
        }
        View view2 = this.cga.getView(i, view, this);
        if (view2 != view) {
            this.fDQ.add(view);
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

    private int[] q(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.cga == null) {
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
            View so = so(i);
            if (so.getVisibility() != 8) {
                measureScrapChild(so, i3, i4);
                paddingRight += so.getMeasuredWidth();
                paddingTop = Math.max(so.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int biA() {
        if (canScroll()) {
            return this.fDD - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sp(int i) {
        scrollBy(sq(i), 0);
        invalidate();
    }

    private int sq(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > biA()) {
                i = biA() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.fDT) {
            this.fDT = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.fDB.a(view, null);
            this.fDz = view;
            this.fDA = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.fDG || this.fDH) && this.fDB != null) {
                this.fDB.biz();
                return;
            }
            return;
        }
        this.fDG = false;
        this.fDH = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(b bVar) {
        this.fDB = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void e(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.fDA && (childAt = getChildAt(i)) != this.fDM) {
                childAt.getHitRect(this.fDF);
                if (this.fDF.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.fDA;
                    bo(i2, i);
                    bn(i2, i);
                    this.fDA = i;
                    return;
                }
            }
        }
    }

    private void bn(int i, int i2) {
        if (this.fDI != null) {
            this.fDI.J(i, i2);
        }
    }

    private void bo(int i, int i2) {
        if (i != i2) {
            View childAt = getChildAt(i);
            View childAt2 = getChildAt(i2);
            if (i < i2) {
                detachViewFromParent(i);
                int i3 = -childAt.getMeasuredWidth();
                int left = childAt2.getLeft() - childAt.getLeft();
                while (i < i2) {
                    View childAt3 = getChildAt(i);
                    childAt3.offsetLeftAndRight(i3);
                    TranslateAnimation translateAnimation = new TranslateAnimation(-i3, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(300L);
                    translateAnimation.setFillAfter(true);
                    childAt3.startAnimation(translateAnimation);
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
                childAt4.offsetLeftAndRight(measuredWidth);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(-measuredWidth, 0.0f, 0.0f, 0.0f);
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                childAt4.startAnimation(translateAnimation2);
            }
            attachViewToParent(childAt, i2, childAt.getLayoutParams());
            childAt.offsetLeftAndRight(left2);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void biB() {
        if (!this.fDG) {
            this.fDG = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void biC() {
        if (!this.fDH) {
            this.fDH = true;
            int biA = biA();
            int scrollX = getScrollX();
            int scrollX2 = biA - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void biD() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.fDG = false;
        this.fDH = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void biE() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.fDI = aVar;
    }

    public void setMaxItemNum(int i) {
        this.fDK = i;
    }

    public int getMaxItemNum() {
        return this.fDK;
    }

    public void setAddView(View view) {
        this.fDM = view;
    }

    public int bp(View view) {
        this.fDR = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.fDP) {
            this.fDD -= measuredWidth;
        } else {
            if (this.fDM != null) {
                addViewInLayout(this.fDM, -1, this.fDM.getLayoutParams(), true);
                this.fDD += this.fDM.getMeasuredWidth();
            }
            this.fDD -= measuredWidth;
            this.fDP = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.fDQ.add(view);
        int childCount = getChildCount();
        if (childCount > 1) {
            for (int i = indexOfChild; i < childCount; i++) {
                View childAt = getChildAt(i);
                childAt.offsetLeftAndRight(-measuredWidth);
                TranslateAnimation translateAnimation = new TranslateAnimation(measuredWidth, 0.0f, 0.0f, 0.0f);
                translateAnimation.setDuration(500L);
                translateAnimation.setFillAfter(true);
                childAt.startAnimation(translateAnimation);
            }
        }
        int scrollX = getScrollX();
        if (!canScroll()) {
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, 500);
            postInvalidate();
        } else if (scrollX > biA()) {
            this.mScroller.startScroll(scrollX, 0, biA() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new d(this), 500L);
        return indexOfChild;
    }

    public boolean biF() {
        return this.fDR;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.fDW);
        this.mScroller.forceFinished(true);
        this.fDE.forceFinished(true);
        if (this.fDz != null) {
            this.fDz.setVisibility(0);
            this.fDz = null;
        }
        this.fDA = -1;
        this.fDG = false;
        this.fDH = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.fDT = false;
    }

    public void setCenterStart(boolean z) {
        this.fDU = z;
    }

    public void setStartEndSpace(int i) {
        this.fDJ = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.fDV = z;
    }
}
