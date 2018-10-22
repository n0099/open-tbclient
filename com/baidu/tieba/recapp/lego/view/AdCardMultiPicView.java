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
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected RelativeLayout gFC;
    protected TbImageView gFD;
    protected TextView gFE;
    protected RelativeLayout gFF;
    protected TbImageView gFG;
    protected TextView gFH;
    protected RelativeLayout gFI;
    protected TbImageView gFJ;
    protected TextView gFK;
    protected View gFL;
    protected TextView gFM;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return e.h.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return e.h.card_ad_multi_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void bL(View view) {
        this.gFC = (RelativeLayout) view.findViewById(e.g.rl_img_left);
        this.gFD = (TbImageView) view.findViewById(e.g.advert_app_img_left);
        this.gFE = (TextView) view.findViewById(e.g.txt_left);
        this.gFF = (RelativeLayout) view.findViewById(e.g.rl_img_center);
        this.gFG = (TbImageView) view.findViewById(e.g.advert_app_img_center);
        this.gFH = (TextView) view.findViewById(e.g.txt_center);
        this.gFI = (RelativeLayout) view.findViewById(e.g.rl_img_right);
        this.gFJ = (TbImageView) view.findViewById(e.g.advert_app_img_right);
        this.gFK = (TextView) view.findViewById(e.g.txt_right);
        this.gFM = (TextView) view.findViewById(e.g.advert_source_right);
        this.gFD.setDrawBorder(true);
        this.gFD.setBorderWidth(1);
        this.gFG.setDrawBorder(true);
        this.gFG.setBorderWidth(1);
        this.gFJ.setDrawBorder(true);
        this.gFJ.setBorderWidth(1);
        this.gFL = view.findViewById(e.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gEJ.setVisibility(8);
            return;
        }
        this.gFE.setVisibility(8);
        this.gFD.setVisibility(8);
        this.gFH.setVisibility(8);
        this.gFG.setVisibility(8);
        this.gFK.setVisibility(8);
        this.gFJ.setVisibility(8);
        a(this.gFD, dimensionPixelSize, dimensionPixelSize);
        a(this.gFG, dimensionPixelSize, dimensionPixelSize);
        a(this.gFJ, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gFD.startLoad(dVarArr[0].pic, 30, false);
            this.gFD.setVisibility(0);
            a(this.gFD, dVarArr[0].gEt);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gFE.setVisibility(8);
            } else {
                this.gFE.setVisibility(0);
                this.gFE.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gFD.startLoad(dVarArr[0].pic, 30, false);
            this.gFD.setVisibility(0);
            this.gFG.setVisibility(0);
            a(this.gFD, dVarArr[0].gEt);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gFE.setVisibility(8);
            } else {
                this.gFE.setVisibility(0);
                this.gFE.setText(dVarArr[0].desc);
            }
            this.gFG.startLoad(dVarArr[1].pic, 30, false);
            a(this.gFG, dVarArr[1].gEt);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gFH.setVisibility(8);
            } else {
                this.gFH.setVisibility(0);
                this.gFH.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gFD.startLoad(dVarArr[0].pic, 30, false);
            this.gFD.setVisibility(0);
            this.gFG.setVisibility(0);
            this.gFJ.setVisibility(0);
            a(this.gFD, dVarArr[0].gEt);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gFE.setVisibility(8);
            } else {
                this.gFE.setVisibility(0);
                this.gFE.setText(dVarArr[0].desc);
            }
            this.gFG.startLoad(dVarArr[1].pic, 30, false);
            a(this.gFG, dVarArr[1].gEt);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gFH.setVisibility(8);
            } else {
                this.gFH.setVisibility(0);
                this.gFH.setText(dVarArr[1].desc);
            }
            this.gFJ.startLoad(dVarArr[2].pic, 30, false);
            a(this.gFJ, dVarArr[2].gEt);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.gFK.setVisibility(8);
            } else {
                this.gFK.setVisibility(0);
                this.gFK.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gFM.setText(adCard.adSource);
            this.gFL.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.aln != null && !TextUtils.isEmpty(advertAppInfo.aln.adSource)) {
            this.gFM.setText(advertAppInfo.aln.adSource);
            this.gFL.setVisibility(0);
        } else {
            this.gFL.setVisibility(8);
        }
        this.gEJ.setVisibility(0);
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
