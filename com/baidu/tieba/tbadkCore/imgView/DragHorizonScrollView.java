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
    private int cXz;
    private int cYo;
    private BaseAdapter cyC;
    private boolean glA;
    private boolean glB;
    private boolean glC;
    private Runnable glD;
    private final float glf;
    private View glg;
    private int glh;
    private b gli;
    private int glj;
    private int glk;
    private Scroller gll;
    private Rect glm;
    private boolean gln;
    private boolean glo;
    private a glp;
    private int glq;
    private int glr;
    private boolean gls;
    private View glt;
    private final int glu;
    private final int glv;
    private boolean glw;
    private ArrayList<View> glx;
    private boolean gly;
    private boolean glz;
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
        void K(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.glf = 2.0f;
        this.glm = new Rect();
        this.glr = 10;
        this.glu = 300;
        this.glv = 500;
        this.glx = new ArrayList<>();
        this.glB = false;
        this.glC = true;
        this.glD = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gll.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gll;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.cYo - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.tv(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.cYo = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gll.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.glf = 2.0f;
        this.glm = new Rect();
        this.glr = 10;
        this.glu = 300;
        this.glv = 500;
        this.glx = new ArrayList<>();
        this.glB = false;
        this.glC = true;
        this.glD = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gll.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gll;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.cYo - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tv(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.cYo = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gll.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.glf = 2.0f;
        this.glm = new Rect();
        this.glr = 10;
        this.glu = 300;
        this.glv = 500;
        this.glx = new ArrayList<>();
        this.glB = false;
        this.glC = true;
        this.glD = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gll.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gll;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.cYo - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tv(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.cYo = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gll.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.glg = null;
        this.glh = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.gll = new Scroller(context);
        this.glq = getResources().getDimensionPixelSize(d.f.ds66);
        this.mPadding = getResources().getDimensionPixelSize(d.f.ds32);
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
        this.mItemCount = this.cyC == null ? 0 : this.cyC.getCount();
        this.mItemCount = Math.min(this.glr, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View tu = tu(0);
            measureScrapChild(tu, i, i2);
            i4 = tu.getMeasuredWidth();
            i3 = tu.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] w = w(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(w[0], i);
                this.glz = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(w[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.glj = i;
        this.cXz = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.glt) {
                this.glx.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.glq;
        if (this.glB) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds32);
            if (this.mItemCount > 0) {
                View tu = tu(0);
                measureScrapChild(tu, this.glj, this.cXz);
                paddingLeft = ((getMeasuredWidth() - tu.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.glt != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.glq * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.glt.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.glt.setLayoutParams(layoutParams);
                measureScrapChild(this.glt, this.glj, this.cXz);
                paddingLeft = ((getMeasuredWidth() - this.glt.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View tu2 = tu(i7);
            if (tu2 != null && tu2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = tu2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    tu2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(tu2, -1, layoutParams2, true);
                measureScrapChild(tu2, this.glj, this.cXz);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = tu2.getMeasuredWidth() + i6;
                tu2.layout(i6, paddingTop, measuredWidth2, tu2.getMeasuredHeight() + paddingTop);
                tu2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.glt != null) {
            if (this.glC) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.glq * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.glt.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.glt.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.glt, this.glj, this.cXz);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.glt.getMeasuredWidth() + i6;
            this.glt.layout(i6, paddingTop2, measuredWidth4, this.glt.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.glr) {
                i6 = measuredWidth4 - this.glt.getMeasuredWidth();
                this.glw = false;
            } else {
                addViewInLayout(this.glt, -1, this.glt.getLayoutParams(), true);
                this.glw = true;
                i6 = measuredWidth4;
            }
        }
        this.glk = (this.glq + i6) - this.mPadding;
        if (this.gls || z) {
            scrollTo(0, 0);
            scrollBy(btA(), 0);
            this.gls = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.glk > getMeasuredWidth();
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
                    if (!this.gll.isFinished()) {
                        removeCallbacks(this.glD);
                        this.gll.forceFinished(true);
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
                    if (!this.gll.isFinished()) {
                        removeCallbacks(this.glD);
                        this.gll.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.glD);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cYo = i2;
                        this.gll.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.glD);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    tv((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cyC = baseAdapter;
        this.mScroller.forceFinished(true);
        this.gll.forceFinished(true);
        if (!this.gls && z) {
            this.gls = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cyC;
    }

    private View tu(int i) {
        View view = null;
        if (this.glx.size() > 0) {
            view = this.glx.remove(0);
        }
        View view2 = this.cyC.getView(i, view, this);
        if (view2 != view) {
            this.glx.add(view);
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

    private int[] w(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.cyC == null) {
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
            View tu = tu(i);
            if (tu.getVisibility() != 8) {
                measureScrapChild(tu, i3, i4);
                paddingRight += tu.getMeasuredWidth();
                paddingTop = Math.max(tu.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int btA() {
        if (canScroll()) {
            return this.glk - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tv(int i) {
        scrollBy(tw(i), 0);
        invalidate();
    }

    private int tw(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > btA()) {
                i = btA() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.glA) {
            this.glA = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.gli.a(view, null);
            this.glg = view;
            this.glh = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.gln || this.glo) && this.gli != null) {
                this.gli.btz();
                return;
            }
            return;
        }
        this.gln = false;
        this.glo = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.gli = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void e(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.glh && (childAt = getChildAt(i)) != this.glt) {
                childAt.getHitRect(this.glm);
                if (this.glm.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.glh;
                    bI(i2, i);
                    bH(i2, i);
                    this.glh = i;
                    return;
                }
            }
        }
    }

    private void bH(int i, int i2) {
        if (this.glp != null) {
            this.glp.K(i, i2);
        }
    }

    private void bI(int i, int i2) {
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
    public void btB() {
        if (!this.gln) {
            this.gln = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void btC() {
        if (!this.glo) {
            this.glo = true;
            int btA = btA();
            int scrollX = getScrollX();
            int scrollX2 = btA - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void btD() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.gln = false;
        this.glo = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void btE() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.glp = aVar;
    }

    public void setMaxItemNum(int i) {
        this.glr = i;
    }

    public int getMaxItemNum() {
        return this.glr;
    }

    public void setAddView(View view) {
        this.glt = view;
    }

    public int bA(View view) {
        this.gly = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.glw) {
            this.glk -= measuredWidth;
        } else {
            if (this.glt != null) {
                addViewInLayout(this.glt, -1, this.glt.getLayoutParams(), true);
                this.glk += this.glt.getMeasuredWidth();
            }
            this.glk -= measuredWidth;
            this.glw = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.glx.add(view);
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
        } else if (scrollX > btA()) {
            this.mScroller.startScroll(scrollX, 0, btA() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.gly = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.btA()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.btA(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.glz) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean btF() {
        return this.gly;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.glD);
        this.mScroller.forceFinished(true);
        this.gll.forceFinished(true);
        if (this.glg != null) {
            this.glg.setVisibility(0);
            this.glg = null;
        }
        this.glh = -1;
        this.gln = false;
        this.glo = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.glA = false;
    }

    public void setCenterStart(boolean z) {
        this.glB = z;
    }

    public void setStartEndSpace(int i) {
        this.glq = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.glC = z;
    }
}
