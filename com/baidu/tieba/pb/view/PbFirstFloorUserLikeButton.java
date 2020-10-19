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
    protected String eLk;
    protected String eLl;
    public View.OnClickListener lxA;
    private com.baidu.tbadk.core.view.commonBtn.b lxy;
    private com.baidu.tbadk.core.view.commonBtn.b lxz;

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
        this.eLk = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.eLl = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.tbds36);
        setText(this.eLl);
        this.lxy = new com.baidu.tbadk.core.view.commonBtn.b();
        this.lxy.pN(R.color.cp_link_tip_a);
        this.lxy.a(R.drawable.ic_icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.lxy.pI(l.getDimens(getContext(), R.dimen.tbds36));
        this.lxz = new com.baidu.tbadk.core.view.commonBtn.b();
        this.lxz.pP(R.color.cp_cont_d);
        setConfig(this.lxy);
    }

    public void setFollowIconSize(int i) {
        this.lxy.pI(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aN(boolean z) {
        if (!(this.eKJ instanceof Boolean) || ((Boolean) this.eKJ).booleanValue() != z) {
            this.eKJ = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.eLk);
                setConfig(this.lxz);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.eLl);
                setConfig(this.lxy);
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
    public void pW(int i) {
    }

    public void bq(View view) {
        if (this.lxA != null) {
            this.lxA.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        bok();
    }
}
