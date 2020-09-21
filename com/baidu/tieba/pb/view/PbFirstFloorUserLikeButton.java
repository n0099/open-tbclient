package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String ezd;
    protected String eze;
    private com.baidu.tbadk.core.view.commonBtn.b lih;
    private com.baidu.tbadk.core.view.commonBtn.b lii;
    public View.OnClickListener lij;

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
        this.ezd = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.eze = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.tbds36);
        setText(this.eze);
        this.lih = new com.baidu.tbadk.core.view.commonBtn.b();
        this.lih.pp(R.color.cp_link_tip_a);
        this.lih.a(R.drawable.ic_icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        this.lih.pj(l.getDimens(getContext(), R.dimen.tbds36));
        this.lii = new com.baidu.tbadk.core.view.commonBtn.b();
        this.lii.pr(R.color.cp_cont_d);
        setConfig(this.lih);
    }

    public void setFollowIconSize(int i) {
        this.lih.pj(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aN(boolean z) {
        if (!(this.eyC instanceof Boolean) || ((Boolean) this.eyC).booleanValue() != z) {
            this.eyC = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.ezd);
                setConfig(this.lii);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.eze);
                setConfig(this.lih);
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
    public void py(int i) {
    }

    public void bm(View view) {
        if (this.lij != null) {
            this.lij.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        blA();
    }
}
