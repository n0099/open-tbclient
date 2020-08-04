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
/* loaded from: classes20.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected TextView loA;
    protected XfremodeRoundLayout loB;
    protected TbImageView loC;
    protected TextView loD;
    protected View loE;
    protected TextView loF;
    protected XfremodeRoundLayout lou;
    protected TbImageView lov;
    protected TextView lox;
    protected XfremodeRoundLayout loy;
    protected TbImageView loz;

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
    protected void de(View view) {
        this.lou = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.lov = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.lox = (TextView) view.findViewById(R.id.txt_left);
        this.loy = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.loz = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.loA = (TextView) view.findViewById(R.id.txt_center);
        this.loB = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.loC = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.loD = (TextView) view.findViewById(R.id.txt_right);
        this.loF = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.dVN.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.lou.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.loy.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.loB.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lov.setPlaceHolder(2);
        this.loz.setPlaceHolder(2);
        this.loC.setPlaceHolder(2);
        this.loE = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.lnu.setVisibility(8);
            return;
        }
        this.lox.setVisibility(8);
        this.lov.setVisibility(8);
        this.loA.setVisibility(8);
        this.loz.setVisibility(8);
        this.loD.setVisibility(8);
        this.loC.setVisibility(8);
        a(this.lov, dimensionPixelSize, dimensionPixelSize);
        a(this.loz, dimensionPixelSize, dimensionPixelSize);
        a(this.loC, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.lov.startLoad(dVarArr[0].pic, 30, false);
            this.lov.setVisibility(0);
            a(this.lov, dVarArr[0].lne);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lox.setVisibility(8);
            } else {
                this.lox.setVisibility(0);
                this.lox.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.lov.startLoad(dVarArr[0].pic, 30, false);
            this.lov.setVisibility(0);
            this.loz.setVisibility(0);
            a(this.lov, dVarArr[0].lne);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lox.setVisibility(8);
            } else {
                this.lox.setVisibility(0);
                this.lox.setText(dVarArr[0].desc);
            }
            this.loz.startLoad(dVarArr[1].pic, 30, false);
            a(this.loz, dVarArr[1].lne);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.loA.setVisibility(8);
            } else {
                this.loA.setVisibility(0);
                this.loA.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.lov.startLoad(dVarArr[0].pic, 30, false);
            this.lov.setVisibility(0);
            this.loz.setVisibility(0);
            this.loC.setVisibility(0);
            a(this.lov, dVarArr[0].lne);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lox.setVisibility(8);
            } else {
                this.lox.setVisibility(0);
                this.lox.setText(dVarArr[0].desc);
            }
            this.loz.startLoad(dVarArr[1].pic, 30, false);
            a(this.loz, dVarArr[1].lne);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.loA.setVisibility(8);
            } else {
                this.loA.setVisibility(0);
                this.loA.setText(dVarArr[1].desc);
            }
            this.loC.startLoad(dVarArr[2].pic, 30, false);
            a(this.loC, dVarArr[2].lne);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.loD.setVisibility(8);
            } else {
                this.loD.setVisibility(0);
                this.loD.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.loF.setText(adCard.adSource);
            this.loE.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.dNf != null && !TextUtils.isEmpty(advertAppInfo.dNf.adSource)) {
            this.loF.setText(advertAppInfo.dNf.adSource);
            this.loE.setVisibility(0);
        } else {
            this.loE.setVisibility(8);
        }
        this.lnu.setVisibility(0);
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
