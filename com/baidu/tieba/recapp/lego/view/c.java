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
    protected TbImageView gEA;
    protected TextView gEB;
    protected RelativeLayout gEC;
    protected TbImageView gED;
    protected TextView gEE;
    protected View gEF;
    protected TextView gEG;
    protected RelativeLayout gEw;
    protected TbImageView gEx;
    protected TextView gEy;
    protected RelativeLayout gEz;

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
        this.gEw = (RelativeLayout) view.findViewById(d.g.rl_img_left);
        this.gEx = (TbImageView) view.findViewById(d.g.advert_app_img_left);
        this.gEy = (TextView) view.findViewById(d.g.txt_left);
        this.gEz = (RelativeLayout) view.findViewById(d.g.rl_img_center);
        this.gEA = (TbImageView) view.findViewById(d.g.advert_app_img_center);
        this.gEB = (TextView) view.findViewById(d.g.txt_center);
        this.gEC = (RelativeLayout) view.findViewById(d.g.rl_img_right);
        this.gED = (TbImageView) view.findViewById(d.g.advert_app_img_right);
        this.gEE = (TextView) view.findViewById(d.g.txt_right);
        this.gEG = (TextView) view.findViewById(d.g.advert_source_right);
        this.gEx.setDrawBorder(true);
        this.gEx.setBorderWidth(1);
        this.gEA.setDrawBorder(true);
        this.gEA.setBorderWidth(1);
        this.gED.setDrawBorder(true);
        this.gED.setBorderWidth(1);
        this.gEF = view.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void a(AdCard adCard) {
        AdCard.c[] cVarArr = adCard.threadPicList;
        int length = cVarArr != null ? cVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gDE.setVisibility(8);
            return;
        }
        this.gEy.setVisibility(8);
        this.gEx.setVisibility(8);
        this.gEB.setVisibility(8);
        this.gEA.setVisibility(8);
        this.gEE.setVisibility(8);
        this.gED.setVisibility(8);
        a(this.gEx, dimensionPixelSize, dimensionPixelSize);
        a(this.gEA, dimensionPixelSize, dimensionPixelSize);
        a(this.gED, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gEx.startLoad(cVarArr[0].pic, 30, false);
            this.gEx.setVisibility(0);
            a(this.gEx, cVarArr[0].gDm);
            if (StringUtils.isNull(cVarArr[0].desc, true)) {
                this.gEy.setVisibility(8);
            } else {
                this.gEy.setVisibility(0);
                this.gEy.setText(cVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gEx.startLoad(cVarArr[0].pic, 30, false);
            this.gEx.setVisibility(0);
            this.gEA.setVisibility(0);
            a(this.gEx, cVarArr[0].gDm);
            if (StringUtils.isNull(cVarArr[0].desc, true)) {
                this.gEy.setVisibility(8);
            } else {
                this.gEy.setVisibility(0);
                this.gEy.setText(cVarArr[0].desc);
            }
            this.gEA.startLoad(cVarArr[1].pic, 30, false);
            a(this.gEA, cVarArr[1].gDm);
            if (StringUtils.isNull(cVarArr[1].desc, true)) {
                this.gEB.setVisibility(8);
            } else {
                this.gEB.setVisibility(0);
                this.gEB.setText(cVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gEx.startLoad(cVarArr[0].pic, 30, false);
            this.gEx.setVisibility(0);
            this.gEA.setVisibility(0);
            this.gED.setVisibility(0);
            a(this.gEx, cVarArr[0].gDm);
            if (StringUtils.isNull(cVarArr[0].desc, true)) {
                this.gEy.setVisibility(8);
            } else {
                this.gEy.setVisibility(0);
                this.gEy.setText(cVarArr[0].desc);
            }
            this.gEA.startLoad(cVarArr[1].pic, 30, false);
            a(this.gEA, cVarArr[1].gDm);
            if (StringUtils.isNull(cVarArr[1].desc, true)) {
                this.gEB.setVisibility(8);
            } else {
                this.gEB.setVisibility(0);
                this.gEB.setText(cVarArr[1].desc);
            }
            this.gED.startLoad(cVarArr[2].pic, 30, false);
            a(this.gED, cVarArr[2].gDm);
            if (StringUtils.isNull(cVarArr[2].desc, true)) {
                this.gEE.setVisibility(8);
            } else {
                this.gEE.setVisibility(0);
                this.gEE.setText(cVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gEG.setText(adCard.adSource);
            this.gEF.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.aKR != null && !TextUtils.isEmpty(advertAppInfo.aKR.adSource)) {
            this.gEG.setText(advertAppInfo.aKR.adSource);
            this.gEF.setVisibility(0);
        } else {
            this.gEF.setVisibility(8);
        }
        this.gDE.setVisibility(0);
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
