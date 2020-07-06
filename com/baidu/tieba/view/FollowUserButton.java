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
    private a mig;
    private int mih;
    private boolean mii;

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
        this.mih = R.drawable.icon_pure_add12_svg;
        this.mii = true;
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.my(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
        cVar.k(this.mih, 0, true);
        cVar.mC(R.color.cp_link_tip_a);
        setConfig(cVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }

    public void hA(boolean z) {
        if (z) {
            setVisibility(0);
            setClickable(this.mii);
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mE(R.color.cp_cont_d);
            cVar.k(0, 0, true);
            setConfig(cVar);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            setVisibility(0);
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.my(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
            cVar2.k(this.mih, 0, true);
            cVar2.mC(R.color.cp_link_tip_a);
            setConfig(cVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        if (z) {
            hA(true);
        } else {
            hA(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        r(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void mK(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bc(View view) {
        if (this.mig != null) {
            this.mig.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        aYj();
    }

    public void setOnClickEvent(a aVar) {
        this.mig = aVar;
    }

    public void setSvgIconResId(int i) {
        this.mih = i;
        aYj();
    }

    public void setClickableUnLike(boolean z) {
        this.mii = z;
    }
}
