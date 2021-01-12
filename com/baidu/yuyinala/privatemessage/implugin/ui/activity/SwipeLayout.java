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
    private View bWZ;
    private float bmA;
    private float bmB;
    private float currentX;
    private float currentY;
    private final int duration;
    private float lastX;
    private Activity mActivity;
    private Context mContext;
    private Drawable oRk;
    public boolean oRl;
    protected boolean oRm;
    protected boolean oRn;
    private boolean oRo;
    private boolean oRp;
    private int oRq;
    private int oRr;
    private VelocityTracker oRs;
    private int oRt;
    private boolean oRu;
    private ObjectAnimator oRv;
    private int screenWidth;
    private int touchSlop;

    public SwipeLayout(Context context) {
        super(context);
        this.oRl = false;
        this.oRm = true;
        this.oRn = false;
        this.oRo = false;
        this.oRp = false;
        this.oRq = 16;
        this.oRr = 72;
        this.screenWidth = 1080;
        this.oRt = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oRl = false;
        this.oRm = true;
        this.oRn = false;
        this.oRo = false;
        this.oRp = false;
        this.oRq = 16;
        this.oRr = 72;
        this.screenWidth = 1080;
        this.oRt = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oRl = false;
        this.oRm = true;
        this.oRn = false;
        this.oRo = false;
        this.oRp = false;
        this.oRq = 16;
        this.oRr = 72;
        this.screenWidth = 1080;
        this.oRt = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public void setSwipeAnyWhere(boolean z) {
        this.oRn = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.oRm = z;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        int dp2px = f.dp2px(this.mContext, 20.0f);
        int contentX = ((int) getContentX()) - dp2px;
        this.oRk.setBounds(contentX, view.getTop(), dp2px + contentX, view.getBottom());
        this.oRk.draw(canvas);
        this.oRk.setAlpha(76);
        return drawChild;
    }

    public void setCanSwipe(boolean z) {
        this.oRo = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oRm && !this.oRo && !this.oRp) {
            if (this.oRn) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.bmA = motionEvent.getX();
                        this.bmB = motionEvent.getY();
                        this.currentX = this.bmA;
                        this.currentY = this.bmB;
                        this.lastX = this.bmA;
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.bmA;
                        float y = motionEvent.getY() - this.bmB;
                        if ((x * x) + (y * y) > this.touchSlop * this.touchSlop) {
                            if (y == 0.0f || Math.abs(x / y) > 1.0f) {
                                this.bmA = motionEvent.getX();
                                this.bmB = motionEvent.getY();
                                this.currentX = this.bmA;
                                this.currentY = this.bmB;
                                this.lastX = this.bmA;
                                this.oRo = true;
                                this.oRs = VelocityTracker.obtain();
                                return true;
                            }
                            this.oRp = true;
                            break;
                        }
                        break;
                }
            } else if (motionEvent.getAction() == 0 && motionEvent.getX() < this.oRr) {
                this.oRo = true;
                this.oRs = VelocityTracker.obtain();
                return true;
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.oRp = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.oRo || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oRo) {
            if (this.oRs == null) {
                this.oRs = VelocityTracker.obtain();
            }
            this.oRs.addMovement(motionEvent);
            switch (motionEvent.getAction()) {
                case 0:
                    this.bmA = motionEvent.getX();
                    this.bmB = motionEvent.getY();
                    this.currentX = this.bmA;
                    this.currentY = this.bmB;
                    this.lastX = this.bmA;
                    break;
                case 1:
                case 3:
                    this.oRs.computeCurrentVelocity(10000);
                    this.oRs.computeCurrentVelocity(1000, 20000.0f);
                    this.oRo = false;
                    this.oRu = false;
                    if (Math.abs(this.oRs.getXVelocity()) > (this.screenWidth / 200) * 1000) {
                        bt(this.oRs.getXVelocity());
                    } else if (getContentX() > this.screenWidth / 3) {
                        At(false);
                    } else {
                        As(false);
                    }
                    recycleVelocityTracker();
                    break;
                case 2:
                    this.currentX = motionEvent.getX();
                    this.currentY = motionEvent.getY();
                    float f = this.currentX - this.lastX;
                    if (f != 0.0f && !this.oRu) {
                        this.oRu = true;
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
        if (this.oRs != null) {
            this.oRs.recycle();
            this.oRs = null;
        }
    }

    public void ehW() {
        if (this.oRv != null) {
            this.oRv.removeAllListeners();
            this.oRv.cancel();
        }
    }

    public void setContentX(float f) {
        this.bWZ.setX((int) f);
        invalidate();
    }

    public float getContentX() {
        return this.bWZ.getX();
    }

    private void As(boolean z) {
        int i;
        ehW();
        this.oRv = ObjectAnimator.ofFloat(this, "contentX", getContentX(), 0.0f);
        if (z) {
            i = (int) ((200.0f * getContentX()) / this.screenWidth);
        } else {
            i = 200;
        }
        this.oRv.setDuration(i >= 100 ? i : 100);
        this.oRv.setInterpolator(new DecelerateInterpolator());
        this.oRv.start();
    }

    private void At(boolean z) {
        int i;
        ehW();
        this.oRv = ObjectAnimator.ofFloat(this, "contentX", getContentX(), this.screenWidth);
        if (z) {
            i = (int) ((200.0f * (this.screenWidth - getContentX())) / this.screenWidth);
        } else {
            i = 200;
        }
        this.oRv.setDuration(i >= 100 ? i : 100);
        this.oRv.setInterpolator(new DecelerateInterpolator());
        this.oRv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.SwipeLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SwipeLayout.this.mActivity.isFinishing()) {
                    SwipeLayout.this.oRl = true;
                    SwipeLayout.this.mActivity.finish();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
        this.oRv.start();
    }

    private void bt(float f) {
        if (f > 0.0f) {
            if (getContentX() < this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() < this.screenWidth / 3) {
                As(false);
            } else {
                At(true);
            }
        } else if (getContentX() > this.screenWidth / 3 && ((f * 200.0f) / 1000.0f) + getContentX() > this.screenWidth / 3) {
            At(false);
        } else {
            As(true);
        }
    }
}
