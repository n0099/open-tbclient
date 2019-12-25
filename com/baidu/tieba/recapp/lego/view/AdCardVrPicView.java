package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes10.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView jEo;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cH(View view) {
        this.jEo = (VrPicView) view.findViewById(R.id.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.jDf.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.cIQ.width = this.mMaxWidth;
            advertAppInfo.cIQ.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.cIQ.cJb = str;
            this.jEo.a(this.cQU, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.jEo.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.cIQ.width;
                layoutParams.height = advertAppInfo.cIQ.height;
            }
            this.jEo.setLayoutParams(layoutParams);
            return;
        }
        this.jDf.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }
}
