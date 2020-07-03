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
    protected String egF;
    protected String egG;
    private com.baidu.tbadk.core.view.commonBtn.c kAq;
    private com.baidu.tbadk.core.view.commonBtn.c kAr;
    public View.OnClickListener kAs;

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
        this.egF = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.egG = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.tbds36);
        setText(this.egG);
        this.kAq = new com.baidu.tbadk.core.view.commonBtn.c();
        this.kAq.mC(R.color.cp_link_tip_a);
        this.kAq.k(R.drawable.ic_icon_pure_add12_svg, 0, true);
        this.kAq.my(l.getDimens(getContext(), R.dimen.tbds36));
        this.kAr = new com.baidu.tbadk.core.view.commonBtn.c();
        this.kAr.mE(R.color.cp_cont_d);
        setConfig(this.kAq);
    }

    public void setFollowIconSize(int i) {
        this.kAq.my(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void hA(boolean z) {
        if (!(this.ege instanceof Boolean) || ((Boolean) this.ege).booleanValue() != z) {
            this.ege = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.egF);
                setConfig(this.kAr);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.egG);
                setConfig(this.kAq);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        hA(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        hA(z);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void mK(int i) {
    }

    public void bc(View view) {
        if (this.kAs != null) {
            this.kAs.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aYj();
    }
}
