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
    private BaseAdapter cQl;
    private int djY;
    private int djj;
    private final float grK;
    private View grL;
    private int grM;
    private b grN;
    private int grO;
    private int grP;
    private Scroller grQ;
    private Rect grR;
    private boolean grS;
    private boolean grT;
    private a grU;
    private int grV;
    private int grW;
    private boolean grX;
    private View grY;
    private final int grZ;
    private final int gsa;
    private boolean gsb;
    private ArrayList<View> gsc;
    private boolean gsd;
    private boolean gse;
    private boolean gsf;
    private boolean gsg;
    private boolean gsh;
    private Runnable gsi;
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
        void I(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.grK = 2.0f;
        this.grR = new Rect();
        this.grW = 10;
        this.grZ = 300;
        this.gsa = 500;
        this.gsc = new ArrayList<>();
        this.gsg = false;
        this.gsh = true;
        this.gsi = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.grQ.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.grQ;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.djY - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.tY(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.djY = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.grQ.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.grK = 2.0f;
        this.grR = new Rect();
        this.grW = 10;
        this.grZ = 300;
        this.gsa = 500;
        this.gsc = new ArrayList<>();
        this.gsg = false;
        this.gsh = true;
        this.gsi = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.grQ.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.grQ;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.djY - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tY(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.djY = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.grQ.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.grK = 2.0f;
        this.grR = new Rect();
        this.grW = 10;
        this.grZ = 300;
        this.gsa = 500;
        this.gsc = new ArrayList<>();
        this.gsg = false;
        this.gsh = true;
        this.gsi = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.grQ.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.grQ;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.djY - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tY(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.djY = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.grQ.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.grL = null;
        this.grM = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.grQ = new Scroller(context);
        this.grV = getResources().getDimensionPixelSize(d.e.ds66);
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
        this.mItemCount = this.cQl == null ? 0 : this.cQl.getCount();
        this.mItemCount = Math.min(this.grW, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View tX = tX(0);
            measureScrapChild(tX, i, i2);
            i4 = tX.getMeasuredWidth();
            i3 = tX.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] z = z(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(z[0], i);
                this.gse = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(z[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.grO = i;
        this.djj = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.grY) {
                this.gsc.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.grV;
        if (this.gsg) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds32);
            if (this.mItemCount > 0) {
                View tX = tX(0);
                measureScrapChild(tX, this.grO, this.djj);
                paddingLeft = ((getMeasuredWidth() - tX.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.grY != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.grV * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.grY.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.grY.setLayoutParams(layoutParams);
                measureScrapChild(this.grY, this.grO, this.djj);
                paddingLeft = ((getMeasuredWidth() - this.grY.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View tX2 = tX(i7);
            if (tX2 != null && tX2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = tX2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    tX2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(tX2, -1, layoutParams2, true);
                measureScrapChild(tX2, this.grO, this.djj);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = tX2.getMeasuredWidth() + i6;
                tX2.layout(i6, paddingTop, measuredWidth2, tX2.getMeasuredHeight() + paddingTop);
                tX2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.grY != null) {
            if (this.gsh) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.grV * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.grY.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.grY.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.grY, this.grO, this.djj);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.grY.getMeasuredWidth() + i6;
            this.grY.layout(i6, paddingTop2, measuredWidth4, this.grY.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.grW) {
                i6 = measuredWidth4 - this.grY.getMeasuredWidth();
                this.gsb = false;
            } else {
                addViewInLayout(this.grY, -1, this.grY.getLayoutParams(), true);
                this.gsb = true;
                i6 = measuredWidth4;
            }
        }
        this.grP = (this.grV + i6) - this.mPadding;
        if (this.grX || z) {
            scrollTo(0, 0);
            scrollBy(bva(), 0);
            this.grX = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.grP > getMeasuredWidth();
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
                    if (!this.grQ.isFinished()) {
                        removeCallbacks(this.gsi);
                        this.grQ.forceFinished(true);
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
                    if (!this.grQ.isFinished()) {
                        removeCallbacks(this.gsi);
                        this.grQ.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.gsi);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.djY = i2;
                        this.grQ.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.gsi);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    tY((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cQl = baseAdapter;
        this.mScroller.forceFinished(true);
        this.grQ.forceFinished(true);
        if (!this.grX && z) {
            this.grX = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cQl;
    }

    private View tX(int i) {
        View view = null;
        if (this.gsc.size() > 0) {
            view = this.gsc.remove(0);
        }
        View view2 = this.cQl.getView(i, view, this);
        if (view2 != view) {
            this.gsc.add(view);
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

    private int[] z(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.cQl == null) {
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
            View tX = tX(i);
            if (tX.getVisibility() != 8) {
                measureScrapChild(tX, i3, i4);
                paddingRight += tX.getMeasuredWidth();
                paddingTop = Math.max(tX.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bva() {
        if (canScroll()) {
            return this.grP - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tY(int i) {
        scrollBy(tZ(i), 0);
        invalidate();
    }

    private int tZ(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bva()) {
                i = bva() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.gsf) {
            this.gsf = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.grN.a(view, null);
            this.grL = view;
            this.grM = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.grS || this.grT) && this.grN != null) {
                this.grN.buZ();
                return;
            }
            return;
        }
        this.grS = false;
        this.grT = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.grN = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void j(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.grM && (childAt = getChildAt(i)) != this.grY) {
                childAt.getHitRect(this.grR);
                if (this.grR.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.grM;
                    bW(i2, i);
                    bV(i2, i);
                    this.grM = i;
                    return;
                }
            }
        }
    }

    private void bV(int i, int i2) {
        if (this.grU != null) {
            this.grU.I(i, i2);
        }
    }

    private void bW(int i, int i2) {
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
    public void bvb() {
        if (!this.grS) {
            this.grS = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bvc() {
        if (!this.grT) {
            this.grT = true;
            int bva = bva();
            int scrollX = getScrollX();
            int scrollX2 = bva - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bvd() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.grS = false;
        this.grT = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bve() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.grU = aVar;
    }

    public void setMaxItemNum(int i) {
        this.grW = i;
    }

    public int getMaxItemNum() {
        return this.grW;
    }

    public void setAddView(View view) {
        this.grY = view;
    }

    public int bK(View view) {
        this.gsd = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.gsb) {
            this.grP -= measuredWidth;
        } else {
            if (this.grY != null) {
                addViewInLayout(this.grY, -1, this.grY.getLayoutParams(), true);
                this.grP += this.grY.getMeasuredWidth();
            }
            this.grP -= measuredWidth;
            this.gsb = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.gsc.add(view);
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
        } else if (scrollX > bva()) {
            this.mScroller.startScroll(scrollX, 0, bva() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.gsd = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bva()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bva(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.gse) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bvf() {
        return this.gsd;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.gsi);
        this.mScroller.forceFinished(true);
        this.grQ.forceFinished(true);
        if (this.grL != null) {
            this.grL.setVisibility(0);
            this.grL = null;
        }
        this.grM = -1;
        this.grS = false;
        this.grT = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.gsf = false;
    }

    public void setCenterStart(boolean z) {
        this.gsg = z;
    }

    public void setStartEndSpace(int i) {
        this.grV = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.gsh = z;
    }
}
