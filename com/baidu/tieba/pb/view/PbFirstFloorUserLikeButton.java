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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class PbFirstFloorUserLikeButton extends EntelechyUserLikeButton {
    private AlphaAnimation fNE;

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
        setTextSize(0, l.f(getContext(), f.e.tbfontsize34));
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void aW(boolean z) {
        this.azk = z;
        if (z) {
            setVisibility(8);
            setClickable(false);
            setText(this.azi);
            setPadding(0, 0, 0, 0);
        } else {
            setVisibility(0);
            setClickable(true);
            setText(this.azj);
            setPadding(getResources().getDimensionPixelSize(f.e.tbds18), 0, getResources().getDimensionPixelSize(f.e.tbds12), 0);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void d(boolean z, int i) {
        aW(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        if (z2) {
            this.azk = z;
            if (getVisibility() != 8) {
                if (z) {
                    if (this.fNE == null) {
                        this.fNE = new AlphaAnimation(1.0f, 0.0f);
                        this.fNE.setDuration(500L);
                        this.fNE.setFillAfter(true);
                        this.fNE.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton.1
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
                        this.fNE.cancel();
                    }
                    if (isShown()) {
                        startAnimation(this.fNE);
                        return;
                    } else {
                        setVisibility(8);
                        return;
                    }
                }
                setVisibility(0);
                setClickable(true);
                setText(this.azj);
                setPadding(getResources().getDimensionPixelSize(f.e.tbds18), 0, getResources().getDimensionPixelSize(f.e.tbds12), 0);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        aW(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.EntelechyUserLikeButton, com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        am.c(this, f.d.cp_cont_g, 1);
        if (this.azk) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.icon_add_follow_white), (Drawable) null, (Drawable) null, (Drawable) null);
        setBackgroundDrawable(am.getDrawable(f.C0146f.selector_like_button_bg));
    }
}
