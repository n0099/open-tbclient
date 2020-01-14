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
/* loaded from: classes11.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout jHF;
    protected TbImageView jHG;
    protected TextView jHH;
    protected XfremodeRoundLayout jHI;
    protected TbImageView jHJ;
    protected TextView jHK;
    protected XfremodeRoundLayout jHL;
    protected TbImageView jHM;
    protected TextView jHN;
    protected View jHO;
    protected TextView jHP;

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
    protected void cN(View view) {
        this.jHF = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.jHG = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.jHH = (TextView) view.findViewById(R.id.txt_left);
        this.jHI = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.jHJ = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.jHK = (TextView) view.findViewById(R.id.txt_center);
        this.jHL = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.jHM = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.jHN = (TextView) view.findViewById(R.id.txt_right);
        this.jHP = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.cRe.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.jHF.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jHI.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jHL.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jHG.setPlaceHolder(2);
        this.jHJ.setPlaceHolder(2);
        this.jHM.setPlaceHolder(2);
        this.jHO = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.jGM.setVisibility(8);
            return;
        }
        this.jHH.setVisibility(8);
        this.jHG.setVisibility(8);
        this.jHK.setVisibility(8);
        this.jHJ.setVisibility(8);
        this.jHN.setVisibility(8);
        this.jHM.setVisibility(8);
        a(this.jHG, dimensionPixelSize, dimensionPixelSize);
        a(this.jHJ, dimensionPixelSize, dimensionPixelSize);
        a(this.jHM, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.jHG.startLoad(dVarArr[0].pic, 30, false);
            this.jHG.setVisibility(0);
            a(this.jHG, dVarArr[0].jGx);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jHH.setVisibility(8);
            } else {
                this.jHH.setVisibility(0);
                this.jHH.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.jHG.startLoad(dVarArr[0].pic, 30, false);
            this.jHG.setVisibility(0);
            this.jHJ.setVisibility(0);
            a(this.jHG, dVarArr[0].jGx);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jHH.setVisibility(8);
            } else {
                this.jHH.setVisibility(0);
                this.jHH.setText(dVarArr[0].desc);
            }
            this.jHJ.startLoad(dVarArr[1].pic, 30, false);
            a(this.jHJ, dVarArr[1].jGx);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jHK.setVisibility(8);
            } else {
                this.jHK.setVisibility(0);
                this.jHK.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.jHG.startLoad(dVarArr[0].pic, 30, false);
            this.jHG.setVisibility(0);
            this.jHJ.setVisibility(0);
            this.jHM.setVisibility(0);
            a(this.jHG, dVarArr[0].jGx);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jHH.setVisibility(8);
            } else {
                this.jHH.setVisibility(0);
                this.jHH.setText(dVarArr[0].desc);
            }
            this.jHJ.startLoad(dVarArr[1].pic, 30, false);
            a(this.jHJ, dVarArr[1].jGx);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jHK.setVisibility(8);
            } else {
                this.jHK.setVisibility(0);
                this.jHK.setText(dVarArr[1].desc);
            }
            this.jHM.startLoad(dVarArr[2].pic, 30, false);
            a(this.jHM, dVarArr[2].jGx);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.jHN.setVisibility(8);
            } else {
                this.jHN.setVisibility(0);
                this.jHN.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.jHP.setText(adCard.adSource);
            this.jHO.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.cJb != null && !TextUtils.isEmpty(advertAppInfo.cJb.adSource)) {
            this.jHP.setText(advertAppInfo.cJb.adSource);
            this.jHO.setVisibility(0);
        } else {
            this.jHO.setVisibility(8);
        }
        this.jGM.setVisibility(0);
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
