package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class FollowUserButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    private a nzp;
    private int nzq;
    private boolean nzr;

    /* loaded from: classes21.dex */
    public interface a {
        void onClick(View view);
    }

    public FollowUserButton(Context context) {
        this(context, null);
    }

    public FollowUserButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FollowUserButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nzq = R.drawable.icon_pure_add12_svg;
        this.nzr = true;
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.qd(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
        bVar.a(this.nzq, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.qi(R.color.cp_link_tip_a);
        setConfig(bVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }

    public void aN(boolean z) {
        if (z) {
            setVisibility(0);
            setClickable(this.nzr);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.qk(R.color.cp_cont_d);
            bVar.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            setConfig(bVar);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            setVisibility(0);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.qd(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
            bVar2.a(this.nzq, 0, TBSpecificationButtonConfig.IconType.SVG);
            bVar2.qi(R.color.cp_link_tip_a);
            setConfig(bVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void s(boolean z, int i) {
        if (z) {
            aN(true);
        } else {
            aN(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        s(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void qr(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bv(View view) {
        if (this.nzp != null) {
            this.nzp.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void h(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        bsD();
    }

    public void setOnClickEvent(a aVar) {
        this.nzp = aVar;
    }

    public void setSvgIconResId(int i) {
        this.nzq = i;
        bsD();
    }

    public void setClickableUnLike(boolean z) {
        this.nzr = z;
    }
}
