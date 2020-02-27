package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes13.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView jIR;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cO(View view) {
        this.jIR = (VrPicView) view.findViewById(R.id.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.jHD.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.cNe.width = this.mMaxWidth;
            advertAppInfo.cNe.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.cNe.cNp = str;
            this.jIR.a(this.cVg, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.jIR.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.cNe.width;
                layoutParams.height = advertAppInfo.cNe.height;
            }
            this.jIR.setLayoutParams(layoutParams);
            return;
        }
        this.jHD.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }
}
