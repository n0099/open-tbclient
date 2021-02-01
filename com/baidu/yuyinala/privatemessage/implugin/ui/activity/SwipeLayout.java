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
    private float bqb;
    private float bqc;
    private View cbb;
    private float currentX;
    private float currentY;
    private final int duration;
    private float lastX;
    private Activity mActivity;
    private Context mContext;
    protected boolean pbA;
    private boolean pbB;
    private boolean pbC;
    private int pbD;
    private int pbE;
    private VelocityTracker pbF;
    private int pbG;
    private boolean pbH;
    private ObjectAnimator pbI;
    private Drawable pbx;
    public boolean pby;
    protected boolean pbz;
    private int screenWidth;
    private int touchSlop;

    public SwipeLayout(Context context) {
        super(context);
        this.pby = false;
        this.pbz = true;
        this.pbA = false;
        this.pbB = false;
        this.pbC = false;
        this.pbD = 16;
        this.pbE = 72;
        this.screenWidth = 1080;
        this.pbG = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pby = false;
        this.pbz = true;
        this.pbA = false;
        this.pbB = false;
        this.pbC = false;
        this.pbD = 16;
        this.pbE = 72;
        this.screenWidth = 1080;
        this.pbG = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pby = false;
        this.pbz = true;
        this.pbA = false;
        this.pbB = false;
        this.pbC = false;
        this.pbD = 16;
        this.pbE = 72;
        this.screenWidth = 1080;
        this.pbG = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public void setSwipeAnyWhere(boolean z) {
        this.pbA = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.pbz = z;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        int dp2px = f.dp2px(this.mContext, 20.0f);
        int contentX = ((int) getContentX()) - dp2px;
        this.pbx.setBounds(contentX, view.getTop(), dp2px + contentX, view.getBottom());
        this.pbx.draw(canvas);
        this.pbx.setAlpha(76);
        return drawChild;
    }

    public void setCanSwipe(boolean z) {
        this.pbB = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.pbz && !this.pbB && !this.pbC) {
            if (this.pbA) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.bqb = motionEvent.getX();
                        this.bqc = motionEvent.getY();
                        this.currentX = this.bqb;
                        this.currentY = this.bqc;
                        this.lastX = this.bqb;
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.bqb;
                        float y = motionEvent.getY() - this.bqc;
                        if ((x * x) + (y * y) > this.touchSlop * this.touchSlop) {
                            if (y == 0.0f || Math.abs(x / y) > 1.0f) {
                                this.bqb = motionEvent.getX();
                                this.bqc = motionEvent.getY();
                                this.currentX = this.bqb;
                                this.currentY = this.bqc;
                                this.lastX = this.bqb;
                                this.pbB = true;
                                this.pbF = VelocityTracker.obtain();
                                return true;
                            }
                            this.pbC = true;
                            break;
                        }
                        break;
                }
            } else if (motionEvent.getAction() == 0 && motionEvent.getX() < this.pbE) {
                this.pbB = true;
                this.pbF = VelocityTracker.obtain();
                return true;
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.pbC = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.pbB || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.pbB) {
            if (this.pbF == null) {
                this.pbF = VelocityTracker.obtain();
            }
            this.pbF.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    this.bqb = motionEvent.getX();
                    this.bqc = motionEvent.getY();
                    this.currentX = this.bqb;
                    this.currentY = this.bqc;
                    this.lastX = this.bqb;
                    break;
                case 1:
                case 3:
                    this.pbF.computeCurrentVelocity(10000);
                    this.pbF.computeCurrentVelocity(1000, 20000.0f);
                    this.pbB = false;
                    this.pbH = false;
                    if (Math.abs(this.pbF.getXVelocity()) > (this.screenWidth / 200) * 1000) {
                        bw(this.pbF.getXVelocity());
                    } else if (getContentX() > this.screenWidth / 3) {
                        AM(false);
                    } else {
                        AL(false);
                    }
                    recycleVelocityTracker();
                    break;
                case 2:
                    this.currentX = motionEvent.getX();
                    this.currentY = motionEvent.getY();
                    float f = this.currentX - this.lastX;
                    if (f != 0.0f && !this.pbH) {
                        this.pbH = true;
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
        if (this.pbF != null) {
            this.pbF.recycle();
            this.pbF = null;
        }
    }

    public void ekq() {
        if (this.pbI != null) {
            this.pbI.removeAllListeners();
            this.pbI.cancel();
        }
    }

    public void setContentX(float f) {
        this.cbb.setX((int) f);
        invalidate();
    }

    public float getContentX() {
        return this.cbb.getX();
    }

    private void AL(boolean z) {
        int i;
        ekq();
        this.pbI = ObjectAnimator.ofFloat(this, "contentX", getContentX(), 0.0f);
        if (z) {
            i = (int) ((200.0f * getContentX()) / this.screenWidth);
        } else {
            i = 200;
        }
        this.pbI.setDuration(i >= 100 ? i : 100);
        this.pbI.setInterpolator(new DecelerateInterpolator());
        this.pbI.start();
    }

    private void AM(boolean z) {
        int i;
        ekq();
        this.pbI = ObjectAnimator.ofFloat(this, "contentX", getContentX(), this.screenWidth);
        if (z) {
            i = (int) ((200.0f * (this.screenWidth - getContentX())) / this.screenWidth);
        } else {
            i = 200;
        }
        this.pbI.setDuration(i >= 100 ? i : 100);
        this.pbI.setInterpolator(new DecelerateInterpolator());
        this.pbI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.SwipeLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SwipeLayout.this.mActivity.isFinishing()) {
                    SwipeLayout.this.pby = true;
                    SwipeLayout.this.mActivity.finish();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
        this.pbI.start();
    }

    private void bw(float f) {
        if (f > 0.0f) {
            if (getContentX() < this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() < this.screenWidth / 3) {
                AL(false);
            } else {
                AM(true);
            }
        } else if (getContentX() > this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() > this.screenWidth / 3) {
            AM(false);
        } else {
            AL(true);
        }
    }
}
