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
/* loaded from: classes6.dex */
public class SubPbView extends LinearLayout {
    private float atk;
    private View cau;
    private int dGb;
    private boolean dpf;
    private BdTypeListView efM;
    private BlankView iQq;
    private LinearLayout iRv;
    private RelativeLayout iRw;
    private ValueAnimator iRx;
    private int iRy;
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
        this.iRy = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.dGb = l.getEquipmentHeight(context);
        this.iRx = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.iRx.setDuration(300L);
        this.iRx.setInterpolator(new LinearInterpolator());
        this.iRx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.dGb = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.dGb / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.dGb == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.dGb == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.iQq = blankView;
    }

    public void setTopView(View view) {
        this.cau = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.iRv = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.efM = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.iRw = relativeLayout;
    }

    public boolean coY() {
        return this.dpf;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.iRx.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iQq == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.dGb == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.mLastTouchY > this.atk) {
                this.iRv.layout(i, (int) (this.mLastTouchY - this.atk), i3, ((int) (this.mLastTouchY - this.atk)) + this.iRv.getHeight());
                this.iRw.layout(i, ((int) (this.mLastTouchY - this.atk)) + this.iRv.getHeight(), i3, i4);
            }
        } else {
            this.iRv.layout(i, this.dGb, i3, this.dGb + this.iRv.getMeasuredHeight());
            this.iRw.layout(i, this.dGb + this.iRv.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.iQq != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.iQq == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.iRx.isRunning()) {
            this.iRx.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.atk = motionEvent.getRawY();
                this.mLastTouchY = this.atk;
                z = false;
                break;
            case 1:
            case 3:
                z = this.mLastTouchY > this.atk && this.cau.getTop() == 0 && this.efM.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.mLastTouchY - this.atk > ((float) this.iRy) && this.cau.getTop() == 0 && this.efM.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.iRx.setIntValues((int) (this.mLastTouchY - this.atk), l.getEquipmentHeight(getContext()));
                    this.iRx.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.atk = 0.0f;
                    this.mLastTouchY = this.atk;
                    requestLayout();
                    break;
                }
            case 2:
                this.mLastTouchY = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.mLastTouchY - this.atk) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.mLastTouchY > this.atk && this.cau.getTop() == 0 && this.efM.getFirstVisiblePosition() == 0) {
            this.dpf = true;
            requestLayout();
            return true;
        } else if (z) {
            this.dpf = true;
            return true;
        } else {
            this.dpf = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.iRx.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.iRx.start();
    }

    public void onDestroy() {
        this.iRx.cancel();
        this.iRx.removeAllUpdateListeners();
        clearAnimation();
    }
}
