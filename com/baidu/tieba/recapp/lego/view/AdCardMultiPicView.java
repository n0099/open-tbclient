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
    protected TextView iKA;
    protected RelativeLayout iKB;
    protected TbImageView iKC;
    protected TextView iKD;
    protected XfremodeRoundLayout iKE;
    protected TbImageView iKF;
    protected TextView iKG;
    protected View iKH;
    protected TextView iKI;
    protected XfremodeRoundLayout iKy;
    protected TbImageView iKz;

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
    protected void cM(View view) {
        this.iKy = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.iKz = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.iKA = (TextView) view.findViewById(R.id.txt_left);
        this.iKB = (RelativeLayout) view.findViewById(R.id.rl_img_center);
        this.iKC = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.iKD = (TextView) view.findViewById(R.id.txt_center);
        this.iKE = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.iKF = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.iKG = (TextView) view.findViewById(R.id.txt_right);
        this.iKI = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.cfl.getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.iKy.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize});
        this.iKE.setRoundLayoutRadius(new float[]{0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
        this.iKH = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iJF.setVisibility(8);
            return;
        }
        this.iKA.setVisibility(8);
        this.iKz.setVisibility(8);
        this.iKD.setVisibility(8);
        this.iKC.setVisibility(8);
        this.iKG.setVisibility(8);
        this.iKF.setVisibility(8);
        a(this.iKz, dimensionPixelSize, dimensionPixelSize);
        a(this.iKC, dimensionPixelSize, dimensionPixelSize);
        a(this.iKF, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.iKz.startLoad(dVarArr[0].pic, 30, false);
            this.iKz.setVisibility(0);
            a(this.iKz, dVarArr[0].iJq);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iKA.setVisibility(8);
            } else {
                this.iKA.setVisibility(0);
                this.iKA.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.iKz.startLoad(dVarArr[0].pic, 30, false);
            this.iKz.setVisibility(0);
            this.iKC.setVisibility(0);
            a(this.iKz, dVarArr[0].iJq);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iKA.setVisibility(8);
            } else {
                this.iKA.setVisibility(0);
                this.iKA.setText(dVarArr[0].desc);
            }
            this.iKC.startLoad(dVarArr[1].pic, 30, false);
            a(this.iKC, dVarArr[1].iJq);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iKD.setVisibility(8);
            } else {
                this.iKD.setVisibility(0);
                this.iKD.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.iKz.startLoad(dVarArr[0].pic, 30, false);
            this.iKz.setVisibility(0);
            this.iKC.setVisibility(0);
            this.iKF.setVisibility(0);
            a(this.iKz, dVarArr[0].iJq);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iKA.setVisibility(8);
            } else {
                this.iKA.setVisibility(0);
                this.iKA.setText(dVarArr[0].desc);
            }
            this.iKC.startLoad(dVarArr[1].pic, 30, false);
            a(this.iKC, dVarArr[1].iJq);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iKD.setVisibility(8);
            } else {
                this.iKD.setVisibility(0);
                this.iKD.setText(dVarArr[1].desc);
            }
            this.iKF.startLoad(dVarArr[2].pic, 30, false);
            a(this.iKF, dVarArr[2].iJq);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.iKG.setVisibility(8);
            } else {
                this.iKG.setVisibility(0);
                this.iKG.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.iKI.setText(adCard.adSource);
            this.iKH.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bXu != null && !TextUtils.isEmpty(advertAppInfo.bXu.adSource)) {
            this.iKI.setText(advertAppInfo.bXu.adSource);
            this.iKH.setVisibility(0);
        } else {
            this.iKH.setVisibility(8);
        }
        this.iJF.setVisibility(0);
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
