package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes11.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView jHV;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cN(View view) {
        this.jHV = (VrPicView) view.findViewById(R.id.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.jGM.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.cJb.width = this.mMaxWidth;
            advertAppInfo.cJb.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.cJb.cJm = str;
            this.jHV.a(this.cRe, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.jHV.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.cJb.width;
                layoutParams.height = advertAppInfo.cJb.height;
            }
            this.jHV.setLayoutParams(layoutParams);
            return;
        }
        this.jGM.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }
}
