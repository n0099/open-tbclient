package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes5.dex */
public class AdCardSmallPicView extends AdSimpleCardBaseView {
    public TbImageView A;
    public XfremodeRoundLayout z;

    public AdCardSmallPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void S(AdCard adCard) {
        AdCard.d[] dVarArr;
        if (adCard != null && (dVarArr = adCard.threadPicList) != null && dVarArr.length >= 1) {
            String str = dVarArr[0].f20707a;
            if (!TextUtils.isEmpty(str)) {
                this.t.setVisibility(0);
                this.A.W(str, 17, false);
                return;
            }
            this.t.setVisibility(8);
            return;
        }
        this.t.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public void U(View view) {
        float dimensionPixelSize = this.m.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.z = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        TbImageView tbImageView = (TbImageView) view.findViewById(R.id.ad_img);
        this.A = tbImageView;
        tbImageView.setPlaceHolder(3);
        this.z.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getCustomLayout() {
        return R.layout.ad_card_small_pic_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    public int getLayout() {
        return R.layout.card_small_pic_ad;
    }
}
