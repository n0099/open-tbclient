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
    protected RelativeLayout gFB;
    protected TbImageView gFC;
    protected TextView gFD;
    protected RelativeLayout gFE;
    protected TbImageView gFF;
    protected TextView gFG;
    protected RelativeLayout gFH;
    protected TbImageView gFI;
    protected TextView gFJ;
    protected View gFK;
    protected TextView gFL;

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
        this.gFB = (RelativeLayout) view.findViewById(e.g.rl_img_left);
        this.gFC = (TbImageView) view.findViewById(e.g.advert_app_img_left);
        this.gFD = (TextView) view.findViewById(e.g.txt_left);
        this.gFE = (RelativeLayout) view.findViewById(e.g.rl_img_center);
        this.gFF = (TbImageView) view.findViewById(e.g.advert_app_img_center);
        this.gFG = (TextView) view.findViewById(e.g.txt_center);
        this.gFH = (RelativeLayout) view.findViewById(e.g.rl_img_right);
        this.gFI = (TbImageView) view.findViewById(e.g.advert_app_img_right);
        this.gFJ = (TextView) view.findViewById(e.g.txt_right);
        this.gFL = (TextView) view.findViewById(e.g.advert_source_right);
        this.gFC.setDrawBorder(true);
        this.gFC.setBorderWidth(1);
        this.gFF.setDrawBorder(true);
        this.gFF.setBorderWidth(1);
        this.gFI.setDrawBorder(true);
        this.gFI.setBorderWidth(1);
        this.gFK = view.findViewById(e.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gEI.setVisibility(8);
            return;
        }
        this.gFD.setVisibility(8);
        this.gFC.setVisibility(8);
        this.gFG.setVisibility(8);
        this.gFF.setVisibility(8);
        this.gFJ.setVisibility(8);
        this.gFI.setVisibility(8);
        a(this.gFC, dimensionPixelSize, dimensionPixelSize);
        a(this.gFF, dimensionPixelSize, dimensionPixelSize);
        a(this.gFI, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gFC.startLoad(dVarArr[0].pic, 30, false);
            this.gFC.setVisibility(0);
            a(this.gFC, dVarArr[0].gEs);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gFD.setVisibility(8);
            } else {
                this.gFD.setVisibility(0);
                this.gFD.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gFC.startLoad(dVarArr[0].pic, 30, false);
            this.gFC.setVisibility(0);
            this.gFF.setVisibility(0);
            a(this.gFC, dVarArr[0].gEs);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gFD.setVisibility(8);
            } else {
                this.gFD.setVisibility(0);
                this.gFD.setText(dVarArr[0].desc);
            }
            this.gFF.startLoad(dVarArr[1].pic, 30, false);
            a(this.gFF, dVarArr[1].gEs);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gFG.setVisibility(8);
            } else {
                this.gFG.setVisibility(0);
                this.gFG.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gFC.startLoad(dVarArr[0].pic, 30, false);
            this.gFC.setVisibility(0);
            this.gFF.setVisibility(0);
            this.gFI.setVisibility(0);
            a(this.gFC, dVarArr[0].gEs);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gFD.setVisibility(8);
            } else {
                this.gFD.setVisibility(0);
                this.gFD.setText(dVarArr[0].desc);
            }
            this.gFF.startLoad(dVarArr[1].pic, 30, false);
            a(this.gFF, dVarArr[1].gEs);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gFG.setVisibility(8);
            } else {
                this.gFG.setVisibility(0);
                this.gFG.setText(dVarArr[1].desc);
            }
            this.gFI.startLoad(dVarArr[2].pic, 30, false);
            a(this.gFI, dVarArr[2].gEs);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.gFJ.setVisibility(8);
            } else {
                this.gFJ.setVisibility(0);
                this.gFJ.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gFL.setText(adCard.adSource);
            this.gFK.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.aln != null && !TextUtils.isEmpty(advertAppInfo.aln.adSource)) {
            this.gFL.setText(advertAppInfo.aln.adSource);
            this.gFK.setVisibility(0);
        } else {
            this.gFK.setVisibility(8);
        }
        this.gEI.setVisibility(0);
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
