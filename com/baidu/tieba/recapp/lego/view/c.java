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
public class c extends a {
    protected RelativeLayout gEh;
    protected TbImageView gEi;
    protected TextView gEj;
    protected RelativeLayout gEk;
    protected TbImageView gEl;
    protected TextView gEm;
    protected RelativeLayout gEn;
    protected TbImageView gEo;
    protected TextView gEp;
    protected View gEq;
    protected TextView gEr;

    public c(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getLayout() {
        return d.h.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected int getCustomLayout() {
        return d.h.card_ad_multi_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void cL(View view) {
        this.gEh = (RelativeLayout) view.findViewById(d.g.rl_img_left);
        this.gEi = (TbImageView) view.findViewById(d.g.advert_app_img_left);
        this.gEj = (TextView) view.findViewById(d.g.txt_left);
        this.gEk = (RelativeLayout) view.findViewById(d.g.rl_img_center);
        this.gEl = (TbImageView) view.findViewById(d.g.advert_app_img_center);
        this.gEm = (TextView) view.findViewById(d.g.txt_center);
        this.gEn = (RelativeLayout) view.findViewById(d.g.rl_img_right);
        this.gEo = (TbImageView) view.findViewById(d.g.advert_app_img_right);
        this.gEp = (TextView) view.findViewById(d.g.txt_right);
        this.gEr = (TextView) view.findViewById(d.g.advert_source_right);
        this.gEi.setDrawBorder(true);
        this.gEi.setBorderWidth(1);
        this.gEl.setDrawBorder(true);
        this.gEl.setBorderWidth(1);
        this.gEo.setDrawBorder(true);
        this.gEo.setBorderWidth(1);
        this.gEq = view.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.a
    protected void a(AdCard adCard) {
        AdCard.c[] cVarArr = adCard.threadPicList;
        int length = cVarArr != null ? cVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gDp.setVisibility(8);
            return;
        }
        this.gEj.setVisibility(8);
        this.gEi.setVisibility(8);
        this.gEm.setVisibility(8);
        this.gEl.setVisibility(8);
        this.gEp.setVisibility(8);
        this.gEo.setVisibility(8);
        a(this.gEi, dimensionPixelSize, dimensionPixelSize);
        a(this.gEl, dimensionPixelSize, dimensionPixelSize);
        a(this.gEo, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gEi.startLoad(cVarArr[0].pic, 30, false);
            this.gEi.setVisibility(0);
            a(this.gEi, cVarArr[0].gCX);
            if (StringUtils.isNull(cVarArr[0].desc, true)) {
                this.gEj.setVisibility(8);
            } else {
                this.gEj.setVisibility(0);
                this.gEj.setText(cVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gEi.startLoad(cVarArr[0].pic, 30, false);
            this.gEi.setVisibility(0);
            this.gEl.setVisibility(0);
            a(this.gEi, cVarArr[0].gCX);
            if (StringUtils.isNull(cVarArr[0].desc, true)) {
                this.gEj.setVisibility(8);
            } else {
                this.gEj.setVisibility(0);
                this.gEj.setText(cVarArr[0].desc);
            }
            this.gEl.startLoad(cVarArr[1].pic, 30, false);
            a(this.gEl, cVarArr[1].gCX);
            if (StringUtils.isNull(cVarArr[1].desc, true)) {
                this.gEm.setVisibility(8);
            } else {
                this.gEm.setVisibility(0);
                this.gEm.setText(cVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gEi.startLoad(cVarArr[0].pic, 30, false);
            this.gEi.setVisibility(0);
            this.gEl.setVisibility(0);
            this.gEo.setVisibility(0);
            a(this.gEi, cVarArr[0].gCX);
            if (StringUtils.isNull(cVarArr[0].desc, true)) {
                this.gEj.setVisibility(8);
            } else {
                this.gEj.setVisibility(0);
                this.gEj.setText(cVarArr[0].desc);
            }
            this.gEl.startLoad(cVarArr[1].pic, 30, false);
            a(this.gEl, cVarArr[1].gCX);
            if (StringUtils.isNull(cVarArr[1].desc, true)) {
                this.gEm.setVisibility(8);
            } else {
                this.gEm.setVisibility(0);
                this.gEm.setText(cVarArr[1].desc);
            }
            this.gEo.startLoad(cVarArr[2].pic, 30, false);
            a(this.gEo, cVarArr[2].gCX);
            if (StringUtils.isNull(cVarArr[2].desc, true)) {
                this.gEp.setVisibility(8);
            } else {
                this.gEp.setVisibility(0);
                this.gEp.setText(cVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gEr.setText(adCard.adSource);
            this.gEq.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.aKG != null && !TextUtils.isEmpty(advertAppInfo.aKG.adSource)) {
            this.gEr.setText(advertAppInfo.aKG.adSource);
            this.gEq.setVisibility(0);
        } else {
            this.gEq.setVisibility(8);
        }
        this.gDp.setVisibility(0);
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
