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
    private Drawable oPC;
    public boolean oPD;
    protected boolean oPE;
    protected boolean oPF;
    private boolean oPG;
    private boolean oPH;
    private int oPI;
    private int oPJ;
    private VelocityTracker oPK;
    private int oPL;
    private boolean oPM;
    private ObjectAnimator oPN;
    private int screenWidth;
    private int touchSlop;

    public SwipeLayout(Context context) {
        super(context);
        this.oPD = false;
        this.oPE = true;
        this.oPF = false;
        this.oPG = false;
        this.oPH = false;
        this.oPI = 16;
        this.oPJ = 72;
        this.screenWidth = 1080;
        this.oPL = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oPD = false;
        this.oPE = true;
        this.oPF = false;
        this.oPG = false;
        this.oPH = false;
        this.oPI = 16;
        this.oPJ = 72;
        this.screenWidth = 1080;
        this.oPL = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oPD = false;
        this.oPE = true;
        this.oPF = false;
        this.oPG = false;
        this.oPH = false;
        this.oPI = 16;
        this.oPJ = 72;
        this.screenWidth = 1080;
        this.oPL = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public void setSwipeAnyWhere(boolean z) {
        this.oPF = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.oPE = z;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        int dp2px = f.dp2px(this.mContext, 20.0f);
        int contentX = ((int) getContentX()) - dp2px;
        this.oPC.setBounds(contentX, view.getTop(), dp2px + contentX, view.getBottom());
        this.oPC.draw(canvas);
        this.oPC.setAlpha(76);
        return drawChild;
    }

    public void setCanSwipe(boolean z) {
        this.oPG = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oPE && !this.oPG && !this.oPH) {
            if (this.oPF) {
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
                                this.oPG = true;
                                this.oPK = VelocityTracker.obtain();
                                return true;
                            }
                            this.oPH = true;
                            break;
                        }
                        break;
                }
            } else if (motionEvent.getAction() == 0 && motionEvent.getX() < this.oPJ) {
                this.oPG = true;
                this.oPK = VelocityTracker.obtain();
                return true;
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.oPH = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.oPG || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oPG) {
            if (this.oPK == null) {
                this.oPK = VelocityTracker.obtain();
            }
            this.oPK.addMovement(motionEvent);
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
                    this.oPK.computeCurrentVelocity(10000);
                    this.oPK.computeCurrentVelocity(1000, 20000.0f);
                    this.oPG = false;
                    this.oPM = false;
                    if (Math.abs(this.oPK.getXVelocity()) > (this.screenWidth / 200) * 1000) {
                        bi(this.oPK.getXVelocity());
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
                    if (f != 0.0f && !this.oPM) {
                        this.oPM = true;
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
        if (this.oPK != null) {
            this.oPK.recycle();
            this.oPK = null;
        }
    }

    public void elL() {
        if (this.oPN != null) {
            this.oPN.removeAllListeners();
            this.oPN.cancel();
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
        elL();
        this.oPN = ObjectAnimator.ofFloat(this, "contentX", getContentX(), 0.0f);
        if (z) {
            i = (int) ((200.0f * getContentX()) / this.screenWidth);
        } else {
            i = 200;
        }
        this.oPN.setDuration(i >= 100 ? i : 100);
        this.oPN.setInterpolator(new DecelerateInterpolator());
        this.oPN.start();
    }

    private void Ax(boolean z) {
        int i;
        elL();
        this.oPN = ObjectAnimator.ofFloat(this, "contentX", getContentX(), this.screenWidth);
        if (z) {
            i = (int) ((200.0f * (this.screenWidth - getContentX())) / this.screenWidth);
        } else {
            i = 200;
        }
        this.oPN.setDuration(i >= 100 ? i : 100);
        this.oPN.setInterpolator(new DecelerateInterpolator());
        this.oPN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.SwipeLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SwipeLayout.this.mActivity.isFinishing()) {
                    SwipeLayout.this.oPD = true;
                    SwipeLayout.this.mActivity.finish();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
        this.oPN.start();
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
