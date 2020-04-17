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
    protected String dKj;
    protected String dKk;
    private AlphaAnimation jNC;

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
        this.dKj = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dKk = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.tbds36);
        setText(this.dKk);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lG(R.color.cp_link_tip_a);
        setConfig(cVar);
    }

    public void gT(boolean z) {
        this.dJK = Boolean.valueOf(z);
        if (z) {
            setVisibility(8);
            setClickable(false);
            setText(this.dKj);
        } else {
            setVisibility(0);
            setClickable(true);
            setText(this.dKk);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void n(boolean z, int i) {
        gT(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        if (z2) {
            this.dJK = Boolean.valueOf(z);
            if (getVisibility() != 8) {
                if (z) {
                    if (this.jNC == null) {
                        this.jNC = new AlphaAnimation(1.0f, 0.0f);
                        this.jNC.setDuration(500L);
                        this.jNC.setFillAfter(true);
                        this.jNC.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton.1
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
                        this.jNC.cancel();
                    }
                    if (isShown()) {
                        startAnimation(this.jNC);
                        return;
                    } else {
                        setVisibility(8);
                        return;
                    }
                }
                setVisibility(0);
                setClickable(true);
                setText(this.dKk);
                setPadding(getResources().getDimensionPixelSize(R.dimen.tbds18), 0, getResources().getDimensionPixelSize(R.dimen.tbds12), 0);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        gT(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void lL(int i) {
    }

    public void bb(View view) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aQp();
    }
}
