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
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, e, f {
    private BaseAdapter bQQ;
    private int cur;
    private int cvx;
    private int cwr;
    private final float eYZ;
    private View eZa;
    private int eZb;
    private com.baidu.tieba.tbadkCore.imgView.a eZc;
    private int eZd;
    private int eZe;
    private Scroller eZf;
    private Rect eZg;
    private boolean eZh;
    private boolean eZi;
    private a eZj;
    private int eZk;
    private int eZl;
    private boolean eZm;
    private View eZn;
    private final int eZo;
    private final int eZp;
    private boolean eZq;
    private ArrayList<View> eZr;
    private boolean eZs;
    private boolean eZt;
    private boolean eZu;
    private boolean eZv;
    private Runnable eZw;
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
        this.eYZ = 2.0f;
        this.eZg = new Rect();
        this.eZl = 10;
        this.eZo = 300;
        this.eZp = 500;
        this.eZr = new ArrayList<>();
        this.eZv = false;
        this.eZw = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eYZ = 2.0f;
        this.eZg = new Rect();
        this.eZl = 10;
        this.eZo = 300;
        this.eZp = 500;
        this.eZr = new ArrayList<>();
        this.eZv = false;
        this.eZw = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eYZ = 2.0f;
        this.eZg = new Rect();
        this.eZl = 10;
        this.eZo = 300;
        this.eZp = 500;
        this.eZr = new ArrayList<>();
        this.eZv = false;
        this.eZw = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.eZa = null;
        this.eZb = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.eZf = new Scroller(context);
        this.eZk = getResources().getDimensionPixelSize(u.e.ds66);
        this.mPadding = getResources().getDimensionPixelSize(u.e.ds32);
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
        this.cwr = this.bQQ == null ? 0 : this.bQQ.getCount();
        this.cwr = Math.min(this.eZl, this.cwr);
        if (this.cwr <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View qI = qI(0);
            j(qI, i, i2);
            i4 = qI.getMeasuredWidth();
            i3 = qI.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] q = q(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(q[0], i);
                this.eZt = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(q[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.eZd = i;
        this.cur = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.eZn) {
                this.eZr.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.eZk;
        if (this.eZv) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(u.e.ds32);
            if (this.cwr > 0) {
                View qI = qI(0);
                j(qI, this.eZd, this.cur);
                paddingLeft = ((getMeasuredWidth() - qI.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.eZn != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.eZk * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.eZn.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.eZn.setLayoutParams(layoutParams);
                j(this.eZn, this.eZd, this.cur);
                paddingLeft = ((getMeasuredWidth() - this.eZn.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.cwr; i7++) {
            View qI2 = qI(i7);
            if (qI2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = qI2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    qI2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(qI2, -1, layoutParams2, true);
                j(qI2, this.eZd, this.cur);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = qI2.getMeasuredWidth() + i6;
                qI2.layout(i6, paddingTop, measuredWidth2, qI2.getMeasuredHeight() + paddingTop);
                qI2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.eZn != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.eZk * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.eZn.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.eZn.setLayoutParams(layoutParams3);
            j(this.eZn, this.eZd, this.cur);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.eZn.getMeasuredWidth() + i6;
            this.eZn.layout(i6, paddingTop2, measuredWidth4, this.eZn.getMeasuredHeight() + paddingTop2);
            if (this.cwr == this.eZl) {
                i6 = measuredWidth4 - this.eZn.getMeasuredWidth();
                this.eZq = false;
            } else {
                addViewInLayout(this.eZn, -1, this.eZn.getLayoutParams(), true);
                this.eZq = true;
                i6 = measuredWidth4;
            }
        }
        this.eZe = (this.eZk + i6) - this.mPadding;
        if (this.eZm || z) {
            scrollTo(0, 0);
            scrollBy(bcL(), 0);
            this.eZm = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.eZe > getMeasuredWidth();
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
                    if (!this.eZf.isFinished()) {
                        removeCallbacks(this.eZw);
                        this.eZf.forceFinished(true);
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
                    if (!this.eZf.isFinished()) {
                        removeCallbacks(this.eZw);
                        this.eZf.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.eZw);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cvx = i2;
                        this.eZf.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.eZw);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    qJ((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bQQ = baseAdapter;
        this.mScroller.forceFinished(true);
        this.eZf.forceFinished(true);
        if (!this.eZm && z) {
            this.eZm = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bQQ;
    }

    private View qI(int i) {
        View view = null;
        if (this.eZr.size() > 0) {
            view = this.eZr.remove(0);
        }
        View view2 = this.bQQ.getView(i, view, this);
        if (view2 != view) {
            this.eZr.add(view);
        }
        view2.setOnLongClickListener(this);
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

    private int[] q(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.bQQ == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.cwr - 1;
        }
        while (i <= i2) {
            View qI = qI(i);
            if (qI.getVisibility() != 8) {
                j(qI, i3, i4);
                paddingRight += qI.getMeasuredWidth();
                paddingTop = Math.max(qI.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bcL() {
        if (canScroll()) {
            return this.eZe - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qJ(int i) {
        scrollBy(qK(i), 0);
        invalidate();
    }

    private int qK(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bcL()) {
                i = bcL() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.eZu) {
            this.eZu = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.eZc.a(view, null);
            this.eZa = view;
            this.eZb = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.eZh || this.eZi) && this.eZc != null) {
                this.eZc.bcK();
                return;
            }
            return;
        }
        this.eZh = false;
        this.eZi = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.eZc = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.eZb && (childAt = getChildAt(i)) != this.eZn) {
                childAt.getHitRect(this.eZg);
                if (this.eZg.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.eZb;
                    bk(i2, i);
                    bj(i2, i);
                    this.eZb = i;
                    return;
                }
            }
        }
    }

    private void bj(int i, int i2) {
        if (this.eZj != null) {
            this.eZj.B(i, i2);
        }
    }

    private void bk(int i, int i2) {
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
    public void bcM() {
        if (!this.eZh) {
            this.eZh = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bcN() {
        if (!this.eZi) {
            this.eZi = true;
            int bcL = bcL();
            int scrollX = getScrollX();
            int scrollX2 = bcL - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bcO() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.eZh = false;
        this.eZi = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bcP() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.eZj = aVar;
    }

    public void setMaxItemNum(int i) {
        this.eZl = i;
    }

    public int getMaxItemNum() {
        return this.eZl;
    }

    public void setAddView(View view) {
        this.eZn = view;
    }

    public int bt(View view) {
        this.eZs = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.eZq) {
            this.eZe -= measuredWidth;
        } else {
            if (this.eZn != null) {
                addViewInLayout(this.eZn, -1, this.eZn.getLayoutParams(), true);
                this.eZe += this.eZn.getMeasuredWidth();
            }
            this.eZe -= measuredWidth;
            this.eZq = true;
        }
        this.cwr--;
        removeViewInLayout(view);
        this.eZr.add(view);
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
        } else if (scrollX > bcL()) {
            this.mScroller.startScroll(scrollX, 0, bcL() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean bcQ() {
        return this.eZs;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.eZw);
        this.mScroller.forceFinished(true);
        this.eZf.forceFinished(true);
        if (this.eZa != null) {
            this.eZa.setVisibility(0);
            this.eZa = null;
        }
        this.eZb = -1;
        this.eZh = false;
        this.eZi = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.eZu = false;
    }

    public void setCenterStart(boolean z) {
        this.eZv = z;
    }
}
