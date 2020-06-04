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
    protected XfremodeRoundLayout kNh;
    protected TbImageView kNi;
    protected TextView kNj;
    protected XfremodeRoundLayout kNk;
    protected TbImageView kNl;
    protected TextView kNm;
    protected XfremodeRoundLayout kNn;
    protected TbImageView kNo;
    protected TextView kNp;
    protected View kNq;
    protected TextView kNr;

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
    protected void cX(View view) {
        this.kNh = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.kNi = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.kNj = (TextView) view.findViewById(R.id.txt_left);
        this.kNk = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.kNl = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.kNm = (TextView) view.findViewById(R.id.txt_center);
        this.kNn = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.kNo = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.kNp = (TextView) view.findViewById(R.id.txt_right);
        this.kNr = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.dIF.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.kNh.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.kNk.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.kNn.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.kNi.setPlaceHolder(2);
        this.kNl.setPlaceHolder(2);
        this.kNo.setPlaceHolder(2);
        this.kNq = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.kMj.setVisibility(8);
            return;
        }
        this.kNj.setVisibility(8);
        this.kNi.setVisibility(8);
        this.kNm.setVisibility(8);
        this.kNl.setVisibility(8);
        this.kNp.setVisibility(8);
        this.kNo.setVisibility(8);
        a(this.kNi, dimensionPixelSize, dimensionPixelSize);
        a(this.kNl, dimensionPixelSize, dimensionPixelSize);
        a(this.kNo, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.kNi.startLoad(dVarArr[0].pic, 30, false);
            this.kNi.setVisibility(0);
            a(this.kNi, dVarArr[0].kLU);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.kNj.setVisibility(8);
            } else {
                this.kNj.setVisibility(0);
                this.kNj.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.kNi.startLoad(dVarArr[0].pic, 30, false);
            this.kNi.setVisibility(0);
            this.kNl.setVisibility(0);
            a(this.kNi, dVarArr[0].kLU);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.kNj.setVisibility(8);
            } else {
                this.kNj.setVisibility(0);
                this.kNj.setText(dVarArr[0].desc);
            }
            this.kNl.startLoad(dVarArr[1].pic, 30, false);
            a(this.kNl, dVarArr[1].kLU);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.kNm.setVisibility(8);
            } else {
                this.kNm.setVisibility(0);
                this.kNm.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.kNi.startLoad(dVarArr[0].pic, 30, false);
            this.kNi.setVisibility(0);
            this.kNl.setVisibility(0);
            this.kNo.setVisibility(0);
            a(this.kNi, dVarArr[0].kLU);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.kNj.setVisibility(8);
            } else {
                this.kNj.setVisibility(0);
                this.kNj.setText(dVarArr[0].desc);
            }
            this.kNl.startLoad(dVarArr[1].pic, 30, false);
            a(this.kNl, dVarArr[1].kLU);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.kNm.setVisibility(8);
            } else {
                this.kNm.setVisibility(0);
                this.kNm.setText(dVarArr[1].desc);
            }
            this.kNo.startLoad(dVarArr[2].pic, 30, false);
            a(this.kNo, dVarArr[2].kLU);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.kNp.setVisibility(8);
            } else {
                this.kNp.setVisibility(0);
                this.kNp.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.kNr.setText(adCard.adSource);
            this.kNq.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.dAD != null && !TextUtils.isEmpty(advertAppInfo.dAD.adSource)) {
            this.kNr.setText(advertAppInfo.dAD.adSource);
            this.kNq.setVisibility(0);
        } else {
            this.kNq.setVisibility(8);
        }
        this.kMj.setVisibility(0);
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
