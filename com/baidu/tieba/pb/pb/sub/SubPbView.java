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
    private RelativeLayout aYd;
    private float bIt;
    private float bIv;
    private LinearLayout fNh;
    private ValueAnimator fNk;
    private int fNl;
    private int fNm;
    private boolean fzM;
    private BdTypeListView gAY;
    private View iSI;
    private boolean mIsFinish;
    private float mRatio;
    private BlankView mjn;
    private boolean mkv;

    public SubPbView(Context context) {
        this(context, null);
    }

    public SubPbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubPbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRatio = 0.0f;
        this.fNm = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.fNl = l.getEquipmentHeight(context);
        this.fNk = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fNk.setDuration(300L);
        this.fNk.setInterpolator(new LinearInterpolator());
        this.fNk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.fNl = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.fNl / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.fNl == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.fNl == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.mjn = blankView;
    }

    public void setTopView(View view) {
        this.iSI = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.fNh = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.gAY = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aYd = relativeLayout;
    }

    public boolean dsZ() {
        return this.fzM;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.fNk.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mjn == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fNl == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bIt > this.bIv) {
                this.fNh.layout(i, (int) (this.bIt - this.bIv), i3, ((int) (this.bIt - this.bIv)) + this.fNh.getHeight());
                this.aYd.layout(i, ((int) (this.bIt - this.bIv)) + this.fNh.getHeight(), i3, i4);
            }
        } else {
            this.fNh.layout(i, this.fNl, i3, this.fNl + this.fNh.getMeasuredHeight());
            this.aYd.layout(i, this.fNl + this.fNh.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.mjn != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mjn == null || !this.mkv) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fNk.isRunning()) {
            this.fNk.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bIv = motionEvent.getRawY();
                this.bIt = this.bIv;
                z = false;
                break;
            case 1:
            case 3:
                z = this.bIt > this.bIv && this.iSI.getTop() == 0 && this.gAY.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.bIt - this.bIv > ((float) this.fNm) && this.iSI.getTop() == 0 && this.gAY.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.fNk.setIntValues((int) (this.bIt - this.bIv), l.getEquipmentHeight(getContext()));
                    this.fNk.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bIv = 0.0f;
                    this.bIt = this.bIv;
                    requestLayout();
                    break;
                }
            case 2:
                this.bIt = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.bIt - this.bIv) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bIt > this.bIv && this.iSI.getTop() == 0 && this.gAY.getFirstVisiblePosition() == 0) {
            this.fzM = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fzM = true;
            return true;
        } else {
            this.fzM = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fNk.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fNk.start();
    }

    public void onDestroy() {
        this.fNk.cancel();
        this.fNk.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setEnableDragExit(boolean z) {
        this.mkv = z;
    }
}
