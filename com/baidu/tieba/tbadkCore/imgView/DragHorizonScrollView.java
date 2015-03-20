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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, f, g {
    private int bxP;
    private final float coH;
    private BaseAdapter coI;
    private View coJ;
    private int coK;
    private a coL;
    private int coM;
    private int coN;
    private Scroller coO;
    private Rect coP;
    private boolean coQ;
    private boolean coR;
    private d coS;
    private int coT;
    private int coU;
    private boolean coV;
    private View coW;
    private final int coX;
    private final int coY;
    private int coZ;
    private boolean cpa;
    private ArrayList<View> cpb;
    private boolean cpc;
    private boolean cpd;
    private boolean cpe;
    private boolean cpf;
    private Runnable cpg;
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
        this.coH = 2.0f;
        this.coP = new Rect();
        this.coU = 10;
        this.coX = 300;
        this.coY = 500;
        this.cpb = new ArrayList<>();
        this.cpf = false;
        this.cpg = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.coH = 2.0f;
        this.coP = new Rect();
        this.coU = 10;
        this.coX = 300;
        this.coY = 500;
        this.cpb = new ArrayList<>();
        this.cpf = false;
        this.cpg = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.coH = 2.0f;
        this.coP = new Rect();
        this.coU = 10;
        this.coX = 300;
        this.coY = 500;
        this.cpb = new ArrayList<>();
        this.cpf = false;
        this.cpg = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.coJ = null;
        this.coK = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.coO = new Scroller(context);
        this.coT = getResources().getDimensionPixelSize(t.editor_muti_image_upload_scrollview_paddingleft);
        this.mPadding = getResources().getDimensionPixelSize(t.default_gap_24);
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
        this.bxP = this.coI == null ? 0 : this.coI.getCount();
        this.bxP = Math.min(this.coU, this.bxP);
        if (this.bxP <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View iu = iu(0);
            f(iu, i, i2);
            i4 = iu.getMeasuredWidth();
            i3 = iu.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] h = h(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(h[0], i);
                this.cpd = true;
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
        this.coM = i;
        this.coN = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.coW) {
                this.cpb.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.coT;
        if (this.cpf) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(t.default_gap_24);
            if (this.bxP > 0) {
                View iu = iu(0);
                f(iu, this.coM, this.coN);
                paddingLeft = ((getMeasuredWidth() - iu.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.coW != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.coT * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.coW.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.coW.setLayoutParams(layoutParams);
                f(this.coW, this.coM, this.coN);
                paddingLeft = ((getMeasuredWidth() - this.coW.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.bxP; i7++) {
            View iu2 = iu(i7);
            if (iu2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = iu2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    iu2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(iu2, -1, layoutParams2, true);
                f(iu2, this.coM, this.coN);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = iu2.getMeasuredWidth() + i6;
                iu2.layout(i6, paddingTop, measuredWidth2, iu2.getMeasuredHeight() + paddingTop);
                iu2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.coW != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.coT * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.coW.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.coW.setLayoutParams(layoutParams3);
            f(this.coW, this.coM, this.coN);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.coW.getMeasuredWidth() + i6;
            this.coW.layout(i6, paddingTop2, measuredWidth4, this.coW.getMeasuredHeight() + paddingTop2);
            if (this.bxP == this.coU) {
                i6 = measuredWidth4 - this.coW.getMeasuredWidth();
                this.cpa = false;
            } else {
                addViewInLayout(this.coW, -1, this.coW.getLayoutParams(), true);
                this.cpa = true;
                i6 = measuredWidth4;
            }
        }
        this.mContentWidth = (this.coT + i6) - this.mPadding;
        if (this.coV || z) {
            scrollTo(0, 0);
            scrollBy(amN(), 0);
            this.coV = false;
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
                    if (!this.coO.isFinished()) {
                        removeCallbacks(this.cpg);
                        this.coO.forceFinished(true);
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
                    if (!this.coO.isFinished()) {
                        removeCallbacks(this.cpg);
                        this.coO.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.cpg);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.coZ = i2;
                        this.coO.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.cpg);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    iv((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.coI = baseAdapter;
        this.mScroller.forceFinished(true);
        this.coO.forceFinished(true);
        if (!this.coV && z) {
            this.coV = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.coI;
    }

    private View iu(int i) {
        View view = null;
        if (this.cpb.size() > 0) {
            view = this.cpb.remove(0);
        }
        View view2 = this.coI.getView(i, view, this);
        if (view2 != view) {
            this.cpb.add(view);
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

    private int[] h(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.coI == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.bxP - 1;
        }
        while (i <= i2) {
            View iu = iu(i);
            if (iu.getVisibility() != 8) {
                f(iu, i3, i4);
                paddingRight += iu.getMeasuredWidth();
                paddingTop = Math.max(iu.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int amN() {
        if (canScroll()) {
            return this.mContentWidth - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iv(int i) {
        scrollBy(iw(i), 0);
        invalidate();
    }

    private int iw(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > amN()) {
                i = amN() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.cpe) {
            this.cpe = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.coL.a(view, null);
            this.coJ = view;
            this.coK = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.coQ || this.coR) && this.coL != null) {
                this.coL.amM();
                return;
            }
            return;
        }
        this.coQ = false;
        this.coR = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(a aVar) {
        this.coL = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.coK && (childAt = getChildAt(i)) != this.coW) {
                childAt.getHitRect(this.coP);
                if (this.coP.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.coK;
                    aj(i2, i);
                    ai(i2, i);
                    this.coK = i;
                    return;
                }
            }
        }
    }

    private void ai(int i, int i2) {
        if (this.coS != null) {
            this.coS.af(i, i2);
        }
    }

    private void aj(int i, int i2) {
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
    public void amO() {
        if (!this.coQ) {
            this.coQ = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void amP() {
        if (!this.coR) {
            this.coR = true;
            int amN = amN();
            int scrollX = getScrollX();
            int scrollX2 = amN - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void amQ() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.coQ = false;
        this.coR = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void amR() {
        reset();
    }

    public void setOnSwapDataListener(d dVar) {
        this.coS = dVar;
    }

    public void setMaxItemNum(int i) {
        this.coU = i;
    }

    public int getMaxItemNum() {
        return this.coU;
    }

    public void setAddView(View view) {
        this.coW = view;
    }

    public int ac(View view) {
        this.cpc = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.cpa) {
            this.mContentWidth -= measuredWidth;
        } else {
            if (this.coW != null) {
                addViewInLayout(this.coW, -1, this.coW.getLayoutParams(), true);
                this.mContentWidth += this.coW.getMeasuredWidth();
            }
            this.mContentWidth -= measuredWidth;
            this.cpa = true;
        }
        this.bxP--;
        removeViewInLayout(view);
        this.cpb.add(view);
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
        } else if (scrollX > amN()) {
            this.mScroller.startScroll(scrollX, 0, amN() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean amS() {
        return this.cpc;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.cpg);
        this.mScroller.forceFinished(true);
        this.coO.forceFinished(true);
        if (this.coJ != null) {
            this.coJ.setVisibility(0);
            this.coJ = null;
        }
        this.coK = -1;
        this.coQ = false;
        this.coR = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.cpe = false;
    }

    public void notifyDataSetChanged() {
        this.mScroller.forceFinished(true);
        this.coO.forceFinished(true);
        requestLayout();
    }

    public void setCenterStart(boolean z) {
        this.cpf = z;
    }
}
