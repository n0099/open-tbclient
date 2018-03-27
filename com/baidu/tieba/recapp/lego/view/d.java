package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class d extends a {
    private TbImageView gEI;
    private View gEJ;
    private TextView gEK;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getLayout() {
        return d.h.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getCustomLayout() {
        return d.h.card_ad_single_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void cL(View view) {
        this.gEI = (TbImageView) view.findViewById(d.g.ad_img);
        this.gEI.setDrawBorder(true);
        this.gEI.setBorderWidth(1);
        this.gEJ = view.findViewById(d.g.channel_ad);
        this.gEK = (TextView) view.findViewById(d.g.advert_source_img);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void a(AdCard adCard) {
        if (adCard.threadPicList == null || adCard.threadPicList.length < 1) {
            this.gDF.setVisibility(8);
            return;
        }
        String str = adCard.threadPicList[0].pic;
        boolean a = a(this.gEI, adCard);
        if (!TextUtils.isEmpty(str) && a) {
            this.gDF.setVisibility(0);
            this.gEI.startLoad(str, 17, false);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (!StringUtils.isNull(adCard.adSource, true)) {
                this.gEK.setText(adCard.adSource);
                this.gEJ.setVisibility(0);
            } else if (advertAppInfo != null && advertAppInfo.aKH != null && !TextUtils.isEmpty(advertAppInfo.aKH.adSource)) {
                this.gEK.setText(advertAppInfo.aKH.adSource);
                this.gEJ.setVisibility(0);
            } else {
                this.gEJ.setVisibility(8);
            }
            a(this.gEI, adCard.threadPicList[0].gDn);
            return;
        }
        this.gDF.setVisibility(8);
    }

    protected boolean a(TbImageView tbImageView, AdCard adCard) {
        if (adCard == null || tbImageView == null) {
            return false;
        }
        int i = this.mMaxWidth;
        if (!adCard.needResize) {
            b(tbImageView, (this.mImageHeight * i) / this.mImageWidth, i);
            return true;
        }
        int i2 = adCard.height;
        int i3 = adCard.width;
        if (this.mMaxWidth <= 0 || i2 <= 0 || i3 <= 0) {
            b(tbImageView, this.mImageHeight, this.mImageWidth);
            return true;
        }
        int i4 = (i2 * i) / i3;
        if (i4 > i) {
            return false;
        }
        b(tbImageView, i4, i);
        return true;
    }

    protected void b(TbImageView tbImageView, int i, int i2) {
        if (tbImageView != null) {
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i2, i);
            } else {
                layoutParams.height = i;
                layoutParams.width = i2;
            }
            tbImageView.setLayoutParams(layoutParams);
        }
    }
}
