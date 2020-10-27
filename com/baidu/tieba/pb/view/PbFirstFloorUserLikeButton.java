package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String eTG;
    protected String eTH;
    private com.baidu.tbadk.core.view.commonBtn.b lJW;
    private com.baidu.tbadk.core.view.commonBtn.b lJX;
    public View.OnClickListener lJY;

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
        this.eTG = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.eTH = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.tbds36);
        setText(this.eTH);
        this.lJW = new com.baidu.tbadk.core.view.commonBtn.b();
        this.lJW.pY(R.color.cp_link_tip_a);
        this.lJW.a(R.drawable.ic_icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.lJW.pT(l.getDimens(getContext(), R.dimen.tbds36));
        this.lJX = new com.baidu.tbadk.core.view.commonBtn.b();
        this.lJX.qa(R.color.cp_cont_d);
        setConfig(this.lJW);
    }

    public void setFollowIconSize(int i) {
        this.lJW.pT(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aN(boolean z) {
        if (!(this.eTf instanceof Boolean) || ((Boolean) this.eTf).booleanValue() != z) {
            this.eTf = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.eTG);
                setConfig(this.lJX);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.eTH);
                setConfig(this.lJW);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void s(boolean z, int i) {
        aN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        aN(z);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void qh(int i) {
    }

    public void br(View view) {
        if (this.lJY != null) {
            this.lJY.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        bqd();
    }
}
