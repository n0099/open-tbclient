package com.baidu.tieba.pb.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class PbFirstFloorUserLikeButton extends EntelechyUserLikeButton {
    private AlphaAnimation gey;

    public PbFirstFloorUserLikeButton(Context context) {
        super(context);
    }

    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, l.h(getContext(), e.C0200e.tbfontsize34));
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void bJ(boolean z) {
        this.aHI = z;
        if (z) {
            setVisibility(8);
            setClickable(false);
            setText(this.aHG);
            setPadding(0, 0, 0, 0);
        } else {
            setVisibility(0);
            setClickable(true);
            setText(this.aHH);
            setPadding(getResources().getDimensionPixelSize(e.C0200e.tbds18), 0, getResources().getDimensionPixelSize(e.C0200e.tbds12), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        bJ(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        if (z2) {
            this.aHI = z;
            if (getVisibility() != 8) {
                if (z) {
                    if (this.gey == null) {
                        this.gey = new AlphaAnimation(1.0f, 0.0f);
                        this.gey.setDuration(500L);
                        this.gey.setFillAfter(true);
                        this.gey.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton.1
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation animation) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation) {
                                PbFirstFloorUserLikeButton.this.clearAnimation();
                                PbFirstFloorUserLikeButton.this.setVisibility(8);
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation animation) {
                            }
                        });
                    } else {
                        this.gey.cancel();
                    }
                    if (isShown()) {
                        startAnimation(this.gey);
                        return;
                    } else {
                        setVisibility(8);
                        return;
                    }
                }
                setVisibility(0);
                setClickable(true);
                setText(this.aHH);
                setPadding(getResources().getDimensionPixelSize(e.C0200e.tbds18), 0, getResources().getDimensionPixelSize(e.C0200e.tbds12), 0);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        bJ(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        al.c(this, e.d.cp_cont_g, 1);
        if (this.aHI) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        setBackgroundDrawable(al.getDrawable(e.f.selector_like_button_bg));
    }
}
