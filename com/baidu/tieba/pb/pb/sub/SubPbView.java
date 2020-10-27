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
/* loaded from: classes22.dex */
public class SubPbView extends LinearLayout {
    private RelativeLayout aTU;
    private float btA;
    private float btC;
    private boolean fez;
    private LinearLayout frC;
    private ValueAnimator frF;
    private int frG;
    private int frH;
    private BdTypeListView gcr;
    private View ilR;
    private BlankView lCX;
    private boolean lEb;
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
        this.frH = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.frG = l.getEquipmentHeight(context);
        this.frF = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.frF.setDuration(300L);
        this.frF.setInterpolator(new LinearInterpolator());
        this.frF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.frG = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.frG / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.frG == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.frG == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.lCX = blankView;
    }

    public void setTopView(View view) {
        this.ilR = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.frC = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.gcr = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aTU = relativeLayout;
    }

    public boolean dnc() {
        return this.fez;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.frF.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lCX == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.frG == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.btA > this.btC) {
                this.frC.layout(i, (int) (this.btA - this.btC), i3, ((int) (this.btA - this.btC)) + this.frC.getHeight());
                this.aTU.layout(i, ((int) (this.btA - this.btC)) + this.frC.getHeight(), i3, i4);
            }
        } else {
            this.frC.layout(i, this.frG, i3, this.frG + this.frC.getMeasuredHeight());
            this.aTU.layout(i, this.frG + this.frC.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.lCX != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.lCX == null || !this.lEb) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.frF.isRunning()) {
            this.frF.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.btC = motionEvent.getRawY();
                this.btA = this.btC;
                z = false;
                break;
            case 1:
            case 3:
                z = this.btA > this.btC && this.ilR.getTop() == 0 && this.gcr.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.btA - this.btC > ((float) this.frH) && this.ilR.getTop() == 0 && this.gcr.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.frF.setIntValues((int) (this.btA - this.btC), l.getEquipmentHeight(getContext()));
                    this.frF.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.btC = 0.0f;
                    this.btA = this.btC;
                    requestLayout();
                    break;
                }
            case 2:
                this.btA = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.btA - this.btC) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.btA > this.btC && this.ilR.getTop() == 0 && this.gcr.getFirstVisiblePosition() == 0) {
            this.fez = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fez = true;
            return true;
        } else {
            this.fez = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.frF.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.frF.start();
    }

    public void onDestroy() {
        this.frF.cancel();
        this.frF.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setEnableDragExit(boolean z) {
        this.lEb = z;
    }
}
