package com.baidu.yuyinala.privatemessage.implugin.ui.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.baidu.yuyinala.privatemessage.implugin.util.f;
/* loaded from: classes11.dex */
public class SwipeLayout extends FrameLayout {
    private float brm;
    private float brn;
    private View cbM;
    private float currentX;
    private float currentY;
    private final int duration;
    private float lastX;
    private Activity mActivity;
    private Context mContext;
    private Drawable oVM;
    public boolean oVN;
    protected boolean oVO;
    protected boolean oVP;
    private boolean oVQ;
    private boolean oVR;
    private int oVS;
    private int oVT;
    private VelocityTracker oVU;
    private int oVV;
    private boolean oVW;
    private ObjectAnimator oVX;
    private int screenWidth;
    private int touchSlop;

    public SwipeLayout(Context context) {
        super(context);
        this.oVN = false;
        this.oVO = true;
        this.oVP = false;
        this.oVQ = false;
        this.oVR = false;
        this.oVS = 16;
        this.oVT = 72;
        this.screenWidth = 1080;
        this.oVV = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oVN = false;
        this.oVO = true;
        this.oVP = false;
        this.oVQ = false;
        this.oVR = false;
        this.oVS = 16;
        this.oVT = 72;
        this.screenWidth = 1080;
        this.oVV = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oVN = false;
        this.oVO = true;
        this.oVP = false;
        this.oVQ = false;
        this.oVR = false;
        this.oVS = 16;
        this.oVT = 72;
        this.screenWidth = 1080;
        this.oVV = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public void setSwipeAnyWhere(boolean z) {
        this.oVP = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.oVO = z;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        int dp2px = f.dp2px(this.mContext, 20.0f);
        int contentX = ((int) getContentX()) - dp2px;
        this.oVM.setBounds(contentX, view.getTop(), dp2px + contentX, view.getBottom());
        this.oVM.draw(canvas);
        this.oVM.setAlpha(76);
        return drawChild;
    }

    public void setCanSwipe(boolean z) {
        this.oVQ = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oVO && !this.oVQ && !this.oVR) {
            if (this.oVP) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.brm = motionEvent.getX();
                        this.brn = motionEvent.getY();
                        this.currentX = this.brm;
                        this.currentY = this.brn;
                        this.lastX = this.brm;
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.brm;
                        float y = motionEvent.getY() - this.brn;
                        if ((x * x) + (y * y) > this.touchSlop * this.touchSlop) {
                            if (y == 0.0f || Math.abs(x / y) > 1.0f) {
                                this.brm = motionEvent.getX();
                                this.brn = motionEvent.getY();
                                this.currentX = this.brm;
                                this.currentY = this.brn;
                                this.lastX = this.brm;
                                this.oVQ = true;
                                this.oVU = VelocityTracker.obtain();
                                return true;
                            }
                            this.oVR = true;
                            break;
                        }
                        break;
                }
            } else if (motionEvent.getAction() == 0 && motionEvent.getX() < this.oVT) {
                this.oVQ = true;
                this.oVU = VelocityTracker.obtain();
                return true;
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.oVR = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.oVQ || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oVQ) {
            if (this.oVU == null) {
                this.oVU = VelocityTracker.obtain();
            }
            this.oVU.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    this.brm = motionEvent.getX();
                    this.brn = motionEvent.getY();
                    this.currentX = this.brm;
                    this.currentY = this.brn;
                    this.lastX = this.brm;
                    break;
                case 1:
                case 3:
                    this.oVU.computeCurrentVelocity(10000);
                    this.oVU.computeCurrentVelocity(1000, 20000.0f);
                    this.oVQ = false;
                    this.oVW = false;
                    if (Math.abs(this.oVU.getXVelocity()) > (this.screenWidth / 200) * 1000) {
                        bt(this.oVU.getXVelocity());
                    } else if (getContentX() > this.screenWidth / 3) {
                        Ax(false);
                    } else {
                        Aw(false);
                    }
                    recycleVelocityTracker();
                    break;
                case 2:
                    this.currentX = motionEvent.getX();
                    this.currentY = motionEvent.getY();
                    float f = this.currentX - this.lastX;
                    if (f != 0.0f && !this.oVW) {
                        this.oVW = true;
                        f /= f;
                    }
                    if (getContentX() + f < 0.0f) {
                        setContentX(0.0f);
                    } else {
                        setContentX(f + getContentX());
                    }
                    this.lastX = this.currentX;
                    break;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void recycleVelocityTracker() {
        if (this.oVU != null) {
            this.oVU.recycle();
            this.oVU = null;
        }
    }

    public void elQ() {
        if (this.oVX != null) {
            this.oVX.removeAllListeners();
            this.oVX.cancel();
        }
    }

    public void setContentX(float f) {
        this.cbM.setX((int) f);
        invalidate();
    }

    public float getContentX() {
        return this.cbM.getX();
    }

    private void Aw(boolean z) {
        int i;
        elQ();
        this.oVX = ObjectAnimator.ofFloat(this, "contentX", getContentX(), 0.0f);
        if (z) {
            i = (int) ((200.0f * getContentX()) / this.screenWidth);
        } else {
            i = 200;
        }
        this.oVX.setDuration(i >= 100 ? i : 100);
        this.oVX.setInterpolator(new DecelerateInterpolator());
        this.oVX.start();
    }

    private void Ax(boolean z) {
        int i;
        elQ();
        this.oVX = ObjectAnimator.ofFloat(this, "contentX", getContentX(), this.screenWidth);
        if (z) {
            i = (int) ((200.0f * (this.screenWidth - getContentX())) / this.screenWidth);
        } else {
            i = 200;
        }
        this.oVX.setDuration(i >= 100 ? i : 100);
        this.oVX.setInterpolator(new DecelerateInterpolator());
        this.oVX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.SwipeLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SwipeLayout.this.mActivity.isFinishing()) {
                    SwipeLayout.this.oVN = true;
                    SwipeLayout.this.mActivity.finish();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
        this.oVX.start();
    }

    private void bt(float f) {
        if (f > 0.0f) {
            if (getContentX() < this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() < this.screenWidth / 3) {
                Aw(false);
            } else {
                Ax(true);
            }
        } else if (getContentX() > this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() > this.screenWidth / 3) {
            Ax(false);
        } else {
            Aw(true);
        }
    }
}
