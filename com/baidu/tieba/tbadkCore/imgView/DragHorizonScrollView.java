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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, c, d {
    private Runnable flingRunnable;
    private BaseAdapter mAdapter;
    private int mContentWidth;
    private int mHeightMeasureSpec;
    private int mItemCount;
    private int mLastFlingX;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private final float nyT;
    private View nyU;
    private int nyV;
    private com.baidu.tieba.tbadkCore.imgView.a nyW;
    private int nyX;
    private Scroller nyY;
    private boolean nyZ;
    private boolean nza;
    private a nzb;
    private int nzc;
    private int nzd;
    private boolean nze;
    private View nzf;
    private final int nzg;
    private final int nzh;
    private boolean nzi;
    private ArrayList<View> nzj;
    private boolean nzk;
    private boolean nzl;
    private boolean nzm;
    private boolean nzn;
    private boolean nzo;
    private Rect tempRect;

    /* loaded from: classes.dex */
    public interface a {
        void bc(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.nyT = 2.0f;
        this.tempRect = new Rect();
        this.nzd = 10;
        this.nzg = 300;
        this.nzh = 500;
        this.nzj = new ArrayList<>();
        this.nzn = false;
        this.nzo = true;
        this.flingRunnable = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.nyY.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.nyY;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.JK(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.nyY.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nyT = 2.0f;
        this.tempRect = new Rect();
        this.nzd = 10;
        this.nzg = 300;
        this.nzh = 500;
        this.nzj = new ArrayList<>();
        this.nzn = false;
        this.nzo = true;
        this.flingRunnable = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.nyY.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.nyY;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.JK(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.nyY.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nyT = 2.0f;
        this.tempRect = new Rect();
        this.nzd = 10;
        this.nzg = 300;
        this.nzh = 500;
        this.nzj = new ArrayList<>();
        this.nzn = false;
        this.nzo = true;
        this.flingRunnable = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.nyY.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.nyY;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.JK(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.nyY.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.nyU = null;
        this.nyV = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.nyY = new Scroller(context);
        this.nzc = getResources().getDimensionPixelSize(R.dimen.ds66);
        this.mPadding = getResources().getDimensionPixelSize(R.dimen.ds32);
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
        this.mItemCount = this.mAdapter == null ? 0 : this.mAdapter.getCount();
        this.mItemCount = Math.min(this.nzd, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View JJ = JJ(0);
            measureScrapChild(JJ, i, i2);
            i4 = JJ.getMeasuredWidth();
            i3 = JJ.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] K = K(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(K[0], i);
                this.nzl = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(K[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.nyX = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.nzf) {
                this.nzj.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.nzc;
        if (this.nzn) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds32);
            if (this.mItemCount > 0) {
                View JJ = JJ(0);
                measureScrapChild(JJ, this.nyX, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - JJ.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.nzf != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.nzc * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.nzf.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.nzf.setLayoutParams(layoutParams);
                measureScrapChild(this.nzf, this.nyX, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.nzf.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View JJ2 = JJ(i7);
            if (JJ2 != null && JJ2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = JJ2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    JJ2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(JJ2, -1, layoutParams2, true);
                measureScrapChild(JJ2, this.nyX, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = JJ2.getMeasuredWidth() + i6;
                JJ2.layout(i6, paddingTop, measuredWidth2, JJ2.getMeasuredHeight() + paddingTop);
                JJ2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.nzf != null) {
            if (this.nzo) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.nzc * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.nzf.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.nzf.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.nzf, this.nyX, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.nzf.getMeasuredWidth() + i6;
            this.nzf.layout(i6, paddingTop2, measuredWidth4, this.nzf.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.nzd) {
                i6 = measuredWidth4 - this.nzf.getMeasuredWidth();
                this.nzi = false;
            } else {
                addViewInLayout(this.nzf, -1, this.nzf.getLayoutParams(), true);
                this.nzi = true;
                i6 = measuredWidth4;
            }
        }
        this.mContentWidth = (this.nzc + i6) - this.mPadding;
        if (this.nze || z) {
            scrollTo(0, 0);
            scrollBy(dOa(), 0);
            this.nze = false;
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
                    if (!this.nyY.isFinished()) {
                        removeCallbacks(this.flingRunnable);
                        this.nyY.forceFinished(true);
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
                    if (!this.nyY.isFinished()) {
                        removeCallbacks(this.flingRunnable);
                        this.nyY.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.flingRunnable);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.mLastFlingX = i2;
                        this.nyY.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.flingRunnable);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    JK((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void setAdapter(BaseAdapter baseAdapter, boolean z) {
        this.mAdapter = baseAdapter;
        this.mScroller.forceFinished(true);
        this.nyY.forceFinished(true);
        if (!this.nze && z) {
            this.nze = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.mAdapter;
    }

    private View JJ(int i) {
        View view = null;
        if (this.nzj.size() > 0) {
            view = this.nzj.remove(0);
        }
        View view2 = this.mAdapter.getView(i, view, this);
        if (view2 != view) {
            this.nzj.add(view);
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

    private int[] K(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.mAdapter == null) {
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
            View JJ = JJ(i);
            if (JJ.getVisibility() != 8) {
                measureScrapChild(JJ, i3, i4);
                paddingRight += JJ.getMeasuredWidth();
                paddingTop = Math.max(JJ.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int dOa() {
        if (canScroll()) {
            return this.mContentWidth - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JK(int i) {
        scrollBy(JL(i), 0);
        invalidate();
    }

    private int JL(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > dOa()) {
                i = dOa() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.nzm) {
            this.nzm = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.nyW.b(view, null);
            this.nyU = view;
            this.nyV = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.nyZ || this.nza) && this.nyW != null) {
                this.nyW.dNZ();
                return;
            }
            return;
        }
        this.nyZ = false;
        this.nza = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.c
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.nyW = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void i(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.nyV && (childAt = getChildAt(i)) != this.nzf) {
                childAt.getHitRect(this.tempRect);
                if (this.tempRect.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.nyV;
                    dv(i2, i);
                    du(i2, i);
                    this.nyV = i;
                    return;
                }
            }
        }
    }

    private void du(int i, int i2) {
        if (this.nzb != null) {
            this.nzb.bc(i, i2);
        }
    }

    private void dv(int i, int i2) {
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

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void dOb() {
        if (!this.nyZ) {
            this.nyZ = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void dOc() {
        if (!this.nza) {
            this.nza = true;
            int dOa = dOa();
            int scrollX = getScrollX();
            int scrollX2 = dOa - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void dOd() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.nyZ = false;
        this.nza = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void dOe() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.nzb = aVar;
    }

    public void setMaxItemNum(int i) {
        this.nzd = i;
    }

    public int getMaxItemNum() {
        return this.nzd;
    }

    public void setAddView(View view) {
        this.nzf = view;
    }

    public int ej(View view) {
        this.nzk = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.nzi) {
            this.mContentWidth -= measuredWidth;
        } else {
            if (this.nzf != null) {
                addViewInLayout(this.nzf, -1, this.nzf.getLayoutParams(), true);
                this.mContentWidth += this.nzf.getMeasuredWidth();
            }
            this.mContentWidth -= measuredWidth;
            this.nzi = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.nzj.add(view);
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
        } else if (scrollX > dOa()) {
            this.mScroller.startScroll(scrollX, 0, dOa() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.nzk = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.dOa()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.dOa(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.nzl) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean dOf() {
        return this.nzk;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.flingRunnable);
        this.mScroller.forceFinished(true);
        this.nyY.forceFinished(true);
        if (this.nyU != null) {
            this.nyU.setVisibility(0);
            this.nyU = null;
        }
        this.nyV = -1;
        this.nyZ = false;
        this.nza = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.nzm = false;
    }

    public void setCenterStart(boolean z) {
        this.nzn = z;
    }

    public void setStartEndSpace(int i) {
        this.nzc = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.nzo = z;
    }
}
