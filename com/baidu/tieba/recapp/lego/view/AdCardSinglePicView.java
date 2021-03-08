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
import com.baidu.tieba.recapp.lego.a.a;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes7.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    private XfremodeRoundLayout mXk;
    private TbImageView mXl;
    private View mXm;
    private TextView mXn;

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
        float HW = HW(R.string.J_X05);
        if (view instanceof XfremodeRoundLayout) {
            ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{HW, HW, HW, HW, HW, HW, HW, HW});
        }
        this.mXk = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.mXl = (TbImageView) view.findViewById(R.id.ad_img);
        this.mXl.setPlaceHolder(3);
        this.mXm = view.findViewById(R.id.channel_ad);
        this.mXn = (TextView) view.findViewById(R.id.advert_source_img);
        this.mXk.setRoundLayoutRadius(new float[]{HW, HW, HW, HW, HW, HW, HW, HW});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList == null || adCard.threadPicList.length < 1) {
            this.mVP.setVisibility(8);
            return;
        }
        String str = adCard.threadPicList[0].pic;
        boolean a2 = a(this.mXl, adCard);
        if (!TextUtils.isEmpty(str) && a2) {
            this.mVP.setVisibility(0);
            this.mXl.startLoad(str, 17, false);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (!StringUtils.isNull(adCard.adSource, true)) {
                this.mXn.setText(adCard.adSource);
                this.mXm.setVisibility(0);
            } else if (advertAppInfo != null && advertAppInfo.eNd != null && !TextUtils.isEmpty(advertAppInfo.eNd.adSource)) {
                this.mXn.setText(advertAppInfo.eNd.adSource);
                this.mXm.setVisibility(0);
            } else {
                this.mXm.setVisibility(8);
            }
            a(this.mXl, adCard.threadPicList[0].mVw);
            return;
        }
        this.mVP.setVisibility(8);
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
        int HT = (int) (d * a.HT(this.mMaxWidth));
        if (!adCard.needResize) {
            c(tbImageView, HT, i);
            return true;
        }
        int i2 = adCard.height;
        int i3 = adCard.width;
        if (i <= 0 || i2 <= 0 || i3 <= 0) {
            c(tbImageView, this.mMaxWidth, (int) (this.mMaxWidth * 0.0f));
            return true;
        }
        int i4 = (i2 * i) / i3;
        if (i4 > i) {
            return false;
        }
        c(tbImageView, i4, i);
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
            this.mXk.setLayoutParams(layoutParams);
            tbImageView.setLayoutParams(layoutParams);
        }
    }
}
