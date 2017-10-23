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
    private BaseAdapter cGE;
    private int dbP;
    private int dba;
    private final float ghV;
    private View ghW;
    private int ghX;
    private b ghY;
    private int ghZ;
    private int gia;
    private Scroller gib;
    private Rect gic;
    private boolean gie;
    private boolean gif;
    private a gig;
    private int gih;
    private int gii;
    private boolean gij;
    private View gik;
    private final int gil;
    private final int gim;
    private boolean gin;
    private ArrayList<View> gio;
    private boolean gip;
    private boolean giq;
    private boolean gir;
    private boolean gis;
    private boolean git;
    private Runnable giu;
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
        this.ghV = 2.0f;
        this.gic = new Rect();
        this.gii = 10;
        this.gil = 300;
        this.gim = 500;
        this.gio = new ArrayList<>();
        this.gis = false;
        this.git = true;
        this.giu = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gib.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gib;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.dbP - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.tD(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dbP = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gib.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ghV = 2.0f;
        this.gic = new Rect();
        this.gii = 10;
        this.gil = 300;
        this.gim = 500;
        this.gio = new ArrayList<>();
        this.gis = false;
        this.git = true;
        this.giu = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gib.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gib;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.dbP - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tD(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dbP = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gib.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ghV = 2.0f;
        this.gic = new Rect();
        this.gii = 10;
        this.gil = 300;
        this.gim = 500;
        this.gio = new ArrayList<>();
        this.gis = false;
        this.git = true;
        this.giu = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gib.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gib;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.dbP - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.tD(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.dbP = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.gib.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.ghW = null;
        this.ghX = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.gib = new Scroller(context);
        this.gih = getResources().getDimensionPixelSize(d.f.ds66);
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
        this.mItemCount = this.cGE == null ? 0 : this.cGE.getCount();
        this.mItemCount = Math.min(this.gii, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View tC = tC(0);
            measureScrapChild(tC, i, i2);
            i4 = tC.getMeasuredWidth();
            i3 = tC.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] w = w(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(w[0], i);
                this.giq = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(w[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.ghZ = i;
        this.dba = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.gik) {
                this.gio.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.gih;
        if (this.gis) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds32);
            if (this.mItemCount > 0) {
                View tC = tC(0);
                measureScrapChild(tC, this.ghZ, this.dba);
                paddingLeft = ((getMeasuredWidth() - tC.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.gik != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.gih * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.gik.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.gik.setLayoutParams(layoutParams);
                measureScrapChild(this.gik, this.ghZ, this.dba);
                paddingLeft = ((getMeasuredWidth() - this.gik.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View tC2 = tC(i7);
            if (tC2 != null && tC2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = tC2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    tC2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(tC2, -1, layoutParams2, true);
                measureScrapChild(tC2, this.ghZ, this.dba);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = tC2.getMeasuredWidth() + i6;
                tC2.layout(i6, paddingTop, measuredWidth2, tC2.getMeasuredHeight() + paddingTop);
                tC2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.gik != null) {
            if (this.git) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.gih * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.gik.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.gik.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.gik, this.ghZ, this.dba);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.gik.getMeasuredWidth() + i6;
            this.gik.layout(i6, paddingTop2, measuredWidth4, this.gik.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.gii) {
                i6 = measuredWidth4 - this.gik.getMeasuredWidth();
                this.gin = false;
            } else {
                addViewInLayout(this.gik, -1, this.gik.getLayoutParams(), true);
                this.gin = true;
                i6 = measuredWidth4;
            }
        }
        this.gia = (this.gih + i6) - this.mPadding;
        if (this.gij || z) {
            scrollTo(0, 0);
            scrollBy(brK(), 0);
            this.gij = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.gia > getMeasuredWidth();
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
                    if (!this.gib.isFinished()) {
                        removeCallbacks(this.giu);
                        this.gib.forceFinished(true);
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
                    if (!this.gib.isFinished()) {
                        removeCallbacks(this.giu);
                        this.gib.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.giu);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.dbP = i2;
                        this.gib.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.giu);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    tD((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cGE = baseAdapter;
        this.mScroller.forceFinished(true);
        this.gib.forceFinished(true);
        if (!this.gij && z) {
            this.gij = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cGE;
    }

    private View tC(int i) {
        View view = null;
        if (this.gio.size() > 0) {
            view = this.gio.remove(0);
        }
        View view2 = this.cGE.getView(i, view, this);
        if (view2 != view) {
            this.gio.add(view);
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

    private int[] w(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.cGE == null) {
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
            View tC = tC(i);
            if (tC.getVisibility() != 8) {
                measureScrapChild(tC, i3, i4);
                paddingRight += tC.getMeasuredWidth();
                paddingTop = Math.max(tC.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int brK() {
        if (canScroll()) {
            return this.gia - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tD(int i) {
        scrollBy(tE(i), 0);
        invalidate();
    }

    private int tE(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > brK()) {
                i = brK() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.gir) {
            this.gir = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.ghY.a(view, null);
            this.ghW = view;
            this.ghX = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.gie || this.gif) && this.ghY != null) {
                this.ghY.brJ();
                return;
            }
            return;
        }
        this.gie = false;
        this.gif = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.ghY = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void i(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.ghX && (childAt = getChildAt(i)) != this.gik) {
                childAt.getHitRect(this.gic);
                if (this.gic.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.ghX;
                    bV(i2, i);
                    bU(i2, i);
                    this.ghX = i;
                    return;
                }
            }
        }
    }

    private void bU(int i, int i2) {
        if (this.gig != null) {
            this.gig.I(i, i2);
        }
    }

    private void bV(int i, int i2) {
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
    public void brL() {
        if (!this.gie) {
            this.gie = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void brM() {
        if (!this.gif) {
            this.gif = true;
            int brK = brK();
            int scrollX = getScrollX();
            int scrollX2 = brK - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void brN() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.gie = false;
        this.gif = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void brO() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.gig = aVar;
    }

    public void setMaxItemNum(int i) {
        this.gii = i;
    }

    public int getMaxItemNum() {
        return this.gii;
    }

    public void setAddView(View view) {
        this.gik = view;
    }

    public int bG(View view) {
        this.gip = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.gin) {
            this.gia -= measuredWidth;
        } else {
            if (this.gik != null) {
                addViewInLayout(this.gik, -1, this.gik.getLayoutParams(), true);
                this.gia += this.gik.getMeasuredWidth();
            }
            this.gia -= measuredWidth;
            this.gin = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.gio.add(view);
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
        } else if (scrollX > brK()) {
            this.mScroller.startScroll(scrollX, 0, brK() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.gip = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.brK()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.brK(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.giq) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean brP() {
        return this.gip;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.giu);
        this.mScroller.forceFinished(true);
        this.gib.forceFinished(true);
        if (this.ghW != null) {
            this.ghW.setVisibility(0);
            this.ghW = null;
        }
        this.ghX = -1;
        this.gie = false;
        this.gif = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.gir = false;
    }

    public void setCenterStart(boolean z) {
        this.gis = z;
    }

    public void setStartEndSpace(int i) {
        this.gih = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.git = z;
    }
}
