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
    private Drawable pbX;
    public boolean pbY;
    protected boolean pbZ;
    protected boolean pca;
    private boolean pcb;
    private boolean pcc;
    private int pcd;
    private int pce;
    private VelocityTracker pcf;
    private int pcg;
    private boolean pch;
    private ObjectAnimator pci;
    private int screenWidth;
    private int touchSlop;

    public SwipeLayout(Context context) {
        super(context);
        this.pbY = false;
        this.pbZ = true;
        this.pca = false;
        this.pcb = false;
        this.pcc = false;
        this.pcd = 16;
        this.pce = 72;
        this.screenWidth = 1080;
        this.pcg = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pbY = false;
        this.pbZ = true;
        this.pca = false;
        this.pcb = false;
        this.pcc = false;
        this.pcd = 16;
        this.pce = 72;
        this.screenWidth = 1080;
        this.pcg = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public SwipeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pbY = false;
        this.pbZ = true;
        this.pca = false;
        this.pcb = false;
        this.pcc = false;
        this.pcd = 16;
        this.pce = 72;
        this.screenWidth = 1080;
        this.pcg = 30;
        this.touchSlop = 60;
        this.duration = 200;
        this.mContext = context;
    }

    public void setSwipeAnyWhere(boolean z) {
        this.pca = z;
    }

    public void setSwipeEnabled(boolean z) {
        this.pbZ = z;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        int dp2px = f.dp2px(this.mContext, 20.0f);
        int contentX = ((int) getContentX()) - dp2px;
        this.pbX.setBounds(contentX, view.getTop(), dp2px + contentX, view.getBottom());
        this.pbX.draw(canvas);
        this.pbX.setAlpha(76);
        return drawChild;
    }

    public void setCanSwipe(boolean z) {
        this.pcb = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.pbZ && !this.pcb && !this.pcc) {
            if (this.pca) {
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
                                this.pcb = true;
                                this.pcf = VelocityTracker.obtain();
                                return true;
                            }
                            this.pcc = true;
                            break;
                        }
                        break;
                }
            } else if (motionEvent.getAction() == 0 && motionEvent.getX() < this.pce) {
                this.pcb = true;
                this.pcf = VelocityTracker.obtain();
                return true;
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.pcc = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.pcb || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.pcb) {
            if (this.pcf == null) {
                this.pcf = VelocityTracker.obtain();
            }
            this.pcf.addMovement(motionEvent);
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
                    this.pcf.computeCurrentVelocity(10000);
                    this.pcf.computeCurrentVelocity(1000, 20000.0f);
                    this.pcb = false;
                    this.pch = false;
                    if (Math.abs(this.pcf.getXVelocity()) > (this.screenWidth / 200) * 1000) {
                        bw(this.pcf.getXVelocity());
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
                    if (f != 0.0f && !this.pch) {
                        this.pch = true;
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
        if (this.pcf != null) {
            this.pcf.recycle();
            this.pcf = null;
        }
    }

    public void eky() {
        if (this.pci != null) {
            this.pci.removeAllListeners();
            this.pci.cancel();
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
        eky();
        this.pci = ObjectAnimator.ofFloat(this, "contentX", getContentX(), 0.0f);
        if (z) {
            i = (int) ((200.0f * getContentX()) / this.screenWidth);
        } else {
            i = 200;
        }
        this.pci.setDuration(i >= 100 ? i : 100);
        this.pci.setInterpolator(new DecelerateInterpolator());
        this.pci.start();
    }

    private void AM(boolean z) {
        int i;
        eky();
        this.pci = ObjectAnimator.ofFloat(this, "contentX", getContentX(), this.screenWidth);
        if (z) {
            i = (int) ((200.0f * (this.screenWidth - getContentX())) / this.screenWidth);
        } else {
            i = 200;
        }
        this.pci.setDuration(i >= 100 ? i : 100);
        this.pci.setInterpolator(new DecelerateInterpolator());
        this.pci.addListener(new Animator.AnimatorListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.activity.SwipeLayout.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!SwipeLayout.this.mActivity.isFinishing()) {
                    SwipeLayout.this.pbY = true;
                    SwipeLayout.this.mActivity.finish();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }
        });
        this.pci.start();
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
