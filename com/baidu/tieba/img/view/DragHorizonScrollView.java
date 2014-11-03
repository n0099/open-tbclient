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
    private int blA;
    private boolean blB;
    private View blC;
    private final int blD;
    private final int blE;
    private int blF;
    private boolean blG;
    private ArrayList<View> blH;
    private boolean blI;
    private boolean blJ;
    private boolean blK;
    private boolean blL;
    private Runnable blM;
    private final float bll;
    private BaseAdapter blm;
    private View bln;
    private int blo;
    private a blp;
    private int blq;
    private int blr;
    private int bls;
    private int blt;
    private Scroller blu;
    private Rect blv;
    private boolean blw;
    private boolean blx;
    private d bly;
    private int blz;
    private float mLastMotionX;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mPadding;
    private Scroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public DragHorizonScrollView(Context context) {
        super(context);
        this.bll = 2.0f;
        this.blv = new Rect();
        this.blA = 10;
        this.blD = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        this.blE = 500;
        this.blH = new ArrayList<>();
        this.blL = false;
        this.blM = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bll = 2.0f;
        this.blv = new Rect();
        this.blA = 10;
        this.blD = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        this.blE = 500;
        this.blH = new ArrayList<>();
        this.blL = false;
        this.blM = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bll = 2.0f;
        this.blv = new Rect();
        this.blA = 10;
        this.blD = TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI;
        this.blE = 500;
        this.blH = new ArrayList<>();
        this.blL = false;
        this.blM = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.bln = null;
        this.blo = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.blu = new Scroller(context);
        this.blz = getResources().getDimensionPixelSize(t.editor_muti_image_upload_scrollview_paddingleft);
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
        this.blq = this.blm == null ? 0 : this.blm.getCount();
        this.blq = Math.min(this.blA, this.blq);
        if (this.blq <= 0 || !(mode == 0 || mode2 == 0)) {
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
                this.blJ = true;
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
        this.blr = i;
        this.bls = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.blC) {
                this.blH.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.blz;
        if (this.blL) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(t.default_gap_24);
            if (this.blq > 0) {
                View gp = gp(0);
                f(gp, this.blr, this.bls);
                paddingLeft = ((getMeasuredWidth() - gp.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.blC != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.blz * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.blC.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.blC.setLayoutParams(layoutParams);
                f(this.blC, this.blr, this.bls);
                paddingLeft = ((getMeasuredWidth() - this.blC.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.blq; i7++) {
            View gp2 = gp(i7);
            if (gp2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = gp2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    gp2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(gp2, -1, layoutParams2, true);
                f(gp2, this.blr, this.bls);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = gp2.getMeasuredWidth() + i6;
                gp2.layout(i6, paddingTop, measuredWidth2, gp2.getMeasuredHeight() + paddingTop);
                gp2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.blC != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.blz * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.blC.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.blC.setLayoutParams(layoutParams3);
            f(this.blC, this.blr, this.bls);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.blC.getMeasuredWidth() + i6;
            this.blC.layout(i6, paddingTop2, measuredWidth4, this.blC.getMeasuredHeight() + paddingTop2);
            if (this.blq == this.blA) {
                i6 = measuredWidth4 - this.blC.getMeasuredWidth();
                this.blG = false;
            } else {
                addViewInLayout(this.blC, -1, this.blC.getLayoutParams(), true);
                this.blG = true;
                i6 = measuredWidth4;
            }
        }
        this.blt = (this.blz + i6) - this.mPadding;
        if (this.blB || z) {
            scrollTo(0, 0);
            scrollBy(Sh(), 0);
            this.blB = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sg() {
        return this.blt > getMeasuredWidth();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        int action = motionEvent.getAction();
        if (action == 2) {
        }
        if (Sg()) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            float x = motionEvent.getX();
            switch (action) {
                case 0:
                    this.mLastMotionX = x;
                    if (!this.blu.isFinished()) {
                        removeCallbacks(this.blM);
                        this.blu.forceFinished(true);
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
        if ((motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) && Sg()) {
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int action = motionEvent.getAction();
            float x = motionEvent.getX();
            switch (action) {
                case 0:
                    if (!this.blu.isFinished()) {
                        removeCallbacks(this.blM);
                        this.blu.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.blM);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.blF = i2;
                        this.blu.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.blM);
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
        this.blm = baseAdapter;
        this.mScroller.forceFinished(true);
        this.blu.forceFinished(true);
        if (!this.blB && z) {
            this.blB = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.blm;
    }

    private View gp(int i) {
        View view = null;
        if (this.blH.size() > 0) {
            view = this.blH.remove(0);
        }
        View view2 = this.blm.getView(i, view, this);
        if (view2 != view) {
            this.blH.add(view);
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
        if (this.blm == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.blq - 1;
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
    public int Sh() {
        if (Sg()) {
            return this.blt - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
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
            if (i2 > Sh()) {
                i = Sh() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.blK) {
            this.blK = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.blp.a(view, null);
            this.bln = view;
            this.blo = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.blw || this.blx) && this.blp != null) {
                this.blp.Sf();
                return;
            }
            return;
        }
        this.blw = false;
        this.blx = false;
    }

    @Override // com.baidu.tieba.img.view.f
    public void setDragController(a aVar) {
        this.blp = aVar;
    }

    @Override // com.baidu.tieba.img.view.g
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.blo && (childAt = getChildAt(i)) != this.blC) {
                childAt.getHitRect(this.blv);
                if (this.blv.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.blo;
                    S(i2, i);
                    R(i2, i);
                    this.blo = i;
                    return;
                }
            }
        }
    }

    private void R(int i, int i2) {
        if (this.bly != null) {
            this.bly.G(i, i2);
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
    public void Si() {
        if (!this.blw) {
            this.blw = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.img.view.g
    public void Sj() {
        if (!this.blx) {
            this.blx = true;
            int Sh = Sh();
            int scrollX = getScrollX();
            int scrollX2 = Sh - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.img.view.g
    public void Sk() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.blw = false;
        this.blx = false;
    }

    @Override // com.baidu.tieba.img.view.g
    public void Sl() {
        reset();
    }

    public void setOnSwapDataListener(d dVar) {
        this.bly = dVar;
    }

    public void setMaxItemNum(int i) {
        this.blA = i;
    }

    public int getMaxItemNum() {
        return this.blA;
    }

    public void setAddView(View view) {
        this.blC = view;
    }

    public int P(View view) {
        this.blI = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.blG) {
            this.blt -= measuredWidth;
        } else {
            if (this.blC != null) {
                addViewInLayout(this.blC, -1, this.blC.getLayoutParams(), true);
                this.blt += this.blC.getMeasuredWidth();
            }
            this.blt -= measuredWidth;
            this.blG = true;
        }
        this.blq--;
        removeViewInLayout(view);
        this.blH.add(view);
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
        if (!Sg()) {
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, 500);
            postInvalidate();
        } else if (scrollX > Sh()) {
            this.mScroller.startScroll(scrollX, 0, Sh() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean Sm() {
        return this.blI;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.blM);
        this.mScroller.forceFinished(true);
        this.blu.forceFinished(true);
        if (this.bln != null) {
            this.bln.setVisibility(0);
            this.bln = null;
        }
        this.blo = -1;
        this.blw = false;
        this.blx = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.blK = false;
    }

    public void notifyDataSetChanged() {
        this.mScroller.forceFinished(true);
        this.blu.forceFinished(true);
        requestLayout();
    }

    public void setCenterStart(boolean z) {
        this.blL = z;
    }
}
