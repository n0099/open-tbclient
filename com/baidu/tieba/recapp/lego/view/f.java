package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class f extends a {
    private VrPicView gEK;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getCustomLayout() {
        return d.h.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void cL(View view) {
        this.gEK = (VrPicView) view.findViewById(d.g.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.gDE.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.aKR.width = this.mMaxWidth;
            advertAppInfo.aKR.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.aKR.aLb = str;
            this.gEK.a(this.aRR, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.gEK.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.aKR.width;
                layoutParams.height = advertAppInfo.aKR.height;
            }
            this.gEK.setLayoutParams(layoutParams);
            return;
        }
        this.gDE.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getLayout() {
        return d.h.card_ad;
    }
}
