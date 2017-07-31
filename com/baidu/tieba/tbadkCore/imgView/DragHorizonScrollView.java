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
    private int cVA;
    private int cWp;
    private BaseAdapter cwB;
    private boolean gjA;
    private View gjB;
    private final int gjC;
    private final int gjD;
    private boolean gjE;
    private ArrayList<View> gjF;
    private boolean gjG;
    private boolean gjH;
    private boolean gjI;
    private boolean gjJ;
    private boolean gjK;
    private Runnable gjL;
    private final float gjn;
    private View gjo;
    private int gjp;
    private b gjq;
    private int gjr;
    private int gjs;
    private Scroller gjt;
    private Rect gju;
    private boolean gjv;
    private boolean gjw;
    private a gjx;
    private int gjy;
    private int gjz;
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
        this.gjn = 2.0f;
        this.gju = new Rect();
        this.gjz = 10;
        this.gjC = 300;
        this.gjD = 500;
        this.gjF = new ArrayList<>();
        this.gjJ = false;
        this.gjK = true;
        this.gjL = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gjt.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gjt;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.cWp - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.tl(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.cWp = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gjt.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gjn = 2.0f;
        this.gju = new Rect();
        this.gjz = 10;
        this.gjC = 300;
        this.gjD = 500;
        this.gjF = new ArrayList<>();
        this.gjJ = false;
        this.gjK = true;
        this.gjL = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gjt.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gjt;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.cWp - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tl(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.cWp = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gjt.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gjn = 2.0f;
        this.gju = new Rect();
        this.gjz = 10;
        this.gjC = 300;
        this.gjD = 500;
        this.gjF = new ArrayList<>();
        this.gjJ = false;
        this.gjK = true;
        this.gjL = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gjt.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gjt;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.cWp - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tl(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.cWp = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gjt.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gjo = null;
        this.gjp = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.gjt = new Scroller(context);
        this.gjy = getResources().getDimensionPixelSize(d.f.ds66);
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
        this.mItemCount = this.cwB == null ? 0 : this.cwB.getCount();
        this.mItemCount = Math.min(this.gjz, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View tk = tk(0);
            measureScrapChild(tk, i, i2);
            i4 = tk.getMeasuredWidth();
            i3 = tk.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] v = v(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(v[0], i);
                this.gjH = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(v[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.gjr = i;
        this.cVA = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.gjB) {
                this.gjF.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.gjy;
        if (this.gjJ) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds32);
            if (this.mItemCount > 0) {
                View tk = tk(0);
                measureScrapChild(tk, this.gjr, this.cVA);
                paddingLeft = ((getMeasuredWidth() - tk.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.gjB != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.gjy * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.gjB.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.gjB.setLayoutParams(layoutParams);
                measureScrapChild(this.gjB, this.gjr, this.cVA);
                paddingLeft = ((getMeasuredWidth() - this.gjB.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View tk2 = tk(i7);
            if (tk2 != null && tk2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = tk2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    tk2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(tk2, -1, layoutParams2, true);
                measureScrapChild(tk2, this.gjr, this.cVA);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = tk2.getMeasuredWidth() + i6;
                tk2.layout(i6, paddingTop, measuredWidth2, tk2.getMeasuredHeight() + paddingTop);
                tk2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.gjB != null) {
            if (this.gjK) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.gjy * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.gjB.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.gjB.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.gjB, this.gjr, this.cVA);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.gjB.getMeasuredWidth() + i6;
            this.gjB.layout(i6, paddingTop2, measuredWidth4, this.gjB.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.gjz) {
                i6 = measuredWidth4 - this.gjB.getMeasuredWidth();
                this.gjE = false;
            } else {
                addViewInLayout(this.gjB, -1, this.gjB.getLayoutParams(), true);
                this.gjE = true;
                i6 = measuredWidth4;
            }
        }
        this.gjs = (this.gjy + i6) - this.mPadding;
        if (this.gjA || z) {
            scrollTo(0, 0);
            scrollBy(bsS(), 0);
            this.gjA = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.gjs > getMeasuredWidth();
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
                    if (!this.gjt.isFinished()) {
                        removeCallbacks(this.gjL);
                        this.gjt.forceFinished(true);
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
                    if (!this.gjt.isFinished()) {
                        removeCallbacks(this.gjL);
                        this.gjt.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.gjL);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cWp = i2;
                        this.gjt.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.gjL);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    tl((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cwB = baseAdapter;
        this.mScroller.forceFinished(true);
        this.gjt.forceFinished(true);
        if (!this.gjA && z) {
            this.gjA = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cwB;
    }

    private View tk(int i) {
        View view = null;
        if (this.gjF.size() > 0) {
            view = this.gjF.remove(0);
        }
        View view2 = this.cwB.getView(i, view, this);
        if (view2 != view) {
            this.gjF.add(view);
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

    private int[] v(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.cwB == null) {
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
            View tk = tk(i);
            if (tk.getVisibility() != 8) {
                measureScrapChild(tk, i3, i4);
                paddingRight += tk.getMeasuredWidth();
                paddingTop = Math.max(tk.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bsS() {
        if (canScroll()) {
            return this.gjs - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl(int i) {
        scrollBy(tm(i), 0);
        invalidate();
    }

    private int tm(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bsS()) {
                i = bsS() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.gjI) {
            this.gjI = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.gjq.a(view, null);
            this.gjo = view;
            this.gjp = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.gjv || this.gjw) && this.gjq != null) {
                this.gjq.bsR();
                return;
            }
            return;
        }
        this.gjv = false;
        this.gjw = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.gjq = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void e(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.gjp && (childAt = getChildAt(i)) != this.gjB) {
                childAt.getHitRect(this.gju);
                if (this.gju.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.gjp;
                    bA(i2, i);
                    bz(i2, i);
                    this.gjp = i;
                    return;
                }
            }
        }
    }

    private void bz(int i, int i2) {
        if (this.gjx != null) {
            this.gjx.K(i, i2);
        }
    }

    private void bA(int i, int i2) {
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
    public void bsT() {
        if (!this.gjv) {
            this.gjv = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bsU() {
        if (!this.gjw) {
            this.gjw = true;
            int bsS = bsS();
            int scrollX = getScrollX();
            int scrollX2 = bsS - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bsV() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.gjv = false;
        this.gjw = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bsW() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.gjx = aVar;
    }

    public void setMaxItemNum(int i) {
        this.gjz = i;
    }

    public int getMaxItemNum() {
        return this.gjz;
    }

    public void setAddView(View view) {
        this.gjB = view;
    }

    public int by(View view) {
        this.gjG = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.gjE) {
            this.gjs -= measuredWidth;
        } else {
            if (this.gjB != null) {
                addViewInLayout(this.gjB, -1, this.gjB.getLayoutParams(), true);
                this.gjs += this.gjB.getMeasuredWidth();
            }
            this.gjs -= measuredWidth;
            this.gjE = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.gjF.add(view);
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
        } else if (scrollX > bsS()) {
            this.mScroller.startScroll(scrollX, 0, bsS() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.gjG = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bsS()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bsS(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.gjH) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bsX() {
        return this.gjG;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.gjL);
        this.mScroller.forceFinished(true);
        this.gjt.forceFinished(true);
        if (this.gjo != null) {
            this.gjo.setVisibility(0);
            this.gjo = null;
        }
        this.gjp = -1;
        this.gjv = false;
        this.gjw = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.gjI = false;
    }

    public void setCenterStart(boolean z) {
        this.gjJ = z;
    }

    public void setStartEndSpace(int i) {
        this.gjy = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.gjK = z;
    }
}
