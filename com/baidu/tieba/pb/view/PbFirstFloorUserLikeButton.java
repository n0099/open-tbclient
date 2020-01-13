package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String dfI;
    protected String dfJ;
    private AlphaAnimation jab;

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
        this.dfI = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dfJ = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.tbds36);
        setText(this.dfJ);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.lb(R.color.cp_link_tip_a);
        setConfig(cVar);
    }

    public void fN(boolean z) {
        this.dfk = Boolean.valueOf(z);
        if (z) {
            setVisibility(8);
            setClickable(false);
            setText(this.dfI);
        } else {
            setVisibility(0);
            setClickable(true);
            setText(this.dfJ);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void l(boolean z, int i) {
        fN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void b(boolean z, int i, boolean z2) {
        if (z2) {
            this.dfk = Boolean.valueOf(z);
            if (getVisibility() != 8) {
                if (z) {
                    if (this.jab == null) {
                        this.jab = new AlphaAnimation(1.0f, 0.0f);
                        this.jab.setDuration(500L);
                        this.jab.setFillAfter(true);
                        this.jab.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton.1
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
                        this.jab.cancel();
                    }
                    if (isShown()) {
                        startAnimation(this.jab);
                        return;
                    } else {
                        setVisibility(8);
                        return;
                    }
                }
                setVisibility(0);
                setClickable(true);
                setText(this.dfJ);
                setPadding(getResources().getDimensionPixelSize(R.dimen.tbds18), 0, getResources().getDimensionPixelSize(R.dimen.tbds12), 0);
                onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            return;
        }
        fN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void lg(int i) {
    }

    public void ba(View view) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aFw();
    }
}
