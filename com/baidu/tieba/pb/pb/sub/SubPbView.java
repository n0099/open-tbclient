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
    private RelativeLayout aEL;
    private float aZA;
    private float aZC;
    private boolean eii;
    private int ezE;
    private BdTypeListView fbb;
    private View gXW;
    private BlankView kae;
    private LinearLayout kbk;
    private ValueAnimator kbl;
    private int kbm;
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
        this.kbm = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.ezE = l.getEquipmentHeight(context);
        this.kbl = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.kbl.setDuration(300L);
        this.kbl.setInterpolator(new LinearInterpolator());
        this.kbl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.ezE = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.ezE / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.ezE == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.ezE == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.kae = blankView;
    }

    public void setTopView(View view) {
        this.gXW = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.kbk = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.fbb = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.aEL = relativeLayout;
    }

    public boolean cJM() {
        return this.eii;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.kbl.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.kae == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.ezE == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.aZA > this.aZC) {
                this.kbk.layout(i, (int) (this.aZA - this.aZC), i3, ((int) (this.aZA - this.aZC)) + this.kbk.getHeight());
                this.aEL.layout(i, ((int) (this.aZA - this.aZC)) + this.kbk.getHeight(), i3, i4);
            }
        } else {
            this.kbk.layout(i, this.ezE, i3, this.ezE + this.kbk.getMeasuredHeight());
            this.aEL.layout(i, this.ezE + this.kbk.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.kae != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.kae == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.kbl.isRunning()) {
            this.kbl.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.aZC = motionEvent.getRawY();
                this.aZA = this.aZC;
                z = false;
                break;
            case 1:
            case 3:
                z = this.aZA > this.aZC && this.gXW.getTop() == 0 && this.fbb.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.aZA - this.aZC > ((float) this.kbm) && this.gXW.getTop() == 0 && this.fbb.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.kbl.setIntValues((int) (this.aZA - this.aZC), l.getEquipmentHeight(getContext()));
                    this.kbl.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.aZC = 0.0f;
                    this.aZA = this.aZC;
                    requestLayout();
                    break;
                }
            case 2:
                this.aZA = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.aZA - this.aZC) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.aZA > this.aZC && this.gXW.getTop() == 0 && this.fbb.getFirstVisiblePosition() == 0) {
            this.eii = true;
            requestLayout();
            return true;
        } else if (z) {
            this.eii = true;
            return true;
        } else {
            this.eii = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.kbl.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.kbl.start();
    }

    public void onDestroy() {
        this.kbl.cancel();
        this.kbl.removeAllUpdateListeners();
        clearAnimation();
    }
}
