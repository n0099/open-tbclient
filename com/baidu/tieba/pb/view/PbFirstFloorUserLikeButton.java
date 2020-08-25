package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String ewS;
    protected String ewT;
    private com.baidu.tbadk.core.view.commonBtn.b kZi;
    private com.baidu.tbadk.core.view.commonBtn.b kZj;
    public View.OnClickListener kZk;

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
        this.ewS = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.ewT = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.tbds36);
        setText(this.ewT);
        this.kZi = new com.baidu.tbadk.core.view.commonBtn.b();
        this.kZi.pb(R.color.cp_link_tip_a);
        this.kZi.a(R.drawable.ic_icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.kZi.oX(l.getDimens(getContext(), R.dimen.tbds36));
        this.kZj = new com.baidu.tbadk.core.view.commonBtn.b();
        this.kZj.pd(R.color.cp_cont_d);
        setConfig(this.kZi);
    }

    public void setFollowIconSize(int i) {
        this.kZi.oX(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aN(boolean z) {
        if (!(this.ewr instanceof Boolean) || ((Boolean) this.ewr).booleanValue() != z) {
            this.ewr = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.ewS);
                setConfig(this.kZj);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.ewT);
                setConfig(this.kZi);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        aN(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        aN(z);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void pk(int i) {
    }

    public void bk(View view) {
        if (this.kZk != null) {
            this.kZk.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        bkF();
    }
}
