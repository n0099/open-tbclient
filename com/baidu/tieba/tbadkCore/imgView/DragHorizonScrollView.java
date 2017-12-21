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
    private BaseAdapter cZQ;
    private int dtl;
    private Scroller gDA;
    private Rect gDB;
    private boolean gDC;
    private boolean gDD;
    private a gDE;
    private int gDF;
    private int gDG;
    private boolean gDH;
    private View gDI;
    private final int gDJ;
    private final int gDK;
    private boolean gDL;
    private ArrayList<View> gDM;
    private boolean gDN;
    private boolean gDO;
    private boolean gDP;
    private boolean gDQ;
    private boolean gDR;
    private Runnable gDS;
    private final float gDu;
    private View gDv;
    private int gDw;
    private b gDx;
    private int gDy;
    private int gDz;
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
        this.gDu = 2.0f;
        this.gDB = new Rect();
        this.gDG = 10;
        this.gDJ = 300;
        this.gDK = 500;
        this.gDM = new ArrayList<>();
        this.gDQ = false;
        this.gDR = true;
        this.gDS = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gDA.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gDA;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.dtl - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.uz(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dtl = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gDA.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gDu = 2.0f;
        this.gDB = new Rect();
        this.gDG = 10;
        this.gDJ = 300;
        this.gDK = 500;
        this.gDM = new ArrayList<>();
        this.gDQ = false;
        this.gDR = true;
        this.gDS = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gDA.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gDA;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.dtl - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.uz(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dtl = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gDA.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gDu = 2.0f;
        this.gDB = new Rect();
        this.gDG = 10;
        this.gDJ = 300;
        this.gDK = 500;
        this.gDM = new ArrayList<>();
        this.gDQ = false;
        this.gDR = true;
        this.gDS = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gDA.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gDA;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.dtl - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.uz(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dtl = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gDA.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gDv = null;
        this.gDw = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.gDA = new Scroller(context);
        this.gDF = getResources().getDimensionPixelSize(d.e.ds66);
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
        this.mItemCount = this.cZQ == null ? 0 : this.cZQ.getCount();
        this.mItemCount = Math.min(this.gDG, this.mItemCount);
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
                this.gDO = true;
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
        this.gDy = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.gDI) {
                this.gDM.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.gDF;
        if (this.gDQ) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds32);
            if (this.mItemCount > 0) {
                View uy = uy(0);
                measureScrapChild(uy, this.gDy, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - uy.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.gDI != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.gDF * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.gDI.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.gDI.setLayoutParams(layoutParams);
                measureScrapChild(this.gDI, this.gDy, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.gDI.getMeasuredWidth()) + dimensionPixelSize) / 2;
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
                measureScrapChild(uy2, this.gDy, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = uy2.getMeasuredWidth() + i6;
                uy2.layout(i6, paddingTop, measuredWidth2, uy2.getMeasuredHeight() + paddingTop);
                uy2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.gDI != null) {
            if (this.gDR) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.gDF * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.gDI.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.gDI.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.gDI, this.gDy, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.gDI.getMeasuredWidth() + i6;
            this.gDI.layout(i6, paddingTop2, measuredWidth4, this.gDI.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.gDG) {
                i6 = measuredWidth4 - this.gDI.getMeasuredWidth();
                this.gDL = false;
            } else {
                addViewInLayout(this.gDI, -1, this.gDI.getLayoutParams(), true);
                this.gDL = true;
                i6 = measuredWidth4;
            }
        }
        this.gDz = (this.gDF + i6) - this.mPadding;
        if (this.gDH || z) {
            scrollTo(0, 0);
            scrollBy(bxr(), 0);
            this.gDH = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.gDz > getMeasuredWidth();
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
                    if (!this.gDA.isFinished()) {
                        removeCallbacks(this.gDS);
                        this.gDA.forceFinished(true);
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
                    if (!this.gDA.isFinished()) {
                        removeCallbacks(this.gDS);
                        this.gDA.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.gDS);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.dtl = i2;
                        this.gDA.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.gDS);
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
        this.cZQ = baseAdapter;
        this.mScroller.forceFinished(true);
        this.gDA.forceFinished(true);
        if (!this.gDH && z) {
            this.gDH = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cZQ;
    }

    private View uy(int i) {
        View view = null;
        if (this.gDM.size() > 0) {
            view = this.gDM.remove(0);
        }
        View view2 = this.cZQ.getView(i, view, this);
        if (view2 != view) {
            this.gDM.add(view);
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
        if (this.cZQ == null) {
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
            return this.gDz - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
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
        if (!this.gDP) {
            this.gDP = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.gDx.a(view, null);
            this.gDv = view;
            this.gDw = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.gDC || this.gDD) && this.gDx != null) {
                this.gDx.bxq();
                return;
            }
            return;
        }
        this.gDC = false;
        this.gDD = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.gDx = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void j(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.gDw && (childAt = getChildAt(i)) != this.gDI) {
                childAt.getHitRect(this.gDB);
                if (this.gDB.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.gDw;
                    bY(i2, i);
                    bX(i2, i);
                    this.gDw = i;
                    return;
                }
            }
        }
    }

    private void bX(int i, int i2) {
        if (this.gDE != null) {
            this.gDE.H(i, i2);
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
        if (!this.gDC) {
            this.gDC = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bxt() {
        if (!this.gDD) {
            this.gDD = true;
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
        this.gDC = false;
        this.gDD = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bxv() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.gDE = aVar;
    }

    public void setMaxItemNum(int i) {
        this.gDG = i;
    }

    public int getMaxItemNum() {
        return this.gDG;
    }

    public void setAddView(View view) {
        this.gDI = view;
    }

    public int bJ(View view) {
        this.gDN = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.gDL) {
            this.gDz -= measuredWidth;
        } else {
            if (this.gDI != null) {
                addViewInLayout(this.gDI, -1, this.gDI.getLayoutParams(), true);
                this.gDz += this.gDI.getMeasuredWidth();
            }
            this.gDz -= measuredWidth;
            this.gDL = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.gDM.add(view);
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
                DragHorizonScrollView.this.gDN = false;
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
                if (DragHorizonScrollView.this.gDO) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bxw() {
        return this.gDN;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.gDS);
        this.mScroller.forceFinished(true);
        this.gDA.forceFinished(true);
        if (this.gDv != null) {
            this.gDv.setVisibility(0);
            this.gDv = null;
        }
        this.gDw = -1;
        this.gDC = false;
        this.gDD = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.gDP = false;
    }

    public void setCenterStart(boolean z) {
        this.gDQ = z;
    }

    public void setStartEndSpace(int i) {
        this.gDF = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.gDR = z;
    }
}
