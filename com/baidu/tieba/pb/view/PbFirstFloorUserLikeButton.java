package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String fnr;
    protected String fns;
    private com.baidu.tbadk.core.view.commonBtn.b mok;
    private com.baidu.tbadk.core.view.commonBtn.b mol;
    public View.OnClickListener mom;

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
        this.fnr = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fns = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.T_X08);
        setText(this.fns);
        this.mok = new com.baidu.tbadk.core.view.commonBtn.b();
        this.mok.pR(R.color.CAM_X0302);
        this.mol = new com.baidu.tbadk.core.view.commonBtn.b();
        this.mol.pT(R.color.CAM_X0109);
        setConfig(this.mok);
    }

    public void setFollowIconSize(int i) {
        this.mok.setIconSize(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aM(boolean z) {
        if (!(this.fmP instanceof Boolean) || ((Boolean) this.fmP).booleanValue() != z) {
            this.fmP = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.fnr);
                setConfig(this.mol);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.fns);
                setConfig(this.mok);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        aM(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(boolean z, int i, boolean z2) {
        aM(z);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void qb(int i) {
    }

    public void bG(View view) {
        if (this.mom != null) {
            this.mom.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        bup();
    }
}
