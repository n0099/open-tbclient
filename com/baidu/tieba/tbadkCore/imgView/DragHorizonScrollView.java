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
    private int cDn;
    private int cEu;
    private int cFp;
    private BaseAdapter cbV;
    private int fzA;
    private b fzB;
    private int fzC;
    private int fzD;
    private Scroller fzE;
    private Rect fzF;
    private boolean fzG;
    private boolean fzH;
    private a fzI;
    private int fzJ;
    private int fzK;
    private boolean fzL;
    private View fzM;
    private final int fzN;
    private final int fzO;
    private boolean fzP;
    private ArrayList<View> fzQ;
    private boolean fzR;
    private boolean fzS;
    private boolean fzT;
    private boolean fzU;
    private Runnable fzV;
    private final float fzy;
    private View fzz;
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
        this.fzy = 2.0f;
        this.fzF = new Rect();
        this.fzK = 10;
        this.fzN = 300;
        this.fzO = 500;
        this.fzQ = new ArrayList<>();
        this.fzU = false;
        this.fzV = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fzy = 2.0f;
        this.fzF = new Rect();
        this.fzK = 10;
        this.fzN = 300;
        this.fzO = 500;
        this.fzQ = new ArrayList<>();
        this.fzU = false;
        this.fzV = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fzy = 2.0f;
        this.fzF = new Rect();
        this.fzK = 10;
        this.fzN = 300;
        this.fzO = 500;
        this.fzQ = new ArrayList<>();
        this.fzU = false;
        this.fzV = new c(this);
        init(context);
    }

    private void init(Context context) {
        this.fzz = null;
        this.fzA = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.fzE = new Scroller(context);
        this.fzJ = getResources().getDimensionPixelSize(w.f.ds66);
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
        this.cFp = this.cbV == null ? 0 : this.cbV.getCount();
        this.cFp = Math.min(this.fzK, this.cFp);
        if (this.cFp <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View sa = sa(0);
            k(sa, i, i2);
            i4 = sa.getMeasuredWidth();
            i3 = sa.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] s = s(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(s[0], i);
                this.fzS = true;
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
        this.fzC = i;
        this.cDn = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.fzM) {
                this.fzQ.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.fzJ;
        if (this.fzU) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds32);
            if (this.cFp > 0) {
                View sa = sa(0);
                k(sa, this.fzC, this.cDn);
                paddingLeft = ((getMeasuredWidth() - sa.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.fzM != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.fzJ * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.fzM.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.fzM.setLayoutParams(layoutParams);
                k(this.fzM, this.fzC, this.cDn);
                paddingLeft = ((getMeasuredWidth() - this.fzM.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.cFp; i7++) {
            View sa2 = sa(i7);
            if (sa2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = sa2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    sa2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(sa2, -1, layoutParams2, true);
                k(sa2, this.fzC, this.cDn);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = sa2.getMeasuredWidth() + i6;
                sa2.layout(i6, paddingTop, measuredWidth2, sa2.getMeasuredHeight() + paddingTop);
                sa2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.fzM != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.fzJ * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.fzM.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.fzM.setLayoutParams(layoutParams3);
            k(this.fzM, this.fzC, this.cDn);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.fzM.getMeasuredWidth() + i6;
            this.fzM.layout(i6, paddingTop2, measuredWidth4, this.fzM.getMeasuredHeight() + paddingTop2);
            if (this.cFp == this.fzK) {
                i6 = measuredWidth4 - this.fzM.getMeasuredWidth();
                this.fzP = false;
            } else {
                addViewInLayout(this.fzM, -1, this.fzM.getLayoutParams(), true);
                this.fzP = true;
                i6 = measuredWidth4;
            }
        }
        this.fzD = (this.fzJ + i6) - this.mPadding;
        if (this.fzL || z) {
            scrollTo(0, 0);
            scrollBy(bjJ(), 0);
            this.fzL = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.fzD > getMeasuredWidth();
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
                    if (!this.fzE.isFinished()) {
                        removeCallbacks(this.fzV);
                        this.fzE.forceFinished(true);
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
                    if (!this.fzE.isFinished()) {
                        removeCallbacks(this.fzV);
                        this.fzE.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.fzV);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cEu = i2;
                        this.fzE.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.fzV);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    sb((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cbV = baseAdapter;
        this.mScroller.forceFinished(true);
        this.fzE.forceFinished(true);
        if (!this.fzL && z) {
            this.fzL = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cbV;
    }

    private View sa(int i) {
        View view = null;
        if (this.fzQ.size() > 0) {
            view = this.fzQ.remove(0);
        }
        View view2 = this.cbV.getView(i, view, this);
        if (view2 != view) {
            this.fzQ.add(view);
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
        if (this.cbV == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.cFp - 1;
        }
        while (i <= i2) {
            View sa = sa(i);
            if (sa.getVisibility() != 8) {
                k(sa, i3, i4);
                paddingRight += sa.getMeasuredWidth();
                paddingTop = Math.max(sa.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bjJ() {
        if (canScroll()) {
            return this.fzD - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(int i) {
        scrollBy(sc(i), 0);
        invalidate();
    }

    private int sc(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bjJ()) {
                i = bjJ() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.fzT) {
            this.fzT = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.fzB.a(view, null);
            this.fzz = view;
            this.fzA = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.fzG || this.fzH) && this.fzB != null) {
                this.fzB.bjI();
                return;
            }
            return;
        }
        this.fzG = false;
        this.fzH = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(b bVar) {
        this.fzB = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void e(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.fzA && (childAt = getChildAt(i)) != this.fzM) {
                childAt.getHitRect(this.fzF);
                if (this.fzF.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.fzA;
                    br(i2, i);
                    bq(i2, i);
                    this.fzA = i;
                    return;
                }
            }
        }
    }

    private void bq(int i, int i2) {
        if (this.fzI != null) {
            this.fzI.K(i, i2);
        }
    }

    private void br(int i, int i2) {
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
    public void bjK() {
        if (!this.fzG) {
            this.fzG = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bjL() {
        if (!this.fzH) {
            this.fzH = true;
            int bjJ = bjJ();
            int scrollX = getScrollX();
            int scrollX2 = bjJ - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bjM() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.fzG = false;
        this.fzH = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bjN() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.fzI = aVar;
    }

    public void setMaxItemNum(int i) {
        this.fzK = i;
    }

    public int getMaxItemNum() {
        return this.fzK;
    }

    public void setAddView(View view) {
        this.fzM = view;
    }

    public int bo(View view) {
        this.fzR = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.fzP) {
            this.fzD -= measuredWidth;
        } else {
            if (this.fzM != null) {
                addViewInLayout(this.fzM, -1, this.fzM.getLayoutParams(), true);
                this.fzD += this.fzM.getMeasuredWidth();
            }
            this.fzD -= measuredWidth;
            this.fzP = true;
        }
        this.cFp--;
        removeViewInLayout(view);
        this.fzQ.add(view);
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
        } else if (scrollX > bjJ()) {
            this.mScroller.startScroll(scrollX, 0, bjJ() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new d(this), 500L);
        return indexOfChild;
    }

    public boolean bjO() {
        return this.fzR;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.fzV);
        this.mScroller.forceFinished(true);
        this.fzE.forceFinished(true);
        if (this.fzz != null) {
            this.fzz.setVisibility(0);
            this.fzz = null;
        }
        this.fzA = -1;
        this.fzG = false;
        this.fzH = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.fzT = false;
    }

    public void setCenterStart(boolean z) {
        this.fzU = z;
    }
}
