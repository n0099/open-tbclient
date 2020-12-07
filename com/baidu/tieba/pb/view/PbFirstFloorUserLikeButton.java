package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String fga;
    protected String fgb;
    private com.baidu.tbadk.core.view.commonBtn.b mek;
    private com.baidu.tbadk.core.view.commonBtn.b mel;
    public View.OnClickListener men;

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
        this.fga = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.fgb = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.T_X08);
        setText(this.fgb);
        this.mek = new com.baidu.tbadk.core.view.commonBtn.b();
        this.mek.rh(R.color.CAM_X0302);
        this.mel = new com.baidu.tbadk.core.view.commonBtn.b();
        this.mel.rj(R.color.CAM_X0109);
        setConfig(this.mek);
    }

    public void setFollowIconSize(int i) {
        this.mek.rc(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aP(boolean z) {
        if (!(this.ffy instanceof Boolean) || ((Boolean) this.ffy).booleanValue() != z) {
            this.ffy = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.fga);
                setConfig(this.mel);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.fgb);
                setConfig(this.mek);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void s(boolean z, int i) {
        aP(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        aP(z);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void rq(int i) {
    }

    public void bB(View view) {
        if (this.men != null) {
            this.men.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        bvt();
    }
}
