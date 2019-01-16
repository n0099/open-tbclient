package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView gSc;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return e.h.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void bQ(View view) {
        this.gSc = (VrPicView) view.findViewById(e.g.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.gQV.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.aqd.width = this.mMaxWidth;
            advertAppInfo.aqd.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.aqd.aqo = str;
            this.gSc.a(this.mContext, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.gSc.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.aqd.width;
                layoutParams.height = advertAppInfo.aqd.height;
            }
            this.gSc.setLayoutParams(layoutParams);
            return;
        }
        this.gQV.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return e.h.card_ad;
    }
}
