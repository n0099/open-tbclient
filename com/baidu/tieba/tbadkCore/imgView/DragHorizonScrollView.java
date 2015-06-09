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
import com.baidu.tieba.o;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, f, g {
    private int bAQ;
    private final float csZ;
    private BaseAdapter cta;
    private View ctb;
    private int ctc;
    private a ctd;
    private int cte;
    private int ctf;
    private Scroller ctg;
    private Rect cth;
    private boolean cti;
    private boolean ctj;
    private d ctk;
    private int ctl;
    private int ctm;
    private boolean ctn;
    private View cto;
    private final int ctp;
    private final int ctq;
    private int ctr;
    private boolean cts;
    private ArrayList<View> ctt;
    private boolean ctu;
    private boolean ctv;
    private boolean ctw;
    private boolean ctx;
    private Runnable cty;
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
        this.csZ = 2.0f;
        this.cth = new Rect();
        this.ctm = 10;
        this.ctp = 300;
        this.ctq = 500;
        this.ctt = new ArrayList<>();
        this.ctx = false;
        this.cty = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.csZ = 2.0f;
        this.cth = new Rect();
        this.ctm = 10;
        this.ctp = 300;
        this.ctq = 500;
        this.ctt = new ArrayList<>();
        this.ctx = false;
        this.cty = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.csZ = 2.0f;
        this.cth = new Rect();
        this.ctm = 10;
        this.ctp = 300;
        this.ctq = 500;
        this.ctt = new ArrayList<>();
        this.ctx = false;
        this.cty = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.ctb = null;
        this.ctc = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.ctg = new Scroller(context);
        this.ctl = getResources().getDimensionPixelSize(o.editor_muti_image_upload_scrollview_paddingleft);
        this.mPadding = getResources().getDimensionPixelSize(o.default_gap_24);
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
        this.bAQ = this.cta == null ? 0 : this.cta.getCount();
        this.bAQ = Math.min(this.ctm, this.bAQ);
        if (this.bAQ <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View iT = iT(0);
            f(iT, i, i2);
            i4 = iT.getMeasuredWidth();
            i3 = iT.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] i6 = i(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(i6[0], i);
                this.ctv = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(i6[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.cte = i;
        this.ctf = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.cto) {
                this.ctt.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.ctl;
        if (this.ctx) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(o.default_gap_24);
            if (this.bAQ > 0) {
                View iT = iT(0);
                f(iT, this.cte, this.ctf);
                paddingLeft = ((getMeasuredWidth() - iT.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.cto != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.ctl * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.cto.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.cto.setLayoutParams(layoutParams);
                f(this.cto, this.cte, this.ctf);
                paddingLeft = ((getMeasuredWidth() - this.cto.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.bAQ; i7++) {
            View iT2 = iT(i7);
            if (iT2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = iT2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    iT2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(iT2, -1, layoutParams2, true);
                f(iT2, this.cte, this.ctf);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = iT2.getMeasuredWidth() + i6;
                iT2.layout(i6, paddingTop, measuredWidth2, iT2.getMeasuredHeight() + paddingTop);
                iT2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.cto != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.ctl * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.cto.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.cto.setLayoutParams(layoutParams3);
            f(this.cto, this.cte, this.ctf);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.cto.getMeasuredWidth() + i6;
            this.cto.layout(i6, paddingTop2, measuredWidth4, this.cto.getMeasuredHeight() + paddingTop2);
            if (this.bAQ == this.ctm) {
                i6 = measuredWidth4 - this.cto.getMeasuredWidth();
                this.cts = false;
            } else {
                addViewInLayout(this.cto, -1, this.cto.getLayoutParams(), true);
                this.cts = true;
                i6 = measuredWidth4;
            }
        }
        this.mContentWidth = (this.ctl + i6) - this.mPadding;
        if (this.ctn || z) {
            scrollTo(0, 0);
            scrollBy(aoU(), 0);
            this.ctn = false;
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
                    if (!this.ctg.isFinished()) {
                        removeCallbacks(this.cty);
                        this.ctg.forceFinished(true);
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
                    if (!this.ctg.isFinished()) {
                        removeCallbacks(this.cty);
                        this.ctg.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.cty);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.ctr = i2;
                        this.ctg.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.cty);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    iU((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cta = baseAdapter;
        this.mScroller.forceFinished(true);
        this.ctg.forceFinished(true);
        if (!this.ctn && z) {
            this.ctn = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cta;
    }

    private View iT(int i) {
        View view = null;
        if (this.ctt.size() > 0) {
            view = this.ctt.remove(0);
        }
        View view2 = this.cta.getView(i, view, this);
        if (view2 != view) {
            this.ctt.add(view);
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

    private int[] i(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.cta == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.bAQ - 1;
        }
        while (i <= i2) {
            View iT = iT(i);
            if (iT.getVisibility() != 8) {
                f(iT, i3, i4);
                paddingRight += iT.getMeasuredWidth();
                paddingTop = Math.max(iT.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aoU() {
        if (canScroll()) {
            return this.mContentWidth - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iU(int i) {
        scrollBy(iV(i), 0);
        invalidate();
    }

    private int iV(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > aoU()) {
                i = aoU() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.ctw) {
            this.ctw = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.ctd.a(view, null);
            this.ctb = view;
            this.ctc = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.cti || this.ctj) && this.ctd != null) {
                this.ctd.aoT();
                return;
            }
            return;
        }
        this.cti = false;
        this.ctj = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(a aVar) {
        this.ctd = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.ctc && (childAt = getChildAt(i)) != this.cto) {
                childAt.getHitRect(this.cth);
                if (this.cth.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.ctc;
                    ak(i2, i);
                    aj(i2, i);
                    this.ctc = i;
                    return;
                }
            }
        }
    }

    private void aj(int i, int i2) {
        if (this.ctk != null) {
            this.ctk.ag(i, i2);
        }
    }

    private void ak(int i, int i2) {
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
    public void aoV() {
        if (!this.cti) {
            this.cti = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void aoW() {
        if (!this.ctj) {
            this.ctj = true;
            int aoU = aoU();
            int scrollX = getScrollX();
            int scrollX2 = aoU - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void aoX() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.cti = false;
        this.ctj = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void aoY() {
        reset();
    }

    public void setOnSwapDataListener(d dVar) {
        this.ctk = dVar;
    }

    public void setMaxItemNum(int i) {
        this.ctm = i;
    }

    public int getMaxItemNum() {
        return this.ctm;
    }

    public void setAddView(View view) {
        this.cto = view;
    }

    public int ad(View view) {
        this.ctu = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.cts) {
            this.mContentWidth -= measuredWidth;
        } else {
            if (this.cto != null) {
                addViewInLayout(this.cto, -1, this.cto.getLayoutParams(), true);
                this.mContentWidth += this.cto.getMeasuredWidth();
            }
            this.mContentWidth -= measuredWidth;
            this.cts = true;
        }
        this.bAQ--;
        removeViewInLayout(view);
        this.ctt.add(view);
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
        } else if (scrollX > aoU()) {
            this.mScroller.startScroll(scrollX, 0, aoU() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean aoZ() {
        return this.ctu;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.cty);
        this.mScroller.forceFinished(true);
        this.ctg.forceFinished(true);
        if (this.ctb != null) {
            this.ctb.setVisibility(0);
            this.ctb = null;
        }
        this.ctc = -1;
        this.cti = false;
        this.ctj = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.ctw = false;
    }

    public void notifyDataSetChanged() {
        this.mScroller.forceFinished(true);
        this.ctg.forceFinished(true);
        requestLayout();
    }

    public void setCenterStart(boolean z) {
        this.ctx = z;
    }
}
