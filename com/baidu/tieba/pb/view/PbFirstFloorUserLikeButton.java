package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class PbFirstFloorUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    protected String emO;
    protected String emP;
    private com.baidu.tbadk.core.view.commonBtn.c kJs;
    private com.baidu.tbadk.core.view.commonBtn.c kJt;
    public View.OnClickListener kJu;

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
        this.emO = TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed);
        this.emP = TbadkCoreApplication.getInst().getString(R.string.attention);
        setTextSize(R.dimen.tbds36);
        setText(this.emP);
        this.kJs = new com.baidu.tbadk.core.view.commonBtn.c();
        this.kJs.mV(R.color.cp_link_tip_a);
        this.kJs.k(R.drawable.ic_icon_pure_add12_svg, 0, true);
        this.kJs.mR(l.getDimens(getContext(), R.dimen.tbds36));
        this.kJt = new com.baidu.tbadk.core.view.commonBtn.c();
        this.kJt.mX(R.color.cp_cont_d);
        setConfig(this.kJs);
    }

    public void setFollowIconSize(int i) {
        this.kJs.mR(i);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void aM(boolean z) {
        if (!(this.emo instanceof Boolean) || ((Boolean) this.emo).booleanValue() != z) {
            this.emo = Boolean.valueOf(z);
            if (z) {
                setVisibility(8);
                setClickable(false);
                setText(this.emO);
                setConfig(this.kJt);
            } else {
                setVisibility(0);
                setClickable(true);
                setText(this.emP);
                setConfig(this.kJs);
            }
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        aM(z);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        aM(z);
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void nc(int i) {
    }

    public void bi(View view) {
        if (this.kJu != null) {
            this.kJu.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        bci();
    }
}
