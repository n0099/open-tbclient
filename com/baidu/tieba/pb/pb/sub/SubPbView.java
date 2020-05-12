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
    private float aSm;
    private float aSo;
    private RelativeLayout azt;
    private View cEd;
    private boolean dTZ;
    private BdTypeListView eOj;
    private int ekO;
    private BlankView jHp;
    private LinearLayout jIu;
    private ValueAnimator jIv;
    private int jIw;
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
        this.jIw = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.ekO = l.getEquipmentHeight(context);
        this.jIv = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.jIv.setDuration(300L);
        this.jIv.setInterpolator(new LinearInterpolator());
        this.jIv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.ekO = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.ekO / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.ekO == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.ekO == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.jHp = blankView;
    }

    public void setTopView(View view) {
        this.cEd = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.jIu = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.eOj = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.azt = relativeLayout;
    }

    public boolean cCz() {
        return this.dTZ;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.jIv.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.jHp == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.ekO == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.aSm > this.aSo) {
                this.jIu.layout(i, (int) (this.aSm - this.aSo), i3, ((int) (this.aSm - this.aSo)) + this.jIu.getHeight());
                this.azt.layout(i, ((int) (this.aSm - this.aSo)) + this.jIu.getHeight(), i3, i4);
            }
        } else {
            this.jIu.layout(i, this.ekO, i3, this.ekO + this.jIu.getMeasuredHeight());
            this.azt.layout(i, this.ekO + this.jIu.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.jHp != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.jHp == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.jIv.isRunning()) {
            this.jIv.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.aSo = motionEvent.getRawY();
                this.aSm = this.aSo;
                z = false;
                break;
            case 1:
            case 3:
                z = this.aSm > this.aSo && this.cEd.getTop() == 0 && this.eOj.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.aSm - this.aSo > ((float) this.jIw) && this.cEd.getTop() == 0 && this.eOj.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.jIv.setIntValues((int) (this.aSm - this.aSo), l.getEquipmentHeight(getContext()));
                    this.jIv.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.aSo = 0.0f;
                    this.aSm = this.aSo;
                    requestLayout();
                    break;
                }
            case 2:
                this.aSm = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.aSm - this.aSo) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.aSm > this.aSo && this.cEd.getTop() == 0 && this.eOj.getFirstVisiblePosition() == 0) {
            this.dTZ = true;
            requestLayout();
            return true;
        } else if (z) {
            this.dTZ = true;
            return true;
        } else {
            this.dTZ = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.jIv.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.jIv.start();
    }

    public void onDestroy() {
        this.jIv.cancel();
        this.jIv.removeAllUpdateListeners();
        clearAnimation();
    }
}
