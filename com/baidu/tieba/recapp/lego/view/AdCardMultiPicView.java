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
    protected RelativeLayout gyb;
    protected TbImageView gyc;
    protected TextView gyd;
    protected RelativeLayout gye;
    protected TbImageView gyf;
    protected TextView gyg;
    protected RelativeLayout gyh;
    protected TbImageView gyi;
    protected TextView gyj;
    protected View gyk;
    protected TextView gyl;

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
    protected void bL(View view) {
        this.gyb = (RelativeLayout) view.findViewById(e.g.rl_img_left);
        this.gyc = (TbImageView) view.findViewById(e.g.advert_app_img_left);
        this.gyd = (TextView) view.findViewById(e.g.txt_left);
        this.gye = (RelativeLayout) view.findViewById(e.g.rl_img_center);
        this.gyf = (TbImageView) view.findViewById(e.g.advert_app_img_center);
        this.gyg = (TextView) view.findViewById(e.g.txt_center);
        this.gyh = (RelativeLayout) view.findViewById(e.g.rl_img_right);
        this.gyi = (TbImageView) view.findViewById(e.g.advert_app_img_right);
        this.gyj = (TextView) view.findViewById(e.g.txt_right);
        this.gyl = (TextView) view.findViewById(e.g.advert_source_right);
        this.gyc.setDrawBorder(true);
        this.gyc.setBorderWidth(1);
        this.gyf.setDrawBorder(true);
        this.gyf.setBorderWidth(1);
        this.gyi.setDrawBorder(true);
        this.gyi.setBorderWidth(1);
        this.gyk = view.findViewById(e.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0141e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gxi.setVisibility(8);
            return;
        }
        this.gyd.setVisibility(8);
        this.gyc.setVisibility(8);
        this.gyg.setVisibility(8);
        this.gyf.setVisibility(8);
        this.gyj.setVisibility(8);
        this.gyi.setVisibility(8);
        a(this.gyc, dimensionPixelSize, dimensionPixelSize);
        a(this.gyf, dimensionPixelSize, dimensionPixelSize);
        a(this.gyi, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gyc.startLoad(dVarArr[0].pic, 30, false);
            this.gyc.setVisibility(0);
            a(this.gyc, dVarArr[0].gwS);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gyd.setVisibility(8);
            } else {
                this.gyd.setVisibility(0);
                this.gyd.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gyc.startLoad(dVarArr[0].pic, 30, false);
            this.gyc.setVisibility(0);
            this.gyf.setVisibility(0);
            a(this.gyc, dVarArr[0].gwS);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gyd.setVisibility(8);
            } else {
                this.gyd.setVisibility(0);
                this.gyd.setText(dVarArr[0].desc);
            }
            this.gyf.startLoad(dVarArr[1].pic, 30, false);
            a(this.gyf, dVarArr[1].gwS);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gyg.setVisibility(8);
            } else {
                this.gyg.setVisibility(0);
                this.gyg.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gyc.startLoad(dVarArr[0].pic, 30, false);
            this.gyc.setVisibility(0);
            this.gyf.setVisibility(0);
            this.gyi.setVisibility(0);
            a(this.gyc, dVarArr[0].gwS);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gyd.setVisibility(8);
            } else {
                this.gyd.setVisibility(0);
                this.gyd.setText(dVarArr[0].desc);
            }
            this.gyf.startLoad(dVarArr[1].pic, 30, false);
            a(this.gyf, dVarArr[1].gwS);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gyg.setVisibility(8);
            } else {
                this.gyg.setVisibility(0);
                this.gyg.setText(dVarArr[1].desc);
            }
            this.gyi.startLoad(dVarArr[2].pic, 30, false);
            a(this.gyi, dVarArr[2].gwS);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.gyj.setVisibility(8);
            } else {
                this.gyj.setVisibility(0);
                this.gyj.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gyl.setText(adCard.adSource);
            this.gyk.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.agr != null && !TextUtils.isEmpty(advertAppInfo.agr.adSource)) {
            this.gyl.setText(advertAppInfo.agr.adSource);
            this.gyk.setVisibility(0);
        } else {
            this.gyk.setVisibility(8);
        }
        this.gxi.setVisibility(0);
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
