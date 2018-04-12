package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView fZy;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return d.i.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void br(View view2) {
        this.fZy = (VrPicView) view2.findViewById(d.g.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.fYs.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.Wb.width = this.mMaxWidth;
            advertAppInfo.Wb.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.Wb.Wl = str;
            this.fZy.a(this.adf, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.fZy.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.Wb.width;
                layoutParams.height = advertAppInfo.Wb.height;
            }
            this.fZy.setLayoutParams(layoutParams);
            return;
        }
        this.fYs.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return d.i.card_ad;
    }
}
