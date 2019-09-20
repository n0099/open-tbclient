package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView iLV;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cQ(View view) {
        this.iLV = (VrPicView) view.findViewById(R.id.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.iKO.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.bFC.width = this.mMaxWidth;
            advertAppInfo.bFC.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.bFC.bFN = str;
            this.iLV.a(this.mContext, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.iLV.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.bFC.width;
                layoutParams.height = advertAppInfo.bFC.height;
            }
            this.iLV.setLayoutParams(layoutParams);
            return;
        }
        this.iKO.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }
}
