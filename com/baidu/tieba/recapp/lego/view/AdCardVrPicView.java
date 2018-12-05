package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView gOh;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return e.h.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void bN(View view) {
        this.gOh = (VrPicView) view.findViewById(e.g.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.gNa.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.apB.width = this.mMaxWidth;
            advertAppInfo.apB.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.apB.apM = str;
            this.gOh.a(this.mContext, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.gOh.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.apB.width;
                layoutParams.height = advertAppInfo.apB.height;
            }
            this.gOh.setLayoutParams(layoutParams);
            return;
        }
        this.gNa.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return e.h.card_ad;
    }
}
