package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class FollowUserButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    private a nXV;
    private int nXW;
    private boolean nXX;

    /* loaded from: classes.dex */
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
        this.nXW = 0;
        this.nXX = true;
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
        bVar.a(this.nXW, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.pR(R.color.CAM_X0304);
        setConfig(bVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }

    public void aM(boolean z) {
        if (z) {
            setVisibility(0);
            setClickable(this.nXX);
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pT(R.color.CAM_X0109);
            bVar.a(0, 0, TBSpecificationButtonConfig.IconType.SVG);
            setConfig(bVar);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            setVisibility(0);
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds30));
            bVar2.a(this.nXW, 0, TBSpecificationButtonConfig.IconType.SVG);
            bVar2.pR(R.color.CAM_X0304);
            setConfig(bVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void r(boolean z, int i) {
        if (z) {
            aM(true);
        } else {
            aM(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void c(boolean z, int i, boolean z2) {
        r(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void qb(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bG(View view) {
        if (this.nXV != null) {
            this.nXV.onClick(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        bup();
    }

    public void setOnClickEvent(a aVar) {
        this.nXV = aVar;
    }

    public void setSvgIconResId(int i) {
        this.nXW = i;
        bup();
    }

    public void setClickableUnLike(boolean z) {
        this.nXX = z;
    }
}
