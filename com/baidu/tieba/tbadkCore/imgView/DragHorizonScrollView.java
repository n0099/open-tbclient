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
    private BaseAdapter cZA;
    private int dsc;
    private final float gAG;
    private View gAH;
    private int gAI;
    private b gAJ;
    private int gAK;
    private int gAL;
    private Scroller gAM;
    private Rect gAN;
    private boolean gAO;
    private boolean gAP;
    private a gAQ;
    private int gAR;
    private int gAS;
    private boolean gAT;
    private View gAU;
    private final int gAV;
    private final int gAW;
    private boolean gAX;
    private ArrayList<View> gAY;
    private boolean gAZ;
    private boolean gBa;
    private boolean gBb;
    private boolean gBc;
    private boolean gBd;
    private Runnable gBe;
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
        void G(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.gAG = 2.0f;
        this.gAN = new Rect();
        this.gAS = 10;
        this.gAV = 300;
        this.gAW = 500;
        this.gAY = new ArrayList<>();
        this.gBc = false;
        this.gBd = true;
        this.gBe = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gAM.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gAM;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.dsc - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.uo(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dsc = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gAM.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAG = 2.0f;
        this.gAN = new Rect();
        this.gAS = 10;
        this.gAV = 300;
        this.gAW = 500;
        this.gAY = new ArrayList<>();
        this.gBc = false;
        this.gBd = true;
        this.gBe = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gAM.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gAM;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.dsc - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.uo(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dsc = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gAM.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gAG = 2.0f;
        this.gAN = new Rect();
        this.gAS = 10;
        this.gAV = 300;
        this.gAW = 500;
        this.gAY = new ArrayList<>();
        this.gBc = false;
        this.gBd = true;
        this.gBe = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gAM.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gAM;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.dsc - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.uo(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dsc = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gAM.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gAH = null;
        this.gAI = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.gAM = new Scroller(context);
        this.gAR = getResources().getDimensionPixelSize(d.e.ds66);
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
        this.mItemCount = this.cZA == null ? 0 : this.cZA.getCount();
        this.mItemCount = Math.min(this.gAS, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View un = un(0);
            measureScrapChild(un, i, i2);
            i4 = un.getMeasuredWidth();
            i3 = un.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] z = z(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(z[0], i);
                this.gBa = true;
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
        this.gAK = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.gAU) {
                this.gAY.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.gAR;
        if (this.gBc) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds32);
            if (this.mItemCount > 0) {
                View un = un(0);
                measureScrapChild(un, this.gAK, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - un.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.gAU != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.gAR * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.gAU.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.gAU.setLayoutParams(layoutParams);
                measureScrapChild(this.gAU, this.gAK, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.gAU.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View un2 = un(i7);
            if (un2 != null && un2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = un2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    un2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(un2, -1, layoutParams2, true);
                measureScrapChild(un2, this.gAK, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = un2.getMeasuredWidth() + i6;
                un2.layout(i6, paddingTop, measuredWidth2, un2.getMeasuredHeight() + paddingTop);
                un2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.gAU != null) {
            if (this.gBd) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.gAR * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.gAU.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.gAU.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.gAU, this.gAK, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.gAU.getMeasuredWidth() + i6;
            this.gAU.layout(i6, paddingTop2, measuredWidth4, this.gAU.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.gAS) {
                i6 = measuredWidth4 - this.gAU.getMeasuredWidth();
                this.gAX = false;
            } else {
                addViewInLayout(this.gAU, -1, this.gAU.getLayoutParams(), true);
                this.gAX = true;
                i6 = measuredWidth4;
            }
        }
        this.gAL = (this.gAR + i6) - this.mPadding;
        if (this.gAT || z) {
            scrollTo(0, 0);
            scrollBy(bwK(), 0);
            this.gAT = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.gAL > getMeasuredWidth();
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
                    if (!this.gAM.isFinished()) {
                        removeCallbacks(this.gBe);
                        this.gAM.forceFinished(true);
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
                    if (!this.gAM.isFinished()) {
                        removeCallbacks(this.gBe);
                        this.gAM.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.gBe);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.dsc = i2;
                        this.gAM.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.gBe);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    uo((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cZA = baseAdapter;
        this.mScroller.forceFinished(true);
        this.gAM.forceFinished(true);
        if (!this.gAT && z) {
            this.gAT = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cZA;
    }

    private View un(int i) {
        View view = null;
        if (this.gAY.size() > 0) {
            view = this.gAY.remove(0);
        }
        View view2 = this.cZA.getView(i, view, this);
        if (view2 != view) {
            this.gAY.add(view);
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
        if (this.cZA == null) {
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
            View un = un(i);
            if (un.getVisibility() != 8) {
                measureScrapChild(un, i3, i4);
                paddingRight += un.getMeasuredWidth();
                paddingTop = Math.max(un.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bwK() {
        if (canScroll()) {
            return this.gAL - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo(int i) {
        scrollBy(up(i), 0);
        invalidate();
    }

    private int up(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bwK()) {
                i = bwK() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.gBb) {
            this.gBb = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.gAJ.a(view, null);
            this.gAH = view;
            this.gAI = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.gAO || this.gAP) && this.gAJ != null) {
                this.gAJ.bwJ();
                return;
            }
            return;
        }
        this.gAO = false;
        this.gAP = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.gAJ = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void j(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.gAI && (childAt = getChildAt(i)) != this.gAU) {
                childAt.getHitRect(this.gAN);
                if (this.gAN.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.gAI;
                    bX(i2, i);
                    bW(i2, i);
                    this.gAI = i;
                    return;
                }
            }
        }
    }

    private void bW(int i, int i2) {
        if (this.gAQ != null) {
            this.gAQ.G(i, i2);
        }
    }

    private void bX(int i, int i2) {
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
    public void bwL() {
        if (!this.gAO) {
            this.gAO = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bwM() {
        if (!this.gAP) {
            this.gAP = true;
            int bwK = bwK();
            int scrollX = getScrollX();
            int scrollX2 = bwK - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bwN() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.gAO = false;
        this.gAP = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bwO() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.gAQ = aVar;
    }

    public void setMaxItemNum(int i) {
        this.gAS = i;
    }

    public int getMaxItemNum() {
        return this.gAS;
    }

    public void setAddView(View view) {
        this.gAU = view;
    }

    public int bF(View view) {
        this.gAZ = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.gAX) {
            this.gAL -= measuredWidth;
        } else {
            if (this.gAU != null) {
                addViewInLayout(this.gAU, -1, this.gAU.getLayoutParams(), true);
                this.gAL += this.gAU.getMeasuredWidth();
            }
            this.gAL -= measuredWidth;
            this.gAX = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.gAY.add(view);
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
        } else if (scrollX > bwK()) {
            this.mScroller.startScroll(scrollX, 0, bwK() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.gAZ = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bwK()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bwK(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.gBa) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bwP() {
        return this.gAZ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.gBe);
        this.mScroller.forceFinished(true);
        this.gAM.forceFinished(true);
        if (this.gAH != null) {
            this.gAH.setVisibility(0);
            this.gAH = null;
        }
        this.gAI = -1;
        this.gAO = false;
        this.gAP = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.gBb = false;
    }

    public void setCenterStart(boolean z) {
        this.gBc = z;
    }

    public void setStartEndSpace(int i) {
        this.gAR = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.gBd = z;
    }
}
