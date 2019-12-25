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
/* loaded from: classes10.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout jDY;
    protected TbImageView jDZ;
    protected TextView jEa;
    protected XfremodeRoundLayout jEb;
    protected TbImageView jEc;
    protected TextView jEd;
    protected XfremodeRoundLayout jEe;
    protected TbImageView jEf;
    protected TextView jEg;
    protected View jEh;
    protected TextView jEi;

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
    protected void cH(View view) {
        this.jDY = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.jDZ = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.jEa = (TextView) view.findViewById(R.id.txt_left);
        this.jEb = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.jEc = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.jEd = (TextView) view.findViewById(R.id.txt_center);
        this.jEe = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.jEf = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.jEg = (TextView) view.findViewById(R.id.txt_right);
        this.jEi = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.cQU.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.jDY.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jEb.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jEe.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jDZ.setPlaceHolder(2);
        this.jEc.setPlaceHolder(2);
        this.jEf.setPlaceHolder(2);
        this.jEh = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.jDf.setVisibility(8);
            return;
        }
        this.jEa.setVisibility(8);
        this.jDZ.setVisibility(8);
        this.jEd.setVisibility(8);
        this.jEc.setVisibility(8);
        this.jEg.setVisibility(8);
        this.jEf.setVisibility(8);
        a(this.jDZ, dimensionPixelSize, dimensionPixelSize);
        a(this.jEc, dimensionPixelSize, dimensionPixelSize);
        a(this.jEf, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.jDZ.startLoad(dVarArr[0].pic, 30, false);
            this.jDZ.setVisibility(0);
            a(this.jDZ, dVarArr[0].jCQ);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jEa.setVisibility(8);
            } else {
                this.jEa.setVisibility(0);
                this.jEa.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.jDZ.startLoad(dVarArr[0].pic, 30, false);
            this.jDZ.setVisibility(0);
            this.jEc.setVisibility(0);
            a(this.jDZ, dVarArr[0].jCQ);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jEa.setVisibility(8);
            } else {
                this.jEa.setVisibility(0);
                this.jEa.setText(dVarArr[0].desc);
            }
            this.jEc.startLoad(dVarArr[1].pic, 30, false);
            a(this.jEc, dVarArr[1].jCQ);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jEd.setVisibility(8);
            } else {
                this.jEd.setVisibility(0);
                this.jEd.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.jDZ.startLoad(dVarArr[0].pic, 30, false);
            this.jDZ.setVisibility(0);
            this.jEc.setVisibility(0);
            this.jEf.setVisibility(0);
            a(this.jDZ, dVarArr[0].jCQ);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jEa.setVisibility(8);
            } else {
                this.jEa.setVisibility(0);
                this.jEa.setText(dVarArr[0].desc);
            }
            this.jEc.startLoad(dVarArr[1].pic, 30, false);
            a(this.jEc, dVarArr[1].jCQ);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jEd.setVisibility(8);
            } else {
                this.jEd.setVisibility(0);
                this.jEd.setText(dVarArr[1].desc);
            }
            this.jEf.startLoad(dVarArr[2].pic, 30, false);
            a(this.jEf, dVarArr[2].jCQ);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.jEg.setVisibility(8);
            } else {
                this.jEg.setVisibility(0);
                this.jEg.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.jEi.setText(adCard.adSource);
            this.jEh.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.cIQ != null && !TextUtils.isEmpty(advertAppInfo.cIQ.adSource)) {
            this.jEi.setText(advertAppInfo.cIQ.adSource);
            this.jEh.setVisibility(0);
        } else {
            this.jEh.setVisibility(8);
        }
        this.jDf.setVisibility(0);
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
