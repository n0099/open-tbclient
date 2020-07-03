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
/* loaded from: classes13.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout lha;
    protected TbImageView lhb;
    protected TextView lhc;
    protected XfremodeRoundLayout lhd;
    protected TbImageView lhe;
    protected TextView lhf;
    protected XfremodeRoundLayout lhg;
    protected TbImageView lhh;
    protected TextView lhi;
    protected View lhj;
    protected TextView lhk;

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
    protected void cY(View view) {
        this.lha = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.lhb = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.lhc = (TextView) view.findViewById(R.id.txt_left);
        this.lhd = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.lhe = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.lhf = (TextView) view.findViewById(R.id.txt_center);
        this.lhg = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.lhh = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.lhi = (TextView) view.findViewById(R.id.txt_right);
        this.lhk = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.dPv.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.lha.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lhd.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lhg.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lhb.setPlaceHolder(2);
        this.lhe.setPlaceHolder(2);
        this.lhh.setPlaceHolder(2);
        this.lhj = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.lgd.setVisibility(8);
            return;
        }
        this.lhc.setVisibility(8);
        this.lhb.setVisibility(8);
        this.lhf.setVisibility(8);
        this.lhe.setVisibility(8);
        this.lhi.setVisibility(8);
        this.lhh.setVisibility(8);
        a(this.lhb, dimensionPixelSize, dimensionPixelSize);
        a(this.lhe, dimensionPixelSize, dimensionPixelSize);
        a(this.lhh, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.lhb.startLoad(dVarArr[0].pic, 30, false);
            this.lhb.setVisibility(0);
            a(this.lhb, dVarArr[0].lfO);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lhc.setVisibility(8);
            } else {
                this.lhc.setVisibility(0);
                this.lhc.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.lhb.startLoad(dVarArr[0].pic, 30, false);
            this.lhb.setVisibility(0);
            this.lhe.setVisibility(0);
            a(this.lhb, dVarArr[0].lfO);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lhc.setVisibility(8);
            } else {
                this.lhc.setVisibility(0);
                this.lhc.setText(dVarArr[0].desc);
            }
            this.lhe.startLoad(dVarArr[1].pic, 30, false);
            a(this.lhe, dVarArr[1].lfO);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.lhf.setVisibility(8);
            } else {
                this.lhf.setVisibility(0);
                this.lhf.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.lhb.startLoad(dVarArr[0].pic, 30, false);
            this.lhb.setVisibility(0);
            this.lhe.setVisibility(0);
            this.lhh.setVisibility(0);
            a(this.lhb, dVarArr[0].lfO);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lhc.setVisibility(8);
            } else {
                this.lhc.setVisibility(0);
                this.lhc.setText(dVarArr[0].desc);
            }
            this.lhe.startLoad(dVarArr[1].pic, 30, false);
            a(this.lhe, dVarArr[1].lfO);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.lhf.setVisibility(8);
            } else {
                this.lhf.setVisibility(0);
                this.lhf.setText(dVarArr[1].desc);
            }
            this.lhh.startLoad(dVarArr[2].pic, 30, false);
            a(this.lhh, dVarArr[2].lfO);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.lhi.setVisibility(8);
            } else {
                this.lhi.setVisibility(0);
                this.lhi.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.lhk.setText(adCard.adSource);
            this.lhj.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.dGU != null && !TextUtils.isEmpty(advertAppInfo.dGU.adSource)) {
            this.lhk.setText(advertAppInfo.dGU.adSource);
            this.lhj.setVisibility(0);
        } else {
            this.lhj.setVisibility(8);
        }
        this.lgd.setVisibility(0);
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
