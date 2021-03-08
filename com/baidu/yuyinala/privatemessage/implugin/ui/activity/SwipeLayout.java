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
/* loaded from: classes10.dex */
public class SwipeLayout extends FrameLayout {
    private float brB;
    private float brC;
    private View ccD;
    private float currentX;
    private float currentY;
    private final int duration;
    private float lastX;
    private Activity mActivity;
    private Context mContext;
    private Drawable ped;
    public boolean pee;
    protected boolean pef;
    protected boolean peg;
    private boolean peh;
    private boolean pei;
    private int pej;
    private int pek;
    private VelocityTracker pel;
    private int pem;
    private boolean pen;
    private ObjectAnimator peo;
    private int screenWidth;
    private int touchSlop;

    public SwipeLayout(Context context) {
        super(context);
        this.pee = false;
        this.pef = true;
        this.peg = false;
        this.peh = false;
        this.pei = false;
        this.pej = 16;
        this.pek = 72;
        this.screenWidth = 1080;
        this.pem = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pee = false;
        this.pef = true;
        this.peg = false;
        this.peh = false;
        this.pei = false;
        this.pej = 16;
        this.pek = 72;
        this.screenWidth = 1080;
        this.pem = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pee = false;
        this.pef = true;
        this.peg = false;
        this.peh = false;
        this.pei = false;
        this.pej = 16;
        this.pek = 72;
        this.screenWidth = 1080;
        this.pem = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public void setSwipeAnyWhere(boolean z) {
        this.peg = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.pef = z;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        int dp2px = f.dp2px(this.mContext, 20.0f);
        int contentX = ((int) getContentX()) - dp2px;
        this.ped.setBounds(contentX, view.getTop(), dp2px + contentX, view.getBottom());
        this.ped.draw(canvas);
        this.ped.setAlpha(76);
        return drawChild;
    }

    public void setCanSwipe(boolean z) {
        this.peh = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.pef && !this.peh && !this.pei) {
            if (this.peg) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.brB = motionEvent.getX();
                        this.brC = motionEvent.getY();
                        this.currentX = this.brB;
                        this.currentY = this.brC;
                        this.lastX = this.brB;
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.brB;
                        float y = motionEvent.getY() - this.brC;
                        if ((x * x) + (y * y) > this.touchSlop * this.touchSlop) {
                            if (y == 0.0f || Math.abs(x / y) > 1.0f) {
                                this.brB = motionEvent.getX();
                                this.brC = motionEvent.getY();
                                this.currentX = this.brB;
                                this.currentY = this.brC;
                                this.lastX = this.brB;
                                this.peh = true;
                                this.pel = VelocityTracker.obtain();
                                return true;
                            }
                            this.pei = true;
                            break;
                        }
                        break;
                }
            } else if (motionEvent.getAction() == 0 && motionEvent.getX() < this.pek) {
                this.peh = true;
                this.pel = VelocityTracker.obtain();
                return true;
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.pei = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.peh || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.peh) {
            if (this.pel == null) {
                this.pel = VelocityTracker.obtain();
            }
            this.pel.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    this.brB = motionEvent.getX();
                    this.brC = motionEvent.getY();
                    this.currentX = this.brB;
                    this.currentY = this.brC;
                    this.lastX = this.brB;
                    break;
                case 1:
                case 3:
                    this.pel.computeCurrentVelocity(10000);
                    this.pel.computeCurrentVelocity(1000, 20000.0f);
                    this.peh = false;
                    this.pen = false;
                    if (Math.abs(this.pel.getXVelocity()) > (this.screenWidth / 200) * 1000) {
                        bA(this.pel.getXVelocity());
                    } else if (getContentX() > this.screenWidth / 3) {
                        AL(false);
                    } else {
                        AK(false);
                    }
                    recycleVelocityTracker();
                    break;
                case 2:
                    this.currentX = motionEvent.getX();
                    this.currentY = motionEvent.getY();
                    float f = this.currentX - this.lastX;
                    if (f != 0.0f && !this.pen) {
                        this.pen = true;
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
        if (this.pel != null) {
            this.pel.recycle();
            this.pel = null;
        }
    }

    public void ekI() {
        if (this.peo != null) {
            this.peo.removeAllListeners();
            this.peo.cancel();
        }
    }

    public void setContentX(float f) {
        this.ccD.setX((int) f);
        invalidate();
    }

    public float getContentX() {
        return this.ccD.getX();
    }

    private void AK(boolean z) {
        int i;
        ekI();
        this.peo = ObjectAnimator.ofFloat(this, "contentX", getContentX(), 0.0f);
        if (z) {
            i = (int) ((200.0f * getContentX()) / this.screenWidth);
        } else {
            i = 200;
        }
        this.peo.setDuration(i >= 100 ? i : 100);
        this.peo.setInterpolator(new DecelerateInterpolator());
        this.peo.start();
    }

    private void AL(boolean z) {
        int i;
        ekI();
        this.peo = ObjectAnimator.ofFloat(this, "contentX", getContentX(), this.screenWidth);
        if (z) {
            i = (int) ((200.0f * (this.screenWidth - getContentX())) / this.screenWidth);
        } else {
            i = 200;
        }
        this.peo.setDuration(i >= 100 ? i : 100);
        this.peo.setInterpolator(new DecelerateInterpolator());
        this.peo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.SwipeLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SwipeLayout.this.mActivity.isFinishing()) {
                    SwipeLayout.this.pee = true;
                    SwipeLayout.this.mActivity.finish();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
        this.peo.start();
    }

    private void bA(float f) {
        if (f > 0.0f) {
            if (getContentX() < this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() < this.screenWidth / 3) {
                AK(false);
            } else {
                AL(true);
            }
        } else if (getContentX() > this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() > this.screenWidth / 3) {
            AL(false);
        } else {
            AK(true);
        }
    }
}
