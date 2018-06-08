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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected RelativeLayout glF;
    protected TbImageView glG;
    protected TextView glH;
    protected RelativeLayout glI;
    protected TbImageView glJ;
    protected TextView glK;
    protected RelativeLayout glL;
    protected TbImageView glM;
    protected TextView glN;
    protected View glO;
    protected TextView glP;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return d.i.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return d.i.card_ad_multi_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void bu(View view) {
        this.glF = (RelativeLayout) view.findViewById(d.g.rl_img_left);
        this.glG = (TbImageView) view.findViewById(d.g.advert_app_img_left);
        this.glH = (TextView) view.findViewById(d.g.txt_left);
        this.glI = (RelativeLayout) view.findViewById(d.g.rl_img_center);
        this.glJ = (TbImageView) view.findViewById(d.g.advert_app_img_center);
        this.glK = (TextView) view.findViewById(d.g.txt_center);
        this.glL = (RelativeLayout) view.findViewById(d.g.rl_img_right);
        this.glM = (TbImageView) view.findViewById(d.g.advert_app_img_right);
        this.glN = (TextView) view.findViewById(d.g.txt_right);
        this.glP = (TextView) view.findViewById(d.g.advert_source_right);
        this.glG.setDrawBorder(true);
        this.glG.setBorderWidth(1);
        this.glJ.setDrawBorder(true);
        this.glJ.setBorderWidth(1);
        this.glM.setDrawBorder(true);
        this.glM.setBorderWidth(1);
        this.glO = view.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gkN.setVisibility(8);
            return;
        }
        this.glH.setVisibility(8);
        this.glG.setVisibility(8);
        this.glK.setVisibility(8);
        this.glJ.setVisibility(8);
        this.glN.setVisibility(8);
        this.glM.setVisibility(8);
        a(this.glG, dimensionPixelSize, dimensionPixelSize);
        a(this.glJ, dimensionPixelSize, dimensionPixelSize);
        a(this.glM, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.glG.startLoad(dVarArr[0].pic, 30, false);
            this.glG.setVisibility(0);
            a(this.glG, dVarArr[0].gkx);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.glH.setVisibility(8);
            } else {
                this.glH.setVisibility(0);
                this.glH.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.glG.startLoad(dVarArr[0].pic, 30, false);
            this.glG.setVisibility(0);
            this.glJ.setVisibility(0);
            a(this.glG, dVarArr[0].gkx);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.glH.setVisibility(8);
            } else {
                this.glH.setVisibility(0);
                this.glH.setText(dVarArr[0].desc);
            }
            this.glJ.startLoad(dVarArr[1].pic, 30, false);
            a(this.glJ, dVarArr[1].gkx);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.glK.setVisibility(8);
            } else {
                this.glK.setVisibility(0);
                this.glK.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.glG.startLoad(dVarArr[0].pic, 30, false);
            this.glG.setVisibility(0);
            this.glJ.setVisibility(0);
            this.glM.setVisibility(0);
            a(this.glG, dVarArr[0].gkx);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.glH.setVisibility(8);
            } else {
                this.glH.setVisibility(0);
                this.glH.setText(dVarArr[0].desc);
            }
            this.glJ.startLoad(dVarArr[1].pic, 30, false);
            a(this.glJ, dVarArr[1].gkx);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.glK.setVisibility(8);
            } else {
                this.glK.setVisibility(0);
                this.glK.setText(dVarArr[1].desc);
            }
            this.glM.startLoad(dVarArr[2].pic, 30, false);
            a(this.glM, dVarArr[2].gkx);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.glN.setVisibility(8);
            } else {
                this.glN.setVisibility(0);
                this.glN.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.glP.setText(adCard.adSource);
            this.glO.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.adX != null && !TextUtils.isEmpty(advertAppInfo.adX.adSource)) {
            this.glP.setText(advertAppInfo.adX.adSource);
            this.glO.setVisibility(0);
        } else {
            this.glO.setVisibility(8);
        }
        this.gkN.setVisibility(0);
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
