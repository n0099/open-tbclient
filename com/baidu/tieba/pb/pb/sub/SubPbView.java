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
    private float ayo;
    private View ceO;
    private int dKD;
    private boolean dtM;
    private BdTypeListView eko;
    private BlankView iVC;
    private LinearLayout iWH;
    private ValueAnimator iWI;
    private int iWJ;
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
        this.iWJ = (l.getEquipmentHeight(context) / 3) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
        this.dKD = l.getEquipmentHeight(context);
        this.iWI = ValueAnimator.ofInt(l.getEquipmentHeight(context), 0);
        this.iWI.setDuration(300L);
        this.iWI.setInterpolator(new LinearInterpolator());
        this.iWI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.sub.SubPbView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SubPbView.this.dKD = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SubPbView.this.mRatio = 1.0f - (SubPbView.this.dKD / l.getEquipmentHeight(SubPbView.this.getContext()));
                if (SubPbView.this.dKD == 0) {
                    SubPbView.this.mRatio = 1.0f;
                } else if (SubPbView.this.dKD == l.getEquipmentHeight(SubPbView.this.getContext())) {
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
        this.iVC = blankView;
    }

    public void setTopView(View view) {
        this.ceO = view;
    }

    public void setNavigationView(LinearLayout linearLayout) {
        this.iWH = linearLayout;
    }

    public void setListView(BdTypeListView bdTypeListView) {
        this.eko = bdTypeListView;
    }

    public void setContentView(RelativeLayout relativeLayout) {
        this.agN = relativeLayout;
    }

    public boolean crA() {
        return this.dtM;
    }

    public void show() {
        if (this.mRatio == 0.0f) {
            this.iWI.start();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.iVC == null) {
            super.onLayout(z, i, i2, i3, i4);
        } else if (this.dKD == 0) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.mLastTouchY > this.ayo) {
                this.iWH.layout(i, (int) (this.mLastTouchY - this.ayo), i3, ((int) (this.mLastTouchY - this.ayo)) + this.iWH.getHeight());
                this.agN.layout(i, ((int) (this.mLastTouchY - this.ayo)) + this.iWH.getHeight(), i3, i4);
            }
        } else {
            this.iWH.layout(i, this.dKD, i3, this.dKD + this.iWH.getMeasuredHeight());
            this.agN.layout(i, this.dKD + this.iWH.getMeasuredHeight(), i3, i4);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mRatio >= 0.0f && this.iVC != null) {
            canvas.drawColor(Color.argb((int) (168.0f * this.mRatio), 0, 0, 0), PorterDuff.Mode.SRC);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.iVC == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (this.iWI.isRunning()) {
            this.iWI.end();
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.ayo = motionEvent.getRawY();
                this.mLastTouchY = this.ayo;
                z = false;
                break;
            case 1:
            case 3:
                z = this.mLastTouchY > this.ayo && this.ceO.getTop() == 0 && this.eko.getFirstVisiblePosition() == 0;
                this.mIsFinish = this.mLastTouchY - this.ayo > ((float) this.iWJ) && this.ceO.getTop() == 0 && this.eko.getFirstVisiblePosition() == 0;
                if (this.mIsFinish) {
                    this.iWI.setIntValues((int) (this.mLastTouchY - this.ayo), l.getEquipmentHeight(getContext()));
                    this.iWI.start();
                    break;
                } else {
                    this.mRatio = 1.0f;
                    this.ayo = 0.0f;
                    this.mLastTouchY = this.ayo;
                    requestLayout();
                    break;
                }
            case 2:
                this.mLastTouchY = motionEvent.getRawY();
                this.mRatio = 1.0f - ((this.mLastTouchY - this.ayo) / l.getEquipmentHeight(getContext()));
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (this.mLastTouchY > this.ayo && this.ceO.getTop() == 0 && this.eko.getFirstVisiblePosition() == 0) {
            this.dtM = true;
            requestLayout();
            return true;
        } else if (z) {
            this.dtM = true;
            return true;
        } else {
            this.dtM = false;
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public void onFinish() {
        this.mIsFinish = true;
        this.iWI.setIntValues(0, l.getEquipmentHeight(getContext()));
        this.iWI.start();
    }

    public void onDestroy() {
        this.iWI.cancel();
        this.iWI.removeAllUpdateListeners();
        clearAnimation();
    }
}
