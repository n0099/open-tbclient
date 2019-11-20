package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView iJW;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cM(View view) {
        this.iJW = (VrPicView) view.findViewById(R.id.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.iIO.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.bWD.width = this.mMaxWidth;
            advertAppInfo.bWD.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.bWD.bWO = str;
            this.iJW.a(this.ceu, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.iJW.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.bWD.width;
                layoutParams.height = advertAppInfo.bWD.height;
            }
            this.iJW.setLayoutParams(layoutParams);
            return;
        }
        this.iIO.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }
}
