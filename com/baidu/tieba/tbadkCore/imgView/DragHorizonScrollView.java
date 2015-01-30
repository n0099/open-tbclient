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
    private final float bZE;
    private BaseAdapter bZF;
    private View bZG;
    private int bZH;
    private a bZI;
    private int bZJ;
    private int bZK;
    private int bZL;
    private Scroller bZM;
    private Rect bZN;
    private boolean bZO;
    private boolean bZP;
    private d bZQ;
    private int bZR;
    private int bZS;
    private boolean bZT;
    private View bZU;
    private final int bZV;
    private final int bZW;
    private int bZX;
    private boolean bZY;
    private ArrayList<View> bZZ;
    private boolean caa;
    private boolean cab;
    private boolean cac;
    private boolean cad;
    private Runnable cae;
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
        this.bZE = 2.0f;
        this.bZN = new Rect();
        this.bZS = 10;
        this.bZV = 300;
        this.bZW = 500;
        this.bZZ = new ArrayList<>();
        this.cad = false;
        this.cae = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bZE = 2.0f;
        this.bZN = new Rect();
        this.bZS = 10;
        this.bZV = 300;
        this.bZW = 500;
        this.bZZ = new ArrayList<>();
        this.cad = false;
        this.cae = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bZE = 2.0f;
        this.bZN = new Rect();
        this.bZS = 10;
        this.bZV = 300;
        this.bZW = 500;
        this.bZZ = new ArrayList<>();
        this.cad = false;
        this.cae = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.bZG = null;
        this.bZH = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.bZM = new Scroller(context);
        this.bZR = getResources().getDimensionPixelSize(u.editor_muti_image_upload_scrollview_paddingleft);
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
        this.bZJ = this.bZF == null ? 0 : this.bZF.getCount();
        this.bZJ = Math.min(this.bZS, this.bZJ);
        if (this.bZJ <= 0 || !(mode == 0 || mode2 == 0)) {
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
                this.cab = true;
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
        this.bZK = i;
        this.bZL = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.bZU) {
                this.bZZ.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.bZR;
        if (this.cad) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(u.default_gap_24);
            if (this.bZJ > 0) {
                View ic = ic(0);
                g(ic, this.bZK, this.bZL);
                paddingLeft = ((getMeasuredWidth() - ic.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.bZU != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.bZR * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.bZU.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.bZU.setLayoutParams(layoutParams);
                g(this.bZU, this.bZK, this.bZL);
                paddingLeft = ((getMeasuredWidth() - this.bZU.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.bZJ; i7++) {
            View ic2 = ic(i7);
            if (ic2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = ic2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    ic2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(ic2, -1, layoutParams2, true);
                g(ic2, this.bZK, this.bZL);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = ic2.getMeasuredWidth() + i6;
                ic2.layout(i6, paddingTop, measuredWidth2, ic2.getMeasuredHeight() + paddingTop);
                ic2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.bZU != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.bZR * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.bZU.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.bZU.setLayoutParams(layoutParams3);
            g(this.bZU, this.bZK, this.bZL);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.bZU.getMeasuredWidth() + i6;
            this.bZU.layout(i6, paddingTop2, measuredWidth4, this.bZU.getMeasuredHeight() + paddingTop2);
            if (this.bZJ == this.bZS) {
                i6 = measuredWidth4 - this.bZU.getMeasuredWidth();
                this.bZY = false;
            } else {
                addViewInLayout(this.bZU, -1, this.bZU.getLayoutParams(), true);
                this.bZY = true;
                i6 = measuredWidth4;
            }
        }
        this.mContentWidth = (this.bZR + i6) - this.mPadding;
        if (this.bZT || z) {
            scrollTo(0, 0);
            scrollBy(ahR(), 0);
            this.bZT = false;
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
                    if (!this.bZM.isFinished()) {
                        removeCallbacks(this.cae);
                        this.bZM.forceFinished(true);
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
                    if (!this.bZM.isFinished()) {
                        removeCallbacks(this.cae);
                        this.bZM.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.cae);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.bZX = i2;
                        this.bZM.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.cae);
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
        this.bZF = baseAdapter;
        this.mScroller.forceFinished(true);
        this.bZM.forceFinished(true);
        if (!this.bZT && z) {
            this.bZT = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bZF;
    }

    private View ic(int i) {
        View view = null;
        if (this.bZZ.size() > 0) {
            view = this.bZZ.remove(0);
        }
        View view2 = this.bZF.getView(i, view, this);
        if (view2 != view) {
            this.bZZ.add(view);
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
        if (this.bZF == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.bZJ - 1;
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
    public int ahR() {
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
            if (i2 > ahR()) {
                i = ahR() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.cac) {
            this.cac = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.bZI.a(view, null);
            this.bZG = view;
            this.bZH = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.bZO || this.bZP) && this.bZI != null) {
                this.bZI.ahQ();
                return;
            }
            return;
        }
        this.bZO = false;
        this.bZP = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(a aVar) {
        this.bZI = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.bZH && (childAt = getChildAt(i)) != this.bZU) {
                childAt.getHitRect(this.bZN);
                if (this.bZN.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.bZH;
                    af(i2, i);
                    ae(i2, i);
                    this.bZH = i;
                    return;
                }
            }
        }
    }

    private void ae(int i, int i2) {
        if (this.bZQ != null) {
            this.bZQ.ab(i, i2);
        }
    }

    private void af(int i, int i2) {
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
    public void ahS() {
        if (!this.bZO) {
            this.bZO = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void ahT() {
        if (!this.bZP) {
            this.bZP = true;
            int ahR = ahR();
            int scrollX = getScrollX();
            int scrollX2 = ahR - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void ahU() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.bZO = false;
        this.bZP = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void ahV() {
        reset();
    }

    public void setOnSwapDataListener(d dVar) {
        this.bZQ = dVar;
    }

    public void setMaxItemNum(int i) {
        this.bZS = i;
    }

    public int getMaxItemNum() {
        return this.bZS;
    }

    public void setAddView(View view) {
        this.bZU = view;
    }

    public int Z(View view) {
        this.caa = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.bZY) {
            this.mContentWidth -= measuredWidth;
        } else {
            if (this.bZU != null) {
                addViewInLayout(this.bZU, -1, this.bZU.getLayoutParams(), true);
                this.mContentWidth += this.bZU.getMeasuredWidth();
            }
            this.mContentWidth -= measuredWidth;
            this.bZY = true;
        }
        this.bZJ--;
        removeViewInLayout(view);
        this.bZZ.add(view);
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
        } else if (scrollX > ahR()) {
            this.mScroller.startScroll(scrollX, 0, ahR() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean ahW() {
        return this.caa;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.cae);
        this.mScroller.forceFinished(true);
        this.bZM.forceFinished(true);
        if (this.bZG != null) {
            this.bZG.setVisibility(0);
            this.bZG = null;
        }
        this.bZH = -1;
        this.bZO = false;
        this.bZP = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.cac = false;
    }

    public void notifyDataSetChanged() {
        this.mScroller.forceFinished(true);
        this.bZM.forceFinished(true);
        requestLayout();
    }

    public void setCenterStart(boolean z) {
        this.cad = z;
    }
}
