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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, d, e {
    private int JM;
    private int TB;
    private BaseAdapter dQJ;
    private ArrayList<View> hkA;
    private boolean hkB;
    private boolean hkC;
    private boolean hkD;
    private boolean hkE;
    private boolean hkF;
    private Runnable hkG;
    private final float hkj;
    private View hkk;
    private int hkl;
    private b hkm;
    private int hkn;
    private Scroller hko;
    private Rect hkp;
    private boolean hkq;
    private boolean hkr;
    private a hks;
    private int hkt;
    private int hku;
    private boolean hkv;
    private View hkw;
    private final int hkx;
    private final int hky;
    private boolean hkz;
    private int mHeightMeasureSpec;
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
        void aG(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.hkj = 2.0f;
        this.hkp = new Rect();
        this.hku = 10;
        this.hkx = 300;
        this.hky = 500;
        this.hkA = new ArrayList<>();
        this.hkE = false;
        this.hkF = true;
        this.hkG = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.hko.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.hko;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.TB - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.xm(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.TB = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.hko.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hkj = 2.0f;
        this.hkp = new Rect();
        this.hku = 10;
        this.hkx = 300;
        this.hky = 500;
        this.hkA = new ArrayList<>();
        this.hkE = false;
        this.hkF = true;
        this.hkG = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.hko.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.hko;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.TB - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.xm(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.TB = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.hko.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hkj = 2.0f;
        this.hkp = new Rect();
        this.hku = 10;
        this.hkx = 300;
        this.hky = 500;
        this.hkA = new ArrayList<>();
        this.hkE = false;
        this.hkF = true;
        this.hkG = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.hko.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.hko;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.TB - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.xm(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.TB = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.hko.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hkk = null;
        this.hkl = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.hko = new Scroller(context);
        this.hkt = getResources().getDimensionPixelSize(d.e.ds66);
        this.mPadding = getResources().getDimensionPixelSize(d.e.ds32);
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
        this.mItemCount = this.dQJ == null ? 0 : this.dQJ.getCount();
        this.mItemCount = Math.min(this.hku, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View xl = xl(0);
            measureScrapChild(xl, i, i2);
            i4 = xl.getMeasuredWidth();
            i3 = xl.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] H = H(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(H[0], i);
                this.hkC = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(H[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.hkn = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.hkw) {
                this.hkA.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.hkt;
        if (this.hkE) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds32);
            if (this.mItemCount > 0) {
                View xl = xl(0);
                measureScrapChild(xl, this.hkn, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - xl.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.hkw != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.hkt * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.hkw.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.hkw.setLayoutParams(layoutParams);
                measureScrapChild(this.hkw, this.hkn, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.hkw.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View xl2 = xl(i7);
            if (xl2 != null && xl2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = xl2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    xl2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(xl2, -1, layoutParams2, true);
                measureScrapChild(xl2, this.hkn, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = xl2.getMeasuredWidth() + i6;
                xl2.layout(i6, paddingTop, measuredWidth2, xl2.getMeasuredHeight() + paddingTop);
                xl2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.hkw != null) {
            if (this.hkF) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.hkt * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.hkw.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.hkw.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.hkw, this.hkn, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.hkw.getMeasuredWidth() + i6;
            this.hkw.layout(i6, paddingTop2, measuredWidth4, this.hkw.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.hku) {
                i6 = measuredWidth4 - this.hkw.getMeasuredWidth();
                this.hkz = false;
            } else {
                addViewInLayout(this.hkw, -1, this.hkw.getLayoutParams(), true);
                this.hkz = true;
                i6 = measuredWidth4;
            }
        }
        this.JM = (this.hkt + i6) - this.mPadding;
        if (this.hkv || z) {
            scrollTo(0, 0);
            scrollBy(bCH(), 0);
            this.hkv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.JM > getMeasuredWidth();
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
                    if (!this.hko.isFinished()) {
                        removeCallbacks(this.hkG);
                        this.hko.forceFinished(true);
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
                    if (!this.hko.isFinished()) {
                        removeCallbacks(this.hkG);
                        this.hko.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.hkG);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.TB = i2;
                        this.hko.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.hkG);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    xm((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.dQJ = baseAdapter;
        this.mScroller.forceFinished(true);
        this.hko.forceFinished(true);
        if (!this.hkv && z) {
            this.hkv = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.dQJ;
    }

    private View xl(int i) {
        View view = null;
        if (this.hkA.size() > 0) {
            view = this.hkA.remove(0);
        }
        View view2 = this.dQJ.getView(i, view, this);
        if (view2 != view) {
            this.hkA.add(view);
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

    private int[] H(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.dQJ == null) {
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
            View xl = xl(i);
            if (xl.getVisibility() != 8) {
                measureScrapChild(xl, i3, i4);
                paddingRight += xl.getMeasuredWidth();
                paddingTop = Math.max(xl.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bCH() {
        if (canScroll()) {
            return this.JM - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xm(int i) {
        scrollBy(xn(i), 0);
        invalidate();
    }

    private int xn(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bCH()) {
                i = bCH() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.hkD) {
            this.hkD = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.hkm.a(view, null);
            this.hkk = view;
            this.hkl = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.hkq || this.hkr) && this.hkm != null) {
                this.hkm.swap();
                return;
            }
            return;
        }
        this.hkq = false;
        this.hkr = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.hkm = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void n(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.hkl && (childAt = getChildAt(i)) != this.hkw) {
                childAt.getHitRect(this.hkp);
                if (this.hkp.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.hkl;
                    cV(i2, i);
                    cU(i2, i);
                    this.hkl = i;
                    return;
                }
            }
        }
    }

    private void cU(int i, int i2) {
        if (this.hks != null) {
            this.hks.aG(i, i2);
        }
    }

    private void cV(int i, int i2) {
        if (i != i2) {
            View childAt = getChildAt(i);
            View childAt2 = getChildAt(i2);
            if (childAt != null && childAt2 != null) {
                if (i < i2) {
                    detachViewFromParent(i);
                    int i3 = -childAt.getMeasuredWidth();
                    int left = childAt2.getLeft() - childAt.getLeft();
                    while (i < i2) {
                        View childAt3 = getChildAt(i);
                        if (childAt3 != null) {
                            childAt3.offsetLeftAndRight(i3);
                            TranslateAnimation translateAnimation = new TranslateAnimation(-i3, 0.0f, 0.0f, 0.0f);
                            translateAnimation.setDuration(300L);
                            translateAnimation.setFillAfter(true);
                            childAt3.startAnimation(translateAnimation);
                        }
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
                    if (childAt4 != null) {
                        childAt4.offsetLeftAndRight(measuredWidth);
                        TranslateAnimation translateAnimation2 = new TranslateAnimation(-measuredWidth, 0.0f, 0.0f, 0.0f);
                        translateAnimation2.setDuration(300L);
                        translateAnimation2.setFillAfter(true);
                        childAt4.startAnimation(translateAnimation2);
                    }
                }
                attachViewToParent(childAt, i2, childAt.getLayoutParams());
                childAt.offsetLeftAndRight(left2);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bCI() {
        if (!this.hkq) {
            this.hkq = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bCJ() {
        if (!this.hkr) {
            this.hkr = true;
            int bCH = bCH();
            int scrollX = getScrollX();
            int scrollX2 = bCH - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bCK() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.hkq = false;
        this.hkr = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bCL() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.hks = aVar;
    }

    public void setMaxItemNum(int i) {
        this.hku = i;
    }

    public int getMaxItemNum() {
        return this.hku;
    }

    public void setAddView(View view) {
        this.hkw = view;
    }

    public int cU(View view) {
        this.hkB = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.hkz) {
            this.JM -= measuredWidth;
        } else {
            if (this.hkw != null) {
                addViewInLayout(this.hkw, -1, this.hkw.getLayoutParams(), true);
                this.JM += this.hkw.getMeasuredWidth();
            }
            this.JM -= measuredWidth;
            this.hkz = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.hkA.add(view);
        int childCount = getChildCount();
        if (childCount > 1) {
            for (int i = indexOfChild; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt != null) {
                    childAt.offsetLeftAndRight(-measuredWidth);
                    TranslateAnimation translateAnimation = new TranslateAnimation(measuredWidth, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(500L);
                    translateAnimation.setFillAfter(true);
                    childAt.startAnimation(translateAnimation);
                }
            }
        }
        int scrollX = getScrollX();
        if (!canScroll()) {
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, 500);
            postInvalidate();
        } else if (scrollX > bCH()) {
            this.mScroller.startScroll(scrollX, 0, bCH() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.hkB = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bCH()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bCH(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.hkC) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bCM() {
        return this.hkB;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.hkG);
        this.mScroller.forceFinished(true);
        this.hko.forceFinished(true);
        if (this.hkk != null) {
            this.hkk.setVisibility(0);
            this.hkk = null;
        }
        this.hkl = -1;
        this.hkq = false;
        this.hkr = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.hkD = false;
    }

    public void setCenterStart(boolean z) {
        this.hkE = z;
    }

    public void setStartEndSpace(int i) {
        this.hkt = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.hkF = z;
    }
}
