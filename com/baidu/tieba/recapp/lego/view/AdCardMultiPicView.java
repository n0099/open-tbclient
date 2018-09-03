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
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.lego.model.AdCard;
/* loaded from: classes3.dex */
public class AdCardMultiPicView extends AdCardBaseView {
    protected RelativeLayout gqJ;
    protected TbImageView gqK;
    protected TextView gqL;
    protected RelativeLayout gqM;
    protected TbImageView gqN;
    protected TextView gqO;
    protected RelativeLayout gqP;
    protected TbImageView gqQ;
    protected TextView gqR;
    protected View gqS;
    protected TextView gqT;

    public AdCardMultiPicView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getLayout() {
        return f.h.card_ad;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected int getCustomLayout() {
        return f.h.card_ad_multi_pic;
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void by(View view) {
        this.gqJ = (RelativeLayout) view.findViewById(f.g.rl_img_left);
        this.gqK = (TbImageView) view.findViewById(f.g.advert_app_img_left);
        this.gqL = (TextView) view.findViewById(f.g.txt_left);
        this.gqM = (RelativeLayout) view.findViewById(f.g.rl_img_center);
        this.gqN = (TbImageView) view.findViewById(f.g.advert_app_img_center);
        this.gqO = (TextView) view.findViewById(f.g.txt_center);
        this.gqP = (RelativeLayout) view.findViewById(f.g.rl_img_right);
        this.gqQ = (TbImageView) view.findViewById(f.g.advert_app_img_right);
        this.gqR = (TextView) view.findViewById(f.g.txt_right);
        this.gqT = (TextView) view.findViewById(f.g.advert_source_right);
        this.gqK.setDrawBorder(true);
        this.gqK.setBorderWidth(1);
        this.gqN.setDrawBorder(true);
        this.gqN.setBorderWidth(1);
        this.gqQ.setDrawBorder(true);
        this.gqQ.setBorderWidth(1);
        this.gqS = view.findViewById(f.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gpQ.setVisibility(8);
            return;
        }
        this.gqL.setVisibility(8);
        this.gqK.setVisibility(8);
        this.gqO.setVisibility(8);
        this.gqN.setVisibility(8);
        this.gqR.setVisibility(8);
        this.gqQ.setVisibility(8);
        a(this.gqK, dimensionPixelSize, dimensionPixelSize);
        a(this.gqN, dimensionPixelSize, dimensionPixelSize);
        a(this.gqQ, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gqK.startLoad(dVarArr[0].pic, 30, false);
            this.gqK.setVisibility(0);
            a(this.gqK, dVarArr[0].gpA);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gqL.setVisibility(8);
            } else {
                this.gqL.setVisibility(0);
                this.gqL.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gqK.startLoad(dVarArr[0].pic, 30, false);
            this.gqK.setVisibility(0);
            this.gqN.setVisibility(0);
            a(this.gqK, dVarArr[0].gpA);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gqL.setVisibility(8);
            } else {
                this.gqL.setVisibility(0);
                this.gqL.setText(dVarArr[0].desc);
            }
            this.gqN.startLoad(dVarArr[1].pic, 30, false);
            a(this.gqN, dVarArr[1].gpA);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gqO.setVisibility(8);
            } else {
                this.gqO.setVisibility(0);
                this.gqO.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gqK.startLoad(dVarArr[0].pic, 30, false);
            this.gqK.setVisibility(0);
            this.gqN.setVisibility(0);
            this.gqQ.setVisibility(0);
            a(this.gqK, dVarArr[0].gpA);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gqL.setVisibility(8);
            } else {
                this.gqL.setVisibility(0);
                this.gqL.setText(dVarArr[0].desc);
            }
            this.gqN.startLoad(dVarArr[1].pic, 30, false);
            a(this.gqN, dVarArr[1].gpA);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gqO.setVisibility(8);
            } else {
                this.gqO.setVisibility(0);
                this.gqO.setText(dVarArr[1].desc);
            }
            this.gqQ.startLoad(dVarArr[2].pic, 30, false);
            a(this.gqQ, dVarArr[2].gpA);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.gqR.setVisibility(8);
            } else {
                this.gqR.setVisibility(0);
                this.gqR.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gqT.setText(adCard.adSource);
            this.gqS.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.adQ != null && !TextUtils.isEmpty(advertAppInfo.adQ.adSource)) {
            this.gqT.setText(advertAppInfo.adQ.adSource);
            this.gqS.setVisibility(0);
        } else {
            this.gqS.setVisibility(8);
        }
        this.gpQ.setVisibility(0);
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
