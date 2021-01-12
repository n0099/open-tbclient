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
/* loaded from: classes2.dex */
public class SubPbView extends LinearLayout {
    private RelativeLayout aTy;
    private float bDj;
    private float bDl;
    private int fJA;
    private int fJB;
    private LinearLayout fJw;
    private ValueAnimator fJz;
    private boolean fvX;
    private BdTypeListView gwr;
    private View iLd;
    private BlankView lXP;
    private boolean lYW;
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
        this.fJB = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.fJA = l.getEquipmentHeight(context);
        this.fJz = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fJz.setDuration(300L);
        this.fJz.setInterpolator(new LinearInterpolator());
        this.fJz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.fJA = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.fJA / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.fJA == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.fJA == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.lXP = blankView;
    }

    public void setTopView(View view) {
        this.iLd = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.fJw = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.gwr = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aTy = relativeLayout;
    }

    public boolean dqv() {
        return this.fvX;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.fJz.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lXP == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fJA == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bDj > this.bDl) {
                this.fJw.layout(i, (int) (this.bDj - this.bDl), i3, ((int) (this.bDj - this.bDl)) + this.fJw.getHeight());
                this.aTy.layout(i, ((int) (this.bDj - this.bDl)) + this.fJw.getHeight(), i3, i4);
            }
        } else {
            this.fJw.layout(i, this.fJA, i3, this.fJA + this.fJw.getMeasuredHeight());
            this.aTy.layout(i, this.fJA + this.fJw.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.lXP != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.lXP == null || !this.lYW) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fJz.isRunning()) {
            this.fJz.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bDl = motionEvent.getRawY();
                this.bDj = this.bDl;
                z = false;
                break;
            case 1:
            case 3:
                z = this.bDj > this.bDl && this.iLd.getTop() == 0 && this.gwr.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.bDj - this.bDl > ((float) this.fJB) && this.iLd.getTop() == 0 && this.gwr.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.fJz.setIntValues((int) (this.bDj - this.bDl), l.getEquipmentHeight(getContext()));
                    this.fJz.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bDl = 0.0f;
                    this.bDj = this.bDl;
                    requestLayout();
                    break;
                }
            case 2:
                this.bDj = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.bDj - this.bDl) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bDj > this.bDl && this.iLd.getTop() == 0 && this.gwr.getFirstVisiblePosition() == 0) {
            this.fvX = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fvX = true;
            return true;
        } else {
            this.fvX = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fJz.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fJz.start();
    }

    public void onDestroy() {
        this.fJz.cancel();
        this.fJz.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setEnableDragExit(boolean z) {
        this.lYW = z;
    }
}
