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
    private int bCg;
    private int bDm;
    private int bEh;
    private BaseAdapter bmA;
    private ArrayList<View> dIA;
    private boolean dIB;
    private boolean dIC;
    private boolean dID;
    private boolean dIE;
    private Runnable dIF;
    private final float dIi;
    private View dIj;
    private int dIk;
    private com.baidu.tieba.tbadkCore.imgView.a dIl;
    private int dIm;
    private int dIn;
    private Scroller dIo;
    private Rect dIp;
    private boolean dIq;
    private boolean dIr;
    private a dIs;
    private int dIt;
    private int dIu;
    private boolean dIv;
    private View dIw;
    private final int dIx;
    private final int dIy;
    private boolean dIz;
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
        this.dIi = 2.0f;
        this.dIp = new Rect();
        this.dIu = 10;
        this.dIx = 300;
        this.dIy = 500;
        this.dIA = new ArrayList<>();
        this.dIE = false;
        this.dIF = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dIi = 2.0f;
        this.dIp = new Rect();
        this.dIu = 10;
        this.dIx = 300;
        this.dIy = 500;
        this.dIA = new ArrayList<>();
        this.dIE = false;
        this.dIF = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dIi = 2.0f;
        this.dIp = new Rect();
        this.dIu = 10;
        this.dIx = 300;
        this.dIy = 500;
        this.dIA = new ArrayList<>();
        this.dIE = false;
        this.dIF = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.dIj = null;
        this.dIk = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.dIo = new Scroller(context);
        this.dIt = getResources().getDimensionPixelSize(n.e.editor_muti_image_upload_scrollview_paddingleft);
        this.mPadding = getResources().getDimensionPixelSize(n.e.default_gap_24);
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
        this.bEh = this.bmA == null ? 0 : this.bmA.getCount();
        this.bEh = Math.min(this.dIu, this.bEh);
        if (this.bEh <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View nb = nb(0);
            g(nb, i, i2);
            i4 = nb.getMeasuredWidth();
            i3 = nb.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] q = q(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(q[0], i);
                this.dIC = true;
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
        this.dIm = i;
        this.bCg = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.dIw) {
                this.dIA.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.dIt;
        if (this.dIE) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(n.e.default_gap_24);
            if (this.bEh > 0) {
                View nb = nb(0);
                g(nb, this.dIm, this.bCg);
                paddingLeft = ((getMeasuredWidth() - nb.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.dIw != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.dIt * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.dIw.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.dIw.setLayoutParams(layoutParams);
                g(this.dIw, this.dIm, this.bCg);
                paddingLeft = ((getMeasuredWidth() - this.dIw.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.bEh; i7++) {
            View nb2 = nb(i7);
            if (nb2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = nb2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    nb2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(nb2, -1, layoutParams2, true);
                g(nb2, this.dIm, this.bCg);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = nb2.getMeasuredWidth() + i6;
                nb2.layout(i6, paddingTop, measuredWidth2, nb2.getMeasuredHeight() + paddingTop);
                nb2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.dIw != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.dIt * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.dIw.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.dIw.setLayoutParams(layoutParams3);
            g(this.dIw, this.dIm, this.bCg);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.dIw.getMeasuredWidth() + i6;
            this.dIw.layout(i6, paddingTop2, measuredWidth4, this.dIw.getMeasuredHeight() + paddingTop2);
            if (this.bEh == this.dIu) {
                i6 = measuredWidth4 - this.dIw.getMeasuredWidth();
                this.dIz = false;
            } else {
                addViewInLayout(this.dIw, -1, this.dIw.getLayoutParams(), true);
                this.dIz = true;
                i6 = measuredWidth4;
            }
        }
        this.dIn = (this.dIt + i6) - this.mPadding;
        if (this.dIv || z) {
            scrollTo(0, 0);
            scrollBy(aFL(), 0);
            this.dIv = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.dIn > getMeasuredWidth();
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
                    if (!this.dIo.isFinished()) {
                        removeCallbacks(this.dIF);
                        this.dIo.forceFinished(true);
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
                    if (!this.dIo.isFinished()) {
                        removeCallbacks(this.dIF);
                        this.dIo.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.dIF);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.bDm = i2;
                        this.dIo.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.dIF);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    nc((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bmA = baseAdapter;
        this.mScroller.forceFinished(true);
        this.dIo.forceFinished(true);
        if (!this.dIv && z) {
            this.dIv = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bmA;
    }

    private View nb(int i) {
        View view = null;
        if (this.dIA.size() > 0) {
            view = this.dIA.remove(0);
        }
        View view2 = this.bmA.getView(i, view, this);
        if (view2 != view) {
            this.dIA.add(view);
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

    private int[] q(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.bmA == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.bEh - 1;
        }
        while (i <= i2) {
            View nb = nb(i);
            if (nb.getVisibility() != 8) {
                g(nb, i3, i4);
                paddingRight += nb.getMeasuredWidth();
                paddingTop = Math.max(nb.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aFL() {
        if (canScroll()) {
            return this.dIn - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc(int i) {
        scrollBy(nd(i), 0);
        invalidate();
    }

    private int nd(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > aFL()) {
                i = aFL() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.dID) {
            this.dID = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.dIl.a(view, null);
            this.dIj = view;
            this.dIk = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.dIq || this.dIr) && this.dIl != null) {
                this.dIl.aFK();
                return;
            }
            return;
        }
        this.dIq = false;
        this.dIr = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.dIl = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.dIk && (childAt = getChildAt(i)) != this.dIw) {
                childAt.getHitRect(this.dIp);
                if (this.dIp.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.dIk;
                    bb(i2, i);
                    ba(i2, i);
                    this.dIk = i;
                    return;
                }
            }
        }
    }

    private void ba(int i, int i2) {
        if (this.dIs != null) {
            this.dIs.I(i, i2);
        }
    }

    private void bb(int i, int i2) {
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
    public void aFM() {
        if (!this.dIq) {
            this.dIq = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aFN() {
        if (!this.dIr) {
            this.dIr = true;
            int aFL = aFL();
            int scrollX = getScrollX();
            int scrollX2 = aFL - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aFO() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.dIq = false;
        this.dIr = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void aFP() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.dIs = aVar;
    }

    public void setMaxItemNum(int i) {
        this.dIu = i;
    }

    public int getMaxItemNum() {
        return this.dIu;
    }

    public void setAddView(View view) {
        this.dIw = view;
    }

    public int aM(View view) {
        this.dIB = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.dIz) {
            this.dIn -= measuredWidth;
        } else {
            if (this.dIw != null) {
                addViewInLayout(this.dIw, -1, this.dIw.getLayoutParams(), true);
                this.dIn += this.dIw.getMeasuredWidth();
            }
            this.dIn -= measuredWidth;
            this.dIz = true;
        }
        this.bEh--;
        removeViewInLayout(view);
        this.dIA.add(view);
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
        } else if (scrollX > aFL()) {
            this.mScroller.startScroll(scrollX, 0, aFL() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean aFQ() {
        return this.dIB;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.dIF);
        this.mScroller.forceFinished(true);
        this.dIo.forceFinished(true);
        if (this.dIj != null) {
            this.dIj.setVisibility(0);
            this.dIj = null;
        }
        this.dIk = -1;
        this.dIq = false;
        this.dIr = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.dID = false;
    }

    public void setCenterStart(boolean z) {
        this.dIE = z;
    }
}
