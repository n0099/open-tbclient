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
/* loaded from: classes13.dex */
public class AdCardSinglePicView extends AdCardBaseView {
    private XfremodeRoundLayout jIM;
    private TbImageView jIN;
    private View jIO;
    private TextView jIP;

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
    protected void cO(View view) {
        float dimensionPixelSize = this.cVg.getResources().getDimensionPixelSize(R.dimen.tbds10);
        if (view instanceof XfremodeRoundLayout) {
            ((XfremodeRoundLayout) view).setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        }
        this.jIM = (XfremodeRoundLayout) view.findViewById(R.id.rl_ad_image);
        this.jIN = (TbImageView) view.findViewById(R.id.ad_img);
        this.jIN.setPlaceHolder(3);
        this.jIO = view.findViewById(R.id.channel_ad);
        this.jIP = (TextView) view.findViewById(R.id.advert_source_img);
        this.jIM.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        if (adCard.threadPicList == null || adCard.threadPicList.length < 1) {
            this.jHD.setVisibility(8);
            return;
        }
        String str = adCard.threadPicList[0].pic;
        boolean a = a(this.jIN, adCard);
        if (!TextUtils.isEmpty(str) && a) {
            this.jHD.setVisibility(0);
            this.jIN.startLoad(str, 17, false);
            AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
            if (!StringUtils.isNull(adCard.adSource, true)) {
                this.jIP.setText(adCard.adSource);
                this.jIO.setVisibility(0);
            } else if (advertAppInfo != null && advertAppInfo.cNe != null && !TextUtils.isEmpty(advertAppInfo.cNe.adSource)) {
                this.jIP.setText(advertAppInfo.cNe.adSource);
                this.jIO.setVisibility(0);
            } else {
                this.jIO.setVisibility(8);
            }
            a(this.jIN, adCard.threadPicList[0].jHo);
            return;
        }
        this.jHD.setVisibility(8);
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
            b(tbImageView, i2, i);
            return true;
        }
        int i3 = adCard.height;
        int i4 = adCard.width;
        if (i <= 0 || i3 <= 0 || i4 <= 0) {
            b(tbImageView, i2, i);
            return true;
        }
        int i5 = (i * i3) / i4;
        if (i5 > i) {
            return false;
        }
        b(tbImageView, i5, i);
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
            this.jIM.setLayoutParams(layoutParams);
            tbImageView.setLayoutParams(layoutParams);
        }
    }
}
