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
/* loaded from: classes21.dex */
public class SubPbView extends LinearLayout {
    private RelativeLayout aTB;
    private float byb;
    private float byd;
    private boolean fjA;
    private LinearLayout fwJ;
    private ValueAnimator fwM;
    private int fwN;
    private int fwO;
    private BdTypeListView ghN;
    private View isE;
    private BlankView lJl;
    private boolean lKp;
    private boolean mIsFinish;
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
        this.fwO = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.fwN = l.getEquipmentHeight(context);
        this.fwM = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fwM.setDuration(300L);
        this.fwM.setInterpolator(new LinearInterpolator());
        this.fwM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.fwN = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.fwN / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.fwN == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.fwN == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.lJl = blankView;
    }

    public void setTopView(View view) {
        this.isE = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.fwJ = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.ghN = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aTB = relativeLayout;
    }

    public boolean dpf() {
        return this.fjA;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.fwM.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lJl == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fwN == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.byb > this.byd) {
                this.fwJ.layout(i, (int) (this.byb - this.byd), i3, ((int) (this.byb - this.byd)) + this.fwJ.getHeight());
                this.aTB.layout(i, ((int) (this.byb - this.byd)) + this.fwJ.getHeight(), i3, i4);
            }
        } else {
            this.fwJ.layout(i, this.fwN, i3, this.fwN + this.fwJ.getMeasuredHeight());
            this.aTB.layout(i, this.fwN + this.fwJ.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.lJl != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.lJl == null || !this.lKp) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fwM.isRunning()) {
            this.fwM.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.byd = motionEvent.getRawY();
                this.byb = this.byd;
                z = false;
                break;
            case 1:
            case 3:
                z = this.byb > this.byd && this.isE.getTop() == 0 && this.ghN.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.byb - this.byd > ((float) this.fwO) && this.isE.getTop() == 0 && this.ghN.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.fwM.setIntValues((int) (this.byb - this.byd), l.getEquipmentHeight(getContext()));
                    this.fwM.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.byd = 0.0f;
                    this.byb = this.byd;
                    requestLayout();
                    break;
                }
            case 2:
                this.byb = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.byb - this.byd) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.byb > this.byd && this.isE.getTop() == 0 && this.ghN.getFirstVisiblePosition() == 0) {
            this.fjA = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fjA = true;
            return true;
        } else {
            this.fjA = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fwM.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fwM.start();
    }

    public void onDestroy() {
        this.fwM.cancel();
        this.fwM.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setEnableDragExit(boolean z) {
        this.lKp = z;
    }
}
