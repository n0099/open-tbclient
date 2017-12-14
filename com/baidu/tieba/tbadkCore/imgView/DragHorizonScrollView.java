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
    private BaseAdapter cZM;
    private int dth;
    private int gDA;
    private int gDB;
    private boolean gDC;
    private View gDD;
    private final int gDE;
    private final int gDF;
    private boolean gDG;
    private ArrayList<View> gDH;
    private boolean gDI;
    private boolean gDJ;
    private boolean gDK;
    private boolean gDL;
    private boolean gDM;
    private Runnable gDN;
    private final float gDp;
    private View gDq;
    private int gDr;
    private b gDs;
    private int gDt;
    private int gDu;
    private Scroller gDv;
    private Rect gDw;
    private boolean gDx;
    private boolean gDy;
    private a gDz;
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
        void H(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.gDp = 2.0f;
        this.gDw = new Rect();
        this.gDB = 10;
        this.gDE = 300;
        this.gDF = 500;
        this.gDH = new ArrayList<>();
        this.gDL = false;
        this.gDM = true;
        this.gDN = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gDv.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gDv;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.dth - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.uz(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dth = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gDv.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gDp = 2.0f;
        this.gDw = new Rect();
        this.gDB = 10;
        this.gDE = 300;
        this.gDF = 500;
        this.gDH = new ArrayList<>();
        this.gDL = false;
        this.gDM = true;
        this.gDN = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gDv.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gDv;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.dth - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.uz(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dth = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gDv.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gDp = 2.0f;
        this.gDw = new Rect();
        this.gDB = 10;
        this.gDE = 300;
        this.gDF = 500;
        this.gDH = new ArrayList<>();
        this.gDL = false;
        this.gDM = true;
        this.gDN = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gDv.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gDv;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.dth - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.uz(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dth = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gDv.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gDq = null;
        this.gDr = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.gDv = new Scroller(context);
        this.gDA = getResources().getDimensionPixelSize(d.e.ds66);
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
        this.mItemCount = this.cZM == null ? 0 : this.cZM.getCount();
        this.mItemCount = Math.min(this.gDB, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View uy = uy(0);
            measureScrapChild(uy, i, i2);
            i4 = uy.getMeasuredWidth();
            i3 = uy.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] z = z(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(z[0], i);
                this.gDJ = true;
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
        this.gDt = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.gDD) {
                this.gDH.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.gDA;
        if (this.gDL) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds32);
            if (this.mItemCount > 0) {
                View uy = uy(0);
                measureScrapChild(uy, this.gDt, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - uy.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.gDD != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.gDA * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.gDD.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.gDD.setLayoutParams(layoutParams);
                measureScrapChild(this.gDD, this.gDt, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.gDD.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View uy2 = uy(i7);
            if (uy2 != null && uy2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = uy2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    uy2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(uy2, -1, layoutParams2, true);
                measureScrapChild(uy2, this.gDt, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = uy2.getMeasuredWidth() + i6;
                uy2.layout(i6, paddingTop, measuredWidth2, uy2.getMeasuredHeight() + paddingTop);
                uy2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.gDD != null) {
            if (this.gDM) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.gDA * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.gDD.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.gDD.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.gDD, this.gDt, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.gDD.getMeasuredWidth() + i6;
            this.gDD.layout(i6, paddingTop2, measuredWidth4, this.gDD.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.gDB) {
                i6 = measuredWidth4 - this.gDD.getMeasuredWidth();
                this.gDG = false;
            } else {
                addViewInLayout(this.gDD, -1, this.gDD.getLayoutParams(), true);
                this.gDG = true;
                i6 = measuredWidth4;
            }
        }
        this.gDu = (this.gDA + i6) - this.mPadding;
        if (this.gDC || z) {
            scrollTo(0, 0);
            scrollBy(bxr(), 0);
            this.gDC = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.gDu > getMeasuredWidth();
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
                    if (!this.gDv.isFinished()) {
                        removeCallbacks(this.gDN);
                        this.gDv.forceFinished(true);
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
                    if (!this.gDv.isFinished()) {
                        removeCallbacks(this.gDN);
                        this.gDv.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.gDN);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.dth = i2;
                        this.gDv.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.gDN);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    uz((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cZM = baseAdapter;
        this.mScroller.forceFinished(true);
        this.gDv.forceFinished(true);
        if (!this.gDC && z) {
            this.gDC = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cZM;
    }

    private View uy(int i) {
        View view = null;
        if (this.gDH.size() > 0) {
            view = this.gDH.remove(0);
        }
        View view2 = this.cZM.getView(i, view, this);
        if (view2 != view) {
            this.gDH.add(view);
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
        if (this.cZM == null) {
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
            View uy = uy(i);
            if (uy.getVisibility() != 8) {
                measureScrapChild(uy, i3, i4);
                paddingRight += uy.getMeasuredWidth();
                paddingTop = Math.max(uy.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bxr() {
        if (canScroll()) {
            return this.gDu - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uz(int i) {
        scrollBy(uA(i), 0);
        invalidate();
    }

    private int uA(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bxr()) {
                i = bxr() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.gDK) {
            this.gDK = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.gDs.a(view, null);
            this.gDq = view;
            this.gDr = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.gDx || this.gDy) && this.gDs != null) {
                this.gDs.bxq();
                return;
            }
            return;
        }
        this.gDx = false;
        this.gDy = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.gDs = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void j(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.gDr && (childAt = getChildAt(i)) != this.gDD) {
                childAt.getHitRect(this.gDw);
                if (this.gDw.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.gDr;
                    bY(i2, i);
                    bX(i2, i);
                    this.gDr = i;
                    return;
                }
            }
        }
    }

    private void bX(int i, int i2) {
        if (this.gDz != null) {
            this.gDz.H(i, i2);
        }
    }

    private void bY(int i, int i2) {
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
    public void bxs() {
        if (!this.gDx) {
            this.gDx = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bxt() {
        if (!this.gDy) {
            this.gDy = true;
            int bxr = bxr();
            int scrollX = getScrollX();
            int scrollX2 = bxr - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bxu() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.gDx = false;
        this.gDy = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bxv() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.gDz = aVar;
    }

    public void setMaxItemNum(int i) {
        this.gDB = i;
    }

    public int getMaxItemNum() {
        return this.gDB;
    }

    public void setAddView(View view) {
        this.gDD = view;
    }

    public int bI(View view) {
        this.gDI = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.gDG) {
            this.gDu -= measuredWidth;
        } else {
            if (this.gDD != null) {
                addViewInLayout(this.gDD, -1, this.gDD.getLayoutParams(), true);
                this.gDu += this.gDD.getMeasuredWidth();
            }
            this.gDu -= measuredWidth;
            this.gDG = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.gDH.add(view);
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
        } else if (scrollX > bxr()) {
            this.mScroller.startScroll(scrollX, 0, bxr() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.gDI = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bxr()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bxr(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.gDJ) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bxw() {
        return this.gDI;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.gDN);
        this.mScroller.forceFinished(true);
        this.gDv.forceFinished(true);
        if (this.gDq != null) {
            this.gDq.setVisibility(0);
            this.gDq = null;
        }
        this.gDr = -1;
        this.gDx = false;
        this.gDy = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.gDK = false;
    }

    public void setCenterStart(boolean z) {
        this.gDL = z;
    }

    public void setStartEndSpace(int i) {
        this.gDA = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.gDM = z;
    }
}
