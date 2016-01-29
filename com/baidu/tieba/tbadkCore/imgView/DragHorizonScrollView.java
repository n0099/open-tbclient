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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, e, f {
    private int bFs;
    private int bGy;
    private int bHt;
    private BaseAdapter bpo;
    private ArrayList<View> dYA;
    private boolean dYB;
    private boolean dYC;
    private boolean dYD;
    private boolean dYE;
    private Runnable dYF;
    private final float dYi;
    private View dYj;
    private int dYk;
    private com.baidu.tieba.tbadkCore.imgView.a dYl;
    private int dYm;
    private int dYn;
    private Scroller dYo;
    private Rect dYp;
    private boolean dYq;
    private boolean dYr;
    private a dYs;
    private int dYt;
    private int dYu;
    private boolean dYv;
    private View dYw;
    private final int dYx;
    private final int dYy;
    private boolean dYz;
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
        this.dYi = 2.0f;
        this.dYp = new Rect();
        this.dYu = 10;
        this.dYx = 300;
        this.dYy = 500;
        this.dYA = new ArrayList<>();
        this.dYE = false;
        this.dYF = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dYi = 2.0f;
        this.dYp = new Rect();
        this.dYu = 10;
        this.dYx = 300;
        this.dYy = 500;
        this.dYA = new ArrayList<>();
        this.dYE = false;
        this.dYF = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dYi = 2.0f;
        this.dYp = new Rect();
        this.dYu = 10;
        this.dYx = 300;
        this.dYy = 500;
        this.dYA = new ArrayList<>();
        this.dYE = false;
        this.dYF = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.dYj = null;
        this.dYk = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.dYo = new Scroller(context);
        this.dYt = getResources().getDimensionPixelSize(t.e.editor_muti_image_upload_scrollview_paddingleft);
        this.mPadding = getResources().getDimensionPixelSize(t.e.default_gap_24);
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
        this.bHt = this.bpo == null ? 0 : this.bpo.getCount();
        this.bHt = Math.min(this.dYu, this.bHt);
        if (this.bHt <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View oo = oo(0);
            g(oo, i, i2);
            i4 = oo.getMeasuredWidth();
            i3 = oo.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] p = p(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(p[0], i);
                this.dYC = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(p[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.dYm = i;
        this.bFs = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.dYw) {
                this.dYA.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.dYt;
        if (this.dYE) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.default_gap_24);
            if (this.bHt > 0) {
                View oo = oo(0);
                g(oo, this.dYm, this.bFs);
                paddingLeft = ((getMeasuredWidth() - oo.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.dYw != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.dYt * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.dYw.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.dYw.setLayoutParams(layoutParams);
                g(this.dYw, this.dYm, this.bFs);
                paddingLeft = ((getMeasuredWidth() - this.dYw.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.bHt; i7++) {
            View oo2 = oo(i7);
            if (oo2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = oo2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    oo2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(oo2, -1, layoutParams2, true);
                g(oo2, this.dYm, this.bFs);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = oo2.getMeasuredWidth() + i6;
                oo2.layout(i6, paddingTop, measuredWidth2, oo2.getMeasuredHeight() + paddingTop);
                oo2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.dYw != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.dYt * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.dYw.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.dYw.setLayoutParams(layoutParams3);
            g(this.dYw, this.dYm, this.bFs);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.dYw.getMeasuredWidth() + i6;
            this.dYw.layout(i6, paddingTop2, measuredWidth4, this.dYw.getMeasuredHeight() + paddingTop2);
            if (this.bHt == this.dYu) {
                i6 = measuredWidth4 - this.dYw.getMeasuredWidth();
                this.dYz = false;
            } else {
                addViewInLayout(this.dYw, -1, this.dYw.getLayoutParams(), true);
                this.dYz = true;
                i6 = measuredWidth4;
            }
        }
        this.dYn = (this.dYt + i6) - this.mPadding;
        if (this.dYv || z) {
            scrollTo(0, 0);
            scrollBy(aMQ(), 0);
            this.dYv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.dYn > getMeasuredWidth();
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
                    if (!this.dYo.isFinished()) {
                        removeCallbacks(this.dYF);
                        this.dYo.forceFinished(true);
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
                    if (!this.dYo.isFinished()) {
                        removeCallbacks(this.dYF);
                        this.dYo.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.dYF);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.bGy = i2;
                        this.dYo.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.dYF);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    op((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bpo = baseAdapter;
        this.mScroller.forceFinished(true);
        this.dYo.forceFinished(true);
        if (!this.dYv && z) {
            this.dYv = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bpo;
    }

    private View oo(int i) {
        View view = null;
        if (this.dYA.size() > 0) {
            view = this.dYA.remove(0);
        }
        View view2 = this.bpo.getView(i, view, this);
        if (view2 != view) {
            this.dYA.add(view);
        }
        view2.setOnLongClickListener(this);
        return view2;
    }

    private void g(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view.setLayoutParams(layoutParams);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    private int[] p(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.bpo == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.bHt - 1;
        }
        while (i <= i2) {
            View oo = oo(i);
            if (oo.getVisibility() != 8) {
                g(oo, i3, i4);
                paddingRight += oo.getMeasuredWidth();
                paddingTop = Math.max(oo.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aMQ() {
        if (canScroll()) {
            return this.dYn - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op(int i) {
        scrollBy(oq(i), 0);
        invalidate();
    }

    private int oq(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > aMQ()) {
                i = aMQ() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.dYD) {
            this.dYD = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.dYl.a(view, null);
            this.dYj = view;
            this.dYk = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.dYq || this.dYr) && this.dYl != null) {
                this.dYl.aMP();
                return;
            }
            return;
        }
        this.dYq = false;
        this.dYr = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.dYl = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.dYk && (childAt = getChildAt(i)) != this.dYw) {
                childAt.getHitRect(this.dYp);
                if (this.dYp.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.dYk;
                    be(i2, i);
                    bd(i2, i);
                    this.dYk = i;
                    return;
                }
            }
        }
    }

    private void bd(int i, int i2) {
        if (this.dYs != null) {
            this.dYs.E(i, i2);
        }
    }

    private void be(int i, int i2) {
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
    public void aMR() {
        if (!this.dYq) {
            this.dYq = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aMS() {
        if (!this.dYr) {
            this.dYr = true;
            int aMQ = aMQ();
            int scrollX = getScrollX();
            int scrollX2 = aMQ - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aMT() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.dYq = false;
        this.dYr = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aMU() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.dYs = aVar;
    }

    public void setMaxItemNum(int i) {
        this.dYu = i;
    }

    public int getMaxItemNum() {
        return this.dYu;
    }

    public void setAddView(View view) {
        this.dYw = view;
    }

    public int bd(View view) {
        this.dYB = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.dYz) {
            this.dYn -= measuredWidth;
        } else {
            if (this.dYw != null) {
                addViewInLayout(this.dYw, -1, this.dYw.getLayoutParams(), true);
                this.dYn += this.dYw.getMeasuredWidth();
            }
            this.dYn -= measuredWidth;
            this.dYz = true;
        }
        this.bHt--;
        removeViewInLayout(view);
        this.dYA.add(view);
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
        } else if (scrollX > aMQ()) {
            this.mScroller.startScroll(scrollX, 0, aMQ() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean aMV() {
        return this.dYB;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.dYF);
        this.mScroller.forceFinished(true);
        this.dYo.forceFinished(true);
        if (this.dYj != null) {
            this.dYj.setVisibility(0);
            this.dYj = null;
        }
        this.dYk = -1;
        this.dYq = false;
        this.dYr = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.dYD = false;
    }

    public void setCenterStart(boolean z) {
        this.dYE = z;
    }
}
