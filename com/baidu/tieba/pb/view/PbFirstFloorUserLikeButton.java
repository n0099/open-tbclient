package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String fpJ;
    protected String fpK;
    private com.baidu.tbadk.core.view.commonBtn.b mjA;
    public View.OnClickListener mjB;
    private com.baidu.tbadk.core.view.commonBtn.b mjz;

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
        this.fpJ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fpK = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.T_X08);
        setText(this.fpK);
        this.mjz = new com.baidu.tbadk.core.view.commonBtn.b();
        this.mjz.rs(R.color.CAM_X0302);
        this.mjA = new com.baidu.tbadk.core.view.commonBtn.b();
        this.mjA.ru(R.color.CAM_X0109);
        setConfig(this.mjz);
    }

    public void setFollowIconSize(int i) {
        this.mjz.setIconSize(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aM(boolean z) {
        if (!(this.fpg instanceof Boolean) || ((Boolean) this.fpg).booleanValue() != z) {
            this.fpg = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.fpJ);
                setConfig(this.mjA);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.fpK);
                setConfig(this.mjz);
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
    public void rC(int i) {
    }

    public void bK(View view) {
        if (this.mjB != null) {
            this.mjB.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        bxP();
    }
}
