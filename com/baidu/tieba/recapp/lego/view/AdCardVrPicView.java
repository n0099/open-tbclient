package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardVrPicView extends AdCardBaseView {
    private VrPicView gaB;

    public AdCardVrPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return d.i.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void br(View view2) {
        this.gaB = (VrPicView) view2.findViewById(d.g.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.fZv.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.VX.width = this.mMaxWidth;
            advertAppInfo.VX.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.VX.Wh = str;
            this.gaB.a(this.mContext, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.gaB.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.VX.width;
                layoutParams.height = advertAppInfo.VX.height;
            }
            this.gaB.setLayoutParams(layoutParams);
            return;
        }
        this.fZv.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return d.i.card_ad;
    }
}
