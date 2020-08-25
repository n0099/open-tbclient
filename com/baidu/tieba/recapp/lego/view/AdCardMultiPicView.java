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
    protected XfremodeRoundLayout lEQ;
    protected TbImageView lER;
    protected TextView lES;
    protected XfremodeRoundLayout lET;
    protected TbImageView lEU;
    protected TextView lEV;
    protected XfremodeRoundLayout lEW;
    protected TbImageView lEX;
    protected TextView lEY;
    protected View lEZ;
    protected TextView lFa;

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
    protected void di(View view) {
        this.lEQ = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.lER = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.lES = (TextView) view.findViewById(R.id.txt_left);
        this.lET = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.lEU = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.lEV = (TextView) view.findViewById(R.id.txt_center);
        this.lEW = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.lEX = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.lEY = (TextView) view.findViewById(R.id.txt_right);
        this.lFa = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.efn.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.lEQ.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lET.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lEW.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lER.setPlaceHolder(2);
        this.lEU.setPlaceHolder(2);
        this.lEX.setPlaceHolder(2);
        this.lEZ = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.lDU.setVisibility(8);
            return;
        }
        this.lES.setVisibility(8);
        this.lER.setVisibility(8);
        this.lEV.setVisibility(8);
        this.lEU.setVisibility(8);
        this.lEY.setVisibility(8);
        this.lEX.setVisibility(8);
        a(this.lER, dimensionPixelSize, dimensionPixelSize);
        a(this.lEU, dimensionPixelSize, dimensionPixelSize);
        a(this.lEX, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.lER.startLoad(dVarArr[0].pic, 30, false);
            this.lER.setVisibility(0);
            a(this.lER, dVarArr[0].lDF);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lES.setVisibility(8);
            } else {
                this.lES.setVisibility(0);
                this.lES.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.lER.startLoad(dVarArr[0].pic, 30, false);
            this.lER.setVisibility(0);
            this.lEU.setVisibility(0);
            a(this.lER, dVarArr[0].lDF);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lES.setVisibility(8);
            } else {
                this.lES.setVisibility(0);
                this.lES.setText(dVarArr[0].desc);
            }
            this.lEU.startLoad(dVarArr[1].pic, 30, false);
            a(this.lEU, dVarArr[1].lDF);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.lEV.setVisibility(8);
            } else {
                this.lEV.setVisibility(0);
                this.lEV.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.lER.startLoad(dVarArr[0].pic, 30, false);
            this.lER.setVisibility(0);
            this.lEU.setVisibility(0);
            this.lEX.setVisibility(0);
            a(this.lER, dVarArr[0].lDF);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lES.setVisibility(8);
            } else {
                this.lES.setVisibility(0);
                this.lES.setText(dVarArr[0].desc);
            }
            this.lEU.startLoad(dVarArr[1].pic, 30, false);
            a(this.lEU, dVarArr[1].lDF);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.lEV.setVisibility(8);
            } else {
                this.lEV.setVisibility(0);
                this.lEV.setText(dVarArr[1].desc);
            }
            this.lEX.startLoad(dVarArr[2].pic, 30, false);
            a(this.lEX, dVarArr[2].lDF);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.lEY.setVisibility(8);
            } else {
                this.lEY.setVisibility(0);
                this.lEY.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.lFa.setText(adCard.adSource);
            this.lEZ.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.dWo != null && !TextUtils.isEmpty(advertAppInfo.dWo.adSource)) {
            this.lFa.setText(advertAppInfo.dWo.adSource);
            this.lEZ.setVisibility(0);
        } else {
            this.lEZ.setVisibility(8);
        }
        this.lDU.setVisibility(0);
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
