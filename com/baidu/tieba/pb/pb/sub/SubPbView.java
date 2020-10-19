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
    private RelativeLayout aSY;
    private float bru;
    private float brw;
    private boolean eWd;
    private BdTypeListView fSo;
    private LinearLayout fjd;
    private ValueAnimator fjg;
    private int fjh;
    private int fji;
    private View hZr;
    private BlankView lqy;
    private boolean lrC;
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
        this.fji = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.fjh = l.getEquipmentHeight(context);
        this.fjg = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fjg.setDuration(300L);
        this.fjg.setInterpolator(new LinearInterpolator());
        this.fjg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.fjh = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.fjh / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.fjh == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.fjh == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.lqy = blankView;
    }

    public void setTopView(View view) {
        this.hZr = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.fjd = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.fSo = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aSY = relativeLayout;
    }

    public boolean djV() {
        return this.eWd;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.fjg.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lqy == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fjh == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bru > this.brw) {
                this.fjd.layout(i, (int) (this.bru - this.brw), i3, ((int) (this.bru - this.brw)) + this.fjd.getHeight());
                this.aSY.layout(i, ((int) (this.bru - this.brw)) + this.fjd.getHeight(), i3, i4);
            }
        } else {
            this.fjd.layout(i, this.fjh, i3, this.fjh + this.fjd.getMeasuredHeight());
            this.aSY.layout(i, this.fjh + this.fjd.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.lqy != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.lqy == null || !this.lrC) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fjg.isRunning()) {
            this.fjg.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.brw = motionEvent.getRawY();
                this.bru = this.brw;
                z = false;
                break;
            case 1:
            case 3:
                z = this.bru > this.brw && this.hZr.getTop() == 0 && this.fSo.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.bru - this.brw > ((float) this.fji) && this.hZr.getTop() == 0 && this.fSo.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.fjg.setIntValues((int) (this.bru - this.brw), l.getEquipmentHeight(getContext()));
                    this.fjg.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.brw = 0.0f;
                    this.bru = this.brw;
                    requestLayout();
                    break;
                }
            case 2:
                this.bru = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.bru - this.brw) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bru > this.brw && this.hZr.getTop() == 0 && this.fSo.getFirstVisiblePosition() == 0) {
            this.eWd = true;
            requestLayout();
            return true;
        } else if (z) {
            this.eWd = true;
            return true;
        } else {
            this.eWd = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fjg.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fjg.start();
    }

    public void onDestroy() {
        this.fjg.cancel();
        this.fjg.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setEnableDragExit(boolean z) {
        this.lrC = z;
    }
}
