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
    protected RelativeLayout fZh;
    protected TbImageView fZi;
    protected TextView fZj;
    protected RelativeLayout fZk;
    protected TbImageView fZl;
    protected TextView fZm;
    protected RelativeLayout fZn;
    protected TbImageView fZo;
    protected TextView fZp;
    protected View fZq;
    protected TextView fZr;

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
    protected void br(View view2) {
        this.fZh = (RelativeLayout) view2.findViewById(d.g.rl_img_left);
        this.fZi = (TbImageView) view2.findViewById(d.g.advert_app_img_left);
        this.fZj = (TextView) view2.findViewById(d.g.txt_left);
        this.fZk = (RelativeLayout) view2.findViewById(d.g.rl_img_center);
        this.fZl = (TbImageView) view2.findViewById(d.g.advert_app_img_center);
        this.fZm = (TextView) view2.findViewById(d.g.txt_center);
        this.fZn = (RelativeLayout) view2.findViewById(d.g.rl_img_right);
        this.fZo = (TbImageView) view2.findViewById(d.g.advert_app_img_right);
        this.fZp = (TextView) view2.findViewById(d.g.txt_right);
        this.fZr = (TextView) view2.findViewById(d.g.advert_source_right);
        this.fZi.setDrawBorder(true);
        this.fZi.setBorderWidth(1);
        this.fZl.setDrawBorder(true);
        this.fZl.setBorderWidth(1);
        this.fZo.setDrawBorder(true);
        this.fZo.setBorderWidth(1);
        this.fZq = view2.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.fYp.setVisibility(8);
            return;
        }
        this.fZj.setVisibility(8);
        this.fZi.setVisibility(8);
        this.fZm.setVisibility(8);
        this.fZl.setVisibility(8);
        this.fZp.setVisibility(8);
        this.fZo.setVisibility(8);
        a(this.fZi, dimensionPixelSize, dimensionPixelSize);
        a(this.fZl, dimensionPixelSize, dimensionPixelSize);
        a(this.fZo, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.fZi.startLoad(dVarArr[0].pic, 30, false);
            this.fZi.setVisibility(0);
            a(this.fZi, dVarArr[0].fXZ);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.fZj.setVisibility(8);
            } else {
                this.fZj.setVisibility(0);
                this.fZj.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.fZi.startLoad(dVarArr[0].pic, 30, false);
            this.fZi.setVisibility(0);
            this.fZl.setVisibility(0);
            a(this.fZi, dVarArr[0].fXZ);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.fZj.setVisibility(8);
            } else {
                this.fZj.setVisibility(0);
                this.fZj.setText(dVarArr[0].desc);
            }
            this.fZl.startLoad(dVarArr[1].pic, 30, false);
            a(this.fZl, dVarArr[1].fXZ);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.fZm.setVisibility(8);
            } else {
                this.fZm.setVisibility(0);
                this.fZm.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.fZi.startLoad(dVarArr[0].pic, 30, false);
            this.fZi.setVisibility(0);
            this.fZl.setVisibility(0);
            this.fZo.setVisibility(0);
            a(this.fZi, dVarArr[0].fXZ);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.fZj.setVisibility(8);
            } else {
                this.fZj.setVisibility(0);
                this.fZj.setText(dVarArr[0].desc);
            }
            this.fZl.startLoad(dVarArr[1].pic, 30, false);
            a(this.fZl, dVarArr[1].fXZ);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.fZm.setVisibility(8);
            } else {
                this.fZm.setVisibility(0);
                this.fZm.setText(dVarArr[1].desc);
            }
            this.fZo.startLoad(dVarArr[2].pic, 30, false);
            a(this.fZo, dVarArr[2].fXZ);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.fZp.setVisibility(8);
            } else {
                this.fZp.setVisibility(0);
                this.fZp.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.fZr.setText(adCard.adSource);
            this.fZq.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.Wb != null && !TextUtils.isEmpty(advertAppInfo.Wb.adSource)) {
            this.fZr.setText(advertAppInfo.Wb.adSource);
            this.fZq.setVisibility(0);
        } else {
            this.fZq.setVisibility(8);
        }
        this.fYp.setVisibility(0);
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
