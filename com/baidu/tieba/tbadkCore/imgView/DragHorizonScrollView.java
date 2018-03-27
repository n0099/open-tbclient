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
    private int JG;
    private int Tu;
    private final float hcA;
    private BaseAdapter hcB;
    private View hcC;
    private int hcD;
    private b hcE;
    private int hcF;
    private Scroller hcG;
    private Rect hcH;
    private boolean hcI;
    private boolean hcJ;
    private a hcK;
    private int hcL;
    private int hcM;
    private boolean hcN;
    private View hcO;
    private final int hcP;
    private final int hcQ;
    private boolean hcR;
    private ArrayList<View> hcS;
    private boolean hcT;
    private boolean hcU;
    private boolean hcV;
    private boolean hcW;
    private boolean hcX;
    private Runnable hcY;
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
        this.hcA = 2.0f;
        this.hcH = new Rect();
        this.hcM = 10;
        this.hcP = 300;
        this.hcQ = 500;
        this.hcS = new ArrayList<>();
        this.hcW = false;
        this.hcX = true;
        this.hcY = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.hcG.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.hcG;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.Tu - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.vP(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.Tu = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.hcG.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hcA = 2.0f;
        this.hcH = new Rect();
        this.hcM = 10;
        this.hcP = 300;
        this.hcQ = 500;
        this.hcS = new ArrayList<>();
        this.hcW = false;
        this.hcX = true;
        this.hcY = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.hcG.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.hcG;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.Tu - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.vP(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.Tu = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.hcG.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hcA = 2.0f;
        this.hcH = new Rect();
        this.hcM = 10;
        this.hcP = 300;
        this.hcQ = 500;
        this.hcS = new ArrayList<>();
        this.hcW = false;
        this.hcX = true;
        this.hcY = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.hcG.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.hcG;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.Tu - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.vP(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.Tu = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.hcG.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hcC = null;
        this.hcD = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.hcG = new Scroller(context);
        this.hcL = getResources().getDimensionPixelSize(d.e.ds66);
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
        this.mItemCount = this.hcB == null ? 0 : this.hcB.getCount();
        this.mItemCount = Math.min(this.hcM, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View vO = vO(0);
            measureScrapChild(vO, i, i2);
            i4 = vO.getMeasuredWidth();
            i3 = vO.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] G = G(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(G[0], i);
                this.hcU = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(G[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.hcF = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.hcO) {
                this.hcS.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.hcL;
        if (this.hcW) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds32);
            if (this.mItemCount > 0) {
                View vO = vO(0);
                measureScrapChild(vO, this.hcF, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - vO.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.hcO != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.hcL * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.hcO.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.hcO.setLayoutParams(layoutParams);
                measureScrapChild(this.hcO, this.hcF, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.hcO.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View vO2 = vO(i7);
            if (vO2 != null && vO2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = vO2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    vO2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(vO2, -1, layoutParams2, true);
                measureScrapChild(vO2, this.hcF, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = vO2.getMeasuredWidth() + i6;
                vO2.layout(i6, paddingTop, measuredWidth2, vO2.getMeasuredHeight() + paddingTop);
                vO2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.hcO != null) {
            if (this.hcX) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.hcL * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.hcO.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.hcO.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.hcO, this.hcF, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.hcO.getMeasuredWidth() + i6;
            this.hcO.layout(i6, paddingTop2, measuredWidth4, this.hcO.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.hcM) {
                i6 = measuredWidth4 - this.hcO.getMeasuredWidth();
                this.hcR = false;
            } else {
                addViewInLayout(this.hcO, -1, this.hcO.getLayoutParams(), true);
                this.hcR = true;
                i6 = measuredWidth4;
            }
        }
        this.JG = (this.hcL + i6) - this.mPadding;
        if (this.hcN || z) {
            scrollTo(0, 0);
            scrollBy(bxs(), 0);
            this.hcN = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.JG > getMeasuredWidth();
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
                    if (!this.hcG.isFinished()) {
                        removeCallbacks(this.hcY);
                        this.hcG.forceFinished(true);
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
                    if (!this.hcG.isFinished()) {
                        removeCallbacks(this.hcY);
                        this.hcG.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.hcY);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.Tu = i2;
                        this.hcG.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.hcY);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    vP((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.hcB = baseAdapter;
        this.mScroller.forceFinished(true);
        this.hcG.forceFinished(true);
        if (!this.hcN && z) {
            this.hcN = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.hcB;
    }

    private View vO(int i) {
        View view = null;
        if (this.hcS.size() > 0) {
            view = this.hcS.remove(0);
        }
        View view2 = this.hcB.getView(i, view, this);
        if (view2 != view) {
            this.hcS.add(view);
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

    private int[] G(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.hcB == null) {
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
            View vO = vO(i);
            if (vO.getVisibility() != 8) {
                measureScrapChild(vO, i3, i4);
                paddingRight += vO.getMeasuredWidth();
                paddingTop = Math.max(vO.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bxs() {
        if (canScroll()) {
            return this.JG - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vP(int i) {
        scrollBy(vQ(i), 0);
        invalidate();
    }

    private int vQ(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bxs()) {
                i = bxs() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.hcV) {
            this.hcV = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.hcE.a(view, null);
            this.hcC = view;
            this.hcD = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.hcI || this.hcJ) && this.hcE != null) {
                this.hcE.swap();
                return;
            }
            return;
        }
        this.hcI = false;
        this.hcJ = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.hcE = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void o(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.hcD && (childAt = getChildAt(i)) != this.hcO) {
                childAt.getHitRect(this.hcH);
                if (this.hcH.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.hcD;
                    cJ(i2, i);
                    cI(i2, i);
                    this.hcD = i;
                    return;
                }
            }
        }
    }

    private void cI(int i, int i2) {
        if (this.hcK != null) {
            this.hcK.aG(i, i2);
        }
    }

    private void cJ(int i, int i2) {
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
    public void bxt() {
        if (!this.hcI) {
            this.hcI = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bxu() {
        if (!this.hcJ) {
            this.hcJ = true;
            int bxs = bxs();
            int scrollX = getScrollX();
            int scrollX2 = bxs - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bxv() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.hcI = false;
        this.hcJ = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bxw() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.hcK = aVar;
    }

    public void setMaxItemNum(int i) {
        this.hcM = i;
    }

    public int getMaxItemNum() {
        return this.hcM;
    }

    public void setAddView(View view) {
        this.hcO = view;
    }

    public int cQ(View view) {
        this.hcT = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.hcR) {
            this.JG -= measuredWidth;
        } else {
            if (this.hcO != null) {
                addViewInLayout(this.hcO, -1, this.hcO.getLayoutParams(), true);
                this.JG += this.hcO.getMeasuredWidth();
            }
            this.JG -= measuredWidth;
            this.hcR = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.hcS.add(view);
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
        } else if (scrollX > bxs()) {
            this.mScroller.startScroll(scrollX, 0, bxs() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.hcT = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bxs()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bxs(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.hcU) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bxx() {
        return this.hcT;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.hcY);
        this.mScroller.forceFinished(true);
        this.hcG.forceFinished(true);
        if (this.hcC != null) {
            this.hcC.setVisibility(0);
            this.hcC = null;
        }
        this.hcD = -1;
        this.hcI = false;
        this.hcJ = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.hcV = false;
    }

    public void setCenterStart(boolean z) {
        this.hcW = z;
    }

    public void setStartEndSpace(int i) {
        this.hcL = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.hcX = z;
    }
}
