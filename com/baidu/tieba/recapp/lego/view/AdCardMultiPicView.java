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
    protected RelativeLayout ija;
    protected TbImageView ijb;
    protected TextView ijc;
    protected RelativeLayout ijd;
    protected TbImageView ije;
    protected TextView ijf;
    protected RelativeLayout ijg;
    protected TbImageView ijh;
    protected TextView iji;
    protected View ijj;
    protected TextView ijk;

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
        this.ija = (RelativeLayout) view.findViewById(d.g.rl_img_left);
        this.ijb = (TbImageView) view.findViewById(d.g.advert_app_img_left);
        this.ijc = (TextView) view.findViewById(d.g.txt_left);
        this.ijd = (RelativeLayout) view.findViewById(d.g.rl_img_center);
        this.ije = (TbImageView) view.findViewById(d.g.advert_app_img_center);
        this.ijf = (TextView) view.findViewById(d.g.txt_center);
        this.ijg = (RelativeLayout) view.findViewById(d.g.rl_img_right);
        this.ijh = (TbImageView) view.findViewById(d.g.advert_app_img_right);
        this.iji = (TextView) view.findViewById(d.g.txt_right);
        this.ijk = (TextView) view.findViewById(d.g.advert_source_right);
        this.ijb.setRadius(this.mContext.getResources().getDimensionPixelSize(d.e.tbds20));
        this.ijb.setConrers(5);
        this.ijb.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.ijb.setBorderColor(0);
        this.ijh.setRadius(this.mContext.getResources().getDimensionPixelSize(d.e.tbds20));
        this.ijh.setConrers(10);
        this.ijh.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.ijh.setBorderColor(0);
        this.ijj = view.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iih.setVisibility(8);
            return;
        }
        this.ijc.setVisibility(8);
        this.ijb.setVisibility(8);
        this.ijf.setVisibility(8);
        this.ije.setVisibility(8);
        this.iji.setVisibility(8);
        this.ijh.setVisibility(8);
        a(this.ijb, dimensionPixelSize, dimensionPixelSize);
        a(this.ije, dimensionPixelSize, dimensionPixelSize);
        a(this.ijh, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.ijb.startLoad(dVarArr[0].pic, 30, false);
            this.ijb.setVisibility(0);
            a(this.ijb, dVarArr[0].ihS);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijc.setVisibility(8);
            } else {
                this.ijc.setVisibility(0);
                this.ijc.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.ijb.startLoad(dVarArr[0].pic, 30, false);
            this.ijb.setVisibility(0);
            this.ije.setVisibility(0);
            a(this.ijb, dVarArr[0].ihS);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijc.setVisibility(8);
            } else {
                this.ijc.setVisibility(0);
                this.ijc.setText(dVarArr[0].desc);
            }
            this.ije.startLoad(dVarArr[1].pic, 30, false);
            a(this.ije, dVarArr[1].ihS);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.ijf.setVisibility(8);
            } else {
                this.ijf.setVisibility(0);
                this.ijf.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.ijb.startLoad(dVarArr[0].pic, 30, false);
            this.ijb.setVisibility(0);
            this.ije.setVisibility(0);
            this.ijh.setVisibility(0);
            a(this.ijb, dVarArr[0].ihS);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijc.setVisibility(8);
            } else {
                this.ijc.setVisibility(0);
                this.ijc.setText(dVarArr[0].desc);
            }
            this.ije.startLoad(dVarArr[1].pic, 30, false);
            a(this.ije, dVarArr[1].ihS);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.ijf.setVisibility(8);
            } else {
                this.ijf.setVisibility(0);
                this.ijf.setText(dVarArr[1].desc);
            }
            this.ijh.startLoad(dVarArr[2].pic, 30, false);
            a(this.ijh, dVarArr[2].ihS);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.iji.setVisibility(8);
            } else {
                this.iji.setVisibility(0);
                this.iji.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.ijk.setText(adCard.adSource);
            this.ijj.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bwR != null && !TextUtils.isEmpty(advertAppInfo.bwR.adSource)) {
            this.ijk.setText(advertAppInfo.bwR.adSource);
            this.ijj.setVisibility(0);
        } else {
            this.ijj.setVisibility(8);
        }
        this.iih.setVisibility(0);
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
