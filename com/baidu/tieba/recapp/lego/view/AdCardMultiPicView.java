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
/* loaded from: classes26.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout mvI;
    protected TbImageView mvJ;
    protected TextView mvK;
    protected XfremodeRoundLayout mvL;
    protected TbImageView mvM;
    protected TextView mvN;
    protected XfremodeRoundLayout mvO;
    protected TbImageView mvP;
    protected TextView mvQ;
    protected View mvR;
    protected TextView mvS;
    private final float mvT;
    private final float mvU;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mvT = 1.0f;
        this.mvU = 0.0f;
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
    protected void dD(View view) {
        this.mvI = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.mvJ = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.mvK = (TextView) view.findViewById(R.id.txt_left);
        this.mvL = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.mvM = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.mvN = (TextView) view.findViewById(R.id.txt_center);
        this.mvO = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.mvP = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.mvQ = (TextView) view.findViewById(R.id.txt_right);
        this.mvS = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.eIc.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.mvI.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.mvL.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.mvO.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.mvJ.setPlaceHolder(2);
        this.mvM.setPlaceHolder(2);
        this.mvP.setPlaceHolder(2);
        this.mvR = view.findViewById(R.id.channel_ad_right);
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
            this.muM.setVisibility(8);
            return;
        }
        this.mvK.setVisibility(8);
        this.mvJ.setVisibility(8);
        this.mvN.setVisibility(8);
        this.mvM.setVisibility(8);
        this.mvQ.setVisibility(8);
        this.mvP.setVisibility(8);
        a(this.mvJ, dimensionPixelSize, max);
        a(this.mvM, dimensionPixelSize, max);
        a(this.mvP, dimensionPixelSize, max);
        if (length == 1) {
            this.mvJ.startLoad(dVarArr[0].pic, 30, false);
            this.mvJ.setVisibility(0);
            a(this.mvJ, dVarArr[0].mux);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mvK.setVisibility(8);
            } else {
                this.mvK.setVisibility(0);
                this.mvK.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.mvJ.startLoad(dVarArr[0].pic, 30, false);
            this.mvJ.setVisibility(0);
            this.mvM.setVisibility(0);
            a(this.mvJ, dVarArr[0].mux);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mvK.setVisibility(8);
            } else {
                this.mvK.setVisibility(0);
                this.mvK.setText(dVarArr[0].desc);
            }
            this.mvM.startLoad(dVarArr[1].pic, 30, false);
            a(this.mvM, dVarArr[1].mux);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mvN.setVisibility(8);
            } else {
                this.mvN.setVisibility(0);
                this.mvN.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.mvJ.startLoad(dVarArr[0].pic, 30, false);
            this.mvJ.setVisibility(0);
            this.mvM.setVisibility(0);
            this.mvP.setVisibility(0);
            a(this.mvJ, dVarArr[0].mux);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mvK.setVisibility(8);
            } else {
                this.mvK.setVisibility(0);
                this.mvK.setText(dVarArr[0].desc);
            }
            this.mvM.startLoad(dVarArr[1].pic, 30, false);
            a(this.mvM, dVarArr[1].mux);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mvN.setVisibility(8);
            } else {
                this.mvN.setVisibility(0);
                this.mvN.setText(dVarArr[1].desc);
            }
            this.mvP.startLoad(dVarArr[2].pic, 30, false);
            a(this.mvP, dVarArr[2].mux);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.mvQ.setVisibility(8);
            } else {
                this.mvQ.setVisibility(0);
                this.mvQ.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.mvS.setText(adCard.adSource);
            this.mvR.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.eyX != null && !TextUtils.isEmpty(advertAppInfo.eyX.adSource)) {
            this.mvS.setText(advertAppInfo.eyX.adSource);
            this.mvR.setVisibility(0);
        } else {
            this.mvR.setVisibility(8);
        }
        this.muM.setVisibility(0);
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
