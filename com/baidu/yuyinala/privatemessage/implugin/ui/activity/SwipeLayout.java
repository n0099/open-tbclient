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
    private Drawable oRl;
    public boolean oRm;
    protected boolean oRn;
    protected boolean oRo;
    private boolean oRp;
    private boolean oRq;
    private int oRr;
    private int oRs;
    private VelocityTracker oRt;
    private int oRu;
    private boolean oRv;
    private ObjectAnimator oRw;
    private int screenWidth;
    private int touchSlop;

    public SwipeLayout(Context context) {
        super(context);
        this.oRm = false;
        this.oRn = true;
        this.oRo = false;
        this.oRp = false;
        this.oRq = false;
        this.oRr = 16;
        this.oRs = 72;
        this.screenWidth = 1080;
        this.oRu = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oRm = false;
        this.oRn = true;
        this.oRo = false;
        this.oRp = false;
        this.oRq = false;
        this.oRr = 16;
        this.oRs = 72;
        this.screenWidth = 1080;
        this.oRu = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oRm = false;
        this.oRn = true;
        this.oRo = false;
        this.oRp = false;
        this.oRq = false;
        this.oRr = 16;
        this.oRs = 72;
        this.screenWidth = 1080;
        this.oRu = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public void setSwipeAnyWhere(boolean z) {
        this.oRo = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.oRn = z;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        int dp2px = f.dp2px(this.mContext, 20.0f);
        int contentX = ((int) getContentX()) - dp2px;
        this.oRl.setBounds(contentX, view.getTop(), dp2px + contentX, view.getBottom());
        this.oRl.draw(canvas);
        this.oRl.setAlpha(76);
        return drawChild;
    }

    public void setCanSwipe(boolean z) {
        this.oRp = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.oRn && !this.oRp && !this.oRq) {
            if (this.oRo) {
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
                                this.oRp = true;
                                this.oRt = VelocityTracker.obtain();
                                return true;
                            }
                            this.oRq = true;
                            break;
                        }
                        break;
                }
            } else if (motionEvent.getAction() == 0 && motionEvent.getX() < this.oRs) {
                this.oRp = true;
                this.oRt = VelocityTracker.obtain();
                return true;
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.oRq = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.oRp || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oRp) {
            if (this.oRt == null) {
                this.oRt = VelocityTracker.obtain();
            }
            this.oRt.addMovement(motionEvent);
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
                    this.oRt.computeCurrentVelocity(10000);
                    this.oRt.computeCurrentVelocity(1000, 20000.0f);
                    this.oRp = false;
                    this.oRv = false;
                    if (Math.abs(this.oRt.getXVelocity()) > (this.screenWidth / 200) * 1000) {
                        bt(this.oRt.getXVelocity());
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
                    if (f != 0.0f && !this.oRv) {
                        this.oRv = true;
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
        if (this.oRt != null) {
            this.oRt.recycle();
            this.oRt = null;
        }
    }

    public void ehW() {
        if (this.oRw != null) {
            this.oRw.removeAllListeners();
            this.oRw.cancel();
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
        this.oRw = ObjectAnimator.ofFloat(this, "contentX", getContentX(), 0.0f);
        if (z) {
            i = (int) ((200.0f * getContentX()) / this.screenWidth);
        } else {
            i = 200;
        }
        this.oRw.setDuration(i >= 100 ? i : 100);
        this.oRw.setInterpolator(new DecelerateInterpolator());
        this.oRw.start();
    }

    private void At(boolean z) {
        int i;
        ehW();
        this.oRw = ObjectAnimator.ofFloat(this, "contentX", getContentX(), this.screenWidth);
        if (z) {
            i = (int) ((200.0f * (this.screenWidth - getContentX())) / this.screenWidth);
        } else {
            i = 200;
        }
        this.oRw.setDuration(i >= 100 ? i : 100);
        this.oRw.setInterpolator(new DecelerateInterpolator());
        this.oRw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.SwipeLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SwipeLayout.this.mActivity.isFinishing()) {
                    SwipeLayout.this.oRm = true;
                    SwipeLayout.this.mActivity.finish();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
        this.oRw.start();
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
