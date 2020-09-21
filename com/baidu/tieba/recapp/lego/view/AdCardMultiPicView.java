package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes25.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout lNV;
    protected TbImageView lNW;
    protected TextView lNX;
    protected XfremodeRoundLayout lNY;
    protected TbImageView lNZ;
    protected TextView lOa;
    protected XfremodeRoundLayout lOb;
    protected TbImageView lOc;
    protected TextView lOd;
    protected View lOe;
    protected TextView lOf;
    private final float lOg;
    private final float lOh;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lOg = 1.0f;
        this.lOh = 0.0f;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return R.layout.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return R.layout.card_ad_multi_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void dq(View view) {
        this.lNV = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.lNW = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.lNX = (TextView) view.findViewById(R.id.txt_left);
        this.lNY = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.lNZ = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.lOa = (TextView) view.findViewById(R.id.txt_center);
        this.lOb = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.lOc = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.lOd = (TextView) view.findViewById(R.id.txt_right);
        this.lOf = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.ehG.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.lNV.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lNY.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lOb.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lNW.setPlaceHolder(2);
        this.lNZ.setPlaceHolder(2);
        this.lOc.setPlaceHolder(2);
        this.lOe = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        int i = adCard.height;
        int i2 = adCard.width;
        int max = (int) (Math.max(Math.min((i == 0 || i2 == 0) ? 1.0f : i / i2, 1.0f), 0.0f) * dimensionPixelSize);
        if (length <= 0) {
            this.lMZ.setVisibility(8);
            return;
        }
        this.lNX.setVisibility(8);
        this.lNW.setVisibility(8);
        this.lOa.setVisibility(8);
        this.lNZ.setVisibility(8);
        this.lOd.setVisibility(8);
        this.lOc.setVisibility(8);
        a(this.lNW, dimensionPixelSize, max);
        a(this.lNZ, dimensionPixelSize, max);
        a(this.lOc, dimensionPixelSize, max);
        if (length == 1) {
            this.lNW.startLoad(dVarArr[0].pic, 30, false);
            this.lNW.setVisibility(0);
            a(this.lNW, dVarArr[0].lMK);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lNX.setVisibility(8);
            } else {
                this.lNX.setVisibility(0);
                this.lNX.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.lNW.startLoad(dVarArr[0].pic, 30, false);
            this.lNW.setVisibility(0);
            this.lNZ.setVisibility(0);
            a(this.lNW, dVarArr[0].lMK);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lNX.setVisibility(8);
            } else {
                this.lNX.setVisibility(0);
                this.lNX.setText(dVarArr[0].desc);
            }
            this.lNZ.startLoad(dVarArr[1].pic, 30, false);
            a(this.lNZ, dVarArr[1].lMK);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.lOa.setVisibility(8);
            } else {
                this.lOa.setVisibility(0);
                this.lOa.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.lNW.startLoad(dVarArr[0].pic, 30, false);
            this.lNW.setVisibility(0);
            this.lNZ.setVisibility(0);
            this.lOc.setVisibility(0);
            a(this.lNW, dVarArr[0].lMK);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lNX.setVisibility(8);
            } else {
                this.lNX.setVisibility(0);
                this.lNX.setText(dVarArr[0].desc);
            }
            this.lNZ.startLoad(dVarArr[1].pic, 30, false);
            a(this.lNZ, dVarArr[1].lMK);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.lOa.setVisibility(8);
            } else {
                this.lOa.setVisibility(0);
                this.lOa.setText(dVarArr[1].desc);
            }
            this.lOc.startLoad(dVarArr[2].pic, 30, false);
            a(this.lOc, dVarArr[2].lMK);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.lOd.setVisibility(8);
            } else {
                this.lOd.setVisibility(0);
                this.lOd.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.lOf.setText(adCard.adSource);
            this.lOe.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.dYC != null && !TextUtils.isEmpty(advertAppInfo.dYC.adSource)) {
            this.lOf.setText(advertAppInfo.dYC.adSource);
            this.lOe.setVisibility(0);
        } else {
            this.lOe.setVisibility(8);
        }
        this.lMZ.setVisibility(0);
    }

    private void a(TbImageView tbImageView, int i, int i2) {
        if (tbImageView != null) {
            ViewGroup.LayoutParams layoutParams = tbImageView.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            tbImageView.setLayoutParams(layoutParams);
        }
    }
}
