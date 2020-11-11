package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes26.dex */
public class AdCardSmallPicView extends AdSimpleCardBaseView {
    private XfremodeRoundLayout mvV;
    private TbImageView mvW;

    public AdCardSmallPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_small_pic_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void dD(View view) {
        float dimensionPixelSize = this.eIc.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.mvV = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mvW = (TbImageView) view.findViewById(R.id.ad_img);
        this.mvW.setPlaceHolder(3);
        this.mvV.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(AdCard adCard) {
        if (adCard == null || adCard.threadPicList == null || adCard.threadPicList.length < 1) {
            this.muM.setVisibility(8);
            return;
        }
        String str = adCard.threadPicList[0].pic;
        if (!TextUtils.isEmpty(str)) {
            this.muM.setVisibility(0);
            this.mvW.startLoad(str, 17, false);
            return;
        }
        this.muM.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }
}
