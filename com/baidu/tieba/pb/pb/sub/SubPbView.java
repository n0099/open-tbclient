package com.baidu.tieba.pb.pb.sub;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class SubPbView extends LinearLayout {
    private RelativeLayout agN;
    private float ayn;
    private View ceN;
    private int dKq;
    private boolean dtz;
    private BdTypeListView ekb;
    private BlankView iVq;
    private LinearLayout iWv;
    private ValueAnimator iWw;
    private int iWx;
    private boolean mIsFinish;
    private float mLastTouchY;
    private float mRatio;

    public SubPbView(Context context) {
        this(context, null);
    }

    public SubPbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubPbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRatio = 0.0f;
        this.iWx = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.dKq = l.getEquipmentHeight(context);
        this.iWw = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.iWw.setDuration(300L);
        this.iWw.setInterpolator(new LinearInterpolator());
        this.iWw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.dKq = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.dKq / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.dKq == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.dKq == l.getEquipmentHeight(SubPbView.this.getContext())) {
                    SubPbView.this.mRatio = 0.0f;
                    if (SubPbView.this.mIsFinish && (SubPbView.this.getContext() instanceof Activity)) {
                        ((Activity) SubPbView.this.getContext()).finish();
                    }
                }
                SubPbView.this.requestLayout();
            }
        });
    }

    public void setBlankView(BlankView blankView) {
        this.iVq = blankView;
    }

    public void setTopView(View view) {
        this.ceN = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.iWv = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.ekb = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.agN = relativeLayout;
    }

    public boolean crz() {
        return this.dtz;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.iWw.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iVq == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.dKq == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.mLastTouchY > this.ayn) {
                this.iWv.layout(i, (int) (this.mLastTouchY - this.ayn), i3, ((int) (this.mLastTouchY - this.ayn)) + this.iWv.getHeight());
                this.agN.layout(i, ((int) (this.mLastTouchY - this.ayn)) + this.iWv.getHeight(), i3, i4);
            }
        } else {
            this.iWv.layout(i, this.dKq, i3, this.dKq + this.iWv.getMeasuredHeight());
            this.agN.layout(i, this.dKq + this.iWv.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.iVq != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.iVq == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.iWw.isRunning()) {
            this.iWw.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.ayn = motionEvent.getRawY();
                this.mLastTouchY = this.ayn;
                z = false;
                break;
            case 1:
            case 3:
                z = this.mLastTouchY > this.ayn && this.ceN.getTop() == 0 && this.ekb.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.mLastTouchY - this.ayn > ((float) this.iWx) && this.ceN.getTop() == 0 && this.ekb.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.iWw.setIntValues((int) (this.mLastTouchY - this.ayn), l.getEquipmentHeight(getContext()));
                    this.iWw.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.ayn = 0.0f;
                    this.mLastTouchY = this.ayn;
                    requestLayout();
                    break;
                }
            case 2:
                this.mLastTouchY = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.mLastTouchY - this.ayn) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.mLastTouchY > this.ayn && this.ceN.getTop() == 0 && this.ekb.getFirstVisiblePosition() == 0) {
            this.dtz = true;
            requestLayout();
            return true;
        } else if (z) {
            this.dtz = true;
            return true;
        } else {
            this.dtz = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.iWw.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.iWw.start();
    }

    public void onDestroy() {
        this.iWw.cancel();
        this.iWw.removeAllUpdateListeners();
        clearAnimation();
    }
}
