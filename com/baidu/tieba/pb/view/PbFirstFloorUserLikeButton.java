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
    private com.baidu.tbadk.core.view.commonBtn.b mnV;
    private com.baidu.tbadk.core.view.commonBtn.b mnW;
    public View.OnClickListener mnX;

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
        this.mnV = new com.baidu.tbadk.core.view.commonBtn.b();
        this.mnV.pR(R.color.CAM_X0302);
        this.mnW = new com.baidu.tbadk.core.view.commonBtn.b();
        this.mnW.pT(R.color.CAM_X0109);
        setConfig(this.mnV);
    }

    public void setFollowIconSize(int i) {
        this.mnV.setIconSize(i);
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
                setConfig(this.mnW);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.fns);
                setConfig(this.mnV);
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
        if (this.mnX != null) {
            this.mnX.onClick(view);
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
