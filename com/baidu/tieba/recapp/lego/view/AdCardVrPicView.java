package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView ijI;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return d.h.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cD(View view) {
        this.ijI = (VrPicView) view.findViewById(d.g.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.iiB.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.bwL.width = this.mMaxWidth;
            advertAppInfo.bwL.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.bwL.bwW = str;
            this.ijI.a(this.mContext, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.ijI.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.bwL.width;
                layoutParams.height = advertAppInfo.bwL.height;
            }
            this.ijI.setLayoutParams(layoutParams);
            return;
        }
        this.iiB.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return d.h.card_ad;
    }
}
