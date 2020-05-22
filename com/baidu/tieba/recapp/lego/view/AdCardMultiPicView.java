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
/* loaded from: classes13.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout kLY;
    protected TbImageView kLZ;
    protected TextView kMa;
    protected XfremodeRoundLayout kMb;
    protected TbImageView kMc;
    protected TextView kMd;
    protected XfremodeRoundLayout kMe;
    protected TbImageView kMf;
    protected TextView kMg;
    protected View kMh;
    protected TextView kMi;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
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
    protected void cX(View view) {
        this.kLY = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.kLZ = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.kMa = (TextView) view.findViewById(R.id.txt_left);
        this.kMb = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.kMc = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.kMd = (TextView) view.findViewById(R.id.txt_center);
        this.kMe = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.kMf = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.kMg = (TextView) view.findViewById(R.id.txt_right);
        this.kMi = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.dIF.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.kLY.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.kMb.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.kMe.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.kLZ.setPlaceHolder(2);
        this.kMc.setPlaceHolder(2);
        this.kMf.setPlaceHolder(2);
        this.kMh = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.kLa.setVisibility(8);
            return;
        }
        this.kMa.setVisibility(8);
        this.kLZ.setVisibility(8);
        this.kMd.setVisibility(8);
        this.kMc.setVisibility(8);
        this.kMg.setVisibility(8);
        this.kMf.setVisibility(8);
        a(this.kLZ, dimensionPixelSize, dimensionPixelSize);
        a(this.kMc, dimensionPixelSize, dimensionPixelSize);
        a(this.kMf, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.kLZ.startLoad(dVarArr[0].pic, 30, false);
            this.kLZ.setVisibility(0);
            a(this.kLZ, dVarArr[0].kKL);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.kMa.setVisibility(8);
            } else {
                this.kMa.setVisibility(0);
                this.kMa.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.kLZ.startLoad(dVarArr[0].pic, 30, false);
            this.kLZ.setVisibility(0);
            this.kMc.setVisibility(0);
            a(this.kLZ, dVarArr[0].kKL);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.kMa.setVisibility(8);
            } else {
                this.kMa.setVisibility(0);
                this.kMa.setText(dVarArr[0].desc);
            }
            this.kMc.startLoad(dVarArr[1].pic, 30, false);
            a(this.kMc, dVarArr[1].kKL);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.kMd.setVisibility(8);
            } else {
                this.kMd.setVisibility(0);
                this.kMd.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.kLZ.startLoad(dVarArr[0].pic, 30, false);
            this.kLZ.setVisibility(0);
            this.kMc.setVisibility(0);
            this.kMf.setVisibility(0);
            a(this.kLZ, dVarArr[0].kKL);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.kMa.setVisibility(8);
            } else {
                this.kMa.setVisibility(0);
                this.kMa.setText(dVarArr[0].desc);
            }
            this.kMc.startLoad(dVarArr[1].pic, 30, false);
            a(this.kMc, dVarArr[1].kKL);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.kMd.setVisibility(8);
            } else {
                this.kMd.setVisibility(0);
                this.kMd.setText(dVarArr[1].desc);
            }
            this.kMf.startLoad(dVarArr[2].pic, 30, false);
            a(this.kMf, dVarArr[2].kKL);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.kMg.setVisibility(8);
            } else {
                this.kMg.setVisibility(0);
                this.kMg.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.kMi.setText(adCard.adSource);
            this.kMh.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.dAD != null && !TextUtils.isEmpty(advertAppInfo.dAD.adSource)) {
            this.kMi.setText(advertAppInfo.dAD.adSource);
            this.kMh.setVisibility(0);
        } else {
            this.kMh.setVisibility(8);
        }
        this.kLa.setVisibility(0);
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
