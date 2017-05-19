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
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, f, g {
    private BaseAdapter bZO;
    private int cxx;
    private int cyE;
    private int czz;
    private final float fvG;
    private View fvH;
    private int fvI;
    private b fvJ;
    private int fvK;
    private int fvL;
    private Scroller fvM;
    private Rect fvN;
    private boolean fvO;
    private boolean fvP;
    private a fvQ;
    private int fvR;
    private int fvS;
    private boolean fvT;
    private View fvU;
    private final int fvV;
    private final int fvW;
    private boolean fvX;
    private ArrayList<View> fvY;
    private boolean fvZ;
    private boolean fwa;
    private boolean fwb;
    private boolean fwc;
    private boolean fwd;
    private Runnable fwe;
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
        this.fvG = 2.0f;
        this.fvN = new Rect();
        this.fvS = 10;
        this.fvV = 300;
        this.fvW = 500;
        this.fvY = new ArrayList<>();
        this.fwc = false;
        this.fwd = true;
        this.fwe = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fvG = 2.0f;
        this.fvN = new Rect();
        this.fvS = 10;
        this.fvV = 300;
        this.fvW = 500;
        this.fvY = new ArrayList<>();
        this.fwc = false;
        this.fwd = true;
        this.fwe = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fvG = 2.0f;
        this.fvN = new Rect();
        this.fvS = 10;
        this.fvV = 300;
        this.fvW = 500;
        this.fvY = new ArrayList<>();
        this.fwc = false;
        this.fwd = true;
        this.fwe = new c(this);
        init(context);
    }

    private void init(Context context) {
        this.fvH = null;
        this.fvI = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.fvM = new Scroller(context);
        this.fvR = getResources().getDimensionPixelSize(w.f.ds66);
        this.mPadding = getResources().getDimensionPixelSize(w.f.ds32);
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
        this.czz = this.bZO == null ? 0 : this.bZO.getCount();
        this.czz = Math.min(this.fvS, this.czz);
        if (this.czz <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View rS = rS(0);
            k(rS, i, i2);
            i4 = rS.getMeasuredWidth();
            i3 = rS.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] r = r(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(r[0], i);
                this.fwa = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(r[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.fvK = i;
        this.cxx = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.fvU) {
                this.fvY.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.fvR;
        if (this.fwc) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds32);
            if (this.czz > 0) {
                View rS = rS(0);
                k(rS, this.fvK, this.cxx);
                paddingLeft = ((getMeasuredWidth() - rS.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.fvU != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.fvR * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.fvU.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.fvU.setLayoutParams(layoutParams);
                k(this.fvU, this.fvK, this.cxx);
                paddingLeft = ((getMeasuredWidth() - this.fvU.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.czz; i7++) {
            View rS2 = rS(i7);
            if (rS2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = rS2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    rS2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(rS2, -1, layoutParams2, true);
                k(rS2, this.fvK, this.cxx);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = rS2.getMeasuredWidth() + i6;
                rS2.layout(i6, paddingTop, measuredWidth2, rS2.getMeasuredHeight() + paddingTop);
                rS2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.fvU != null) {
            if (this.fwd) {
                int measuredWidth3 = ((getMeasuredWidth() - (this.fvR * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams3 = this.fvU.getLayoutParams();
                if (layoutParams3 == null) {
                    layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
                }
                layoutParams3.width = measuredWidth3;
                layoutParams3.height = -1;
                this.fvU.setLayoutParams(layoutParams3);
            }
            k(this.fvU, this.fvK, this.cxx);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.fvU.getMeasuredWidth() + i6;
            this.fvU.layout(i6, paddingTop2, measuredWidth4, this.fvU.getMeasuredHeight() + paddingTop2);
            if (this.czz == this.fvS) {
                i6 = measuredWidth4 - this.fvU.getMeasuredWidth();
                this.fvX = false;
            } else {
                addViewInLayout(this.fvU, -1, this.fvU.getLayoutParams(), true);
                this.fvX = true;
                i6 = measuredWidth4;
            }
        }
        this.fvL = (this.fvR + i6) - this.mPadding;
        if (this.fvT || z) {
            scrollTo(0, 0);
            scrollBy(bhg(), 0);
            this.fvT = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.fvL > getMeasuredWidth();
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
                    if (!this.fvM.isFinished()) {
                        removeCallbacks(this.fwe);
                        this.fvM.forceFinished(true);
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
                    if (!this.fvM.isFinished()) {
                        removeCallbacks(this.fwe);
                        this.fvM.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.fwe);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cyE = i2;
                        this.fvM.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.fwe);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    rT((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bZO = baseAdapter;
        this.mScroller.forceFinished(true);
        this.fvM.forceFinished(true);
        if (!this.fvT && z) {
            this.fvT = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bZO;
    }

    private View rS(int i) {
        View view = null;
        if (this.fvY.size() > 0) {
            view = this.fvY.remove(0);
        }
        View view2 = this.bZO.getView(i, view, this);
        if (view2 != view) {
            this.fvY.add(view);
        }
        if (view2 != null) {
            view2.setOnLongClickListener(this);
        }
        return view2;
    }

    private void k(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view.setLayoutParams(layoutParams);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    private int[] r(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.bZO == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.czz - 1;
        }
        while (i <= i2) {
            View rS = rS(i);
            if (rS.getVisibility() != 8) {
                k(rS, i3, i4);
                paddingRight += rS.getMeasuredWidth();
                paddingTop = Math.max(rS.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bhg() {
        if (canScroll()) {
            return this.fvL - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rT(int i) {
        scrollBy(rU(i), 0);
        invalidate();
    }

    private int rU(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bhg()) {
                i = bhg() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.fwb) {
            this.fwb = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.fvJ.a(view, null);
            this.fvH = view;
            this.fvI = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.fvO || this.fvP) && this.fvJ != null) {
                this.fvJ.bhf();
                return;
            }
            return;
        }
        this.fvO = false;
        this.fvP = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(b bVar) {
        this.fvJ = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void e(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.fvI && (childAt = getChildAt(i)) != this.fvU) {
                childAt.getHitRect(this.fvN);
                if (this.fvN.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.fvI;
                    bo(i2, i);
                    bn(i2, i);
                    this.fvI = i;
                    return;
                }
            }
        }
    }

    private void bn(int i, int i2) {
        if (this.fvQ != null) {
            this.fvQ.K(i, i2);
        }
    }

    private void bo(int i, int i2) {
        if (i != i2) {
            View childAt = getChildAt(i);
            View childAt2 = getChildAt(i2);
            if (i < i2) {
                detachViewFromParent(i);
                int i3 = -childAt.getMeasuredWidth();
                int left = childAt2.getLeft() - childAt.getLeft();
                while (i < i2) {
                    View childAt3 = getChildAt(i);
                    childAt3.offsetLeftAndRight(i3);
                    TranslateAnimation translateAnimation = new TranslateAnimation(-i3, 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(300L);
                    translateAnimation.setFillAfter(true);
                    childAt3.startAnimation(translateAnimation);
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
                childAt4.offsetLeftAndRight(measuredWidth);
                TranslateAnimation translateAnimation2 = new TranslateAnimation(-measuredWidth, 0.0f, 0.0f, 0.0f);
                translateAnimation2.setDuration(300L);
                translateAnimation2.setFillAfter(true);
                childAt4.startAnimation(translateAnimation2);
            }
            attachViewToParent(childAt, i2, childAt.getLayoutParams());
            childAt.offsetLeftAndRight(left2);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bhh() {
        if (!this.fvO) {
            this.fvO = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bhi() {
        if (!this.fvP) {
            this.fvP = true;
            int bhg = bhg();
            int scrollX = getScrollX();
            int scrollX2 = bhg - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bhj() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.fvO = false;
        this.fvP = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bhk() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.fvQ = aVar;
    }

    public void setMaxItemNum(int i) {
        this.fvS = i;
    }

    public int getMaxItemNum() {
        return this.fvS;
    }

    public void setAddView(View view) {
        this.fvU = view;
    }

    public int bk(View view) {
        this.fvZ = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.fvX) {
            this.fvL -= measuredWidth;
        } else {
            if (this.fvU != null) {
                addViewInLayout(this.fvU, -1, this.fvU.getLayoutParams(), true);
                this.fvL += this.fvU.getMeasuredWidth();
            }
            this.fvL -= measuredWidth;
            this.fvX = true;
        }
        this.czz--;
        removeViewInLayout(view);
        this.fvY.add(view);
        int childCount = getChildCount();
        if (childCount > 1) {
            for (int i = indexOfChild; i < childCount; i++) {
                View childAt = getChildAt(i);
                childAt.offsetLeftAndRight(-measuredWidth);
                TranslateAnimation translateAnimation = new TranslateAnimation(measuredWidth, 0.0f, 0.0f, 0.0f);
                translateAnimation.setDuration(500L);
                translateAnimation.setFillAfter(true);
                childAt.startAnimation(translateAnimation);
            }
        }
        int scrollX = getScrollX();
        if (!canScroll()) {
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, 500);
            postInvalidate();
        } else if (scrollX > bhg()) {
            this.mScroller.startScroll(scrollX, 0, bhg() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new d(this), 500L);
        return indexOfChild;
    }

    public boolean bhl() {
        return this.fvZ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.fwe);
        this.mScroller.forceFinished(true);
        this.fvM.forceFinished(true);
        if (this.fvH != null) {
            this.fvH.setVisibility(0);
            this.fvH = null;
        }
        this.fvI = -1;
        this.fvO = false;
        this.fvP = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.fwb = false;
    }

    public void setCenterStart(boolean z) {
        this.fwc = z;
    }

    public void setStartEndSpace(int i) {
        this.fvR = i;
    }

    public void setPadding(int i) {
        this.mPadding = i;
    }

    public void setNeedRecomputeAddView(boolean z) {
        this.fwd = z;
    }
}
