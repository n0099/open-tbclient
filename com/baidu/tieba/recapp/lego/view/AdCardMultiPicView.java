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
    protected XfremodeRoundLayout jID;
    protected TbImageView jIE;
    protected TextView jIF;
    protected XfremodeRoundLayout jIG;
    protected TbImageView jIH;
    protected TextView jII;
    protected XfremodeRoundLayout jIJ;
    protected TbImageView jIK;
    protected TextView jIL;
    protected View jIM;
    protected TextView jIN;

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
        this.jID = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_left);
        this.jIE = (TbImageView) view.findViewById(R.id.advert_app_img_left);
        this.jIF = (TextView) view.findViewById(R.id.txt_left);
        this.jIG = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_center);
        this.jIH = (TbImageView) view.findViewById(R.id.advert_app_img_center);
        this.jII = (TextView) view.findViewById(R.id.txt_center);
        this.jIJ = (XfremodeRoundLayout) view.findViewById(R.id.rl_img_right);
        this.jIK = (TbImageView) view.findViewById(R.id.advert_app_img_right);
        this.jIL = (TextView) view.findViewById(R.id.txt_right);
        this.jIN = (TextView) view.findViewById(R.id.advert_source_right);
        float dimensionPixelSize = this.cVh.getResources().getDimensionPixelSize(R.dimen.tbds10);
        this.jID.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jIG.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jIJ.setRoundLayoutRadius(new float[]{dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize});
        this.jIE.setPlaceHolder(2);
        this.jIH.setPlaceHolder(2);
        this.jIK.setPlaceHolder(2);
        this.jIM = view.findViewById(R.id.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.jHF.setVisibility(8);
            return;
        }
        this.jIF.setVisibility(8);
        this.jIE.setVisibility(8);
        this.jII.setVisibility(8);
        this.jIH.setVisibility(8);
        this.jIL.setVisibility(8);
        this.jIK.setVisibility(8);
        a(this.jIE, dimensionPixelSize, dimensionPixelSize);
        a(this.jIH, dimensionPixelSize, dimensionPixelSize);
        a(this.jIK, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.jIE.startLoad(dVarArr[0].pic, 30, false);
            this.jIE.setVisibility(0);
            a(this.jIE, dVarArr[0].jHq);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jIF.setVisibility(8);
            } else {
                this.jIF.setVisibility(0);
                this.jIF.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.jIE.startLoad(dVarArr[0].pic, 30, false);
            this.jIE.setVisibility(0);
            this.jIH.setVisibility(0);
            a(this.jIE, dVarArr[0].jHq);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jIF.setVisibility(8);
            } else {
                this.jIF.setVisibility(0);
                this.jIF.setText(dVarArr[0].desc);
            }
            this.jIH.startLoad(dVarArr[1].pic, 30, false);
            a(this.jIH, dVarArr[1].jHq);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jII.setVisibility(8);
            } else {
                this.jII.setVisibility(0);
                this.jII.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.jIE.startLoad(dVarArr[0].pic, 30, false);
            this.jIE.setVisibility(0);
            this.jIH.setVisibility(0);
            this.jIK.setVisibility(0);
            a(this.jIE, dVarArr[0].jHq);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.jIF.setVisibility(8);
            } else {
                this.jIF.setVisibility(0);
                this.jIF.setText(dVarArr[0].desc);
            }
            this.jIH.startLoad(dVarArr[1].pic, 30, false);
            a(this.jIH, dVarArr[1].jHq);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.jII.setVisibility(8);
            } else {
                this.jII.setVisibility(0);
                this.jII.setText(dVarArr[1].desc);
            }
            this.jIK.startLoad(dVarArr[2].pic, 30, false);
            a(this.jIK, dVarArr[2].jHq);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.jIL.setVisibility(8);
            } else {
                this.jIL.setVisibility(0);
                this.jIL.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.jIN.setText(adCard.adSource);
            this.jIM.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.cNf != null && !TextUtils.isEmpty(advertAppInfo.cNf.adSource)) {
            this.jIN.setText(advertAppInfo.cNf.adSource);
            this.jIM.setVisibility(0);
        } else {
            this.jIM.setVisibility(8);
        }
        this.jHF.setVisibility(0);
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
