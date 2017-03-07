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
    private int cCx;
    private int cDE;
    private int cEz;
    private BaseAdapter cbd;
    private int fvA;
    private b fvB;
    private int fvC;
    private int fvD;
    private Scroller fvE;
    private Rect fvF;
    private boolean fvG;
    private boolean fvH;
    private a fvI;
    private int fvJ;
    private int fvK;
    private boolean fvL;
    private View fvM;
    private final int fvN;
    private final int fvO;
    private boolean fvP;
    private ArrayList<View> fvQ;
    private boolean fvR;
    private boolean fvS;
    private boolean fvT;
    private boolean fvU;
    private Runnable fvV;
    private final float fvy;
    private View fvz;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void K(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.fvy = 2.0f;
        this.fvF = new Rect();
        this.fvK = 10;
        this.fvN = 300;
        this.fvO = 500;
        this.fvQ = new ArrayList<>();
        this.fvU = false;
        this.fvV = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fvy = 2.0f;
        this.fvF = new Rect();
        this.fvK = 10;
        this.fvN = 300;
        this.fvO = 500;
        this.fvQ = new ArrayList<>();
        this.fvU = false;
        this.fvV = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fvy = 2.0f;
        this.fvF = new Rect();
        this.fvK = 10;
        this.fvN = 300;
        this.fvO = 500;
        this.fvQ = new ArrayList<>();
        this.fvU = false;
        this.fvV = new c(this);
        init(context);
    }

    private void init(Context context) {
        this.fvz = null;
        this.fvA = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.fvE = new Scroller(context);
        this.fvJ = getResources().getDimensionPixelSize(w.f.ds66);
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
        this.cEz = this.cbd == null ? 0 : this.cbd.getCount();
        this.cEz = Math.min(this.fvK, this.cEz);
        if (this.cEz <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View rW = rW(0);
            k(rW, i, i2);
            i4 = rW.getMeasuredWidth();
            i3 = rW.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] s = s(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(s[0], i);
                this.fvS = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(s[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.fvC = i;
        this.cCx = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.fvM) {
                this.fvQ.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.fvJ;
        if (this.fvU) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds32);
            if (this.cEz > 0) {
                View rW = rW(0);
                k(rW, this.fvC, this.cCx);
                paddingLeft = ((getMeasuredWidth() - rW.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.fvM != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.fvJ * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.fvM.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.fvM.setLayoutParams(layoutParams);
                k(this.fvM, this.fvC, this.cCx);
                paddingLeft = ((getMeasuredWidth() - this.fvM.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.cEz; i7++) {
            View rW2 = rW(i7);
            if (rW2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = rW2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    rW2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(rW2, -1, layoutParams2, true);
                k(rW2, this.fvC, this.cCx);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = rW2.getMeasuredWidth() + i6;
                rW2.layout(i6, paddingTop, measuredWidth2, rW2.getMeasuredHeight() + paddingTop);
                rW2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.fvM != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.fvJ * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.fvM.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.fvM.setLayoutParams(layoutParams3);
            k(this.fvM, this.fvC, this.cCx);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.fvM.getMeasuredWidth() + i6;
            this.fvM.layout(i6, paddingTop2, measuredWidth4, this.fvM.getMeasuredHeight() + paddingTop2);
            if (this.cEz == this.fvK) {
                i6 = measuredWidth4 - this.fvM.getMeasuredWidth();
                this.fvP = false;
            } else {
                addViewInLayout(this.fvM, -1, this.fvM.getLayoutParams(), true);
                this.fvP = true;
                i6 = measuredWidth4;
            }
        }
        this.fvD = (this.fvJ + i6) - this.mPadding;
        if (this.fvL || z) {
            scrollTo(0, 0);
            scrollBy(bhX(), 0);
            this.fvL = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.fvD > getMeasuredWidth();
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
                    if (!this.fvE.isFinished()) {
                        removeCallbacks(this.fvV);
                        this.fvE.forceFinished(true);
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
                    if (!this.fvE.isFinished()) {
                        removeCallbacks(this.fvV);
                        this.fvE.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.fvV);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cDE = i2;
                        this.fvE.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.fvV);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    rX((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cbd = baseAdapter;
        this.mScroller.forceFinished(true);
        this.fvE.forceFinished(true);
        if (!this.fvL && z) {
            this.fvL = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cbd;
    }

    private View rW(int i) {
        View view = null;
        if (this.fvQ.size() > 0) {
            view = this.fvQ.remove(0);
        }
        View view2 = this.cbd.getView(i, view, this);
        if (view2 != view) {
            this.fvQ.add(view);
        }
        if (view2 != null) {
            view2.setOnLongClickListener(this);
        }
        return view2;
    }

    private void k(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view.setLayoutParams(layoutParams);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    private int[] s(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.cbd == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.cEz - 1;
        }
        while (i <= i2) {
            View rW = rW(i);
            if (rW.getVisibility() != 8) {
                k(rW, i3, i4);
                paddingRight += rW.getMeasuredWidth();
                paddingTop = Math.max(rW.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bhX() {
        if (canScroll()) {
            return this.fvD - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rX(int i) {
        scrollBy(rY(i), 0);
        invalidate();
    }

    private int rY(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bhX()) {
                i = bhX() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.fvT) {
            this.fvT = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.fvB.a(view, null);
            this.fvz = view;
            this.fvA = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.fvG || this.fvH) && this.fvB != null) {
                this.fvB.bhW();
                return;
            }
            return;
        }
        this.fvG = false;
        this.fvH = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(b bVar) {
        this.fvB = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void e(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.fvA && (childAt = getChildAt(i)) != this.fvM) {
                childAt.getHitRect(this.fvF);
                if (this.fvF.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.fvA;
                    bu(i2, i);
                    bt(i2, i);
                    this.fvA = i;
                    return;
                }
            }
        }
    }

    private void bt(int i, int i2) {
        if (this.fvI != null) {
            this.fvI.K(i, i2);
        }
    }

    private void bu(int i, int i2) {
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
    public void bhY() {
        if (!this.fvG) {
            this.fvG = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bhZ() {
        if (!this.fvH) {
            this.fvH = true;
            int bhX = bhX();
            int scrollX = getScrollX();
            int scrollX2 = bhX - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bia() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.fvG = false;
        this.fvH = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bib() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.fvI = aVar;
    }

    public void setMaxItemNum(int i) {
        this.fvK = i;
    }

    public int getMaxItemNum() {
        return this.fvK;
    }

    public void setAddView(View view) {
        this.fvM = view;
    }

    public int bq(View view) {
        this.fvR = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.fvP) {
            this.fvD -= measuredWidth;
        } else {
            if (this.fvM != null) {
                addViewInLayout(this.fvM, -1, this.fvM.getLayoutParams(), true);
                this.fvD += this.fvM.getMeasuredWidth();
            }
            this.fvD -= measuredWidth;
            this.fvP = true;
        }
        this.cEz--;
        removeViewInLayout(view);
        this.fvQ.add(view);
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
        } else if (scrollX > bhX()) {
            this.mScroller.startScroll(scrollX, 0, bhX() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new d(this), 500L);
        return indexOfChild;
    }

    public boolean bic() {
        return this.fvR;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.fvV);
        this.mScroller.forceFinished(true);
        this.fvE.forceFinished(true);
        if (this.fvz != null) {
            this.fvz.setVisibility(0);
            this.fvz = null;
        }
        this.fvA = -1;
        this.fvG = false;
        this.fvH = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.fvT = false;
    }

    public void setCenterStart(boolean z) {
        this.fvU = z;
    }
}
