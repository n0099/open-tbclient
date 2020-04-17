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
    private float aSh;
    private float aSj;
    private RelativeLayout azn;
    private View cDX;
    private boolean dTU;
    private BdTypeListView eOe;
    private int ekJ;
    private BlankView jHl;
    private LinearLayout jIq;
    private ValueAnimator jIr;
    private int jIs;
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
        this.jIs = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.ekJ = l.getEquipmentHeight(context);
        this.jIr = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.jIr.setDuration(300L);
        this.jIr.setInterpolator(new LinearInterpolator());
        this.jIr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.ekJ = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.ekJ / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.ekJ == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.ekJ == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.jHl = blankView;
    }

    public void setTopView(View view) {
        this.cDX = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.jIq = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.eOe = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.azn = relativeLayout;
    }

    public boolean cCB() {
        return this.dTU;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.jIr.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.jHl == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.ekJ == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.aSh > this.aSj) {
                this.jIq.layout(i, (int) (this.aSh - this.aSj), i3, ((int) (this.aSh - this.aSj)) + this.jIq.getHeight());
                this.azn.layout(i, ((int) (this.aSh - this.aSj)) + this.jIq.getHeight(), i3, i4);
            }
        } else {
            this.jIq.layout(i, this.ekJ, i3, this.ekJ + this.jIq.getMeasuredHeight());
            this.azn.layout(i, this.ekJ + this.jIq.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.jHl != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.jHl == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.jIr.isRunning()) {
            this.jIr.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.aSj = motionEvent.getRawY();
                this.aSh = this.aSj;
                z = false;
                break;
            case 1:
            case 3:
                z = this.aSh > this.aSj && this.cDX.getTop() == 0 && this.eOe.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.aSh - this.aSj > ((float) this.jIs) && this.cDX.getTop() == 0 && this.eOe.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.jIr.setIntValues((int) (this.aSh - this.aSj), l.getEquipmentHeight(getContext()));
                    this.jIr.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.aSj = 0.0f;
                    this.aSh = this.aSj;
                    requestLayout();
                    break;
                }
            case 2:
                this.aSh = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.aSh - this.aSj) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.aSh > this.aSj && this.cDX.getTop() == 0 && this.eOe.getFirstVisiblePosition() == 0) {
            this.dTU = true;
            requestLayout();
            return true;
        } else if (z) {
            this.dTU = true;
            return true;
        } else {
            this.dTU = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.jIr.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.jIr.start();
    }

    public void onDestroy() {
        this.jIr.cancel();
        this.jIr.removeAllUpdateListeners();
        clearAnimation();
    }
}
