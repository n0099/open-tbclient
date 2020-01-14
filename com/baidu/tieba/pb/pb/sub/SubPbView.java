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
/* loaded from: classes7.dex */
public class SubPbView extends LinearLayout {
    private RelativeLayout aeG;
    private float atW;
    private View caG;
    private int dGk;
    private boolean dpq;
    private BdTypeListView efW;
    private boolean gWN;
    private BlankView iTU;
    private LinearLayout iVc;
    private ValueAnimator iVd;
    private int iVe;
    private boolean iVf;
    private d iVg;
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
        this.gWN = true;
        this.iVe = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.dGk = l.getEquipmentHeight(context);
        this.iVd = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.iVd.setDuration(300L);
        this.iVd.setInterpolator(new LinearInterpolator());
        this.iVd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.dGk = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.dGk / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.dGk == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.dGk == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.iTU = blankView;
    }

    public void setTopView(View view) {
        this.caG = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.iVc = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.efW = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aeG = relativeLayout;
    }

    public boolean cqg() {
        return this.dpq;
    }

    public boolean cqN() {
        return this.iVf;
    }

    public void setSubPbInitListener(d dVar) {
        this.iVg = dVar;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.iVd.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iTU == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.dGk == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.mLastTouchY > this.atW) {
                this.iVc.layout(i, (int) (this.mLastTouchY - this.atW), i3, ((int) (this.mLastTouchY - this.atW)) + this.iVc.getHeight());
                this.aeG.layout(i, ((int) (this.mLastTouchY - this.atW)) + this.iVc.getHeight(), i3, i4);
            }
            if (this.gWN) {
                this.iVf = true;
                this.gWN = false;
                if (this.iVg != null) {
                    this.iVg.cqb();
                }
            }
        } else {
            this.iVc.layout(i, this.dGk, i3, this.dGk + this.iVc.getMeasuredHeight());
            this.aeG.layout(i, this.dGk + this.iVc.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.iTU != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.iTU == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.iVd.isRunning()) {
            this.iVd.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.atW = motionEvent.getRawY();
                this.mLastTouchY = this.atW;
                z = false;
                break;
            case 1:
            case 3:
                z = this.mLastTouchY > this.atW && this.caG.getTop() == 0 && this.efW.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.mLastTouchY - this.atW > ((float) this.iVe) && this.caG.getTop() == 0 && this.efW.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.iVd.setIntValues((int) (this.mLastTouchY - this.atW), l.getEquipmentHeight(getContext()));
                    this.iVd.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.atW = 0.0f;
                    this.mLastTouchY = this.atW;
                    requestLayout();
                    break;
                }
            case 2:
                this.mLastTouchY = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.mLastTouchY - this.atW) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.mLastTouchY > this.atW && this.caG.getTop() == 0 && this.efW.getFirstVisiblePosition() == 0) {
            this.dpq = true;
            requestLayout();
            return true;
        } else if (z) {
            this.dpq = true;
            return true;
        } else {
            this.dpq = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.iVd.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.iVd.start();
    }

    public void onDestroy() {
        this.iVd.cancel();
        this.iVd.removeAllUpdateListeners();
        clearAnimation();
    }
}
