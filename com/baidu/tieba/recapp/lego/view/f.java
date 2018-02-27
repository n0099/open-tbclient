package com.baidu.tieba.recapp.lego.view;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class f extends a {
    private VrPicView gEv;

    public f(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getCustomLayout() {
        return d.h.card_ad_vr_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void cL(View view) {
        this.gEv = (VrPicView) view.findViewById(d.g.vr_pic_view);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void a(AdCard adCard) {
        if (adCard.threadPicList != null && adCard.threadPicList.length >= 1) {
            String str = adCard.threadPicList[0].pic;
            this.gDp.setVisibility(0);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            advertAppInfo.aKG.width = this.mMaxWidth;
            advertAppInfo.aKG.height = (this.mMaxWidth * this.mImageHeight) / this.mImageWidth;
            advertAppInfo.aKG.aKQ = str;
            this.gEv.a(this.aRG, advertAppInfo);
            ViewGroup.LayoutParams layoutParams = this.gEv.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = advertAppInfo.aKG.width;
                layoutParams.height = advertAppInfo.aKG.height;
            }
            this.gEv.setLayoutParams(layoutParams);
            return;
        }
        this.gDp.setVisibility(8);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getLayout() {
        return d.h.card_ad;
    }
}
