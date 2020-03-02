package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes13.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView jIT;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cO(View view) {
        this.jIT = (VrPicView) view.findViewById(R.id.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.jHF.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.cNf.width = this.mMaxWidth;
            advertAppInfo.cNf.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.cNf.cNq = str;
            this.jIT.a(this.cVh, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.jIT.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.cNf.width;
                layoutParams.height = advertAppInfo.cNf.height;
            }
            this.jIT.setLayoutParams(layoutParams);
            return;
        }
        this.jHF.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }
}
