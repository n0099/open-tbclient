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
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, e, f {
    private int bPP;
    private int bQV;
    private int bRQ;
    private BaseAdapter buq;
    private final float eqZ;
    private View era;
    private int erb;
    private com.baidu.tieba.tbadkCore.imgView.a erc;
    private int erd;
    private int ere;
    private Scroller erf;
    private Rect erg;
    private boolean erh;
    private boolean eri;
    private a erj;
    private int erk;
    private int erl;
    private boolean erm;
    private View ern;
    private final int ero;
    private final int erp;
    private boolean erq;
    private ArrayList<View> err;
    private boolean ers;
    private boolean ert;
    private boolean eru;
    private boolean erv;
    private Runnable erw;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    /* loaded from: classes.dex */
    public interface a {
        void B(int i, int i2);
    }

    public DragHorizonScrollView(Context context) {
        super(context);
        this.eqZ = 2.0f;
        this.erg = new Rect();
        this.erl = 10;
        this.ero = 300;
        this.erp = 500;
        this.err = new ArrayList<>();
        this.erv = false;
        this.erw = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eqZ = 2.0f;
        this.erg = new Rect();
        this.erl = 10;
        this.ero = 300;
        this.erp = 500;
        this.err = new ArrayList<>();
        this.erv = false;
        this.erw = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eqZ = 2.0f;
        this.erg = new Rect();
        this.erl = 10;
        this.ero = 300;
        this.erp = 500;
        this.err = new ArrayList<>();
        this.erv = false;
        this.erw = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.era = null;
        this.erb = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.erf = new Scroller(context);
        this.erk = getResources().getDimensionPixelSize(t.e.editor_muti_image_upload_scrollview_paddingleft);
        this.mPadding = getResources().getDimensionPixelSize(t.e.default_gap_24);
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
        this.bRQ = this.buq == null ? 0 : this.buq.getCount();
        this.bRQ = Math.min(this.erl, this.bRQ);
        if (this.bRQ <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View py = py(0);
            g(py, i, i2);
            i4 = py.getMeasuredWidth();
            i3 = py.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] p = p(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(p[0], i);
                this.ert = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(p[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.erd = i;
        this.bPP = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.ern) {
                this.err.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.erk;
        if (this.erv) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.default_gap_24);
            if (this.bRQ > 0) {
                View py = py(0);
                g(py, this.erd, this.bPP);
                paddingLeft = ((getMeasuredWidth() - py.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.ern != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.erk * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.ern.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.ern.setLayoutParams(layoutParams);
                g(this.ern, this.erd, this.bPP);
                paddingLeft = ((getMeasuredWidth() - this.ern.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.bRQ; i7++) {
            View py2 = py(i7);
            if (py2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = py2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    py2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(py2, -1, layoutParams2, true);
                g(py2, this.erd, this.bPP);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = py2.getMeasuredWidth() + i6;
                py2.layout(i6, paddingTop, measuredWidth2, py2.getMeasuredHeight() + paddingTop);
                py2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.ern != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.erk * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.ern.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.ern.setLayoutParams(layoutParams3);
            g(this.ern, this.erd, this.bPP);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.ern.getMeasuredWidth() + i6;
            this.ern.layout(i6, paddingTop2, measuredWidth4, this.ern.getMeasuredHeight() + paddingTop2);
            if (this.bRQ == this.erl) {
                i6 = measuredWidth4 - this.ern.getMeasuredWidth();
                this.erq = false;
            } else {
                addViewInLayout(this.ern, -1, this.ern.getLayoutParams(), true);
                this.erq = true;
                i6 = measuredWidth4;
            }
        }
        this.ere = (this.erk + i6) - this.mPadding;
        if (this.erm || z) {
            scrollTo(0, 0);
            scrollBy(aTR(), 0);
            this.erm = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.ere > getMeasuredWidth();
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
                    if (!this.erf.isFinished()) {
                        removeCallbacks(this.erw);
                        this.erf.forceFinished(true);
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
                    if (!this.erf.isFinished()) {
                        removeCallbacks(this.erw);
                        this.erf.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.erw);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.bQV = i2;
                        this.erf.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.erw);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    pz((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.buq = baseAdapter;
        this.mScroller.forceFinished(true);
        this.erf.forceFinished(true);
        if (!this.erm && z) {
            this.erm = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.buq;
    }

    private View py(int i) {
        View view = null;
        if (this.err.size() > 0) {
            view = this.err.remove(0);
        }
        View view2 = this.buq.getView(i, view, this);
        if (view2 != view) {
            this.err.add(view);
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

    private int[] p(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.buq == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.bRQ - 1;
        }
        while (i <= i2) {
            View py = py(i);
            if (py.getVisibility() != 8) {
                g(py, i3, i4);
                paddingRight += py.getMeasuredWidth();
                paddingTop = Math.max(py.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aTR() {
        if (canScroll()) {
            return this.ere - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pz(int i) {
        scrollBy(pA(i), 0);
        invalidate();
    }

    private int pA(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > aTR()) {
                i = aTR() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.eru) {
            this.eru = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.erc.a(view, null);
            this.era = view;
            this.erb = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.erh || this.eri) && this.erc != null) {
                this.erc.aTQ();
                return;
            }
            return;
        }
        this.erh = false;
        this.eri = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.erc = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.erb && (childAt = getChildAt(i)) != this.ern) {
                childAt.getHitRect(this.erg);
                if (this.erg.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.erb;
                    bc(i2, i);
                    bb(i2, i);
                    this.erb = i;
                    return;
                }
            }
        }
    }

    private void bb(int i, int i2) {
        if (this.erj != null) {
            this.erj.B(i, i2);
        }
    }

    private void bc(int i, int i2) {
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
    public void aTS() {
        if (!this.erh) {
            this.erh = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aTT() {
        if (!this.eri) {
            this.eri = true;
            int aTR = aTR();
            int scrollX = getScrollX();
            int scrollX2 = aTR - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aTU() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.erh = false;
        this.eri = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aTV() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.erj = aVar;
    }

    public void setMaxItemNum(int i) {
        this.erl = i;
    }

    public int getMaxItemNum() {
        return this.erl;
    }

    public void setAddView(View view) {
        this.ern = view;
    }

    public int bi(View view) {
        this.ers = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.erq) {
            this.ere -= measuredWidth;
        } else {
            if (this.ern != null) {
                addViewInLayout(this.ern, -1, this.ern.getLayoutParams(), true);
                this.ere += this.ern.getMeasuredWidth();
            }
            this.ere -= measuredWidth;
            this.erq = true;
        }
        this.bRQ--;
        removeViewInLayout(view);
        this.err.add(view);
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
        } else if (scrollX > aTR()) {
            this.mScroller.startScroll(scrollX, 0, aTR() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean aTW() {
        return this.ers;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.erw);
        this.mScroller.forceFinished(true);
        this.erf.forceFinished(true);
        if (this.era != null) {
            this.era.setVisibility(0);
            this.era = null;
        }
        this.erb = -1;
        this.erh = false;
        this.eri = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.eru = false;
    }

    public void setCenterStart(boolean z) {
        this.erv = z;
    }
}
