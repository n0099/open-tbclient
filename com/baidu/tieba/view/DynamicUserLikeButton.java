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
/* loaded from: classes20.dex */
public class DynamicUserLikeButton extends TBSpecificationBtn implements com.baidu.tbadk.core.view.userLike.b {
    private boolean ajE;
    private a mRa;
    private boolean mRb;

    /* loaded from: classes20.dex */
    public interface a {
        void ci(View view);
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
        bVar.pp(R.color.cp_link_tip_a);
        setConfig(bVar);
        setText(TbadkCoreApplication.getInst().getString(R.string.attention));
    }

    public void aN(boolean z) {
        if (this.mRb) {
            if (z) {
                com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
                bVar.bmj();
                setConfig(bVar);
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            } else {
                com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
                bVar2.pq(R.color.cp_cont_b);
                bVar2.pj(UtilHelper.getDimenPixelSize(R.dimen.tbds24));
                bVar2.a(R.drawable.icon_pure_add12_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
                bVar2.pk(R.color.cp_cont_b);
                setConfig(bVar2);
                setClickable(true);
                setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            }
        } else if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar3 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar3.pr(R.color.cp_cont_d);
            setConfig(bVar3);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar4 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar4.pp(R.color.cp_link_tip_a);
            if (this.ajE) {
                bVar4.pj(UtilHelper.getDimenPixelSize(R.dimen.tbds24));
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
            aN(true);
        } else {
            aN(false);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void a(boolean z, int i, boolean z2) {
        r(z, i);
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void py(int i) {
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void bm(View view) {
        if (this.mRa != null) {
            this.mRa.ci(view);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.b
    public void g(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    public void onChangeSkinType(int i) {
        blA();
    }

    public void setOnClickEvent(a aVar) {
        this.mRa = aVar;
    }

    public void setUseNewStyle(boolean z) {
        this.ajE = z;
    }

    public void setGodRecommendStyle(boolean z) {
        this.mRb = z;
    }
}
