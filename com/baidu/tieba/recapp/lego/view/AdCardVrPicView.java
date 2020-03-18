package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes13.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView jKG;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cO(View view) {
        this.jKG = (VrPicView) view.findViewById(R.id.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.jJq.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.cNt.width = this.mMaxWidth;
            advertAppInfo.cNt.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.cNt.cNE = str;
            this.jKG.a(this.cVv, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.jKG.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.cNt.width;
                layoutParams.height = advertAppInfo.cNt.height;
            }
            this.jKG.setLayoutParams(layoutParams);
            return;
        }
        this.jJq.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }
}
