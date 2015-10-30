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
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, e, f {
    private int bTb;
    private BaseAdapter bbA;
    private boolean daA;
    private ArrayList<View> daB;
    private boolean daC;
    private boolean daD;
    private boolean daE;
    private boolean daF;
    private Runnable daG;
    private final float daf;
    private View dag;
    private int dah;
    private com.baidu.tieba.tbadkCore.imgView.a dai;
    private int daj;
    private int dak;
    private int dal;
    private Scroller dam;
    private Rect dan;
    private boolean dao;
    private boolean dap;
    private a daq;
    private int dar;
    private int das;
    private boolean dau;
    private View dav;
    private final int daw;
    private final int dax;
    private int daz;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void H(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.daf = 2.0f;
        this.dan = new Rect();
        this.das = 10;
        this.daw = 300;
        this.dax = 500;
        this.daB = new ArrayList<>();
        this.daF = false;
        this.daG = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.daf = 2.0f;
        this.dan = new Rect();
        this.das = 10;
        this.daw = 300;
        this.dax = 500;
        this.daB = new ArrayList<>();
        this.daF = false;
        this.daG = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.daf = 2.0f;
        this.dan = new Rect();
        this.das = 10;
        this.daw = 300;
        this.dax = 500;
        this.daB = new ArrayList<>();
        this.daF = false;
        this.daG = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.dag = null;
        this.dah = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.dam = new Scroller(context);
        this.dar = getResources().getDimensionPixelSize(i.d.editor_muti_image_upload_scrollview_paddingleft);
        this.mPadding = getResources().getDimensionPixelSize(i.d.default_gap_24);
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
        this.bTb = this.bbA == null ? 0 : this.bbA.getCount();
        this.bTb = Math.min(this.das, this.bTb);
        if (this.bTb <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View kZ = kZ(0);
            f(kZ, i, i2);
            i4 = kZ.getMeasuredWidth();
            i3 = kZ.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] m = m(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(m[0], i);
                this.daD = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(m[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.daj = i;
        this.dak = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.dav) {
                this.daB.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.dar;
        if (this.daF) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.default_gap_24);
            if (this.bTb > 0) {
                View kZ = kZ(0);
                f(kZ, this.daj, this.dak);
                paddingLeft = ((getMeasuredWidth() - kZ.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.dav != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.dar * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.dav.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.dav.setLayoutParams(layoutParams);
                f(this.dav, this.daj, this.dak);
                paddingLeft = ((getMeasuredWidth() - this.dav.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.bTb; i7++) {
            View kZ2 = kZ(i7);
            if (kZ2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = kZ2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    kZ2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(kZ2, -1, layoutParams2, true);
                f(kZ2, this.daj, this.dak);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = kZ2.getMeasuredWidth() + i6;
                kZ2.layout(i6, paddingTop, measuredWidth2, kZ2.getMeasuredHeight() + paddingTop);
                kZ2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.dav != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.dar * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.dav.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.dav.setLayoutParams(layoutParams3);
            f(this.dav, this.daj, this.dak);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.dav.getMeasuredWidth() + i6;
            this.dav.layout(i6, paddingTop2, measuredWidth4, this.dav.getMeasuredHeight() + paddingTop2);
            if (this.bTb == this.das) {
                i6 = measuredWidth4 - this.dav.getMeasuredWidth();
                this.daA = false;
            } else {
                addViewInLayout(this.dav, -1, this.dav.getLayoutParams(), true);
                this.daA = true;
                i6 = measuredWidth4;
            }
        }
        this.dal = (this.dar + i6) - this.mPadding;
        if (this.dau || z) {
            scrollTo(0, 0);
            scrollBy(awX(), 0);
            this.dau = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.dal > getMeasuredWidth();
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
                    if (!this.dam.isFinished()) {
                        removeCallbacks(this.daG);
                        this.dam.forceFinished(true);
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
                    if (!this.dam.isFinished()) {
                        removeCallbacks(this.daG);
                        this.dam.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.daG);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.daz = i2;
                        this.dam.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.daG);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    la((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bbA = baseAdapter;
        this.mScroller.forceFinished(true);
        this.dam.forceFinished(true);
        if (!this.dau && z) {
            this.dau = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bbA;
    }

    private View kZ(int i) {
        View view = null;
        if (this.daB.size() > 0) {
            view = this.daB.remove(0);
        }
        View view2 = this.bbA.getView(i, view, this);
        if (view2 != view) {
            this.daB.add(view);
        }
        view2.setOnLongClickListener(this);
        return view2;
    }

    private void f(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view.setLayoutParams(layoutParams);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    private int[] m(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.bbA == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.bTb - 1;
        }
        while (i <= i2) {
            View kZ = kZ(i);
            if (kZ.getVisibility() != 8) {
                f(kZ, i3, i4);
                paddingRight += kZ.getMeasuredWidth();
                paddingTop = Math.max(kZ.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awX() {
        if (canScroll()) {
            return this.dal - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void la(int i) {
        scrollBy(lb(i), 0);
        invalidate();
    }

    private int lb(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > awX()) {
                i = awX() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.daE) {
            this.daE = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.dai.a(view, null);
            this.dag = view;
            this.dah = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.dao || this.dap) && this.dai != null) {
                this.dai.awW();
                return;
            }
            return;
        }
        this.dao = false;
        this.dap = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.dai = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.dah && (childAt = getChildAt(i)) != this.dav) {
                childAt.getHitRect(this.dan);
                if (this.dan.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.dah;
                    aH(i2, i);
                    aG(i2, i);
                    this.dah = i;
                    return;
                }
            }
        }
    }

    private void aG(int i, int i2) {
        if (this.daq != null) {
            this.daq.H(i, i2);
        }
    }

    private void aH(int i, int i2) {
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
    public void awY() {
        if (!this.dao) {
            this.dao = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void awZ() {
        if (!this.dap) {
            this.dap = true;
            int awX = awX();
            int scrollX = getScrollX();
            int scrollX2 = awX - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void axa() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.dao = false;
        this.dap = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void axb() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.daq = aVar;
    }

    public void setMaxItemNum(int i) {
        this.das = i;
    }

    public int getMaxItemNum() {
        return this.das;
    }

    public void setAddView(View view) {
        this.dav = view;
    }

    public int ax(View view) {
        this.daC = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.daA) {
            this.dal -= measuredWidth;
        } else {
            if (this.dav != null) {
                addViewInLayout(this.dav, -1, this.dav.getLayoutParams(), true);
                this.dal += this.dav.getMeasuredWidth();
            }
            this.dal -= measuredWidth;
            this.daA = true;
        }
        this.bTb--;
        removeViewInLayout(view);
        this.daB.add(view);
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
        } else if (scrollX > awX()) {
            this.mScroller.startScroll(scrollX, 0, awX() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean axc() {
        return this.daC;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.daG);
        this.mScroller.forceFinished(true);
        this.dam.forceFinished(true);
        if (this.dag != null) {
            this.dag.setVisibility(0);
            this.dag = null;
        }
        this.dah = -1;
        this.dao = false;
        this.dap = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.daE = false;
    }

    public void setCenterStart(boolean z) {
        this.daF = z;
    }
}
