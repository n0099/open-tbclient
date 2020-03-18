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
    protected XfremodeRoundLayout jKo;
    protected TbImageView jKp;
    protected TextView jKq;
    protected XfremodeRoundLayout jKr;
    protected TbImageView jKs;
    protected TextView jKt;
    protected XfremodeRoundLayout jKu;
    protected TbImageView jKv;
    protected TextView jKw;
    protected View jKx;
    protected TextView jKy;

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
    protected void cO(View view) {
        this.jKo = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.jKp = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.jKq = (TextView) view.findViewById(R.id.txt_left);
        this.jKr = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.jKs = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.jKt = (TextView) view.findViewById(R.id.txt_center);
        this.jKu = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.jKv = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.jKw = (TextView) view.findViewById(R.id.txt_right);
        this.jKy = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.cVv.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.jKo.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jKr.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jKu.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jKp.setPlaceHolder(2);
        this.jKs.setPlaceHolder(2);
        this.jKv.setPlaceHolder(2);
        this.jKx = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.jJq.setVisibility(8);
            return;
        }
        this.jKq.setVisibility(8);
        this.jKp.setVisibility(8);
        this.jKt.setVisibility(8);
        this.jKs.setVisibility(8);
        this.jKw.setVisibility(8);
        this.jKv.setVisibility(8);
        a(this.jKp, dimensionPixelSize, dimensionPixelSize);
        a(this.jKs, dimensionPixelSize, dimensionPixelSize);
        a(this.jKv, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.jKp.startLoad(dVarArr[0].pic, 30, false);
            this.jKp.setVisibility(0);
            a(this.jKp, dVarArr[0].jJb);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jKq.setVisibility(8);
            } else {
                this.jKq.setVisibility(0);
                this.jKq.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.jKp.startLoad(dVarArr[0].pic, 30, false);
            this.jKp.setVisibility(0);
            this.jKs.setVisibility(0);
            a(this.jKp, dVarArr[0].jJb);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jKq.setVisibility(8);
            } else {
                this.jKq.setVisibility(0);
                this.jKq.setText(dVarArr[0].desc);
            }
            this.jKs.startLoad(dVarArr[1].pic, 30, false);
            a(this.jKs, dVarArr[1].jJb);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jKt.setVisibility(8);
            } else {
                this.jKt.setVisibility(0);
                this.jKt.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.jKp.startLoad(dVarArr[0].pic, 30, false);
            this.jKp.setVisibility(0);
            this.jKs.setVisibility(0);
            this.jKv.setVisibility(0);
            a(this.jKp, dVarArr[0].jJb);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jKq.setVisibility(8);
            } else {
                this.jKq.setVisibility(0);
                this.jKq.setText(dVarArr[0].desc);
            }
            this.jKs.startLoad(dVarArr[1].pic, 30, false);
            a(this.jKs, dVarArr[1].jJb);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jKt.setVisibility(8);
            } else {
                this.jKt.setVisibility(0);
                this.jKt.setText(dVarArr[1].desc);
            }
            this.jKv.startLoad(dVarArr[2].pic, 30, false);
            a(this.jKv, dVarArr[2].jJb);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.jKw.setVisibility(8);
            } else {
                this.jKw.setVisibility(0);
                this.jKw.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.jKy.setText(adCard.adSource);
            this.jKx.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.cNt != null && !TextUtils.isEmpty(advertAppInfo.cNt.adSource)) {
            this.jKy.setText(advertAppInfo.cNt.adSource);
            this.jKx.setVisibility(0);
        } else {
            this.jKx.setVisibility(8);
        }
        this.jJq.setVisibility(0);
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
