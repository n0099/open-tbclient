package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class f extends a {
    private VrPicView gEL;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getCustomLayout() {
        return d.h.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void cL(View view) {
        this.gEL = (VrPicView) view.findViewById(d.g.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.gDF.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.aKH.width = this.mMaxWidth;
            advertAppInfo.aKH.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.aKH.aKR = str;
            this.gEL.a(this.aRI, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.gEL.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.aKH.width;
                layoutParams.height = advertAppInfo.aKH.height;
            }
            this.gEL.setLayoutParams(layoutParams);
            return;
        }
        this.gDF.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getLayout() {
        return d.h.card_ad;
    }
}
