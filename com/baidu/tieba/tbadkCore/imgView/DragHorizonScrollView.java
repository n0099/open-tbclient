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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, e, f {
    private int cJC;
    private int cKI;
    private int cLC;
    private BaseAdapter cdT;
    private final float fwC;
    private View fwD;
    private int fwE;
    private com.baidu.tieba.tbadkCore.imgView.a fwF;
    private int fwG;
    private int fwH;
    private Scroller fwI;
    private Rect fwJ;
    private boolean fwK;
    private boolean fwL;
    private a fwM;
    private int fwN;
    private int fwO;
    private boolean fwP;
    private View fwQ;
    private final int fwR;
    private final int fwS;
    private boolean fwT;
    private ArrayList<View> fwU;
    private boolean fwV;
    private boolean fwW;
    private boolean fwX;
    private boolean fwY;
    private Runnable fwZ;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void D(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.fwC = 2.0f;
        this.fwJ = new Rect();
        this.fwO = 10;
        this.fwR = 300;
        this.fwS = 500;
        this.fwU = new ArrayList<>();
        this.fwY = false;
        this.fwZ = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fwC = 2.0f;
        this.fwJ = new Rect();
        this.fwO = 10;
        this.fwR = 300;
        this.fwS = 500;
        this.fwU = new ArrayList<>();
        this.fwY = false;
        this.fwZ = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fwC = 2.0f;
        this.fwJ = new Rect();
        this.fwO = 10;
        this.fwR = 300;
        this.fwS = 500;
        this.fwU = new ArrayList<>();
        this.fwY = false;
        this.fwZ = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.fwD = null;
        this.fwE = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.fwI = new Scroller(context);
        this.fwN = getResources().getDimensionPixelSize(r.e.ds66);
        this.mPadding = getResources().getDimensionPixelSize(r.e.ds32);
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
        this.cLC = this.cdT == null ? 0 : this.cdT.getCount();
        this.cLC = Math.min(this.fwO, this.cLC);
        if (this.cLC <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View rR = rR(0);
            j(rR, i, i2);
            i4 = rR.getMeasuredWidth();
            i3 = rR.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] t = t(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(t[0], i);
                this.fwW = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(t[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.fwG = i;
        this.cJC = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.fwQ) {
                this.fwU.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.fwN;
        if (this.fwY) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds32);
            if (this.cLC > 0) {
                View rR = rR(0);
                j(rR, this.fwG, this.cJC);
                paddingLeft = ((getMeasuredWidth() - rR.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.fwQ != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.fwN * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.fwQ.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.fwQ.setLayoutParams(layoutParams);
                j(this.fwQ, this.fwG, this.cJC);
                paddingLeft = ((getMeasuredWidth() - this.fwQ.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.cLC; i7++) {
            View rR2 = rR(i7);
            if (rR2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = rR2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    rR2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(rR2, -1, layoutParams2, true);
                j(rR2, this.fwG, this.cJC);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = rR2.getMeasuredWidth() + i6;
                rR2.layout(i6, paddingTop, measuredWidth2, rR2.getMeasuredHeight() + paddingTop);
                rR2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.fwQ != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.fwN * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.fwQ.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.fwQ.setLayoutParams(layoutParams3);
            j(this.fwQ, this.fwG, this.cJC);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.fwQ.getMeasuredWidth() + i6;
            this.fwQ.layout(i6, paddingTop2, measuredWidth4, this.fwQ.getMeasuredHeight() + paddingTop2);
            if (this.cLC == this.fwO) {
                i6 = measuredWidth4 - this.fwQ.getMeasuredWidth();
                this.fwT = false;
            } else {
                addViewInLayout(this.fwQ, -1, this.fwQ.getLayoutParams(), true);
                this.fwT = true;
                i6 = measuredWidth4;
            }
        }
        this.fwH = (this.fwN + i6) - this.mPadding;
        if (this.fwP || z) {
            scrollTo(0, 0);
            scrollBy(bkn(), 0);
            this.fwP = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.fwH > getMeasuredWidth();
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
                    if (!this.fwI.isFinished()) {
                        removeCallbacks(this.fwZ);
                        this.fwI.forceFinished(true);
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
                    if (!this.fwI.isFinished()) {
                        removeCallbacks(this.fwZ);
                        this.fwI.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.fwZ);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cKI = i2;
                        this.fwI.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.fwZ);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    rS((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cdT = baseAdapter;
        this.mScroller.forceFinished(true);
        this.fwI.forceFinished(true);
        if (!this.fwP && z) {
            this.fwP = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cdT;
    }

    private View rR(int i) {
        View view = null;
        if (this.fwU.size() > 0) {
            view = this.fwU.remove(0);
        }
        View view2 = this.cdT.getView(i, view, this);
        if (view2 != view) {
            this.fwU.add(view);
        }
        if (view2 != null) {
            view2.setOnLongClickListener(this);
        }
        return view2;
    }

    private void j(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view.setLayoutParams(layoutParams);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    private int[] t(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.cdT == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.cLC - 1;
        }
        while (i <= i2) {
            View rR = rR(i);
            if (rR.getVisibility() != 8) {
                j(rR, i3, i4);
                paddingRight += rR.getMeasuredWidth();
                paddingTop = Math.max(rR.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bkn() {
        if (canScroll()) {
            return this.fwH - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS(int i) {
        scrollBy(rT(i), 0);
        invalidate();
    }

    private int rT(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bkn()) {
                i = bkn() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.fwX) {
            this.fwX = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.fwF.a(view, null);
            this.fwD = view;
            this.fwE = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.fwK || this.fwL) && this.fwF != null) {
                this.fwF.bkm();
                return;
            }
            return;
        }
        this.fwK = false;
        this.fwL = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.fwF = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.fwE && (childAt = getChildAt(i)) != this.fwQ) {
                childAt.getHitRect(this.fwJ);
                if (this.fwJ.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.fwE;
                    bu(i2, i);
                    bt(i2, i);
                    this.fwE = i;
                    return;
                }
            }
        }
    }

    private void bt(int i, int i2) {
        if (this.fwM != null) {
            this.fwM.D(i, i2);
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

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bko() {
        if (!this.fwK) {
            this.fwK = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bkp() {
        if (!this.fwL) {
            this.fwL = true;
            int bkn = bkn();
            int scrollX = getScrollX();
            int scrollX2 = bkn - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bkq() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.fwK = false;
        this.fwL = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bkr() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.fwM = aVar;
    }

    public void setMaxItemNum(int i) {
        this.fwO = i;
    }

    public int getMaxItemNum() {
        return this.fwO;
    }

    public void setAddView(View view) {
        this.fwQ = view;
    }

    public int bp(View view) {
        this.fwV = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.fwT) {
            this.fwH -= measuredWidth;
        } else {
            if (this.fwQ != null) {
                addViewInLayout(this.fwQ, -1, this.fwQ.getLayoutParams(), true);
                this.fwH += this.fwQ.getMeasuredWidth();
            }
            this.fwH -= measuredWidth;
            this.fwT = true;
        }
        this.cLC--;
        removeViewInLayout(view);
        this.fwU.add(view);
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
        } else if (scrollX > bkn()) {
            this.mScroller.startScroll(scrollX, 0, bkn() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean bks() {
        return this.fwV;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.fwZ);
        this.mScroller.forceFinished(true);
        this.fwI.forceFinished(true);
        if (this.fwD != null) {
            this.fwD.setVisibility(0);
            this.fwD = null;
        }
        this.fwE = -1;
        this.fwK = false;
        this.fwL = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.fwX = false;
    }

    public void setCenterStart(boolean z) {
        this.fwY = z;
    }
}
