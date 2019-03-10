package com.baidu.tieba.lego.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseCardView;
import com.baidu.tieba.lego.card.view.ButtonCardView;
import com.baidu.tieba.lego.k;
/* loaded from: classes2.dex */
public class LegoBottomView extends RelativeLayout implements k {
    private ObjectAnimator gLY;
    private Runnable gLZ;
    private boolean gMa;
    private boolean gMb;

    public LegoBottomView(Context context) {
        super(context);
        this.gLY = null;
        this.gLZ = null;
        this.gMa = false;
        this.gMb = false;
        init();
    }

    public LegoBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gLY = null;
        this.gLZ = null;
        this.gMa = false;
        this.gMb = false;
        init();
    }

    public LegoBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gLY = null;
        this.gLZ = null;
        this.gMa = false;
        this.gMb = false;
        init();
    }

    private void init() {
        this.gLY = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 0.5f, 1.0f);
        this.gLY.setDuration(1000L);
        this.gLY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.view.LegoBottomView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                LegoBottomView.this.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gLZ = new Runnable() { // from class: com.baidu.tieba.lego.view.LegoBottomView.2
            @Override // java.lang.Runnable
            public void run() {
                LegoBottomView.this.gLY.start();
            }
        };
    }

    public void a(BaseCardView baseCardView, ICardInfo iCardInfo) {
        baseCardView.aq(iCardInfo);
        if (baseCardView instanceof ButtonCardView) {
            ((ButtonCardView) baseCardView).setBackgroundAlpha(0.3f);
        }
        addView(baseCardView);
    }

    public void destory() {
        this.gMa = false;
        this.gMb = false;
        removeCallbacks(this.gLZ);
    }

    @Override // com.baidu.tieba.lego.k
    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
                if (getVisibility() != 0 && !this.gMb) {
                    removeCallbacks(this.gLZ);
                    postDelayed(this.gLZ, 1000L);
                    return;
                }
                return;
            case 1:
            case 2:
                setVisibility(8);
                return;
            default:
                return;
        }
    }

    public boolean isShow() {
        return this.gMa;
    }

    public void setIsShow(boolean z) {
        this.gMa = z;
    }

    public void setIsVideoLandscape(boolean z) {
        removeCallbacks(this.gLZ);
        this.gMb = z;
    }
}
