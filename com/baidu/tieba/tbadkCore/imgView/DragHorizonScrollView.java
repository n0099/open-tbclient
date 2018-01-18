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
    private final float gZJ;
    private BaseAdapter gZK;
    private View gZL;
    private int gZM;
    private b gZN;
    private int gZO;
    private Scroller gZP;
    private Rect gZQ;
    private boolean gZR;
    private boolean gZS;
    private a gZT;
    private int gZU;
    private int gZV;
    private boolean gZW;
    private View gZX;
    private final int gZY;
    private final int gZZ;
    private boolean haa;
    private ArrayList<View> hab;
    private boolean hac;
    private boolean had;
    private boolean hae;
    private boolean haf;
    private boolean hag;
    private Runnable hah;
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
        this.gZJ = 2.0f;
        this.gZQ = new Rect();
        this.gZV = 10;
        this.gZY = 300;
        this.gZZ = 500;
        this.hab = new ArrayList<>();
        this.haf = false;
        this.hag = true;
        this.hah = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gZP.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gZP;
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
                DragHorizonScrollView.this.gZP.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gZJ = 2.0f;
        this.gZQ = new Rect();
        this.gZV = 10;
        this.gZY = 300;
        this.gZZ = 500;
        this.hab = new ArrayList<>();
        this.haf = false;
        this.hag = true;
        this.hah = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gZP.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gZP;
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
                DragHorizonScrollView.this.gZP.forceFinished(true);
            }
        };
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gZJ = 2.0f;
        this.gZQ = new Rect();
        this.gZV = 10;
        this.gZY = 300;
        this.gZZ = 500;
        this.hab = new ArrayList<>();
        this.haf = false;
        this.hag = true;
        this.hah = new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.1
            @Override // java.lang.Runnable
            public void run() {
                int max;
                if (DragHorizonScrollView.this.mItemCount == 0) {
                    DragHorizonScrollView.this.gZP.forceFinished(true);
                    return;
                }
                Scroller scroller = DragHorizonScrollView.this.gZP;
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
                DragHorizonScrollView.this.gZP.forceFinished(true);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gZL = null;
        this.gZM = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.gZP = new Scroller(context);
        this.gZU = getResources().getDimensionPixelSize(d.e.ds66);
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
        this.mItemCount = this.gZK == null ? 0 : this.gZK.getCount();
        this.mItemCount = Math.min(this.gZV, this.mItemCount);
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
                this.had = true;
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
        this.gZO = i;
        this.mHeightMeasureSpec = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.gZX) {
                this.hab.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.gZU;
        if (this.haf) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds32);
            if (this.mItemCount > 0) {
                View vN = vN(0);
                measureScrapChild(vN, this.gZO, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - vN.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.gZX != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.gZU * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.gZX.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.gZX.setLayoutParams(layoutParams);
                measureScrapChild(this.gZX, this.gZO, this.mHeightMeasureSpec);
                paddingLeft = ((getMeasuredWidth() - this.gZX.getMeasuredWidth()) + dimensionPixelSize) / 2;
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
                measureScrapChild(vN2, this.gZO, this.mHeightMeasureSpec);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = vN2.getMeasuredWidth() + i6;
                vN2.layout(i6, paddingTop, measuredWidth2, vN2.getMeasuredHeight() + paddingTop);
                vN2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.gZX != null) {
            if (this.hag) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.gZU * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.gZX.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.gZX.setLayoutParams(layoutParams3);
            }
            measureScrapChild(this.gZX, this.gZO, this.mHeightMeasureSpec);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.gZX.getMeasuredWidth() + i6;
            this.gZX.layout(i6, paddingTop2, measuredWidth4, this.gZX.getMeasuredHeight() + paddingTop2);
            if (this.mItemCount == this.gZV) {
                i6 = measuredWidth4 - this.gZX.getMeasuredWidth();
                this.haa = false;
            } else {
                addViewInLayout(this.gZX, -1, this.gZX.getLayoutParams(), true);
                this.haa = true;
                i6 = measuredWidth4;
            }
        }
        this.JM = (this.gZU + i6) - this.mPadding;
        if (this.gZW || z) {
            scrollTo(0, 0);
            scrollBy(bwd(), 0);
            this.gZW = false;
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
                    if (!this.gZP.isFinished()) {
                        removeCallbacks(this.hah);
                        this.gZP.forceFinished(true);
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
                    if (!this.gZP.isFinished()) {
                        removeCallbacks(this.hah);
                        this.gZP.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.hah);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.TB = i2;
                        this.gZP.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.hah);
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
        this.gZK = baseAdapter;
        this.mScroller.forceFinished(true);
        this.gZP.forceFinished(true);
        if (!this.gZW && z) {
            this.gZW = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.gZK;
    }

    private View vN(int i) {
        View view = null;
        if (this.hab.size() > 0) {
            view = this.hab.remove(0);
        }
        View view2 = this.gZK.getView(i, view, this);
        if (view2 != view) {
            this.hab.add(view);
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
        if (this.gZK == null) {
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
    public int bwd() {
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
            if (i2 > bwd()) {
                i = bwd() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.hae) {
            this.hae = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i) != null) {
                    getChildAt(i).clearAnimation();
                }
            }
            this.gZN.a(view, null);
            this.gZL = view;
            this.gZM = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.gZR || this.gZS) && this.gZN != null) {
                this.gZN.swap();
                return;
            }
            return;
        }
        this.gZR = false;
        this.gZS = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.d
    public void setDragController(b bVar) {
        this.gZN = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void n(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.gZM && (childAt = getChildAt(i)) != this.gZX) {
                childAt.getHitRect(this.gZQ);
                if (this.gZQ.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.gZM;
                    cO(i2, i);
                    cN(i2, i);
                    this.gZM = i;
                    return;
                }
            }
        }
    }

    private void cN(int i, int i2) {
        if (this.gZT != null) {
            this.gZT.aG(i, i2);
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
    public void bwe() {
        if (!this.gZR) {
            this.gZR = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bwf() {
        if (!this.gZS) {
            this.gZS = true;
            int bwd = bwd();
            int scrollX = getScrollX();
            int scrollX2 = bwd - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bwg() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.gZR = false;
        this.gZS = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void bwh() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.gZT = aVar;
    }

    public void setMaxItemNum(int i) {
        this.gZV = i;
    }

    public int getMaxItemNum() {
        return this.gZV;
    }

    public void setAddView(View view) {
        this.gZX = view;
    }

    public int cR(View view) {
        this.hac = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.haa) {
            this.JM -= measuredWidth;
        } else {
            if (this.gZX != null) {
                addViewInLayout(this.gZX, -1, this.gZX.getLayoutParams(), true);
                this.JM += this.gZX.getMeasuredWidth();
            }
            this.JM -= measuredWidth;
            this.haa = true;
        }
        this.mItemCount--;
        removeViewInLayout(view);
        this.hab.add(view);
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
        } else if (scrollX > bwd()) {
            this.mScroller.startScroll(scrollX, 0, bwd() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadkCore.imgView.DragHorizonScrollView.2
            @Override // java.lang.Runnable
            public void run() {
                DragHorizonScrollView.this.hac = false;
                int childCount2 = DragHorizonScrollView.this.getChildCount();
                for (int i2 = 0; i2 < childCount2; i2++) {
                    if (DragHorizonScrollView.this.getChildAt(i2) != null) {
                        DragHorizonScrollView.this.getChildAt(i2).clearAnimation();
                    }
                }
                if (DragHorizonScrollView.this.canScroll()) {
                    if (DragHorizonScrollView.this.getScrollX() > DragHorizonScrollView.this.bwd()) {
                        DragHorizonScrollView.this.scrollTo(DragHorizonScrollView.this.bwd(), 0);
                    }
                } else {
                    DragHorizonScrollView.this.scrollTo(0, 0);
                }
                if (DragHorizonScrollView.this.had) {
                    DragHorizonScrollView.this.requestLayout();
                }
            }
        }, 500L);
        return indexOfChild;
    }

    public boolean bwi() {
        return this.hac;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.hah);
        this.mScroller.forceFinished(true);
        this.gZP.forceFinished(true);
        if (this.gZL != null) {
            this.gZL.setVisibility(0);
            this.gZL = null;
        }
        this.gZM = -1;
        this.gZR = false;
        this.gZS = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) != null) {
                getChildAt(i).clearAnimation();
            }
        }
        this.hae = false;
    }

    public void setCenterStart(boolean z) {
        this.haf = z;
    }

    public void setStartEndSpace(int i) {
        this.gZU = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.hag = z;
    }
}
