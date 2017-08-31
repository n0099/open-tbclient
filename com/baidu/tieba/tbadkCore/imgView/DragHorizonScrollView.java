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
    private BaseAdapter cFf;
    private int deW;
    private int deg;
    private final float gjH;
    private View gjI;
    private int gjJ;
    private b gjK;
    private int gjL;
    private int gjM;
    private Scroller gjN;
    private Rect gjO;
    private boolean gjP;
    private boolean gjQ;
    private a gjR;
    private int gjS;
    private int gjT;
    private boolean gjU;
    private View gjV;
    private final int gjW;
    private final int gjX;
    private boolean gjY;
    private ArrayList<View> gjZ;
    private boolean gka;
    private boolean gkb;
    private boolean gkc;
    private boolean gkd;
    private boolean gke;
    private Runnable gkf;
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
        this.gjH = 2.0f;
        this.gjO = new Rect();
        this.gjT = 10;
        this.gjW = 300;
        this.gjX = 500;
        this.gjZ = new ArrayList<>();
        this.gkd = false;
        this.gke = true;
        this.gkf = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gjN.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gjN;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.deW - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.tx(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.deW = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gjN.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjH = 2.0f;
        this.gjO = new Rect();
        this.gjT = 10;
        this.gjW = 300;
        this.gjX = 500;
        this.gjZ = new ArrayList<>();
        this.gkd = false;
        this.gke = true;
        this.gkf = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gjN.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gjN;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.deW - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tx(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.deW = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gjN.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjH = 2.0f;
        this.gjO = new Rect();
        this.gjT = 10;
        this.gjW = 300;
        this.gjX = 500;
        this.gjZ = new ArrayList<>();
        this.gkd = false;
        this.gke = true;
        this.gkf = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gjN.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gjN;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.deW - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tx(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.deW = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gjN.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gjI = null;
        this.gjJ = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.gjN = new Scroller(context);
        this.gjS = getResources().getDimensionPixelSize(d.f.ds66);
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
        this.mItemCount = this.cFf == null ? 0 : this.cFf.getCount();
        this.mItemCount = Math.min(this.gjT, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View tw = tw(0);
            measureScrapChild(tw, i, i2);
            i4 = tw.getMeasuredWidth();
            i3 = tw.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] t = t(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(t[0], i);
                this.gkb = true;
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
        this.gjL = i;
        this.deg = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.gjV) {
                this.gjZ.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.gjS;
        if (this.gkd) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds32);
            if (this.mItemCount > 0) {
                View tw = tw(0);
                measureScrapChild(tw, this.gjL, this.deg);
                paddingLeft = ((getMeasuredWidth() - tw.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.gjV != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.gjS * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.gjV.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.gjV.setLayoutParams(layoutParams);
                measureScrapChild(this.gjV, this.gjL, this.deg);
                paddingLeft = ((getMeasuredWidth() - this.gjV.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View tw2 = tw(i7);
            if (tw2 != null && tw2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = tw2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    tw2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(tw2, -1, layoutParams2, true);
                measureScrapChild(tw2, this.gjL, this.deg);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = tw2.getMeasuredWidth() + i6;
                tw2.layout(i6, paddingTop, measuredWidth2, tw2.getMeasuredHeight() + paddingTop);
                tw2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.gjV != null) {
            if (this.gke) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.gjS * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.gjV.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.gjV.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.gjV, this.gjL, this.deg);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.gjV.getMeasuredWidth() + i6;
            this.gjV.layout(i6, paddingTop2, measuredWidth4, this.gjV.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.gjT) {
                i6 = measuredWidth4 - this.gjV.getMeasuredWidth();
                this.gjY = false;
            } else {
                addViewInLayout(this.gjV, -1, this.gjV.getLayoutParams(), true);
                this.gjY = true;
                i6 = measuredWidth4;
            }
        }
        this.gjM = (this.gjS + i6) - this.mPadding;
        if (this.gjU || z) {
            scrollTo(0, 0);
            scrollBy(bsI(), 0);
            this.gjU = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.gjM > getMeasuredWidth();
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
                    if (!this.gjN.isFinished()) {
                        removeCallbacks(this.gkf);
                        this.gjN.forceFinished(true);
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
                    if (!this.gjN.isFinished()) {
                        removeCallbacks(this.gkf);
                        this.gjN.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.gkf);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.deW = i2;
                        this.gjN.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.gkf);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    tx((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cFf = baseAdapter;
        this.mScroller.forceFinished(true);
        this.gjN.forceFinished(true);
        if (!this.gjU && z) {
            this.gjU = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cFf;
    }

    private View tw(int i) {
        View view = null;
        if (this.gjZ.size() > 0) {
            view = this.gjZ.remove(0);
        }
        View view2 = this.cFf.getView(i, view, this);
        if (view2 != view) {
            this.gjZ.add(view);
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
        if (this.cFf == null) {
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
            View tw = tw(i);
            if (tw.getVisibility() != 8) {
                measureScrapChild(tw, i3, i4);
                paddingRight += tw.getMeasuredWidth();
                paddingTop = Math.max(tw.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bsI() {
        if (canScroll()) {
            return this.gjM - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tx(int i) {
        scrollBy(ty(i), 0);
        invalidate();
    }

    private int ty(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bsI()) {
                i = bsI() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.gkc) {
            this.gkc = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.gjK.a(view, null);
            this.gjI = view;
            this.gjJ = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.gjP || this.gjQ) && this.gjK != null) {
                this.gjK.bsH();
                return;
            }
            return;
        }
        this.gjP = false;
        this.gjQ = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.gjK = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void e(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.gjJ && (childAt = getChildAt(i)) != this.gjV) {
                childAt.getHitRect(this.gjO);
                if (this.gjO.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.gjJ;
                    bK(i2, i);
                    bJ(i2, i);
                    this.gjJ = i;
                    return;
                }
            }
        }
    }

    private void bJ(int i, int i2) {
        if (this.gjR != null) {
            this.gjR.H(i, i2);
        }
    }

    private void bK(int i, int i2) {
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
    public void bsJ() {
        if (!this.gjP) {
            this.gjP = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bsK() {
        if (!this.gjQ) {
            this.gjQ = true;
            int bsI = bsI();
            int scrollX = getScrollX();
            int scrollX2 = bsI - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bsL() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.gjP = false;
        this.gjQ = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bsM() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.gjR = aVar;
    }

    public void setMaxItemNum(int i) {
        this.gjT = i;
    }

    public int getMaxItemNum() {
        return this.gjT;
    }

    public void setAddView(View view) {
        this.gjV = view;
    }

    public int bG(View view) {
        this.gka = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.gjY) {
            this.gjM -= measuredWidth;
        } else {
            if (this.gjV != null) {
                addViewInLayout(this.gjV, -1, this.gjV.getLayoutParams(), true);
                this.gjM += this.gjV.getMeasuredWidth();
            }
            this.gjM -= measuredWidth;
            this.gjY = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.gjZ.add(view);
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
        } else if (scrollX > bsI()) {
            this.mScroller.startScroll(scrollX, 0, bsI() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.gka = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bsI()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bsI(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.gkb) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bsN() {
        return this.gka;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.gkf);
        this.mScroller.forceFinished(true);
        this.gjN.forceFinished(true);
        if (this.gjI != null) {
            this.gjI.setVisibility(0);
            this.gjI = null;
        }
        this.gjJ = -1;
        this.gjP = false;
        this.gjQ = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.gkc = false;
    }

    public void setCenterStart(boolean z) {
        this.gkd = z;
    }

    public void setStartEndSpace(int i) {
        this.gjS = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.gke = z;
    }
}
