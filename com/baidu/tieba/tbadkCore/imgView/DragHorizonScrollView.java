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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, e, f {
    private BaseAdapter bSO;
    private int cxg;
    private int cym;
    private int czg;
    private final float fmc;
    private View fmd;
    private int fme;
    private com.baidu.tieba.tbadkCore.imgView.a fmf;
    private int fmg;
    private int fmh;
    private Scroller fmi;
    private Rect fmj;
    private boolean fmk;
    private boolean fml;
    private a fmm;
    private int fmn;
    private int fmo;
    private boolean fmp;
    private View fmq;
    private final int fmr;
    private final int fms;
    private boolean fmt;
    private ArrayList<View> fmu;
    private boolean fmv;
    private boolean fmw;
    private boolean fmx;
    private boolean fmy;
    private Runnable fmz;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void B(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.fmc = 2.0f;
        this.fmj = new Rect();
        this.fmo = 10;
        this.fmr = 300;
        this.fms = 500;
        this.fmu = new ArrayList<>();
        this.fmy = false;
        this.fmz = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fmc = 2.0f;
        this.fmj = new Rect();
        this.fmo = 10;
        this.fmr = 300;
        this.fms = 500;
        this.fmu = new ArrayList<>();
        this.fmy = false;
        this.fmz = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmc = 2.0f;
        this.fmj = new Rect();
        this.fmo = 10;
        this.fmr = 300;
        this.fms = 500;
        this.fmu = new ArrayList<>();
        this.fmy = false;
        this.fmz = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.fmd = null;
        this.fme = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.fmi = new Scroller(context);
        this.fmn = getResources().getDimensionPixelSize(u.e.ds66);
        this.mPadding = getResources().getDimensionPixelSize(u.e.ds32);
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
        this.czg = this.bSO == null ? 0 : this.bSO.getCount();
        this.czg = Math.min(this.fmo, this.czg);
        if (this.czg <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View rd = rd(0);
            j(rd, i, i2);
            i4 = rd.getMeasuredWidth();
            i3 = rd.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] r = r(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(r[0], i);
                this.fmw = true;
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
        this.fmg = i;
        this.cxg = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.fmq) {
                this.fmu.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.fmn;
        if (this.fmy) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds32);
            if (this.czg > 0) {
                View rd = rd(0);
                j(rd, this.fmg, this.cxg);
                paddingLeft = ((getMeasuredWidth() - rd.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.fmq != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.fmn * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.fmq.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.fmq.setLayoutParams(layoutParams);
                j(this.fmq, this.fmg, this.cxg);
                paddingLeft = ((getMeasuredWidth() - this.fmq.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.czg; i7++) {
            View rd2 = rd(i7);
            if (rd2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = rd2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    rd2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(rd2, -1, layoutParams2, true);
                j(rd2, this.fmg, this.cxg);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = rd2.getMeasuredWidth() + i6;
                rd2.layout(i6, paddingTop, measuredWidth2, rd2.getMeasuredHeight() + paddingTop);
                rd2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.fmq != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.fmn * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.fmq.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.fmq.setLayoutParams(layoutParams3);
            j(this.fmq, this.fmg, this.cxg);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.fmq.getMeasuredWidth() + i6;
            this.fmq.layout(i6, paddingTop2, measuredWidth4, this.fmq.getMeasuredHeight() + paddingTop2);
            if (this.czg == this.fmo) {
                i6 = measuredWidth4 - this.fmq.getMeasuredWidth();
                this.fmt = false;
            } else {
                addViewInLayout(this.fmq, -1, this.fmq.getLayoutParams(), true);
                this.fmt = true;
                i6 = measuredWidth4;
            }
        }
        this.fmh = (this.fmn + i6) - this.mPadding;
        if (this.fmp || z) {
            scrollTo(0, 0);
            scrollBy(bga(), 0);
            this.fmp = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.fmh > getMeasuredWidth();
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
                    if (!this.fmi.isFinished()) {
                        removeCallbacks(this.fmz);
                        this.fmi.forceFinished(true);
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
                    if (!this.fmi.isFinished()) {
                        removeCallbacks(this.fmz);
                        this.fmi.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.fmz);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cym = i2;
                        this.fmi.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.fmz);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    re((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bSO = baseAdapter;
        this.mScroller.forceFinished(true);
        this.fmi.forceFinished(true);
        if (!this.fmp && z) {
            this.fmp = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bSO;
    }

    private View rd(int i) {
        View view = null;
        if (this.fmu.size() > 0) {
            view = this.fmu.remove(0);
        }
        View view2 = this.bSO.getView(i, view, this);
        if (view2 != view) {
            this.fmu.add(view);
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
        if (this.bSO == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.czg - 1;
        }
        while (i <= i2) {
            View rd = rd(i);
            if (rd.getVisibility() != 8) {
                j(rd, i3, i4);
                paddingRight += rd.getMeasuredWidth();
                paddingTop = Math.max(rd.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bga() {
        if (canScroll()) {
            return this.fmh - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re(int i) {
        scrollBy(rf(i), 0);
        invalidate();
    }

    private int rf(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bga()) {
                i = bga() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.fmx) {
            this.fmx = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.fmf.a(view, null);
            this.fmd = view;
            this.fme = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.fmk || this.fml) && this.fmf != null) {
                this.fmf.bfZ();
                return;
            }
            return;
        }
        this.fmk = false;
        this.fml = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.fmf = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.fme && (childAt = getChildAt(i)) != this.fmq) {
                childAt.getHitRect(this.fmj);
                if (this.fmj.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.fme;
                    bn(i2, i);
                    bm(i2, i);
                    this.fme = i;
                    return;
                }
            }
        }
    }

    private void bm(int i, int i2) {
        if (this.fmm != null) {
            this.fmm.B(i, i2);
        }
    }

    private void bn(int i, int i2) {
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
    public void bgb() {
        if (!this.fmk) {
            this.fmk = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bgc() {
        if (!this.fml) {
            this.fml = true;
            int bga = bga();
            int scrollX = getScrollX();
            int scrollX2 = bga - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bgd() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.fmk = false;
        this.fml = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bge() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.fmm = aVar;
    }

    public void setMaxItemNum(int i) {
        this.fmo = i;
    }

    public int getMaxItemNum() {
        return this.fmo;
    }

    public void setAddView(View view) {
        this.fmq = view;
    }

    public int bs(View view) {
        this.fmv = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.fmt) {
            this.fmh -= measuredWidth;
        } else {
            if (this.fmq != null) {
                addViewInLayout(this.fmq, -1, this.fmq.getLayoutParams(), true);
                this.fmh += this.fmq.getMeasuredWidth();
            }
            this.fmh -= measuredWidth;
            this.fmt = true;
        }
        this.czg--;
        removeViewInLayout(view);
        this.fmu.add(view);
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
        } else if (scrollX > bga()) {
            this.mScroller.startScroll(scrollX, 0, bga() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean bgf() {
        return this.fmv;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.fmz);
        this.mScroller.forceFinished(true);
        this.fmi.forceFinished(true);
        if (this.fmd != null) {
            this.fmd.setVisibility(0);
            this.fmd = null;
        }
        this.fme = -1;
        this.fmk = false;
        this.fml = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.fmx = false;
    }

    public void setCenterStart(boolean z) {
        this.fmy = z;
    }
}
