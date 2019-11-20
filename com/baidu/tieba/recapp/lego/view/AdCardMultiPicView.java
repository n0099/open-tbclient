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
    protected XfremodeRoundLayout iJH;
    protected TbImageView iJI;
    protected TextView iJJ;
    protected RelativeLayout iJK;
    protected TbImageView iJL;
    protected TextView iJM;
    protected XfremodeRoundLayout iJN;
    protected TbImageView iJO;
    protected TextView iJP;
    protected View iJQ;
    protected TextView iJR;

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
    protected void cM(View view) {
        this.iJH = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.iJI = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.iJJ = (TextView) view.findViewById(R.id.txt_left);
        this.iJK = (RelativeLayout) view.findViewById(R.id.rl_img_center);
        this.iJL = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.iJM = (TextView) view.findViewById(R.id.txt_center);
        this.iJN = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.iJO = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.iJP = (TextView) view.findViewById(R.id.txt_right);
        this.iJR = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.ceu.getResources().getDimensionPixelSize(R.dimen.tbds20);
        this.iJH.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize});
        this.iJN.setRoundLayoutRadius(new float[]{0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
        this.iJQ = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iIO.setVisibility(8);
            return;
        }
        this.iJJ.setVisibility(8);
        this.iJI.setVisibility(8);
        this.iJM.setVisibility(8);
        this.iJL.setVisibility(8);
        this.iJP.setVisibility(8);
        this.iJO.setVisibility(8);
        a(this.iJI, dimensionPixelSize, dimensionPixelSize);
        a(this.iJL, dimensionPixelSize, dimensionPixelSize);
        a(this.iJO, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.iJI.startLoad(dVarArr[0].pic, 30, false);
            this.iJI.setVisibility(0);
            a(this.iJI, dVarArr[0].iIz);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iJJ.setVisibility(8);
            } else {
                this.iJJ.setVisibility(0);
                this.iJJ.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.iJI.startLoad(dVarArr[0].pic, 30, false);
            this.iJI.setVisibility(0);
            this.iJL.setVisibility(0);
            a(this.iJI, dVarArr[0].iIz);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iJJ.setVisibility(8);
            } else {
                this.iJJ.setVisibility(0);
                this.iJJ.setText(dVarArr[0].desc);
            }
            this.iJL.startLoad(dVarArr[1].pic, 30, false);
            a(this.iJL, dVarArr[1].iIz);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iJM.setVisibility(8);
            } else {
                this.iJM.setVisibility(0);
                this.iJM.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.iJI.startLoad(dVarArr[0].pic, 30, false);
            this.iJI.setVisibility(0);
            this.iJL.setVisibility(0);
            this.iJO.setVisibility(0);
            a(this.iJI, dVarArr[0].iIz);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.iJJ.setVisibility(8);
            } else {
                this.iJJ.setVisibility(0);
                this.iJJ.setText(dVarArr[0].desc);
            }
            this.iJL.startLoad(dVarArr[1].pic, 30, false);
            a(this.iJL, dVarArr[1].iIz);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.iJM.setVisibility(8);
            } else {
                this.iJM.setVisibility(0);
                this.iJM.setText(dVarArr[1].desc);
            }
            this.iJO.startLoad(dVarArr[2].pic, 30, false);
            a(this.iJO, dVarArr[2].iIz);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.iJP.setVisibility(8);
            } else {
                this.iJP.setVisibility(0);
                this.iJP.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.iJR.setText(adCard.adSource);
            this.iJQ.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bWD != null && !TextUtils.isEmpty(advertAppInfo.bWD.adSource)) {
            this.iJR.setText(advertAppInfo.bWD.adSource);
            this.iJQ.setVisibility(0);
        } else {
            this.iJQ.setVisibility(8);
        }
        this.iIO.setVisibility(0);
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
