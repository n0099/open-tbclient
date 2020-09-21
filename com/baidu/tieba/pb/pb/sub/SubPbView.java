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
    private RelativeLayout aPN;
    private float bnH;
    private float bnJ;
    private boolean eJW;
    private LinearLayout eWR;
    private ValueAnimator eWU;
    private int eWV;
    private int eWW;
    private BdTypeListView fGf;
    private View hKw;
    private BlankView lbh;
    private boolean lcl;
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
        this.eWW = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.eWV = l.getEquipmentHeight(context);
        this.eWU = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.eWU.setDuration(300L);
        this.eWU.setInterpolator(new LinearInterpolator());
        this.eWU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.eWV = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.eWV / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.eWV == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.eWV == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.lbh = blankView;
    }

    public void setTopView(View view) {
        this.hKw = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.eWR = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.fGf = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aPN = relativeLayout;
    }

    public boolean dgm() {
        return this.eJW;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.eWU.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lbh == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.eWV == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bnH > this.bnJ) {
                this.eWR.layout(i, (int) (this.bnH - this.bnJ), i3, ((int) (this.bnH - this.bnJ)) + this.eWR.getHeight());
                this.aPN.layout(i, ((int) (this.bnH - this.bnJ)) + this.eWR.getHeight(), i3, i4);
            }
        } else {
            this.eWR.layout(i, this.eWV, i3, this.eWV + this.eWR.getMeasuredHeight());
            this.aPN.layout(i, this.eWV + this.eWR.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.lbh != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.lbh == null || !this.lcl) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eWU.isRunning()) {
            this.eWU.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bnJ = motionEvent.getRawY();
                this.bnH = this.bnJ;
                z = false;
                break;
            case 1:
            case 3:
                z = this.bnH > this.bnJ && this.hKw.getTop() == 0 && this.fGf.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.bnH - this.bnJ > ((float) this.eWW) && this.hKw.getTop() == 0 && this.fGf.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.eWU.setIntValues((int) (this.bnH - this.bnJ), l.getEquipmentHeight(getContext()));
                    this.eWU.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bnJ = 0.0f;
                    this.bnH = this.bnJ;
                    requestLayout();
                    break;
                }
            case 2:
                this.bnH = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.bnH - this.bnJ) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bnH > this.bnJ && this.hKw.getTop() == 0 && this.fGf.getFirstVisiblePosition() == 0) {
            this.eJW = true;
            requestLayout();
            return true;
        } else if (z) {
            this.eJW = true;
            return true;
        } else {
            this.eJW = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.eWU.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.eWU.start();
    }

    public void onDestroy() {
        this.eWU.cancel();
        this.eWU.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setEnableDragExit(boolean z) {
        this.lcl = z;
    }
}
