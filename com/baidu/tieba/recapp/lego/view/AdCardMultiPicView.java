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
    protected RelativeLayout gqG;
    protected TbImageView gqH;
    protected TextView gqI;
    protected RelativeLayout gqJ;
    protected TbImageView gqK;
    protected TextView gqL;
    protected RelativeLayout gqM;
    protected TbImageView gqN;
    protected TextView gqO;
    protected View gqP;
    protected TextView gqQ;

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
    protected void by(View view) {
        this.gqG = (RelativeLayout) view.findViewById(d.g.rl_img_left);
        this.gqH = (TbImageView) view.findViewById(d.g.advert_app_img_left);
        this.gqI = (TextView) view.findViewById(d.g.txt_left);
        this.gqJ = (RelativeLayout) view.findViewById(d.g.rl_img_center);
        this.gqK = (TbImageView) view.findViewById(d.g.advert_app_img_center);
        this.gqL = (TextView) view.findViewById(d.g.txt_center);
        this.gqM = (RelativeLayout) view.findViewById(d.g.rl_img_right);
        this.gqN = (TbImageView) view.findViewById(d.g.advert_app_img_right);
        this.gqO = (TextView) view.findViewById(d.g.txt_right);
        this.gqQ = (TextView) view.findViewById(d.g.advert_source_right);
        this.gqH.setDrawBorder(true);
        this.gqH.setBorderWidth(1);
        this.gqK.setDrawBorder(true);
        this.gqK.setBorderWidth(1);
        this.gqN.setDrawBorder(true);
        this.gqN.setBorderWidth(1);
        this.gqP = view.findViewById(d.g.channel_ad_right);
    }

    @Override // com.baidu.tieba.recapp.lego.view.AdCardBaseView
    protected void a(AdCard adCard) {
        AdCard.d[] dVarArr = adCard.threadPicList;
        int length = dVarArr != null ? dVarArr.length : 0;
        int dimensionPixelSize = (int) ((this.mMaxWidth - (TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds20) * 2)) / 3.0f);
        if (length <= 0) {
            this.gpN.setVisibility(8);
            return;
        }
        this.gqI.setVisibility(8);
        this.gqH.setVisibility(8);
        this.gqL.setVisibility(8);
        this.gqK.setVisibility(8);
        this.gqO.setVisibility(8);
        this.gqN.setVisibility(8);
        a(this.gqH, dimensionPixelSize, dimensionPixelSize);
        a(this.gqK, dimensionPixelSize, dimensionPixelSize);
        a(this.gqN, dimensionPixelSize, dimensionPixelSize);
        if (length == 1) {
            this.gqH.startLoad(dVarArr[0].pic, 30, false);
            this.gqH.setVisibility(0);
            a(this.gqH, dVarArr[0].gpx);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gqI.setVisibility(8);
            } else {
                this.gqI.setVisibility(0);
                this.gqI.setText(dVarArr[0].desc);
            }
        } else if (length == 2) {
            this.gqH.startLoad(dVarArr[0].pic, 30, false);
            this.gqH.setVisibility(0);
            this.gqK.setVisibility(0);
            a(this.gqH, dVarArr[0].gpx);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gqI.setVisibility(8);
            } else {
                this.gqI.setVisibility(0);
                this.gqI.setText(dVarArr[0].desc);
            }
            this.gqK.startLoad(dVarArr[1].pic, 30, false);
            a(this.gqK, dVarArr[1].gpx);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gqL.setVisibility(8);
            } else {
                this.gqL.setVisibility(0);
                this.gqL.setText(dVarArr[1].desc);
            }
        } else if (length >= 3) {
            this.gqH.startLoad(dVarArr[0].pic, 30, false);
            this.gqH.setVisibility(0);
            this.gqK.setVisibility(0);
            this.gqN.setVisibility(0);
            a(this.gqH, dVarArr[0].gpx);
            if (StringUtils.isNull(dVarArr[0].desc, true)) {
                this.gqI.setVisibility(8);
            } else {
                this.gqI.setVisibility(0);
                this.gqI.setText(dVarArr[0].desc);
            }
            this.gqK.startLoad(dVarArr[1].pic, 30, false);
            a(this.gqK, dVarArr[1].gpx);
            if (StringUtils.isNull(dVarArr[1].desc, true)) {
                this.gqL.setVisibility(8);
            } else {
                this.gqL.setVisibility(0);
                this.gqL.setText(dVarArr[1].desc);
            }
            this.gqN.startLoad(dVarArr[2].pic, 30, false);
            a(this.gqN, dVarArr[2].gpx);
            if (StringUtils.isNull(dVarArr[2].desc, true)) {
                this.gqO.setVisibility(8);
            } else {
                this.gqO.setVisibility(0);
                this.gqO.setText(dVarArr[2].desc);
            }
        }
        AdvertAppInfo advertAppInfo = adCard.getAdvertAppInfo();
        if (!StringUtils.isNull(adCard.adSource, true)) {
            this.gqQ.setText(adCard.adSource);
            this.gqP.setVisibility(0);
        } else if (advertAppInfo != null && advertAppInfo.adQ != null && !TextUtils.isEmpty(advertAppInfo.adQ.adSource)) {
            this.gqQ.setText(advertAppInfo.adQ.adSource);
            this.gqP.setVisibility(0);
        } else {
            this.gqP.setVisibility(8);
        }
        this.gpN.setVisibility(0);
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
