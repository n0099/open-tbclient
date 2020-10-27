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
/* loaded from: classes4.dex */
public class SwipeLayout extends FrameLayout {
    private View bMH;
    private float bkM;
    private float bkN;
    private float currentX;
    private float currentY;
    private final int duration;
    private float lastX;
    private Activity mActivity;
    private Context mContext;
    private boolean opA;
    private boolean opB;
    private int opC;
    private int opD;
    private VelocityTracker opE;
    private int opF;
    private boolean opG;
    private ObjectAnimator opH;
    private Drawable opw;
    public boolean opx;
    protected boolean opy;
    protected boolean opz;
    private int screenWidth;
    private int touchSlop;

    public SwipeLayout(Context context) {
        super(context);
        this.opx = false;
        this.opy = true;
        this.opz = false;
        this.opA = false;
        this.opB = false;
        this.opC = 16;
        this.opD = 72;
        this.screenWidth = 1080;
        this.opF = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.opx = false;
        this.opy = true;
        this.opz = false;
        this.opA = false;
        this.opB = false;
        this.opC = 16;
        this.opD = 72;
        this.screenWidth = 1080;
        this.opF = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.opx = false;
        this.opy = true;
        this.opz = false;
        this.opA = false;
        this.opB = false;
        this.opC = 16;
        this.opD = 72;
        this.screenWidth = 1080;
        this.opF = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public void setSwipeAnyWhere(boolean z) {
        this.opz = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.opy = z;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        int dp2px = f.dp2px(this.mContext, 20.0f);
        int contentX = ((int) getContentX()) - dp2px;
        this.opw.setBounds(contentX, view.getTop(), dp2px + contentX, view.getBottom());
        this.opw.draw(canvas);
        this.opw.setAlpha(76);
        return drawChild;
    }

    public void setCanSwipe(boolean z) {
        this.opA = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.opy && !this.opA && !this.opB) {
            if (this.opz) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.bkM = motionEvent.getX();
                        this.bkN = motionEvent.getY();
                        this.currentX = this.bkM;
                        this.currentY = this.bkN;
                        this.lastX = this.bkM;
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.bkM;
                        float y = motionEvent.getY() - this.bkN;
                        if ((x * x) + (y * y) > this.touchSlop * this.touchSlop) {
                            if (y == 0.0f || Math.abs(x / y) > 1.0f) {
                                this.bkM = motionEvent.getX();
                                this.bkN = motionEvent.getY();
                                this.currentX = this.bkM;
                                this.currentY = this.bkN;
                                this.lastX = this.bkM;
                                this.opA = true;
                                this.opE = VelocityTracker.obtain();
                                return true;
                            }
                            this.opB = true;
                            break;
                        }
                        break;
                }
            } else if (motionEvent.getAction() == 0 && motionEvent.getX() < this.opD) {
                this.opA = true;
                this.opE = VelocityTracker.obtain();
                return true;
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.opB = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.opA || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.opA) {
            if (this.opE == null) {
                this.opE = VelocityTracker.obtain();
            }
            this.opE.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    this.bkM = motionEvent.getX();
                    this.bkN = motionEvent.getY();
                    this.currentX = this.bkM;
                    this.currentY = this.bkN;
                    this.lastX = this.bkM;
                    break;
                case 1:
                case 3:
                    this.opE.computeCurrentVelocity(10000);
                    this.opE.computeCurrentVelocity(1000, 20000.0f);
                    this.opA = false;
                    this.opG = false;
                    if (Math.abs(this.opE.getXVelocity()) > (this.screenWidth / 200) * 1000) {
                        aY(this.opE.getXVelocity());
                    } else if (getContentX() > this.screenWidth / 3) {
                        zB(false);
                    } else {
                        zA(false);
                    }
                    recycleVelocityTracker();
                    break;
                case 2:
                    this.currentX = motionEvent.getX();
                    this.currentY = motionEvent.getY();
                    float f = this.currentX - this.lastX;
                    if (f != 0.0f && !this.opG) {
                        this.opG = true;
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
        if (this.opE != null) {
            this.opE.recycle();
            this.opE = null;
        }
    }

    public void ecj() {
        if (this.opH != null) {
            this.opH.removeAllListeners();
            this.opH.cancel();
        }
    }

    public void setContentX(float f) {
        this.bMH.setX((int) f);
        invalidate();
    }

    public float getContentX() {
        return this.bMH.getX();
    }

    private void zA(boolean z) {
        int i;
        ecj();
        this.opH = ObjectAnimator.ofFloat(this, "contentX", getContentX(), 0.0f);
        if (z) {
            i = (int) ((200.0f * getContentX()) / this.screenWidth);
        } else {
            i = 200;
        }
        this.opH.setDuration(i >= 100 ? i : 100);
        this.opH.setInterpolator(new DecelerateInterpolator());
        this.opH.start();
    }

    private void zB(boolean z) {
        int i;
        ecj();
        this.opH = ObjectAnimator.ofFloat(this, "contentX", getContentX(), this.screenWidth);
        if (z) {
            i = (int) ((200.0f * (this.screenWidth - getContentX())) / this.screenWidth);
        } else {
            i = 200;
        }
        this.opH.setDuration(i >= 100 ? i : 100);
        this.opH.setInterpolator(new DecelerateInterpolator());
        this.opH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.SwipeLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SwipeLayout.this.mActivity.isFinishing()) {
                    SwipeLayout.this.opx = true;
                    SwipeLayout.this.mActivity.finish();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
        this.opH.start();
    }

    private void aY(float f) {
        if (f > 0.0f) {
            if (getContentX() < this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() < this.screenWidth / 3) {
                zA(false);
            } else {
                zB(true);
            }
        } else if (getContentX() > this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() > this.screenWidth / 3) {
            zB(false);
        } else {
            zA(true);
        }
    }
}
