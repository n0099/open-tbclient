package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.view.DynamicUserLikeButton;
import d.a.n0.r.f0.q.b;
/* loaded from: classes5.dex */
public class PbImageAlaUserLikeButton extends DynamicUserLikeButton implements b {
    public PbImageAlaUserLikeButton(Context context) {
        this(context, null);
    }

    @Override // com.baidu.tieba.view.DynamicUserLikeButton
    public void s(boolean z) {
        if (z) {
            d.a.n0.r.f0.m.b bVar = new d.a.n0.r.f0.m.b();
            bVar.r(R.color.CAM_X0109);
            setConfig(bVar);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
        } else {
            d.a.n0.r.f0.m.b bVar2 = new d.a.n0.r.f0.m.b();
            bVar2.q(R.color.CAM_X0302);
            bVar2.i(R.drawable.icon_pure_add10_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
            bVar2.g(UtilHelper.getDimenPixelSize(R.dimen.tbds26));
            setConfig(bVar2);
            setClickable(true);
            setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        }
        r(TbadkCoreApplication.getInst().getSkinType());
    }

    public PbImageAlaUserLikeButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbImageAlaUserLikeButton(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
