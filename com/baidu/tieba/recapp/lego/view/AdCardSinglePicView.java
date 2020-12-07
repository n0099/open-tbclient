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
/* loaded from: classes26.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    private XfremodeRoundLayout mKI;
    private TbImageView mKJ;
    private View mKK;
    private TextView mKL;

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
    protected void dS(View view) {
        float Jm = Jm(R.string.J_X05);
        if (view instanceof XfremodeRoundLayout) {
            ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{Jm, Jm, Jm, Jm, Jm, Jm, Jm, Jm});
        }
        this.mKI = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mKJ = (TbImageView) view.findViewById(R.id.ad_img);
        this.mKJ.setPlaceHolder(3);
        this.mKK = view.findViewById(R.id.channel_ad);
        this.mKL = (TextView) view.findViewById(R.id.advert_source_img);
        this.mKI.setRoundLayoutRadius(new float[]{Jm, Jm, Jm, Jm, Jm, Jm, Jm, Jm});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList == null || adCard.threadPicList.length < 1) {
            this.mJp.setVisibility(8);
            return;
        }
        String str = adCard.threadPicList[0].pic;
        boolean a2 = a(this.mKJ, adCard);
        if (!TextUtils.isEmpty(str) && a2) {
            this.mJp.setVisibility(0);
            this.mKJ.startLoad(str, 17, false);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (!StringUtils.isNull(adCard.adSource, true)) {
                this.mKL.setText(adCard.adSource);
                this.mKK.setVisibility(0);
            } else if (advertAppInfo != null && advertAppInfo.eEm != null && !TextUtils.isEmpty(advertAppInfo.eEm.adSource)) {
                this.mKL.setText(advertAppInfo.eEm.adSource);
                this.mKK.setVisibility(0);
            } else {
                this.mKK.setVisibility(8);
            }
            a(this.mKJ, adCard.threadPicList[0].mJb);
            return;
        }
        this.mJp.setVisibility(8);
    }

    protected boolean a(TbImageView tbImageView, AdCard adCard) {
        double d = 1.0d;
        if (adCard == null || tbImageView == null) {
            return false;
        }
        if (adCard.showWidthScale > 0.0d && adCard.showWidthScale < 1.0d) {
            d = adCard.showWidthScale;
        }
        int i = (int) (this.mMaxWidth * d);
        int i2 = (int) (d * this.mImageHeight);
        if (!adCard.needResize) {
            c(tbImageView, i2, i);
            return true;
        }
        int i3 = adCard.height;
        int i4 = adCard.width;
        if (i <= 0 || i3 <= 0 || i4 <= 0) {
            c(tbImageView, this.mMaxWidth, (int) (this.mMaxWidth * 0.0f));
            return true;
        }
        int i5 = (i3 * i) / i4;
        if (i5 > i) {
            return false;
        }
        c(tbImageView, i5, i);
        return true;
    }

    protected void c(TbImageView tbImageView, int i, int i2) {
        if (tbImageView != null) {
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i2, i);
            } else {
                layoutParams.height = i;
                layoutParams.width = i2;
            }
            this.mKI.setLayoutParams(layoutParams);
            tbImageView.setLayoutParams(layoutParams);
        }
    }
}
