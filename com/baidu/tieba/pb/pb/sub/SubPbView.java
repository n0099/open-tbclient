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
    private RelativeLayout aWF;
    private float bDj;
    private float bDl;
    private ValueAnimator fEB;
    private int fEC;
    private int fED;
    private LinearLayout fEy;
    private boolean fqY;
    private BdTypeListView gpX;
    private View iDw;
    private BlankView lXf;
    private boolean lYm;
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
        this.fED = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.fEC = l.getEquipmentHeight(context);
        this.fEB = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fEB.setDuration(300L);
        this.fEB.setInterpolator(new LinearInterpolator());
        this.fEB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.fEC = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.fEC / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.fEC == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.fEC == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.lXf = blankView;
    }

    public void setTopView(View view) {
        this.iDw = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.fEy = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.gpX = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aWF = relativeLayout;
    }

    public boolean duw() {
        return this.fqY;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.fEB.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lXf == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fEC == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bDj > this.bDl) {
                this.fEy.layout(i, (int) (this.bDj - this.bDl), i3, ((int) (this.bDj - this.bDl)) + this.fEy.getHeight());
                this.aWF.layout(i, ((int) (this.bDj - this.bDl)) + this.fEy.getHeight(), i3, i4);
            }
        } else {
            this.fEy.layout(i, this.fEC, i3, this.fEC + this.fEy.getMeasuredHeight());
            this.aWF.layout(i, this.fEC + this.fEy.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.lXf != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.lXf == null || !this.lYm) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fEB.isRunning()) {
            this.fEB.end();
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
                z = this.bDj > this.bDl && this.iDw.getTop() == 0 && this.gpX.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.bDj - this.bDl > ((float) this.fED) && this.iDw.getTop() == 0 && this.gpX.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.fEB.setIntValues((int) (this.bDj - this.bDl), l.getEquipmentHeight(getContext()));
                    this.fEB.start();
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
        if (this.bDj > this.bDl && this.iDw.getTop() == 0 && this.gpX.getFirstVisiblePosition() == 0) {
            this.fqY = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fqY = true;
            return true;
        } else {
            this.fqY = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fEB.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fEB.start();
    }

    public void onDestroy() {
        this.fEB.cancel();
        this.fEB.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setEnableDragExit(boolean z) {
        this.lYm = z;
    }
}
