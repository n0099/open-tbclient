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
    private ObjectAnimator gLX;
    private Runnable gLY;
    private boolean gLZ;
    private boolean gMa;

    public LegoBottomView(Context context) {
        super(context);
        this.gLX = null;
        this.gLY = null;
        this.gLZ = false;
        this.gMa = false;
        init();
    }

    public LegoBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gLX = null;
        this.gLY = null;
        this.gLZ = false;
        this.gMa = false;
        init();
    }

    public LegoBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gLX = null;
        this.gLY = null;
        this.gLZ = false;
        this.gMa = false;
        init();
    }

    private void init() {
        this.gLX = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 0.5f, 1.0f);
        this.gLX.setDuration(1000L);
        this.gLX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.lego.view.LegoBottomView.1
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
        this.gLY = new Runnable() { // from class: com.baidu.tieba.lego.view.LegoBottomView.2
            @Override // java.lang.Runnable
            public void run() {
                LegoBottomView.this.gLX.start();
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
        this.gLZ = false;
        this.gMa = false;
        removeCallbacks(this.gLY);
    }

    @Override // com.baidu.tieba.lego.k
    public void onScrollStateChanged(AbsListView absListView, int i) {
        switch (i) {
            case 0:
                if (getVisibility() != 0 && !this.gMa) {
                    removeCallbacks(this.gLY);
                    postDelayed(this.gLY, 1000L);
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
        return this.gLZ;
    }

    public void setIsShow(boolean z) {
        this.gLZ = z;
    }

    public void setIsVideoLandscape(boolean z) {
        removeCallbacks(this.gLY);
        this.gMa = z;
    }
}
