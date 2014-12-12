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
    private final float bXL;
    private BaseAdapter bXM;
    private View bXN;
    private int bXO;
    private a bXP;
    private int bXQ;
    private int bXR;
    private int bXS;
    private Scroller bXT;
    private Rect bXU;
    private boolean bXV;
    private boolean bXW;
    private d bXX;
    private int bXY;
    private int bXZ;
    private boolean bYa;
    private View bYb;
    private final int bYc;
    private final int bYd;
    private int bYe;
    private boolean bYf;
    private ArrayList<View> bYg;
    private boolean bYh;
    private boolean bYi;
    private boolean bYj;
    private boolean bYk;
    private Runnable bYl;
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
        this.bXL = 2.0f;
        this.bXU = new Rect();
        this.bXZ = 10;
        this.bYc = 300;
        this.bYd = 500;
        this.bYg = new ArrayList<>();
        this.bYk = false;
        this.bYl = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bXL = 2.0f;
        this.bXU = new Rect();
        this.bXZ = 10;
        this.bYc = 300;
        this.bYd = 500;
        this.bYg = new ArrayList<>();
        this.bYk = false;
        this.bYl = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bXL = 2.0f;
        this.bXU = new Rect();
        this.bXZ = 10;
        this.bYc = 300;
        this.bYd = 500;
        this.bYg = new ArrayList<>();
        this.bYk = false;
        this.bYl = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.bXN = null;
        this.bXO = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.bXT = new Scroller(context);
        this.bXY = getResources().getDimensionPixelSize(u.editor_muti_image_upload_scrollview_paddingleft);
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
        this.bXQ = this.bXM == null ? 0 : this.bXM.getCount();
        this.bXQ = Math.min(this.bXZ, this.bXQ);
        if (this.bXQ <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View hT = hT(0);
            g(hT, i, i2);
            i4 = hT.getMeasuredWidth();
            i3 = hT.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] h = h(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(h[0], i);
                this.bYi = true;
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
        this.bXR = i;
        this.bXS = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.bYb) {
                this.bYg.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.bXY;
        if (this.bYk) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(u.default_gap_24);
            if (this.bXQ > 0) {
                View hT = hT(0);
                g(hT, this.bXR, this.bXS);
                paddingLeft = ((getMeasuredWidth() - hT.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.bYb != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.bXY * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.bYb.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.bYb.setLayoutParams(layoutParams);
                g(this.bYb, this.bXR, this.bXS);
                paddingLeft = ((getMeasuredWidth() - this.bYb.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.bXQ; i7++) {
            View hT2 = hT(i7);
            if (hT2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = hT2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    hT2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(hT2, -1, layoutParams2, true);
                g(hT2, this.bXR, this.bXS);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = hT2.getMeasuredWidth() + i6;
                hT2.layout(i6, paddingTop, measuredWidth2, hT2.getMeasuredHeight() + paddingTop);
                hT2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.bYb != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.bXY * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.bYb.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.bYb.setLayoutParams(layoutParams3);
            g(this.bYb, this.bXR, this.bXS);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.bYb.getMeasuredWidth() + i6;
            this.bYb.layout(i6, paddingTop2, measuredWidth4, this.bYb.getMeasuredHeight() + paddingTop2);
            if (this.bXQ == this.bXZ) {
                i6 = measuredWidth4 - this.bYb.getMeasuredWidth();
                this.bYf = false;
            } else {
                addViewInLayout(this.bYb, -1, this.bYb.getLayoutParams(), true);
                this.bYf = true;
                i6 = measuredWidth4;
            }
        }
        this.mContentWidth = (this.bXY + i6) - this.mPadding;
        if (this.bYa || z) {
            scrollTo(0, 0);
            scrollBy(ahn(), 0);
            this.bYa = false;
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
                    if (!this.bXT.isFinished()) {
                        removeCallbacks(this.bYl);
                        this.bXT.forceFinished(true);
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
                    if (!this.bXT.isFinished()) {
                        removeCallbacks(this.bYl);
                        this.bXT.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.bYl);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.bYe = i2;
                        this.bXT.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.bYl);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    hU((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bXM = baseAdapter;
        this.mScroller.forceFinished(true);
        this.bXT.forceFinished(true);
        if (!this.bYa && z) {
            this.bYa = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bXM;
    }

    private View hT(int i) {
        View view = null;
        if (this.bYg.size() > 0) {
            view = this.bYg.remove(0);
        }
        View view2 = this.bXM.getView(i, view, this);
        if (view2 != view) {
            this.bYg.add(view);
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
        if (this.bXM == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.bXQ - 1;
        }
        while (i <= i2) {
            View hT = hT(i);
            if (hT.getVisibility() != 8) {
                g(hT, i3, i4);
                paddingRight += hT.getMeasuredWidth();
                paddingTop = Math.max(hT.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ahn() {
        if (canScroll()) {
            return this.mContentWidth - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU(int i) {
        scrollBy(hV(i), 0);
        invalidate();
    }

    private int hV(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > ahn()) {
                i = ahn() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.bYj) {
            this.bYj = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.bXP.a(view, null);
            this.bXN = view;
            this.bXO = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.bXV || this.bXW) && this.bXP != null) {
                this.bXP.ahm();
                return;
            }
            return;
        }
        this.bXV = false;
        this.bXW = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(a aVar) {
        this.bXP = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.bXO && (childAt = getChildAt(i)) != this.bYb) {
                childAt.getHitRect(this.bXU);
                if (this.bXU.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.bXO;
                    ae(i2, i);
                    ad(i2, i);
                    this.bXO = i;
                    return;
                }
            }
        }
    }

    private void ad(int i, int i2) {
        if (this.bXX != null) {
            this.bXX.aa(i, i2);
        }
    }

    private void ae(int i, int i2) {
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
    public void aho() {
        if (!this.bXV) {
            this.bXV = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void ahp() {
        if (!this.bXW) {
            this.bXW = true;
            int ahn = ahn();
            int scrollX = getScrollX();
            int scrollX2 = ahn - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void ahq() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.bXV = false;
        this.bXW = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void ahr() {
        reset();
    }

    public void setOnSwapDataListener(d dVar) {
        this.bXX = dVar;
    }

    public void setMaxItemNum(int i) {
        this.bXZ = i;
    }

    public int getMaxItemNum() {
        return this.bXZ;
    }

    public void setAddView(View view) {
        this.bYb = view;
    }

    public int X(View view) {
        this.bYh = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.bYf) {
            this.mContentWidth -= measuredWidth;
        } else {
            if (this.bYb != null) {
                addViewInLayout(this.bYb, -1, this.bYb.getLayoutParams(), true);
                this.mContentWidth += this.bYb.getMeasuredWidth();
            }
            this.mContentWidth -= measuredWidth;
            this.bYf = true;
        }
        this.bXQ--;
        removeViewInLayout(view);
        this.bYg.add(view);
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
        } else if (scrollX > ahn()) {
            this.mScroller.startScroll(scrollX, 0, ahn() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean ahs() {
        return this.bYh;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.bYl);
        this.mScroller.forceFinished(true);
        this.bXT.forceFinished(true);
        if (this.bXN != null) {
            this.bXN.setVisibility(0);
            this.bXN = null;
        }
        this.bXO = -1;
        this.bXV = false;
        this.bXW = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.bYj = false;
    }

    public void notifyDataSetChanged() {
        this.mScroller.forceFinished(true);
        this.bXT.forceFinished(true);
        requestLayout();
    }

    public void setCenterStart(boolean z) {
        this.bYk = z;
    }
}
