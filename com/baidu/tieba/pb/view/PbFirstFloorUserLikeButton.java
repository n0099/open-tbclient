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
    protected String eZv;
    protected String eZw;
    private com.baidu.tbadk.core.view.commonBtn.b lPS;
    private com.baidu.tbadk.core.view.commonBtn.b lPT;
    public View.OnClickListener lPU;

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
        this.eZv = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.eZw = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.tbds36);
        setText(this.eZw);
        this.lPS = new com.baidu.tbadk.core.view.commonBtn.b();
        this.lPS.qi(R.color.cp_link_tip_a);
        this.lPS.a(R.drawable.ic_icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.lPS.qd(l.getDimens(getContext(), R.dimen.tbds36));
        this.lPT = new com.baidu.tbadk.core.view.commonBtn.b();
        this.lPT.qk(R.color.cp_cont_d);
        setConfig(this.lPS);
    }

    public void setFollowIconSize(int i) {
        this.lPS.qd(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aN(boolean z) {
        if (!(this.eYU instanceof Boolean) || ((Boolean) this.eYU).booleanValue() != z) {
            this.eYU = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.eZv);
                setConfig(this.lPT);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.eZw);
                setConfig(this.lPS);
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
    public void qr(int i) {
    }

    public void bv(View view) {
        if (this.lPU != null) {
            this.lPU.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        bsD();
    }
}
