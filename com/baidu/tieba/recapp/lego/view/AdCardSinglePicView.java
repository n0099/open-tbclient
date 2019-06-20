package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    private TbImageView iCa;
    private View iCb;
    private TextView iCc;

    public AdCardSinglePicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_single_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cL(View view) {
        this.iCa = (TbImageView) view.findViewById(R.id.ad_img);
        this.iCa.setRadius(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iCa.setConrers(15);
        this.iCa.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iCa.setBorderColor(0);
        this.iCb = view.findViewById(R.id.channel_ad);
        this.iCc = (TextView) view.findViewById(R.id.advert_source_img);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList == null || adCard.threadPicList.length < 1) {
            this.iAW.setVisibility(8);
            return;
        }
        String str = adCard.threadPicList[0].pic;
        boolean a = a(this.iCa, adCard);
        if (!TextUtils.isEmpty(str) && a) {
            this.iAW.setVisibility(0);
            this.iCa.startLoad(str, 17, false);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (!StringUtils.isNull(adCard.adSource, true)) {
                this.iCc.setText(adCard.adSource);
                this.iCb.setVisibility(0);
            } else if (advertAppInfo != null && advertAppInfo.bEd != null && !TextUtils.isEmpty(advertAppInfo.bEd.adSource)) {
                this.iCc.setText(advertAppInfo.bEd.adSource);
                this.iCb.setVisibility(0);
            } else {
                this.iCb.setVisibility(8);
            }
            a(this.iCa, adCard.threadPicList[0].iAH);
            return;
        }
        this.iAW.setVisibility(8);
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
