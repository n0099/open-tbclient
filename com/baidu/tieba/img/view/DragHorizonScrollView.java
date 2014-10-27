package com.baidu.tieba.img.view;

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
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, f, g {
    private final float bkX;
    private BaseAdapter bkY;
    private View bkZ;
    private int bla;
    private a blb;
    private int blc;
    private int bld;
    private int ble;
    private int blf;
    private Scroller blg;
    private Rect blh;
    private boolean bli;
    private boolean blj;
    private d blk;
    private int bll;
    private int blm;
    private boolean bln;
    private View blo;
    private final int blp;
    private final int blq;
    private int blr;
    private boolean bls;
    private ArrayList<View> blt;
    private boolean blu;
    private boolean blv;
    private boolean blw;
    private boolean blx;
    private Runnable bly;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public DragHorizonScrollView(Context context) {
        super(context);
        this.bkX = 2.0f;
        this.blh = new Rect();
        this.blm = 10;
        this.blp = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        this.blq = 500;
        this.blt = new ArrayList<>();
        this.blx = false;
        this.bly = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bkX = 2.0f;
        this.blh = new Rect();
        this.blm = 10;
        this.blp = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        this.blq = 500;
        this.blt = new ArrayList<>();
        this.blx = false;
        this.bly = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bkX = 2.0f;
        this.blh = new Rect();
        this.blm = 10;
        this.blp = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        this.blq = 500;
        this.blt = new ArrayList<>();
        this.blx = false;
        this.bly = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.bkZ = null;
        this.bla = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.blg = new Scroller(context);
        this.bll = getResources().getDimensionPixelSize(t.editor_muti_image_upload_scrollview_paddingleft);
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
        this.blc = this.bkY == null ? 0 : this.bkY.getCount();
        this.blc = Math.min(this.blm, this.blc);
        if (this.blc <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View gp = gp(0);
            f(gp, i, i2);
            i4 = gp.getMeasuredWidth();
            i3 = gp.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] g = g(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(g[0], i);
                this.blv = true;
            } else {
                i5 = size;
            }
            if (mode2 == Integer.MIN_VALUE) {
                paddingTop = resolveSize(g[1], i2);
            }
        } else {
            i5 = size;
        }
        setMeasuredDimension(i5, paddingTop);
        this.bld = i;
        this.ble = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.blo) {
                this.blt.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.bll;
        if (this.blx) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(t.default_gap_24);
            if (this.blc > 0) {
                View gp = gp(0);
                f(gp, this.bld, this.ble);
                paddingLeft = ((getMeasuredWidth() - gp.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.blo != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.bll * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.blo.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.blo.setLayoutParams(layoutParams);
                f(this.blo, this.bld, this.ble);
                paddingLeft = ((getMeasuredWidth() - this.blo.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.blc; i7++) {
            View gp2 = gp(i7);
            if (gp2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = gp2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    gp2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(gp2, -1, layoutParams2, true);
                f(gp2, this.bld, this.ble);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = gp2.getMeasuredWidth() + i6;
                gp2.layout(i6, paddingTop, measuredWidth2, gp2.getMeasuredHeight() + paddingTop);
                gp2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.blo != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.bll * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.blo.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.blo.setLayoutParams(layoutParams3);
            f(this.blo, this.bld, this.ble);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.blo.getMeasuredWidth() + i6;
            this.blo.layout(i6, paddingTop2, measuredWidth4, this.blo.getMeasuredHeight() + paddingTop2);
            if (this.blc == this.blm) {
                i6 = measuredWidth4 - this.blo.getMeasuredWidth();
                this.bls = false;
            } else {
                addViewInLayout(this.blo, -1, this.blo.getLayoutParams(), true);
                this.bls = true;
                i6 = measuredWidth4;
            }
        }
        this.blf = (this.bll + i6) - this.mPadding;
        if (this.bln || z) {
            scrollTo(0, 0);
            scrollBy(Se(), 0);
            this.bln = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sd() {
        return this.blf > getMeasuredWidth();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2) {
        }
        if (Sd()) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            float x = motionEvent.getX();
            switch (action) {
                case 0:
                    this.mLastMotionX = x;
                    if (!this.blg.isFinished()) {
                        removeCallbacks(this.bly);
                        this.blg.forceFinished(true);
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
        if ((motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) && Sd()) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int action = motionEvent.getAction();
            float x = motionEvent.getX();
            switch (action) {
                case 0:
                    if (!this.blg.isFinished()) {
                        removeCallbacks(this.bly);
                        this.blg.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.bly);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.blr = i2;
                        this.blg.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.bly);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    gq((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bkY = baseAdapter;
        this.mScroller.forceFinished(true);
        this.blg.forceFinished(true);
        if (!this.bln && z) {
            this.bln = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bkY;
    }

    private View gp(int i) {
        View view = null;
        if (this.blt.size() > 0) {
            view = this.blt.remove(0);
        }
        View view2 = this.bkY.getView(i, view, this);
        if (view2 != view) {
            this.blt.add(view);
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

    private int[] g(int i, int i2, int i3, int i4) {
        int[] iArr = new int[2];
        if (this.bkY == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.blc - 1;
        }
        while (i <= i2) {
            View gp = gp(i);
            if (gp.getVisibility() != 8) {
                f(gp, i3, i4);
                paddingRight += gp.getMeasuredWidth();
                paddingTop = Math.max(gp.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Se() {
        if (Sd()) {
            return this.blf - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gq(int i) {
        scrollBy(gr(i), 0);
        invalidate();
    }

    private int gr(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > Se()) {
                i = Se() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.blw) {
            this.blw = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.blb.a(view, null);
            this.bkZ = view;
            this.bla = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.bli || this.blj) && this.blb != null) {
                this.blb.Sc();
                return;
            }
            return;
        }
        this.bli = false;
        this.blj = false;
    }

    @Override // com.baidu.tieba.img.view.f
    public void setDragController(a aVar) {
        this.blb = aVar;
    }

    @Override // com.baidu.tieba.img.view.g
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.bla && (childAt = getChildAt(i)) != this.blo) {
                childAt.getHitRect(this.blh);
                if (this.blh.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.bla;
                    S(i2, i);
                    R(i2, i);
                    this.bla = i;
                    return;
                }
            }
        }
    }

    private void R(int i, int i2) {
        if (this.blk != null) {
            this.blk.G(i, i2);
        }
    }

    private void S(int i, int i2) {
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

    @Override // com.baidu.tieba.img.view.g
    public void Sf() {
        if (!this.bli) {
            this.bli = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.img.view.g
    public void Sg() {
        if (!this.blj) {
            this.blj = true;
            int Se = Se();
            int scrollX = getScrollX();
            int scrollX2 = Se - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.img.view.g
    public void Sh() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.bli = false;
        this.blj = false;
    }

    @Override // com.baidu.tieba.img.view.g
    public void Si() {
        reset();
    }

    public void setOnSwapDataListener(d dVar) {
        this.blk = dVar;
    }

    public void setMaxItemNum(int i) {
        this.blm = i;
    }

    public int getMaxItemNum() {
        return this.blm;
    }

    public void setAddView(View view) {
        this.blo = view;
    }

    public int P(View view) {
        this.blu = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.bls) {
            this.blf -= measuredWidth;
        } else {
            if (this.blo != null) {
                addViewInLayout(this.blo, -1, this.blo.getLayoutParams(), true);
                this.blf += this.blo.getMeasuredWidth();
            }
            this.blf -= measuredWidth;
            this.bls = true;
        }
        this.blc--;
        removeViewInLayout(view);
        this.blt.add(view);
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
        if (!Sd()) {
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, 500);
            postInvalidate();
        } else if (scrollX > Se()) {
            this.mScroller.startScroll(scrollX, 0, Se() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean Sj() {
        return this.blu;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.bly);
        this.mScroller.forceFinished(true);
        this.blg.forceFinished(true);
        if (this.bkZ != null) {
            this.bkZ.setVisibility(0);
            this.bkZ = null;
        }
        this.bla = -1;
        this.bli = false;
        this.blj = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.blw = false;
    }

    public void notifyDataSetChanged() {
        this.mScroller.forceFinished(true);
        this.blg.forceFinished(true);
        requestLayout();
    }

    public void setCenterStart(boolean z) {
        this.blx = z;
    }
}
