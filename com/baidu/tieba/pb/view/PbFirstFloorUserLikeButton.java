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
    protected String ewW;
    protected String ewX;
    private com.baidu.tbadk.core.view.commonBtn.b kZp;
    private com.baidu.tbadk.core.view.commonBtn.b kZq;
    public View.OnClickListener kZr;

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
        this.ewW = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.ewX = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.tbds36);
        setText(this.ewX);
        this.kZp = new com.baidu.tbadk.core.view.commonBtn.b();
        this.kZp.pb(R.color.cp_link_tip_a);
        this.kZp.a(R.drawable.ic_icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.kZp.oX(l.getDimens(getContext(), R.dimen.tbds36));
        this.kZq = new com.baidu.tbadk.core.view.commonBtn.b();
        this.kZq.pd(R.color.cp_cont_d);
        setConfig(this.kZp);
    }

    public void setFollowIconSize(int i) {
        this.kZp.oX(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aN(boolean z) {
        if (!(this.ewv instanceof Boolean) || ((Boolean) this.ewv).booleanValue() != z) {
            this.ewv = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.ewW);
                setConfig(this.kZq);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.ewX);
                setConfig(this.kZp);
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
        if (this.kZr != null) {
            this.kZr.onClick(view);
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
