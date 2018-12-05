package com.baidu.tieba.tbadkCore.imgView;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ActivityChooserView;
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
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, c, d {
    private View bGo;
    private final float hmQ;
    private View hmR;
    private int hmS;
    private com.baidu.tieba.tbadkCore.imgView.a hmT;
    private int hmU;
    private Scroller hmV;
    private Rect hmW;
    private boolean hmX;
    private boolean hmY;
    private a hmZ;
    private int hna;
    private int hnb;
    private boolean hnc;
    private final int hnd;
    private final int hne;
    private boolean hnf;
    private ArrayList<View> hng;
    private boolean hnh;
    private boolean hni;
    private boolean hnj;
    private boolean hnk;
    private boolean hnl;
    private Runnable hnm;
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

    /* loaded from: classes.dex */
    public interface a {
        void J(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.hmQ = 2.0f;
        this.hmW = new Rect();
        this.hnb = 10;
        this.hnd = 300;
        this.hne = 500;
        this.hng = new ArrayList<>();
        this.hnk = false;
        this.hnl = true;
        this.hnm = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.hmV.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.hmV;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.vy(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.hmV.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hmQ = 2.0f;
        this.hmW = new Rect();
        this.hnb = 10;
        this.hnd = 300;
        this.hne = 500;
        this.hng = new ArrayList<>();
        this.hnk = false;
        this.hnl = true;
        this.hnm = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.hmV.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.hmV;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.vy(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.hmV.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hmQ = 2.0f;
        this.hmW = new Rect();
        this.hnb = 10;
        this.hnd = 300;
        this.hne = 500;
        this.hng = new ArrayList<>();
        this.hnk = false;
        this.hnl = true;
        this.hnm = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.hmV.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.hmV;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.mLastFlingX - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.vy(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.mLastFlingX = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.hmV.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hmR = null;
        this.hmS = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.hmV = new Scroller(context);
        this.hna = getResources().getDimensionPixelSize(e.C0210e.ds66);
        this.mPadding = getResources().getDimensionPixelSize(e.C0210e.ds32);
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
        this.mItemCount = Math.min(this.hnb, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View vx = vx(0);
            measureScrapChild(vx, i, i2);
            i4 = vx.getMeasuredWidth();
            i3 = vx.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] y = y(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(y[0], i);
                this.hni = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(y[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.hmU = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.bGo) {
                this.hng.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.hna;
        if (this.hnk) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds32);
            if (this.mItemCount > 0) {
                View vx = vx(0);
                measureScrapChild(vx, this.hmU, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - vx.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.bGo != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.hna * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.bGo.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.bGo.setLayoutParams(layoutParams);
                measureScrapChild(this.bGo, this.hmU, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.bGo.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View vx2 = vx(i7);
            if (vx2 != null && vx2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = vx2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    vx2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(vx2, -1, layoutParams2, true);
                measureScrapChild(vx2, this.hmU, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = vx2.getMeasuredWidth() + i6;
                vx2.layout(i6, paddingTop, measuredWidth2, vx2.getMeasuredHeight() + paddingTop);
                vx2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.bGo != null) {
            if (this.hnl) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.hna * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.bGo.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.bGo.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.bGo, this.hmU, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.bGo.getMeasuredWidth() + i6;
            this.bGo.layout(i6, paddingTop2, measuredWidth4, this.bGo.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.hnb) {
                i6 = measuredWidth4 - this.bGo.getMeasuredWidth();
                this.hnf = false;
            } else {
                addViewInLayout(this.bGo, -1, this.bGo.getLayoutParams(), true);
                this.hnf = true;
                i6 = measuredWidth4;
            }
        }
        this.mContentWidth = (this.hna + i6) - this.mPadding;
        if (this.hnc || z) {
            scrollTo(0, 0);
            scrollBy(bDM(), 0);
            this.hnc = false;
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
                    if (!this.hmV.isFinished()) {
                        removeCallbacks(this.hnm);
                        this.hmV.forceFinished(true);
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
                    if (!this.hmV.isFinished()) {
                        removeCallbacks(this.hnm);
                        this.hmV.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.hnm);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.mLastFlingX = i2;
                        this.hmV.fling(i2, 0, i, 0, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                        post(this.hnm);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    vy((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void setAdapter(BaseAdapter baseAdapter, boolean z) {
        this.mAdapter = baseAdapter;
        this.mScroller.forceFinished(true);
        this.hmV.forceFinished(true);
        if (!this.hnc && z) {
            this.hnc = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.mAdapter;
    }

    private View vx(int i) {
        View view = null;
        if (this.hng.size() > 0) {
            view = this.hng.remove(0);
        }
        View view2 = this.mAdapter.getView(i, view, this);
        if (view2 != view) {
            this.hng.add(view);
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

    private int[] y(int i, int i2, int i3, int i4) {
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
            View vx = vx(i);
            if (vx.getVisibility() != 8) {
                measureScrapChild(vx, i3, i4);
                paddingRight += vx.getMeasuredWidth();
                paddingTop = Math.max(vx.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bDM() {
        if (canScroll()) {
            return this.mContentWidth - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vy(int i) {
        scrollBy(vz(i), 0);
        invalidate();
    }

    private int vz(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bDM()) {
                i = bDM() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.hnj) {
            this.hnj = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.hmT.b(view, null);
            this.hmR = view;
            this.hmS = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.hmX || this.hmY) && this.hmT != null) {
                this.hmT.swap();
                return;
            }
            return;
        }
        this.hmX = false;
        this.hmY = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.c
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.hmT = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void m(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.hmS && (childAt = getChildAt(i)) != this.bGo) {
                childAt.getHitRect(this.hmW);
                if (this.hmW.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.hmS;
                    bT(i2, i);
                    bS(i2, i);
                    this.hmS = i;
                    return;
                }
            }
        }
    }

    private void bS(int i, int i2) {
        if (this.hmZ != null) {
            this.hmZ.J(i, i2);
        }
    }

    private void bT(int i, int i2) {
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
    public void bDN() {
        if (!this.hmX) {
            this.hmX = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void bDO() {
        if (!this.hmY) {
            this.hmY = true;
            int bDM = bDM();
            int scrollX = getScrollX();
            int scrollX2 = bDM - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void bDP() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.hmX = false;
        this.hmY = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void bDQ() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.hmZ = aVar;
    }

    public void setMaxItemNum(int i) {
        this.hnb = i;
    }

    public int getMaxItemNum() {
        return this.hnb;
    }

    public void setAddView(View view) {
        this.bGo = view;
    }

    public int bR(View view) {
        this.hnh = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.hnf) {
            this.mContentWidth -= measuredWidth;
        } else {
            if (this.bGo != null) {
                addViewInLayout(this.bGo, -1, this.bGo.getLayoutParams(), true);
                this.mContentWidth += this.bGo.getMeasuredWidth();
            }
            this.mContentWidth -= measuredWidth;
            this.hnf = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.hng.add(view);
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
        } else if (scrollX > bDM()) {
            this.mScroller.startScroll(scrollX, 0, bDM() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.hnh = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bDM()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bDM(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.hni) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bDR() {
        return this.hnh;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.hnm);
        this.mScroller.forceFinished(true);
        this.hmV.forceFinished(true);
        if (this.hmR != null) {
            this.hmR.setVisibility(0);
            this.hmR = null;
        }
        this.hmS = -1;
        this.hmX = false;
        this.hmY = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.hnj = false;
    }

    public void setCenterStart(boolean z) {
        this.hnk = z;
    }

    public void setStartEndSpace(int i) {
        this.hna = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.hnl = z;
    }
}
