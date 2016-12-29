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
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class DragHorizonScrollView extends ViewGroup implements View.OnLongClickListener, f, g {
    private BaseAdapter bND;
    private int ctX;
    private int cvZ;
    private int cve;
    private final float fhM;
    private View fhN;
    private int fhO;
    private b fhP;
    private int fhQ;
    private int fhR;
    private Scroller fhS;
    private Rect fhT;
    private boolean fhU;
    private boolean fhV;
    private a fhW;
    private int fhX;
    private int fhY;
    private boolean fhZ;
    private View fia;
    private final int fib;
    private final int fic;
    private boolean fie;
    private ArrayList<View> fif;
    private boolean fig;
    private boolean fih;
    private boolean fii;
    private boolean fij;
    private Runnable fik;
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
        this.fhM = 2.0f;
        this.fhT = new Rect();
        this.fhY = 10;
        this.fib = 300;
        this.fic = 500;
        this.fif = new ArrayList<>();
        this.fij = false;
        this.fik = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fhM = 2.0f;
        this.fhT = new Rect();
        this.fhY = 10;
        this.fib = 300;
        this.fic = 500;
        this.fif = new ArrayList<>();
        this.fij = false;
        this.fik = new c(this);
        init(context);
    }

    public DragHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fhM = 2.0f;
        this.fhT = new Rect();
        this.fhY = 10;
        this.fib = 300;
        this.fic = 500;
        this.fif = new ArrayList<>();
        this.fij = false;
        this.fik = new c(this);
        init(context);
    }

    private void init(Context context) {
        this.fhN = null;
        this.fhO = -1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mScroller = new Scroller(context, new LinearInterpolator());
        this.fhS = new Scroller(context);
        this.fhX = getResources().getDimensionPixelSize(r.e.ds66);
        this.mPadding = getResources().getDimensionPixelSize(r.e.ds32);
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
        this.cvZ = this.bND == null ? 0 : this.bND.getCount();
        this.cvZ = Math.min(this.fhY, this.cvZ);
        if (this.cvZ <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View rm = rm(0);
            j(rm, i, i2);
            i4 = rm.getMeasuredWidth();
            i3 = rm.getMeasuredHeight();
        }
        if (mode == 0) {
            size = getPaddingLeft() + getPaddingRight() + i4;
        }
        int paddingTop = mode2 == 0 ? i3 + getPaddingTop() + getPaddingBottom() : size2;
        if (mode == Integer.MIN_VALUE || mode2 == Integer.MIN_VALUE) {
            int[] s = s(0, -1, i, i2);
            if (mode == Integer.MIN_VALUE) {
                i5 = resolveSize(s[0], i);
                this.fih = true;
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
        this.fhQ = i;
        this.ctX = i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != this.fia) {
                this.fif.add(childAt);
            }
        }
        removeAllViewsInLayout();
        int paddingLeft = getPaddingLeft() + this.fhX;
        if (this.fij) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(r.e.ds32);
            if (this.cvZ > 0) {
                View rm = rm(0);
                j(rm, this.fhQ, this.ctX);
                paddingLeft = ((getMeasuredWidth() - rm.getMeasuredWidth()) + dimensionPixelSize) / 2;
            } else if (this.fia != null) {
                int measuredWidth = ((getMeasuredWidth() - (this.fhX * 2)) + this.mPadding) / 3;
                ViewGroup.LayoutParams layoutParams = this.fia.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new ViewGroup.LayoutParams(measuredWidth, -1);
                }
                layoutParams.width = measuredWidth;
                layoutParams.height = -1;
                this.fia.setLayoutParams(layoutParams);
                j(this.fia, this.fhQ, this.ctX);
                paddingLeft = ((getMeasuredWidth() - this.fia.getMeasuredWidth()) + dimensionPixelSize) / 2;
            }
        }
        int i6 = paddingLeft;
        for (int i7 = 0; i7 < this.cvZ; i7++) {
            View rm2 = rm(i7);
            if (rm2.getVisibility() != 8) {
                ViewGroup.LayoutParams layoutParams2 = rm2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                    rm2.setLayoutParams(layoutParams2);
                }
                addViewInLayout(rm2, -1, layoutParams2, true);
                j(rm2, this.fhQ, this.ctX);
                int paddingTop = getPaddingTop();
                int measuredWidth2 = rm2.getMeasuredWidth() + i6;
                rm2.layout(i6, paddingTop, measuredWidth2, rm2.getMeasuredHeight() + paddingTop);
                rm2.setDrawingCacheEnabled(false);
                i6 = measuredWidth2;
            }
        }
        if (this.fia != null) {
            int measuredWidth3 = ((getMeasuredWidth() - (this.fhX * 2)) + this.mPadding) / 3;
            ViewGroup.LayoutParams layoutParams3 = this.fia.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(measuredWidth3, -1);
            }
            layoutParams3.width = measuredWidth3;
            layoutParams3.height = -1;
            this.fia.setLayoutParams(layoutParams3);
            j(this.fia, this.fhQ, this.ctX);
            int paddingTop2 = getPaddingTop();
            int measuredWidth4 = this.fia.getMeasuredWidth() + i6;
            this.fia.layout(i6, paddingTop2, measuredWidth4, this.fia.getMeasuredHeight() + paddingTop2);
            if (this.cvZ == this.fhY) {
                i6 = measuredWidth4 - this.fia.getMeasuredWidth();
                this.fie = false;
            } else {
                addViewInLayout(this.fia, -1, this.fia.getLayoutParams(), true);
                this.fie = true;
                i6 = measuredWidth4;
            }
        }
        this.fhR = (this.fhX + i6) - this.mPadding;
        if (this.fhZ || z) {
            scrollTo(0, 0);
            scrollBy(bgs(), 0);
            this.fhZ = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canScroll() {
        return this.fhR > getMeasuredWidth();
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
                    if (!this.fhS.isFinished()) {
                        removeCallbacks(this.fik);
                        this.fhS.forceFinished(true);
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
                    if (!this.fhS.isFinished()) {
                        removeCallbacks(this.fik);
                        this.fhS.forceFinished(true);
                    }
                    this.mLastMotionX = x;
                    break;
                case 1:
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                    int xVelocity = (int) velocityTracker.getXVelocity();
                    if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                        removeCallbacks(this.fik);
                        int i = -xVelocity;
                        int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                        this.cve = i2;
                        this.fhS.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                        post(this.fik);
                    }
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                        break;
                    }
                    break;
                case 2:
                    this.mLastMotionX = x;
                    rn((int) (this.mLastMotionX - x));
                    break;
            }
        }
        return true;
    }

    public void a(BaseAdapter baseAdapter, boolean z) {
        this.bND = baseAdapter;
        this.mScroller.forceFinished(true);
        this.fhS.forceFinished(true);
        if (!this.fhZ && z) {
            this.fhZ = z;
        }
        requestLayout();
    }

    public BaseAdapter getAdapter() {
        return this.bND;
    }

    private View rm(int i) {
        View view = null;
        if (this.fif.size() > 0) {
            view = this.fif.remove(0);
        }
        View view2 = this.bND.getView(i, view, this);
        if (view2 != view) {
            this.fif.add(view);
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
        if (this.bND == null) {
            iArr[0] = getPaddingLeft() + getPaddingRight();
            iArr[1] = getPaddingTop() + getPaddingBottom();
            return iArr;
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (i2 == -1) {
            i2 = this.cvZ - 1;
        }
        while (i <= i2) {
            View rm = rm(i);
            if (rm.getVisibility() != 8) {
                j(rm, i3, i4);
                paddingRight += rm.getMeasuredWidth();
                paddingTop = Math.max(rm.getMeasuredHeight(), paddingTop);
            }
            i++;
        }
        iArr[0] = paddingRight;
        iArr[1] = paddingTop;
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bgs() {
        if (canScroll()) {
            return this.fhR - ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn(int i) {
        scrollBy(ro(i), 0);
        invalidate();
    }

    private int ro(int i) {
        if (i == 0) {
            return 0;
        }
        boolean z = i > 0;
        int scrollX = getScrollX();
        int i2 = scrollX + i;
        if (z) {
            if (i2 > bgs()) {
                i = bgs() - scrollX;
            }
        } else if (i2 < 0) {
            i = -scrollX;
        }
        return i;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (!this.fii) {
            this.fii = true;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).clearAnimation();
            }
            this.fhP.a(view, null);
            this.fhN = view;
            this.fhO = indexOfChild(view);
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), 0);
            postInvalidateDelayed(16L);
            if ((this.fhU || this.fhV) && this.fhP != null) {
                this.fhP.bgr();
                return;
            }
            return;
        }
        this.fhU = false;
        this.fhV = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.f
    public void setDragController(b bVar) {
        this.fhP = bVar;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void e(Rect rect) {
        View childAt;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (i != this.fhO && (childAt = getChildAt(i)) != this.fia) {
                childAt.getHitRect(this.fhT);
                if (this.fhT.contains((rect.left + rect.right) / 2, (rect.top + rect.bottom) / 2)) {
                    int i2 = this.fhO;
                    bo(i2, i);
                    bn(i2, i);
                    this.fhO = i;
                    return;
                }
            }
        }
    }

    private void bn(int i, int i2) {
        if (this.fhW != null) {
            this.fhW.D(i, i2);
        }
    }

    private void bo(int i, int i2) {
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
    public void bgt() {
        if (!this.fhU) {
            this.fhU = true;
            int scrollX = getScrollX();
            this.mScroller.startScroll(scrollX, 0, 0 - scrollX, 0, (int) (scrollX * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bgu() {
        if (!this.fhV) {
            this.fhV = true;
            int bgs = bgs();
            int scrollX = getScrollX();
            int scrollX2 = bgs - getScrollX();
            this.mScroller.startScroll(scrollX, 0, scrollX2, 0, (int) (scrollX2 * 2.0f));
            invalidate();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bgv() {
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.fhU = false;
        this.fhV = false;
    }

    @Override // com.baidu.tieba.tbadkCore.imgView.g
    public void bgw() {
        reset();
    }

    public void setOnSwapDataListener(a aVar) {
        this.fhW = aVar;
    }

    public void setMaxItemNum(int i) {
        this.fhY = i;
    }

    public int getMaxItemNum() {
        return this.fhY;
    }

    public void setAddView(View view) {
        this.fia = view;
    }

    public int bo(View view) {
        this.fig = true;
        view.clearAnimation();
        int indexOfChild = indexOfChild(view);
        if (indexOfChild == -1) {
            return indexOfChild;
        }
        int measuredWidth = view.getMeasuredWidth();
        if (this.fie) {
            this.fhR -= measuredWidth;
        } else {
            if (this.fia != null) {
                addViewInLayout(this.fia, -1, this.fia.getLayoutParams(), true);
                this.fhR += this.fia.getMeasuredWidth();
            }
            this.fhR -= measuredWidth;
            this.fie = true;
        }
        this.cvZ--;
        removeViewInLayout(view);
        this.fif.add(view);
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
        } else if (scrollX > bgs()) {
            this.mScroller.startScroll(scrollX, 0, bgs() - scrollX, 0, 500);
            postInvalidate();
        }
        postDelayed(new d(this), 500L);
        return indexOfChild;
    }

    public boolean bgx() {
        return this.fig;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    private void reset() {
        removeCallbacks(this.fik);
        this.mScroller.forceFinished(true);
        this.fhS.forceFinished(true);
        if (this.fhN != null) {
            this.fhN.setVisibility(0);
            this.fhN = null;
        }
        this.fhO = -1;
        this.fhU = false;
        this.fhV = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).clearAnimation();
        }
        this.fii = false;
    }

    public void setCenterStart(boolean z) {
        this.fij = z;
    }
}
