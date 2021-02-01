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
    private RelativeLayout aWD;
    private float bGT;
    private float bGV;
    private LinearLayout fLH;
    private ValueAnimator fLK;
    private int fLL;
    private int fLM;
    private boolean fyn;
    private BdTypeListView gzb;
    private View iQL;
    private boolean mIsFinish;
    private float mRatio;
    private BlankView mgU;
    private boolean mic;

    public SubPbView(Context context) {
        this(context, null);
    }

    public SubPbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubPbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRatio = 0.0f;
        this.fLM = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.fLL = l.getEquipmentHeight(context);
        this.fLK = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fLK.setDuration(300L);
        this.fLK.setInterpolator(new LinearInterpolator());
        this.fLK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.fLL = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.fLL / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.fLL == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.fLL == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.mgU = blankView;
    }

    public void setTopView(View view) {
        this.iQL = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.fLH = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.gzb = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aWD = relativeLayout;
    }

    public boolean dsJ() {
        return this.fyn;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.fLK.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mgU == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fLL == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bGT > this.bGV) {
                this.fLH.layout(i, (int) (this.bGT - this.bGV), i3, ((int) (this.bGT - this.bGV)) + this.fLH.getHeight());
                this.aWD.layout(i, ((int) (this.bGT - this.bGV)) + this.fLH.getHeight(), i3, i4);
            }
        } else {
            this.fLH.layout(i, this.fLL, i3, this.fLL + this.fLH.getMeasuredHeight());
            this.aWD.layout(i, this.fLL + this.fLH.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.mgU != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mgU == null || !this.mic) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fLK.isRunning()) {
            this.fLK.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bGV = motionEvent.getRawY();
                this.bGT = this.bGV;
                z = false;
                break;
            case 1:
            case 3:
                z = this.bGT > this.bGV && this.iQL.getTop() == 0 && this.gzb.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.bGT - this.bGV > ((float) this.fLM) && this.iQL.getTop() == 0 && this.gzb.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.fLK.setIntValues((int) (this.bGT - this.bGV), l.getEquipmentHeight(getContext()));
                    this.fLK.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bGV = 0.0f;
                    this.bGT = this.bGV;
                    requestLayout();
                    break;
                }
            case 2:
                this.bGT = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.bGT - this.bGV) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bGT > this.bGV && this.iQL.getTop() == 0 && this.gzb.getFirstVisiblePosition() == 0) {
            this.fyn = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fyn = true;
            return true;
        } else {
            this.fyn = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fLK.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fLK.start();
    }

    public void onDestroy() {
        this.fLK.cancel();
        this.fLK.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setEnableDragExit(boolean z) {
        this.mic = z;
    }
}
