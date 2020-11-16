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
    private View bQG;
    private float bkv;
    private float bkw;
    private float currentX;
    private float currentY;
    private final int duration;
    private float lastX;
    private Activity mActivity;
    private Context mContext;
    private int oAA;
    private int oAB;
    private VelocityTracker oAC;
    private int oAD;
    private boolean oAE;
    private ObjectAnimator oAF;
    private Drawable oAu;
    public boolean oAv;
    protected boolean oAw;
    protected boolean oAx;
    private boolean oAy;
    private boolean oAz;
    private int screenWidth;
    private int touchSlop;

    public SwipeLayout(Context context) {
        super(context);
        this.oAv = false;
        this.oAw = true;
        this.oAx = false;
        this.oAy = false;
        this.oAz = false;
        this.oAA = 16;
        this.oAB = 72;
        this.screenWidth = 1080;
        this.oAD = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oAv = false;
        this.oAw = true;
        this.oAx = false;
        this.oAy = false;
        this.oAz = false;
        this.oAA = 16;
        this.oAB = 72;
        this.screenWidth = 1080;
        this.oAD = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oAv = false;
        this.oAw = true;
        this.oAx = false;
        this.oAy = false;
        this.oAz = false;
        this.oAA = 16;
        this.oAB = 72;
        this.screenWidth = 1080;
        this.oAD = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public void setSwipeAnyWhere(boolean z) {
        this.oAx = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.oAw = z;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        int dp2px = f.dp2px(this.mContext, 20.0f);
        int contentX = ((int) getContentX()) - dp2px;
        this.oAu.setBounds(contentX, view.getTop(), dp2px + contentX, view.getBottom());
        this.oAu.draw(canvas);
        this.oAu.setAlpha(76);
        return drawChild;
    }

    public void setCanSwipe(boolean z) {
        this.oAy = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oAw && !this.oAy && !this.oAz) {
            if (this.oAx) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.bkv = motionEvent.getX();
                        this.bkw = motionEvent.getY();
                        this.currentX = this.bkv;
                        this.currentY = this.bkw;
                        this.lastX = this.bkv;
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.bkv;
                        float y = motionEvent.getY() - this.bkw;
                        if ((x * x) + (y * y) > this.touchSlop * this.touchSlop) {
                            if (y == 0.0f || Math.abs(x / y) > 1.0f) {
                                this.bkv = motionEvent.getX();
                                this.bkw = motionEvent.getY();
                                this.currentX = this.bkv;
                                this.currentY = this.bkw;
                                this.lastX = this.bkv;
                                this.oAy = true;
                                this.oAC = VelocityTracker.obtain();
                                return true;
                            }
                            this.oAz = true;
                            break;
                        }
                        break;
                }
            } else if (motionEvent.getAction() == 0 && motionEvent.getX() < this.oAB) {
                this.oAy = true;
                this.oAC = VelocityTracker.obtain();
                return true;
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.oAz = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.oAy || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oAy) {
            if (this.oAC == null) {
                this.oAC = VelocityTracker.obtain();
            }
            this.oAC.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    this.bkv = motionEvent.getX();
                    this.bkw = motionEvent.getY();
                    this.currentX = this.bkv;
                    this.currentY = this.bkw;
                    this.lastX = this.bkv;
                    break;
                case 1:
                case 3:
                    this.oAC.computeCurrentVelocity(10000);
                    this.oAC.computeCurrentVelocity(1000, 20000.0f);
                    this.oAy = false;
                    this.oAE = false;
                    if (Math.abs(this.oAC.getXVelocity()) > (this.screenWidth / 200) * 1000) {
                        bh(this.oAC.getXVelocity());
                    } else if (getContentX() > this.screenWidth / 3) {
                        zT(false);
                    } else {
                        zS(false);
                    }
                    recycleVelocityTracker();
                    break;
                case 2:
                    this.currentX = motionEvent.getX();
                    this.currentY = motionEvent.getY();
                    float f = this.currentX - this.lastX;
                    if (f != 0.0f && !this.oAE) {
                        this.oAE = true;
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
        if (this.oAC != null) {
            this.oAC.recycle();
            this.oAC = null;
        }
    }

    public void efW() {
        if (this.oAF != null) {
            this.oAF.removeAllListeners();
            this.oAF.cancel();
        }
    }

    public void setContentX(float f) {
        this.bQG.setX((int) f);
        invalidate();
    }

    public float getContentX() {
        return this.bQG.getX();
    }

    private void zS(boolean z) {
        int i;
        efW();
        this.oAF = ObjectAnimator.ofFloat(this, "contentX", getContentX(), 0.0f);
        if (z) {
            i = (int) ((200.0f * getContentX()) / this.screenWidth);
        } else {
            i = 200;
        }
        this.oAF.setDuration(i >= 100 ? i : 100);
        this.oAF.setInterpolator(new DecelerateInterpolator());
        this.oAF.start();
    }

    private void zT(boolean z) {
        int i;
        efW();
        this.oAF = ObjectAnimator.ofFloat(this, "contentX", getContentX(), this.screenWidth);
        if (z) {
            i = (int) ((200.0f * (this.screenWidth - getContentX())) / this.screenWidth);
        } else {
            i = 200;
        }
        this.oAF.setDuration(i >= 100 ? i : 100);
        this.oAF.setInterpolator(new DecelerateInterpolator());
        this.oAF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.SwipeLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SwipeLayout.this.mActivity.isFinishing()) {
                    SwipeLayout.this.oAv = true;
                    SwipeLayout.this.mActivity.finish();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
        this.oAF.start();
    }

    private void bh(float f) {
        if (f > 0.0f) {
            if (getContentX() < this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() < this.screenWidth / 3) {
                zS(false);
            } else {
                zT(true);
            }
        } else if (getContentX() > this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() > this.screenWidth / 3) {
            zT(false);
        } else {
            zS(true);
        }
    }
}
