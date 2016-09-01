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
    private int cIL;
    private int cJR;
    private int cKL;
    private BaseAdapter cdU;
    private final float ftW;
    private View ftX;
    private int ftY;
    private com.baidu.tieba.tbadkCore.imgView.a ftZ;
    private int fua;
    private int fub;
    private Scroller fuc;
    private Rect fud;
    private boolean fue;
    private boolean fuf;
    private a fug;
    private int fuh;
    private int fui;
    private boolean fuj;
    private View fuk;
    private final int ful;
    private final int fum;
    private boolean fun;
    private ArrayList<View> fuo;
    private boolean fup;
    private boolean fuq;
    private boolean fur;
    private boolean fus;
    private Runnable fut;
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
        this.ftW = 2.0f;
        this.fud = new Rect();
        this.fui = 10;
        this.ful = 300;
        this.fum = 500;
        this.fuo = new ArrayList<>();
        this.fus = false;
        this.fut = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ftW = 2.0f;
        this.fud = new Rect();
        this.fui = 10;
        this.ful = 300;
        this.fum = 500;
        this.fuo = new ArrayList<>();
        this.fus = false;
        this.fut = new b(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ftW = 2.0f;
        this.fud = new Rect();
        this.fui = 10;
        this.ful = 300;
        this.fum = 500;
        this.fuo = new ArrayList<>();
        this.fus = false;
        this.fut = new b(this);
        init(context);
    }

    private void init(Context context) {
        this.ftX = null;
        this.ftY = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.fuc = new Scroller(context);
        this.fuh = getResources().getDimensionPixelSize(t.e.ds66);
        this.mPadding = getResources().getDimensionPixelSize(t.e.ds32);
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
        this.cKL = this.cdU == null ? 0 : this.cdU.getCount();
        this.cKL = Math.min(this.fui, this.cKL);
        if (this.cKL <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View rD = rD(0);
            j(rD, i, i2);
            i4 = rD.getMeasuredWidth();
            i3 = rD.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] s = s(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(s[0], i);
                this.fuq = true;
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
        this.fua = i;
        this.cIL = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.fuk) {
                this.fuo.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.fuh;
        if (this.fus) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(t.e.ds32);
            if (this.cKL > 0) {
                View rD = rD(0);
                j(rD, this.fua, this.cIL);
                paddingLeft = ((getMeasuredWidth() - rD.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.fuk != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.fuh * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.fuk.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.fuk.setLayoutParams(layoutParams);
                j(this.fuk, this.fua, this.cIL);
                paddingLeft = ((getMeasuredWidth() - this.fuk.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.cKL; i7++) {
            View rD2 = rD(i7);
            if (rD2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = rD2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    rD2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(rD2, -1, layoutParams2, true);
                j(rD2, this.fua, this.cIL);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = rD2.getMeasuredWidth() + i6;
                rD2.layout(i6, paddingTop, measuredWidth2, rD2.getMeasuredHeight() + paddingTop);
                rD2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.fuk != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.fuh * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.fuk.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.fuk.setLayoutParams(layoutParams3);
            j(this.fuk, this.fua, this.cIL);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.fuk.getMeasuredWidth() + i6;
            this.fuk.layout(i6, paddingTop2, measuredWidth4, this.fuk.getMeasuredHeight() + paddingTop2);
            if (this.cKL == this.fui) {
                i6 = measuredWidth4 - this.fuk.getMeasuredWidth();
                this.fun = false;
            } else {
                addViewInLayout(this.fuk, -1, this.fuk.getLayoutParams(), true);
                this.fun = true;
                i6 = measuredWidth4;
            }
        }
        this.fub = (this.fuh + i6) - this.mPadding;
        if (this.fuj || z) {
            scrollTo(0, 0);
            scrollBy(bjB(), 0);
            this.fuj = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.fub > getMeasuredWidth();
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
                    if (!this.fuc.isFinished()) {
                        removeCallbacks(this.fut);
                        this.fuc.forceFinished(true);
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
                    if (!this.fuc.isFinished()) {
                        removeCallbacks(this.fut);
                        this.fuc.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.fut);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cJR = i2;
                        this.fuc.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.fut);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    rE((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.cdU = baseAdapter;
        this.mScroller.forceFinished(true);
        this.fuc.forceFinished(true);
        if (!this.fuj && z) {
            this.fuj = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.cdU;
    }

    private View rD(int i) {
        View view = null;
        if (this.fuo.size() > 0) {
            view = this.fuo.remove(0);
        }
        View view2 = this.cdU.getView(i, view, this);
        if (view2 != view) {
            this.fuo.add(view);
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
        if (this.cdU == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.cKL - 1;
        }
        while (i <= i2) {
            View rD = rD(i);
            if (rD.getVisibility() != 8) {
                j(rD, i3, i4);
                paddingRight += rD.getMeasuredWidth();
                paddingTop = Math.max(rD.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bjB() {
        if (canScroll()) {
            return this.fub - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rE(int i) {
        scrollBy(rF(i), 0);
        invalidate();
    }

    private int rF(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bjB()) {
                i = bjB() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.fur) {
            this.fur = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.ftZ.a(view, null);
            this.ftX = view;
            this.ftY = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.fue || this.fuf) && this.ftZ != null) {
                this.ftZ.bjA();
                return;
            }
            return;
        }
        this.fue = false;
        this.fuf = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.e
    public void setDragController(com.baidu.tieba.tbadkCore.imgView.a aVar) {
        this.ftZ = aVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void d(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.ftY && (childAt = getChildAt(i)) != this.fuk) {
                childAt.getHitRect(this.fud);
                if (this.fud.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.ftY;
                    bs(i2, i);
                    br(i2, i);
                    this.ftY = i;
                    return;
                }
            }
        }
    }

    private void br(int i, int i2) {
        if (this.fug != null) {
            this.fug.D(i, i2);
        }
    }

    private void bs(int i, int i2) {
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
    public void bjC() {
        if (!this.fue) {
            this.fue = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bjD() {
        if (!this.fuf) {
            this.fuf = true;
            int bjB = bjB();
            int scrollX = getScrollX();
            int scrollX2 = bjB - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bjE() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.fue = false;
        this.fuf = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void bjF() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.fug = aVar;
    }

    public void setMaxItemNum(int i) {
        this.fui = i;
    }

    public int getMaxItemNum() {
        return this.fui;
    }

    public void setAddView(View view) {
        this.fuk = view;
    }

    public int br(View view) {
        this.fup = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.fun) {
            this.fub -= measuredWidth;
        } else {
            if (this.fuk != null) {
                addViewInLayout(this.fuk, -1, this.fuk.getLayoutParams(), true);
                this.fub += this.fuk.getMeasuredWidth();
            }
            this.fub -= measuredWidth;
            this.fun = true;
        }
        this.cKL--;
        removeViewInLayout(view);
        this.fuo.add(view);
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
        } else if (scrollX > bjB()) {
            this.mScroller.startScroll(scrollX, 0, bjB() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new c(this), 500L);
        return indexOfChild;
    }

    public boolean bjG() {
        return this.fup;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.fut);
        this.mScroller.forceFinished(true);
        this.fuc.forceFinished(true);
        if (this.ftX != null) {
            this.ftX.setVisibility(0);
            this.ftX = null;
        }
        this.ftY = -1;
        this.fue = false;
        this.fuf = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.fur = false;
    }

    public void setCenterStart(boolean z) {
        this.fus = z;
    }
}
