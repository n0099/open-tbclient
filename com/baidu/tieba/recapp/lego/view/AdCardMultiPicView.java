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
    protected RelativeLayout fZk;
    protected TbImageView fZl;
    protected TextView fZm;
    protected RelativeLayout fZn;
    protected TbImageView fZo;
    protected TextView fZp;
    protected RelativeLayout fZq;
    protected TbImageView fZr;
    protected TextView fZs;
    protected View fZt;
    protected TextView fZu;

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
        this.fZk = (RelativeLayout) view2.findViewById(d.g.rl_img_left);
        this.fZl = (TbImageView) view2.findViewById(d.g.advert_app_img_left);
        this.fZm = (TextView) view2.findViewById(d.g.txt_left);
        this.fZn = (RelativeLayout) view2.findViewById(d.g.rl_img_center);
        this.fZo = (TbImageView) view2.findViewById(d.g.advert_app_img_center);
        this.fZp = (TextView) view2.findViewById(d.g.txt_center);
        this.fZq = (RelativeLayout) view2.findViewById(d.g.rl_img_right);
        this.fZr = (TbImageView) view2.findViewById(d.g.advert_app_img_right);
        this.fZs = (TextView) view2.findViewById(d.g.txt_right);
        this.fZu = (TextView) view2.findViewById(d.g.advert_source_right);
        this.fZl.setDrawBorder(true);
        this.fZl.setBorderWidth(1);
        this.fZo.setDrawBorder(true);
        this.fZo.setBorderWidth(1);
        this.fZr.setDrawBorder(true);
        this.fZr.setBorderWidth(1);
        this.fZt = view2.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.fYs.setVisibility(8);
            return;
        }
        this.fZm.setVisibility(8);
        this.fZl.setVisibility(8);
        this.fZp.setVisibility(8);
        this.fZo.setVisibility(8);
        this.fZs.setVisibility(8);
        this.fZr.setVisibility(8);
        a(this.fZl, dimensionPixelSize, dimensionPixelSize);
        a(this.fZo, dimensionPixelSize, dimensionPixelSize);
        a(this.fZr, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.fZl.startLoad(dVarArr[0].pic, 30, false);
            this.fZl.setVisibility(0);
            a(this.fZl, dVarArr[0].fYc);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.fZm.setVisibility(8);
            } else {
                this.fZm.setVisibility(0);
                this.fZm.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.fZl.startLoad(dVarArr[0].pic, 30, false);
            this.fZl.setVisibility(0);
            this.fZo.setVisibility(0);
            a(this.fZl, dVarArr[0].fYc);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.fZm.setVisibility(8);
            } else {
                this.fZm.setVisibility(0);
                this.fZm.setText(dVarArr[0].desc);
            }
            this.fZo.startLoad(dVarArr[1].pic, 30, false);
            a(this.fZo, dVarArr[1].fYc);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.fZp.setVisibility(8);
            } else {
                this.fZp.setVisibility(0);
                this.fZp.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.fZl.startLoad(dVarArr[0].pic, 30, false);
            this.fZl.setVisibility(0);
            this.fZo.setVisibility(0);
            this.fZr.setVisibility(0);
            a(this.fZl, dVarArr[0].fYc);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.fZm.setVisibility(8);
            } else {
                this.fZm.setVisibility(0);
                this.fZm.setText(dVarArr[0].desc);
            }
            this.fZo.startLoad(dVarArr[1].pic, 30, false);
            a(this.fZo, dVarArr[1].fYc);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.fZp.setVisibility(8);
            } else {
                this.fZp.setVisibility(0);
                this.fZp.setText(dVarArr[1].desc);
            }
            this.fZr.startLoad(dVarArr[2].pic, 30, false);
            a(this.fZr, dVarArr[2].fYc);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.fZs.setVisibility(8);
            } else {
                this.fZs.setVisibility(0);
                this.fZs.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.fZu.setText(adCard.adSource);
            this.fZt.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.Wb != null && !TextUtils.isEmpty(advertAppInfo.Wb.adSource)) {
            this.fZu.setText(advertAppInfo.Wb.adSource);
            this.fZt.setVisibility(0);
        } else {
            this.fZt.setVisibility(8);
        }
        this.fYs.setVisibility(0);
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
