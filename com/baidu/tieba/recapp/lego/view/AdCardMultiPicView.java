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
    protected TbImageView ijA;
    protected TextView ijB;
    protected View ijC;
    protected TextView ijD;
    protected RelativeLayout ijt;
    protected TbImageView iju;
    protected TextView ijv;
    protected RelativeLayout ijw;
    protected TbImageView ijx;
    protected TextView ijy;
    protected RelativeLayout ijz;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return d.h.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return d.h.card_ad_multi_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void cD(View view) {
        this.ijt = (RelativeLayout) view.findViewById(d.g.rl_img_left);
        this.iju = (TbImageView) view.findViewById(d.g.advert_app_img_left);
        this.ijv = (TextView) view.findViewById(d.g.txt_left);
        this.ijw = (RelativeLayout) view.findViewById(d.g.rl_img_center);
        this.ijx = (TbImageView) view.findViewById(d.g.advert_app_img_center);
        this.ijy = (TextView) view.findViewById(d.g.txt_center);
        this.ijz = (RelativeLayout) view.findViewById(d.g.rl_img_right);
        this.ijA = (TbImageView) view.findViewById(d.g.advert_app_img_right);
        this.ijB = (TextView) view.findViewById(d.g.txt_right);
        this.ijD = (TextView) view.findViewById(d.g.advert_source_right);
        this.iju.setRadius(this.mContext.getResources().getDimensionPixelSize(d.e.tbds20));
        this.iju.setConrers(5);
        this.iju.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.iju.setBorderColor(0);
        this.ijA.setRadius(this.mContext.getResources().getDimensionPixelSize(d.e.tbds20));
        this.ijA.setConrers(10);
        this.ijA.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.ijA.setBorderColor(0);
        this.ijC = view.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iiA.setVisibility(8);
            return;
        }
        this.ijv.setVisibility(8);
        this.iju.setVisibility(8);
        this.ijy.setVisibility(8);
        this.ijx.setVisibility(8);
        this.ijB.setVisibility(8);
        this.ijA.setVisibility(8);
        a(this.iju, dimensionPixelSize, dimensionPixelSize);
        a(this.ijx, dimensionPixelSize, dimensionPixelSize);
        a(this.ijA, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.iju.startLoad(dVarArr[0].pic, 30, false);
            this.iju.setVisibility(0);
            a(this.iju, dVarArr[0].iik);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijv.setVisibility(8);
            } else {
                this.ijv.setVisibility(0);
                this.ijv.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.iju.startLoad(dVarArr[0].pic, 30, false);
            this.iju.setVisibility(0);
            this.ijx.setVisibility(0);
            a(this.iju, dVarArr[0].iik);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijv.setVisibility(8);
            } else {
                this.ijv.setVisibility(0);
                this.ijv.setText(dVarArr[0].desc);
            }
            this.ijx.startLoad(dVarArr[1].pic, 30, false);
            a(this.ijx, dVarArr[1].iik);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.ijy.setVisibility(8);
            } else {
                this.ijy.setVisibility(0);
                this.ijy.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.iju.startLoad(dVarArr[0].pic, 30, false);
            this.iju.setVisibility(0);
            this.ijx.setVisibility(0);
            this.ijA.setVisibility(0);
            a(this.iju, dVarArr[0].iik);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijv.setVisibility(8);
            } else {
                this.ijv.setVisibility(0);
                this.ijv.setText(dVarArr[0].desc);
            }
            this.ijx.startLoad(dVarArr[1].pic, 30, false);
            a(this.ijx, dVarArr[1].iik);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.ijy.setVisibility(8);
            } else {
                this.ijy.setVisibility(0);
                this.ijy.setText(dVarArr[1].desc);
            }
            this.ijA.startLoad(dVarArr[2].pic, 30, false);
            a(this.ijA, dVarArr[2].iik);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.ijB.setVisibility(8);
            } else {
                this.ijB.setVisibility(0);
                this.ijB.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.ijD.setText(adCard.adSource);
            this.ijC.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bwL != null && !TextUtils.isEmpty(advertAppInfo.bwL.adSource)) {
            this.ijD.setText(advertAppInfo.bwL.adSource);
            this.ijC.setVisibility(0);
        } else {
            this.ijC.setVisibility(8);
        }
        this.iiA.setVisibility(0);
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
