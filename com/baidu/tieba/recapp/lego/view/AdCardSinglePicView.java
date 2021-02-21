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
    private XfremodeRoundLayout mVb;
    private TbImageView mVc;
    private View mVd;
    private TextView mVe;

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
    protected void ea(View view) {
        float HS = HS(R.string.J_X05);
        if (view instanceof XfremodeRoundLayout) {
            ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{HS, HS, HS, HS, HS, HS, HS, HS});
        }
        this.mVb = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mVc = (TbImageView) view.findViewById(R.id.ad_img);
        this.mVc.setPlaceHolder(3);
        this.mVd = view.findViewById(R.id.channel_ad);
        this.mVe = (TextView) view.findViewById(R.id.advert_source_img);
        this.mVb.setRoundLayoutRadius(new float[]{HS, HS, HS, HS, HS, HS, HS, HS});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList == null || adCard.threadPicList.length < 1) {
            this.mTE.setVisibility(8);
            return;
        }
        String str = adCard.threadPicList[0].pic;
        boolean a2 = a(this.mVc, adCard);
        if (!TextUtils.isEmpty(str) && a2) {
            this.mTE.setVisibility(0);
            this.mVc.startLoad(str, 17, false);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (!StringUtils.isNull(adCard.adSource, true)) {
                this.mVe.setText(adCard.adSource);
                this.mVd.setVisibility(0);
            } else if (advertAppInfo != null && advertAppInfo.eLC != null && !TextUtils.isEmpty(advertAppInfo.eLC.adSource)) {
                this.mVe.setText(advertAppInfo.eLC.adSource);
                this.mVd.setVisibility(0);
            } else {
                this.mVd.setVisibility(8);
            }
            a(this.mVc, adCard.threadPicList[0].mTr);
            return;
        }
        this.mTE.setVisibility(8);
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
            this.mVb.setLayoutParams(layoutParams);
            tbImageView.setLayoutParams(layoutParams);
        }
    }
}
