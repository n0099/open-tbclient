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
    private BaseAdapter cFX;
    private int dfR;
    private int dfc;
    private final float gkB;
    private View gkC;
    private int gkD;
    private b gkE;
    private int gkF;
    private int gkG;
    private Scroller gkH;
    private Rect gkI;
    private boolean gkJ;
    private boolean gkK;
    private a gkL;
    private int gkM;
    private int gkN;
    private boolean gkO;
    private View gkP;
    private final int gkQ;
    private final int gkR;
    private boolean gkS;
    private ArrayList<View> gkT;
    private boolean gkU;
    private boolean gkV;
    private boolean gkW;
    private boolean gkX;
    private boolean gkY;
    private Runnable gkZ;
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
        this.gkB = 2.0f;
        this.gkI = new Rect();
        this.gkN = 10;
        this.gkQ = 300;
        this.gkR = 500;
        this.gkT = new ArrayList<>();
        this.gkX = false;
        this.gkY = true;
        this.gkZ = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gkH.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gkH;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.dfR - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.tz(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dfR = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gkH.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gkB = 2.0f;
        this.gkI = new Rect();
        this.gkN = 10;
        this.gkQ = 300;
        this.gkR = 500;
        this.gkT = new ArrayList<>();
        this.gkX = false;
        this.gkY = true;
        this.gkZ = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gkH.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gkH;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.dfR - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tz(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dfR = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gkH.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gkB = 2.0f;
        this.gkI = new Rect();
        this.gkN = 10;
        this.gkQ = 300;
        this.gkR = 500;
        this.gkT = new ArrayList<>();
        this.gkX = false;
        this.gkY = true;
        this.gkZ = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gkH.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gkH;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.dfR - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tz(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dfR = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gkH.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gkC = null;
        this.gkD = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.gkH = new Scroller(context);
        this.gkM = getResources().getDimensionPixelSize(d.f.ds66);
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
        this.mItemCount = this.cFX == null ? 0 : this.cFX.getCount();
        this.mItemCount = Math.min(this.gkN, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View ty = ty(0);
            measureScrapChild(ty, i, i2);
            i4 = ty.getMeasuredWidth();
            i3 = ty.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] t = t(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(t[0], i);
                this.gkV = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(t[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.gkF = i;
        this.dfc = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.gkP) {
                this.gkT.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.gkM;
        if (this.gkX) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds32);
            if (this.mItemCount > 0) {
                View ty = ty(0);
                measureScrapChild(ty, this.gkF, this.dfc);
                paddingLeft = ((getMeasuredWidth() - ty.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.gkP != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.gkM * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.gkP.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.gkP.setLayoutParams(layoutParams);
                measureScrapChild(this.gkP, this.gkF, this.dfc);
                paddingLeft = ((getMeasuredWidth() - this.gkP.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View ty2 = ty(i7);
            if (ty2 != null && ty2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = ty2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    ty2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(ty2, -1, layoutParams2, true);
                measureScrapChild(ty2, this.gkF, this.dfc);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = ty2.getMeasuredWidth() + i6;
                ty2.layout(i6, paddingTop, measuredWidth2, ty2.getMeasuredHeight() + paddingTop);
                ty2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.gkP != null) {
            if (this.gkY) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.gkM * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.gkP.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.gkP.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.gkP, this.gkF, this.dfc);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.gkP.getMeasuredWidth() + i6;
            this.gkP.layout(i6, paddingTop2, measuredWidth4, this.gkP.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.gkN) {
                i6 = measuredWidth4 - this.gkP.getMeasuredWidth();
                this.gkS = false;
            } else {
                addViewInLayout(this.gkP, -1, this.gkP.getLayoutParams(), true);
                this.gkS = true;
                i6 = measuredWidth4;
            }
        }
        this.gkG = (this.gkM + i6) - this.mPadding;
        if (this.gkO || z) {
            scrollTo(0, 0);
            scrollBy(bsT(), 0);
            this.gkO = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.gkG > getMeasuredWidth();
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
                    if (!this.gkH.isFinished()) {
                        removeCallbacks(this.gkZ);
                        this.gkH.forceFinished(true);
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
                    if (!this.gkH.isFinished()) {
                        removeCallbacks(this.gkZ);
                        this.gkH.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.gkZ);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.dfR = i2;
                        this.gkH.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.gkZ);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    tz((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cFX = baseAdapter;
        this.mScroller.forceFinished(true);
        this.gkH.forceFinished(true);
        if (!this.gkO && z) {
            this.gkO = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cFX;
    }

    private View ty(int i) {
        View view = null;
        if (this.gkT.size() > 0) {
            view = this.gkT.remove(0);
        }
        View view2 = this.cFX.getView(i, view, this);
        if (view2 != view) {
            this.gkT.add(view);
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

    private int[] t(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.cFX == null) {
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
            View ty = ty(i);
            if (ty.getVisibility() != 8) {
                measureScrapChild(ty, i3, i4);
                paddingRight += ty.getMeasuredWidth();
                paddingTop = Math.max(ty.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bsT() {
        if (canScroll()) {
            return this.gkG - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tz(int i) {
        scrollBy(tA(i), 0);
        invalidate();
    }

    private int tA(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bsT()) {
                i = bsT() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.gkW) {
            this.gkW = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.gkE.a(view, null);
            this.gkC = view;
            this.gkD = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.gkJ || this.gkK) && this.gkE != null) {
                this.gkE.bsS();
                return;
            }
            return;
        }
        this.gkJ = false;
        this.gkK = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.gkE = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void e(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.gkD && (childAt = getChildAt(i)) != this.gkP) {
                childAt.getHitRect(this.gkI);
                if (this.gkI.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.gkD;
                    bO(i2, i);
                    bN(i2, i);
                    this.gkD = i;
                    return;
                }
            }
        }
    }

    private void bN(int i, int i2) {
        if (this.gkL != null) {
            this.gkL.H(i, i2);
        }
    }

    private void bO(int i, int i2) {
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
    public void bsU() {
        if (!this.gkJ) {
            this.gkJ = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bsV() {
        if (!this.gkK) {
            this.gkK = true;
            int bsT = bsT();
            int scrollX = getScrollX();
            int scrollX2 = bsT - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bsW() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.gkJ = false;
        this.gkK = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bsX() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.gkL = aVar;
    }

    public void setMaxItemNum(int i) {
        this.gkN = i;
    }

    public int getMaxItemNum() {
        return this.gkN;
    }

    public void setAddView(View view) {
        this.gkP = view;
    }

    public int bG(View view) {
        this.gkU = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.gkS) {
            this.gkG -= measuredWidth;
        } else {
            if (this.gkP != null) {
                addViewInLayout(this.gkP, -1, this.gkP.getLayoutParams(), true);
                this.gkG += this.gkP.getMeasuredWidth();
            }
            this.gkG -= measuredWidth;
            this.gkS = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.gkT.add(view);
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
        } else if (scrollX > bsT()) {
            this.mScroller.startScroll(scrollX, 0, bsT() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.gkU = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bsT()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bsT(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.gkV) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bsY() {
        return this.gkU;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.gkZ);
        this.mScroller.forceFinished(true);
        this.gkH.forceFinished(true);
        if (this.gkC != null) {
            this.gkC.setVisibility(0);
            this.gkC = null;
        }
        this.gkD = -1;
        this.gkJ = false;
        this.gkK = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.gkW = false;
    }

    public void setCenterStart(boolean z) {
        this.gkX = z;
    }

    public void setStartEndSpace(int i) {
        this.gkM = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.gkY = z;
    }
}
