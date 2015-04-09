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
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, f, g {
    private int byf;
    private final float coX;
    private BaseAdapter coY;
    private View coZ;
    private int cpa;
    private a cpb;
    private int cpc;
    private int cpd;
    private Scroller cpe;
    private Rect cpf;
    private boolean cpg;
    private boolean cph;
    private d cpi;
    private int cpj;
    private int cpk;
    private boolean cpl;
    private View cpm;
    private final int cpn;
    private final int cpo;
    private int cpp;
    private boolean cpq;
    private ArrayList<View> cpr;
    private boolean cps;
    private boolean cpt;
    private boolean cpu;
    private boolean cpv;
    private Runnable cpw;
    private int mContentWidth;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public DragHorizonScrollView(Context context) {
        super(context);
        this.coX = 2.0f;
        this.cpf = new Rect();
        this.cpk = 10;
        this.cpn = 300;
        this.cpo = 500;
        this.cpr = new ArrayList<>();
        this.cpv = false;
        this.cpw = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.coX = 2.0f;
        this.cpf = new Rect();
        this.cpk = 10;
        this.cpn = 300;
        this.cpo = 500;
        this.cpr = new ArrayList<>();
        this.cpv = false;
        this.cpw = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.coX = 2.0f;
        this.cpf = new Rect();
        this.cpk = 10;
        this.cpn = 300;
        this.cpo = 500;
        this.cpr = new ArrayList<>();
        this.cpv = false;
        this.cpw = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.coZ = null;
        this.cpa = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.cpe = new Scroller(context);
        this.cpj = getResources().getDimensionPixelSize(t.editor_muti_image_upload_scrollview_paddingleft);
        this.mPadding = getResources().getDimensionPixelSize(t.default_gap_24);
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
        this.byf = this.coY == null ? 0 : this.coY.getCount();
        this.byf = Math.min(this.cpk, this.byf);
        if (this.byf <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View ix = ix(0);
            f(ix, i, i2);
            i4 = ix.getMeasuredWidth();
            i3 = ix.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] h = h(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(h[0], i);
                this.cpt = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(h[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.cpc = i;
        this.cpd = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.cpm) {
                this.cpr.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.cpj;
        if (this.cpv) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(t.default_gap_24);
            if (this.byf > 0) {
                View ix = ix(0);
                f(ix, this.cpc, this.cpd);
                paddingLeft = ((getMeasuredWidth() - ix.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.cpm != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.cpj * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.cpm.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.cpm.setLayoutParams(layoutParams);
                f(this.cpm, this.cpc, this.cpd);
                paddingLeft = ((getMeasuredWidth() - this.cpm.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.byf; i7++) {
            View ix2 = ix(i7);
            if (ix2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = ix2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    ix2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(ix2, -1, layoutParams2, true);
                f(ix2, this.cpc, this.cpd);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = ix2.getMeasuredWidth() + i6;
                ix2.layout(i6, paddingTop, measuredWidth2, ix2.getMeasuredHeight() + paddingTop);
                ix2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.cpm != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.cpj * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.cpm.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.cpm.setLayoutParams(layoutParams3);
            f(this.cpm, this.cpc, this.cpd);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.cpm.getMeasuredWidth() + i6;
            this.cpm.layout(i6, paddingTop2, measuredWidth4, this.cpm.getMeasuredHeight() + paddingTop2);
            if (this.byf == this.cpk) {
                i6 = measuredWidth4 - this.cpm.getMeasuredWidth();
                this.cpq = false;
            } else {
                addViewInLayout(this.cpm, -1, this.cpm.getLayoutParams(), true);
                this.cpq = true;
                i6 = measuredWidth4;
            }
        }
        this.mContentWidth = (this.cpj + i6) - this.mPadding;
        if (this.cpl || z) {
            scrollTo(0, 0);
            scrollBy(anc(), 0);
            this.cpl = false;
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
                    if (!this.cpe.isFinished()) {
                        removeCallbacks(this.cpw);
                        this.cpe.forceFinished(true);
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
                    if (!this.cpe.isFinished()) {
                        removeCallbacks(this.cpw);
                        this.cpe.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.cpw);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cpp = i2;
                        this.cpe.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.cpw);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    iy((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.coY = baseAdapter;
        this.mScroller.forceFinished(true);
        this.cpe.forceFinished(true);
        if (!this.cpl && z) {
            this.cpl = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.coY;
    }

    private View ix(int i) {
        View view = null;
        if (this.cpr.size() > 0) {
            view = this.cpr.remove(0);
        }
        View view2 = this.coY.getView(i, view, this);
        if (view2 != view) {
            this.cpr.add(view);
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

    private int[] h(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.coY == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.byf - 1;
        }
        while (i <= i2) {
            View ix = ix(i);
            if (ix.getVisibility() != 8) {
                f(ix, i3, i4);
                paddingRight += ix.getMeasuredWidth();
                paddingTop = Math.max(ix.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int anc() {
        if (canScroll()) {
            return this.mContentWidth - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iy(int i) {
        scrollBy(iz(i), 0);
        invalidate();
    }

    private int iz(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > anc()) {
                i = anc() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.cpu) {
            this.cpu = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.cpb.a(view, null);
            this.coZ = view;
            this.cpa = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.cpg || this.cph) && this.cpb != null) {
                this.cpb.anb();
                return;
            }
            return;
        }
        this.cpg = false;
        this.cph = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(a aVar) {
        this.cpb = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.cpa && (childAt = getChildAt(i)) != this.cpm) {
                childAt.getHitRect(this.cpf);
                if (this.cpf.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.cpa;
                    aj(i2, i);
                    ai(i2, i);
                    this.cpa = i;
                    return;
                }
            }
        }
    }

    private void ai(int i, int i2) {
        if (this.cpi != null) {
            this.cpi.af(i, i2);
        }
    }

    private void aj(int i, int i2) {
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
    public void and() {
        if (!this.cpg) {
            this.cpg = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void ane() {
        if (!this.cph) {
            this.cph = true;
            int anc = anc();
            int scrollX = getScrollX();
            int scrollX2 = anc - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void anf() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.cpg = false;
        this.cph = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void ang() {
        reset();
    }

    public void setOnSwapDataListener(d dVar) {
        this.cpi = dVar;
    }

    public void setMaxItemNum(int i) {
        this.cpk = i;
    }

    public int getMaxItemNum() {
        return this.cpk;
    }

    public void setAddView(View view) {
        this.cpm = view;
    }

    public int ac(View view) {
        this.cps = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.cpq) {
            this.mContentWidth -= measuredWidth;
        } else {
            if (this.cpm != null) {
                addViewInLayout(this.cpm, -1, this.cpm.getLayoutParams(), true);
                this.mContentWidth += this.cpm.getMeasuredWidth();
            }
            this.mContentWidth -= measuredWidth;
            this.cpq = true;
        }
        this.byf--;
        removeViewInLayout(view);
        this.cpr.add(view);
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
        } else if (scrollX > anc()) {
            this.mScroller.startScroll(scrollX, 0, anc() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean anh() {
        return this.cps;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.cpw);
        this.mScroller.forceFinished(true);
        this.cpe.forceFinished(true);
        if (this.coZ != null) {
            this.coZ.setVisibility(0);
            this.coZ = null;
        }
        this.cpa = -1;
        this.cpg = false;
        this.cph = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.cpu = false;
    }

    public void notifyDataSetChanged() {
        this.mScroller.forceFinished(true);
        this.cpe.forceFinished(true);
        requestLayout();
    }

    public void setCenterStart(boolean z) {
        this.cpv = z;
    }
}
