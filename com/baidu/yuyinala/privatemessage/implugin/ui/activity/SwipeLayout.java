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
    private View bSq;
    private float bmg;
    private float bmh;
    private float currentX;
    private float currentY;
    private final int duration;
    private float lastX;
    private Activity mActivity;
    private Context mContext;
    private Drawable oyQ;
    public boolean oyR;
    protected boolean oyS;
    protected boolean oyT;
    private boolean oyU;
    private boolean oyV;
    private int oyW;
    private int oyX;
    private VelocityTracker oyY;
    private int oyZ;
    private boolean oza;
    private ObjectAnimator ozb;
    private int screenWidth;
    private int touchSlop;

    public SwipeLayout(Context context) {
        super(context);
        this.oyR = false;
        this.oyS = true;
        this.oyT = false;
        this.oyU = false;
        this.oyV = false;
        this.oyW = 16;
        this.oyX = 72;
        this.screenWidth = 1080;
        this.oyZ = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oyR = false;
        this.oyS = true;
        this.oyT = false;
        this.oyU = false;
        this.oyV = false;
        this.oyW = 16;
        this.oyX = 72;
        this.screenWidth = 1080;
        this.oyZ = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oyR = false;
        this.oyS = true;
        this.oyT = false;
        this.oyU = false;
        this.oyV = false;
        this.oyW = 16;
        this.oyX = 72;
        this.screenWidth = 1080;
        this.oyZ = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public void setSwipeAnyWhere(boolean z) {
        this.oyT = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.oyS = z;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        int dp2px = f.dp2px(this.mContext, 20.0f);
        int contentX = ((int) getContentX()) - dp2px;
        this.oyQ.setBounds(contentX, view.getTop(), dp2px + contentX, view.getBottom());
        this.oyQ.draw(canvas);
        this.oyQ.setAlpha(76);
        return drawChild;
    }

    public void setCanSwipe(boolean z) {
        this.oyU = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oyS && !this.oyU && !this.oyV) {
            if (this.oyT) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.bmg = motionEvent.getX();
                        this.bmh = motionEvent.getY();
                        this.currentX = this.bmg;
                        this.currentY = this.bmh;
                        this.lastX = this.bmg;
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.bmg;
                        float y = motionEvent.getY() - this.bmh;
                        if ((x * x) + (y * y) > this.touchSlop * this.touchSlop) {
                            if (y == 0.0f || Math.abs(x / y) > 1.0f) {
                                this.bmg = motionEvent.getX();
                                this.bmh = motionEvent.getY();
                                this.currentX = this.bmg;
                                this.currentY = this.bmh;
                                this.lastX = this.bmg;
                                this.oyU = true;
                                this.oyY = VelocityTracker.obtain();
                                return true;
                            }
                            this.oyV = true;
                            break;
                        }
                        break;
                }
            } else if (motionEvent.getAction() == 0 && motionEvent.getX() < this.oyX) {
                this.oyU = true;
                this.oyY = VelocityTracker.obtain();
                return true;
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.oyV = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.oyU || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oyU) {
            if (this.oyY == null) {
                this.oyY = VelocityTracker.obtain();
            }
            this.oyY.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    this.bmg = motionEvent.getX();
                    this.bmh = motionEvent.getY();
                    this.currentX = this.bmg;
                    this.currentY = this.bmh;
                    this.lastX = this.bmg;
                    break;
                case 1:
                case 3:
                    this.oyY.computeCurrentVelocity(10000);
                    this.oyY.computeCurrentVelocity(1000, 20000.0f);
                    this.oyU = false;
                    this.oza = false;
                    if (Math.abs(this.oyY.getXVelocity()) > (this.screenWidth / 200) * 1000) {
                        ba(this.oyY.getXVelocity());
                    } else if (getContentX() > this.screenWidth / 3) {
                        zM(false);
                    } else {
                        zL(false);
                    }
                    recycleVelocityTracker();
                    break;
                case 2:
                    this.currentX = motionEvent.getX();
                    this.currentY = motionEvent.getY();
                    float f = this.currentX - this.lastX;
                    if (f != 0.0f && !this.oza) {
                        this.oza = true;
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
        if (this.oyY != null) {
            this.oyY.recycle();
            this.oyY = null;
        }
    }

    public void efY() {
        if (this.ozb != null) {
            this.ozb.removeAllListeners();
            this.ozb.cancel();
        }
    }

    public void setContentX(float f) {
        this.bSq.setX((int) f);
        invalidate();
    }

    public float getContentX() {
        return this.bSq.getX();
    }

    private void zL(boolean z) {
        int i;
        efY();
        this.ozb = ObjectAnimator.ofFloat(this, "contentX", getContentX(), 0.0f);
        if (z) {
            i = (int) ((200.0f * getContentX()) / this.screenWidth);
        } else {
            i = 200;
        }
        this.ozb.setDuration(i >= 100 ? i : 100);
        this.ozb.setInterpolator(new DecelerateInterpolator());
        this.ozb.start();
    }

    private void zM(boolean z) {
        int i;
        efY();
        this.ozb = ObjectAnimator.ofFloat(this, "contentX", getContentX(), this.screenWidth);
        if (z) {
            i = (int) ((200.0f * (this.screenWidth - getContentX())) / this.screenWidth);
        } else {
            i = 200;
        }
        this.ozb.setDuration(i >= 100 ? i : 100);
        this.ozb.setInterpolator(new DecelerateInterpolator());
        this.ozb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.SwipeLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SwipeLayout.this.mActivity.isFinishing()) {
                    SwipeLayout.this.oyR = true;
                    SwipeLayout.this.mActivity.finish();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
        this.ozb.start();
    }

    private void ba(float f) {
        if (f > 0.0f) {
            if (getContentX() < this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() < this.screenWidth / 3) {
                zL(false);
            } else {
                zM(true);
            }
        } else if (getContentX() > this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() > this.screenWidth / 3) {
            zM(false);
        } else {
            zL(true);
        }
    }
}
