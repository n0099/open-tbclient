package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    private TbImageView gOe;
    private View gOf;
    private TextView gOg;

    public AdCardSinglePicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return e.h.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return e.h.card_ad_single_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void bN(View view) {
        this.gOe = (TbImageView) view.findViewById(e.g.ad_img);
        this.gOe.setDrawBorder(true);
        this.gOe.setBorderWidth(1);
        this.gOf = view.findViewById(e.g.channel_ad);
        this.gOg = (TextView) view.findViewById(e.g.advert_source_img);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList == null || adCard.threadPicList.length < 1) {
            this.gNa.setVisibility(8);
            return;
        }
        String str = adCard.threadPicList[0].pic;
        boolean a = a(this.gOe, adCard);
        if (!TextUtils.isEmpty(str) && a) {
            this.gNa.setVisibility(0);
            this.gOe.startLoad(str, 17, false);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (!StringUtils.isNull(adCard.adSource, true)) {
                this.gOg.setText(adCard.adSource);
                this.gOf.setVisibility(0);
            } else if (advertAppInfo != null && advertAppInfo.apB != null && !TextUtils.isEmpty(advertAppInfo.apB.adSource)) {
                this.gOg.setText(advertAppInfo.apB.adSource);
                this.gOf.setVisibility(0);
            } else {
                this.gOf.setVisibility(8);
            }
            a(this.gOe, adCard.threadPicList[0].gMK);
            return;
        }
        this.gNa.setVisibility(8);
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
