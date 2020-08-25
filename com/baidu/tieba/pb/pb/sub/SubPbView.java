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
/* loaded from: classes16.dex */
public class SubPbView extends LinearLayout {
    private RelativeLayout aNN;
    private float bkL;
    private float bkN;
    private boolean eHL;
    private LinearLayout eTX;
    private ValueAnimator eUa;
    private int eUb;
    private int eUc;
    private BdTypeListView fCP;
    private View hDo;
    private BlankView kSw;
    private boolean kTA;
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
        this.eUc = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.eUb = l.getEquipmentHeight(context);
        this.eUa = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.eUa.setDuration(300L);
        this.eUa.setInterpolator(new LinearInterpolator());
        this.eUa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.eUb = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.eUb / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.eUb == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.eUb == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.kSw = blankView;
    }

    public void setTopView(View view) {
        this.hDo = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.eTX = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.fCP = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aNN = relativeLayout;
    }

    public boolean dcH() {
        return this.eHL;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.eUa.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kSw == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.eUb == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bkL > this.bkN) {
                this.eTX.layout(i, (int) (this.bkL - this.bkN), i3, ((int) (this.bkL - this.bkN)) + this.eTX.getHeight());
                this.aNN.layout(i, ((int) (this.bkL - this.bkN)) + this.eTX.getHeight(), i3, i4);
            }
        } else {
            this.eTX.layout(i, this.eUb, i3, this.eUb + this.eTX.getMeasuredHeight());
            this.aNN.layout(i, this.eUb + this.eTX.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.kSw != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.kSw == null || !this.kTA) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eUa.isRunning()) {
            this.eUa.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bkN = motionEvent.getRawY();
                this.bkL = this.bkN;
                z = false;
                break;
            case 1:
            case 3:
                z = this.bkL > this.bkN && this.hDo.getTop() == 0 && this.fCP.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.bkL - this.bkN > ((float) this.eUc) && this.hDo.getTop() == 0 && this.fCP.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.eUa.setIntValues((int) (this.bkL - this.bkN), l.getEquipmentHeight(getContext()));
                    this.eUa.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bkN = 0.0f;
                    this.bkL = this.bkN;
                    requestLayout();
                    break;
                }
            case 2:
                this.bkL = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.bkL - this.bkN) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bkL > this.bkN && this.hDo.getTop() == 0 && this.fCP.getFirstVisiblePosition() == 0) {
            this.eHL = true;
            requestLayout();
            return true;
        } else if (z) {
            this.eHL = true;
            return true;
        } else {
            this.eHL = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.eUa.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.eUa.start();
    }

    public void onDestroy() {
        this.eUa.cancel();
        this.eUa.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setEnableDragExit(boolean z) {
        this.kTA = z;
    }
}
