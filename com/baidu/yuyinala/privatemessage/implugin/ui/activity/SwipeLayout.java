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
    private View bVQ;
    private float bpE;
    private float bpF;
    private float currentX;
    private float currentY;
    private final int duration;
    private float lastX;
    private Activity mActivity;
    private Context mContext;
    private Drawable oPA;
    public boolean oPB;
    protected boolean oPC;
    protected boolean oPD;
    private boolean oPE;
    private boolean oPF;
    private int oPG;
    private int oPH;
    private VelocityTracker oPI;
    private int oPJ;
    private boolean oPK;
    private ObjectAnimator oPL;
    private int screenWidth;
    private int touchSlop;

    public SwipeLayout(Context context) {
        super(context);
        this.oPB = false;
        this.oPC = true;
        this.oPD = false;
        this.oPE = false;
        this.oPF = false;
        this.oPG = 16;
        this.oPH = 72;
        this.screenWidth = 1080;
        this.oPJ = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oPB = false;
        this.oPC = true;
        this.oPD = false;
        this.oPE = false;
        this.oPF = false;
        this.oPG = 16;
        this.oPH = 72;
        this.screenWidth = 1080;
        this.oPJ = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oPB = false;
        this.oPC = true;
        this.oPD = false;
        this.oPE = false;
        this.oPF = false;
        this.oPG = 16;
        this.oPH = 72;
        this.screenWidth = 1080;
        this.oPJ = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public void setSwipeAnyWhere(boolean z) {
        this.oPD = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.oPC = z;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        int dp2px = f.dp2px(this.mContext, 20.0f);
        int contentX = ((int) getContentX()) - dp2px;
        this.oPA.setBounds(contentX, view.getTop(), dp2px + contentX, view.getBottom());
        this.oPA.draw(canvas);
        this.oPA.setAlpha(76);
        return drawChild;
    }

    public void setCanSwipe(boolean z) {
        this.oPE = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oPC && !this.oPE && !this.oPF) {
            if (this.oPD) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.bpE = motionEvent.getX();
                        this.bpF = motionEvent.getY();
                        this.currentX = this.bpE;
                        this.currentY = this.bpF;
                        this.lastX = this.bpE;
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.bpE;
                        float y = motionEvent.getY() - this.bpF;
                        if ((x * x) + (y * y) > this.touchSlop * this.touchSlop) {
                            if (y == 0.0f || Math.abs(x / y) > 1.0f) {
                                this.bpE = motionEvent.getX();
                                this.bpF = motionEvent.getY();
                                this.currentX = this.bpE;
                                this.currentY = this.bpF;
                                this.lastX = this.bpE;
                                this.oPE = true;
                                this.oPI = VelocityTracker.obtain();
                                return true;
                            }
                            this.oPF = true;
                            break;
                        }
                        break;
                }
            } else if (motionEvent.getAction() == 0 && motionEvent.getX() < this.oPH) {
                this.oPE = true;
                this.oPI = VelocityTracker.obtain();
                return true;
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.oPF = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.oPE || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oPE) {
            if (this.oPI == null) {
                this.oPI = VelocityTracker.obtain();
            }
            this.oPI.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    this.bpE = motionEvent.getX();
                    this.bpF = motionEvent.getY();
                    this.currentX = this.bpE;
                    this.currentY = this.bpF;
                    this.lastX = this.bpE;
                    break;
                case 1:
                case 3:
                    this.oPI.computeCurrentVelocity(10000);
                    this.oPI.computeCurrentVelocity(1000, 20000.0f);
                    this.oPE = false;
                    this.oPK = false;
                    if (Math.abs(this.oPI.getXVelocity()) > (this.screenWidth / 200) * 1000) {
                        bi(this.oPI.getXVelocity());
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
                    if (f != 0.0f && !this.oPK) {
                        this.oPK = true;
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
        if (this.oPI != null) {
            this.oPI.recycle();
            this.oPI = null;
        }
    }

    public void elK() {
        if (this.oPL != null) {
            this.oPL.removeAllListeners();
            this.oPL.cancel();
        }
    }

    public void setContentX(float f) {
        this.bVQ.setX((int) f);
        invalidate();
    }

    public float getContentX() {
        return this.bVQ.getX();
    }

    private void Aw(boolean z) {
        int i;
        elK();
        this.oPL = ObjectAnimator.ofFloat(this, "contentX", getContentX(), 0.0f);
        if (z) {
            i = (int) ((200.0f * getContentX()) / this.screenWidth);
        } else {
            i = 200;
        }
        this.oPL.setDuration(i >= 100 ? i : 100);
        this.oPL.setInterpolator(new DecelerateInterpolator());
        this.oPL.start();
    }

    private void Ax(boolean z) {
        int i;
        elK();
        this.oPL = ObjectAnimator.ofFloat(this, "contentX", getContentX(), this.screenWidth);
        if (z) {
            i = (int) ((200.0f * (this.screenWidth - getContentX())) / this.screenWidth);
        } else {
            i = 200;
        }
        this.oPL.setDuration(i >= 100 ? i : 100);
        this.oPL.setInterpolator(new DecelerateInterpolator());
        this.oPL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.SwipeLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SwipeLayout.this.mActivity.isFinishing()) {
                    SwipeLayout.this.oPB = true;
                    SwipeLayout.this.mActivity.finish();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
        this.oPL.start();
    }

    private void bi(float f) {
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
