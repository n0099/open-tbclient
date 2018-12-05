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
    protected RelativeLayout gNT;
    protected TbImageView gNU;
    protected TextView gNV;
    protected RelativeLayout gNW;
    protected TbImageView gNX;
    protected TextView gNY;
    protected RelativeLayout gNZ;
    protected TbImageView gOa;
    protected TextView gOb;
    protected View gOc;
    protected TextView gOd;

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
        this.gNT = (RelativeLayout) view.findViewById(e.g.rl_img_left);
        this.gNU = (TbImageView) view.findViewById(e.g.advert_app_img_left);
        this.gNV = (TextView) view.findViewById(e.g.txt_left);
        this.gNW = (RelativeLayout) view.findViewById(e.g.rl_img_center);
        this.gNX = (TbImageView) view.findViewById(e.g.advert_app_img_center);
        this.gNY = (TextView) view.findViewById(e.g.txt_center);
        this.gNZ = (RelativeLayout) view.findViewById(e.g.rl_img_right);
        this.gOa = (TbImageView) view.findViewById(e.g.advert_app_img_right);
        this.gOb = (TextView) view.findViewById(e.g.txt_right);
        this.gOd = (TextView) view.findViewById(e.g.advert_source_right);
        this.gNU.setDrawBorder(true);
        this.gNU.setBorderWidth(1);
        this.gNX.setDrawBorder(true);
        this.gNX.setBorderWidth(1);
        this.gOa.setDrawBorder(true);
        this.gOa.setBorderWidth(1);
        this.gOc = view.findViewById(e.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gNa.setVisibility(8);
            return;
        }
        this.gNV.setVisibility(8);
        this.gNU.setVisibility(8);
        this.gNY.setVisibility(8);
        this.gNX.setVisibility(8);
        this.gOb.setVisibility(8);
        this.gOa.setVisibility(8);
        a(this.gNU, dimensionPixelSize, dimensionPixelSize);
        a(this.gNX, dimensionPixelSize, dimensionPixelSize);
        a(this.gOa, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gNU.startLoad(dVarArr[0].pic, 30, false);
            this.gNU.setVisibility(0);
            a(this.gNU, dVarArr[0].gMK);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gNV.setVisibility(8);
            } else {
                this.gNV.setVisibility(0);
                this.gNV.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gNU.startLoad(dVarArr[0].pic, 30, false);
            this.gNU.setVisibility(0);
            this.gNX.setVisibility(0);
            a(this.gNU, dVarArr[0].gMK);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gNV.setVisibility(8);
            } else {
                this.gNV.setVisibility(0);
                this.gNV.setText(dVarArr[0].desc);
            }
            this.gNX.startLoad(dVarArr[1].pic, 30, false);
            a(this.gNX, dVarArr[1].gMK);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gNY.setVisibility(8);
            } else {
                this.gNY.setVisibility(0);
                this.gNY.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gNU.startLoad(dVarArr[0].pic, 30, false);
            this.gNU.setVisibility(0);
            this.gNX.setVisibility(0);
            this.gOa.setVisibility(0);
            a(this.gNU, dVarArr[0].gMK);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gNV.setVisibility(8);
            } else {
                this.gNV.setVisibility(0);
                this.gNV.setText(dVarArr[0].desc);
            }
            this.gNX.startLoad(dVarArr[1].pic, 30, false);
            a(this.gNX, dVarArr[1].gMK);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gNY.setVisibility(8);
            } else {
                this.gNY.setVisibility(0);
                this.gNY.setText(dVarArr[1].desc);
            }
            this.gOa.startLoad(dVarArr[2].pic, 30, false);
            a(this.gOa, dVarArr[2].gMK);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.gOb.setVisibility(8);
            } else {
                this.gOb.setVisibility(0);
                this.gOb.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gOd.setText(adCard.adSource);
            this.gOc.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.apB != null && !TextUtils.isEmpty(advertAppInfo.apB.adSource)) {
            this.gOd.setText(advertAppInfo.apB.adSource);
            this.gOc.setVisibility(0);
        } else {
            this.gOc.setVisibility(8);
        }
        this.gNa.setVisibility(0);
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
