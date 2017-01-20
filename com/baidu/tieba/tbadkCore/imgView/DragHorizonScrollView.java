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
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, f, g {
    private BaseAdapter bTR;
    private int cBb;
    private int cCi;
    private int cDd;
    private final float fra;
    private View frb;
    private int frc;
    private b frd;
    private int fre;
    private int frf;
    private Scroller frg;
    private Rect frh;
    private boolean fri;
    private boolean frj;
    private a frk;
    private int frl;
    private int frm;
    private boolean frn;
    private View fro;
    private final int frp;
    private final int frq;
    private boolean frr;
    private ArrayList<View> frt;
    private boolean fru;
    private boolean frv;
    private boolean frw;
    private boolean frx;
    private Runnable fry;
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
        this.fra = 2.0f;
        this.frh = new Rect();
        this.frm = 10;
        this.frp = 300;
        this.frq = 500;
        this.frt = new ArrayList<>();
        this.frx = false;
        this.fry = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fra = 2.0f;
        this.frh = new Rect();
        this.frm = 10;
        this.frp = 300;
        this.frq = 500;
        this.frt = new ArrayList<>();
        this.frx = false;
        this.fry = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fra = 2.0f;
        this.frh = new Rect();
        this.frm = 10;
        this.frp = 300;
        this.frq = 500;
        this.frt = new ArrayList<>();
        this.frx = false;
        this.fry = new c(this);
        init(context);
    }

    private void init(Context context) {
        this.frb = null;
        this.frc = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.frg = new Scroller(context);
        this.frl = getResources().getDimensionPixelSize(r.f.ds66);
        this.mPadding = getResources().getDimensionPixelSize(r.f.ds32);
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
        this.cDd = this.bTR == null ? 0 : this.bTR.getCount();
        this.cDd = Math.min(this.frm, this.cDd);
        if (this.cDd <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View rX = rX(0);
            j(rX, i, i2);
            i4 = rX.getMeasuredWidth();
            i3 = rX.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] r = r(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(r[0], i);
                this.frv = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(r[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.fre = i;
        this.cBb = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.fro) {
                this.frt.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.frl;
        if (this.frx) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(r.f.ds32);
            if (this.cDd > 0) {
                View rX = rX(0);
                j(rX, this.fre, this.cBb);
                paddingLeft = ((getMeasuredWidth() - rX.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.fro != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.frl * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.fro.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.fro.setLayoutParams(layoutParams);
                j(this.fro, this.fre, this.cBb);
                paddingLeft = ((getMeasuredWidth() - this.fro.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.cDd; i7++) {
            View rX2 = rX(i7);
            if (rX2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = rX2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    rX2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(rX2, -1, layoutParams2, true);
                j(rX2, this.fre, this.cBb);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = rX2.getMeasuredWidth() + i6;
                rX2.layout(i6, paddingTop, measuredWidth2, rX2.getMeasuredHeight() + paddingTop);
                rX2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.fro != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.frl * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.fro.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.fro.setLayoutParams(layoutParams3);
            j(this.fro, this.fre, this.cBb);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.fro.getMeasuredWidth() + i6;
            this.fro.layout(i6, paddingTop2, measuredWidth4, this.fro.getMeasuredHeight() + paddingTop2);
            if (this.cDd == this.frm) {
                i6 = measuredWidth4 - this.fro.getMeasuredWidth();
                this.frr = false;
            } else {
                addViewInLayout(this.fro, -1, this.fro.getLayoutParams(), true);
                this.frr = true;
                i6 = measuredWidth4;
            }
        }
        this.frf = (this.frl + i6) - this.mPadding;
        if (this.frn || z) {
            scrollTo(0, 0);
            scrollBy(bih(), 0);
            this.frn = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.frf > getMeasuredWidth();
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
                    if (!this.frg.isFinished()) {
                        removeCallbacks(this.fry);
                        this.frg.forceFinished(true);
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
                    if (!this.frg.isFinished()) {
                        removeCallbacks(this.fry);
                        this.frg.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.fry);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cCi = i2;
                        this.frg.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.fry);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    rY((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bTR = baseAdapter;
        this.mScroller.forceFinished(true);
        this.frg.forceFinished(true);
        if (!this.frn && z) {
            this.frn = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bTR;
    }

    private View rX(int i) {
        View view = null;
        if (this.frt.size() > 0) {
            view = this.frt.remove(0);
        }
        View view2 = this.bTR.getView(i, view, this);
        if (view2 != view) {
            this.frt.add(view);
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

    private int[] r(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.bTR == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.cDd - 1;
        }
        while (i <= i2) {
            View rX = rX(i);
            if (rX.getVisibility() != 8) {
                j(rX, i3, i4);
                paddingRight += rX.getMeasuredWidth();
                paddingTop = Math.max(rX.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bih() {
        if (canScroll()) {
            return this.frf - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rY(int i) {
        scrollBy(rZ(i), 0);
        invalidate();
    }

    private int rZ(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bih()) {
                i = bih() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.frw) {
            this.frw = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.frd.a(view, null);
            this.frb = view;
            this.frc = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.fri || this.frj) && this.frd != null) {
                this.frd.big();
                return;
            }
            return;
        }
        this.fri = false;
        this.frj = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(b bVar) {
        this.frd = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void e(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.frc && (childAt = getChildAt(i)) != this.fro) {
                childAt.getHitRect(this.frh);
                if (this.frh.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.frc;
                    bp(i2, i);
                    bo(i2, i);
                    this.frc = i;
                    return;
                }
            }
        }
    }

    private void bo(int i, int i2) {
        if (this.frk != null) {
            this.frk.E(i, i2);
        }
    }

    private void bp(int i, int i2) {
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
    public void bii() {
        if (!this.fri) {
            this.fri = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bij() {
        if (!this.frj) {
            this.frj = true;
            int bih = bih();
            int scrollX = getScrollX();
            int scrollX2 = bih - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bik() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.fri = false;
        this.frj = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bil() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.frk = aVar;
    }

    public void setMaxItemNum(int i) {
        this.frm = i;
    }

    public int getMaxItemNum() {
        return this.frm;
    }

    public void setAddView(View view) {
        this.fro = view;
    }

    public int br(View view) {
        this.fru = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.frr) {
            this.frf -= measuredWidth;
        } else {
            if (this.fro != null) {
                addViewInLayout(this.fro, -1, this.fro.getLayoutParams(), true);
                this.frf += this.fro.getMeasuredWidth();
            }
            this.frf -= measuredWidth;
            this.frr = true;
        }
        this.cDd--;
        removeViewInLayout(view);
        this.frt.add(view);
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
        } else if (scrollX > bih()) {
            this.mScroller.startScroll(scrollX, 0, bih() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new d(this), 500L);
        return indexOfChild;
    }

    public boolean bim() {
        return this.fru;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.fry);
        this.mScroller.forceFinished(true);
        this.frg.forceFinished(true);
        if (this.frb != null) {
            this.frb.setVisibility(0);
            this.frb = null;
        }
        this.frc = -1;
        this.fri = false;
        this.frj = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.frw = false;
    }

    public void setCenterStart(boolean z) {
        this.frx = z;
    }
}
