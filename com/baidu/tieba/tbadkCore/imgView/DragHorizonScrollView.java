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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, f, g {
    private int cOR;
    private int cPY;
    private int cQS;
    private BaseAdapter chU;
    private final float fDI;
    private View fDJ;
    private int fDK;
    private b fDL;
    private int fDM;
    private int fDN;
    private Scroller fDO;
    private Rect fDP;
    private boolean fDQ;
    private boolean fDR;
    private a fDS;
    private int fDT;
    private int fDU;
    private boolean fDV;
    private View fDW;
    private final int fDX;
    private final int fDY;
    private boolean fDZ;
    private ArrayList<View> fEa;
    private boolean fEb;
    private boolean fEc;
    private boolean fEd;
    private boolean fEe;
    private Runnable fEf;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void D(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.fDI = 2.0f;
        this.fDP = new Rect();
        this.fDU = 10;
        this.fDX = 300;
        this.fDY = 500;
        this.fEa = new ArrayList<>();
        this.fEe = false;
        this.fEf = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fDI = 2.0f;
        this.fDP = new Rect();
        this.fDU = 10;
        this.fDX = 300;
        this.fDY = 500;
        this.fEa = new ArrayList<>();
        this.fEe = false;
        this.fEf = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDI = 2.0f;
        this.fDP = new Rect();
        this.fDU = 10;
        this.fDX = 300;
        this.fDY = 500;
        this.fEa = new ArrayList<>();
        this.fEe = false;
        this.fEf = new c(this);
        init(context);
    }

    private void init(Context context) {
        this.fDJ = null;
        this.fDK = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.fDO = new Scroller(context);
        this.fDT = getResources().getDimensionPixelSize(r.e.ds66);
        this.mPadding = getResources().getDimensionPixelSize(r.e.ds32);
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
        this.cQS = this.chU == null ? 0 : this.chU.getCount();
        this.cQS = Math.min(this.fDU, this.cQS);
        if (this.cQS <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View sj = sj(0);
            j(sj, i, i2);
            i4 = sj.getMeasuredWidth();
            i3 = sj.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] s = s(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(s[0], i);
                this.fEc = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(s[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.fDM = i;
        this.cOR = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.fDW) {
                this.fEa.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.fDT;
        if (this.fEe) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds32);
            if (this.cQS > 0) {
                View sj = sj(0);
                j(sj, this.fDM, this.cOR);
                paddingLeft = ((getMeasuredWidth() - sj.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.fDW != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.fDT * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.fDW.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.fDW.setLayoutParams(layoutParams);
                j(this.fDW, this.fDM, this.cOR);
                paddingLeft = ((getMeasuredWidth() - this.fDW.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.cQS; i7++) {
            View sj2 = sj(i7);
            if (sj2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = sj2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    sj2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(sj2, -1, layoutParams2, true);
                j(sj2, this.fDM, this.cOR);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = sj2.getMeasuredWidth() + i6;
                sj2.layout(i6, paddingTop, measuredWidth2, sj2.getMeasuredHeight() + paddingTop);
                sj2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.fDW != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.fDT * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.fDW.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.fDW.setLayoutParams(layoutParams3);
            j(this.fDW, this.fDM, this.cOR);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.fDW.getMeasuredWidth() + i6;
            this.fDW.layout(i6, paddingTop2, measuredWidth4, this.fDW.getMeasuredHeight() + paddingTop2);
            if (this.cQS == this.fDU) {
                i6 = measuredWidth4 - this.fDW.getMeasuredWidth();
                this.fDZ = false;
            } else {
                addViewInLayout(this.fDW, -1, this.fDW.getLayoutParams(), true);
                this.fDZ = true;
                i6 = measuredWidth4;
            }
        }
        this.fDN = (this.fDT + i6) - this.mPadding;
        if (this.fDV || z) {
            scrollTo(0, 0);
            scrollBy(bmD(), 0);
            this.fDV = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.fDN > getMeasuredWidth();
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
                    if (!this.fDO.isFinished()) {
                        removeCallbacks(this.fEf);
                        this.fDO.forceFinished(true);
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
                    if (!this.fDO.isFinished()) {
                        removeCallbacks(this.fEf);
                        this.fDO.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.fEf);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cPY = i2;
                        this.fDO.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.fEf);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    sk((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.chU = baseAdapter;
        this.mScroller.forceFinished(true);
        this.fDO.forceFinished(true);
        if (!this.fDV && z) {
            this.fDV = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.chU;
    }

    private View sj(int i) {
        View view = null;
        if (this.fEa.size() > 0) {
            view = this.fEa.remove(0);
        }
        View view2 = this.chU.getView(i, view, this);
        if (view2 != view) {
            this.fEa.add(view);
        }
        if (view2 != null) {
            view2.setOnLongClickListener(this);
        }
        return view2;
    }

    private void j(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view.setLayoutParams(layoutParams);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    private int[] s(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.chU == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.cQS - 1;
        }
        while (i <= i2) {
            View sj = sj(i);
            if (sj.getVisibility() != 8) {
                j(sj, i3, i4);
                paddingRight += sj.getMeasuredWidth();
                paddingTop = Math.max(sj.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bmD() {
        if (canScroll()) {
            return this.fDN - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sk(int i) {
        scrollBy(sl(i), 0);
        invalidate();
    }

    private int sl(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bmD()) {
                i = bmD() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.fEd) {
            this.fEd = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.fDL.a(view, null);
            this.fDJ = view;
            this.fDK = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.fDQ || this.fDR) && this.fDL != null) {
                this.fDL.bmC();
                return;
            }
            return;
        }
        this.fDQ = false;
        this.fDR = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(b bVar) {
        this.fDL = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.fDK && (childAt = getChildAt(i)) != this.fDW) {
                childAt.getHitRect(this.fDP);
                if (this.fDP.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.fDK;
                    bz(i2, i);
                    by(i2, i);
                    this.fDK = i;
                    return;
                }
            }
        }
    }

    private void by(int i, int i2) {
        if (this.fDS != null) {
            this.fDS.D(i, i2);
        }
    }

    private void bz(int i, int i2) {
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
    public void bmE() {
        if (!this.fDQ) {
            this.fDQ = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bmF() {
        if (!this.fDR) {
            this.fDR = true;
            int bmD = bmD();
            int scrollX = getScrollX();
            int scrollX2 = bmD - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bmG() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.fDQ = false;
        this.fDR = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bmH() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.fDS = aVar;
    }

    public void setMaxItemNum(int i) {
        this.fDU = i;
    }

    public int getMaxItemNum() {
        return this.fDU;
    }

    public void setAddView(View view) {
        this.fDW = view;
    }

    public int bp(View view) {
        this.fEb = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.fDZ) {
            this.fDN -= measuredWidth;
        } else {
            if (this.fDW != null) {
                addViewInLayout(this.fDW, -1, this.fDW.getLayoutParams(), true);
                this.fDN += this.fDW.getMeasuredWidth();
            }
            this.fDN -= measuredWidth;
            this.fDZ = true;
        }
        this.cQS--;
        removeViewInLayout(view);
        this.fEa.add(view);
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
        } else if (scrollX > bmD()) {
            this.mScroller.startScroll(scrollX, 0, bmD() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new d(this), 500L);
        return indexOfChild;
    }

    public boolean bmI() {
        return this.fEb;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.fEf);
        this.mScroller.forceFinished(true);
        this.fDO.forceFinished(true);
        if (this.fDJ != null) {
            this.fDJ.setVisibility(0);
            this.fDJ = null;
        }
        this.fDK = -1;
        this.fDQ = false;
        this.fDR = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.fEd = false;
    }

    public void setCenterStart(boolean z) {
        this.fEe = z;
    }
}
