package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView iKN;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cM(View view) {
        this.iKN = (VrPicView) view.findViewById(R.id.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.iJF.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.bXu.width = this.mMaxWidth;
            advertAppInfo.bXu.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.bXu.bXF = str;
            this.iKN.a(this.cfl, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.iKN.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.bXu.width;
                layoutParams.height = advertAppInfo.bXu.height;
            }
            this.iKN.setLayoutParams(layoutParams);
            return;
        }
        this.iJF.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }
}
