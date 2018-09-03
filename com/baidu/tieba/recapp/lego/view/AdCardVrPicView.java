package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView gqX;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return f.h.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void by(View view) {
        this.gqX = (VrPicView) view.findViewById(f.g.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.gpQ.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.adQ.width = this.mMaxWidth;
            advertAppInfo.adQ.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.adQ.aeb = str;
            this.gqX.a(this.mContext, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.gqX.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.adQ.width;
                layoutParams.height = advertAppInfo.adQ.height;
            }
            this.gqX.setLayoutParams(layoutParams);
            return;
        }
        this.gpQ.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return f.h.card_ad;
    }
}
