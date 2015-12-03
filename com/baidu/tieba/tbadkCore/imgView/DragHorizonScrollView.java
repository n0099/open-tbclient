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
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, e, f {
    private BaseAdapter biJ;
    private int cjK;
    private final float dAD;
    private View dAE;
    private int dAF;
    private com.baidu.tieba.tbadkCore.imgView.a dAG;
    private int dAH;
    private int dAI;
    private int dAJ;
    private Scroller dAK;
    private Rect dAL;
    private boolean dAM;
    private boolean dAN;
    private a dAO;
    private int dAP;
    private int dAQ;
    private boolean dAR;
    private View dAS;
    private final int dAT;
    private final int dAU;
    private int dAV;
    private boolean dAW;
    private ArrayList<View> dAX;
    private boolean dAY;
    private boolean dAZ;
    private boolean dBa;
    private boolean dBb;
    private Runnable dBc;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void I(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.dAD = 2.0f;
        this.dAL = new Rect();
        this.dAQ = 10;
        this.dAT = 300;
        this.dAU = 500;
        this.dAX = new ArrayList<>();
        this.dBb = false;
        this.dBc = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dAD = 2.0f;
        this.dAL = new Rect();
        this.dAQ = 10;
        this.dAT = 300;
        this.dAU = 500;
        this.dAX = new ArrayList<>();
        this.dBb = false;
        this.dBc = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dAD = 2.0f;
        this.dAL = new Rect();
        this.dAQ = 10;
        this.dAT = 300;
        this.dAU = 500;
        this.dAX = new ArrayList<>();
        this.dBb = false;
        this.dBc = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.dAE = null;
        this.dAF = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.dAK = new Scroller(context);
        this.dAP = getResources().getDimensionPixelSize(n.d.editor_muti_image_upload_scrollview_paddingleft);
        this.mPadding = getResources().getDimensionPixelSize(n.d.default_gap_24);
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
        this.cjK = this.biJ == null ? 0 : this.biJ.getCount();
        this.cjK = Math.min(this.dAQ, this.cjK);
        if (this.cjK <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View mz = mz(0);
            e(mz, i, i2);
            i4 = mz.getMeasuredWidth();
            i3 = mz.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] m = m(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(m[0], i);
                this.dAZ = true;
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
        this.dAH = i;
        this.dAI = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.dAS) {
                this.dAX.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.dAP;
        if (this.dBb) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(n.d.default_gap_24);
            if (this.cjK > 0) {
                View mz = mz(0);
                e(mz, this.dAH, this.dAI);
                paddingLeft = ((getMeasuredWidth() - mz.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.dAS != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.dAP * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.dAS.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.dAS.setLayoutParams(layoutParams);
                e(this.dAS, this.dAH, this.dAI);
                paddingLeft = ((getMeasuredWidth() - this.dAS.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.cjK; i7++) {
            View mz2 = mz(i7);
            if (mz2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = mz2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    mz2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(mz2, -1, layoutParams2, true);
                e(mz2, this.dAH, this.dAI);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = mz2.getMeasuredWidth() + i6;
                mz2.layout(i6, paddingTop, measuredWidth2, mz2.getMeasuredHeight() + paddingTop);
                mz2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.dAS != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.dAP * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.dAS.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.dAS.setLayoutParams(layoutParams3);
            e(this.dAS, this.dAH, this.dAI);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.dAS.getMeasuredWidth() + i6;
            this.dAS.layout(i6, paddingTop2, measuredWidth4, this.dAS.getMeasuredHeight() + paddingTop2);
            if (this.cjK == this.dAQ) {
                i6 = measuredWidth4 - this.dAS.getMeasuredWidth();
                this.dAW = false;
            } else {
                addViewInLayout(this.dAS, -1, this.dAS.getLayoutParams(), true);
                this.dAW = true;
                i6 = measuredWidth4;
            }
        }
        this.dAJ = (this.dAP + i6) - this.mPadding;
        if (this.dAR || z) {
            scrollTo(0, 0);
            scrollBy(aDy(), 0);
            this.dAR = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.dAJ > getMeasuredWidth();
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
                    if (!this.dAK.isFinished()) {
                        removeCallbacks(this.dBc);
                        this.dAK.forceFinished(true);
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
                    if (!this.dAK.isFinished()) {
                        removeCallbacks(this.dBc);
                        this.dAK.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.dBc);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.dAV = i2;
                        this.dAK.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.dBc);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    mA((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.biJ = baseAdapter;
        this.mScroller.forceFinished(true);
        this.dAK.forceFinished(true);
        if (!this.dAR && z) {
            this.dAR = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.biJ;
    }

    private View mz(int i) {
        View view = null;
        if (this.dAX.size() > 0) {
            view = this.dAX.remove(0);
        }
        View view2 = this.biJ.getView(i, view, this);
        if (view2 != view) {
            this.dAX.add(view);
        }
        view2.setOnLongClickListener(this);
        return view2;
    }

    private void e(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
            view.setLayoutParams(layoutParams);
        }
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), layoutParams.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), layoutParams.height));
    }

    private int[] m(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.biJ == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.cjK - 1;
        }
        while (i <= i2) {
            View mz = mz(i);
            if (mz.getVisibility() != 8) {
                e(mz, i3, i4);
                paddingRight += mz.getMeasuredWidth();
                paddingTop = Math.max(mz.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aDy() {
        if (canScroll()) {
            return this.dAJ - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mA(int i) {
        scrollBy(mB(i), 0);
        invalidate();
    }

    private int mB(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > aDy()) {
                i = aDy() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.dBa) {
            this.dBa = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.dAG.a(view, null);
            this.dAE = view;
            this.dAF = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.dAM || this.dAN) && this.dAG != null) {
                this.dAG.aDx();
                return;
            }
            return;
        }
        this.dAM = false;
        this.dAN = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.dAG = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.dAF && (childAt = getChildAt(i)) != this.dAS) {
                childAt.getHitRect(this.dAL);
                if (this.dAL.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.dAF;
                    aM(i2, i);
                    aL(i2, i);
                    this.dAF = i;
                    return;
                }
            }
        }
    }

    private void aL(int i, int i2) {
        if (this.dAO != null) {
            this.dAO.I(i, i2);
        }
    }

    private void aM(int i, int i2) {
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
    public void aDz() {
        if (!this.dAM) {
            this.dAM = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aDA() {
        if (!this.dAN) {
            this.dAN = true;
            int aDy = aDy();
            int scrollX = getScrollX();
            int scrollX2 = aDy - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aDB() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.dAM = false;
        this.dAN = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aDC() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.dAO = aVar;
    }

    public void setMaxItemNum(int i) {
        this.dAQ = i;
    }

    public int getMaxItemNum() {
        return this.dAQ;
    }

    public void setAddView(View view) {
        this.dAS = view;
    }

    public int aG(View view) {
        this.dAY = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.dAW) {
            this.dAJ -= measuredWidth;
        } else {
            if (this.dAS != null) {
                addViewInLayout(this.dAS, -1, this.dAS.getLayoutParams(), true);
                this.dAJ += this.dAS.getMeasuredWidth();
            }
            this.dAJ -= measuredWidth;
            this.dAW = true;
        }
        this.cjK--;
        removeViewInLayout(view);
        this.dAX.add(view);
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
        } else if (scrollX > aDy()) {
            this.mScroller.startScroll(scrollX, 0, aDy() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean aDD() {
        return this.dAY;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.dBc);
        this.mScroller.forceFinished(true);
        this.dAK.forceFinished(true);
        if (this.dAE != null) {
            this.dAE.setVisibility(0);
            this.dAE = null;
        }
        this.dAF = -1;
        this.dAM = false;
        this.dAN = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.dBa = false;
    }

    public void setCenterStart(boolean z) {
        this.dBb = z;
    }
}
