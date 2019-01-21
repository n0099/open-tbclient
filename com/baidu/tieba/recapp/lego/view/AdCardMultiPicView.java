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
    protected RelativeLayout gRP;
    protected TbImageView gRQ;
    protected TextView gRR;
    protected RelativeLayout gRS;
    protected TbImageView gRT;
    protected TextView gRU;
    protected RelativeLayout gRV;
    protected TbImageView gRW;
    protected TextView gRX;
    protected View gRY;
    protected TextView gRZ;

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
    protected void bQ(View view) {
        this.gRP = (RelativeLayout) view.findViewById(e.g.rl_img_left);
        this.gRQ = (TbImageView) view.findViewById(e.g.advert_app_img_left);
        this.gRR = (TextView) view.findViewById(e.g.txt_left);
        this.gRS = (RelativeLayout) view.findViewById(e.g.rl_img_center);
        this.gRT = (TbImageView) view.findViewById(e.g.advert_app_img_center);
        this.gRU = (TextView) view.findViewById(e.g.txt_center);
        this.gRV = (RelativeLayout) view.findViewById(e.g.rl_img_right);
        this.gRW = (TbImageView) view.findViewById(e.g.advert_app_img_right);
        this.gRX = (TextView) view.findViewById(e.g.txt_right);
        this.gRZ = (TextView) view.findViewById(e.g.advert_source_right);
        this.gRQ.setDrawBorder(true);
        this.gRQ.setBorderWidth(1);
        this.gRT.setDrawBorder(true);
        this.gRT.setBorderWidth(1);
        this.gRW.setDrawBorder(true);
        this.gRW.setBorderWidth(1);
        this.gRY = view.findViewById(e.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gQW.setVisibility(8);
            return;
        }
        this.gRR.setVisibility(8);
        this.gRQ.setVisibility(8);
        this.gRU.setVisibility(8);
        this.gRT.setVisibility(8);
        this.gRX.setVisibility(8);
        this.gRW.setVisibility(8);
        a(this.gRQ, dimensionPixelSize, dimensionPixelSize);
        a(this.gRT, dimensionPixelSize, dimensionPixelSize);
        a(this.gRW, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gRQ.startLoad(dVarArr[0].pic, 30, false);
            this.gRQ.setVisibility(0);
            a(this.gRQ, dVarArr[0].gQG);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gRR.setVisibility(8);
            } else {
                this.gRR.setVisibility(0);
                this.gRR.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gRQ.startLoad(dVarArr[0].pic, 30, false);
            this.gRQ.setVisibility(0);
            this.gRT.setVisibility(0);
            a(this.gRQ, dVarArr[0].gQG);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gRR.setVisibility(8);
            } else {
                this.gRR.setVisibility(0);
                this.gRR.setText(dVarArr[0].desc);
            }
            this.gRT.startLoad(dVarArr[1].pic, 30, false);
            a(this.gRT, dVarArr[1].gQG);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gRU.setVisibility(8);
            } else {
                this.gRU.setVisibility(0);
                this.gRU.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gRQ.startLoad(dVarArr[0].pic, 30, false);
            this.gRQ.setVisibility(0);
            this.gRT.setVisibility(0);
            this.gRW.setVisibility(0);
            a(this.gRQ, dVarArr[0].gQG);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gRR.setVisibility(8);
            } else {
                this.gRR.setVisibility(0);
                this.gRR.setText(dVarArr[0].desc);
            }
            this.gRT.startLoad(dVarArr[1].pic, 30, false);
            a(this.gRT, dVarArr[1].gQG);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gRU.setVisibility(8);
            } else {
                this.gRU.setVisibility(0);
                this.gRU.setText(dVarArr[1].desc);
            }
            this.gRW.startLoad(dVarArr[2].pic, 30, false);
            a(this.gRW, dVarArr[2].gQG);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.gRX.setVisibility(8);
            } else {
                this.gRX.setVisibility(0);
                this.gRX.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gRZ.setText(adCard.adSource);
            this.gRY.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.aqe != null && !TextUtils.isEmpty(advertAppInfo.aqe.adSource)) {
            this.gRZ.setText(advertAppInfo.aqe.adSource);
            this.gRY.setVisibility(0);
        } else {
            this.gRY.setVisibility(8);
        }
        this.gQW.setVisibility(0);
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
