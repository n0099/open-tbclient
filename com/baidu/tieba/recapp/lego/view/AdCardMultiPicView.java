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
    protected RelativeLayout gHd;
    protected TbImageView gHe;
    protected TextView gHf;
    protected RelativeLayout gHg;
    protected TbImageView gHh;
    protected TextView gHi;
    protected RelativeLayout gHj;
    protected TbImageView gHk;
    protected TextView gHl;
    protected View gHm;
    protected TextView gHn;

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
    protected void bN(View view) {
        this.gHd = (RelativeLayout) view.findViewById(e.g.rl_img_left);
        this.gHe = (TbImageView) view.findViewById(e.g.advert_app_img_left);
        this.gHf = (TextView) view.findViewById(e.g.txt_left);
        this.gHg = (RelativeLayout) view.findViewById(e.g.rl_img_center);
        this.gHh = (TbImageView) view.findViewById(e.g.advert_app_img_center);
        this.gHi = (TextView) view.findViewById(e.g.txt_center);
        this.gHj = (RelativeLayout) view.findViewById(e.g.rl_img_right);
        this.gHk = (TbImageView) view.findViewById(e.g.advert_app_img_right);
        this.gHl = (TextView) view.findViewById(e.g.txt_right);
        this.gHn = (TextView) view.findViewById(e.g.advert_source_right);
        this.gHe.setDrawBorder(true);
        this.gHe.setBorderWidth(1);
        this.gHh.setDrawBorder(true);
        this.gHh.setBorderWidth(1);
        this.gHk.setDrawBorder(true);
        this.gHk.setBorderWidth(1);
        this.gHm = view.findViewById(e.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gGk.setVisibility(8);
            return;
        }
        this.gHf.setVisibility(8);
        this.gHe.setVisibility(8);
        this.gHi.setVisibility(8);
        this.gHh.setVisibility(8);
        this.gHl.setVisibility(8);
        this.gHk.setVisibility(8);
        a(this.gHe, dimensionPixelSize, dimensionPixelSize);
        a(this.gHh, dimensionPixelSize, dimensionPixelSize);
        a(this.gHk, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gHe.startLoad(dVarArr[0].pic, 30, false);
            this.gHe.setVisibility(0);
            a(this.gHe, dVarArr[0].gFU);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gHf.setVisibility(8);
            } else {
                this.gHf.setVisibility(0);
                this.gHf.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gHe.startLoad(dVarArr[0].pic, 30, false);
            this.gHe.setVisibility(0);
            this.gHh.setVisibility(0);
            a(this.gHe, dVarArr[0].gFU);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gHf.setVisibility(8);
            } else {
                this.gHf.setVisibility(0);
                this.gHf.setText(dVarArr[0].desc);
            }
            this.gHh.startLoad(dVarArr[1].pic, 30, false);
            a(this.gHh, dVarArr[1].gFU);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gHi.setVisibility(8);
            } else {
                this.gHi.setVisibility(0);
                this.gHi.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gHe.startLoad(dVarArr[0].pic, 30, false);
            this.gHe.setVisibility(0);
            this.gHh.setVisibility(0);
            this.gHk.setVisibility(0);
            a(this.gHe, dVarArr[0].gFU);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gHf.setVisibility(8);
            } else {
                this.gHf.setVisibility(0);
                this.gHf.setText(dVarArr[0].desc);
            }
            this.gHh.startLoad(dVarArr[1].pic, 30, false);
            a(this.gHh, dVarArr[1].gFU);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gHi.setVisibility(8);
            } else {
                this.gHi.setVisibility(0);
                this.gHi.setText(dVarArr[1].desc);
            }
            this.gHk.startLoad(dVarArr[2].pic, 30, false);
            a(this.gHk, dVarArr[2].gFU);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.gHl.setVisibility(8);
            } else {
                this.gHl.setVisibility(0);
                this.gHl.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gHn.setText(adCard.adSource);
            this.gHm.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.ama != null && !TextUtils.isEmpty(advertAppInfo.ama.adSource)) {
            this.gHn.setText(advertAppInfo.ama.adSource);
            this.gHm.setVisibility(0);
        } else {
            this.gHm.setVisibility(8);
        }
        this.gGk.setVisibility(0);
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
