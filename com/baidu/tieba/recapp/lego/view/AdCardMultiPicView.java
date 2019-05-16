package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected RelativeLayout iBM;
    protected TbImageView iBN;
    protected TextView iBO;
    protected RelativeLayout iBP;
    protected TbImageView iBQ;
    protected TextView iBR;
    protected RelativeLayout iBS;
    protected TbImageView iBT;
    protected TextView iBU;
    protected View iBV;
    protected TextView iBW;

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
    protected void cL(View view) {
        this.iBM = (RelativeLayout) view.findViewById(R.id.rl_img_left);
        this.iBN = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.iBO = (TextView) view.findViewById(R.id.txt_left);
        this.iBP = (RelativeLayout) view.findViewById(R.id.rl_img_center);
        this.iBQ = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.iBR = (TextView) view.findViewById(R.id.txt_center);
        this.iBS = (RelativeLayout) view.findViewById(R.id.rl_img_right);
        this.iBT = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.iBU = (TextView) view.findViewById(R.id.txt_right);
        this.iBW = (TextView) view.findViewById(R.id.advert_source_right);
        this.iBN.setRadius(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iBN.setConrers(5);
        this.iBN.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iBN.setBorderColor(0);
        this.iBT.setRadius(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iBT.setConrers(10);
        this.iBT.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iBT.setBorderColor(0);
        this.iBV = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iAT.setVisibility(8);
            return;
        }
        this.iBO.setVisibility(8);
        this.iBN.setVisibility(8);
        this.iBR.setVisibility(8);
        this.iBQ.setVisibility(8);
        this.iBU.setVisibility(8);
        this.iBT.setVisibility(8);
        a(this.iBN, dimensionPixelSize, dimensionPixelSize);
        a(this.iBQ, dimensionPixelSize, dimensionPixelSize);
        a(this.iBT, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.iBN.startLoad(dVarArr[0].pic, 30, false);
            this.iBN.setVisibility(0);
            a(this.iBN, dVarArr[0].iAE);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iBO.setVisibility(8);
            } else {
                this.iBO.setVisibility(0);
                this.iBO.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.iBN.startLoad(dVarArr[0].pic, 30, false);
            this.iBN.setVisibility(0);
            this.iBQ.setVisibility(0);
            a(this.iBN, dVarArr[0].iAE);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iBO.setVisibility(8);
            } else {
                this.iBO.setVisibility(0);
                this.iBO.setText(dVarArr[0].desc);
            }
            this.iBQ.startLoad(dVarArr[1].pic, 30, false);
            a(this.iBQ, dVarArr[1].iAE);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iBR.setVisibility(8);
            } else {
                this.iBR.setVisibility(0);
                this.iBR.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.iBN.startLoad(dVarArr[0].pic, 30, false);
            this.iBN.setVisibility(0);
            this.iBQ.setVisibility(0);
            this.iBT.setVisibility(0);
            a(this.iBN, dVarArr[0].iAE);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iBO.setVisibility(8);
            } else {
                this.iBO.setVisibility(0);
                this.iBO.setText(dVarArr[0].desc);
            }
            this.iBQ.startLoad(dVarArr[1].pic, 30, false);
            a(this.iBQ, dVarArr[1].iAE);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iBR.setVisibility(8);
            } else {
                this.iBR.setVisibility(0);
                this.iBR.setText(dVarArr[1].desc);
            }
            this.iBT.startLoad(dVarArr[2].pic, 30, false);
            a(this.iBT, dVarArr[2].iAE);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.iBU.setVisibility(8);
            } else {
                this.iBU.setVisibility(0);
                this.iBU.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.iBW.setText(adCard.adSource);
            this.iBV.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bEc != null && !TextUtils.isEmpty(advertAppInfo.bEc.adSource)) {
            this.iBW.setText(advertAppInfo.bEc.adSource);
            this.iBV.setVisibility(0);
        } else {
            this.iBV.setVisibility(8);
        }
        this.iAT.setVisibility(0);
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
