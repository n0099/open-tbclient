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
    protected TbImageView gpA;
    protected TextView gpB;
    protected RelativeLayout gpC;
    protected TbImageView gpD;
    protected TextView gpE;
    protected View gpF;
    protected TextView gpG;
    protected RelativeLayout gpw;
    protected TbImageView gpx;
    protected TextView gpy;
    protected RelativeLayout gpz;

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
    protected void bv(View view) {
        this.gpw = (RelativeLayout) view.findViewById(d.g.rl_img_left);
        this.gpx = (TbImageView) view.findViewById(d.g.advert_app_img_left);
        this.gpy = (TextView) view.findViewById(d.g.txt_left);
        this.gpz = (RelativeLayout) view.findViewById(d.g.rl_img_center);
        this.gpA = (TbImageView) view.findViewById(d.g.advert_app_img_center);
        this.gpB = (TextView) view.findViewById(d.g.txt_center);
        this.gpC = (RelativeLayout) view.findViewById(d.g.rl_img_right);
        this.gpD = (TbImageView) view.findViewById(d.g.advert_app_img_right);
        this.gpE = (TextView) view.findViewById(d.g.txt_right);
        this.gpG = (TextView) view.findViewById(d.g.advert_source_right);
        this.gpx.setDrawBorder(true);
        this.gpx.setBorderWidth(1);
        this.gpA.setDrawBorder(true);
        this.gpA.setBorderWidth(1);
        this.gpD.setDrawBorder(true);
        this.gpD.setBorderWidth(1);
        this.gpF = view.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.goD.setVisibility(8);
            return;
        }
        this.gpy.setVisibility(8);
        this.gpx.setVisibility(8);
        this.gpB.setVisibility(8);
        this.gpA.setVisibility(8);
        this.gpE.setVisibility(8);
        this.gpD.setVisibility(8);
        a(this.gpx, dimensionPixelSize, dimensionPixelSize);
        a(this.gpA, dimensionPixelSize, dimensionPixelSize);
        a(this.gpD, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gpx.startLoad(dVarArr[0].pic, 30, false);
            this.gpx.setVisibility(0);
            a(this.gpx, dVarArr[0].gon);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gpy.setVisibility(8);
            } else {
                this.gpy.setVisibility(0);
                this.gpy.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gpx.startLoad(dVarArr[0].pic, 30, false);
            this.gpx.setVisibility(0);
            this.gpA.setVisibility(0);
            a(this.gpx, dVarArr[0].gon);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gpy.setVisibility(8);
            } else {
                this.gpy.setVisibility(0);
                this.gpy.setText(dVarArr[0].desc);
            }
            this.gpA.startLoad(dVarArr[1].pic, 30, false);
            a(this.gpA, dVarArr[1].gon);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gpB.setVisibility(8);
            } else {
                this.gpB.setVisibility(0);
                this.gpB.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gpx.startLoad(dVarArr[0].pic, 30, false);
            this.gpx.setVisibility(0);
            this.gpA.setVisibility(0);
            this.gpD.setVisibility(0);
            a(this.gpx, dVarArr[0].gon);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gpy.setVisibility(8);
            } else {
                this.gpy.setVisibility(0);
                this.gpy.setText(dVarArr[0].desc);
            }
            this.gpA.startLoad(dVarArr[1].pic, 30, false);
            a(this.gpA, dVarArr[1].gon);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gpB.setVisibility(8);
            } else {
                this.gpB.setVisibility(0);
                this.gpB.setText(dVarArr[1].desc);
            }
            this.gpD.startLoad(dVarArr[2].pic, 30, false);
            a(this.gpD, dVarArr[2].gon);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.gpE.setVisibility(8);
            } else {
                this.gpE.setVisibility(0);
                this.gpE.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gpG.setText(adCard.adSource);
            this.gpF.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.aem != null && !TextUtils.isEmpty(advertAppInfo.aem.adSource)) {
            this.gpG.setText(advertAppInfo.aem.adSource);
            this.gpF.setVisibility(0);
        } else {
            this.gpF.setVisibility(8);
        }
        this.goD.setVisibility(0);
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
