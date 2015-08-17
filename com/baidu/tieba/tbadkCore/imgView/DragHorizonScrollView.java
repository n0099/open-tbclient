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
    private int bOI;
    private BaseAdapter bbb;
    private final float cJB;
    private View cJC;
    private int cJD;
    private com.baidu.tieba.tbadkCore.imgView.a cJE;
    private int cJF;
    private int cJG;
    private int cJH;
    private Scroller cJI;
    private Rect cJJ;
    private boolean cJK;
    private boolean cJL;
    private a cJM;
    private int cJN;
    private int cJO;
    private boolean cJP;
    private View cJQ;
    private final int cJR;
    private final int cJS;
    private int cJT;
    private boolean cJU;
    private ArrayList<View> cJV;
    private boolean cJW;
    private boolean cJX;
    private boolean cJY;
    private boolean cJZ;
    private Runnable cKa;
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
        this.cJB = 2.0f;
        this.cJJ = new Rect();
        this.cJO = 10;
        this.cJR = 300;
        this.cJS = 500;
        this.cJV = new ArrayList<>();
        this.cJZ = false;
        this.cKa = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cJB = 2.0f;
        this.cJJ = new Rect();
        this.cJO = 10;
        this.cJR = 300;
        this.cJS = 500;
        this.cJV = new ArrayList<>();
        this.cJZ = false;
        this.cKa = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cJB = 2.0f;
        this.cJJ = new Rect();
        this.cJO = 10;
        this.cJR = 300;
        this.cJS = 500;
        this.cJV = new ArrayList<>();
        this.cJZ = false;
        this.cKa = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.cJC = null;
        this.cJD = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.cJI = new Scroller(context);
        this.cJN = getResources().getDimensionPixelSize(i.d.editor_muti_image_upload_scrollview_paddingleft);
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
        this.bOI = this.bbb == null ? 0 : this.bbb.getCount();
        this.bOI = Math.min(this.cJO, this.bOI);
        if (this.bOI <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View jL = jL(0);
            f(jL, i, i2);
            i4 = jL.getMeasuredWidth();
            i3 = jL.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] l = l(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(l[0], i);
                this.cJX = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(l[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.cJF = i;
        this.cJG = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.cJQ) {
                this.cJV.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.cJN;
        if (this.cJZ) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.default_gap_24);
            if (this.bOI > 0) {
                View jL = jL(0);
                f(jL, this.cJF, this.cJG);
                paddingLeft = ((getMeasuredWidth() - jL.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.cJQ != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.cJN * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.cJQ.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.cJQ.setLayoutParams(layoutParams);
                f(this.cJQ, this.cJF, this.cJG);
                paddingLeft = ((getMeasuredWidth() - this.cJQ.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.bOI; i7++) {
            View jL2 = jL(i7);
            if (jL2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = jL2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    jL2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(jL2, -1, layoutParams2, true);
                f(jL2, this.cJF, this.cJG);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = jL2.getMeasuredWidth() + i6;
                jL2.layout(i6, paddingTop, measuredWidth2, jL2.getMeasuredHeight() + paddingTop);
                jL2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.cJQ != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.cJN * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.cJQ.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.cJQ.setLayoutParams(layoutParams3);
            f(this.cJQ, this.cJF, this.cJG);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.cJQ.getMeasuredWidth() + i6;
            this.cJQ.layout(i6, paddingTop2, measuredWidth4, this.cJQ.getMeasuredHeight() + paddingTop2);
            if (this.bOI == this.cJO) {
                i6 = measuredWidth4 - this.cJQ.getMeasuredWidth();
                this.cJU = false;
            } else {
                addViewInLayout(this.cJQ, -1, this.cJQ.getLayoutParams(), true);
                this.cJU = true;
                i6 = measuredWidth4;
            }
        }
        this.cJH = (this.cJN + i6) - this.mPadding;
        if (this.cJP || z) {
            scrollTo(0, 0);
            scrollBy(aqo(), 0);
            this.cJP = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.cJH > getMeasuredWidth();
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
                    if (!this.cJI.isFinished()) {
                        removeCallbacks(this.cKa);
                        this.cJI.forceFinished(true);
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
                    if (!this.cJI.isFinished()) {
                        removeCallbacks(this.cKa);
                        this.cJI.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.cKa);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cJT = i2;
                        this.cJI.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.cKa);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    jM((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bbb = baseAdapter;
        this.mScroller.forceFinished(true);
        this.cJI.forceFinished(true);
        if (!this.cJP && z) {
            this.cJP = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bbb;
    }

    private View jL(int i) {
        View view = null;
        if (this.cJV.size() > 0) {
            view = this.cJV.remove(0);
        }
        View view2 = this.bbb.getView(i, view, this);
        if (view2 != view) {
            this.cJV.add(view);
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

    private int[] l(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.bbb == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.bOI - 1;
        }
        while (i <= i2) {
            View jL = jL(i);
            if (jL.getVisibility() != 8) {
                f(jL, i3, i4);
                paddingRight += jL.getMeasuredWidth();
                paddingTop = Math.max(jL.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aqo() {
        if (canScroll()) {
            return this.cJH - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jM(int i) {
        scrollBy(jN(i), 0);
        invalidate();
    }

    private int jN(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > aqo()) {
                i = aqo() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.cJY) {
            this.cJY = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.cJE.a(view, null);
            this.cJC = view;
            this.cJD = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.cJK || this.cJL) && this.cJE != null) {
                this.cJE.aqn();
                return;
            }
            return;
        }
        this.cJK = false;
        this.cJL = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.cJE = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.cJD && (childAt = getChildAt(i)) != this.cJQ) {
                childAt.getHitRect(this.cJJ);
                if (this.cJJ.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.cJD;
                    az(i2, i);
                    ay(i2, i);
                    this.cJD = i;
                    return;
                }
            }
        }
    }

    private void ay(int i, int i2) {
        if (this.cJM != null) {
            this.cJM.H(i, i2);
        }
    }

    private void az(int i, int i2) {
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
    public void aqp() {
        if (!this.cJK) {
            this.cJK = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aqq() {
        if (!this.cJL) {
            this.cJL = true;
            int aqo = aqo();
            int scrollX = getScrollX();
            int scrollX2 = aqo - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aqr() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.cJK = false;
        this.cJL = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aqs() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.cJM = aVar;
    }

    public void setMaxItemNum(int i) {
        this.cJO = i;
    }

    public int getMaxItemNum() {
        return this.cJO;
    }

    public void setAddView(View view) {
        this.cJQ = view;
    }

    public int an(View view) {
        this.cJW = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.cJU) {
            this.cJH -= measuredWidth;
        } else {
            if (this.cJQ != null) {
                addViewInLayout(this.cJQ, -1, this.cJQ.getLayoutParams(), true);
                this.cJH += this.cJQ.getMeasuredWidth();
            }
            this.cJH -= measuredWidth;
            this.cJU = true;
        }
        this.bOI--;
        removeViewInLayout(view);
        this.cJV.add(view);
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
        } else if (scrollX > aqo()) {
            this.mScroller.startScroll(scrollX, 0, aqo() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean aqt() {
        return this.cJW;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.cKa);
        this.mScroller.forceFinished(true);
        this.cJI.forceFinished(true);
        if (this.cJC != null) {
            this.cJC.setVisibility(0);
            this.cJC = null;
        }
        this.cJD = -1;
        this.cJK = false;
        this.cJL = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.cJY = false;
    }

    public void setCenterStart(boolean z) {
        this.cJZ = z;
    }
}
