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
    private BaseAdapter bZE;
    private int cAW;
    private int cCY;
    private int cCd;
    private ArrayList<View> fxA;
    private boolean fxB;
    private boolean fxC;
    private boolean fxD;
    private boolean fxE;
    private Runnable fxF;
    private final float fxh;
    private View fxi;
    private int fxj;
    private b fxl;
    private int fxm;
    private int fxn;
    private Scroller fxo;
    private Rect fxp;
    private boolean fxq;
    private boolean fxr;
    private a fxs;
    private int fxt;
    private int fxu;
    private boolean fxv;
    private View fxw;
    private final int fxx;
    private final int fxy;
    private boolean fxz;
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
        this.fxh = 2.0f;
        this.fxp = new Rect();
        this.fxu = 10;
        this.fxx = 300;
        this.fxy = 500;
        this.fxA = new ArrayList<>();
        this.fxE = false;
        this.fxF = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fxh = 2.0f;
        this.fxp = new Rect();
        this.fxu = 10;
        this.fxx = 300;
        this.fxy = 500;
        this.fxA = new ArrayList<>();
        this.fxE = false;
        this.fxF = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fxh = 2.0f;
        this.fxp = new Rect();
        this.fxu = 10;
        this.fxx = 300;
        this.fxy = 500;
        this.fxA = new ArrayList<>();
        this.fxE = false;
        this.fxF = new c(this);
        init(context);
    }

    private void init(Context context) {
        this.fxi = null;
        this.fxj = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.fxo = new Scroller(context);
        this.fxt = getResources().getDimensionPixelSize(w.f.ds66);
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
        this.cCY = this.bZE == null ? 0 : this.bZE.getCount();
        this.cCY = Math.min(this.fxu, this.cCY);
        if (this.cCY <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View rU = rU(0);
            j(rU, i, i2);
            i4 = rU.getMeasuredWidth();
            i3 = rU.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] s = s(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(s[0], i);
                this.fxC = true;
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
        this.fxm = i;
        this.cAW = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.fxw) {
                this.fxA.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.fxt;
        if (this.fxE) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds32);
            if (this.cCY > 0) {
                View rU = rU(0);
                j(rU, this.fxm, this.cAW);
                paddingLeft = ((getMeasuredWidth() - rU.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.fxw != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.fxt * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.fxw.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.fxw.setLayoutParams(layoutParams);
                j(this.fxw, this.fxm, this.cAW);
                paddingLeft = ((getMeasuredWidth() - this.fxw.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.cCY; i7++) {
            View rU2 = rU(i7);
            if (rU2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = rU2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    rU2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(rU2, -1, layoutParams2, true);
                j(rU2, this.fxm, this.cAW);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = rU2.getMeasuredWidth() + i6;
                rU2.layout(i6, paddingTop, measuredWidth2, rU2.getMeasuredHeight() + paddingTop);
                rU2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.fxw != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.fxt * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.fxw.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.fxw.setLayoutParams(layoutParams3);
            j(this.fxw, this.fxm, this.cAW);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.fxw.getMeasuredWidth() + i6;
            this.fxw.layout(i6, paddingTop2, measuredWidth4, this.fxw.getMeasuredHeight() + paddingTop2);
            if (this.cCY == this.fxu) {
                i6 = measuredWidth4 - this.fxw.getMeasuredWidth();
                this.fxz = false;
            } else {
                addViewInLayout(this.fxw, -1, this.fxw.getLayoutParams(), true);
                this.fxz = true;
                i6 = measuredWidth4;
            }
        }
        this.fxn = (this.fxt + i6) - this.mPadding;
        if (this.fxv || z) {
            scrollTo(0, 0);
            scrollBy(biI(), 0);
            this.fxv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.fxn > getMeasuredWidth();
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
                    if (!this.fxo.isFinished()) {
                        removeCallbacks(this.fxF);
                        this.fxo.forceFinished(true);
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
                    if (!this.fxo.isFinished()) {
                        removeCallbacks(this.fxF);
                        this.fxo.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.fxF);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cCd = i2;
                        this.fxo.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.fxF);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    rV((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bZE = baseAdapter;
        this.mScroller.forceFinished(true);
        this.fxo.forceFinished(true);
        if (!this.fxv && z) {
            this.fxv = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bZE;
    }

    private View rU(int i) {
        View view = null;
        if (this.fxA.size() > 0) {
            view = this.fxA.remove(0);
        }
        View view2 = this.bZE.getView(i, view, this);
        if (view2 != view) {
            this.fxA.add(view);
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

    private int[] s(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.bZE == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.cCY - 1;
        }
        while (i <= i2) {
            View rU = rU(i);
            if (rU.getVisibility() != 8) {
                j(rU, i3, i4);
                paddingRight += rU.getMeasuredWidth();
                paddingTop = Math.max(rU.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int biI() {
        if (canScroll()) {
            return this.fxn - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rV(int i) {
        scrollBy(rW(i), 0);
        invalidate();
    }

    private int rW(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > biI()) {
                i = biI() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.fxD) {
            this.fxD = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.fxl.a(view, null);
            this.fxi = view;
            this.fxj = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.fxq || this.fxr) && this.fxl != null) {
                this.fxl.biH();
                return;
            }
            return;
        }
        this.fxq = false;
        this.fxr = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(b bVar) {
        this.fxl = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void e(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.fxj && (childAt = getChildAt(i)) != this.fxw) {
                childAt.getHitRect(this.fxp);
                if (this.fxp.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.fxj;
                    br(i2, i);
                    bq(i2, i);
                    this.fxj = i;
                    return;
                }
            }
        }
    }

    private void bq(int i, int i2) {
        if (this.fxs != null) {
            this.fxs.K(i, i2);
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
    public void biJ() {
        if (!this.fxq) {
            this.fxq = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void biK() {
        if (!this.fxr) {
            this.fxr = true;
            int biI = biI();
            int scrollX = getScrollX();
            int scrollX2 = biI - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void biL() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.fxq = false;
        this.fxr = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void biM() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.fxs = aVar;
    }

    public void setMaxItemNum(int i) {
        this.fxu = i;
    }

    public int getMaxItemNum() {
        return this.fxu;
    }

    public void setAddView(View view) {
        this.fxw = view;
    }

    public int bo(View view) {
        this.fxB = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.fxz) {
            this.fxn -= measuredWidth;
        } else {
            if (this.fxw != null) {
                addViewInLayout(this.fxw, -1, this.fxw.getLayoutParams(), true);
                this.fxn += this.fxw.getMeasuredWidth();
            }
            this.fxn -= measuredWidth;
            this.fxz = true;
        }
        this.cCY--;
        removeViewInLayout(view);
        this.fxA.add(view);
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
        } else if (scrollX > biI()) {
            this.mScroller.startScroll(scrollX, 0, biI() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new d(this), 500L);
        return indexOfChild;
    }

    public boolean biN() {
        return this.fxB;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.fxF);
        this.mScroller.forceFinished(true);
        this.fxo.forceFinished(true);
        if (this.fxi != null) {
            this.fxi.setVisibility(0);
            this.fxi = null;
        }
        this.fxj = -1;
        this.fxq = false;
        this.fxr = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.fxD = false;
    }

    public void setCenterStart(boolean z) {
        this.fxE = z;
    }
}
