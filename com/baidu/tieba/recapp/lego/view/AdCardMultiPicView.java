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
    protected RelativeLayout ijA;
    protected TbImageView ijB;
    protected TextView ijC;
    protected View ijD;
    protected TextView ijE;
    protected RelativeLayout iju;
    protected TbImageView ijv;
    protected TextView ijw;
    protected RelativeLayout ijx;
    protected TbImageView ijy;
    protected TextView ijz;

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
        this.iju = (RelativeLayout) view.findViewById(d.g.rl_img_left);
        this.ijv = (TbImageView) view.findViewById(d.g.advert_app_img_left);
        this.ijw = (TextView) view.findViewById(d.g.txt_left);
        this.ijx = (RelativeLayout) view.findViewById(d.g.rl_img_center);
        this.ijy = (TbImageView) view.findViewById(d.g.advert_app_img_center);
        this.ijz = (TextView) view.findViewById(d.g.txt_center);
        this.ijA = (RelativeLayout) view.findViewById(d.g.rl_img_right);
        this.ijB = (TbImageView) view.findViewById(d.g.advert_app_img_right);
        this.ijC = (TextView) view.findViewById(d.g.txt_right);
        this.ijE = (TextView) view.findViewById(d.g.advert_source_right);
        this.ijv.setRadius(this.mContext.getResources().getDimensionPixelSize(d.e.tbds20));
        this.ijv.setConrers(5);
        this.ijv.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.ijv.setBorderColor(0);
        this.ijB.setRadius(this.mContext.getResources().getDimensionPixelSize(d.e.tbds20));
        this.ijB.setConrers(10);
        this.ijB.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.ijB.setBorderColor(0);
        this.ijD = view.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iiB.setVisibility(8);
            return;
        }
        this.ijw.setVisibility(8);
        this.ijv.setVisibility(8);
        this.ijz.setVisibility(8);
        this.ijy.setVisibility(8);
        this.ijC.setVisibility(8);
        this.ijB.setVisibility(8);
        a(this.ijv, dimensionPixelSize, dimensionPixelSize);
        a(this.ijy, dimensionPixelSize, dimensionPixelSize);
        a(this.ijB, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.ijv.startLoad(dVarArr[0].pic, 30, false);
            this.ijv.setVisibility(0);
            a(this.ijv, dVarArr[0].iil);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijw.setVisibility(8);
            } else {
                this.ijw.setVisibility(0);
                this.ijw.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.ijv.startLoad(dVarArr[0].pic, 30, false);
            this.ijv.setVisibility(0);
            this.ijy.setVisibility(0);
            a(this.ijv, dVarArr[0].iil);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijw.setVisibility(8);
            } else {
                this.ijw.setVisibility(0);
                this.ijw.setText(dVarArr[0].desc);
            }
            this.ijy.startLoad(dVarArr[1].pic, 30, false);
            a(this.ijy, dVarArr[1].iil);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.ijz.setVisibility(8);
            } else {
                this.ijz.setVisibility(0);
                this.ijz.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.ijv.startLoad(dVarArr[0].pic, 30, false);
            this.ijv.setVisibility(0);
            this.ijy.setVisibility(0);
            this.ijB.setVisibility(0);
            a(this.ijv, dVarArr[0].iil);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijw.setVisibility(8);
            } else {
                this.ijw.setVisibility(0);
                this.ijw.setText(dVarArr[0].desc);
            }
            this.ijy.startLoad(dVarArr[1].pic, 30, false);
            a(this.ijy, dVarArr[1].iil);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.ijz.setVisibility(8);
            } else {
                this.ijz.setVisibility(0);
                this.ijz.setText(dVarArr[1].desc);
            }
            this.ijB.startLoad(dVarArr[2].pic, 30, false);
            a(this.ijB, dVarArr[2].iil);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.ijC.setVisibility(8);
            } else {
                this.ijC.setVisibility(0);
                this.ijC.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.ijE.setText(adCard.adSource);
            this.ijD.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bwL != null && !TextUtils.isEmpty(advertAppInfo.bwL.adSource)) {
            this.ijE.setText(advertAppInfo.bwL.adSource);
            this.ijD.setVisibility(0);
        } else {
            this.ijD.setVisibility(8);
        }
        this.iiB.setVisibility(0);
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
