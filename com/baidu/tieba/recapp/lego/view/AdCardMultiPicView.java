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
    protected XfremodeRoundLayout lFb;
    protected TbImageView lFc;
    protected TextView lFd;
    protected XfremodeRoundLayout lFe;
    protected TbImageView lFf;
    protected TextView lFg;
    protected XfremodeRoundLayout lFh;
    protected TbImageView lFi;
    protected TextView lFj;
    protected View lFk;
    protected TextView lFl;
    private final float lFm;
    private final float lFn;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lFm = 1.0f;
        this.lFn = 0.0f;
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
        this.lFb = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.lFc = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.lFd = (TextView) view.findViewById(R.id.txt_left);
        this.lFe = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.lFf = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.lFg = (TextView) view.findViewById(R.id.txt_center);
        this.lFh = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.lFi = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.lFj = (TextView) view.findViewById(R.id.txt_right);
        this.lFl = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.efr.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.lFb.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lFe.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lFh.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.lFc.setPlaceHolder(2);
        this.lFf.setPlaceHolder(2);
        this.lFi.setPlaceHolder(2);
        this.lFk = view.findViewById(R.id.channel_ad_right);
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
            this.lEf.setVisibility(8);
            return;
        }
        this.lFd.setVisibility(8);
        this.lFc.setVisibility(8);
        this.lFg.setVisibility(8);
        this.lFf.setVisibility(8);
        this.lFj.setVisibility(8);
        this.lFi.setVisibility(8);
        a(this.lFc, dimensionPixelSize, max);
        a(this.lFf, dimensionPixelSize, max);
        a(this.lFi, dimensionPixelSize, max);
        if (length == 1) {
            this.lFc.startLoad(dVarArr[0].pic, 30, false);
            this.lFc.setVisibility(0);
            a(this.lFc, dVarArr[0].lDQ);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lFd.setVisibility(8);
            } else {
                this.lFd.setVisibility(0);
                this.lFd.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.lFc.startLoad(dVarArr[0].pic, 30, false);
            this.lFc.setVisibility(0);
            this.lFf.setVisibility(0);
            a(this.lFc, dVarArr[0].lDQ);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lFd.setVisibility(8);
            } else {
                this.lFd.setVisibility(0);
                this.lFd.setText(dVarArr[0].desc);
            }
            this.lFf.startLoad(dVarArr[1].pic, 30, false);
            a(this.lFf, dVarArr[1].lDQ);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.lFg.setVisibility(8);
            } else {
                this.lFg.setVisibility(0);
                this.lFg.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.lFc.startLoad(dVarArr[0].pic, 30, false);
            this.lFc.setVisibility(0);
            this.lFf.setVisibility(0);
            this.lFi.setVisibility(0);
            a(this.lFc, dVarArr[0].lDQ);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.lFd.setVisibility(8);
            } else {
                this.lFd.setVisibility(0);
                this.lFd.setText(dVarArr[0].desc);
            }
            this.lFf.startLoad(dVarArr[1].pic, 30, false);
            a(this.lFf, dVarArr[1].lDQ);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.lFg.setVisibility(8);
            } else {
                this.lFg.setVisibility(0);
                this.lFg.setText(dVarArr[1].desc);
            }
            this.lFi.startLoad(dVarArr[2].pic, 30, false);
            a(this.lFi, dVarArr[2].lDQ);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.lFj.setVisibility(8);
            } else {
                this.lFj.setVisibility(0);
                this.lFj.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.lFl.setText(adCard.adSource);
            this.lFk.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.dWs != null && !TextUtils.isEmpty(advertAppInfo.dWs.adSource)) {
            this.lFl.setText(advertAppInfo.dWs.adSource);
            this.lFk.setVisibility(0);
        } else {
            this.lFk.setVisibility(8);
        }
        this.lEf.setVisibility(0);
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
