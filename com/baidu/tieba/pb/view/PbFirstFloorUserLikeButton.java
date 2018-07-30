package com.baidu.tieba.pb.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class PbFirstFloorUserLikeButton extends EntelechyUserLikeButton {
    private AlphaAnimation fNL;

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
        setTextSize(0, l.f(getContext(), d.e.tbfontsize34));
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void aV(boolean z) {
        this.azn = z;
        if (z) {
            setVisibility(8);
            setClickable(false);
            setText(this.azl);
            setPadding(0, 0, 0, 0);
        } else {
            setVisibility(0);
            setClickable(true);
            setText(this.azm);
            setPadding(getResources().getDimensionPixelSize(d.e.tbds18), 0, getResources().getDimensionPixelSize(d.e.tbds12), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        aV(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        if (z2) {
            this.azn = z;
            if (getVisibility() != 8) {
                if (z) {
                    if (this.fNL == null) {
                        this.fNL = new AlphaAnimation(1.0f, 0.0f);
                        this.fNL.setDuration(500L);
                        this.fNL.setFillAfter(true);
                        this.fNL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton.1
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
                        this.fNL.cancel();
                    }
                    if (isShown()) {
                        startAnimation(this.fNL);
                        return;
                    } else {
                        setVisibility(8);
                        return;
                    }
                }
                setVisibility(0);
                setClickable(true);
                setText(this.azm);
                setPadding(getResources().getDimensionPixelSize(d.e.tbds18), 0, getResources().getDimensionPixelSize(d.e.tbds12), 0);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        aV(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        am.c(this, d.C0140d.cp_cont_g, 1);
        if (this.azn) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        setBackgroundDrawable(am.getDrawable(d.f.selector_like_button_bg));
    }
}
