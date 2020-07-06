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
    private RelativeLayout aHh;
    private float beH;
    private float beJ;
    private LinearLayout eDc;
    private ValueAnimator eDf;
    private int eDg;
    private int eDh;
    private boolean eqS;
    private BdTypeListView fml;
    private View hkM;
    private BlankView ktW;
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
        this.eDh = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.eDg = l.getEquipmentHeight(context);
        this.eDf = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.eDf.setDuration(300L);
        this.eDf.setInterpolator(new LinearInterpolator());
        this.eDf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.eDg = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.eDg / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.eDg == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.eDg == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.ktW = blankView;
    }

    public void setTopView(View view) {
        this.hkM = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.eDc = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.fml = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aHh = relativeLayout;
    }

    public boolean cOe() {
        return this.eqS;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.eDf.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.ktW == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.eDg == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.beH > this.beJ) {
                this.eDc.layout(i, (int) (this.beH - this.beJ), i3, ((int) (this.beH - this.beJ)) + this.eDc.getHeight());
                this.aHh.layout(i, ((int) (this.beH - this.beJ)) + this.eDc.getHeight(), i3, i4);
            }
        } else {
            this.eDc.layout(i, this.eDg, i3, this.eDg + this.eDc.getMeasuredHeight());
            this.aHh.layout(i, this.eDg + this.eDc.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.ktW != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.ktW == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.eDf.isRunning()) {
            this.eDf.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.beJ = motionEvent.getRawY();
                this.beH = this.beJ;
                z = false;
                break;
            case 1:
            case 3:
                z = this.beH > this.beJ && this.hkM.getTop() == 0 && this.fml.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.beH - this.beJ > ((float) this.eDh) && this.hkM.getTop() == 0 && this.fml.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.eDf.setIntValues((int) (this.beH - this.beJ), l.getEquipmentHeight(getContext()));
                    this.eDf.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.beJ = 0.0f;
                    this.beH = this.beJ;
                    requestLayout();
                    break;
                }
            case 2:
                this.beH = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.beH - this.beJ) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.beH > this.beJ && this.hkM.getTop() == 0 && this.fml.getFirstVisiblePosition() == 0) {
            this.eqS = true;
            requestLayout();
            return true;
        } else if (z) {
            this.eqS = true;
            return true;
        } else {
            this.eqS = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.eDf.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.eDf.start();
    }

    public void onDestroy() {
        this.eDf.cancel();
        this.eDf.removeAllUpdateListeners();
        clearAnimation();
    }
}
