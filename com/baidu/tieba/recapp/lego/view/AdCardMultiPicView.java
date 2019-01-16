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
    protected RelativeLayout gRO;
    protected TbImageView gRP;
    protected TextView gRQ;
    protected RelativeLayout gRR;
    protected TbImageView gRS;
    protected TextView gRT;
    protected RelativeLayout gRU;
    protected TbImageView gRV;
    protected TextView gRW;
    protected View gRX;
    protected TextView gRY;

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
        this.gRO = (RelativeLayout) view.findViewById(e.g.rl_img_left);
        this.gRP = (TbImageView) view.findViewById(e.g.advert_app_img_left);
        this.gRQ = (TextView) view.findViewById(e.g.txt_left);
        this.gRR = (RelativeLayout) view.findViewById(e.g.rl_img_center);
        this.gRS = (TbImageView) view.findViewById(e.g.advert_app_img_center);
        this.gRT = (TextView) view.findViewById(e.g.txt_center);
        this.gRU = (RelativeLayout) view.findViewById(e.g.rl_img_right);
        this.gRV = (TbImageView) view.findViewById(e.g.advert_app_img_right);
        this.gRW = (TextView) view.findViewById(e.g.txt_right);
        this.gRY = (TextView) view.findViewById(e.g.advert_source_right);
        this.gRP.setDrawBorder(true);
        this.gRP.setBorderWidth(1);
        this.gRS.setDrawBorder(true);
        this.gRS.setBorderWidth(1);
        this.gRV.setDrawBorder(true);
        this.gRV.setBorderWidth(1);
        this.gRX = view.findViewById(e.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0210e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gQV.setVisibility(8);
            return;
        }
        this.gRQ.setVisibility(8);
        this.gRP.setVisibility(8);
        this.gRT.setVisibility(8);
        this.gRS.setVisibility(8);
        this.gRW.setVisibility(8);
        this.gRV.setVisibility(8);
        a(this.gRP, dimensionPixelSize, dimensionPixelSize);
        a(this.gRS, dimensionPixelSize, dimensionPixelSize);
        a(this.gRV, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gRP.startLoad(dVarArr[0].pic, 30, false);
            this.gRP.setVisibility(0);
            a(this.gRP, dVarArr[0].gQF);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gRQ.setVisibility(8);
            } else {
                this.gRQ.setVisibility(0);
                this.gRQ.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gRP.startLoad(dVarArr[0].pic, 30, false);
            this.gRP.setVisibility(0);
            this.gRS.setVisibility(0);
            a(this.gRP, dVarArr[0].gQF);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gRQ.setVisibility(8);
            } else {
                this.gRQ.setVisibility(0);
                this.gRQ.setText(dVarArr[0].desc);
            }
            this.gRS.startLoad(dVarArr[1].pic, 30, false);
            a(this.gRS, dVarArr[1].gQF);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gRT.setVisibility(8);
            } else {
                this.gRT.setVisibility(0);
                this.gRT.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gRP.startLoad(dVarArr[0].pic, 30, false);
            this.gRP.setVisibility(0);
            this.gRS.setVisibility(0);
            this.gRV.setVisibility(0);
            a(this.gRP, dVarArr[0].gQF);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gRQ.setVisibility(8);
            } else {
                this.gRQ.setVisibility(0);
                this.gRQ.setText(dVarArr[0].desc);
            }
            this.gRS.startLoad(dVarArr[1].pic, 30, false);
            a(this.gRS, dVarArr[1].gQF);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gRT.setVisibility(8);
            } else {
                this.gRT.setVisibility(0);
                this.gRT.setText(dVarArr[1].desc);
            }
            this.gRV.startLoad(dVarArr[2].pic, 30, false);
            a(this.gRV, dVarArr[2].gQF);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.gRW.setVisibility(8);
            } else {
                this.gRW.setVisibility(0);
                this.gRW.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gRY.setText(adCard.adSource);
            this.gRX.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.aqd != null && !TextUtils.isEmpty(advertAppInfo.aqd.adSource)) {
            this.gRY.setText(advertAppInfo.aqd.adSource);
            this.gRX.setVisibility(0);
        } else {
            this.gRX.setVisibility(8);
        }
        this.gQV.setVisibility(0);
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
