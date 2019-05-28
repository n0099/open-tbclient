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
    protected RelativeLayout iBO;
    protected TbImageView iBP;
    protected TextView iBQ;
    protected RelativeLayout iBR;
    protected TbImageView iBS;
    protected TextView iBT;
    protected RelativeLayout iBU;
    protected TbImageView iBV;
    protected TextView iBW;
    protected View iBX;
    protected TextView iBY;

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
        this.iBO = (RelativeLayout) view.findViewById(R.id.rl_img_left);
        this.iBP = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.iBQ = (TextView) view.findViewById(R.id.txt_left);
        this.iBR = (RelativeLayout) view.findViewById(R.id.rl_img_center);
        this.iBS = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.iBT = (TextView) view.findViewById(R.id.txt_center);
        this.iBU = (RelativeLayout) view.findViewById(R.id.rl_img_right);
        this.iBV = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.iBW = (TextView) view.findViewById(R.id.txt_right);
        this.iBY = (TextView) view.findViewById(R.id.advert_source_right);
        this.iBP.setRadius(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iBP.setConrers(5);
        this.iBP.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iBP.setBorderColor(0);
        this.iBV.setRadius(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iBV.setConrers(10);
        this.iBV.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iBV.setBorderColor(0);
        this.iBX = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iAV.setVisibility(8);
            return;
        }
        this.iBQ.setVisibility(8);
        this.iBP.setVisibility(8);
        this.iBT.setVisibility(8);
        this.iBS.setVisibility(8);
        this.iBW.setVisibility(8);
        this.iBV.setVisibility(8);
        a(this.iBP, dimensionPixelSize, dimensionPixelSize);
        a(this.iBS, dimensionPixelSize, dimensionPixelSize);
        a(this.iBV, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.iBP.startLoad(dVarArr[0].pic, 30, false);
            this.iBP.setVisibility(0);
            a(this.iBP, dVarArr[0].iAG);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iBQ.setVisibility(8);
            } else {
                this.iBQ.setVisibility(0);
                this.iBQ.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.iBP.startLoad(dVarArr[0].pic, 30, false);
            this.iBP.setVisibility(0);
            this.iBS.setVisibility(0);
            a(this.iBP, dVarArr[0].iAG);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iBQ.setVisibility(8);
            } else {
                this.iBQ.setVisibility(0);
                this.iBQ.setText(dVarArr[0].desc);
            }
            this.iBS.startLoad(dVarArr[1].pic, 30, false);
            a(this.iBS, dVarArr[1].iAG);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iBT.setVisibility(8);
            } else {
                this.iBT.setVisibility(0);
                this.iBT.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.iBP.startLoad(dVarArr[0].pic, 30, false);
            this.iBP.setVisibility(0);
            this.iBS.setVisibility(0);
            this.iBV.setVisibility(0);
            a(this.iBP, dVarArr[0].iAG);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iBQ.setVisibility(8);
            } else {
                this.iBQ.setVisibility(0);
                this.iBQ.setText(dVarArr[0].desc);
            }
            this.iBS.startLoad(dVarArr[1].pic, 30, false);
            a(this.iBS, dVarArr[1].iAG);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iBT.setVisibility(8);
            } else {
                this.iBT.setVisibility(0);
                this.iBT.setText(dVarArr[1].desc);
            }
            this.iBV.startLoad(dVarArr[2].pic, 30, false);
            a(this.iBV, dVarArr[2].iAG);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.iBW.setVisibility(8);
            } else {
                this.iBW.setVisibility(0);
                this.iBW.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.iBY.setText(adCard.adSource);
            this.iBX.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bEc != null && !TextUtils.isEmpty(advertAppInfo.bEc.adSource)) {
            this.iBY.setText(advertAppInfo.bEc.adSource);
            this.iBX.setVisibility(0);
        } else {
            this.iBX.setVisibility(8);
        }
        this.iAV.setVisibility(0);
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
