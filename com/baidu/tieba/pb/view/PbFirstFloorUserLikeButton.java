package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String dkc;
    protected String dkd;
    private AlphaAnimation jbV;

    public PbFirstFloorUserLikeButton(Context context) {
        super(context);
        init();
    }

    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PbFirstFloorUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.dkc = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dkd = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.tbds36);
        setText(this.dkd);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.ls(R.color.cp_link_tip_a);
        setConfig(cVar);
    }

    public void fU(boolean z) {
        this.djE = Boolean.valueOf(z);
        if (z) {
            setVisibility(8);
            setClickable(false);
            setText(this.dkc);
        } else {
            setVisibility(0);
            setClickable(true);
            setText(this.dkd);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void m(boolean z, int i) {
        fU(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void b(boolean z, int i, boolean z2) {
        if (z2) {
            this.djE = Boolean.valueOf(z);
            if (getVisibility() != 8) {
                if (z) {
                    if (this.jbV == null) {
                        this.jbV = new AlphaAnimation(1.0f, 0.0f);
                        this.jbV.setDuration(500L);
                        this.jbV.setFillAfter(true);
                        this.jbV.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton.1
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
                        this.jbV.cancel();
                    }
                    if (isShown()) {
                        startAnimation(this.jbV);
                        return;
                    } else {
                        setVisibility(8);
                        return;
                    }
                }
                setVisibility(0);
                setClickable(true);
                setText(this.dkd);
                setPadding(getResources().getDimensionPixelSize(R.dimen.tbds18), 0, getResources().getDimensionPixelSize(R.dimen.tbds12), 0);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        fU(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void lx(int i) {
    }

    public void ba(View view) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aHO();
    }
}
