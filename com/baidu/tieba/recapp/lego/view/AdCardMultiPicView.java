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
    protected RelativeLayout iiZ;
    protected TbImageView ija;
    protected TextView ijb;
    protected RelativeLayout ijc;
    protected TbImageView ijd;
    protected TextView ije;
    protected RelativeLayout ijf;
    protected TbImageView ijg;
    protected TextView ijh;
    protected View iji;
    protected TextView ijj;

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
        this.iiZ = (RelativeLayout) view.findViewById(d.g.rl_img_left);
        this.ija = (TbImageView) view.findViewById(d.g.advert_app_img_left);
        this.ijb = (TextView) view.findViewById(d.g.txt_left);
        this.ijc = (RelativeLayout) view.findViewById(d.g.rl_img_center);
        this.ijd = (TbImageView) view.findViewById(d.g.advert_app_img_center);
        this.ije = (TextView) view.findViewById(d.g.txt_center);
        this.ijf = (RelativeLayout) view.findViewById(d.g.rl_img_right);
        this.ijg = (TbImageView) view.findViewById(d.g.advert_app_img_right);
        this.ijh = (TextView) view.findViewById(d.g.txt_right);
        this.ijj = (TextView) view.findViewById(d.g.advert_source_right);
        this.ija.setRadius(this.mContext.getResources().getDimensionPixelSize(d.e.tbds20));
        this.ija.setConrers(5);
        this.ija.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.ija.setBorderColor(0);
        this.ijg.setRadius(this.mContext.getResources().getDimensionPixelSize(d.e.tbds20));
        this.ijg.setConrers(10);
        this.ijg.setBorderWidth(this.mContext.getResources().getDimensionPixelSize(d.e.tbds1));
        this.ijg.setBorderColor(0);
        this.iji = view.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10) * 2)) / 3.0f);
        if (length <= 0) {
            this.iig.setVisibility(8);
            return;
        }
        this.ijb.setVisibility(8);
        this.ija.setVisibility(8);
        this.ije.setVisibility(8);
        this.ijd.setVisibility(8);
        this.ijh.setVisibility(8);
        this.ijg.setVisibility(8);
        a(this.ija, dimensionPixelSize, dimensionPixelSize);
        a(this.ijd, dimensionPixelSize, dimensionPixelSize);
        a(this.ijg, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.ija.startLoad(dVarArr[0].pic, 30, false);
            this.ija.setVisibility(0);
            a(this.ija, dVarArr[0].ihR);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijb.setVisibility(8);
            } else {
                this.ijb.setVisibility(0);
                this.ijb.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.ija.startLoad(dVarArr[0].pic, 30, false);
            this.ija.setVisibility(0);
            this.ijd.setVisibility(0);
            a(this.ija, dVarArr[0].ihR);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijb.setVisibility(8);
            } else {
                this.ijb.setVisibility(0);
                this.ijb.setText(dVarArr[0].desc);
            }
            this.ijd.startLoad(dVarArr[1].pic, 30, false);
            a(this.ijd, dVarArr[1].ihR);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.ije.setVisibility(8);
            } else {
                this.ije.setVisibility(0);
                this.ije.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.ija.startLoad(dVarArr[0].pic, 30, false);
            this.ija.setVisibility(0);
            this.ijd.setVisibility(0);
            this.ijg.setVisibility(0);
            a(this.ija, dVarArr[0].ihR);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.ijb.setVisibility(8);
            } else {
                this.ijb.setVisibility(0);
                this.ijb.setText(dVarArr[0].desc);
            }
            this.ijd.startLoad(dVarArr[1].pic, 30, false);
            a(this.ijd, dVarArr[1].ihR);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.ije.setVisibility(8);
            } else {
                this.ije.setVisibility(0);
                this.ije.setText(dVarArr[1].desc);
            }
            this.ijg.startLoad(dVarArr[2].pic, 30, false);
            a(this.ijg, dVarArr[2].ihR);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.ijh.setVisibility(8);
            } else {
                this.ijh.setVisibility(0);
                this.ijh.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.ijj.setText(adCard.adSource);
            this.iji.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.bwQ != null && !TextUtils.isEmpty(advertAppInfo.bwQ.adSource)) {
            this.ijj.setText(advertAppInfo.bwQ.adSource);
            this.iji.setVisibility(0);
        } else {
            this.iji.setVisibility(8);
        }
        this.iig.setVisibility(0);
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
