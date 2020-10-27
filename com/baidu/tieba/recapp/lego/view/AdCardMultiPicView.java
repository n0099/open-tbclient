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
    protected XfremodeRoundLayout mpL;
    protected TbImageView mpM;
    protected TextView mpN;
    protected XfremodeRoundLayout mpO;
    protected TbImageView mpP;
    protected TextView mpQ;
    protected XfremodeRoundLayout mpR;
    protected TbImageView mpS;
    protected TextView mpT;
    protected View mpU;
    protected TextView mpV;
    private final float mpW;
    private final float mpX;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mpW = 1.0f;
        this.mpX = 0.0f;
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
    protected void dy(View view) {
        this.mpL = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.mpM = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.mpN = (TextView) view.findViewById(R.id.txt_left);
        this.mpO = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.mpP = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.mpQ = (TextView) view.findViewById(R.id.txt_center);
        this.mpR = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.mpS = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.mpT = (TextView) view.findViewById(R.id.txt_right);
        this.mpV = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.eCn.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.mpL.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.mpO.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.mpR.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.mpM.setPlaceHolder(2);
        this.mpP.setPlaceHolder(2);
        this.mpS.setPlaceHolder(2);
        this.mpU = view.findViewById(R.id.channel_ad_right);
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
            this.moP.setVisibility(8);
            return;
        }
        this.mpN.setVisibility(8);
        this.mpM.setVisibility(8);
        this.mpQ.setVisibility(8);
        this.mpP.setVisibility(8);
        this.mpT.setVisibility(8);
        this.mpS.setVisibility(8);
        a(this.mpM, dimensionPixelSize, max);
        a(this.mpP, dimensionPixelSize, max);
        a(this.mpS, dimensionPixelSize, max);
        if (length == 1) {
            this.mpM.startLoad(dVarArr[0].pic, 30, false);
            this.mpM.setVisibility(0);
            a(this.mpM, dVarArr[0].moA);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mpN.setVisibility(8);
            } else {
                this.mpN.setVisibility(0);
                this.mpN.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.mpM.startLoad(dVarArr[0].pic, 30, false);
            this.mpM.setVisibility(0);
            this.mpP.setVisibility(0);
            a(this.mpM, dVarArr[0].moA);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mpN.setVisibility(8);
            } else {
                this.mpN.setVisibility(0);
                this.mpN.setText(dVarArr[0].desc);
            }
            this.mpP.startLoad(dVarArr[1].pic, 30, false);
            a(this.mpP, dVarArr[1].moA);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mpQ.setVisibility(8);
            } else {
                this.mpQ.setVisibility(0);
                this.mpQ.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.mpM.startLoad(dVarArr[0].pic, 30, false);
            this.mpM.setVisibility(0);
            this.mpP.setVisibility(0);
            this.mpS.setVisibility(0);
            a(this.mpM, dVarArr[0].moA);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.mpN.setVisibility(8);
            } else {
                this.mpN.setVisibility(0);
                this.mpN.setText(dVarArr[0].desc);
            }
            this.mpP.startLoad(dVarArr[1].pic, 30, false);
            a(this.mpP, dVarArr[1].moA);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.mpQ.setVisibility(8);
            } else {
                this.mpQ.setVisibility(0);
                this.mpQ.setText(dVarArr[1].desc);
            }
            this.mpS.startLoad(dVarArr[2].pic, 30, false);
            a(this.mpS, dVarArr[2].moA);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.mpT.setVisibility(8);
            } else {
                this.mpT.setVisibility(0);
                this.mpT.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.mpV.setText(adCard.adSource);
            this.mpU.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.ete != null && !TextUtils.isEmpty(advertAppInfo.ete.adSource)) {
            this.mpV.setText(advertAppInfo.ete.adSource);
            this.mpU.setVisibility(0);
        } else {
            this.mpU.setVisibility(8);
        }
        this.moP.setVisibility(0);
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
