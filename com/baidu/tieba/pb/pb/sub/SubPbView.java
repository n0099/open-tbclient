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
    private RelativeLayout agN;
    private float aym;
    private View ceM;
    private int dKp;
    private boolean dty;
    private BdTypeListView eka;
    private BlankView iVo;
    private LinearLayout iWt;
    private ValueAnimator iWu;
    private int iWv;
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
        this.iWv = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.dKp = l.getEquipmentHeight(context);
        this.iWu = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.iWu.setDuration(300L);
        this.iWu.setInterpolator(new LinearInterpolator());
        this.iWu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.dKp = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.dKp / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.dKp == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.dKp == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.iVo = blankView;
    }

    public void setTopView(View view) {
        this.ceM = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.iWt = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.eka = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.agN = relativeLayout;
    }

    public boolean crx() {
        return this.dty;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.iWu.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iVo == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.dKp == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.mLastTouchY > this.aym) {
                this.iWt.layout(i, (int) (this.mLastTouchY - this.aym), i3, ((int) (this.mLastTouchY - this.aym)) + this.iWt.getHeight());
                this.agN.layout(i, ((int) (this.mLastTouchY - this.aym)) + this.iWt.getHeight(), i3, i4);
            }
        } else {
            this.iWt.layout(i, this.dKp, i3, this.dKp + this.iWt.getMeasuredHeight());
            this.agN.layout(i, this.dKp + this.iWt.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.iVo != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.iVo == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.iWu.isRunning()) {
            this.iWu.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.aym = motionEvent.getRawY();
                this.mLastTouchY = this.aym;
                z = false;
                break;
            case 1:
            case 3:
                z = this.mLastTouchY > this.aym && this.ceM.getTop() == 0 && this.eka.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.mLastTouchY - this.aym > ((float) this.iWv) && this.ceM.getTop() == 0 && this.eka.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.iWu.setIntValues((int) (this.mLastTouchY - this.aym), l.getEquipmentHeight(getContext()));
                    this.iWu.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.aym = 0.0f;
                    this.mLastTouchY = this.aym;
                    requestLayout();
                    break;
                }
            case 2:
                this.mLastTouchY = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.mLastTouchY - this.aym) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.mLastTouchY > this.aym && this.ceM.getTop() == 0 && this.eka.getFirstVisiblePosition() == 0) {
            this.dty = true;
            requestLayout();
            return true;
        } else if (z) {
            this.dty = true;
            return true;
        } else {
            this.dty = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.iWu.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.iWu.start();
    }

    public void onDestroy() {
        this.iWu.cancel();
        this.iWu.removeAllUpdateListeners();
        clearAnimation();
    }
}
