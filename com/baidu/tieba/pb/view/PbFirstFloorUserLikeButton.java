package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String fkZ;
    protected String fla;
    private com.baidu.tbadk.core.view.commonBtn.b meT;
    private com.baidu.tbadk.core.view.commonBtn.b meU;
    public View.OnClickListener meV;

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
        this.fkZ = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fla = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.T_X08);
        setText(this.fla);
        this.meT = new com.baidu.tbadk.core.view.commonBtn.b();
        this.meT.pM(R.color.CAM_X0302);
        this.meU = new com.baidu.tbadk.core.view.commonBtn.b();
        this.meU.pO(R.color.CAM_X0109);
        setConfig(this.meT);
    }

    public void setFollowIconSize(int i) {
        this.meT.setIconSize(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aM(boolean z) {
        if (!(this.fkx instanceof Boolean) || ((Boolean) this.fkx).booleanValue() != z) {
            this.fkx = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.fkZ);
                setConfig(this.meU);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.fla);
                setConfig(this.meT);
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
    public void pW(int i) {
    }

    public void bK(View view) {
        if (this.meV != null) {
            this.meV.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        btV();
    }
}
