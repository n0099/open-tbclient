package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
/* loaded from: classes21.dex */
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
    public void aP(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.qI(R.color.CAM_X0109);
            setConfig(bVar);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.qG(R.color.CAM_X0302);
            bVar2.a(R.drawable.icon_pure_add10_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            bVar2.qB(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
            setConfig(bVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}
