package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView glT;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return d.i.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void bu(View view) {
        this.glT = (VrPicView) view.findViewById(d.g.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.gkN.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.adX.width = this.mMaxWidth;
            advertAppInfo.adX.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.adX.aei = str;
            this.glT.a(this.mContext, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.glT.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.adX.width;
                layoutParams.height = advertAppInfo.adX.height;
            }
            this.glT.setLayoutParams(layoutParams);
            return;
        }
        this.gkN.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return d.i.card_ad;
    }
}
