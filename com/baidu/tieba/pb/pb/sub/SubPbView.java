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
    private RelativeLayout aYl;
    private float bHV;
    private float bHX;
    private boolean fAF;
    private LinearLayout fOd;
    private ValueAnimator fOg;
    private int fOh;
    private int fOi;
    private BdTypeListView gAY;
    private View iPK;
    private boolean mIsFinish;
    private float mRatio;
    private BlankView mcx;
    private boolean mdE;

    public SubPbView(Context context) {
        this(context, null);
    }

    public SubPbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubPbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRatio = 0.0f;
        this.fOi = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.fOh = l.getEquipmentHeight(context);
        this.fOg = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fOg.setDuration(300L);
        this.fOg.setInterpolator(new LinearInterpolator());
        this.fOg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.fOh = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.fOh / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.fOh == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.fOh == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.mcx = blankView;
    }

    public void setTopView(View view) {
        this.iPK = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.fOd = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.gAY = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aYl = relativeLayout;
    }

    public boolean dum() {
        return this.fAF;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.fOg.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mcx == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fOh == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bHV > this.bHX) {
                this.fOd.layout(i, (int) (this.bHV - this.bHX), i3, ((int) (this.bHV - this.bHX)) + this.fOd.getHeight());
                this.aYl.layout(i, ((int) (this.bHV - this.bHX)) + this.fOd.getHeight(), i3, i4);
            }
        } else {
            this.fOd.layout(i, this.fOh, i3, this.fOh + this.fOd.getMeasuredHeight());
            this.aYl.layout(i, this.fOh + this.fOd.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.mcx != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mcx == null || !this.mdE) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fOg.isRunning()) {
            this.fOg.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bHX = motionEvent.getRawY();
                this.bHV = this.bHX;
                z = false;
                break;
            case 1:
            case 3:
                z = this.bHV > this.bHX && this.iPK.getTop() == 0 && this.gAY.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.bHV - this.bHX > ((float) this.fOi) && this.iPK.getTop() == 0 && this.gAY.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.fOg.setIntValues((int) (this.bHV - this.bHX), l.getEquipmentHeight(getContext()));
                    this.fOg.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bHX = 0.0f;
                    this.bHV = this.bHX;
                    requestLayout();
                    break;
                }
            case 2:
                this.bHV = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.bHV - this.bHX) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bHV > this.bHX && this.iPK.getTop() == 0 && this.gAY.getFirstVisiblePosition() == 0) {
            this.fAF = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fAF = true;
            return true;
        } else {
            this.fAF = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fOg.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fOg.start();
    }

    public void onDestroy() {
        this.fOg.cancel();
        this.fOg.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setEnableDragExit(boolean z) {
        this.mdE = z;
    }
}
