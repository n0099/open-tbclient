package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class FollowUserButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    private a lMX;
    private int lMY;
    private boolean lMZ;

    /* loaded from: classes8.dex */
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
        this.lMY = R.drawable.icon_pure_add12_svg;
        this.lMZ = true;
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mf(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
        cVar.k(this.lMY, 0, true);
        cVar.mi(R.color.cp_link_tip_a);
        setConfig(cVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }

    public void hr(boolean z) {
        if (z) {
            setVisibility(0);
            setClickable(this.lMZ);
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mk(R.color.cp_cont_d);
            cVar.k(0, 0, true);
            setConfig(cVar);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            setVisibility(0);
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mf(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
            cVar2.k(this.lMY, 0, true);
            cVar2.mi(R.color.cp_link_tip_a);
            setConfig(cVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        if (z) {
            hr(true);
        } else {
            hr(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        r(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void mo(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bc(View view) {
        if (this.lMX != null) {
            this.lMX.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aWq();
    }

    public void setOnClickEvent(a aVar) {
        this.lMX = aVar;
    }

    public void setSvgIconResId(int i) {
        this.lMY = i;
        aWq();
    }

    public void setClickableUnLike(boolean z) {
        this.lMZ = z;
    }
}
