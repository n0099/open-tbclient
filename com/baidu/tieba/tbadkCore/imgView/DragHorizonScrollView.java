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
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, f, g {
    private final float bZD;
    private BaseAdapter bZE;
    private View bZF;
    private int bZG;
    private a bZH;
    private int bZI;
    private int bZJ;
    private int bZK;
    private Scroller bZL;
    private Rect bZM;
    private boolean bZN;
    private boolean bZO;
    private d bZP;
    private int bZQ;
    private int bZR;
    private boolean bZS;
    private View bZT;
    private final int bZU;
    private final int bZV;
    private int bZW;
    private boolean bZX;
    private ArrayList<View> bZY;
    private boolean bZZ;
    private boolean caa;
    private boolean cab;
    private boolean cac;
    private Runnable cad;
    private int mContentWidth;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public DragHorizonScrollView(Context context) {
        super(context);
        this.bZD = 2.0f;
        this.bZM = new Rect();
        this.bZR = 10;
        this.bZU = 300;
        this.bZV = 500;
        this.bZY = new ArrayList<>();
        this.cac = false;
        this.cad = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZD = 2.0f;
        this.bZM = new Rect();
        this.bZR = 10;
        this.bZU = 300;
        this.bZV = 500;
        this.bZY = new ArrayList<>();
        this.cac = false;
        this.cad = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZD = 2.0f;
        this.bZM = new Rect();
        this.bZR = 10;
        this.bZU = 300;
        this.bZV = 500;
        this.bZY = new ArrayList<>();
        this.cac = false;
        this.cad = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.bZF = null;
        this.bZG = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.bZL = new Scroller(context);
        this.bZQ = getResources().getDimensionPixelSize(u.editor_muti_image_upload_scrollview_paddingleft);
        this.mPadding = getResources().getDimensionPixelSize(u.default_gap_24);
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
        this.bZI = this.bZE == null ? 0 : this.bZE.getCount();
        this.bZI = Math.min(this.bZR, this.bZI);
        if (this.bZI <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View ic = ic(0);
            g(ic, i, i2);
            i4 = ic.getMeasuredWidth();
            i3 = ic.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] h = h(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(h[0], i);
                this.caa = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(h[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.bZJ = i;
        this.bZK = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.bZT) {
                this.bZY.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.bZQ;
        if (this.cac) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(u.default_gap_24);
            if (this.bZI > 0) {
                View ic = ic(0);
                g(ic, this.bZJ, this.bZK);
                paddingLeft = ((getMeasuredWidth() - ic.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.bZT != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.bZQ * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.bZT.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.bZT.setLayoutParams(layoutParams);
                g(this.bZT, this.bZJ, this.bZK);
                paddingLeft = ((getMeasuredWidth() - this.bZT.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.bZI; i7++) {
            View ic2 = ic(i7);
            if (ic2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = ic2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    ic2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(ic2, -1, layoutParams2, true);
                g(ic2, this.bZJ, this.bZK);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = ic2.getMeasuredWidth() + i6;
                ic2.layout(i6, paddingTop, measuredWidth2, ic2.getMeasuredHeight() + paddingTop);
                ic2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.bZT != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.bZQ * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.bZT.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.bZT.setLayoutParams(layoutParams3);
            g(this.bZT, this.bZJ, this.bZK);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.bZT.getMeasuredWidth() + i6;
            this.bZT.layout(i6, paddingTop2, measuredWidth4, this.bZT.getMeasuredHeight() + paddingTop2);
            if (this.bZI == this.bZR) {
                i6 = measuredWidth4 - this.bZT.getMeasuredWidth();
                this.bZX = false;
            } else {
                addViewInLayout(this.bZT, -1, this.bZT.getLayoutParams(), true);
                this.bZX = true;
                i6 = measuredWidth4;
            }
        }
        this.mContentWidth = (this.bZQ + i6) - this.mPadding;
        if (this.bZS || z) {
            scrollTo(0, 0);
            scrollBy(ahM(), 0);
            this.bZS = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.mContentWidth > getMeasuredWidth();
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
                    if (!this.bZL.isFinished()) {
                        removeCallbacks(this.cad);
                        this.bZL.forceFinished(true);
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
                    if (!this.bZL.isFinished()) {
                        removeCallbacks(this.cad);
                        this.bZL.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.cad);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.bZW = i2;
                        this.bZL.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.cad);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    id((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bZE = baseAdapter;
        this.mScroller.forceFinished(true);
        this.bZL.forceFinished(true);
        if (!this.bZS && z) {
            this.bZS = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bZE;
    }

    private View ic(int i) {
        View view = null;
        if (this.bZY.size() > 0) {
            view = this.bZY.remove(0);
        }
        View view2 = this.bZE.getView(i, view, this);
        if (view2 != view) {
            this.bZY.add(view);
        }
        view2.setOnLongClickListener(this);
        return view2;
    }

    private void g(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view.setLayoutParams(layoutParams);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    private int[] h(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.bZE == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.bZI - 1;
        }
        while (i <= i2) {
            View ic = ic(i);
            if (ic.getVisibility() != 8) {
                g(ic, i3, i4);
                paddingRight += ic.getMeasuredWidth();
                paddingTop = Math.max(ic.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ahM() {
        if (canScroll()) {
            return this.mContentWidth - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void id(int i) {
        scrollBy(ie(i), 0);
        invalidate();
    }

    private int ie(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > ahM()) {
                i = ahM() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.cab) {
            this.cab = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.bZH.a(view, null);
            this.bZF = view;
            this.bZG = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.bZN || this.bZO) && this.bZH != null) {
                this.bZH.ahL();
                return;
            }
            return;
        }
        this.bZN = false;
        this.bZO = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(a aVar) {
        this.bZH = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.bZG && (childAt = getChildAt(i)) != this.bZT) {
                childAt.getHitRect(this.bZM);
                if (this.bZM.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.bZG;
                    ag(i2, i);
                    af(i2, i);
                    this.bZG = i;
                    return;
                }
            }
        }
    }

    private void af(int i, int i2) {
        if (this.bZP != null) {
            this.bZP.ac(i, i2);
        }
    }

    private void ag(int i, int i2) {
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
    public void ahN() {
        if (!this.bZN) {
            this.bZN = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void ahO() {
        if (!this.bZO) {
            this.bZO = true;
            int ahM = ahM();
            int scrollX = getScrollX();
            int scrollX2 = ahM - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void ahP() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.bZN = false;
        this.bZO = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void ahQ() {
        reset();
    }

    public void setOnSwapDataListener(d dVar) {
        this.bZP = dVar;
    }

    public void setMaxItemNum(int i) {
        this.bZR = i;
    }

    public int getMaxItemNum() {
        return this.bZR;
    }

    public void setAddView(View view) {
        this.bZT = view;
    }

    public int Z(View view) {
        this.bZZ = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.bZX) {
            this.mContentWidth -= measuredWidth;
        } else {
            if (this.bZT != null) {
                addViewInLayout(this.bZT, -1, this.bZT.getLayoutParams(), true);
                this.mContentWidth += this.bZT.getMeasuredWidth();
            }
            this.mContentWidth -= measuredWidth;
            this.bZX = true;
        }
        this.bZI--;
        removeViewInLayout(view);
        this.bZY.add(view);
        int childCount = getChildCount();
        for (int i = indexOfChild; i < childCount; i++) {
            View childAt = getChildAt(i);
            childAt.offsetLeftAndRight(-measuredWidth);
            TranslateAnimation translateAnimation = new TranslateAnimation(measuredWidth, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(500L);
            translateAnimation.setFillAfter(true);
            childAt.startAnimation(translateAnimation);
        }
        int scrollX = getScrollX();
        if (!canScroll()) {
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, 500);
            postInvalidate();
        } else if (scrollX > ahM()) {
            this.mScroller.startScroll(scrollX, 0, ahM() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean ahR() {
        return this.bZZ;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.cad);
        this.mScroller.forceFinished(true);
        this.bZL.forceFinished(true);
        if (this.bZF != null) {
            this.bZF.setVisibility(0);
            this.bZF = null;
        }
        this.bZG = -1;
        this.bZN = false;
        this.bZO = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.cab = false;
    }

    public void notifyDataSetChanged() {
        this.mScroller.forceFinished(true);
        this.bZL.forceFinished(true);
        requestLayout();
    }

    public void setCenterStart(boolean z) {
        this.cac = z;
    }
}
