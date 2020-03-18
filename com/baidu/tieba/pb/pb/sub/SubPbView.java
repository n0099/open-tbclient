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
    private RelativeLayout agX;
    private float ayC;
    private View ceZ;
    private int dKT;
    private boolean dtZ;
    private BdTypeListView ekE;
    private BlankView iXd;
    private LinearLayout iYi;
    private ValueAnimator iYj;
    private int iYk;
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
        this.iYk = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.dKT = l.getEquipmentHeight(context);
        this.iYj = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.iYj.setDuration(300L);
        this.iYj.setInterpolator(new LinearInterpolator());
        this.iYj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.dKT = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.dKT / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.dKT == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.dKT == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.iXd = blankView;
    }

    public void setTopView(View view) {
        this.ceZ = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.iYi = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.ekE = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.agX = relativeLayout;
    }

    public boolean crV() {
        return this.dtZ;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.iYj.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iXd == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.dKT == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.mLastTouchY > this.ayC) {
                this.iYi.layout(i, (int) (this.mLastTouchY - this.ayC), i3, ((int) (this.mLastTouchY - this.ayC)) + this.iYi.getHeight());
                this.agX.layout(i, ((int) (this.mLastTouchY - this.ayC)) + this.iYi.getHeight(), i3, i4);
            }
        } else {
            this.iYi.layout(i, this.dKT, i3, this.dKT + this.iYi.getMeasuredHeight());
            this.agX.layout(i, this.dKT + this.iYi.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.iXd != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.iXd == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.iYj.isRunning()) {
            this.iYj.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.ayC = motionEvent.getRawY();
                this.mLastTouchY = this.ayC;
                z = false;
                break;
            case 1:
            case 3:
                z = this.mLastTouchY > this.ayC && this.ceZ.getTop() == 0 && this.ekE.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.mLastTouchY - this.ayC > ((float) this.iYk) && this.ceZ.getTop() == 0 && this.ekE.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.iYj.setIntValues((int) (this.mLastTouchY - this.ayC), l.getEquipmentHeight(getContext()));
                    this.iYj.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.ayC = 0.0f;
                    this.mLastTouchY = this.ayC;
                    requestLayout();
                    break;
                }
            case 2:
                this.mLastTouchY = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.mLastTouchY - this.ayC) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.mLastTouchY > this.ayC && this.ceZ.getTop() == 0 && this.ekE.getFirstVisiblePosition() == 0) {
            this.dtZ = true;
            requestLayout();
            return true;
        } else if (z) {
            this.dtZ = true;
            return true;
        } else {
            this.dtZ = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.iYj.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.iYj.start();
    }

    public void onDestroy() {
        this.iYj.cancel();
        this.iYj.removeAllUpdateListeners();
        clearAnimation();
    }
}
