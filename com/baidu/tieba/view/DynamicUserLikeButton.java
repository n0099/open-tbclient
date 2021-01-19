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
public class DynamicUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    private boolean akL;
    private a nNd;
    private boolean nNe;

    /* loaded from: classes.dex */
    public interface a {
        void cQ(View view);
    }

    public DynamicUserLikeButton(Context context) {
        this(context, null);
    }

    public DynamicUserLikeButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DynamicUserLikeButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pM(R.color.CAM_X0302);
        setConfig(bVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }

    public void aM(boolean z) {
        if (this.nNe) {
            if (z) {
                com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
                bVar.buD();
                setConfig(bVar);
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            } else {
                com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                bVar2.pN(R.color.CAM_X0105);
                bVar2.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds24));
                bVar2.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                bVar2.pI(R.color.CAM_X0105);
                setConfig(bVar2);
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            }
        } else if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar3 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar3.pO(R.color.CAM_X0109);
            setConfig(bVar3);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar4 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar4.pM(R.color.CAM_X0302);
            if (this.akL) {
                bVar4.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds24));
                bVar4.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            }
            setConfig(bVar4);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

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
    public void pW(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bK(View view) {
        if (this.nNd != null) {
            this.nNd.cQ(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void i(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        btV();
    }

    public void setOnClickEvent(a aVar) {
        this.nNd = aVar;
    }

    public void setUseNewStyle(boolean z) {
        this.akL = z;
    }

    public void setGodRecommendStyle(boolean z) {
        this.nNe = z;
    }
}
