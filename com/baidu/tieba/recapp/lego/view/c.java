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
public class c extends a {
    protected RelativeLayout gEA;
    protected TbImageView gEB;
    protected TextView gEC;
    protected RelativeLayout gED;
    protected TbImageView gEE;
    protected TextView gEF;
    protected View gEG;
    protected TextView gEH;
    protected RelativeLayout gEx;
    protected TbImageView gEy;
    protected TextView gEz;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getLayout() {
        return d.h.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getCustomLayout() {
        return d.h.card_ad_multi_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void cL(View view) {
        this.gEx = (RelativeLayout) view.findViewById(d.g.rl_img_left);
        this.gEy = (TbImageView) view.findViewById(d.g.advert_app_img_left);
        this.gEz = (TextView) view.findViewById(d.g.txt_left);
        this.gEA = (RelativeLayout) view.findViewById(d.g.rl_img_center);
        this.gEB = (TbImageView) view.findViewById(d.g.advert_app_img_center);
        this.gEC = (TextView) view.findViewById(d.g.txt_center);
        this.gED = (RelativeLayout) view.findViewById(d.g.rl_img_right);
        this.gEE = (TbImageView) view.findViewById(d.g.advert_app_img_right);
        this.gEF = (TextView) view.findViewById(d.g.txt_right);
        this.gEH = (TextView) view.findViewById(d.g.advert_source_right);
        this.gEy.setDrawBorder(true);
        this.gEy.setBorderWidth(1);
        this.gEB.setDrawBorder(true);
        this.gEB.setBorderWidth(1);
        this.gEE.setDrawBorder(true);
        this.gEE.setBorderWidth(1);
        this.gEG = view.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void a(AdCard adCard) {
        AdCard.c[] cVarArr = adCard.threadPicList;
        int length = cVarArr != null ? cVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gDF.setVisibility(8);
            return;
        }
        this.gEz.setVisibility(8);
        this.gEy.setVisibility(8);
        this.gEC.setVisibility(8);
        this.gEB.setVisibility(8);
        this.gEF.setVisibility(8);
        this.gEE.setVisibility(8);
        a(this.gEy, dimensionPixelSize, dimensionPixelSize);
        a(this.gEB, dimensionPixelSize, dimensionPixelSize);
        a(this.gEE, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gEy.startLoad(cVarArr[0].pic, 30, false);
            this.gEy.setVisibility(0);
            a(this.gEy, cVarArr[0].gDn);
            if (StringUtils.isNull(cVarArr[0].desc, true)) {
                this.gEz.setVisibility(8);
            } else {
                this.gEz.setVisibility(0);
                this.gEz.setText(cVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gEy.startLoad(cVarArr[0].pic, 30, false);
            this.gEy.setVisibility(0);
            this.gEB.setVisibility(0);
            a(this.gEy, cVarArr[0].gDn);
            if (StringUtils.isNull(cVarArr[0].desc, true)) {
                this.gEz.setVisibility(8);
            } else {
                this.gEz.setVisibility(0);
                this.gEz.setText(cVarArr[0].desc);
            }
            this.gEB.startLoad(cVarArr[1].pic, 30, false);
            a(this.gEB, cVarArr[1].gDn);
            if (StringUtils.isNull(cVarArr[1].desc, true)) {
                this.gEC.setVisibility(8);
            } else {
                this.gEC.setVisibility(0);
                this.gEC.setText(cVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gEy.startLoad(cVarArr[0].pic, 30, false);
            this.gEy.setVisibility(0);
            this.gEB.setVisibility(0);
            this.gEE.setVisibility(0);
            a(this.gEy, cVarArr[0].gDn);
            if (StringUtils.isNull(cVarArr[0].desc, true)) {
                this.gEz.setVisibility(8);
            } else {
                this.gEz.setVisibility(0);
                this.gEz.setText(cVarArr[0].desc);
            }
            this.gEB.startLoad(cVarArr[1].pic, 30, false);
            a(this.gEB, cVarArr[1].gDn);
            if (StringUtils.isNull(cVarArr[1].desc, true)) {
                this.gEC.setVisibility(8);
            } else {
                this.gEC.setVisibility(0);
                this.gEC.setText(cVarArr[1].desc);
            }
            this.gEE.startLoad(cVarArr[2].pic, 30, false);
            a(this.gEE, cVarArr[2].gDn);
            if (StringUtils.isNull(cVarArr[2].desc, true)) {
                this.gEF.setVisibility(8);
            } else {
                this.gEF.setVisibility(0);
                this.gEF.setText(cVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gEH.setText(adCard.adSource);
            this.gEG.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.aKH != null && !TextUtils.isEmpty(advertAppInfo.aKH.adSource)) {
            this.gEH.setText(advertAppInfo.aKH.adSource);
            this.gEG.setVisibility(0);
        } else {
            this.gEG.setVisibility(8);
        }
        this.gDF.setVisibility(0);
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
