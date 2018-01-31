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
    private int JM;
    private int TB;
    private boolean haA;
    private Runnable haB;
    private final float had;
    private BaseAdapter hae;
    private View haf;
    private int hag;
    private b hah;
    private int hai;
    private Scroller haj;
    private Rect hak;
    private boolean hal;
    private boolean ham;
    private a han;
    private int hao;
    private int hap;
    private boolean haq;
    private View har;
    private final int has;
    private final int hat;
    private boolean hau;
    private ArrayList<View> hav;
    private boolean haw;
    private boolean hax;
    private boolean hay;
    private boolean haz;
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
        this.had = 2.0f;
        this.hak = new Rect();
        this.hap = 10;
        this.has = 300;
        this.hat = 500;
        this.hav = new ArrayList<>();
        this.haz = false;
        this.haA = true;
        this.haB = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.haj.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.haj;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = DragHorizonScrollView.this.TB - currX;
                if (i > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i);
                }
                DragHorizonScrollView.this.vO(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.TB = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.haj.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.had = 2.0f;
        this.hak = new Rect();
        this.hap = 10;
        this.has = 300;
        this.hat = 500;
        this.hav = new ArrayList<>();
        this.haz = false;
        this.haA = true;
        this.haB = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.haj.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.haj;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.TB - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.vO(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.TB = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.haj.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.had = 2.0f;
        this.hak = new Rect();
        this.hap = 10;
        this.has = 300;
        this.hat = 500;
        this.hav = new ArrayList<>();
        this.haz = false;
        this.haA = true;
        this.haB = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.haj.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.haj;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i2 = DragHorizonScrollView.this.TB - currX;
                if (i2 > 0) {
                    max = Math.min(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1, i2);
                } else {
                    max = Math.max(-(((DragHorizonScrollView.this.getWidth() - DragHorizonScrollView.this.getPaddingLeft()) - DragHorizonScrollView.this.getPaddingRight()) - 1), i2);
                }
                DragHorizonScrollView.this.vO(-max);
                if (computeScrollOffset) {
                    DragHorizonScrollView.this.TB = currX;
                    DragHorizonScrollView.this.post(this);
                    return;
                }
                DragHorizonScrollView.this.haj.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.haf = null;
        this.hag = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.haj = new Scroller(context);
        this.hao = getResources().getDimensionPixelSize(d.e.ds66);
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
        this.mItemCount = this.hae == null ? 0 : this.hae.getCount();
        this.mItemCount = Math.min(this.hap, this.mItemCount);
        if (this.mItemCount <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View vN = vN(0);
            measureScrapChild(vN, i, i2);
            i4 = vN.getMeasuredWidth();
            i3 = vN.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] G = G(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(G[0], i);
                this.hax = true;
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
        this.hai = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.har) {
                this.hav.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.hao;
        if (this.haz) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds32);
            if (this.mItemCount > 0) {
                View vN = vN(0);
                measureScrapChild(vN, this.hai, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - vN.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.har != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.hao * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.har.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.har.setLayoutParams(layoutParams);
                measureScrapChild(this.har, this.hai, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.har.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.mItemCount; i7++) {
            View vN2 = vN(i7);
            if (vN2 != null && vN2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = vN2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    vN2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(vN2, -1, layoutParams2, true);
                measureScrapChild(vN2, this.hai, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = vN2.getMeasuredWidth() + i6;
                vN2.layout(i6, paddingTop, measuredWidth2, vN2.getMeasuredHeight() + paddingTop);
                vN2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.har != null) {
            if (this.haA) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.hao * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.har.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.har.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.har, this.hai, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.har.getMeasuredWidth() + i6;
            this.har.layout(i6, paddingTop2, measuredWidth4, this.har.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.hap) {
                i6 = measuredWidth4 - this.har.getMeasuredWidth();
                this.hau = false;
            } else {
                addViewInLayout(this.har, -1, this.har.getLayoutParams(), true);
                this.hau = true;
                i6 = measuredWidth4;
            }
        }
        this.JM = (this.hao + i6) - this.mPadding;
        if (this.haq || z) {
            scrollTo(0, 0);
            scrollBy(bwf(), 0);
            this.haq = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.JM > getMeasuredWidth();
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
                    if (!this.haj.isFinished()) {
                        removeCallbacks(this.haB);
                        this.haj.forceFinished(true);
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
                    if (!this.haj.isFinished()) {
                        removeCallbacks(this.haB);
                        this.haj.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.haB);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.TB = i2;
                        this.haj.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.haB);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    vO((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.hae = baseAdapter;
        this.mScroller.forceFinished(true);
        this.haj.forceFinished(true);
        if (!this.haq && z) {
            this.haq = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.hae;
    }

    private View vN(int i) {
        View view = null;
        if (this.hav.size() > 0) {
            view = this.hav.remove(0);
        }
        View view2 = this.hae.getView(i, view, this);
        if (view2 != view) {
            this.hav.add(view);
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
        if (this.hae == null) {
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
            View vN = vN(i);
            if (vN.getVisibility() != 8) {
                measureScrapChild(vN, i3, i4);
                paddingRight += vN.getMeasuredWidth();
                paddingTop = Math.max(vN.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bwf() {
        if (canScroll()) {
            return this.JM - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vO(int i) {
        scrollBy(vP(i), 0);
        invalidate();
    }

    private int vP(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bwf()) {
                i = bwf() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.hay) {
            this.hay = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.hah.a(view, null);
            this.haf = view;
            this.hag = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.hal || this.ham) && this.hah != null) {
                this.hah.swap();
                return;
            }
            return;
        }
        this.hal = false;
        this.ham = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.hah = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void n(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.hag && (childAt = getChildAt(i)) != this.har) {
                childAt.getHitRect(this.hak);
                if (this.hak.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.hag;
                    cO(i2, i);
                    cN(i2, i);
                    this.hag = i;
                    return;
                }
            }
        }
    }

    private void cN(int i, int i2) {
        if (this.han != null) {
            this.han.aG(i, i2);
        }
    }

    private void cO(int i, int i2) {
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
    public void bwg() {
        if (!this.hal) {
            this.hal = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bwh() {
        if (!this.ham) {
            this.ham = true;
            int bwf = bwf();
            int scrollX = getScrollX();
            int scrollX2 = bwf - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bwi() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.hal = false;
        this.ham = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bwj() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.han = aVar;
    }

    public void setMaxItemNum(int i) {
        this.hap = i;
    }

    public int getMaxItemNum() {
        return this.hap;
    }

    public void setAddView(View view) {
        this.har = view;
    }

    public int cR(View view) {
        this.haw = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.hau) {
            this.JM -= measuredWidth;
        } else {
            if (this.har != null) {
                addViewInLayout(this.har, -1, this.har.getLayoutParams(), true);
                this.JM += this.har.getMeasuredWidth();
            }
            this.JM -= measuredWidth;
            this.hau = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.hav.add(view);
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
        } else if (scrollX > bwf()) {
            this.mScroller.startScroll(scrollX, 0, bwf() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.haw = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bwf()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bwf(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.hax) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bwk() {
        return this.haw;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.haB);
        this.mScroller.forceFinished(true);
        this.haj.forceFinished(true);
        if (this.haf != null) {
            this.haf.setVisibility(0);
            this.haf = null;
        }
        this.hag = -1;
        this.hal = false;
        this.ham = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.hay = false;
    }

    public void setCenterStart(boolean z) {
        this.haz = z;
    }

    public void setStartEndSpace(int i) {
        this.hao = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.haA = z;
    }
}
