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
    protected RelativeLayout iBP;
    protected TbImageView iBQ;
    protected TextView iBR;
    protected RelativeLayout iBS;
    protected TbImageView iBT;
    protected TextView iBU;
    protected RelativeLayout iBV;
    protected TbImageView iBW;
    protected TextView iBX;
    protected View iBY;
    protected TextView iBZ;

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
        this.iBP = (RelativeLayout) view.findViewById(R.id.rl_img_left);
        this.iBQ = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.iBR = (TextView) view.findViewById(R.id.txt_left);
        this.iBS = (RelativeLayout) view.findViewById(R.id.rl_img_center);
        this.iBT = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.iBU = (TextView) view.findViewById(R.id.txt_center);
        this.iBV = (RelativeLayout) view.findViewById(R.id.rl_img_right);
        this.iBW = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.iBX = (TextView) view.findViewById(R.id.txt_right);
        this.iBZ = (TextView) view.findViewById(R.id.advert_source_right);
        this.iBQ.setRadius(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iBQ.setConrers(5);
        this.iBQ.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iBQ.setBorderColor(0);
        this.iBW.setRadius(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.iBW.setConrers(10);
        this.iBW.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.iBW.setBorderColor(0);
        this.iBY = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iAW.setVisibility(8);
            return;
        }
        this.iBR.setVisibility(8);
        this.iBQ.setVisibility(8);
        this.iBU.setVisibility(8);
        this.iBT.setVisibility(8);
        this.iBX.setVisibility(8);
        this.iBW.setVisibility(8);
        a(this.iBQ, dimensionPixelSize, dimensionPixelSize);
        a(this.iBT, dimensionPixelSize, dimensionPixelSize);
        a(this.iBW, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.iBQ.startLoad(dVarArr[0].pic, 30, false);
            this.iBQ.setVisibility(0);
            a(this.iBQ, dVarArr[0].iAH);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iBR.setVisibility(8);
            } else {
                this.iBR.setVisibility(0);
                this.iBR.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.iBQ.startLoad(dVarArr[0].pic, 30, false);
            this.iBQ.setVisibility(0);
            this.iBT.setVisibility(0);
            a(this.iBQ, dVarArr[0].iAH);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iBR.setVisibility(8);
            } else {
                this.iBR.setVisibility(0);
                this.iBR.setText(dVarArr[0].desc);
            }
            this.iBT.startLoad(dVarArr[1].pic, 30, false);
            a(this.iBT, dVarArr[1].iAH);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iBU.setVisibility(8);
            } else {
                this.iBU.setVisibility(0);
                this.iBU.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.iBQ.startLoad(dVarArr[0].pic, 30, false);
            this.iBQ.setVisibility(0);
            this.iBT.setVisibility(0);
            this.iBW.setVisibility(0);
            a(this.iBQ, dVarArr[0].iAH);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iBR.setVisibility(8);
            } else {
                this.iBR.setVisibility(0);
                this.iBR.setText(dVarArr[0].desc);
            }
            this.iBT.startLoad(dVarArr[1].pic, 30, false);
            a(this.iBT, dVarArr[1].iAH);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iBU.setVisibility(8);
            } else {
                this.iBU.setVisibility(0);
                this.iBU.setText(dVarArr[1].desc);
            }
            this.iBW.startLoad(dVarArr[2].pic, 30, false);
            a(this.iBW, dVarArr[2].iAH);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.iBX.setVisibility(8);
            } else {
                this.iBX.setVisibility(0);
                this.iBX.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.iBZ.setText(adCard.adSource);
            this.iBY.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bEd != null && !TextUtils.isEmpty(advertAppInfo.bEd.adSource)) {
            this.iBZ.setText(advertAppInfo.bEd.adSource);
            this.iBY.setVisibility(0);
        } else {
            this.iBY.setVisibility(8);
        }
        this.iAW.setVisibility(0);
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
