package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
/* loaded from: classes9.dex */
public class PbImageAlaUserLikeButton extends DynamicUserLikeButton implements com.baidu.tbadk.core.view.userLike.b {
    public PbImageAlaUserLikeButton(Context context) {
        this(context, null);
    }

    public PbImageAlaUserLikeButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbImageAlaUserLikeButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.baidu.tieba.view.DynamicUserLikeButton
    public void hr(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mk(R.color.cp_cont_d);
            setConfig(cVar);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mi(R.color.cp_link_tip_a);
            cVar2.k(R.drawable.icon_pure_add10_svg, 0, true);
            cVar2.mf(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
            setConfig(cVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
