package com.baidu.tieba.yuyinala.liveroom.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import androidx.core.view.MotionEventCompat;
import com.baidu.live.adp.lib.util.BdUtilHelper;
/* loaded from: classes10.dex */
public class AlaLiveView extends RelativeLayout implements com.baidu.live.liveroom.g.a {
    private boolean bnE;
    private boolean bsk;
    private float cBP;
    private int hMK;
    private boolean hML;
    private boolean hMM;
    private boolean hMN;
    public boolean hMO;
    public boolean hMP;
    private com.baidu.live.liveroom.g.c hMQ;
    private com.baidu.live.liveroom.g.b hMR;
    private com.baidu.live.liveroom.g.d hMS;
    private int hMT;
    private int mActivePointerId;
    private float mDownX;
    private int mFlingDistance;
    private boolean mIsScrolling;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mMoveDistance;
    private Scroller mScroller;
    private VelocityTracker mVelocityTracker;
    private float mXVelocity;

    public AlaLiveView(Context context) {
        super(context);
        this.hML = false;
        this.mIsScrolling = false;
        this.mActivePointerId = -1;
        this.bsk = true;
        this.hMM = true;
        this.hMN = false;
        this.hMO = false;
        this.bnE = false;
        init(context);
    }

    public AlaLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hML = false;
        this.mIsScrolling = false;
        this.mActivePointerId = -1;
        this.bsk = true;
        this.hMM = true;
        this.hMN = false;
        this.hMO = false;
        this.bnE = false;
        init(context);
    }

    public AlaLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hML = false;
        this.mIsScrolling = false;
        this.mActivePointerId = -1;
        this.bsk = true;
        this.hMM = true;
        this.hMN = false;
        this.hMO = false;
        this.bnE = false;
        init(context);
    }

    private void init(Context context) {
        this.mScroller = new Scroller(context, new a(1.5f));
        this.mMaximumVelocity = ViewConfiguration.getMaximumFlingVelocity();
        this.mMinimumVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.mMoveDistance = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.mFlingDistance = BdUtilHelper.getEquipmentWidth(context) / 4;
        this.hMK = Math.max(ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2, 50);
    }

    public ViewGroup getView() {
        return this;
    }

    public void setSwipeClearEnable(boolean z) {
        this.hMM = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.hMT = (int) motionEvent.getX();
            completeScroll();
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            if (isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.mLastMotionX = motionEvent.getX();
            this.mLastMotionY = motionEvent.getY();
            this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
            this.cBP = MotionEventCompat.getY(motionEvent, actionIndex);
            W(motionEvent);
            return super.onInterceptTouchEvent(motionEvent);
        } else if (motionEvent.getAction() == 2) {
            return Math.abs(((int) motionEvent.getX()) - this.hMT) > this.hMK;
        } else {
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (V(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean V(MotionEvent motionEvent) {
        if (this.hMR == null) {
            return false;
        }
        return this.hMR.dispatchTouchEvent(motionEvent);
    }

    private boolean W(MotionEvent motionEvent) {
        if (this.hMS == null) {
            return false;
        }
        return this.hMS.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.hMO ? X(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public boolean X(MotionEvent motionEvent) {
        if (W(motionEvent)) {
            return true;
        }
        if (!this.hMM || this.mIsScrolling) {
            if (this.hMN) {
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                completeScroll();
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = motionEvent.getX();
                    this.mLastMotionY = motionEvent.getY();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.cBP = MotionEventCompat.getY(motionEvent, actionIndex);
                    return true;
                }
                break;
            case 1:
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                this.mXVelocity = velocityTracker.getXVelocity();
                float yVelocity = velocityTracker.getYVelocity();
                int diffX = getDiffX(motionEvent);
                int M = M(motionEvent);
                if (Math.abs(this.mXVelocity) > Math.abs(yVelocity * 2.0f) && Math.abs(this.mXVelocity) > this.mMinimumVelocity && Math.abs(diffX) > this.mFlingDistance) {
                    if (this.mXVelocity < 0.0f) {
                        scrollOrigin();
                    } else {
                        scrollRight();
                    }
                    endDrag();
                    return true;
                }
                if (diffX < (-this.mMoveDistance) && Math.abs(diffX) > Math.abs(M)) {
                    scrollOrigin();
                } else if (diffX > this.mMoveDistance && Math.abs(diffX) > Math.abs(M)) {
                    scrollRight();
                } else if (this.hML) {
                    scrollOrigin();
                }
                endDrag();
                break;
            case 2:
                if (this.bnE) {
                    BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
                    endDrag();
                    return false;
                }
                if (!this.hML) {
                    determineDrag(motionEvent);
                }
                if (this.hML) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    int pointerIndex = getPointerIndex(motionEvent, this.mActivePointerId);
                    if (!isInvalidEvent(motionEvent, pointerIndex, this.mActivePointerId)) {
                        float x = MotionEventCompat.getX(motionEvent, pointerIndex);
                        float f = this.mLastMotionX - x;
                        this.mLastMotionX = x;
                        float scrollX = getScrollX() + f;
                        this.mLastMotionX += scrollX - ((int) scrollX);
                        if (scrollX < 0.0f) {
                            scrollTo((int) scrollX, getScrollY());
                            break;
                        } else if (scrollX <= (-getWidth())) {
                            scrollTo(-getWidth(), getScrollY());
                            break;
                        } else {
                            scrollTo(0, getScrollY());
                            break;
                        }
                    }
                }
                break;
            case 3:
                if (this.hML) {
                    scrollOrigin();
                }
                endDrag();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private void releaseVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.clear();
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller != null) {
            if (!this.mScroller.isFinished() && this.mScroller.computeScrollOffset()) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                }
                invalidate();
            }
            if (this.mScroller.isFinished()) {
                completeScroll();
            }
        }
    }

    private void completeScroll() {
        if (this.mIsScrolling) {
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.mIsScrolling = false;
    }

    private void determineDrag(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (!isInvalidEvent(motionEvent, pointerIndex, i)) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float abs = Math.abs(x - this.mLastMotionX);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (abs > this.mMoveDistance && abs > abs2) {
                if (this.hMR != null && !this.hMR.LE()) {
                    this.hML = true;
                }
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private int getDiffX(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (isInvalidEvent(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) (MotionEventCompat.getX(motionEvent, pointerIndex) - this.mDownX);
    }

    private int M(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (isInvalidEvent(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.cBP);
    }

    public void ckl() {
        if (!this.bsk) {
            ckn();
        }
    }

    public void ckm() {
        if (this.mScroller != null) {
            this.mScroller.forceFinished(true);
        }
        this.mScroller = null;
        this.hMP = true;
    }

    private void endDrag() {
        this.hML = false;
        this.mActivePointerId = -1;
        releaseVelocityTracker();
    }

    private void scrollRight() {
        if (this.hMQ != null) {
            this.hMQ.LF();
        }
        this.bsk = false;
        this.mIsScrolling = true;
        int scrollX = getScrollX() - getWidth();
        if (this.mScroller != null) {
            this.mScroller.startScroll(getScrollX(), 0, scrollX - 1, 0);
        }
        if (this.hMQ != null) {
            this.hMQ.cz(this.bsk);
        }
        BdUtilHelper.hideSoftKeyPad(getContext(), getRootView());
        postInvalidate();
    }

    public void ckn() {
        vX(1);
    }

    public void scrollOrigin() {
        vX(250);
    }

    public void vX(int i) {
        if (this.hMQ != null) {
            this.hMQ.LF();
        }
        this.bsk = true;
        this.mIsScrolling = true;
        int scrollX = getScrollX();
        if (this.mScroller != null) {
            this.mScroller.startScroll(getScrollX(), 0, -scrollX, 0, i);
        }
        if (this.hMQ != null) {
            this.hMQ.cz(this.bsk);
        }
        postInvalidate();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.bnE = z;
    }

    public boolean getKeyboardVisibility() {
        return this.bnE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a implements Interpolator {
        private final float mFactor;

        public a(float f) {
            this.mFactor = f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.mFactor * f;
            if (f2 > 0.9d) {
                return 1.0f;
            }
            return f2;
        }
    }

    public boolean cko() {
        return this.bsk;
    }

    public void setOnLiveViewScrollListener(com.baidu.live.liveroom.g.c cVar) {
        this.hMQ = cVar;
    }

    public void setLiveViewOnDispatchTouchEventListener(com.baidu.live.liveroom.g.b bVar) {
        this.hMR = bVar;
    }

    public void setLiveViewOnTouchEventListener(com.baidu.live.liveroom.g.d dVar) {
        this.hMS = dVar;
    }

    public void setIsForceHandledTouch(boolean z) {
        this.hMN = z;
    }
}
