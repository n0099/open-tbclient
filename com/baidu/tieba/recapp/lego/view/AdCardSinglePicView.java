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
/* loaded from: classes8.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    private XfremodeRoundLayout mPT;
    private TbImageView mPU;
    private View mPV;
    private TextView mPW;

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
    protected void ec(View view) {
        float Jg = Jg(R.string.J_X05);
        if (view instanceof XfremodeRoundLayout) {
            ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{Jg, Jg, Jg, Jg, Jg, Jg, Jg, Jg});
        }
        this.mPT = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mPU = (TbImageView) view.findViewById(R.id.ad_img);
        this.mPU.setPlaceHolder(3);
        this.mPV = view.findViewById(R.id.channel_ad);
        this.mPW = (TextView) view.findViewById(R.id.advert_source_img);
        this.mPT.setRoundLayoutRadius(new float[]{Jg, Jg, Jg, Jg, Jg, Jg, Jg, Jg});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList == null || adCard.threadPicList.length < 1) {
            this.mOy.setVisibility(8);
            return;
        }
        String str = adCard.threadPicList[0].pic;
        boolean a2 = a(this.mPU, adCard);
        if (!TextUtils.isEmpty(str) && a2) {
            this.mOy.setVisibility(0);
            this.mPU.startLoad(str, 17, false);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (!StringUtils.isNull(adCard.adSource, true)) {
                this.mPW.setText(adCard.adSource);
                this.mPV.setVisibility(0);
            } else if (advertAppInfo != null && advertAppInfo.eOc != null && !TextUtils.isEmpty(advertAppInfo.eOc.adSource)) {
                this.mPW.setText(advertAppInfo.eOc.adSource);
                this.mPV.setVisibility(0);
            } else {
                this.mPV.setVisibility(8);
            }
            a(this.mPU, adCard.threadPicList[0].mOl);
            return;
        }
        this.mOy.setVisibility(8);
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
            this.mPT.setLayoutParams(layoutParams);
            tbImageView.setLayoutParams(layoutParams);
        }
    }
}
