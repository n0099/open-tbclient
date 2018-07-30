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
public class AdCardSinglePicView extends AdCardBaseView {
    private TbImageView gqR;
    private View gqS;
    private TextView gqT;

    public AdCardSinglePicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return d.h.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return d.h.card_ad_single_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void by(View view) {
        this.gqR = (TbImageView) view.findViewById(d.g.ad_img);
        this.gqR.setDrawBorder(true);
        this.gqR.setBorderWidth(1);
        this.gqS = view.findViewById(d.g.channel_ad);
        this.gqT = (TextView) view.findViewById(d.g.advert_source_img);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList == null || adCard.threadPicList.length < 1) {
            this.gpN.setVisibility(8);
            return;
        }
        String str = adCard.threadPicList[0].pic;
        boolean a = a(this.gqR, adCard);
        if (!TextUtils.isEmpty(str) && a) {
            this.gpN.setVisibility(0);
            this.gqR.startLoad(str, 17, false);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (!StringUtils.isNull(adCard.adSource, true)) {
                this.gqT.setText(adCard.adSource);
                this.gqS.setVisibility(0);
            } else if (advertAppInfo != null && advertAppInfo.adQ != null && !TextUtils.isEmpty(advertAppInfo.adQ.adSource)) {
                this.gqT.setText(advertAppInfo.adQ.adSource);
                this.gqS.setVisibility(0);
            } else {
                this.gqS.setVisibility(8);
            }
            a(this.gqR, adCard.threadPicList[0].gpx);
            return;
        }
        this.gpN.setVisibility(8);
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
