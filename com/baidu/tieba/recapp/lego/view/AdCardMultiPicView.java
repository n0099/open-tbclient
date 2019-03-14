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
    protected RelativeLayout ijn;
    protected TbImageView ijo;
    protected TextView ijp;
    protected RelativeLayout ijq;
    protected TbImageView ijr;
    protected TextView ijs;
    protected RelativeLayout ijt;
    protected TbImageView iju;
    protected TextView ijv;
    protected View ijw;
    protected TextView ijx;

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
        this.ijn = (RelativeLayout) view.findViewById(d.g.rl_img_left);
        this.ijo = (TbImageView) view.findViewById(d.g.advert_app_img_left);
        this.ijp = (TextView) view.findViewById(d.g.txt_left);
        this.ijq = (RelativeLayout) view.findViewById(d.g.rl_img_center);
        this.ijr = (TbImageView) view.findViewById(d.g.advert_app_img_center);
        this.ijs = (TextView) view.findViewById(d.g.txt_center);
        this.ijt = (RelativeLayout) view.findViewById(d.g.rl_img_right);
        this.iju = (TbImageView) view.findViewById(d.g.advert_app_img_right);
        this.ijv = (TextView) view.findViewById(d.g.txt_right);
        this.ijx = (TextView) view.findViewById(d.g.advert_source_right);
        this.ijo.setRadius(this.mContext.getResources().getDimensionPixelSize(d.e.tbds20));
        this.ijo.setConrers(5);
        this.ijo.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.ijo.setBorderColor(0);
        this.iju.setRadius(this.mContext.getResources().getDimensionPixelSize(d.e.tbds20));
        this.iju.setConrers(10);
        this.iju.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.iju.setBorderColor(0);
        this.ijw = view.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iiu.setVisibility(8);
            return;
        }
        this.ijp.setVisibility(8);
        this.ijo.setVisibility(8);
        this.ijs.setVisibility(8);
        this.ijr.setVisibility(8);
        this.ijv.setVisibility(8);
        this.iju.setVisibility(8);
        a(this.ijo, dimensionPixelSize, dimensionPixelSize);
        a(this.ijr, dimensionPixelSize, dimensionPixelSize);
        a(this.iju, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.ijo.startLoad(dVarArr[0].pic, 30, false);
            this.ijo.setVisibility(0);
            a(this.ijo, dVarArr[0].iif);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijp.setVisibility(8);
            } else {
                this.ijp.setVisibility(0);
                this.ijp.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.ijo.startLoad(dVarArr[0].pic, 30, false);
            this.ijo.setVisibility(0);
            this.ijr.setVisibility(0);
            a(this.ijo, dVarArr[0].iif);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijp.setVisibility(8);
            } else {
                this.ijp.setVisibility(0);
                this.ijp.setText(dVarArr[0].desc);
            }
            this.ijr.startLoad(dVarArr[1].pic, 30, false);
            a(this.ijr, dVarArr[1].iif);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.ijs.setVisibility(8);
            } else {
                this.ijs.setVisibility(0);
                this.ijs.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.ijo.startLoad(dVarArr[0].pic, 30, false);
            this.ijo.setVisibility(0);
            this.ijr.setVisibility(0);
            this.iju.setVisibility(0);
            a(this.ijo, dVarArr[0].iif);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijp.setVisibility(8);
            } else {
                this.ijp.setVisibility(0);
                this.ijp.setText(dVarArr[0].desc);
            }
            this.ijr.startLoad(dVarArr[1].pic, 30, false);
            a(this.ijr, dVarArr[1].iif);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.ijs.setVisibility(8);
            } else {
                this.ijs.setVisibility(0);
                this.ijs.setText(dVarArr[1].desc);
            }
            this.iju.startLoad(dVarArr[2].pic, 30, false);
            a(this.iju, dVarArr[2].iif);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.ijv.setVisibility(8);
            } else {
                this.ijv.setVisibility(0);
                this.ijv.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.ijx.setText(adCard.adSource);
            this.ijw.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bwN != null && !TextUtils.isEmpty(advertAppInfo.bwN.adSource)) {
            this.ijx.setText(advertAppInfo.bwN.adSource);
            this.ijw.setVisibility(0);
        } else {
            this.ijw.setVisibility(8);
        }
        this.iiu.setVisibility(0);
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
