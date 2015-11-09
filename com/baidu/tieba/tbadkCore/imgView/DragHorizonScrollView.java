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
    private int bTw;
    private BaseAdapter bce;
    private final float dbP;
    private View dbQ;
    private int dbR;
    private com.baidu.tieba.tbadkCore.imgView.a dbS;
    private int dbT;
    private int dbU;
    private int dbV;
    private Scroller dbW;
    private Rect dbX;
    private boolean dbY;
    private boolean dbZ;
    private a dca;
    private int dcb;
    private int dcc;
    private boolean dcd;
    private View dce;
    private final int dcf;
    private final int dcg;
    private int dch;
    private boolean dci;
    private ArrayList<View> dcj;
    private boolean dck;
    private boolean dcl;
    private boolean dcm;
    private boolean dcn;
    private Runnable dco;
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
        this.dbP = 2.0f;
        this.dbX = new Rect();
        this.dcc = 10;
        this.dcf = 300;
        this.dcg = 500;
        this.dcj = new ArrayList<>();
        this.dcn = false;
        this.dco = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dbP = 2.0f;
        this.dbX = new Rect();
        this.dcc = 10;
        this.dcf = 300;
        this.dcg = 500;
        this.dcj = new ArrayList<>();
        this.dcn = false;
        this.dco = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dbP = 2.0f;
        this.dbX = new Rect();
        this.dcc = 10;
        this.dcf = 300;
        this.dcg = 500;
        this.dcj = new ArrayList<>();
        this.dcn = false;
        this.dco = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.dbQ = null;
        this.dbR = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.dbW = new Scroller(context);
        this.dcb = getResources().getDimensionPixelSize(i.d.editor_muti_image_upload_scrollview_paddingleft);
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
        this.bTw = this.bce == null ? 0 : this.bce.getCount();
        this.bTw = Math.min(this.dcc, this.bTw);
        if (this.bTw <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View ln = ln(0);
            f(ln, i, i2);
            i4 = ln.getMeasuredWidth();
            i3 = ln.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] m = m(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(m[0], i);
                this.dcl = true;
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
        this.dbT = i;
        this.dbU = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.dce) {
                this.dcj.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.dcb;
        if (this.dcn) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(i.d.default_gap_24);
            if (this.bTw > 0) {
                View ln = ln(0);
                f(ln, this.dbT, this.dbU);
                paddingLeft = ((getMeasuredWidth() - ln.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.dce != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.dcb * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.dce.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.dce.setLayoutParams(layoutParams);
                f(this.dce, this.dbT, this.dbU);
                paddingLeft = ((getMeasuredWidth() - this.dce.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.bTw; i7++) {
            View ln2 = ln(i7);
            if (ln2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = ln2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    ln2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(ln2, -1, layoutParams2, true);
                f(ln2, this.dbT, this.dbU);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = ln2.getMeasuredWidth() + i6;
                ln2.layout(i6, paddingTop, measuredWidth2, ln2.getMeasuredHeight() + paddingTop);
                ln2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.dce != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.dcb * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.dce.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.dce.setLayoutParams(layoutParams3);
            f(this.dce, this.dbT, this.dbU);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.dce.getMeasuredWidth() + i6;
            this.dce.layout(i6, paddingTop2, measuredWidth4, this.dce.getMeasuredHeight() + paddingTop2);
            if (this.bTw == this.dcc) {
                i6 = measuredWidth4 - this.dce.getMeasuredWidth();
                this.dci = false;
            } else {
                addViewInLayout(this.dce, -1, this.dce.getLayoutParams(), true);
                this.dci = true;
                i6 = measuredWidth4;
            }
        }
        this.dbV = (this.dcb + i6) - this.mPadding;
        if (this.dcd || z) {
            scrollTo(0, 0);
            scrollBy(axN(), 0);
            this.dcd = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.dbV > getMeasuredWidth();
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
                    if (!this.dbW.isFinished()) {
                        removeCallbacks(this.dco);
                        this.dbW.forceFinished(true);
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
                    if (!this.dbW.isFinished()) {
                        removeCallbacks(this.dco);
                        this.dbW.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.dco);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.dch = i2;
                        this.dbW.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.dco);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    lo((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bce = baseAdapter;
        this.mScroller.forceFinished(true);
        this.dbW.forceFinished(true);
        if (!this.dcd && z) {
            this.dcd = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bce;
    }

    private View ln(int i) {
        View view = null;
        if (this.dcj.size() > 0) {
            view = this.dcj.remove(0);
        }
        View view2 = this.bce.getView(i, view, this);
        if (view2 != view) {
            this.dcj.add(view);
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
        if (this.bce == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.bTw - 1;
        }
        while (i <= i2) {
            View ln = ln(i);
            if (ln.getVisibility() != 8) {
                f(ln, i3, i4);
                paddingRight += ln.getMeasuredWidth();
                paddingTop = Math.max(ln.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int axN() {
        if (canScroll()) {
            return this.dbV - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lo(int i) {
        scrollBy(lp(i), 0);
        invalidate();
    }

    private int lp(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > axN()) {
                i = axN() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.dcm) {
            this.dcm = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.dbS.a(view, null);
            this.dbQ = view;
            this.dbR = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.dbY || this.dbZ) && this.dbS != null) {
                this.dbS.axM();
                return;
            }
            return;
        }
        this.dbY = false;
        this.dbZ = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.dbS = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.dbR && (childAt = getChildAt(i)) != this.dce) {
                childAt.getHitRect(this.dbX);
                if (this.dbX.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.dbR;
                    aJ(i2, i);
                    aI(i2, i);
                    this.dbR = i;
                    return;
                }
            }
        }
    }

    private void aI(int i, int i2) {
        if (this.dca != null) {
            this.dca.H(i, i2);
        }
    }

    private void aJ(int i, int i2) {
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
    public void axO() {
        if (!this.dbY) {
            this.dbY = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void axP() {
        if (!this.dbZ) {
            this.dbZ = true;
            int axN = axN();
            int scrollX = getScrollX();
            int scrollX2 = axN - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void axQ() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.dbY = false;
        this.dbZ = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void axR() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.dca = aVar;
    }

    public void setMaxItemNum(int i) {
        this.dcc = i;
    }

    public int getMaxItemNum() {
        return this.dcc;
    }

    public void setAddView(View view) {
        this.dce = view;
    }

    public int aw(View view) {
        this.dck = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.dci) {
            this.dbV -= measuredWidth;
        } else {
            if (this.dce != null) {
                addViewInLayout(this.dce, -1, this.dce.getLayoutParams(), true);
                this.dbV += this.dce.getMeasuredWidth();
            }
            this.dbV -= measuredWidth;
            this.dci = true;
        }
        this.bTw--;
        removeViewInLayout(view);
        this.dcj.add(view);
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
        } else if (scrollX > axN()) {
            this.mScroller.startScroll(scrollX, 0, axN() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean axS() {
        return this.dck;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.dco);
        this.mScroller.forceFinished(true);
        this.dbW.forceFinished(true);
        if (this.dbQ != null) {
            this.dbQ.setVisibility(0);
            this.dbQ = null;
        }
        this.dbR = -1;
        this.dbY = false;
        this.dbZ = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.dcm = false;
    }

    public void setCenterStart(boolean z) {
        this.dcn = z;
    }
}
