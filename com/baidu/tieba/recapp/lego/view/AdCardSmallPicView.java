package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes13.dex */
public class AdCardSmallPicView extends AdSimpleCardBaseView {
    private XfremodeRoundLayout kum;
    private TbImageView kun;

    public AdCardSmallPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getCustomLayout() {
        return R.layout.ad_card_small_pic_view;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void cW(View view) {
        float dimensionPixelSize = this.duG.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.kum = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.kun = (TbImageView) view.findViewById(R.id.ad_img);
        this.kun.setPlaceHolder(3);
        this.kum.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected void a(AdCard adCard) {
        if (adCard == null || adCard.threadPicList == null || adCard.threadPicList.length < 1) {
            this.ktc.setVisibility(8);
            return;
        }
        String str = adCard.threadPicList[0].pic;
        if (!TextUtils.isEmpty(str)) {
            this.ktc.setVisibility(0);
            this.kun.startLoad(str, 17, false);
            return;
        }
        this.ktc.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdSimpleCardBaseView
    protected int getLayout() {
        return R.layout.card_small_pic_ad;
    }
}
