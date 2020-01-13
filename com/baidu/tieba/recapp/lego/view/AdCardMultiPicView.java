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
    protected XfremodeRoundLayout jHA;
    protected TbImageView jHB;
    protected TextView jHC;
    protected XfremodeRoundLayout jHD;
    protected TbImageView jHE;
    protected TextView jHF;
    protected XfremodeRoundLayout jHG;
    protected TbImageView jHH;
    protected TextView jHI;
    protected View jHJ;
    protected TextView jHK;

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
        this.jHA = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.jHB = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.jHC = (TextView) view.findViewById(R.id.txt_left);
        this.jHD = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.jHE = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.jHF = (TextView) view.findViewById(R.id.txt_center);
        this.jHG = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.jHH = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.jHI = (TextView) view.findViewById(R.id.txt_right);
        this.jHK = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.cRe.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.jHA.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jHD.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jHG.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jHB.setPlaceHolder(2);
        this.jHE.setPlaceHolder(2);
        this.jHH.setPlaceHolder(2);
        this.jHJ = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.jGH.setVisibility(8);
            return;
        }
        this.jHC.setVisibility(8);
        this.jHB.setVisibility(8);
        this.jHF.setVisibility(8);
        this.jHE.setVisibility(8);
        this.jHI.setVisibility(8);
        this.jHH.setVisibility(8);
        a(this.jHB, dimensionPixelSize, dimensionPixelSize);
        a(this.jHE, dimensionPixelSize, dimensionPixelSize);
        a(this.jHH, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.jHB.startLoad(dVarArr[0].pic, 30, false);
            this.jHB.setVisibility(0);
            a(this.jHB, dVarArr[0].jGs);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jHC.setVisibility(8);
            } else {
                this.jHC.setVisibility(0);
                this.jHC.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.jHB.startLoad(dVarArr[0].pic, 30, false);
            this.jHB.setVisibility(0);
            this.jHE.setVisibility(0);
            a(this.jHB, dVarArr[0].jGs);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jHC.setVisibility(8);
            } else {
                this.jHC.setVisibility(0);
                this.jHC.setText(dVarArr[0].desc);
            }
            this.jHE.startLoad(dVarArr[1].pic, 30, false);
            a(this.jHE, dVarArr[1].jGs);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jHF.setVisibility(8);
            } else {
                this.jHF.setVisibility(0);
                this.jHF.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.jHB.startLoad(dVarArr[0].pic, 30, false);
            this.jHB.setVisibility(0);
            this.jHE.setVisibility(0);
            this.jHH.setVisibility(0);
            a(this.jHB, dVarArr[0].jGs);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jHC.setVisibility(8);
            } else {
                this.jHC.setVisibility(0);
                this.jHC.setText(dVarArr[0].desc);
            }
            this.jHE.startLoad(dVarArr[1].pic, 30, false);
            a(this.jHE, dVarArr[1].jGs);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jHF.setVisibility(8);
            } else {
                this.jHF.setVisibility(0);
                this.jHF.setText(dVarArr[1].desc);
            }
            this.jHH.startLoad(dVarArr[2].pic, 30, false);
            a(this.jHH, dVarArr[2].jGs);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.jHI.setVisibility(8);
            } else {
                this.jHI.setVisibility(0);
                this.jHI.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.jHK.setText(adCard.adSource);
            this.jHJ.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.cJb != null && !TextUtils.isEmpty(advertAppInfo.cJb.adSource)) {
            this.jHK.setText(advertAppInfo.cJb.adSource);
            this.jHJ.setVisibility(0);
        } else {
            this.jHJ.setVisibility(8);
        }
        this.jGH.setVisibility(0);
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
