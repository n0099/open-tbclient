package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView gpK;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return d.i.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void bv(View view) {
        this.gpK = (VrPicView) view.findViewById(d.g.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.goD.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.aem.width = this.mMaxWidth;
            advertAppInfo.aem.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.aem.aex = str;
            this.gpK.a(this.mContext, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.gpK.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.aem.width;
                layoutParams.height = advertAppInfo.aem.height;
            }
            this.gpK.setLayoutParams(layoutParams);
            return;
        }
        this.goD.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return d.i.card_ad;
    }
}
