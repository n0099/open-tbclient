package com.baidu.tieba.recapp.lego.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected XfremodeRoundLayout iLH;
    protected TbImageView iLI;
    protected TextView iLJ;
    protected RelativeLayout iLK;
    protected TbImageView iLL;
    protected TextView iLM;
    protected XfremodeRoundLayout iLN;
    protected TbImageView iLO;
    protected TextView iLP;
    protected View iLQ;
    protected TextView iLR;

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
    protected void cQ(View view) {
        this.iLH = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.iLI = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.iLJ = (TextView) view.findViewById(R.id.txt_left);
        this.iLK = (RelativeLayout) view.findViewById(R.id.rl_img_center);
        this.iLL = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.iLM = (TextView) view.findViewById(R.id.txt_center);
        this.iLN = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.iLO = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.iLP = (TextView) view.findViewById(R.id.txt_right);
        this.iLR = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.iLH.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize});
        this.iLN.setRoundLayoutRadius(new float[]{0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
        this.iLQ = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iKO.setVisibility(8);
            return;
        }
        this.iLJ.setVisibility(8);
        this.iLI.setVisibility(8);
        this.iLM.setVisibility(8);
        this.iLL.setVisibility(8);
        this.iLP.setVisibility(8);
        this.iLO.setVisibility(8);
        a(this.iLI, dimensionPixelSize, dimensionPixelSize);
        a(this.iLL, dimensionPixelSize, dimensionPixelSize);
        a(this.iLO, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.iLI.startLoad(dVarArr[0].pic, 30, false);
            this.iLI.setVisibility(0);
            a(this.iLI, dVarArr[0].iKz);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iLJ.setVisibility(8);
            } else {
                this.iLJ.setVisibility(0);
                this.iLJ.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.iLI.startLoad(dVarArr[0].pic, 30, false);
            this.iLI.setVisibility(0);
            this.iLL.setVisibility(0);
            a(this.iLI, dVarArr[0].iKz);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iLJ.setVisibility(8);
            } else {
                this.iLJ.setVisibility(0);
                this.iLJ.setText(dVarArr[0].desc);
            }
            this.iLL.startLoad(dVarArr[1].pic, 30, false);
            a(this.iLL, dVarArr[1].iKz);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iLM.setVisibility(8);
            } else {
                this.iLM.setVisibility(0);
                this.iLM.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.iLI.startLoad(dVarArr[0].pic, 30, false);
            this.iLI.setVisibility(0);
            this.iLL.setVisibility(0);
            this.iLO.setVisibility(0);
            a(this.iLI, dVarArr[0].iKz);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iLJ.setVisibility(8);
            } else {
                this.iLJ.setVisibility(0);
                this.iLJ.setText(dVarArr[0].desc);
            }
            this.iLL.startLoad(dVarArr[1].pic, 30, false);
            a(this.iLL, dVarArr[1].iKz);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iLM.setVisibility(8);
            } else {
                this.iLM.setVisibility(0);
                this.iLM.setText(dVarArr[1].desc);
            }
            this.iLO.startLoad(dVarArr[2].pic, 30, false);
            a(this.iLO, dVarArr[2].iKz);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.iLP.setVisibility(8);
            } else {
                this.iLP.setVisibility(0);
                this.iLP.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.iLR.setText(adCard.adSource);
            this.iLQ.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bFC != null && !TextUtils.isEmpty(advertAppInfo.bFC.adSource)) {
            this.iLR.setText(advertAppInfo.bFC.adSource);
            this.iLQ.setVisibility(0);
        } else {
            this.iLQ.setVisibility(8);
        }
        this.iKO.setVisibility(0);
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
