package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String dYD;
    protected String dYE;
    private com.baidu.tbadk.core.view.commonBtn.c kgD;
    private com.baidu.tbadk.core.view.commonBtn.c kgE;
    public View.OnClickListener kgF;

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
        this.dYD = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.dYE = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.tbds36);
        setText(this.dYE);
        this.kgD = new com.baidu.tbadk.core.view.commonBtn.c();
        this.kgD.mk(R.color.cp_link_tip_a);
        this.kgD.k(R.drawable.ic_icon_pure_add12_svg, 0, true);
        this.kgD.mh(l.getDimens(getContext(), R.dimen.tbds36));
        this.kgE = new com.baidu.tbadk.core.view.commonBtn.c();
        this.kgE.mm(R.color.cp_cont_d);
        setConfig(this.kgD);
    }

    public void setFollowIconSize(int i) {
        this.kgD.mh(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void hr(boolean z) {
        if (!(this.dYe instanceof Boolean) || ((Boolean) this.dYe).booleanValue() != z) {
            this.dYe = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.dYD);
                setConfig(this.kgE);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.dYE);
                setConfig(this.kgD);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        hr(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        hr(z);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void mq(int i) {
    }

    public void bc(View view) {
        if (this.kgF != null) {
            this.kgF.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aWr();
    }
}
