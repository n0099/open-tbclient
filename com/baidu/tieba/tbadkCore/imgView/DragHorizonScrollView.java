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
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, e, f {
    private int bSQ;
    private BaseAdapter bbp;
    private final float cZF;
    private View cZG;
    private int cZH;
    private com.baidu.tieba.tbadkCore.imgView.a cZI;
    private int cZJ;
    private int cZK;
    private int cZL;
    private Scroller cZM;
    private Rect cZN;
    private boolean cZO;
    private boolean cZP;
    private a cZQ;
    private int cZR;
    private int cZS;
    private boolean cZT;
    private View cZU;
    private final int cZV;
    private final int cZW;
    private int cZX;
    private boolean cZY;
    private ArrayList<View> cZZ;
    private boolean daa;
    private boolean dab;
    private boolean dac;
    private boolean dad;
    private Runnable dae;
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
        this.cZF = 2.0f;
        this.cZN = new Rect();
        this.cZS = 10;
        this.cZV = 300;
        this.cZW = 500;
        this.cZZ = new ArrayList<>();
        this.dad = false;
        this.dae = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cZF = 2.0f;
        this.cZN = new Rect();
        this.cZS = 10;
        this.cZV = 300;
        this.cZW = 500;
        this.cZZ = new ArrayList<>();
        this.dad = false;
        this.dae = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cZF = 2.0f;
        this.cZN = new Rect();
        this.cZS = 10;
        this.cZV = 300;
        this.cZW = 500;
        this.cZZ = new ArrayList<>();
        this.dad = false;
        this.dae = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.cZG = null;
        this.cZH = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.cZM = new Scroller(context);
        this.cZR = getResources().getDimensionPixelSize(i.d.editor_muti_image_upload_scrollview_paddingleft);
        this.mPadding = getResources().getDimensionPixelSize(i.d.default_gap_24);
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
        this.bSQ = this.bbp == null ? 0 : this.bbp.getCount();
        this.bSQ = Math.min(this.cZS, this.bSQ);
        if (this.bSQ <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View kX = kX(0);
            f(kX, i, i2);
            i4 = kX.getMeasuredWidth();
            i3 = kX.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] m = m(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(m[0], i);
                this.dab = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(m[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.cZJ = i;
        this.cZK = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.cZU) {
                this.cZZ.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.cZR;
        if (this.dad) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.default_gap_24);
            if (this.bSQ > 0) {
                View kX = kX(0);
                f(kX, this.cZJ, this.cZK);
                paddingLeft = ((getMeasuredWidth() - kX.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.cZU != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.cZR * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.cZU.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.cZU.setLayoutParams(layoutParams);
                f(this.cZU, this.cZJ, this.cZK);
                paddingLeft = ((getMeasuredWidth() - this.cZU.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.bSQ; i7++) {
            View kX2 = kX(i7);
            if (kX2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = kX2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    kX2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(kX2, -1, layoutParams2, true);
                f(kX2, this.cZJ, this.cZK);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = kX2.getMeasuredWidth() + i6;
                kX2.layout(i6, paddingTop, measuredWidth2, kX2.getMeasuredHeight() + paddingTop);
                kX2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.cZU != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.cZR * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.cZU.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.cZU.setLayoutParams(layoutParams3);
            f(this.cZU, this.cZJ, this.cZK);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.cZU.getMeasuredWidth() + i6;
            this.cZU.layout(i6, paddingTop2, measuredWidth4, this.cZU.getMeasuredHeight() + paddingTop2);
            if (this.bSQ == this.cZS) {
                i6 = measuredWidth4 - this.cZU.getMeasuredWidth();
                this.cZY = false;
            } else {
                addViewInLayout(this.cZU, -1, this.cZU.getLayoutParams(), true);
                this.cZY = true;
                i6 = measuredWidth4;
            }
        }
        this.cZL = (this.cZR + i6) - this.mPadding;
        if (this.cZT || z) {
            scrollTo(0, 0);
            scrollBy(awR(), 0);
            this.cZT = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.cZL > getMeasuredWidth();
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
                    if (!this.cZM.isFinished()) {
                        removeCallbacks(this.dae);
                        this.cZM.forceFinished(true);
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
                    if (!this.cZM.isFinished()) {
                        removeCallbacks(this.dae);
                        this.cZM.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.dae);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cZX = i2;
                        this.cZM.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.dae);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    kY((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bbp = baseAdapter;
        this.mScroller.forceFinished(true);
        this.cZM.forceFinished(true);
        if (!this.cZT && z) {
            this.cZT = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bbp;
    }

    private View kX(int i) {
        View view = null;
        if (this.cZZ.size() > 0) {
            view = this.cZZ.remove(0);
        }
        View view2 = this.bbp.getView(i, view, this);
        if (view2 != view) {
            this.cZZ.add(view);
        }
        view2.setOnLongClickListener(this);
        return view2;
    }

    private void f(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view.setLayoutParams(layoutParams);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    private int[] m(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.bbp == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.bSQ - 1;
        }
        while (i <= i2) {
            View kX = kX(i);
            if (kX.getVisibility() != 8) {
                f(kX, i3, i4);
                paddingRight += kX.getMeasuredWidth();
                paddingTop = Math.max(kX.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int awR() {
        if (canScroll()) {
            return this.cZL - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kY(int i) {
        scrollBy(kZ(i), 0);
        invalidate();
    }

    private int kZ(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > awR()) {
                i = awR() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.dac) {
            this.dac = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.cZI.a(view, null);
            this.cZG = view;
            this.cZH = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.cZO || this.cZP) && this.cZI != null) {
                this.cZI.awQ();
                return;
            }
            return;
        }
        this.cZO = false;
        this.cZP = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.cZI = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.cZH && (childAt = getChildAt(i)) != this.cZU) {
                childAt.getHitRect(this.cZN);
                if (this.cZN.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.cZH;
                    aH(i2, i);
                    aG(i2, i);
                    this.cZH = i;
                    return;
                }
            }
        }
    }

    private void aG(int i, int i2) {
        if (this.cZQ != null) {
            this.cZQ.H(i, i2);
        }
    }

    private void aH(int i, int i2) {
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

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void awS() {
        if (!this.cZO) {
            this.cZO = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void awT() {
        if (!this.cZP) {
            this.cZP = true;
            int awR = awR();
            int scrollX = getScrollX();
            int scrollX2 = awR - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void awU() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.cZO = false;
        this.cZP = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void awV() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.cZQ = aVar;
    }

    public void setMaxItemNum(int i) {
        this.cZS = i;
    }

    public int getMaxItemNum() {
        return this.cZS;
    }

    public void setAddView(View view) {
        this.cZU = view;
    }

    public int ax(View view) {
        this.daa = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.cZY) {
            this.cZL -= measuredWidth;
        } else {
            if (this.cZU != null) {
                addViewInLayout(this.cZU, -1, this.cZU.getLayoutParams(), true);
                this.cZL += this.cZU.getMeasuredWidth();
            }
            this.cZL -= measuredWidth;
            this.cZY = true;
        }
        this.bSQ--;
        removeViewInLayout(view);
        this.cZZ.add(view);
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
        } else if (scrollX > awR()) {
            this.mScroller.startScroll(scrollX, 0, awR() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean awW() {
        return this.daa;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.dae);
        this.mScroller.forceFinished(true);
        this.cZM.forceFinished(true);
        if (this.cZG != null) {
            this.cZG.setVisibility(0);
            this.cZG = null;
        }
        this.cZH = -1;
        this.cZO = false;
        this.cZP = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.dac = false;
    }

    public void setCenterStart(boolean z) {
        this.dad = z;
    }
}
