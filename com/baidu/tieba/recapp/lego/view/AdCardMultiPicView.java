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
    protected RelativeLayout gan;
    protected TbImageView gao;
    protected TextView gap;
    protected RelativeLayout gaq;
    protected TbImageView gar;
    protected TextView gas;
    protected RelativeLayout gat;
    protected TbImageView gau;
    protected TextView gav;
    protected View gaw;
    protected TextView gax;

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
        this.gan = (RelativeLayout) view2.findViewById(d.g.rl_img_left);
        this.gao = (TbImageView) view2.findViewById(d.g.advert_app_img_left);
        this.gap = (TextView) view2.findViewById(d.g.txt_left);
        this.gaq = (RelativeLayout) view2.findViewById(d.g.rl_img_center);
        this.gar = (TbImageView) view2.findViewById(d.g.advert_app_img_center);
        this.gas = (TextView) view2.findViewById(d.g.txt_center);
        this.gat = (RelativeLayout) view2.findViewById(d.g.rl_img_right);
        this.gau = (TbImageView) view2.findViewById(d.g.advert_app_img_right);
        this.gav = (TextView) view2.findViewById(d.g.txt_right);
        this.gax = (TextView) view2.findViewById(d.g.advert_source_right);
        this.gao.setDrawBorder(true);
        this.gao.setBorderWidth(1);
        this.gar.setDrawBorder(true);
        this.gar.setBorderWidth(1);
        this.gau.setDrawBorder(true);
        this.gau.setBorderWidth(1);
        this.gaw = view2.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.fZv.setVisibility(8);
            return;
        }
        this.gap.setVisibility(8);
        this.gao.setVisibility(8);
        this.gas.setVisibility(8);
        this.gar.setVisibility(8);
        this.gav.setVisibility(8);
        this.gau.setVisibility(8);
        a(this.gao, dimensionPixelSize, dimensionPixelSize);
        a(this.gar, dimensionPixelSize, dimensionPixelSize);
        a(this.gau, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gao.startLoad(dVarArr[0].pic, 30, false);
            this.gao.setVisibility(0);
            a(this.gao, dVarArr[0].fZf);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gap.setVisibility(8);
            } else {
                this.gap.setVisibility(0);
                this.gap.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gao.startLoad(dVarArr[0].pic, 30, false);
            this.gao.setVisibility(0);
            this.gar.setVisibility(0);
            a(this.gao, dVarArr[0].fZf);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gap.setVisibility(8);
            } else {
                this.gap.setVisibility(0);
                this.gap.setText(dVarArr[0].desc);
            }
            this.gar.startLoad(dVarArr[1].pic, 30, false);
            a(this.gar, dVarArr[1].fZf);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gas.setVisibility(8);
            } else {
                this.gas.setVisibility(0);
                this.gas.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gao.startLoad(dVarArr[0].pic, 30, false);
            this.gao.setVisibility(0);
            this.gar.setVisibility(0);
            this.gau.setVisibility(0);
            a(this.gao, dVarArr[0].fZf);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gap.setVisibility(8);
            } else {
                this.gap.setVisibility(0);
                this.gap.setText(dVarArr[0].desc);
            }
            this.gar.startLoad(dVarArr[1].pic, 30, false);
            a(this.gar, dVarArr[1].fZf);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gas.setVisibility(8);
            } else {
                this.gas.setVisibility(0);
                this.gas.setText(dVarArr[1].desc);
            }
            this.gau.startLoad(dVarArr[2].pic, 30, false);
            a(this.gau, dVarArr[2].fZf);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.gav.setVisibility(8);
            } else {
                this.gav.setVisibility(0);
                this.gav.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gax.setText(adCard.adSource);
            this.gaw.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.VX != null && !TextUtils.isEmpty(advertAppInfo.VX.adSource)) {
            this.gax.setText(advertAppInfo.VX.adSource);
            this.gaw.setVisibility(0);
        } else {
            this.gaw.setVisibility(8);
        }
        this.fZv.setVisibility(0);
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
