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
/* loaded from: classes25.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    private XfremodeRoundLayout mww;
    private TbImageView mwx;
    private View mwy;
    private TextView mwz;

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
    protected void dH(View view) {
        float Iv = Iv(R.string.J_X05);
        if (view instanceof XfremodeRoundLayout) {
            ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{Iv, Iv, Iv, Iv, Iv, Iv, Iv, Iv});
        }
        this.mww = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mwx = (TbImageView) view.findViewById(R.id.ad_img);
        this.mwx.setPlaceHolder(3);
        this.mwy = view.findViewById(R.id.channel_ad);
        this.mwz = (TextView) view.findViewById(R.id.advert_source_img);
        this.mww.setRoundLayoutRadius(new float[]{Iv, Iv, Iv, Iv, Iv, Iv, Iv, Iv});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList == null || adCard.threadPicList.length < 1) {
            this.mvd.setVisibility(8);
            return;
        }
        String str = adCard.threadPicList[0].pic;
        boolean a2 = a(this.mwx, adCard);
        if (!TextUtils.isEmpty(str) && a2) {
            this.mvd.setVisibility(0);
            this.mwx.startLoad(str, 17, false);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (!StringUtils.isNull(adCard.adSource, true)) {
                this.mwz.setText(adCard.adSource);
                this.mwy.setVisibility(0);
            } else if (advertAppInfo != null && advertAppInfo.exl != null && !TextUtils.isEmpty(advertAppInfo.exl.adSource)) {
                this.mwz.setText(advertAppInfo.exl.adSource);
                this.mwy.setVisibility(0);
            } else {
                this.mwy.setVisibility(8);
            }
            a(this.mwx, adCard.threadPicList[0].muP);
            return;
        }
        this.mvd.setVisibility(8);
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
            this.mww.setLayoutParams(layoutParams);
            tbImageView.setLayoutParams(layoutParams);
        }
    }
}
