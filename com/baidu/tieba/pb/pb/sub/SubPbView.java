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
    private RelativeLayout aVm;
    private float bzM;
    private float bzO;
    private boolean fks;
    private LinearLayout fxu;
    private ValueAnimator fxx;
    private int fxy;
    private int fxz;
    private BdTypeListView gih;
    private View irQ;
    private BlankView lIT;
    private boolean lJX;
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
        this.fxz = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.fxy = l.getEquipmentHeight(context);
        this.fxx = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.fxx.setDuration(300L);
        this.fxx.setInterpolator(new LinearInterpolator());
        this.fxx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.fxy = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.fxy / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.fxy == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.fxy == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.lIT = blankView;
    }

    public void setTopView(View view) {
        this.irQ = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.fxu = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.gih = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aVm = relativeLayout;
    }

    public boolean dpF() {
        return this.fks;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.fxx.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.lIT == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.fxy == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.bzM > this.bzO) {
                this.fxu.layout(i, (int) (this.bzM - this.bzO), i3, ((int) (this.bzM - this.bzO)) + this.fxu.getHeight());
                this.aVm.layout(i, ((int) (this.bzM - this.bzO)) + this.fxu.getHeight(), i3, i4);
            }
        } else {
            this.fxu.layout(i, this.fxy, i3, this.fxy + this.fxu.getMeasuredHeight());
            this.aVm.layout(i, this.fxy + this.fxu.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.lIT != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.lIT == null || !this.lJX) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.fxx.isRunning()) {
            this.fxx.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.bzO = motionEvent.getRawY();
                this.bzM = this.bzO;
                z = false;
                break;
            case 1:
            case 3:
                z = this.bzM > this.bzO && this.irQ.getTop() == 0 && this.gih.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.bzM - this.bzO > ((float) this.fxz) && this.irQ.getTop() == 0 && this.gih.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.fxx.setIntValues((int) (this.bzM - this.bzO), l.getEquipmentHeight(getContext()));
                    this.fxx.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.bzO = 0.0f;
                    this.bzM = this.bzO;
                    requestLayout();
                    break;
                }
            case 2:
                this.bzM = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.bzM - this.bzO) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.bzM > this.bzO && this.irQ.getTop() == 0 && this.gih.getFirstVisiblePosition() == 0) {
            this.fks = true;
            requestLayout();
            return true;
        } else if (z) {
            this.fks = true;
            return true;
        } else {
            this.fks = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.fxx.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.fxx.start();
    }

    public void onDestroy() {
        this.fxx.cancel();
        this.fxx.removeAllUpdateListeners();
        clearAnimation();
    }

    public void setEnableDragExit(boolean z) {
        this.lJX = z;
    }
}
