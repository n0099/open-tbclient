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
    protected TbImageView loA;
    protected TextView loB;
    protected View loC;
    protected TextView loD;
    protected XfremodeRoundLayout los;
    protected TbImageView lot;
    protected TextView lou;
    protected XfremodeRoundLayout lov;
    protected TbImageView lox;
    protected TextView loy;
    protected XfremodeRoundLayout loz;

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
        this.los = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.lot = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.lou = (TextView) view.findViewById(R.id.txt_left);
        this.lov = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.lox = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.loy = (TextView) view.findViewById(R.id.txt_center);
        this.loz = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.loA = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.loB = (TextView) view.findViewById(R.id.txt_right);
        this.loD = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.dVN.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.los.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lov.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.loz.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lot.setPlaceHolder(2);
        this.lox.setPlaceHolder(2);
        this.loA.setPlaceHolder(2);
        this.loC = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.lns.setVisibility(8);
            return;
        }
        this.lou.setVisibility(8);
        this.lot.setVisibility(8);
        this.loy.setVisibility(8);
        this.lox.setVisibility(8);
        this.loB.setVisibility(8);
        this.loA.setVisibility(8);
        a(this.lot, dimensionPixelSize, dimensionPixelSize);
        a(this.lox, dimensionPixelSize, dimensionPixelSize);
        a(this.loA, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.lot.startLoad(dVarArr[0].pic, 30, false);
            this.lot.setVisibility(0);
            a(this.lot, dVarArr[0].lnc);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lou.setVisibility(8);
            } else {
                this.lou.setVisibility(0);
                this.lou.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.lot.startLoad(dVarArr[0].pic, 30, false);
            this.lot.setVisibility(0);
            this.lox.setVisibility(0);
            a(this.lot, dVarArr[0].lnc);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lou.setVisibility(8);
            } else {
                this.lou.setVisibility(0);
                this.lou.setText(dVarArr[0].desc);
            }
            this.lox.startLoad(dVarArr[1].pic, 30, false);
            a(this.lox, dVarArr[1].lnc);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.loy.setVisibility(8);
            } else {
                this.loy.setVisibility(0);
                this.loy.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.lot.startLoad(dVarArr[0].pic, 30, false);
            this.lot.setVisibility(0);
            this.lox.setVisibility(0);
            this.loA.setVisibility(0);
            a(this.lot, dVarArr[0].lnc);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lou.setVisibility(8);
            } else {
                this.lou.setVisibility(0);
                this.lou.setText(dVarArr[0].desc);
            }
            this.lox.startLoad(dVarArr[1].pic, 30, false);
            a(this.lox, dVarArr[1].lnc);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.loy.setVisibility(8);
            } else {
                this.loy.setVisibility(0);
                this.loy.setText(dVarArr[1].desc);
            }
            this.loA.startLoad(dVarArr[2].pic, 30, false);
            a(this.loA, dVarArr[2].lnc);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.loB.setVisibility(8);
            } else {
                this.loB.setVisibility(0);
                this.loB.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.loD.setText(adCard.adSource);
            this.loC.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.dNf != null && !TextUtils.isEmpty(advertAppInfo.dNf.adSource)) {
            this.loD.setText(advertAppInfo.dNf.adSource);
            this.loC.setVisibility(0);
        } else {
            this.loC.setVisibility(8);
        }
        this.lns.setVisibility(0);
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
